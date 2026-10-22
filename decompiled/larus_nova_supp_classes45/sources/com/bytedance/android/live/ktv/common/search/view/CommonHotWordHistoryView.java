package com.bytedance.android.live.ktv.common.search.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J@\u0010\f\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003H\u0016J+\u0010\u000f\u001a\u00020\n2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\rH\u0016R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonHotWordHistoryView;", "Landroid/widget/FrameLayout;", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "word", "", "isHistory", "", "hotWordHistoryClickAction", "setHotWordHistoryClickAction", "Lkotlin/Function1;", "historyRemoveAction", "setHistoryRemoveAction", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getTitle", "()Landroid/widget/TextView;", "title", "Lcom/bytedance/android/live/uikit/layout/WrapLineFlowLayout;", "b", "getContainer", "()Lcom/bytedance/android/live/uikit/layout/WrapLineFlowLayout;", KtvSubElement.CONTAINER, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonHotWordHistoryView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public Function2<? super String, ? super Boolean, Unit> c;
    public Function1<? super String, Unit> d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    public CommonHotWordHistoryView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonHotWordHistoryView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final WrapLineFlowLayout getContainer() {
        return (WrapLineFlowLayout) this.b.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.a.getValue();
    }

    public void setHistoryRemoveAction(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "historyRemoveAction");
        this.d = r2;
    }

    public void setHotWordHistoryClickAction(Function2<? super String, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "hotWordHistoryClickAction");
        this.c = r2;
    }

    public final void a(boolean r6, List<u> r7) {
        WrapLineFlowLayout r0 = getContainer();
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ALogger.i("CommonHotWordHistoryView", "words:" + r7.size());
        Iterator<T> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L28;
        u r1 = (u) r8.next();
        if (this.e == false) goto L13;
        if (r6 == false) goto L12;
        int r2 = 2131566466;
    L16:
        View r3 = LayoutInflater.from(getContext()).inflate(r2, getContainer(), false);
        TextView r4 = (TextView) r3.findViewById(2131367794);
        if (r4 == null) goto L19;
        KtvOrderSongThemeManager.d(r4, KtvOrderSongThemeManager.f);
        KtvOrderSongThemeManager.c(r4, KtvOrderSongThemeManager.g);
        r4.setAlpha(1.0f);
        r4.setTag(r1.a());
        r4.setText(r1.a());
        r4.setOnClickListener(new com.bytedance.android.live.ktv.common.search.view.a(this, r6));
    L19:
        View r5 = r3.findViewById(2131384273);
        if (r5 == null) goto L22;
        KtvOrderSongThemeManager.c(r5, KtvOrderSongThemeManager.l);
    L22:
        FrameLayout r9 = (FrameLayout) r3.findViewById(2131384269);
        if (r9 == null) goto L25;
        r9.setTag(r1.a());
        r9.setOnClickListener(new b(this));
    L25:
        WrapLineFlowLayout r11 = getContainer();
        if (r11 == null) goto L7;
        r11.addView(r3);
        goto L7
    L12:
        r2 = 2131566470;
        goto L16
    L13:
        if (r6 == false) goto L15;
        r2 = 2131566465;
        goto L16
    L15:
        r2 = 2131566469;
        goto L16
    }

    public final void b(int r5, List<u> r6) {
        List<u> r0 = r6;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        UtilityKotlinExtentionsKt.t(this);
        return;
    L11:
        UtilityKotlinExtentionsKt.w(this);
        TextView r2 = getTitle();
        if (r2 == null) goto L14;
        KtvOrderSongThemeManager.d(r2, 200);
    L14:
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L28;
        TextView r7 = getTitle();
        if (r7 == null) goto L20;
        r7.setText(s1.B(2131918576));
    L20:
        a(false, r6);
        return;
    L28:
        return;
    L21:
        TextView r8 = getTitle();
        if (r8 == null) goto L24;
        r8.setText(s1.B(2131918575));
    L24:
        a(true, r6);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public CommonHotWordHistoryView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = LazyKt.lazy(new CommonHotWordHistoryView$title$2(this));
        this.b = LazyKt.lazy(new CommonHotWordHistoryView$container$2(this));
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130973967});
        boolean r7 = r6.getBoolean(0, false);
        this.e = r7;
        r6.recycle();
        if (r7 == false) goto L5;
        int r8 = 2131566468;
    L6:
        LayoutInflater.from(r3).inflate(r8, this);
        return;
    L5:
        r8 = 2131566467;
        goto L6
    }

    public /* synthetic */ CommonHotWordHistoryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
