package com.bytedance.android.ec.core.monitor;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/RecyclerViewPerformanceMonitor;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewPerformanceMonitor extends RecyclerView.OnScrollListener {
    public boolean a;
    public final q b;

    public RecyclerViewPerformanceMonitor(MonitorScenes r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        this(new q(r10, null, null));
    }

    public RecyclerViewPerformanceMonitor(q r10) {
        Intrinsics.checkNotNullParameter(r10, "monitorSceneWrapper");
        this.b = r10;
    }

    public final void onScrollStateChanged(RecyclerView r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        super.onScrollStateChanged(r10, r11);
        String r12 = null;
        boolean r13 = false;
        boolean r14 = true;
        if (r11 == 0) goto L19;
        if (r11 == 1) goto L9;
        if (r11 == 2) goto L9;
        return;
    L9:
        if (this.a == false) goto L11;
        return;
    L11:
        Map<String, a> r15 = c.a;
        q r16 = this.b;
        Intrinsics.checkNotNullParameter(r16, "monitorSceneWrapper");
        ApmAgent.addPerfTag("e_commerce", r16.a);
        String r17 = this.b.a;
        if (r17.length() <= 0) goto L14;
        r13 = true;
    L14:
        if (r13 == false) goto L16;
        r12 = r17;
    L16:
        if (r12 == null) goto L18;
        Intrinsics.checkNotNullParameter(r12, "sceneName");
        ApmAgent.addPerfTag("e_commerce", r12);
    L18:
        c.g(this.b);
        this.a = true;
        return;
    L19:
        Map<String, a> r18 = c.a;
        q r19 = this.b;
        Intrinsics.checkNotNullParameter(r19, "monitorSceneWrapper");
        ApmAgent.removePerfTag("e_commerce", r19.a);
        String r20 = this.b.a;
        if (r20.length() > 0) goto L23;
        r14 = false;
    L23:
        if (r14 == false) goto L25;
        r12 = r20;
    L25:
        if (r12 == null) goto L27;
        Intrinsics.checkNotNullParameter(r12, "sceneName");
        ApmAgent.removePerfTag("e_commerce", r12);
    L27:
        c.i(this.b);
        this.a = false;
    }
}
