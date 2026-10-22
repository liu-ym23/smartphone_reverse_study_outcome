package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinTypeRefiner extends AbstractTypeRefiner {

    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId r5) {
            Intrinsics.checkNotNullParameter(r5, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r5, Function0<? extends S> r10) {
            Intrinsics.checkNotNullParameter(r5, "classDescriptor");
            Intrinsics.checkNotNullParameter(r10, "compute");
            return r10.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor r5) {
            Intrinsics.checkNotNullParameter(r5, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "classDescriptor");
            return r5.getTypeConstructor().mo1403getSupertypes();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public /* bridge */ /* synthetic */ KotlinTypeMarker refineType(KotlinTypeMarker r5) {
            return refineType(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public /* bridge */ /* synthetic */ ClassifierDescriptor refineDescriptor(DeclarationDescriptor r5) {
            return refineDescriptor(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public KotlinType refineType(KotlinTypeMarker r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            return (KotlinType) r5;
        }
    }

    public KotlinTypeRefiner() {
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId r5);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r5, Function0<? extends S> r10);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor r5);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor r5);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor r5);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor r5);

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
    public abstract KotlinType refineType(KotlinTypeMarker r5);
}
