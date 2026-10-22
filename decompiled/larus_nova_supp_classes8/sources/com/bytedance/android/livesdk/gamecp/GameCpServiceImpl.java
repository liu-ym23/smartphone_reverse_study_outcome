package com.bytedance.android.livesdk.gamecp;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.bytedance.android.livesdkapi.gamecp.IGameCpService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J,\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001bH\u0016J.\u0010\u001c\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010 \u001a\u00020\u0015*\u0004\u0018\u00010!H\u0002¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/GameCpServiceImpl;", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService;", "()V", "action", "", "context", "Landroid/content/Context;", "params", "Lcom/google/gson/JsonObject;", "logParams", "cancelDownload", "createGamePromoteDetailDialog", "Landroidx/appcompat/app/AppCompatDialogFragment;", "gameDetailData", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$GameDetailData;", "dismissListener", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDetailDialogDismissListener;", "genDownloadToken", "", "getDownloadList", "status", "", "callback", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IDownloadListCallback;", "logMonitorLinkEvent", "scene", "eventName", "", "subscribeDownloadGame", "listener", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDownloadListener;", "unSubscribeDownloadGame", "optString", "Lcom/google/gson/JsonElement;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public class GameCpServiceImpl implements IGameCpService {

    public static final class a implements dw.e {
        public final /* synthetic */ Context a;
        public final /* synthetic */ JsonObject b;
        public final /* synthetic */ JsonObject c;

        public final void onGranted() {
            boolean r0 = kv.a.a;
            xr.f r1 = kv.a.b();
            if (r1 == null) goto L8;
            xr.b r2 = r1.p1();
            if (r2 == null) goto L9;
            r2.X0(this.a, this.b, this.c);
            return;
        L9:
            return;
        }

        public a(Context r1, JsonObject r2, JsonObject r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements com.bytedance.android.gamecp.base.core.service.depend.l {
        public final /* synthetic */ IGameCpService.IGameDetailDialogDismissListener a;

        public final void onDismiss() {
            IGameCpService.IGameDetailDialogDismissListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onDismiss();
            return;
        }

        public b(IGameCpService.IGameDetailDialogDismissListener r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.android.gamecp.base.core.service.depend.c {
        public final /* synthetic */ IGameCpService.IDownloadListCallback a;

        public c(IGameCpService.IDownloadListCallback r1) {
            this.a = r1;
        }

        public final void onResult(JSONObject r2) {
            IGameCpService.IDownloadListCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.get(r2);
            return;
        }
    }

    public static final class d implements com.bytedance.android.gamecp.base.core.service.depend.n {
        public final /* synthetic */ IGameCpService.IGameDownloadListener a;

        public final void onInstallFailed(int r1) {
        }

        public final void onJumpInstall(int r1) {
        }

        public final void passThrough(int r1) {
        }

        public final void onCancel() {
            IGameCpService.IGameDownloadListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onCancel();
            return;
        }

        public final void onReady() {
            IGameCpService.IGameDownloadListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onReady();
            return;
        }

        public final void onUpdate() {
            IGameCpService.IGameDownloadListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onUpdate();
            return;
        }

        public d(IGameCpService.IGameDownloadListener r1) {
            this.a = r1;
        }

        public final void onDownloaded(String r2) {
            IGameCpService.IGameDownloadListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onDownloaded(r2);
            return;
        }

        public final void onError(int r2) {
            IGameCpService.IGameDownloadListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onError(r2);
            return;
        }

        public final void onInstalled(com.bytedance.android.gamecp.base.core.service.depend.v r2) {
            Intrinsics.checkNotNullParameter(r2, "installedFinishData");
            IGameCpService.IGameDownloadListener r3 = this.a;
            if (r3 == null) goto L6;
            r3.onInstalled();
            return;
        }

        public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r2) {
            Intrinsics.checkNotNullParameter(r2, "progressData");
            IGameCpService.IGameDownloadListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onPause(r2.a);
            return;
        }

        public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r5) {
            Intrinsics.checkNotNullParameter(r5, "progressData");
            IGameCpService.ProgressData r0 = new IGameCpService.ProgressData(r5.a, r5.b, r5.c, r5.d);
            IGameCpService.IGameDownloadListener r6 = this.a;
            if (r6 == null) goto L6;
            r6.onProgress(r0);
            return;
        }
    }

    public GameCpServiceImpl() {
    }

    public int genDownloadToken() {
        boolean r0 = kv.a.a;
        xr.f r1 = kv.a.b();
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.genDownloadToken();
    }

    private final String optString(JsonElement r3) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        String r4 = r3.getAsString();     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == true) goto L15;
        r0 = r5;
    L15:
        String r2 = (String) r0;
        if (r2 != null) goto L21;
        return "";
    L21:
        return r2;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public void action(Context r4, JsonObject r5, JsonObject r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        bw.e r0 = com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService();
        String r1 = optString(r5.get("gameId"));
        Integer r2 = StringsKt.toIntOrNull(optString(r5.get("downloadStatus")));
        if (r2 == null) goto L5;
        r2.intValue();
    L5:
        r0.f0(r1, new a(r4, r5, r6));
    }

    public void cancelDownload(Context r1, JsonObject r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        boolean r4 = kv.a.a;
        xr.f r5 = kv.a.b();
        if (r5 == null) goto L6;
        r5.cancelDownloadGame(r1, r2);
        return;
    }

    public AppCompatDialogFragment createGamePromoteDetailDialog(IGameCpService.GameDetailData r3, JsonObject r4, IGameCpService.IGameDetailDialogDismissListener r5) {
        Intrinsics.checkNotNullParameter(r3, "gameDetailData");
        com.bytedance.android.gamecp.base.core.service.depend.a r0 = new com.bytedance.android.gamecp.base.core.service.depend.a();
        r0.a = r3.getGameId();
        r0.b = r3.getAttributionId();
        r0.c = "3";
        boolean r6 = kv.a.a;
        xr.f r7 = kv.a.b();
        if (r7 != null) goto L7;
        return null;
    L7:
        return r7.a2(r0, r4, new b(r5));
    }

    public void logMonitorLinkEvent(int r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        boolean r0 = kv.a.a;
        xr.f r1 = kv.a.b();
        if (r1 == null) goto L6;
        r1.logMonitorLinkEvent(r3, r4, r5, true);
        return;
    }

    public void unSubscribeDownloadGame(Context r1, JsonObject r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        boolean r4 = kv.a.a;
        xr.f r5 = kv.a.b();
        if (r5 == null) goto L6;
        r5.N0(r2);
        return;
    }

    public void getDownloadList(Context r1, String r2, JsonObject r3, IGameCpService.IDownloadListCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        boolean r5 = kv.a.a;
        xr.f r6 = kv.a.b();
        if (r6 == null) goto L6;
        r6.r2(r2, new c(r4));
        return;
    }

    public void subscribeDownloadGame(Context r1, JsonObject r2, JsonObject r3, IGameCpService.IGameDownloadListener r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        boolean r5 = kv.a.a;
        xr.f r6 = kv.a.b();
        if (r6 == null) goto L6;
        r6.C1(r2, new d(r4));
        return;
    }
}
