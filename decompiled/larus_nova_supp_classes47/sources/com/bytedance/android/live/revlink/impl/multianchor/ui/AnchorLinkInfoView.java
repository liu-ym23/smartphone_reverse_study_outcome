package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.VHeadView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class AnchorLinkInfoView extends LinearLayout {
    public VHeadView a;
    public VHeadView b;
    public VHeadView c;
    public TextView d;

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567601, this, true);
        this.a = r0.findViewById(2131375984);
        this.b = r0.findViewById(2131375985);
        this.c = r0.findViewById(2131375986);
        this.d = (TextView) r0.findViewById(2131390140);
    }

    public VHeadView getIvAnchorAvatar1() {
        return this.a;
    }

    public VHeadView getIvAnchorAvatar2() {
        return this.b;
    }

    public VHeadView getIvAnchorAvatar3() {
        return this.c;
    }

    public TextView getTvAnchorLinkInfo() {
        return this.d;
    }

    public AnchorLinkInfoView(Context r1) {
        super(r1);
        a();
    }

    public AnchorLinkInfoView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public AnchorLinkInfoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
