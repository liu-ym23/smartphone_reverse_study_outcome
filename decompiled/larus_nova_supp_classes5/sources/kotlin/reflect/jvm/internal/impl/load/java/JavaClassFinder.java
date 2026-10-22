package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface JavaClassFinder {

    public static final class Request {
        private final ClassId classId;
        private final JavaClass outerClass;
        private final byte[] previouslyFoundClassFileContent;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Request) == true) goto L8;
            return false;
        L8:
            Request r6 = (Request) r5;
            if (Intrinsics.areEqual(this.classId, r6.classId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.previouslyFoundClassFileContent, r6.previouslyFoundClassFileContent) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.outerClass, r6.outerClass) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.classId.hashCode() * 31;
            byte[] r1 = this.previouslyFoundClassFileContent;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            JavaClass r5 = this.outerClass;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = Arrays.hashCode(r1);
            goto L6
        }

        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public Request(ClassId r2, byte[] r3, JavaClass r4) {
            Intrinsics.checkNotNullParameter(r2, "classId");
            this.classId = r2;
            this.previouslyFoundClassFileContent = r3;
            this.outerClass = r4;
        }

        public /* synthetic */ Request(ClassId r2, byte[] r3, JavaClass r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r2, r3, r4);
        }
    }

    JavaClass findClass(Request r1);

    JavaPackage findPackage(FqName r1, boolean r2);

    Set<String> knownClassNamesInPackage(FqName r1);
}
