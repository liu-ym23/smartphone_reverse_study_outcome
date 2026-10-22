package androidx.room.processor;

import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.solver.transaction.binder.InstantTransactionMethodBinder;
import androidx.room.solver.transaction.binder.TransactionMethodBinder;
import androidx.room.solver.transaction.result.TransactionMethodAdapter;
import androidx.room.vo.ShortcutQueryParameter;
import androidx.room.vo.TransactionMethod;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J1\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u001e\u0010'\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006("}, d2 = {"Landroidx/room/processor/DefaultMethodProcessorDelegate;", "Landroidx/room/processor/MethodProcessorDelegate;", "context", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "executableType", "Landroidx/room/compiler/processing/XMethodType;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XMethodType;)V", "getExecutableType", "()Landroidx/room/compiler/processing/XMethodType;", "extractParams", "", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "extractReturnType", "findDeleteOrUpdateMethodBinder", "Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;", "returnType", "findInsertMethodBinder", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", LynxResourceModule.PARAMS_KEY, "Landroidx/room/vo/ShortcutQueryParameter;", "findPreparedResultBinder", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "findResultBinder", "Landroidx/room/solver/query/result/QueryResultBinder;", "extrasCreator", "Lkotlin/Function1;", "Landroidx/room/solver/TypeAdapterExtras;", "", "Lkotlin/ExtensionFunctionType;", "findTransactionMethodBinder", "Landroidx/room/solver/transaction/binder/InstantTransactionMethodBinder;", "callType", "Landroidx/room/vo/TransactionMethod$CallType;", "findUpsertMethodBinder", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultMethodProcessorDelegate extends MethodProcessorDelegate {
    private final XMethodType executableType;

    public DefaultMethodProcessorDelegate(Context r5, XType r10, XMethodElement r11, XMethodType r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "executableElement");
        Intrinsics.checkNotNullParameter(r12, "executableType");
        super(r5, r10, r11);
        this.executableType = r12;
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public List<XExecutableParameterElement> extractParams() {
        return getExecutableElement().getParameters();
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public XType extractReturnType() {
        return this.executableType.getReturnType();
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public DeleteOrUpdateMethodBinder findDeleteOrUpdateMethodBinder(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        return getContext().getTypeAdapterStore().findDeleteOrUpdateMethodBinder(r5);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public InsertOrUpsertMethodBinder findInsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return getContext().getTypeAdapterStore().findInsertMethodBinder(r5, r10);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public PreparedQueryResultBinder findPreparedResultBinder(XType r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, "query");
        return getContext().getTypeAdapterStore().findPreparedQueryResultBinder(r5, r10);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public QueryResultBinder findResultBinder(XType r5, ParsedQuery r10, Function1<? super TypeAdapterExtras, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extrasCreator");
        return getContext().getTypeAdapterStore().findQueryResultBinder(r5, r10, r11);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public /* bridge */ /* synthetic */ TransactionMethodBinder findTransactionMethodBinder(TransactionMethod.CallType r5) {
        return findTransactionMethodBinder(r5);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public InsertOrUpsertMethodBinder findUpsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return getContext().getTypeAdapterStore().findUpsertMethodBinder(r5, r10);
    }

    public final XMethodType getExecutableType() {
        return this.executableType;
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public InstantTransactionMethodBinder findTransactionMethodBinder(TransactionMethod.CallType r5) {
        Intrinsics.checkNotNullParameter(r5, "callType");
        return new InstantTransactionMethodBinder(new TransactionMethodAdapter(getExecutableElement().getJvmName(), r5));
    }
}
