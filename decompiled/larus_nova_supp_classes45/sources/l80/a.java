package l80;

import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class a implements ttc.b {
    public /* synthetic */ a() {
    }

    public final boolean getAsBoolean() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }
}
