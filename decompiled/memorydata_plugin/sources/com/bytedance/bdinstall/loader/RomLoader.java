package com.bytedance.bdinstall.loader;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.util.RomUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class RomLoader extends BaseLoader {
    RomLoader() {
        super(true, false);
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r3) {
        StringBuilder r2 = new StringBuilder(16);
        if (RomUtils.isMiui() == false) goto L7;
        String r0 = "MIUI-";
    L5:
        r2.append(r0);
    L14:
        r2.append(Build.VERSION.INCREMENTAL);
        r3.put(Api.KEY_ROM, r2.toString());
        String r4 = RomUtils.getRomInfo();
        if (TextUtils.isEmpty(r4) == true) goto L19;
        r3.put("rom_version", r4);
        return true;
    L19:
        return true;
    L7:
        if (RomUtils.isFlyme() == false) goto L9;
        r0 = "FLYME-";
        goto L5
    L9:
        String r1 = RomUtils.getEmuiInfo();
        if (RomUtils.isHwOrHonor(r1) == false) goto L14;
        r2.append("EMUI-");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r2.append(r1).append("-");
        goto L14
    }
}
