package com.lynx.devtool.recorder;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderEventSend {
    public LynxRecorderEventSend() {
    }

    private static KeyEvent getKeyEvent(JSONObject r2) {
        return new KeyEvent(CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r2, "action")), CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r2, "keycode")));
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static JavaOnlyArray jsonArrayToJavaOnlyArray(JSONArray r3) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = 0;
    L4:
        if (r1 >= r3.length()) goto L13;
        if ((r3.opt(r1) instanceof JSONArray) == false) goto L9;
        r0.add(jsonArrayToJavaOnlyArray((JSONArray) r3.opt(r1)));
    L12:
        r1 = r1 + 1;
        goto L4
    L9:
        if ((r3.opt(r1) instanceof JSONObject) == false) goto L11;
        r0.add(jsonObjectToJavaOnlyMap((JSONObject) r3.opt(r1)));
        goto L12
    L11:
        r0.add(r3.opt(r1));
        goto L12
    L13:
        return r0;
    }

    private static JavaOnlyMap jsonObjectToJavaOnlyMap(JSONObject r4) {
        Iterator<String> r0 = r4.keys();
        JavaOnlyMap r1 = new JavaOnlyMap();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r2 = r0.next().toString();
        if ((r4.opt(r2) instanceof JSONArray) == true) goto L7;
        if ((r4.opt(r2) instanceof JSONObject) == true) goto L10;
        r1.put(r2, r4.opt(r2));
        goto L4
    L10:
        r1.put(r2, jsonObjectToJavaOnlyMap((JSONObject) r4.opt(r2)));
        goto L4
    L7:
        r1.put(r2, jsonArrayToJavaOnlyArray((JSONArray) r4.opt(r2)));
        goto L4
    L12:
        return r1;
    }

    public static void sendGlobalEvent(JSONObject r2, LynxView r3) {
        JSONArray r4 = JSONObjectProtectorUtils.getJSONArray(r2, "arguments");     // Catch: JSONException -> L15
        if (r4.length() == 2) goto L5;
        return;
    L5:
        String r0 = JSONArrayProtectorUtils.getString(r4, 0);     // Catch: JSONException -> L15
        if (r0.equals("exposure") == false) goto L8;
        return;
    L8:
        if (r0.equals("disexposure") == true) goto L20;
        JSONArray r5 = JSONArrayProtectorUtils.getJSONArray(r4, 1);     // Catch: JSONException -> L15
        if (r3 == null) goto L21;
        r3.sendGlobalEvent(r0, jsonArrayToJavaOnlyArray(r5));     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    private static MotionEvent getMotionEvent(JSONObject r9, float r10, float r11) {
        int r5 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r9, "action"));     // Catch: JSONException -> L4
        float r6 = CastFloatProtector.parseFloat(JSONObjectProtectorUtils.getString(r9, "x")) * r10;     // Catch: JSONException -> L4
        float r7 = CastFloatProtector.parseFloat(JSONObjectProtectorUtils.getString(r9, "y")) * r11;     // Catch: JSONException -> L4
        int r8 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r9, "metaState"));     // Catch: JSONException -> L4
        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), r5, r6, r7, r8);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void sendEventAndroid(JSONObject r2, LynxView r3, float r4, float r5) {
        String r0 = JSONObjectProtectorUtils.getString(r2, "type");     // Catch: JSONException -> L4
    L5:
        if (r0 != null) goto L7;
    L9:
        r3.dispatchTouchEvent(getMotionEvent(r2, r4, r5));
        return;
    L7:
        if (r0.equals("key") == false) goto L9;
        r3.dispatchKeyEvent(getKeyEvent(r2));
        return;
    L4:
        r0 = null;
        goto L5
    }
}
