package com.bytedance.android.live.core.utils.fresco;

import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class TagCompat {
    private static final boolean COVER_TAG = true;
    private static final String KEY_DRAWEE_HOLDER = "DraweeHolder";

    public static class TagMap extends HashMap<String, Object> {
        public TagMap(String r1, Object r2, a r3) {
            put(r1, r2);
        }
    }

    public static /* synthetic */ class a {
    }

    public TagCompat() {
    }

    public static Object getTag(View r1) {
        return getTag(r1, KEY_DRAWEE_HOLDER);
    }

    public static Object getTag(View r1, String r2) {
        return getTag(r1, r2, null);
    }

    public static void setTag(View r1, Object r2) {
        setTag(r1, KEY_DRAWEE_HOLDER, r2);
    }

    public static Object getTag(View r1, String r2, Object r3) {
        if (r1 == null) goto L8;
        Object r4 = r1.getTag();
        if ((r4 instanceof TagMap) == false) goto L8;
        Object r5 = ((TagMap) r4).get(r2);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return r3;
    }

    public static boolean setTag(View r1, String r2, Object r3) {
        return setTag(r1, r2, r3, COVER_TAG);
    }

    public static boolean setTag(View r3, String r4, Object r5, boolean r6) {
        if (r3 == null) goto L11;
        Object r0 = r3.getTag();
        if ((r0 instanceof TagMap) == false) goto L7;
        ((TagMap) r0).put(r4, r5);
        return COVER_TAG;
    L7:
        if (r0 == null) goto L9;
        if (r6 == true) goto L9;
        return false;
    L9:
        r3.setTag(new TagMap(r4, r5, null));
        return COVER_TAG;
    L11:
        return false;
    }
}
