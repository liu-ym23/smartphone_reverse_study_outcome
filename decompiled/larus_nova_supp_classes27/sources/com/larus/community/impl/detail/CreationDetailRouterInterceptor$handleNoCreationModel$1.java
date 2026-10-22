package com.larus.community.impl.detail;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.utils.p0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.CreationDetailRouterInterceptor$handleNoCreationModel$1", f = "CreationDetailRouterInterceptor.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailRouterInterceptor$handleNoCreationModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ FragmentActivity $curActivity;
    final /* synthetic */ boolean $isFromAnchor;
    final /* synthetic */ Bundle $originBundle;
    int label;
    final /* synthetic */ CreationDetailRouterInterceptor this$0;

    public CreationDetailRouterInterceptor$handleNoCreationModel$1(Bundle r1, String r2, boolean r3, CreationDetailRouterInterceptor r4, FragmentActivity r5, Continuation<? super CreationDetailRouterInterceptor$handleNoCreationModel$1> r6) {
        this.$originBundle = r1;
        this.$creationId = r2;
        this.$isFromAnchor = r3;
        this.this$0 = r4;
        this.$curActivity = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationDetailRouterInterceptor$handleNoCreationModel$1(this.$originBundle, this.$creationId, this.$isFromAnchor, this.this$0, this.$curActivity, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        UserCreation r3 = null;
        boolean r4 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r30);
        Object r5 = r30;
    L11:
        dm9.a.b r6 = (dm9.a) r5;
        boolean r7 = r6 instanceof dm9.a.b;
        if (r7 == false) goto L46;
        dm9.a.b r8 = r6;
        if (r8.a.isSuccess() == false) goto L46;
        com.larus.community.impl.api.e r9 = (com.larus.community.impl.api.e) r8.a.getData();
        if (r9 == null) goto L22;
        List<UserCreation> r10 = r9.a();
        if (r10 == null) goto L22;
        if ((!r10.isEmpty()) != true) goto L22;
    L23:
        if (r4 == false) goto L46;
        com.larus.community.impl.api.e r11 = (com.larus.community.impl.api.e) r8.a.getData();
        if (r11 == null) goto L29;
        List<UserCreation> r12 = r11.a();
        if (r12 == null) goto L29;
        r3 = (UserCreation) CollectionsKt.firstOrNull(r12);
    L29:
        String r13 = this.$originBundle.getString("template_rec_req_id");
        if (r13 == null) goto L36;
        String r14 = p0.a(r13);
        if (r14 == null) goto L36;
        int r15 = this.$originBundle.getInt("position");
        if (r3 == null) goto L36;
        r3.n = new UserCreationTrackParams(r14, Boxing.boxInt(r15), 122);
    L36:
        this.$originBundle.putString("creation", GsonProtectorUtils.toJson(new Gson(), r3));
        Bundle r16 = this.$originBundle;
        Gson r17 = new Gson();
        String r18 = this.$originBundle.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
        if (r18 != null) goto L39;
        String r110 = "";
    L40:
        String r20 = this.$originBundle.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
        if (r20 != null) goto L43;
        String r21 = "";
    L44:
        String r22 = this.$originBundle.getString("recommend_from");
        String r111 = this.$originBundle.getString("ai_creation_recommend_from");
        String r23 = this.$originBundle.getString("prompt_type");
        String r24 = this.$originBundle.getString("prompt_from");
        String r25 = this.$originBundle.getString("visual_size");
        String r26 = this.$originBundle.getString("tag_code");
        String r27 = this.$originBundle.getString("item_id");
        String r28 = this.$originBundle.getString("reco_request_id");
        r16.putString("track_params", GsonProtectorUtils.toJson(r17, new zp9.g(r21, r22, null, null, null, null, null, null, r110, r111, null, null, null, this.$creationId, this.$originBundle.getString("gid"), Boxing.boxBoolean(this.$isFromAnchor), r23, r24, r25, r26, r27, r28, 7420)));
        CreationDetailRouterInterceptor r31 = this.this$0;
        FragmentActivity r32 = this.$curActivity;
        Bundle r33 = this.$originBundle;
        r31.getClass();
        CreationDetailRouterInterceptor.e(r32, r33);
    L87:
        return Unit.INSTANCE;
    L43:
        r21 = r20;
        goto L44
    L39:
        r110 = r18;
    L22:
        r4 = false;
    L46:
        if (r7 == false) goto L85;
        String r34 = this.$originBundle.getString("creation_type");
        if (r34 == null) goto L50;
        Integer r35 = StringsKt.toIntOrNull(r34);
    L51:
        if (r35 != null) goto L54;
    L55:
        if (r35 != null) goto L58;
    L60:
        if (r35 != null) goto L63;
    L64:
        if (r35 != null) goto L67;
    L68:
        if (r35 != null) goto L71;
    L72:
        if (r35 != null) goto L75;
    L76:
        if (r35 != null) goto L79;
    L82:
        if (r3 == null) goto L84;
        SmartRouter.buildRoute(this.$curActivity, UriProtector.parse("//flow/creation_template").buildUpon().appendQueryParameter("actionbar_instruction_type", r3.toString()).appendQueryParameter(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, this.$originBundle.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD)).build().toString()).d();
        goto L87
    L84:
        m29.a.c("CreationDetailRouterInterceptor", "instructionType is null, so jump detail");
        CreationDetailRouterInterceptor r36 = this.this$0;
        FragmentActivity r37 = this.$curActivity;
        Bundle r38 = this.$originBundle;
        r36.getClass();
        CreationDetailRouterInterceptor.e(r37, r38);
        goto L87
    L79:
        if (r35.intValue() != 12) goto L82;
    L80:
        r3 = Boxing.boxInt(18);
        goto L82
    L75:
        if (r35.intValue() == 10) goto L80;
    L71:
        if (r35.intValue() == 11) goto L80;
    L67:
        if (r35.intValue() == 7) goto L80;
    L63:
        if (r35.intValue() == 6) goto L80;
    L58:
        if (r35.intValue() != 5) goto L60;
    L81:
        r3 = Boxing.boxInt(4);
        goto L82
    L54:
        if (r35.intValue() == 2) goto L81;
    L50:
        r35 = null;
        goto L51
    L85:
        m29.a.b("CreationDetailRouterInterceptor", "getCreationDetail failed, fallback to detail loading");
        CreationDetailRouterInterceptor r40 = this.this$0;
        FragmentActivity r41 = this.$curActivity;
        Bundle r42 = this.$originBundle;
        r40.getClass();
        CreationDetailRouterInterceptor.e(r41, r42);
        goto L87
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r30);
        CreationRecommendApi.a r43 = CreationRecommendApi.a;
        CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1 r44 = new CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1(this.$creationId, this.$isFromAnchor, null);
        this.label = 1;
        r43.getClass();
        r5 = CreationRecommendApi.a.c(r44, this);
        if (r5 != r1) goto L11;
        return r1;
    }
}
