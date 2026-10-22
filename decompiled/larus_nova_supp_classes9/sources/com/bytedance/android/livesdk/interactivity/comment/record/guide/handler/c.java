package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements ObservableOnSubscribe {
    public final /* synthetic */ d a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.highlight.b b;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.n c;
    public final /* synthetic */ long d;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Integer r2 = (Integer) r1;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ ObservableEmitter b;

        public b(c r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.d(this.a.a.b, String.valueOf(r4));
            this.b.onError(r4);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.c$c, reason: collision with other inner class name */
    public static final class C0130c implements Action {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ObservableEmitter c;

        public C0130c(c r1, String r2, ObservableEmitter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            ALogger.d(this.a.a.b, "下载完成");
            c r0 = this.a;
            r0.a.c.put(Long.valueOf(r0.d), this.b);
            this.c.onNext(this.b);
            this.c.onComplete();
        }
    }

    public c(d r1, com.bytedance.android.livesdk.interactivity.comment.highlight.b r2, com.bytedance.android.livesdk.interactivity.comment.record.guide.n r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "emmit");
        List<String> r0 = this.b.i();
        if (r0 != null) goto L6;
        r11.onError(new IllegalArgumentException("highlightData tsUrl is Empty"));
        return;
    L6:
        Context r1 = this.c.getContext();
        ArrayList r2 = new ArrayList();
        int r3 = r0.size();
        String[] r4 = new String[r3];
        int r6 = 0;
    L7:
        if (r6 >= r3) goto L9;
        r4[r6] = BuildConfig.FLAVOR;
        r6 = r6 + 1;
        goto L7
    L9:
        String r5 = e72.c.c(r1);
        int r7 = r0.size();
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L22;
        String r9 = (String) ListProtector.get(r0, r8);
        if (r9 != null) goto L14;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == true) goto L21;
        String r13 = r5 + File.separator + r8 + "_" + UriProtector.parse(r9).getLastPathSegment();
        r2.add(new Pair(r9, r13));
        r4[r8] = r13;
        ListProtector.add(this.a.e, r8, r13);
    L21:
        r8 = r8 + 1;
        goto L10
    L14:
        if (r9.length() == 0) goto L17;
        r10 = false;
        goto L18
    L22:
        String r14 = r5 + File.separator + System.currentTimeMillis() + "_highlight.mp4";
        this.a.getClass();
        Observable r15 = Observable.create(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.b(r2));
        this.a.getClass();
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.concat(r15, Observable.create(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.a(r4, r14)).subscribeOn(Schedulers.io())).subscribe(a.a, new b(this, r11), new C0130c(this, r14, r11)), this.a.a);
    }
}
