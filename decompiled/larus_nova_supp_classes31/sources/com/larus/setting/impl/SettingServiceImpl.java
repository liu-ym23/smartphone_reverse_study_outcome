package com.larus.setting.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.SettingsAccountInfo;
import com.larus.account.base.model.SettingsBaseAccountInfo;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.disk.api.IAppDiskService;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.push.api.IPushService;
import com.larus.setting.api.ISettingApi;
import com.larus.setting.api.data.NotifySettingsSectionId;
import com.larus.setting.api.data.SettingsItemAction;
import com.larus.setting.api.trace.ISettingTrackApi;
import com.larus.setting.api.trace.SettingTrackDelegate;
import com.larus.setting.impl.iconchanger.ChangeAppIconManager;
import com.larus.setting.impl.modeltraining.PrivacyModelTrainingActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0016JJ\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0016J,\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010+\u001a\u00020\nH\u0002J\u0012\u0010,\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006."}, d2 = {"Lcom/larus/setting/impl/SettingServiceImpl;", "Lcom/larus/setting/api/ISettingApi;", "<init>", "()V", "getSettingTrackImpl", "Lcom/larus/setting/api/trace/ISettingTrackApi;", "preloadAppDynamicIcons", "", "setEnableBackGroundUpdate", "enableBackGroundUpdate", "", "initRegisterAppBackGroundListener", "setEnableShowSynDialog", "enable", "openChangeAppIconPage", "context", "Landroid/content/Context;", "enterFrom", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "localConversationId", "conversationId", "previousPage", "pendingDeeplinkSchema", "getFindSettingsItemList", "", "Lcom/larus/setting/api/data/SettingsSection;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotifySettingItems", "isAppNotifyEnable", "application", "Landroid/app/Application;", "isAppNotifyDetailEnable", "bindManualCacheCleanEntry", "fragment", "Landroidx/fragment/app/Fragment;", "entryView", "Landroid/view/View;", "currentPage", "trackNode", "isNotifyEnabled", "jumpPrivacyModelTrainingPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SettingServiceImpl implements ISettingApi {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public SettingServiceImpl() {
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void g() {
        ChangeAppIconManager.d = false;
    }

    public static boolean l() {
        IPushService r0 = (IPushService) ServiceManager.get().getService(IPushService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c() != true) goto L7;
        return true;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final ISettingTrackApi f() {
        return SettingTrackDelegate.a;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void i() {
        ChangeAppIconManager.f();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void k() {
        ChangeAppIconManager.b();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final List<zs9.c> a(final FragmentActivity r14) {
        if (r14 == null) goto L4;
        final SettingModel r0 = new SettingModel(r14.getApplication());
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        boolean r4 = r0.isAppNotifyDetailAdminDisabled();
        zs9.b r5 = new zs9.b();
        r5.b = r14.getString(2131909307);
        if (l() == false) goto L8;
        SettingsItemAction r6 = SettingsItemAction.TOGGLE;
    L9:
        r5.g = r6;
        String r7 = null;
        if (l() == true) goto L12;
        String r8 = r14.getString(2131909306);
    L13:
        r5.c = r8;
        r5.d = 2131242163;
        r5.e = Boolean.valueOf(r0.isSystemNotifyEnable());
        r5.h = new m3(this, r0, r14);
        r2.add(r5);
        zs9.c r9 = new zs9.c();
        r9.a = NotifySettingsSectionId.APP_CLOSED.getValue();
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        r9.b = String.format(r14.getString(2131909302), Arrays.copyOf(new Object[]{r14.getResources().getString(2131894309)}, 1));
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r9.c = r2;
        r1.add(r9);
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.b() == true) goto L16;
    L29:
        com.larus.bmhome.a0.z1.getClass();
        if (com.larus.bmhome.a0.a.b == false) goto L32;
        zs9.c r11 = new zs9.c();
        r11.a = NotifySettingsSectionId.NOTIFY_TYPE.getValue();
        r11.b = r14.getString(2131909304);
        zs9.b r15 = new zs9.b();
        r15.a = "scheduled_job";
        int r12 = com.larus.utils.j0.a;
        r15.b = com.larus.utils.j0.e("scheduledTasks_notifSettings_header_scheduledTasks");
        r15.g = SettingsItemAction.TOGGLE;
        r15.d = 2131241914;
        r15.e = Boolean.valueOf(r0.isScheduledJobNotifyEnable());
        r15.h = new p3(r0);
        r11.a(CollectionsKt.listOf(r15));
        r1.add(r11);
    L32:
        return r1;
    L16:
        if (com.larus.platform.service.z2.a.q().n == false) goto L29;
        zs9.b r13 = new zs9.b();
        r13.b = r14.getString(2131909300);
        SettingsItemAction r16 = SettingsItemAction.TOGGLE;
        r13.g = r16;
        r13.d = 2131240840;
        r13.e = Boolean.valueOf(r0.isAppNotifyEnable());
        r13.h = new n3(r0);
        r3.add(r13);
        zs9.b r17 = new zs9.b();
        r17.b = r14.getString(2131909305);
        if (r4 == false) goto L22;
        int r18 = com.larus.utils.j0.a;
        String r19 = com.larus.utils.j0.e("AdminConsole_PrivacySettings_CannotEnableOrgSettings_Text");
        if (Boolean.valueOf(Intrinsics.areEqual(r19, "AdminConsole_PrivacySettings_CannotEnableOrgSettings_Text")).booleanValue() == true) goto L22;
        r7 = r19;
    L22:
        r17.c = r7;
        r17.g = r16;
        r17.d = 2131240839;
        if (r4 == false) goto L25;
    L27:
        boolean r20 = false;
    L28:
        r17.e = Boolean.valueOf(r20);
        r17.f = !r4;
        r17.h = new o3(r0);
        r3.add(r17);
        zs9.c r21 = new zs9.c();
        r21.a = NotifySettingsSectionId.APP_OPEN.getValue();
        r21.b = String.format(r14.getString(2131909303), Arrays.copyOf(new Object[]{r14.getResources().getString(2131894309)}, 1));
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r21.c = r3;
        r1.add(r21);
        goto L29
    L25:
        if (r0.isAppNotifyDetailEnable() == false) goto L27;
        r20 = true;
        goto L28
    L12:
        r8 = null;
        goto L13
    L8:
        r6 = SettingsItemAction.TAP;
        goto L9
    L4:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final boolean e(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        return new SettingModel(r2).isAppNotifyDetailEnable();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final boolean h(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        return new SettingModel(r2).isAppNotifyEnable();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void j(Context r4) {
        if ((r4 instanceof Activity) == false) goto L5;
        Activity r5 = (Activity) r4;
    L6:
        if (r5 == null) goto L8;
        r5.startActivity(new Intent(r5, PrivacyModelTrainingActivity.class));
        return;
    L8:
        AppHost.Companion r6 = AppHost.a;
        Application r0 = r6.getApplication();
        Intent r1 = new Intent(r6.getApplication(), PrivacyModelTrainingActivity.class);
        r1.addFlags(268435456);
        r0.startActivity(r1);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.setting.api.ISettingApi
    public final Object d(FragmentActivity r22, Continuation<? super List<zs9.c>> r23) {
        FragmentActivity r0 = r22;
        if ((r23 instanceof SettingServiceImpl$getFindSettingsItemList$1) == false) goto L7;
        SettingServiceImpl$getFindSettingsItemList$1 r2 = (SettingServiceImpl$getFindSettingsItemList$1) r23;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        SettingServiceImpl$getFindSettingsItemList$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        String r16 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Ref.ObjectRef r6 = (Ref.ObjectRef) r14.L$3;
        final SettingModel r7 = (SettingModel) r14.L$2;
        List<zs9.b> r8 = (List) r14.L$1;
        FragmentActivity r9 = (FragmentActivity) r14.L$0;
        ResultKt.throwOnFailure(r1);
        Ref.ObjectRef r10 = r6;
        r0 = r9;
        List<zs9.b> r11 = r8;
        Object r12 = r1;
    L30:
        com.larus.network.http.y r13 = (com.larus.network.http.a) r12;
        if ((r13 instanceof com.larus.network.http.y) == false) goto L39;
        SettingsAccountInfo r15 = (SettingsAccountInfo) ((com.larus.network.http.a) r13).b;
        if (r15 == null) goto L37;
        SettingsBaseAccountInfo r17 = r15.a();
        if (r17 == null) goto L37;
        String r18 = r17.a();
    L38:
        r10.element = r18;
        IAccountService.a.i(r15);
    L37:
        r18 = null;
    L39:
        zs9.b r19 = new zs9.b();
        r19.b = r0.getString(2131909311);
        r19.g = SettingsItemAction.TOGGLE;
        r19.c = (String) r10.element;
        r19.d = Boxing.boxInt(2131241716);
        r19.e = Boxing.boxBoolean(r7.isFindByPhoneEnabled());
        r19.h = new k3(r7);
        r11.add(r19);
        final SettingModel r110 = r7;
        List<zs9.b> r20 = r11;
    L41:
        zs9.b r21 = new zs9.b();
        r21.b = r0.getString(2131909236);
        r21.g = SettingsItemAction.TOGGLE;
        r38.b r24 = IAccountService.a.getUserInfo();
        if (r24 == null) goto L44;
        r16 = r24.g();
    L44:
        r21.c = r16;
        r21.d = Boxing.boxInt(2131241419);
        r21.e = Boxing.boxBoolean(r110.isFindByDoubaoUserNameEnabled());
        r21.h = new l3(r110);
        r20.add(r21);
        zs9.c r25 = new zs9.c();
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r25.c = r20;
        return CollectionsKt.listOf(r25);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r0 == null) goto L17;
        r20 = new ArrayList();
        r110 = new SettingModel(r22.getApplication());
        if (ILoginService.a.getAccountInfo().g == true) goto L41;
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        SettingsAccountInfo r26 = IAccountService.a.w();
        if (r26 == null) goto L25;
        SettingsBaseAccountInfo r27 = r26.a();
        if (r27 == null) goto L25;
        String r28 = r27.a();
    L26:
        r111.element = r28;
        String r29 = com.larus.login.api.i0.c;
        JSONObject r30 = new JSONObject();
        r14.L$0 = r0;
        r14.L$1 = r20;
        r14.L$2 = r110;
        r14.L$3 = r111;
        r14.label = 1;
        r12 = HttpExtKt.k("Basic", SettingsAccountInfo.class, r29, r30, null, null, false, null, null, null, r14, 1008);
        if (r12 != r4) goto L29;
        return r4;
    L29:
        r11 = r20;
        r10 = r111;
        r7 = r110;
    L25:
        r28 = null;
        goto L26
    L17:
        return CollectionsKt.emptyList();
    L7:
        r2 = new SettingServiceImpl$getFindSettingsItemList$1(this, r23);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.setting.impl.b1, kotlin.jvm.functions.Function1] */
    @Override // com.larus.setting.api.ISettingApi
    public final void c(final Fragment r12, View r13, final String r14, final by7.e r15) {
        Intrinsics.checkNotNullParameter(r12, "fragment");
        Intrinsics.checkNotNullParameter(r14, "currentPage");
        ManualCacheCleanUiController.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "fragment");
        Intrinsics.checkNotNullParameter(r14, "currentPage");
        CommonDialog r1 = null;
        if ((r13 instanceof ItemTextArrow) == false) goto L5;
        final ItemTextArrow r0 = (ItemTextArrow) r13;
    L6:
        boolean r2 = IAppDiskService.a.f();
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("bind entry, itemAvailable=");
        if (r0 == null) goto L9;
        boolean r7 = true;
    L10:
        r4.append(r7);
        r4.append(", enabled=");
        r4.append(r2);
        r3.i("ManualCacheCleanUi", r4.toString());
        if (r0 == null) goto L26;
        if (r2 == false) goto L26;
        r0.setVisibility(0);
        r0.setEnabled(true);
        r0.setClickable(true);
        r0.setStyle(1);
        final Ref.ObjectRef r16 = new Ref.ObjectRef();
        final ?? r9 = new b1(r0);
        final ItemTextArrow r8 = r0;
        com.larus.utils.e1.d(r0, new c1(r16, r14, r15, r12, r8, r9));
        CommonDialog r5 = r12.getChildFragmentManager().findFragmentByTag("manual_cache_clean_confirm");
        if ((r5 instanceof CommonDialog) == false) goto L17;
        r1 = r5;
    L17:
        if (r1 != null) goto L29;
        ManualCacheCleanUiController.c(r16, r12, r0, r9, r14, r15, false);
        return;
    L29:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L20
    L24:
        ManualCacheCleanUiController.c(r16, r12, r0, r9, r14, r15, true);
        return;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L24;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L26:
        if (r13 == null) goto L33;
        r13.setVisibility(8);
        return;
    L33:
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void b(Context r2, String r3, by7.e r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        ChangeAppIconManager.b = true;
        com.bytedance.router.i r9 = SmartRouter.buildRoute(r2, "//flow/change_app_icon");
        Bundle r0 = com.larus.utils.f.c(new Pair[0]);
        if (r5 == null) goto L5;
        r0.putString("setting_local_conversation_id", r6);
    L5:
        if (r6 == null) goto L7;
        r0.putString("setting_conversation_id", r6);
    L7:
        if (r8 == null) goto L9;
        r0.putString("pending_deeplink_schema", r8);
    L9:
        r0.putString("enter_method", r3);
        if (r7 == null) goto L12;
        r0.putString("previous_page", r7);
    L12:
        if (r4 == null) goto L14;
        by7.h.k(r0, r4);
    L14:
        r9.c.putExtras(r0);
        r9.c.addFlags(536870912);
        r9.d = 2130772401;
        r9.e = 2130772399;
        r9.e(100);
    }
}
