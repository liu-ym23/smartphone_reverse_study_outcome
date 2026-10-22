package androidx.room.solver.query.result;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.CodeGenScope;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.ColumnIndexVar;
import androidx.room.vo.Field;
import com.squareup.javapoet.g;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/room/solver/query/result/PojoIndexAdapter;", "Landroidx/room/solver/query/result/IndexAdapter;", "mapping", "Landroidx/room/solver/query/result/PojoRowAdapter$PojoMapping;", "info", "Landroidx/room/verifier/QueryResultInfo;", "query", "Landroidx/room/parser/ParsedQuery;", "(Landroidx/room/solver/query/result/PojoRowAdapter$PojoMapping;Landroidx/room/verifier/QueryResultInfo;Landroidx/room/parser/ParsedQuery;)V", "columnIndexVars", "", "Landroidx/room/vo/ColumnIndexVar;", "getIndexVars", "onCursorReady", "", "cursorVarName", "", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PojoIndexAdapter implements IndexAdapter {
    private List<ColumnIndexVar> columnIndexVars;
    private final QueryResultInfo info;
    private final PojoRowAdapter.PojoMapping mapping;
    private final ParsedQuery query;

    public PojoIndexAdapter(PojoRowAdapter.PojoMapping r5, QueryResultInfo r10, ParsedQuery r11) {
        Intrinsics.checkNotNullParameter(r5, "mapping");
        this.mapping = r5;
        this.info = r10;
        this.query = r11;
    }

    @Override // androidx.room.solver.query.result.IndexAdapter
    public List<ColumnIndexVar> getIndexVars() {
        List<ColumnIndexVar> r5 = this.columnIndexVars;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("columnIndexVars");
        return null;
    L6:
        return r5;
    }

    @Override // androidx.room.solver.query.result.IndexAdapter
    public void onCursorReady(String r18, CodeGenScope r19) {
        CodeGenScope r5 = r19;
        Intrinsics.checkNotNullParameter(r18, "cursorVarName");
        Intrinsics.checkNotNullParameter(r5, "scope");
        List<Field> r10 = this.mapping.getMatchedFields();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L30;
        Field r13 = (Field) r12.next();
        String r14 = r5.getTmpVar("_cursorIndexOf" + String_extKt.capitalize(String_extKt.stripNonJava(r13.getName()), Locale.US));
        if (this.info == null) goto L24;
        ParsedQuery r15 = this.query;
        if (r15 == null) goto L24;
        if (Intrinsics.areEqual(r15.getHasTopStarProjection(), Boolean.FALSE) == false) goto L24;
        Iterator<ColumnInfo> r16 = this.info.getColumns().iterator();
        int r17 = 0;
    L13:
        if (r16.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r16.next().getName(), r13.getColumnName()) == true) goto L19;
        r17 = r17 + 1;
    L19:
        if (r17 == (-1)) goto L21;
        g r20 = r19.builder();
        String r21 = Javapoet_extKt.getT();
        String r110 = Javapoet_extKt.getL();
        String r111 = Javapoet_extKt.getL();
        StringBuilder r22 = a.y("final ", r21, " ", r110, " = ");
        r22.append(r111);
        r20.c(r22.toString(), new Object[]{x.f15023h, r14, Integer.valueOf(r17)});
    L29:
        r11.add(new ColumnIndexVar(r13.getColumnName(), r14));
        r5 = r19;
        r12 = r12;
        goto L4
    L21:
        String r23 = r13.getColumnName();
        String r24 = this.query.getOriginal();
        String r25 = ProcessorErrors.INSTANCE.getISSUE_TRACKER_LINK();
        StringBuilder r26 = new StringBuilder("Result column index not found for field '");
        r26.append(r13);
        r26.append("' with column name '");
        r26.append(r23);
        r26.append("'. Query: ");
        throw new IllegalStateException(a.t(r26, r24, ". Please file a bug at ", r25).toString());
    L18:
        r17 = -1;
    L24:
        if (this.info != null) goto L27;
        String r27 = "getColumnIndex";
    L26:
        String r28 = r27;
        g r112 = r19.builder();
        String r29 = Javapoet_extKt.getT();
        String r30 = Javapoet_extKt.getL();
        String r113 = Javapoet_extKt.getT();
        String r114 = Javapoet_extKt.getL();
        String r31 = Javapoet_extKt.getL();
        String r32 = Javapoet_extKt.getS();
        StringBuilder r33 = a.y("final ", r29, " ", r30, " = ");
        a.C(r33, r113, ".", r114, "(");
        r112.c(a.u(r33, r31, ", ", r32, ")"), new Object[]{x.f15023h, r14, RoomTypeNames.INSTANCE.getCURSOR_UTIL(), r28, r18, r13.getColumnName()});
        goto L29
    L27:
        r27 = "getColumnIndexOrThrow";
        goto L26
    L30:
        this.columnIndexVars = r11;
    }
}
