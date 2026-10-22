package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    public static abstract class Result {

        public static final class ClassFileContent extends Result {
            private final byte[] content;

            public final byte[] getContent() {
                return this.content;
            }
        }

        public static final class KotlinClass extends Result {
            private final byte[] byteContent;
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }

            public KotlinClass(KotlinJvmBinaryClass r2, byte[] r3) {
                Intrinsics.checkNotNullParameter(r2, "kotlinJvmBinaryClass");
                super(null);
                this.kotlinJvmBinaryClass = r2;
                this.byteContent = r3;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass r1, byte[] r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = null;
            L5:
                this(r1, r2);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker r1) {
            this();
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            if ((this instanceof KotlinClass) == false) goto L5;
            KotlinClass r0 = (KotlinClass) this;
        L6:
            if (r0 != null) goto L8;
            return null;
        L8:
            return r0.getKotlinJvmBinaryClass();
        L5:
            r0 = null;
            goto L6
        }
    }

    Result findKotlinClassOrContent(JavaClass r1, JvmMetadataVersion r2);

    Result findKotlinClassOrContent(ClassId r1, JvmMetadataVersion r2);
}
