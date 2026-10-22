package com.obric.oui.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class KeyCycles extends KeyAttributes {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Wave f13539b;
    private float[] c;
    private float[] d;
    private float[] e;

    public static final enum Wave extends Enum<Wave> {
        private static final /* synthetic */ Wave[] $VALUES = null;
        public static final Wave COS = null;
        public static final Wave REVERSE_SAW = null;
        public static final Wave SAW = null;
        public static final Wave SIN = null;
        public static final Wave SQUARE = null;
        public static final Wave TRIANGLE = null;

        static {
            Wave r0 = new Wave("SIN", 0);
            SIN = r0;
            Wave r1 = new Wave("SQUARE", 1);
            SQUARE = r1;
            Wave r3 = new Wave("TRIANGLE", 2);
            TRIANGLE = r3;
            Wave r5 = new Wave("SAW", 3);
            SAW = r5;
            Wave r7 = new Wave("REVERSE_SAW", 4);
            REVERSE_SAW = r7;
            Wave r9 = new Wave("COS", 5);
            COS = r9;
            $VALUES = new Wave[]{r0, r1, r3, r5, r7, r9};
        }

        private Wave(String r1, int r2) {
            super(r1, r2);
        }

        public static Wave valueOf(String r2) {
            return (Wave) ZeusTransformUtils.preCheckCast(Enum.valueOf(Wave.class, r2), Wave.class, "com.obric.memorydata.plugin");
        }

        public static Wave[] values() {
            return (Wave[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Wave[].class, "com.obric.memorydata.plugin");
        }
    }

    @Override // com.obric.oui.constraintlayout.core.dsl.KeyAttributes
    public void a(StringBuilder r3) {
        super.a(r3);
        if (this.f13539b == null) goto L5;
        r3.append("shape:'").append(this.f13539b).append("',\n");
    L5:
        a(r3, TypedValues.CycleType.S_WAVE_PERIOD, this.c);
        a(r3, TypedValues.CycleType.S_WAVE_OFFSET, this.d);
        a(r3, TypedValues.CycleType.S_WAVE_PHASE, this.e);
    }
}
