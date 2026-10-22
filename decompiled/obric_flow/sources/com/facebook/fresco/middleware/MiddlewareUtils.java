package com.facebook.fresco.middleware;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MiddlewareUtils {
    public static ControllerListener2.Extras a(Map r5, Map r10, Map r11, Rect r12, String r13, PointF r14, HashMap r15, Object r16, Uri r17) {
        ControllerListener2.Extras r18 = new ControllerListener2.Extras();
        r18.view = new HashMap();
        r18.view.putAll(r5);
        if (r12 == null) goto L5;
        r18.view.put("viewport_width", Integer.valueOf(r12.width()));
        r18.view.put("viewport_height", Integer.valueOf(r12.height()));
    L6:
        r18.view.put("scale_type", r13);
        if (r14 == null) goto L9;
        r18.view.put("focus_point_x", Float.valueOf(r14.x));
        r18.view.put("focus_point_y", Float.valueOf(r14.y));
    L9:
        r18.view.put("caller_context", r16);
        if (r17 == null) goto L12;
        r18.view.put("uri_main", r17);
    L12:
        if (r11 == null) goto L17;
        r18.pipe = r11;
        if (r15 == null) goto L16;
        r18.pipe.putAll(r15);
    L16:
        return r18;
    L17:
        r18.pipe = r15;
        r18.view.putAll(r10);
        return r18;
    L5:
        r18.view.put("viewport_width", -1);
        r18.view.put("viewport_height", -1);
        goto L6
    }
}
