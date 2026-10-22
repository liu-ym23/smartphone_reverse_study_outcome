package com.bytedance.ies.xelement.input;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxBaseInputView f6452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxContext f6454c;
    public n d;
    public LynxEditText e;
    public final com.lynx.tasm.behavior.o f;
    public Rect g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6462o;

    public o(LynxBaseInputView r5) {
        Intrinsics.checkNotNullParameter(r5, "inputView");
        this.f6452a = r5;
        LynxContext r10 = r5.getLynxContext();
        this.f6454c = r10;
        com.lynx.tasm.behavior.o r11 = r10.k().getKeyboardEvent();
        this.f = r11;
        this.g = new Rect();
        this.f6456i = "end";
        this.f6457j = true;
        this.f6459l = true;
        this.f6461n = -1;
        if (kk.a.c(r10) != null) goto L5;
        LynxLog.b(4, "LynxInputScrollHelper", "input's smart-scroll doesn't work properly since the context is not an activity");
        return;
    L5:
        if (r11.d == false) goto L7;
        c();
        return;
    L7:
        if (com.lynx.tasm.utils.j.j() == true) goto L10;
        m r12 = new m(this, 1);
        com.lynx.tasm.utils.j.a().post(r12);
        return;
    L10:
        r11.c();
        c();
    }

    public final LynxInputScrollHelper$Companion$SCROLL_ALGORITHM a() {
        LynxContext r5 = this.f6454c;
        Activity r10 = kk.a.c(r5);
        if (r10 == null) goto L25;
        int r11 = r10.getWindow().getAttributes().softInputMode & 240;
        if (r11 != 16) goto L7;
        Activity r12 = kk.a.c(r5);
        if (r12 == null) goto L23;
        if ((r12.getWindow().getDecorView().getSystemUiVisibility() & 1024) == 0) goto L23;
        return LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6428b;
    L23:
        return LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6429c;
    L7:
        if (r11 == 32) goto L15;
        if (r11 == 48) goto L13;
        return LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6427a;
    L13:
        return LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.d;
    L15:
        return LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6427a;
    L25:
        return LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6427a;
    }

    public final void b(AndroidScrollView r5, int r10) {
        this.f6452a.getView().post(new androidx.core.content.res.a(r10, 2, r5));
    }

    public final void c() {
        if (this.f6453b == false) goto L6;
        LynxLog.b(1, "LynxInputScrollHelper", "inputScrollerHelper has already initialized");
        return;
    L6:
        com.lynx.tasm.behavior.o r5 = this.f;
        if (r5.e != null) goto L10;
        LynxLog.b(1, "LynxInputScrollHelper", "keyboardMonitor has not been created");
        return;
    L10:
        LynxEditText r10 = this.f6452a.f6402a;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L13:
        this.e = r10;
        if (a() == LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6427a) goto L16;
        n r11 = new n(this, 0);
        this.d = r11;
        LynxEditText r12 = this.e;
        r5.f10308k.put(r12, r11);
        r5.c();
    L16:
        this.f6453b = true;
    }

    public final boolean d() {
        if (kk.a.c(this.f6454c) != null) goto L5;
    L14:
        return false;
    L5:
        if (this.f6459l == false) goto L14;
        if (TextUtils.equals(this.f6456i, "none") == true) goto L14;
        if (a() == LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6427a) goto L14;
        if (this.f.e == null) goto L14;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        if (kk.a.c(this.f6454c) == null) goto L89;
        boolean r5 = this.f6453b;
        com.lynx.tasm.behavior.o r10 = this.f;
        if (r5 == true) goto L9;
        r10.c();
        c();
    L9:
        if (this.e != null) goto L14;
        if (r10.e != null) goto L14;
        return;
    L14:
        if (this.f6455h != 0) goto L18;
        int r11 = r10.f;
        this.f6455h = r11;
        this.g = r10.f10305h;
        if (r11 != 0) goto L18;
        return;
    L18:
        Rect r12 = new Rect();
        LynxEditText r13 = this.e;
        Intrinsics.checkNotNull(r13);
        r13.getDrawingRect(r12);
        LynxBaseUI r14 = this.f6452a.getParentBaseUI();
    L19:
        if (r14 == null) goto L95;
        if ((r14 instanceof AbsLynxUIScroll) == true) goto L22;
        r14 = r14.getParentBaseUI();
        goto L19
    L22:
        LynxEditText r15 = this.e;
        if (r15 != null) goto L25;
        return;
    L25:
        if (r15.isFocused() != true) goto L85;
        AbsLynxUIScroll r16 = (AbsLynxUIScroll) r14;
        if ((r16.getView() instanceof AndroidScrollView) == false) goto L92;
        LynxInputScrollHelper$Companion$SCROLL_ALGORITHM r17 = a();
        this.f6455h = r10.f;
        this.g = r10.f10305h;
        if (r17 != LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6429c) goto L54;
        if (this.f6457j == false) goto L51;
        ((ViewGroup) r16.getView()).offsetDescendantRectToMyCoords(this.e, r12);
        int r18 = ((ViewGroup) r16.getView()).getChildAt(0).getBottom() - r12.bottom;
        if (TextUtils.equals(this.f6456i, "center") == false) goto L36;
        int r19 = r18 - ((this.f6461n - r12.height()) / 2);
    L37:
        if (r19 >= 0) goto L93;
        T r20 = r16.getView();
        if (r20 == 0) goto L50;
        AndroidScrollView r21 = (AndroidScrollView) r20;
        View r22 = r21.getChildAt(0);
        if (r22.getPaddingBottom() == 0) goto L46;
        r21.setFillViewport(true);
        r22.setPadding(0, 0, 0, r22.getPaddingBottom() - r19);
        b(r21, r19);
        return;
    L46:
        if (r22.getPaddingBottom() != 0) goto L86;
        r22.setPadding(0, 0, 0, -r19);
        b(r21, r19);
        return;
    L86:
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.scroll.AndroidScrollView");
    L93:
        return;
    L36:
        r19 = r18 - this.f6458k;
        goto L37
    L51:
        ((ViewGroup) r16.getView()).getChildAt(0).setPadding(0, 0, 0, 0);
        return;
    L54:
        if (r17 != LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.f6428b) goto L56;
    L57:
        T r23 = r16.getView();
        if (r23 == 0) goto L80;
        AndroidScrollView r24 = (AndroidScrollView) r23;
        View r25 = r24.getChildAt(0);
        int[] r26 = {-1, -1};
        LynxEditText r27 = this.e;
        Intrinsics.checkNotNull(r27);
        r27.getLocationOnScreen(r26);
        int r28 = r26[0];
        int r110 = r26[1];
        LynxEditText r111 = this.e;
        Intrinsics.checkNotNull(r111);
        int r112 = r111.getWidth() + r28;
        int r29 = r26[1];
        LynxEditText r113 = this.e;
        Intrinsics.checkNotNull(r113);
        Rect r30 = new Rect(r28, r110, r112, r113.getHeight() + r29);
        int r31 = (r10.e.getWindow().getDecorView().getHeight() + this.g.top) - r30.bottom;
        if (TextUtils.equals(this.f6456i, "center") == false) goto L62;
        int r32 = r31 - ((this.f6461n - r30.height()) / 2);
        int r33 = (this.f6461n - r30.height()) / 2;
    L63:
        if (r32 >= 0) goto L94;
        r24.offsetDescendantRectToMyCoords(this.e, r30);
        if ((r24.getContentHeight() - r30.bottom) < r33) goto L69;
        r33 = 0;
    L69:
        if (this.f6457j == false) goto L77;
        int r34 = r25.getPaddingBottom();
        int r35 = this.f6460m + r33;
        if (r34 == r35) goto L74;
        r24.setFillViewport(true);
        r25.setPadding(0, 0, 0, this.f6460m + r33);
        b(r24, r32);
        return;
    L74:
        if (r34 != r35) goto L88;
        b(r24, r32);
        return;
    L88:
        return;
    L77:
        ((ViewGroup) r16.getView()).getChildAt(0).setPadding(0, 0, 0, 0);
        return;
    L94:
        return;
    L62:
        r33 = this.f6458k;
        r32 = r31 - r33;
        goto L63
    L80:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.scroll.AndroidScrollView");
    L56:
        if (r17 == LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.d) goto L57;
        return;
    L92:
        return;
    L85:
        return;
    L95:
        return;
    }
}
