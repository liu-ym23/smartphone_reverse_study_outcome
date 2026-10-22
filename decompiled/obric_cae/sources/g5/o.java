package g5;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7676a;

    public o(Context r8) {
        this.f7676a = r8.getSharedPreferences("device_register_oaid_refine", 0);
    }
}
