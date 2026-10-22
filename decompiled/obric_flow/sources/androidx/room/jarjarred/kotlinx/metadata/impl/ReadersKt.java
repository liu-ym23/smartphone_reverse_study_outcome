package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.InconsistentKotlinMetadataException;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmContractVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectInvocationKind;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectType;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmLambdaVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmVariance;
import androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementLevel;
import androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVersionKind;
import androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.Flags;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.ProtoTypeTableUtilKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.TypeTable;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.VersionRequirement;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.VersionRequirementTable;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0018\u0010\u0011\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0012\u001a\u00060\u0001j\u0002`\u0002H\u0002\u001a*\u0010\u0013\u001a\u00020\u000b*\u00020\u00142\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020\u001b2\u0006\u0010\r\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020\u001d2\u0006\u0010\r\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020\u001f2\u0006\u0010\r\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020!2\u0006\u0010\r\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020#2\u0006\u0010\r\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0010H\u0002\u001a\u001a\u0010\u0013\u001a\u00020\u000b*\u00020#2\u0006\u0010\r\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017\u001a*\u0010\u0013\u001a\u00020\u000b*\u00020'2\u0006\u0010\r\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u001a*\u0010\u0013\u001a\u00020\u000b*\u00020)2\u0006\u0010\r\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u001a\u001a\u0010\u0013\u001a\u00020\u000b*\u00020+2\u0006\u0010\r\u001a\u00020,2\u0006\u0010%\u001a\u00020\u0010\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\r\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020.2\u0006\u0010\r\u001a\u00020/2\u0006\u0010%\u001a\u00020\u0010H\u0002\u001a}\u0010\u0013\u001a\u00020\u000b*\u00020\u00072f\u00100\u001ab\u0012\u0017\u0012\u00150\u0001j\u0002`\u0002¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u001104¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\f\u0012\u0013\u0012\u001105¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0006\u0012\u0004\u0018\u000107012\u0006\u0010\u000f\u001a\u00020\u0010H\u0082\b\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\r\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u0002082\u0006\u0010\r\u001a\u0002092\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u000e\u0010:\u001a\u00060\u0001j\u0002`\u0002*\u00020+\u001a\u000e\u0010;\u001a\u00060\u0001j\u0002`\u0002*\u00020+\u001a\u0016\u0010<\u001a\u0004\u0018\u00010\u0003*\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a>\u0010=\u001a\u00020\u000b*\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020#0\u00192\f\u0010@\u001a\b\u0012\u0004\u0012\u00020+0\u00192\f\u0010A\u001a\b\u0012\u0004\u0012\u00020.0\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u001c\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006B"}, d2 = {"typeFlags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type;", "getTypeFlags", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;)I", "typeParameterFlags", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "getTypeParameterFlags", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$TypeParameter;)I", "acceptVersionRequirementVisitor", "", "id", "v", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContext;", "getDefaultPropertyAccessorFlags", "flags", "accept", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "strings", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "contextExtensions", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContextExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Contract;", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Effect;", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Expression;", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function;", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "outer", "Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "visit", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "getPropertyGetterFlags", "getPropertySetterFlags", "loadInlineClassUnderlyingType", "visitDeclarations", "Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainerVisitor;", "functions", "properties", "typeAliases", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ReadersKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = null;

        static {
            int[] r5 = new int[ProtoBuf.TypeParameter.Variance.values().length];
            r5[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L83:
            r5[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L97:
            r5[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L8:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            r10[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L85:
            r10[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L99:
            r10[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L57:
            r10[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L13:
            $EnumSwitchMapping$1 = r10;
            int[] r11 = new int[ProtoBuf.VersionRequirement.VersionKind.values().length];
            r11[ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L87:
            r11[ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L59:
            r11[ProtoBuf.VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L44
        L17:
            $EnumSwitchMapping$2 = r11;
            int[] r12 = new int[DeprecationLevel.values().length];
            r12[DeprecationLevel.WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
        L89:
            r12[DeprecationLevel.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
        L61:
            r12[DeprecationLevel.HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L47
        L21:
            $EnumSwitchMapping$3 = r12;
            int[] r13 = new int[ProtoBuf.Effect.EffectType.values().length];
            r13[ProtoBuf.Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L48
        L91:
            r13[ProtoBuf.Effect.EffectType.CALLS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L49
        L63:
            r13[ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L50
        L25:
            $EnumSwitchMapping$4 = r13;
            int[] r14 = new int[ProtoBuf.Effect.InvocationKind.values().length];
            r14[ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L51
        L65:
            r14[ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L52
        L69:
            r14[ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L53
        L29:
            $EnumSwitchMapping$5 = r14;
            int[] r15 = new int[ProtoBuf.Expression.ConstantValue.values().length];
            r15[ProtoBuf.Expression.ConstantValue.TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
        L67:
            r15[ProtoBuf.Expression.ConstantValue.FALSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
        L73:
            r15[ProtoBuf.Expression.ConstantValue.NULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L56
        L33:
            $EnumSwitchMapping$6 = r15;
        }
    }

    public static final void accept(ProtoBuf.Class r10, KmClassVisitor r11, NameResolver r12, List<? extends ReadContextExtension> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "v");
        Intrinsics.checkNotNullParameter(r12, "strings");
        Intrinsics.checkNotNullParameter(r13, "contextExtensions");
        ReadContext r5 = null;
        ReadContext r14 = new ReadContext(r12, new TypeTable(r10.getTypeTable()), VersionRequirementTable.Companion.create(r10.getVersionRequirementTable()), r5, r13, 8, null).withTypeParameters(r10.getTypeParameterList());
        r11.visit(r10.getFlags(), r14.className(r10.getFqName()));
        Iterator<ProtoBuf.TypeParameter> r15 = r10.getTypeParameterList().iterator();
    L4:
        if (r15.hasNext() == false) goto L18;
        ProtoBuf.TypeParameter r16 = r15.next();
        ProtoBuf.TypeParameter.Variance r17 = r16.getVariance();
        Intrinsics.checkNotNull(r17);
        int r18 = WhenMappings.$EnumSwitchMapping$0[r17.ordinal()];
        if (r18 == 1) goto L14;
        if (r18 != 2) goto L9;
        KmVariance r19 = KmVariance.OUT;
    L15:
        KmTypeParameterVisitor r20 = r11.visitTypeParameter(getTypeParameterFlags(r16), r14.get(r16.getName()), r16.getId(), r19);
        if (r20 == null) goto L4;
        accept(r16, r20, r14);
        goto L4
    L9:
        if (r18 != 3) goto L12;
        r19 = KmVariance.INVARIANT;
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        r19 = KmVariance.IN;
        goto L15
    L18:
        Iterator<ProtoBuf.Type> r110 = ProtoTypeTableUtilKt.supertypes(r10, r14.getTypes()).iterator();
    L20:
        if (r110.hasNext() == false) goto L24;
        ProtoBuf.Type r21 = r110.next();
        KmTypeVisitor r22 = r11.visitSupertype(getTypeFlags(r21));
        if (r22 == null) goto L20;
        accept(r21, r22, r14);
        goto L20
    L24:
        Iterator<ProtoBuf.Constructor> r111 = r10.getConstructorList().iterator();
    L26:
        if (r111.hasNext() == false) goto L30;
        ProtoBuf.Constructor r23 = r111.next();
        KmConstructorVisitor r24 = r11.visitConstructor(r23.getFlags());
        if (r24 == null) goto L26;
        accept(r23, r24, r14);
        goto L26
    L30:
        visitDeclarations(r11, r10.getFunctionList(), r10.getPropertyList(), r10.getTypeAliasList(), r14);
        if (r10.hasCompanionObjectName() == false) goto L33;
        r11.visitCompanionObject(r14.get(r10.getCompanionObjectName()));
    L33:
        Iterator<Integer> r112 = r10.getNestedClassNameList().iterator();
    L35:
        if (r112.hasNext() == false) goto L37;
        r11.visitNestedClass(r14.get(r112.next().intValue()));
        goto L35
    L37:
        Iterator<ProtoBuf.EnumEntry> r113 = r10.getEnumEntryList().iterator();
    L39:
        if (r113.hasNext() == false) goto L45;
        ProtoBuf.EnumEntry r25 = r113.next();
        if (r25.hasName() == false) goto L44;
        r11.visitEnumEntry(r14.get(r25.getName()));
        goto L39
    L44:
        throw new InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
    L45:
        Iterator<Integer> r114 = r10.getSealedSubclassFqNameList().iterator();
    L47:
        if (r114.hasNext() == false) goto L50;
        r11.visitSealedSubclass(r14.className(r114.next().intValue()));
        goto L47
    L50:
        if (r10.hasInlineClassUnderlyingPropertyName() == false) goto L52;
        r11.visitInlineClassUnderlyingPropertyName(r14.get(r10.getInlineClassUnderlyingPropertyName()));
    L52:
        ProtoBuf.Type r115 = loadInlineClassUnderlyingType(r10, r14);
        if (r115 == null) goto L57;
        KmTypeVisitor r26 = r11.visitInlineClassUnderlyingType(getTypeFlags(r115));
        if (r26 == null) goto L57;
        accept(r115, r26, r14);
    L57:
        Iterator<ProtoBuf.Type> r116 = ProtoTypeTableUtilKt.contextReceiverTypes(r10, r14.getTypes()).iterator();
    L59:
        if (r116.hasNext() == false) goto L63;
        ProtoBuf.Type r27 = r116.next();
        KmTypeVisitor r28 = r11.visitContextReceiverType(getTypeFlags(r27));
        if (r28 == null) goto L59;
        accept(r27, r28, r14);
        goto L59
    L63:
        Iterator<Integer> r117 = r10.getVersionRequirementList().iterator();
    L65:
        if (r117.hasNext() == false) goto L69;
        Integer r29 = r117.next();
        KmVersionRequirementVisitor r30 = r11.visitVersionRequirement();
        if (r30 == null) goto L65;
        acceptVersionRequirementVisitor(r29.intValue(), r30, r14);
        goto L65
    L69:
        Iterator<MetadataExtensions> r118 = r14.getExtensions$kotlinx_metadata().iterator();
    L71:
        if (r118.hasNext() == false) goto L73;
        r118.next().readClassExtensions(r11, r10, r14);
        goto L71
    L73:
        r11.visitEnd();
    }

    public static /* synthetic */ void accept$default(ProtoBuf.Class r5, KmClassVisitor r10, NameResolver r11, List r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        accept(r5, r10, r11, r12);
    }

    private static final void acceptVersionRequirementVisitor(int r5, KmVersionRequirementVisitor r10, ReadContext r11) {
        VersionRequirement r12 = VersionRequirement.Companion.create(r5, r11.getStrings(), r11.getVersionRequirements$kotlinx_metadata());
        if (r12 == null) goto L25;
        ProtoBuf.VersionRequirement.VersionKind r13 = r12.getKind();
        int r14 = WhenMappings.$EnumSwitchMapping$2[r13.ordinal()];
        if (r14 == 1) goto L12;
        if (r14 == 2) goto L11;
        if (r14 != 3) goto L10;
        KmVersionRequirementVersionKind r15 = KmVersionRequirementVersionKind.API_VERSION;
    L13:
        DeprecationLevel r16 = r12.getLevel();
        int r17 = WhenMappings.$EnumSwitchMapping$3[r16.ordinal()];
        if (r17 == 1) goto L21;
        if (r17 == 2) goto L20;
        if (r17 != 3) goto L19;
        KmVersionRequirementLevel r18 = KmVersionRequirementLevel.HIDDEN;
    L22:
        r10.visit(r15, r18, r12.getErrorCode(), r12.getMessage());
        VersionRequirement.Version r19 = r12.getVersion();
        r10.visitVersion(r19.component1(), r19.component2(), r19.component3());
        r10.visitEnd();
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        r18 = KmVersionRequirementLevel.ERROR;
        goto L22
    L21:
        r18 = KmVersionRequirementLevel.WARNING;
        goto L22
    L10:
        throw new NoWhenBranchMatchedException();
    L11:
        r15 = KmVersionRequirementVersionKind.COMPILER_VERSION;
        goto L13
    L12:
        r15 = KmVersionRequirementVersionKind.LANGUAGE_VERSION;
        goto L13
    L25:
        throw new InconsistentKotlinMetadataException("No VersionRequirement with the given id in the table", null, 2, null);
    }

    private static final int getDefaultPropertyAccessorFlags(int r10) {
        return Flags.getAccessorFlags(Flags.HAS_ANNOTATIONS.get(r10).booleanValue(), Flags.VISIBILITY.get(r10), Flags.MODALITY.get(r10), false, false, false);
    }

    public static final int getPropertyGetterFlags(ProtoBuf.Property r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.hasGetterFlags() == false) goto L6;
        return r5.getGetterFlags();
    L6:
        return getDefaultPropertyAccessorFlags(r5.getFlags());
    }

    public static final int getPropertySetterFlags(ProtoBuf.Property r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.hasSetterFlags() == false) goto L6;
        return r5.getSetterFlags();
    L6:
        return getDefaultPropertyAccessorFlags(r5.getFlags());
    }

    private static final int getTypeFlags(ProtoBuf.Type r5) {
        boolean r10 = r5.getNullable();
        int r11 = r5.getFlags() << 1;
        return (r10 ? 1 : 0) + r11;
    }

    private static final int getTypeParameterFlags(ProtoBuf.TypeParameter r5) {
        return r5.getReified() ? 1 : 0;
    }

    private static final ProtoBuf.Type loadInlineClassUnderlyingType(ProtoBuf.Class r10, ReadContext r11) {
        ProtoBuf.Type r5 = ProtoTypeTableUtilKt.inlineClassUnderlyingType(r10, r11.getTypes());
        if (r5 == null) goto L6;
        return r5;
    L6:
        if (r10.hasInlineClassUnderlyingPropertyName() == true) goto L8;
        return null;
    L8:
        Iterator<T> r12 = r10.getPropertyList().iterator();
        boolean r13 = false;
        Object r14 = null;
    L10:
        if (r12.hasNext() == false) goto L18;
        Object r15 = r12.next();
        ProtoBuf.Property r16 = (ProtoBuf.Property) r15;
        if (ProtoTypeTableUtilKt.receiverType(r16, r11.getTypes()) != null) goto L10;
        if (Intrinsics.areEqual(r11.get(r16.getName()), r11.get(r10.getInlineClassUnderlyingPropertyName())) == false) goto L10;
        if (r13 == true) goto L16;
        r13 = true;
        r14 = r15;
    L16:
        r14 = null;
    L20:
        ProtoBuf.Property r17 = (ProtoBuf.Property) r14;
        if (r17 != null) goto L23;
        return null;
    L23:
        return ProtoTypeTableUtilKt.returnType(r17, r11.getTypes());
    L18:
        if (r13 == true) goto L20;
        goto L20
    }

    private static final void visitDeclarations(KmDeclarationContainerVisitor r5, List<ProtoBuf.Function> r10, List<ProtoBuf.Property> r11, List<ProtoBuf.TypeAlias> r12, ReadContext r13) {
        Iterator<ProtoBuf.Function> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        ProtoBuf.Function r15 = r14.next();
        KmFunctionVisitor r16 = r5.visitFunction(r15.getFlags(), r13.get(r15.getName()));
        if (r16 == null) goto L4;
        accept(r15, r16, r13);
        goto L4
    L8:
        Iterator<ProtoBuf.Property> r17 = r11.iterator();
    L10:
        if (r17.hasNext() == false) goto L14;
        ProtoBuf.Property r18 = r17.next();
        KmPropertyVisitor r19 = r5.visitProperty(r18.getFlags(), r13.get(r18.getName()), getPropertyGetterFlags(r18), getPropertySetterFlags(r18));
        if (r19 == null) goto L10;
        accept(r18, r19, r13);
        goto L10
    L14:
        Iterator<ProtoBuf.TypeAlias> r20 = r12.iterator();
    L16:
        if (r20.hasNext() == false) goto L20;
        ProtoBuf.TypeAlias r21 = r20.next();
        KmTypeAliasVisitor r22 = r5.visitTypeAlias(r21.getFlags(), r13.get(r21.getName()));
        if (r22 == null) goto L16;
        accept(r21, r22, r13);
        goto L16
    }

    public static /* synthetic */ void accept$default(ProtoBuf.Package r5, KmPackageVisitor r10, NameResolver r11, List r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        accept(r5, r10, r11, r12);
    }

    public static /* synthetic */ void accept$default(ProtoBuf.PackageFragment r5, KmModuleFragmentVisitor r10, NameResolver r11, List r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        accept(r5, r10, r11, r12);
    }

    public static final void accept(ProtoBuf.Package r10, KmPackageVisitor r11, NameResolver r12, List<? extends ReadContextExtension> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "v");
        Intrinsics.checkNotNullParameter(r12, "strings");
        Intrinsics.checkNotNullParameter(r13, "contextExtensions");
        ReadContext r5 = null;
        ReadContext r14 = new ReadContext(r12, new TypeTable(r10.getTypeTable()), VersionRequirementTable.Companion.create(r10.getVersionRequirementTable()), r5, r13, 8, null);
        visitDeclarations(r11, r10.getFunctionList(), r10.getPropertyList(), r10.getTypeAliasList(), r14);
        Iterator<MetadataExtensions> r15 = r14.getExtensions$kotlinx_metadata().iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r15.next().readPackageExtensions(r11, r10, r14);
        goto L4
    L6:
        r11.visitEnd();
    }

    public static final void accept(ProtoBuf.PackageFragment r10, KmModuleFragmentVisitor r11, NameResolver r12, List<? extends ReadContextExtension> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "v");
        Intrinsics.checkNotNullParameter(r12, "strings");
        Intrinsics.checkNotNullParameter(r13, "contextExtensions");
        ReadContext r5 = null;
        ReadContext r14 = new ReadContext(r12, new TypeTable(ProtoBuf.TypeTable.newBuilder().build()), VersionRequirementTable.Companion.getEMPTY(), r5, r13, 8, null);
        KmPackageVisitor r15 = r11.visitPackage();
        if (r15 == null) goto L5;
        accept(r10.getPackage(), r15, r12, r13);
    L5:
        Iterator<T> r16 = r10.getClass_List().iterator();
    L7:
        if (r16.hasNext() == false) goto L11;
        ProtoBuf.Class r17 = (ProtoBuf.Class) r16.next();
        KmClassVisitor r18 = r11.visitClass();
        if (r18 == null) goto L7;
        accept(r17, r18, r12, r13);
        goto L7
    L11:
        Iterator<MetadataExtensions> r19 = r14.getExtensions$kotlinx_metadata().iterator();
    L13:
        if (r19.hasNext() == false) goto L15;
        r19.next().readModuleFragmentExtensions(r11, r10, r14);
        goto L13
    L15:
        r11.visitEnd();
    }

    public static final void accept(ProtoBuf.Function r10, KmLambdaVisitor r11, NameResolver r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "v");
        Intrinsics.checkNotNullParameter(r12, "strings");
        ReadContext r5 = null;
        List r13 = null;
        ReadContext r14 = new ReadContext(r12, new TypeTable(r10.getTypeTable()), VersionRequirementTable.Companion.getEMPTY(), r5, r13, 24, null);
        KmFunctionVisitor r15 = r11.visitFunction(r10.getFlags(), r14.get(r10.getName()));
        if (r15 == null) goto L5;
        accept(r10, r15, r14);
    L5:
        r11.visitEnd();
    }

    private static final void accept(ProtoBuf.Constructor r5, KmConstructorVisitor r10, ReadContext r11) {
        Iterator<ProtoBuf.ValueParameter> r12 = r5.getValueParameterList().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ProtoBuf.ValueParameter r13 = r12.next();
        KmValueParameterVisitor r14 = r10.visitValueParameter(r13.getFlags(), r11.get(r13.getName()));
        if (r14 == null) goto L4;
        accept(r13, r14, r11);
        goto L4
    L8:
        Iterator<Integer> r15 = r5.getVersionRequirementList().iterator();
    L10:
        if (r15.hasNext() == false) goto L14;
        Integer r16 = r15.next();
        KmVersionRequirementVisitor r17 = r10.visitVersionRequirement();
        if (r17 == null) goto L10;
        acceptVersionRequirementVisitor(r16.intValue(), r17, r11);
        goto L10
    L14:
        Iterator<MetadataExtensions> r18 = r11.getExtensions$kotlinx_metadata().iterator();
    L16:
        if (r18.hasNext() == false) goto L18;
        r18.next().readConstructorExtensions(r10, r5, r11);
        goto L16
    L18:
        r10.visitEnd();
    }

    private static final void accept(ProtoBuf.Function r10, KmFunctionVisitor r11, ReadContext r12) {
        ReadContext r13 = r12.withTypeParameters(r10.getTypeParameterList());
        Iterator<ProtoBuf.TypeParameter> r5 = r10.getTypeParameterList().iterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        ProtoBuf.TypeParameter r14 = r5.next();
        ProtoBuf.TypeParameter.Variance r15 = r14.getVariance();
        Intrinsics.checkNotNull(r15);
        int r16 = WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
        if (r16 != 1) goto L8;
        KmVariance r17 = KmVariance.IN;
    L16:
        KmTypeParameterVisitor r18 = r11.visitTypeParameter(getTypeParameterFlags(r14), r13.get(r14.getName()), r14.getId(), r17);
        if (r18 == null) goto L4;
        accept(r14, r18, r13);
        goto L4
    L8:
        if (r16 != 2) goto L10;
        r17 = KmVariance.OUT;
        goto L16
    L10:
        if (r16 != 3) goto L13;
        r17 = KmVariance.INVARIANT;
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    L19:
        ProtoBuf.Type r19 = ProtoTypeTableUtilKt.receiverType(r10, r13.getTypes());
        if (r19 == null) goto L24;
        KmTypeVisitor r20 = r11.visitReceiverParameterType(getTypeFlags(r19));
        if (r20 == null) goto L24;
        accept(r19, r20, r13);
    L24:
        Iterator<ProtoBuf.Type> r21 = ProtoTypeTableUtilKt.contextReceiverTypes(r10, r13.getTypes()).iterator();
    L26:
        if (r21.hasNext() == false) goto L30;
        ProtoBuf.Type r22 = r21.next();
        KmTypeVisitor r23 = r11.visitContextReceiverType(getTypeFlags(r22));
        if (r23 == null) goto L26;
        accept(r22, r23, r13);
        goto L26
    L30:
        Iterator<ProtoBuf.ValueParameter> r24 = r10.getValueParameterList().iterator();
    L32:
        if (r24.hasNext() == false) goto L36;
        ProtoBuf.ValueParameter r25 = r24.next();
        KmValueParameterVisitor r26 = r11.visitValueParameter(r25.getFlags(), r13.get(r25.getName()));
        if (r26 == null) goto L32;
        accept(r25, r26, r13);
        goto L32
    L36:
        ProtoBuf.Type r27 = ProtoTypeTableUtilKt.returnType(r10, r13.getTypes());
        KmTypeVisitor r28 = r11.visitReturnType(getTypeFlags(r27));
        if (r28 == null) goto L40;
        accept(r27, r28, r13);
    L40:
        if (r10.hasContract() == false) goto L44;
        KmContractVisitor r29 = r11.visitContract();
        if (r29 == null) goto L44;
        accept(r10.getContract(), r29, r13);
    L44:
        Iterator<Integer> r30 = r10.getVersionRequirementList().iterator();
    L46:
        if (r30.hasNext() == false) goto L50;
        Integer r31 = r30.next();
        KmVersionRequirementVisitor r32 = r11.visitVersionRequirement();
        if (r32 == null) goto L46;
        acceptVersionRequirementVisitor(r31.intValue(), r32, r13);
        goto L46
    L50:
        Iterator<MetadataExtensions> r33 = r13.getExtensions$kotlinx_metadata().iterator();
    L52:
        if (r33.hasNext() == false) goto L54;
        r33.next().readFunctionExtensions(r11, r10, r13);
        goto L52
    L54:
        r11.visitEnd();
    }

    public static final void accept(ProtoBuf.Property r10, KmPropertyVisitor r11, ReadContext r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "v");
        Intrinsics.checkNotNullParameter(r12, "outer");
        ReadContext r13 = r12.withTypeParameters(r10.getTypeParameterList());
        Iterator<ProtoBuf.TypeParameter> r5 = r10.getTypeParameterList().iterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        ProtoBuf.TypeParameter r14 = r5.next();
        ProtoBuf.TypeParameter.Variance r15 = r14.getVariance();
        Intrinsics.checkNotNull(r15);
        int r16 = WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
        if (r16 != 1) goto L8;
        KmVariance r17 = KmVariance.IN;
    L16:
        KmTypeParameterVisitor r18 = r11.visitTypeParameter(getTypeParameterFlags(r14), r13.get(r14.getName()), r14.getId(), r17);
        if (r18 == null) goto L4;
        accept(r14, r18, r13);
        goto L4
    L8:
        if (r16 != 2) goto L10;
        r17 = KmVariance.OUT;
        goto L16
    L10:
        if (r16 != 3) goto L13;
        r17 = KmVariance.INVARIANT;
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    L19:
        ProtoBuf.Type r19 = ProtoTypeTableUtilKt.receiverType(r10, r13.getTypes());
        if (r19 == null) goto L24;
        KmTypeVisitor r20 = r11.visitReceiverParameterType(getTypeFlags(r19));
        if (r20 == null) goto L24;
        accept(r19, r20, r13);
    L24:
        Iterator<ProtoBuf.Type> r21 = ProtoTypeTableUtilKt.contextReceiverTypes(r10, r13.getTypes()).iterator();
    L26:
        if (r21.hasNext() == false) goto L31;
        ProtoBuf.Type r22 = r21.next();
        KmTypeVisitor r23 = r11.visitContextReceiverType(getTypeFlags(r22));
        if (r23 == null) goto L26;
        accept(r22, r23, r13);
        goto L26
    L31:
        if (r10.hasSetterValueParameter() == false) goto L35;
        ProtoBuf.ValueParameter r24 = r10.getSetterValueParameter();
        KmValueParameterVisitor r25 = r11.visitSetterParameter(r24.getFlags(), r13.get(r24.getName()));
        if (r25 == null) goto L35;
        accept(r24, r25, r13);
    L35:
        ProtoBuf.Type r26 = ProtoTypeTableUtilKt.returnType(r10, r13.getTypes());
        KmTypeVisitor r27 = r11.visitReturnType(getTypeFlags(r26));
        if (r27 == null) goto L38;
        accept(r26, r27, r13);
    L38:
        Iterator<Integer> r28 = r10.getVersionRequirementList().iterator();
    L40:
        if (r28.hasNext() == false) goto L44;
        Integer r29 = r28.next();
        KmVersionRequirementVisitor r30 = r11.visitVersionRequirement();
        if (r30 == null) goto L40;
        acceptVersionRequirementVisitor(r29.intValue(), r30, r13);
        goto L40
    L44:
        Iterator<MetadataExtensions> r31 = r13.getExtensions$kotlinx_metadata().iterator();
    L46:
        if (r31.hasNext() == false) goto L48;
        r31.next().readPropertyExtensions(r11, r10, r13);
        goto L46
    L48:
        r11.visitEnd();
    }

    private static final void accept(ProtoBuf.TypeAlias r10, KmTypeAliasVisitor r11, ReadContext r12) {
        ReadContext r13 = r12.withTypeParameters(r10.getTypeParameterList());
        Iterator<ProtoBuf.TypeParameter> r5 = r10.getTypeParameterList().iterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        ProtoBuf.TypeParameter r14 = r5.next();
        ProtoBuf.TypeParameter.Variance r15 = r14.getVariance();
        Intrinsics.checkNotNull(r15);
        int r16 = WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
        if (r16 != 1) goto L8;
        KmVariance r17 = KmVariance.IN;
    L16:
        KmTypeParameterVisitor r18 = r11.visitTypeParameter(getTypeParameterFlags(r14), r13.get(r14.getName()), r14.getId(), r17);
        if (r18 == null) goto L4;
        accept(r14, r18, r13);
        goto L4
    L8:
        if (r16 != 2) goto L10;
        r17 = KmVariance.OUT;
        goto L16
    L10:
        if (r16 != 3) goto L13;
        r17 = KmVariance.INVARIANT;
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    L19:
        ProtoBuf.Type r19 = ProtoTypeTableUtilKt.underlyingType(r10, r13.getTypes());
        KmTypeVisitor r20 = r11.visitUnderlyingType(getTypeFlags(r19));
        if (r20 == null) goto L22;
        accept(r19, r20, r13);
    L22:
        ProtoBuf.Type r21 = ProtoTypeTableUtilKt.expandedType(r10, r13.getTypes());
        KmTypeVisitor r22 = r11.visitExpandedType(getTypeFlags(r21));
        if (r22 == null) goto L25;
        accept(r21, r22, r13);
    L25:
        Iterator<ProtoBuf.Annotation> r23 = r10.getAnnotationList().iterator();
    L27:
        if (r23.hasNext() == false) goto L29;
        r11.visitAnnotation(ReadUtilsKt.readAnnotation(r23.next(), r13.getStrings()));
        goto L27
    L29:
        Iterator<Integer> r24 = r10.getVersionRequirementList().iterator();
    L31:
        if (r24.hasNext() == false) goto L35;
        Integer r25 = r24.next();
        KmVersionRequirementVisitor r26 = r11.visitVersionRequirement();
        if (r26 == null) goto L31;
        acceptVersionRequirementVisitor(r25.intValue(), r26, r13);
        goto L31
    L35:
        Iterator<MetadataExtensions> r27 = r13.getExtensions$kotlinx_metadata().iterator();
    L37:
        if (r27.hasNext() == false) goto L39;
        r27.next().readTypeAliasExtensions(r11, r10, r13);
        goto L37
    L39:
        r11.visitEnd();
    }

    private static final void accept(ProtoBuf.ValueParameter r5, KmValueParameterVisitor r10, ReadContext r11) {
        ProtoBuf.Type r12 = ProtoTypeTableUtilKt.type(r5, r11.getTypes());
        KmTypeVisitor r13 = r10.visitType(getTypeFlags(r12));
        if (r13 == null) goto L5;
        accept(r12, r13, r11);
    L5:
        ProtoBuf.Type r14 = ProtoTypeTableUtilKt.varargElementType(r5, r11.getTypes());
        if (r14 == null) goto L10;
        KmTypeVisitor r15 = r10.visitVarargElementType(getTypeFlags(r14));
        if (r15 == null) goto L10;
        accept(r14, r15, r11);
    L10:
        Iterator<MetadataExtensions> r16 = r11.getExtensions$kotlinx_metadata().iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r16.next().readValueParameterExtensions(r10, r5, r11);
        goto L12
    L14:
        r10.visitEnd();
    }

    private static final void accept(ProtoBuf.TypeParameter r5, Function4<? super Integer, ? super String, ? super Integer, ? super KmVariance, ? extends KmTypeParameterVisitor> r10, ReadContext r11) {
        ProtoBuf.TypeParameter.Variance r12 = r5.getVariance();
        Intrinsics.checkNotNull(r12);
        int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r13 != 1) goto L5;
        KmVariance r14 = KmVariance.IN;
    L13:
        KmTypeParameterVisitor r15 = r10.invoke(Integer.valueOf(getTypeParameterFlags(r5)), r11.get(r5.getName()), Integer.valueOf(r5.getId()), r14);
        if (r15 == null) goto L17;
        accept(r5, r15, r11);
        return;
    L17:
        return;
    L5:
        if (r13 != 2) goto L7;
        r14 = KmVariance.OUT;
        goto L13
    L7:
        if (r13 != 3) goto L10;
        r14 = KmVariance.INVARIANT;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private static final void accept(ProtoBuf.TypeParameter r5, KmTypeParameterVisitor r10, ReadContext r11) {
        Iterator<ProtoBuf.Type> r12 = ProtoTypeTableUtilKt.upperBounds(r5, r11.getTypes()).iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ProtoBuf.Type r13 = r12.next();
        KmTypeVisitor r14 = r10.visitUpperBound(getTypeFlags(r13));
        if (r14 == null) goto L4;
        accept(r13, r14, r11);
        goto L4
    L8:
        Iterator<MetadataExtensions> r15 = r11.getExtensions$kotlinx_metadata().iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        r15.next().readTypeParameterExtensions(r10, r5, r11);
        goto L10
    L12:
        r10.visitEnd();
    }

    private static final void accept(ProtoBuf.Type r10, KmTypeVisitor r11, ReadContext r12) {
        String r5 = null;
        if (r10.hasClassName() == false) goto L6;
        r11.visitClass(r12.className(r10.getClassName()));
    L16:
        Iterator<ProtoBuf.Type.Argument> r13 = r10.getArgumentList().iterator();
    L18:
        if (r13.hasNext() == false) goto L41;
        ProtoBuf.Type.Argument r14 = r13.next();
        ProtoBuf.Type.Argument.Projection r15 = r14.getProjection();
        Intrinsics.checkNotNull(r15);
        int r16 = WhenMappings.$EnumSwitchMapping$1[r15.ordinal()];
        if (r16 == 1) goto L31;
        if (r16 != 2) goto L23;
        KmVariance r17 = KmVariance.OUT;
    L32:
        if (r17 != null) goto L33;
        r11.visitStarProjection();
        goto L18
    L33:
        ProtoBuf.Type r18 = ProtoTypeTableUtilKt.type(r14, r12.getTypes());
        if (r18 == null) goto L39;
        KmTypeVisitor r19 = r11.visitArgument(getTypeFlags(r18), r17);
        if (r19 == null) goto L18;
        accept(r18, r19, r12);
        goto L18
    L39:
        throw new InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
    L23:
        if (r16 != 3) goto L25;
        r17 = KmVariance.INVARIANT;
        goto L32
    L25:
        if (r16 != 4) goto L28;
        r17 = null;
        goto L32
    L28:
        throw new NoWhenBranchMatchedException();
    L31:
        r17 = KmVariance.IN;
        goto L32
    L41:
        ProtoBuf.Type r20 = ProtoTypeTableUtilKt.abbreviatedType(r10, r12.getTypes());
        if (r20 == null) goto L46;
        KmTypeVisitor r21 = r11.visitAbbreviatedType(getTypeFlags(r20));
        if (r21 == null) goto L46;
        accept(r20, r21, r12);
    L46:
        ProtoBuf.Type r22 = ProtoTypeTableUtilKt.outerType(r10, r12.getTypes());
        if (r22 == null) goto L51;
        KmTypeVisitor r23 = r11.visitOuterType(getTypeFlags(r22));
        if (r23 == null) goto L51;
        accept(r22, r23, r12);
    L51:
        ProtoBuf.Type r24 = ProtoTypeTableUtilKt.flexibleUpperBound(r10, r12.getTypes());
        if (r24 == null) goto L59;
        int r25 = getTypeFlags(r24);
        if (r10.hasFlexibleTypeCapabilitiesId() == false) goto L56;
        r5 = r12.get(r10.getFlexibleTypeCapabilitiesId());
    L56:
        KmTypeVisitor r26 = r11.visitFlexibleTypeUpperBound(r25, r5);
        if (r26 == null) goto L59;
        accept(r24, r26, r12);
    L59:
        Iterator<MetadataExtensions> r27 = r12.getExtensions$kotlinx_metadata().iterator();
    L61:
        if (r27.hasNext() == false) goto L63;
        r27.next().readTypeExtensions(r11, r10, r12);
        goto L61
    L63:
        r11.visitEnd();
        return;
    L6:
        if (r10.hasTypeAliasName() == false) goto L9;
        r11.visitTypeAlias(r12.className(r10.getTypeAliasName()));
        goto L16
    L9:
        if (r10.hasTypeParameter() == false) goto L12;
        r11.visitTypeParameter(r10.getTypeParameter());
        goto L16
    L12:
        if (r10.hasTypeParameterName() == false) goto L68;
        Integer r28 = r12.getTypeParameterId(r10.getTypeParameterName());
        if (r28 == null) goto L66;
        r11.visitTypeParameter(r28.intValue());
        goto L16
    L66:
        throw new InconsistentKotlinMetadataException("No type parameter id for " + r12.get(r10.getTypeParameterName()), null, 2, null);
    L68:
        throw new InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
    }

    private static final void accept(ProtoBuf.Contract r10, KmContractVisitor r11, ReadContext r12) {
        Iterator<ProtoBuf.Effect> r13 = r10.getEffectList().iterator();
    L4:
        if (r13.hasNext() == false) goto L31;
        ProtoBuf.Effect r5 = r13.next();
        if (r5.hasEffectType() == false) goto L4;
        ProtoBuf.Effect.EffectType r14 = r5.getEffectType();
        Intrinsics.checkNotNull(r14);
        int r15 = WhenMappings.$EnumSwitchMapping$4[r14.ordinal()];
        if (r15 == 1) goto L15;
        if (r15 == 2) goto L14;
        if (r15 != 3) goto L13;
        KmEffectType r16 = KmEffectType.RETURNS_NOT_NULL;
    L17:
        if (r5.hasKind() == true) goto L19;
        KmEffectInvocationKind r17 = null;
    L28:
        KmEffectVisitor r18 = r11.visitEffect(r16, r17);
        if (r18 == null) goto L4;
        accept(r5, r18, r12);
        goto L4
    L19:
        ProtoBuf.Effect.InvocationKind r19 = r5.getKind();
        Intrinsics.checkNotNull(r19);
        int r20 = WhenMappings.$EnumSwitchMapping$5[r19.ordinal()];
        if (r20 == 1) goto L27;
        if (r20 == 2) goto L26;
        if (r20 != 3) goto L25;
        r17 = KmEffectInvocationKind.AT_LEAST_ONCE;
        goto L28
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r17 = KmEffectInvocationKind.EXACTLY_ONCE;
        goto L28
    L27:
        r17 = KmEffectInvocationKind.AT_MOST_ONCE;
        goto L28
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r16 = KmEffectType.CALLS;
        goto L17
    L15:
        r16 = KmEffectType.RETURNS_CONSTANT;
        goto L17
    L31:
        r11.visitEnd();
    }

    private static final void accept(ProtoBuf.Effect r5, KmEffectVisitor r10, ReadContext r11) {
        Iterator<ProtoBuf.Expression> r12 = r5.getEffectConstructorArgumentList().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        ProtoBuf.Expression r13 = r12.next();
        KmEffectExpressionVisitor r14 = r10.visitConstructorArgument();
        if (r14 == null) goto L4;
        accept(r13, r14, r11);
        goto L4
    L9:
        if (r5.hasConclusionOfConditionalEffect() == false) goto L13;
        KmEffectExpressionVisitor r15 = r10.visitConclusionOfConditionalEffect();
        if (r15 == null) goto L13;
        accept(r5.getConclusionOfConditionalEffect(), r15, r11);
    L13:
        r10.visitEnd();
    }

    private static final void accept(ProtoBuf.Expression r5, KmEffectExpressionVisitor r10, ReadContext r11) {
        int r12 = r5.getFlags();
        Boolean r13 = null;
        if (r5.hasValueParameterReference() == false) goto L5;
        Integer r14 = Integer.valueOf(r5.getValueParameterReference());
    L6:
        r10.visit(r12, r14);
        if (r5.hasConstantValue() == false) goto L20;
        ProtoBuf.Expression.ConstantValue r15 = r5.getConstantValue();
        Intrinsics.checkNotNull(r15);
        int r16 = WhenMappings.$EnumSwitchMapping$6[r15.ordinal()];
        if (r16 != 1) goto L11;
        r13 = Boolean.TRUE;
    L19:
        r10.visitConstantValue(r13);
        goto L20
    L11:
        if (r16 != 2) goto L13;
        r13 = Boolean.FALSE;
        goto L19
    L13:
        if (r16 == 3) goto L19;
        throw new NoWhenBranchMatchedException();
    L20:
        ProtoBuf.Type r17 = ProtoTypeTableUtilKt.isInstanceType(r5, r11.getTypes());
        if (r17 == null) goto L25;
        KmTypeVisitor r18 = r10.visitIsInstanceType(getTypeFlags(r17));
        if (r18 == null) goto L25;
        accept(r17, r18, r11);
    L25:
        Iterator<ProtoBuf.Expression> r19 = r5.getAndArgumentList().iterator();
    L27:
        if (r19.hasNext() == false) goto L31;
        ProtoBuf.Expression r20 = r19.next();
        KmEffectExpressionVisitor r21 = r10.visitAndArgument();
        if (r21 == null) goto L27;
        accept(r20, r21, r11);
        goto L27
    L31:
        Iterator<ProtoBuf.Expression> r22 = r5.getOrArgumentList().iterator();
    L33:
        if (r22.hasNext() == false) goto L37;
        ProtoBuf.Expression r23 = r22.next();
        KmEffectExpressionVisitor r24 = r10.visitOrArgument();
        if (r24 == null) goto L33;
        accept(r23, r24, r11);
        goto L33
    L37:
        r10.visitEnd();
        return;
    L5:
        r14 = null;
        goto L6
    }
}
