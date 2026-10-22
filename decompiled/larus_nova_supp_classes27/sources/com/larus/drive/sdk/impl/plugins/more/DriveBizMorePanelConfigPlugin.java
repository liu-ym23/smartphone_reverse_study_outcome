package com.larus.drive.sdk.impl.plugins.more;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.ability.DriveMorePanelOpenResult;
import com.bytedance.ee.bear.drive.ability.IDriveMorePanelPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.larus.office.c;
import com.larus.office.h;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/larus/drive/sdk/impl/plugins/more/DriveBizMorePanelConfigPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/larus/office/IHostStateListener;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onMoreButtonClicked", "", "findMorePanelAbility", "Lcom/bytedance/ee/bear/drive/ability/IDriveMorePanelPlugin;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveBizMorePanelConfigPlugin extends AbsDrivePlugin implements c {
    public static final a Companion = null;
    private static final String TAG = "DriveBizMorePanelConfigPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void onActionButtonVisibilityChanged(boolean r1) {
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onChatListFoldStatusChanger(boolean r1) {
    }

    public void onNewOfficePageCreated() {
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void onReferenceCleared() {
    }

    public boolean onMoreButtonClicked() {
        DrivePluginHost r0 = (DrivePluginHost) getHost();
        if (r0 != null) goto L6;
        FLogger.a.i(TAG, "onMoreButtonClicked: host is null, skip open panel");
        return false;
    L6:
        IDriveMorePanelPlugin<?> r1 = findMorePanelAbility(r0);
        if (r1 == null) goto L9;
        DriveMorePanelOpenResult r2 = r1.openMorePanel(new w45.a("external"));
    L10:
        FLogger.a.i(TAG, "onMoreButtonClicked: openMorePanel result=" + r2);
        if (r2 != DriveMorePanelOpenResult.SUCCESS) goto L14;
        return true;
    L14:
        return false;
    L9:
        r2 = null;
        goto L10
    }

    public DriveBizMorePanelConfigPlugin() {
    }

    private final IDriveMorePanelPlugin<?> findMorePanelAbility(DrivePluginHost r2) {
        return r2.findPlugin(IDriveMorePanelPlugin.class);
    }

    public void onAttachToHost(final DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        IDriveMorePanelPlugin<?> r0 = findMorePanelAbility(r4);
        if (r0 != null) goto L17;
        FLogger.a.i(TAG, "onAttachToHost: IDriveMorePanelPlugin not found, skip apply config");
        return;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r0.registerMoreConfig(new j89.a(r4));     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r5) == false) goto L13;
        Unit r1 = (Unit) r5;
        FLogger.a.i(TAG, "onAttachToHost: drive more config applied");
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L19;
        FLogger.a.e(TAG, "onAttachToHost: apply drive more config failed", r6);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public void onDetachFromHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        IDriveMorePanelPlugin<?> r1 = findMorePanelAbility(r5);     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.unregisterMoreConfig();     // Catch: Throwable -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L14;
        FLogger.a.e(TAG, "onDetachFromHost: unregister drive more config failed", r4);
    L14:
        super.onDetachFromHost(r5);
        return;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public boolean shouldSuppressFlowMessagePush(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return false;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        if (r2 == null) goto L7;
        h r4 = r2.getHostAbilityOrNull(h.class);
        if (r4 == null) goto L7;
        r4.S9(this);
    L7:
        FLogger.a.i(TAG, "onAttachToUIContainer: register host state listener");
    }

    public void onDetachFromUIContainer(DrivePluginHost r4, t r5) {
        if (r4 == null) goto L6;
        h r0 = r4.getHostAbilityOrNull(h.class);
        if (r0 == null) goto L6;
        r0.V5(this);
    L6:
        FLogger.a.i(TAG, "onDetachFromUIContainer: unregister host state listener");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r4, r5);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }
}
