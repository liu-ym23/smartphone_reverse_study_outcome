package com.obric.miniapp.intent;

import android.telephony.TelephonyManager;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CallPhoneOperation$execute$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public CallPhoneOperation$execute$1(Object r8) {
        super(0, r8, a.class, "isSimAbsent", "isSimAbsent()Z", 0);
    }

    public final Boolean invoke() {
        a r0 = (a) ((CallableReference) this).receiver;
        a r1 = a.a;
        r0.getClass();
        Object r2 = AppHost.a.getApplication().getSystemService("phone");
        if ((r2 instanceof TelephonyManager) == false) goto L5;
        TelephonyManager r3 = (TelephonyManager) r2;
    L6:
        if (r3 == null) goto L10;
        boolean r4 = true;
        if (r3.getSimState() != 1) goto L10;
    L12:
        return Boolean.valueOf(r4);
    L10:
        r4 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m232invoke() {
        return invoke();
    }
}
