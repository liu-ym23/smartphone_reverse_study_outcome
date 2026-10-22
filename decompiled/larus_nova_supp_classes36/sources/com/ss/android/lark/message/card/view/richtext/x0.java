package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x0 {
    public static final Map<RichText, Integer> b = null;
    public static final Map<RichText, List<NodeParams>> c = null;
    public static final Map<RichText, List<NodeParams>> d = null;
    public final int a;

    static {
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
    }

    public x0(int r2) {
        this.a = 0;
        this.a = r2;
    }

    public static boolean a(int r2) {
        if (r2 > 1) goto L5;
    L7:
        return false;
    L5:
        if (zz7.b.d() == ZoomLevel6.NORMAL) goto L7;
        return true;
    }

    public final int f(Context r2, int r3) {
        if (a(this.a) == false) goto L5;
        ZoomLevel6 r0 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        return MathKt.roundToInt(zz7.b.a(r2, zz7.b.e().getMultiplier() * r3));
    L5:
        return UIUtils.dp2px(r2, r3);
    }

    public static void d(String r2, RichText r3, int r4) {
        if (a(r4) == false) goto L13;
        JSONObject r5 = new JSONObject();
        r5.put("textsize_set", r2);     // Catch: Exception -> L11
        Map<RichText, Integer> r6 = b;     // Catch: Exception -> L11
        if (((HashMap) r6).get(r3) == null) goto L8;
        float r7 = ((Integer) ((HashMap) r6).get(r3)).intValue();     // Catch: Exception -> L11
    L9:
        r5.put("textsize_show", r7 + "");     // Catch: Exception -> L11
    L12:
        Statistics.sendEvent("op_card_button_show", r5);
        return;
    L8:
        r7 = 14.0f;
    L11:
        Log.e("ZoomRule", "send button show event failed!");
        goto L12
    L13:
        Log.i("ZoomRule", "sendEvent->don't need send!!");
    }

    public static synchronized void e(RichText r2, int r3, NodeParams r4) {
        monitor-enter(x0.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (a(r3) == true) goto L9;
        monitor-exit(x0.class);
        return;
    L9:
        if (r4.mRichTextTag != RichTextElement.RichTextTag.PARAGRAPH) goto L14;
        Map<RichText, List<NodeParams>> r5 = d;     // Catch: Throwable -> L16
        List r1 = (List) ((HashMap) r5).get(r2);     // Catch: Throwable -> L16
        if (r1 != null) goto L13;
        r1 = new ArrayList();     // Catch: Throwable -> L16
        ((HashMap) r5).put(r2, r1);     // Catch: Throwable -> L16
    L13:
        r1.add(r4);     // Catch: Throwable -> L16
    L14:
        monitor-exit(x0.class);
    }

    public final void b(Context r4, YogaNode r5, NodeParams r6) {
        if (a(this.a) == true) goto L6;
        return;
    L6:
        if (r6.mYogaProperty.height <= 0.0f) goto L13;
        Log.i("ZoomRule", "origin height:" + r6.mYogaProperty.height);
        r5.setHeightAuto();
        YogaProperty r7 = r6.mYogaProperty;
        if (r7.paddingTop != 0.0f) goto L10;
    L11:
        r5.setPadding(YogaEdge.TOP, UIUtils.dp2px(r4, 10.0f));
        r5.setPadding(YogaEdge.BOTTOM, UIUtils.dp2px(r4, 10.0f));
        return;
    L10:
        if (r7.paddingBottom == 0.0f) goto L11;
        return;
    }

    public static void c(String r2, String r3, String r4, String r5, RichText r6, int r7) {
        if (a(r7) == false) goto L16;
        JSONObject r8 = new JSONObject();
        r8.put("message_id", r2);     // Catch: Exception -> L14
        r8.put("actionType", r3);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r8.put("url", r4);     // Catch: Exception -> L14
    L8:
        r8.put("textsize_set", r5);     // Catch: Exception -> L14
        Map<RichText, Integer> r9 = b;     // Catch: Exception -> L14
        if (((HashMap) r9).get(r6) == null) goto L11;
        float r10 = ((Integer) ((HashMap) r9).get(r6)).intValue();     // Catch: Exception -> L14
    L12:
        r8.put("textsize_show", r10 + "");     // Catch: Exception -> L14
    L15:
        Statistics.sendEvent("op_card_button_click", r8);
        return;
    L11:
        r10 = 14.0f;
    L14:
        Log.e("ZoomRule", "send button click event failed!");
        goto L15
    L16:
        Log.i("ZoomRule", "sendEvent->don't need send!!");
    }
}
