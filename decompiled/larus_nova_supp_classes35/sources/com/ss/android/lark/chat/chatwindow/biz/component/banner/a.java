package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.view.SizeDetectFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final ViewGroup a;
    public final b b;
    public final Map<Integer, wya.b<? extends wya.c>> c;
    public int d;
    public boolean e;
    public final com.ss.android.lark.chat.chatwindow.biz.component.banner.b f;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.banner.a$a, reason: collision with other inner class name */
    public static final class C0031a {
    }

    public interface b {
        void a();

        void b();

        void onShow();
    }

    static {
    }

    public final void a(int r3) {
        Log.d("BannerController", "hideBanner:" + r3);
        wya.b r4 = (wya.b) ((LinkedHashMap) this.c).get(Integer.valueOf(r3));
        if (r4 == null) goto L5;
        r4.b(false);
        r4.getListener();
    L5:
        UICallbackExecutor.executeDelayed(this.f, 0);
    }

    public a(SizeDetectFrameLayout r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "mBannerContainer");
        Intrinsics.checkNotNullParameter(r3, "mVisibilityListener");
        this.a = r2;
        this.b = r3;
        this.c = new LinkedHashMap();
        this.f = new com.ss.android.lark.chat.chatwindow.biz.component.banner.b(this);
    }

    public final void b(int r5, wya.c r6) {
        Log.d("BannerController", "showBanner:" + r5);
        wya.b r7 = (wya.b) ((LinkedHashMap) this.c).get(Integer.valueOf(r5));
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getBanner() != null) goto L8;
        r7.c(LayoutInflater.from(this.a.getContext()).inflate(r7.getLayoutId(), this.a, false), r6);
    L9:
        r7.b(true);
        r7.getListener();
        UICallbackExecutor.executeDelayed(this.f, 0);
        return;
    L8:
        r7.d(r6);
        goto L9
    }
}
