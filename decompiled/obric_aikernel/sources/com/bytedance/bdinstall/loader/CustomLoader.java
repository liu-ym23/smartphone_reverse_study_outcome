package com.bytedance.bdinstall.loader;

import com.bytedance.bdinstall.InstallOptions;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomLoader extends BaseLoader {
    private final InstallOptions mOptions;

    CustomLoader(InstallOptions r10) {
        super(false, true);
        this.mOptions = r10;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        Map<String, Object> r11 = this.mOptions.getCommonHeader();
        if (r11 == null) goto L26;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L5:
        if (r11.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, Object>> r12 = r11.entrySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r12.hasNext() == false) goto L28;
        Map.Entry<String, Object> r13 = r12.next();     // Catch: Exception -> L14
        if (r13 == null) goto L8;
        r10.put(r13.getKey(), r13.getValue());     // Catch: Exception -> L14
        goto L8
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }
}
