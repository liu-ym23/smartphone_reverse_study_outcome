package com.bytedance.android.livesdk.chatroom.ui.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.utils.m;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.jvm.internal.Intrinsics;
import oo1.f;
import oo1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSVideoDataPushThread extends PthreadThreadV2 {
    public Context v;
    public View w;
    public long x;
    public volatile Bitmap y;
    public final DataCenter z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.VSVideoDataPushThread$run$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ VSVideoDataPushThread a;
        public final /* synthetic */ ILivePlayerClient b;
        public final /* synthetic */ Handler c;

        public final void a() {
            if (oo1.e.f.get() == false) goto L5;
            int r0 = m.a;
            m.a(new VSVideoDataPushThread$run$1$run$1(this));
            this.c.postDelayed(this, this.a.x);
            return;
        L5:
            ALogger.d("VSVideoDataPushThread", "停止录屏截图");
            Looper r1 = Looper.myLooper();
            if (r1 == null) goto L8;
            ThreadMethodProxy.quit(r1);
        L8:
            oo1.d r2 = f.a;
            ALogger.i("QuickInsideRecordManager", "stopRecord");
            oo1.d r3 = f.a;
            if (r3 == null) goto L13;
            r3.a();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AnonymousClass1(VSVideoDataPushThread r1, ILivePlayerClient r2, Handler r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void run() {
        Looper.prepare();     // Catch: Throwable -> L4
        Handler r0 = new Handler();     // Catch: Throwable -> L4
        r0.postDelayed(new AnonymousClass1(this, r.p().currentClient(), r0), this.x);     // Catch: Throwable -> L4
        Looper.loop();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final Context getContext() {
        return this.v;
    }

    public VSVideoDataPushThread(DataCenter r3) {
        super("VSVideoDataPushThread");
        this.z = r3;
        this.x = 42;
    }

    public static final void a(VSVideoDataPushThread r8, Bitmap r9) {
        r8.getClass();
        if (r9 == null) goto L48;
        ALogger.d("VSVideoDataPushThread", "pushFrame");
        Bitmap r2 = null;
        if (r8.y != null) goto L17;
        View r0 = r8.w;
        if (r0 == null) goto L17;
        int r3 = i.a;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "watermarkView");
        Object r4 = r0.getTag();
        if ((r4 instanceof Bitmap) == true) goto L11;
        r4 = null;
    L11:
        Bitmap r5 = (Bitmap) r4;
        if (r5 != null) goto L15;
        r0.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        Bitmap r6 = Bitmap.createBitmap(r0.getMeasuredWidth(), r0.getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        Canvas r7 = new Canvas(r6);
        r0.layout(0, 0, r0.getMeasuredWidth(), r0.getMeasuredHeight());
        r0.draw(r7);
        r0.setTag(r6);
        r5 = r6;
    L15:
        r8.y = r5;
    L17:
        if (r8.y == null) goto L43;
        Bitmap r1 = r8.y;
        if (r1 != null) goto L21;
    L22:
        int r10 = i.a;
        Bitmap r11 = r8.y;
        if (r9.getConfig() == null) goto L41;
        if (r11 == null) goto L41;
        if (r9.isRecycled() == true) goto L41;
        if (r11.isRecycled() == true) goto L41;
        if (r11.getWidth() == 0) goto L41;
        if (r11.getHeight() == 0) goto L41;
        Bitmap.Config r12 = r9.getConfig();
        Intrinsics.checkNotNull(r12);
        r2 = r9.copy(r12, true);
        if (r2 == null) goto L41;
        new Canvas(r2).drawBitmap(r11, 0.0f, r2.getHeight() - r11.getHeight(), new Paint());     // Catch: Exception -> L39
    L39:
        e = move-exception;
        ALogger.e("VideoFrameUtil", "add watermark failed", e);
    L41:
        if (r2 == null) goto L44;
        f.a(r2);
    L44:
        ALogger.d("VSVideoDataPushThread", "pushVideoFrame");
        return;
    L21:
        if (r1.isRecycled() != true) goto L22;
    L43:
        f.a(r9);
        goto L44
    }
}
