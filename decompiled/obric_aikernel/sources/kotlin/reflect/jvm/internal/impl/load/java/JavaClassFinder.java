package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaClassFinder {

    public static final class DefaultImpls {
        public static /* synthetic */ JavaPackage findPackage$default(JavaClassFinder r10, FqName r11, boolean r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 2) == 0) goto L7;
            r12 = true;
        L7:
            return r10.findPackage(r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPackage");
        }
    }

    public static final class Request {
        private final ClassId classId;
        private final JavaClass outerClass;
        private final byte[] previouslyFoundClassFileContent;

        public Request(ClassId r10, byte[] r11, JavaClass r12) {
            Intrinsics.checkNotNullParameter(r10, "classId");
            this.classId = r10;
            this.previouslyFoundClassFileContent = r11;
            this.outerClass = r12;
        }

        public /* synthetic */ Request(ClassId r10, byte[] r11, JavaClass r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = null;
        L6:
            if ((r13 & 4) == 0) goto L8;
            r12 = null;
        L8:
            this(r10, r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Request) == true) goto L8;
            return false;
        L8:
            Request r11 = (Request) r10;
            if (Intrinsics.areEqual(this.classId, r11.classId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.previouslyFoundClassFileContent, r11.previouslyFoundClassFileContent) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.outerClass, r11.outerClass) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            int r10 = this.classId.hashCode() * 31;
            byte[] r11 = this.previouslyFoundClassFileContent;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            JavaClass r15 = this.outerClass;
            if (r15 == null) goto L11;
            r12 = r15.hashCode();
        L11:
            return r14 + r12;
        L5:
            r13 = Arrays.hashCode(r11);
            goto L6
        }

        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }
    }

    JavaClass findClass(Request r10);

    JavaPackage findPackage(FqName r10, boolean r11);

    Set<String> knownClassNamesInPackage(FqName r10);
}
