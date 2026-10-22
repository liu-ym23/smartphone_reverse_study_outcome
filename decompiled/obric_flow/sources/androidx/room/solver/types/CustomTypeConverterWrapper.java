package androidx.room.solver.types;

import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.String_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.CustomTypeConverter;
import androidx.room.writer.TypeWriter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.i;
import com.squareup.javapoet.m;
import com.squareup.javapoet.t;
import com.squareup.javapoet.x;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/solver/types/CustomTypeConverterWrapper;", "Landroidx/room/solver/types/SingleStatementTypeConverter;", "Landroidx/room/vo/CustomTypeConverter;", "custom", "<init>", "(Landroidx/room/vo/CustomTypeConverter;)V", "Landroidx/room/solver/CodeGenScope;", "scope", "Lcom/squareup/javapoet/t;", "providedTypeConverter", "(Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/t;", "", "inputVarName", "Lcom/squareup/javapoet/i;", "buildStatement", "(Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/i;", "Lcom/squareup/javapoet/m;", "typeConverter", "(Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/m;", "Landroidx/room/vo/CustomTypeConverter;", "getCustom", "()Landroidx/room/vo/CustomTypeConverter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CustomTypeConverterWrapper extends SingleStatementTypeConverter {
    private final CustomTypeConverter custom;

    public CustomTypeConverterWrapper(CustomTypeConverter r5) {
        Intrinsics.checkNotNullParameter(r5, "custom");
        super(r5.getFrom(), r5.getTo());
        this.custom = r5;
    }

    private final t providedTypeConverter(CodeGenScope r5) {
        x r10 = this.custom.getTypeName();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.squareup.javapoet.ClassName");
        final String r11 = String_extKt.decapitalize(((e) r10).f14961y, Locale.US);
        x r12 = this.custom.getTypeName();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.squareup.javapoet.ClassName");
        TypeWriter r13 = r5.getWriter();
        CustomTypeConverterWrapperKt.addRequiredTypeConverter(r13, (e) r12);
        TypeWriter r14 = r5.getWriter();
        final x r15 = this.custom.getTypeName();
        final m r16 = r14.getOrCreateField(new CustomTypeConverterWrapper$providedTypeConverter$converterField$1(r11, this, r15));
        return r5.getWriter().getOrCreateMethod(new AnonymousClass1(r11, this, r16));
    }

    @Override // androidx.room.solver.types.SingleStatementTypeConverter
    public i buildStatement(String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r10, "inputVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        if (this.custom.isEnclosingClassKotlinObject() == false) goto L6;
        StringBuilder r12 = a.y(Javapoet_extKt.getT(), ".INSTANCE.", Javapoet_extKt.getL(), "(", Javapoet_extKt.getL());
        r12.append(")");
        return i.d(r12.toString(), new Object[]{this.custom.getTypeName(), this.custom.getMethodName(), r10});
    L6:
        if (this.custom.isStatic() == false) goto L9;
        StringBuilder r13 = a.y(Javapoet_extKt.getT(), ".", Javapoet_extKt.getL(), "(", Javapoet_extKt.getL());
        r13.append(")");
        return i.d(r13.toString(), new Object[]{this.custom.getTypeName(), this.custom.getMethodName(), r10});
    L9:
        if (this.custom.isProvidedConverter() == false) goto L11;
        StringBuilder r5 = a.y(Javapoet_extKt.getN(), "().", Javapoet_extKt.getL(), "(", Javapoet_extKt.getL());
        r5.append(")");
        return i.d(r5.toString(), new Object[]{providedTypeConverter(r11), this.custom.getMethodName(), r10});
    L11:
        StringBuilder r14 = a.y(Javapoet_extKt.getN(), ".", Javapoet_extKt.getL(), "(", Javapoet_extKt.getL());
        r14.append(")");
        return i.d(r14.toString(), new Object[]{typeConverter(r11), this.custom.getMethodName(), r10});
    }

    public final CustomTypeConverter getCustom() {
        return this.custom;
    }

    public final m typeConverter(CodeGenScope r5) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        x r10 = this.custom.getTypeName();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.squareup.javapoet.ClassName");
        final String r11 = String_extKt.decapitalize(((e) r10).f14961y, Locale.US);
        TypeWriter r12 = r5.getWriter();
        final x r13 = this.custom.getTypeName();
        return r12.getOrCreateField(new C01421(r11, this, r13));
    }
}
