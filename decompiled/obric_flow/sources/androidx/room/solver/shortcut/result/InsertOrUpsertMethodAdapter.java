package androidx.room.solver.shortcut.result;

import ai.j0;
import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.KotlinTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.ShortcutQueryParameter;
import com.lynx.jsbridge.LynxResourceModule;
import com.squareup.javapoet.c;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0005\u0015\u0016\u0017\u0018\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JK\u0010\u0012\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b0\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u001a"}, d2 = {"Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$MethodType;", "methodType", "<init>", "(Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$MethodType;)V", "", "Landroidx/room/vo/ShortcutQueryParameter;", "parameters", "", "", "Lkotlin/Pair;", "Lcom/squareup/javapoet/m;", "adapters", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "createMethodBody", "(Ljava/util/List;Ljava/util/Map;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$MethodType;", "Companion", "InsertMethodType", "MethodType", "ReturnType", "UpsertMethodType", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InsertOrUpsertMethodAdapter {
    public static final Companion Companion = null;
    private static final Lazy<Set<ReturnType>> MULTIPLE_ITEM_SET$delegate = null;
    private final MethodType methodType;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J[\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00180\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, d2 = {"Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$Companion;", "", "()V", "MULTIPLE_ITEM_SET", "", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;", "getMULTIPLE_ITEM_SET", "()Ljava/util/Set;", "MULTIPLE_ITEM_SET$delegate", "Lkotlin/Lazy;", "createInsert", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "context", "Landroidx/room/processor/Context;", "returnType", "Landroidx/room/compiler/processing/XType;", LynxResourceModule.PARAMS_KEY, "", "Landroidx/room/vo/ShortcutQueryParameter;", "createMethod", "methodTypeClass", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$MethodType;", "multiParamSingleReturnError", "", "singleParamMultiReturnError", "createUpsert", "getReturnType", "isReturnValid", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final InsertOrUpsertMethodAdapter createMethod(Context r10, XType r11, List<ShortcutQueryParameter> r12, Function1<? super ReturnType, ? extends MethodType> r13, String r14, String r15) {
            ReturnType r16 = getReturnType(r11);
            DefaultConstructorMarker r17 = null;
            if (r16 != null) goto L5;
        L8:
            return null;
        L5:
            if (isReturnValid(r10, r16, r12, r14, r15) == false) goto L8;
            return new InsertOrUpsertMethodAdapter(r13.invoke(r16), r17);
        }

        private final Set<ReturnType> getMULTIPLE_ITEM_SET() {
            return (Set) InsertOrUpsertMethodAdapter.access$getMULTIPLE_ITEM_SET$delegate$cp().getValue();
        }

        private final ReturnType getReturnType(XType r5) {
            if (XTypeKt.isVoid(r5) == false) goto L6;
            return ReturnType.VOID;
        L6:
            if (XTypeKt.isVoidObject(r5) == false) goto L9;
            return ReturnType.VOID_OBJECT;
        L9:
            if (XTypeKt.isKotlinUnit(r5) == false) goto L12;
            return ReturnType.UNIT;
        L12:
            if (XTypeKt.isArray(r5) == false) goto L21;
            XType r10 = ((XArrayType) r5).getComponentType();
            if (XTypeKt.isLong(r10) == false) goto L34;
            if (Intrinsics.areEqual(r10.getTypeName(), x.f15024i) == false) goto L33;
            return ReturnType.ID_ARRAY;
        L33:
            return ReturnType.ID_ARRAY_BOX;
        L34:
            return null;
        L21:
            if (r5.isList() == false) goto L26;
            if (XTypeKt.isLong((XType) CollectionsKt.first(r5.getTypeArguments())) == false) goto L34;
            return ReturnType.ID_LIST;
        L26:
            if (XTypeKt.isLong(r5) == false) goto L34;
            return ReturnType.SINGLE_ID;
        }

        private final boolean isReturnValid(Context r5, ReturnType r10, List<ShortcutQueryParameter> r11, String r12, String r13) {
            boolean r14 = true;
            if (r11.isEmpty() == true) goto L27;
            if (r11.size() > 1) goto L27;
            if (((ShortcutQueryParameter) CollectionsKt.first(r11)).isMultiple() == false) goto L14;
            boolean r15 = getMULTIPLE_ITEM_SET().contains(r10);
            if (r15 == true) goto L12;
            r5.getLogger().e(r12, new Object[0]);
        L12:
            return r15;
        L14:
            if (r10 != ReturnType.VOID) goto L16;
        L23:
            if (r14 == true) goto L25;
            r5.getLogger().e(r13, new Object[0]);
        L25:
            return r14;
        L16:
            if (r10 == ReturnType.VOID_OBJECT) goto L23;
            if (r10 == ReturnType.UNIT) goto L23;
            if (r10 == ReturnType.SINGLE_ID) goto L23;
            r14 = false;
        L27:
            if (r10 != ReturnType.VOID) goto L29;
            return true;
        L29:
            if (r10 != ReturnType.UNIT) goto L32;
            return true;
        L32:
            return false;
        }

        public final InsertOrUpsertMethodAdapter createInsert(Context r10, XType r11, List<ShortcutQueryParameter> r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "returnType");
            Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
            InsertOrUpsertMethodAdapter$Companion$createInsert$1 r5 = InsertOrUpsertMethodAdapter$Companion$createInsert$1.INSTANCE;
            ProcessorErrors r13 = ProcessorErrors.INSTANCE;
            return createMethod(r10, r11, r12, r5, r13.getINSERT_MULTI_PARAM_SINGLE_RETURN_MISMATCH(), r13.getINSERT_SINGLE_PARAM_MULTI_RETURN_MISMATCH());
        }

        public final InsertOrUpsertMethodAdapter createUpsert(Context r10, XType r11, List<ShortcutQueryParameter> r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "returnType");
            Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
            InsertOrUpsertMethodAdapter$Companion$createUpsert$1 r5 = InsertOrUpsertMethodAdapter$Companion$createUpsert$1.INSTANCE;
            ProcessorErrors r13 = ProcessorErrors.INSTANCE;
            return createMethod(r10, r11, r12, r5, r13.getUPSERT_MULTI_PARAM_SINGLE_RETURN_MISMATCH(), r13.getUPSERT_SINGLE_PARAM_MULTI_RETURN_MISMATCH());
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$InsertMethodType;", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$MethodType;", "returnType", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;", "(Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;)V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InsertMethodType extends MethodType {
        private final String methodName;

        public InsertMethodType(ReturnType r5) {
            Intrinsics.checkNotNullParameter(r5, "returnType");
            super(r5, null);
            this.methodName = j0.C("insert", r5.getMethodSuffix());
        }

        @Override // androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter.MethodType
        public String getMethodName() {
            return this.methodName;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$MethodType;", "", "returnType", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;", "(Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;)V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "getReturnType", "()Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$InsertMethodType;", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$UpsertMethodType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class MethodType {
        private final ReturnType returnType;

        public /* synthetic */ MethodType(ReturnType r5, DefaultConstructorMarker r10) {
            this(r5);
        }

        public abstract String getMethodName();

        public final ReturnType getReturnType() {
            return this.returnType;
        }

        private MethodType(ReturnType r5) {
            this.returnType = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;", "", "", "methodSuffix", "Lcom/squareup/javapoet/x;", "returnTypeName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/squareup/javapoet/x;)V", "Ljava/lang/String;", "getMethodSuffix", "()Ljava/lang/String;", "Lcom/squareup/javapoet/x;", "getReturnTypeName", "()Lcom/squareup/javapoet/x;", "VOID", "VOID_OBJECT", "UNIT", "SINGLE_ID", "ID_ARRAY", "ID_ARRAY_BOX", "ID_LIST", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum ReturnType extends Enum<ReturnType> {
        private static final /* synthetic */ ReturnType[] $VALUES = null;
        public static final ReturnType ID_ARRAY = null;
        public static final ReturnType ID_ARRAY_BOX = null;
        public static final ReturnType ID_LIST = null;
        public static final ReturnType SINGLE_ID = null;
        public static final ReturnType UNIT = null;
        public static final ReturnType VOID = null;
        public static final ReturnType VOID_OBJECT = null;
        private final String methodSuffix;
        private final x returnTypeName;

        private static final /* synthetic */ ReturnType[] $values() {
            return new ReturnType[]{VOID, VOID_OBJECT, UNIT, SINGLE_ID, ID_ARRAY, ID_ARRAY_BOX, ID_LIST};
        }

        static {
            x r5 = x.d;
            VOID = new ReturnType("VOID", 0, "", r5);
            VOID_OBJECT = new ReturnType("VOID_OBJECT", 1, "", r5);
            UNIT = new ReturnType("UNIT", 2, "", KotlinTypeNames.INSTANCE.getUNIT());
            x r10 = x.f15024i;
            SINGLE_ID = new ReturnType("SINGLE_ID", 3, "AndReturnId", r10);
            ID_ARRAY = new ReturnType("ID_ARRAY", 4, "AndReturnIdsArray", new c(r10));
            ID_ARRAY_BOX = new ReturnType("ID_ARRAY_BOX", 5, "AndReturnIdsArrayBox", new c(r10.b()));
            ID_LIST = new ReturnType("ID_LIST", 6, "AndReturnIdsList", v.n(Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(List.class)), new x[]{r10.b()}));
            $VALUES = $values();
        }

        private ReturnType(String r5, int r10, String r11, x r12) {
            super(r5, r10);
            this.methodSuffix = r11;
            this.returnTypeName = r12;
        }

        public static ReturnType valueOf(String r5) {
            return (ReturnType) Enum.valueOf(ReturnType.class, r5);
        }

        public static ReturnType[] values() {
            return (ReturnType[]) $VALUES.clone();
        }

        public final String getMethodSuffix() {
            return this.methodSuffix;
        }

        public final x getReturnTypeName() {
            return this.returnTypeName;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$UpsertMethodType;", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$MethodType;", "returnType", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;", "(Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;)V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UpsertMethodType extends MethodType {
        private final String methodName;

        public UpsertMethodType(ReturnType r5) {
            Intrinsics.checkNotNullParameter(r5, "returnType");
            super(r5, null);
            this.methodName = j0.C("upsert", r5.getMethodSuffix());
        }

        @Override // androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter.MethodType
        public String getMethodName() {
            return this.methodName;
        }
    }

    static {
        Companion = new Companion(null);
        MULTIPLE_ITEM_SET$delegate = LazyKt.lazy(InsertOrUpsertMethodAdapter$Companion$MULTIPLE_ITEM_SET$2.INSTANCE);
    }

    public /* synthetic */ InsertOrUpsertMethodAdapter(MethodType r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public static final /* synthetic */ Lazy access$getMULTIPLE_ITEM_SET$delegate$cp() {
        return MULTIPLE_ITEM_SET$delegate;
    }

    public final void createMethodBody(List<ShortcutQueryParameter> r18, Map<String, ? extends Pair<m, ? extends Object>> r19, m r20, CodeGenScope r21) {
        Map<String, ? extends Pair<m, ? extends Object>> r5 = r19;
        Intrinsics.checkNotNullParameter(r18, "parameters");
        Intrinsics.checkNotNullParameter(r5, "adapters");
        Intrinsics.checkNotNullParameter(r20, "dbField");
        Intrinsics.checkNotNullParameter(r21, "scope");
        g r10 = r21.builder();
        String r11 = this.methodType.getMethodName();
        ReturnType r12 = this.methodType.getReturnType();
        r10.c(j0.j(Javapoet_extKt.getN(), ".beginTransaction()"), new Object[]{r20});
        if (r12 != ReturnType.VOID) goto L5;
    L9:
        boolean r13 = false;
    L10:
        if (r13 == false) goto L12;
        String r14 = r21.getTmpVar("_result");
    L13:
        r10.e("try", new Object[0]);
        Iterator r15 = r18.iterator();
    L15:
        if (r15.hasNext() == false) goto L25;
        ShortcutQueryParameter r16 = (ShortcutQueryParameter) r15.next();
        Pair<m, ? extends Object> r17 = r5.get(r16.getName());
        if (r17 == null) goto L19;
        m r110 = r17.getFirst();
    L21:
        if (r13 == false) goto L23;
        String r111 = Javapoet_extKt.getT();
        String r22 = Javapoet_extKt.getL();
        String r23 = Javapoet_extKt.getN();
        String r24 = Javapoet_extKt.getL();
        String r25 = Javapoet_extKt.getL();
        StringBuilder r26 = a.y(r111, " ", r22, " = ", r23);
        androidx.constraintlayout.motion.widget.a.C(r26, ".", r24, "(", r25);
        r26.append(")");
        r10.c(r26.toString(), new Object[]{r12.getReturnTypeName(), r14, r110, r11, r16.getName()});
    L24:
        r15 = r15;
        r5 = r19;
        r13 = r13;
        goto L15
    L23:
        StringBuilder r27 = a.y(Javapoet_extKt.getN(), ".", Javapoet_extKt.getL(), "(", Javapoet_extKt.getL());
        r27.append(")");
        r10.c(r27.toString(), new Object[]{r110, r11, r16.getName()});
        goto L24
    L19:
        r110 = null;
        goto L21
    L25:
        boolean r112 = r13;
        r10.c(j0.j(Javapoet_extKt.getN(), ".setTransactionSuccessful()"), new Object[]{r20});
        if (r112 == false) goto L29;
        r10.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r14});
    L34:
        r10.h("finally", new Object[0]);
        r10.c(j0.j(Javapoet_extKt.getN(), ".endTransaction()"), new Object[]{r20});
        r10.g();
        return;
    L29:
        if (r12 != ReturnType.VOID_OBJECT) goto L32;
        r10.c("return null", new Object[0]);
        goto L34
    L32:
        if (r12 != ReturnType.UNIT) goto L34;
        r10.c(j0.k("return ", Javapoet_extKt.getT(), ".INSTANCE"), new Object[]{KotlinTypeNames.INSTANCE.getUNIT()});
        goto L34
    L12:
        r14 = null;
        goto L13
    L5:
        if (r12 == ReturnType.VOID_OBJECT) goto L9;
        if (r12 == ReturnType.UNIT) goto L9;
        r13 = true;
        goto L10
    }

    private InsertOrUpsertMethodAdapter(MethodType r5) {
        this.methodType = r5;
    }
}
