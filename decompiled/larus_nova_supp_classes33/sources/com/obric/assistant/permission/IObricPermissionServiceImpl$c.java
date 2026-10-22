package com.obric.assistant.permission;

import com.larus.platform.api.g1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricPermissionServiceImpl$c implements g1.c {
    public final /* synthetic */ List<String> a;
    public final /* synthetic */ IObricPermissionService$a b;
    public final /* synthetic */ IObricPermissionServiceImpl c;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
    }

    public final void onSettingPageReturn() {
        List<String> r0 = this.a;
        IObricPermissionServiceImpl r1 = this.c;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (r1.checkPermission((String) r4) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        List<String> r5 = this.a;
        IObricPermissionServiceImpl r6 = this.c;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r9 = r8.next();
        if (r6.checkPermission((String) r9) == true) goto L10;
        r7.add(r9);
        goto L10
    L14:
        boolean r10 = true;
        if ((!r2.isEmpty()) == true) goto L17;
    L19:
        r10 = false;
    L20:
        this.b.a(false, r10, r2, r7);
        return;
    L17:
        if (r7.isEmpty() == false) goto L19;
        goto L19
    }

    public IObricPermissionServiceImpl$c(List<String> r1, IObricPermissionService$a r2, IObricPermissionServiceImpl r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
