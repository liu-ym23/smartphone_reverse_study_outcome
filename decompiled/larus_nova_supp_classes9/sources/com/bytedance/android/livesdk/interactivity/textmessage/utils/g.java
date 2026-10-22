package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import com.ss.android.ugc.effectmanager.IFetchResourceListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements IFetchResourceListener {
    public final /* synthetic */ f.a a;

    public g(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.c r1) {
        this.a = r1;
    }

    public final void onFailure(Exception r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        this.a.onFailure();
    }

    public final void onSuccess(long r1) {
        this.a.onSuccess();
    }
}
