package com.lynx.animax.player;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.LocalSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal;
import com.obric.oui.orecyclerview.widget.a1;
import com.obric.oui.orecyclerview.widget.b1;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import jg.k;
import kotlin.jvm.internal.Intrinsics;
import mt.b0;
import mt.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements xn.d, hn.f, b0, j, nr.g {
    public static b d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9658c;

    public /* synthetic */ b(int r5, Object r10, Object r11) {
        this.f9656a = r5;
        this.f9657b = r10;
        this.f9658c = r11;
    }

    @Override // hn.f
    public void a(boolean r5) {
        if (r5 == false) goto L8;
        hn.c r10 = (hn.c) this.f9658c;
        hn.g r11 = r10.f17349a;
        boolean r12 = r10.f17351c;
        androidx.core.view.inputmethod.a r13 = new androidx.core.view.inputmethod.a(this, 12);
        if (r11.d((LynxBaseScrollViewNestedInternal) this.f9657b, r12, r13) == true) goto L9;
        r10.a(0);
        return;
    L9:
        return;
    }

    @Override // nr.g
    public void b(nr.a r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r5, "host");
        if ((r5 instanceof com.obric.oui.dialog.v2.alert.b) == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter((com.obric.oui.dialog.base.d) r5, "dialog");
        return;
    }

    public IAnimaXService c(Class r5) {
        IAnimaXService r10 = (IAnimaXService) ((ConcurrentHashMap) this.f9657b).get(r5);
        if (r10 == null) goto L7;
        return (IAnimaXService) r5.cast(r10);
    L7:
        return gm.a.b().a((gm.b) this.f9658c, r5);
    }

    public synchronized void d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (((ArrayList) this.f9658c).isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r5 = ((ArrayList) this.f9658c).iterator();     // Catch: Throwable -> L11
    L9:
        if (r5.hasNext() == false) goto L13;
        ((Runnable) r5.next()).run();     // Catch: Throwable -> L11
        goto L9
    L13:
        ((ArrayList) this.f9658c).clear();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // xn.d
    public synchronized void e(wn.b r10, xn.e r11, xn.c r12) {
        monitor-enter(this);
        f(new com.bytedance.apm.e(this, r10, r11, r12, 11, false));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void f(Runnable r5) {
        monitor-enter(this);
        ((ArrayList) this.f9658c).add(r5);     // Catch: Throwable -> L6
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.ui.image.h(this, 11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // xn.d
    public synchronized void g(int r5, Throwable r10) {
        monitor-enter(this);
        f(new a7.a(this, r5, r10, 3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void h(String r10, int r11, String r12) {
        Logger.d("WsChannelSdk_ok", td.d.b("onFailure() : ", r12));
        Bundle r5 = new Bundle();
        r5.putString("url", r10);
        r5.putInt(WsConstants.ERROR_CODE, r11);
        r5.putString("error_msg", r12);
        r5.putString("method", "onFailure");
        r8.a.a((Context) this.f9658c, "WsChannelSdk_ok", r5);
        IWsChannelClient r13 = (IWsChannelClient) this.f9657b;
        if (r13 == null) goto L12;
        JSONObject r14 = new JSONObject();
        r14.put("type", 0);     // Catch: Exception -> L7
        r14.put("state", 2);     // Catch: Exception -> L7
        r14.put("url", r10);     // Catch: Exception -> L7
        r14.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r14.put("error", r12);     // Catch: Exception -> L7
        r14.put(WsConstants.ERROR_CODE, r11);     // Catch: Exception -> L7
        r13.onConnection(r14);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public View i(int r10, int r11, int r12, int r13) {
        b1 r5 = (b1) this.f9657b;
        int r14 = r5.getParentStart();
        int r15 = r5.getParentEnd();
        if (r11 <= r10) goto L5;
        int r16 = 1;
    L6:
        View r17 = null;
    L7:
        if (r10 == r11) goto L18;
        View r18 = r5.getChildAt(r10);
        int r19 = r5.getChildStart(r18);
        int r20 = r5.getChildEnd(r18);
        a1 r21 = (a1) this.f9658c;
        r21.f13789b = r14;
        r21.f13790c = r15;
        r21.d = r19;
        r21.e = r20;
        if (r12 == 0) goto L13;
        r21.f13788a = r12;
        if (r21.a() == false) goto L13;
        return r18;
    L13:
        if (r13 == 0) goto L17;
        r21.f13788a = r13;
        if (r21.a() == false) goto L17;
        r17 = r18;
    L17:
        r10 = r10 + r16;
        goto L7
    L18:
        return r17;
    L5:
        r16 = -1;
        goto L6
    }

    @Override // mt.j
    public void onComplete() {
        ((j) this.f9657b).onComplete();
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        switch(this.f9656a) {
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        ((j) this.f9657b).onError(r5);
        return;
    L6:
        ((b0) this.f9658c).onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        switch(this.f9656a) {
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        DisposableHelper.setOnce((AtomicReference) this.f9658c, r5);
        return;
    L6:
        DisposableHelper.replace((AtomicReference) this.f9657b, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(Object r5) {
        switch(this.f9656a) {
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        ((j) this.f9657b).onSuccess(r5);
        return;
    L6:
        ((b0) this.f9658c).onSuccess(r5);
    }

    public /* synthetic */ b(int r5, Object r10, boolean r11, Object r12) {
        this.f9656a = r5;
        this.f9658c = r10;
        this.f9657b = r12;
    }

    public b(int r5) {
        this.f9656a = r5;
        switch(r5) {
            case 3: goto L10;
            case 12: goto L8;
            case 15: goto L6;
            default: goto L5;
        };
    L6:
        this.f9657b = new ConcurrentHashMap();
        this.f9658c = "default_bid";
        return;
    L8:
        this.f9657b = new lh.f(this);
        this.f9658c = XPath.WILDCARD;
        return;
    L10:
        this.f9657b = new qb.a(Boolean.TRUE);
        this.f9658c = new qb.a(null);
        return;
    }

    @Override // nr.g
    public void a(Context r5, nr.f r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "dialogContainer");
        FrameLayout r11 = r10.getIconSlot();
        r11.setVisibility(0);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
        r12.gravity = 1;
        r12.topMargin = com.lynx.tasm.utils.a.p(4, r5);
        r12.bottomMargin = com.lynx.tasm.utils.a.p(16, r5);
        ImageView r13 = new ImageView((Context) this.f9657b);
        r13.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r14 = (Drawable) this.f9658c;
        if (r14 == null) goto L5;
        r13.setImageDrawable(r14);
    L5:
        r11.addView(r13, r12);
    }

    public b(b r5, ck.b r10) {
        this.f9656a = 1;
        this.f9657b = (LocalSocket) r5.f9657b;
        this.f9658c = r10;
    }

    public b(LynxContext r5) {
        this.f9656a = 14;
        this.f9658c = new HashMap();
        this.f9657b = new WeakReference(r5);
    }

    public b(gm.b r5) {
        this.f9656a = 7;
        this.f9657b = new ConcurrentHashMap();
        this.f9658c = r5;
    }

    public b(k r5) {
        this.f9656a = 6;
        this.f9658c = new ArrayList();
        this.f9657b = r5;
    }

    public b(Context r5) {
        this.f9656a = 13;
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f9657b = r5;
    }

    public b(b1 r5) {
        this.f9656a = 5;
        this.f9657b = r5;
        a1 r10 = new a1();
        r10.f13788a = 0;
        this.f9658c = r10;
    }
}
