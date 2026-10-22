package com.bytedance.android.live.liveinteract.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ py.k a;
    public final /* synthetic */ View b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i0 a;

        public a(i0 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            View r0 = this.a.b;
            Resources r2 = s1.getResources();
            r0.setBackground(new BitmapDrawable(r2, (Bitmap) r4));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i0 a;

        public b(i0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ALogger.e("LinkMicPosTagInfoUtils", ((Throwable) r2).getMessage());
            this.a.b.setBackgroundResource(2131248855);
        }
    }

    public i0(py.k r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((ObservableSubscribeProxy) com.bytedance.android.livesdk.chatroom.utils.a1.k(this.a).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this.b))).subscribe(new a(this), new b(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
