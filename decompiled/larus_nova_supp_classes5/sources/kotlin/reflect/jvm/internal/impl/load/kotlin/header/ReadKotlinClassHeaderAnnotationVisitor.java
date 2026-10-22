package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.security.AccessControlException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS = null;
    private static boolean IGNORE_OLD_METADATA;
    private String[] data;
    private int extraInt;
    private String extraString;
    private KotlinClassHeader.Kind headerKind;
    private String[] incompatibleData;
    private int[] metadataVersionArray;
    private String packageName;
    private String[] serializedIrFields;
    private String[] strings;

    public static abstract class CollectStringArrayAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings;

        private static /* synthetic */ void $$$reportNull$$$0(int r6) {
            Object[] r1 = new Object[3];
            if (r6 == 1) goto L9;
            if (r6 == 2) goto L8;
            if (r6 == 3) goto L7;
            r1[0] = "enumClassId";
        L10:
            r1[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (r6 == 2) goto L15;
            if (r6 == 3) goto L14;
            r1[2] = "visitEnum";
        L17:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L14:
            r1[2] = "visitAnnotation";
            goto L17
        L15:
            r1[2] = "visitClassLiteral";
            goto L17
        L7:
            r1[0] = "classId";
            goto L10
        L8:
            r1[0] = "classLiteralValue";
            goto L10
        L9:
            r1[0] = "enumEntryName";
            goto L10
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r1) {
            if (r1 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(ClassLiteralValue r1) {
            if (r1 != null) goto L5;
            $$$reportNull$$$0(2);
            return;
        }

        public abstract void visitEnd(String[] r1);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(ClassId r1, Name r2) {
            if (r1 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r2 != null) goto L7;
            $$$reportNull$$$0(1);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            visitEnd((String[]) this.strings.toArray(new String[0]));
        }

        public CollectStringArrayAnnotationVisitor() {
            this.strings = new ArrayList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(Object r2) {
            if ((r2 instanceof String) == false) goto L6;
            this.strings.add((String) r2);
            return;
        }
    }

    public class KotlinMetadataArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r6) {
            Object[] r1 = new Object[3];
            if (r6 == 1) goto L9;
            if (r6 == 2) goto L8;
            if (r6 == 3) goto L7;
            r1[0] = "classLiteralValue";
        L10:
            r1[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (r6 == 1) goto L16;
            if (r6 == 2) goto L16;
            if (r6 == 3) goto L15;
            r1[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L15:
            r1[2] = "visitAnnotation";
        L16:
            r1[2] = "visitEnum";
            goto L18
        L7:
            r1[0] = "classId";
            goto L10
        L8:
            r1[0] = "enumEntryName";
            goto L10
        L9:
            r1[0] = "enumClassId";
            goto L10
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r1, ClassId r2) {
            if (r2 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r1, ClassLiteralValue r2) {
            if (r2 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r1, ClassId r2, Name r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r3 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new AnonymousClass2(this);
        }

        private KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r1) {
            this.this$0 = r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r3) {
            if (r3 == null) goto L5;
            String r4 = r3.asString();
        L7:
            if ("d1".equals(r4) == false) goto L11;
            return dataArrayVisitor();
        L11:
            if ("d2".equals(r4) == true) goto L13;
            return null;
        L13:
            return stringsArrayVisitor();
        L5:
            r4 = null;
            goto L7
        }

        public /* synthetic */ KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r1, 1 r2) {
            this(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r2, Object r3) {
            if (r2 != null) goto L4;
            return;
        L4:
            String r4 = r2.asString();
            if ("k".equals(r4) == false) goto L10;
            if ((r3 instanceof Integer) == false) goto L34;
            ReadKotlinClassHeaderAnnotationVisitor.access$302(this.this$0, KotlinClassHeader.Kind.getById(((Integer) r3).intValue()));
            return;
        L34:
            return;
        L10:
            if ("mv".equals(r4) == false) goto L15;
            if ((r3 instanceof int[]) == false) goto L36;
            ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, (int[]) r3);
            return;
        L36:
            return;
        L15:
            if ("xs".equals(r4) == false) goto L22;
            if ((r3 instanceof String) == false) goto L38;
            String r5 = (String) r3;
            if (r5.isEmpty() == true) goto L39;
            ReadKotlinClassHeaderAnnotationVisitor.access$502(this.this$0, r5);
            return;
        L39:
            return;
        L38:
            return;
        L22:
            if ("xi".equals(r4) == false) goto L27;
            if ((r3 instanceof Integer) == false) goto L41;
            ReadKotlinClassHeaderAnnotationVisitor.access$602(this.this$0, ((Integer) r3).intValue());
            return;
        L41:
            return;
        L27:
            if ("pn".equals(r4) == true) goto L29;
            return;
        L29:
            if ((r3 instanceof String) == false) goto L44;
            String r6 = (String) r3;
            if (r6.isEmpty() == true) goto L45;
            ReadKotlinClassHeaderAnnotationVisitor.access$702(this.this$0, r6);
            return;
        L45:
            return;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r3) {
        Object[] r0 = new Object[3];
        if (r3 == 1) goto L5;
        r0[0] = "classId";
    L6:
        r0[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        r0[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L5:
        r0[0] = "source";
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }

    static {
        IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));     // Catch: AccessControlException -> L4
    L5:
        HashMap r0 = new HashMap();
        HEADER_KINDS = r0;
        r0.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        r0.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        r0.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        r0.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        r0.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
        return;
    L4:
        IGNORE_OLD_METADATA = false;
        goto L5
    }

    private boolean shouldHaveData() {
        KotlinClassHeader.Kind r0 = this.headerKind;
        if (r0 != KotlinClassHeader.Kind.CLASS) goto L5;
    L10:
        return true;
    L5:
        if (r0 == KotlinClassHeader.Kind.FILE_FACADE) goto L10;
        if (r0 == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART) goto L10;
        return false;
    }

    public KotlinClassHeader createHeaderWithDefaultMetadataVersion() {
        return createHeader(JvmMetadataVersion.INSTANCE);
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

    public KotlinClassHeader createHeader(JvmMetadataVersion r13) {
        byte[] r1 = null;
        if (this.headerKind != null) goto L5;
    L24:
        return null;
    L5:
        if (this.metadataVersionArray == null) goto L24;
        int[] r0 = this.metadataVersionArray;
        if ((this.extraInt & 8) == 0) goto L10;
        boolean r2 = true;
    L11:
        JvmMetadataVersion r4 = new JvmMetadataVersion(r0, r2);
        if (r4.isCompatible(r13) == true) goto L15;
        this.incompatibleData = this.data;
        this.data = null;
    L19:
        String[] r14 = this.serializedIrFields;
        if (r14 == null) goto L22;
        r1 = BitEncoding.decodeBytes(r14);
    L22:
        KotlinClassHeader.Kind r3 = this.headerKind;
        String[] r5 = this.data;
        String[] r6 = this.incompatibleData;
        String[] r7 = this.strings;
        String r8 = this.extraString;
        int r9 = this.extraInt;
        String r10 = this.packageName;
        return new KotlinClassHeader(r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L15:
        if (shouldHaveData() == false) goto L19;
        if (this.data != null) goto L19;
        return null;
    L10:
        r2 = false;
        goto L11
    }

    public static /* synthetic */ String[] access$1002(ReadKotlinClassHeaderAnnotationVisitor r0, String[] r1) {
        r0.serializedIrFields = r1;
        return r1;
    }

    public static /* synthetic */ KotlinClassHeader.Kind access$302(ReadKotlinClassHeaderAnnotationVisitor r0, KotlinClassHeader.Kind r1) {
        r0.headerKind = r1;
        return r1;
    }

    public static /* synthetic */ int[] access$402(ReadKotlinClassHeaderAnnotationVisitor r0, int[] r1) {
        r0.metadataVersionArray = r1;
        return r1;
    }

    public static /* synthetic */ String access$502(ReadKotlinClassHeaderAnnotationVisitor r0, String r1) {
        r0.extraString = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(ReadKotlinClassHeaderAnnotationVisitor r0, int r1) {
        r0.extraInt = r1;
        return r1;
    }

    public static /* synthetic */ String access$702(ReadKotlinClassHeaderAnnotationVisitor r0, String r1) {
        r0.packageName = r1;
        return r1;
    }

    public static /* synthetic */ String[] access$802(ReadKotlinClassHeaderAnnotationVisitor r0, String[] r1) {
        r0.data = r1;
        return r1;
    }

    public static /* synthetic */ String[] access$902(ReadKotlinClassHeaderAnnotationVisitor r0, String[] r1) {
        r0.strings = r1;
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r3, SourceElement r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        FqName r5 = r3.asSingleFqName();
        1 r1 = null;
        if (r5.equals(JvmAnnotationNames.METADATA_FQ_NAME) == false) goto L11;
        return new KotlinMetadataArgumentVisitor(this, r1);
    L11:
        if (r5.equals(JvmAnnotationNames.SERIALIZED_IR_FQ_NAME) == false) goto L15;
        return new KotlinSerializedIrArgumentVisitor(this, null);
    L15:
        if (IGNORE_OLD_METADATA == false) goto L18;
        return null;
    L18:
        if (this.headerKind == null) goto L20;
        return null;
    L20:
        KotlinClassHeader.Kind r6 = HEADER_KINDS.get(r3);
        if (r6 == null) goto L24;
        this.headerKind = r6;
        return new OldDeprecatedAnnotationArgumentVisitor(this, null);
    L24:
        return null;
    }
}
