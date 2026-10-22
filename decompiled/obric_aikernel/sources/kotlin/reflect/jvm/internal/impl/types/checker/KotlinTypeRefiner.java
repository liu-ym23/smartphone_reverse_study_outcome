package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.common.wschannel.WsConstants;
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
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId r10) {
            Intrinsics.checkNotNullParameter(r10, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r10, Function0<? extends S> r11) {
            Intrinsics.checkNotNullParameter(r10, "classDescriptor");
            Intrinsics.checkNotNullParameter(r11, "compute");
            return r11.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor r10) {
            Intrinsics.checkNotNullParameter(r10, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public /* bridge */ /* synthetic */ ClassifierDescriptor refineDescriptor(DeclarationDescriptor r10) {
            return refineDescriptor(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "classDescriptor");
            Collection<KotlinType> r11 = r10.getTypeConstructor().mo1324getSupertypes();
            Intrinsics.checkNotNullExpressionValue(r11, "classDescriptor.typeConstructor.supertypes");
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public KotlinType refineType(KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            return (KotlinType) r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public /* bridge */ /* synthetic */ KotlinTypeMarker refineType(KotlinTypeMarker r10) {
            return refineType(r10);
        }
    }

    public KotlinTypeRefiner() {
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId r10);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r10, Function0<? extends S> r11);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor r10);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor r10);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor r10);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
    public abstract KotlinType refineType(KotlinTypeMarker r10);
}
