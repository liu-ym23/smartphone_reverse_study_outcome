package q7;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.annie.card.base.HybridDomainUtils;
import com.bytedance.android.annie.card.web.e;
import com.bytedance.android.annie.card.web.secLink.LiveSecLinkManager;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o7.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends c implements o7.d {
    public final List<e> v;
    public final er7.a w;
    public final boolean x;
    public WeakReference<ViewParent> y;
    public final boolean z;

    @Override // q7.d, android.webkit.WebView
    public final boolean canGoBack() {
        er7.a r0 = this.w;
        if (r0 == null) goto L11;
        if (super.canGoBack() == true) goto L7;
    L9:
        return false;
    L7:
        if (r0.canGoBack() == false) goto L9;
        return true;
    L11:
        return super.canGoBack();
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        Iterator<T> r0 = this.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).e(this);
        goto L4
    L6:
        super.destroy();
    }

    @Override // q7.d, android.webkit.WebView
    public final void goBack() {
        Iterator<T> r0 = this.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).q(this);
        goto L4
    L6:
        er7.a r1 = this.w;
        if (r1 == null) goto L11;
        boolean r10 = true;
        if (r1.b() != true) goto L11;
    L12:
        if (r10 == false) goto L14;
        return;
    L14:
        super.goBack();
        return;
    L11:
        r10 = false;
        goto L12
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Iterator<T> r0 = this.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).d(this);
        goto L4
    L6:
        super.onAttachedToWindow();
    }

    @Override // q7.d, android.webkit.WebView
    public final void reload() {
        Iterator<T> r0 = this.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).B(this);
        goto L4
    L6:
        super.reload();
    }

    public static ViewParent g(View r10) {
        View r0 = null;
        if (r10 == null) goto L5;
        ViewParent r11 = r10.getParent();
    L6:
        if (r11 != null) goto L9;
        return null;
    L9:
        if ((r11 instanceof ViewPager) == false) goto L11;
        return r11;
    L11:
        if ((r11 instanceof AbsListView) == false) goto L13;
        return r11;
    L13:
        if ((r11 instanceof ScrollView) == false) goto L15;
        return r11;
    L15:
        if ((r11 instanceof HorizontalScrollView) == false) goto L17;
        return r11;
    L17:
        if ((r11 instanceof GridView) == false) goto L20;
        return r11;
    L20:
        if ((r11 instanceof View) == false) goto L23;
        r0 = (View) r11;
    L23:
        return g(r0);
    L5:
        r11 = null;
        goto L6
    }

    @Override // o7.d
    public final void c(String r10) {
        er7.a r0 = this.w;
        if (r0 == null) goto L12;
        com.bytedance.android.annie.card.web.secLink.b r1 = LiveSecLinkManager.a;
        Intrinsics.checkNotNullParameter(r0, "strategy");
        if (LiveSecLinkManager.c() == true) goto L8;
        return;
    L8:
        if (cr7.a.c == false) goto L14;
        r0.a(r10);
        return;
    L14:
        return;
    }

    public final String f(String r10) {
        er7.a r0 = this.w;
        if (r0 != null) goto L5;
        return r10;
    L5:
        if (LiveSecLinkManager.c() == true) goto L8;
    L15:
        String r1 = r10;
    L16:
        if (r1 != null) goto L19;
        return r10;
    L19:
        return r1;
    L8:
        if (cr7.a.c == false) goto L15;
        if (TextUtils.isEmpty(r10) == true) goto L15;
        r1 = r0.d(r10);
        if (TextUtils.isEmpty(r1) == false) goto L16;
        goto L15
    }

    @Override // q7.d, android.webkit.WebView
    public final void loadUrl(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Iterator<T> r0 = this.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).s(this, r10);
        goto L4
    L6:
        super.loadUrl(f(r10));
    }

    @Override // q7.c, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.z == false) goto L20;
        WeakReference<ViewParent> r11 = null;
        if (r10.getAction() != 0) goto L15;
        ViewParent r0 = g(this);
        if (r0 == null) goto L9;
        r11 = new WeakReference(r0);
    L9:
        this.y = r11;
        if (r11 == null) goto L20;
        ViewParent r1 = r11.get();
        if (r1 == null) goto L20;
        r1.requestDisallowInterceptTouchEvent(true);
        goto L20
    L15:
        if (r10.getAction() != 3) goto L17;
    L18:
        this.y = null;
        goto L20
    L17:
        if (r10.getAction() == 1) goto L18;
    L20:
        return super.onTouchEvent(r10);
    }

    @Override // o7.d
    public void setCallback(dr7.d r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        er7.a r0 = this.w;
        if (r0 == null) goto L6;
        r0.c(r10);
        return;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r10) {
        if (this.x == false) goto L6;
        r10 = new a();
    L6:
        return super.startActionMode(r10);
    }

    @Override // android.webkit.WebView
    public final void evaluateJavascript(String r10, ValueCallback<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "script");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        super.evaluateJavascript(r10, r11);     // Catch: Throwable -> L9
        Iterator<T> r1 = this.v.iterator();     // Catch: Throwable -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        ((e) r1.next()).f(r10, r11);     // Catch: Throwable -> L9
        goto L5
    L7:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // q7.d, android.webkit.WebView
    public final void loadUrl(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "additionalHttpHeaders");
        Iterator<T> r0 = this.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).s(this, r10);
        goto L4
    L6:
        super.loadUrl(f(r10), r11);
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r10, int r11) {
        if (this.x == false) goto L6;
        r10 = new a();
    L6:
        return super.startActionMode(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context r10, CardParamVoNew r11, List<? extends e> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "mLifecycleCallbacks");
        super(r10);
        this.v = r12;
        er7.a r13 = null;
        if (r11 == null) goto L5;
        String r14 = r11.b;
    L6:
        com.bytedance.android.annie.card.web.secLink.b r0 = LiveSecLinkManager.a;
        Intrinsics.checkNotNullParameter("host", "bizKey");
        boolean r1 = true;
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        if (r15 == true) goto L68;
        Integer r16 = LiveSecLinkManager.a();
        if (r16 == null) goto L22;
        if (r16.intValue() == 0) goto L68;
    L22:
        if (l.g(r14) == false) goto L24;
    L53:
        boolean r17 = true;
    L54:
        if (r17 == true) goto L68;
        Integer r18 = LiveSecLinkManager.a();
        if (r18 != null) goto L60;
    L62:
        Integer r19 = LiveSecLinkManager.a();
        if (r19 == null) goto L68;
        if (r19.intValue() != 2) goto L68;
        boolean r20 = true;
    L69:
        if (r11 == null) goto L71;
        boolean r21 = Intrinsics.areEqual(r11.E(), Boolean.TRUE);
    L72:
        if (r21 == true) goto L74;
        if (r20 == true) goto L74;
    L122:
        if (r11 == null) goto L124;
        this.x = r11.b();
    L124:
        Iterator<T> r22 = this.v.iterator();
    L126:
        if (r22.hasNext() == false) goto L128;
        ((e) r22.next()).A(this);
        goto L126
    L128:
        if (r11 != null) goto L130;
    L132:
        r1 = false;
    L133:
        this.z = r1;
        return;
    L130:
        if (r11.t() != true) goto L132;
    L74:
        Iterator<T> r23 = this.v.iterator();
    L76:
        if (r23.hasNext() == false) goto L79;
        ((e) r23.next()).m(r20);
        goto L76
    L79:
        if (LiveSecLinkManager.c() == true) goto L82;
    L100:
        if (r11 == null) goto L102;
        boolean r24 = Intrinsics.areEqual(r11.E(), Boolean.TRUE);
    L103:
        if (r24 == false) goto L105;
        String r25 = "deeplink";
    L106:
        if (r11 == null) goto L116;
        String r26 = r11.K0();
        if (r26 == null) goto L116;
        if (r26.length() != 0) goto L112;
        boolean r27 = true;
    L113:
        if (r27 == true) goto L118;
        r25 = r26;
    L118:
        if (LiveSecLinkManager.c() == false) goto L121;
        r13 = cr7.a.a(this, r25);
    L121:
        this.w = r13;
        goto L122
    L112:
        r27 = false;
    L116:
        r25 = null;
        goto L118
    L105:
        r25 = "common";
        goto L106
    L102:
        r24 = false;
        goto L103
    L82:
        if (cr7.a.c == true) goto L100;
        LiveSecLinkManager.a.getClass();
        g.b().getClass();
        String r28 = String.valueOf(com.bytedance.android.annie.ng.e.a.a);
        Application r29 = g.a();
        if (TextUtils.isEmpty(r28) == true) goto L100;
        if (r29 == null) goto L100;
        gr7.a.a r30 = new gr7.a.a();
        r30.a = r28;
        r30.b = "cn";
        r30.c = "https://link.wtturl.cn";
        cr7.a.b(r29, new gr7.a(r30));
        List r31 = (List) HybridDomainUtils.a.getValue();
        gr7.a r32 = cr7.a.b;
        if (r32 != null) goto L91;
    L94:
        List r33 = (List) HybridDomainUtils.b.getValue();
        gr7.a r34 = cr7.a.b;
        if (r34 == null) goto L100;
        if (r34.g != null) goto L99;
        r34.g = new ArrayList();
    L99:
        r34.g.addAll(r33);
        goto L100
    L91:
        if (r32.g != null) goto L93;
        r32.g = new ArrayList();
    L93:
        r32.g.addAll(r31);
        goto L94
    L71:
        r21 = false;
        goto L72
    L60:
        if (r18.intValue() != 1) goto L62;
        Schedulers.computation().scheduleDirect(new com.bytedance.android.annie.card.web.secLink.a(r14, "host"));
        goto L68
    L24:
        if (o7.e.a() == true) goto L48;
        if (r14 != null) goto L28;
    L31:
        boolean r35 = true;
    L32:
        if (r35 == false) goto L135;
    L49:
        boolean r36 = false;
    L50:
        if (r36 == true) goto L53;
        r17 = false;
        goto L54
    L135:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L36
        Object r38 = Result.constructor-impl(new URI(r14).getHost());     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r38) == false) goto L41;
        r38 = null;
    L41:
        String r39 = (String) r38;
        if (r39 == null) goto L49;
        Iterator r40 = ((List) HybridDomainUtils.b.getValue()).iterator();
    L45:
        if (r40.hasNext() == false) goto L49;
        if (l.h(r39, (String) r40.next()) == false) goto L45;
    L36:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r38 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L28:
        if (StringsKt.isBlank(r14) == true) goto L31;
        r35 = false;
    L48:
        r36 = true;
    L68:
        r20 = false;
        goto L69
    L9:
        if (StringsKt.isBlank(r14) == true) goto L12;
        r15 = false;
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onOverScrolled(int r10, int r11, boolean r12, boolean r13) {
        if (this.z == false) goto L11;
        WeakReference<ViewParent> r0 = this.y;
        if (r0 == null) goto L11;
        if (r0 == null) goto L10;
        ViewParent r1 = r0.get();
        if (r1 == null) goto L10;
        r1.requestDisallowInterceptTouchEvent(false);
    L10:
        this.y = null;
    L11:
        super.onOverScrolled(r10, r11, r12, r13);
    }
}
