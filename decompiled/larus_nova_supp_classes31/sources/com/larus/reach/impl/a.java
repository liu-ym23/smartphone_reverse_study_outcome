package com.larus.reach.impl;

import android.content.Context;
import com.larus.network.FlowHttpConnection;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachCustomClickResult;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.reach.runtime.ReachBannerRuntime;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import ns9.d;
import ns9.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final CoroutineScope a;

    /* JADX INFO: renamed from: com.larus.reach.impl.a$a, reason: collision with other inner class name */
    public static final class C0017a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReachCustomClickResult.values().length];
            r0[ReachCustomClickResult.LOCAL_HANDLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ReachCustomClickResult.SCENE_HANDLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ReachCustomClickResult.NOT_HANDLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public a() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void c(ns9.t r6, e r7) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "click");
        ConcurrentHashMap<String, Long> r2 = com.larus.reach.impl.b.a;
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "click");
        if (c.a(r6) == false) goto L27;
        int r3 = com.larus.reach.impl.b.a.a[r7.a.ordinal()];
        if (r3 != 1) goto L8;
        com.larus.platform.service.o.a.reportEvent("inapp_push_click", com.larus.reach.impl.b.a(r6));
        goto L27
    L8:
        if (r3 != 2) goto L10;
    L14:
        d r4 = r7.b;
        if (r4 == null) goto L27;
        ReachButtonType r5 = r4.getType();
        if (r5 == null) goto L27;
        int r8 = com.larus.reach.impl.b.a.b[r5.ordinal()];
        if (r8 == 1) goto L24;
        if (r8 != 2) goto L23;
        String r9 = "close";
    L25:
        com.larus.platform.service.o r10 = com.larus.platform.service.o.a;
        JSONObject r11 = com.larus.reach.impl.b.a(r6);
        r11.put("button_type", r9);
        Unit r12 = Unit.INSTANCE;
        r10.reportEvent("inapp_push_click_button", r11);
        goto L27
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r9 = "normal";
        goto L25
    L10:
        if (r3 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    L27:
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r13 = com.larus.reach.runtime.y.a;
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "click");
        Iterator r0 = com.larus.reach.runtime.y.h(r6.a.c).iterator();
    L29:
        if (r0.hasNext() == false) goto L38;
        ReachSceneLifecycleListener r1 = (ReachSceneLifecycleListener) r0.next();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L33
        r1.h(r6, r7);     // Catch: Throwable -> L33
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L29;
        FLogger.a.w("ReachSceneDispatcher", "reach scene onClick failed, reachUniqueId=" + r6.a.h + ", scene=" + r6.a.c, r16);
    L33:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }

    public final boolean b(Context r12, ns9.t r13, ReachBannerRuntime.f r14, e r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "session");
        Intrinsics.checkNotNullParameter(r15, "click");
        c(r13, r15);
        ReachCustomClickResult r16 = r14.d(r15);
        int r17 = b.a[r16.ordinal()];
        if (r17 != 1) goto L5;
    L16:
        return true;
    L5:
        if (r17 == 2) goto L16;
        if (r17 != 3) goto L15;
        if (r15.c.isEmpty() == false) goto L12;
        return false;
    L12:
        Context r4 = r12.getApplicationContext();
        BuildersKt.launch$default(this.a, null, null, new ReachActionExecutor$execute$1(r15, this, r4, r13, null), 3, null);
        return true;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public static final Object a(a r17, Context r18, ns9.t r19, e r20, ns9.b r21, Continuation r22) {
        r17.getClass();
        if ((r22 instanceof ReachActionExecutor$sendRequest$1) == false) goto L7;
        ReachActionExecutor$sendRequest$1 r1 = (ReachActionExecutor$sendRequest$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L39:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        e r4 = (e) r1.L$2;
        ns9.t r5 = (ns9.t) r1.L$1;
        Context r6 = (Context) r1.L$0;
        ResultKt.throwOnFailure(r0);
        e r7 = r4;
        ns9.t r8 = r5;
        Context r9 = r6;
    L35:
        dm9.a r10 = (dm9.a) r0;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        ReachActionExecutor$sendRequest$2 r12 = new ReachActionExecutor$sendRequest$2(r17, r9, r8, r7, r10, null);
        r1.L$0 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.label = 2;
        if (BuildersKt.withContext(r11, r12, r1) != r13) goto L39;
        return r13;
    L16:
        ResultKt.throwOnFailure(r0);
        Map<String, String> r14 = r21.b;
        if (r14 == null) goto L23;
        String r15 = r14.get("biz_req_psm");
        if (r15 == null) goto L23;
        if ((!StringsKt.isBlank(r15)) == false) goto L23;
    L24:
        if (r14 == null) goto L30;
        String r16 = r14.get("biz_req_id");
        if (r16 == null) goto L30;
        if ((!StringsKt.isBlank(r16)) == false) goto L30;
    L31:
        FlowHttpConnection r23 = FlowHttpConnection.a;
        ReachActionExecutor$sendRequest$result$1 r24 = new ReachActionExecutor$sendRequest$result$1(r15, r16, r14, null);
        r1.L$0 = r18;
        r1.L$1 = r19;
        r1.L$2 = r20;
        r1.label = 1;
        r0 = FlowHttpConnection.g("Basic", ReachActionApi.class, r24, true, null, null, null, r1, 240);
        if (r0 == r13) goto L40;
        r9 = r18;
        r8 = r19;
        r7 = r20;
        goto L35
    L40:
        return r13;
    L30:
        r16 = null;
    L23:
        r15 = null;
    L7:
        r1 = new ReachActionExecutor$sendRequest$1(r17, r22);
        goto L8
    }
}
