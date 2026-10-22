package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements vr1.m, com.bytedance.android.scope.o {
    public l() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.m
    public final boolean handle(Context r2, Uri r3) {
        return jc1.k.n(ILiveActionHandler.class).handle(r2, r3);
    }
}
