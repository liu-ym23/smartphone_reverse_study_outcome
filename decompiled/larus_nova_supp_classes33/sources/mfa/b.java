package mfa;

import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.permission.IObricPermissionService$a;
import com.obric.assistant.permission.IObricPermissionServiceImpl;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ IObricPermissionService$a a;

    public /* synthetic */ b(IObricPermissionService$a r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invoke(Object r14, Object r15) {
        IObricPermissionService$a r0 = this.a;
        int r16 = ((Integer) r14).intValue();
        Intent r17 = (Intent) r15;
        int r1 = IObricPermissionServiceImpl.b;
        FLogger r2 = FLogger.a;
        r2.i("IObricPermissionServiceImpl", "miui combine permission resultCode: " + r16 + ", result: " + r17);
        boolean r4 = true;
        if (r16 != (-1)) goto L27;
        if (r17 == null) goto L27;
        String[] r18 = r17.getStringArrayExtra("miui.intent.extra.REQUEST_PERMISSIONS_NAMES");
        int[] r19 = r17.getIntArrayExtra("miui.intent.extra.REQUEST_PERMISSIONS_RESULTS");
        ArrayList r3 = new ArrayList();
        ArrayList r6 = new ArrayList();
        if (r18 == null) goto L19;
        if (r19 == null) goto L19;
        int r5 = Math.min(r18.length, r19.length);
        int r7 = 0;
    L9:
        if (r7 >= r5) goto L21;
        String r8 = r18[r7];
        if (r19[r7] != 0) goto L13;
        boolean r9 = true;
    L14:
        FLogger.a.i("IObricPermissionServiceImpl", "miui combine, permission: " + r8 + ", granted: " + r9);
        Intrinsics.checkNotNull(r8);
        if (r9 == false) goto L17;
        r3.add(r8);
    L18:
        r7 = r7 + 1;
        goto L9
    L17:
        r6.add(r8);
        goto L18
    L13:
        r9 = false;
    L21:
        if (r3.size() > 0) goto L23;
    L25:
        r4 = false;
    L26:
        r0.a(false, r4, r3, r6);
    L29:
        return Unit.INSTANCE;
    L23:
        if (r6.isEmpty() == false) goto L25;
    L19:
        r2.e("IObricPermissionServiceImpl", "miui combine permission missing extras");
    L27:
        r0.a(true, false, new ArrayList(), new ArrayList());
        goto L29
    }
}
