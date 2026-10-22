package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H&J\u0006\u0010\n\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature;", "", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "name", "getName", "asString", "toString", "Field", "Method", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Field;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Method;", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JvmMemberSignature {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Field;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature;", "name", "", "desc", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getName", "asString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Field extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public Field(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "desc");
            super(null);
            this.name = r5;
            this.desc = r10;
        }

        public static /* synthetic */ Field copy$default(Field r5, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.getName();
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.getDesc();
        L9:
            return r5.copy(r10, r11);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getDesc();
        }

        public final Field copy(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "desc");
            return new Field(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Field) == true) goto L8;
            return false;
        L8:
            Field r10 = (Field) r5;
            if (Intrinsics.areEqual(getName(), r10.getName()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getDesc(), r10.getDesc()) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            int r5 = getName().hashCode() * 31;
            return getDesc().hashCode() + r5;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Method;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature;", "name", "", "desc", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getName", "asString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Method extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public Method(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "desc");
            super(null);
            this.name = r5;
            this.desc = r10;
        }

        public static /* synthetic */ Method copy$default(Method r5, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.getName();
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.getDesc();
        L9:
            return r5.copy(r10, r11);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + getDesc();
        }

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getDesc();
        }

        public final Method copy(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "desc");
            return new Method(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Method) == true) goto L8;
            return false;
        L8:
            Method r10 = (Method) r5;
            if (Intrinsics.areEqual(getName(), r10.getName()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getDesc(), r10.getDesc()) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            int r5 = getName().hashCode() * 31;
            return getDesc().hashCode() + r5;
        }
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker r5) {
        this();
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }

    private JvmMemberSignature() {
    }
}
