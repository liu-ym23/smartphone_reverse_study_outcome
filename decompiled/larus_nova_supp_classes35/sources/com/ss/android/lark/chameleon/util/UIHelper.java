package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.text.TextUtils;
import com.samskivert.mustache.e;
import com.samskivert.mustache.h;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class UIHelper {
    private static final String TAG = "UIHelper";
    private static Map<String, h> mTmplCache;

    public UIHelper() {
    }

    static {
        mTmplCache = new HashMap();
    }

    private static h getTmpl(String r2) {
        h r0 = mTmplCache.get(r2);
        if (r0 != null) goto L6;
        h r1 = e.a().b().a(r2);
        mTmplCache.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public static String mustacheFormat(Context r0, int r1, Map<String, String> r2) {
        String r3 = r0.getString(r1);
        if (TextUtils.isEmpty(r3) == true) goto L12;
        if (r2 == null) goto L12;
        if (r2.isEmpty() == true) goto L12;
        return getTmpl(r3).b(r2);
    L10:
        e = move-exception;
        Log.e(TAG, e.getMessage());
    L12:
        return r3;
    }

    public static String mustacheFormatEscapeHtml(Context r0, int r1, Map<String, String> r2) {
        String r3 = r0.getString(r1);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        if (r2 != null) goto L6;
        return r3;
    L6:
        if (r2.isEmpty() == false) goto L9;
        return r3;
    L9:
        return e.a().a(r3).b(r2);
    L10:
        return r3;
    }

    public static String mustacheFormat(Context r1, int r2, String r3, String r4) {
        String r5 = r1.getString(r2);
        if (r3 == null) goto L11;
        if (r4 == null) goto L11;
        HashMap r6 = new HashMap(1);
        r6.put(r3, r4);
        return getTmpl(r5).b(r6);
    L9:
        e = move-exception;
        Log.e(TAG, e.getMessage());
    L11:
        return r5;
    }

    public static String mustacheFormatEscapeHtml(Context r1, int r2, String r3, String r4) {
        String r5 = r1.getString(r2);
        if (r3 == null) goto L8;
        if (r4 == null) goto L9;
        HashMap r6 = new HashMap(1);
        r6.put(r3, r4);
        return e.a().a(r5).b(r6);
    L9:
        return r5;
    L8:
        return r5;
    }
}
