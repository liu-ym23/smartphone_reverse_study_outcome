package s62;

import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        if (((Integer) r4) == null) goto L22;
        Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
        boolean r0 = true;
        if (r5 != null) goto L9;
    L10:
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 != null) goto L14;
    L16:
        r0 = false;
    L17:
        cc2.e r7 = new cc2.e();
        r7.a(cc2.a.class, cc2.a.b.c, r0);
        DataCenter r1 = this.a.k;
        if (r1 == null) goto L21;
        r1.put("cmd_change_interactivity_component_visibility", r7);
        return;
    L21:
        return;
    L14:
        if (2 != r6.intValue()) goto L16;
    L9:
        if (1 == r5.intValue()) goto L17;
    }
}
