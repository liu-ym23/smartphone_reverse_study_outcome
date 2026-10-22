package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.Utils;

/* JADX INFO: loaded from: classes.dex */
final class OaidSp {
    private static final String KEY_OAID = "oaid";
    private static final String SP_FILE = "device_register_oaid_refine";
    private final SharedPreferences sp;

    @WorkerThread
    OaidSp(Context r10) {
        this.sp = r10.getSharedPreferences(SP_FILE, 0);
    }

    public void clear() {
        Utils.removeSpValues(this.sp, new String[]{"oaid"});
    }

    @Nullable
    @WorkerThread
    OaidModel fetch() {
        return OaidModel.create(this.sp.getString("oaid", ""));
    }

    @WorkerThread
    void save(@Nullable OaidModel r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.sp.edit().putString("oaid", r10.toJson().toString()).apply();
    }
}
