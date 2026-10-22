package com.google.j2objc.annotations;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface LoopTranslation {

    public static final enum LoopStyle extends Enum<LoopStyle> {
        private static final /* synthetic */ LoopStyle[] $VALUES = null;
        public static final LoopStyle FAST_ENUMERATION = null;
        public static final LoopStyle JAVA_ITERATOR = null;

        static {
            LoopStyle r0 = new LoopStyle("JAVA_ITERATOR", 0);
            JAVA_ITERATOR = r0;
            LoopStyle r1 = new LoopStyle("FAST_ENUMERATION", 1);
            FAST_ENUMERATION = r1;
            $VALUES = new LoopStyle[]{r0, r1};
        }

        private LoopStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static LoopStyle valueOf(String r2) {
            return (LoopStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(LoopStyle.class, r2), LoopStyle.class, "com.obric.memorydata.plugin");
        }

        public static LoopStyle[] values() {
            return (LoopStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LoopStyle[].class, "com.obric.memorydata.plugin");
        }
    }
}
