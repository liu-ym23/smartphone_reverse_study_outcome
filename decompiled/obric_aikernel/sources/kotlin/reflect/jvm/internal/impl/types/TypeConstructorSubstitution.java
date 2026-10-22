package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion r10, Map r11, boolean r12, int r13, Object r14) {
            if ((r13 & 2) == 0) goto L6;
            r12 = false;
        L6:
            return r10.createByConstructorsMap(r11, r12);
        }

        @JvmStatic
        public final TypeSubstitution create(KotlinType r10) {
            Intrinsics.checkNotNullParameter(r10, "kotlinType");
            return create(r10.getConstructor(), r10.getArguments());
        }

        @JvmStatic
        public final TypeSubstitution create(TypeConstructor r10, List<? extends TypeProjection> r11) {
            Intrinsics.checkNotNullParameter(r10, "typeConstructor");
            Intrinsics.checkNotNullParameter(r11, "arguments");
            List<TypeParameterDescriptor> r12 = r10.getParameters();
            Intrinsics.checkNotNullExpressionValue(r12, "typeConstructor.parameters");
            TypeParameterDescriptor r13 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(r12);
            boolean r14 = true;
            if (r13 != null) goto L5;
        L7:
            r14 = false;
        L8:
            if (r14 == false) goto L16;
            List<TypeParameterDescriptor> r15 = r10.getParameters();
            Intrinsics.checkNotNullExpressionValue(r15, "typeConstructor.parameters");
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator<T> r17 = r15.iterator();
        L11:
            if (r17.hasNext() == false) goto L14;
            r16.add(((TypeParameterDescriptor) r17.next()).getTypeConstructor());
            goto L11
        L14:
            return createByConstructorsMap$default(this, MapsKt.toMap(CollectionsKt.zip(r16, r11)), false, 2, null);
        L16:
            return new IndexedParametersSubstitution(r12, r11);
        L5:
            if (r13.isCapturedFromOuterDeclaration() != true) goto L7;
            goto L7
        }

        @JvmStatic
        @JvmOverloads
        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r10) {
            Intrinsics.checkNotNullParameter(r10, "map");
            return createByConstructorsMap$default(this, r10, false, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        public final TypeConstructorSubstitution createByConstructorsMap(final Map<TypeConstructor, ? extends TypeProjection> r10, final boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(r10, r11);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TypeConstructorSubstitution() {
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeConstructor r10, List<? extends TypeProjection> r11) {
        return Companion.create(r10, r11);
    }

    @JvmStatic
    @JvmOverloads
    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r10) {
        return Companion.createByConstructorsMap(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo1328get(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return get(r10.getConstructor());
    }

    public abstract TypeProjection get(TypeConstructor r10);
}
