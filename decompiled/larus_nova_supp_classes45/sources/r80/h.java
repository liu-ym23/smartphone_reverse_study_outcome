package r80;

import android.content.Context;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements com.bytedance.android.live.core.utils.screen.a {
    public static final List<String> a = null;

    public h() {
    }

    static {
        a = Arrays.asList(new String[]{"ONEPLUS A6000"});
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r2) {
        return a.contains(Build.MODEL);
    }
}
