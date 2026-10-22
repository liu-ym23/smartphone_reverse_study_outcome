package p59;

import com.larus.common_ui.dialog.u;
import com.larus.permission.api.IPermissionX;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements u {
    public final /* synthetic */ IPermissionX.c a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        IPermissionX.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(false, null);
        return;
    }

    public d(b.C0136b r1) {
        this.a = r1;
    }
}
