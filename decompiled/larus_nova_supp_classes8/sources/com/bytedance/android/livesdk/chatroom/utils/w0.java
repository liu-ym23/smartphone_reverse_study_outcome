package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w0 extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ a1.b c;

    public class a implements Consumer<Bitmap> {
        public final /* synthetic */ w0 a;

        public a(w0 r1) {
            this.a = r1;
        }

        public final void accept(Object r9) throws Exception {
            Bitmap r10 = (Bitmap) r9;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.getNinePatchChunk() == null) goto L10;
            Rect r6 = a1.i(r10.getNinePatchChunk());
            NinePatchDrawable r7 = new NinePatchDrawable(this.a.a.getResources(), r10, r10.getNinePatchChunk(), r6, null);
            r7.setAutoMirrored(this.a.b);
            this.a.a.setBackground(r7);
            w0 r0 = this.a;
            if (r0.b == false) goto L9;
            r0.a.setPadding(r6.right, r6.top, r6.left, r6.bottom);
            goto L10
        L9:
            r0.a.setPadding(r6.left, r6.top, r6.right, r6.bottom);
        L10:
            a1.b r1 = this.a.c;
            if (r1 == null) goto L15;
            r1.a(r10);
            return;
        }
    }

    public class b implements Function<PooledByteBuffer, Bitmap> {
        public b() {
        }

        public final Object apply(Object r2) throws Exception {
            return BitmapFactory.decodeStream(new PooledByteBufferInputStream((PooledByteBuffer) r2));
        }
    }

    public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r2) {
        a1.b r3 = this.c;
        if (r3 == null) goto L6;
        r3.onFail(new RuntimeException());
        return;
    }

    public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isFinished() == true) goto L6;
        return;
    L6:
        if (r3.getResult() != null) goto L8;
        return;
    L8:
        if (((CloseableReference) r3.getResult()).get() == null) goto L15;
        Observable.just((PooledByteBuffer) ((CloseableReference) r3.getResult()).get()).subscribeOn(Schedulers.io()).map(new b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), RxUtil.getNoOpThrowable());
        return;
    }

    public w0(View r1, boolean r2, ht2.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
