package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
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
            Label r8 = new Label("REQUIRED", 0);
            REQUIRED = r8;
            Label r10 = new Label("OPTIONAL", 1);
            OPTIONAL = r10;
            Label r11 = new Label("REPEATED", 2);
            REPEATED = r11;
            Label r12 = new Label("ONE_OF", 3);
            ONE_OF = r12;
            Label r13 = new Label("PACKED", 4);
            PACKED = r13;
            $VALUES = new Label[]{r8, r10, r11, r12, r13};
        }

        private Label(String r8, int r10) {
            super(r8, r10);
        }

        public static Label valueOf(String r8) {
            return (Label) Enum.valueOf(Label.class, r8);
        }

        public static Label[] values() {
            return (Label[]) $VALUES.clone();
        }

        public boolean isOneOf() {
            if (this != ONE_OF) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isPacked() {
            if (this != PACKED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isRepeated() {
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
