package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
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

            public KotlinClass(KotlinJvmBinaryClass r5, byte[] r10) {
                Intrinsics.checkNotNullParameter(r5, "kotlinJvmBinaryClass");
                super(null);
                this.kotlinJvmBinaryClass = r5;
                this.byteContent = r10;
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass r5, byte[] r10, int r11, DefaultConstructorMarker r12) {
                if ((r11 & 2) == 0) goto L5;
                r10 = null;
            L5:
                this(r5, r10);
            }
        }

        public /* synthetic */ Result(DefaultConstructorMarker r5) {
            this();
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            if ((this instanceof KotlinClass) == false) goto L5;
            KotlinClass r5 = (KotlinClass) this;
        L6:
            if (r5 != null) goto L8;
            return null;
        L8:
            return r5.getKotlinJvmBinaryClass();
        L5:
            r5 = null;
            goto L6
        }

        private Result() {
        }
    }

    Result findKotlinClassOrContent(JavaClass r5, JvmMetadataVersion r10);

    Result findKotlinClassOrContent(ClassId r5, JvmMetadataVersion r10);
}
