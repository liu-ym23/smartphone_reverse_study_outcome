package androidx.room.writer;

import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import com.squareup.javapoet.u;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000bH$¢\u0006\u0004\b\t\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/room/writer/ValidationWriter;", "", "<init>", "()V", "Lcom/squareup/javapoet/u;", "dbParam", "Landroidx/room/solver/CodeGenScope;", "scope", "", "write", "(Lcom/squareup/javapoet/u;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;", "(Lcom/squareup/javapoet/u;Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;)V", "", "statementCount", "()I", "countingScope", "Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;", "CodeBlockWrapper", "CountingCodeGenScope", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ValidationWriter {
    private CountingCodeGenScope countingScope;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\"\u00020\u0001¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/writer/ValidationWriter$CodeBlockWrapper;", "", "Lcom/squareup/javapoet/g;", "builder", "<init>", "(Lcom/squareup/javapoet/g;)V", "", "format", "", "args", "addStatement", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/room/writer/ValidationWriter$CodeBlockWrapper;", "controlFlow", "beginControlFlow", "endControlFlow", "()Landroidx/room/writer/ValidationWriter$CodeBlockWrapper;", "Lcom/squareup/javapoet/g;", "getBuilder", "()Lcom/squareup/javapoet/g;", "", "<set-?>", "statementCount", "I", "getStatementCount", "()I", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CodeBlockWrapper {
        private final g builder;
        private int statementCount;

        public CodeBlockWrapper(g r5) {
            Intrinsics.checkNotNullParameter(r5, "builder");
            this.builder = r5;
        }

        public final CodeBlockWrapper addStatement(String r5, Object... r10) {
            Intrinsics.checkNotNullParameter(r5, "format");
            Intrinsics.checkNotNullParameter(r10, "args");
            this.statementCount++;
            this.builder.c(r5, Arrays.copyOf(r10, r10.length));
            return this;
        }

        public final CodeBlockWrapper beginControlFlow(String r5, Object... r10) {
            Intrinsics.checkNotNullParameter(r5, "controlFlow");
            Intrinsics.checkNotNullParameter(r10, "args");
            this.statementCount++;
            this.builder.e(r5, Arrays.copyOf(r10, r10.length));
            return this;
        }

        public final CodeBlockWrapper endControlFlow() {
            this.builder.g();
            return this;
        }

        public final g getBuilder() {
            return this.builder;
        }

        public final int getStatementCount() {
            return this.statementCount;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;", "", "scope", "Landroidx/room/solver/CodeGenScope;", "(Landroidx/room/solver/CodeGenScope;)V", "builder", "Landroidx/room/writer/ValidationWriter$CodeBlockWrapper;", "getScope", "()Landroidx/room/solver/CodeGenScope;", "getTmpVar", "", "prefix", "statementCount", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CountingCodeGenScope {
        private CodeBlockWrapper builder;
        private final CodeGenScope scope;

        public CountingCodeGenScope(CodeGenScope r5) {
            Intrinsics.checkNotNullParameter(r5, "scope");
            this.scope = r5;
        }

        public final CodeBlockWrapper builder() {
            if (this.builder != null) goto L5;
            this.builder = new CodeBlockWrapper(this.scope.builder());
        L5:
            CodeBlockWrapper r5 = this.builder;
            Intrinsics.checkNotNull(r5);
            return r5;
        }

        public final CodeGenScope getScope() {
            return this.scope;
        }

        public final String getTmpVar(String r5) {
            Intrinsics.checkNotNullParameter(r5, "prefix");
            return this.scope.getTmpVar(r5);
        }

        public final int statementCount() {
            CodeBlockWrapper r5 = this.builder;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return r5.getStatementCount();
        }
    }

    public ValidationWriter() {
    }

    public final int statementCount() {
        CountingCodeGenScope r5 = this.countingScope;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("countingScope");
        r5 = null;
    L6:
        return r5.statementCount();
    }

    public final void write(u r5, CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r5, "dbParam");
        Intrinsics.checkNotNullParameter(r10, "scope");
        CountingCodeGenScope r11 = new CountingCodeGenScope(r10);
        this.countingScope = r11;
        write(r5, r11);
    }

    public abstract void write(u r5, CountingCodeGenScope r10);
}
