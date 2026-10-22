package com.google.auto.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import javax.annotation.processing.AbstractProcessor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicAnnotationProcessor extends AbstractProcessor {

    private static final class ElementName {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Kind f4274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4275b;

        private static final enum Kind extends Enum<Kind> {
            private static final /* synthetic */ Kind[] $VALUES = null;
            public static final Kind PACKAGE_NAME = null;
            public static final Kind TYPE_NAME = null;

            private static /* synthetic */ Kind[] $values() {
                return new Kind[]{PACKAGE_NAME, TYPE_NAME};
            }

            static {
                PACKAGE_NAME = new Kind("PACKAGE_NAME", 0);
                TYPE_NAME = new Kind("TYPE_NAME", 1);
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

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, ElementName.class) == true) goto L5;
            return false;
        L5:
            ElementName r5 = (ElementName) ZeusTransformUtils.preCheckCast(r4, ElementName.class, "com.obric.memorydata.plugin");
            if (this.f4274a == r5.f4274a) goto L8;
            return false;
        L8:
            if (this.f4275b.equals(r5.f4275b) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f4274a, this.f4275b});
        }
    }
}
