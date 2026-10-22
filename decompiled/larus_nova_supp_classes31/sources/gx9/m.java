package gx9;

import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ String n;
    public final /* synthetic */ String o;
    public final /* synthetic */ String p;
    public final /* synthetic */ String q;
    public final /* synthetic */ String r;
    public final /* synthetic */ String s;
    public final /* synthetic */ Boolean t;

    public /* synthetic */ m(int r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, Boolean r22) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
    }

    public final Object invoke(Object r34) {
        int r1 = this.a;
        String r2 = this.b;
        String r3 = this.c;
        String r4 = this.d;
        String r15 = this.e;
        String r13 = this.f;
        String r14 = this.g;
        String r11 = this.h;
        String r10 = this.i;
        String r9 = this.j;
        String r8 = this.k;
        String r7 = this.l;
        String r6 = this.m;
        String r5 = this.n;
        String r12 = this.o;
        String r16 = this.p;
        String r17 = this.q;
        String r18 = this.r;
        String r19 = this.s;
        Boolean r110 = this.t;
        com.larus.bmhome.chat.trace.a r0 = (com.larus.bmhome.chat.trace.a) r34;
        Intrinsics.checkNotNullParameter(r0, "$this$withChatBaseData");
        int r20 = o.a;
        String r21 = IAIChatControlTraceService.a.g(r0.d, r0.e, r0.b);
        if (Intrinsics.areEqual(r0.k, "landing") == false) goto L5;
        String r25 = "landing";
    L6:
        String r22 = r0.a;
        if (r22 == null) goto L9;
        Long r23 = StringsKt.toLongOrNull(r22);
    L10:
        String r24 = r0.g;
        if (r24 == null) goto L13;
        Long r26 = StringsKt.toLongOrNull(r24);
    L14:
        long r27 = r1;
        String r28 = r0.j;
        String r29 = r0.k;
        if (StringsKt.contains(r2, "local-", true) == false) goto L17;
        String r111 = null;
    L18:
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        if (r4 == null) goto L22;
    L25:
        o3.g(r23, r21, r26, r28, r25, r111, r29, Long.valueOf(r27), r13, r14, r11, r10, r9, r8, r7, r4, r15, r3, r6, r5, r12, r16, r17, r18, r19, r110);
        return Unit.INSTANCE;
    L22:
        if (o0.d(r15) == false) goto L24;
        r4 = "action_bar_instruction";
        goto L25
    L24:
        r4 = null;
        goto L25
    L17:
        r111 = StringsKt.removeSuffix(StringsKt.removeSuffix(r2, ":fake_message:1"), "-fix-suggest");
        goto L18
    L13:
        r26 = null;
        goto L14
    L9:
        r23 = null;
        goto L10
    L5:
        r25 = "click_chat";
        goto L6
    }
}
