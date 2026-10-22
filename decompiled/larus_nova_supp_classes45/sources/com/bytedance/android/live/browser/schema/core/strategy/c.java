package com.bytedance.android.live.browser.schema.core.strategy;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c {
    public final int a;

    public static final class a {
    }

    public interface b {
        c a(JSONObject r1);
    }

    static {
    }

    public abstract boolean a(JSONObject r1);

    public final int getType() {
        return this.a;
    }

    public c(int r1) {
        this.a = r1;
    }
}
