package androidx.room.solver.prepared.result;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.KotlinTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.parser.QueryType;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "", "Landroidx/room/compiler/processing/XType;", "returnType", "Landroidx/room/parser/QueryType;", "queryType", "<init>", "(Landroidx/room/compiler/processing/XType;Landroidx/room/parser/QueryType;)V", "", "stmtQueryVal", "preparedStmtField", "Lcom/squareup/javapoet/m;", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "executeAndReturn", "(Ljava/lang/String;Ljava/lang/String;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "Landroidx/room/parser/QueryType;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PreparedQueryResultAdapter {
    public static final Companion Companion = null;
    private final QueryType queryType;
    private final XType returnType;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000b"}, d2 = {"Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter$Companion;", "", "()V", "create", "Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "returnType", "Landroidx/room/compiler/processing/XType;", "queryType", "Landroidx/room/parser/QueryType;", "isValidReturnType", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[QueryType.values().length];
                r5[QueryType.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r5[QueryType.UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r5[QueryType.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final boolean isValidReturnType(XType r5, QueryType r10) {
            if (XTypeKt.isVoid(r5) == false) goto L5;
        L19:
            return true;
        L5:
            if (XTypeKt.isVoidObject(r5) == true) goto L19;
            if (XTypeKt.isKotlinUnit(r5) == true) goto L19;
            int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
            if (r11 == 1) goto L18;
            if (r11 == 2) goto L21;
            if (r11 == 3) goto L21;
            return false;
        L21:
            return XTypeKt.isInt(r5);
        L18:
            return XTypeKt.isLong(r5);
        }

        public final PreparedQueryResultAdapter create(XType r5, QueryType r10) {
            Intrinsics.checkNotNullParameter(r5, "returnType");
            Intrinsics.checkNotNullParameter(r10, "queryType");
            if (isValidReturnType(r5, r10) == true) goto L7;
            return null;
        L7:
            return new PreparedQueryResultAdapter(r5, r10);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PreparedQueryResultAdapter(XType r5, QueryType r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, "queryType");
        this.returnType = r5;
        this.queryType = r10;
    }

    public final void executeAndReturn(String r17, String r18, m r19, CodeGenScope r20) {
        Intrinsics.checkNotNullParameter(r17, "stmtQueryVal");
        Intrinsics.checkNotNullParameter(r19, "dbField");
        Intrinsics.checkNotNullParameter(r20, "scope");
        g r5 = r20.builder();
        if (this.queryType != QueryType.INSERT) goto L5;
        String r10 = "executeInsert";
    L6:
        r5.c(j0.j(Javapoet_extKt.getN(), ".beginTransaction()"), new Object[]{r19});
        r5.e("try", new Object[0]);
        if (XTypeKt.isVoid(this.returnType) == false) goto L9;
    L14:
        r5.c(a.q(Javapoet_extKt.getL(), ".", Javapoet_extKt.getL(), "()"), new Object[]{r17, r10});
        r5.c(j0.j(Javapoet_extKt.getN(), ".setTransactionSuccessful()"), new Object[]{r19});
        if (XTypeKt.isVoidObject(this.returnType) == false) goto L18;
        r5.c("return null", new Object[0]);
    L20:
        r5.h("finally", new Object[0]);
        r5.c(j0.j(Javapoet_extKt.getN(), ".endTransaction()"), new Object[]{r19});
        if (r18 == null) goto L23;
        r5.c(a.q(Javapoet_extKt.getN(), ".release(", Javapoet_extKt.getL(), ")"), new Object[]{r18, r17});
    L23:
        r5.g();
        return;
    L18:
        if (XTypeKt.isKotlinUnit(this.returnType) == false) goto L20;
        r5.c(j0.k("return ", Javapoet_extKt.getT(), ".INSTANCE"), new Object[]{KotlinTypeNames.INSTANCE.getUNIT()});
        goto L20
    L9:
        if (XTypeKt.isVoidObject(this.returnType) == true) goto L14;
        if (XTypeKt.isKotlinUnit(this.returnType) == true) goto L14;
        String r11 = r20.getTmpVar("_result");
        String r12 = Javapoet_extKt.getL();
        String r13 = Javapoet_extKt.getL();
        String r14 = Javapoet_extKt.getL();
        String r15 = Javapoet_extKt.getL();
        r5.c(androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("final ", r12, " ", r13, " = "), r14, ".", r15, "()"), new Object[]{this.returnType.getTypeName(), r11, r17, r10});
        r5.c(j0.j(Javapoet_extKt.getN(), ".setTransactionSuccessful()"), new Object[]{r19});
        r5.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r11});
        goto L20
    L5:
        r10 = "executeUpdateDelete";
        goto L6
    }
}
