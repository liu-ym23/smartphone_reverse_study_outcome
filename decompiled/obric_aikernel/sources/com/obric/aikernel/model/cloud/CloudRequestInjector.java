package com.obric.aikernel.model.cloud;

import android.content.Context;
import com.obric.aikernel.RequestTracker;
import com.obric.aikernel.b;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CloudModelRequest;
import com.obric.aikernel.model.cloud.common.CloudRequestConfigs;
import com.obric.aikernel.request.CallerActionLogger;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class CloudRequestInjector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4624a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public CloudRequestInjector(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f4624a = r10;
    }

    public final Object a(RequestParams r11, b r12, Continuation<? super Boolean> r13) {
        if ((r13 instanceof CloudRequestInjector$injectRequest$1) == false) goto L7;
        CloudRequestInjector$injectRequest$1 r10 = (CloudRequestInjector$injectRequest$1) r13;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r11 = (RequestParams) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L29:
        h.d(m0.a(z0.b()), null, null, new CloudRequestInjector$injectRequest$2$1((RequestTracker.b) r15, null), 3, null);
        CallerActionLogger.d(CallerActionLogger.f4835a, r11, null, 2, null);
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        String r18 = r11.getBackend().getString(IdlKeys.Args_BizName);
        if (r18 != null) goto L17;
    L20:
        boolean r19 = true;
    L21:
        if (r19 == true) goto L23;
        CloudModelRequest r110 = CloudRequestConfigs.f4631a.b(this.f4624a, r18, r11, r12);
        if (r110 == null) goto L32;
        CallerActionLogger.f4835a.e(r11);
        ApiPerfDetails.a r20 = ApiPerfDetails.Companion;
        r20.b(r11.getBackend()).putBoolean("is_cloud", true);
        ApiPerfDetails.a.j(r20, r11.getBackend(), ApiPerfDetails.onStartApiCoroutine, false, 2, null);
        AIKLog.INSTANCE.i("CloudRequestInjector", r18 + " cloud call start: request[" + r11.getClientId() + '-' + r11.getTraceIdStr() + "] " + r110);
        r10.L$0 = r11;
        r10.label = 1;
        r15 = r110.f(r10);
        if (r15 != r16) goto L29;
        return r16;
    L32:
        return Boxing.boxBoolean(false);
    L23:
        return Boxing.boxBoolean(false);
    L17:
        if (r18.length() == 0) goto L20;
        r19 = false;
    L7:
        r10 = new CloudRequestInjector$injectRequest$1(this, r13);
        goto L8
    }
}
