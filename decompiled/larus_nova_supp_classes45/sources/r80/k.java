package r80;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements com.bytedance.android.live.core.log.c {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return Build.MODEL + " is fold screen!";
    }
}
