package com.bytedance.android.livesdk.chatroom.wornhole;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.bytedance.android.live.core.tetris.widgets.d;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.preinflate.LiveNitaViewInfo;
import com.bytedance.android.livesdk.utils.LiveInflateUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/wornhole/PreloadInteractionViewManager;", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadInteractionViewManager implements AsyncLayoutInflater.OnInflateFinishedListener {
    public static View a;
    public static AsyncLayoutInflater b;
    public static boolean c;
    public static final PreloadInteractionViewManager d = null;

    private PreloadInteractionViewManager() {
    }

    static {
        d = new PreloadInteractionViewManager();
    }

    public final void onCancel(int r1) {
        c = false;
    }

    public static View a(Context r4, ViewGroup r5) {
        long r0 = System.currentTimeMillis();
        LiveNitaViewInfo r2 = LiveNitaViewInfo.TTLIVE_FRAGMENT_PORTRAIT_INTERACTION;
        Activity r6 = ContextUtil.contextToActivity(r4);
        if (r6 == null) goto L7;
        View r7 = LiveInflateUtil.b("AudiencePortraitInteractionFragment", r2, r6, r5);
        d.g("create view, use time: " + (System.currentTimeMillis() - r0));
        return r7;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public static void b(Context r2, ViewGroup r3) {
        if (c == false) goto L5;
        return;
    L5:
        d.g("start async inflate interaction view");
        if (b != null) goto L8;
        b = new AsyncLayoutInflater(r2);
    L8:
        AsyncLayoutInflater r4 = b;
        if (r4 == null) goto L12;
        c = true;
        r4.inflate(2131566079, r3, d);
        return;
    }

    public static View c(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (d.b() == false) goto L11;
        View r0 = a;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        a = null;
        b(r2, r3);
        d.g("used preload view");
        return r0;
    L8:
        b(r2, r3);
        return a(r2, r3);
    L11:
        return a(r2, r3);
    }

    public final void onInflateFinished(View r1, int r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        c = false;
        a = r1;
        d.g("async inflate interaction view success");
    }
}
