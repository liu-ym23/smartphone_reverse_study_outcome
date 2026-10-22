package kotlin.reflect.jvm.internal.impl.load.kotlin;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final MemberSignature fromFieldNameAndDesc(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "desc");
            return new MemberSignature(a.m(r5, '#', r10), null);
        }

        @JvmStatic
        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature r5) {
            Intrinsics.checkNotNullParameter(r5, "signature");
            if ((r5 instanceof JvmMemberSignature.Method) == false) goto L6;
            return fromMethodNameAndDesc(r5.getName(), r5.getDesc());
        L6:
            if ((r5 instanceof JvmMemberSignature.Field) == false) goto L10;
            return fromFieldNameAndDesc(r5.getName(), r5.getDesc());
        L10:
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final MemberSignature fromMethod(NameResolver r5, JvmProtoBuf.JvmMethodSignature r10) {
            Intrinsics.checkNotNullParameter(r5, "nameResolver");
            Intrinsics.checkNotNullParameter(r10, "signature");
            return fromMethodNameAndDesc(r5.getString(r10.getName()), r5.getString(r10.getDesc()));
        }

        @JvmStatic
        public final MemberSignature fromMethodNameAndDesc(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "desc");
            return new MemberSignature(j0.j(r5, r10), null);
        }

        @JvmStatic
        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "signature");
            return new MemberSignature(r5.getSignature() + '@' + r10, null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ MemberSignature(String r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MemberSignature) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.signature, ((MemberSignature) r5).signature) == true) goto L11;
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
        return j0.p(new StringBuilder("MemberSignature(signature="), this.signature, ')');
    }

    private MemberSignature(String r5) {
        this.signature = r5;
    }
}
