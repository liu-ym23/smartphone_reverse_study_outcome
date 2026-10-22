package com.obric.assistant.login;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentPrivacyIDL;
import com.obric.aiagent.ipc.utils.g;
import com.obric.assistant.common.utils.m;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.reporter.IObricSystemReporter;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.login.LoginReportImpl$report$1", f = "LoginReportImpl.kt", i = {}, l = {129, 90}, m = "invokeSuspend", n = {}, s = {})
final class LoginReportImpl$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ LoginReportImpl this$0;

    public static final class a implements Function1<String, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<String> a;

        public a(j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            String r3 = (String) r2;
            Intrinsics.checkNotNullParameter(r3, "deviceId");
            this.a.resumeWith(Result.constructor-impl(r3));
            return Unit.INSTANCE;
        }
    }

    public LoginReportImpl$report$1(LoginReportImpl r1, Continuation<? super LoginReportImpl$report$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LoginReportImpl$report$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = false;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L55:
        Boolean r4 = (Boolean) r10;
    L56:
        FLogger.a.i("LoginReportImpl", "report: called, reportODidRelation response: " + r4);
    L58:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        LoginReportImpl r2 = (LoginReportImpl) this.L$0;
        ResultKt.throwOnFailure(r10);
    L33:
        String r11 = (String) r10;
        LoginReportImpl r5 = this.this$0;
        int r6 = LoginReportImpl.b;
        r5.getClass();
        String r7 = o.a.getDeviceId();
        FLogger r8 = FLogger.a;
        r8.i("LoginReportImpl", "report: called, oMatrixDid = " + r11 + ", doubaoDid = " + r7);
        if (r11 != null) goto L36;
    L39:
        boolean r9 = true;
    L40:
        if (r9 == false) goto L42;
    L59:
        r8.e("LoginReportImpl", "report: called, oMatrixDid or doubaoDid isNullOrEmpty!!");
        return Unit.INSTANCE;
    L42:
        if (r7.length() != 0) goto L44;
        r3 = true;
    L44:
        if (r3 == true) goto L59;
        JSONObject r12 = new JSONObject();
        r12.put("o_system_did", r11);
        r12.put("o_assistant_did", r7);
        KClass r13 = Reflection.getOrCreateKotlinClass(IAgentPrivacyIDL.class);
        int r14 = com.obric.aiagent.assistant.idl.k.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        g.a.getClass();
        IAgentPrivacyIDL r15 = g.b(IAgentPrivacyIDL.class);
        if (r15 == null) goto L58;
        String r16 = r15.getPemCertChain("o_did_relation", r12.toString());
        if (r16 == null) goto L58;
        r8.i("LoginReportImpl", "report: called, getPemCertChain result: ".concat(r16));
        IObricNetworkService r17 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        r4 = null;
        if (r17 == null) goto L56;
        this.L$0 = null;
        this.label = 2;
        r10 = r17.k("obric_assistant_aiagent", r16, this);
        if (r10 != r0) goto L55;
        return r0;
    L36:
        if (r11.length() == 0) goto L39;
        r9 = false;
        goto L40
    L10:
        ResultKt.throwOnFailure(r10);
        LoginReportImpl r18 = this.this$0;
        this.L$0 = r18;
        this.label = 1;
        j r19 = new j(IntrinsicsKt.intercepted(this), 1);
        r19.C();
        a r20 = new a(r19);
        int r21 = LoginReportImpl.b;
        r18.getClass();
        m.a.getClass();
        if (m.a() == false) goto L16;
        IObricSystemReporter.a.getClass();
        IObricSystemReporter r110 = IObricSystemReporter.a.a();
        if (r110 != null) goto L15;
        FLogger.a.e("LoginReportImpl", "acquireOMatrixDeviceId failed, IObricSystemReporter is null");
        r20.invoke("");
    L28:
        r10 = r19.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended(this);
    L31:
        if (r10 != r0) goto L33;
        return r0;
    L15:
        r110.a(r20);
        goto L28
    L16:
        MatrixTeaManager r111 = MatrixTeaManager.o;
        String r112 = MatrixTeaManager.a.a().e();
        if (r112 != null) goto L19;
    L22:
        boolean r22 = true;
    L23:
        if (r22 == false) goto L25;
    L27:
        MatrixTeaManager.a.a().b(new d(r20));
        goto L28
    L25:
        if (Intrinsics.areEqual(r112, "0") == true) goto L27;
        r20.invoke(r112);
        goto L28
    L19:
        if (StringsKt.isBlank(r112) == true) goto L22;
        r22 = false;
        goto L23
    }
}
