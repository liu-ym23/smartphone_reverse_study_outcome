package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i1<T> implements Consumer {
    public static final i1 a = null;

    static {
        a = new i1();
    }

    public i1() {
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        xs2.b.a().post(new RefreshVSMessageBoardDataEvent());
    }
}
