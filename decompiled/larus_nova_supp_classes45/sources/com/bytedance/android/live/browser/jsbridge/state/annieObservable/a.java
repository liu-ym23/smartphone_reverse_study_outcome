package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends BaseDataObsProvider<Episode> {
    public final VSDataContext b;
    public final Disposable c;
    public final lm1.b d;
    public final Disposable e;
    public final DataCenter f;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.state.annieObservable.a$a, reason: collision with other inner class name */
    public static final class C0126a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0126a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.i(sh6.c.b((sh6.b) r2));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.i(sh6.c.b((sh6.b) r2));
        }
    }

    public final Object g() {
        VSDataContext r0 = this.b;
        if (r0 == null) goto L8;
        n r1 = r0.getEpisode();
        if (r1 == null) goto L8;
        Episode r2 = (Episode) r1.getValue();
        if (r2 == null) goto L8;
    L14:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return (Episode) this.f.get("data_vs_episode_data", null);
    L8:
        lm1.b r3 = this.d;
        if (r3 == null) goto L13;
        n r4 = r3.getEpisode();
        if (r4 == null) goto L13;
        r2 = (Episode) r4.getValue();
    L13:
        r2 = null;
        goto L14
    }

    public final String key() {
        int r0 = com.bytedance.android.live.browser.jsbridge.i.e.a.b;
        return "current_episode";
    }

    public final void onRelease() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.e;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public a(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.f = r4;
        VSDataContext.Companion.getClass();
        VSDataContext r0 = VSDataContext.a.b(r4);
        this.b = r0;
        Disposable r1 = null;
        if (r0 == null) goto L9;
        n r2 = r0.getEpisode();
        if (r2 == null) goto L9;
        Observable r3 = r2.a();
        if (r3 == null) goto L9;
        Disposable r5 = r3.subscribe(new C0126a(this));
    L10:
        this.c = r5;
        lm1.b r6 = pm1.f.d(r4);
        this.d = r6;
        if (r6 == null) goto L17;
        n r7 = r6.getEpisode();
        if (r7 == null) goto L17;
        Observable r8 = r7.a();
        if (r8 == null) goto L17;
        r1 = r8.subscribe(new b(this));
    L17:
        this.e = r1;
        return;
    L9:
        r5 = null;
        goto L10
    }
}
