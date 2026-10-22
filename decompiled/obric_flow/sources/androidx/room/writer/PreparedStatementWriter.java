package androidx.room.writer;

import ai.j0;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.e;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/writer/PreparedStatementWriter;", "", "Landroidx/room/writer/QueryWriter;", "queryWriter", "<init>", "(Landroidx/room/writer/QueryWriter;)V", "Landroidx/room/writer/TypeWriter;", "typeWriter", "Lcom/squareup/javapoet/m;", "dbParam", "Lcom/squareup/javapoet/z;", "createAnonymous", "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/m;)Lcom/squareup/javapoet/z;", "Landroidx/room/writer/QueryWriter;", "getQueryWriter", "()Landroidx/room/writer/QueryWriter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PreparedStatementWriter {
    private final QueryWriter queryWriter;

    public PreparedStatementWriter(QueryWriter r5) {
        Intrinsics.checkNotNullParameter(r5, "queryWriter");
        this.queryWriter = r5;
    }

    public final z createAnonymous(TypeWriter r10, m r11) {
        Intrinsics.checkNotNullParameter(r10, "typeWriter");
        Intrinsics.checkNotNullParameter(r11, "dbParam");
        CodeGenScope r5 = new CodeGenScope(r10);
        y r12 = z.a(String.valueOf(Javapoet_extKt.getN()), new Object[]{r11});
        r12.f(RoomTypeNames.INSTANCE.getSHARED_SQLITE_STMT());
        s r13 = t.e("createQuery");
        r13.h();
        r13.v(e.o("java.lang", "String", new String[0]));
        r13.l(new Modifier[]{Modifier.PUBLIC});
        String r14 = r5.getTmpVar("_query");
        CodeGenScope r15 = r5.fork();
        this.queryWriter.prepareQuery(r14, r15);
        r13.j(r15.builder().f());
        r13.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r14});
        r12.b(r13.r());
        return r12.e();
    }

    public final QueryWriter getQueryWriter() {
        return this.queryWriter;
    }
}
