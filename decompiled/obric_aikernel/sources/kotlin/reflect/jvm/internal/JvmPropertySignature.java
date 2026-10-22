package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmPropertySignature {

    public static final class JavaField extends JvmPropertySignature {
        private final Field field;

        public JavaField(Field r10) {
            Intrinsics.checkNotNullParameter(r10, "field");
            super(null);
            this.field = r10;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            StringBuilder r10 = new StringBuilder();
            String r11 = this.field.getName();
            Intrinsics.checkNotNullExpressionValue(r11, "field.name");
            r10.append(JvmAbi.getterName(r11));
            r10.append("()");
            Class<?> r12 = this.field.getType();
            Intrinsics.checkNotNullExpressionValue(r12, "field.type");
            r10.append(ReflectClassUtilKt.getDesc(r12));
            return r10.toString();
        }

        public final Field getField() {
            return this.field;
        }
    }

    public static final class JavaMethodProperty extends JvmPropertySignature {
        private final Method getterMethod;
        private final Method setterMethod;

        public JavaMethodProperty(Method r10, Method r11) {
            Intrinsics.checkNotNullParameter(r10, "getterMethod");
            super(null);
            this.getterMethod = r10;
            this.setterMethod = r11;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature(this.getterMethod);
        }

        public final Method getGetterMethod() {
            return this.getterMethod;
        }

        public final Method getSetterMethod() {
            return this.setterMethod;
        }
    }

    public static final class KotlinProperty extends JvmPropertySignature {
        private final PropertyDescriptor descriptor;
        private final NameResolver nameResolver;
        private final ProtoBuf.Property proto;
        private final JvmProtoBuf.JvmPropertySignature signature;
        private final String string;
        private final TypeTable typeTable;

        public KotlinProperty(PropertyDescriptor r10, ProtoBuf.Property r11, JvmProtoBuf.JvmPropertySignature r12, NameResolver r13, TypeTable r14) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "proto");
            Intrinsics.checkNotNullParameter(r12, "signature");
            Intrinsics.checkNotNullParameter(r13, "nameResolver");
            Intrinsics.checkNotNullParameter(r14, "typeTable");
            super(null);
            this.descriptor = r10;
            this.proto = r11;
            this.signature = r12;
            this.nameResolver = r13;
            this.typeTable = r14;
            if (r12.hasGetter() == false) goto L5;
            String r15 = r13.getString(r12.getGetter().getName()) + r13.getString(r12.getGetter().getDesc());
        L8:
            this.string = r15;
            return;
        L5:
            JvmMemberSignature.Field r16 = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, r11, r13, r14, false, 8, null);
            if (r16 == null) goto L11;
            String r17 = r16.component1();
            r15 = JvmAbi.getterName(r17) + getManglingSuffix() + "()" + r16.component2();
            goto L8
        L11:
            throw new KotlinReflectionInternalError("No field signature for property: " + r10);
        }

        private final String getManglingSuffix() {
            DeclarationDescriptor r10 = this.descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(r10, "descriptor.containingDeclaration");
            if (Intrinsics.areEqual(this.descriptor.getVisibility(), DescriptorVisibilities.INTERNAL) == false) goto L15;
            if ((r10 instanceof DeserializedClassDescriptor) == false) goto L15;
            ProtoBuf.Class r11 = ((DeserializedClassDescriptor) r10).getClassProto();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> r12 = JvmProtoBuf.classModuleName;
            Intrinsics.checkNotNullExpressionValue(r12, "classModuleName");
            Integer r13 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r11, r12);
            if (r13 == null) goto L10;
            String r14 = this.nameResolver.getString(r13.intValue());
            if (r14 == null) goto L10;
        L11:
            StringBuilder r15 = new StringBuilder();
            r15.append(Typography.dollar);
            String r16 = NameUtils.sanitizeAsJavaIdentifier(r14);
        L12:
            r15.append(r16);
            return r15.toString();
        L10:
            r14 = "main";
        L15:
            if (Intrinsics.areEqual(this.descriptor.getVisibility(), DescriptorVisibilities.PRIVATE) == true) goto L17;
            return "";
        L17:
            if ((r10 instanceof PackageFragmentDescriptor) == false) goto L25;
            PropertyDescriptor r17 = this.descriptor;
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            DeserializedContainerSource r18 = ((DeserializedPropertyDescriptor) r17).getContainerSource();
            if ((r18 instanceof JvmPackagePartSource) == false) goto L26;
            JvmPackagePartSource r19 = (JvmPackagePartSource) r18;
            if (r19.getFacadeClassName() == null) goto L27;
            r15 = new StringBuilder();
            r15.append(Typography.dollar);
            r16 = r19.getSimpleName().asString();
            goto L12
        L27:
            return "";
        L26:
            return "";
        L25:
            return "";
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            return this.string;
        }

        public final PropertyDescriptor getDescriptor() {
            return this.descriptor;
        }

        public final NameResolver getNameResolver() {
            return this.nameResolver;
        }

        public final ProtoBuf.Property getProto() {
            return this.proto;
        }

        public final JvmProtoBuf.JvmPropertySignature getSignature() {
            return this.signature;
        }

        public final TypeTable getTypeTable() {
            return this.typeTable;
        }
    }

    public static final class MappedKotlinProperty extends JvmPropertySignature {
        private final JvmFunctionSignature.KotlinFunction getterSignature;
        private final JvmFunctionSignature.KotlinFunction setterSignature;

        public MappedKotlinProperty(JvmFunctionSignature.KotlinFunction r10, JvmFunctionSignature.KotlinFunction r11) {
            Intrinsics.checkNotNullParameter(r10, "getterSignature");
            super(null);
            this.getterSignature = r10;
            this.setterSignature = r11;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            return this.getterSignature.asString();
        }

        public final JvmFunctionSignature.KotlinFunction getGetterSignature() {
            return this.getterSignature;
        }

        public final JvmFunctionSignature.KotlinFunction getSetterSignature() {
            return this.setterSignature;
        }
    }

    private JvmPropertySignature() {
    }

    public /* synthetic */ JvmPropertySignature(DefaultConstructorMarker r10) {
        this();
    }

    public abstract String asString();
}
