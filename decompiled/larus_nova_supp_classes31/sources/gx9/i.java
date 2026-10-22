package gx9;

import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
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
    public final /* synthetic */ String t;
    public final /* synthetic */ Boolean u;

    public /* synthetic */ i(String r3, String r4, String r5, int r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, Boolean r23) {
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
        this.u = r23;
    }

    public final Object invoke(Object r33) {
        String r9 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        int r3 = this.d;
        String r4 = this.e;
        String r5 = this.f;
        String r15 = this.g;
        String r10 = this.h;
        String r11 = this.i;
        String r12 = this.j;
        String r13 = this.k;
        String r14 = this.l;
        String r8 = this.m;
        String r7 = this.n;
        String r6 = this.o;
        String r16 = this.p;
        String r17 = this.q;
        String r18 = this.r;
        String r19 = this.s;
        String r110 = this.t;
        Boolean r111 = this.u;
        com.larus.bmhome.chat.trace.a r0 = (com.larus.bmhome.chat.trace.a) r33;
        Intrinsics.checkNotNullParameter(r0, "$this$withChatBaseData");
        int r20 = o.a;
        String r21 = IAIChatControlTraceService.a.g(r0.d, r0.e, r0.b);
        if (Intrinsics.areEqual(r0.k, "landing") == false) goto L5;
        String r22 = "landing";
    L7:
        if (Intrinsics.areEqual(r9, "related_video_suggested_prompt") == false) goto L9;
        String r23 = "";
    L10:
        String r24 = r0.a;
        String r26 = null;
        if (r2 == null) goto L13;
        Long r27 = StringsKt.toLongOrNull(r2);
    L14:
        long r25 = r3;
        String r112 = r0.j;
        String r28 = r0.k;
        if (r4 != null) goto L17;
        String r29 = "";
    L18:
        if (r5 == null) goto L20;
        r26 = r5;
    L23:
        c0.D(r24, r21, Long.valueOf(r25), r27, r112, r22, r23, r28, r9, r10, r11, r12, r13, r14, r8, r26, r15, r29, r7, r6, r16, r17, r18, r19, r110, r111);
        return Unit.INSTANCE;
    L20:
        if (o0.d(r15) == false) goto L23;
        r26 = "action_bar_instruction";
        goto L23
    L17:
        r29 = r4;
        goto L18
    L13:
        r27 = null;
        goto L14
    L9:
        r23 = StringsKt.removeSuffix(r1, ":fake_message:1");
        goto L10
    L5:
        r22 = "click_chat";
        goto L7
    }
}
