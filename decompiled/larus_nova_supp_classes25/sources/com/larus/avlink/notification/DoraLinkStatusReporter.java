package com.larus.avlink.notification;

import com.larus.applog.api.IApplog;
import com.larus.avlink.n1;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraLinkStatusReporter {
    public static final DoraLinkStatusReporter a = null;
    public static a b;
    public static a c;
    public static Job d;
    public static final MutexImpl e = null;

    public static final class a {
        public final boolean a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((r0 * 31) + this.b) * 31) + this.c;
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "LinkStatus(link=" + this.a + ", idleState=" + this.b + ", currentIdleState=" + this.c + ')';
        }

        public a(boolean r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public DoraLinkStatusReporter() {
    }

    static {
        a = new DoraLinkStatusReporter();
        e = kotlinx.coroutines.sync.b.a();
    }

    public static void b(boolean r6) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraLinkStatusReporter$reportMicOccupyStatus$1(r6, null), 2, null);
    }

    public static void c(boolean r7, Integer r8, Integer r9) {
        IApplog.Companion r0 = IApplog.a;
        boolean r2 = false;
        if (r0.getUserID().length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        if (r0.getDeviceId().length() != 0) goto L10;
        r2 = true;
    L10:
        if (r2 == true) goto L21;
        if (r8 != null) goto L14;
        return;
    L14:
        int r10 = r8.intValue();
        if (r9 == null) goto L17;
        int r11 = r9.intValue();
    L18:
        a r3 = new a(r7, r10, r11);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraLinkStatusReporter$reportStatus$1(r3, null), 2, null);
        return;
    L17:
        r11 = -1;
        goto L18
    L21:
        return;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0176 -> B:13:0x0046). Please report as a decompilation issue!!! */
    public static final Object a(DoraLinkStatusReporter r22, boolean r23, int r24, int r25, int r26, Continuation r27) {
        r22.getClass();
        if ((r27 instanceof DoraLinkStatusReporter$doReport$1) == false) goto L7;
        DoraLinkStatusReporter$doReport$1 r2 = (DoraLinkStatusReporter$doReport$1) r27;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r9 = "DoraLinkStatusReporter";
        if (r5 == 0) goto L21;
        if (r5 == 1) goto L16;
        if (r5 != 2) goto L15;
        int r0 = r2.I$2;
        int r6 = r2.I$1;
        int r10 = r2.I$0;
        b r11 = (b) r2.L$1;
        BizResponse r12 = (BizResponse) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L13:
        String r18 = r9;
        int r7 = r10;
        b r15 = r11;
        BizResponse r14 = r12;
        if (r0 == 0) goto L68;
    L71:
        DoraLinkApi.a r8 = DoraLinkApi.a;     // Catch: Exception -> L55
        DoraLinkStatusReporter$doReport$response$1 r13 = new DoraLinkStatusReporter$doReport$response$1(r15, null);     // Catch: Exception -> L55
        r2.L$0 = r14;     // Catch: Exception -> L55
        r2.L$1 = r15;     // Catch: Exception -> L55
        r2.I$0 = r7;     // Catch: Exception -> L55
        r2.I$1 = r6;     // Catch: Exception -> L55
        r2.label = 1;     // Catch: Exception -> L55
        r8.getClass();     // Catch: Exception -> L55
        DoraLinkApi.a r16 = DoraLinkApi.a.a;     // Catch: Exception -> L55
        FlowHttpConnection r17 = FlowHttpConnection.a;     // Catch: Exception -> L55
        BizResponse r19 = r14;
        b r20 = r15;
        Object r21 = FlowHttpConnection.g("Audio", DoraLinkApi.class, r13, false, null, null, null, r2, 248);     // Catch: Exception -> L53
        if (r21 == r4) goto L76;
        r10 = r7;
        r9 = r18;
        r12 = r19;
        r11 = r20;
        r1 = r21;
    L46:
        dm9.a.b r28 = (dm9.a) r1;     // Catch: Exception -> L19
        if ((r28 instanceof dm9.a.b) == false) goto L49;
        r12 = r28.a;     // Catch: Exception -> L19
    L61:
        r0 = 0;
        if (0 == 0) goto L13;
        r6 = r6 + 1;
        r2.L$0 = r12;
        r2.L$1 = r11;
        r2.I$0 = r10;
        r2.I$1 = r6;
        r2.I$2 = 0;
        r2.label = 2;
        if (DelayKt.delay(1000, r2) != r4) goto L13;
        return r4;
    L49:
        StringBuilder r29 = new StringBuilder();     // Catch: Exception -> L19
        r29.append("Request failed with code: ");     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.larus.network.bean.HttpDataResult.Error");     // Catch: Exception -> L19
        r29.append(((dm9.a.a) r28).c);     // Catch: Exception -> L19
        n1.b(r9, r29.toString());     // Catch: Exception -> L19
        if (r6 >= r10) goto L61;
    L60:
        r0 = 1;
        if (1 == 0) goto L13;
    L19:
        Exception e2 = e;
        r7 = r10;
        b r110 = r11;
        BizResponse r111 = r12;
    L58:
        n1.b(r9, "Network request failed: " + e2.getMessage());
        r10 = r7;
        r12 = r111;
        r11 = r110;
        if (r6 >= r7) goto L61;
    L76:
        return r4;
    L53:
        e2 = e;
    L57:
        r9 = r18;
        r111 = r19;
        r110 = r20;
    L55:
        e2 = e;
        r19 = r14;
        r20 = r15;
        goto L57
    L68:
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r6 = r2.I$1;
        r10 = r2.I$0;
        r11 = (b) r2.L$1;
        r12 = (BizResponse) r2.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L19
        goto L46
    L21:
        ResultKt.throwOnFailure(r1);
        IApplog.Companion r30 = IApplog.a;
        String r112 = r30.getUserID();
        String r113 = r30.getDeviceId();
        Boolean r114 = Boxing.boxBoolean(r23);
        if ((r24 & 1) == 0) goto L24;
        boolean r31 = true;
    L25:
        Boolean r115 = Boxing.boxBoolean(r31);
        if ((r24 & 2) == 0) goto L28;
        boolean r32 = true;
    L29:
        Boolean r116 = Boxing.boxBoolean(r32);
        Boolean r117 = Boxing.boxBoolean(false);
        if (r25 != (-1)) goto L32;
    L34:
        boolean r118 = false;
    L35:
        Boolean r210 = Boxing.boxBoolean(r118);
        if (r25 == (-1)) goto L38;
        boolean r33 = true;
    L39:
        b r34 = new b(r112, r113, r114, r115, r116, r117, r210, Boxing.boxBoolean(r33));
        n1.d("DoraLinkStatusReporter", "doReport post:" + r34);
        r15 = r34;
        r14 = null;
        r18 = "DoraLinkStatusReporter";
        r6 = 0;
        r7 = r26;
        goto L71
    L38:
        r33 = false;
        goto L39
    L32:
        if ((r25 & 1) == 0) goto L34;
        r118 = true;
        goto L35
    L28:
        r32 = false;
        goto L29
    L24:
        r31 = false;
    L7:
        r2 = new DoraLinkStatusReporter$doReport$1(r22, r27);
        goto L8
    }
}
