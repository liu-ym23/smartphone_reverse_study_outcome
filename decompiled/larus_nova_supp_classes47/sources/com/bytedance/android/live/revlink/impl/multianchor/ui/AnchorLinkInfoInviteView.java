package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.VHeadView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class AnchorLinkInfoInviteView extends FrameLayout {
    public VHeadView a;
    public View b;
    public View c;
    public VHeadView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567602, this, true);
        this.a = r0.findViewById(2131376019);
        this.b = r0.findViewById(2131362947);
        this.c = r0.findViewById(2131392617);
        this.d = r0.findViewById(2131376272);
        this.e = (TextView) r0.findViewById(2131390845);
        this.f = (TextView) r0.findViewById(2131390995);
        this.g = (TextView) r0.findViewById(2131390841);
        this.h = (TextView) r0.findViewById(2131390517);
    }

    public View getAnimWave() {
        return this.b;
    }

    public VHeadView getIvAvatar() {
        return this.a;
    }

    public VHeadView getIvGender() {
        return this.d;
    }

    public TextView getTvDistance() {
        return this.h;
    }

    public TextView getTvLabelBottom() {
        return this.g;
    }

    public TextView getTvLabelTop() {
        return this.e;
    }

    public TextView getTvNickname() {
        return this.f;
    }

    public View getViewWave() {
        return this.c;
    }

    public AnchorLinkInfoInviteView(Context r1) {
        super(r1);
        a();
    }

    public AnchorLinkInfoInviteView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public AnchorLinkInfoInviteView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
