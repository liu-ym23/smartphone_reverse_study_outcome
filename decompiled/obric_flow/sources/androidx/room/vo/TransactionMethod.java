package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.solver.transaction.binder.TransactionMethodBinder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0018B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/room/vo/TransactionMethod;", "", "element", "Landroidx/room/compiler/processing/XMethodElement;", "returnType", "Landroidx/room/compiler/processing/XType;", "parameterNames", "", "", "callType", "Landroidx/room/vo/TransactionMethod$CallType;", "methodBinder", "Landroidx/room/solver/transaction/binder/TransactionMethodBinder;", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XType;Ljava/util/List;Landroidx/room/vo/TransactionMethod$CallType;Landroidx/room/solver/transaction/binder/TransactionMethodBinder;)V", "getCallType", "()Landroidx/room/vo/TransactionMethod$CallType;", "getElement", "()Landroidx/room/compiler/processing/XMethodElement;", "getMethodBinder", "()Landroidx/room/solver/transaction/binder/TransactionMethodBinder;", "getParameterNames", "()Ljava/util/List;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "CallType", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransactionMethod {
    private final CallType callType;
    private final XMethodElement element;
    private final TransactionMethodBinder methodBinder;
    private final List<String> parameterNames;
    private final XType returnType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/vo/TransactionMethod$CallType;", "", "(Ljava/lang/String;I)V", "CONCRETE", "DEFAULT_JAVA8", "DEFAULT_KOTLIN", "INHERITED_DEFAULT_JAVA8", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum CallType extends Enum<CallType> {
        private static final /* synthetic */ CallType[] $VALUES = null;
        public static final CallType CONCRETE = null;
        public static final CallType DEFAULT_JAVA8 = null;
        public static final CallType DEFAULT_KOTLIN = null;
        public static final CallType INHERITED_DEFAULT_JAVA8 = null;

        private static final /* synthetic */ CallType[] $values() {
            return new CallType[]{CONCRETE, DEFAULT_JAVA8, DEFAULT_KOTLIN, INHERITED_DEFAULT_JAVA8};
        }

        static {
            CONCRETE = new CallType("CONCRETE", 0);
            DEFAULT_JAVA8 = new CallType("DEFAULT_JAVA8", 1);
            DEFAULT_KOTLIN = new CallType("DEFAULT_KOTLIN", 2);
            INHERITED_DEFAULT_JAVA8 = new CallType("INHERITED_DEFAULT_JAVA8", 3);
            $VALUES = $values();
        }

        private CallType(String r5, int r10) {
            super(r5, r10);
        }

        public static CallType valueOf(String r5) {
            return (CallType) Enum.valueOf(CallType.class, r5);
        }

        public static CallType[] values() {
            return (CallType[]) $VALUES.clone();
        }
    }

    public TransactionMethod(XMethodElement r5, XType r10, List<String> r11, CallType r12, TransactionMethodBinder r13) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "returnType");
        Intrinsics.checkNotNullParameter(r11, "parameterNames");
        Intrinsics.checkNotNullParameter(r12, "callType");
        Intrinsics.checkNotNullParameter(r13, "methodBinder");
        this.element = r5;
        this.returnType = r10;
        this.parameterNames = r11;
        this.callType = r12;
        this.methodBinder = r13;
    }

    public final CallType getCallType() {
        return this.callType;
    }

    public final XMethodElement getElement() {
        return this.element;
    }

    public final TransactionMethodBinder getMethodBinder() {
        return this.methodBinder;
    }

    public final List<String> getParameterNames() {
        return this.parameterNames;
    }

    public final XType getReturnType() {
        return this.returnType;
    }
}
