package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmMemberSignature {

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

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.desc;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Field) == true) goto L8;
            return false;
        L8:
            Field r10 = (Field) r5;
            if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.desc, r10.desc) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            int r5 = this.name.hashCode() * 31;
            return this.desc.hashCode() + r5;
        }
    }

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

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + getDesc();
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Method) == true) goto L8;
            return false;
        L8:
            Method r10 = (Method) r5;
            if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.desc, r10.desc) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            int r5 = this.name.hashCode() * 31;
            return this.desc.hashCode() + r5;
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
