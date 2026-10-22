package ff0;

import android.util.Log;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.ss.android.ugc.effectmanager.IFetchResourceListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements IFetchResourceListener {
    public j() {
    }

    public final void onFailure(Exception r8) {
        Intrinsics.checkNotNullParameter(r8, "exception");
        d r0 = d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "down_load_lip_sync_model_result", -1, Log.getStackTraceString(r8), null, 16);
    }

    public final void onSuccess(long r7) {
        HamletAvatarContext r8 = HamletAvatarContext.Companion.getContext();     // Catch: Exception -> L9
        if (r8 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r9 = r8.isLipSyncModelDownloaded();     // Catch: Exception -> L9
        if (r9 == null) goto L7;
        r9.setValue(Boolean.TRUE);     // Catch: Exception -> L9
    L7:
        d r10 = d.a;     // Catch: Exception -> L9
        com.bytedance.android.live.liveinteract.utils.j.a(1, "down_load_lip_sync_model_result", 0, null, null, 24);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        d r11 = d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "down_load_lip_sync_model_result", -1, Log.getStackTraceString(e), null, 16);
    }
}
