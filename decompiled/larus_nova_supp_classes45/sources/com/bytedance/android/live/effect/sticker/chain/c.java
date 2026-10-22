package com.bytedance.android.live.effect.sticker.chain;

import android.widget.CompoundButton;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Ref.BooleanRef a;

    public c(Ref.BooleanRef r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        this.a.element = r2;
    }
}
