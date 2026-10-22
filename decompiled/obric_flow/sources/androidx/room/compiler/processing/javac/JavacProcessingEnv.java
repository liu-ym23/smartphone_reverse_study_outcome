package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XFiler;
import androidx.room.compiler.processing.XMessager;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XProcessingEnvConfig;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import com.google.auto.common.o0;
import com.google.auto.common.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 X2\u00020\u0001:\u0001XB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010.\u001a\u00020/H\u0000¢\u0006\u0002\b0J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020#H\u0016J\u0012\u00106\u001a\u0004\u0018\u00010)2\u0006\u00105\u001a\u00020#H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u000204H\u0016J)\u0010:\u001a\u00020;2\u0006\u00109\u001a\u0002022\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u0002040=\"\u000204H\u0016¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u0002020@2\u0006\u0010A\u001a\u00020#H\u0016J6\u0010B\u001a\u0002HC\"\n\b\u0000\u0010C\u0018\u0001*\u00020;2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0086\b¢\u0006\u0002\u0010JJ\u001d\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020#H\u0000¢\u0006\u0002\bPJ\u000e\u0010Q\u001a\u00020R2\u0006\u0010M\u001a\u00020SJ\u000e\u0010T\u001a\u00020)2\u0006\u0010M\u001a\u00020(J\u000e\u0010U\u001a\u00020V2\u0006\u0010M\u001a\u00020WR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006Y"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "Landroidx/room/compiler/processing/XProcessingEnv;", "delegate", "Ljavax/annotation/processing/ProcessingEnvironment;", "config", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "(Ljavax/annotation/processing/ProcessingEnvironment;Landroidx/room/compiler/processing/XProcessingEnvConfig;)V", "backend", "Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "getBackend", "()Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "getConfig", "()Landroidx/room/compiler/processing/XProcessingEnvConfig;", "getDelegate", "()Ljavax/annotation/processing/ProcessingEnvironment;", "elementUtils", "Ljavax/lang/model/util/Elements;", "getElementUtils", "()Ljavax/lang/model/util/Elements;", "filer", "Landroidx/room/compiler/processing/javac/JavacFiler;", "getFiler", "()Landroidx/room/compiler/processing/javac/JavacFiler;", "jvmVersion", "", "getJvmVersion", "()I", "messager", "Landroidx/room/compiler/processing/XMessager;", "getMessager", "()Landroidx/room/compiler/processing/XMessager;", "messager$delegate", "Lkotlin/Lazy;", "options", "", "", "getOptions", "()Ljava/util/Map;", "typeElementStore", "Landroidx/room/compiler/processing/javac/XTypeElementStore;", "Ljavax/lang/model/element/TypeElement;", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "typeUtils", "Ljavax/lang/model/util/Types;", "getTypeUtils", "()Ljavax/lang/model/util/Types;", "clearCache", "", "clearCache$room_compiler_processing", "findGeneratedAnnotation", "Landroidx/room/compiler/processing/XTypeElement;", "findType", "Landroidx/room/compiler/processing/XType;", "qName", "findTypeElement", "getArrayType", "Landroidx/room/compiler/processing/javac/JavacArrayType;", "type", "getDeclaredType", "Landroidx/room/compiler/processing/javac/JavacType;", "types", "", "(Landroidx/room/compiler/processing/XTypeElement;[Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/javac/JavacType;", "getTypeElementsFromPackage", "", "packageName", "wrap", ExifInterface.GPS_DIRECTION_TRUE, "typeMirror", "Ljavax/lang/model/type/TypeMirror;", "kotlinType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "elementNullability", "Landroidx/room/compiler/processing/XNullability;", "(Ljavax/lang/model/type/TypeMirror;Landroidx/room/compiler/processing/javac/kotlin/KmType;Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/javac/JavacType;", "wrapAnnotatedElement", "Landroidx/room/compiler/processing/XElement;", "element", "Ljavax/lang/model/element/Element;", "annotationName", "wrapAnnotatedElement$room_compiler_processing", "wrapExecutableElement", "Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "Ljavax/lang/model/element/ExecutableElement;", "wrapTypeElement", "wrapVariableElement", "Landroidx/room/compiler/processing/javac/JavacVariableElement;", "Ljavax/lang/model/element/VariableElement;", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacProcessingEnv implements XProcessingEnv {
    public static final Companion Companion = null;
    private static final Map<String, TypeKind> PRIMITIVE_TYPES = null;
    private final XProcessingEnv.Backend backend;
    private final XProcessingEnvConfig config;
    private final ProcessingEnvironment delegate;
    private final Elements elementUtils;
    private final JavacFiler filer;
    private final int jvmVersion;
    private final Lazy messager$delegate;
    private final XTypeElementStore<TypeElement, JavacTypeElement> typeElementStore;
    private final Types typeUtils;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacProcessingEnv$Companion;", "", "()V", "PRIMITIVE_TYPES", "", "", "Ljavax/lang/model/type/TypeKind;", "getPRIMITIVE_TYPES", "()Ljava/util/Map;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Map<String, TypeKind> getPRIMITIVE_TYPES() {
            return JavacProcessingEnv.access$getPRIMITIVE_TYPES$cp();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r5 = new int[TypeKind.values().length];
            r5[TypeKind.ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r5[TypeKind.DECLARED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[ElementKind.values().length];
            r10[ElementKind.CONSTRUCTOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r10[ElementKind.METHOD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            $EnumSwitchMapping$1 = r10;
        }
    }

    static {
        Companion = new Companion(null);
        TypeKind[] r5 = TypeKind.values();
        ArrayList r10 = new ArrayList();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        TypeKind r13 = r5[r12];
        if (r13.isPrimitive() == false) goto L7;
        r10.add(r13);
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        LinkedHashMap r14 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r10)), 16));
        Iterator r15 = r10.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        r14.put(((TypeKind) r16).name().toLowerCase(Locale.US), r16);
        goto L10
    L12:
        PRIMITIVE_TYPES = r14;
    }

    public JavacProcessingEnv(ProcessingEnvironment r5, XProcessingEnvConfig r10) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r10, "config");
        this.delegate = r5;
        this.config = r10;
        this.backend = XProcessingEnv.Backend.JAVAC;
        this.elementUtils = r5.getElementUtils();
        this.typeUtils = r5.getTypeUtils();
        this.typeElementStore = new XTypeElementStore(new JavacProcessingEnv$typeElementStore$1(this), JavacProcessingEnv$typeElementStore$2.INSTANCE, new JavacProcessingEnv$typeElementStore$3(this));
        this.messager$delegate = LazyKt.lazy(new JavacProcessingEnv$messager$2(this));
        this.filer = new JavacFiler(this, r5.getFiler());
        Integer r11 = StringsKt.toIntOrNull(StringsKt.S(r5.getSourceVersion().name(), "RELEASE_"));
        if (r11 == null) goto L7;
        this.jvmVersion = r11.intValue();
        return;
    L7:
        throw new IllegalStateException(("Invalid source version: " + r5.getSourceVersion()).toString());
    }

    public static final /* synthetic */ Map access$getPRIMITIVE_TYPES$cp() {
        return PRIMITIVE_TYPES;
    }

    public final void clearCache$room_compiler_processing() {
        this.typeElementStore.clear$room_compiler_processing();
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XTypeElement findGeneratedAnnotation() {
        Optional r5 = y.a(this.elementUtils, this.delegate.getSourceVersion());
        if (r5.isPresent() == true) goto L7;
        return null;
    L7:
        return wrapTypeElement((TypeElement) r5.get());
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XType findType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        TypeKind r10 = PRIMITIVE_TYPES.get(r5);
        if (r10 == null) goto L23;
        TypeMirror r11 = this.typeUtils.getPrimitiveType(r10);
        XNullability r12 = XNullability.NONNULL;
        TypeKind r13 = r11.getKind();
        if (r13 != null) goto L7;
        int r14 = -1;
    L9:
        if (r14 != 1) goto L11;
        if (r12 != null) goto L30;
        XType r15 = new JavacArrayType(this, o0.a(r11));
    L29:
        return r15;
    L30:
        return new JavacArrayType(this, o0.a(r11), r12, null);
    L11:
        if (r14 == 2) goto L15;
        if (r12 == null) goto L27;
        return new DefaultJavacType(this, r11, r12);
    L27:
        return new DefaultJavacType(this, r11);
    L15:
        if (r12 != null) goto L28;
        r15 = new JavacDeclaredType(this, o0.b(r11));
        goto L29
    L28:
        return new JavacDeclaredType(this, o0.b(r11), r12);
    L7:
        r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        goto L9
    L23:
        JavacTypeElement r16 = findTypeElement(r5);
        if (r16 != null) goto L26;
        return null;
    L26:
        return r16.getType();
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public /* bridge */ /* synthetic */ XTypeElement findTypeElement(String r5) {
        return findTypeElement(r5);
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public /* bridge */ /* synthetic */ XArrayType getArrayType(XType r5) {
        return getArrayType(r5);
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XProcessingEnv.Backend getBackend() {
        return this.backend;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XProcessingEnvConfig getConfig() {
        return this.config;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public /* bridge */ /* synthetic */ XType getDeclaredType(XTypeElement r5, XType[] r10) {
        return getDeclaredType(r5, r10);
    }

    public final ProcessingEnvironment getDelegate() {
        return this.delegate;
    }

    public final Elements getElementUtils() {
        return this.elementUtils;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public /* bridge */ /* synthetic */ XFiler getFiler() {
        return getFiler();
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public int getJvmVersion() {
        return this.jvmVersion;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XMessager getMessager() {
        return (XMessager) this.messager$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public Map<String, String> getOptions() {
        return this.delegate.getOptions();
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public List<XTypeElement> getTypeElementsFromPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        PackageElement r10 = this.delegate.getElementUtils().getPackageElement(r5);
        if (r10 == null) goto L5;
        List r11 = r10.getEnclosedElements();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        Object r14 = r13.next();
        if ((r14 instanceof TypeElement) == false) goto L8;
        r12.add(r14);
        goto L8
    L12:
        ArrayList r15 = new ArrayList(CollectionsKt.h(r12));
        Iterator r16 = r12.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.add(wrapTypeElement((TypeElement) r16.next()));
        goto L14
    L16:
        return r15;
    L5:
        return CollectionsKt.emptyList();
    }

    public final Types getTypeUtils() {
        return this.typeUtils;
    }

    public final /* synthetic */ <T extends JavacType> T wrap(TypeMirror r5, KmType r10, XNullability r11) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        TypeKind r12 = r5.getKind();
        if (r12 != null) goto L5;
        int r13 = -1;
    L7:
        if (r13 != 1) goto L9;
        if (r10 == null) goto L23;
        T r14 = new JavacArrayType(this, o0.a(r5), r10);
    L26:
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return r14;
    L23:
        if (r11 == null) goto L25;
        T r15 = new JavacArrayType(this, o0.a(r5), r11, null);
    L14:
        r14 = r15;
        goto L26
    L25:
        r15 = new JavacArrayType(this, o0.a(r5));
        goto L14
    L9:
        if (r13 == 2) goto L16;
        if (r10 == null) goto L12;
        r14 = new DefaultJavacType(this, r5, r10);
        goto L26
    L12:
        if (r11 == null) goto L15;
        r15 = new DefaultJavacType(this, r5, r11);
        goto L14
    L15:
        r14 = new DefaultJavacType(this, r5);
        goto L26
    L16:
        if (r10 == null) goto L18;
        r14 = new JavacDeclaredType(this, o0.b(r5), r10);
        goto L26
    L18:
        if (r11 == null) goto L20;
        r15 = new JavacDeclaredType(this, o0.b(r5), r11);
        goto L14
    L20:
        r15 = new JavacDeclaredType(this, o0.b(r5));
        goto L14
    L5:
        r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        goto L7
    }

    public final XElement wrapAnnotatedElement$room_compiler_processing(Element r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "annotationName");
        if ((r5 instanceof VariableElement) == false) goto L6;
        return wrapVariableElement((VariableElement) r5);
    L6:
        if ((r5 instanceof TypeElement) == false) goto L9;
        return wrapTypeElement((TypeElement) r5);
    L9:
        if ((r5 instanceof ExecutableElement) == false) goto L13;
        return wrapExecutableElement((ExecutableElement) r5);
    L13:
        if ((r5 instanceof PackageElement) == false) goto L17;
        throw new IllegalStateException(("Cannot get elements with annotation " + r10 + ". Package elements are not supported by XProcessing.").toString());
    L17:
        throw new IllegalStateException(("Unsupported element " + r5 + " with annotation " + r10).toString());
    }

    public final JavacExecutableElement wrapExecutableElement(ExecutableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        ElementKind r10 = r5.getKind();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 == 1) goto L14;
        if (r11 != 2) goto L12;
        return new JavacMethodElement(this, r5);
    L12:
        throw new IllegalStateException(("Unsupported kind " + r5.getKind() + " of executable element " + r5).toString());
    L14:
        return new JavacConstructorElement(this, r5);
    L5:
        r11 = WhenMappings.$EnumSwitchMapping$1[r10.ordinal()];
        goto L7
    }

    public final JavacTypeElement wrapTypeElement(TypeElement r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        return (JavacTypeElement) this.typeElementStore.get(r5);
    }

    public final JavacVariableElement wrapVariableElement(VariableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Element r10 = r5.getEnclosingElement();
        if ((r10 instanceof ExecutableElement) == false) goto L17;
        Iterator<T> r11 = wrapExecutableElement((ExecutableElement) r10).getParameters().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((JavacMethodParameter) r12).m59getElement().getSimpleName(), r5.getSimpleName()) == false) goto L6;
    L11:
        JavacMethodParameter r13 = (JavacMethodParameter) r12;
        if (r13 == null) goto L15;
        return r13;
    L15:
        throw new IllegalStateException(("Unable to create variable element for " + r5).toString());
    L10:
        r12 = null;
        goto L11
    L17:
        if ((r10 instanceof TypeElement) == false) goto L21;
        return new JavacFieldElement(this, r5);
    L21:
        throw new IllegalStateException(("Unsupported enclosing type " + r10 + " for " + r5).toString());
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public JavacTypeElement findTypeElement(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        return (JavacTypeElement) this.typeElementStore.get(r5);
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public JavacArrayType getArrayType(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if ((r5 instanceof JavacType) == false) goto L7;
        return new JavacArrayType(this, this.typeUtils.getArrayType(((JavacType) r5).mo55getTypeMirror()), XNullability.UNKNOWN, r5.getNullability());
    L7:
        throw new IllegalStateException(("given type must be from java, " + r5 + " is not").toString());
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public JavacType getDeclaredType(XTypeElement r10, XType... r11) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "types");
        if ((r10 instanceof JavacTypeElement) == false) goto L39;
        ArrayList r5 = new ArrayList(r11.length);
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L11;
        XType r15 = r11[r14];
        if ((r15 instanceof JavacType) == false) goto L10;
        r5.add(((JavacType) r15).mo55getTypeMirror());
        r14 = r14 + 1;
        goto L5
    L10:
        throw new IllegalStateException("Check failed.");
    L11:
        Object[] r16 = r5.toArray(new TypeMirror[0]);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        TypeMirror[] r17 = (TypeMirror[]) r16;
        int r18 = r11.length;
    L12:
        if (r13 >= r18) goto L18;
        if ((r11[r13] instanceof JavacType) == false) goto L17;
        r13 = r13 + 1;
        goto L12
    L17:
        throw new IllegalStateException("Check failed.");
    L18:
        JavacTypeElement r19 = (JavacTypeElement) r10;
        TypeMirror r20 = this.typeUtils.getDeclaredType(r19.m57getElement(), (TypeMirror[]) Arrays.copyOf(r17, r17.length));
        XNullability r21 = ElementExtKt.getNullability(r19.m57getElement());
        TypeKind r22 = r20.getKind();
        if (r22 != null) goto L21;
        int r23 = -1;
    L23:
        if (r23 != 1) goto L25;
        if (r21 == null) goto L35;
        XType r24 = new JavacArrayType(this, o0.a(r20), r21, null);
    L37:
        return (JavacDeclaredType) r24;
    L35:
        XType r25 = new JavacArrayType(this, o0.a(r20));
    L32:
        r24 = r25;
        goto L37
    L25:
        if (r23 == 2) goto L29;
        if (r21 == null) goto L28;
        r24 = new DefaultJavacType(this, r20, r21);
        goto L37
    L28:
        r24 = new DefaultJavacType(this, r20);
        goto L37
    L29:
        if (r21 == null) goto L31;
        r24 = new JavacDeclaredType(this, o0.b(r20), r21);
        goto L37
    L31:
        r25 = new JavacDeclaredType(this, o0.b(r20));
        goto L32
    L21:
        r23 = WhenMappings.$EnumSwitchMapping$0[r22.ordinal()];
        goto L23
    L39:
        throw new IllegalStateException("Check failed.");
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public JavacFiler getFiler() {
        return this.filer;
    }
}
