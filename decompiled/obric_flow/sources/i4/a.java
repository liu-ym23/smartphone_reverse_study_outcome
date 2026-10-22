package i4;

import ai.j0;
import ai.q0;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import bi.e;
import cj.d;
import com.bumptech.glide.load.engine.d0;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.apm.impl.RetrofitMonitorService;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.c;
import com.bytedance.crash.n;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.UISvg;
import com.lynx.tasm.b0;
import com.lynx.tasm.ui.image.h;
import fi.i;
import fi.k;
import g8.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import ko.r;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l9.p;
import m1.j;
import oj.f;
import org.json.JSONObject;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.logger.Level;
import pt.b;
import pt.o;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b, j0.a, la.a, f, d {
    public static String e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f17502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17503c;
    public Object d;

    public /* synthetic */ a(Object r5, int r10, Object r11, Object r12) {
        this.f17501a = r10;
        this.f17502b = r5;
        this.f17503c = r11;
        this.d = r12;
    }

    public static HashMap j(Map r5, String... r10) {
        HashMap r11 = new HashMap();
        if (r10.length != 0) goto L5;
    L16:
        m.b r12 = c.f4025a;
        IllegalArgumentException r13 = new IllegalArgumentException("err keysWithDefaultValue:" + r10);
        r12.getClass();
        m.b.h("NPTH_CATCH", r13);
        return r11;
    L5:
        if ((r10.length % 2) != 0) goto L16;
        int r14 = 0;
    L9:
        if (r14 >= r10.length) goto L15;
        String r15 = r10[r14];
        Object r16 = r5.get(r15);
        if (r16 != null) goto L13;
        r11.put(r15, r10[r14 + 1]);
    L14:
        r14 = r14 + 2;
        goto L9
    L13:
        r11.put(r15, String.valueOf(r16));
        goto L14
    L15:
        return r11;
    }

    public static void p(a r5, ComponentName r10) {
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (((Messenger) r5.f17503c) != null) goto L26;
        r5.m(r10);     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L26:
        if (((LinkedBlockingDeque) r5.d).peek() == null) goto L21;
        m8.b r11 = (m8.b) ((LinkedBlockingDeque) r5.d).poll();     // Catch: Throwable -> L25
        if (r11 == null) goto L21;
        Message r12 = new Message();     // Catch: Throwable -> L25
        r12.what = r11.f20020a;     // Catch: Throwable -> L25
        r12.getData().putParcelable(null, null);     // Catch: Throwable -> L25
        r5.n(r12);     // Catch: Throwable -> L18 DeadObjectException -> L20
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
    L20:
        r5.f17503c = null;     // Catch: Throwable -> L25
        ((LinkedBlockingDeque) r5.d).offerFirst(r11);     // Catch: Throwable -> L25
    L21:
        monitor-exit(r5);
    }

    public static boolean s() {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        android.support.v4.media.c r10 = fj.a.f16916b;     // Catch: Throwable -> L7
        if (r10 == null) goto L9;
        com.bytedance.android.monitorV2.settings.d r11 = (com.bytedance.android.monitorV2.settings.d) r10.e(com.bytedance.android.monitorV2.settings.d.class);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        boolean r12 = r11.a();     // Catch: Throwable -> L7
    L10:
        Object r13 = Result.m124constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L7
    L13:
        Boolean r14 = Boolean.TRUE;
        if (Result.m130isFailureimpl(r13) == false) goto L17;
        r13 = r14;
    L17:
        return ((Boolean) r13).booleanValue();
    L9:
        r12 = true;
    L7:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static void x(a r10, boolean r11, String r12, org.koin.core.instance.c r13) {
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "mapping");
        Intrinsics.checkNotNullParameter(r13, "factory");
        ConcurrentHashMap r5 = (ConcurrentHashMap) r10.d;
        boolean r14 = r5.containsKey(r12);
        org.koin.core.a r15 = (org.koin.core.a) r10.f17502b;
        if (r14 == false) goto L8;
        if (r11 == false) goto L6;
        um.a r16 = r15.f21001c;
        StringBuilder r17 = j0.x("(+) override index '", r12, "' -> '");
        r17.append(r13.f21015a);
        r17.append('\'');
        String r18 = r17.toString();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r18, "msg");
        r16.s(Level.WARNING, r18);
        goto L8
    L6:
        Intrinsics.checkNotNullParameter(r13, "factory");
        Intrinsics.checkNotNullParameter(r12, "mapping");
        throw new DefinitionOverrideException("Already existing definition for " + r13.f21015a + " at " + r12);
    L8:
        um.a r19 = r15.f21001c;
        StringBuilder r20 = j0.x("(+) index '", r12, "' -> '");
        r20.append(r13.f21015a);
        r20.append('\'');
        r19.o(r20.toString());
        r5.put(r12, r13);
    }

    @Override // la.a
    public synchronized long a(long r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (((AtomicBoolean) this.f17503c).get() == true) goto L19;
        int r10 = (int) r5;     // Catch: Throwable -> L10
        if (r10 != r5) goto L17;
        RandomAccessFile r11 = (RandomAccessFile) this.f17502b;     // Catch: Throwable -> L10
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");     // Catch: Throwable -> L10
    L13:
        long r12 = r11.skipBytes(r10);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L17:
        throw new IOException("too large:" + r5);     // Catch: Throwable -> L10
    L19:
        throw new IOException("released!");     // Catch: Throwable -> L10
    }

    @Override // pt.b
    public void accept(Object r5, Object r10) {
        Map r11 = (Map) r5;
        Object r12 = ((o) this.d).apply(r10);
        Collection r13 = (Collection) r11.get(r12);
        if (r13 != null) goto L5;
        r13 = (Collection) ((o) this.f17502b).apply(r12);
        r11.put(r12, r13);
    L5:
        r13.add(((o) this.f17503c).apply(r10));
    }

    @Override // cj.e
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String mo117b() {
        return (String) this.f17503c;
    }

    @Override // la.a
    public long c() {
        if (((AtomicBoolean) this.f17503c).get() == true) goto L10;
        RandomAccessFile r5 = (RandomAccessFile) this.f17502b;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L8:
        return r5.getFilePointer();
    L10:
        throw new IOException("released!");
    }

    @Override // la.a
    public void d() {
        if (((AtomicBoolean) this.f17503c).get() == true) goto L6;
        return;
    L6:
        throw new IOException("released!");
    }

    @Override // la.a
    public void e() {
        release();
        ((File) this.d).delete();
    }

    @Override // oj.f
    public void f(String r5, HashMap r10) {
        ((HashMap) this.d).put("params.txt", new n6.a(r5, r10));
    }

    @Override // la.a
    /* JADX INFO: renamed from: finish, reason: collision with other method in class */
    public void mo119finish() {
    }

    @Override // la.a
    public void g(long r5) {
        if (((AtomicBoolean) this.f17503c).get() == true) goto L13;
        if (r5 >= 0) goto L7;
        r5 = 0;
    L7:
        RandomAccessFile r10 = (RandomAccessFile) this.f17502b;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L10:
        r10.seek(r5);
        return;
    L13:
        throw new IOException("released!");
    }

    @Override // oj.f
    public void h(String r5, String r10) {
        HashMap r11 = (HashMap) this.d;
        r11.put(r5, new k("text/plain; charset=UTF-8", r10.getBytes("UTF-8"), new String[0]));
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public String i() {
        boolean r5 = n.f4074w;
        ICommonParams r10 = (ICommonParams) this.f17503c;
        if (r5 == true) goto L5;
        return String.valueOf(r10.getCommonParams().get(WsConstants.KEY_APP_ID));
    L12:
        return "4444";
    L5:
        if (TextUtils.isEmpty(e) == false) goto L7;
        String r11 = String.valueOf(r10.getCommonParams().get(WsConstants.KEY_APP_ID));
        e = r11;
        return r11;
    L7:
        return e;
    }

    public void k() {
        HashMap r5 = (HashMap) this.d;
        Iterator r10 = r5.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        ((Bitmap) ((Map.Entry) r10.next()).getValue()).recycle();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        Log.e("lynx_SvgResourceManager", th.toString());
        goto L4
    L10:
        r5.clear();
    }

    public void l(Application r5, int r10) {
        if (r5 == null) goto L25;
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > 3) goto L27;
        WeakReference r11 = (WeakReference) this.f17502b;
        if (r11 != null) goto L10;
    L11:
        this.f17502b = new WeakReference(r5.getApplicationContext());
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("WsChannelSdk", com.lynx.jsbridge.a.d(r10, "sendAppState appState = "));
    L16:
        if (((c5.a) g.d(r5).f17073b).b(WsConstants.KEY_FRONTIER_ENABLED, true) == false) goto L28;
        ComponentName r12 = new ComponentName(r5, WsChannelService.class);     // Catch: Throwable -> L20
        Intent r13 = new Intent(WsConstants.APP_STATE_ACTION);     // Catch: Throwable -> L20
        r13.setComponent(r12);     // Catch: Throwable -> L20
        r13.putExtra(WsConstants.KEY_APP_STATE, r10);     // Catch: Throwable -> L20
        r5.startService(r13);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L28:
        return;
    L10:
        if (r11.get() != null) goto L13;
    L27:
        return;
    }

    @Override // la.a
    public long length() {
        RandomAccessFile r5 = (RandomAccessFile) this.f17502b;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L6:
        return r5.length();
    }

    public void m(ComponentName r5) {
        WeakReference r10 = (WeakReference) this.f17502b;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.get() == null) goto L22;
        Context r11 = (Context) r10.get();
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelSdk", "doBindService");
    L17:
        Intent r12 = new Intent();     // Catch: Throwable -> L16
        r12.setComponent(r5);     // Catch: Throwable -> L16
        r11.startService(r12);     // Catch: Throwable -> L16
    L19:
        Intent r13 = new Intent();     // Catch: Throwable -> L13
        r13.setComponent(r5);     // Catch: Throwable -> L13
        r11.bindService(r13, new m8.c(this, 0), 1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void n(Message r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r5.toString() + " , + what = " + r5.what);
    L5:
        Messenger r10 = (Messenger) this.f17503c;
        if (r10 != null) goto L8;
        return;
    L8:
        r10.send(r5);
    }

    public void o(com.bytedance.android.monitorV2.event.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (s() == true) goto L5;
        return;
    L5:
        if (((AtomicBoolean) this.d).get() == true) goto L7;
        return;
    L7:
        if (((List) this.f17502b).contains(r5.f3557a) == false) goto L31;
        String r10 = r5.f3557a;
        t4.a r11 = r5.f3550m;
        if (r11 == null) goto L29;
        JSONObject r12 = r11.s();
        u4.b r13 = (u4.b) ((HashMap) this.f17503c).get(r10);
        if (r13 == null) goto L30;
        Intrinsics.checkNotNullParameter(r12, "nativeInfo");
        Object r14 = r13.e;
        monitor-enter(r14);
        r r15 = new r(r12);     // Catch: Throwable -> L22
        if (r13.d(r15) == true) goto L19;
        monitor-exit(r14);
        return;
    L19:
        r13.e(r15);     // Catch: Throwable -> L22
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r14);
        return;
    L22:
        th = move-exception;
        throw th;
    L30:
        return;
    L29:
        return;
    }

    public void q(String r5, long r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "result");
        Intrinsics.checkNotNullParameter(r5, "hybridType");
        if (s() == true) goto L5;
        return;
    L5:
        if (((AtomicBoolean) this.d).get() == false) goto L40;
        ((AtomicBoolean) this.d).compareAndSet(true, false);
        qo.a.k("fmp_end", r10, r11);
        Iterator r12 = ((List) this.f17502b).iterator();
    L9:
        if (r12.hasNext() == false) goto L41;
        u4.b r13 = (u4.b) ((HashMap) this.f17503c).get((String) r12.next());
        if (r13 == null) goto L9;
        Intrinsics.checkNotNullParameter(r11, "result");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L18
        Object r15 = r13.e;     // Catch: Throwable -> L18
        monitor-enter(r15);     // Catch: Throwable -> L18
        CollectionsKt.sort(r13.d);     // Catch: Throwable -> L20
        r13.b(r10, r11);     // Catch: Throwable -> L20
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r15);     // Catch: Throwable -> L18
        Object r17 = Result.m124constructorimpl(r16);     // Catch: Throwable -> L18
    L24:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L9;
        d5.b.e("PerfMixHandler", "result error: " + r18.getMessage());
        goto L9
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L24
    L41:
        return;
    }

    public void r(String r10, lm.d r11) {
        HashMap r5 = (HashMap) this.d;
        if (r5.containsKey(r10) == false) goto L6;
        LynxLog.b(1, "UISVG", "requestBitmapSync got from bitmap cache ");
        r11.a((Bitmap) r5.get(r10));
        return;
    L6:
        ImageRequestBuilder r12 = ImageRequestBuilder.a(Uri.parse(dn.a.J((b0) this.f17503c, false, r10)));
        Method r13 = oo.g.f20803a;
        oo.g.b(r12, Bitmap.Config.ARGB_8888, false);
        ImageRequest r14 = r12.a();
        AbstractDataSource r15 = Fresco.a().e().a(r14, "lynx_SvgResourceManager", ImageRequest.RequestLevel.f8431b, null);
        r15.a(new lm.c(this, r15, r10, r11), UiThreadImmediateExecutorService.b());
    }

    @Override // la.a
    public void release() {
        if (((AtomicBoolean) this.f17503c).getAndSet(true) == false) goto L5;
        return;
    L5:
        RandomAccessFile r5 = (RandomAccessFile) this.f17502b;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L8:
        com.bytedance.geckox.utils.d.c(r5);
    }

    public void t(ia.b r5) {
        ((CopyOnWriteArraySet) this.d).add(r5);     // Catch: Throwable -> L4
        ((ia.f) this.f17502b).a((h) this.f17503c);     // Catch: Throwable -> L4
        ia.f r10 = (ia.f) this.f17502b;     // Catch: Throwable -> L4
        h r11 = (h) this.f17503c;     // Catch: Throwable -> L4
        r10.b(Message.obtain(r10.d, r11), 30000);     // Catch: Throwable -> L4
        return;
    }

    public Map u() {
        Map r5 = v();
        Object r10 = r5.get(WsConstants.KEY_APP_ID);
        if (r10 == null) goto L5;
        String r11 = String.valueOf(r10);
    L6:
        if (r11 != null) goto L8;
        r5.put(WsConstants.KEY_APP_ID, 4444);
    L8:
        return r5;
    L5:
        r11 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Map] */
    public Map v() {
        ICommonParams r5 = (ICommonParams) this.d;     // Catch: Throwable -> L7
        if (r5 == null) goto L9;
        Map<String, Object> r10 = r5.getCommonParams();     // Catch: Throwable -> L7
    L6:
        ?? r11 = r10;
        r11.putAll(((ICommonParams) this.f17503c).getCommonParams());     // Catch: Throwable -> L13
        th = null;
    L15:
        if (r11 != 0) goto L21;
        r11 = new HashMap(4);
        if (th != null) goto L149;
        r11.put("params_err", "empty params");
        goto L21
    L149:
        r11.put("err_info", com.bytedance.crash.util.h.a(th));     // Catch: Throwable -> L126
        r11.put("params_err", "crash while getting params");     // Catch: Throwable -> L126
    L21:
        boolean r12 = r11.isEmpty();
        Context r13 = (Context) this.f17502b;
        if (r12 == false) goto L24;
    L139:
        PackageInfo r14 = r13.getPackageManager().getPackageInfo(r13.getPackageName(), 128);     // Catch: Throwable -> L48
        r11.put("version_name", r14.versionName);     // Catch: Throwable -> L48
        r11.put("version_code", Integer.valueOf(r14.versionCode));     // Catch: Throwable -> L48
        if (r11.get("update_version_code") != null) goto L70;
        Bundle r15 = r14.applicationInfo.metaData;     // Catch: Throwable -> L48
        if (r15 == null) goto L43;
        Object r16 = r15.get("UPDATE_VERSION_CODE");     // Catch: Throwable -> L48
    L44:
        if (r16 != null) goto L46;
        r16 = r11.get("version_code");     // Catch: Throwable -> L48
    L46:
        r11.put("update_version_code", r16);     // Catch: Throwable -> L48
        goto L70
    L43:
        r16 = null;
    L70:
        if (r11.containsKey("params_err") == true) goto L72;
        r11.put("params_err", "unavailable params");
    L72:
        r11.putAll(com.lynx.tasm.base.a.g());
        String r17 = String.valueOf(r11.get("update_version_code"));
        com.bytedance.ies.argus.bean.b r18 = com.bytedance.ies.argus.bean.b.a();
        int r19 = r18.f5125b;
        if (r19 != (-1)) goto L124;
        File r20 = (File) r18.f5126c;
        if (((File[]) r18.f5127h) != null) goto L80;
        File[] r21 = r20.listFiles(new p(1));
        r18.f5127h = r21;
        if (r21 != null) goto L80;
        r18.f5127h = new File[0];
    L80:
        File[] r22 = (File[]) r18.f5127h;
        if (r22 != null) goto L83;
    L123:
        r18.f5125b = 2;
    L99:
        r19 = 2;
        goto L124
    L83:
        if (r22.length == 0) goto L123;
        int r23 = r22.length;
        long r24 = -1;
        File r110 = null;
        int r111 = 0;
    L87:
        if (r111 >= r23) goto L97;
        File r112 = r22[r111];
        long r113 = Long.parseLong(r112.getName().split("-|\\.")[1]);     // Catch: Throwable -> L94
        if (r113 <= r24) goto L96;
        r24 = r113;
    L93:
        r110 = r112;
    L96:
        r111 = r111 + 1;
    L94:
        if (r110 != null) goto L96;
    L97:
        if (r110 != null) goto L132;
        r18.f5125b = 2;
        goto L99
    L132:
        String[] r25 = r110.getName().split("-|\\.");     // Catch: Throwable -> L109
        Long.parseLong(r25[0]);     // Catch: Throwable -> L109
        Long.parseLong(r25[1]);     // Catch: Throwable -> L109
        JSONObject r26 = new JSONObject(cl.a.D(r110.getAbsolutePath()));     // Catch: Throwable -> L103
    L104:
        if (r26 != null) goto L107;
        r26 = new JSONObject();     // Catch: Throwable -> L109
    L107:
        if (r26.optJSONObject("header") == null) goto L111;
        Object r27 = r26.optJSONObject("header").opt("update_version_code");     // Catch: Throwable -> L109
    L112:
        if (r27 != null) goto L114;
        String r28 = null;
    L116:
        if (TextUtils.isEmpty(r28) == false) goto L118;
    L122:
        r18.f5125b = 0;
        r19 = 0;
        goto L124
    L118:
        if (TextUtils.equals(r17, r28) == true) goto L122;
        r18.f5125b = 1;     // Catch: Throwable -> L109
        r19 = 1;
        goto L124
    L114:
        r28 = String.valueOf(r27);     // Catch: Throwable -> L109
        goto L116
    L111:
        r27 = null;
    L103:
        r26 = null;
    L109:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
    L124:
        r11.put("first_update_launch", Integer.valueOf(r19));
        return r11;
    L48:
        Class r29 = m.c(r13);
        if (m.f23306c != null) goto L52;
        if (r29 == null) goto L52;
        m.f23306c = r29.getDeclaredField("VERSION_NAME");     // Catch: NoSuchFieldException -> L128
    L52:
        Field r30 = m.f23306c;
        if (r30 != null) goto L134;
    L56:
        String r31 = "";
    L57:
        r11.put("version_name", r31);
        Class r32 = m.c(r13);
        if (m.d != null) goto L61;
        if (r32 == null) goto L61;
        m.d = r32.getDeclaredField("VERSION_CODE");     // Catch: NoSuchFieldException -> L129
    L61:
        Field r33 = m.d;
        if (r33 != null) goto L141;
    L65:
        int r34 = -1;
    L66:
        r11.put("version_code", Integer.valueOf(r34));
        if (r11.get("update_version_code") != null) goto L70;
        r11.put("update_version_code", r11.get("version_code"));
        goto L70
    L141:
        r34 = ((Integer) r33.get(null)).intValue();     // Catch: Throwable -> L130
    L134:
        r31 = String.valueOf(r30.get(null));     // Catch: Throwable -> L131
    L24:
        if (r11.containsKey("app_version") == true) goto L28;
        if (r11.containsKey("version_name") == false) goto L139;
    L28:
        if (r11.containsKey("version_code") == false) goto L139;
        if (r11.containsKey("update_version_code") == false) goto L139;
        String r35 = r13.getPackageManager().getPackageInfo(r13.getPackageName(), 128).versionName;     // Catch: Throwable -> L127
        String r36 = (String) Class.forName(r13.getPackageName() + ".BuildConfig").getDeclaredField("VERSION_NAME").get(null);     // Catch: Throwable -> L127
        if (r35 == null) goto L72;
        if (r35.equals(r36) == true) goto L72;
        r11.put("manifest_version", r35);     // Catch: Throwable -> L127
    L13:
        th = th;
        goto L15
    L9:
        r10 = new HashMap();     // Catch: Throwable -> L7
    L7:
        th = th;
        r11 = 0;
        goto L15
    }

    public void w(Runnable r5) {
        ia.f r10 = (ia.f) this.f17502b;
        r10.b(Message.obtain(r10.d, r5), 0);
    }

    @Override // la.a
    public void write(int r5) {
        write(new byte[]{(byte) r5}, 0, 1);
    }

    public a(int r5) {
        this.f17501a = r5;
        switch(r5) {
            case 2: goto L22;
            case 3: goto L20;
            case 9: goto L18;
            case 10: goto L16;
            case 12: goto L14;
            case 13: goto L12;
            case 19: goto L10;
            case 22: goto L8;
            case 23: goto L7;
            default: goto L4;
        };
    L4:
        this.f17502b = new LinkedHashMap();
        this.f17503c = new LinkedHashMap();
        this.d = new ConcurrentHashMap();
        return;
    L8:
        this.f17502b = new ug.d(11);
        this.f17503c = new ArrayList();
        this.d = new ArrayList();
        return;
    L10:
        this.d = new ConcurrentHashMap();
        this.f17502b = new ConcurrentHashMap();
        this.f17503c = new ConcurrentHashMap();
        return;
    L12:
        this.d = new LinkedBlockingDeque();
        return;
    L14:
        this.f17502b = new int[]{-1, -1, -1, -1, -1, -1};
        return;
    L16:
        ReentrantReadWriteLock r10 = new ReentrantReadWriteLock();
        this.f17502b = r10.writeLock();
        this.f17503c = r10.readLock();
        com.airbnb.lottie.parser.moshi.c r11 = new com.airbnb.lottie.parser.moshi.c();
        r11.d = new lh.a[8192];
        r11.f1313a = 0;
        r11.f1314b = 0;
        r11.f1315c = 0;
        this.d = r11;
        return;
    L18:
        this.f17502b = new JSONObject();
        this.f17503c = new JSONObject();
        this.d = "crash_upload_size";
        return;
    L20:
        this.f17503c = new h(this, 23);
        this.d = new CopyOnWriteArraySet();
        ia.f r12 = new ia.f("LogSendManager-Thread");
        this.f17502b = r12;
        r12.f17560a.start();
        return;
    L22:
        this.f17503c = new h(this, 22);
        this.d = new CopyOnWriteArraySet();
        ia.f r13 = new ia.f("AsyncEventManager-Thread");
        this.f17502b = r13;
        r13.f17560a.start();
        return;
    }

    @Override // la.a
    public File b() {
        return (File) this.d;
    }

    @Override // oj.f
    public oj.b finish() {
        HashMap r5 = (HashMap) this.d;
        Map r10 = (Map) this.f17503c;
        String r11 = (String) this.f17502b;
        RetrofitMonitorService r12 = (RetrofitMonitorService) com.bytedance.ttnet.utils.d.c(RetrofitMonitorService.class, r11);
        HashMap r13 = new HashMap();
        q0 r14 = r12.uploadFiles(r11, r5, DefaultTTNetImpl.convertHeaderMap(r10)).execute();     // Catch: Throwable -> L11
        Object r15 = r14.f291b;     // Catch: Throwable -> L11
        e r16 = r14.f290a;
        byte[] r17 = DefaultTTNetImpl.toByteArray(((i) r15).c());     // Catch: Throwable -> L11
        List r18 = (List) r16.d;     // Catch: Throwable -> L11
        if (wn.f.j(r18) == true) goto L13;
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L11
    L9:
        if (r19.hasNext() == false) goto L13;
        bi.c r20 = (bi.c) r19.next();     // Catch: Throwable -> L11
        r13.put(r20.f915a, r20.f916b);     // Catch: Throwable -> L11
    L13:
        int r21 = r16.f930b;     // Catch: Throwable -> L11
    L22:
        return new oj.b(r21, r13, r17);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r22 = new JSONObject();
        r22.put("exception", th.getMessage() + ym.a.g(30, th));     // Catch: Exception -> L18
        r22.put("exception_object", th.toString());     // Catch: Exception -> L18
    L20:
        r17 = r22.toString().getBytes();
        r21 = 100001;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    @Override // la.a
    public int b(byte[] r5) {
        return c(r5, 0, r5.length);
    }

    @Override // oj.f
    public void d(File r5, String r10, HashMap r11) {
        ((HashMap) this.d).put(r10, new n6.a(r11, new fi.h(r5)));
    }

    @Override // j0.a
    public d0 e(d0 r5, z.f r10) {
        Drawable r11 = (Drawable) r5.get();
        if ((r11 instanceof BitmapDrawable) == false) goto L7;
        com.bumptech.glide.load.resource.bitmap.c r12 = com.bumptech.glide.load.resource.bitmap.c.b(((BitmapDrawable) r11).getBitmap(), (com.bumptech.glide.load.engine.bitmap_recycle.a) this.f17502b);
        return ((al.a) this.f17503c).e(r12, r10);
    L7:
        if ((r11 instanceof GifDrawable) == true) goto L9;
        return null;
    L9:
        return ((j0.c) this.d).e(r5, r10);
    }

    @Override // la.a
    public void write(byte[] r5) {
        write(r5, 0, r5.length);
    }

    @Override // cj.e
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public Activity mo118c() {
        View r5 = ((n1.a) ((n1.c) this.f17502b)).a();
        Activity r10 = null;
        if (r5 == null) goto L5;
        Context r11 = r5.getContext();
    L6:
        if (r11 == null) goto L13;
        if ((r11 instanceof Activity) == true) goto L9;
        if ((r11 instanceof ContextWrapper) == false) goto L13;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L6
    L9:
        r10 = (Activity) r11;
    L13:
        if (r10 == null) goto L15;
        return r10;
    L15:
        return s0.c.b();
    L5:
        r11 = null;
        goto L6
    }

    @Override // la.a
    public int write(byte[] r5, int r10, int r11) {
        if (((AtomicBoolean) this.f17503c).get() == true) goto L29;
        if (r5.length != 0) goto L7;
    L27:
        return 0;
    L7:
        if (r11 < 1) goto L27;
        if (r10 < 0) goto L27;
        if (r10 >= r5.length) goto L27;
        if ((r10 + r11) <= r5.length) goto L16;
        r11 = r5.length - r10;
    L16:
        monitor-enter(this);
        RandomAccessFile r12 = (RandomAccessFile) this.f17502b;     // Catch: Throwable -> L20
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");     // Catch: Throwable -> L20
    L22:
        r12.write(r5, r10, r11);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r11;
    L20:
        th = move-exception;
        throw th;
    L29:
        throw new IOException("released!");
    }

    @Override // cj.e
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public PlatformType mo116a() {
        return (PlatformType) this.d;
    }

    @Override // cj.e
    public Object a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        return ((n1.a) ((n1.c) this.f17502b)).b(r5);
    }

    @Override // la.a
    public int a() {
        switch(this.f17501a) {
            case 10: goto L9;
            default: goto L4;
        };
    L4:
        byte[] r5 = new byte[1];
        if (c(r5, 0, 1) > 0) goto L8;
        return -1;
    L8:
        return r5[0];
    L9:
        ReentrantReadWriteLock.ReadLock r10 = (ReentrantReadWriteLock.ReadLock) this.f17503c;
        r10.lock();
        int r11 = ((com.airbnb.lottie.parser.moshi.c) this.d).f1315c;     // Catch: Throwable -> L13
        r10.unlock();
        return r11;
    L13:
        th = move-exception;
        r10.unlock();
        throw th;
    }

    @Override // la.a
    public int c(byte[] r5, int r10, int r11) {
        if (((AtomicBoolean) this.f17503c).get() == true) goto L27;
        if (r11 < 1) goto L24;
        if (r10 >= 0) goto L8;
        return 0;
    L8:
        if (r10 < r5.length) goto L11;
        return 0;
    L11:
        if ((r10 + r11) <= r5.length) goto L13;
        r11 = r5.length - r10;
    L13:
        monitor-enter(this);
        RandomAccessFile r12 = (RandomAccessFile) this.f17502b;     // Catch: Throwable -> L17
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");     // Catch: Throwable -> L17
    L19:
        int r13 = r12.read(r5, r10, r11);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r13;
    L17:
        th = move-exception;
        throw th;
    L24:
        return 0;
    L27:
        throw new IOException("released!");
    }

    public a(Context r5, ICommonParams r10, a r11) {
        this.f17501a = 8;
        this.f17502b = r5;
        this.f17503c = r10;
        if (r11 != null) goto L5;
        ICommonParams r12 = null;
    L6:
        this.d = r12;
        return;
    L5:
        r12 = (ICommonParams) r11.f17503c;
        goto L6
    }

    public a(CloseableReference r5) {
        this.f17501a = 24;
        this.f17502b = r5;
        if (r5 == null) goto L11;
        monitor-enter(r5);
        Object r10 = r5.f7671b.d();     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        CloseableImage r11 = (CloseableImage) r10;
    L13:
        if ((r11 instanceof CloseableBitmap) == false) goto L15;
        this.f17503c = ((CloseableStaticBitmap) ((CloseableBitmap) r11)).g;
    L16:
        this.d = null;
        return;
    L15:
        this.f17503c = null;
    L8:
        th = move-exception;
        throw th;
    L11:
        r11 = null;
        goto L13
    }

    public a(b0 r5, UISvg r10) {
        this.f17501a = 11;
        this.f17502b = null;
        this.f17503c = r5;
        this.d = new HashMap();
        this.f17502b = new WeakReference(r10);
    }

    public a(File r11, int r12) {
        this.f17501a = r12;
        switch(r12) {
            case 14: goto L29;
            case 18: goto L27;
            default: goto L4;
        };
    L4:
        this.d = r11;
        w8.f r13 = new w8.f();
        String r5 = com.bytedance.crash.util.g.f4181a;
        File r10 = new File(r11, "header.bin");
        if (r10.exists() == true) goto L7;
    L18:
        this.f17503c = r13;
        i9.g r14 = new i9.g(r11);
        this.f17502b = r14;
        if (r13.g() == true) goto L21;
        return;
    L21:
        if (r14.e != null) goto L58;
        String r15 = com.bytedance.crash.util.g.f4181a;
        File r16 = new File(r11, "tombstone.txt");
        if (r16.exists() == false) goto L25;
        r16.renameTo(new File(r16.getAbsoluteFile() + ".old"));
    L25:
        NativeImpl.g(r11);
        r14.d(new File(r11, "tombstone.txt"));
        return;
    L58:
        return;
    L7:
        if (r10.length() == 0) goto L18;
        String r17 = NativeImpl.d(r10.getAbsolutePath());
        if (r17 == null) goto L18;
        String[] r18 = r17.split("\n");
        r13.f22816a = new HashMap();
        int r19 = r18.length;
        int r20 = 0;
    L13:
        if (r20 >= r19) goto L18;
        String[] r21 = r18[r20].split("=");
        if (r21.length != 2) goto L17;
        ((HashMap) r13.f22816a).put(r21[0], r21[1]);
    L17:
        r20 = r20 + 1;
        goto L13
    L27:
        this.f17502b = r11;
        return;
    L29:
        this.d = r11;
        this.f17503c = new AtomicBoolean(false);
        boolean r22 = r11.getParentFile().mkdirs();
        RandomAccessFile r23 = new RandomAccessFile(r11, "rw");     // Catch: Exception -> L32
    L41:
        this.f17502b = r23;
        return;
    L32:
        e = move-exception;
        boolean r24 = ((File) this.d).getParentFile().exists();
        RandomAccessFile r25 = (RandomAccessFile) this.f17502b;
        if (r25 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L36:
        com.bytedance.geckox.utils.d.c(r25);
        if ((e instanceof FileNotFoundException) == false) goto L49;
        boolean r26 = ((File) this.d).getParentFile().mkdirs();
        boolean r27 = ((File) this.d).getParentFile().exists();
        r23 = new RandomAccessFile((File) this.d, "rw");     // Catch: Exception -> L43
    L43:
        RandomAccessFile r110 = (RandomAccessFile) this.f17502b;
        if (r110 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L46:
        com.bytedance.geckox.utils.d.c(r110);
        throw new IOException("create raf mSwap failed![2 dir mk:" + r26 + ",dir exist:+" + r27 + ", dir mk:" + r22 + ",dir exist:+" + r24 + "] path: " + ((File) this.d).getAbsolutePath() + " caused by: " + e.getMessage(), e);
    L49:
        throw new IOException("create raf mSwap failed![1 dir mk:" + r22 + ",dir exist:+" + r24 + "] path: " + ((File) this.d).getAbsolutePath() + " caused by: " + e.getMessage(), e);
    }

    public a(n1.c r5, com.bytedance.sdk.xbridge.cn.platform.web.c r10) {
        this.f17501a = 17;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "bridgeCall");
        this.f17502b = r5;
        UUID.randomUUID().toString();
        j r11 = (j) ((n1.a) r5).b(j.class);
        this.f17503c = "";
        this.d = r10.K;
    }

    public a(Drawable r5, CloseableReference r10) {
        this.f17501a = 24;
        this.f17502b = r10;
        this.d = r5;
        this.f17503c = null;
    }

    public a(List r5, int r10) {
        this.f17501a = r10;
        switch(r10) {
            case 20: goto L9;
            default: goto L4;
        };
    L4:
        this.d = r5;
        this.f17502b = new ArrayList(r5.size());
        this.f17503c = new ArrayList(r5.size());
        int r11 = 0;
    L6:
        if (r11 >= r5.size()) goto L8;
        ((ArrayList) this.f17502b).add(((q.f) r5.get(r11)).f21410b.d());
        p.a r12 = ((q.f) r5.get(r11)).f21411c;
        ((ArrayList) this.f17503c).add(r12.d());
        r11 = r11 + 1;
        goto L6
    L8:
        return;
    L9:
        Intrinsics.checkNotNullParameter(r5, "mixEvents");
        this.f17502b = r5;
        this.f17503c = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("res_loader_perf_template", new u4.g()), TuplesKt.to("res_loader_perf", new u4.f(2)), TuplesKt.to("jsbPerfV2", new u4.f(1)), TuplesKt.to("jsbPerf", new u4.f(0))});
        this.d = new AtomicBoolean(true);
    }

    public a(String r5, Map r10) {
        this.f17501a = 15;
        this.d = new HashMap();
        this.f17502b = r5;
        this.f17503c = r10;
    }

    public a(org.koin.core.a r5) {
        this.f17501a = 16;
        Intrinsics.checkNotNullParameter(r5, "_koin");
        this.f17502b = r5;
        this.d = new ConcurrentHashMap();
        this.f17503c = new HashMap();
    }

    public a(android.support.v4.media.c r5) {
        this.f17501a = 21;
        this.f17501a = 21;
        this.f17502b = r5;
        this.f17503c = Choreographer.getInstance();
        this.d = new c7.e(this, 8);
    }
}
