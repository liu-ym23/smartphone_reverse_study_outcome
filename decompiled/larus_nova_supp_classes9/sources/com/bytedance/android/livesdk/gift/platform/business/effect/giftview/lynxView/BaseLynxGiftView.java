package com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.annie.util.o;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.configmodel.q1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/giftview/lynxView/BaseLynxGiftView;", "Landroid/widget/FrameLayout;", "Lzy0/b;", "a", "Lzy0/b;", "getLynxCard", "()Lzy0/b;", "setLynxCard", "(Lzy0/b;)V", "lynxCard", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseLynxGiftView extends FrameLayout {
    public zy0.b a;

    public static final class a {
    }

    static {
    }

    public BaseLynxGiftView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseLynxGiftView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        removeAllViews();
        zy0.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
    }

    public final zy0.b getLynxCard() {
        return this.a;
    }

    public final void setLynxCard(zy0.b r1) {
        this.a = r1;
    }

    public final void b(Activity r13, b r14) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "lynxViewParam");
        a();
        if (r14.e == false) goto L5;
        String r0 = r14.a + "&enable_canvas=1";
    L6:
        x0 r1 = new x0(r0);
        x0 r2 = r1.d("url");
        ReadOnlyProperty r3 = com.bytedance.android.livesdk.gift.platform.business.effect.a.L;
        KProperty[] r4 = com.bytedance.android.livesdk.gift.platform.business.effect.a.a;
        if (((q1) r3.getValue(null, r4[36])).enableSurfaceCanvas == false) goto L18;
        Map<String, String> r6 = r14.b;
        if (r6 == null) goto L11;
        String r7 = r6.get("giftId");
    L12:
        if (r7 == null) goto L18;
        List<String> r5 = ((q1) r3.getValue(null, r4[36])).surfaceCanvasWhiteGiftIdList;
        if (r5 == null) goto L18;
        if (CollectionsKt.contains(r5, r14.b.get("giftId")) != true) goto L18;
        r2.b("enable_surface_canvas", "1");
        goto L18
    L11:
        r7 = null;
    L18:
        Map<String, String> r8 = r14.b;
        if (r8 == null) goto L24;
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L22:
        if (r9.hasNext() == false) goto L24;
        Map.Entry<String, String> r10 = r9.next();
        r2.b(r10.getKey(), r10.getValue());
    L24:
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r1.a.put("url", r2);
        String r11 = r1.toString();
        if (((q1) com.bytedance.android.livesdk.gift.platform.business.effect.a.L.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[36])).enableAnnieX == true) goto L117;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r15 = f.a(c.class).J8(r13, UriProtector.parse(r11), new BaseLynxGiftView$createLynxComponentDelegateWithAnnie$1(this, r14));
    L43:
        this.a = r15;
        if (r15 != null) goto L119;
    L49:
        String r16 = r2.toString();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.t.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[18])).booleanValue() == false) goto L93;
        zy0.b r17 = this.a;
        if (r17 == null) goto L98;
        xy0.a r18 = r17.g();
        if (r18 == null) goto L98;
        if (r16 == null) goto L91;
        ConcurrentHashMap r19 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r20 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L121;
        Class<?> r21 = Class.forName("q20.h");     // Catch: Throwable -> L63
        if (r20 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L85;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L63
    L85:
        Object r23 = o.b(r21, "onLynxLoad", new Object[]{UriProtector.parse(r16)});
        if (r23 == null) goto L91;
        String r24 = r23.toString();
        if (r24 == null) goto L91;
        r16 = r24;
    L63:
        th = move-exception;
        if (r20 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L67;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L67:
        throw th;
    L121:
        r21 = Class.forName("q20.h");     // Catch: Throwable -> L72
        if (r20 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L85;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        if (r20 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L77;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L77:
        if ((th instanceof PluginClassNotFoundException) == false) goto L79;
        throw th;
    L79:
        if ((th instanceof ClassNotFoundException) == false) goto L81;
    L84:
        r21 = MiraPluginFix.forName("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
        goto L85
    L81:
        if ((th instanceof NoClassDefFoundError) == true) goto L84;
        throw th;
    L91:
        r18.load(r16);
    L98:
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r110 = r14.c;
        if (r110 == null) goto L106;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r111 = r110.entrySet().iterator();
    L102:
        if (r111.hasNext() == false) goto L106;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r25 = r111.next();
        final String r26 = r25.getKey();
        final com.bytedance.ies.web.jsbridge2.f.b r27 = r25.getValue();
        zy0.b r28 = this.a;
        if (r28 == null) goto L102;
        r28.l1(new BaseLynxGiftView$showLynxView$3$1(r26, r27));
    L106:
        Map<String, g<Object, Object>> r112 = r14.d;
        if (r112 == null) goto L114;
        Iterator<Map.Entry<String, g<Object, Object>>> r113 = r112.entrySet().iterator();
    L110:
        if (r113.hasNext() == false) goto L135;
        Map.Entry<String, g<Object, Object>> r114 = r113.next();
        final String r29 = r114.getKey();
        final g<Object, Object> r115 = r114.getValue();
        zy0.b r30 = this.a;
        if (r30 == null) goto L110;
        r30.l1(new BaseLynxGiftView$showLynxView$4$1(r29, r115));
        goto L110
    L135:
        return;
    L114:
        return;
    L93:
        zy0.b r31 = this.a;
        if (r31 == null) goto L98;
        xy0.a r33 = r31.g();
        if (r33 == null) goto L98;
        r33.load(r16);
        goto L98
    L119:
        r15.x();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("LynxGiftView", "registerKryptonServices error " + e);
        e.printStackTrace();
        goto L49
    L117:
        Uri r34 = UriProtector.parse(r11);     // Catch: Exception -> L36
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r34, "group"), "-1") == true) goto L38;
        Uri.Builder r35 = new Uri.Builder().scheme(r34.getScheme()).authority(r34.getAuthority()).path(r34.getPath());     // Catch: Exception -> L36
        Iterator r36 = UriProtector.getQueryParameterNames(r34).iterator();     // Catch: Exception -> L36
    L32:
        if (r36.hasNext() == false) goto L34;
        String r116 = (String) r36.next();     // Catch: Exception -> L36
        r35.appendQueryParameter(r116, UriProtector.getQueryParameter(r34, r116));     // Catch: Exception -> L36
        goto L32
    L34:
        r35.appendQueryParameter("group", "-1");     // Catch: Exception -> L36
        String r37 = r35.build().toString();     // Catch: Exception -> L36
    L39:
        if (r37 == null) goto L41;
        r15 = f.a(c.class).q8(r13, UriProtector.parse(r37), new BaseLynxGiftView$createLynxComponentDelegateWithAnnieX$1(this, r14));
        goto L43
    L41:
        r15 = f.a(c.class).J8(r13, UriProtector.parse(r11), new BaseLynxGiftView$createLynxComponentDelegateWithAnnie$1(this, r14));
    L38:
        r37 = null;
    L36:
        e = move-exception;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("LynxGiftView", "processUrlWithGroupParam error " + e);
        goto L38
    L5:
        r0 = r14.a;
        goto L6
    }

    public BaseLynxGiftView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ BaseLynxGiftView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
