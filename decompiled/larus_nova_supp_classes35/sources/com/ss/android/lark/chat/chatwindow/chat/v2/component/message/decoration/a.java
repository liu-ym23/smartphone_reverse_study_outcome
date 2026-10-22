package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.utils.Contexts;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import z5c.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ BannerSettingItemDecoration a;
    public final /* synthetic */ LifecycleOwner b;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "e");
        int r0 = MathKt.roundToInt(r12.getX());
        int r13 = MathKt.roundToInt(r12.getY());
        BannerSettingItemDecoration r1 = this.a;
        Rect r2 = r1.k;
        if (r2 == null) goto L11;
        LifecycleOwner r5 = this.b;
        if (r2.contains(r0, r13) == false) goto L11;
        if ((System.currentTimeMillis() - r1.l) >= 1000) goto L9;
        return false;
    L9:
        r1.l = System.currentTimeMillis();
        int r14 = s2b.a.a;
        Context r15 = r1.a.getContext();
        String r7 = x0.c.b;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r7, "scene");
        com.suite.lark.platform.component.cta.a.b(Contexts.requireActivity(r15), r5, "chat_storage_duration_limit", r7, null, null, 112);
        return true;
    L11:
        return false;
    }

    public a(BannerSettingItemDecoration r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
