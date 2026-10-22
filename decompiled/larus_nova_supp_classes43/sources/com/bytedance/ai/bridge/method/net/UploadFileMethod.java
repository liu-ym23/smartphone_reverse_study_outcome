package com.bytedance.ai.bridge.method.net;

import android.text.TextUtils;
import com.bytedance.ai.applet.domain.AppletDomainPolicyManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsUploadFileMethodIDL;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.ai.file.AppletFileManager;
import d3.a0;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/UploadFileMethod;", "Lcom/bytedance/ai/bridge/network/AbsUploadFileMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsUploadFileMethodIDL$UploadFileParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsUploadFileMethodIDL$UploadFileResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadFileMethod extends AbsUploadFileMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.UploadFileMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.UploadFileMethod$handle$1", f = "UploadFileMethod.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsUploadFileMethodIDL.b> $callback;
        final /* synthetic */ String $filePath;
        final /* synthetic */ String $name;
        final /* synthetic */ AbsUploadFileMethodIDL.a $params;
        final /* synthetic */ d4.b.e $preparation;
        final /* synthetic */ d4.b $uploadManager;
        final /* synthetic */ String $uploadTaskId;
        final /* synthetic */ String $url;
        int label;

        public AnonymousClass1(d4.b.e r1, f3.h<AbsUploadFileMethodIDL.b> r10, String r11, String r12, e3.d r13, String r14, d4.b r15, String r16, String r17, AbsUploadFileMethodIDL.a r18, Continuation<? super AnonymousClass1> r19) {
            this.$preparation = r1;
            this.$callback = r10;
            this.$appletId = r11;
            this.$url = r12;
            this.$bridgeContext = r13;
            this.$filePath = r14;
            this.$uploadManager = r15;
            this.$uploadTaskId = r16;
            this.$name = r17;
            this.$params = r18;
            super(2, r19);
        }

        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            return new AnonymousClass1(this.$preparation, this.$callback, this.$appletId, this.$url, this.$bridgeContext, this.$filePath, this.$uploadManager, this.$uploadTaskId, this.$name, this.$params, r14);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r21) {
            String r10 = "uploadFile:fail no file exist";
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L9;
            if (r11 != 1) goto L8;
            ResultKt.throwOnFailure(r21);     // Catch: Throwable -> L51
            Object r12 = r21;
        L16:
            com.bytedance.ai.applet.domain.e r13 = (com.bytedance.ai.applet.domain.e) r12;     // Catch: Throwable -> L51
            if (r13.a == true) goto L24;
            if (this.$preparation.a == false) goto L21;
            f3.h.a.a(this.$callback, "uploadFile:fail abort", null, null, 14);     // Catch: Throwable -> L51
        L22:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
        L78:
            this.$uploadManager.c(this.$bridgeContext, this.$uploadTaskId, this.$preparation);
            return r1;
        L21:
            f3.h.a.a(this.$callback, r13.b, null, null, 14);     // Catch: Throwable -> L51
            goto L22
        L24:
            if (this.$preparation.a == false) goto L26;
            f3.h.a.a(this.$callback, "uploadFile:fail abort", null, null, 14);     // Catch: Throwable -> L51
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
            goto L78
        L26:
            AppletFileManager r14 = x3.a.d(this.$bridgeContext);     // Catch: Throwable -> L51
            if (r14 != null) goto L82;
            f3.h.a.a(this.$callback, "uploadFile:fail file manager is unavailable", null, null, 14);     // Catch: Throwable -> L51
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
            goto L78
        L82:
            int r15 = com.bytedance.ai.file.a.b;     // Catch: Throwable -> L66
            File r16 = r14.n(com.bytedance.ai.file.a.C0040a.a(this.$filePath));     // Catch: Throwable -> L66
        L32:
            if (this.$preparation.a == false) goto L35;
            f3.h.a.a(this.$callback, "uploadFile:fail abort", null, null, 14);     // Catch: Throwable -> L51
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
            goto L78
        L35:
            if (r16.exists() == true) goto L38;
            f3.h.a.a(this.$callback, "uploadFile:fail no file exist", null, null, 14);     // Catch: Throwable -> L51
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
            goto L78
        L38:
            if (r16.isFile() == true) goto L40;
            f3.h.a.a(this.$callback, "uploadFile:fail path is not a file", null, null, 14);     // Catch: Throwable -> L51
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
            goto L78
        L40:
            d4.b r17 = this.$uploadManager;     // Catch: Throwable -> L51
            e3.d r18 = this.$bridgeContext;     // Catch: Throwable -> L51
            String r19 = this.$uploadTaskId;     // Catch: Throwable -> L51
            String r110 = this.$url;     // Catch: Throwable -> L51
            String r111 = this.$name;     // Catch: Throwable -> L51
            Map<String, String> r112 = d4.c.b(this.$params.getHeader());     // Catch: Throwable -> L51
            Map<String, String> r113 = d4.c.a(this.$params.getFormData());     // Catch: Throwable -> L51
            Long r20 = this.$params.getTimeout();     // Catch: Throwable -> L51
            if (r20 == null) goto L43;
            long r22 = r20.longValue();     // Catch: Throwable -> L51
        L44:
            long r114 = r22;
            IHostNetworkDepend r23 = r4.a.c;     // Catch: Throwable -> L51
            if (r23 != null) goto L47;
            r23 = new b4.a();     // Catch: Throwable -> L51
        L47:
            d4.b.h r24 = r17.l(r18, r19, r110, r16, r111, r112, r113, r114, r23, this.$preparation);     // Catch: Throwable -> L51
            d4.b.g r25 = r24.a;     // Catch: Throwable -> L51
            if (r25 == null) goto L53;
            f3.h<AbsUploadFileMethodIDL.b> r26 = this.$callback;     // Catch: Throwable -> L51
            Intrinsics.checkNotNullParameter(AbsUploadFileMethodIDL.b.class, "<this>");     // Catch: Throwable -> L51
            BaseModel r27 = k3.c.a(AbsUploadFileMethodIDL.b.class);     // Catch: Throwable -> L51
            AbsUploadFileMethodIDL.b r28 = (AbsUploadFileMethodIDL.b) r27;     // Catch: Throwable -> L51
            r28.setStatusCode(r25.a);     // Catch: Throwable -> L51
            r28.setHeader(r25.b);     // Catch: Throwable -> L51
            r28.setData(r25.c);     // Catch: Throwable -> L51
            f3.h.a.b(r26, (ResultModel) r27);     // Catch: Throwable -> L51
        L64:
            this.$uploadManager.c(this.$bridgeContext, this.$uploadTaskId, this.$preparation);
            return Unit.INSTANCE;
        L53:
            f3.h<AbsUploadFileMethodIDL.b> r29 = this.$callback;     // Catch: Throwable -> L51
            String r30 = r24.b;     // Catch: Throwable -> L51
            if (r30 != null) goto L56;
            r30 = "uploadFile failed";
        L56:
            Intrinsics.checkNotNullParameter(AbsUploadFileMethodIDL.b.class, "<this>");     // Catch: Throwable -> L51
            BaseModel r31 = k3.c.a(AbsUploadFileMethodIDL.b.class);     // Catch: Throwable -> L51
            AbsUploadFileMethodIDL.b r32 = (AbsUploadFileMethodIDL.b) r31;     // Catch: Throwable -> L51
            Integer r33 = r24.c;     // Catch: Throwable -> L51
            if (r33 == null) goto L59;
            int r34 = r33.intValue();     // Catch: Throwable -> L51
        L60:
            r32.setStatusCode(r34);     // Catch: Throwable -> L51
            Map<String, String> r35 = r24.d;     // Catch: Throwable -> L51
            if (r35 != null) goto L63;
            r35 = MapsKt.emptyMap();     // Catch: Throwable -> L51
        L63:
            r32.setHeader(r35);     // Catch: Throwable -> L51
            Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L51
            f3.h.a.a(r29, r30, null, ((AbsUploadFileMethodIDL.b) r31).toJson(), 6);     // Catch: Throwable -> L51
            goto L64
        L59:
            r34 = -1;
            goto L60
        L43:
            r22 = 0;
        L66:
            th = move-exception;
            if (this.$preparation.a == false) goto L70;
            f3.h.a.a(this.$callback, "uploadFile:fail abort", null, null, 14);     // Catch: Throwable -> L51
        L77:
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
            goto L78
        L70:
            f3.h<AbsUploadFileMethodIDL.b> r37 = this.$callback;     // Catch: Throwable -> L51
            String r38 = th.getMessage();     // Catch: Throwable -> L51
            if (r38 == null) goto L76;
            String r39 = "uploadFile:fail ".concat(r38);     // Catch: Throwable -> L51
            if (r39 == null) goto L76;
            r10 = r39;
        L76:
            f3.h.a.a(r37, r10, null, null, 14);     // Catch: Throwable -> L51
            goto L77
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r21);
            if (this.$preparation.a == false) goto L13;
            f3.h.a.a(this.$callback, "uploadFile:fail abort", null, null, 14);     // Catch: Throwable -> L51
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
            goto L78
        L13:
            AppletDomainPolicyManager r40 = AppletDomainPolicyManager.a;     // Catch: Throwable -> L51
            String r41 = this.$appletId;     // Catch: Throwable -> L51
            String r115 = this.$url;     // Catch: Throwable -> L51
            this.label = 1;     // Catch: Throwable -> L51
            r12 = r40.f(r41, r115, this);     // Catch: Throwable -> L51
            if (r12 != r0) goto L16;
            return r0;
        L51:
            th = move-exception;
            this.$uploadManager.c(this.$bridgeContext, this.$uploadTaskId, this.$preparation);
            throw th;
        }
    }

    public UploadFileMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r19, ParamModel r20, f3.h r21) {
        AbsUploadFileMethodIDL.a r11 = (AbsUploadFileMethodIDL.a) r20;
        Intrinsics.checkNotNullParameter(r19, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r21, "callback");
        String r10 = r11.getUrl();
        String r12 = r11.getFilePath();
        String r13 = r11.getName();
        String r14 = r11.getUploadTaskId();
        String r15 = null;
        if (Intrinsics.areEqual(r11.getEnableProfile(), Boolean.TRUE) == false) goto L6;
        f3.h.a.a(r21, "uploadFile:fail enableProfile is not supported", null, null, 14);
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        f3.h.a.a(r21, "uploadFile:fail url is invalid", null, null, 14);
        return;
    L9:
        if (TextUtils.isEmpty(r12) == false) goto L12;
        f3.h.a.a(r21, "uploadFile:fail no file exist", null, null, 14);
        return;
    L12:
        if (TextUtils.isEmpty(r13) == false) goto L15;
        f3.h.a.a(r21, "uploadFile:fail name is required", null, null, 14);
        return;
    L15:
        if (TextUtils.isEmpty(r14) == false) goto L17;
        f3.h.a.a(r21, "uploadFile:fail uploadTaskId is empty", null, null, 14);
        return;
    L17:
        d4.b r16 = d4.c.c(r19);
        if (r16 != null) goto L20;
        f3.h.a.a(r21, "uploadFile:fail upload manager is unavailable", null, null, 14);
        return;
    L20:
        Intrinsics.checkNotNullParameter(r19, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "uploadTaskId");
        int r1 = d4.b.c.c;
        d4.b.c r17 = d4.b.c.a.a(r19);
        if (r17 != null) goto L23;
        d4.b.f r18 = new d4.b.f(null, "uploadFile:fail bridge context is unavailable", 1);
    L47:
        String r22 = r18.b;
        if (r22 == null) goto L50;
        f3.h.a.a(r21, r22, null, null, 14);
        return;
    L50:
        d4.b.e r23 = r18.a;
        if (r23 != null) goto L53;
        f3.h.a.a(r21, "uploadFile:fail bridge context is unavailable", null, null, 14);
        return;
    L53:
        a0 r24 = r19.getContainerContext();
        if (r24 == null) goto L56;
        r15 = r24.getAppletId();
    L56:
        BuildersKt.launch$default(AppletRequestMethod.c, null, null, new AnonymousClass1(r23, r21, r15, r10, r19, r12, r16, r14, r13, r11, null), 3, null);
        return;
    L23:
        d4.b.e r110 = new d4.b.e();
        Object r111 = r16.a;
        monitor-enter(r111);
        Map r112 = (Map) ((LinkedHashMap) r16.b).get(r17);     // Catch: Throwable -> L58
        boolean r113 = false;
        if (r112 != null) goto L28;
    L30:
        boolean r114 = false;
    L31:
        if (r114 == true) goto L45;
        Map r115 = (Map) ((LinkedHashMap) r16.c).get(r17);     // Catch: Throwable -> L58
        if (r115 != null) goto L35;
    L37:
        if (r113 == true) goto L45;
        Map<String, d4.b.e> r25 = (Map) ((LinkedHashMap) r16.c).get(r17);     // Catch: Throwable -> L58
        if (r25 != null) goto L42;
        r25 = new LinkedHashMap();     // Catch: Throwable -> L58
    L42:
        r25.put(r14, r110);     // Catch: Throwable -> L58
        r16.c.put(r17, r25);     // Catch: Throwable -> L58
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r111);
        r18 = new d4.b.f(r110, null, 2);
        goto L47
    L35:
        if (r115.containsKey(r14) != true) goto L37;
        r113 = true;
    L45:
        r18 = new d4.b.f(null, "uploadFile:fail uploadTaskId already exists", 1);     // Catch: Throwable -> L58
        monitor-exit(r111);
        goto L47
    L28:
        if (r112.containsKey(r14) != true) goto L30;
        r114 = true;
    L58:
        th = move-exception;
        throw th;
    }
}
