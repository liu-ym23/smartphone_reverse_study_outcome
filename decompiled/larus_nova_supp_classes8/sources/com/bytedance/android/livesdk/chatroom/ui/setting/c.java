package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public c(a r1, boolean r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r9) {
        ApiServerException r10 = (Throwable) r9;
        if ((r10 instanceof ApiServerException) == false) goto L5;
        f2.c(r10.getPrompt(), 0);
    L5:
        MultiTypeAdapter r11 = this.a.q.listAdapter();
        if (r11 == null) goto L10;
        int r0 = mx.l.o;
        mx.l.a.b(r11, this.a, !this.b);
        a.g(this.a, this.c, this.d, this.b, false);
        return;
    }
}
