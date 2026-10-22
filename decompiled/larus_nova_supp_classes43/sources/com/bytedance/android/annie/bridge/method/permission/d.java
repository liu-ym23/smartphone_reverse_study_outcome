package com.bytedance.android.annie.bridge.method.permission;

import com.bytedance.android.annie.bridge.method.abs.RequestPermissionResultModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements q9.c {
    public final /* synthetic */ RequestPermissionMethod a;

    public d(RequestPermissionMethod r1) {
        this.a = r1;
    }

    @Override // q9.c
    public final void onResult(boolean r10, Map<String, ? extends PermissionStatus> r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        RequestPermissionMethod r1 = this.a;
        RequestPermissionResultModel r12 = new RequestPermissionResultModel();
        r12.a(RequestPermissionResultModel.Code.Success);
        if (r10 == false) goto L5;
        String r13 = RequestPermissionResultModel.Status.Permitted.toString();
    L15:
        r12.c(r13);
        r12.b("Request Permission Success !");
        r1.finishWithResult(r12);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Iterator r14 = ((LinkedHashMap) r11).values().iterator();
    L7:
        if (r14.hasNext() == false) goto L11;
        if (((PermissionStatus) r14.next()) != PermissionStatus.UNDETERMINED) goto L7;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L14;
        r13 = RequestPermissionResultModel.Status.Undetermined.toString();
        goto L15
    L14:
        r13 = RequestPermissionResultModel.Status.Denied.toString();
        goto L15
    L11:
        r15 = false;
        goto L12
    }
}
