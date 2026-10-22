package androidx.room.jarjarred.kotlinx.metadata;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier;", "", "()V", "Class", "TypeAlias", "TypeParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier$Class;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier$TypeAlias;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier$TypeParameter;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmClassifier {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier$Class;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier;", "name", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Class extends KmClassifier {
        private final String name;

        public Class(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            super(null);
            this.name = r5;
        }

        public static /* synthetic */ Class copy$default(Class r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.name;
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return this.name;
        }

        public final Class copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return new Class(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Class) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.name, ((Class) r5).name) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return j0.p(new StringBuilder("Class(name="), this.name, ')');
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier$TypeAlias;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier;", "name", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TypeAlias extends KmClassifier {
        private final String name;

        public TypeAlias(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            super(null);
            this.name = r5;
        }

        public static /* synthetic */ TypeAlias copy$default(TypeAlias r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.name;
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return this.name;
        }

        public final TypeAlias copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return new TypeAlias(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TypeAlias) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.name, ((TypeAlias) r5).name) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return j0.p(new StringBuilder("TypeAlias(name="), this.name, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier$TypeParameter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier;", "id", "", "(I)V", "getId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TypeParameter extends KmClassifier {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f595id;

        public TypeParameter(int r5) {
            super(null);
            this.f595id = r5;
        }

        public static /* synthetic */ TypeParameter copy$default(TypeParameter r5, int r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.f595id;
        L6:
            return r5.copy(r10);
        }

        public final int component1() {
            return this.f595id;
        }

        public final TypeParameter copy(int r5) {
            return new TypeParameter(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TypeParameter) == true) goto L9;
            return false;
        L9:
            if (this.f595id == ((TypeParameter) r5).f595id) goto L11;
            return false;
        L11:
            return true;
        }

        public final int getId() {
            return this.f595id;
        }

        public int hashCode() {
            return Integer.hashCode(this.f595id);
        }

        public String toString() {
            return j0.n(new StringBuilder("TypeParameter(id="), this.f595id, ')');
        }
    }

    public /* synthetic */ KmClassifier(DefaultConstructorMarker r5) {
        this();
    }

    private KmClassifier() {
    }
}
