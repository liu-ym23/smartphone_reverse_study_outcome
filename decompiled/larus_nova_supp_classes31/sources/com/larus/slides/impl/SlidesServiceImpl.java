package com.larus.slides.impl;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.InAppBannerScene;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.api.d3;
import com.larus.platform.model.NotificationBusiness;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachService;
import com.larus.reach.api.ReachType;
import com.larus.slides.api.ISlidesService;
import com.larus.slides.sdk.api.ISlidesSdkProxyService;
import com.larus.slides.sdk.api.ISlidesSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import hq9.e4;
import hq9.n3;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.s3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0010H\u0002JS\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010$2#\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0007\u0018\u00010&H\u0096@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\u0018\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u000f\u00105\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0002\u00107J\u0010\u00108\u001a\n\u0018\u000109j\u0004\u0018\u0001`:H\u0016J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/slides/impl/SlidesServiceImpl;", "Lcom/larus/slides/api/ISlidesService;", "<init>", "()V", "isColdLaunch", "", "preloadWebViewIfNeeded", "", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSlides", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "page", "", "tryPrefetchData", "openSlidesAndChat", "switchConversationParams", "Lcom/larus/bmhome/chat/resp/SwitchConversationParams;", "findArtifactBlock", "Lcom/larus/im/bean/message/block/ArtifactBlock;", "msg", "Lcom/larus/im/bean/message/Message;", "triggerInnerNotification", "inAppBannerNotify", "Lcom/larus/im/bean/InAppBannerNotify;", "convertAiPptReachRequest", "Lcom/larus/reach/api/ReachRequest;", "getCommonBundle", "pageName", "setSlidesPermission", "slidesToken", "public", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSlidesPermission", "clearReference", "getSlidesTrackInfo", "Lorg/json/JSONObject;", "clearPPTTemplateCache", "showSlidesDownloadFragment", "fragment", "Landroidx/fragment/app/Fragment;", "downloadParams", "Lcom/larus/share/bean/SlideDownloadParams;", "getFloatChatShowPercent", "", "()Ljava/lang/Integer;", "getActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "tryPreloadSlidesDataIfSdkReady", "tryPrefetchSlidesDataIfSdkReady", "buildSlidesOfficeInputParam", "Lcom/larus/office/OfficeInputParam;", "resourceId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesServiceImpl implements ISlidesService {
    public static final /* synthetic */ int b = 0;
    public boolean a;

    public static final class a {
    }

    public static final class b implements by7.e {
        public final /* synthetic */ String a;

        public final by7.e parentTrackNode() {
            return by7.i.c(this);
        }

        public final by7.e referrerTrackNode() {
            return by7.e.a.a(this);
        }

        public b(String r1) {
            this.a = r1;
        }

        public final void fillTrackParams(TrackParams r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            r3.put("current_page", this.a);
        }
    }

    static {
    }

    @Override // com.larus.slides.api.ISlidesService
    public final void clearReference() {
        ISlidesSdkProxyService r0 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r0 == null) goto L6;
        r0.clearReference();
        return;
    }

    @Override // com.larus.slides.api.ISlidesService
    public final void d() {
        com.larus.slides.impl.actionbar.j.a r0 = com.larus.slides.impl.actionbar.j.a;
        com.larus.slides.impl.actionbar.j.a = null;
        FLogger.a.d("PPTGenerationTemplateManager", "Template cache cleared");
    }

    @Override // com.larus.slides.api.ISlidesService
    public final JSONObject e() {
        AppCompatActivity r0 = AppHost.a.a().getCurrentActivity();
        SlidesFragment r2 = null;
        if ((r0 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r1 = r0;
    L7:
        if ((r1 instanceof SlidesActivity) == false) goto L11;
        Fragment r3 = ((SlidesActivity) r1).getSupportFragmentManager().findFragmentByTag("aippt_new_detail");
        if ((r3 instanceof SlidesFragment) == false) goto L11;
        r2 = (SlidesFragment) r3;
    L11:
        if (r2 == null) goto L14;
        return r2.t9();
    L14:
        return new JSONObject();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.slides.api.ISlidesService
    public final void e0() {
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L6;
        r0.e0();
        return;
    }

    public SlidesServiceImpl() {
        this.a = true;
    }

    @Override // com.larus.slides.api.ISlidesService
    public final Integer A() {
        Fragment r0 = com.larus.slides.impl.chat.a.a();
        if (r0 == null) goto L7;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L7;
        va8.g0 r2 = (va8.g0) r1.getAbility(va8.g0.class);
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r2.Gt());
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.slides.api.ISlidesService
    public final Object a(Continuation<? super Unit> r3) {
        ISlidesSdkServiceV2 r0 = (ISlidesSdkServiceV2) ServiceManager.get().getService(ISlidesSdkServiceV2.class);
        if (r0 == null) goto L10;
        Object r4 = r0.a(r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.slides.api.ISlidesService
    public final void b(final tc9.e r33) {
        ns9.t r1 = null;
        if (r33 == null) goto L5;
        String r2 = r33.f();
    L6:
        InAppBannerScene r3 = InAppBannerScene.AI_PPT;
        if (Intrinsics.areEqual(r2, r3.getScene()) == false) goto L67;
        ReachService r4 = (ReachService) ServiceManager.get().getService(ReachService.class);
        if (r4 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        String r10 = "";
        if (r6 == false) goto L37;
        if (r33 == null) goto L18;
        String r7 = r33.f();
    L20:
        if (Intrinsics.areEqual(r7, r3.getScene()) == false) goto L36;
        String r8 = r33.g();
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        String r9 = com.larus.utils.y0.k(com.larus.utils.y0.c(r8, "enter_method", "inner_push"));
        if (r9 != null) goto L28;
        r9 = "";
    L28:
        Context r11 = AppHost.a.getApplication().getApplicationContext();
        if (r11 == null) goto L31;
        String r12 = r11.getString(2131901314);
    L32:
        if (r12 == null) goto L35;
        r10 = r12;
    L35:
        ns9.b r13 = new ns9.b(1, MapsKt.mapOf(TuplesKt.to("schema", r9)));
        r1 = new ns9.t(new ns9.l(null, ReachType.BANNER, r3.getScene(), null, null, ReachRequestSource.CLIENT_BRIDGE, null, 89), new ns9.a(ReachPosition.TOP), new ns9.s(0, null, "dismiss", 3), new ns9.f(r33.h(), r33.d(), r33.b(), null, CollectionsKt.listOf(new ns9.d(ReachButtonType.NORMAL, ReachButtonStyle.PRIMARY, r10, CollectionsKt.listOf(r13))), 17), 16);
        goto L36
    L31:
        r12 = null;
    L36:
        r4.a(r1);
        goto L67
    L18:
        r7 = null;
        goto L20
    L37:
        AppHost.Companion r5 = AppHost.a;
        if ((r5.a().getCurrentActivity() instanceof SlidesActivity) == false) goto L41;
        FLogger.a.i("SlidesServiceImpl", "triggerInnerNotification already in ppt edit");
        return;
    L41:
        String r14 = r33.g();
        if (r14 != null) goto L44;
        r14 = "";
    L44:
        String r15 = com.larus.utils.y0.k(com.larus.utils.y0.c(r14, "enter_method", "inner_push"));
        if (r15 != null) goto L47;
        r15 = "";
    L47:
        String r16 = r33.d();
        if (r16 != null) goto L50;
        String r17 = "";
    L51:
        String r18 = r33.h();
        if (r18 != null) goto L54;
        String r19 = "";
    L55:
        String r20 = r33.b();
        if (r20 != null) goto L58;
        String r110 = "";
    L59:
        Context r21 = r5.getApplication().getApplicationContext();
        if (r21 == null) goto L65;
        String r22 = r21.getString(2131901314);
        if (r22 == null) goto L65;
        r10 = r22;
    L65:
        d3.a.c(new n3(null, r17, r19, r110, null, 0, NotificationBusiness.SLIDES_PPT, null, null, new e4(true, r15, r10, new y0(r33, this)), null, null, null, null, false, null, false, null, 1047397));
        return;
    L58:
        r110 = r20;
        goto L59
    L54:
        r19 = r18;
        goto L55
    L50:
        r17 = r16;
        goto L51
    L11:
        if (r4.h(r3.getScene()) != true) goto L13;
        r6 = true;
    L67:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.slides.api.ISlidesService
    public final boolean c(final Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        String r1 = r6.getString("resource_id");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L21;
        FLogger.a.i("SlidesServiceImpl", "tryPrefetchData skipped, resourceId is empty");
        return false;
    L21:
        final String r0 = r6.getString("resource_id");     // Catch: Exception -> L18
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        return com.larus.office.base.service.d.a("SlidesServiceImpl", r0, new z0(this, r6, r0));
    L18:
        e = move-exception;
        FLogger.a.e("SlidesServiceImpl", "tryPrefetchSlidesDataIfSdkReady, e = " + e);
        return false;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    @Override // com.larus.slides.api.ISlidesService
    public final boolean f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "slidesToken");
        HashMap<String, Boolean> r1 = zw9.c.a;
        Intrinsics.checkNotNullParameter(r3, "slidesToken");
        return Intrinsics.areEqual(zw9.c.a.get(r3), Boolean.TRUE);
    }

    public static OfficeInputParam k(Bundle r4, String r5) {
        OfficeInputParam r0 = new OfficeInputParam();
        r0.setResourceId(r5);
        String r6 = r4.getString("slides_token");
        String r1 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.setSlidesToken(r6);
        r0.setResourceType(9);
        r0.setResourceVersion(r4.getInt("resource_version", -1));
        String r7 = r4.getString("conversation_id");
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r0.setConversationId(r7);
        String r8 = r4.getString("artifact_meta_id");
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r0.setArtifactMetaId(r8);
        String r9 = r4.getString("enter_method");
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r0.setEnterMethod(r9);
        r0.setClickTimestamp(r4.getLong("click_timestamp", System.currentTimeMillis()));
        r0.setObjType(30);
        String r10 = r4.getString("is_general_agent");
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        r0.setGeneralAgent(r10);
        String r11 = r4.getString("chat_id");
        if (r11 == null) goto L21;
        r1 = r11;
    L21:
        r0.setAgentChatId(r1);
        r0.setSourceUrlForParams(r4.getString("key_source_url_for_params"));
        return r0;
    }

    @Override // com.larus.slides.api.ISlidesService
    public final void h(Context r14, ni8.e r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "switchConversationParams");
        boolean r3 = true;
        if (Intrinsics.areEqual(PollingConfigService.a.f("slide_dg"), "1") == false) goto L22;
        t19.s r5 = t19.s.a;
        AppHost.Companion r0 = AppHost.a;
        Application r6 = r0.getApplication();
        z2 r2 = z2.a;
        FlowDowngradeToastConfig r7 = r2.getFlowDowngradeToastConfig();
        String r8 = null;
        if (r7 == null) goto L7;
        String r9 = r7.getTrafficDegradationFeatureDisableCn();
    L8:
        if (r9 != null) goto L10;
    L13:
        if (r3 == false) goto L16;
        String r1 = r0.getApplication().getString(2131910602);
    L15:
        String r10 = r1;
        Intrinsics.checkNotNull(r10);
        t19.s.j(r5, r6, r10, null, false, 28);
        s3.a("slide_dg");
        return;
    L16:
        FlowDowngradeToastConfig r4 = r2.getFlowDowngradeToastConfig();
        if (r4 == null) goto L19;
        r8 = r4.getTrafficDegradationFeatureDisableCn();
    L19:
        r1 = String.valueOf(r8);
        goto L15
    L10:
        if (r9.length() == 0) goto L13;
        r3 = false;
        goto L13
    L7:
        r9 = null;
        goto L8
    L22:
        String r11 = r15.q;
        String r12 = r15.a;
        FLogger.a.i("SlidesServiceImpl", "openSlidesAndChat: messageId=" + r11 + " conversationId=" + r12);
        if (r11 != null) goto L25;
    L28:
        boolean r13 = true;
    L29:
        if (r13 == true) goto L39;
        if (r12 != null) goto L32;
    L35:
        if (r3 == true) goto L40;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SlidesServiceImpl$openSlidesAndChat$1(r12, r15, r11, this, r14, null), 3, null);
        return;
    L40:
        return;
    L32:
        if (r12.length() == 0) goto L35;
        r3 = false;
        goto L35
    L39:
        return;
    L25:
        if (r11.length() == 0) goto L28;
        r13 = false;
        goto L29
    }

    @Override // com.larus.slides.api.ISlidesService
    public final void j(Fragment r2, kw9.h r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "downloadParams");
        zw9.c.d(r2, r3);
    }

    @Override // com.larus.slides.api.ISlidesService
    public final void g(Context r11, final Bundle r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "page");
        FLogger.a.i("SlidesServiceImpl", "Open slides: " + r12.getString("slides_token"));
        boolean r3 = false;
        if (Intrinsics.areEqual(PollingConfigService.a.f("slide_dg"), "1") == false) goto L21;
        t19.s r4 = t19.s.a;
        AppHost.Companion r14 = AppHost.a;
        Application r5 = r14.getApplication();
        z2 r15 = z2.a;
        FlowDowngradeToastConfig r16 = r15.getFlowDowngradeToastConfig();
        String r0 = null;
        if (r16 == null) goto L7;
        String r17 = r16.getTrafficDegradationFeatureDisableCn();
    L8:
        if (r17 != null) goto L10;
    L11:
        r3 = true;
    L12:
        if (r3 == false) goto L15;
        String r18 = r14.getApplication().getString(2131910602);
    L14:
        String r6 = r18;
        Intrinsics.checkNotNull(r6);
        t19.s.j(r4, r5, r6, null, false, 28);
        s3.a("slide_dg");
        return;
    L15:
        FlowDowngradeToastConfig r19 = r15.getFlowDowngradeToastConfig();
        if (r19 == null) goto L18;
        r0 = r19.getTrafficDegradationFeatureDisableCn();
    L18:
        r18 = String.valueOf(r0);
        goto L14
    L10:
        if (r17.length() != 0) goto L12;
    L7:
        r17 = null;
        goto L8
    L21:
        b r1 = new b(r13);
        r12.putBoolean("is_cold_start", this.a);
        if (this.a == false) goto L33;
        this.a = false;
    L33:
        final String r2 = r12.getString("resource_id");     // Catch: Exception -> L29
        if (r2 != null) goto L27;
        r2 = "";
    L27:
        r3 = com.larus.office.base.service.d.b("SlidesServiceImpl", r2, new x0(this, r12, r2));     // Catch: Exception -> L29
    L31:
        r12.putBoolean("key_office_preloaded", r3);
        com.bytedance.router.i r110 = SmartRouter.buildRoute(r11, "//flow/slides_detail");
        by7.h.k(r12, r1);
        r12.putString("argPreviousPage", r13);
        r110.c.putExtras(r12);
        r110.d = 2130772401;
        r110.e = 2130772399;
        r110.d();
        return;
    L29:
        e = move-exception;
        FLogger.a.e("SlidesServiceImpl", "tryPreloadSlidesDataIfSdkReady, e = " + e);
        goto L31
    }

    @Override // com.larus.slides.api.ISlidesService
    public final Unit i(String r1, boolean r2, Function0 r3, Function1 r4) {
        zw9.c.c(r1, r2, r3, r4);
        return Unit.INSTANCE;
    }
}
