package androidx.room.compiler.processing.javac;

import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEnumEntry;
import androidx.room.compiler.processing.XEnumTypeElement;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XHasModifiers;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeParameterElement;
import androidx.room.compiler.processing.javac.kotlin.KotlinMetadataElement;
import androidx.room.compiler.processing.util.MemoizedSequence;
import com.google.auto.common.d0;
import com.google.auto.common.o0;
import com.squareup.javapoet.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003z{|B\u0019\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u000f\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0010\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u0010\u0010\u0011\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\fJ\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\fJ\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\fJ\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\fJ\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\fJ\u000f\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010\fJ\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\fJ\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\fJ\u000f\u0010*\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010\fJ\u0011\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u001eH\u0016¢\u0006\u0004\b/\u0010 J\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020+0\u001eH\u0016¢\u0006\u0004\b0\u0010 J\u0015\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016¢\u0006\u0004\b1\u0010 J\u0015\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016¢\u0006\u0004\b2\u0010 R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00103\u001a\u0004\b4\u00105R\u001d\u0010;\u001a\u0004\u0018\u0001068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u00108\u001a\u0004\bC\u0010DR\u001b\u0010H\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u00108\u001a\u0004\bG\u0010\u0015R\u001d\u0010M\u001a\u0004\u0018\u00010I8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u00108\u001a\u0004\bK\u0010LR!\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bO\u00108\u001a\u0004\bP\u0010 R\u001d\u0010U\u001a\u0004\u0018\u00010\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u00108\u001a\u0004\bS\u0010TR!\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u00108\u001a\u0004\bX\u0010 R\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010[R!\u0010_\u001a\b\u0012\u0004\u0012\u00020.0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u00108\u001a\u0004\b^\u0010 R\u001b\u0010d\u001a\u00020`8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\ba\u00108\u001a\u0004\bb\u0010cR!\u0010h\u001a\b\u0012\u0004\u0012\u00020e0\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bf\u00108\u001a\u0004\bg\u0010 R\u001d\u0010m\u001a\u0004\u0018\u00010i8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bj\u00108\u001a\u0004\bk\u0010lR!\u0010p\u001a\b\u0012\u0004\u0012\u00020i0\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bn\u00108\u001a\u0004\bo\u0010 R\u0014\u0010r\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010?R\u001a\u0010v\u001a\u00020<8VX\u0096\u0004¢\u0006\f\u0012\u0004\bt\u0010u\u001a\u0004\bs\u0010?R\u0014\u0010y\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bw\u0010x\u0082\u0001\u0002}~¨\u0006\u007f"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacTypeElement;", "Landroidx/room/compiler/processing/javac/JavacElement;", "Landroidx/room/compiler/processing/XTypeElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "env", "Ljavax/lang/model/element/TypeElement;", "element", "<init>", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/TypeElement;)V", "", "isAbstract", "()Z", "isFinal", "isPrivate", "isProtected", "isPublic", "isStatic", "isTransient", "Landroidx/room/compiler/codegen/XClassName;", "asClassName", "()Landroidx/room/compiler/codegen/XClassName;", "Lkotlin/sequences/Sequence;", "Landroidx/room/compiler/processing/XMethodElement;", "getAllMethods", "()Lkotlin/sequences/Sequence;", "Landroidx/room/compiler/processing/util/MemoizedSequence;", "Landroidx/room/compiler/processing/XFieldElement;", "getAllFieldsIncludingPrivateSupers", "()Landroidx/room/compiler/processing/util/MemoizedSequence;", "", "getDeclaredFields", "()Ljava/util/List;", "isKotlinObject", "isCompanionObject", "isDataClass", "isValueClass", "isFunctionalInterface", "isExpect", "isAnnotationClass", "isClass", "isNested", "isInterface", "Landroidx/room/compiler/processing/javac/JavacConstructorElement;", "findPrimaryConstructor", "()Landroidx/room/compiler/processing/javac/JavacConstructorElement;", "Landroidx/room/compiler/processing/javac/JavacMethodElement;", "getDeclaredMethods", "getConstructors", "getSuperInterfaceElements", "getEnclosedTypeElements", "Ljavax/lang/model/element/TypeElement;", "getElement", "()Ljavax/lang/model/element/TypeElement;", "Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataElement;", "kotlinMetadata$delegate", "Lkotlin/Lazy;", "getKotlinMetadata", "()Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataElement;", "kotlinMetadata", "", "qualifiedName$delegate", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName", "Lcom/squareup/javapoet/e;", "className$delegate", "getClassName", "()Lcom/squareup/javapoet/e;", "className", "xClassName$delegate", "getXClassName", "xClassName", "Landroidx/room/compiler/processing/XMemberContainer;", "enclosingElement$delegate", "getEnclosingElement", "()Landroidx/room/compiler/processing/XMemberContainer;", "enclosingElement", "Landroidx/room/compiler/processing/XTypeParameterElement;", "typeParameters$delegate", "getTypeParameters", "typeParameters", "enclosingTypeElement$delegate", "getEnclosingTypeElement", "()Landroidx/room/compiler/processing/XTypeElement;", "enclosingTypeElement", "Landroidx/room/compiler/processing/javac/JavacFieldElement;", "_declaredFields$delegate", "get_declaredFields", "_declaredFields", "allMethods", "Landroidx/room/compiler/processing/util/MemoizedSequence;", "allFieldsIncludingPrivateSupers", "_declaredMethods$delegate", "get_declaredMethods", "_declaredMethods", "Landroidx/room/compiler/processing/javac/JavacDeclaredType;", "type$delegate", "getType", "()Landroidx/room/compiler/processing/javac/JavacDeclaredType;", "type", "Landroidx/room/compiler/processing/XType;", "superTypes$delegate", "getSuperTypes", "superTypes", "Landroidx/room/compiler/processing/javac/JavacType;", "superClass$delegate", "getSuperClass", "()Landroidx/room/compiler/processing/javac/JavacType;", "superClass", "superInterfaces$delegate", "getSuperInterfaces", "superInterfaces", "getName", "name", "getPackageName", "getPackageName$annotations", "()V", "packageName", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/javac/JavacTypeElement;", "closestMemberContainer", "Companion", "DefaultJavacTypeElement", "JavacEnumTypeElement", "Landroidx/room/compiler/processing/javac/JavacTypeElement$DefaultJavacTypeElement;", "Landroidx/room/compiler/processing/javac/JavacTypeElement$JavacEnumTypeElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacTypeElement extends JavacElement implements XTypeElement, XHasModifiers {
    public static final Companion Companion = null;
    private final /* synthetic */ JavacHasModifiers $$delegate_0;
    private final Lazy _declaredFields$delegate;
    private final Lazy _declaredMethods$delegate;
    private final MemoizedSequence<XFieldElement> allFieldsIncludingPrivateSupers;
    private final MemoizedSequence<XMethodElement> allMethods;
    private final Lazy className$delegate;
    private final TypeElement element;
    private final Lazy enclosingElement$delegate;
    private final Lazy enclosingTypeElement$delegate;
    private final Lazy kotlinMetadata$delegate;
    private final Lazy qualifiedName$delegate;
    private final Lazy superClass$delegate;
    private final Lazy superInterfaces$delegate;
    private final Lazy superTypes$delegate;
    private final Lazy type$delegate;
    private final Lazy typeParameters$delegate;
    private final Lazy xClassName$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacTypeElement$Companion;", "", "()V", "create", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "typeElement", "Ljavax/lang/model/element/TypeElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[ElementKind.values().length];
                r5[ElementKind.ENUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final JavacTypeElement create(JavacProcessingEnv r5, TypeElement r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "typeElement");
            ElementKind r11 = r10.getKind();
            if (r11 != null) goto L5;
            int r12 = -1;
        L7:
            if (r12 != 1) goto L10;
            return new JavacEnumTypeElement(r5, r10);
        L10:
            return new DefaultJavacTypeElement(r5, r10);
        L5:
            r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
            goto L7
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacTypeElement$DefaultJavacTypeElement;", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/TypeElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/TypeElement;)V", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultJavacTypeElement extends JavacTypeElement {
        public DefaultJavacTypeElement(JavacProcessingEnv r5, TypeElement r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "element");
            super(r5, r10, null);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacTypeElement$JavacEnumTypeElement;", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "Landroidx/room/compiler/processing/XEnumTypeElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/TypeElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/TypeElement;)V", "entries", "", "Landroidx/room/compiler/processing/XEnumEntry;", "getEntries", "()Ljava/util/Set;", "entries$delegate", "Lkotlin/Lazy;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class JavacEnumTypeElement extends JavacTypeElement implements XEnumTypeElement {
        private final Lazy entries$delegate;

        public JavacEnumTypeElement(final JavacProcessingEnv r5, final TypeElement r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "element");
            super(r5, r10, null);
            if (r10.getKind() != ElementKind.ENUM) goto L7;
            this.entries$delegate = LazyKt.lazy(new JavacTypeElement$JavacEnumTypeElement$entries$2(r10, r5, this));
            return;
        L7:
            throw new IllegalStateException("Check failed.");
        }

        @Override // androidx.room.compiler.processing.XEnumTypeElement
        public Set<XEnumEntry> getEntries() {
            return (Set) this.entries$delegate.getValue();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ JavacTypeElement(JavacProcessingEnv r5, TypeElement r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static final /* synthetic */ XClassName access$getXClassName(JavacTypeElement r5) {
        return r5.getXClassName();
    }

    public static /* synthetic */ void getPackageName$annotations() {
    }

    private final XClassName getXClassName() {
        return (XClassName) this.xClassName$delegate.getValue();
    }

    private final List<JavacFieldElement> get_declaredFields() {
        return (List) this._declaredFields$delegate.getValue();
    }

    private final List<JavacMethodElement> get_declaredMethods() {
        return (List) this._declaredMethods$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public XClassName asClassName() {
        return getXClassName();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public /* bridge */ /* synthetic */ XConstructorElement findPrimaryConstructor() {
        return findPrimaryConstructor();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public /* bridge */ /* synthetic */ Sequence getAllFieldsIncludingPrivateSupers() {
        return getAllFieldsIncludingPrivateSupers();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public Sequence<XMethodElement> getAllMethods() {
        return this.allMethods;
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public e getClassName() {
        return (e) this.className$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public JavacTypeElement getClosestMemberContainer() {
        return this;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<JavacConstructorElement> getConstructors() {
        List r5 = ElementFilter.constructorsIn(m57getElement().getEnclosedElements());
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ExecutableElement r12 = (ExecutableElement) r11.next();
        r10.add(new JavacConstructorElement(getEnv$room_compiler_processing(), r12));
        goto L4
    L6:
        return r10;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XFieldElement> getDeclaredFields() {
        return get_declaredFields();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<JavacMethodElement> getDeclaredMethods() {
        return get_declaredMethods();
    }

    @Override // androidx.room.compiler.processing.javac.JavacElement
    public /* bridge */ /* synthetic */ Element getElement() {
        return m57getElement();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XTypeElement> getEnclosedTypeElements() {
        List r5 = ElementFilter.typesIn(m57getElement().getEnclosedElements());
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        TypeElement r12 = (TypeElement) r11.next();
        r10.add(getEnv$room_compiler_processing().wrapTypeElement(r12));
        goto L4
    L6:
        return r10;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public XTypeElement getEnclosingTypeElement() {
        return (XTypeElement) this.enclosingTypeElement$delegate.getValue();
    }

    public final KotlinMetadataElement getKotlinMetadata() {
        return (KotlinMetadataElement) this.kotlinMetadata$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return m57getElement().getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public String getPackageName() {
        return d0.d(m57getElement()).getQualifiedName().toString();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public String getQualifiedName() {
        return (String) this.qualifiedName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public /* bridge */ /* synthetic */ XType getSuperClass() {
        return getSuperClass();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XTypeElement> getSuperInterfaceElements() {
        List r5 = m57getElement().getInterfaces();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        TypeMirror r12 = (TypeMirror) r11.next();
        r10.add(getEnv$room_compiler_processing().wrapTypeElement(o0.g(r12)));
        goto L4
    L6:
        return r10;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<JavacType> getSuperInterfaces() {
        return (List) this.superInterfaces$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XType> getSuperTypes() {
        return (List) this.superTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public /* bridge */ /* synthetic */ XType getType() {
        return getType();
    }

    @Override // androidx.room.compiler.processing.XParameterizable
    public List<XTypeParameterElement> getTypeParameters() {
        return (List) this.typeParameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isAbstract() {
        return this.$$delegate_0.isAbstract();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isAnnotationClass() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 == null) goto L6;
        return r5.isAnnotationClass();
    L6:
        if (m57getElement().getKind() != ElementKind.ANNOTATION_TYPE) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isClass() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 == null) goto L6;
        return r5.isClass();
    L6:
        if (m57getElement().getKind() != ElementKind.CLASS) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isCompanionObject() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isCompanionObject() == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isDataClass() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isDataClass() == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isExpect() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isExpect() == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isFinal() {
        return this.$$delegate_0.isFinal();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isFunctionalInterface() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isFunctionalInterface() == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isInterface() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 == null) goto L6;
        return r5.isInterface();
    L6:
        if (m57getElement().getKind() != ElementKind.INTERFACE) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isKotlinObject() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
    L7:
        KotlinMetadataElement r10 = getKotlinMetadata();
        if (r10 != null) goto L10;
    L12:
        return false;
    L10:
        if (r10.isCompanionObject() != true) goto L12;
        return true;
    L5:
        if (r5.isObject() != true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isNested() {
        if (ElementExtKt.enclosingType(m57getElement(), getEnv$room_compiler_processing()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPrivate() {
        return this.$$delegate_0.isPrivate();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isProtected() {
        return this.$$delegate_0.isProtected();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPublic() {
        return this.$$delegate_0.isPublic();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isStatic() {
        return this.$$delegate_0.isStatic();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isValueClass() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isValueClass() == true) goto L7;
        return false;
    L7:
        return true;
    }

    private JavacTypeElement(final JavacProcessingEnv r5, TypeElement r10) {
        Element r11 = (Element) r10;
        super(r5, r11);
        this.element = r10;
        this.$$delegate_0 = new JavacHasModifiers(r11);
        this.kotlinMetadata$delegate = LazyKt.lazy(new JavacTypeElement$kotlinMetadata$2(this));
        this.qualifiedName$delegate = LazyKt.lazy(new JavacTypeElement$qualifiedName$2(this));
        this.className$delegate = LazyKt.lazy(new JavacTypeElement$className$2(this));
        this.xClassName$delegate = LazyKt.lazy(new JavacTypeElement$xClassName$2(this));
        this.enclosingElement$delegate = LazyKt.lazy(new JavacTypeElement$enclosingElement$2(this));
        this.typeParameters$delegate = LazyKt.lazy(new JavacTypeElement$typeParameters$2(this, r5));
        this.enclosingTypeElement$delegate = LazyKt.lazy(new JavacTypeElement$enclosingTypeElement$2(this, r5));
        this._declaredFields$delegate = LazyKt.lazy(new JavacTypeElement$_declaredFields$2(this, r5));
        this.allMethods = new MemoizedSequence(new JavacTypeElement$allMethods$1(this));
        this.allFieldsIncludingPrivateSupers = new MemoizedSequence(new JavacTypeElement$allFieldsIncludingPrivateSupers$1(this));
        this._declaredMethods$delegate = LazyKt.lazy(new JavacTypeElement$_declaredMethods$2(this, r5));
        this.type$delegate = LazyKt.lazy(new JavacTypeElement$type$2(r5, this));
        this.superTypes$delegate = LazyKt.lazy(new JavacTypeElement$superTypes$2(this, r5));
        this.superClass$delegate = LazyKt.lazy(new JavacTypeElement$superClass$2(this, r5));
        this.superInterfaces$delegate = LazyKt.lazy(new JavacTypeElement$superInterfaces$2(this, r5));
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public JavacConstructorElement findPrimaryConstructor() {
        KotlinMetadataElement r5 = getKotlinMetadata();
        Object r10 = null;
        if (r5 == null) goto L18;
        String r11 = r5.findPrimaryConstructorSignature();
        if (r11 == null) goto L19;
        Iterator<T> r12 = getConstructors().iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(r11, ((JavacConstructorElement) r13).getDescriptor()) == false) goto L9;
        r10 = r13;
    L14:
        return (JavacConstructorElement) r10;
    L19:
        return null;
    L18:
        return null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public MemoizedSequence<XFieldElement> getAllFieldsIncludingPrivateSupers() {
        return this.allFieldsIncludingPrivateSupers;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    /* JADX INFO: renamed from: getElement, reason: collision with other method in class */
    public TypeElement m57getElement() {
        return this.element;
    }

    @Override // androidx.room.compiler.processing.XElement
    public XMemberContainer getEnclosingElement() {
        return (XMemberContainer) this.enclosingElement$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public JavacType getSuperClass() {
        return (JavacType) this.superClass$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public JavacDeclaredType getType() {
        return (JavacDeclaredType) this.type$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XTypeElement getClosestMemberContainer() {
        return getClosestMemberContainer();
    }
}
