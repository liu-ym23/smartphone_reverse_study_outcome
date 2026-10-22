package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.conditional.access.network.model.response.CommonData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager$sendNetworkProbe$1", f = "NoPermissionModuleManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NoPermissionModuleManager$sendNetworkProbe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.conditional.access.nopermission.manager.c $callback;
    int label;
    final /* synthetic */ NoPermissionModuleManager this$0;

    public static final class a<T> implements Consumer {
        public a() {
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "external source probe send successfully");
            throw null;
        }
    }

    public static final class b<T> implements Consumer {
        public b() {
        }

        public final void accept(Object r3) {
            int r0 = ScsLogger.a;
            ScsLogger.c("SecurityPolicy_NoPermissionModuleManager", "external source probe send error, message=" + ((Throwable) r3).getMessage());
            throw null;
        }
    }

    public static final class c implements com.ss.android.lark.security.compliance.infra.network.d<CommonData> {
        public c() {
        }

        public final Type b() {
            return CommonData.class;
        }

        public final void a(NetworkErrorResult r3) {
            Intrinsics.checkNotNullParameter(r3, "networkErrorResult");
            int r0 = ScsLogger.a;
            ScsLogger.c("SecurityPolicy_NoPermissionModuleManager", "probe send error: " + r3.getErrorMessage());
            throw null;
        }

        public final void c(com.ss.android.lark.security.compliance.infra.network.h<CommonData> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "probe send successfully");
            throw null;
        }
    }

    public NoPermissionModuleManager$sendNetworkProbe$1(NoPermissionModuleManager r1, com.ss.android.lark.conditional.access.nopermission.manager.c r2, Continuation<? super NoPermissionModuleManager$sendNetworkProbe$1> r3) {
        this.this$0 = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NoPermissionModuleManager$sendNetworkProbe$1(this.this$0, null, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r9);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "sendNetworkProbe");
        InternalSecurityAction r10 = (InternalSecurityAction) this.this$0.e.getParcelable("param_action");
        this.this$0.i();
        if (o8b.a.a(r10) == false) goto L8;
        this.this$0.c.g().subscribe(new a(), new b());
        return Unit.INSTANCE;
    L8:
        HttpMethod r11 = HttpMethod.GET;
        HttpParams r3 = new HttpParams();
        HttpHeaders r4 = new HttpHeaders();
        LinkedHashMap r12 = new LinkedHashMap();
        HttpMethod r2 = HttpMethod.GET;
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/ping/", "path");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r7 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/ping/", r2, r3, r4, new JSONObject(r12), true);
        r7.c(BuildConfig.FLAVOR);
        this.this$0.a.a(r7, new c());
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
