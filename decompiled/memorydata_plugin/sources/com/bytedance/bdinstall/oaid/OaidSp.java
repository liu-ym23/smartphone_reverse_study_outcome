package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.Utils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class OaidSp {
    private static final String KEY_OAID = "oaid";
    private static final String SP_FILE = "device_register_oaid_refine";
    private final SharedPreferences sp;

    OaidSp(Context r3) {
        this.sp = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(SP_FILE, 0);
    }

    public void clear() {
        Utils.removeSpValues(this.sp, new String[]{"oaid"});
    }

    OaidModel fetch() {
        return OaidModel.create(this.sp.getString("oaid", ""));
    }

    void save(OaidModel r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.sp.edit().putString("oaid", r2.toJson().toString()).apply();
    }
}
