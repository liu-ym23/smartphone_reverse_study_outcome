package com.obric.oui.constraintlayout.core.motion;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CustomAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AttributeType f13556a;

    public static final enum AttributeType extends Enum<AttributeType> {
        private static final /* synthetic */ AttributeType[] $VALUES = null;
        public static final AttributeType BOOLEAN_TYPE = null;
        public static final AttributeType COLOR_DRAWABLE_TYPE = null;
        public static final AttributeType COLOR_TYPE = null;
        public static final AttributeType DIMENSION_TYPE = null;
        public static final AttributeType FLOAT_TYPE = null;
        public static final AttributeType INT_TYPE = null;
        public static final AttributeType REFERENCE_TYPE = null;
        public static final AttributeType STRING_TYPE = null;

        static {
            AttributeType r0 = new AttributeType("INT_TYPE", 0);
            INT_TYPE = r0;
            AttributeType r1 = new AttributeType("FLOAT_TYPE", 1);
            FLOAT_TYPE = r1;
            AttributeType r3 = new AttributeType("COLOR_TYPE", 2);
            COLOR_TYPE = r3;
            AttributeType r5 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r5;
            AttributeType r7 = new AttributeType("STRING_TYPE", 4);
            STRING_TYPE = r7;
            AttributeType r9 = new AttributeType("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r9;
            AttributeType r11 = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r11;
            AttributeType r13 = new AttributeType("REFERENCE_TYPE", 7);
            REFERENCE_TYPE = r13;
            $VALUES = new AttributeType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private AttributeType(String r1, int r2) {
            super(r1, r2);
        }

        public static AttributeType valueOf(String r2) {
            return (AttributeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AttributeType.class, r2), AttributeType.class, "com.obric.memorydata.plugin");
        }

        public static AttributeType[] values() {
            return (AttributeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AttributeType[].class, "com.obric.memorydata.plugin");
        }
    }

    public AttributeType getType() {
        return this.f13556a;
    }
}
