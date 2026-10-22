package com.bytedance.android.live.revlink.impl.pk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements Runnable {
    public final /* synthetic */ py.k a;
    public final /* synthetic */ View b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.b.setBackground(new BitmapDrawable((Bitmap) r3));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "obj");
            r3.printStackTrace();
        }
    }

    public s(py.k r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((ObservableSubscribeProxy) a1.k(this.a).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this.b))).subscribe(new a(this), b.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
