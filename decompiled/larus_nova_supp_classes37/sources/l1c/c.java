package l1c;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void a() {
        b r0 = this.a;
        com.ss.android.lark.storage.kv.repo.c r1 = r0.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");
        r1 = null;
    L5:
        String r2 = r1.getString("user_task_hit_rate", null);
        if (TextUtils.isEmpty(r2) == false) goto L14;
        Log.i("Detector/PreloadHitRateDetector", "initLastTaskHitRate is empty!");
        return;
    L14:
        r0.e = (HashMap) new Gson().fromJson(r2, HashMap.class);     // Catch: Exception -> L10
    L12:
        Log.i("Detector/PreloadHitRateDetector", "initLastTaskHitRate:" + r0.e);
        return;
    L10:
        e = move-exception;
        Log.d("Detector/PreloadHitRateDetector", "initLastTaskHitRate error:" + e.getMessage());
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
