package kotlin.reflect.jvm.internal.impl.types.checker;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class KotlinTypeRefiner extends AbstractTypeRefiner {

    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId r2) {
            Intrinsics.checkNotNullParameter(r2, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor r2) {
            Intrinsics.checkNotNullParameter(r2, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            return null;
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public /* bridge */ /* synthetic */ ClassifierDescriptor refineDescriptor(DeclarationDescriptor r1) {
            return refineDescriptor(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "classDescriptor");
            return r2.getTypeConstructor().getSupertypes();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public KotlinType refineType(KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
            return (KotlinType) r2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public /* bridge */ /* synthetic */ KotlinTypeMarker refineType(KotlinTypeMarker r1) {
            return refineType(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r2, Function0<? extends S> r3) {
            Intrinsics.checkNotNullParameter(r2, "classDescriptor");
            Intrinsics.checkNotNullParameter(r3, "compute");
            return (S) r3.invoke();
        }
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId r1);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r1, Function0<? extends S> r2);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor r1);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor r1);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor r1);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
    public abstract KotlinType refineType(KotlinTypeMarker r1);

    public KotlinTypeRefiner() {
    }
}
