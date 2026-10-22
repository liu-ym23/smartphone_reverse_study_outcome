package com.bytedance.android.live.profile;

import com.bytedance.android.live.profile.p000enum.ProfileMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ NewLiveProfileDialogFragment a;
    public final /* synthetic */ ProfileMode b;

    public f(NewLiveProfileDialogFragment r1, ProfileMode r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.profile.model.a r4 = (com.bytedance.android.live.profile.model.a) r3;
        NewLiveProfileDialogFragment r5 = this.a;
        com.bytedance.android.live.profile.seeselftransition.a r0 = r5.n;
        if (r0 == null) goto L6;
        r0.b(this.b, r5);
        return;
    }
}
