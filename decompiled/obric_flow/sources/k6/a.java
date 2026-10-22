package k6;

import ai.e;
import android.text.TextUtils;
import android.view.Surface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import com.bumptech.glide.load.resource.bitmap.h;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.SsHttpCall;
import com.lynx.tasm.ui.image.UIImage;
import com.lynx.tasm.ui.image.r;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import dn.f;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.g;
import pt.b;
import pt.o;
import xn.c;
import xn.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements e, h, r, d, b, xp.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f18622b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f18623a;

    public /* synthetic */ a(Object r5) {
        this.f18623a = r5;
    }

    public static a j() {
        if (f18622b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f18622b != null) goto L11;
        a r5 = new a();     // Catch: Throwable -> L9
        al.a r10 = new al.a();     // Catch: Throwable -> L9
        r10.f314b = new LinkedList();     // Catch: Throwable -> L9
        r10.f313a = 20;     // Catch: Throwable -> L9
        r5.f18623a = r10;     // Catch: Throwable -> L9
        f18622b = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f18622b;
    }

    @Override // com.lynx.tasm.ui.image.r
    public void a() {
        UIImage.access$600((UIImage) this.f18623a);
    }

    @Override // pt.b
    public void accept(Object r5, Object r10) {
        ((Map) r5).put(((o) this.f18623a).apply(r10), r10);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public int b() {
        int r5 = d() << 8;
        return d() | r5;
    }

    @Override // xp.a
    public void c(Surface r5) {
        Intrinsics.checkNotNullParameter(r5, "surface");
        AlphaVideoGLTextureView r10 = (AlphaVideoGLTextureView) this.f18623a;
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

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public short d() {
        ByteBuffer r5 = (ByteBuffer) this.f18623a;
        if (r5.remaining() < 1) goto L7;
        return (short) (r5.get() & UByte.MAX_VALUE);
    L7:
        throw new DefaultImageHeaderParser$Reader$EndOfFileException();
    }

    @Override // xn.d
    public void e(wn.b r5, xn.e r10, c r11) {
        String r12 = r10.f23182a;
        f r13 = (f) this.f18623a;
        xn.e r14 = r13.F;
        if (r14 == null) goto L5;
        String r15 = r14.f23182a;
    L7:
        if (TextUtils.equals(r12, r15) == true) goto L9;
        return;
    L9:
        r13.f16688k = new wn.e(r5, r13.f16691n);
        r13.f(r13.f16688k);
        r13.n();
        return;
    L5:
        r15 = null;
        goto L7
    }

    public String f() {
        Intrinsics.checkNotNullParameter("sl_monitor_hybrid_settings", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter("{}", "defaultValue");
        Keva r5 = (Keva) this.f18623a;
        if (r5 == null) goto L5;
        String r10 = r5.getString("sl_monitor_hybrid_settings", "{}");
    L6:
        if (r10 != null) goto L8;
        return "{}";
    L8:
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    @Override // xn.d
    public void g(int r5, Throwable r10) {
    }

    public void h(Exception r5) {
        h.f r10 = (h.f) this.f18623a;
        Object r11 = r10.f17267a;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r10.f17268b == true) goto L11;
        r10.f17268b = true;     // Catch: Throwable -> L9
        r10.e = r5;     // Catch: Throwable -> L9
        r10.f17267a.notifyAll();     // Catch: Throwable -> L9
        r10.f();     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public Object i(g r5) {
        kotlinx.serialization.json.internal.g r10 = kotlinx.serialization.json.internal.f.f19423a;
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Map r11 = (Map) ((ConcurrentHashMap) this.f18623a).get(r5);
        if (r11 == null) goto L5;
        Object r12 = r11.get(r10);
    L6:
        if (r12 != null) goto L9;
        return null;
    L9:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    @Override // ai.e
    public Type responseType() {
        return (Type) this.f18623a;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public long skip(long r5) {
        ByteBuffer r10 = (ByteBuffer) this.f18623a;
        int r11 = (int) Math.min(r10.remaining(), r5);
        r10.position(r10.position() + r11);
        return r11;
    }

    public a(int r5) {
        switch(r5) {
            case 5: goto L9;
            case 8: goto L7;
            case 10: goto L5;
            default: goto L3;
        };
    L3:
        this.f18623a = new com.bytedance.android.monitorV2.webview.a();
        return;
    L5:
        this.f18623a = new ConcurrentHashMap(16);
        return;
    L7:
        this.f18623a = new h.f();
        return;
    L9:
        this.f18623a = Keva.getRepo("salamander_anniex", 1);
    }

    @Override // ai.e
    public Object a(SsHttpCall r5) {
        return r5;
    }
}
