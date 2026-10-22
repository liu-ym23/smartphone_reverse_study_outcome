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
public final /* synthetic */ class a implements Function2 {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ IObricPermissionService$a b;

    public /* synthetic */ a(Intent r1, IObricPermissionService$a r2) {
        this.a = r1;
        this.b = r2;
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
        Intent r0 = this.a;
        IObricPermissionService$a r1 = this.b;
        int r16 = ((Integer) r14).intValue();
        Intent r17 = (Intent) r15;
        int r2 = IObricPermissionServiceImpl.b;
        FLogger r3 = FLogger.a;
        r3.i("IObricPermissionServiceImpl", "batchPermissionRequest, intent: " + r0 + ", resultCode: " + r16 + ", result: " + r17);
        boolean r5 = true;
        if (r16 != (-1)) goto L27;
        if (r17 == null) goto L27;
        String[] r18 = r17.getStringArrayExtra("com.android.permissioncontroller.extra.ORIGINAL_PERMISSION_LIST");
        int[] r19 = r17.getIntArrayExtra("com.android.permissioncontroller.extra.ORIGINAL_PERMISSION_RESULTS");
        ArrayList r4 = new ArrayList();
        ArrayList r6 = new ArrayList();
        if (r18 == null) goto L19;
        if (r19 == null) goto L19;
        int r7 = r18.length;
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L21;
        String r9 = r18[r8];
        if (r19[r8] != 0) goto L13;
        boolean r10 = true;
    L14:
        FLogger.a.i("IObricPermissionServiceImpl", "batchPermissionRequest, originalPerms: " + r9 + ", granted: " + r10);
        if (r10 == false) goto L17;
        Intrinsics.checkNotNull(r9);
        r4.add(r9);
    L18:
        r8 = r8 + 1;
        goto L9
    L17:
        Intrinsics.checkNotNull(r9);
        r6.add(r9);
        goto L18
    L13:
        r10 = false;
    L21:
        if (r4.size() > 0) goto L23;
    L25:
        r5 = false;
    L26:
        FLogger.a.i("IObricPermissionServiceImpl", "requestCallBack, allGranted: " + r5 + ", grantedList.size: " + r4.size() + ", deniedList: " + r6.size());
        r1.a(false, r5, r4, r6);
    L29:
        return Unit.INSTANCE;
    L23:
        if (r6.size() != 0) goto L25;
    L19:
        r3.e("IObricPermissionServiceImpl", "batchPermissionRequest failed or canceled");
    L27:
        r3.i("IObricPermissionServiceImpl", "requestCallBack, isCanceledOrFailed, resultCode: " + r16 + ", result: " + r17);
        r1.a(true, false, new ArrayList(), new ArrayList());
        goto L29
    }
}
