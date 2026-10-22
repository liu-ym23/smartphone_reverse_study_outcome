package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XProcessingConfig;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;
import com.google.devtools.ksp.symbol.ClassKind;
import com.google.devtools.ksp.symbol.Origin;
import il.c;
import il.g;
import il.j;
import il.l;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003$%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010JF\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b \u0010\nJ)\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0006¢\u0006\u0004\b#\u0010\n¨\u0006'"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspClassFileUtility;", "", "<init>", "()V", "Lil/c;", "owner", "", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "fields", "orderKotlinSourceFields", "(Lil/c;Ljava/util/List;)Ljava/util/List;", "Lil/l;", "Lil/g;", "functionDeclaration", "", "isDeclaredInside", "(Lil/l;Lil/g;)Z", ExifInterface.GPS_DIRECTION_TRUE, "ksClassDeclaration", "Landroidx/room/compiler/processing/ksp/KspClassFileUtility$Type;", "type", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getName", "Landroidx/room/compiler/processing/ksp/KspClassFileUtility$MemberNameComparator;", "getNamesComparator", "(Lil/c;Landroidx/room/compiler/processing/ksp/KspClassFileUtility$Type;Lkotlin/jvm/functions/Function1;)Landroidx/room/compiler/processing/ksp/KspClassFileUtility$MemberNameComparator;", "Landroidx/room/compiler/processing/ksp/KspClassFileUtility$ReflectionReferences;", "typeReferences", "getBinarySource", "(Landroidx/room/compiler/processing/ksp/KspClassFileUtility$ReflectionReferences;Lil/c;)Ljava/lang/Object;", "orderFields", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "methods", "orderMethods", "MemberNameComparator", "ReflectionReferences", "Type", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspClassFileUtility {
    public static final KspClassFileUtility INSTANCE = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B&\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u001bR\"\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspClassFileUtility$MemberNameComparator;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getName", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "strictMode", "", "(Lkotlin/jvm/functions/Function1;Z)V", "getGetName", "()Lkotlin/jvm/functions/Function1;", "nextOrder", "", "orders", "", "sealed", "getStrictMode", "()Z", "compare", "elm1", "elm2", "(Ljava/lang/Object;Ljava/lang/Object;)I", "getOrder", "name", "register", "", "seal", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MemberNameComparator<T> implements Comparator<T> {
        private final Function1<T, String> getName;
        private int nextOrder;
        private final Map<String, Integer> orders;
        private boolean sealed;
        private final boolean strictMode;

        /* JADX WARN: Multi-variable type inference failed */
        public MemberNameComparator(Function1<? super T, String> r5, boolean r10) {
            Intrinsics.checkNotNullParameter(r5, "getName");
            this.getName = r5;
            this.strictMode = r10;
            this.orders = new LinkedHashMap();
        }

        private final int getOrder(String r5) {
            Map<String, Integer> r10 = this.orders;
            Integer r11 = r10.get(r5);
            if (r11 != null) goto L13;
            if (this.sealed == true) goto L7;
        L11:
            int r12 = this.nextOrder;
            this.nextOrder = r12 + 1;
            r11 = Integer.valueOf(r12);
            r10.put(r5, r11);
            goto L13
        L7:
            if (this.strictMode == false) goto L11;
            throw new IllegalStateException(("expected to find field/method " + r5 + " but it is non-existent").toString());
        L13:
            return r11.intValue();
        }

        @Override // java.util.Comparator
        public int compare(T r5, T r10) {
            return Intrinsics.compare(getOrder(this.getName.invoke(r5)), getOrder(this.getName.invoke(r10)));
        }

        public final Function1<T, String> getGetName() {
            return this.getName;
        }

        public final boolean getStrictMode() {
            return this.strictMode;
        }

        public final void register(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            getOrder(r5);
        }

        public final void seal() {
            this.sealed = true;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0015\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0015\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0015\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0015\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\b¨\u0006 "}, d2 = {"Landroidx/room/compiler/processing/ksp/KspClassFileUtility$ReflectionReferences;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "asStringMethod", "Ljava/lang/reflect/Method;", "getAsStringMethod", "()Ljava/lang/reflect/Method;", "binaryClassMethod", "getBinaryClassMethod", "descriptorSourceMethod", "getDescriptorSourceMethod", "deserializedClassDescriptor", "Ljava/lang/Class;", "getDeserializedClassDescriptor", "()Ljava/lang/Class;", "getDescriptorMethod", "getGetDescriptorMethod", "kotlinJvmBinaryClass", "getKotlinJvmBinaryClass", "kotlinJvmBinarySourceElement", "getKotlinJvmBinarySourceElement", "ksClassDeclarationDescriptorImpl", "getKsClassDeclarationDescriptorImpl", "memberVisitor", "getMemberVisitor", "name", "getName", "visitMembersMethod", "getVisitMembersMethod", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ReflectionReferences {
        public static final Companion Companion = null;
        private static final Object FAILED = null;
        private static Object instance;
        private final Method asStringMethod;
        private final Method binaryClassMethod;
        private final Method descriptorSourceMethod;
        private final Class<?> deserializedClassDescriptor;
        private final Method getDescriptorMethod;
        private final Class<?> kotlinJvmBinaryClass;
        private final Class<?> kotlinJvmBinarySourceElement;
        private final Class<?> ksClassDeclarationDescriptorImpl;
        private final Class<?> memberVisitor;
        private final Class<?> name;
        private final Method visitMembersMethod;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspClassFileUtility$ReflectionReferences$Companion;", "", "()V", MiniAppWidgetAvailability.INSTALL_STATE_FAILED, "instance", "getInstance", "Landroidx/room/compiler/processing/ksp/KspClassFileUtility$ReflectionReferences;", "ref", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final ReflectionReferences getInstance(Object r5) {
                Intrinsics.checkNotNullParameter(r5, "ref");
                DefaultConstructorMarker r10 = null;
                if (ReflectionReferences.access$getInstance$cp() == null) goto L12;
            L8:
                Object r11 = ReflectionReferences.access$getInstance$cp();
                if ((r11 instanceof ReflectionReferences) == true) goto L11;
                return null;
            L11:
                return (ReflectionReferences) r11;
            L12:
                Object r12 = new ReflectionReferences(r5.getClass().getClassLoader(), r10);     // Catch: Throwable -> L6
            L7:
                ReflectionReferences.access$setInstance$cp(r12);
            L6:
                r12 = ReflectionReferences.access$getFAILED$cp();
                goto L7
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            FAILED = new Object();
        }

        public /* synthetic */ ReflectionReferences(ClassLoader r5, DefaultConstructorMarker r10) {
            this(r5);
        }

        public static final /* synthetic */ Object access$getFAILED$cp() {
            return FAILED;
        }

        public static final /* synthetic */ Object access$getInstance$cp() {
            return instance;
        }

        public static final /* synthetic */ void access$setInstance$cp(Object r5) {
            instance = r5;
        }

        public final Method getAsStringMethod() {
            return this.asStringMethod;
        }

        public final Method getBinaryClassMethod() {
            return this.binaryClassMethod;
        }

        public final Method getDescriptorSourceMethod() {
            return this.descriptorSourceMethod;
        }

        public final Class<?> getDeserializedClassDescriptor() {
            return this.deserializedClassDescriptor;
        }

        public final Method getGetDescriptorMethod() {
            return this.getDescriptorMethod;
        }

        public final Class<?> getKotlinJvmBinaryClass() {
            return this.kotlinJvmBinaryClass;
        }

        public final Class<?> getKotlinJvmBinarySourceElement() {
            return this.kotlinJvmBinarySourceElement;
        }

        public final Class<?> getKsClassDeclarationDescriptorImpl() {
            return this.ksClassDeclarationDescriptorImpl;
        }

        public final Class<?> getMemberVisitor() {
            return this.memberVisitor;
        }

        public final Class<?> getName() {
            return this.name;
        }

        public final Method getVisitMembersMethod() {
            return this.visitMembersMethod;
        }

        private ReflectionReferences(ClassLoader r10) {
            Class<?> r5 = r10.loadClass("org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedClassDescriptor");
            this.deserializedClassDescriptor = r5;
            Class<?> r11 = r10.loadClass("com.google.devtools.ksp.symbol.impl.binary.KSClassDeclarationDescriptorImpl");
            this.ksClassDeclarationDescriptorImpl = r11;
            Class<?> r12 = r10.loadClass("org.jetbrains.kotlin.load.kotlin.KotlinJvmBinarySourceElement");
            this.kotlinJvmBinarySourceElement = r12;
            Class<?> r13 = r10.loadClass("org.jetbrains.kotlin.load.kotlin.KotlinJvmBinaryClass");
            this.kotlinJvmBinaryClass = r13;
            Class<?> r14 = r10.loadClass("org.jetbrains.kotlin.load.kotlin.KotlinJvmBinaryClass$MemberVisitor");
            this.memberVisitor = r14;
            Class<?> r15 = r10.loadClass("org.jetbrains.kotlin.name.Name");
            this.name = r15;
            this.getDescriptorMethod = r11.getDeclaredMethod("getDescriptor", null);
            this.descriptorSourceMethod = r5.getMethod("getSource", null);
            this.binaryClassMethod = r12.getMethod("getBinaryClass", null);
            this.visitMembersMethod = r13.getDeclaredMethod("visitMembers", new Class[]{r14, byte[].class});
            this.asStringMethod = r15.getDeclaredMethod("asString", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspClassFileUtility$Type;", "", "visitorName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getVisitorName", "()Ljava/lang/String;", "FIELD", "METHOD", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FIELD = null;
        public static final Type METHOD = null;
        private final String visitorName;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{FIELD, METHOD};
        }

        static {
            FIELD = new Type("FIELD", 0, "visitField");
            METHOD = new Type("METHOD", 1, "visitMethod");
            $VALUES = $values();
        }

        private Type(String r5, int r10, String r11) {
            super(r5, r10);
            this.visitorName = r11;
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final String getVisitorName() {
            return this.visitorName;
        }
    }

    static {
        INSTANCE = new KspClassFileUtility();
    }

    private KspClassFileUtility() {
    }

    public static /* synthetic */ Object a(Type r5, ReflectionReferences r10, MemberNameComparator r11, Object r12, Method r13, Object[] r14) {
        return getNamesComparator$lambda$3(r5, r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ boolean access$isDeclaredInside(KspClassFileUtility r5, l r10, g r11) {
        return r5.isDeclaredInside(r10, r11);
    }

    private final Object getBinarySource(ReflectionReferences r5, c r10) {
        Object r11 = r5.getGetDescriptorMethod().invoke(r10, null);
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r5.getDeserializedClassDescriptor().isInstance(r11) == true) goto L8;
        return null;
    L8:
        Object r12 = r5.getDescriptorSourceMethod().invoke(r11, null);
        if (r12 != null) goto L12;
        return null;
    L12:
        if (r5.getKotlinJvmBinarySourceElement().isInstance(r12) == true) goto L14;
        return null;
    L14:
        Object r13 = r5.getBinaryClassMethod().invoke(r12, null);
        if (r13 != null) goto L17;
        return null;
    L17:
        return r13;
    }

    private final <T> MemberNameComparator<T> getNamesComparator(c r10, final Type r11, Function1<? super T, String> r12) {
    L11:
        th = move-exception;
        if (XProcessingConfig.INSTANCE.getSTRICT_MODE() == true) goto L31;
        return null;
    L31:
        throw new RuntimeException("failed to get fields", th);
    L4:
        if (r10.getOrigin() == Origin.KOTLIN_LIB) goto L7;
        return null;
    L7:
        if (r10.isCompanionObject() == true) goto L9;
    L13:
        final ReflectionReferences r5 = ReflectionReferences.Companion.getInstance(r10);     // Catch: Throwable -> L11
        if (r5 != null) goto L16;
        return null;
    L16:
        Object r13 = getBinarySource(r5, r10);     // Catch: Throwable -> L11
        if (r13 != null) goto L20;
        return null;
    L20:
        if (XProcessingConfig.INSTANCE.getSTRICT_MODE() == true) goto L22;
    L24:
        boolean r14 = false;
    L25:
        final MemberNameComparator<T> r15 = new MemberNameComparator(r12, r14);     // Catch: Throwable -> L11
        InvocationHandler r16 = new a(r11, r5, r15);     // Catch: Throwable -> L11
        Object r17 = Proxy.newProxyInstance(r10.getClass().getClassLoader(), new Class[]{r5.getMemberVisitor()}, r16);     // Catch: Throwable -> L11
        r5.getVisitMembersMethod().invoke(r13, new Object[]{r17, null});     // Catch: Throwable -> L11
        r15.seal();     // Catch: Throwable -> L11
        return r15;
    L22:
        if (r10.b() == ClassKind.INTERFACE) goto L24;
        r14 = true;
        goto L25
    L9:
        if (r11 != Type.FIELD) goto L13;
        r10.f();     // Catch: Throwable -> L11
        goto L13
    }

    private static final Object getNamesComparator$lambda$3(Type r5, ReflectionReferences r10, MemberNameComparator r11, Object r12, Method r13, Object[] r14) {
        Intrinsics.checkNotNullParameter(r5, "$type");
        Intrinsics.checkNotNullParameter(r10, "$typeReferences");
        Intrinsics.checkNotNullParameter(r11, "$fieldNameComparator");
        if (Intrinsics.areEqual(r13.getName(), r5.getVisitorName()) == false) goto L7;
        Object r15 = r10.getAsStringMethod().invoke(r14[0], null);
        if ((r15 instanceof String) == false) goto L7;
        r11.register((String) r15);
    L7:
        return null;
    }

    private final boolean isDeclaredInside(l r5, g r10) {
    L2:
        if (r1 == null) goto L8;
        if (Intrinsics.areEqual(r1, r10) == true) goto L5;
        j r11 = r11.getParent();
        goto L2
    L5:
        return true;
    L8:
        return false;
    }

    private final List<KspFieldElement> orderKotlinSourceFields(c r5, List<KspFieldElement> r10) {
        r5.c();
        return r10;
    }

    public final List<KspFieldElement> orderFields(c r5, List<KspFieldElement> r10) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r10, "fields");
        if (r10.isEmpty() == false) goto L6;
        return r10;
    L6:
        if (r5.getOrigin() == Origin.KOTLIN) goto L8;
        MemberNameComparator r11 = getNamesComparator(r5, Type.FIELD, KspClassFileUtility$orderFields$comparator$1.INSTANCE);
        if (r11 == null) goto L19;
        Iterator<T> r12 = r10.iterator();
    L14:
        if (r12.hasNext() == false) goto L17;
        r11.register(((KspFieldElement) r12.next()).getName());
        goto L14
    L17:
        return CollectionsKt.sortedWith(r10, r11);
    L19:
        return r10;
    L8:
        return orderKotlinSourceFields(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<KspMethodElement> orderMethods(c r5, List<? extends KspMethodElement> r10) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r10, "methods");
        if (r10.isEmpty() == false) goto L5;
        return r10;
    L5:
        MemberNameComparator r11 = getNamesComparator(r5, Type.METHOD, KspClassFileUtility$orderMethods$comparator$1.INSTANCE);
        if (r11 == null) goto L15;
        Iterator r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L13;
        r11.register(((KspMethodElement) r12.next()).getJvmName());
        goto L10
    L13:
        return CollectionsKt.sortedWith(r10, r11);
    L15:
        return r10;
    }
}
