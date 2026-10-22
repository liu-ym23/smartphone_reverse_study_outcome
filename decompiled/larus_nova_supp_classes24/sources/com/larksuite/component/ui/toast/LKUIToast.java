package com.larksuite.component.ui.toast;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.toast.c;
import h08.b;
import h08.d;
import h08.e;
import h08.f;
import h08.g;
import h08.h;
import h08.i;
import h08.j;
import h08.k;
import h08.l;
import h08.m;
import h08.n;
import h08.o;
import h08.p;
import h08.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIToast {
    public static final long DURATION_LONG = 3500;
    public static final int DURATION_MAX = Integer.MAX_VALUE;
    public static final long DURATION_SHORT = 2000;
    private static final String TAG = "LKUIToast";
    public static WeakReference<c> mUdToastRef;
    private static int sBottomMargin;
    private static Handler sHandler;
    private static boolean sIsEnabled;

    public LKUIToast() {
    }

    public static /* synthetic */ void a(Context r0, String r1, int r2, long r3) {
        lambda$show$13(r0, r1, r2, r3);
    }

    public static /* synthetic */ void b(Context r0, CharSequence r1) {
        lambda$showLoading$0(r0, r1);
    }

    public static /* synthetic */ void c(Context r0, String r1, long r2) {
        lambda$showInCenter$10(r0, r1, r2);
    }

    public static /* synthetic */ void d(Context r0, String r1, long r2) {
        lambda$show$11(r0, r1, r2);
    }

    public static void disableToast() {
        sIsEnabled = false;
    }

    public static /* synthetic */ void e(Context r0, CharSequence r1) {
        lambda$loadFail$4(r0, r1);
    }

    public static void enableToast() {
        sIsEnabled = true;
    }

    public static /* synthetic */ void f(Context r0, String r1, int r2) {
        lambda$show$8(r0, r1, r2);
    }

    public static /* synthetic */ void g(Context r0, CharSequence r1) {
        lambda$loadSuccess$2(r0, r1);
    }

    public static /* synthetic */ void h() {
        lambda$cancelLoading$1();
    }

    public static /* synthetic */ void i(Context r0, String r1) {
        lambda$showInCenter$7(r0, r1);
    }

    public static /* synthetic */ void j(Context r0, String r1) {
        lambda$show$6(r0, r1);
    }

    public static /* synthetic */ void k(Context r0, int r1) {
        lambda$loadFail$5(r0, r1);
    }

    public static /* synthetic */ void l(Context r0, String r1, long r2) {
        lambda$showInCenter$12(r0, r1, r2);
    }

    public static /* synthetic */ void m(Context r0, String r1, long r2) {
        lambda$show$9(r0, r1, r2);
    }

    public static /* synthetic */ void n(Context r0, int r1) {
        lambda$loadSuccess$3(r0, r1);
    }

    static {
        sHandler = new Handler(Looper.getMainLooper());
        sBottomMargin = 0;
        sIsEnabled = true;
    }

    public static void cancelLoading() {
        runOnUiThread(new n());
    }

    public static RotateAnimation getRotateAnimation() {
        RotateAnimation r7 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r7.setInterpolator(new LinearInterpolator());
        r7.setDuration(1200);
        r7.setRepeatCount(-1);
        r7.setRepeatMode(1);
        return r7;
    }

    private static boolean isDisabled() {
        return !sIsEnabled;
    }

    private static /* synthetic */ void lambda$cancelLoading$1() {
        WeakReference<c> r0 = mUdToastRef;
        if (r0 != null) goto L5;
        return;
    L5:
        c r1 = r0.get();
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        mUdToastRef = null;
    }

    public static CharSequence nullIsEmpty(CharSequence r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return "";
    L6:
        return r1;
    }

    private static void runOnUiThread(Runnable r2) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r2.run();
        return;
    L5:
        sHandler.post(r2);
    }

    public static void setBottomMargin(int r0) {
        sBottomMargin = r0;
    }

    private static /* synthetic */ void lambda$loadFail$4(Context r2, CharSequence r3) {
        WeakReference<c> r0 = mUdToastRef;
        if (r0 != null) goto L5;
        showFail(r2, r3);
        return;
    L5:
        c r1 = r0.get();
        if (r1 != null) goto L8;
    L10:
        showFail(r2, r3);
        return;
    L8:
        if (r1.isShowing() == false) goto L10;
        r1.setText(nullIsEmpty(r3));
        r1.setIcon(2131255144);
        sHandler.postDelayed(new o(r1), DURATION_SHORT);
    }

    private static /* synthetic */ void lambda$loadFail$5(Context r0, int r1) {
        loadFail(r0, r0.getString(r1));
    }

    private static /* synthetic */ void lambda$loadSuccess$2(Context r2, CharSequence r3) {
        WeakReference<c> r0 = mUdToastRef;
        if (r0 != null) goto L5;
        showSuccess(r2, r3);
        return;
    L5:
        c r1 = r0.get();
        if (r1 != null) goto L8;
    L10:
        showSuccess(r2, r3);
        return;
    L8:
        if (r1.isShowing() == false) goto L10;
        r1.setText(nullIsEmpty(r3));
        r1.setIcon(2131256306);
        sHandler.postDelayed(new o(r1), DURATION_SHORT);
    }

    private static /* synthetic */ void lambda$loadSuccess$3(Context r0, int r1) {
        loadSuccess(r0, r0.getString(r1));
    }

    private static /* synthetic */ void lambda$show$6(Context r0, String r1) {
        UDToast.show(r0, nullIsEmpty(r1).toString());
    }

    private static void lambda$showInCenter$7(Context r2, String r3) {
        UDToast.a r4 = UDToast.build(r2);
        r4.g(nullIsEmpty(r3));
        r4.b.c(17, 0, 0);
        r4.a().show();
    }

    private static /* synthetic */ void lambda$showLoading$0(Context r2, CharSequence r3) {
        WeakReference<c> r0 = mUdToastRef;
        if (r0 != null) goto L5;
        showPermanentLoading(r2, r3);
        return;
    L5:
        c r1 = r0.get();
        if (r1 != null) goto L8;
    L10:
        showPermanentLoading(r2, r3);
        return;
    L8:
        if (r1.isShowing() == false) goto L10;
        r1.setText(nullIsEmpty(r3));
    }

    public static void loadFail(final Context r1, final int r2) {
        runOnUiThread(new l(r1, r2));
    }

    public static void loadSuccess(final Context r1, final int r2) {
        runOnUiThread(new h08.c(r1, r2));
    }

    public static b newGlobal(Context r2, String r3) {
        UDToast.a r1 = UDToast.build(r2);
        r1.g(nullIsEmpty(r3));
        return new b(r2, r1);
    }

    public static b newGlobalInCenter(Context r4, String r5) {
        UDToast.a r1 = UDToast.build(r4);
        r1.g(nullIsEmpty(r5));
        r1.b.c(17, 0, 0);
        return new b(r4, r1);
    }

    public static void show(final Context r1, final String r2) {
        if (r1 != null) goto L4;
    L8:
        isDisabled();
        return;
    L4:
        if (isDisabled() == true) goto L8;
        runOnUiThread(new g(r1, r2));
    }

    private static void showFail(Context r0, CharSequence r1) {
        UDToast.a r2 = UDToast.build(r0);
        r2.g(nullIsEmpty(r1));
        r2.d(2131255144);
        r2.a().show();
    }

    public static void showInCenter(final Context r1, final String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new p(r1, r2));
        return;
    }

    public static void showLoading(final Context r1, final CharSequence r2) {
        runOnUiThread(new i(r1, r2));
    }

    private static void showPermanentLoading(Context r4, CharSequence r5) {
        Drawable r0 = new CircularProgressDrawable(r4);
        r0.setStyle(1);
        r0.setColorSchemeColors(new int[]{UDColorUtils.getColor(r4, 2131106521)});
        r0.setStrokeCap(Paint.Cap.ROUND);
        UDToast.a r6 = UDToast.build(r4);
        r6.g(nullIsEmpty(r5));
        r6.e(r0);
        r6.b.d = 2147483647L;
        com.ss.android.lark.compose.foundation.toast.g r7 = r6.a();
        mUdToastRef = new WeakReference(r7);
        r7.show();
    }

    private static void showSuccess(Context r0, CharSequence r1) {
        UDToast.a r2 = UDToast.build(r0);
        r2.g(nullIsEmpty(r1));
        r2.d(2131256306);
        r2.a().show();
    }

    public static void loadFail(final Context r1, final CharSequence r2) {
        runOnUiThread(new m(r1, r2));
    }

    public static void loadSuccess(final Context r1, final CharSequence r2) {
        runOnUiThread(new d(r1, r2));
    }

    public static void show(Context r0, int r1) {
        show(r0, r0.getString(r1));
    }

    public static void showInCenter(Context r0, int r1) {
        showInCenter(r0, r0.getString(r1));
    }

    public static void showLoading(Context r0, int r1) {
        showLoading(r0, r0.getString(r1));
    }

    private static void lambda$show$11(Context r0, String r1, long r2) {
        UDToast.a r3 = UDToast.build(r0);
        r3.g(nullIsEmpty(r1));
        r3.b.d = r2;
        r3.a().show();
    }

    private static /* synthetic */ void lambda$show$8(Context r0, String r1, int r2) {
        UDToast.a r3 = UDToast.build(r0);
        r3.g(nullIsEmpty(r1));
        r3.d(r2);
        r3.a().show();
    }

    private static void lambda$show$9(Context r0, String r1, long r2) {
        UDToast.a r3 = UDToast.build(r0);
        r3.g(nullIsEmpty(r1));
        r3.b.d = r2;
        r3.a().show();
    }

    private static void lambda$showInCenter$10(Context r0, String r1, long r2) {
        UDToast.a r3 = UDToast.build(r0);
        r3.g(nullIsEmpty(r1));
        r3.b.d = r2;
        r3.a().show();
    }

    private static void lambda$showInCenter$12(Context r2, String r3, long r4) {
        UDToast.a r5 = UDToast.build(r2);
        r5.g(nullIsEmpty(r3));
        r5.b.c(17, 0, 0);
        r5.b.d = r4;
        r5.a().show();
    }

    public static b newGlobal(Context r2, int r3, String r4) {
        UDToast.a r1 = UDToast.build(r2);
        r1.g(nullIsEmpty(r4));
        r1.d(r3);
        return new b(r2, r1);
    }

    public static b newGlobalInCenter(Context r0, String r1, int r2) {
        return newGlobalInCenter(r0, r1);
    }

    public static void show(final Context r2, final String r3, boolean r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L12;
        if (r4 == false) goto L8;
        final long r0 = -2;
    L9:
        runOnUiThread(new j(r2, r3, r0));
        return;
    L8:
        r0 = -1;
        goto L9
    }

    public static void showInCenter(final Context r2, final String r3, boolean r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L12;
        if (r4 == false) goto L8;
        final long r0 = -2;
    L9:
        runOnUiThread(new q(r2, r3, r0));
        return;
    L8:
        r0 = -1;
        goto L9
    }

    public static b newGlobal(Context r0, String r1, int r2) {
        return newGlobal(r0, r1);
    }

    public static void show(final Context r1, final int r2, final String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new k(r1, r3, r2));
        return;
    }

    public static void showInCenter(final Context r1, final String r2, final long r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new e(r1, r2, r3));
        return;
    }

    public static void show(final Context r1, final String r2, final long r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new h(r1, r2, r3));
        return;
    }

    public static void showInCenter(Context r0, int r1, long r2) {
        showInCenter(r0, r0.getString(r1), r2);
    }

    public static void show(Context r0, int r1, int r2) {
        show(r0, r1, r0.getString(r2));
    }

    public static void showInCenter(Context r0, int r1, boolean r2) {
        showInCenter(r0, r0.getString(r1), r2);
    }

    public static void show(Context r0, int r1, long r2) {
        show(r0, r0.getString(r1), r2);
    }

    public static void show(Context r0, int r1, boolean r2) {
        show(r0, r0.getString(r1), r2);
    }

    private static void lambda$show$13(Context r0, String r1, int r2, long r3) {
        UDToast.a r4 = UDToast.build(r0);
        r4.g(nullIsEmpty(r1));
        r4.d(r2);
        r4.b.d = r3;
        r4.a().show();
    }

    public static void show(final Context r7, final int r8, final String r9, final long r10) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new f(r7, r9, r8, r10));
        return;
    }

    public static void show(Context r0, int r1, int r2, long r3) {
        show(r0, r1, r0.getString(r2), r3);
    }
}
