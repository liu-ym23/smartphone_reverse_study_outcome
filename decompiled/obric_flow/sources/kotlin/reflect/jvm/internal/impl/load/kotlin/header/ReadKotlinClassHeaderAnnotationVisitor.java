package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS = null;
    private static final boolean IGNORE_OLD_METADATA = false;
    private String[] data;
    private int extraInt;
    private String extraString;
    private KotlinClassHeader.Kind headerKind;
    private String[] incompatibleData;
    private int[] metadataVersionArray;
    private String packageName;
    private String[] serializedIrFields;
    private String[] strings;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class CollectStringArrayAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r5 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r5[0] = "enumClassId";
        L10:
            r5[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (r10 == 2) goto L15;
            if (r10 == 3) goto L14;
            r5[2] = "visitEnum";
        L17:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r5));
        L14:
            r5[2] = "visitAnnotation";
            goto L17
        L15:
            r5[2] = "visitClassLiteral";
            goto L17
        L7:
            r5[0] = "classId";
            goto L10
        L8:
            r5[0] = "classLiteralValue";
            goto L10
        L9:
            r5[0] = "enumEntryName";
            goto L10
        }

        public CollectStringArrayAnnotationVisitor() {
            this.strings = new ArrayList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(Object r5) {
            if ((r5 instanceof String) == false) goto L6;
            this.strings.add((String) r5);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r5) {
            if (r5 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(ClassLiteralValue r5) {
            if (r5 != null) goto L5;
            $$$reportNull$$$0(2);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            visitEnd((String[]) this.strings.toArray(new String[0]));
        }

        public abstract void visitEnd(String[] r5);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(ClassId r5, Name r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L7;
            $$$reportNull$$$0(1);
            return;
        }
    }

    public class KotlinMetadataArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r5 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r5[0] = "classLiteralValue";
        L10:
            r5[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r5[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r5));
        L15:
            r5[2] = "visitAnnotation";
        L16:
            r5[2] = "visitEnum";
            goto L18
        L7:
            r5[0] = "classId";
            goto L10
        L8:
            r5[0] = "enumEntryName";
            goto L10
        L9:
            r5[0] = "enumClassId";
            goto L10
        }

        private KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r5) {
            this.this$0 = r5;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new AnonymousClass2(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r5, Object r10) {
            if (r5 != null) goto L4;
            return;
        L4:
            String r11 = r5.asString();
            if ("k".equals(r11) == false) goto L10;
            if ((r10 instanceof Integer) == false) goto L34;
            ReadKotlinClassHeaderAnnotationVisitor.access$302(this.this$0, KotlinClassHeader.Kind.getById(((Integer) r10).intValue()));
            return;
        L34:
            return;
        L10:
            if ("mv".equals(r11) == false) goto L15;
            if ((r10 instanceof int[]) == false) goto L36;
            ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, (int[]) r10);
            return;
        L36:
            return;
        L15:
            if ("xs".equals(r11) == false) goto L22;
            if ((r10 instanceof String) == false) goto L38;
            String r12 = (String) r10;
            if (r12.isEmpty() == true) goto L39;
            ReadKotlinClassHeaderAnnotationVisitor.access$502(this.this$0, r12);
            return;
        L39:
            return;
        L38:
            return;
        L22:
            if ("xi".equals(r11) == false) goto L27;
            if ((r10 instanceof Integer) == false) goto L41;
            ReadKotlinClassHeaderAnnotationVisitor.access$602(this.this$0, ((Integer) r10).intValue());
            return;
        L41:
            return;
        L27:
            if ("pn".equals(r11) == true) goto L29;
            return;
        L29:
            if ((r10 instanceof String) == false) goto L44;
            String r13 = (String) r10;
            if (r13.isEmpty() == true) goto L45;
            ReadKotlinClassHeaderAnnotationVisitor.access$702(this.this$0, r13);
            return;
        L45:
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r5, ClassId r10) {
            if (r10 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r5) {
            if (r5 == null) goto L5;
            String r10 = r5.asString();
        L7:
            if ("d1".equals(r10) == false) goto L11;
            return dataArrayVisitor();
        L11:
            if ("d2".equals(r10) == true) goto L13;
            return null;
        L13:
            return stringsArrayVisitor();
        L5:
            r10 = null;
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r5, ClassLiteralValue r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r5, ClassId r10, Name r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r11 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }

        public /* synthetic */ KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public class KotlinSerializedIrArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r5 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r5[0] = "classLiteralValue";
        L10:
            r5[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r5[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r5));
        L15:
            r5[2] = "visitAnnotation";
        L16:
            r5[2] = "visitEnum";
            goto L18
        L7:
            r5[0] = "classId";
            goto L10
        L8:
            r5[0] = "enumEntryName";
            goto L10
        L9:
            r5[0] = "enumClassId";
            goto L10
        }

        private KotlinSerializedIrArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r5) {
            this.this$0 = r5;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor serializedIrArrayVisitor() {
            return new AnonymousClass1(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r5, Object r10) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r5, ClassId r10) {
            if (r10 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r5) {
            if (r5 == null) goto L5;
            String r10 = r5.asString();
        L7:
            if ("b".equals(r10) == true) goto L9;
            return null;
        L9:
            return serializedIrArrayVisitor();
        L5:
            r10 = null;
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r5, ClassLiteralValue r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r5, ClassId r10, Name r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r11 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }

        public /* synthetic */ KotlinSerializedIrArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public class OldDeprecatedAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r5 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r5[0] = "classLiteralValue";
        L10:
            r5[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r5[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r5));
        L15:
            r5[2] = "visitAnnotation";
        L16:
            r5[2] = "visitEnum";
            goto L18
        L7:
            r5[0] = "classId";
            goto L10
        L8:
            r5[0] = "enumEntryName";
            goto L10
        L9:
            r5[0] = "enumClassId";
            goto L10
        }

        private OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r5) {
            this.this$0 = r5;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new AnonymousClass2(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r5, Object r10) {
            if (r5 != null) goto L4;
            return;
        L4:
            String r11 = r5.asString();
            if ("version".equals(r11) == false) goto L10;
            if ((r10 instanceof int[]) == false) goto L17;
            ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, (int[]) r10);
            return;
        L17:
            return;
        L10:
            if ("multifileClassName".equals(r11) == false) goto L19;
            ReadKotlinClassHeaderAnnotationVisitor r12 = this.this$0;
            if ((r10 instanceof String) == false) goto L14;
            String r13 = (String) r10;
        L15:
            ReadKotlinClassHeaderAnnotationVisitor.access$502(r12, r13);
            return;
        L14:
            r13 = null;
            goto L15
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r5, ClassId r10) {
            if (r10 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r5) {
            if (r5 == null) goto L5;
            String r10 = r5.asString();
        L7:
            if ("data".equals(r10) == true) goto L17;
            if ("filePartClassNames".equals(r10) == true) goto L17;
            if ("strings".equals(r10) == true) goto L14;
            return null;
        L14:
            return stringsArrayVisitor();
        L17:
            return dataArrayVisitor();
        L5:
            r10 = null;
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r5, ClassLiteralValue r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r5, ClassId r10, Name r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r11 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }

        public /* synthetic */ OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r5) {
        Object[] r10 = new Object[3];
        if (r5 == 1) goto L5;
        r10[0] = "classId";
    L6:
        r10[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        r10[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r10));
    L5:
        r10[0] = "source";
        goto L6
    }

    static {
        IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        HashMap r5 = new HashMap();
        HEADER_KINDS = r5;
        r5.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        r5.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        r5.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        r5.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        r5.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    public ReadKotlinClassHeaderAnnotationVisitor() {
        this.metadataVersionArray = null;
        this.extraString = null;
        this.extraInt = 0;
        this.packageName = null;
        this.data = null;
        this.strings = null;
        this.incompatibleData = null;
        this.headerKind = null;
        this.serializedIrFields = null;
    }

    public static /* synthetic */ String[] access$1002(ReadKotlinClassHeaderAnnotationVisitor r5, String[] r10) {
        r5.serializedIrFields = r10;
        return r10;
    }

    public static /* synthetic */ KotlinClassHeader.Kind access$302(ReadKotlinClassHeaderAnnotationVisitor r5, KotlinClassHeader.Kind r10) {
        r5.headerKind = r10;
        return r10;
    }

    public static /* synthetic */ int[] access$402(ReadKotlinClassHeaderAnnotationVisitor r5, int[] r10) {
        r5.metadataVersionArray = r10;
        return r10;
    }

    public static /* synthetic */ String access$502(ReadKotlinClassHeaderAnnotationVisitor r5, String r10) {
        r5.extraString = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(ReadKotlinClassHeaderAnnotationVisitor r5, int r10) {
        r5.extraInt = r10;
        return r10;
    }

    public static /* synthetic */ String access$702(ReadKotlinClassHeaderAnnotationVisitor r5, String r10) {
        r5.packageName = r10;
        return r10;
    }

    public static /* synthetic */ String[] access$802(ReadKotlinClassHeaderAnnotationVisitor r5, String[] r10) {
        r5.data = r10;
        return r10;
    }

    public static /* synthetic */ String[] access$902(ReadKotlinClassHeaderAnnotationVisitor r5, String[] r10) {
        r5.strings = r10;
        return r10;
    }

    private boolean shouldHaveData() {
        KotlinClassHeader.Kind r5 = this.headerKind;
        if (r5 != KotlinClassHeader.Kind.CLASS) goto L5;
    L10:
        return true;
    L5:
        if (r5 == KotlinClassHeader.Kind.FILE_FACADE) goto L10;
        if (r5 == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART) goto L10;
        return false;
    }

    public KotlinClassHeader createHeader(JvmMetadataVersion r13) {
        byte[] r5 = null;
        if (this.headerKind != null) goto L5;
    L24:
        return null;
    L5:
        if (this.metadataVersionArray == null) goto L24;
        int[] r10 = this.metadataVersionArray;
        if ((this.extraInt & 8) == 0) goto L10;
        boolean r11 = true;
    L11:
        JvmMetadataVersion r12 = new JvmMetadataVersion(r10, r11);
        if (r12.isCompatible(r13) == true) goto L15;
        this.incompatibleData = this.data;
        this.data = null;
    L19:
        String[] r14 = this.serializedIrFields;
        if (r14 == null) goto L22;
        r5 = BitEncoding.decodeBytes(r14);
    L22:
        KotlinClassHeader.Kind r15 = this.headerKind;
        String[] r16 = this.data;
        String[] r17 = this.incompatibleData;
        String[] r18 = this.strings;
        String r19 = this.extraString;
        int r20 = this.extraInt;
        String r110 = this.packageName;
        return new KotlinClassHeader(r15, r12, r16, r17, r18, r19, r20, r110, r5);
    L15:
        if (shouldHaveData() == false) goto L19;
        if (this.data != null) goto L19;
        return null;
    L10:
        r11 = false;
        goto L11
    }

    public KotlinClassHeader createHeaderWithDefaultMetadataVersion() {
        return createHeader(JvmMetadataVersion.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r5, SourceElement r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        FqName r11 = r5.asSingleFqName();
        AnonymousClass1 r12 = null;
        if (r11.equals(JvmAnnotationNames.METADATA_FQ_NAME) == false) goto L11;
        return new KotlinMetadataArgumentVisitor(this, r12);
    L11:
        if (r11.equals(JvmAnnotationNames.SERIALIZED_IR_FQ_NAME) == false) goto L15;
        return new KotlinSerializedIrArgumentVisitor(this, r12);
    L15:
        if (IGNORE_OLD_METADATA == false) goto L18;
        return null;
    L18:
        if (this.headerKind == null) goto L20;
        return null;
    L20:
        KotlinClassHeader.Kind r13 = HEADER_KINDS.get(r5);
        if (r13 == null) goto L24;
        this.headerKind = r13;
        return new OldDeprecatedAnnotationArgumentVisitor(this, r12);
    L24:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }
}
