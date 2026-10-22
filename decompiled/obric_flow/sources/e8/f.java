package e8;

import com.bytedance.common.utility.Logger;
import com.lynx.tasm.ui.image.h;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f16790b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f16791c = null;

    static {
        e r5 = d.f16785a;
        f16789a = r5;
        f16790b = r5;
        f16791c = new AtomicInteger();
    }

    public static void b(Runnable r5) {
        f16789a.submit(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [e8.e, java.util.concurrent.AbstractExecutorService] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        ?? r5 = this;
        if (Logger.debug() == false) goto L5;
        r5 = new h(this, 13);
    L5:
        f16789a.submit(r5);
    }
}
