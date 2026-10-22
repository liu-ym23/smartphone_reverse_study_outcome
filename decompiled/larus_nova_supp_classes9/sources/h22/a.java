package h22;

import com.bytedance.android.livesdkapi.util.ILivePreInflateService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a implements ILivePreInflateService {
    private Map<String, Integer> themeMap;

    public a() {
        this.themeMap = new HashMap();
    }

    public int getHostActivityTheme(String r2) {
        Integer r3 = this.themeMap.get(r2);
        if (r3 != null) goto L5;
        return -1;
    L5:
        return r3.intValue();
    }

    public void initHostActivityTheme(Map<String, Integer> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        this.themeMap.putAll(r2);
        return;
    }
}
