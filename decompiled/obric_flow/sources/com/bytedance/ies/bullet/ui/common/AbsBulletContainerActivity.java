package com.bytedance.ies.bullet.ui.common;

import android.R;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.p;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.launcher.widget.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import oo.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/AbsBulletContainerActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lwd/a;", "", "Lcom/bytedance/ies/bullet/core/n;", "Lcom/bytedance/ies/bullet/service/base/n;", "Lcom/bytedance/ies/bullet/core/container/b;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nAbsBulletContainerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsBulletContainerActivity.kt\ncom/bytedance/ies/bullet/ui/common/AbsBulletContainerActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Cast.kt\ncom/ss/android/ugc/aweme/uncheckedcast/CastKt\n*L\n1#1,1340:1\n1#2:1341\n4#3:1342\n4#3:1343\n4#3:1344\n4#3:1345\n4#3:1346\n4#3:1347\n4#3:1348\n4#3:1349\n*E\n*S KotlinDebug\n*F\n+ 1 AbsBulletContainerActivity.kt\ncom/bytedance/ies/bullet/ui/common/AbsBulletContainerActivity\n*L\n308#1:1342\n309#1:1343\n641#1:1344\n653#1:1345\n661#1:1346\n675#1:1347\n676#1:1348\n682#1:1349\n*E\n"})
public abstract class AbsBulletContainerActivity extends AbsActivity implements wd.a, n, com.bytedance.ies.bullet.service.base.n, com.bytedance.ies.bullet.core.container.b {
    public LinkedHashMap s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public yd.a f6164t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f6165u;

