package com.ss.android.lark.keyboard.edittext2.list;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import eab.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InsertListStateMachine {
    public final com.ss.android.lark.keyboard.edittext2.list.b a;
    public final EditorListApplier b;
    public State c;
    public final SpannableStringBuilder d;
    public char e;
    public int f;
    public int g;
    public int h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/list/InsertListStateMachine$State;", "", "<init>", "(Ljava/lang/String;I)V", "None", "LineStart", "OLNumber", "ULSymbol", "OLDot", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum State extends Enum<State> {
        public static final State LineStart = null;
        public static final State None = null;
        public static final State OLDot = null;
        public static final State OLNumber = null;
        public static final State ULSymbol = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("None", 0);
            None = r0;
            State r1 = new State("LineStart", 1);
            LineStart = r1;
            State r3 = new State("OLNumber", 2);
            OLNumber = r3;
            State r5 = new State("ULSymbol", 3);
            ULSymbol = r5;
            State r7 = new State("OLDot", 4);
            OLDot = r7;
            State[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[State.values().length];
            r0[State.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[State.LineStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[State.OLNumber.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[State.ULSymbol.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[State.OLDot.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public final void e() {
        State r0 = this.c;
        State r1 = State.None;
        if (r0 != r1) goto L5;
        return;
    L5:
        Log.d("InsertListStateMachine", "toStateNone");
        this.c = r1;
        this.d.clear();
        this.f = -1;
        this.e = 0;
    }

    public final void d(int r3) {
        this.c = State.LineStart;
        this.d.clear();
        this.f = r3;
        this.e = 0;
        Log.d("InsertListStateMachine", "toStateLineStart, start is " + r3);
    }

    public InsertListStateMachine(com.ss.android.lark.keyboard.edittext2.list.b r2, EditorListApplier r3) {
        Intrinsics.checkNotNullParameter(r2, "coordinator");
        Intrinsics.checkNotNullParameter(r3, "actionHandle");
        this.a = r2;
        this.b = r3;
        this.c = State.None;
        this.d = new SpannableStringBuilder();
        this.f = -1;
        this.g = -1;
        this.h = -1;
    }

    public final void a(Editable r8, int r9, int r10) {
        com.ss.android.lark.coremd.impl.buildnode.a[] r0 = (com.ss.android.lark.coremd.impl.buildnode.a[]) r8.getSpans(0, r8.length(), com.ss.android.lark.coremd.impl.buildnode.a.class);
        Intrinsics.checkNotNull(r0);
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L9;
        if ((r0[r3].a instanceof e) == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        e();
        return;
    L13:
        int r4 = b.a[this.c.ordinal()];
        float r5 = 16.0f;
        if (r4 != 4) goto L16;
        com.ss.android.lark.keyboard.edittext2.list.b r6 = this.a;
        y9b.b r7 = (y9b.c) r6.c.acquire();
        if (r7 != null) goto L37;
        r7 = new y9b.c();
    L37:
        y9b.b r11 = r7;
        r11.h(0);
        r11.f(0);
        Float r12 = r6.e.a;
        if (r12 == null) goto L40;
        r5 = r12.floatValue();
    L40:
        ((CommonPrefixSpan) r11).a.j = UIUtils.dp2px(r6.a, r5);
        Integer r13 = r6.e.b;
        if (r13 == null) goto L43;
        int r14 = r13.intValue();
    L44:
        ((CommonPrefixSpan) r11).a.g = r14;
        r6.d(r11);
        boolean r15 = false;
    L45:
        int r16 = r10 - r9;
        Character r17 = StringsKt.getOrNull(r8, r10 - 1);
        if (r17 == null) goto L52;
        if (r17.charValue() != '\n') goto L52;
        r16 = r16 - 1;
    L52:
        if (r16 <= this.d.length()) goto L54;
        String r18 = "";
    L55:
        int r19 = r10 - (this.d.length() - r18.length());
        int r20 = this.f;
        r8.replace(r20, this.d.length() + r20, r18);
        r8.setSpan(r11, r9, r19, 33);
        if (r15 == false) goto L76;
        Object[] r21 = r8.getSpans(r19, r19, y9b.b.class);
        int r22 = r21.length;
        int r23 = 0;
    L58:
        if (r23 >= r22) goto L66;
        Object r24 = r21[r23];
        if (r8.getSpanStart((y9b.b) r24) != r19) goto L62;
        boolean r25 = true;
    L63:
        if (r25 == true) goto L67;
        r23 = r23 + 1;
    L67:
        y9b.b r26 = (y9b.b) r24;
        if (r26 == null) goto L70;
        r26.g(ListHeadType.None);
    L70:
        this.b.h(r8);
        return;
    L62:
        r25 = false;
        goto L63
    L66:
        r24 = null;
        goto L67
    L76:
        return;
    L54:
        r18 = "\u200b";
        goto L55
    L43:
        r14 = r6.b.b;
        goto L44
    L16:
        if (r4 == 5) goto L19;
        e();
        return;
    L19:
        SpannableStringBuilder r27 = this.d;
        String r28 = r27.subSequence(0, r27.length() - 2).toString();
        com.ss.android.lark.keyboard.edittext2.list.b r29 = this.a;
        Integer r30 = StringsKt.toIntOrNull(r28);
        if (r30 == null) goto L22;
        int r31 = r30.intValue();
    L23:
        r11 = (y9b.b) r29.d.acquire();
        if (r11 != null) goto L26;
        r11 = new y9b.b();
    L26:
        r11.h(r31);
        r11.f(0);
        Float r32 = r29.e.a;
        if (r32 == null) goto L29;
        r5 = r32.floatValue();
    L29:
        ((CommonPrefixSpan) r11).a.j = UIUtils.dp2px(r29.a, r5);
        Integer r33 = r29.e.b;
        if (r33 == null) goto L32;
        int r34 = r33.intValue();
    L33:
        ((CommonPrefixSpan) r11).a.g = r34;
        r29.d(r11);
        r11.g(ListHeadType.VirtualHead);
        r15 = true;
        goto L45
    L32:
        r34 = r29.b.b;
        goto L33
    L22:
        r31 = 1;
        goto L23
    L9:
        r2 = false;
        goto L10
    }

    public final void c(Editable r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "s");
        if (this.g == r6) goto L5;
    L7:
        this.g = r6;
        this.h = r7;
        Log.d("InsertListStateMachine", "selectionChange: start is " + r6 + ", end is " + r7);
        if (r6 == r7) goto L10;
    L37:
        e();
        return;
    L10:
        if (r6 == (-1)) goto L37;
        int r8 = 12;
        int r0 = r6;
    L14:
        if (r0 <= 0) goto L19;
        int r2 = r0 - 1;
        if (r5.charAt(r2) == '\n') goto L19;
        if (r8 < 0) goto L19;
        r8 = r8 - 1;
        r0 = r2;
    L19:
        boolean r9 = false;
        if (r0 != 0) goto L22;
    L25:
        boolean r1 = true;
    L26:
        if (r1 == true) goto L28;
    L35:
        e();
        return;
    L28:
        if (r5.getSpans(r0, r6, y9b.b.class).length != 0) goto L31;
        r9 = true;
    L31:
        if ((!r9) == true) goto L35;
        b(r5, r0, r6, true);
        return;
    L22:
        if (r5.charAt(r0 - 1) == '\n') goto L25;
        r1 = false;
        goto L26
    L5:
        if (this.h != r7) goto L7;
    }

    public final void b(Editable r8, int r9, int r10, boolean r11) {
        if (r10 != r9) goto L5;
        d(r9);
        return;
    L5:
        State r0 = this.c;
        int r1 = b.a[r0.ordinal()];
        boolean r2 = true;
        if (r1 != 1) goto L8;
        d(r9);
        int r12 = r9;
    L95:
        if (r12 >= r10) goto L127;
        if (this.c == State.None) goto L125;
        if (r12 >= r8.length()) goto L126;
        char r3 = r8.charAt(r12);
        this.d.append(r3);
        this.e = r3;
        r12 = r12 + 1;
        b(r8, r9, r12, false);
        goto L95
    L126:
        return;
    L125:
        return;
    L127:
        return;
    L8:
        if (r1 == 2) goto L66;
        if (r1 != 3) goto L12;
        char r13 = this.e;
        if ('0' > r13) goto L49;
        if (r13 >= ':') goto L49;
    L50:
        if (r2 == false) goto L56;
        State r14 = this.c;
        State r15 = State.OLNumber;
        if (r14 == r15) goto L121;
        Log.d("InsertListStateMachine", "toStateOLNumber");
        this.c = r15;
        return;
    L121:
        return;
    L56:
        if (r13 != '.') goto L58;
    L61:
        State r16 = this.c;
        State r17 = State.OLDot;
        if (r16 == r17) goto L122;
        Log.d("InsertListStateMachine", "toStateOLDot");
        this.c = r17;
        return;
    L122:
        return;
    L58:
        if (r13 == 12290) goto L61;
        e();
        return;
    L49:
        r2 = false;
        goto L50
    L12:
        if (r1 == 4) goto L32;
        if (r1 != 5) goto L30;
        if (this.e != ' ') goto L28;
        if (r11 == true) goto L19;
        e();
        return;
    L19:
        if (r10 >= r8.length()) goto L24;
        if (r8.charAt(r10) == '\n') goto L24;
        r10 = r10 + 1;
    L24:
        if (r10 >= r8.length()) goto L26;
        r10 = r10 + 1;
    L26:
        a(r8, r9, r10);
        return;
    L28:
        e();
        return;
    L30:
        throw new NoWhenBranchMatchedException();
    L32:
        if (this.e != ' ') goto L44;
        if (r11 == true) goto L35;
        e();
        return;
    L35:
        if (r10 >= r8.length()) goto L40;
        if (r8.charAt(r10) == '\n') goto L40;
        r10 = r10 + 1;
    L40:
        if (r10 >= r8.length()) goto L42;
        r10 = r10 + 1;
    L42:
        a(r8, r9, r10);
        return;
    L44:
        e();
        return;
    L66:
        if ((r10 - this.f) == 1) goto L68;
    L93:
        e();
        return;
    L68:
        if (this.d.length() != 1) goto L93;
        char r18 = this.e;
        if (r18 != '*') goto L72;
    L89:
        State r19 = this.c;
        State r20 = State.ULSymbol;
        if (r19 == r20) goto L124;
        Log.d("InsertListStateMachine", "toStateULSymbol");
        this.c = r20;
        return;
    L124:
        return;
    L72:
        if (r18 == '-') goto L89;
        if (r18 == 65290) goto L89;
        if (r18 == 65293) goto L89;
        if ('1' > r18) goto L82;
        if (r18 >= ':') goto L82;
    L83:
        if (r2 == false) goto L88;
        State r21 = this.c;
        State r22 = State.OLNumber;
        if (r21 == r22) goto L123;
        Log.d("InsertListStateMachine", "toStateOLNumber");
        this.c = r22;
        return;
    L123:
        return;
    L88:
        e();
        return;
    L82:
        r2 = false;
        goto L83
    }
}
