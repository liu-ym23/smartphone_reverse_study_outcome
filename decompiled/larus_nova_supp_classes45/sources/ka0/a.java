package ka0;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.monitorV2.util.o;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.e;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a implements b {
    public final HybridCard b;

    /* JADX INFO: renamed from: ka0.a$a, reason: collision with other inner class name */
    public static final class C0243a extends b7.a {
        public final /* synthetic */ a a;

        public C0243a(a r1) {
            this.a = r1;
        }

        public final void onLoadSuccess(View r5) {
            super.onLoadSuccess(r5);
            a r0 = this.a;
            HybridCard r1 = r0.b;
            if (r1 == null) goto L5;
            IHybridComponent.HybridType r2 = r1.hybridType();
        L7:
            if (r2 != IHybridComponent.HybridType.LYNX) goto L9;
            b.a.getClass();
            int r3 = 1;
        L10:
            r0.b(r1, r5, r3);
            return;
        L9:
            b.a.getClass();
            r3 = 2;
            goto L10
        L5:
            r2 = null;
            goto L7
        }

        public final void onLoadFail(View r1, String r2, String r3) {
            super.onLoadFail(r1, r2, r3);
            a r4 = this.a;
            r4.a(r4.b, r3);
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("q20.h");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("q20.h");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    }

    @Override // ka0.b
    public final void release() {
        HybridCard r0 = this.b;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public static String e(String r5) {
        if (r5 != null) goto L12;
        return r5;
    L12:
        int r0 = e.a;     // Catch: Throwable -> L11
        Object r1 = o.b(c(), "onLynxLoad", new Object[]{UriProtector.parse(r5)});     // Catch: Throwable -> L11
        if (r1 == null) goto L14;
        String r2 = r1.toString();     // Catch: Throwable -> L11
        if (r2 != null) goto L10;
        return r5;
    L10:
        return r2;
    L14:
        return r5;
    L16:
        return r5;
    }

    @Override // ka0.b
    public final void loadUrl(String r4) {
        if (((Boolean) xa1.a.a.getValue()).booleanValue() == false) goto L7;
        HybridCard r0 = this.b;
        if (r0 == null) goto L11;
        a7.a.a(r0, e(r4), null, 2);
        return;
    L11:
        return;
    L7:
        HybridCard r1 = this.b;
        if (r1 == null) goto L13;
        a7.a.a(r1, r4, null, 2);
        return;
    }

    public final void d(String r2, Map<String, ? extends Object> r3) {
        if (((Boolean) xa1.a.a.getValue()).booleanValue() == false) goto L7;
        HybridCard r0 = this.b;
        if (r0 == null) goto L11;
        r0.load(e(r2), r3);
        return;
    L11:
        return;
    L7:
        HybridCard r1 = this.b;
        if (r1 == null) goto L13;
        r1.load(r2, r3);
        return;
    }

    @Override // ka0.b
    public final <T> void sendJsEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
        HybridCard r0 = this.b;
        if (r0 == null) goto L6;
        r0.sendJsEvent(r2, r3);
        return;
    }

    public a(Context r3, Uri r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "originUri");
        this.b = ((IBaseBrowserService) k.n(IBaseBrowserService.class)).getHybridCard(r3, r4, r5, new C0243a(this));
    }
}
