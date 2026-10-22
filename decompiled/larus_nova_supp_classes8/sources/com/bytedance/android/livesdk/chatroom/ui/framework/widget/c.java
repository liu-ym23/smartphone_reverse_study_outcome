package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.castscreen.views.bytecast.LiveCastControlLayout;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveCastControlLayout a;

    public c(LiveCastControlLayout r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L5;
        this.a.setVisibility(0);
        return;
    L5:
        this.a.setVisibility(8);
    }
}
