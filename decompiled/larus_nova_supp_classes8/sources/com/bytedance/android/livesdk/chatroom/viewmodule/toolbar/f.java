package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.config.iq;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements u, Disposable {
    public final CompositeDisposable a;

    public final boolean isDisposed() {
        return this.a.isDisposed();
    }

    public final void dispose() {
        this.a.dispose();
    }

    public f(int r2) {
        if ((r2 & 2) == 0) goto L6;
        iq.a.getValue().longValue();
    L6:
        if ((r2 & 4) == 0) goto L8;
        CompositeDisposable r3 = new CompositeDisposable();
    L9:
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.a = r3;
        new LinkedHashMap();
        return;
    L8:
        r3 = null;
        goto L9
    }
}
