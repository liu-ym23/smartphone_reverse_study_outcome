package com.obric.oui.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class KeyPositions extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f13542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13543b;
    private Type c;
    private int[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private float[] h;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CARTESIAN = null;
        public static final Type PATH = null;
        public static final Type SCREEN = null;

        static {
            Type r0 = new Type("CARTESIAN", 0);
            CARTESIAN = r0;
            Type r1 = new Type("SCREEN", 1);
            SCREEN = r1;
            Type r3 = new Type("PATH", 2);
            PATH = r3;
            $VALUES = new Type[]{r0, r1, r3};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("KeyPositions:{\n");
        a(r0, TypedValues.AttributesType.S_TARGET, this.f13542a);
        r0.append("frame:").append(Arrays.toString(this.d)).append(",\n");
        if (this.c == null) goto L5;
        r0.append("type:'").append(this.c).append("',\n");
    L5:
        a(r0, "easing", this.f13543b);
        a(r0, "percentX", this.g);
        a(r0, "percentX", this.h);
        a(r0, "percentWidth", this.e);
        a(r0, "percentHeight", this.f);
        r0.append("},\n");
        return r0.toString();
    }
}
