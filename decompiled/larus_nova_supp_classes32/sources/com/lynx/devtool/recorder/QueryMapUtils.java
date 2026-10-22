package com.lynx.devtool.recorder;

import android.net.Uri;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class QueryMapUtils {
    private final String TAG;
    private HashMap<String, String> mQuery;

    public HashMap<String, String> toMap() {
        HashMap<String, String> r0 = new HashMap();
        r0.putAll(this.mQuery);
        return r0;
    }

    public QueryMapUtils() {
        this.TAG = getClass().toString();
        this.mQuery = new HashMap();
    }

    private String getQueryStringFromUrl(String r2) {
        if (r2.contains("?") == true) goto L5;
        return null;
    L5:
        return r2.split("\\?")[1];
    }

    private void saveQueryToMap(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.isEmpty() == true) goto L19;
        String[] r8 = r7.split("&");
        int r0 = r8.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L20;
        String[] r3 = r8[r2].split("=");
        if (r3.length < 2) goto L14;
        String r4 = r3[0];
        String r5 = r3[1];
        if (r5.startsWith("http") == false) goto L13;
        r5 = Uri.decode(r5);
    L13:
        this.mQuery.put(r4, r5);
    L14:
        r2 = r2 + 1;
        goto L7
    L20:
        return;
    }

    public boolean contains(String r2) {
        return this.mQuery.containsKey(r2);
    }

    public String getString(String r2) {
        return this.mQuery.get(r2);
    }

    public void parse(String r1) {
        saveQueryToMap(getQueryStringFromUrl(r1));
    }

    public boolean getBoolean(String r2, boolean r3) {
        String r4 = this.mQuery.get(r2);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return Boolean.parseBoolean(r4);
    L7:
        return r3;
    }

    public float getFloat(String r2, float r3) {
        if (this.mQuery.containsKey(r2) == false) goto L9;
        String r4 = this.mQuery.get(r2);
        if (r4 != null) goto L11;
        return r3;
    L11:
        return CastFloatProtector.parseFloat(r4);
    L9:
        return r3;
    }

    public int getInt(String r2, int r3) {
        String r4 = this.mQuery.get(r2);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return CastIntegerProtector.parseInt(r4);
    L7:
        return r3;
    }
}
