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
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class CollectStringArrayAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r11[0] = "enumClassId";
        L10:
            r11[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (r10 == 2) goto L15;
            if (r10 == 3) goto L14;
            r11[2] = "visitEnum";
        L17:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L14:
            r11[2] = "visitAnnotation";
            goto L17
        L15:
            r11[2] = "visitClassLiteral";
            goto L17
        L7:
            r11[0] = "classId";
            goto L10
        L8:
            r11[0] = "classLiteralValue";
            goto L10
        L9:
            r11[0] = "enumEntryName";
            goto L10
        }

        public CollectStringArrayAnnotationVisitor() {
            this.strings = new ArrayList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(Object r10) {
            if ((r10 instanceof String) == false) goto L6;
            this.strings.add((String) r10);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r10) {
            if (r10 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(ClassLiteralValue r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(2);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            visitEnd((String[]) this.strings.toArray(new String[0]));
        }

        protected abstract void visitEnd(String[] r10);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(ClassId r10, Name r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L7;
            $$$reportNull$$$0(1);
            return;
        }
    }

    private class KotlinMetadataArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r11[0] = "classLiteralValue";
        L10:
            r11[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r11[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L15:
            r11[2] = "visitAnnotation";
        L16:
            r11[2] = "visitEnum";
            goto L18
        L7:
            r11[0] = "classId";
            goto L10
        L8:
            r11[0] = "enumEntryName";
            goto L10
        L9:
            r11[0] = "enumClassId";
            goto L10
        }

        private KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r10) {
            this.this$0 = r10;
        }

        /* synthetic */ KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r10, AnonymousClass1 r11) {
            this(r10);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new AnonymousClass2(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r10, Object r11) {
            if (r10 != null) goto L4;
            return;
        L4:
            String r12 = r10.asString();
            if ("k".equals(r12) == false) goto L10;
            if ((r11 instanceof Integer) == false) goto L30;
            ReadKotlinClassHeaderAnnotationVisitor.access$302(this.this$0, KotlinClassHeader.Kind.getById(((Integer) r11).intValue()));
            return;
        L30:
            return;
        L10:
            if ("mv".equals(r12) == false) goto L15;
            if ((r11 instanceof int[]) == false) goto L32;
            ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, (int[]) r11);
            return;
        L32:
            return;
        L15:
            if ("xs".equals(r12) == false) goto L20;
            if ((r11 instanceof String) == false) goto L34;
            ReadKotlinClassHeaderAnnotationVisitor.access$502(this.this$0, (String) r11);
            return;
        L34:
            return;
        L20:
            if ("xi".equals(r12) == false) goto L25;
            if ((r11 instanceof Integer) == false) goto L36;
            ReadKotlinClassHeaderAnnotationVisitor.access$602(this.this$0, ((Integer) r11).intValue());
            return;
        L36:
            return;
        L25:
            if ("pn".equals(r12) == true) goto L27;
            return;
        L27:
            if ((r11 instanceof String) == false) goto L39;
            ReadKotlinClassHeaderAnnotationVisitor.access$702(this.this$0, (String) r11);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r10, ClassId r11) {
            if (r11 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r10) {
            if (r10 == null) goto L5;
            String r11 = r10.asString();
        L7:
            if ("d1".equals(r11) == false) goto L11;
            return dataArrayVisitor();
        L11:
            if ("d2".equals(r11) == true) goto L13;
            return null;
        L13:
            return stringsArrayVisitor();
        L5:
            r11 = null;
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r10, ClassLiteralValue r11) {
            if (r11 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r10, ClassId r11, Name r12) {
            if (r11 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r12 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }
    }

    private class KotlinSerializedIrArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r11[0] = "classLiteralValue";
        L10:
            r11[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r11[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L15:
            r11[2] = "visitAnnotation";
        L16:
            r11[2] = "visitEnum";
            goto L18
        L7:
            r11[0] = "classId";
            goto L10
        L8:
            r11[0] = "enumEntryName";
            goto L10
        L9:
            r11[0] = "enumClassId";
            goto L10
        }

        private KotlinSerializedIrArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r10) {
            this.this$0 = r10;
        }

        /* synthetic */ KotlinSerializedIrArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r10, AnonymousClass1 r11) {
            this(r10);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor serializedIrArrayVisitor() {
            return new AnonymousClass1(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r10, Object r11) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r10, ClassId r11) {
            if (r11 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r10) {
            if (r10 == null) goto L5;
            String r11 = r10.asString();
        L7:
            if ("b".equals(r11) == true) goto L9;
            return null;
        L9:
            return serializedIrArrayVisitor();
        L5:
            r11 = null;
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r10, ClassLiteralValue r11) {
            if (r11 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r10, ClassId r11, Name r12) {
            if (r11 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r12 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }
    }

    private class OldDeprecatedAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L7;
            r11[0] = "classLiteralValue";
        L10:
            r11[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L16;
            if (r10 == 3) goto L15;
            r11[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L15:
            r11[2] = "visitAnnotation";
        L16:
            r11[2] = "visitEnum";
            goto L18
        L7:
            r11[0] = "classId";
            goto L10
        L8:
            r11[0] = "enumEntryName";
            goto L10
        L9:
            r11[0] = "enumClassId";
            goto L10
        }

        private OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r10) {
            this.this$0 = r10;
        }

        /* synthetic */ OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r10, AnonymousClass1 r11) {
            this(r10);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new AnonymousClass2(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r10, Object r11) {
            if (r10 != null) goto L4;
            return;
        L4:
            String r12 = r10.asString();
            if ("version".equals(r12) == false) goto L10;
            if ((r11 instanceof int[]) == false) goto L17;
            ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, (int[]) r11);
            return;
        L17:
            return;
        L10:
            if ("multifileClassName".equals(r12) == false) goto L19;
            ReadKotlinClassHeaderAnnotationVisitor r13 = this.this$0;
            if ((r11 instanceof String) == false) goto L14;
            String r14 = (String) r11;
        L15:
            ReadKotlinClassHeaderAnnotationVisitor.access$502(r13, r14);
            return;
        L14:
            r14 = null;
            goto L15
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r10, ClassId r11) {
            if (r11 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r10) {
            if (r10 == null) goto L5;
            String r11 = r10.asString();
        L7:
            if ("data".equals(r11) == true) goto L17;
            if ("filePartClassNames".equals(r11) == true) goto L17;
            if ("strings".equals(r11) == true) goto L14;
            return null;
        L14:
            return stringsArrayVisitor();
        L17:
            return dataArrayVisitor();
        L5:
            r11 = null;
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r10, ClassLiteralValue r11) {
            if (r11 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r10, ClassId r11, Name r12) {
            if (r11 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r12 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        if (r10 == 1) goto L5;
        r11[0] = "classId";
    L6:
        r11[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        r11[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L5:
        r11[0] = "source";
        goto L6
    }

    static {
        IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        HashMap r10 = new HashMap();
        HEADER_KINDS = r10;
        r10.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        r10.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        r10.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        r10.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        r10.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
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

    static /* synthetic */ String[] access$1002(ReadKotlinClassHeaderAnnotationVisitor r10, String[] r11) {
        r10.serializedIrFields = r11;
        return r11;
    }

    static /* synthetic */ KotlinClassHeader.Kind access$302(ReadKotlinClassHeaderAnnotationVisitor r10, KotlinClassHeader.Kind r11) {
        r10.headerKind = r11;
        return r11;
    }

    static /* synthetic */ int[] access$402(ReadKotlinClassHeaderAnnotationVisitor r10, int[] r11) {
        r10.metadataVersionArray = r11;
        return r11;
    }

    static /* synthetic */ String access$502(ReadKotlinClassHeaderAnnotationVisitor r10, String r11) {
        r10.extraString = r11;
        return r11;
    }

    static /* synthetic */ int access$602(ReadKotlinClassHeaderAnnotationVisitor r10, int r11) {
        r10.extraInt = r11;
        return r11;
    }

    static /* synthetic */ String access$702(ReadKotlinClassHeaderAnnotationVisitor r10, String r11) {
        r10.packageName = r11;
        return r11;
    }

    static /* synthetic */ String[] access$802(ReadKotlinClassHeaderAnnotationVisitor r10, String[] r11) {
        r10.data = r11;
        return r11;
    }

    static /* synthetic */ String[] access$902(ReadKotlinClassHeaderAnnotationVisitor r10, String[] r11) {
        r10.strings = r11;
        return r11;
    }

    private boolean shouldHaveData() {
        KotlinClassHeader.Kind r10 = this.headerKind;
        if (r10 != KotlinClassHeader.Kind.CLASS) goto L5;
    L10:
        return true;
    L5:
        if (r10 == KotlinClassHeader.Kind.FILE_FACADE) goto L10;
        if (r10 == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART) goto L10;
        return false;
    }

    public KotlinClassHeader createHeader() {
        byte[] r10 = null;
        if (this.headerKind != null) goto L5;
    L24:
        return null;
    L5:
        if (this.metadataVersionArray == null) goto L24;
        int[] r11 = this.metadataVersionArray;
        if ((this.extraInt & 8) == 0) goto L10;
        boolean r12 = true;
    L11:
        JvmMetadataVersion r13 = new JvmMetadataVersion(r11, r12);
        if (r13.isCompatible() == true) goto L15;
        this.incompatibleData = this.data;
        this.data = null;
    L19:
        String[] r14 = this.serializedIrFields;
        if (r14 == null) goto L22;
        r10 = BitEncoding.decodeBytes(r14);
    L22:
        KotlinClassHeader.Kind r15 = this.headerKind;
        String[] r16 = this.data;
        String[] r17 = this.incompatibleData;
        String[] r18 = this.strings;
        String r19 = this.extraString;
        int r20 = this.extraInt;
        String r110 = this.packageName;
        return new KotlinClassHeader(r15, r13, r16, r17, r18, r19, r20, r110, r10);
    L15:
        if (shouldHaveData() == false) goto L19;
        if (this.data != null) goto L19;
        return null;
    L10:
        r12 = false;
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r10, SourceElement r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        FqName r12 = r10.asSingleFqName();
        AnonymousClass1 r13 = null;
        if (r12.equals(JvmAnnotationNames.METADATA_FQ_NAME) == false) goto L11;
        return new KotlinMetadataArgumentVisitor(this, r13);
    L11:
        if (r12.equals(JvmAnnotationNames.SERIALIZED_IR_FQ_NAME) == false) goto L15;
        return new KotlinSerializedIrArgumentVisitor(this, r13);
    L15:
        if (IGNORE_OLD_METADATA == false) goto L18;
        return null;
    L18:
        if (this.headerKind == null) goto L20;
        return null;
    L20:
        KotlinClassHeader.Kind r14 = HEADER_KINDS.get(r10);
        if (r14 == null) goto L24;
        this.headerKind = r14;
        return new OldDeprecatedAnnotationArgumentVisitor(this, r13);
    L24:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }
}
