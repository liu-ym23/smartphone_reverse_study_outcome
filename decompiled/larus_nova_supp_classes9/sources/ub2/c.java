package ub2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.i;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.e;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.f;
import com.bytedance.common.utility.Logger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements i {

    public static final class a implements IHostFrescoHelper.GetBitmapCallBack {
        public final /* synthetic */ c a;
        public final /* synthetic */ k b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ ITextPieceImage d;
        public final /* synthetic */ float e;

        public final void fail(IHostFrescoHelper.BitmapDataSource r7) {
            LiveTracingMonitor.EventModule r0 = e.a;
            this.a.getClass();
            k r1 = this.b;
            if (r7 == null) goto L5;
            Throwable r8 = r7.error;
        L6:
            Intrinsics.checkNotNullParameter("NetWorkNormalImageLoader", "loader");
            StringBuilder r2 = new StringBuilder("image error, load failed, loader is NetWorkNormalImageLoader, image type is ");
            if (r1 == null) goto L9;
            Integer r3 = r1.getImageType();
        L10:
            r2.append(r3);
            r2.append(", urls is ");
            if (r1 == null) goto L15;
            List r4 = r1.getUrls();
            if (r4 == null) goto L15;
            String r5 = (String) CollectionsKt.firstOrNull(r4);
        L16:
            r2.append(r5);
            e.b(r2.toString());
            if (r8 == null) goto L21;
            pm0.a r6 = om0.c.c();
            if (r6 == null) goto L21;
            r6.e("RenderTracer", r8);
        L21:
            e.b.h++;
            this.c.invoke(null);
            return;
        L15:
            r5 = null;
            goto L16
        L9:
            r3 = null;
            goto L10
        L5:
            r8 = null;
            goto L6
        }

        public final void onNewResultImpl(Bitmap r5) {
            if (r5 != null) goto L6;
            LiveTracingMonitor.EventModule r6 = e.a;
            this.a.getClass();
            e.c("NetWorkNormalImageLoader", this.b, null);
            this.c.invoke(null);
            return;
        L6:
            Bitmap r2 = r5.copy(Bitmap.Config.ARGB_8888, true);
            if (r2 != null) goto L11;
            LiveTracingMonitor.EventModule r7 = e.a;
            this.a.getClass();
            e.c("NetWorkNormalImageLoader", this.b, null);
            this.c.invoke(null);
            return;
        L11:
            if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.a == false) goto L14;
            Logger.d("ttlive_render_engine", "on bitmap ret : " + this.d);
        L14:
            if (this.d.getScaleType() == ITextPieceImage.ScaleType.FIT_Y) goto L16;
        L18:
            c r8 = this.a;
            ITextPieceImage r0 = this.d;
            float r1 = this.e;
            r8.getClass();
            this.c.invoke(c.d(r2, r0, r1));
            return;
        L16:
            if (r5.getHeight() <= 0) goto L18;
            this.d.setWidth((int) ((r5.getWidth() / r5.getHeight()) * this.d.getHeight()));
            goto L18
        }

        public a(c r1, k r2, Function1 r3, ITextPieceImage r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public c() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final boolean c(ITextPieceImage r2) {
        Intrinsics.checkNotNullParameter(r2, "image");
        if (r2.getResourceType() != ITextPieceImage.ResourceType.NetWork) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final Drawable a(ITextPieceImage r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "image");
        String r0 = jc1.k.n(IHostFrescoHelper.class).getImageFilePath(r5.getImageModel());
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        Bitmap r1 = BitmapFactory.decodeFile(r0);
        if (r1 != null) goto L10;
        LiveTracingMonitor.EventModule r7 = e.a;
        e.c("NetWorkNormalImageLoader", r5.getImageModel(), null);
        return null;
    L10:
        if (r5.getScaleType() != ITextPieceImage.ScaleType.FIT_Y) goto L15;
        if (r1.getHeight() <= 0) goto L15;
        r5.setWidth((int) ((r1.getWidth() / r1.getHeight()) * r5.getHeight()));
        r1 = Bitmap.createScaledBitmap(r1, r5.getWidth(), r5.getHeight(), false);
    L15:
        return d(r1, r5, r6);
    }

    public static Drawable d(Bitmap r5, ITextPieceImage r6, float r7) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r6.getWidth() <= 0) goto L9;
        int r0 = r6.getWidth();
    L16:
        if (r6.getHeight() <= 0) goto L19;
        int r8 = r6.getHeight();
    L25:
        int r1 = (int) f.a(r0, r7);
        int r9 = (int) f.a(r8, r7);
        BitmapDrawable r10 = new BitmapDrawable(s1.getResources(), r5);
        r10.setBounds(0, 0, r1, r9);
        return r10;
    L19:
        if (r6.getScaleY() <= 0) goto L21;
        r8 = (int) (r5.getHeight() * r6.getScaleY());
        goto L25
    L21:
        int r11 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.a.a;
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        int r13 = r5.getHeight();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.c.c.getClass();
        int r2 = com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.c.b;
        if (r13 <= r2) goto L24;
        r8 = r2;
        goto L25
    L24:
        r8 = r5.getHeight();
        goto L25
    L9:
        if (r6.getScaleX() <= 0) goto L11;
        r0 = (int) (r5.getWidth() * r6.getScaleX());
        goto L16
    L11:
        int r3 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.a.a;
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        int r4 = r5.getHeight();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.c.c.getClass();
        int r14 = com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.c.b;
        if (r4 <= r14) goto L14;
        r0 = (r14 * r5.getWidth()) / r5.getHeight();
        goto L16
    L14:
        r0 = r5.getWidth();
        goto L16
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final void b(ITextPieceImage r10, float r11, Function1<? super Drawable, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "image");
        Intrinsics.checkNotNullParameter(r13, "callback");
        k r0 = r10.getImageModel();
        if (r0 != null) goto L5;
    L11:
        e.d("NetWorkNormalImageLoader", r0);
        r13.invoke(null);
        return;
    L5:
        if (r0.getUrls() == null) goto L11;
        if (r0.getUrls().isEmpty() == true) goto L11;
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r0, new a(this, r0, r13, r10, r11));
    }
}
