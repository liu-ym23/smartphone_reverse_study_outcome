package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.solver.query.result.QueryResultBinder;
import com.squareup.javapoet.x;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00010BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003JW\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00061"}, d2 = {"Landroidx/room/vo/RawQueryMethod;", "", "element", "Landroidx/room/compiler/processing/XMethodElement;", "name", "", "returnType", "Landroidx/room/compiler/processing/XType;", "inTransaction", "", "observedTableNames", "", "runtimeQueryParam", "Landroidx/room/vo/RawQueryMethod$RuntimeQueryParameter;", "queryResultBinder", "Landroidx/room/solver/query/result/QueryResultBinder;", "(Landroidx/room/compiler/processing/XMethodElement;Ljava/lang/String;Landroidx/room/compiler/processing/XType;ZLjava/util/Set;Landroidx/room/vo/RawQueryMethod$RuntimeQueryParameter;Landroidx/room/solver/query/result/QueryResultBinder;)V", "getElement", "()Landroidx/room/compiler/processing/XMethodElement;", "getInTransaction", "()Z", "getName", "()Ljava/lang/String;", "getObservedTableNames", "()Ljava/util/Set;", "getQueryResultBinder", "()Landroidx/room/solver/query/result/QueryResultBinder;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnsValue", "getReturnsValue", "returnsValue$delegate", "Lkotlin/Lazy;", "getRuntimeQueryParam", "()Landroidx/room/vo/RawQueryMethod$RuntimeQueryParameter;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "RuntimeQueryParameter", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RawQueryMethod {
    private final XMethodElement element;
    private final boolean inTransaction;
    private final String name;
    private final Set<String> observedTableNames;
    private final QueryResultBinder queryResultBinder;
    private final XType returnType;
    private final Lazy returnsValue$delegate;
    private final RuntimeQueryParameter runtimeQueryParam;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f¨\u0006\u001d"}, d2 = {"Landroidx/room/vo/RawQueryMethod$RuntimeQueryParameter;", "", "", "paramName", "Lcom/squareup/javapoet/x;", "type", "<init>", "(Ljava/lang/String;Lcom/squareup/javapoet/x;)V", "", "isString", "()Z", "isSupportQuery", "component1", "()Ljava/lang/String;", "component2", "()Lcom/squareup/javapoet/x;", "copy", "(Ljava/lang/String;Lcom/squareup/javapoet/x;)Landroidx/room/vo/RawQueryMethod$RuntimeQueryParameter;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getParamName", "Lcom/squareup/javapoet/x;", "getType", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RuntimeQueryParameter {
        private final String paramName;
        private final x type;

        public RuntimeQueryParameter(String r5, x r10) {
            Intrinsics.checkNotNullParameter(r5, "paramName");
            Intrinsics.checkNotNullParameter(r10, "type");
            this.paramName = r5;
            this.type = r10;
        }

        public static /* synthetic */ RuntimeQueryParameter copy$default(RuntimeQueryParameter r5, String r10, x r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.paramName;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.type;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.paramName;
        }

        public final x component2() {
            return this.type;
        }

        public final RuntimeQueryParameter copy(String r5, x r10) {
            Intrinsics.checkNotNullParameter(r5, "paramName");
            Intrinsics.checkNotNullParameter(r10, "type");
            return new RuntimeQueryParameter(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RuntimeQueryParameter) == true) goto L8;
            return false;
        L8:
            RuntimeQueryParameter r10 = (RuntimeQueryParameter) r5;
            if (Intrinsics.areEqual(this.paramName, r10.paramName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r10.type) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getParamName() {
            return this.paramName;
        }

        public final x getType() {
            return this.type;
        }

        public int hashCode() {
            int r5 = this.paramName.hashCode() * 31;
            return this.type.hashCode() + r5;
        }

        public final boolean isString() {
            return Intrinsics.areEqual(CommonTypeNames.INSTANCE.getSTRING(), this.type);
        }

        public final boolean isSupportQuery() {
            return Intrinsics.areEqual(SupportDbTypeNames.INSTANCE.getQUERY(), this.type);
        }

        public String toString() {
            return "RuntimeQueryParameter(paramName=" + this.paramName + ", type=" + this.type + ")";
        }
    }

    public RawQueryMethod(XMethodElement r5, String r10, XType r11, boolean r12, Set<String> r13, RuntimeQueryParameter r14, QueryResultBinder r15) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "returnType");
        Intrinsics.checkNotNullParameter(r13, "observedTableNames");
        Intrinsics.checkNotNullParameter(r15, "queryResultBinder");
        this.element = r5;
        this.name = r10;
        this.returnType = r11;
        this.inTransaction = r12;
        this.observedTableNames = r13;
        this.runtimeQueryParam = r14;
        this.queryResultBinder = r15;
        this.returnsValue$delegate = LazyKt.lazy(new RawQueryMethod$returnsValue$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RawQueryMethod copy$default(RawQueryMethod r5, XMethodElement r10, String r11, XType r12, boolean r13, Set r14, RuntimeQueryParameter r15, QueryResultBinder r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r10 = r5.element;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r11 = r5.name;
    L8:
        String r19 = r11;
        if ((r17 & 4) == 0) goto L11;
        r12 = r5.returnType;
    L11:
        XType r20 = r12;
        if ((r17 & 8) == 0) goto L14;
        r13 = r5.inTransaction;
    L14:
        boolean r21 = r13;
        if ((r17 & 16) == 0) goto L17;
        r14 = r5.observedTableNames;
    L17:
        Set r22 = r14;
        if ((r17 & 32) == 0) goto L20;
        r15 = r5.runtimeQueryParam;
    L20:
        RuntimeQueryParameter r23 = r15;
        if ((r17 & 64) == 0) goto L23;
        r16 = r5.queryResultBinder;
    L23:
        XMethodElement r24 = r10;
        return r5.copy(r24, r19, r20, r21, r22, r23, r16);
    }

    public final XMethodElement component1() {
        return this.element;
    }

    public final String component2() {
        return this.name;
    }

    public final XType component3() {
        return this.returnType;
    }

    public final boolean component4() {
        return this.inTransaction;
    }

    public final Set<String> component5() {
        return this.observedTableNames;
    }

    public final RuntimeQueryParameter component6() {
        return this.runtimeQueryParam;
    }

    public final QueryResultBinder component7() {
        return this.queryResultBinder;
    }

    public final RawQueryMethod copy(XMethodElement r10, String r11, XType r12, boolean r13, Set<String> r14, RuntimeQueryParameter r15, QueryResultBinder r16) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "returnType");
        Intrinsics.checkNotNullParameter(r14, "observedTableNames");
        Intrinsics.checkNotNullParameter(r16, "queryResultBinder");
        return new RawQueryMethod(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RawQueryMethod) == true) goto L8;
        return false;
    L8:
        RawQueryMethod r10 = (RawQueryMethod) r5;
        if (Intrinsics.areEqual(this.element, r10.element) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.returnType, r10.returnType) == true) goto L18;
        return false;
    L18:
        if (this.inTransaction == r10.inTransaction) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.observedTableNames, r10.observedTableNames) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.runtimeQueryParam, r10.runtimeQueryParam) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.queryResultBinder, r10.queryResultBinder) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final XMethodElement getElement() {
        return this.element;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final String getName() {
        return this.name;
    }

    public final Set<String> getObservedTableNames() {
        return this.observedTableNames;
    }

    public final QueryResultBinder getQueryResultBinder() {
        return this.queryResultBinder;
    }

    public final XType getReturnType() {
        return this.returnType;
    }

    public final boolean getReturnsValue() {
        return ((Boolean) this.returnsValue$delegate.getValue()).booleanValue();
    }

    public final RuntimeQueryParameter getRuntimeQueryParam() {
        return this.runtimeQueryParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.element.hashCode() * 31, 31, this.name);
        int r10 = (this.returnType.hashCode() + r5) * 31;
        boolean r11 = this.inTransaction;
        ?? r12 = r11;
        if (r11 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = (r10 + r12) * 31;
        int r14 = (this.observedTableNames.hashCode() + r13) * 31;
        RuntimeQueryParameter r15 = this.runtimeQueryParam;
        if (r15 != null) goto L8;
        int r16 = 0;
    L9:
        int r17 = this.queryResultBinder.hashCode();
        return r17 + ((r14 + r16) * 31);
    L8:
        r16 = r15.hashCode();
        goto L9
    }

    public String toString() {
        return "RawQueryMethod(element=" + this.element + ", name=" + this.name + ", returnType=" + this.returnType + ", inTransaction=" + this.inTransaction + ", observedTableNames=" + this.observedTableNames + ", runtimeQueryParam=" + this.runtimeQueryParam + ", queryResultBinder=" + this.queryResultBinder + ")";
    }
}
