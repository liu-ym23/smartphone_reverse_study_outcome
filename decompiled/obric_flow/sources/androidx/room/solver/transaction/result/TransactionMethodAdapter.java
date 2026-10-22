package androidx.room.solver.transaction.result;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.TransactionMethod;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JQ\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/solver/transaction/result/TransactionMethodAdapter;", "", "", "methodName", "Landroidx/room/vo/TransactionMethod$CallType;", "callType", "<init>", "(Ljava/lang/String;Landroidx/room/vo/TransactionMethod$CallType;)V", "Landroidx/room/compiler/processing/XType;", "returnType", "", "parameterNames", "Lcom/squareup/javapoet/e;", "daoName", "daoImplName", "resultVar", "", "returnStmt", "Landroidx/room/solver/CodeGenScope;", "scope", "", "createDelegateToSuperCode", "(Landroidx/room/compiler/processing/XType;Ljava/util/List;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/e;Ljava/lang/String;ZLandroidx/room/solver/CodeGenScope;)V", "Ljava/lang/String;", "Landroidx/room/vo/TransactionMethod$CallType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransactionMethodAdapter {
    private final TransactionMethod.CallType callType;
    private final String methodName;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[TransactionMethod.CallType.values().length];
            r5[TransactionMethod.CallType.CONCRETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r5[TransactionMethod.CallType.INHERITED_DEFAULT_JAVA8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r5[TransactionMethod.CallType.DEFAULT_JAVA8.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r5[TransactionMethod.CallType.DEFAULT_KOTLIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public TransactionMethodAdapter(String r5, TransactionMethod.CallType r10) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r10, "callType");
        this.methodName = r5;
        this.callType = r10;
    }

    public static /* synthetic */ void createDelegateToSuperCode$default(TransactionMethodAdapter r10, XType r11, List r12, e r13, e r14, String r15, boolean r16, CodeGenScope r17, int r18, Object r19) {
        if ((r18 & 16) == 0) goto L5;
        String r20 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        boolean r21 = false;
    L10:
        r10.createDelegateToSuperCode(r11, r12, r13, r14, r20, r21, r17);
        return;
    L9:
        r21 = r16;
        goto L10
    L5:
        r20 = r15;
        goto L7
    }

    public final void createDelegateToSuperCode(XType r10, List<String> r11, e r12, e r13, String r14, boolean r15, CodeGenScope r16) {
        Intrinsics.checkNotNullParameter(r10, "returnType");
        Intrinsics.checkNotNullParameter(r11, "parameterNames");
        Intrinsics.checkNotNullParameter(r12, "daoName");
        Intrinsics.checkNotNullParameter(r13, "daoImplName");
        Intrinsics.checkNotNullParameter(r16, "scope");
        g r17 = r16.builder();
        ArrayList r5 = new ArrayList();
        StringBuilder r18 = new StringBuilder();
        if (r14 == null) goto L8;
        if (r15 == false) goto L8;
        throw new IllegalStateException("Can't assign to var and return in the same statement.");
    L8:
        if (r14 == null) goto L10;
        r18.append(Javapoet_extKt.getT() + " " + Javapoet_extKt.getL() + " = ");
        r5.add(r10.getTypeName());
        r5.add(r14);
    L12:
        int r19 = WhenMappings.$EnumSwitchMapping$0[this.callType.ordinal()];
        boolean r110 = true;
        if (r19 != 1) goto L15;
    L23:
        r18.append(Javapoet_extKt.getT() + ".super." + Javapoet_extKt.getN() + "(");
        r5.add(r13);
        r5.add(this.methodName);
    L25:
        if (this.callType != TransactionMethod.CallType.DEFAULT_KOTLIN) goto L28;
        r110 = false;
    L28:
        Iterator<T> r20 = r11.iterator();
    L30:
        if (r20.hasNext() == false) goto L36;
        String r21 = (String) r20.next();
        if (r110 == false) goto L34;
        r110 = false;
    L35:
        r18.append(Javapoet_extKt.getL());
        r5.add(r21);
        goto L30
    L34:
        r18.append(", ");
        goto L35
    L36:
        r18.append(")");
        String r22 = r18.toString();
        Object[] r23 = r5.toArray(new Object[0]);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r17.b(r22, Arrays.copyOf(r23, r23.length));
        return;
    L15:
        if (r19 == 2) goto L23;
        if (r19 != 3) goto L19;
        r18.append(Javapoet_extKt.getT() + ".super." + Javapoet_extKt.getN() + "(");
        r5.add(r12);
        r5.add(this.methodName);
        goto L25
    L19:
        if (r19 != 4) goto L25;
        String r24 = Javapoet_extKt.getT();
        String r111 = Javapoet_extKt.getN();
        String r25 = Javapoet_extKt.getN();
        String r26 = Javapoet_extKt.getT();
        StringBuilder r27 = a.y(r24, ".", r111, ".", r25);
        r27.append("(");
        r27.append(r26);
        r27.append(".this");
        r18.append(r27.toString());
        r5.add(r12);
        r5.add("DefaultImpls");
        r5.add(this.methodName);
        r5.add(r13);
        goto L25
    L10:
        if (r15 == false) goto L12;
        r18.append("return ");
        goto L12
    }
}
