package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.sticker.presenter.p0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveStickerDownloadHelper implements com.bytedance.android.live.effect.api.l {
    public final Lazy a;
    public final List<com.bytedance.android.live.effect.api.l.b> b;
    public final List<String> c;
    public final LiveEffectContextFactoryDelegate$Type d;

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ LiveStickerDownloadHelper a;
        public final /* synthetic */ Effect b;

        public b(LiveStickerDownloadHelper r1, Effect r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<Boolean> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            r3.onNext(Boolean.valueOf(((EffectManager) this.a.a.getValue()).isEffectDownloaded(this.b)));
        }
    }

    public static final class c extends p0<Boolean> {
        public final /* synthetic */ com.bytedance.android.live.effect.api.l.a a;

        public c(com.bytedance.android.live.effect.api.l.a r1) {
            this.a = r1;
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.a(false);
        }

        public final void onNext(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            this.a.a(r3);
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.d;
    }

    public LiveStickerDownloadHelper(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.d = r2;
        this.a = LazyKt.lazy(new LiveStickerDownloadHelper$effectManager$2(this));
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    @Override // com.bytedance.android.live.effect.api.l
    public final void a(Effect r2, boolean r3, com.bytedance.android.live.effect.api.l.a r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r2 != null) goto L6;
        r4.a(false);
        return;
    L6:
        Observable r5 = Observable.create(new b(this, r2)).subscribeOn(Schedulers.io());
        if (r3 == false) goto L9;
        Scheduler r6 = AndroidSchedulers.mainThread();
    L10:
        r5.observeOn(r6).subscribe(new c(r4));
        return;
    L9:
        r6 = Schedulers.io();
        goto L10
    }

    @Override // com.bytedance.android.live.effect.api.l
    public final void b(String r3, Sticker r4, com.bytedance.android.live.effect.api.l.c r5) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, "sticker");
        a(r4.getEffect(), false, new f(this, r5, r4, r3));
    }
}
