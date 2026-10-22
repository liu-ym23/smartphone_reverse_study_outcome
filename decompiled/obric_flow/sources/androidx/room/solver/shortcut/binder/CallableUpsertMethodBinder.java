package androidx.room.solver.shortcut.binder;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter;
import androidx.room.vo.ShortcutQueryParameter;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.z;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B\\\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012A\u0010\u000e\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012JM\u0010\u001d\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\u00180\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!RR\u0010\u000e\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/room/solver/shortcut/binder/CallableUpsertMethodBinder;", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "Landroidx/room/compiler/processing/XType;", "typeArg", "Lkotlin/Function3;", "Lcom/squareup/javapoet/g;", "Lcom/squareup/javapoet/z;", "Lkotlin/ParameterName;", "name", "callableImpl", "Lcom/squareup/javapoet/m;", "dbField", "", "Lkotlin/ExtensionFunctionType;", "addStmntBlock", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "adapter", "<init>", "(Landroidx/room/compiler/processing/XType;Lkotlin/jvm/functions/Function3;Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;)V", "", "Landroidx/room/vo/ShortcutQueryParameter;", "parameters", "", "", "Lkotlin/Pair;", "", "adapters", "Landroidx/room/solver/CodeGenScope;", "scope", "convertAndReturn", "(Ljava/util/List;Ljava/util/Map;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "getTypeArg", "()Landroidx/room/compiler/processing/XType;", "Lkotlin/jvm/functions/Function3;", "getAddStmntBlock", "()Lkotlin/jvm/functions/Function3;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallableUpsertMethodBinder extends InsertOrUpsertMethodBinder {
    public static final Companion Companion = null;
    private final Function3<g, z, m, Unit> addStmntBlock;
    private final XType typeArg;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062A\u0010\u0012\u001a=\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/solver/shortcut/binder/CallableUpsertMethodBinder$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/XType;", "typeArg", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "adapter", "Lkotlin/Function3;", "Lcom/squareup/javapoet/g;", "Lcom/squareup/javapoet/z;", "Lkotlin/ParameterName;", "name", "callableImpl", "Lcom/squareup/javapoet/m;", "dbField", "", "Lkotlin/ExtensionFunctionType;", "addCodeBlock", "Landroidx/room/solver/shortcut/binder/CallableUpsertMethodBinder;", "createUpsertBinder", "(Landroidx/room/compiler/processing/XType;Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;Lkotlin/jvm/functions/Function3;)Landroidx/room/solver/shortcut/binder/CallableUpsertMethodBinder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final CallableUpsertMethodBinder createUpsertBinder(XType r5, InsertOrUpsertMethodAdapter r10, Function3<? super g, ? super z, ? super m, Unit> r11) {
            Intrinsics.checkNotNullParameter(r5, "typeArg");
            Intrinsics.checkNotNullParameter(r11, "addCodeBlock");
            return new CallableUpsertMethodBinder(r5, r11, r10);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallableUpsertMethodBinder(XType r5, Function3<? super g, ? super z, ? super m, Unit> r10, InsertOrUpsertMethodAdapter r11) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r10, "addStmntBlock");
        super(r11);
        this.typeArg = r5;
        this.addStmntBlock = r10;
    }

    @Override // androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder
    public void convertAndReturn(final List<ShortcutQueryParameter> r10, final Map<String, ? extends Pair<m, ? extends Object>> r11, final m r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "parameters");
        Intrinsics.checkNotNullParameter(r11, "adapters");
        Intrinsics.checkNotNullParameter(r12, "dbField");
        Intrinsics.checkNotNullParameter(r13, "scope");
        final CodeGenScope r14 = r13.fork();
        z r15 = Javapoet_extKt.CallableTypeSpecBuilder(this.typeArg.getTypeName(), new CallableUpsertMethodBinder$convertAndReturn$callableImpl$1(this, r10, r11, r12, r14)).e();
        g r16 = r13.builder();
        this.addStmntBlock.invoke(r16, r15, r12);
    }

    public final Function3<g, z, m, Unit> getAddStmntBlock() {
        return this.addStmntBlock;
    }

    public final XType getTypeArg() {
        return this.typeArg;
    }
}
