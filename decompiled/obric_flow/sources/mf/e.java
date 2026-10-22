package mf;

import android.graphics.Bitmap;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.map.api.exception.BDMapException;
import com.bytedance.map.api.image.ImageCallback;
import com.bytedance.map.api.model.BDLatLng;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements ImageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BDLatLng f20073c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ ReadableMap f;
    public final /* synthetic */ CountDownLatch g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ LynxMapView f20074h;

    public e(LynxMapView r5, int r10, String r11, BDLatLng r12, float r13, float r14, ReadableMap r15, CountDownLatch r16) {
        this.f20074h = r5;
        this.f20071a = r10;
        this.f20072b = r11;
        this.f20073c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public final void a(Bitmap r18) {
        LynxLog.b(2, "LynxMapView", "onLoadSuccess" + this.f20074h);
        int r5 = this.f20071a;
        if (r5 != 0) goto L5;
        LynxMapView.access$300(this.f20074h, this.f20072b, this.f20073c, r18, this.d, this.e, this.f);
    L7:
        this.g.countDown();
        return;
    L5:
        if (r5 != 2) goto L7;
        LynxMapView.access$400(this.f20074h, this.f20072b, this.f20073c, r18, this.d, this.e, this.f);
        goto L7
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public final void a(BDMapException r5) {
        LynxLog.b(2, "LynxMapView", "onLoadFailure" + this.f20074h);
        this.g.countDown();
    }
}
