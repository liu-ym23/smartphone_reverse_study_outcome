package com.bytedance.android.livesdk.interactivity.api;

import am2.x;
import android.content.Context;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalManagerServiceWidget;
import com.bytedance.android.livesdk.interactivity.barrage.widget.VSLandscapeCarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalRedPacketEggResultModel;
import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalTrayContentResultModel;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.SimpleZDanmakuSettingDialogFragment;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeZDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPreviewBarrageService;
import com.bytedance.android.livesdkapi.service.OpenParams;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0005H\u0016J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J>\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0016J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"H\u0016J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020)H\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/BarrageService;", "Lcom/bytedance/android/livesdk/interactivity/api/IBarrageService;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "providePortraitBarrageWidget", "provideLandscapeBarrageWidget", "Ljava/lang/Class;", "provideCarnivalManagerWidget", "provideChatCarnivalWidget", "provideLandscapeCarnivalWidget", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "providePortraitSimpleBarrageWidget", "providePortraitSimpleBarrageWidgetClass", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "requestPage", BuildConfig.FLAVOR, "showVSLandscapeBarrageSettingDialog", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraParams", "Ln22/c;", "showLandscapeBarrageSettingDialog", "Ln22/d;", "msg", "addBarrageToScreen", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/b;", "createBarrageContext", "Lq82/c;", "Lq82/f;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ShowCarnivalTrayContentResultModel;", "createShowCarnivalTrayContentMethod", "Lq82/b;", "Lq82/e;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ShowCarnivalRedPacketEggResultModel;", "createShowCarnivalRedPacketEggMethod", "Lcom/bytedance/android/livesdkapi/service/OpenParams;", "params", "openPortraitSimpleBarrageSettingDialog", "Lcom/bytedance/android/livesdkapi/service/IPreviewBarrageService;", "provideILivePreviewBarrageService", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BarrageService implements IBarrageService {
    public BarrageService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.b createBarrageContext() {
        return new BarrageWidgetContext();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public q82.b<q82.e, ShowCarnivalRedPacketEggResultModel> createShowCarnivalRedPacketEggMethod() {
        return new y52.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public q82.c<q82.f, ShowCarnivalTrayContentResultModel> createShowCarnivalTrayContentMethod() {
        return new y52.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget provideChatCarnivalWidget() {
        return new CarnivalDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget provideLandscapeBarrageWidget() {
        return new LandscapeZDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget provideLandscapeCarnivalWidget() {
        return new VSLandscapeCarnivalDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget providePortraitBarrageWidget() {
        return new PortraitZDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public AbsMergeWidget providePortraitSimpleBarrageWidget() {
        return new PortraitSimpleZDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Class<? extends Widget> provideCarnivalManagerWidget() {
        return CarnivalManagerServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public IPreviewBarrageService provideILivePreviewBarrageService() {
        return com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.a.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Class<? extends AbsMergeWidget> providePortraitSimpleBarrageWidgetClass() {
        return PortraitSimpleZDanmakuWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public void addBarrageToScreen(n22.d r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        q22.d r0 = new q22.d(r2);
        xs2.b.a().post(r0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public void openPortraitSimpleBarrageSettingDialog(Context r4, OpenParams r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        int r2 = SimpleZDanmakuSettingDialogFragment.i;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        FragmentActivity r6 = ContextUtil.contextToFragmentActivity(r4);
        if (r6 == null) goto L15;
        FragmentManager r7 = r6.getSupportFragmentManager();
        if (r7 == null) goto L16;
        SimpleZDanmakuSettingDialogFragment r0 = new SimpleZDanmakuSettingDialogFragment();
        r0.h = r5;
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "SimpleZDanmakuSettingDialogFragment", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r0, r8) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r0.show(r7, "SimpleZDanmakuSettingDialogFragment");
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public n22.c showLandscapeBarrageSettingDialog(Context r5, DataCenter r6, HashMap<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        int r0 = z52.b.K;
        ((BarrageSetting) l42.a.d.getValue()).setNeedRollback(((Boolean) l42.a.g.getValue()).booleanValue());
        HashMap r1 = new HashMap();
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L5;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r1);
    L5:
        if (r7 == null) goto L7;
        r1.put("position", r7.get("position"));
        r1.put("live_type", r7.get("live_type"));
    L7:
        j0.l().sendLog("livesdk_landscape_barrage_settings_click", r1, new Object[]{new x(), IRoom.class});
        IRoomContextService r8 = jc1.k.f(IRoomContextService.class);
        if (r8 != null) goto L10;
    L12:
        z52.b r9 = new z52.b(r5);
        Window r10 = r9.getWindow();
        if (r10 == null) goto L16;
        r10.setDimAmount(0.0f);
    L16:
        if (r9.isShowing() == true) goto L23;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r9);
        goto L23
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L21:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
    L23:
        return r9;
    L10:
        if (r8.getRoomDataContext(r6, 0).isVSRoom() != Boolean.TRUE) goto L12;
        int r11 = VSLiveLandscapeBarrageSettingDialog.m;
        VSLiveLandscapeBarrageSettingDialog.a.b(r5, r6, BuildConfig.FLAVOR);
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public void showVSLandscapeBarrageSettingDialog(Context r2, DataCenter r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        int r0 = VSLiveLandscapeBarrageSettingDialog.m;
        VSLiveLandscapeBarrageSettingDialog.a.b(r2, r3, r4);
    }
}
