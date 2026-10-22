package anb;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements rza.a {
    public a() {
    }

    public final void w0(Context r2, ActivityResultLauncher<String> r3, ActivityResultLauncher<Intent> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pickLauncher");
        Intrinsics.checkNotNullParameter(r4, "pickSDKLauncher");
        Log.i("pickAvatar");
    }
}
