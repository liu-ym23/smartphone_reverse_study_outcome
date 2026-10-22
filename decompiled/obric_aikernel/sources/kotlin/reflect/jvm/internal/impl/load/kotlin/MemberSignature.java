package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* JADX INFO: loaded from: classes3.dex */
public final class MemberSignature {
    public static final Companion Companion = null;
    private final String signature;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final MemberSignature fromFieldNameAndDesc(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "desc");
            return new MemberSignature(r10 + '#' + r11, null);
        }

        @JvmStatic
        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature r10) {
            Intrinsics.checkNotNullParameter(r10, "signature");
            if ((r10 instanceof JvmMemberSignature.Method) == false) goto L6;
            return fromMethodNameAndDesc(r10.getName(), r10.getDesc());
        L6:
            if ((r10 instanceof JvmMemberSignature.Field) == false) goto L10;
            return fromFieldNameAndDesc(r10.getName(), r10.getDesc());
        L10:
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final MemberSignature fromMethod(NameResolver r10, JvmProtoBuf.JvmMethodSignature r11) {
            Intrinsics.checkNotNullParameter(r10, "nameResolver");
            Intrinsics.checkNotNullParameter(r11, "signature");
            return fromMethodNameAndDesc(r10.getString(r11.getName()), r10.getString(r11.getDesc()));
        }

        @JvmStatic
        public final MemberSignature fromMethodNameAndDesc(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "desc");
            return new MemberSignature(r10 + r11, null);
        }

        @JvmStatic
        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "signature");
            return new MemberSignature(r10.getSignature() + '@' + r11, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private MemberSignature(String r10) {
        this.signature = r10;
    }

    public /* synthetic */ MemberSignature(String r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MemberSignature) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.signature, ((MemberSignature) r10).signature) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + ')';
    }
}
