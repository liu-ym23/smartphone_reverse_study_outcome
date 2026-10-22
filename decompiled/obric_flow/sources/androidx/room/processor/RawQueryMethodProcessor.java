package androidx.room.processor;

import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.ext.Xelement_extKt;
import androidx.room.parser.SqlParser;
import androidx.room.preconditions.Checks;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.vo.RawQueryMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/room/processor/RawQueryMethodProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "findRuntimeQueryParameter", "Landroidx/room/vo/RawQueryMethod$RuntimeQueryParameter;", "extractParams", "", "Landroidx/room/compiler/processing/XVariableElement;", "process", "Landroidx/room/vo/RawQueryMethod;", "processObservedTables", "", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RawQueryMethodProcessor {
    private final XType containing;
    private final Context context;
    private final XMethodElement executableElement;

    public RawQueryMethodProcessor(Context r5, XType r10, XMethodElement r11) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "executableElement");
        this.containing = r10;
        this.executableElement = r11;
        this.context = Context.fork$default(r5, r11, null, 2, null);
    }

    private final RawQueryMethod.RuntimeQueryParameter findRuntimeQueryParameter(List<? extends XVariableElement> r10) {
        if (r10.size() == 1) goto L5;
    L17:
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.getRAW_QUERY_BAD_PARAMS(), new Object[0]);
        return null;
    L5:
        if (this.executableElement.isVarArgs() == true) goto L17;
        XType r5 = ((XVariableElement) CollectionsKt.first(r10)).asMemberOf(this.containing);
        XProcessingEnv r11 = this.context.getProcessingEnv();
        if (r5.getNullability() != XNullability.NULLABLE) goto L9;
        this.context.getLogger().e((XElement) CollectionsKt.first(r10), ProcessorErrors.INSTANCE.parameterCannotBeNullable(((XVariableElement) CollectionsKt.first(r10)).getName()), new Object[0]);
    L9:
        XType r12 = r11.requireType(SupportDbTypeNames.INSTANCE.getQUERY());
        if (r12.isAssignableFrom(r5) == false) goto L14;
        return new RawQueryMethod.RuntimeQueryParameter(r10.get(0).getName(), r12.getTypeName());
    L14:
        if (r11.requireType("java.lang.String").isAssignableFrom(r5) == false) goto L17;
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.getRAW_QUERY_STRING_PARAMETER_REMOVED(), new Object[0]);
        return null;
    }

    private final Set<String> processObservedTables() {
        XAnnotationBox r5 = this.executableElement.getAnnotation(Reflection.getOrCreateKotlinClass(RawQuery.class));
        if (r5 == null) goto L29;
        List<XType> r10 = r5.getAsTypeList("observedEntities");
        if (r10 == null) goto L29;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        XTypeElement r13 = ((XType) r12.next()).getTypeElement();
        if (r13 != null) goto L12;
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.getNOT_ENTITY_OR_VIEW(), new Object[0]);
    L12:
        if (r13 == null) goto L8;
        r11.add(r13);
        goto L8
    L14:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L16:
        if (r15.hasNext() == false) goto L25;
        XTypeElement r16 = (XTypeElement) r15.next();
        if (Xelement_extKt.isEntityElement(r16) == false) goto L20;
        List<String> r17 = CollectionsKt.arrayListOf(new String[]{EntityProcessorKt.EntityProcessor$default(this.context, r16, null, 4, null).process().getTableName()});
    L24:
        CollectionsKt.a(r14, r17);
        goto L16
    L20:
        List<String> r18 = PojoProcessor.Companion.createFor$default(PojoProcessor.Companion, this.context, r16, FieldProcessor.BindingScope.READ_FROM_CURSOR, null, null, 16, null).process().accessedTableNames();
        if (r18.isEmpty() == false) goto L23;
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.rawQueryBadEntity(r16.getType().getTypeName()), new Object[0]);
    L23:
        r17 = r18;
        goto L24
    L25:
        Set<String> r19 = CollectionsKt.toSet(r14);
        if (r19 == null) goto L29;
        return r19;
    L29:
        return SetsKt.emptySet();
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XMethodElement getExecutableElement() {
        return this.executableElement;
    }

    public final RawQueryMethod process() {
        final MethodProcessorDelegate r5 = MethodProcessorDelegate.Companion.createFor(this.context, this.containing, this.executableElement);
        XType r10 = r5.extractReturnType();
        Checks r11 = this.context.getChecker();
        boolean r12 = this.executableElement.hasAnnotation(Reflection.getOrCreateKotlinClass(RawQuery.class));
        XMethodElement r13 = this.executableElement;
        ProcessorErrors r14 = ProcessorErrors.INSTANCE;
        r11.check(r12, r13, r14.getMISSING_RAWQUERY_ANNOTATION(), new Object[0]);
        this.context.getChecker().notUnbound(r10.getTypeName(), this.executableElement, r14.getCANNOT_USE_UNBOUND_GENERICS_IN_QUERY_METHODS(), new Object[0]);
        this.context.getChecker().check(!MethodProcessorDelegateKt.isSuspendAndReturnsDeferredType(r5), this.executableElement, r14.suspendReturnsDeferredType(r10.getRawType().getTypeName().toString()), new Object[0]);
        Set<String> r15 = processObservedTables();
        QueryResultBinder r16 = r5.findResultBinder(r10, SqlParser.Companion.rawQueryForTables(r15), new RawQueryMethodProcessor$process$resultBinder$1(r5, this));
        RawQueryMethod.RuntimeQueryParameter r17 = findRuntimeQueryParameter(r5.extractParams());
        boolean r18 = this.executableElement.hasAnnotation(Reflection.getOrCreateKotlinClass(Transaction.class));
        XMethodElement r19 = this.executableElement;
        RawQueryMethod r20 = new RawQueryMethod(r19, r19.getJvmName(), r10, r18, r15, r17, r16);
        this.context.getChecker().check(r20.getReturnsValue(), this.executableElement, r14.getRAW_QUERY_BAD_RETURN_TYPE(), new Object[0]);
        return r20;
    }
}
