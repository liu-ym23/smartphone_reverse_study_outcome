package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.bytedance.ai.resource.f0;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.oui.indicator.OBaseIndicator;
import com.obric.oui.indicator.OBaseIndicator$setViewPager$3$addOnPageChangeListener$1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements z2.g, com.obric.oui.indicator.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f6304c;
    public Object d;
    public Object e;

    public /* synthetic */ p(int r5, Object r10, Object r11, Object r12, Object r13) {
        this.f6302a = r5;
        this.f6303b = r10;
        this.f6304c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // com.obric.oui.indicator.l
    public int a() {
        int r5 = ((ViewPager) this.f6304c).getCurrentItem();
        int r10 = getCount();
        return OBaseIndicator.a((OBaseIndicator) this.d, r5, r10);
    }

    @Override // z2.g
    public void b(z2.f r10) {
        int r5 = this.f6302a;
        Intrinsics.checkNotNullParameter(r10, "event");
        switch(r5) {
            case 1: goto L12;
            default: goto L4;
        };
    L4:
        r10.f = (String) this.f6303b;
        String r11 = (String) this.f6304c;
        if (r11 == null) goto L7;
        r10.c("message_id", r11);
    L7:
        String r12 = (String) this.d;
        if (r12 == null) goto L10;
        r10.c("replyFor", r12);
    L10:
        r10.c("content", (String) this.e);
        Intrinsics.checkNotNullParameter("success", STGroup.DICT_KEY);
        r10.b("success", Boolean.FALSE);
        return;
    L12:
        r10.c("name", (String) this.f6303b);
        r10.c("bridge_type", ((BridgeType) this.f6304c).f2389a);
        Object r13 = null;
        String r14 = (String) this.d;
        if (r14 == null) goto L25;
        r10.c("packageId", r14);
        com.bytedance.ai.resource.j r15 = com.bytedance.ai.resource.j.f2734a;
        Intrinsics.checkNotNullParameter(r14, "packageId");
        Intrinsics.checkNotNullParameter(r14, "packageName");
        if (com.bytedance.ai.resource.j.n(r14) == false) goto L19;
        f0 r16 = (f0) com.bytedance.ai.resource.j.f2736c.get(r14);
        if (r16 == null) goto L22;
        String r17 = r16.f2722j;
    L23:
        if (r17 == null) goto L25;
        r10.c("scmVersion", r17);
    L22:
        r17 = null;
        goto L23
    L19:
        f0 r18 = (f0) com.bytedance.ai.resource.j.d.get(r14);
        if (r18 == null) goto L22;
        r17 = r18.f2722j;
    L25:
        bj.a r19 = (bj.a) this.e;
        if (r19 == null) goto L47;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L30
        Object r21 = r19.b();     // Catch: Throwable -> L30
        if (r21 == null) goto L32;
        Intrinsics.checkNotNullParameter(r21, "value");     // Catch: Throwable -> L30
        String r22 = z0.a.a().toJson(r21);     // Catch: Throwable -> L30
    L33:
        Object r23 = Result.m124constructorimpl(r22);     // Catch: Throwable -> L30
    L37:
        if (Result.m130isFailureimpl(r23) == true) goto L40;
        r13 = r23;
    L40:
        String r24 = (String) r13;
        if (r24 == null) goto L43;
        r10.c(LynxResourceModule.PARAMS_KEY, r24);
    L43:
        r10.c("url", r19.d());
        long r25 = r19.f933b;
        Intrinsics.checkNotNullParameter("timestamp", STGroup.DICT_KEY);
        r10.b("timestamp", Long.valueOf(r25));
        r10.c("message", r19.f939l);
        r10.c("platformType", r19.c().name());
        return;
    L32:
        r22 = null;
    L30:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    @Override // com.obric.oui.indicator.l
    public void c(int r5) {
        ((ViewPager) this.f6304c).setCurrentItem(r5, false);
    }

    @Override // com.obric.oui.indicator.l
    public boolean d() {
        ViewPager r5 = (ViewPager) this.f6304c;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        PagerAdapter r10 = r5.getAdapter();
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        if (r11 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r11 = r10.getCount();
        goto L6
    }

    @Override // com.obric.oui.indicator.l
    public void e() {
        OBaseIndicator$setViewPager$3$addOnPageChangeListener$1 r5 = (OBaseIndicator$setViewPager$3$addOnPageChangeListener$1) this.f6303b;
        if (r5 == null) goto L7;
        ((ViewPager) this.f6304c).removeOnPageChangeListener(r5);
        return;
    }

    @Override // com.obric.oui.indicator.l
    public void f(final r6.a r5) {
        Intrinsics.checkNotNullParameter(r5, "onPageChangeListenerHelper");
        final OBaseIndicator r10 = (OBaseIndicator) this.d;
        ViewPager.OnPageChangeListener r11 = new OBaseIndicator$setViewPager$3$addOnPageChangeListener$1(r5, r10, this);
        this.f6303b = r11;
        Intrinsics.checkNotNull(r11);
        ((ViewPager) this.f6304c).addOnPageChangeListener(r11);
    }

    public void g(ArrayDeque r5, Object r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r5.remove(r10) == false) goto L12;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        i();
        return;
    L12:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L9
    }

    @Override // com.obric.oui.indicator.l
    public int getCount() {
        return ((Number) ((Function0) this.e).invoke()).intValue();
    }

    public void h(RealCall.AsyncCall r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        r5.getCallsPerHost().decrementAndGet();
        g((ArrayDeque) this.d, r5);
    }

    public void i() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        ArrayList r5 = new ArrayList();
        monitor-enter(this);
        Iterator r10 = ((ArrayDeque) this.f6304c).iterator();     // Catch: Throwable -> L21
    L13:
        if (r10.hasNext() == false) goto L23;
        RealCall.AsyncCall r11 = (RealCall.AsyncCall) r10.next();     // Catch: Throwable -> L21
        if (((ArrayDeque) this.d).size() >= 64) goto L23;
        if (r11.getCallsPerHost().get() >= 5) goto L13;
        r10.remove();     // Catch: Throwable -> L21
        r11.getCallsPerHost().incrementAndGet();     // Catch: Throwable -> L21
        r5.add(r11);     // Catch: Throwable -> L21
        ((ArrayDeque) this.d).add(r11);     // Catch: Throwable -> L21
    L23:
        monitor-enter(this);     // Catch: Throwable -> L21
        ((ArrayDeque) this.d).size();     // Catch: Throwable -> L43
        ((ArrayDeque) this.e).size();     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L21
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        int r13 = r5.size();
        int r14 = 0;
    L29:
        if (r14 >= r13) goto L42;
        RealCall.AsyncCall r15 = (RealCall.AsyncCall) r5.get(r14);
        monitor-enter(this);
        if (((ThreadPoolExecutor) this.f6303b) != null) goto L37;
        this.f6303b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory(Util.okHttpName + " Dispatcher", false));     // Catch: Throwable -> L35
    L37:
        ThreadPoolExecutor r16 = (ThreadPoolExecutor) this.f6303b;     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L35
        monitor-exit(this);
        r15.executeOn(r16);
        r14 = r14 + 1;
    L35:
        th = move-exception;
        throw th;
    L42:
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public String toString() {
        switch(this.f6302a) {
            case 4: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return "Config{mHeartBeatPolicy=" + ((q8.b) this.e) + ", mContext=" + ((Context) this.f6303b) + ", wsUrls=" + ((List) this.f6304c) + ", mOkHttpClient=null, mRetryPolicy=" + ((k8.a) this.d) + '}';
    }

    public p(Context r5, k8.a r10, q8.b r11) {
        this.f6302a = 4;
        this.f6303b = r5;
        this.f6304c = null;
        this.d = r10;
        this.e = r11;
    }

    public p(SSWebView r10, o r11) {
        this.f6302a = 0;
        this.e = new ConcurrentHashMap();
        CopyOnWriteArraySet r5 = new CopyOnWriteArraySet();
        u r12 = r11.f6299a;
        this.f6303b = r12;
        ce.b r13 = new ce.b();
        r13.g = new ConcurrentHashMap();
        r13.f1177h = new bb.b(r13, Looper.getMainLooper(), 1);
        r13.f1176c = r10;
        if (r10 != null) goto L13;
    L8:
        r13.f1175b = true;
        this.f6304c = r13;
        if (r12 == null) goto L11;
        this.d = new q(r12, r5);
        return;
    L11:
        this.d = null;
        return;
    L13:
        r10.getSettings().setJavaScriptEnabled(true);     // Catch: Exception -> L7
    L7:
        Log.e("SSWebSettings", "setJavaScriptEnabled failed");
        goto L8
    }

    public p(int r5) {
        this.f6302a = r5;
        switch(r5) {
            case 7: goto L7;
            default: goto L4;
        };
    L4:
        this.f6304c = new ArrayDeque();
        this.d = new ArrayDeque();
        this.e = new ArrayDeque();
        return;
    }

    public p(ViewPager r5, OBaseIndicator r10, Function0 r11) {
        this.f6302a = 3;
        this.f6304c = r5;
        this.d = r10;
        this.e = r11;
    }
}
