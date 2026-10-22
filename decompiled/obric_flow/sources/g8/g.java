package g8;

import ai.h0;
import ai.j0;
import ai.p;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Looper;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.android.anniex.scene.core.k;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.kit.web.impl.i;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.ui.image.FrescoImageView;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;
import ko.r;
import kotlin.collections.Grouping;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import mt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements IAppletRetrofit, Grouping, mi.c, oo.c, com.bumptech.glide.load.data.g, pt.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static g f17071c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17073b;

    public /* synthetic */ g(Object r5, int r10) {
        this.f17072a = r10;
        this.f17073b = r5;
    }

    public static g d(Context r5) {
        if (f17071c != null) goto L16;
        monitor-enter(g.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f17071c != null) goto L11;
        f17071c = new g(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L9
    L16:
        return f17071c;
    }

    @Override // oo.c
    public void a() {
        Looper r5 = Looper.myLooper();
        Looper r10 = Looper.getMainLooper();
        FrescoImageView r11 = (FrescoImageView) this.f17073b;
        if (r5 != r10) goto L6;
        r11.invalidate();
        return;
    L6:
        r11.postInvalidate();
    }

    @Override // pt.g
    public void accept(Object r5) {
        l r10 = l.a((Throwable) r5);
        ((pt.g) this.f17073b).accept(r10);
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.g
    public Object c() {
        ByteBuffer r5 = (ByteBuffer) this.f17073b;
        r5.position(0);
        return r5;
    }

    @Override // com.bytedance.ai.bridge.service.IAppletRetrofit
    public Object create(Class r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        return ((h0) this.f17073b).b(r5);
    }

    public String e() {
        c5.a r10 = (c5.a) this.f17073b;
        r10.getClass();
        Context r5 = (Context) r10.f1119c;
        if (r10.f1118b == true) goto L7;
        Cursor r11 = r5.getContentResolver().query(WsChannelMultiProcessSharedProvider.b(r5, WsConstants.KEY_WS_APPS, "string"), null, null, null, null);     // Catch: Throwable -> L21
        if (r11 == null) goto L28;
    L18:
        r11.close();
        return "";
    L12:
        if (r11.moveToFirst() == false) goto L15;
        String r12 = r11.getString(0);     // Catch: Throwable -> L18
    L25:
        r11.close();     // Catch: Exception -> L20 Throwable -> L21
    L27:
        return r12;
    L15:
        r12 = "";
        goto L25
    L28:
        return "";
    L7:
        return ((SharedPreferences) r10.d).getString(WsConstants.KEY_WS_APPS, "");
    L29:
        return "";
    }

    public void f(int r5, int r10, String r11) {
        JavaOnlyMap r12 = new JavaOnlyMap();
        if (r5 == 0) goto L5;
        r12.put("errorCode", Integer.valueOf(r10));
        r12.put("errorMsg", r11);
    L5:
        Object[] r13 = {Integer.valueOf(r5), r12};
        ((Callback) this.f17073b).invoke(r13);
    }

    public void g(String r5) {
        p r10 = new p((Context) ((c5.a) this.f17073b).f1119c);
        ((ContentValues) r10.f288c).put(WsConstants.KEY_WS_APPS, r5);
        monitor-enter(r10);
        monitor-enter(r10);     // Catch: Throwable -> L9
        ((Context) r10.f287b).getContentResolver().insert(WsChannelMultiProcessSharedProvider.b((Context) r10.f287b, STGroup.DICT_KEY, "type"), (ContentValues) r10.f288c);     // Catch: Throwable -> L12
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.collections.Grouping
    public Object keyOf(Object r5) {
        return ((k) r5).f3410a;
    }

    @Override // kotlin.collections.Grouping
    public Iterator sourceIterator() {
        return ((HashSet) this.f17073b).iterator();
    }

    public String toString() {
        switch(this.f17072a) {
            case 10: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return j0.p(new StringBuilder("<"), (String) this.f17073b, Typography.greater);
    }

    public g(int r5) {
        this.f17072a = r5;
        switch(r5) {
            case 11: goto L8;
            case 12: goto L4;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        this.f17073b = (ILynxImageService) r.g().e(ILynxImageService.class);
        return;
    L6:
        this.f17073b = new LinkedTransferQueue();
        new Thread(new jm.a(this, 19), "looper_monitor");
        return;
    L8:
        this.f17073b = new CopyOnWriteArrayList();
    }

    @Override // mi.c
    public void a(mi.a r5) {
        Intrinsics.checkNotNullParameter(r5, "reportInfo");
        com.bytedance.android.monitorV2.webview.k r10 = com.bytedance.android.monitorV2.webview.k.d;
        WebView r11 = ((i) this.f17073b).e.f6158b;
        if (r11 == null) goto L11;
        com.bytedance.ies.web.jsbridge2.l r12 = new com.bytedance.ies.web.jsbridge2.l("bdx_monitor_bridge_web_auth", 1);
        r12.f6290b = null;
        r12.f6292h = r5.f20109a;
        r12.f6293i = null;
        if (r5.f20110b == false) goto L7;
        int r13 = 2;
    L8:
        r12.b(r13);
        r10.l(r11, r12.a());
        return;
    L7:
        r13 = 0;
        goto L8
    L11:
        throw new IllegalStateException("You must call 'createWebView' or 'setWebView' first.");
    }

    public g(h0 r5) {
        this.f17072a = 2;
        Intrinsics.checkNotNullParameter(r5, "retrofit");
        this.f17073b = r5;
    }

    public g(Context r5) {
        this.f17072a = 0;
        Context r10 = r5.getApplicationContext();
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (WsChannelMultiProcessSharedProvider.f3970i != null) goto L9;
        WsChannelMultiProcessSharedProvider.f3970i = new c5.a(r10);     // Catch: Throwable -> L7
    L9:
        c5.a r11 = WsChannelMultiProcessSharedProvider.f3970i;     // Catch: Throwable -> L7
        monitor-exit(WsChannelMultiProcessSharedProvider.class);     // Catch: Throwable -> L7
        this.f17073b = r11;
    }
}
