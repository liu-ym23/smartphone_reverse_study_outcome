package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final Companion Companion = null;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor r5, TypeSubstitution r10, KotlinTypeRefiner r11) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r10, "typeSubstitution");
            Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
            if ((r5 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r12 = (ModuleAwareClassDescriptor) r5;
        L6:
            if (r12 == null) goto L10;
            MemberScope r13 = r12.getMemberScope(r10, r11);
            if (r13 == null) goto L10;
            return r13;
        L10:
            return r5.getMemberScope(r10);
        L5:
            r12 = null;
            goto L6
        }

        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor r5, KotlinTypeRefiner r10) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
            if ((r5 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r11 = (ModuleAwareClassDescriptor) r5;
        L6:
            if (r11 == null) goto L10;
            MemberScope r12 = r11.getUnsubstitutedMemberScope(r10);
            if (r12 == null) goto L10;
            return r12;
        L10:
            return r5.getUnsubstitutedMemberScope();
        L5:
            r11 = null;
            goto L6
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ModuleAwareClassDescriptor() {
    }

    public abstract MemberScope getMemberScope(TypeSubstitution r5, KotlinTypeRefiner r10);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    public abstract MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r5);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }
}
