package com.ss.android.update;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import java.io.File;
import yhc.a;
import yhc.g;
import yhc.h;
import yhc.j0;
import yhc.l;
import yhc.p;
import yhc.u;
import yhc.v;
import yhc.w;
import yhc.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class UpdateServiceImpl implements UpdateService {
    private d mUpdateHelper;

    @Override // com.ss.android.update.UpdateService
    public void cancelDownload() {
        this.mUpdateHelper.h();
    }

    @Override // com.ss.android.update.UpdateService
    public void cancelNotifyAvai() {
        this.mUpdateHelper.i();
    }

    @Override // com.ss.android.update.UpdateService
    public void cancelNotifyReady() {
        this.mUpdateHelper.j();
    }

    @Override // com.ss.android.update.UpdateService
    public void exitUpdate() {
        this.mUpdateHelper.W();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean formalUpdateEnable() {
        int r0 = this.mUpdateHelper.T;
        if (r0 == 0) goto L8;
        if (r0 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    @Override // com.ss.android.update.UpdateService
    public String getDownloadingUrl() {
        d r0 = this.mUpdateHelper;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.k == true) goto L7;
        r0.U();     // Catch: Throwable -> L10
        r0.k = true;     // Catch: Throwable -> L10
    L7:
        String r1 = r0.l;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r1;
    }

    @Override // com.ss.android.update.UpdateService
    public Intent getIntentForLocalApp() {
        d r0 = this.mUpdateHelper;
        r0.getClass();
        p.b.a.getClass();
        if (p.d() == false) goto L12;
        Context r1 = r0.d;
        if (r1 == null) goto L13;
        PackageManager r2 = r1.getPackageManager();
        if (r0.p0 != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(null) == false) goto L11;
        return null;
    L11:
        return r2.getLaunchIntentForPackage(null);
    L13:
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.update.UpdateService
    public String getLastVersion() {
        return this.mUpdateHelper.z();
    }

    @Override // com.ss.android.update.UpdateService
    public int getLatency() {
        d r0 = this.mUpdateHelper;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.k == true) goto L7;
        r0.U();     // Catch: Throwable -> L10
        r0.k = true;     // Catch: Throwable -> L10
    L7:
        int r1 = Math.min(Math.max(r0.F, 0), 60);     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r1;
    }

    @Override // com.ss.android.update.UpdateService
    public int getOfficial() {
        return this.mUpdateHelper.C();
    }

    @Override // com.ss.android.update.UpdateService
    public int getPreDownloadDelayDays() {
        d r0 = this.mUpdateHelper;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.k == true) goto L7;
        r0.U();     // Catch: Throwable -> L10
        r0.k = true;     // Catch: Throwable -> L10
    L7:
        int r1 = r0.D;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r1;
    }

    @Override // com.ss.android.update.UpdateService
    public long getPreDownloadDelaySecond() {
        d r0 = this.mUpdateHelper;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.k == true) goto L7;
        r0.U();     // Catch: Throwable -> L10
        r0.k = true;     // Catch: Throwable -> L10
    L7:
        long r1 = r0.E;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r1;
    }

    @Override // com.ss.android.update.UpdateService
    public int getReleaseRuleId() {
        return this.mUpdateHelper.F();
    }

    @Override // com.ss.android.update.UpdateService
    public String getUpdateButtonText() {
        return this.mUpdateHelper.H();
    }

    @Override // com.ss.android.update.UpdateService
    public File getUpdateReadyApk() {
        return this.mUpdateHelper.I();
    }

    @Override // com.ss.android.update.UpdateService
    public String getUpdateTitle() {
        return this.mUpdateHelper.G();
    }

    @Override // com.ss.android.update.UpdateService
    public String getVerboseAppName() {
        AppCommonContext r0 = this.mUpdateHelper.s0;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getStringAppName();
    }

    @Override // com.ss.android.update.UpdateService
    public int getVersionCode() {
        d r0 = this.mUpdateHelper;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.k == true) goto L7;
        r0.U();     // Catch: Throwable -> L10
        r0.k = true;     // Catch: Throwable -> L10
    L7:
        int r1 = r0.n;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r1;
    }

    @Override // com.ss.android.update.UpdateService
    public String getWhatsNew() {
        return this.mUpdateHelper.K();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCanUpdate() {
        return this.mUpdateHelper.M(false);
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isClientStrategyEnable() {
        return this.mUpdateHelper.N();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCurrentVersionOut() {
        return this.mUpdateHelper.O();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isForceUpdate() {
        return this.mUpdateHelper.P();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isInstallAlphaApp() {
        p.b.a.getClass();
        return p.d();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isLocalApp() {
        d r0 = this.mUpdateHelper;
        if (r0 == null) goto L13;
        v r1 = r0.p0;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r1.h == false) goto L9;
        r2 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isRealCurrentVersionOut() {
        return this.mUpdateHelper.Q();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowUpdateDialog() {
        j0 r0 = j0.a.a;
        if (r0.b == false) goto L14;
        int r1 = r0.c.b("current_Strategy", 1);
        int r3 = r0.c.b("show_update_dialog_version", 0);
        int r6 = r0.a;
        if (r6 != r3) goto L7;
        c.k(UpdateService.REASON_NEW_STRATEGY_VERSION_IS_SAME);
        return false;
    L7:
        if (r1 != 1) goto L9;
        r0.c.c("show_update_dialog_version", r6);
    L12:
        return true;
    L9:
        int r2 = r0.c.b("version_code", 0);
        int r4 = r0.a;
        if ((r4 - r2) < r0.d) goto L13;
        r0.c.c("show_update_dialog_version", r4);
        goto L12
    L13:
        c.k(UpdateService.REASON_NEW_STRATEGY_INTERVAL_VERSION + (r0.a - r2));
        return false;
    L14:
        c.k(UpdateService.REASON_NEW_STRATEGY_NOT_ENABLE);
        return false;
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowingUpdateAvailDialog() {
        l r0 = this.mUpdateHelper.x0;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowingUpdateCheckDialog() {
        h r0 = this.mUpdateHelper.i0;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isUpdateApkPreDownloaded() {
        return this.mUpdateHelper.R();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isUpdating() {
        return this.mUpdateHelper.T();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean needPreDownload() {
        d r0 = this.mUpdateHelper;
        monitor-enter(r0);
        boolean r2 = true;
        if (r0.k == true) goto L8;
        r0.U();     // Catch: Throwable -> L15
        r0.k = true;     // Catch: Throwable -> L15
    L8:
        if (r0.C == false) goto L12;
        if (r0.p0.s == false) goto L12;
    L13:
        monitor-exit(r0);
        return r2;
    L12:
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.update.UpdateService
    public void startDownload() {
        this.mUpdateHelper.h0(false);
    }

    @Override // com.ss.android.update.UpdateService
    public void startPreDownload() {
        this.mUpdateHelper.i0(false);
    }

    public UpdateServiceImpl() {
        this.mUpdateHelper = d.x();
    }

    @Override // com.ss.android.update.UpdateService
    public void clickCloseAlphaButton(boolean r2) {
        this.mUpdateHelper.m(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickCloseButton(boolean r2) {
        this.mUpdateHelper.n(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickOpenAlphaButton(boolean r2) {
        this.mUpdateHelper.o(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickUpdateButton(boolean r2) {
        this.mUpdateHelper.p(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void getProgress(a r2) {
        this.mUpdateHelper.E(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCanUpdate(boolean r2) {
        return this.mUpdateHelper.M(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void noShowDialogEvent(String r1) {
        c.k(r1);
    }

    @Override // com.ss.android.update.UpdateService
    public String parseWhatsNew(String r2) {
        this.mUpdateHelper.getClass();
        return d.X(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void removeUpdateStatusListener(OnUpdateStatusChangedListener r2) {
        this.mUpdateHelper.Y(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void setAppExtra(String r2) {
        this.mUpdateHelper.z0 = r2;
    }

    @Override // com.ss.android.update.UpdateService
    public void setCheckSignature(boolean r2) {
        this.mUpdateHelper.a = r2;
    }

    @Override // com.ss.android.update.UpdateService
    public void setCustomUpdateAlphaDialog(g r2) {
        d r3 = this.mUpdateHelper;
        monitor-enter(r3);
        r3.getClass();     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateAlphaDialogScene(boolean r4) {
        d r0 = this.mUpdateHelper;
        r0.W = true;
        c.l(0);
        r0.Z(1, r4);
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateDialogScene(boolean r2) {
        this.mUpdateHelper.e0(r2);
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int r4, OnUpdateStatusChangedListener r5) {
        this.mUpdateHelper.g0(r4, 3, r5, true);
    }

    @Override // com.ss.android.update.UpdateService
    public void reportDialogInfo(int r2, boolean r3) {
        this.mUpdateHelper.Z(r2, r3);
    }

    @Override // com.ss.android.update.UpdateService
    public void setCustomUpdateDialog(l r2, h r3) {
        d r0 = this.mUpdateHelper;
        monitor-enter(r0);
        r0.h0 = r2;     // Catch: Throwable -> L7
        r0.i0 = r3;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int r3, OnUpdateStatusChangedListener r4, boolean r5) {
        this.mUpdateHelper.g0(r3, 3, r4, r5);
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateDialog(int r7, Context r8, boolean r9) {
        if (r7 != 2) goto L5;
    L40:
        d r10 = this.mUpdateHelper;
        if (r10.O() == false) goto L84;
        l r3 = r10.h0;
        if (r3 == null) goto L46;
        r10.x0 = r3;
    L51:
        if (r10.x0.d() == false) goto L53;
        return;
    L53:
        if (r8.getResources().getConfiguration().orientation != 2) goto L56;
        r10.n0.getUpdateConfig().getClass();
        c.k(UpdateService.REASON_NO_ORIENTAL_DIALOG);
        return;
    L56:
        if (r10.W == false) goto L59;
        c.k(UpdateService.REASON_OTHER_DIALOG_SHOWING);
        return;
    L59:
        if (r10.p0.h == true) goto L61;
    L73:
        r10.x0.b(r9);     // Catch: Exception -> L65
        r10.x0.a(r9);     // Catch: Exception -> L65
    L67:
        String r1 = r10.l;
        int r2 = r10.o;
        if (r9 == false) goto L70;
        String r11 = "auto";
    L71:
        c.m("test_invitation_popup_show", r1, r2, r11, -1, r10.v);
        return;
    L70:
        r11 = "trigger";
    L65:
        e = move-exception;
        c.k(e.toString());
        goto L67
    L61:
        if (p.b.a.e() == true) goto L73;
        c.k(UpdateService.REASON_LOCAL_OUT_OF_HOUSE);
        r10.x0 = null;
        return;
    L46:
        if (r10.n0.getUpdateConfig().j == false) goto L48;
        r10.x0 = new y(r8, r9);
        goto L51
    L48:
        r10.x0 = new w(r8, r9);
        goto L51
    L84:
        return;
    L5:
        if (r7 == (-2)) goto L40;
        if (r7 != 1) goto L10;
    L17:
        d r12 = this.mUpdateHelper;
        r12.getClass();
        j0.a.a.a();
        if (r12.Q() == true) goto L20;
        c.k(UpdateService.REASON_CHECK_VERSION_CODE_FAIL);
        return;
    L20:
        r12.g();
        d.X(r12.K());
        if (r12.W == false) goto L23;
        c.k(UpdateService.REASON_OTHER_DIALOG_SHOWING);
        return;
    L23:
        h r4 = r12.i0;
        if (r4 != null) goto L26;
        u r5 = r12.v0;
        if (r5 == null) goto L34;
        if (r5.isShowing() == true) goto L34;
        r12.v0 = null;
    L34:
        if (r12.v0 != null) goto L37;
        r12.v0 = new u(r8);
    L37:
        if (r12.v0.isShowing() == true) goto L39;
        r12.v0.a(1);
    L39:
        c.m("test_invitation_popup_show", r12.l, r12.o, "trigger", -1, r12.v);
        return;
    L26:
        if (r4.b() == true) goto L39;
        r4.a(1);
        goto L39
    L10:
        if (r7 == (-1)) goto L17;
        if (r7 != 3) goto L15;
    L16:
        this.mUpdateHelper.getClass();
        return;
    L15:
        if (r7 == (-3)) goto L16;
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int r2, int r3, OnUpdateStatusChangedListener r4, boolean r5) {
        this.mUpdateHelper.g0(r2, r3, r4, r5);
    }
}
