package e91;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends a<AnchorTabLabel> {
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
        View r6 = r5.inflate(2131567551, r0, false);
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

    public f(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(r2);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r7) {
        Intrinsics.checkNotNullParameter(r7, "tabLabel");
        if (this.a == true) goto L24;
        ViewGroup r0 = this.b.getContainer();
        if (r0 == null) goto L23;
        this.a = true;
        View r1 = this.c;
        TextView r2 = null;
        if (r1 == null) goto L10;
        ImageView r3 = (ImageView) r1.findViewById(2131377101);
    L11:
        View r4 = this.c;
        if (r4 == null) goto L14;
        r2 = (TextView) r4.findViewById(2131377107);
    L14:
        k r5 = r7.getIcon();
        if (r5 == null) goto L17;
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r5, new e(this, r3));
    L17:
        String r8 = r7.getContent();
        if (r8 == null) goto L21;
        if (r2 == null) goto L21;
        r2.setText(r8);
    L21:
        r0.setVisibility(0);
        return;
    L10:
        r3 = null;
        goto L11
    L23:
        return;
    }
}
