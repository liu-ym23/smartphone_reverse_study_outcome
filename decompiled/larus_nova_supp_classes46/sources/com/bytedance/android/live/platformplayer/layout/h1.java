package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h1 implements Observer<Long> {
    public Disposable a;
    public int b;
    public final /* synthetic */ LivePlayerWidget c;

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public h1(LivePlayerWidget r1) {
        this.c = r1;
        this.b = 2;
    }

    public final void onNext(Object r4) {
        ((Number) r4).longValue();
        this.b--;
        LivePlayerWidget r5 = this.c;
        int r0 = LivePlayerWidget.V2;
        ILivePlayerClient r6 = r5.dr();
        Disposable r1 = null;
        if (r6 == null) goto L9;
        IRoomEventHub r7 = r6.getEventHub();
        if (r7 == null) goto L9;
        MutableLiveData r8 = r7.getPlaying();
        if (r8 == null) goto L9;
        Boolean r9 = (Boolean) r8.getValue();
    L10:
        boolean r2 = true;
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L13;
    L19:
        Disposable r10 = this.a;
        if (r10 != null) goto L22;
        return;
    L22:
        if (r10.isDisposed() == false) goto L24;
    L26:
        r2 = false;
    L27:
        if (r2 == false) goto L29;
        r1 = r10;
    L29:
        if (r1 == null) goto L33;
        r1.dispose();
        return;
    L33:
        return;
    L24:
        if (this.b > 0) goto L26;
    L13:
        if (this.c.U2.getLiveIllegal() == true) goto L19;
        if (this.c.tr() == true) goto L17;
    L18:
        this.c.Wu("check player status", true);
        goto L19
    L17:
        if (this.c.H1 == false) goto L19;
    L9:
        r9 = null;
        goto L10
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a = r2;
    }
}
