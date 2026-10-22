package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.Section;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B-\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R4\u0010\u0014\u001a\u001b\u0012\u0017\u0012\u0015\u0012\t\u0012\u00070\u0016¢\u0006\u0002\b\u0017\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00150\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u000f\u0082\u0001\u0002\u001b\u001c¨\u0006\u001d"}, d2 = {"Landroidx/room/vo/QueryMethod;", "", "element", "Landroidx/room/compiler/processing/XMethodElement;", "query", "Landroidx/room/parser/ParsedQuery;", "returnType", "Landroidx/room/compiler/processing/XType;", "parameters", "", "Landroidx/room/vo/QueryParameter;", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/parser/ParsedQuery;Landroidx/room/compiler/processing/XType;Ljava/util/List;)V", "getElement", "()Landroidx/room/compiler/processing/XMethodElement;", "getParameters", "()Ljava/util/List;", "getQuery", "()Landroidx/room/parser/ParsedQuery;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "sectionToParamMapping", "Lkotlin/Pair;", "Landroidx/room/parser/Section$BindVar;", "Lkotlin/internal/NoInfer;", "getSectionToParamMapping", "sectionToParamMapping$delegate", "Lkotlin/Lazy;", "Landroidx/room/vo/ReadQueryMethod;", "Landroidx/room/vo/WriteQueryMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class QueryMethod {
    private final XMethodElement element;
    private final List<QueryParameter> parameters;
    private final ParsedQuery query;
    private final XType returnType;
    private final Lazy sectionToParamMapping$delegate;

    public /* synthetic */ QueryMethod(XMethodElement r5, ParsedQuery r10, XType r11, List r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public final XMethodElement getElement() {
        return this.element;
    }

    public final List<QueryParameter> getParameters() {
        return this.parameters;
    }

    public final ParsedQuery getQuery() {
        return this.query;
    }

    public final XType getReturnType() {
        return this.returnType;
    }

    public final List<Pair<Section.BindVar, QueryParameter>> getSectionToParamMapping() {
        return (List) this.sectionToParamMapping$delegate.getValue();
    }

    private QueryMethod(XMethodElement r5, ParsedQuery r10, XType r11, List<QueryParameter> r12) {
        this.element = r5;
        this.query = r10;
        this.returnType = r11;
        this.parameters = r12;
        this.sectionToParamMapping$delegate = LazyKt.lazy(new QueryMethod$sectionToParamMapping$2(this));
    }
}
