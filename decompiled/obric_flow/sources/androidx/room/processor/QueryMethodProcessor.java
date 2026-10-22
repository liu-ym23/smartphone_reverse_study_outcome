package androidx.room.processor;

import androidx.room.Query;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.log.RLog;
import androidx.room.parser.ParsedQuery;
import androidx.room.preconditions.Checks;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.verifier.DatabaseVerifier;
import androidx.room.vo.QueryMethod;
import androidx.room.vo.ReadQueryMethod;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/room/processor/QueryMethodProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "dbVerifier", "Landroidx/room/verifier/DatabaseVerifier;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/verifier/DatabaseVerifier;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getDbVerifier", "()Landroidx/room/verifier/DatabaseVerifier;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "process", "Landroidx/room/vo/QueryMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryMethodProcessor {
    private final XType containing;
    private final Context context;
    private final DatabaseVerifier dbVerifier;
    private final XMethodElement executableElement;

    public QueryMethodProcessor(Context r5, XType r10, XMethodElement r11, DatabaseVerifier r12) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "executableElement");
        this.containing = r10;
        this.executableElement = r11;
        this.dbVerifier = r12;
        this.context = Context.fork$default(r5, r11, null, 2, null);
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DatabaseVerifier getDbVerifier() {
        return this.dbVerifier;
    }

    public final XMethodElement getExecutableElement() {
        return this.executableElement;
    }

    public final QueryMethod process() {
        XAnnotationBox r5 = this.executableElement.getAnnotation(Reflection.getOrCreateKotlinClass(Query.class));
        if (r5 == null) goto L5;
        final Query r10 = (Query) r5.getValue();
    L6:
        Checks r11 = this.context.getChecker();
        if (r10 == null) goto L9;
        boolean r12 = true;
    L10:
        r11.check(r12, this.executableElement, ProcessorErrors.INSTANCE.getMISSING_QUERY_ANNOTATION(), new Object[0]);
        Pair r13 = this.context.collectLogs(new AnonymousClass1(this, r10));
        QueryMethod r14 = (QueryMethod) r13.component1();
        RLog.CollectingMessager r15 = (RLog.CollectingMessager) r13.component2();
        if ((r14 instanceof ReadQueryMethod) == false) goto L21;
        ReadQueryMethod r16 = (ReadQueryMethod) r14;
        QueryResultAdapter r17 = r16.getQueryResultBinder().getAdapter();
        ParsedQuery r18 = r14.getQuery();
        if (r17 == null) goto L16;
        ParsedQuery r19 = this.context.getQueryRewriter().rewrite(r18, r17);
        if (r19 == null) goto L16;
    L17:
        QueryMethod r20 = r16;
        if (Intrinsics.areEqual(r19, r18) == true) goto L23;
        return new InternalQueryProcessor(this.context, this.executableElement, this.containing, this.dbVerifier).processQuery(r19.getOriginal());
    L23:
        if (Intrinsics.areEqual(r20, r14) == false) goto L25;
        RLog.CollectingMessager.writeTo$default(r15, this.context, null, 2, null);
    L25:
        return r20;
    L16:
        r19 = r18;
        goto L17
    L21:
        r20 = r14;
        goto L23
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public /* synthetic */ QueryMethodProcessor(Context r5, XType r10, XMethodElement r11, DatabaseVerifier r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        this(r5, r10, r11, r12);
    }
}
