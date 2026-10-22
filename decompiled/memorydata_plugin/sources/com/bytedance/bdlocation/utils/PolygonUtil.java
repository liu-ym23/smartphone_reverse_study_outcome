package com.bytedance.bdlocation.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PolygonUtil {
    private List<PointF> vertices;

    public static class Builder {
        private List<PointF> vertices;

        public Builder() {
            this.vertices = new ArrayList();
        }

        public Builder addVertice(PointF r2) {
            this.vertices.add(r2);
            return this;
        }

        public PolygonUtil build() {
            if (this.vertices.size() < 3) goto L7;
            return new PolygonUtil(this.vertices);
        L7:
            throw new RuntimeException("Polygon must have at least 3 points");
        }
    }

    public PolygonUtil() {
        this.vertices = new ArrayList();
    }

    public PolygonUtil(List<PointF> r3) {
        this.vertices = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public static Builder Builder() {
        return new Builder();
    }

    public static boolean isPointInPolygon(PointF r12, List<PointF> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        int r4 = r14.size() - 1;
        int r0 = 0;
        boolean r5 = false;
    L4:
        if (r0 >= r14.size()) goto L18;
        if (((PointF) ZeusTransformUtils.preCheckCast(r14.get(r0), PointF.class, "com.obric.memorydata.plugin")).y < r12.y) goto L8;
        boolean r6 = true;
    L10:
        if (((PointF) ZeusTransformUtils.preCheckCast(r14.get(r4), PointF.class, "com.obric.memorydata.plugin")).y < r12.y) goto L12;
        boolean r7 = true;
    L13:
        if (r6 == r7) goto L17;
        if (r12.x > ((((((PointF) ZeusTransformUtils.preCheckCast(r14.get(r4), PointF.class, "com.obric.memorydata.plugin")).x - ((PointF) ZeusTransformUtils.preCheckCast(r14.get(r0), PointF.class, "com.obric.memorydata.plugin")).x) * (r12.y - ((PointF) ZeusTransformUtils.preCheckCast(r14.get(r0), PointF.class, "com.obric.memorydata.plugin")).y)) / (((PointF) ZeusTransformUtils.preCheckCast(r14.get(r4), PointF.class, "com.obric.memorydata.plugin")).y - ((PointF) ZeusTransformUtils.preCheckCast(r14.get(r0), PointF.class, "com.obric.memorydata.plugin")).y)) + ((PointF) ZeusTransformUtils.preCheckCast(r14.get(r0), PointF.class, "com.obric.memorydata.plugin")).x)) goto L17;
        r5 = !r5;
    L17:
        r4 = r0;
        r0 = r0 + 1;
        goto L4
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = false;
        goto L10
    L18:
        return r5;
    }

    public boolean contains(PointF r1) {
        return isPointInPolygon(r1, this.vertices);
    }

    public boolean contains(List<PointF> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (contains((PointF) ZeusTransformUtils.preCheckCast(r5.next(), PointF.class, "com.obric.memorydata.plugin")) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public Path getPolygonPath() {
        Path r0 = new Path();
        Iterator<PointF> r5 = this.vertices.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L10;
        PointF r2 = (PointF) ZeusTransformUtils.preCheckCast(r5.next(), PointF.class, "com.obric.memorydata.plugin");
        float r3 = r2.x;
        float r4 = r2.y;
        if (r1 != 0) goto L8;
        r0.moveTo(r3, r4);
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        r0.lineTo(r3, r4);
        goto L9
    L10:
        r0.close();
        return r0;
    }

    public List<PointF> getVertices() {
        return this.vertices;
    }

    public void setVertices(List<PointF> r3) {
        this.vertices = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }
}
