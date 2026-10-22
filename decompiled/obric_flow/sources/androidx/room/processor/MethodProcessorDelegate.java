package androidx.room.processor;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XMethodTypeKt;
import androidx.room.compiler.processing.XSuspendMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.ext.RoomCoroutinesTypeNames;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.Section;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.solver.transaction.binder.TransactionMethodBinder;
import androidx.room.vo.QueryParameter;
import androidx.room.vo.ShortcutQueryParameter;
import androidx.room.vo.TransactionMethod;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0005H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H&J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010H&J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J1\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#¢\u0006\u0002\b&H&J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H&J\u001e\u0010+\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006-"}, d2 = {"Landroidx/room/processor/MethodProcessorDelegate;", "", "context", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "getContext", "()Landroidx/room/processor/Context;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "extractParams", "", "Landroidx/room/compiler/processing/XVariableElement;", "extractQueryParams", "Landroidx/room/vo/QueryParameter;", "query", "Landroidx/room/parser/ParsedQuery;", "extractReturnType", "findDeleteOrUpdateMethodBinder", "Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;", "returnType", "findInsertMethodBinder", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", LynxResourceModule.PARAMS_KEY, "Landroidx/room/vo/ShortcutQueryParameter;", "findPreparedResultBinder", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "findResultBinder", "Landroidx/room/solver/query/result/QueryResultBinder;", "extrasCreator", "Lkotlin/Function1;", "Landroidx/room/solver/TypeAdapterExtras;", "", "Lkotlin/ExtensionFunctionType;", "findTransactionMethodBinder", "Landroidx/room/solver/transaction/binder/TransactionMethodBinder;", "callType", "Landroidx/room/vo/TransactionMethod$CallType;", "findUpsertMethodBinder", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class MethodProcessorDelegate {
    public static final Companion Companion = null;
    private final XType containing;
    private final Context context;
    private final XMethodElement executableElement;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Landroidx/room/processor/MethodProcessorDelegate$Companion;", "", "()V", "createFor", "Landroidx/room/processor/MethodProcessorDelegate;", "context", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final MethodProcessorDelegate createFor(Context r5, XType r10, XMethodElement r11) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r10, "containing");
            Intrinsics.checkNotNullParameter(r11, "executableElement");
            XMethodType r12 = r11.asMemberOf(r10);
            if (XMethodTypeKt.isSuspendFunction(r12) == false) goto L10;
            if (r5.getProcessingEnv().findTypeElement(RoomCoroutinesTypeNames.INSTANCE.getCOROUTINES_ROOM().toString()) != null) goto L11;
            r5.getLogger().e(ProcessorErrors.INSTANCE.getMISSING_ROOM_COROUTINE_ARTIFACT(), new Object[0]);
        L11:
            return new SuspendMethodProcessorDelegate(r5, r10, r11, (XSuspendMethodType) r12);
        L10:
            return new DefaultMethodProcessorDelegate(r5, r10, r11, r12);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MethodProcessorDelegate(Context r5, XType r10, XMethodElement r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "executableElement");
        this.context = r5;
        this.containing = r10;
        this.executableElement = r11;
    }

    public abstract List<XVariableElement> extractParams();

    public final List<QueryParameter> extractQueryParams(ParsedQuery r11) {
        Intrinsics.checkNotNullParameter(r11, "query");
        List<XVariableElement> r5 = extractParams();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        XVariableElement r13 = (XVariableElement) r12.next();
        Context r14 = this.context;
        XType r15 = this.containing;
        String r16 = r13.getName();
        Iterator<T> r17 = r11.getBindSections().iterator();
    L7:
        if (r17.hasNext() == false) goto L11;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((Section.BindVar) r18).getVarName(), r13.getName()) == false) goto L7;
    L12:
        r10.add(new QueryParameterProcessor(r14, r15, r13, r16, (Section.BindVar) r18).process());
        goto L4
    L11:
        r18 = null;
        goto L12
    L13:
        return r10;
    }

    public abstract XType extractReturnType();

    public abstract DeleteOrUpdateMethodBinder findDeleteOrUpdateMethodBinder(XType r5);

    public abstract InsertOrUpsertMethodBinder findInsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10);

    public abstract PreparedQueryResultBinder findPreparedResultBinder(XType r5, ParsedQuery r10);

    public abstract QueryResultBinder findResultBinder(XType r5, ParsedQuery r10, Function1<? super TypeAdapterExtras, Unit> r11);

    public abstract TransactionMethodBinder findTransactionMethodBinder(TransactionMethod.CallType r5);

    public abstract InsertOrUpsertMethodBinder findUpsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10);

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XMethodElement getExecutableElement() {
        return this.executableElement;
    }
}
