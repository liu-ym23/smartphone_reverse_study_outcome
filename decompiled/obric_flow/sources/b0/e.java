package b0;

import ai.j0;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.map.api.BDMapClient;
import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.exception.BDMapException;
import com.bytedance.map.api.image.ImageCallback;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.sensor.SensorEventHelper;
import com.lynx.base.log.LynxLog;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e implements l.b, ImageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f812c;
    public Object d;

    public e(LynxMapView r5, BDLatLng r10, float r11, String r12) {
        this.d = r5;
        this.f811b = r10;
        this.f810a = r11;
        this.f812c = r12;
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public void a(Bitmap r15) {
        LynxLog.b(2, "LynxMapView", "onLoadSuccess");
        LynxMapView r5 = (LynxMapView) this.d;
        BDMapClient r10 = LynxMapView.access$600(r5);
        BDMarkerOptions r13 = new BDMarkerOptions((BDLatLng) this.f811b, r15, null, 0.0f, 1.0f, 0.5f, 0.5f, this.f810a, true, (String) this.f812c);
        IMapService r16 = r10.f6862a;
        if (r16 != null) goto L5;
        IMarker r17 = null;
    L6:
        LynxMapView.access$502(r5, r17);
        LynxMapView.access$700(r5).put((String) this.f812c, LynxMapView.access$500(r5));
        if (LynxMapView.access$800(r5) == null) goto L10;
        SensorEventHelper r14 = LynxMapView.access$800(r5);
        r14.f = LynxMapView.access$500(r5);
        return;
    L10:
        return;
    L5:
        r17 = r16.addMarker(r13);
        goto L6
    }

    @Override // l.b
    public v.a b() {
        return (v.a) this.f812c;
    }

    @Override // l.b
    public boolean c(float r5) {
        v.a r10 = (v.a) this.f812c;
        if (r5 >= r10.b()) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == true) goto L10;
        this.f812c = d(r5);
        return true;
    L10:
        return !((v.a) this.f812c).c();
    L5:
        if (r5 >= r10.a()) goto L7;
        r11 = true;
        goto L8
    }

    public v.a d(float r10) {
        List r5 = (List) this.f811b;
        v.a r11 = (v.a) j0.e(r5, 1);
        if (r10 < r11.b()) goto L5;
        return r11;
    L5:
        int r12 = r5.size() - 2;
    L6:
        if (r12 < 1) goto L17;
        v.a r13 = (v.a) r5.get(r12);
        if (((v.a) this.f812c) == r13) goto L15;
        if (r10 < r13.b()) goto L15;
        if (r10 >= r13.a()) goto L15;
        return r13;
    L15:
        r12 = r12 - 1;
        goto L6
    L17:
        return (v.a) r5.get(0);
    }

    @Override // l.b
    public float f() {
        return ((v.a) ((List) this.f811b).get(0)).b();
    }

    @Override // l.b
    public float g() {
        return ((v.a) j0.e((List) this.f811b, 1)).a();
    }

    @Override // l.b
    public boolean isEmpty() {
        return false;
    }

    public e(Context r5) {
        this.f810a = 1;
        this.f811b = r5;
        ActivityManager r10 = (ActivityManager) r5.getSystemService("activity");
        this.f812c = r10;
        this.d = new ug.e(r5.getResources().getDisplayMetrics(), 1);
        if (r10.isLowRamDevice() == false) goto L6;
        this.f810a = 0.0f;
        return;
    }

    public e(List r5) {
        this.d = null;
        this.f810a = -1.0f;
        this.f811b = r5;
        this.f812c = d(0.0f);
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public void a(BDMapException r5) {
        LynxLog.b(2, "LynxMapView", "onLoadFail");
    }

    @Override // l.b
    public boolean a(float r5) {
        v.a r10 = (v.a) this.d;
        v.a r11 = (v.a) this.f812c;
        if (r10 == r11) goto L5;
    L8:
        this.d = r11;
        this.f810a = r5;
        return false;
    L5:
        if (this.f810a != r5) goto L8;
        return true;
    }
}
