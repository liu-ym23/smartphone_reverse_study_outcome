package org.checkerframework.dataflow.qual;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes7.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Pure {

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind DETERMINISTIC = null;
        public static final Kind SIDE_EFFECT_FREE = null;

        private static /* synthetic */ Kind[] $values() {
            return new Kind[]{SIDE_EFFECT_FREE, DETERMINISTIC};
        }

        static {
            SIDE_EFFECT_FREE = new Kind("SIDE_EFFECT_FREE", 0);
            DETERMINISTIC = new Kind("DETERMINISTIC", 1);
            $VALUES = $values();
        }

        private Kind(String r1, int r2) {
            super(r1, r2);
        }

        public static Kind valueOf(String r2) {
            return (Kind) ZeusTransformUtils.preCheckCast(Enum.valueOf(Kind.class, r2), Kind.class, "com.obric.memorydata.plugin");
        }

        public static Kind[] values() {
            return (Kind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Kind[].class, "com.obric.memorydata.plugin");
        }
    }
}
