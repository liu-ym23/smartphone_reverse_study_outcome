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

    public static final class Request {
        private final ClassId classId;
        private final JavaClass outerClass;
        private final byte[] previouslyFoundClassFileContent;

        public Request(ClassId r5, byte[] r10, JavaClass r11) {
            Intrinsics.checkNotNullParameter(r5, "classId");
            this.classId = r5;
            this.previouslyFoundClassFileContent = r10;
            this.outerClass = r11;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Request) == true) goto L8;
            return false;
        L8:
            Request r10 = (Request) r5;
            if (Intrinsics.areEqual(this.classId, r10.classId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.previouslyFoundClassFileContent, r10.previouslyFoundClassFileContent) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.outerClass, r10.outerClass) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            int r5 = this.classId.hashCode() * 31;
            byte[] r10 = this.previouslyFoundClassFileContent;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r5 + r12) * 31;
            JavaClass r14 = this.outerClass;
            if (r14 == null) goto L11;
            r11 = r14.hashCode();
        L11:
            return r13 + r11;
        L5:
            r12 = Arrays.hashCode(r10);
            goto L6
        }

        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        public /* synthetic */ Request(ClassId r5, byte[] r10, JavaClass r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 2) == 0) goto L6;
            r10 = null;
        L6:
            if ((r12 & 4) == 0) goto L8;
            r11 = null;
        L8:
            this(r5, r10, r11);
        }
    }

    JavaClass findClass(Request r5);

    JavaPackage findPackage(FqName r5, boolean r10);

    Set<String> knownClassNamesInPackage(FqName r5);
}
