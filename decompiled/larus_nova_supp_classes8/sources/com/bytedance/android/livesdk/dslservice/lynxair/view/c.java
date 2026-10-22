package com.bytedance.android.livesdk.dslservice.lynxair.view;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import yt1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;

    public final LynxUI createUI(LynxContext r2) {
        return new LynxAirBehaviorFactory$create$2$createUI$1(this, r2);
    }

    public c(f r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        super(r3);
    }
}
