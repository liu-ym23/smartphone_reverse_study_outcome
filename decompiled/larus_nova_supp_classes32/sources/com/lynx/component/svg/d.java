package com.lynx.component.svg;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.n;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final WeakReference<UISvg> a;
    public final LynxContext b;
    public final HashMap<String, Bitmap> c;

    public class a extends BaseBitmapDataSubscriber {
        public final /* synthetic */ DataSource a;
        public final /* synthetic */ String b;
        public final /* synthetic */ b c;
        public final /* synthetic */ d d;

        public final void onFailureImpl(DataSource r2) {
            this.c.onFailed();
            if (r2 == null) goto L6;
            r2.close();
            return;
        }

        public final void onNewResultImpl(Bitmap r3) {
            if (this.a.isFinished() == false) goto L11;
            if (r3 == null) goto L12;
            LLog.d("UISVG Bitmap", "has come");
            this.d.c.put(this.b, Bitmap.createBitmap(r3));
            this.a.close();
            WeakReference<UISvg> r4 = this.d.a;
            if (r4 == null) goto L13;
            UISvg r5 = r4.get();
            if (r5 == null) goto L14;
            LLog.i("lynx_UISvg", "fetch bitmap the image url is :" + this.b + " ui-svg hashCode:" + r5.hashCode());
            r5.S();
            return;
        L14:
            return;
        L13:
            return;
        L12:
            return;
        }

        public a(d r1, DataSource r2, String r3, b r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public interface b {
        void onFailed();

        void onSuccess(Bitmap r1);
    }

    public interface c extends InterfaceC0046d {
        void a(String r1, SVG r2);
    }

    /* JADX INFO: renamed from: com.lynx.component.svg.d$d, reason: collision with other inner class name */
    public interface InterfaceC0046d {
        void onError(String r1);

        void onStart();

        void onSuccess();
    }

    public final void a() {
        Iterator<Map.Entry<String, Bitmap>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        r0.next().getValue().recycle();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        th.toString();
        goto L4
    L10:
        this.c.clear();
    }

    public d(LynxContext r2) {
        this.a = null;
        this.b = r2;
        this.c = new HashMap();
    }

    public d(LynxContext r2, UISvg r3) {
        this.a = null;
        this.b = r2;
        this.c = new HashMap();
        this.a = new WeakReference(r3);
    }

    public final void b(String r4, b r5) {
        if (this.c.containsKey(r4) == false) goto L6;
        LLog.d("UISVG", "requestBitmapSync got from bitmap cache ");
        r5.onSuccess(this.c.get(r4));
        return;
    L6:
        ImageRequestBuilder r0 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(this.b, r4, false)));
        m8a.e.a(r0);
        ImageRequest r1 = r0.build();
        DataSource r2 = Fresco.getImagePipeline().fetchDecodedImage(r1, "lynx_SvgResourceManager");
        r2.subscribe(new a(this, r2, r4, r5), UiThreadImmediateExecutorService.getInstance());
    }

    public final void c(String r4, c r5) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        r5.onError("src is empty!");
        return;
    L7:
        if (this.b.getGenericResourceFetcher() == null) goto L10;
        r5.onStart();
        LynxResourceRequest r0 = new LynxResourceRequest(r4, LynxResourceRequest.LynxResourceType.LynxResourceTypeSVG);
        this.b.getGenericResourceFetcher().a(r0, new e(r5, r4));
        return;
    L10:
        String r6 = d7a.a.b(this.b, r4, false);
        if (TextUtils.isEmpty(r6) == false) goto L15;
        r5.onError("url is empty!");
        return;
    L15:
        if (TextUtils.isEmpty(UriProtector.parse(r6).getScheme()) == false) goto L18;
        r5.onError("scheme is Empty!");
        return;
    L18:
        r5.onStart();
        d8a.h r1 = new d8a.h(r6, this.b.getLynxExtraData());
        n.a().b(r1, new f(r5));
    }
}
