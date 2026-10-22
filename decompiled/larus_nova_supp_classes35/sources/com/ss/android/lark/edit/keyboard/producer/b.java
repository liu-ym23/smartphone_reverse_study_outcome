package com.ss.android.lark.edit.keyboard.producer;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import rcb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends BaseKeyboardHeightProducer {
    public final View e;
    public final InterfaceC0195b f;
    public BaseKeyboardHeightProducer.b g;
    public boolean h;
    public boolean i;
    public boolean j;
    public BaseKeyboardHeightProducer.b k;
    public boolean l;
    public final Lazy m;
    public final d n;
    public final c o;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.edit.keyboard.producer.b$b, reason: collision with other inner class name */
    public interface InterfaceC0195b {
        void a(BaseKeyboardHeightProducer.b r1);
    }

    static {
    }

    public final void c() {
        Log.i("InsetsKBH#Producer", "start");
        View r0 = this.e;
        Intrinsics.checkNotNullParameter(r0, "v");
        if (a().isShowing() == true) goto L20;
        a().setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow r1 = a();     // Catch: Throwable -> L18
        if (PopupWindowLancet.hasSubWindowToken(r0) == false) goto L9;
    L24:
        goto L20
    L9:
        if ((r1 instanceof PopupWindow) == true) goto L11;
    L13:
        OverlaySource r9 = PopupWindowLancet.resolveSource(r0);     // Catch: Throwable -> L18
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r1, r0, r9, 0, 0, 0) == true) goto L24;
        r1.showAtLocation(r0, 0, 0, 0);     // Catch: Throwable -> L18
        PopupWindowLancet.trackAfterShow(r1, r9, r0);     // Catch: Throwable -> L18
        goto L24
    L11:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r1) == false) goto L13;
        r1.showAtLocation(r0, 0, 0, 0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Log.e("BaseBaseKBH#Producer", "showPopupWindow err =" + th.getMessage() + ';');
    L20:
        View r2 = a().getContentView();
        ViewCompat.setOnApplyWindowInsetsListener(r2.getRootView(), null);
        View r3 = r2.getRootView();
        if (r3 == null) goto L27;
        Intrinsics.checkNotNullParameter(r3, "insertsView");
        ViewCompat.setOnApplyWindowInsetsListener(r3, new com.ss.android.lark.edit.keyboard.producer.a(this));
        return;
    }

    public final void b(BaseKeyboardHeightProducer.b r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        if (this.d == null) goto L7;
        this.k = r4;
        e.a.removeCallbacks(this.o);
        Long r5 = this.d;
        if (r5 == null) goto L9;
        long r0 = r5.longValue();
        Log.i("InsetsKBH#Producer", "notify Delayed " + this.d + ' ');
        e.a(this.o, r0);
        return;
    L9:
        return;
    L7:
        this.f.a(r4);
    }

    public b(Activity r2, View r3, pcb.b.a r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "activityContentView");
        Intrinsics.checkNotNullParameter(r4, "listener");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.m = LazyKt.lazy(KeyboardHeightProducer$fgOnNotifyNot0$2.INSTANCE);
        this.n = new d(this);
        this.o = new c(this);
    }
}
