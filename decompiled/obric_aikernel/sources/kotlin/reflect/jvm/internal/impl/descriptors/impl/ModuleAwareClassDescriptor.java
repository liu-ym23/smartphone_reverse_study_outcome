package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor r10, TypeSubstitution r11, KotlinTypeRefiner r12) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "typeSubstitution");
            Intrinsics.checkNotNullParameter(r12, "kotlinTypeRefiner");
            if ((r10 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r13 = (ModuleAwareClassDescriptor) r10;
        L6:
            if (r13 == null) goto L9;
            MemberScope r14 = r13.getMemberScope(r11, r12);
            if (r14 == null) goto L9;
            return r14;
        L9:
            MemberScope r15 = r10.getMemberScope(r11);
            Intrinsics.checkNotNullExpressionValue(r15, "this.getMemberScope(\n   …ubstitution\n            )");
            return r15;
        L5:
            r13 = null;
            goto L6
        }

        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor r10, KotlinTypeRefiner r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
            if ((r10 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r12 = (ModuleAwareClassDescriptor) r10;
        L6:
            if (r12 == null) goto L9;
            MemberScope r13 = r12.getUnsubstitutedMemberScope(r11);
            if (r13 == null) goto L9;
            return r13;
        L9:
            MemberScope r14 = r10.getUnsubstitutedMemberScope();
            Intrinsics.checkNotNullExpressionValue(r14, "this.unsubstitutedMemberScope");
            return r14;
        L5:
            r12 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ModuleAwareClassDescriptor() {
    }

    protected abstract MemberScope getMemberScope(TypeSubstitution r10, KotlinTypeRefiner r11);

    protected abstract MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r10);
}
