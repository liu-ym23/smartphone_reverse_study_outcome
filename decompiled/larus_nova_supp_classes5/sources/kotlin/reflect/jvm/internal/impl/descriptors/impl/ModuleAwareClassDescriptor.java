package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor r2, KotlinTypeRefiner r3) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Intrinsics.checkNotNullParameter(r3, "kotlinTypeRefiner");
            if ((r2 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r0 = (ModuleAwareClassDescriptor) r2;
        L6:
            if (r0 == null) goto L10;
            MemberScope r4 = r0.getUnsubstitutedMemberScope(r3);
            if (r4 == null) goto L10;
            return r4;
        L10:
            return r2.getUnsubstitutedMemberScope();
        L5:
            r0 = null;
            goto L6
        }

        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor r2, TypeSubstitution r3, KotlinTypeRefiner r4) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Intrinsics.checkNotNullParameter(r3, "typeSubstitution");
            Intrinsics.checkNotNullParameter(r4, "kotlinTypeRefiner");
            if ((r2 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r0 = (ModuleAwareClassDescriptor) r2;
        L6:
            if (r0 == null) goto L10;
            MemberScope r5 = r0.getMemberScope(r3, r4);
            if (r5 == null) goto L10;
            return r5;
        L10:
            return r2.getMemberScope(r3);
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ModuleAwareClassDescriptor() {
    }

    public abstract MemberScope getMemberScope(TypeSubstitution r1, KotlinTypeRefiner r2);

    public abstract MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r1);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }
}
