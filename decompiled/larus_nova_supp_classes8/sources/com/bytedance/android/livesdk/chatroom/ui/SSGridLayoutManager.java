package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SSGridLayoutManager extends GridLayoutManager {
    public final boolean isLayoutRTL() {
        IAiService r0 = jc1.k.f(IAiService.class);
        if (r0 == null) goto L6;
        r0.getOhrService();
    L6:
        return super/*androidx.recyclerview.widget.LinearLayoutManager*/.isLayoutRTL();
    }

    public static void p(String r5) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r0.put("status_code", 1);     // Catch: JSONException -> L5
        r2.put("error_log", r5);     // Catch: JSONException -> L5
    L7:
        LiveTracingMonitor.f("ttlive_gift_panel_layout_crash_error", LiveTracingMonitor.EventModule.LIVE_GIFT, r0, r1, r2);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public SSGridLayoutManager(Context r1, int r2) {
        super(r1, r2);
    }

    public void onLayoutChildren(RecyclerView.Recycler r5, RecyclerView.State r6) {
        super.onLayoutChildren(r5, r6);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(null, e, "SSGridLayoutManager onLayoutChildren error");
        if (e.getCause() != null) goto L8;
    L10:
        ALogger.e("SSGridLayoutManager", e);
        return;
    L8:
        if (e.getCause().getStackTrace() == null) goto L10;
        StackTraceElement[] r7 = e.getCause().getStackTrace();
        p(e.getCause().getMessage() + "  layout error! " + Arrays.toString(r7));
        ALogger.e("SSGridLayoutManager", e.getCause().getMessage() + "  layout error! " + Arrays.toString(r7));
    }

    public SSGridLayoutManager(Context r2, int r3, int r4) {
        super(r2, r3, r4, false);
    }

    public final int scrollHorizontallyBy(int r4, RecyclerView.Recycler r5, RecyclerView.State r6) {
        return super.scrollHorizontallyBy(r4, r5, r6);
    L4:
        e = move-exception;
        if (e.getCause() != null) goto L8;
    L10:
        ALogger.e("SSGridLayoutManager", e);
        return 0;
    L8:
        if (e.getCause().getStackTrace() == null) goto L10;
        StackTraceElement[] r7 = e.getCause().getStackTrace();
        p(e.getCause().getMessage() + "  layout error! " + Arrays.toString(r7));
        ALogger.e("SSGridLayoutManager", e.getCause().getMessage() + "  layout error! " + Arrays.toString(r7));
        return 0;
    }

    public int scrollVerticallyBy(int r4, RecyclerView.Recycler r5, RecyclerView.State r6) {
        return super.scrollVerticallyBy(r4, r5, r6);
    L4:
        e = move-exception;
        if (e.getCause() != null) goto L8;
    L10:
        ALogger.e("SSGridLayoutManager", e);
        return 0;
    L8:
        if (e.getCause().getStackTrace() == null) goto L10;
        StackTraceElement[] r7 = e.getCause().getStackTrace();
        ALogger.e("SSGridLayoutManager", e.getCause().getMessage() + "  layout error! " + Arrays.toString(r7));
        p(e.getCause().getMessage() + "  layout error! " + Arrays.toString(r7));
        return 0;
    }

    public SSGridLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
