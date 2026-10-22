package r0c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static void a(Context r3, String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L11;
        Log.e("PhotoEditorOutputDelegate", "image path is empty");
        return;
    L11:
        Activity r6 = Contexts.requireActivity(r3);     // Catch: Exception -> L8
        Intent r0 = new Intent();     // Catch: Exception -> L8
        r0.putExtra(r4, true);     // Catch: Exception -> L8
        r0.putExtra("key_result_path", r5);     // Catch: Exception -> L8
        r6.setResult(-1, r0);     // Catch: Exception -> L8
        r6.finish();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("PhotoEditorOutputDelegate", "failed to return output result", e);
    }
}
