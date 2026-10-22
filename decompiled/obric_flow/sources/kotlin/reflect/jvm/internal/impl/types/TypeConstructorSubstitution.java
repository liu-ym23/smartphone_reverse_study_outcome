package kotlin.reflect.jvm.internal.impl.types;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;

    @SourceDebugExtension({"SMAP\nTypeSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/TypeConstructorSubstitution$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,207:1\n1549#2:208\n1620#2,3:209\n*S KotlinDebug\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/TypeConstructorSubstitution$Companion\n*L\n96#1:208\n96#1:209,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion r5, Map r10, boolean r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L6;
            r11 = false;
        L6:
            return r5.createByConstructorsMap(r10, r11);
        }

        @JvmStatic
        public final TypeSubstitution create(KotlinType r5) {
            Intrinsics.checkNotNullParameter(r5, "kotlinType");
            return create(r5.getConstructor(), r5.getArguments());
        }

        @JvmStatic
        @JvmOverloads
        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            return createByConstructorsMap$default(this, r5, false, 2, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final TypeSubstitution create(TypeConstructor r5, List<? extends TypeProjection> r10) {
            Intrinsics.checkNotNullParameter(r5, "typeConstructor");
            Intrinsics.checkNotNullParameter(r10, "arguments");
            List<TypeParameterDescriptor> r11 = r5.getParameters();
            TypeParameterDescriptor r12 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(r11);
            if (r12 == null) goto L13;
            if (r12.isCapturedFromOuterDeclaration() != true) goto L13;
            List<TypeParameterDescriptor> r13 = r5.getParameters();
            ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
            Iterator<T> r15 = r13.iterator();
        L8:
            if (r15.hasNext() == false) goto L11;
            r14.add(((TypeParameterDescriptor) r15.next()).getTypeConstructor());
            goto L8
        L11:
            return createByConstructorsMap$default(this, MapsKt.toMap(CollectionsKt.zip(r14, r10)), false, 2, null);
        L13:
            return new IndexedParametersSubstitution(r11, r10);
        }

        @JvmStatic
        @JvmOverloads
        public final TypeConstructorSubstitution createByConstructorsMap(final Map<TypeConstructor, ? extends TypeProjection> r5, final boolean r10) {
            Intrinsics.checkNotNullParameter(r5, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(r5, r10);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TypeConstructorSubstitution() {
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeConstructor r5, List<? extends TypeProjection> r10) {
        return Companion.create(r5, r10);
    }

    @JvmStatic
    @JvmOverloads
    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r5) {
        return Companion.createByConstructorsMap(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo1407get(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return get(r5.getConstructor());
    }

    public abstract TypeProjection get(TypeConstructor r5);
}
