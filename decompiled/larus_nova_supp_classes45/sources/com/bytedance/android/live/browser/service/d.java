package com.bytedance.android.live.browser.service;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements w8.d {
    public final com.bytedance.android.live.browser.utils.i a;
    public final /* synthetic */ AnnieAbilityProviderImpl b;
    public final /* synthetic */ Activity c;
    public final /* synthetic */ Ref.ObjectRef d;

    public final void a(boolean r4) {
        Activity r0 = this.c;
        if (r0 == null) goto L8;
        if (r4 == false) goto L6;
        this.b.getClass();
        int r5 = th7.b.a;
        com.bytedance.android.live.browser.utils.k.b.put(this.c, (com.bytedance.android.live.browser.utils.i) this.d.element);
        com.bytedance.android.live.browser.utils.k.a(r0);
        return;
    L6:
        this.b.getClass();
        int r6 = th7.b.a;
        com.bytedance.android.live.browser.utils.k.b.put(this.c, null);
        com.bytedance.android.live.browser.utils.k.b(r0);
        return;
    }

    public d(AnnieAbilityProviderImpl r1, FragmentActivity r2, Ref.ObjectRef r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = (com.bytedance.android.live.browser.utils.i) r3.element;
    }
}
