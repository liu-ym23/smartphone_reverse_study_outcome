package com.lynx.devtool.helper;

import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.miui.easygo.constant.EasyGoDbTable;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TestbenchDumpFileHelper {
    private static final String TAG = "TestbenchDumpFileHelper";

    public TestbenchDumpFileHelper() {
    }

    public static String getUITree(LynxBaseUI r0) {
        return getUITreeRecursive(r0).toString();
    }

    private static JSONObject getUITreeRecursive(LynxBaseUI r5) {
        JSONObject r0 = new JSONObject();
        String r1 = r5.getClass().getSimpleName();     // Catch: Exception -> L31
        int r2 = r1.hashCode();     // Catch: Exception -> L31
        if (r2 == (-423713544)) goto L12;
        if (r2 == (-214732126)) goto L9;
    L14:
        byte r3 = -1;
    L15:
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L23;
        r1 = "FlattenUIImage";
    L23:
        r0.put(EasyGoDbTable.Server.NAME, r1);     // Catch: Exception -> L31
        r0.put("left", r5.getLeft());     // Catch: Exception -> L31
        r0.put("top", r5.getTop());     // Catch: Exception -> L31
        r0.put("width", r5.getWidth());     // Catch: Exception -> L31
        r0.put("height", r5.getHeight());     // Catch: Exception -> L31
        getSpecificInfo(r5, r0);     // Catch: Exception -> L31
        List<LynxBaseUI> r6 = r5.getChildren();     // Catch: Exception -> L31
        if (r6.size() <= 0) goto L33;
        JSONArray r4 = new JSONArray();     // Catch: Exception -> L31
        Iterator<LynxBaseUI> r7 = r6.iterator();     // Catch: Exception -> L31
    L27:
        if (r7.hasNext() == false) goto L29;
        r4.put(getUITreeRecursive(r7.next()));     // Catch: Exception -> L31
        goto L27
    L29:
        r0.put("children", r4);     // Catch: Exception -> L31
    L33:
        return r0;
    L20:
        if ("filter-image".equals(r5.getTagName()) == false) goto L22;
        r1 = "UIFilterImage";
        goto L23
    L22:
        r1 = "UIImage";
        goto L23
    L9:
        if (r1.equals("LynxFlattenImageUI") == false) goto L14;
        r3 = 1;
        goto L15
    L12:
        if (r1.equals("LynxImageUI") == false) goto L14;
        r3 = 0;
    L31:
        e = move-exception;
        LLog.e(TAG, e.toString());
        goto L33
    }

    public static String getViewTree(View r0) {
        return getViewTreeRecursive(r0).toString();
    }

    private static JSONObject getViewTreeRecursive(View r7) {
        JSONObject r1 = new JSONObject();
        Class<?> r2 = r7.getClass();     // Catch: Exception -> L28
        String r3 = r2.getSimpleName();     // Catch: Exception -> L28
        int r6 = 0;
        if (r3.hashCode() == 833241129) goto L7;
    L9:
        byte r4 = -1;
    L10:
        if (r4 == 0) goto L31;
    L19:
        r1.put(EasyGoDbTable.Server.NAME, r3);     // Catch: Exception -> L28
        r1.put("left", r7.getLeft());     // Catch: Exception -> L28
        r1.put("top", r7.getTop());     // Catch: Exception -> L28
        r1.put("width", r7.getWidth());     // Catch: Exception -> L28
        r1.put("height", r7.getHeight());     // Catch: Exception -> L28
        if ((r7 instanceof ViewGroup) == false) goto L30;
        int r5 = ((ViewGroup) r7).getChildCount();     // Catch: Exception -> L28
        if (r5 <= 0) goto L30;
        JSONArray r8 = new JSONArray();     // Catch: Exception -> L28
    L24:
        if (r6 >= r5) goto L26;
        r8.put(getViewTreeRecursive(((ViewGroup) r7).getChildAt(r6)));     // Catch: Exception -> L28
        r6 = r6 + 1;     // Catch: Exception -> L28
        goto L24
    L26:
        r1.put("children", r8);     // Catch: Exception -> L28
    L30:
        return r1;
    L31:
        Field r9 = r2.getDeclaredField("mTagName");     // Catch: Throwable -> L17
        r9.setAccessible(true);     // Catch: Throwable -> L17
        if ("filter-image".equals((String) r9.get(r7)) == false) goto L15;
        String r10 = "FrescoFilterImageView";
    L16:
        r3 = r10;
        goto L19
    L15:
        r10 = "FrescoImageView";
        goto L16
    L17:
        th = move-exception;
        r3 = Log.getStackTraceString(th);     // Catch: Exception -> L28
        LLog.e(TAG, r3);     // Catch: Exception -> L28
        goto L19
    L7:
        if (r3.equals("LynxImageView") == false) goto L9;
        r4 = 0;
    L28:
        e = move-exception;
        LLog.e(TAG, e.toString());
        goto L30
    }

    private static void getSpecificInfo(LynxBaseUI r3, JSONObject r4) throws Exception {
        Class<?> r0 = r3.getClass();
        String r1 = r0.getSimpleName();
        if (r1.equals("LynxImageUI") == false) goto L5;
    L16:
        setLynxImageUIInfo(r3, r4);
        return;
    L5:
        if (r1.equals("LynxFlattenImageUI") == true) goto L16;
        if (r1.equals("FlattenUIImage") == false) goto L11;
        setFlattenUIImageInfo(r0, r3, r4);
        return;
    L11:
        if (r1.equals("UIText") == false) goto L14;
        setTextInfo(((LynxUI) r3).getView(), r4);
        return;
    L14:
        if (r1.equals("FlattenUIText") == false) goto L20;
        setTextInfo(r3, r4);
        return;
    }

    private static void setLynxImageUIInfo(Object r3, JSONObject r4) throws Exception {
        Field r0 = r3.getClass().getDeclaredField("mImageDelegate");
        r0.setAccessible(true);
        Object r5 = r0.get(r3);
        Field r1 = r5.getClass().getDeclaredField("mSrc");
        r1.setAccessible(true);
        r4.put(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, r1.get(r5));
    }

    private static void setTextInfo(Object r2, JSONObject r3) throws Exception {
        Field r0 = r2.getClass().getDeclaredField("mTextLayout");
        r0.setAccessible(true);
        Layout r4 = (Layout) r0.get(r2);
        r3.put("alignment", r4.getAlignment().toString());
        r3.put("textSize", r4.getPaint().getTextSize());
    }

    private static void setFlattenUIImageInfo(Class r2, LynxBaseUI r3, JSONObject r4) throws Exception {
        Field r5 = r2.getDeclaredField("mLynxImageManager");
        r5.setAccessible(true);
        Object r6 = r5.get(r3);
        Field r7 = r6.getClass().getDeclaredField("mImageSource");
        r7.setAccessible(true);
        Object r8 = r7.get(r6);
        Field r9 = r8.getClass().getDeclaredField("mSource");
        r9.setAccessible(true);
        r4.put(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, r9.get(r8));
    }
}
