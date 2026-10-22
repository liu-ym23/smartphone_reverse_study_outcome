package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements Action {
    public final /* synthetic */ MutableLiveData a;
    public final /* synthetic */ Observer b;

    public h(MutableLiveData r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        MutableLiveData r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeObserver(this.b);
        return;
    }
}
