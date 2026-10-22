package com.bytedance.android.live.broadcastgame;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.livesdkapi.openplatform.IOpenPlatformGameService;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ2\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R0\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/OpenPlatformGameService;", "Lcom/bytedance/android/livesdkapi/openplatform/IOpenPlatformGameService;", "Landroid/content/Context;", "context", "", OpenPlatformBaseDebugger.DEVELOP, "appId", "appName", "", "isLandscape", "Landroid/app/Dialog;", "openOuterGameReport", "openOuterGameFeedback", "Lkotlin/Function0;", "", "onCertificate", "Lio/reactivex/disposables/Disposable;", "openCertificatePage", "Lcom/bytedance/android/live/broadcastgame/f0;", "<set-?>", "openPlatformService", "Lcom/bytedance/android/live/broadcastgame/f0;", "getOpenPlatformService", "()Lcom/bytedance/android/live/broadcastgame/f0;", "setOpenPlatformService", "(Lcom/bytedance/android/live/broadcastgame/f0;)V", "<init>", "()V", "Companion", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformGameService implements IOpenPlatformGameService {
    public static final a Companion = null;
    private static final i10.h diComponent = null;
    private f0 openPlatformService;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        diComponent = new i10.f(new i10.b(), new i10.c(), new p10.a(), new i10.a());
    }

    public OpenPlatformGameService() {
        setOpenPlatformService((f0) ((i10.f) diComponent).d.get());
    }

    public static final /* synthetic */ i10.h access$getDiComponent$cp() {
        return diComponent;
    }

    public final f0 getOpenPlatformService() {
        return this.openPlatformService;
    }

    @Inject
    public final void setOpenPlatformService(f0 r1) {
        this.openPlatformService = r1;
    }

    public Disposable openCertificatePage(Context r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onCertificate");
        f0 r0 = this.openPlatformService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.openCertificatePage(r2, r3);
    }

    public Dialog openOuterGameFeedback(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        f0 r0 = this.openPlatformService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.openOuterGameFeedback(r2, r3);
    }

    public Dialog openOuterGameReport(Context r8, String r9, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, OpenPlatformBaseDebugger.DEVELOP);
        Intrinsics.checkNotNullParameter(r11, "appId");
        Intrinsics.checkNotNullParameter(r12, "appName");
        f0 r1 = this.openPlatformService;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.openOuterGameReport(r8, r9, r11, r12, r13);
    }
}
