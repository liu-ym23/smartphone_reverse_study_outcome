package com.ss.android.lark.officewebview.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.r;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.n;
import swb.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l {
    public TextView a;

    public l() {
    }

    public final void c(WebView r13) {
        int r0 = com.ss.android.lark.officesdk.utils.di.g.a;
        if (com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.disable.chromium.debugger.view") == false) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "disable chromium debugger view,return");
        return;
    L6:
        if (r13 != null) goto L8;
    L46:
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "no parent，return");
        return;
    L8:
        if (r13.getParent() == null) goto L46;
        Context r1 = r13.getContext();
        int r2 = com.ss.android.lark.officesdk.utils.di.e.a;
        if (com.ss.android.lark.officesdk.utils.di.e.a.b(r1) == true) goto L13;
        return;
    L13:
        int r3 = r.a;
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("web_chromium_debugger_type", "key");
        if (r.a.a().e() == true) goto L17;
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "user closed");
        return;
    L17:
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "try add chromiumDebug View");
        if (this.a != null) goto L37;
        TextView r4 = new TextView(r13.getContext());
        Lazy<n> r5 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(r13);
        String r6 = r13.getSettings().getUserAgentString();
        String r8 = "system chromium---";
        if (TextUtils.isEmpty(r6) == true) goto L27;
        String[] r7 = r6.split(" ");
        int r9 = r7.length;
        int r10 = 0;
    L22:
        if (r10 >= r9) goto L27;
        String r11 = r7[r10];
        if (r11.startsWith("Chrome/") == true) goto L25;
        r10 = r10 + 1;
        goto L22
    L25:
        r8 = "system chromium---" + r11.split("/")[1];
    L27:
        String r12 = "current chromium is : " + r8;
        int r14 = r.a;
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        String r15 = "";
        Intrinsics.checkNotNullParameter("", "defaultValue");
        String r16 = r.a.a().getString();
        if (TextUtils.isEmpty(r16) == true) goto L31;
        r15 = "\nLast launch is : " + r16;
    L31:
        if (TextUtils.isEmpty(r8) == false) goto L33;
    L35:
        r4.setText("This will not be shown in the online app,you can close in debugger:\n" + r12 + r15);
        r4.setTextSize(10.0f);
        r4.setTextColor(FakePickerAvatarCreator.BLACK);
        GradientDrawable r17 = new GradientDrawable();
        r17.setColor(FakePickerAvatarCreator.GREEN);
        r4.setBackground(r17);
        r4.setAlpha(0.75f);
        r4.setVisibility(0);
        this.a = r4;
        goto L37
    L33:
        if (TextUtils.equals(r8, r16) == true) goto L35;
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r.a.a().b(r8);
    L37:
        if ((r13.getParent() instanceof FrameLayout) == false) goto L40;
        a(true, (FrameLayout) r13.getParent());
        return;
    L40:
        if ((r13.getParent().getParent() instanceof ConstraintLayout) == false) goto L43;
        b(true, (ConstraintLayout) r13.getParent().getParent());
        return;
    L43:
        if ((r13.getParent().getParent() instanceof FrameLayout) == false) goto L52;
        a(true, (FrameLayout) r13.getParent().getParent());
        return;
    }

    public final void a(boolean r4, FrameLayout r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if ((r5 instanceof ScrollView) == false) goto L7;
        return;
    L7:
        if (r5.indexOfChild(this.a) < 0) goto L11;
        if (r4 == true) goto L17;
        r5.removeView(this.a);
        return;
    L17:
        return;
    L11:
        if (r4 == true) goto L13;
        return;
    L13:
        if (this.a.getParent() == null) goto L15;
        ((FrameLayout) this.a.getParent()).removeView(this.a);
    L15:
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -2, 83);
        r5.addView(this.a, r6);
    }

    public final void b(boolean r4, ConstraintLayout r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.indexOfChild(this.a) < 0) goto L9;
        if (r4 == true) goto L15;
        r5.removeView(this.a);
        return;
    L15:
        return;
    L9:
        if (r4 == true) goto L11;
        return;
    L11:
        if (this.a.getParent() == null) goto L13;
        ((FrameLayout) this.a.getParent()).removeView(this.a);
    L13:
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(-1, -2);
        r6.bottomToBottom = 0;
        r6.setMargins(0, 0, 0, p.a(r5.getContext(), 40.0f));
        r5.addView(this.a, r6);
    }
}
