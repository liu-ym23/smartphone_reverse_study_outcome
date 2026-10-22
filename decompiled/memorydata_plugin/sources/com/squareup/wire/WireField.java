package com.squareup.wire;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WireField {

    public static final enum Label extends Enum<Label> {
        private static final /* synthetic */ Label[] $VALUES = null;
        public static final Label ONE_OF = null;
        public static final Label OPTIONAL = null;
        public static final Label PACKED = null;
        public static final Label REPEATED = null;
        public static final Label REQUIRED = null;

        static {
            Label r0 = new Label("REQUIRED", 0);
            REQUIRED = r0;
            Label r1 = new Label("OPTIONAL", 1);
            OPTIONAL = r1;
            Label r3 = new Label("REPEATED", 2);
            REPEATED = r3;
            Label r5 = new Label("ONE_OF", 3);
            ONE_OF = r5;
            Label r7 = new Label("PACKED", 4);
            PACKED = r7;
            $VALUES = new Label[]{r0, r1, r3, r5, r7};
        }

        private Label(String r1, int r2) {
            super(r1, r2);
        }

        public static Label valueOf(String r2) {
            return (Label) ZeusTransformUtils.preCheckCast(Enum.valueOf(Label.class, r2), Label.class, "com.obric.memorydata.plugin");
        }

        public static Label[] values() {
            return (Label[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Label[].class, "com.obric.memorydata.plugin");
        }

        boolean isOneOf() {
            if (this != ONE_OF) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isPacked() {
            if (this != PACKED) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isRepeated() {
            if (this != REPEATED) goto L5;
        L8:
            return true;
        L5:
            if (this == PACKED) goto L8;
            return false;
        }
    }

    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
