package fmb;

import com.bytedance.ee.bear.appsetting.RepositoryPriority;
import com.bytedance.ee.bear.appsetting.m;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements m {
    public final Map<String, Boolean> a;

    public static final class a {
    }

    static {
    }

    public final String getString(String r1) {
        return "";
    }

    public final void c() {
        JSONObject r0 = new JSONObject(SettingManager.getInstance().getSettingConfig("ccm_doubao_feature_gating", true));     // Catch: Exception -> L7
        Iterator<String> r1 = r0.keys();     // Catch: Exception -> L7
    L4:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();     // Catch: Exception -> L7
        this.a.put(r2, Boolean.valueOf(r0.optBoolean(r2, false)));     // Catch: Exception -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        tt5.a.i("DoubaoFGRepository", "beginSync", e);
        e.printStackTrace();
    }

    public final int getPriority() {
        return RepositoryPriority.DOU_BAO.ordinal();
    }

    public final void onClear() {
        ((LinkedHashMap) this.a).clear();
    }

    public b() {
        this.a = new LinkedHashMap();
        c();
    }

    public final boolean a(String r1, Class<?> r2) {
        return this.a.containsKey(r1);
    }

    public final boolean b(String r1, boolean r2, boolean r3) {
        Boolean r4 = Boolean.valueOf(r2);
        return ((Boolean) ((LinkedHashMap) this.a).getOrDefault(r1, r4)).booleanValue();
    }
}
