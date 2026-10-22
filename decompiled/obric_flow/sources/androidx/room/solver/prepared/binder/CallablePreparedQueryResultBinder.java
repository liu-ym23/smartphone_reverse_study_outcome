package androidx.room.solver.prepared.binder;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.prepared.result.PreparedQueryResultAdapter;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0001!B^\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012A\u0010\u000e\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u0019\u001a\u00020\f2\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dRR\u0010\u000e\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/room/solver/prepared/binder/CallablePreparedQueryResultBinder;", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "Landroidx/room/compiler/processing/XType;", "returnType", "Lkotlin/Function3;", "Lcom/squareup/javapoet/g;", "Lcom/squareup/javapoet/z;", "Lkotlin/ParameterName;", "name", "callableImpl", "Lcom/squareup/javapoet/m;", "dbField", "", "Lkotlin/ExtensionFunctionType;", "addStmntBlock", "Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/compiler/processing/XType;Lkotlin/jvm/functions/Function3;Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;)V", "Lkotlin/Function1;", "Landroidx/room/solver/CodeGenScope;", "", "prepareQueryStmtBlock", "preparedStmtField", "scope", "executeAndReturn", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "Lkotlin/jvm/functions/Function3;", "getAddStmntBlock", "()Lkotlin/jvm/functions/Function3;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallablePreparedQueryResultBinder extends PreparedQueryResultBinder {
    public static final Companion Companion = null;
    private final Function3<g, z, m, Unit> addStmntBlock;
    private final XType returnType;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062A\u0010\u0012\u001a=\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/solver/prepared/binder/CallablePreparedQueryResultBinder$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/XType;", "returnType", "Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "adapter", "Lkotlin/Function3;", "Lcom/squareup/javapoet/g;", "Lcom/squareup/javapoet/z;", "Lkotlin/ParameterName;", "name", "callableImpl", "Lcom/squareup/javapoet/m;", "dbField", "", "Lkotlin/ExtensionFunctionType;", "addCodeBlock", "Landroidx/room/solver/prepared/binder/CallablePreparedQueryResultBinder;", "createPreparedBinder", "(Landroidx/room/compiler/processing/XType;Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;Lkotlin/jvm/functions/Function3;)Landroidx/room/solver/prepared/binder/CallablePreparedQueryResultBinder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final CallablePreparedQueryResultBinder createPreparedBinder(XType r5, PreparedQueryResultAdapter r10, Function3<? super g, ? super z, ? super m, Unit> r11) {
            Intrinsics.checkNotNullParameter(r5, "returnType");
            Intrinsics.checkNotNullParameter(r11, "addCodeBlock");
            return new CallablePreparedQueryResultBinder(r5, r11, r10, null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ CallablePreparedQueryResultBinder(XType r5, Function3 r10, PreparedQueryResultAdapter r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    @Override // androidx.room.solver.prepared.binder.PreparedQueryResultBinder
    public void executeAndReturn(final Function1<? super CodeGenScope, String> r10, final String r11, final m r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "prepareQueryStmtBlock");
        Intrinsics.checkNotNullParameter(r12, "dbField");
        Intrinsics.checkNotNullParameter(r13, "scope");
        final CodeGenScope r5 = r13.fork();
        z r14 = Javapoet_extKt.CallableTypeSpecBuilder(this.returnType.getTypeName(), new CallablePreparedQueryResultBinder$executeAndReturn$callableImpl$1(this, r10, r5, r11, r12)).e();
        g r15 = r13.builder();
        this.addStmntBlock.invoke(r15, r14, r12);
    }

    public final Function3<g, z, m, Unit> getAddStmntBlock() {
        return this.addStmntBlock;
    }

    public final XType getReturnType() {
        return this.returnType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CallablePreparedQueryResultBinder(XType r5, Function3<? super g, ? super z, ? super m, Unit> r10, PreparedQueryResultAdapter r11) {
        super(r11);
        this.returnType = r5;
        this.addStmntBlock = r10;
    }
}
