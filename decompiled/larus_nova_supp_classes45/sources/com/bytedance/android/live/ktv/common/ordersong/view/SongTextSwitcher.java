package com.bytedance.android.live.ktv.common.ordersong.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R?\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R?\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/view/SongTextSwitcher;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/widget/LinearLayout;", "getBubbleContentView", "", "", "datas", "", "setSwitcherTextList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "e", "Lkotlin/jvm/functions/Function1;", "getOnTextSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTextSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "onTextSelectedListener", "", "isDismiss", "f", "getOnWindowStateListener", "setOnWindowStateListener", "onWindowStateListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SongTextSwitcher extends AppCompatTextView {
    public List<String> a;
    public final int b;
    public final float c;
    public c90.a d;
    public Function1<? super String, Unit> e;
    public Function1<? super Boolean, Unit> f;
    public boolean g;
    public boolean h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ SongTextSwitcher b;

        public a(String r1, SongTextSwitcher r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.b.y(this.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LinearLayout getBubbleContentView() {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(1);
        KtvOrderSongThemeManager.b(r0, 1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r0.setGravity(17);
        List<String> r2 = this.a;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.size();
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L14;
        List<String> r6 = this.a;
        Intrinsics.checkNotNull(r6);
        String r7 = (String) ListProtector.get(r6, r5);
        TextView r8 = new TextView(r0.getContext());
        r8.setGravity(19);
        r8.setLayoutParams(new LinearLayout.LayoutParams(-2, s1.f(37.0f)));
        r8.setText(r7);
        r8.setMinWidth(s1.f(107.0f));
        r8.setLines(1);
        r8.setTextSize(this.c);
        r8.setTextColor(this.b);
        if (Intrinsics.areEqual(getText(), r7) == false) goto L9;
        Drawable r9 = s1.m(2131251814);
        r9.setBounds(0, 0, s1.f(13.0f), s1.f(12.0f));
        r8.setCompoundDrawables(null, null, r9, null);
        r8.setCompoundDrawablePadding(s1.f(8.0f));
    L10:
        r8.setOnClickListener(new a(r7, this));
        r8.setPadding(s1.f(12.0f), 0, s1.f(12.0f), 0);
        r0.addView(r8);
        List<String> r11 = this.a;
        Intrinsics.checkNotNull(r11);
        if (r5 >= (r11.size() - 1)) goto L13;
        View r12 = new View(r0.getContext());
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, s1.f(0.5f)));
        r12.setBackgroundColor(ColorProtector.parseColor("#1f161823"));
        r0.addView(r12);
    L13:
        r5 = r5 + 1;
        goto L5
    L9:
        r8.setCompoundDrawables(null, null, null, null);
    L14:
        a1.l(r0, s1.f(10.0f));
        return r0;
    }

    public final Function1<String, Unit> getOnTextSelectedListener() {
        return this.e;
    }

    public final Function1<Boolean, Unit> getOnWindowStateListener() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.widget.PopupWindow, c90.a, com.bytedance.android.livesdk.popup.manager.LivePopupWindow] */
    public static final void x(SongTextSwitcher r6) {
        if (r6.g == true) goto L19;
        Activity r0 = ContextUtil.contextToActivity(r6.getContext());
        if (r0 == null) goto L20;
        c90.a.C0006a r1 = new c90.a.C0006a(r0);
        LinearLayout r2 = r6.getBubbleContentView();
        Intrinsics.checkNotNullParameter(r2, "view");
        r1.g = r2;
        r1.f = false;
        r1.r = true;
        r1.e = -1;
        r1.h = s1.f(112.0f) + ((int) UIUtils.dip2Px(r1.x, 14.0f));
        r1.i = s1.f(89.0f) + ((int) UIUtils.dip2Px(r1.x, 14.0f));
        r1.a = -1;
        r1.b = false;
        r1.s = true;
        b r3 = new b(r6);
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.n = r3;
        c r4 = new c(r6);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r1.o = r4;
        ?? r5 = new c90.a(r1);
        Lazy r7 = KtvSettingHelper.z;
        if (((Boolean) r7.getValue()).booleanValue() == false) goto L11;
        ((LivePopupWindow) r5).b = 10;
    L11:
        r5.setTouchable(true);
        r5.setFocusable(true);
        r5.setOutsideTouchable(true);
        Unit r8 = Unit.INSTANCE;
        r6.d = r5;
        r5.i(r6, 80, true);
        Function1<? super Boolean, Unit> r9 = r6.f;
        if (r9 == null) goto L14;
        Unit r11 = (Unit) r9.invoke(Boolean.FALSE);
    L14:
        r6.g = true;
        if (((Boolean) r7.getValue()).booleanValue() == false) goto L18;
        r6.postDelayed(new com.bytedance.android.live.ktv.common.ordersong.view.a(r6), 2000);
        return;
    L18:
        return;
    L20:
        return;
    }

    public final void setOnTextSelectedListener(Function1<? super String, Unit> r1) {
        this.e = r1;
    }

    public final void setOnWindowStateListener(Function1<? super Boolean, Unit> r1) {
        this.f = r1;
    }

    public final void setSwitcherTextList(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "datas");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        setText(r2);
        Function1<? super String, Unit> r0 = this.e;
        if (r0 == null) goto L5;
        Unit r3 = (Unit) r0.invoke(r2);
    L5:
        c90.a r4 = this.d;
        if (r4 == null) goto L8;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
    L8:
        this.g = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SongTextSwitcher(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        int r5 = KtvOrderSongThemeManager.a(10);
        this.b = r5;
        float r6 = s1.e(4.5f);
        this.c = r6;
        setOnClickListener(x0.a(new AnonymousClass1(this)));
        setGravity(17);
        setTextColor(r5);
        setTextSize(r6);
        Drawable r7 = s1.m(2131251813);
        r7.setBounds(0, 0, s1.f(12.0f), s1.f(11.0f));
        setCompoundDrawables(null, null, r7, null);
        setCompoundDrawablePadding(s1.f(6.0f));
    }
}
