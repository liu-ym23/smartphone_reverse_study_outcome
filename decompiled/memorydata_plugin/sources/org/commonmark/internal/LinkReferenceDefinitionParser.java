package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes7.dex */
public class LinkReferenceDefinitionParser {
    private final List<LinkReferenceDefinition> definitions;
    private String destination;
    private StringBuilder label;
    private final Parser.LinkReferenceChecker linkReferenceChecker;
    private String normalizedLabel;
    private final StringBuilder paragraph;
    private boolean referenceValid;
    private State state;
    private StringBuilder title;
    private char titleDelimiter;

    /* JADX INFO: renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State = r0;
            r0[State.PARAGRAPH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.START_DEFINITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.LABEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.DESTINATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.START_TITLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.TITLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DESTINATION = null;
        public static final State LABEL = null;
        public static final State PARAGRAPH = null;
        public static final State START_DEFINITION = null;
        public static final State START_TITLE = null;
        public static final State TITLE = null;

        static {
            State r0 = new State("START_DEFINITION", 0);
            START_DEFINITION = r0;
            State r1 = new State("LABEL", 1);
            LABEL = r1;
            State r3 = new State("DESTINATION", 2);
            DESTINATION = r3;
            State r5 = new State("START_TITLE", 3);
            START_TITLE = r5;
            State r7 = new State("TITLE", 4);
            TITLE = r7;
            State r9 = new State("PARAGRAPH", 5);
            PARAGRAPH = r9;
            $VALUES = new State[]{r0, r1, r3, r5, r7, r9};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    public LinkReferenceDefinitionParser() {
        this(null);
    }

    public LinkReferenceDefinitionParser(Parser.LinkReferenceChecker r3) {
        Parser.LinkReferenceChecker r4 = (Parser.LinkReferenceChecker) ZeusTransformUtils.wrapperContextForParams(r3, Parser.LinkReferenceChecker.class, "com.obric.memorydata.plugin");
        this.state = State.START_DEFINITION;
        this.paragraph = new StringBuilder();
        this.definitions = new ArrayList();
        this.referenceValid = false;
        this.linkReferenceChecker = r4;
    }

    private int destination(CharSequence r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r9 = Parsing.skipSpaceTab(r8, r7, r8.length());
        int r0 = LinkScanner.scanLinkDestination(r8, r9);
        if (r0 != (-1)) goto L6;
        return -1;
    L6:
        if (r8.charAt(r9) != '<') goto L8;
        CharSequence r10 = r8.subSequence(r9 + 1, r0 - 1);
    L9:
        this.destination = r10.toString();
        int r11 = Parsing.skipSpaceTab(r8, r0, r8.length());
        if (r11 < r8.length()) goto L12;
        this.referenceValid = true;
        this.paragraph.setLength(0);
    L14:
        this.state = State.START_TITLE;
        return r11;
    L12:
        if (r11 != r0) goto L14;
        return -1;
    L8:
        r10 = r8.subSequence(r9, r0);
        goto L9
    }

    private void finishReference() {
        if (this.referenceValid == true) goto L5;
        return;
    L5:
        String r0 = Escaping.unescapeString(this.destination);
        StringBuilder r1 = this.title;
        if (r1 == null) goto L8;
        String r2 = Escaping.unescapeString(r1.toString());
    L9:
        this.definitions.add(new LinkReferenceDefinition(this.normalizedLabel, r0, r2));
        this.label = null;
        this.referenceValid = false;
        this.normalizedLabel = null;
        this.destination = null;
        this.title = null;
        return;
    L8:
        r2 = null;
        goto L9
    }

    private int label(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = LinkScanner.scanLinkLabelContent(r6, r5);
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        this.label.append(r6, r5, r0);
        Parser.LinkReferenceChecker r7 = this.linkReferenceChecker;
        if (r7 == null) goto L11;
        if (r7.enable(this.label) == true) goto L11;
        return -1;
    L11:
        if (r0 < r6.length()) goto L15;
        this.label.append('\n');
        return r0;
    L15:
        if (r6.charAt(r0) != ']') goto L29;
        int r1 = r0 + 1;
        if (r1 >= r6.length()) goto L29;
        if (r6.charAt(r1) != ':') goto L29;
        if (this.label.length() <= 999) goto L24;
        return -1;
    L24:
        String r8 = Escaping.normalizeLabelContent(this.label.toString());
        if (r8.isEmpty() == false) goto L27;
        return -1;
    L27:
        this.normalizedLabel = r8;
        this.state = State.DESTINATION;
        return Parsing.skipSpaceTab(r6, r1 + 1, r6.length());
    L29:
        return -1;
    }

    private int startDefinition(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r6 = Parsing.skipSpaceTab(r5, r4, r5.length());
        if (r6 < r5.length()) goto L5;
        return -1;
    L5:
        if (r5.charAt(r6) != '[') goto L13;
        this.state = State.LABEL;
        this.label = new StringBuilder();
        int r7 = r6 + 1;
        if (r7 < r5.length()) goto L10;
        this.label.append('\n');
    L10:
        return r7;
    L13:
        return -1;
    }

    private int startTitle(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r6 = Parsing.skipSpaceTab(r5, r4, r5.length());
        if (r6 < r5.length()) goto L6;
        this.state = State.START_DEFINITION;
        return r6;
    L6:
        this.titleDelimiter = 0;
        char r0 = r5.charAt(r6);
        if (r0 != '\"') goto L9;
    L14:
        this.titleDelimiter = r0;
    L16:
        if (this.titleDelimiter == 0) goto L20;
        this.state = State.TITLE;
        this.title = new StringBuilder();
        r6 = r6 + 1;
        if (r6 != r5.length()) goto L21;
        this.title.append('\n');
    L21:
        return r6;
    L20:
        finishReference();
        this.state = State.START_DEFINITION;
        goto L21
    L9:
        if (r0 == '\'') goto L14;
        if (r0 != '(') goto L16;
        r0 = ')';
        goto L14
    }

    private int title(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = LinkScanner.scanLinkTitleContent(r6, r5, this.titleDelimiter);
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        this.title.append(r6.subSequence(r5, r0));
        if (r0 < r6.length()) goto L9;
        this.title.append('\n');
        return r0;
    L9:
        int r1 = Parsing.skipSpaceTab(r6, r0 + 1, r6.length());
        if (r1 == r6.length()) goto L12;
        return -1;
    L12:
        this.referenceValid = true;
        finishReference();
        this.paragraph.setLength(0);
        this.state = State.START_DEFINITION;
        return r1;
    }

    List<LinkReferenceDefinition> getDefinitions() {
        finishReference();
        return this.definitions;
    }

    CharSequence getParagraphContent() {
        return this.paragraph;
    }

    public void parse(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.paragraph.length() == 0) goto L5;
        this.paragraph.append('\n');
    L5:
        this.paragraph.append(r5);
        int r0 = 0;
    L7:
        if (r0 >= r5.length()) goto L25;
        switch(AnonymousClass1.$SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[this.state.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L18;
        };
    L11:
        r0 = title(r5, r0);
        goto L18
    L12:
        r0 = startTitle(r5, r0);
        goto L18
    L13:
        r0 = destination(r5, r0);
        goto L18
    L14:
        r0 = label(r5, r0);
        goto L18
    L15:
        r0 = startDefinition(r5, r0);
    L18:
        if (r0 != (-1)) goto L7;
        this.state = State.PARAGRAPH;
        return;
    L16:
        return;
    }
}
