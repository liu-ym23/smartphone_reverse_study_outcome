package y4a;

import android.net.Uri;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static String a(String r2) {
        return new Uri.Builder().scheme("asset").authority(NameKeys.UnloadStrategy_No_Strategy).path(r2).build().toString();
    }
}
