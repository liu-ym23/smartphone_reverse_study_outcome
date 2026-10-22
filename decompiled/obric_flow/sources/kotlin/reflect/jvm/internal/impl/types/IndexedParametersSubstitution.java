package kotlin.reflect.jvm.internal.impl.types;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/IndexedParametersSubstitution\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,207:1\n37#2,2:208\n*S KotlinDebug\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/IndexedParametersSubstitution\n*L\n127#1:208,2\n*E\n"})
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] r5, TypeProjection[] r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = false;
    L5:
        this(r5, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo1407get(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof TypeParameterDescriptor) == false) goto L5;
        TypeParameterDescriptor r11 = (TypeParameterDescriptor) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        int r12 = r11.getIndex();
        TypeParameterDescriptor[] r13 = this.parameters;
        if (r12 < r13.length) goto L11;
    L14:
        return null;
    L11:
        if (Intrinsics.areEqual(r13[r12].getTypeConstructor(), r11.getTypeConstructor()) == false) goto L14;
        return this.arguments[r12];
    L5:
        r11 = null;
        goto L6
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        if (this.arguments.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] r5, TypeProjection[] r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "parameters");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        this.parameters = r5;
        this.arguments = r10;
        this.approximateContravariantCapturedTypes = r11;
        int r12 = r5.length;
        int r13 = r10.length;
    }

    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> r10, List<? extends TypeProjection> r11) {
        Intrinsics.checkNotNullParameter(r10, "parameters");
        Intrinsics.checkNotNullParameter(r11, "argumentsList");
        boolean r5 = false;
        this((TypeParameterDescriptor[]) r10.toArray(new TypeParameterDescriptor[0]), (TypeProjection[]) r11.toArray(new TypeProjection[0]), r5, 4, null);
    }
}
