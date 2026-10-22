package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmMemberSignature {

    public static final class Field extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public Field(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "desc");
            super(null);
            this.name = r10;
            this.desc = r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getDesc();
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Field) == true) goto L8;
            return false;
        L8:
            Field r11 = (Field) r10;
            if (Intrinsics.areEqual(getName(), r11.getName()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getDesc(), r11.getDesc()) == true) goto L14;
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
            return (getName().hashCode() * 31) + getDesc().hashCode();
        }
    }

    public static final class Method extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public Method(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "desc");
            super(null);
            this.name = r10;
            this.desc = r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + getDesc();
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Method) == true) goto L8;
            return false;
        L8:
            Method r11 = (Method) r10;
            if (Intrinsics.areEqual(getName(), r11.getName()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getDesc(), r11.getDesc()) == true) goto L14;
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
            return (getName().hashCode() * 31) + getDesc().hashCode();
        }
    }

    private JvmMemberSignature() {
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker r10) {
        this();
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }
}
