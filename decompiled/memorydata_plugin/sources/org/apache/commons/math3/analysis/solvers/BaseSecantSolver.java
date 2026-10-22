package org.apache.commons.math3.analysis.solvers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseSecantSolver extends AbstractUnivariateSolver implements BracketedUnivariateSolver<UnivariateFunction> {
    private AllowedSolution allowed;
    private final Method method;

    /* JADX INFO: renamed from: org.apache.commons.math3.analysis.solvers.BaseSecantSolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method = null;

        static {
            int[] r0 = new int[AllowedSolution.values().length];
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution = r0;
            r0[AllowedSolution.ANY_SIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L23:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.LEFT_SIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.RIGHT_SIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L37:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.BELOW_SIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L25:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.ABOVE_SIDE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r3 = new int[Method.values().length];
            $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method = r3;
            r3[Method.ILLINOIS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method[Method.PEGASUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L35:
            $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method[Method.REGULA_FALSI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    protected static final enum Method extends Enum<Method> {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final Method ILLINOIS = null;
        public static final Method PEGASUS = null;
        public static final Method REGULA_FALSI = null;

        static {
            Method r0 = new Method("REGULA_FALSI", 0);
            REGULA_FALSI = r0;
            Method r1 = new Method("ILLINOIS", 1);
            ILLINOIS = r1;
            Method r3 = new Method("PEGASUS", 2);
            PEGASUS = r3;
            $VALUES = new Method[]{r0, r1, r3};
        }

        private Method(String r1, int r2) {
            super(r1, r2);
        }

        public static Method valueOf(String r2) {
            return (Method) ZeusTransformUtils.preCheckCast(Enum.valueOf(Method.class, r2), Method.class, "com.obric.memorydata.plugin");
        }

        public static Method[] values() {
            return (Method[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Method[].class, "com.obric.memorydata.plugin");
        }
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public final double doSolve() {
        double r1 = getMin();
        double r3 = getMax();
        double r5 = computeObjectiveValue(r1);
        double r7 = computeObjectiveValue(r3);
        double r9 = 0.0d;
        if (r5 != 0.0d) goto L6;
        return r1;
    L6:
        if (r7 != 0.0d) goto L8;
        return r3;
    L8:
        verifyBracketing(r1, r3);
        double r11 = getFunctionValueAccuracy();
        double r13 = getAbsoluteAccuracy();
        double r15 = getRelativeAccuracy();
        boolean r17 = false;
    L9:
        double r20 = r1;
        double r2 = r3 - (((r3 - r1) * r7) / (r7 - r5));
        double r18 = computeObjectiveValue(r2);
        if (r18 == r9) goto L11;
        if ((r7 * r18) >= r9) goto L15;
        r20 = r3;
        r17 = !r17;
        r5 = r7;
    L31:
        if (FastMath.abs(r18) > r11) goto L51;
        int r4 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
        if (r4 == 1) goto L50;
        if (r4 != 2) goto L37;
        if (r17 == false) goto L51;
    L37:
        if (r4 == 3) goto L47;
        if (r4 == 4) goto L45;
        if (r4 != 5) goto L43;
        if (r18 < r9) goto L51;
        return r2;
    L43:
        throw new MathInternalError();
    L45:
        if (r18 > 0.0d) goto L51;
        return r2;
    L47:
        if (r17 == true) goto L51;
        return r2;
    L50:
        return r2;
    L51:
        double r27 = r5;
        if (FastMath.abs(r2 - r20) < FastMath.max(r15 * FastMath.abs(r2), r13)) goto L53;
        r3 = r2;
        r7 = r18;
        r1 = r20;
        r5 = r27;
        r9 = 0.0d;
        goto L9
    L53:
        int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
        if (r0 != 1) goto L56;
        return r2;
    L56:
        if (r0 != 2) goto L58;
        if (r17 == false) goto L79;
        return r2;
    L79:
        return r20;
    L58:
        if (r0 == 3) goto L73;
        if (r0 == 4) goto L69;
        if (r0 != 5) goto L67;
        if (r18 < r9) goto L65;
        return r2;
    L65:
        return r20;
    L67:
        throw new MathInternalError();
    L69:
        if (r18 > 0.0d) goto L72;
        return r2;
    L72:
        return r20;
    L73:
        if (r17 == true) goto L75;
        return r2;
    L75:
        return r20;
    L15:
        int r10 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method[this.method.ordinal()];
        if (r10 != 1) goto L18;
        r5 = r5 * 0.5d;
        goto L31
    L18:
        if (r10 != 2) goto L20;
        r5 = r5 * (r7 / (r7 + r18));
        goto L31
    L20:
        if (r10 != 3) goto L27;
        if (r2 != r3) goto L31;
        throw new ConvergenceException();
    L27:
        throw new MathInternalError();
    L11:
        return r2;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double solve(int r12, UnivariateFunction r13, double r14, double r16, double r18) {
        return solve(r12, (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r13, UnivariateFunction.class, "com.obric.memorydata.plugin"), r14, r16, r18, AllowedSolution.ANY_SIDE);
    }

    public double solve(int r11, UnivariateFunction r12, double r13, double r15, double r17, AllowedSolution r19) {
        UnivariateFunction r3 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r12, UnivariateFunction.class, "com.obric.memorydata.plugin");
        this.allowed = r19;
        return super.solve(r11, r3, r13, r15, r17);
    }
}
