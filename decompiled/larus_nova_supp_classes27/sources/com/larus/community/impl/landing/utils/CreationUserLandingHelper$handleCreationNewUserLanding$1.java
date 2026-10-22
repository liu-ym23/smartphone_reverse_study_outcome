package com.larus.community.impl.landing.utils;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.community.impl.landing.api.CreationNewUserLandingApi;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.network.FlowHttpConnection;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import l29.b;
import sq9.p;
import sq9.t;
import zp9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.landing.utils.CreationUserLandingHelper$handleCreationNewUserLanding$1", f = "CreationUserLandingHelper.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class CreationUserLandingHelper$handleCreationNewUserLanding$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatParam $chatParam;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ b $trackParams;
    int label;
    final /* synthetic */ CreationUserLandingHelper this$0;

    public static final class a implements zs8.a {
        public final /* synthetic */ b a;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            return String.valueOf(this.a.f);
        }

        public final String getBotId() {
            return this.a.c;
        }

        public final String getEnterMethod() {
            return String.valueOf(this.a.g);
        }

        public final String h() {
            return this.a.h;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    public CreationUserLandingHelper$handleCreationNewUserLanding$1(Fragment r1, b r2, CreationUserLandingHelper r3, ChatParam r4, Continuation<? super CreationUserLandingHelper$handleCreationNewUserLanding$1> r5) {
        this.$fragment = r1;
        this.$trackParams = r2;
        this.this$0 = r3;
        this.$chatParam = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationUserLandingHelper$handleCreationNewUserLanding$1(this.$fragment, this.$trackParams, this.this$0, this.$chatParam, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r67) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r12 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r67);
        Object r1 = r67;
    L11:
        dm9.a.b r2 = (dm9.a) r1;
        if ((r2 instanceof dm9.a.b) == false) goto L84;
        dm9.a.b r3 = r2;
        if (r3.a.isSuccess() == false) goto L84;
        l29.a r4 = (l29.a) r3.a.getData();
        if (r4 == null) goto L18;
        boolean r5 = Intrinsics.areEqual(r4.d(), Boxing.boxBoolean(true));
    L19:
        if (r5 == false) goto L84;
        l29.a r6 = (l29.a) r3.a.getData();
        if (r6 == null) goto L23;
        Integer r7 = r6.b();
    L24:
        l29.a r8 = (l29.a) r3.a.getData();
        if (r8 == null) goto L27;
        Integer r9 = r8.c();
    L28:
        l29.a r11 = (l29.a) r3.a.getData();
        if (r11 == null) goto L31;
        UserCreation r13 = r11.a();
    L32:
        if (r13 == null) goto L36;
        AuthorInfo r14 = r13.g;
        if (r14 == null) goto L36;
        String r15 = r14.b;
    L37:
        boolean r16 = !Intrinsics.areEqual(r15, AccountService.a.getUserId());
        if (r7 == null) goto L47;
        if (r7.intValue() != 1) goto L47;
        i r17 = SmartRouter.buildRoute(this.$fragment.getContext(), "//flow/creation_detail");
        r17.c.putExtra("creation", GsonProtectorUtils.toJson(new Gson(), r13));
        r17.c.putExtra("is_show_profile", r16);
        Gson r18 = new Gson();
        b r20 = this.$trackParams;
        String r21 = r20.f;
        String r110 = String.valueOf(r20.a);
        b r22 = this.$trackParams;
        String r111 = r22.b;
        String r23 = r22.g;
        if (r13 == null) goto L45;
        r12 = r13.a;
    L45:
        r17.c.putExtra("track_params", GsonProtectorUtils.toJson(r18, new g(r110, r111, null, null, null, null, null, r21, r23, null, null, null, null, r12, null, null, null, null, null, null, null, null, 4185724)));
        r17.c.putExtra("show_usage_count", true);
        r17.c.putExtra("can_show_inspiration_list", r16);
        r17.c.putExtra("open_new_chat_page_on_send", false);
        r17.e(123);
    L47:
        if (r7 != null) goto L50;
    L54:
        if (r7 != null) goto L57;
    L82:
        FLogger.a.e("CreationUserLandingHelper", "requestCreationNewUserLandingData: unknown landing type");
        goto L84
    L57:
        if (r7.intValue() != 3) goto L82;
        z0 r24 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(28);
        if (r24 != null) goto L68;
        IActionBarService r25 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r9 != null) goto L64;
    L66:
        int r26 = 4;
    L67:
        r24 = r25.e(r26);
        goto L68
    L64:
        if (r9.intValue() != 2) goto L66;
        r26 = 18;
    L68:
        z0 r112 = r24;
        FragmentActivity r113 = this.$fragment.getActivity();
        if (r113 == null) goto L84;
        ChatParam r27 = this.$chatParam;
        b r28 = this.$trackParams;
        if (r112 == null) goto L84;
        IUgcAIGCService.Companion r30 = IUgcAIGCService.a;
        Bundle r31 = new Bundle();
        if (r13 == null) goto L75;
        String r32 = r13.a;
    L77:
        if (o0.d(r32) == false) goto L81;
        if (r13 == null) goto L80;
        r12 = r13.a;
    L80:
        r31.putString("related_creation_id", r12);
    L81:
        r31.putString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r28.g);
        r30.W(new ny9.b(false, r113, r112, r27, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, new a(r28), null, r31, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -10485775, 262143));
        goto L84
    L75:
        r32 = null;
        goto L77
    L50:
        if (r7.intValue() != 2) goto L54;
        t r33 = this.this$0.b;
        if (r33 == null) goto L84;
        String r114 = String.valueOf(this.$trackParams.a);
        b r34 = this.$trackParams;
        r33.a(new p(null, r114, r34.g, r13, r34.b, null, r34.h, r34.c, r34.d, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 33552929), null);
    L36:
        r15 = null;
        goto L37
    L31:
        r13 = null;
        goto L32
    L27:
        r9 = null;
        goto L28
    L23:
        r7 = null;
        goto L24
    L18:
        r5 = false;
    L84:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r67);
        CreationNewUserLandingApi.a r35 = CreationNewUserLandingApi.a;
        CreationUserLandingHelper$handleCreationNewUserLanding$1$result$1 r36 = new CreationUserLandingHelper$handleCreationNewUserLanding$1$result$1(null);
        this.label = 1;
        r35.getClass();
        com.larus.community.impl.api.t r37 = new com.larus.community.impl.api.t();
        FlowHttpConnection r38 = FlowHttpConnection.a;
        r1 = FlowHttpConnection.g("Social", CreationNewUserLandingApi.class, r36, true, null, null, r37, this, 112);
        if (r1 != r10) goto L11;
        return r10;
    }
}
