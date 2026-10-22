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
public final class d implements ImageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDLatLng f20069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f20070c;
    public final /* synthetic */ float d;
    public final /* synthetic */ ReadableMap e;
    public final /* synthetic */ CountDownLatch f;
    public final /* synthetic */ LynxMapView g;

    public d(LynxMapView r5, String r10, BDLatLng r11, float r12, float r13, ReadableMap r14, CountDownLatch r15) {
        this.g = r5;
        this.f20068a = r10;
        this.f20069b = r11;
        this.f20070c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public final void a(Bitmap r11) {
        LynxLog.b(2, "LynxMapView", "onLoadSuccess");
        float r10 = this.d;
        ReadableMap r12 = this.e;
        LynxMapView.access$300(this.g, this.f20068a, this.f20069b, r11, this.f20070c, r10, r12);
        this.f.countDown();
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public final void a(BDMapException r5) {
        LynxLog.b(2, "LynxMapView", "onLoadFail");
        this.f.countDown();
    }
}
