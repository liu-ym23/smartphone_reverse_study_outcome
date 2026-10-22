package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.TriggerKey;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.c;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class TopicDismissTrigger extends d {
    public final TriggerKey d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public boolean i;
    public boolean j;
    public Disposable k;
    public final DataCenter l;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ TopicDismissTrigger a;

        public a(TopicDismissTrigger r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            TopicDismissTrigger r4 = this.a;
            m.a r0 = r4.a;
            if (r0 == null) goto L6;
            r0.a(r4.f());
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TopicDismissTrigger a;

        public b(TopicDismissTrigger r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Integer r8 = (Integer) r7;
            ALogger.i(this.a.h, "监听到用户发评行为");
            TopicDismissTrigger r9 = this.a;
            if (r9.i == true) goto L5;
            return;
        L5:
            if (r9.j == true) goto L21;
            ALogger.i(r9.h, "监听到点击后发评行为，创建三阶定时器");
            TopicDismissTrigger r10 = this.a;
            String r11 = r10.c(r10.g);
            if (r11 == null) goto L22;
            Long r13 = StringsKt.toLongOrNull(r11);
            if (r13 != null) goto L11;
            return;
        L11:
            if (r13.longValue() <= 0) goto L13;
            boolean r0 = true;
        L14:
            if (r0 == true) goto L17;
            r13 = null;
        L17:
            if (r13 == null) goto L24;
            long r1 = r13.longValue();
            this.a.e(r1);
            this.a.j = true;
            return;
        L24:
            return;
        L13:
            r0 = false;
            goto L14
        L22:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d
    public final void d() {
        String r0 = c(this.e);
        if (r0 == null) goto L15;
        Long r1 = StringsKt.toLongOrNull(r0);
        if (r1 == null) goto L15;
        if (r1.longValue() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        long r3 = r1.longValue();
        ALogger.i(this.h, "创建无点击退场计时器");
        e(r3);
        goto L15
    L9:
        r2 = false;
    L15:
        Function1<q42.a, Unit> r4 = new TopicDismissTrigger$onStart$3(this);
        Intrinsics.checkNotNullParameter(q42.a.class, "event");
        Intrinsics.checkNotNullParameter(r4, "onEvent");
        Disposable r5 = xs2.b.a().b(q42.a.class).subscribe(new c(r4));
        f.a(r5, this.c);
        RxUtilKt.c(r5, this.c);
        h r6 = i.b(this.l, 1);
        if (r6 == null) goto L27;
        com.bytedance.live.datacontext.m<Integer> r7 = r6.getSendCommentCount();
        if (r7 == null) goto L28;
        Observable r8 = r7.a();
        if (r8 == null) goto L29;
        Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L30;
        Disposable r10 = r9.subscribe(new b(this));
        if (r10 == null) goto L31;
        RxUtilKt.c(r10, this.c);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public final void release() {
        super.release();
        Disposable r0 = this.k;
        if (r0 != null) goto L5;
    L10:
        this.k = null;
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final TriggerKey f() {
        return this.d;
    }

    public TopicDismissTrigger(DataCenter r1) {
        this.l = r1;
        this.d = TriggerKey.TopicDismiss;
        this.e = "no_click_time_ms";
        this.f = "no_comment_time_ms";
        this.g = "after_comment_ms";
        this.h = "TopicDismissTrigger";
    }

    public final void e(long r4) {
        Disposable r0 = this.k;
        if (r0 != null) goto L5;
    L10:
        this.k = null;
        ALogger.i(this.h, "计时器创建成功，时长:" + r4 + " 毫秒");
        this.k = Observable.timer(r4, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }
}
