package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.widget.CompoundButton;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$1 b;

    public m(TextView r1, LiveMgMountContextService$showStarAtlasAgreementDialog$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        if (r2 == false) goto L4;
        this.a.setTextColor(-1);
        this.a.setBackground(s1.m(2131249531));
        this.b.invoke("tick");
        return;
    L4:
        this.a.setTextColor(ColorProtector.parseColor("#80FFFFFF"));
        this.a.setBackground(s1.m(2131249532));
        this.b.invoke("untick");
    }
}
