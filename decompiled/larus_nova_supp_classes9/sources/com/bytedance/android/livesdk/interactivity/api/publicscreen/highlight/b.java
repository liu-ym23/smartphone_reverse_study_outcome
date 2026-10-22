package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.content.Context;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b implements i {
    public Context a;
    public k b;
    public com.bytedance.live.datacontext.j<vlc.d> c;
    public final CompositeDisposable d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public void b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public void onUnload() {
        this.a = null;
        this.b = null;
        this.d.clear();
    }

    public b() {
        this.d = new CompositeDisposable();
    }

    public final Context getContext() {
        return this.a;
    }
}
