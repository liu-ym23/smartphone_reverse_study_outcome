package com.larus.doc.sdk.impl.generalbiz.state.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/EditMenuItemId;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "h1", "h2", "h3", "plainText", "bold", "italic", "underline", "strikethrough", "blockQuote", "unorderedList", "orderedList", "checkbox", "indentLeft", "indentRight", "alignLeft", "alignCenter", "alignRight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditMenuItemId extends Enum<EditMenuItemId> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ EditMenuItemId[] $VALUES = null;
    public static final Companion Companion = null;
    public static final EditMenuItemId alignCenter = null;
    public static final EditMenuItemId alignLeft = null;
    public static final EditMenuItemId alignRight = null;
    public static final EditMenuItemId blockQuote = null;
    public static final EditMenuItemId bold = null;
    public static final EditMenuItemId checkbox = null;
    public static final EditMenuItemId h1 = null;
    public static final EditMenuItemId h2 = null;
    public static final EditMenuItemId h3 = null;
    public static final EditMenuItemId indentLeft = null;
    public static final EditMenuItemId indentRight = null;
    public static final EditMenuItemId italic = null;
    public static final EditMenuItemId orderedList = null;
    public static final EditMenuItemId plainText = null;
    public static final EditMenuItemId strikethrough = null;
    public static final EditMenuItemId underline = null;
    public static final EditMenuItemId unorderedList = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/EditMenuItemId$Companion;", "", "<init>", "()V", "fromValue", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/EditMenuItemId;", "value", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final EditMenuItemId fromValue(String r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            switch(r2.hashCode()) {
                case -1178781136: goto L87;
                case -1055271401: goto L82;
                case -1026963764: goto L77;
                case -972521773: goto L72;
                case -819190158: goto L67;
                case 3273: goto L62;
                case 3274: goto L57;
                case 3275: goto L52;
                case 3029637: goto L47;
                case 479055571: goto L42;
                case 1213413306: goto L37;
                case 1273649647: goto L32;
                case 1536891843: goto L27;
                case 1766891692: goto L22;
                case 1971481808: goto L17;
                case 1972280855: goto L12;
                case 2129993387: goto L7;
                default: goto L93;
            };
        L93:
            return null;
        L7:
            if (r2.equals("orderedList") == true) goto L10;
            return null;
        L10:
            return EditMenuItemId.orderedList;
        L12:
            if (r2.equals("plainText") == true) goto L15;
            return null;
        L15:
            return EditMenuItemId.plainText;
        L17:
            if (r2.equals("indentRight") == true) goto L20;
            return null;
        L20:
            return EditMenuItemId.indentRight;
        L22:
            if (r2.equals("alignLeft") == true) goto L25;
            return null;
        L25:
            return EditMenuItemId.alignLeft;
        L27:
            if (r2.equals("checkbox") == true) goto L30;
            return null;
        L30:
            return EditMenuItemId.checkbox;
        L32:
            if (r2.equals("blockQuote") == true) goto L35;
            return null;
        L35:
            return EditMenuItemId.blockQuote;
        L37:
            if (r2.equals("alignCenter") == true) goto L40;
            return null;
        L40:
            return EditMenuItemId.alignCenter;
        L42:
            if (r2.equals("indentLeft") == true) goto L45;
            return null;
        L45:
            return EditMenuItemId.indentLeft;
        L47:
            if (r2.equals("bold") == true) goto L50;
            return null;
        L50:
            return EditMenuItemId.bold;
        L52:
            if (r2.equals("h3") == true) goto L55;
            return null;
        L55:
            return EditMenuItemId.h3;
        L57:
            if (r2.equals("h2") == true) goto L60;
            return null;
        L60:
            return EditMenuItemId.h2;
        L62:
            if (r2.equals("h1") == true) goto L65;
            return null;
        L65:
            return EditMenuItemId.h1;
        L67:
            if (r2.equals("unorderedList") == true) goto L70;
            return null;
        L70:
            return EditMenuItemId.unorderedList;
        L72:
            if (r2.equals("strikethrough") == true) goto L75;
            return null;
        L75:
            return EditMenuItemId.strikethrough;
        L77:
            if (r2.equals("underline") == true) goto L80;
            return null;
        L80:
            return EditMenuItemId.underline;
        L82:
            if (r2.equals("alignRight") == true) goto L85;
            return null;
        L85:
            return EditMenuItemId.alignRight;
        L87:
            if (r2.equals("italic") == true) goto L90;
            return null;
        L90:
            return EditMenuItemId.italic;
        }
    }

    private static final /* synthetic */ EditMenuItemId[] $values() {
        return new EditMenuItemId[]{h1, h2, h3, plainText, bold, italic, underline, strikethrough, blockQuote, unorderedList, orderedList, checkbox, indentLeft, indentRight, alignLeft, alignCenter, alignRight};
    }

    public static EnumEntries<EditMenuItemId> getEntries() {
        return $ENTRIES;
    }

    static {
        h1 = new EditMenuItemId("h1", 0, "h1");
        h2 = new EditMenuItemId("h2", 1, "h2");
        h3 = new EditMenuItemId("h3", 2, "h3");
        plainText = new EditMenuItemId("plainText", 3, "plainText");
        bold = new EditMenuItemId("bold", 4, "bold");
        italic = new EditMenuItemId("italic", 5, "italic");
        underline = new EditMenuItemId("underline", 6, "underline");
        strikethrough = new EditMenuItemId("strikethrough", 7, "strikethrough");
        blockQuote = new EditMenuItemId("blockQuote", 8, "blockQuote");
        unorderedList = new EditMenuItemId("unorderedList", 9, "unorderedList");
        orderedList = new EditMenuItemId("orderedList", 10, "orderedList");
        checkbox = new EditMenuItemId("checkbox", 11, "checkbox");
        indentLeft = new EditMenuItemId("indentLeft", 12, "indentLeft");
        indentRight = new EditMenuItemId("indentRight", 13, "indentRight");
        alignLeft = new EditMenuItemId("alignLeft", 14, "alignLeft");
        alignCenter = new EditMenuItemId("alignCenter", 15, "alignCenter");
        alignRight = new EditMenuItemId("alignRight", 16, "alignRight");
        EditMenuItemId[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public static EditMenuItemId[] values() {
        return (EditMenuItemId[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static EditMenuItemId valueOf(String r1) {
        return (EditMenuItemId) a.a(EditMenuItemId.class, r1);
    }

    private EditMenuItemId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
