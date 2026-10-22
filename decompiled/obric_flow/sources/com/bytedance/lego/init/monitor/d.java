package com.bytedance.lego.init.monitor;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f6764b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f6765c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6766a;

    static {
        f6764b = new d(0);
        f6765c = new d(1);
    }

    public /* synthetic */ d(int r5) {
        this.f6766a = r5;
    }

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
    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6766a) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        d r10 = f6764b;
        ThreadPoolExecutor r5 = InitScheduler.INSTANCE.getExecutorServiceOrNull$initscheduler_release();
        if (r5 != null) goto L7;
    L9:
        String r11 = InitMonitor.TASKDISPATCHER_INIT;
        new Thread(r10).start();
        Unit r12 = Unit.INSTANCE;
        return;
    L7:
        if (r5.submit(r10) == null) goto L9;
        return;
    L16:
        InitMonitor.access$sendStartUpTimeAsyncInternal(InitMonitor.INSTANCE);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        InitMonitor r13 = InitMonitor.INSTANCE;
        Category r14 = Category.OTHER_EXCEPTION;
        String r15 = e.getClass().getName();
        JSONObject r16 = new JSONObject();
        JSONObject r17 = new JSONObject();
        r17.put("exception_detail", Log.getStackTraceString(e));
        r16.put("exception_detail", r17);
        r13.monitorEvent(r14, r15, r16);
    }
}
