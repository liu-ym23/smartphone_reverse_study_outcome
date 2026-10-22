package com.larus.drive.sdk.impl.preview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import com.larus.platform.model.office.AiFilePreviewScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q0;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AiFilePreviewCoordinator {
    public static final AiFilePreviewCoordinator a = null;

    public static final class a {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final DrivePreviewResType e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ResolvedIdentity(token=" + this.a + ", objType=" + this.b + ", mountPoint=" + this.c + ", appId=" + this.d + ", resType=" + this.e + ')';
        }

        public a(String r2, String r3, DrivePreviewResType r4) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "appId");
            Intrinsics.checkNotNullParameter(r4, "resType");
            this.a = r2;
            this.b = 12;
            this.c = "doubao_tmp_file";
            this.d = r3;
            this.e = r4;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AiFilePreviewScene.values().length];
            r0[AiFilePreviewScene.AI_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AiFilePreviewScene.P2P_CHAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new AiFilePreviewCoordinator();
    }

    public AiFilePreviewCoordinator() {
    }

    public final Object e(String r10, Continuation<? super String> r11) {
        if ((r11 instanceof AiFilePreviewCoordinator$resolveResourceUri$1) == false) goto L7;
        AiFilePreviewCoordinator$resolveResourceUri$1 r0 = (AiFilePreviewCoordinator$resolveResourceUri$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        long r4 = r0.J$0;
        ResultKt.throwOnFailure(r12);     // Catch: TimeoutCancellationException -> L26
    L21:
        return (String) r12;
    L24:
        FLogger.a.w("AiFilePreview", "resolve failed, reason=request_timeout, costMs=" + (SystemClock.elapsedRealtime() - r4));
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
        long r5 = SystemClock.elapsedRealtime();
        AiFilePreviewCoordinator$resolveResourceUri$2 r13 = new AiFilePreviewCoordinator$resolveResourceUri$2(r10, r5, null);     // Catch: TimeoutCancellationException -> L23
        r0.J$0 = r5;     // Catch: TimeoutCancellationException -> L23
        r0.label = 1;     // Catch: TimeoutCancellationException -> L23
        r12 = TimeoutKt.b(3000, r13, r0);     // Catch: TimeoutCancellationException -> L23
        if (r12 != r2) goto L20;
        return r2;
    L20:
        r4 = r5;
    L23:
        r4 = r5;
    L7:
        r0 = new AiFilePreviewCoordinator$resolveResourceUri$1(this, r11);
        goto L8
    }

    public static final boolean b(Context r0, CoroutineScope r1, String r2) {
        if (CoroutineScopeKt.isActive(r1) == true) goto L5;
    L21:
        return false;
    L5:
        if (Intrinsics.areEqual(AccountService.a.getUserId(), r2) == false) goto L21;
    L8:
        if ((r0 instanceof Activity) == true) goto L9;
        if ((r0 instanceof ContextWrapper) == false) goto L13;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L8
    L13:
        Activity r3 = null;
    L14:
        if (r3 != null) goto L17;
    L20:
        return true;
    L17:
        if (r3.isFinishing() == true) goto L21;
        if (r3.isDestroyed() == true) goto L21;
    L9:
        r3 = (Activity) r0;
        goto L14
    }

    public static final Object c(AiFilePreviewCoordinator r4, cr9.a r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof AiFilePreviewCoordinator$resolveRequest$1) == false) goto L7;
        AiFilePreviewCoordinator$resolveRequest$1 r0 = (AiFilePreviewCoordinator$resolveRequest$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (cr9.a) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        String r8 = (String) r7;
        if (r8 != null) goto L20;
        return null;
    L20:
        AiFilePreviewScene r9 = r5.b;
        int r10 = b.a[r9.ordinal()];
        if (r10 != 1) goto L23;
        String r11 = "doubao_ai_msg";
    L29:
        return new a(r8, r11, DrivePreviewResType.THIRD_PARTY_FILE);
    L23:
        if (r10 != 2) goto L26;
        r11 = "doubao_p2p_msg";
        goto L29
    L26:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        String r12 = r5.a;
        r0.L$0 = r5;
        r0.label = 1;
        r7 = r4.e(r12, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new AiFilePreviewCoordinator$resolveRequest$1(r4, r6);
        goto L8
    }

    public static final void a(Context r10, CoroutineScope r11, String r12, Function0 r13) {
        BuildersKt.launch$default(r11, Dispatchers.getMain().getImmediate(), null, new AiFilePreviewCoordinator$fallbackIfCurrent$1(r10, r11, r12, r13, null), 2, null);
    }

    public static void d(Context r12, CoroutineScope r13, cr9.a r14, q0 r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "scope");
        Intrinsics.checkNotNullParameter(r14, "request");
        Intrinsics.checkNotNullParameter(r15, "fallback");
        BuildersKt.launch$default(r13, null, null, new AiFilePreviewCoordinator$open$1(r14, r12, r13, AccountService.a.getUserId(), r15, null), 3, null);
    }
}
