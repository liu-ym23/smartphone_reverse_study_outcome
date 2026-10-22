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
    protected boolean doLoad(JSONObject r10) {
        StringBuilder r11 = new StringBuilder(16);
        if (RomUtils.isMiui() == false) goto L7;
        String r12 = "MIUI-";
    L5:
        r11.append(r12);
    L14:
        r11.append(Build.VERSION.INCREMENTAL);
        r10.put(Api.KEY_ROM, r11.toString());
        String r13 = RomUtils.getRomInfo();
        if (TextUtils.isEmpty(r13) == true) goto L19;
        r10.put("rom_version", r13);
        return true;
    L19:
        return true;
    L7:
        if (RomUtils.isFlyme() == false) goto L9;
        r12 = "FLYME-";
        goto L5
    L9:
        String r14 = RomUtils.getEmuiInfo();
        if (RomUtils.isHwOrHonor(r14) == false) goto L14;
        r11.append("EMUI-");
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r11.append(r14);
        r12 = "-";
        goto L5
    }
}
