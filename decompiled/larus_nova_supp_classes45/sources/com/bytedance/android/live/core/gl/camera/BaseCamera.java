package com.bytedance.android.live.core.gl.camera;

import com.bytedance.android.live.core.gl.primitive.Align;
import com.bytedance.android.live.core.gl.primitive.e;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseCamera {
    public final int[] a;
    public final float[] b;
    public final float[] c;
    public final e d;
    public final e e;
    public final e f;
    public float g;
    public Align h;
    public float i;
    public float j;
    public ClampType k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/gl/camera/BaseCamera$ClampType;", "", "NONE", "HORIZONTAL", "VERTICAL", "INNER_BORDER", "OUTER_BORDER", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ClampType extends Enum<ClampType> {
        public static final ClampType HORIZONTAL = null;
        public static final ClampType INNER_BORDER = null;
        public static final ClampType NONE = null;
        public static final ClampType OUTER_BORDER = null;
        public static final ClampType VERTICAL = null;
        public static final /* synthetic */ ClampType[] a = null;

        static {
            ClampType r1 = new ClampType("NONE", 0);
            NONE = r1;
            ClampType r2 = new ClampType("HORIZONTAL", 1);
            HORIZONTAL = r2;
            ClampType r3 = new ClampType("VERTICAL", 2);
            VERTICAL = r3;
            ClampType r4 = new ClampType("INNER_BORDER", 3);
            INNER_BORDER = r4;
            ClampType r5 = new ClampType("OUTER_BORDER", 4);
            OUTER_BORDER = r5;
            a = new ClampType[]{r1, r2, r3, r4, r5};
        }

        public static ClampType valueOf(String r1) {
            return (ClampType) a.a(ClampType.class, r1);
        }

        public static ClampType[] values() {
            return (ClampType[]) a.clone();
        }

        public ClampType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract void a();

    public BaseCamera() {
        this.a = new int[4];
        this.b = new float[16];
        this.c = new float[16];
        this.d = new e(0.0f, 0.0f, 10.0f);
        this.e = new e(0.0f, 0.0f, 0.0f);
        this.f = new e(0.0f, 1.0f, 0.0f);
        this.g = 1.0f;
        this.h = Align.CENTER;
        this.i = 10.0f;
        this.k = ClampType.NONE;
    }
}
