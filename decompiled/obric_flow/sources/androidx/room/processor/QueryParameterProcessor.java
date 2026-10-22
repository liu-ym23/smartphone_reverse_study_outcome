package androidx.room.processor;

import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.parser.Section;
import androidx.room.preconditions.Checks;
import androidx.room.solver.TypeAdapterStore;
import androidx.room.solver.query.parameter.QueryParameterAdapter;
import androidx.room.vo.QueryParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/room/processor/QueryParameterProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "element", "Landroidx/room/compiler/processing/XVariableElement;", "sqlName", "", "bindVarSection", "Landroidx/room/parser/Section$BindVar;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XVariableElement;Ljava/lang/String;Landroidx/room/parser/Section$BindVar;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XVariableElement;", "process", "Landroidx/room/vo/QueryParameter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryParameterProcessor {
    private final Section.BindVar bindVarSection;
    private final XType containing;
    private final Context context;
    private final XVariableElement element;
    private final String sqlName;

    public QueryParameterProcessor(Context r5, XType r10, XVariableElement r11, String r12, Section.BindVar r13) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "sqlName");
        this.containing = r10;
        this.element = r11;
        this.sqlName = r12;
        this.bindVarSection = r13;
        this.context = Context.fork$default(r5, r11, null, 2, null);
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XVariableElement getElement() {
        return this.element;
    }

    public final QueryParameter process() {
        XType r5 = this.element.asMemberOf(this.containing);
        TypeAdapterStore r10 = this.context.getTypeAdapterStore();
        Section.BindVar r11 = this.bindVarSection;
        if (r11 == null) goto L5;
        boolean r12 = r11.isMultiple();
    L6:
        QueryParameterAdapter r13 = r10.findQueryParameterAdapter(r5, r12);
        Checks r14 = this.context.getChecker();
        if (r13 == null) goto L9;
        boolean r15 = true;
    L10:
        XVariableElement r16 = this.element;
        ProcessorErrors r17 = ProcessorErrors.INSTANCE;
        r14.check(r15, r16, r17.getCANNOT_BIND_QUERY_PARAMETER_INTO_STMT(), new Object[0]);
        String r18 = this.element.getName();
        this.context.getChecker().check(true ^ StringsKt.P(r18, "_"), this.element, r17.getQUERY_PARAMETERS_CANNOT_START_WITH_UNDERSCORE(), new Object[0]);
        return new QueryParameter(r18, this.sqlName, r5, r13);
    L9:
        r15 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }
}
