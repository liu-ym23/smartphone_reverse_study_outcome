package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class d implements IMusicControlNode {
    public final CompositeDisposable a;
    public Disposable b;
    public g c;
    public final MusicPanel d;
    public ModeType e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            Disposable r6 = this.a.b;
            if (r6 == null) goto L5;
            r6.dispose();
        L5:
            this.a.d();
            String r0 = null;
            this.a.c = null;
            StringBuilder r7 = new StringBuilder("BaseMusicControlNode#process, handleProcessOverTime, songId ");
            MusicPanel r1 = this.a.d;
            if (r1 == null) goto L10;
            KtvMusic r2 = r1.a;
            if (r2 == null) goto L10;
            Long r3 = Long.valueOf(r2.getMId());
        L11:
            r7.append(r3.longValue());
            r7.append(", title: ");
            MusicPanel r8 = this.a.d;
            if (r8 == null) goto L16;
            KtvMusic r9 = r8.a;
            if (r9 == null) goto L16;
            r0 = r9.getMTitle();
        L16:
            r7.append(r0);
            r7.append(", type: ");
            r7.append(this.a.getType());
            com.bytedance.android.live.ktv.common.util.g.a(r7.toString());
            return;
        L10:
            r3 = null;
            goto L11
        }
    }

    public abstract void c();

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public abstract /* synthetic */ IMusicControlNode.OperationType getType();

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public void a() {
        this.a.clear();
        this.c = null;
        if (vm2.h.q() == false) goto L12;
        Disposable r0 = this.b;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isDisposed() == true) goto L14;
        Disposable r1 = this.b;
        if (r1 == null) goto L15;
        r1.dispose();
        return;
    L15:
        return;
    L14:
        return;
    }

    public void d() {
        g r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(this);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public void b(g r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.c = r3;
        Disposable r4 = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        RxUtilKt.c(r4, this.a);
        this.b = r4;
        c();
    }

    public d(MusicPanel r2, ModeType r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "modeType");
        this.d = r2;
        this.e = r3;
        this.a = new CompositeDisposable();
    }
}
