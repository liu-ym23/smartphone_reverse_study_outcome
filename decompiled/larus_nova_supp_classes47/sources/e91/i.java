package e91;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends a<AnchorTabLabel> {
    public View c;

    @Override // e91.a
    public final void c() {
        super.c();
        ViewGroup r0 = this.b.getContainer();
        if (r0 == null) goto L20;
        ViewGroup r1 = this.b.getContainer();
        View r2 = null;
        if (r1 == null) goto L9;
        Context r3 = r1.getContext();
        if (r3 == null) goto L9;
        Object r4 = r3.getSystemService("layout_inflater");
    L11:
        if ((r4 instanceof LayoutInflater) == true) goto L13;
        r4 = null;
    L13:
        LayoutInflater r5 = (LayoutInflater) r4;
        if (r5 == null) goto L18;
        View r6 = r5.inflate(2131567566, r0, false);
        if (r6 == null) goto L18;
        r0.addView(r6);
        Unit r7 = Unit.INSTANCE;
        r2 = r6;
    L18:
        this.c = r2;
        return;
    L9:
        r4 = null;
        goto L11
    }

    public i(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(r2);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r5) {
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        String r0 = r5.getContent();
        if (r0 != null) goto L5;
    L10:
        ViewGroup r1 = this.b.getContainer();
        if (r1 == null) goto L19;
        View r2 = this.c;
        if (r2 == null) goto L17;
        TextView r3 = (TextView) r2.findViewById(2131377107);
        if (r3 == null) goto L17;
        r3.setText(r5.getContent());
    L17:
        r1.setVisibility(0);
        return;
    L19:
        return;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
        return;
    L7:
        r4 = false;
        goto L8
    }
}
