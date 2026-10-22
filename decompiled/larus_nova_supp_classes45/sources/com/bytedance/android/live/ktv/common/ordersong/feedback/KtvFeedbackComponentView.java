package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.utils.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002Ri\u0010\u0015\u001aI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvFeedbackComponentView;", "Landroid/widget/FrameLayout;", "", "", "issues", "", "setData", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "select", "issue", "", "index", "c", "Lkotlin/jvm/functions/Function3;", "getOnIssueSelectListener", "()Lkotlin/jvm/functions/Function3;", "setOnIssueSelectListener", "(Lkotlin/jvm/functions/Function3;)V", "onIssueSelectListener", "", "getSelectedSet", "()Ljava/util/List;", "selectedSet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvFeedbackComponentView extends FrameLayout {
    public Map<Integer, View> a;
    public final boolean b;
    public Function3<? super Boolean, ? super String, ? super Integer, Unit> c;

    public KtvFeedbackComponentView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvFeedbackComponentView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final List<String> getSelectedSet() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = UtilityKotlinExtentionsKt.g((ViewGroup) a(2131372274)).iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        View r2 = (View) r1.next();
        if (r2.isSelected() == false) goto L4;
        CharSequence r4 = null;
        if ((r2 instanceof TextView) == true) goto L10;
        r2 = null;
    L10:
        TextView r3 = (TextView) r2;
        if (r3 == null) goto L13;
        r4 = r3.getText();
    L13:
        r0.add(String.valueOf(r4));
        goto L4
    L14:
        return r0;
    }

    public final Function3<Boolean, String, Integer, Unit> getOnIssueSelectListener() {
        return this.c;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setData(List<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "issues");
        a(2131372274).removeAllViews();
        Iterator<T> r12 = r11.iterator();
        final int r2 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r3 = r12.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final String r5 = (String) r3;
        WrapLineFlowLayout r6 = a(2131372274);
        AppCompatTextView r7 = new KtvFeedbackTextView(getContext(), null, 6, 0);
        r7.setText(r5);
        r7.setOnClickListener(x0.a(new KtvFeedbackComponentView$setData$$inlined$forEachIndexed$lambda$1(r5, r2, this)));
        Unit r8 = Unit.INSTANCE;
        r6.addView(r7);
        r2 = r4;
        goto L4
    }

    public final void setOnIssueSelectListener(Function3<? super Boolean, ? super String, ? super Integer, Unit> r1) {
        this.c = r1;
    }

    public KtvFeedbackComponentView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r4).inflate(2131567727, this, true);
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130974340, 2130974574});
        String r8 = "";
        if (((Boolean) vm2.h.N1.getValue(null, vm2.h.a[142(0x8e, float:1.99E-43)])).booleanValue() == false) goto L8;
        this.b = false;
        TextView r9 = (TextView) a(2131372275);
        String r0 = s1.B(2131918441);
        if (r0 == null) goto L7;
        r8 = r0;
    L7:
        r9.setText(r8);
    L12:
        r7.recycle();
        int r11 = KtvOrderSongThemeManager.a;
        KtvOrderSongThemeManager.d((TextView) a(2131372275), 10);
        return;
    L8:
        this.b = r7.getBoolean(0, true);
        TextView r12 = (TextView) a(2131372275);
        String r1 = r7.getString(1);
        if (r1 == null) goto L11;
        r8 = r1;
    L11:
        r12.setText(r8);
        goto L12
    }

    public /* synthetic */ KtvFeedbackComponentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
