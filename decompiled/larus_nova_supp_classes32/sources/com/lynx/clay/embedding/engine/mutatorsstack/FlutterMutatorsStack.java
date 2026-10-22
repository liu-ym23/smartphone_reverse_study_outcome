package com.lynx.clay.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterMutatorsStack {
    public final List<a> a;
    public final List<Path> b;
    public final Matrix c;

    public static final enum FlutterMutatorType extends Enum<FlutterMutatorType> {
        public static final FlutterMutatorType CLIP_PATH = null;
        public static final FlutterMutatorType CLIP_RECT = null;
        public static final FlutterMutatorType CLIP_RRECT = null;
        public static final FlutterMutatorType OPACITY = null;
        public static final FlutterMutatorType TRANSFORM = null;
        public static final /* synthetic */ FlutterMutatorType[] a = null;

        static {
            FlutterMutatorType r0 = new FlutterMutatorType("CLIP_RECT", 0);
            CLIP_RECT = r0;
            FlutterMutatorType r1 = new FlutterMutatorType("CLIP_RRECT", 1);
            CLIP_RRECT = r1;
            FlutterMutatorType r3 = new FlutterMutatorType("CLIP_PATH", 2);
            CLIP_PATH = r3;
            FlutterMutatorType r5 = new FlutterMutatorType("TRANSFORM", 3);
            TRANSFORM = r5;
            FlutterMutatorType r7 = new FlutterMutatorType("OPACITY", 4);
            OPACITY = r7;
            a = new FlutterMutatorType[]{r0, r1, r3, r5, r7};
        }

        public static FlutterMutatorType[] values() {
            return (FlutterMutatorType[]) a.clone();
        }

        public static FlutterMutatorType valueOf(String r1) {
            return (FlutterMutatorType) r27.a.a(FlutterMutatorType.class, r1);
        }

        public FlutterMutatorType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a {
        public final Matrix a;
        public final FlutterMutatorType b;

        public a() {
            this.b = FlutterMutatorType.CLIP_RECT;
        }

        public FlutterMutatorType getType() {
            return this.b;
        }

        public a(Matrix r2) {
            this.b = FlutterMutatorType.TRANSFORM;
            this.a = r2;
        }

        public a(int r1) {
            this.b = FlutterMutatorType.CLIP_RRECT;
        }
    }

    public static FlutterMutatorsStack create() {
        return new FlutterMutatorsStack();
    }

    public FlutterMutatorsStack() {
        this.a = new ArrayList();
        this.c = new Matrix();
        this.b = new ArrayList();
    }

    public void pushTransform(float[] r2) {
        Matrix r0 = new Matrix();
        r0.setValues(r2);
        a r3 = new a(r0);
        ((ArrayList) this.a).add(r3);
        this.c.preConcat(r3.a);
    }

    public void pushClipRect(int r2, int r3, int r4, int r5) {
        Rect r0 = new Rect(r2, r3, r4, r5);
        a r6 = new a();
        ((ArrayList) this.a).add(r6);
        Path r7 = new Path();
        r7.addRect(new RectF(r0), Path.Direction.CCW);
        r7.transform(this.c);
        ((ArrayList) this.b).add(r7);
    }

    public void pushClipRRect(int r2, int r3, int r4, int r5, float[] r6) {
        Rect r0 = new Rect(r2, r3, r4, r5);
        a r7 = new a(0);
        ((ArrayList) this.a).add(r7);
        Path r8 = new Path();
        r8.addRoundRect(new RectF(r0), r6, Path.Direction.CCW);
        r8.transform(this.c);
        ((ArrayList) this.b).add(r8);
    }
}
