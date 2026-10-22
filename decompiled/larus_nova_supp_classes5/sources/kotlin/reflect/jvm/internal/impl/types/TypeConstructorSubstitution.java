package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r4) {
            Intrinsics.checkNotNullParameter(r4, "map");
            return createByConstructorsMap$default(this, r4, false, 2, null);
        }

        @JvmStatic
        public final TypeSubstitution create(KotlinType r2) {
            Intrinsics.checkNotNullParameter(r2, "kotlinType");
            return create(r2.getConstructor(), r2.getArguments());
        }

        @JvmStatic
        public final TypeSubstitution create(TypeConstructor r5, List<? extends TypeProjection> r6) {
            Intrinsics.checkNotNullParameter(r5, "typeConstructor");
            Intrinsics.checkNotNullParameter(r6, "arguments");
            List<TypeParameterDescriptor> r0 = r5.getParameters();
            TypeParameterDescriptor r1 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(r0);
            if (r1 == null) goto L7;
            boolean r3 = true;
            if (r1.isCapturedFromOuterDeclaration() != true) goto L7;
        L8:
            if (r3 == false) goto L16;
            List<TypeParameterDescriptor> r7 = r5.getParameters();
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r8 = r7.iterator();
        L11:
            if (r8.hasNext() == false) goto L14;
            r2.add(((TypeParameterDescriptor) r8.next()).getTypeConstructor());
            goto L11
        L14:
            return createByConstructorsMap$default(this, MapsKt.toMap(CollectionsKt.zip(r2, r6)), false, 2, null);
        L16:
            return new IndexedParametersSubstitution(r0, r6);
        L7:
            r3 = false;
            goto L8
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(final Map<TypeConstructor, ? extends TypeProjection> r2, final boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(r2, r3);
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion r0, Map r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.createByConstructorsMap(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeConstructor r1, List<? extends TypeProjection> r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r1) {
        return Companion.createByConstructorsMap(r1);
    }

    public abstract TypeProjection get(TypeConstructor r1);

    public TypeConstructorSubstitution() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo385get(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return get(r2.getConstructor());
    }
}
