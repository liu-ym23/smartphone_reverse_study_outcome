package m8;

import com.bytedance.android.annie.ng.h;
import com.bytedance.android.live.browser.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements h {
    public final /* synthetic */ com.bytedance.android.annie.monitor.lynx.b a;
    public final /* synthetic */ com.bytedance.android.annie.ng.a.C0073a b;

    @Override // com.bytedance.android.annie.ng.h
    public final void onCallback() {
        com.bytedance.android.annie.monitor.lynx.b r0 = this.a;
        if (r0 == null) goto L6;
        com.bytedance.android.annie.ng.a.C0073a r1 = this.b;
        c.a.put(r1.a, r0);
        return;
    }

    public a(i r1, com.bytedance.android.annie.ng.a.C0073a r10) {
        this.a = r1;
        this.b = r10;
    }
}
