package wr8;

import android.os.SystemClock;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.userchat.start.core.StartTaskExecTime;
import com.larus.im.service.s;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;
import wc9.l;
import wc9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends xr8.a {
    public static CompletableDeferred<List<l>> a;
    public static boolean b;
    public static final MutableSharedFlow<List<l>> c = null;
    public static final a1 d = null;

    public static final class a {
        public static void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            CompletableDeferred<List<l>> r0 = b.a;
            if (r0 == null) goto L5;
            r0.complete(CollectionsKt.emptyList());
        L5:
            b.a = null;
            FLogger.a.i("PreLoadConvListTask", "resetDeffer reason=".concat(r2));
        }
    }

    @Override // xr8.a
    public final int d() {
        return 60;
    }

    static {
        MutableSharedFlow<List<l>> r0 = SharedFlowKt.MutableSharedFlow$default(GuidePriority.COMMERCE_CREDIT_PRIORITY, 0, null, 6, null);
        c = r0;
        d = e.a(r0);
    }

    @Override // xr8.a
    public final boolean a() {
        int r0 = com.larus.im.d.a;
        s.a.getClass();
        return s.a.a().getInitialize();
    }

    @Override // xr8.a
    public final void b() {
        FLogger r0 = FLogger.a;
        r0.i("PreLoadConvListTask", "start preload conversations");
        a = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (AccountService.a.isLogin().booleanValue() == true) goto L7;
        r0.i("PreLoadConvListTask", "user not login no need preload conversations");
        CompletableDeferred<List<l>> r1 = a;
        if (r1 == null) goto L9;
        r1.complete(CollectionsKt.emptyList());
        return;
    L9:
        return;
    L7:
        long r2 = SystemClock.elapsedRealtime();
        o r3 = new o(null, 20, null, 9);
        com.larus.im.d.d().getConversationList(r3, new c(this, r2));
    }

    @Override // xr8.a
    public final void e() {
        CompletableDeferred<List<l>> r0 = a;
        if (r0 == null) goto L5;
        r0.complete(CollectionsKt.emptyList());
    L5:
        a = null;
        FLogger.a.i("PreLoadConvListTask", "skip pre load conv list!");
        f(this, false, -1, -1, true, "skip execute", 0, 0, 96);
    }

    public b() {
    }

    @Override // xr8.a
    public final StartTaskExecTime c() {
        return StartTaskExecTime.BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED;
    }

    public static void f(final b r12, final boolean r13, final long r14, final long r16, boolean r18, String r19, int r20, int r21, int r22) {
        if ((r22 & 8) == 0) goto L5;
        final boolean r10 = false;
    L7:
        if ((r22 & 16) == 0) goto L9;
        final String r11 = null;
    L11:
        if ((r22 & 32) == 0) goto L13;
        final int r4 = -1;
    L15:
        if ((r22 & 64) == 0) goto L17;
        final int r5 = -1;
    L18:
        r12.getClass();
        ThreadPlus.submitRunnable(new wr8.a(r12, r13, r4, r5, r14, r16, r10, r11));
        return;
    L17:
        r5 = r21;
        goto L18
    L13:
        r4 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }
}
