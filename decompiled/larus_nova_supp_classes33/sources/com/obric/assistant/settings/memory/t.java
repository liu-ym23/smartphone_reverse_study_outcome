package com.obric.assistant.settings.memory;

import android.os.Looper;
import com.obric.assistant.permission.IObricPermissionService$a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t implements IObricPermissionService$a {
    public final /* synthetic */ ObricPersonalContextSettingFragment a;

    public t(ObricPersonalContextSettingFragment r1) {
        this.a = r1;
    }

    @Override // com.obric.assistant.permission.IObricPermissionService$a
    public final void a(boolean r7, boolean r8, List<String> r9, List<String> r10) {
        Intrinsics.checkNotNullParameter(r9, "grantedList");
        Intrinsics.checkNotNullParameter(r10, "deniedList");
        ObricPersonalContextSettingFragment r11 = this.a;
        int r12 = ObricPersonalContextSettingFragment.l;
        r11.V90().refresh();
        ObricPersonalContextSettingFragment r13 = this.a;
        CoroutineScope r0 = r13.j;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        CoroutineStart r14 = CoroutineStart.UNDISPATCHED;
    L6:
        BuildersKt.launch$default(r0, null, r14, new ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1(r13, true, null), 1, null);
        return;
    L5:
        r14 = CoroutineStart.DEFAULT;
        goto L6
    }
}
