package com.bytedance.rpc.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcFieldTag {

    public static final enum Tag extends Enum<Tag> {
        private static final /* synthetic */ Tag[] $VALUES = null;
        public static final Tag ONE_OF = null;
        public static final Tag OPTIONAL = null;
        public static final Tag PACKED = null;
        public static final Tag REPEATED = null;
        public static final Tag REQUIRED = null;

        static {
            Tag r0 = new Tag("REQUIRED", 0);
            REQUIRED = r0;
            Tag r1 = new Tag("OPTIONAL", 1);
            OPTIONAL = r1;
            Tag r3 = new Tag("REPEATED", 2);
            REPEATED = r3;
            Tag r5 = new Tag("ONE_OF", 3);
            ONE_OF = r5;
            Tag r7 = new Tag("PACKED", 4);
            PACKED = r7;
            $VALUES = new Tag[]{r0, r1, r3, r5, r7};
        }

        private Tag(String r1, int r2) {
            super(r1, r2);
        }

        public static Tag valueOf(String r2) {
            return (Tag) ZeusTransformUtils.preCheckCast(Enum.valueOf(Tag.class, r2), Tag.class, "com.obric.memorydata.plugin");
        }

        public static Tag[] values() {
            return (Tag[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Tag[].class, "com.obric.memorydata.plugin");
        }
    }

    int id();

    Tag tag() default Tag.OPTIONAL;
}
