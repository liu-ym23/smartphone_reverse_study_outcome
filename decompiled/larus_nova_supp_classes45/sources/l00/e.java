package l00;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.effectmanager.DownloadableModelSupportResourceFinder;
import com.ss.android.ugc.effectmanager.IFetchResourceListener;
import com.ss.android.ugc.effectmanager.knadapt.UseKNPlatform;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import java.net.URI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements IFetchResourceListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ d.a b;

    public e(com.bytedance.android.live.broadcast.api.camera.c r2) {
        this.a = "lens_taint_scene_detect";
        this.b = r2;
    }

    public final void onFailure(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "exception");
        this.b.onFail("fetchResourcesByRequirementsAndModelNames onFailure: " + Log.getStackTraceString(r4));
    }

    public final void onSuccess(long r3) {
    L21:
        e = move-exception;
        this.b.onFail("fetchResourcesByRequirementsAndModelNames success, but getResourceFinder appear exception " + e);
        return;
    L3:
        if (UseKNPlatform.enableKNPlatform == false) goto L5;
        String r4 = AlgorithmResourceManager.Companion.getInstance().getResourceFinder().findResourceUri(this.a);     // Catch: Exception -> L21
    L6:
        String r5 = "";
        String r6 = URI.create(r4).getPath();     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r6) == true) goto L14;
        if (new PolarisFileWrapper(r6).exists() == false) goto L14;
        r5 = r6;
    L14:
        if (r5.length() != 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
        this.b.onFail("fetchResourcesByRequirementsAndModelNames success, but tryGetFilePatch empty");     // Catch: Exception -> L21
        return;
    L19:
        this.b.onSuccess(r5);     // Catch: Exception -> L21
        return;
    L16:
        r7 = false;
        goto L17
    L5:
        r4 = DownloadableModelSupportResourceFinder.findResourceUri(null, this.a);     // Catch: Exception -> L21
        goto L6
    }
}
