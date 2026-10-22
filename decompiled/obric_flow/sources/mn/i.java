package mn;

import ai.j0;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import com.bumptech.glide.load.engine.d0;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.GeckoManifest;
import com.bytedance.geckox.model.GeckoMd5Check;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.google.common.reflect.w;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements e5.a, g1.e, j0.a, go.a, zp.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i f20152b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20153a;

    public /* synthetic */ i(Object r5) {
        this.f20153a = r5;
    }

    public static Pair a(String r5, String r10) {
        return new Pair(Boolean.valueOf(Pattern.compile(r5, 2).matcher(r10).find()), null);
    L5:
        e = move-exception;
        return new Pair(Boolean.FALSE, e);
    }

    public static i d() {
        if (f20152b != null) goto L16;
        monitor-enter(i.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20152b != null) goto L11;
        f20152b = new i(0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(i.class);     // Catch: Throwable -> L9
    L16:
        return f20152b;
    }

    @Override // g1.e
    public Object b(String r5, Continuation r10) {
        com.bytedance.ai.widget.cache.e r11 = (com.bytedance.ai.widget.cache.e) ((com.bytedance.ai.widget.cache.b) this.f20153a);
        r11.getClass();
        return com.bytedance.ai.widget.cache.e.e(r11, (ContinuationImpl) r10);
    }

    @Override // e5.a
    public void c(LynxView r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter("", "type");
        com.bytedance.ies.bullet.core.e r11 = (com.bytedance.ies.bullet.core.e) ((WeakReference) this.f20153a).get();
        if (r11 == null) goto L6;
        r11.f5293c.e(r11, null, Float.valueOf(r10));
        return;
    }

    @Override // j0.a
    public d0 e(d0 r5, z.f r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return new com.bumptech.glide.load.resource.bitmap.c((Resources) this.f20153a, r5);
    }

    @Override // go.a
    public void f(w r5) {
        if (((LynxResourceResponse$ResponseState) r5.f9377c) != LynxResourceResponse$ResponseState.f10948b) goto L5;
        boolean r10 = true;
    L6:
        Throwable r11 = (Throwable) r5.d;
        byte[] r12 = (byte[]) r5.f9376b;
        if (r11 == null) goto L9;
        r11.getMessage();
    L9:
        ((nn.a) this.f20153a).b(r10, r12);
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // e5.a
    public void g(LynxView r5, long r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter("", "type");
    }

    public void h() {
        PrepareMeta r10 = (PrepareMeta) this.f20153a;
        File r5 = new File(r10.getDestDir(), j0.q(new StringBuilder("res"), File.separator, "gecko_manifest.json"));
        if (r5.exists() == false) goto L59;
        InputStreamReader r11 = null;
        InputStreamReader r12 = new InputStreamReader(new FileInputStream(r5), "utf-8");     // Catch: Throwable -> L41
        StringBuffer r13 = new StringBuffer();     // Catch: Throwable -> L11
    L8:
        int r14 = r12.read();     // Catch: Throwable -> L11
        if (r14 == (-1)) goto L13;
        r13.append((char) r14);     // Catch: Throwable -> L11
        goto L8
    L13:
        String r15 = r13.toString();     // Catch: Throwable -> L11
        com.bytedance.geckox.utils.d.c(r12);
        Map<String, GeckoMd5Check> r16 = ((GeckoManifest) oa.b.f20421b.f20423a.fromJson(r15, GeckoManifest.class)).getFiles();
        if (r16 != null) goto L17;
        return;
    L17:
        if (r16.isEmpty() == true) goto L60;
        Iterator<Map.Entry<String, GeckoMd5Check>> r17 = r16.entrySet().iterator();
    L21:
        if (r17.hasNext() == false) goto L61;
        Map.Entry<String, GeckoMd5Check> r18 = r17.next();
        String r19 = r18.getKey();
        String r20 = r18.getValue().getMd5();
        if (r19.length() == 0) goto L21;
        if (r20.length() == 0) goto L21;
        File r21 = new File(r10.getDestDir(), j0.q(new StringBuilder("res"), File.separator, r19));
        if (r21.exists() == false) goto L21;
        com.bytedance.geckox.utils.d.d(r21);     // Catch: Exception -> L33
    L33:
        String r22 = MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(r21);
        if (Intrinsics.areEqual(r22, r20) == true) goto L38;
        throw new RuntimeException("md5 check failed, " + r22 + '-' + r20 + ", length: " + r21.length());
    L38:
        throw new RuntimeException("file broken, but md5 is the same, file length: " + r21.length());
    L61:
        return;
    L60:
        return;
    L11:
        th = th;
        r11 = r12;
    L42:
        com.bytedance.geckox.utils.d.c(r11);
        throw th;
    L41:
        th = th;
        goto L42
    }

    public void i(fo.e r10, fo.d r11) {
        fo.f r5 = new fo.f();
        String r12 = r10.f16961a;
        if (TextUtils.isEmpty(r12) == false) goto L6;
        r5.f16962a = "url is empty!";
        r11.d(r5);
        LynxLog.b(3, "lynx_ResManager", "url:" + r12 + " is empty!");
        return;
    L6:
        h.i().execute(new com.bytedance.apm.f(this, r12, r10, r11, r5));
    }

    public void j() {
        int r5 = 0;
        StringBuilder r10 = new StringBuilder("[");
        PrepareMeta r11 = (PrepareMeta) this.f20153a;
        r10.append(r11);
        r10.append("]start rename channel");
        GeckoLogger.a(r10.toString());
        if (r11.getUpdatingDir().renameTo(r11.getDestDir()) == false) goto L35;
        com.bytedance.geckox.c r12 = com.bytedance.geckox.b.f4736a;
        h();     // Catch: Exception -> L31
        String r13 = r11.getAccessKey();
        String r14 = r11.getChannel();
        ChannelMeta r15 = com.bytedance.iesgurd.meta.e.a(r13, r14);
        if (r15 != null) goto L9;
        r15 = new ChannelMeta();
    L9:
        r15.setId(Long.valueOf(r11.getVersion()));
        r15.setUpdateTime(Long.valueOf(System.currentTimeMillis()));
        r15.setForbidden(false);
        com.bytedance.iesgurd.meta.e.f(r13, r14, r15);
        com.bytedance.iesgurd.meta.e.d(r13, r14, r15);
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(new com.bytedance.android.anniex.scene.core.i(this, 19, r13, r14));
        String r16 = r11.getAccessKey();
        String r17 = r11.getChannel();
        String r18 = (String) df.c.d.get(r16);
        ConcurrentHashMap r19 = com.bytedance.iesgurd.meta.f.f6652a;
        com.bytedance.iesgurd.meta.f.b(Long.valueOf(r11.getVersion()), r16, r17);
        ConcurrentHashMap r20 = com.bytedance.geckox.utils.a.f4787a;
        if (r20.isEmpty() == true) goto L18;
        List r21 = (List) r20.get(r16);
        if (r21 == null) goto L18;
        if (r21.isEmpty() == true) goto L18;
        boolean r22 = r21.contains(r17);
    L19:
        if (r22 == false) goto L21;
        com.bytedance.geckox.utils.a.b(r16, r17);
    L21:
        if (r18 != null) goto L23;
    L26:
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new hf.d(r16, r17, r5));
        ConcurrentHashMap r23 = va.b.f22564a;
        if (r16.length() == 0) goto L38;
        r17.getClass();
        return;
    L38:
        return;
    L23:
        if (r18.length() == 0) goto L26;
        dn.a.L(new File(new File(r18, r16), r17).getAbsolutePath(), Long.valueOf(r11.getVersion()));
    L18:
        r22 = false;
    L31:
        e = move-exception;
        com.bytedance.geckox.utils.d.j(r11.getDestDir());
        throw new RuntimeException(androidx.room.jarjarred.org.antlr.runtime.a.o(e, new StringBuilder("check file broken failed: ")));
    L35:
        throw new RuntimeException("rename failed, exist: " + r11.getDestDir().exists() + ", path: " + r11.getDestDir().getAbsolutePath());
    }

    public short k(int r5) {
        ByteBuffer r10 = (ByteBuffer) this.f20153a;
        if ((r10.remaining() - r5) >= 2) goto L7;
        return -1;
    L7:
        return r10.getShort(r5);
    }

    public i(int r5) {
        switch(r5) {
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        this.f20153a = new LruCache(100);
        return;
    L5:
        this.f20153a = new HashMap();
    }

    public i(com.bytedance.ai.widget.cache.b r5) {
        Intrinsics.checkNotNullParameter(r5, "loader");
        this.f20153a = r5;
    }

    public i(LynxResourceLoader r5, String r10, long r11) {
        this.f20153a = new nn.a(r5, r10, r11);
    }

    public i(WeakReference r5) {
        Intrinsics.checkNotNullParameter(r5, "contextRef");
        this.f20153a = r5;
    }

    public i(byte[] r5, int r10) {
        this.f20153a = (ByteBuffer) ByteBuffer.wrap(r5).order(ByteOrder.BIG_ENDIAN).limit(r10);
    }
}
