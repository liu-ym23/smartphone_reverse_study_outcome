package androidx.room.solver;

import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/solver/KotlinDefaultMethodDelegateBinder;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "daoName", "daoImplName", "", "methodName", "Landroidx/room/compiler/processing/XType;", "returnType", "", "parameterNames", "Landroidx/room/solver/CodeGenScope;", "scope", "", "executeAndReturn", "(Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/e;Ljava/lang/String;Landroidx/room/compiler/processing/XType;Ljava/util/List;Landroidx/room/solver/CodeGenScope;)V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinDefaultMethodDelegateBinder {
    public static final KotlinDefaultMethodDelegateBinder INSTANCE = null;

    static {
        INSTANCE = new KotlinDefaultMethodDelegateBinder();
    }

    private KotlinDefaultMethodDelegateBinder() {
    }

    public final void executeAndReturn(e r10, e r11, String r12, XType r13, List<String> r14, CodeGenScope r15) {
        Intrinsics.checkNotNullParameter(r10, "daoName");
        Intrinsics.checkNotNullParameter(r11, "daoImplName");
        Intrinsics.checkNotNullParameter(r12, "methodName");
        Intrinsics.checkNotNullParameter(r13, "returnType");
        Intrinsics.checkNotNullParameter(r14, "parameterNames");
        Intrinsics.checkNotNullParameter(r15, "scope");
        g r5 = r15.builder();
        ArrayList r16 = new ArrayList();
        StringBuilder r17 = new StringBuilder();
        if (XTypeKt.isVoid(r13) == true) goto L5;
        r17.append("return ");
    L5:
        String r18 = Javapoet_extKt.getT();
        String r19 = Javapoet_extKt.getN();
        String r20 = Javapoet_extKt.getN();
        String r21 = Javapoet_extKt.getT();
        StringBuilder r22 = a.y(r18, ".", r19, ".", r20);
        r22.append("(");
        r22.append(r21);
        r22.append(".this");
        r17.append(r22.toString());
        r16.add(r10);
        r16.add("DefaultImpls");
        r16.add(r12);
        r16.add(r11);
        Iterator<T> r23 = r14.iterator();
    L7:
        if (r23.hasNext() == false) goto L9;
        String r24 = (String) r23.next();
        r17.append(", ");
        r17.append(Javapoet_extKt.getL());
        r16.add(r24);
        goto L7
    L9:
        r17.append(")");
        String r25 = r17.toString();
        Object[] r26 = r16.toArray(new Object[0]);
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r5.c(r25, Arrays.copyOf(r26, r26.length));
    }
}
