package com.bytedance.bdinstall.loader;

import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomLoader extends BaseLoader {
    private final InstallOptions mOptions;

    CustomLoader(InstallOptions r3) {
        super(false, true);
        this.mOptions = r3;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r5) {
        Map<String, Object> r4 = this.mOptions.getCommonHeader();
        if (r4 == null) goto L26;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L5:
        if (r4.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, Object>> r6 = r4.entrySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r6.hasNext() == false) goto L28;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        if (r1 == null) goto L8;
        r5.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r1.getValue());     // Catch: Exception -> L14
        goto L8
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }
}
