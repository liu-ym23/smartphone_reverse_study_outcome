package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.ExperimentalContextReceivers;
import androidx.room.jarjarred.kotlinx.metadata.Flag;
import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmContractVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectInvocationKind;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectType;
import androidx.room.jarjarred.kotlinx.metadata.KmEffectVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmVariance;
import androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementLevel;
import androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVersionKind;
import androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.VersionRequirement;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.MutableVersionRequirementTable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002\u001a$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\bH\u0002\u001a6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\bH\u0002\u001a$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\bH\u0002\u001a8\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n0\bH\u0002\u001aN\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001f\u001a\u00060\u0005j\u0002`\u00062\n\u0010 \u001a\u00060\u0005j\u0002`\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\n0\b\u001a0\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\n0\bH\u0002\u001a8\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\n0\bH\u0002\u001aH\u0010(\u001a\u00020)2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0\bH\u0002\u001a8\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\n0\bH\u0002\u001a$\u00101\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\bH\u0002¨\u00063"}, d2 = {"writeConstructor", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "output", "Lkotlin/Function1;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor$Builder;", "", "writeContract", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Contract$Builder;", "writeEffect", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;", "invocationKind", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Effect$Builder;", "writeEffectExpression", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Expression$Builder;", "writeFunction", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "name", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "writeProperty", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "getterFlags", "setterFlags", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property$Builder;", "writeType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "writeTypeAlias", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias$Builder;", "writeTypeParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter$Builder;", "writeValueParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter$Builder;", "writeVersionRequirement", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WritersKt {

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeConstructor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeConstructor$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Constructor$Builder;", "visitEnd", "", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitValueParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "name", "", "visitVersionRequirement", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends KmConstructorVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ int $flags;
        final /* synthetic */ Function1<ProtoBuf.Constructor.Builder, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.Constructor.Builder f605t;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(WriteContext r5, int r10, Function1<? super ProtoBuf.Constructor.Builder, Unit> r11) {
            this.$c = r5;
            this.$flags = r10;
            this.$output = r11;
            super(null, 1, null);
            this.f605t = ProtoBuf.Constructor.newBuilder();
        }

        public final ProtoBuf.Constructor.Builder getT() {
            return this.f605t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
        public void visitEnd() {
            if (this.$flags == ProtoBuf.Constructor.getDefaultInstance().getFlags()) goto L5;
            this.f605t.setFlags(this.$flags);
        L5:
            this.$output.invoke(this.f605t);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
        public KmConstructorExtensionVisitor visitExtensions(final KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            final WriteContext r10 = this.$c;
            return (KmConstructorExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new WritersKt$writeConstructor$1$visitExtensions$1(r5, this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
        public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, "name");
            return WritersKt.access$writeValueParameter(this.$c, r5, r10, new WritersKt$writeConstructor$1$visitValueParameter$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
        public KmVersionRequirementVisitor visitVersionRequirement() {
            return WritersKt.access$writeVersionRequirement(this.$c, new WritersKt$writeConstructor$1$visitVersionRequirement$1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeContract$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeContract$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Contract$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Contract$Builder;", "visitEffect", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;", "invocationKind", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;", "visitEnd", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01191 extends KmContractVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ Function1<ProtoBuf.Contract.Builder, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.Contract.Builder f606t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01191(WriteContext r5, Function1<? super ProtoBuf.Contract.Builder, Unit> r10) {
            this.$c = r5;
            this.$output = r10;
            super(null, 1, null);
            this.f606t = ProtoBuf.Contract.newBuilder();
        }

        public final ProtoBuf.Contract.Builder getT() {
            return this.f606t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmContractVisitor
        public KmEffectVisitor visitEffect(KmEffectType r5, KmEffectInvocationKind r10) {
            Intrinsics.checkNotNullParameter(r5, "type");
            return WritersKt.access$writeEffect(this.$c, r5, r10, new WritersKt$writeContract$1$visitEffect$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmContractVisitor
        public void visitEnd() {
            this.$output.invoke(this.f606t);
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeEffect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeEffect$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Effect$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Effect$Builder;", "visitConclusionOfConditionalEffect", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "visitConstructorArgument", "visitEnd", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01201 extends KmEffectVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ KmEffectInvocationKind $invocationKind;
        final /* synthetic */ Function1<ProtoBuf.Effect.Builder, Unit> $output;
        final /* synthetic */ KmEffectType $type;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.Effect.Builder f607t;

        /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeEffect$1$WhenMappings */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

            static {
                int[] r5 = new int[KmEffectType.values().length];
                r5[KmEffectType.RETURNS_CONSTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L20:
                r5[KmEffectType.CALLS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L26:
                r5[KmEffectType.RETURNS_NOT_NULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L8:
                $EnumSwitchMapping$0 = r5;
                int[] r10 = new int[KmEffectInvocationKind.values().length];
                r10[KmEffectInvocationKind.AT_MOST_ONCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L22:
                r10[KmEffectInvocationKind.EXACTLY_ONCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L28:
                r10[KmEffectInvocationKind.AT_LEAST_ONCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L12:
                $EnumSwitchMapping$1 = r10;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01201(WriteContext r5, KmEffectType r10, KmEffectInvocationKind r11, Function1<? super ProtoBuf.Effect.Builder, Unit> r12) {
            this.$c = r5;
            this.$type = r10;
            this.$invocationKind = r11;
            this.$output = r12;
            super(null, 1, null);
            this.f607t = ProtoBuf.Effect.newBuilder();
        }

        public final ProtoBuf.Effect.Builder getT() {
            return this.f607t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectVisitor
        public KmEffectExpressionVisitor visitConclusionOfConditionalEffect() {
            return WritersKt.access$writeEffectExpression(this.$c, new WritersKt$writeEffect$1$visitConclusionOfConditionalEffect$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectVisitor
        public KmEffectExpressionVisitor visitConstructorArgument() {
            return WritersKt.access$writeEffectExpression(this.$c, new WritersKt$writeEffect$1$visitConstructorArgument$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectVisitor
        public void visitEnd() {
            int r5 = WhenMappings.$EnumSwitchMapping$0[this.$type.ordinal()];
            if (r5 == 1) goto L10;
            if (r5 == 2) goto L9;
            if (r5 != 3) goto L8;
            this.f607t.setEffectType(ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL);
            Unit r10 = Unit.INSTANCE;
        L11:
            KmEffectInvocationKind r11 = this.$invocationKind;
            if (r11 != null) goto L14;
            int r12 = -1;
        L15:
            if (r12 == (-1)) goto L24;
            if (r12 == 1) goto L23;
            if (r12 == 2) goto L22;
            if (r12 != 3) goto L21;
            this.f607t.setKind(ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE);
            goto L24
        L21:
            throw new NoWhenBranchMatchedException();
        L22:
            this.f607t.setKind(ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE);
            goto L24
        L23:
            this.f607t.setKind(ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE);
        L24:
            this.$output.invoke(this.f607t);
            return;
        L14:
            r12 = WhenMappings.$EnumSwitchMapping$1[r11.ordinal()];
            goto L15
        L8:
            throw new NoWhenBranchMatchedException();
        L9:
            this.f607t.setEffectType(ProtoBuf.Effect.EffectType.CALLS);
            Unit r13 = Unit.INSTANCE;
            goto L11
        L10:
            this.f607t.setEffectType(ProtoBuf.Effect.EffectType.RETURNS_CONSTANT);
            Unit r14 = Unit.INSTANCE;
            goto L11
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeEffectExpression$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeEffectExpression$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Expression$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Expression$Builder;", "visit", "", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "parameterIndex", "(ILjava/lang/Integer;)V", "visitAndArgument", "visitConstantValue", "value", "", "visitEnd", "visitIsInstanceType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitOrArgument", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01211 extends KmEffectExpressionVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ Function1<ProtoBuf.Expression.Builder, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.Expression.Builder f608t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01211(WriteContext r5, Function1<? super ProtoBuf.Expression.Builder, Unit> r10) {
            this.$c = r5;
            this.$output = r10;
            super(null, 1, null);
            this.f608t = ProtoBuf.Expression.newBuilder();
        }

        public final ProtoBuf.Expression.Builder getT() {
            return this.f608t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
        public void visit(int r5, Integer r10) {
            if (r5 == ProtoBuf.Expression.getDefaultInstance().getFlags()) goto L5;
            this.f608t.setFlags(r5);
        L5:
            if (r10 == null) goto L8;
            this.f608t.setValueParameterReference(r10.intValue());
            return;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
        public KmEffectExpressionVisitor visitAndArgument() {
            return WritersKt.access$writeEffectExpression(this.$c, new WritersKt$writeEffectExpression$1$visitAndArgument$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
        public void visitConstantValue(Object r5) {
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L6;
            this.f608t.setConstantValue(ProtoBuf.Expression.ConstantValue.TRUE);
            return;
        L6:
            if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L8;
            this.f608t.setConstantValue(ProtoBuf.Expression.ConstantValue.FALSE);
            return;
        L8:
            if (r5 != null) goto L12;
            this.f608t.setConstantValue(ProtoBuf.Expression.ConstantValue.NULL);
            return;
        L12:
            throw new IllegalArgumentException("Only true, false or null constant values are allowed for effects (was=" + r5 + ')');
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
        public void visitEnd() {
            this.$output.invoke(this.f608t);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
        public KmTypeVisitor visitIsInstanceType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeEffectExpression$1$visitIsInstanceType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
        public KmEffectExpressionVisitor visitOrArgument() {
            return WritersKt.access$writeEffectExpression(this.$c, new WritersKt$writeEffectExpression$1$visitOrArgument$1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeFunction$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000]\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0017J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J.\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeFunction$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function$Builder;", "visitContextReceiverType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "visitContract", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "visitEnd", "", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitReceiverParameterType", "visitReturnType", "visitTypeParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "name", "", "id", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "visitValueParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitVersionRequirement", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01221 extends KmFunctionVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ int $flags;
        final /* synthetic */ String $name;
        final /* synthetic */ Function1<ProtoBuf.Function.Builder, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.Function.Builder f609t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01221(WriteContext r5, String r10, int r11, Function1<? super ProtoBuf.Function.Builder, Unit> r12) {
            this.$c = r5;
            this.$name = r10;
            this.$flags = r11;
            this.$output = r12;
            super(null, 1, null);
            this.f609t = ProtoBuf.Function.newBuilder();
        }

        public final ProtoBuf.Function.Builder getT() {
            return this.f609t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        @ExperimentalContextReceivers
        public KmTypeVisitor visitContextReceiverType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeFunction$1$visitContextReceiverType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmContractVisitor visitContract() {
            return WritersKt.access$writeContract(this.$c, new WritersKt$writeFunction$1$visitContract$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public void visitEnd() {
            this.f609t.setName(this.$c.get(this.$name));
            if (this.$flags == ProtoBuf.Function.getDefaultInstance().getFlags()) goto L5;
            this.f609t.setFlags(this.$flags);
        L5:
            this.$output.invoke(this.f609t);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmFunctionExtensionVisitor visitExtensions(final KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            final WriteContext r10 = this.$c;
            return (KmFunctionExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new WritersKt$writeFunction$1$visitExtensions$1(r5, this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmTypeVisitor visitReceiverParameterType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeFunction$1$visitReceiverParameterType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmTypeVisitor visitReturnType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeFunction$1$visitReturnType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmTypeParameterVisitor visitTypeParameter(int r10, String r11, int r12, KmVariance r13) {
            Intrinsics.checkNotNullParameter(r11, "name");
            Intrinsics.checkNotNullParameter(r13, "variance");
            return WritersKt.access$writeTypeParameter(this.$c, r10, r11, r12, r13, new WritersKt$writeFunction$1$visitTypeParameter$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, "name");
            return WritersKt.access$writeValueParameter(this.$c, r5, r10, new WritersKt$writeFunction$1$visitValueParameter$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmVersionRequirementVisitor visitVersionRequirement() {
            return WritersKt.access$writeVersionRequirement(this.$c, new WritersKt$writeFunction$1$visitVersionRequirement$1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeProperty$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000W\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0017J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J.\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeProperty$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property$Builder;", "visitContextReceiverType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "visitEnd", "", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitReceiverParameterType", "visitReturnType", "visitSetterParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "name", "", "visitTypeParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "visitVersionRequirement", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01231 extends KmPropertyVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ int $flags;
        final /* synthetic */ int $getterFlags;
        final /* synthetic */ String $name;
        final /* synthetic */ Function1<ProtoBuf.Property.Builder, Unit> $output;
        final /* synthetic */ int $setterFlags;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.Property.Builder f610t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01231(WriteContext r5, String r10, int r11, int r12, int r13, Function1<? super ProtoBuf.Property.Builder, Unit> r14) {
            this.$c = r5;
            this.$name = r10;
            this.$flags = r11;
            this.$getterFlags = r12;
            this.$setterFlags = r13;
            this.$output = r14;
            super(null, 1, null);
            this.f610t = ProtoBuf.Property.newBuilder();
        }

        public final ProtoBuf.Property.Builder getT() {
            return this.f610t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        @ExperimentalContextReceivers
        public KmTypeVisitor visitContextReceiverType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeProperty$1$visitContextReceiverType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public void visitEnd() {
            this.f610t.setName(this.$c.get(this.$name));
            if (this.$flags == ProtoBuf.Property.getDefaultInstance().getFlags()) goto L6;
            this.f610t.setFlags(this.$flags);
        L6:
            if (Flag.Property.HAS_GETTER.invoke(this.$flags) == false) goto L9;
            this.f610t.setGetterFlags(this.$getterFlags);
        L9:
            if (Flag.Property.HAS_SETTER.invoke(this.$flags) == false) goto L11;
            this.f610t.setSetterFlags(this.$setterFlags);
        L11:
            this.$output.invoke(this.f610t);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmPropertyExtensionVisitor visitExtensions(final KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            final WriteContext r10 = this.$c;
            return (KmPropertyExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new WritersKt$writeProperty$1$visitExtensions$1(r5, this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmTypeVisitor visitReceiverParameterType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeProperty$1$visitReceiverParameterType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmTypeVisitor visitReturnType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeProperty$1$visitReturnType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmValueParameterVisitor visitSetterParameter(int r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, "name");
            return WritersKt.access$writeValueParameter(this.$c, r5, r10, new WritersKt$writeProperty$1$visitSetterParameter$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmTypeParameterVisitor visitTypeParameter(int r10, String r11, int r12, KmVariance r13) {
            Intrinsics.checkNotNullParameter(r11, "name");
            Intrinsics.checkNotNullParameter(r13, "variance");
            return WritersKt.access$writeTypeParameter(this.$c, r10, r11, r12, r13, new WritersKt$writeProperty$1$visitTypeParameter$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmVersionRequirementVisitor visitVersionRequirement() {
            return WritersKt.access$writeVersionRequirement(this.$c, new WritersKt$writeProperty$1$visitVersionRequirement$1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeType$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0014\u0010\u001a\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016R\u0016\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeType$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "kotlin.jvm.PlatformType", "visitAbbreviatedType", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "visitArgument", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "visitClass", "", "name", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "visitEnd", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitFlexibleTypeUpperBound", "typeFlexibilityId", "visitOuterType", "visitStarProjection", "visitTypeAlias", "visitTypeParameter", "id", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01241 extends KmTypeVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ int $flags;
        final /* synthetic */ Function1<ProtoBuf.Type.Builder, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.Type.Builder f611t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01241(WriteContext r5, int r10, Function1<? super ProtoBuf.Type.Builder, Unit> r11) {
            this.$c = r5;
            this.$flags = r10;
            this.$output = r11;
            super(null, 1, null);
            this.f611t = ProtoBuf.Type.newBuilder();
        }

        public static final /* synthetic */ ProtoBuf.Type.Builder access$getT$p(C01241 r5) {
            return r5.f611t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public KmTypeVisitor visitAbbreviatedType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeType$1$visitAbbreviatedType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public KmTypeVisitor visitArgument(int r5, final KmVariance r10) {
            Intrinsics.checkNotNullParameter(r10, "variance");
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeType$1$visitArgument$1(this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public void visitClass(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            this.f611t.setClassName(this.$c.getClassName(r5));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public void visitEnd() {
            if (Flag.Type.IS_NULLABLE.invoke(this.$flags) == false) goto L5;
            this.f611t.setNullable(true);
        L5:
            int r5 = this.$flags >> 1;
            if (r5 == ProtoBuf.Type.getDefaultInstance().getFlags()) goto L8;
            this.f611t.setFlags(r5);
        L8:
            this.$output.invoke(this.f611t);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public KmTypeExtensionVisitor visitExtensions(final KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            final WriteContext r10 = this.$c;
            return (KmTypeExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new WritersKt$writeType$1$visitExtensions$1(r5, this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public KmTypeVisitor visitFlexibleTypeUpperBound(int r5, final String r10) {
            final WriteContext r11 = this.$c;
            return WritersKt.access$writeType(r11, r5, new WritersKt$writeType$1$visitFlexibleTypeUpperBound$1(r10, this, r11));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public KmTypeVisitor visitOuterType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeType$1$visitOuterType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public void visitStarProjection() {
            ProtoBuf.Type.Builder r5 = this.f611t;
            ProtoBuf.Type.Argument.Builder r10 = ProtoBuf.Type.Argument.newBuilder();
            r10.setProjection(ProtoBuf.Type.Argument.Projection.STAR);
            r5.addArgument(r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public void visitTypeAlias(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            this.f611t.setTypeAliasName(this.$c.getClassName(r5));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
        public void visitTypeParameter(int r5) {
            this.f611t.setTypeParameter(r5);
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeTypeAlias$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000Y\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J.\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeTypeAlias$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$TypeAlias$Builder;", "visitAnnotation", "", "annotation", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "visitEnd", "visitExpandedType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitTypeParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "name", "", "id", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "visitUnderlyingType", "visitVersionRequirement", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01251 extends KmTypeAliasVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ int $flags;
        final /* synthetic */ String $name;
        final /* synthetic */ Function1<ProtoBuf.TypeAlias.Builder, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.TypeAlias.Builder f612t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01251(WriteContext r5, int r10, String r11, Function1<? super ProtoBuf.TypeAlias.Builder, Unit> r12) {
            this.$c = r5;
            this.$flags = r10;
            this.$name = r11;
            this.$output = r12;
            super(null, 1, null);
            this.f612t = ProtoBuf.TypeAlias.newBuilder();
        }

        public final ProtoBuf.TypeAlias.Builder getT() {
            return this.f612t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
        public void visitAnnotation(KmAnnotation r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            this.f612t.addAnnotation(WriteUtilsKt.writeAnnotation(r5, this.$c.getStrings()));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
        public void visitEnd() {
            if (this.$flags == ProtoBuf.TypeAlias.getDefaultInstance().getFlags()) goto L5;
            this.f612t.setFlags(this.$flags);
        L5:
            this.f612t.setName(this.$c.get(this.$name));
            this.$output.invoke(this.f612t);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
        public KmTypeVisitor visitExpandedType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeTypeAlias$1$visitExpandedType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
        public KmTypeAliasExtensionVisitor visitExtensions(final KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            final WriteContext r10 = this.$c;
            return (KmTypeAliasExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new WritersKt$writeTypeAlias$1$visitExtensions$1(r5, this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
        public KmTypeParameterVisitor visitTypeParameter(int r10, String r11, int r12, KmVariance r13) {
            Intrinsics.checkNotNullParameter(r11, "name");
            Intrinsics.checkNotNullParameter(r13, "variance");
            return WritersKt.access$writeTypeParameter(this.$c, r10, r11, r12, r13, new WritersKt$writeTypeAlias$1$visitTypeParameter$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
        public KmTypeVisitor visitUnderlyingType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeTypeAlias$1$visitUnderlyingType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
        public KmVersionRequirementVisitor visitVersionRequirement() {
            return WritersKt.access$writeVersionRequirement(this.$c, new WritersKt$writeTypeAlias$1$visitVersionRequirement$1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeTypeParameter$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016R\u0016\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeTypeParameter$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter$Builder;", "kotlin.jvm.PlatformType", "visitEnd", "", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitUpperBound", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01261 extends KmTypeParameterVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ int $flags;
        final /* synthetic */ int $id;
        final /* synthetic */ String $name;
        final /* synthetic */ Function1<ProtoBuf.TypeParameter.Builder, Unit> $output;
        final /* synthetic */ KmVariance $variance;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.TypeParameter.Builder f613t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01261(WriteContext r5, String r10, int r11, int r12, KmVariance r13, Function1<? super ProtoBuf.TypeParameter.Builder, Unit> r14) {
            this.$c = r5;
            this.$name = r10;
            this.$id = r11;
            this.$flags = r12;
            this.$variance = r13;
            this.$output = r14;
            super(null, 1, null);
            this.f613t = ProtoBuf.TypeParameter.newBuilder();
        }

        public static final /* synthetic */ ProtoBuf.TypeParameter.Builder access$getT$p(C01261 r5) {
            return r5.f613t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor
        public void visitEnd() {
            this.f613t.setName(this.$c.get(this.$name));
            this.f613t.setId(this.$id);
            boolean r5 = Flag.TypeParameter.IS_REIFIED.invoke(this.$flags);
            if (r5 == ProtoBuf.TypeParameter.getDefaultInstance().getReified()) goto L5;
            this.f613t.setReified(r5);
        L5:
            KmVariance r10 = this.$variance;
            if (r10 != KmVariance.IN) goto L9;
            this.f613t.setVariance(ProtoBuf.TypeParameter.Variance.IN);
        L11:
            this.$output.invoke(this.f613t);
            return;
        L9:
            if (r10 != KmVariance.OUT) goto L11;
            this.f613t.setVariance(ProtoBuf.TypeParameter.Variance.OUT);
            goto L11
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor
        public KmTypeParameterExtensionVisitor visitExtensions(final KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            final WriteContext r10 = this.$c;
            return (KmTypeParameterExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new WritersKt$writeTypeParameter$1$visitExtensions$1(r5, this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor
        public KmTypeVisitor visitUpperBound(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeTypeParameter$1$visitUpperBound$1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeValueParameter$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016R\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeValueParameter$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter$Builder;", "kotlin.jvm.PlatformType", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$ValueParameter$Builder;", "visitEnd", "", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "visitVarargElementType", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01271 extends KmValueParameterVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ int $flags;
        final /* synthetic */ String $name;
        final /* synthetic */ Function1<ProtoBuf.ValueParameter.Builder, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ProtoBuf.ValueParameter.Builder f614t;

        /* JADX WARN: Multi-variable type inference failed */
        public C01271(WriteContext r5, int r10, String r11, Function1<? super ProtoBuf.ValueParameter.Builder, Unit> r12) {
            this.$c = r5;
            this.$flags = r10;
            this.$name = r11;
            this.$output = r12;
            super(null, 1, null);
            this.f614t = ProtoBuf.ValueParameter.newBuilder();
        }

        public final ProtoBuf.ValueParameter.Builder getT() {
            return this.f614t;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
        public void visitEnd() {
            if (this.$flags == ProtoBuf.ValueParameter.getDefaultInstance().getFlags()) goto L5;
            this.f614t.setFlags(this.$flags);
        L5:
            this.f614t.setName(this.$c.get(this.$name));
            this.$output.invoke(this.f614t);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
        public KmValueParameterExtensionVisitor visitExtensions(final KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            final WriteContext r10 = this.$c;
            return (KmValueParameterExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new WritersKt$writeValueParameter$1$visitExtensions$1(r5, this, r10));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
        public KmTypeVisitor visitType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeValueParameter$1$visitType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
        public KmTypeVisitor visitVarargElementType(int r5) {
            return WritersKt.access$writeType(this.$c, r5, new WritersKt$writeValueParameter$1$visitVarargElementType$1(this));
        }
    }

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeVersionRequirement$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\tH\u0016J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"androidx/room/jarjarred/kotlinx/metadata/impl/WritersKt$writeVersionRequirement$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$VersionRequirement$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$VersionRequirement$Builder;", "setT", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$VersionRequirement$Builder;)V", "visit", "", "kind", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVersionKind;", "level", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementLevel;", "errorCode", "", "message", "", "(Lkotlinx/metadata/KmVersionRequirementVersionKind;Lkotlinx/metadata/KmVersionRequirementLevel;Ljava/lang/Integer;Ljava/lang/String;)V", "visitEnd", "visitVersion", "major", "minor", "patch", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C01281 extends KmVersionRequirementVisitor {
        final /* synthetic */ WriteContext $c;
        final /* synthetic */ Function1<Integer, Unit> $output;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private ProtoBuf.VersionRequirement.Builder f615t;

        /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.impl.WritersKt$writeVersionRequirement$1$WhenMappings */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

            static {
                int[] r5 = new int[KmVersionRequirementVersionKind.values().length];
                r5[KmVersionRequirementVersionKind.LANGUAGE_VERSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L20:
                r5[KmVersionRequirementVersionKind.COMPILER_VERSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L26:
                r5[KmVersionRequirementVersionKind.API_VERSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L8:
                $EnumSwitchMapping$0 = r5;
                int[] r10 = new int[KmVersionRequirementLevel.values().length];
                r10[KmVersionRequirementLevel.WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L22:
                r10[KmVersionRequirementLevel.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L28:
                r10[KmVersionRequirementLevel.HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L12:
                $EnumSwitchMapping$1 = r10;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01281(WriteContext r5, Function1<? super Integer, Unit> r10) {
            this.$c = r5;
            this.$output = r10;
            super(null, 1, null);
        }

        public final ProtoBuf.VersionRequirement.Builder getT() {
            return this.f615t;
        }

        public final void setT(ProtoBuf.VersionRequirement.Builder r5) {
            this.f615t = r5;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor
        public void visit(KmVersionRequirementVersionKind r10, KmVersionRequirementLevel r11, Integer r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "kind");
            Intrinsics.checkNotNullParameter(r11, "level");
            ProtoBuf.VersionRequirement.Builder r5 = ProtoBuf.VersionRequirement.newBuilder();
            WriteContext r14 = this.$c;
            int r15 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
            if (r15 == 1) goto L10;
            if (r15 == 2) goto L9;
            if (r15 != 3) goto L8;
            ProtoBuf.VersionRequirement.VersionKind r16 = ProtoBuf.VersionRequirement.VersionKind.API_VERSION;
        L12:
            if (r16 == r5.getDefaultInstanceForType().getVersionKind()) goto L14;
            r5.setVersionKind(r16);
        L14:
            int r17 = WhenMappings.$EnumSwitchMapping$1[r11.ordinal()];
            if (r17 == 1) goto L22;
            if (r17 == 2) goto L21;
            if (r17 != 3) goto L20;
            ProtoBuf.VersionRequirement.Level r18 = ProtoBuf.VersionRequirement.Level.HIDDEN;
        L24:
            if (r18 == r5.getDefaultInstanceForType().getLevel()) goto L26;
            r5.setLevel(r18);
        L26:
            if (r12 == null) goto L28;
            r5.setErrorCode(r12.intValue());
        L28:
            if (r13 == null) goto L30;
            r5.setMessage(r14.get(r13));
        L30:
            this.f615t = r5;
            return;
        L20:
            throw new NoWhenBranchMatchedException();
        L21:
            r18 = ProtoBuf.VersionRequirement.Level.ERROR;
            goto L24
        L22:
            r18 = ProtoBuf.VersionRequirement.Level.WARNING;
            goto L24
        L8:
            throw new NoWhenBranchMatchedException();
        L9:
            r16 = ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION;
            goto L12
        L10:
            r16 = ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
            goto L12
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor
        public void visitEnd() {
            if (this.f615t == null) goto L7;
            Function1<Integer, Unit> r5 = this.$output;
            MutableVersionRequirementTable r10 = this.$c.getVersionRequirements();
            ProtoBuf.VersionRequirement.Builder r11 = this.f615t;
            Intrinsics.checkNotNull(r11);
            r5.invoke(Integer.valueOf(r10.get(r11)));
            return;
        L7:
            throw new IllegalStateException("KmVersionRequirementVisitor.visit has not been called");
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor
        public void visitVersion(int r5, int r10, int r11) {
            if (this.f615t == null) goto L7;
            new VersionRequirement.Version(r5, r10, r11).encode(new WritersKt$writeVersionRequirement$1$visitVersion$1(this), new WritersKt$writeVersionRequirement$1$visitVersion$2(this));
            return;
        L7:
            throw new IllegalStateException("KmVersionRequirementVisitor.visit has not been called");
        }
    }

    public static final /* synthetic */ KmConstructorVisitor access$writeConstructor(WriteContext r5, int r10, Function1 r11) {
        return writeConstructor(r5, r10, r11);
    }

    public static final /* synthetic */ KmContractVisitor access$writeContract(WriteContext r5, Function1 r10) {
        return writeContract(r5, r10);
    }

    public static final /* synthetic */ KmEffectVisitor access$writeEffect(WriteContext r5, KmEffectType r10, KmEffectInvocationKind r11, Function1 r12) {
        return writeEffect(r5, r10, r11, r12);
    }

    public static final /* synthetic */ KmEffectExpressionVisitor access$writeEffectExpression(WriteContext r5, Function1 r10) {
        return writeEffectExpression(r5, r10);
    }

    public static final /* synthetic */ KmFunctionVisitor access$writeFunction(WriteContext r5, int r10, String r11, Function1 r12) {
        return writeFunction(r5, r10, r11, r12);
    }

    public static final /* synthetic */ KmTypeVisitor access$writeType(WriteContext r5, int r10, Function1 r11) {
        return writeType(r5, r10, r11);
    }

    public static final /* synthetic */ KmTypeAliasVisitor access$writeTypeAlias(WriteContext r5, int r10, String r11, Function1 r12) {
        return writeTypeAlias(r5, r10, r11, r12);
    }

    public static final /* synthetic */ KmTypeParameterVisitor access$writeTypeParameter(WriteContext r5, int r10, String r11, int r12, KmVariance r13, Function1 r14) {
        return writeTypeParameter(r5, r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ KmValueParameterVisitor access$writeValueParameter(WriteContext r5, int r10, String r11, Function1 r12) {
        return writeValueParameter(r5, r10, r11, r12);
    }

    public static final /* synthetic */ KmVersionRequirementVisitor access$writeVersionRequirement(WriteContext r5, Function1 r10) {
        return writeVersionRequirement(r5, r10);
    }

    private static final KmConstructorVisitor writeConstructor(WriteContext r5, int r10, Function1<? super ProtoBuf.Constructor.Builder, Unit> r11) {
        return new AnonymousClass1(r5, r10, r11);
    }

    private static final KmContractVisitor writeContract(WriteContext r5, Function1<? super ProtoBuf.Contract.Builder, Unit> r10) {
        return new C01191(r5, r10);
    }

    private static final KmEffectVisitor writeEffect(WriteContext r5, KmEffectType r10, KmEffectInvocationKind r11, Function1<? super ProtoBuf.Effect.Builder, Unit> r12) {
        return new C01201(r5, r10, r11, r12);
    }

    private static final KmEffectExpressionVisitor writeEffectExpression(WriteContext r5, Function1<? super ProtoBuf.Expression.Builder, Unit> r10) {
        return new C01211(r5, r10);
    }

    private static final KmFunctionVisitor writeFunction(WriteContext r5, int r10, String r11, Function1<? super ProtoBuf.Function.Builder, Unit> r12) {
        return new C01221(r5, r11, r10, r12);
    }

    public static final KmPropertyVisitor writeProperty(WriteContext r10, int r11, String r12, int r13, int r14, Function1<? super ProtoBuf.Property.Builder, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r12, "name");
        Intrinsics.checkNotNullParameter(r15, "output");
        return new C01231(r10, r12, r11, r13, r14, r15);
    }

    private static final KmTypeVisitor writeType(WriteContext r5, int r10, Function1<? super ProtoBuf.Type.Builder, Unit> r11) {
        return new C01241(r5, r10, r11);
    }

    private static final KmTypeAliasVisitor writeTypeAlias(WriteContext r5, int r10, String r11, Function1<? super ProtoBuf.TypeAlias.Builder, Unit> r12) {
        return new C01251(r5, r10, r11, r12);
    }

    private static final KmTypeParameterVisitor writeTypeParameter(WriteContext r10, int r11, String r12, int r13, KmVariance r14, Function1<? super ProtoBuf.TypeParameter.Builder, Unit> r15) {
        return new C01261(r10, r12, r13, r11, r14, r15);
    }

    private static final KmValueParameterVisitor writeValueParameter(WriteContext r5, int r10, String r11, Function1<? super ProtoBuf.ValueParameter.Builder, Unit> r12) {
        return new C01271(r5, r10, r11, r12);
    }

    private static final KmVersionRequirementVisitor writeVersionRequirement(WriteContext r5, Function1<? super Integer, Unit> r10) {
        return new C01281(r5, r10);
    }
}
