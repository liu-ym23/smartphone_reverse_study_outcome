package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* JADX INFO: loaded from: classes3.dex */
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

            public KotlinClass(KotlinJvmBinaryClass r10, byte[] r11) {
                Intrinsics.checkNotNullParameter(r10, "kotlinJvmBinaryClass");
                super(null);
                this.kotlinJvmBinaryClass = r10;
                this.byteContent = r11;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass r10, byte[] r11, int r12, DefaultConstructorMarker r13) {
                if ((r12 & 2) == 0) goto L5;
                r11 = null;
            L5:
                this(r10, r11);
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker r10) {
            this();
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            if ((this instanceof KotlinClass) == false) goto L5;
            KotlinClass r10 = (KotlinClass) this;
        L6:
            if (r10 != null) goto L8;
            return null;
        L8:
            return r10.getKotlinJvmBinaryClass();
        L5:
            r10 = null;
            goto L6
        }
    }

    Result findKotlinClassOrContent(JavaClass r10);

    Result findKotlinClassOrContent(ClassId r10);
}
