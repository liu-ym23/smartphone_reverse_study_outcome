package com.bytedance.apm.block.a;

import android.os.Build;
import android.view.FrameMetrics;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm.block.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1179a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.bytedance.apm.trace.fps.c> f1180b;
    private HashMap<String, C0087b> c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1186b;
        public long c;

        public a() {
            this.f1185a = 0;
            this.f1186b = 0;
            this.c = 0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.block.a.b$b, reason: collision with other inner class name */
    private class C0087b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1188b;
        int c;
        int d;
        int[] e;
        int f;
        final /* synthetic */ b g;

        C0087b(b r1, String r2) {
            this.g = r1;
            this.c = 0;
            this.f1187a = r2;
            int r3 = com.bytedance.apm.util.g.b() - 1;
            this.f = r3;
            this.e = new int[(r3 - 0) + 1];
        }

        void a() {
            float r3 = com.bytedance.apm.util.g.a();     // Catch: Throwable -> L13
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
            int r4 = 0;
        L5:
            if (r4 > this.f) goto L10;
            if (this.e[r4] <= 0) goto L9;
            r7.put(String.valueOf(r4), this.e[r4]);     // Catch: Throwable -> L13
        L9:
            r4 = r4 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            com.bytedance.apm.trace.fps.a.a().a(null, this.f1187a, (float) (((double) (((this.c * 100) * com.bytedance.apm.util.g.b()) / (this.c + this.d))) / 100.0d));     // Catch: Throwable -> L13
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L13
            r8.put(MemoryInfoSectionEditActivity.KIND_SCENE, this.f1187a);     // Catch: Throwable -> L13
            JSONObject r9 = new JSONObject();     // Catch: Throwable -> L13
            r9.put("total_scroll_time", this.f1188b);     // Catch: Throwable -> L13
            r9.put("drop_time_rate", 1.0f - ((this.c * 1.0f) / ((int) (this.f1188b / r3))));     // Catch: Throwable -> L13
            r9.put("refresh_rate", this.f + 1);     // Catch: Throwable -> L13
            com.bytedance.apm.data.pipeline.a.b().a(new com.bytedance.apm.data.a.e("fps_drop", this.f1187a, r7, r8, r9));     // Catch: Throwable -> L13
        L11:
            this.c = 0;
            this.d = 0;
            this.f1188b = 0;
        }

        void a(long r4) {
            float r0 = com.bytedance.apm.util.g.a();
            this.f1188b += r4;
            int r5 = Math.min(Math.max((int) (r4 / r0), 0), this.f);
            int[] r6 = this.e;
            r6[r5] = r6[r5] + 1;
            this.d += r5;
            this.c++;
        }

        public String toString() {
            return "visibleScene=" + this.f1187a + ", sumFrame=" + this.c + ", sumDroppedFrames=" + this.d + ", sumFrameCost=" + this.f1188b + ", dropLevel=" + Arrays.toString(this.e);
        }
    }

    static {
    }

    static /* synthetic */ ArrayList a(b r0) {
        return r0.f1180b;
    }

    private void a(String r4, long r5) {
        if (f1179a == true) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L16;
        C0087b r0 = (C0087b) ZeusTransformUtils.preCheckCast(this.c.get(r4), C0087b.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        r0 = new C0087b(this, r4);
        this.c.put(r4, r0);
    L10:
        r0.a(r5);
        if (r0.f1188b < 10000) goto L15;
        this.c.remove(r4);
        r0.a();
        return;
    L15:
        return;
    }

    public void a(final com.bytedance.apm.trace.fps.c r3) {
        f.a().f1197b.a(new AnonymousClass1(this, r3));
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r3, long r4, int r6) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        a(r3, r4);
        int r5 = 0;
    L6:
        if (r5 >= this.f1180b.size()) goto L10;
        ((com.bytedance.apm.trace.fps.c) ZeusTransformUtils.preCheckCast(this.f1180b.get(r5), com.bytedance.apm.trace.fps.c.class, "com.obric.memorydata.plugin")).a(r4);
        r5 = r5 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r3, long r4, long r6) {
        super.a(r3, r4, r6);
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        long r7 = r6 - r4;
        a(r3, r7);
        int r5 = 0;
    L7:
        if (r5 >= this.f1180b.size()) goto L9;
        ((com.bytedance.apm.trace.fps.c) ZeusTransformUtils.preCheckCast(this.f1180b.get(r5), com.bytedance.apm.trace.fps.c.class, "com.obric.memorydata.plugin")).a(r7);
        r5 = r5 + 1;
        goto L7
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r5, FrameMetrics r6, int r7) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        int r8 = 0;
        long r0 = (((((r6.getMetric(0) + r6.getMetric(1)) + r6.getMetric(2)) + r6.getMetric(3)) + r6.getMetric(4)) + r6.getMetric(5)) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        a(r5, r0);
    L6:
        if (r8 >= this.f1180b.size()) goto L10;
        ((com.bytedance.apm.trace.fps.c) ZeusTransformUtils.preCheckCast(this.f1180b.get(r8), com.bytedance.apm.trace.fps.c.class, "com.obric.memorydata.plugin")).a(r0);
        r8 = r8 + 1;
        goto L6
    L10:
        return;
    }

    public void b(final com.bytedance.apm.trace.fps.c r3) {
        f.a().f1197b.a(new AnonymousClass2(this, r3));
    }
}
