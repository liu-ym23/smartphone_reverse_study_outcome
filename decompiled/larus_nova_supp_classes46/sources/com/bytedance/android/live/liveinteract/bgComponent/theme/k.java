package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements km3.g.a {
    public final /* synthetic */ j a;

    public k(j r1) {
        this.a = r1;
    }

    public final void onClose() {
        WeakReference<ThemeUpLoadListener> r0 = this.a.g;
        if (r0 == null) goto L7;
        ThemeUpLoadListener r1 = r0.get();
        if (r1 == null) goto L7;
        r1.onUploadFailed();
    L7:
        Disposable r2 = this.a.f;
        if (r2 == null) goto L11;
        r2.dispose();
        return;
    }
}
