package androidx.room.processor;

import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XSuspendMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.parser.ParsedQuery;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.prepared.binder.CallablePreparedQueryResultBinder;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import androidx.room.solver.query.result.CoroutineResultBinder;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.shortcut.binder.CallableDeleteOrUpdateMethodBinder;
import androidx.room.solver.shortcut.binder.CallableInsertMethodBinder;
import androidx.room.solver.shortcut.binder.CallableUpsertMethodBinder;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.solver.transaction.binder.CoroutineTransactionMethodBinder;
import androidx.room.solver.transaction.binder.TransactionMethodBinder;
import androidx.room.solver.transaction.result.TransactionMethodAdapter;
import androidx.room.vo.ShortcutQueryParameter;
import androidx.room.vo.TransactionMethod;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J1\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u001e\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014H\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006/"}, d2 = {"Landroidx/room/processor/SuspendMethodProcessorDelegate;", "Landroidx/room/processor/MethodProcessorDelegate;", "context", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "executableType", "Landroidx/room/compiler/processing/XSuspendMethodType;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XSuspendMethodType;)V", "continuationParam", "Landroidx/room/compiler/processing/XVariableElement;", "getContinuationParam", "()Landroidx/room/compiler/processing/XVariableElement;", "continuationParam$delegate", "Lkotlin/Lazy;", "getExecutableType", "()Landroidx/room/compiler/processing/XSuspendMethodType;", "extractParams", "", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "extractReturnType", "findDeleteOrUpdateMethodBinder", "Landroidx/room/solver/shortcut/binder/CallableDeleteOrUpdateMethodBinder;", "returnType", "findInsertMethodBinder", "Landroidx/room/solver/shortcut/binder/CallableInsertMethodBinder;", LynxResourceModule.PARAMS_KEY, "Landroidx/room/vo/ShortcutQueryParameter;", "findPreparedResultBinder", "Landroidx/room/solver/prepared/binder/CallablePreparedQueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "findResultBinder", "Landroidx/room/solver/query/result/CoroutineResultBinder;", "extrasCreator", "Lkotlin/Function1;", "Landroidx/room/solver/TypeAdapterExtras;", "", "Lkotlin/ExtensionFunctionType;", "findTransactionMethodBinder", "Landroidx/room/solver/transaction/binder/CoroutineTransactionMethodBinder;", "callType", "Landroidx/room/vo/TransactionMethod$CallType;", "findUpsertMethodBinder", "Landroidx/room/solver/shortcut/binder/CallableUpsertMethodBinder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SuspendMethodProcessorDelegate extends MethodProcessorDelegate {
    private final Lazy continuationParam$delegate;
    private final XSuspendMethodType executableType;

    public SuspendMethodProcessorDelegate(final Context r5, XType r10, final XMethodElement r11, XSuspendMethodType r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "executableElement");
        Intrinsics.checkNotNullParameter(r12, "executableType");
        super(r5, r10, r11);
        this.executableType = r12;
        this.continuationParam$delegate = LazyKt.lazy(new SuspendMethodProcessorDelegate$continuationParam$2(r5, r11));
    }

    public static final /* synthetic */ XVariableElement access$getContinuationParam(SuspendMethodProcessorDelegate r5) {
        return r5.getContinuationParam();
    }

    private final XVariableElement getContinuationParam() {
        return (XVariableElement) this.continuationParam$delegate.getValue();
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public List<XExecutableParameterElement> extractParams() {
        List<XExecutableParameterElement> r5 = getExecutableElement().getParameters();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (Intrinsics.areEqual((XExecutableParameterElement) r12, getContinuationParam()) == true) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public XType extractReturnType() {
        return this.executableType.getSuspendFunctionReturnType();
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public /* bridge */ /* synthetic */ DeleteOrUpdateMethodBinder findDeleteOrUpdateMethodBinder(XType r5) {
        return findDeleteOrUpdateMethodBinder(r5);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public /* bridge */ /* synthetic */ InsertOrUpsertMethodBinder findInsertMethodBinder(XType r5, List r10) {
        return findInsertMethodBinder(r5, r10);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public /* bridge */ /* synthetic */ PreparedQueryResultBinder findPreparedResultBinder(XType r5, ParsedQuery r10) {
        return findPreparedResultBinder(r5, r10);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public /* bridge */ /* synthetic */ QueryResultBinder findResultBinder(XType r5, ParsedQuery r10, Function1 r11) {
        return findResultBinder(r5, r10, r11);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public /* bridge */ /* synthetic */ TransactionMethodBinder findTransactionMethodBinder(TransactionMethod.CallType r5) {
        return findTransactionMethodBinder(r5);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public /* bridge */ /* synthetic */ InsertOrUpsertMethodBinder findUpsertMethodBinder(XType r5, List r10) {
        return findUpsertMethodBinder(r5, r10);
    }

    public final XSuspendMethodType getExecutableType() {
        return this.executableType;
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public CallableDeleteOrUpdateMethodBinder findDeleteOrUpdateMethodBinder(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        return CallableDeleteOrUpdateMethodBinder.Companion.createDeleteOrUpdateBinder(r5, getContext().getTypeAdapterStore().findDeleteOrUpdateAdapter(r5), new AnonymousClass1(this));
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public CallableInsertMethodBinder findInsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return CallableInsertMethodBinder.Companion.createInsertBinder(r5, getContext().getTypeAdapterStore().findInsertAdapter(r5, r10), new C01371(this));
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public CallablePreparedQueryResultBinder findPreparedResultBinder(XType r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, "query");
        return CallablePreparedQueryResultBinder.Companion.createPreparedBinder(r5, getContext().getTypeAdapterStore().findPreparedQueryResultAdapter(r5, r10), new C01381(this));
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public CoroutineResultBinder findResultBinder(XType r5, ParsedQuery r10, Function1<? super TypeAdapterExtras, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extrasCreator");
        QueryResultAdapter r12 = getContext().getTypeAdapterStore().findQueryResultAdapter(r5, r10, r11);
        return new CoroutineResultBinder(r5, getContinuationParam().getName(), r12);
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public CoroutineTransactionMethodBinder findTransactionMethodBinder(TransactionMethod.CallType r5) {
        Intrinsics.checkNotNullParameter(r5, "callType");
        TransactionMethodAdapter r10 = new TransactionMethodAdapter(getExecutableElement().getJvmName(), r5);
        String r11 = getContinuationParam().getName();
        if (getContext().getProcessingEnv().getJvmVersion() < 8) goto L5;
        boolean r12 = true;
    L7:
        return new CoroutineTransactionMethodBinder(r10, r11, r12);
    L5:
        r12 = false;
        goto L7
    }

    @Override // androidx.room.processor.MethodProcessorDelegate
    public CallableUpsertMethodBinder findUpsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return CallableUpsertMethodBinder.Companion.createUpsertBinder(r5, getContext().getTypeAdapterStore().findUpsertAdapter(r5, r10), new C01391(this));
    }
}
