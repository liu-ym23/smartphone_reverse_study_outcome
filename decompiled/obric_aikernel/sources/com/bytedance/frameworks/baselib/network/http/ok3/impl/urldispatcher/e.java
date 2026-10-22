package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends DispatchStrategy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f1826d = "e";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f1827c;

    static {
    }

    public e(JSONObject r10) {
        super(DispatchStrategy.DispatchStrategyType.STATIC_DISPATCH_STRATEGY);
        this.f1827c = new HashMap();
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<String> r11 = r10.keys();
    L7:
        if (r11.hasNext() == false) goto L13;
        String r12 = r11.next();
        String r13 = r10.optString(r12);
        if (TextUtils.isEmpty(r12) == true) goto L7;
        if (TextUtils.isEmpty(r13) == true) goto L7;
        this.f1827c.put(r12, r13);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void a(y2.c r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String d(Uri r10) {
        String r11 = r10.getHost();
        String r12 = r10.toString();
        String r13 = this.f1827c.get(r11);
        if (TextUtils.isEmpty(r13) == false) goto L5;
        return r12;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d(f1826d, "replace host " + r13 + " for " + r11);
    L8:
        return r12.replaceFirst(r11, r13);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean e() {
        return false;
    }
}
