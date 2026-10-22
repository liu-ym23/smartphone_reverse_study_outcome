package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XConstructorType;
import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XFiler;
import androidx.room.compiler.processing.XMessager;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XProcessingEnvConfig;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.javac.XTypeElementStore;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.google.devtools.ksp.symbol.Variance;
import hl.d;
import il.c;
import il.f;
import il.p;
import il.q;
import il.r;
import il.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0087\u0001B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u001c\"\u00020\u0016H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010(\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010(\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020$¢\u0006\u0004\b(\u0010+J\u001d\u0010(\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b(\u00100J\u001d\u0010(\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&2\u0006\u00102\u001a\u000201¢\u0006\u0004\b(\u00103J\u0015\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u0010;\u001a\u00020:2\u0006\u00109\u001a\u000208¢\u0006\u0004\b;\u0010<J'\u0010@\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010>\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010&¢\u0006\u0004\b@\u0010AJ\u000f\u0010E\u001a\u00020BH\u0000¢\u0006\u0004\bC\u0010DJ\u001f\u0010K\u001a\u0002012\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020FH\u0000¢\u0006\u0004\bI\u0010JR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010L\u001a\u0004\bM\u0010NR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010S\u001a\u00020R8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR \u0010Y\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020X0W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010LR\u001b\u0010_\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR \u0010d\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000e0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010g\u001a\u00020f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\\\u001a\u0004\bm\u0010nR\u001a\u0010q\u001a\u00020p8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0014\u0010x\u001a\u00020u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR$\u0010~\u001a\u00020`2\u0006\u0010y\u001a\u00020`8F@@X\u0086\u000e¢\u0006\f\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0014\u0010\u0082\u0001\u001a\u00020\u007f8F¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0015\u0010\u0086\u0001\u001a\u00030\u0083\u00018F¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0088\u0001"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/XProcessingEnv;", "", "", "options", "Lhl/a;", "codeGenerator", "Lhl/c;", "logger", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "config", "<init>", "(Ljava/util/Map;Lhl/a;Lhl/c;Landroidx/room/compiler/processing/XProcessingEnvConfig;)V", "qName", "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "findTypeElement", "(Ljava/lang/String;)Landroidx/room/compiler/processing/ksp/KspTypeElement;", "packageName", "", "Landroidx/room/compiler/processing/XTypeElement;", "getTypeElementsFromPackage", "(Ljava/lang/String;)Ljava/util/List;", "Landroidx/room/compiler/processing/XType;", "findType", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XType;", "findGeneratedAnnotation", "()Landroidx/room/compiler/processing/XTypeElement;", "type", "", "types", "Landroidx/room/compiler/processing/ksp/KspType;", "getDeclaredType", "(Landroidx/room/compiler/processing/XTypeElement;[Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspArrayType;", "getArrayType", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/ksp/KspArrayType;", "Lil/s;", "originatingReference", "Lil/p;", "ksType", "wrap", "(Lil/s;Lil/p;)Landroidx/room/compiler/processing/ksp/KspType;", "typeReference", "(Lil/s;)Landroidx/room/compiler/processing/ksp/KspType;", "Lil/r;", "ksTypeParam", "Lil/q;", "ksTypeArgument", "(Lil/r;Lil/q;)Landroidx/room/compiler/processing/ksp/KspType;", "", "allowPrimitives", "(Lil/p;Z)Landroidx/room/compiler/processing/ksp/KspType;", "Lil/c;", "declaration", "wrapClassDeclaration", "(Lil/c;)Landroidx/room/compiler/processing/ksp/KspTypeElement;", "Lil/f;", "file", "Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "wrapKSFile", "(Lil/f;)Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver$WildcardMode;", "wildcardMode", "declarationType", "resolveWildcards", "(Lil/p;Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver$WildcardMode;Lil/p;)Lil/p;", "", "clearCache$room_compiler_processing", "()V", "clearCache", "Landroidx/room/compiler/processing/XExecutableType;", "type1", "type2", "isSameType$room_compiler_processing", "(Landroidx/room/compiler/processing/XExecutableType;Landroidx/room/compiler/processing/XExecutableType;)Z", "isSameType", "Ljava/util/Map;", "getOptions", "()Ljava/util/Map;", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "getConfig", "()Landroidx/room/compiler/processing/XProcessingEnvConfig;", "Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "backend", "Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "getBackend", "()Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "", "Landroidx/room/compiler/processing/ksp/KspFileMemberContainer;", "ksFileMemberContainers", "Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver;", "ksTypeVarianceResolver$delegate", "Lkotlin/Lazy;", "getKsTypeVarianceResolver", "()Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver;", "ksTypeVarianceResolver", "Lhl/d;", "_resolver", "Lhl/d;", "Landroidx/room/compiler/processing/javac/XTypeElementStore;", "typeElementStore", "Landroidx/room/compiler/processing/javac/XTypeElementStore;", "Landroidx/room/compiler/processing/XMessager;", "messager", "Landroidx/room/compiler/processing/XMessager;", "getMessager", "()Landroidx/room/compiler/processing/XMessager;", "Landroidx/room/compiler/processing/ksp/KspArrayType$Factory;", "arrayTypeFactory$delegate", "getArrayTypeFactory", "()Landroidx/room/compiler/processing/ksp/KspArrayType$Factory;", "arrayTypeFactory", "Landroidx/room/compiler/processing/XFiler;", "filer", "Landroidx/room/compiler/processing/XFiler;", "getFiler", "()Landroidx/room/compiler/processing/XFiler;", "", "getJvmVersion", "()I", "jvmVersion", "value", "getResolver", "()Lhl/d;", "setResolver$room_compiler_processing", "(Lhl/d;)V", "resolver", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv$CommonTypes;", "getCommonTypes", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv$CommonTypes;", "commonTypes", "Landroidx/room/compiler/processing/ksp/KspVoidType;", "getVoidType", "()Landroidx/room/compiler/processing/ksp/KspVoidType;", "voidType", "CommonTypes", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspProcessingEnv implements XProcessingEnv {
    private d _resolver;
    private final Lazy arrayTypeFactory$delegate;
    private final XProcessingEnv.Backend backend;
    private final XProcessingEnvConfig config;
    private final XFiler filer;
    private final Map<f, KspFileMemberContainer> ksFileMemberContainers;
    private final Lazy ksTypeVarianceResolver$delegate;
    private final XMessager messager;
    private final Map<String, String> options;
    private final XTypeElementStore<c, KspTypeElement> typeElementStore;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0011\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspProcessingEnv$CommonTypes;", "", "Lhl/d;", "resolver", "<init>", "(Lhl/d;)V", "Lil/p;", "nullableInt$delegate", "Lkotlin/Lazy;", "getNullableInt", "()Lil/p;", "nullableInt", "nullableLong$delegate", "getNullableLong", "nullableLong", "nullableByte$delegate", "getNullableByte", "nullableByte", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CommonTypes {
        private final Lazy nullableByte$delegate;
        private final Lazy nullableInt$delegate;
        private final Lazy nullableLong$delegate;

        public CommonTypes(final d r5) {
            Intrinsics.checkNotNullParameter(r5, "resolver");
            this.nullableInt$delegate = LazyKt.lazy(new KspProcessingEnv$CommonTypes$nullableInt$2(r5));
            this.nullableLong$delegate = LazyKt.lazy(new KspProcessingEnv$CommonTypes$nullableLong$2(r5));
            this.nullableByte$delegate = LazyKt.lazy(new KspProcessingEnv$CommonTypes$nullableByte$2(r5));
        }

        public final p getNullableByte() {
            j0.A(this.nullableByte$delegate.getValue());
            return null;
        }

        public final p getNullableInt() {
            j0.A(this.nullableInt$delegate.getValue());
            return null;
        }

        public final p getNullableLong() {
            j0.A(this.nullableLong$delegate.getValue());
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.room.compiler.processing.ksp.KspProcessingEnv$getTypeElementsFromPackage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000b\u0010\u0002\u001a\u00070\u0000¢\u0006\u0002\b\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/c;", "Lkotlin/internal/NoInfer;", ST.IMPLICIT_ARG_NAME, "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "invoke", "(Lil/c;)Landroidx/room/compiler/processing/ksp/KspTypeElement;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass1 extends Lambda implements Function1<c, KspTypeElement> {
        final /* synthetic */ KspProcessingEnv this$0;

        public AnonymousClass1(KspProcessingEnv r5) {
            this.this$0 = r5;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KspTypeElement invoke2(c r5) {
            Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
            return KspTypeElement.Companion.create(this.this$0, r5);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KspTypeElement invoke(c r5) {
            j0.A(r5);
            return invoke2(null);
        }
    }

    public KspProcessingEnv(Map<String, String> r5, hl.a r10, hl.c r11, XProcessingEnvConfig r12) {
        Intrinsics.checkNotNullParameter(r5, "options");
        Intrinsics.checkNotNullParameter(r10, "codeGenerator");
        Intrinsics.checkNotNullParameter(r11, "logger");
        Intrinsics.checkNotNullParameter(r12, "config");
        this.options = r5;
        this.config = r12;
        this.backend = XProcessingEnv.Backend.KSP;
        this.ksFileMemberContainers = new LinkedHashMap();
        this.ksTypeVarianceResolver$delegate = LazyKt.lazy(new KspProcessingEnv$ksTypeVarianceResolver$2(this));
        this.typeElementStore = new XTypeElementStore(new KspProcessingEnv$typeElementStore$1(this), KspProcessingEnv$typeElementStore$2.INSTANCE, new KspProcessingEnv$typeElementStore$3(this));
        this.messager = new KspMessager(r11);
        this.arrayTypeFactory$delegate = LazyKt.lazy(new KspProcessingEnv$arrayTypeFactory$2(this));
        this.filer = new KspFiler(r10, getMessager());
    }

    private final KspArrayType.Factory getArrayTypeFactory() {
        return (KspArrayType.Factory) this.arrayTypeFactory$delegate.getValue();
    }

    private final KSTypeVarianceResolver getKsTypeVarianceResolver() {
        return (KSTypeVarianceResolver) this.ksTypeVarianceResolver$delegate.getValue();
    }

    private static final XType isSameType$returnType(KspProcessingEnv r5, XExecutableType r10) {
        if ((r10 instanceof XMethodType) == false) goto L6;
        return ((XMethodType) r10).getReturnType();
    L6:
        if ((r10 instanceof XConstructorType) == false) goto L10;
        return r5.getVoidType();
    L10:
        throw new IllegalStateException(("Unexpected XExecutableType: " + r10).toString());
    }

    public final void clearCache$room_compiler_processing() {
        this.typeElementStore.clear$room_compiler_processing();
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XTypeElement findGeneratedAnnotation() {
        KspTypeElement r5 = findTypeElement("javax.annotation.processing.Generated");
        if (r5 == null) goto L6;
        return r5;
    L6:
        return findTypeElement("javax.annotation.Generated");
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XType findType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        String r10 = KspTypeMapper.INSTANCE.swapWithKotlinType(r5);
        getResolver();
        ResolverExtKt.findClass(null, r10);
        return null;
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

    public final CommonTypes getCommonTypes() {
        getResolver();
        return new CommonTypes(null);
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XProcessingEnvConfig getConfig() {
        return this.config;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public /* bridge */ /* synthetic */ XType getDeclaredType(XTypeElement r5, XType[] r10) {
        return getDeclaredType(r5, r10);
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XFiler getFiler() {
        return this.filer;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public int getJvmVersion() {
        return 8;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public XMessager getMessager() {
        return this.messager;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public Map<String, String> getOptions() {
        return this.options;
    }

    public final d getResolver() {
        Intrinsics.checkNotNull(null);
        return null;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public List<XTypeElement> getTypeElementsFromPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        getResolver();
        throw null;
    }

    public final KspVoidType getVoidType() {
        getResolver();
        throw null;
    }

    public final boolean isSameType$room_compiler_processing(XExecutableType r10, XExecutableType r11) {
        Intrinsics.checkNotNullParameter(r10, "type1");
        Intrinsics.checkNotNullParameter(r11, "type2");
        if (Intrinsics.areEqual(r10, r11) == false) goto L7;
        return true;
    L7:
        if (r10.getParameterTypes().size() == r11.getParameterTypes().size()) goto L9;
        return false;
    L9:
        Iterator<Integer> r5 = CollectionsKt.getIndices(r10.getParameterTypes()).iterator();
    L11:
        if (r5.hasNext() == false) goto L16;
        int r12 = ((IntIterator) r5).nextInt();
        if (r10.getParameterTypes().get(r12).isSameType(r11.getParameterTypes().get(r12)) == true) goto L11;
        return false;
    L16:
        return isSameType$returnType(this, r10).isSameType(isSameType$returnType(this, r11));
    }

    public final p resolveWildcards(p r5, KSTypeVarianceResolver.WildcardMode r10, p r11) {
        Intrinsics.checkNotNullParameter(r5, "ksType");
        Intrinsics.checkNotNullParameter(r10, "wildcardMode");
        getKsTypeVarianceResolver().applyTypeVariance(r5, r10, r11);
        return null;
    }

    public final void setResolver$room_compiler_processing(d r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
    }

    public final KspType wrap(s r5, p r10) {
        Intrinsics.checkNotNullParameter(r5, "originatingReference");
        Intrinsics.checkNotNullParameter(r10, "ksType");
        return wrap(r10, !KSTypeExtKt.isTypeParameterReference(r5));
    }

    public final KspTypeElement wrapClassDeclaration(c r5) {
        Intrinsics.checkNotNullParameter(r5, "declaration");
        return (KspTypeElement) this.typeElementStore.get(r5);
    }

    public final KspMemberContainer wrapKSFile(f r5) {
        Intrinsics.checkNotNullParameter(r5, "file");
        Map<f, KspFileMemberContainer> r10 = this.ksFileMemberContainers;
        KspFileMemberContainer r11 = r10.get(r5);
        if (r11 != null) goto L6;
        r11 = new KspFileMemberContainer(this, r5);
        r10.put(r5, r11);
    L6:
        return r11;
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public KspTypeElement findTypeElement(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        return (KspTypeElement) this.typeElementStore.get(r5);
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public KspArrayType getArrayType(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if ((r5 instanceof KspType) == false) goto L7;
        return getArrayTypeFactory().createWithComponentType((KspType) r5);
    L7:
        throw new IllegalStateException("Check failed.");
    }

    @Override // androidx.room.compiler.processing.XProcessingEnv
    public KspType getDeclaredType(XTypeElement r5, XType... r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "types");
        if ((r5 instanceof KspTypeElement) == false) goto L15;
        new ArrayList(r10.length);
        if (r10.length <= 0) goto L12;
        XType r11 = r10[0];
        if ((r11 instanceof KspType) == false) goto L9;
        getResolver();
        ((KspType) r11).getKsType();
        KSTypeReferenceExtKt.createTypeReference(null);
        throw null;
    L9:
        throw new IllegalStateException((r11 + " is not an instance of KspType").toString());
    L12:
        ((KspTypeElement) r5).getDeclaration();
        throw null;
    L15:
        throw new IllegalStateException(("Unexpected type element type: " + r5).toString());
    }

    public final KspType wrap(s r5) {
        Intrinsics.checkNotNullParameter(r5, "typeReference");
        r5.resolve();
        return wrap(r5, null);
    }

    public final KspType wrap(r r5, q r10) {
        Intrinsics.checkNotNullParameter(r5, "ksTypeParam");
        Intrinsics.checkNotNullParameter(r10, "ksTypeArgument");
        s r11 = r10.getType();
        if (r11 == null) goto L9;
        if (r10.getVariance() != Variance.INVARIANT) goto L9;
        r11.resolve();
        return wrap(null, false);
    L9:
        return new KspTypeArgumentType(this, r5, r10, null);
    }

    public final KspType wrap(p r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "ksType");
        r5.getDeclaration();
        r5.getDeclaration();
        throw null;
    }
}
