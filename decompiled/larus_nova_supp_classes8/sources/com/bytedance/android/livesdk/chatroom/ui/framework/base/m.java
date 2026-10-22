package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.t;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements Action {
    public final /* synthetic */ ru2.b a;
    public final /* synthetic */ Fragment b;

    public m(ru2.b r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.a.a();
        t.b.b(this.b);
    }
}
