package jg;

import ai.j0;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import android.view.View;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.monitor.collector.BinderMonitor;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.common.reflect.w;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import com.lynx.tasm.ui.image.a0;
import com.lynx.tasm.ui.image.v0;
import com.lynx.tasm.ui.image.y;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.Grouping;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.protobuf.f0;
import mt.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Grouping, com.bytedance.ies.bullet.service.base.g, y, xn.d, g8.b, pt.g, go.a, xp.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f18337c = false;
    public static volatile k d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18339b;

    public /* synthetic */ k(Object r5, int r10) {
        this.f18338a = r10;
        this.f18339b = r5;
    }

    public static k m() {
        if (d != null) goto L16;
        monitor-enter(k.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new k(0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(k.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    @Override // com.lynx.tasm.ui.image.y
    /* JADX INFO: renamed from: a */
    public void mo100a() {
        switch(this.f18338a) {
            case 6: goto L8;
            default: goto L5;
        };
    L8:
        v0 r5 = (v0) this.f18339b;
        if (r5.S == false) goto L11;
        r5.h(r5.e, r5.f, r5.s, r5.f11134u, r5.f11133t, r5.f11135v);
        return;
    L11:
        r5.g(r5.e, r5.f, r5.s, r5.f11134u, r5.f11133t, r5.f11135v);
        return;
    L5:
        if (g8.e.f17067b.get() == false) goto L13;
        com.lynx.tasm.behavior.utils.d.e(1, (Application) this.f18339b);
        return;
    }

    @Override // pt.g
    public void accept(Object r5) {
        io.reactivex.internal.functions.e.d(r5, "value is null");
        l r10 = new l(r5);
        ((pt.g) this.f18339b).accept(r10);
    }

    public Object b(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Object r10 = ((ConcurrentHashMap) this.f18339b).get(r5);
        if (r10 != null) goto L5;
    L10:
        return null;
    L5:
        if (r5.isAssignableFrom(r10.getClass()) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L10;
        return r10;
    }

    @Override // com.lynx.tasm.ui.image.y
    public void c() {
        ((v0) this.f18339b).f11121h = true;
    }

    @Override // com.lynx.tasm.ui.image.y
    public void clear() {
    }

    @Override // com.lynx.tasm.ui.image.y
    public void d(LinkedList r5) {
        ((v0) this.f18339b).getClass();
    }

    @Override // xn.d
    public void e(wn.b r5, xn.e r10, xn.c r11) {
        String r12 = r10.f23182a;
        dn.f r13 = (dn.f) this.f18339b;
        xn.e r14 = r13.E;
        if (r14 == null) goto L5;
        String r15 = r14.f23182a;
    L7:
        if (TextUtils.equals(r12, r15) == true) goto L9;
        return;
    L9:
        if (r5 == null) goto L21;
        boolean r16 = r13.f16683f0;
        Drawable r17 = r5.f22876c;
        boolean r18 = r5.d;
        if (r16 == false) goto L17;
        if (r18 == false) goto L15;
        r5.f22879j.setFilterBitmap(false);
        goto L17
    L15:
        r17.setFilterBitmap(false);
    L17:
        if (r11.f23181c == false) goto L21;
        if (r18 == true) goto L21;
        r17.setCallback(r13);
    L21:
        if (r13.g == false) goto L25;
        r13.k(r13.f16681d0);
        r13.o(r13.f16687j);
        r13.f16681d0 = null;
        wn.e r19 = r13.f16687j;
        if (r19 == null) goto L25;
        r19.b();
        r13.f16687j = null;
    L25:
        r13.f16687j = new wn.e(r5, r13.f16691n);
        if (TextUtils.isEmpty(r13.f16689l) == true) goto L28;
        wn.e r20 = r13.f16687j;
        String r21 = r13.f16689l;
        String r22 = r13.f16690m;
        r20.g = r21;
        r20.f22889h = r22;
    L28:
        r13.M = r11.f23179a;
        r13.N = r11.f23180b;
        r13.f16677b.getClass();
        r13.p();
        PorterDuffColorFilter r23 = r13.f16680c0;
        if (r23 == null) goto L31;
        r13.f16687j.setColorFilter(r23);
    L31:
        r13.f(r13.f16687j);
        r13.b(r13.M, r13.N);
        r13.n();
        return;
    L5:
        r15 = null;
        goto L7
    }

    @Override // go.a
    public void f(w r12) {
        int r5 = 0;
        if (((LynxResourceResponse$ResponseState) r12.f9377c) != LynxResourceResponse$ResponseState.f10948b) goto L5;
        boolean r10 = true;
    L6:
        Throwable r11 = (Throwable) r12.d;
        byte[] r13 = (byte[]) r12.f9376b;
        if (r11 == null) goto L9;
        String r14 = r11.getMessage();
    L10:
        nn.b r15 = (nn.b) this.f18339b;
        if (r15.a() == true) goto L13;
        return;
    L13:
        String r16 = r15.f20275b;
        if (r10 == false) goto L24;
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("load resource success with url: "), r16, 2, "LynxResourceLoader");
        if (r13 != null) goto L18;
    L21:
        r5 = 30301;
        r14 = "get null data for provider.";
    L22:
        LynxResourceLoader.nativeInvokeCallback(r15.f20273c, r13, 0, null, r5, r14);
        return;
    L18:
        if (r13.length != 0) goto L22;
    L24:
        LynxLog.b(2, "LynxResourceLoader", f4.b.b(new StringBuilder("load resource failed with url: "), r16, " error message: ", r14));
        LynxResourceLoader.nativeInvokeCallback(r15.f20273c, null, 0, null, 30301, com.lynx.tasm.utils.k.j(r14, ": ", r14));
        return;
    L9:
        r14 = "";
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    @Override // xn.d
    public void g(int r10, Throwable r11) {
        StringBuilder r5 = new StringBuilder("onFailed src:");
        dn.f r12 = (dn.f) this.f18339b;
        r5.append(r12.d);
        r5.append(",with reason:");
        r5.append(r11.getMessage());
        LynxLog.b(4, "LynxImageManager", r5.toString());
        int r13 = mh.e.a(r10);
        String r14 = r11.getMessage();
        if (TextUtils.isEmpty(r14) == false) goto L9;
        r14 = Log.getStackTraceString(r11);
        if (r14 == null) goto L9;
        if (r14.length() <= 200) goto L9;
        r14 = r14.substring(0, 200);
    L9:
        LynxError r15 = new LynxError(r13, "Android LynxImageManager loading image failed", "", "error");
        r15.g = null;
        r15.f10000o = r14;
        r12.h(r15, r13, r10);
    }

    public void h(kotlinx.metadata.internal.protobuf.e r5) {
        if (r5.h() == false) goto L30;
        int r10 = r5.size();
        int[] r11 = f0.f19163h;
        int r12 = Arrays.binarySearch(r11, r10);
        if (r12 >= 0) goto L7;
        r12 = (-(r12 + 1)) - 1;
    L7:
        int r13 = r11[r12 + 1];
        Stack r14 = (Stack) this.f18339b;
        if (r14.isEmpty() == false) goto L10;
    L28:
        r14.push(r5);
        return;
    L10:
        if (((kotlinx.metadata.internal.protobuf.e) r14.peek()).size() >= r13) goto L28;
        int r15 = r11[r12];
        kotlinx.metadata.internal.protobuf.e r16 = (kotlinx.metadata.internal.protobuf.e) r14.pop();
    L14:
        if (r14.isEmpty() == true) goto L18;
        if (((kotlinx.metadata.internal.protobuf.e) r14.peek()).size() >= r15) goto L18;
        r16 = new f0((kotlinx.metadata.internal.protobuf.e) r14.pop(), r16);
    L18:
        f0 r17 = new f0(r16, r5);
    L20:
        if (r14.isEmpty() == true) goto L27;
        int[] r18 = f0.f19163h;
        int r19 = Arrays.binarySearch(r18, r17.f19164b);
        if (r19 >= 0) goto L25;
        r19 = (-(r19 + 1)) - 1;
    L25:
        if (((kotlinx.metadata.internal.protobuf.e) r14.peek()).size() >= r18[r19 + 1]) goto L27;
        r17 = new f0((kotlinx.metadata.internal.protobuf.e) r14.pop(), r17);
    L27:
        r14.push(r17);
        return;
    L30:
        if ((r5 instanceof f0) == false) goto L33;
        f0 r20 = (f0) r5;
        h(r20.f19165c);
        h(r20.d);
        return;
    L33:
        String r21 = String.valueOf(r5.getClass());
        throw new IllegalArgumentException(j0.q(new StringBuilder(r21.length() + 49), "Has a new type of ByteString been created? Found ", r21));
    }

    @Override // com.lynx.tasm.ui.image.y
    public void i(CloseableReference r5) {
        CloseableReference r10 = ((v0) this.f18339b).f11137x;
        Bitmap r11 = null;
        if (r10 == null) goto L5;
        r10.close();
        ((v0) this.f18339b).f11137x = null;
    L5:
        v0 r12 = (v0) this.f18339b;
        r12.f11137x = r5.clone();
        v0 r13 = (v0) this.f18339b;
        if (r13.f11132r == null) goto L26;
        CloseableReference r14 = r13.f11137x;
        if (r14 == null) goto L26;
        monitor-enter(r14);
        Object r15 = r14.f7671b.d();     // Catch: Throwable -> L23
        monitor-exit(r14);     // Catch: Throwable -> L23
        if ((r15 instanceof CloseableBitmap) == false) goto L16;
        r11 = ((CloseableStaticBitmap) ((CloseableBitmap) r15)).g;
    L18:
        if (r11 != null) goto L20;
    L22:
        LynxLog.b(4, "LynxImageManager", "onLocalCacheGet error bitmap is null or recycled");
        goto L26
    L20:
        if (r11.isRecycled() == true) goto L22;
        ((v0) this.f18339b).f11132r.d(r11.getWidth(), r11.getHeight());
        goto L26
    L16:
        if ((r15 instanceof Bitmap) == false) goto L18;
        r11 = (Bitmap) r15;
    L23:
        th = move-exception;
        throw th;
    L26:
        v0 r16 = (v0) this.f18339b;
        r16.f11130p.onCloseableRefReady(r16.f11137x);
    }

    @Override // com.lynx.tasm.ui.image.y
    public ImageRequestBuilder j(Uri r5) {
        a0 r10 = ((v0) this.f18339b).E;
        Bitmap.Config r11 = r10.f11012o;
        boolean r12 = r10.R;
        ImageRequestBuilder r13 = ImageRequestBuilder.a(r5);
        oo.g.b(r13, r11, r12);
        HashMap r14 = r10.E;
        if (r14.isEmpty() == true) goto L5;
        oo.g.c(r13, r14);
    L5:
        return r13;
    }

    public JSONObject k() {
        JSONObject r5 = new JSONObject();
        int r10 = 0;
    L3:
        CopyOnWriteArrayList r11 = (CopyOnWriteArrayList) this.f18339b;
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r5;
    L5:
        if (r10 >= r11.size()) goto L14;
        ((BinderMonitor) ((b) r11.get(r10))).getClass();     // Catch: Exception -> L12
        Pair r12 = null;
        r12 = new Pair(null, BinderMonitor.f6945a.toString());     // Catch: Throwable -> L15
    L10:
        r5.put((String) r12.first, r12.second);     // Catch: Exception -> L12
        r10 = r10 + 1;
        goto L3
    }

    @Override // kotlin.collections.Grouping
    public Object keyOf(Object r5) {
        return ((com.bytedance.android.anniex.scene.core.k) r5).f3410a;
    }

    public JSONObject l(long r11, long r13) {
        JSONObject r5 = new JSONObject();
        int r10 = 0;
    L3:
        CopyOnWriteArrayList r12 = (CopyOnWriteArrayList) this.f18339b;
        if (r10 >= r12.size()) goto L22;
        ((BinderMonitor) ((b) r12.get(r10))).getClass();     // Catch: Exception -> L24
        Pair r14 = null;
        ArrayList r15 = BinderMonitor.a();     // Catch: Throwable -> L23
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L23
        int r17 = r15.size() - 1;     // Catch: Throwable -> L23
    L8:
        if (r17 < 0) goto L19;
        c r18 = (c) r15.get(r17);     // Catch: Throwable -> L23
        if (r18.f18322a <= r13) goto L12;
    L13:
        r16.add(r18);     // Catch: Throwable -> L23
    L15:
        if (r18.f18323b < r11) goto L19;
        r17 = r17 - 1;     // Catch: Throwable -> L23
        goto L8
    L12:
        if (r18.f18323b <= r11) goto L15;
    L19:
        r14 = new Pair(null, r16.toString());     // Catch: Throwable -> L23
    L20:
        r5.put((String) r14.first, r14.second);     // Catch: Exception -> L24
    L21:
        r10 = r10 + 1;
        goto L3
    L22:
        return r5;
    }

    @Override // kotlin.collections.Grouping
    public Iterator sourceIterator() {
        return ((HashSet) this.f18339b).iterator();
    }

    public k(LynxResourceLoader r5, String r10, long r11) {
        this.f18338a = 11;
        this.f18339b = new nn.b(r5, r10, r11);
    }

    @Override // com.lynx.tasm.ui.image.y
    public boolean d() {
        return ((v0) this.f18339b).A;
    }

    @Override // com.lynx.tasm.ui.image.y
    public void b() {
        switch(this.f18338a) {
            case 6: goto L8;
            default: goto L5;
        };
    L8:
        v0 r5 = (v0) this.f18339b;
        CloseableReference r10 = r5.f11137x;
        if (r10 == null) goto L13;
        r10.close();
        r5.f11137x = null;
        return;
    L13:
        return;
    L5:
        if (g8.e.f17067b.get() == false) goto L12;
        com.lynx.tasm.behavior.utils.d.e(2, (Application) this.f18339b);
        return;
    }

    @Override // xp.a
    public void c(Surface r5) {
        Intrinsics.checkNotNullParameter(r5, "surface");
        AlphaVideoGLSurfaceView r10 = (AlphaVideoGLSurfaceView) this.f18339b;
        Surface r11 = r10.getMSurface();
        if (r11 == null) goto L5;
        r11.release();
    L5:
        r10.setMSurface(r5);
        r10.getClass();
        up.a r12 = r10.getMPlayerController();
        if (r12 == null) goto L8;
        Intrinsics.checkNotNullParameter(r5, "surface");
        ((PlayerController) r12).f(PlayerController.c(8, r5));
    L8:
        up.a r13 = r10.getMPlayerController();
        if (r13 == null) goto L12;
        ((PlayerController) r13).f(PlayerController.c(5, null));
        return;
    }

    public k(int r5) {
        this.f18338a = r5;
        switch(r5) {
            case 1: goto L12;
            case 2: goto L10;
            case 5: goto L8;
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        this.f18339b = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new j(this));
        return;
    L6:
        this.f18339b = new Stack();
        return;
    L8:
        this.f18339b = "";
        return;
    L10:
        this.f18339b = new HashMap();
        new HashMap();
        return;
    L12:
        this.f18339b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ies.bullet.service.base.g
    public void a(Object r5, String r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        JSONObject r12 = new JSONObject();
        if (r5 != null) goto L5;
    L7:
        r5 = r12;
    L8:
        com.bytedance.ies.bullet.kit.web.impl.i r13 = (com.bytedance.ies.bullet.kit.web.impl.i) this.f18339b;
        if (r13.f5526i == false) goto L19;
        com.bytedance.sdk.xbridge.cn.platform.web.b r14 = r13.f5527j;
        if (r14 == null) goto L24;
        JSONObject r15 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r10, "name");
        if (((s6.c) ki.a.d.f5321c) == null) goto L15;
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r14.f7413n, "context");
    L15:
        Iterator r16 = r14.f7414o.iterator();
    L17:
        if (r16.hasNext() == false) goto L26;
        ((com.bytedance.sdk.xbridge.cn.platform.web.e) r16.next()).f(r10, r15);
        goto L17
    L26:
        return;
    L24:
        return;
    L19:
        com.bytedance.ies.bullet.kit.web.jsbridge.d r17 = r13.f5525h;
        if (r17 == null) goto L25;
        r17.b(r10, (JSONObject) r5);
        return;
    L25:
        return;
    L5:
        if ((r5 instanceof JSONObject) == false) goto L7;
        goto L7
    }

    @Override // com.lynx.tasm.ui.image.y
    public void e() {
        v0 r5 = (v0) this.f18339b;
        r5.b(r5.e, r5.f, r5.s, r5.f11134u, r5.f11133t, r5.f11135v);
    }
}
