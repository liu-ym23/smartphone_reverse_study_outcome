package com.obric.oui.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class KeyAttributes extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f13536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f13537b;
    private String c;
    private Fit d;
    private int[] e;
    private Visibility[] f;
    private float[] g;
    private float[] h;
    private float[] i;
    private float[] j;
    private float[] k;
    private float[] l;
    private float[] m;
    private float[] n;
    private float[] o;
    private float[] p;
    private float[] q;
    private float[] r;

    public static final enum Fit extends Enum<Fit> {
        private static final /* synthetic */ Fit[] $VALUES = null;
        public static final Fit LINEAR = null;
        public static final Fit SPLINE = null;

        static {
            Fit r0 = new Fit("SPLINE", 0);
            SPLINE = r0;
            Fit r1 = new Fit("LINEAR", 1);
            LINEAR = r1;
            $VALUES = new Fit[]{r0, r1};
        }

        private Fit(String r1, int r2) {
            super(r1, r2);
        }

        public static Fit valueOf(String r2) {
            return (Fit) ZeusTransformUtils.preCheckCast(Enum.valueOf(Fit.class, r2), Fit.class, "com.obric.memorydata.plugin");
        }

        public static Fit[] values() {
            return (Fit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Fit[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Visibility extends Enum<Visibility> {
        private static final /* synthetic */ Visibility[] $VALUES = null;
        public static final Visibility GONE = null;
        public static final Visibility INVISIBLE = null;
        public static final Visibility VISIBLE = null;

        static {
            Visibility r0 = new Visibility("VISIBLE", 0);
            VISIBLE = r0;
            Visibility r1 = new Visibility("INVISIBLE", 1);
            INVISIBLE = r1;
            Visibility r3 = new Visibility("GONE", 2);
            GONE = r3;
            $VALUES = new Visibility[]{r0, r1, r3};
        }

        private Visibility(String r1, int r2) {
            super(r1, r2);
        }

        public static Visibility valueOf(String r2) {
            return (Visibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(Visibility.class, r2), Visibility.class, "com.obric.memorydata.plugin");
        }

        public static Visibility[] values() {
            return (Visibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Visibility[].class, "com.obric.memorydata.plugin");
        }
    }

    public void a(StringBuilder r4) {
        a(r4, TypedValues.AttributesType.S_TARGET, this.f13537b);
        r4.append("frame:").append(Arrays.toString(this.e)).append(",\n");
        a(r4, "easing", this.c);
        if (this.d == null) goto L6;
        r4.append("fit:'").append(this.d).append("',\n");
    L6:
        if (this.f == null) goto L8;
        r4.append("visibility:'").append(Arrays.toString(this.f)).append("',\n");
    L8:
        a(r4, "alpha", this.g);
        a(r4, "rotationX", this.i);
        a(r4, "rotationY", this.j);
        a(r4, "rotationZ", this.h);
        a(r4, "pivotX", this.k);
        a(r4, "pivotY", this.l);
        a(r4, "pathRotate", this.m);
        a(r4, "scaleX", this.n);
        a(r4, "scaleY", this.o);
        a(r4, "translationX", this.p);
        a(r4, "translationY", this.q);
        a(r4, "translationZ", this.r);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f13536a);
        r0.append(":{\n");
        a(r0);
        r0.append("},\n");
        return r0.toString();
    }
}
