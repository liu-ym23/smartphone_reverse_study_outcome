package kotlin.reflect.jvm.internal.impl.types.checker;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {

    public static final class Default extends KotlinTypePreparator {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }
    }

    public KotlinTypePreparator() {
    }

    private final SimpleType transformToNewType(SimpleType r17) {
        CapturedTypeConstructorImpl r0 = r17.getConstructor();
        boolean r2 = true;
        boolean r3 = false;
        IntersectionTypeConstructor r5 = null;
        if ((r0 instanceof CapturedTypeConstructorImpl) == false) goto L25;
        CapturedTypeConstructorImpl r1 = r0;
        TypeProjection r4 = r1.getProjection();
        if (r4.getProjectionKind() == Variance.IN_VARIANCE) goto L8;
        r2 = false;
    L8:
        if (r2 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L15;
        KotlinType r6 = r4.getType();
        if (r6 == null) goto L15;
        r5 = r6.unwrap();
    L15:
        IntersectionTypeConstructor r9 = r5;
        if (r1.getNewTypeConstructor() != null) goto L22;
        TypeProjection r11 = r1.getProjection();
        Collection r7 = r1.getSupertypes();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        r12.add(((KotlinType) r8.next()).unwrap());
        goto L19
    L21:
        r1.setNewTypeConstructor(new NewCapturedTypeConstructor(r11, r12, null, 4, null));
    L22:
        CaptureStatus r10 = CaptureStatus.FOR_SUBTYPING;
        NewCapturedTypeConstructor r13 = r1.getNewTypeConstructor();
        Intrinsics.checkNotNull(r13);
        return new NewCapturedType(r10, r13, r9, r17.getAttributes(), r17.isMarkedNullable(), false, 32, null);
    L25:
        if ((r0 instanceof IntegerValueTypeConstructor) == false) goto L33;
        Collection r14 = ((IntegerValueTypeConstructor) r0).getSupertypes();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L28:
        if (r16.hasNext() == false) goto L31;
        r15.add(TypeUtils.makeNullableAsSpecified((KotlinType) r16.next(), r17.isMarkedNullable()));
        goto L28
    L31:
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r17.getAttributes(), new IntersectionTypeConstructor(r15), CollectionsKt.emptyList(), false, r17.getMemberScope());
    L33:
        if ((r0 instanceof IntersectionTypeConstructor) == true) goto L35;
    L51:
        return r17;
    L35:
        if (r17.isMarkedNullable() == false) goto L51;
        IntersectionTypeConstructor r18 = (IntersectionTypeConstructor) r0;
        Collection r19 = r18.getSupertypes();
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L38:
        if (r21.hasNext() == false) goto L40;
        r20.add(TypeUtilsKt.makeNullable((KotlinType) r21.next()));
        r3 = true;
        goto L38
    L40:
        if (r3 == false) goto L46;
        KotlinType r22 = r18.getAlternativeType();
        if (r22 == null) goto L45;
        r5 = TypeUtilsKt.makeNullable(r22);
    L45:
        r5 = new IntersectionTypeConstructor(r20).setAlternative(r5);
    L46:
        if (r5 == null) goto L50;
        r18 = r5;
    L50:
        return r18.createType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public UnwrappedType prepareType(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, EffectConfiguration.KEY_TYPE);
        if ((r5 instanceof KotlinType) == false) goto L21;
        UnwrappedType r6 = ((KotlinType) r5).unwrap();
        if ((r6 instanceof SimpleType) == false) goto L8;
        UnwrappedType r0 = transformToNewType((SimpleType) r6);
    L17:
        return TypeWithEnhancementKt.inheritEnhancement(r0, r6, new prepareType.1(this));
    L8:
        if ((r6 instanceof FlexibleType) == false) goto L19;
        FlexibleType r1 = (FlexibleType) r6;
        SimpleType r2 = transformToNewType(r1.getLowerBound());
        SimpleType r3 = transformToNewType(r1.getUpperBound());
        if (r2 == r1.getLowerBound()) goto L12;
    L15:
        r0 = KotlinTypeFactory.flexibleType(r2, r3);
        goto L17
    L12:
        if (r3 != r1.getUpperBound()) goto L15;
        r0 = r6;
        goto L17
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public /* bridge */ /* synthetic */ KotlinTypeMarker prepareType(KotlinTypeMarker r1) {
        return prepareType(r1);
    }
}
