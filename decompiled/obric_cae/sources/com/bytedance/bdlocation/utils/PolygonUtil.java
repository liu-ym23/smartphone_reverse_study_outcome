package com.bytedance.bdlocation.utils;

import android.graphics.Path;
import android.graphics.PointF;
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

        public Builder addVertice(PointF r8) {
            this.vertices.add(r8);
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

    public static Builder Builder() {
        return new Builder();
    }

    public static boolean isPointInPolygon(PointF r10, List<PointF> r11) {
        int r8 = r11.size() - 1;
        int r12 = 0;
        boolean r13 = false;
    L4:
        if (r12 >= r11.size()) goto L18;
        if (r11.get(r12).y < r10.y) goto L8;
        boolean r14 = true;
    L10:
        if (r11.get(r8).y < r10.y) goto L12;
        boolean r15 = true;
    L13:
        if (r14 == r15) goto L17;
        if (r10.x > ((((r10.y - r11.get(r12).y) * (r11.get(r8).x - r11.get(r12).x)) / (r11.get(r8).y - r11.get(r12).y)) + r11.get(r12).x)) goto L17;
        r13 = !r13;
    L17:
        r8 = r12;
        r12 = r12 + 1;
        goto L4
    L12:
        r15 = false;
        goto L13
    L8:
        r14 = false;
        goto L10
    L18:
        return r13;
    }

    public boolean contains(PointF r8) {
        return isPointInPolygon(r8, this.vertices);
    }

    public Path getPolygonPath() {
        Path r8 = new Path();
        Iterator<PointF> r10 = this.vertices.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L10;
        PointF r12 = r10.next();
        float r13 = r12.x;
        float r14 = r12.y;
        if (r11 != 0) goto L8;
        r8.moveTo(r13, r14);
    L9:
        r11 = r11 + 1;
        goto L4
    L8:
        r8.lineTo(r13, r14);
        goto L9
    L10:
        r8.close();
        return r8;
    }

    public List<PointF> getVertices() {
        return this.vertices;
    }

    public void setVertices(List<PointF> r8) {
        this.vertices = r8;
    }

    public PolygonUtil(List<PointF> r8) {
        this.vertices = r8;
    }

    public boolean contains(List<PointF> r8) {
        Iterator<PointF> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (contains(r10.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }
}
