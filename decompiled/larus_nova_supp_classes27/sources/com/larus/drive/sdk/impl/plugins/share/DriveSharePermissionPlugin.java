package com.larus.drive.sdk.impl.plugins.share;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.export.j;
import com.bytedance.ee.bear.share.export.l;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.base.share.n;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gk5.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/drive/sdk/impl/plugins/share/DriveSharePermissionPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/share/export/OnSharePanelListener;", "<init>", "()V", "sharePermissionHandler", "Lcom/larus/office/base/share/OfficeSharePermissionHandler;", "currentFileToken", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "onSharePanelChanged", "panel", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "state", "Lcom/bytedance/ee/bear/share/export/SharePanelState;", "params", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "resolveCurrentFileToken", "getShareUISdk", "Lcom/bytedance/ee/bear/share/export/IShareUISdk;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSharePermissionPlugin extends AbsDrivePlugin implements l {
    public static final a Companion = null;
    private static final String TAG = "DriveSharePermissionPlugin";
    private String currentFileToken;
    private final n sharePermissionHandler;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final j getShareUISdk() {
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L7;
        e r1 = r0.q0();
        if (r1 == null) goto L7;
        return r1.y5();
    L7:
        return null;
    }

    public DriveSharePermissionPlugin() {
        this.sharePermissionHandler = new n();
    }

    private final String resolveCurrentFileToken(DrivePluginHost r6) {
        BaseOpenEntity r0 = r6.c.getOpenEntity();
        boolean r1 = true;
        Object r3 = null;
        if (r0 == null) goto L38;
        String r2 = r0.getFileId();
        if (r2 == null) goto L38;
        String r4 = StringsKt.trim(r2).toString();
        if (r4 == null) goto L38;
        if (r4.length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L38;
        return r4;
    L11:
        r5 = false;
    L38:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L30
        String r8 = r6.c.getFileId();     // Catch: Throwable -> L30
        if (r8 == null) goto L27;
        String r9 = StringsKt.trim(r8).toString();     // Catch: Throwable -> L30
        if (r9 == null) goto L27;
        if (r9.length() > 0) goto L25;
        r1 = false;
    L25:
        if (r1 == false) goto L27;
    L28:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r10) == true) goto L37;
        r3 = r10;
    L37:
        return (String) r3;
    L27:
        r9 = null;
    L30:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        this.currentFileToken = resolveCurrentFileToken(r3);
        j r4 = getShareUISdk();
        if (r4 == null) goto L5;
        r4.R5(this);
        r4.ob(this);
    L6:
        FLogger.a.i(TAG, "onAttachToHost: register share panel listener");
        return;
    L5:
        FLogger.a.w(TAG, "onAttachToHost skipped: share ui sdk null");
        goto L6
    }

    public void onDetachFromHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        j r0 = getShareUISdk();
        if (r0 == null) goto L5;
        r0.R5(this);
    L5:
        this.currentFileToken = null;
        n r1 = this.sharePermissionHandler;
        monitor-enter(r1);
        r1.d = true;     // Catch: Throwable -> L12
        r1.b = false;     // Catch: Throwable -> L12
        r1.e = null;     // Catch: Throwable -> L12
        r1.f = null;     // Catch: Throwable -> L12
        monitor-exit(r1);
        FLogger.a.i(TAG, "onDetachFromHost: unregister share panel listener");
        super.onDetachFromHost(r4);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public void onSharePanelChanged(i r2, SharePanelState r3, km5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r3 == SharePanelState.SHOWING) goto L5;
        return;
    L5:
        String r5 = r4.c;
        if (r5 == null) goto L25;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.length() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == true) goto L16;
        r6 = null;
    L16:
        if (r6 != null) goto L19;
        return;
    L19:
        if (r4.b == 12) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(r6, this.currentFileToken) == false) goto L29;
        this.sharePermissionHandler.a(r6, r4.b);
        return;
    L29:
        return;
    L12:
        r7 = false;
        goto L13
    }
}
