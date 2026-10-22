package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b3 extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
    public final /* synthetic */ a3 a;
    public final /* synthetic */ a3.b b;
    public final /* synthetic */ View c;
    public final /* synthetic */ float d;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ b3 a;

        public a(b3 r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            PooledByteBuffer r5 = (PooledByteBuffer) r4;
            Intrinsics.checkNotNullParameter(r5, "pooledByteBuffer");
            a3 r0 = this.a.a;
            PooledByteBufferInputStream r1 = new PooledByteBufferInputStream(r5);
            int r2 = a3.d;
            r0.d(r1);
            PooledByteBufferInputStream r3 = new PooledByteBufferInputStream(r5);
            BitmapFactory.Options r6 = new BitmapFactory.Options();
            r6.inDensity = com.bytedance.android.live.core.utils.s1.v();
            r6.inTargetDensity = com.bytedance.android.live.core.utils.s1.v();
            Unit r7 = Unit.INSTANCE;
            return BitmapFactory.decodeStream(r3, null, r6);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ b3 a;

        public b(b3 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Bitmap r6 = (Bitmap) r5;
            if (r6 == null) goto L14;
            b3 r0 = this.a;
            a3 r1 = r0.a;
            View r2 = r0.c;
            float r3 = r0.d;
            int r4 = a3.d;
            NinePatchDrawable r7 = r1.a(r6, r2, r3, true);
            if (r7 == null) goto L11;
            a3.b r8 = this.a.b;
            if (r8 == null) goto L9;
            r8.a(r7);
            Unit r9 = Unit.INSTANCE;
        L10:
            if (r9 == null) goto L11;
            return;
        L9:
            r9 = null;
        L11:
            this.a.a.e("NinePatchChunk is null");
            a3.b r10 = this.a.b;
            if (r10 == null) goto L19;
            r10.onFail();
            Unit r11 = Unit.INSTANCE;
            return;
        L19:
            return;
        L14:
            a3 r12 = this.a.a;
            int r13 = a3.d;
            r12.e("srcBitmap or flexData is null");
            a3.b r14 = this.a.b;
            if (r14 == null) goto L21;
            r14.onFail();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b3 a;

        public c(b3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            a3 r4 = this.a.a;
            int r0 = a3.d;
            r4.e("BitmapFactory decodeStream exception");
            a3.b r5 = this.a.b;
            if (r5 == null) goto L6;
            r5.onFail();
            return;
        }
    }

    public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r2) {
        this.a.e("dataSource  onFailureImpl");
        a3.b r3 = this.b;
        if (r3 == null) goto L6;
        r3.onFail();
        return;
    }

    public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isFinished() == true) goto L6;
        return;
    L6:
        if (r3.getResult() == null) goto L17;
        CloseableReference r0 = (CloseableReference) r3.getResult();
        if (r0 == null) goto L10;
        PooledByteBuffer r1 = (PooledByteBuffer) r0.get();
    L11:
        if (r1 == null) goto L18;
        Object r4 = r3.getResult();
        Intrinsics.checkNotNull(r4);
        Observable.just(((CloseableReference) r4).get()).subscribeOn(Schedulers.io()).map(new a(this)).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        return;
    L18:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public b3(a3 r1, a3.b r2, View r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