    public AbsBulletContainerActivity() {
        this.s = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(this, "activity");
        new WeakReference(this);
        new ArrayList();
        this.f6165u = new AtomicBoolean(false);
        LazyKt.lazy(new AbsBulletContainerActivity$poolService$2(this));
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void b() {
        com.bytedance.ies.bullet.service.router.a r5 = (com.bytedance.ies.bullet.service.router.a) yc.a.a(com.bytedance.ies.bullet.service.router.a.class, "default_bid");
        if (r5 == null) goto L6;
        r5.a(null, "", "", this);
        return;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final void close() {
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.h("AbsBulletContainerActivity close", MapsKt.mapOf(TuplesKt.to("close page url", null)), "XPage", null, 100);
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r11 = MapsKt.mapOf(TuplesKt.to("close page url", ""));
        com.bytedance.ies.bullet.base.utils.logger.b r12 = new com.bytedance.ies.bullet.base.utils.logger.b();
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter("", "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", "", r12.f5260a);
        Unit r13 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XPage", "moduleTag");
        Intrinsics.checkNotNullParameter("AbsBulletContainerActivity close", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPage", "AbsBulletContainerActivity close", r11, r12);
        finish();
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String d() {
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String e() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void f() {
    }

    public String getBid() {
        return "default_bid";
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getChannel() {
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getContainerId() {
        return "";
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final vc.c getLynxClient() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final Uri getSchema() {
        return null;
    }

    public final View h(int r5) {
        if (this.s != null) goto L5;
        this.s = new LinkedHashMap();
    L5:
        View r10 = (View) this.s.get(Integer.valueOf(r5));
        if (r10 != null) goto L13;
        View r11 = findViewById(r5);
        if (r11 == null) goto L11;
        Integer r12 = Integer.valueOf(r5);
        this.s.put(r12, r11);
        return r11;
    L11:
        return null;
    L13:
        return r10;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void n() {
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        com.bytedance.ies.bullet.service.base.b.a(2, "activity onLoadKitInstanceSuccess", "XPage");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        com.bytedance.ies.bullet.service.base.b.a(2, "message:activity onLoadUriSuccess", "XPage");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        if (xq.b.d(null) == false) goto L5;
        com.bytedance.android.anniex.base.monitor.b r11 = com.bytedance.android.anniex.base.monitor.b.f3120b;
        r10.toString();
        r11.getClass();
    L5:
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "message:activity onLoadFail|e: " + r10.getMessage(), "XPage");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void s(Uri r5, hb.a r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void u(Uri r5, com.bytedance.ies.bullet.core.container.e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void v(Uri r18, h r19, rd.e r20) {
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r20, "schemaModelUnion");
        r20.getClass();
        String r5 = "";
        if (findViewById(R$id.title_bar_container) != null) goto L5;
    L15:
        Window r10 = getWindow();
        if (r10 == null) goto L18;
        WindowManager.LayoutParams r11 = r10.getAttributes();
        r11.layoutInDisplayCutoutMode = 1;
        r10.setAttributes(r11);
    L18:
        HashMap r12 = kl.g.f18671p;
        kl.g r13 = (kl.g) r12.get(toString());
        if (r13 != null) goto L21;
        r13 = new kl.g();
        r13.f18675h = 0;
        r13.f18676i = 0;
        r13.f18677j = false;
        r13.f18678k = null;
        new HashMap();
        r13.f18679l = false;
        r13.f18680m = false;
        r13.f18672a = this;
        Window r14 = getWindow();
        r13.f18673b = r14;
        r13.g = toString();
        r13.e = new kl.b();
        ViewGroup r15 = (ViewGroup) r14.getDecorView();
        r13.f18674c = r15;
        r13.d = (ViewGroup) r15.findViewById(R.id.content);
        r12.put(toString(), r13);
    L21:
        Window r16 = getWindow();
        if (r16 == null) goto L24;
        int r17 = r16.getStatusBarColor();
    L25:
        kl.b r110 = r13.e;
        r110.f18656a = r17;
        r110.g = r110.g;
        if (td.e.k() == false) goto L30;
        kl.b r21 = r13.e;
        if (r21.f18660i == false) goto L30;
        r21.f18660i = r21.f18661j;
    L30:
        FragmentActivity r111 = r13.f18672a;
        r13.f = new kl.a(r111);
        boolean r22 = r13.f18677j;
        if (r22 == false) goto L35;
        kl.g r112 = (kl.g) r12.get(r111.toString());
        if (r112 == null) goto L35;
        r112.e = r13.e;
    L35:
        r13.e.getClass();
        Window r113 = r13.f18673b;
        r13.e.f18657b = r113.getNavigationBarColor();
        boolean r114 = td.e.k();
        int r115 = kl.g.f18670o;
        if (r114 == false) goto L38;
        r113.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        ViewGroup r23 = r13.f18674c;
        int r116 = kl.g.f18669n;
        View r24 = r23.findViewById(r116);
        if (r24 != null) goto L61;
        r24 = new View(r111);
        FrameLayout.LayoutParams r25 = new FrameLayout.LayoutParams(-1, r13.f.f18653a);
        r25.gravity = 48;
        r24.setLayoutParams(r25);
        r24.setVisibility(0);
        r24.setId(r116);
        r13.f18674c.addView(r24);
    L61:
        kl.b r26 = r13.e;
        r26.getClass();
        r24.setBackgroundColor(ColorUtils.blendARGB(r26.f18656a, ViewCompat.MEASURED_STATE_MASK, 0.0f));
        if (r13.f.f18654b == false) goto L64;
    L65:
        kl.b r27 = r13.e;
        if (r27.f18659h == true) goto L68;
    L70:
        r113.clearFlags(134217728);
    L72:
        if (r13.f18675h != 0) goto L75;
        r13.f18675h = r13.f.f18655c;
    L75:
        if (r13.f18676i != 0) goto L77;
        r13.f18676i = r13.f.d;
    L77:
        View r28 = r13.f18674c.findViewById(r115);
        if (r28 != null) goto L81;
        r28 = new View(r111);
        r28.setId(r115);
        r13.f18674c.addView(r28);
    L81:
        if (r13.f.c() == false) goto L83;
        FrameLayout.LayoutParams r29 = new FrameLayout.LayoutParams(-1, r13.f.f18655c);
        r29.gravity = 80;
    L84:
        r28.setLayoutParams(r29);
        r28.setBackgroundColor(ColorUtils.blendARGB(r13.e.f18657b, ViewCompat.MEASURED_STATE_MASK, 0.0f));
        kl.b r30 = r13.e;
        if (r30.f18659h == true) goto L87;
    L89:
        r28.setVisibility(8);
    L90:
        int r31 = 256;
    L91:
        int r32 = kl.f.f18668a[r13.e.d.ordinal()];
        if (r32 != 1) goto L94;
        r31 = r31 | 518;
    L101:
        int r33 = r31 | 4096;
        if (td.e.k() == true) goto L110;
        if (kl.g.a(r13.f18674c.findViewById(R.id.content)) == false) goto L106;
        r13.e.getClass();
    L145:
        r13.f18674c.setSystemUiVisibility(r33);
        if (td.e.m() == false) goto L151;
        r13.e.getClass();
        kl.g.c(r113, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", false);
        kl.b r34 = r13.e;
        if (r34.f18659h == false) goto L151;
        kl.g.c(r113, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", r34.e);
    L151:
        if (td.e.l() == false) goto L153;
        r13.e.getClass();
        r13.e.getClass();
        kl.d.a(r111, false, true);
    L153:
        if (r22 == true) goto L155;
        r13.e.getClass();
    L159:
        if (r13.e.f.size() == 0) goto L172;
        Iterator r35 = r13.e.f.entrySet().iterator();
    L162:
        if (r35.hasNext() == false) goto L172;
        Map.Entry r36 = (Map.Entry) r35.next();
        View r37 = (View) r36.getKey();
        Map r38 = (Map) r36.getValue();
        Integer r39 = Integer.valueOf(r13.e.f18656a);
        r13.e.getClass();
        Integer r40 = Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
        Iterator r41 = r38.entrySet().iterator();
    L165:
        if (r41.hasNext() == false) goto L167;
        Map.Entry r42 = (Map.Entry) r41.next();
        Integer r43 = (Integer) r42.getKey();
        r40 = (Integer) r42.getValue();
        r39 = r43;
        goto L165
    L167:
        if (r37 == null) goto L162;
        r13.e.getClass();
        if (Math.abs(0.0f) == 0.0f) goto L170;
        int r44 = r39.intValue();
        int r45 = r40.intValue();
        r13.e.getClass();
        r37.setBackgroundColor(ColorUtils.blendARGB(r44, r45, 0.0f));
        goto L162
    L170:
        int r46 = r39.intValue();
        int r47 = r40.intValue();
        r13.e.getClass();
        r37.setBackgroundColor(ColorUtils.blendARGB(r46, r47, 0.0f));
    L172:
        Window r48 = getWindow();
        if (r48 != null) goto L202;
    L185:
        Log.d("LandingPageKit", "AbsBulletContainerActivity initStatusBar()");
        if (TextUtils.isEmpty(j.d()) == true) goto L188;
        String r49 = j.d();
    L190:
        if (r49.contains("EmotionUI_3.0") == false) goto L192;
    L198:
        Window r50 = getWindow();
        if (r50 == null) goto L214;
        r50.clearFlags(134217728);
        return;
    L214:
        return;
    L192:
        if (TextUtils.isEmpty(j.d()) == true) goto L195;
        r5 = j.d();
    L195:
        if ("EmotionUI 3".equals(r5) == true) goto L198;
        if (r5.contains("EmotionUI_3.1") == true) goto L198;
        return;
    L188:
        r49 = "";
        goto L190
    L202:
        View r51 = r48.getDecorView();     // Catch: Throwable -> L178
        r51.setSystemUiVisibility(r51.getSystemUiVisibility() | 8192);     // Catch: Throwable -> L178
        r48.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);     // Catch: Throwable -> L178
        r48.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L178
        if (td.e.m() == false) goto L181;
        com.lynx.tasm.base.h.f(r48);     // Catch: Throwable -> L178
    L181:
        if (td.e.l() == false) goto L185;
        kl.d.a(this, true, true);     // Catch: Throwable -> L178
    L178:
        th = move-exception;
        th.printStackTrace();
        goto L185
    L155:
        kl.g r52 = (kl.g) r12.get(r111.toString());
        if (r52 == null) goto L159;
        r52.e.getClass();
        goto L159
    L106:
        r13.e.getClass();
        r13.e.getClass();
        ViewGroup r53 = r13.d;
        if (r53 == null) goto L145;
        r53.setPadding(0, 0, 0, 0);
        goto L145
    L110:
        if (kl.g.a(r13.f18674c.findViewById(R.id.content)) == false) goto L112;
        r13.e.getClass();
    L129:
        if (r22 == true) goto L145;
        if (td.e.k() == false) goto L145;
        View r54 = r13.f18674c.findViewById(r115);
        kl.b r55 = r13.e;
        if (r55.f18659h == true) goto L135;
    L144:
        r54.setVisibility(8);
        goto L145
    L135:
        if (r55.f18660i == false) goto L144;
        if (r54 == null) goto L145;
        if (r13.f18678k != null) goto L145;
        r13.f18678k = new kl.e(r13, new Handler(), r54);
        if (r111.getContentResolver() == null) goto L145;
        if (r13.f18678k == null) goto L145;
        r111.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, r13.f18678k);
        goto L145
    L112:
        r13.e.getClass();
        r13.e.getClass();
        kl.a r56 = r13.f;
        if (r56.f18654b == false) goto L125;
        kl.b r57 = r13.e;
        if (r57.f18659h == false) goto L125;
        if (r57.f18660i == false) goto L125;
        if (r56.c() == false) goto L121;
        int r58 = r13.f.f18655c;
        int r59 = 0;
    L122:
        r13.e.getClass();
        if (r13.f.c() == true) goto L126;
        r59 = r13.f.d;
    L126:
        ViewGroup r60 = r13.d;
        if (r60 == null) goto L129;
        r60.setPadding(0, 0, r59, r58);
        goto L129
    L121:
        r59 = r13.f.d;
        r58 = 0;
    L125:
        r59 = 0;
        r58 = 0;
        goto L126
    L94:
        if (r32 != 2) goto L96;
        r31 = r31 | 1028;
        goto L101
    L96:
        if (r32 != 3) goto L101;
        r31 = r31 | 514;
        goto L101
    L87:
        if (r30.f18660i == false) goto L89;
        r28.setVisibility(0);
        goto L90
    L83:
        r29 = new FrameLayout.LayoutParams(r13.f.d, -1);
        r29.gravity = GravityCompat.END;
        goto L84
    L68:
        if (r27.f18660i == false) goto L70;
        r113.addFlags(134217728);
        goto L72
    L64:
        if (td.e.k() == false) goto L90;
    L38:
        if (r13.f18680m == true) goto L41;
        WindowManager.LayoutParams r117 = r113.getAttributes();
        r117.layoutInDisplayCutoutMode = 1;
        r113.setAttributes(r117);
        r13.f18680m = true;
    L41:
        if (r13.f18679l == true) goto L43;
        r13.e.f18658c = r113.getNavigationBarColor();
        r13.f18679l = true;
    L43:
        r13.e.getClass();
        r113.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        if (r13.f.f18654b == false) goto L46;
        r113.clearFlags(134217728);
    L46:
        r113.addFlags(Integer.MIN_VALUE);
        kl.b r61 = r13.e;
        r61.getClass();
        r113.setStatusBarColor(ColorUtils.blendARGB(r61.f18656a, ViewCompat.MEASURED_STATE_MASK, 0.0f));
        kl.b r62 = r13.e;
        if (r62.f18659h == false) goto L49;
        r113.setNavigationBarColor(ColorUtils.blendARGB(r62.f18657b, ViewCompat.MEASURED_STATE_MASK, 0.0f));
    L50:
        kl.b r63 = r13.e;
        r63.getClass();
        if ((r113.getDecorView().getSystemUiVisibility() & 16) == 0) goto L53;
        boolean r118 = true;
    L54:
        r63.e = r118;
        if (r13.e.e == false) goto L57;
        r31 = 1296;
        goto L91
    L57:
        r31 = 1280;
        goto L91
    L53:
        r118 = false;
        goto L54
    L49:
        r113.setNavigationBarColor(r62.f18658c);
        goto L50
    L24:
        r17 = 0;
        goto L25
    L5:
        if (this.f6164t != null) goto L12;
        tc.c r64 = tc.c.f22119c;
        if (tc.c.f22119c.a(p.class, "default_bid") != null) goto L10;
        com.bytedance.ies.bullet.service.base.b.a(2, "AbsBulletContainerActivity.offerTitleBarProvider, titleBarProviderInBulletContext=null, titleBarProviderInContextViewProvider=null, titleBarProviderInBidViewProvider=null", "XPage");
        yd.a r65 = new yd.a(this);
        r65.setTitleIfMissing("");
        r65.setBackListener(new a(this, 0));
        r65.setCloseAllListener(new a(this, 1));
        this.f6164t = r65;
        ((FrameLayout) h(R$id.title_bar_container)).addView(this.f6164t, -1, -2);
    L14:
        ((FrameLayout) h(R$id.title_bar_container)).setVisibility(0);
        goto L15
    L10:
        throw new ClassCastException();
    L12:
        if (((FrameLayout) h(R$id.title_bar_container)).getChildCount() != 0) goto L14;
        ((FrameLayout) h(R$id.title_bar_container)).addView(this.f6164t, -1, -2);
        goto L14
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void w(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f6165u.get();
    }
}
