package mf;

import android.graphics.Bitmap;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.map.api.exception.BDMapException;
import com.bytedance.map.api.image.ImageCallback;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ImageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f20077c;
    public final /* synthetic */ float d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f20078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f20079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f20080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LynxMapView f20081k;

    public f(LynxMapView r5, int r10, String r11, ArrayList r12, float r13, int r14, int r15, float r16, boolean r17, ReadableMap r18, ReadableMap r19) {
        this.f20081k = r5;
        this.f20075a = r10;
        this.f20076b = r11;
        this.f20077c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.f20078h = r17;
        this.f20079i = r18;
        this.f20080j = r19;
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public final void a(Bitmap r17) {
        LynxLog.b(2, "LynxMapView", "updateLines load texture success" + this.f20081k);
        LynxMapView.access$000(this.f20081k, this.f20075a, this.f20076b, this.f20077c, this.d, this.e, this.f, this.g, this.f20078h, r17, this.f20079i, this.f20080j);
    }

    @Override // com.bytedance.map.api.image.ImageCallback
    public final void a(BDMapException r5) {
        LynxLog.b(2, "LynxMapView", "updateLines load texture fail" + this.f20081k);
    }
}
