package kn8;

import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.Stage;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.reference.r;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import java.util.List;
import jn8.j;
import jn8.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final b a;
    public Boolean b;
    public boolean c;
    public kn8.b d;
    public kn8.a e;
    public Function0<Unit> f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolType.values().length];
            r0[ToolType.SearchPlugin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class b implements k {
        public final /* synthetic */ c a;

        @Override // jn8.k
        public final void b() {
            c r0 = this.a;
            kn8.a r1 = r0.e;
            if (r1 == null) goto L9;
            Function0<Boolean> r2 = r1.e;
            if (r2 == null) goto L9;
            if (((Boolean) r2.invoke()).booleanValue() != true) goto L9;
            boolean r3 = true;
        L10:
            if (r3 == true) goto L30;
            Boolean r4 = r0.b;
            Boolean r5 = Boolean.TRUE;
            r0.b = Boolean.valueOf(!Intrinsics.areEqual(r4, r5));
            Function0<Unit> r6 = r0.f;
            if (r6 == null) goto L15;
            r6.invoke();
        L15:
            kn8.b r7 = r0.d;
            if (r7 != null) goto L18;
            return;
        L18:
            if (a.a[r0.b().ordinal()] != 1) goto L20;
            String r8 = "simple_search";
        L21:
            kn8.a r9 = r0.e;
            if (r9 == null) goto L26;
            SearchReferenceData r10 = r9.f;
            if (r10 == null) goto L26;
            Integer r11 = r10.getIdx();
        L27:
            ri8.c r12 = ri8.c.a;
            r7.d(r8, r11, ri8.c.g(Boolean.valueOf(true ^ Intrinsics.areEqual(r0.b, r5))), r0.b().getValue());
            return;
        L26:
            r11 = null;
            goto L27
        L20:
            r8 = "tool_card";
            goto L21
        L30:
            return;
        L9:
            r3 = false;
            goto L10
        }

        public final void e() {
            c r0 = this.a;
            kn8.a r1 = r0.e;
            if (r1 == null) goto L12;
            SearchReferenceData r2 = r1.f;
            if (r2 == null) goto L12;
            if (r.b(r2) == false) goto L12;
            if (r0.c == true) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L29;
            kn8.b r4 = r0.d;
            if (r4 != null) goto L17;
        L27:
            r0.c = true;
            return;
        L17:
            if (a.a[r0.b().ordinal()] != 1) goto L19;
            String r5 = "simple_search";
        L20:
            kn8.a r6 = r0.e;
            if (r6 == null) goto L25;
            SearchReferenceData r7 = r6.f;
            if (r7 == null) goto L25;
            Integer r8 = r7.getIdx();
        L26:
            ri8.c r9 = ri8.c.a;
            r4.e(r5, r8, ri8.c.g(Boolean.valueOf(!Intrinsics.areEqual(r0.b, Boolean.TRUE))), r0.b().getValue());
        L25:
            r8 = null;
            goto L26
        L19:
            r5 = "tool_card";
            goto L20
        L29:
            return;
        L12:
            r3 = false;
            goto L13
        }

        public b(c r1) {
            this.a = r1;
        }

        @Override // jn8.k
        public final void a(boolean r19) {
            c r1 = this.a;
            r1.getClass();
            if (r19 == false) goto L5;
            Stage r2 = Stage.Searching;
        L6:
            int r3 = r2.getValue();
            kn8.a r4 = r1.e;
            kn8.a r5 = null;
            if (r4 == null) goto L11;
            SearchReferenceData r6 = r4.f;
            if (r6 == null) goto L11;
            SearchReferenceData r11 = SearchReferenceData.copy$default(r6, null, null, null, null, Integer.valueOf(r3), null, null, null, null, false, 1007, null);
        L12:
            kn8.a r7 = r1.e;
            if (r7 == null) goto L15;
            r5 = new kn8.a(r7.a, r7.b, r7.c, r7.d, r7.e, r11, r7.g, r7.h, r7.i, r7.j);
        L15:
            r1.e = r5;
            return;
        L11:
            r11 = null;
            goto L12
        L5:
            r2 = Stage.Searched;
            goto L6
        }

        @Override // jn8.k
        public final void c(int r4, Reference r5) {
            c r0 = this.a;
            kn8.b r1 = r0.d;
            if (r1 == null) goto L11;
            kn8.a r2 = r0.e;
            if (r2 == null) goto L9;
            SearchReferenceData r3 = r2.f;
            if (r3 == null) goto L9;
            Integer r6 = r3.getIdx();
        L10:
            r1.b(r4, r5, r6);
        L9:
            r6 = null;
        L11:
            kn8.b r7 = r0.d;
            if (r7 == null) goto L15;
            r7.c();
            return;
        }

        @Override // jn8.k
        public final void d(Integer r2, Integer r3, String r4, Reference r5) {
            kn8.b r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4, r5);
            return;
        }
    }

    public final j a() {
        kn8.a r1 = this.e;
        Boolean r2 = null;
        if (r1 == null) goto L5;
        SearchReferenceData r3 = r1.f;
    L6:
        ToolType r4 = b();
        Boolean r5 = this.b;
        boolean r6 = false;
        boolean r7 = true;
        if (r5 != null) goto L39;
        if (r3 != null) goto L11;
    L9:
        r5 = null;
        goto L39
    L11:
        if (r.d(r4) == true) goto L14;
        Boolean r8 = Boolean.TRUE;
    L13:
        r5 = r8;
        goto L39
    L14:
        List r9 = r3.getQueries();
        if (r9 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        if (r10 == false) goto L33;
        List r11 = r3.getReference();
        if (r11 != null) goto L25;
    L28:
        boolean r12 = true;
    L29:
        if (r12 == false) goto L33;
        if (r.d(b()) == false) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L36;
        r8 = Boolean.TRUE;
        goto L13
    L36:
        kn8.a r14 = this.e;
        if (r14 == null) goto L9;
        r8 = r14.i;
        goto L13
    L25:
        if (r11.isEmpty() == true) goto L28;
        r12 = false;
    L33:
        r13 = false;
        goto L34
    L17:
        if (r9.isEmpty() == true) goto L20;
        r10 = false;
    L39:
        this.b = r5;
        if (r3 == null) goto L66;
        kn8.a r15 = this.e;
        if (r15 == null) goto L47;
        Message r16 = r15.b;
        if (r16 == null) goto L47;
        Integer r17 = Integer.valueOf(r16.getMessageStatusLocal());
    L48:
        if (r17 != null) goto L51;
    L52:
        if (r17 != null) goto L55;
    L57:
        boolean r18 = false;
    L60:
        if (r.c(r3) == false) goto L63;
        if (r18 == false) goto L63;
    L64:
        r6 = true;
    L65:
        r7 = r6;
    L63:
        if (r.a(r3) == false) goto L65;
    L55:
        if (r17.intValue() != 22) goto L57;
    L58:
        r18 = true;
        goto L60
    L51:
        if (r17.intValue() == 23) goto L58;
    L47:
        r17 = null;
    L66:
        kn8.a r19 = this.e;
        if (r19 == null) goto L71;
        Message r20 = r19.b;
        if (r20 == null) goto L71;
        String r21 = r20.getMessageId();
    L72:
        kn8.a r22 = this.e;
        if (r22 == null) goto L75;
        Integer r23 = r22.d;
    L76:
        if (r3 == null) goto L78;
        String r110 = r3.getTitle();
    L79:
        if (r3 == null) goto L81;
        List r111 = r3.getReference();
    L82:
        if (r3 == null) goto L84;
        List r112 = r3.getQueries();
    L85:
        if (r3 == null) goto L87;
        String r113 = r3.getSearchLoadingText();
    L88:
        if (r3 == null) goto L90;
        Integer r114 = r3.getStage();
    L91:
        if (r3 == null) goto L93;
        Integer r115 = r3.getIdx();
    L94:
        if (r3 == null) goto L96;
        String r116 = r3.getIcon();
    L97:
        if (r3 == null) goto L99;
        String r117 = r3.getIconDark();
    L100:
        if (r3 == null) goto L102;
        String r118 = r3.getToolType();
    L103:
        Boolean r24 = this.b;
        Boolean r25 = Boolean.valueOf(r7);
        kn8.a r26 = this.e;
        if (r26 == null) goto L106;
        String r27 = r26.c;
    L107:
        if (r26 == null) goto L111;
        Message r28 = r26.b;
        if (r28 == null) goto L111;
        String r29 = r28.getConversationId();
    L112:
        kn8.a r30 = this.e;
        if (r30 == null) goto L117;
        Message r31 = r30.b;
        if (r31 == null) goto L117;
        String r210 = r31.getSenderId();
    L118:
        kn8.a r32 = this.e;
        if (r32 == null) goto L121;
        Integer r211 = r32.g;
    L122:
        if (r32 == null) goto L124;
        Boolean r212 = r32.h;
    L125:
        if (r32 == null) goto L127;
        Boolean r213 = r32.h;
    L128:
        if (r32 == null) goto L131;
        r2 = r32.j;
    L131:
        return new j(r21, r23, r110, r111, r112, r113, r114, r115, r116, r117, r118, r24, r25, r27, r29, r210, r211, r212, r213, r2);
    L127:
        r213 = null;
        goto L128
    L124:
        r212 = null;
        goto L125
    L121:
        r211 = null;
    L117:
        r210 = null;
    L111:
        r29 = null;
        goto L112
    L106:
        r27 = null;
        goto L107
    L102:
        r118 = null;
        goto L103
    L99:
        r117 = null;
        goto L100
    L96:
        r116 = null;
        goto L97
    L93:
        r115 = null;
        goto L94
    L90:
        r114 = null;
        goto L91
    L87:
        r113 = null;
        goto L88
    L84:
        r112 = null;
        goto L85
    L81:
        r111 = null;
        goto L82
    L78:
        r110 = null;
        goto L79
    L75:
        r23 = null;
    L71:
        r21 = null;
        goto L72
    L5:
        r3 = null;
        goto L6
    }

    public final ToolType b() {
        ToolType.a r0 = ToolType.Companion;
        kn8.a r1 = this.e;
        if (r1 == null) goto L7;
        SearchReferenceData r2 = r1.f;
        if (r2 == null) goto L7;
        String r3 = r2.getToolType();
    L8:
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r0.getClass();
        return ToolType.a.a(r3);
    L7:
        r3 = null;
        goto L8
    }

    public c() {
        this.a = new b(this);
    }
}
