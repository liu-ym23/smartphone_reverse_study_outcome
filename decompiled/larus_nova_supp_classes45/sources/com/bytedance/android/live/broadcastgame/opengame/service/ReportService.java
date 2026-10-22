package com.bytedance.android.live.broadcastgame.opengame.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportDialog;
import com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportDialogV1;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.bd1;
import com.bytedance.android.livesdk.config.he0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.live.datacontext.j;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00012\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/ReportService;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReportService implements y10.a, com.bytedance.android.live.broadcastgame.opengame.panel.i, p {
    public final boolean a;
    public final Lazy b;
    public WeakReference<OpenGameReportDialog> c;
    public WeakReference<OpenGameReportDialogV1> d;
    public final PluginContext e;
    public final /* synthetic */ i20.a f;

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        LruCache<String, byte[]> r0 = ReportPicUploader.a;
        boolean r1 = this.a;
        ReportPicUploader.d().clear();
        ReportPicUploader.d = "";
        ReportPicUploader.e = "";
        if (r1 == false) goto L5;
        int r2 = ((bd1) he0.a.getValue()).anchorMaximumCount;
    L6:
        ReportPicUploader.a = new LruCache(r2);
        return;
    L5:
        r2 = ((bd1) he0.a.getValue()).audienceMaximumCount;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportDialogV1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog, java.lang.Object] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        LruCache<String, byte[]> r0 = ReportPicUploader.a;
        ReportPicUploader.d().clear();
        ReportPicUploader.d = "";
        ReportPicUploader.e = "";
        ReportPicUploader.a.evictAll();
        WeakReference<OpenGameReportDialog> r1 = this.c;
        if (r1 == null) goto L7;
        OpenGameReportDialog r2 = r1.get();
        if (r2 == null) goto L7;
        r2.b = 3;
        r2.finish();
    L7:
        WeakReference<OpenGameReportDialogV1> r3 = this.d;
        if (r3 == null) goto L47;
        OpenGameReportDialogV1 r4 = r3.get();
        if (r4 == 0) goto L47;
        r4.a = 3;
        ?? r5 = r4.d;
        if (r5 == 0) goto L30;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r5);
        goto L30
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r7 == null) goto L27;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L16:
        if (Looper.myLooper() == r6.getLooper()) goto L18;
        r6.post(DialogLancet.createDismissRunnable(r5));
    L30:
        Handler r8 = DialogLancet.resolveDialogHandler(r4);
        if (r8 != null) goto L33;
    L35:
        DialogLancet.beforeDialogDismiss(r4);
        r4.dismiss();     // Catch: Throwable -> L38 Exception -> L40
    L44:
        DialogLancet.afterDialogDismiss(r4);
        goto L47
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L38
        Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L38
        if (r9 == null) goto L44;
        com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r4);
        throw th;
    L33:
        if (Looper.myLooper() == r8.getLooper()) goto L35;
        r8.post(DialogLancet.createDismissRunnable(r4));
    L47:
        this.f.b();
    }

    public ReportService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.f = new i20.a();
        this.e = r2;
        this.a = r2.o;
        this.b = LazyKt.lazy(new ReportService$roomContext$2(this));
    }

    /* JADX WARN: Type inference failed for: r1v24, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportDialogV1, java.lang.Object] */
    public final void d(boolean r8) {
        HashMap r0 = new HashMap();
        r0.put("user_id", String.valueOf(k.n(IUserService.class).user().b().getIdString()));
        r0.put("room_id", String.valueOf(this.e.m.a));
        r0.put("program_id", this.e.m.i);
        r0.put("program_name", this.e.m.b(this.a));
        if (this.a == false) goto L5;
        String r1 = "anchor";
    L6:
        r0.put("user_type", r1);
        u.l().sendLog("livesdk_open_platform_report_click", r0, new Object[0]);
        if (this.e.m() != PluginType.MINI_APP) goto L9;
        int r9 = OpenGameReportDialog.m;
        Context r11 = this.e.getContext();
        PluginContext r2 = this.e;
        t r3 = r2.m;
        boolean r4 = r2.o;
        Function1<OpenGameReportDialog, Unit> r5 = new ReportService$showReportDialog$1(this);
        Intrinsics.checkNotNullParameter(r11, "ctx");
        Intrinsics.checkNotNullParameter(r3, "pluginInfo");
        Intrinsics.checkNotNullParameter(r5, "callback");
        jc1.a.b().registerActivityLifecycleCallbacks(new com.bytedance.android.live.broadcastgame.opengame.dialog.a(r5));
        Intent r6 = new Intent(r11, OpenGameReportDialog.class);
        r6.putExtra(OpenPlatformBaseDebugger.DEVELOP, r3.b);
        r6.putExtra("room_id", r3.a);
        r6.putExtra("is_anchor", r4);
        r6.putExtra("plugin_type", r3.o.getValue());
        r6.putExtra(OpenPlatformBaseDebugger.APP_ID, r3.i);
        r6.putExtra("app_name", r3.b(r4));
        Unit r7 = Unit.INSTANCE;
        r11.startActivity(r6);
    L20:
        if (this.a == false) goto L28;
        ReportService$catchVideoShot$1 r12 = ReportService$catchVideoShot$1.INSTANCE;
        Bundle r13 = new Bundle();
        r13.putInt("mode", 1);
        r13.putBoolean("outputPixelBufferOrigin", false);
        r13.putBoolean("outputPixelBufferWithEffect", true);
        r13.putInt("frameCount", 1);
        r13.putBoolean("keepVideoCatcherAlive", true);
        RoomContext r14 = (RoomContext) this.b.getValue();
        if (r14 == null) goto L39;
        j r15 = r14.getLiveStream();
        if (r15 == null) goto L40;
        com.bytedance.android.live.pushstream.d r16 = (com.bytedance.android.live.pushstream.d) r15.getValue();
        if (r16 == null) goto L41;
        r16.F0(r13, new g(r16, r12));
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L28:
        RoomContext r17 = (RoomContext) this.b.getValue();
        if (r17 == null) goto L43;
        WeakReference r18 = r17.getPlayerViewRef();
        if (r18 == null) goto L44;
        AbsLivePlayerView r19 = (AbsLivePlayerView) r18.get();
        if (r19 == null) goto L45;
        r19.saveFrame(ReportService$catchVideoShot$2.INSTANCE);
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L9:
        PanelType.a r21 = PanelType.Companion;
        PanelType r22 = this.e.j();
        r21.getClass();
        if (PanelType.a.a(r22) == false) goto L12;
        Context r23 = this.e.i();
    L13:
        ?? r24 = new OpenGameReportDialogV1(r23, this.e.m, this.a, r8);
        r24.setOnDismissListener(new h(r24, this));
        if (DialogLancet.shouldBlockDialogShow(r24) == false) goto L37;
        DialogLancet.handleBlockedDialogShow(r24);
    L18:
        Unit r25 = Unit.INSTANCE;
        this.d = new WeakReference(r24);
        goto L20
    L37:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L17:
        DialogLancet.beforeDialogShow(r24);
        r24.show();
        DialogLancet.afterDialogShow(r24);
        goto L18
    L12:
        r23 = this.e.getContext();
        goto L13
    L5:
        r1 = "user";
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r1) {
        this.e.m();
        PluginType r2 = PluginType.LYNX;
    }
}
