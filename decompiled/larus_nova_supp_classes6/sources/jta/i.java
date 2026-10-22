package jta;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import kta.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i {
    public String a;
    public final SharedPreferences b;

    public i(Context r3) {
        new Handler(Looper.getMainLooper());
        this.a = "";
        this.b = r3.getSharedPreferences(b.a, 0);
    }
}
