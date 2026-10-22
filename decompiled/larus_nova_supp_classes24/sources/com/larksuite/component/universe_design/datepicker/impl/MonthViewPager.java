package com.larksuite.component.universe_design.datepicker.impl;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import com.larksuite.component.universe_design.datepicker.impl.infinite.InfiniteViewPager;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o08.b;
import p08.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/MonthViewPager;", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "viewPageListener", "Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewListener;", "setViewPageListener", "", "initView", "scrollToPage", "offset", "", "getCenterViewHeight", "getCenterView", "Lcom/larksuite/component/universe_design/datepicker/impl/monthview/MonthView;", "getRightView", "getLeftView", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MonthViewPager extends InfiniteViewPager {
    public c h;

    public static final class a implements b {
        public final /* synthetic */ MonthViewPager a;
        public final /* synthetic */ int b;

        @Override // o08.b
        public final void a() {
            MonthCalendarViewAdapter r0 = (MonthCalendarViewAdapter) this.a.getAdapter();
            if (r0 == null) goto L5;
            r0.i();
        L5:
            int r1 = this.b;
            if (r1 >= 0) goto L10;
            c r2 = this.a.h;
            if (r2 == null) goto L15;
            r2.b();
            return;
        L15:
            return;
        L10:
            if (r1 <= 0) goto L17;
            c r3 = this.a.h;
            if (r3 == null) goto L18;
            r3.a();
            return;
        L18:
            return;
        }

        public a(MonthViewPager r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final q08.c getCenterView() {
        PagerAdapter r0 = getAdapter();
        if ((r0 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r1 = (MonthCalendarViewAdapter) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return (q08.c) r1.g(1);
    L5:
        r1 = null;
        goto L6
    }

    public final int getCenterViewHeight() {
        q08.c r0 = getCenterView();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentHeight();
    }

    public final q08.c getLeftView() {
        PagerAdapter r0 = getAdapter();
        if ((r0 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r1 = (MonthCalendarViewAdapter) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return (q08.c) r1.g(0);
    L5:
        r1 = null;
        goto L6
    }

    public final q08.c getRightView() {
        PagerAdapter r0 = getAdapter();
        if ((r0 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r1 = (MonthCalendarViewAdapter) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return (q08.c) r1.g(2);
    L5:
        r1 = null;
        goto L6
    }

    public MonthViewPager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void h(int r4) {
        if (r4 <= 0) goto L5;
        int r1 = 2;
    L6:
        this.e = true;
        this.b = false;
        setCurrentItem(r1, true);
        setOnSmoothScrollFinishListener(new a(this, r4));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void setViewPageListener(c r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MonthViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setWillNotDraw(false);
        setOffscreenPageLimit(3);
        m08.b r4 = new m08.b(this);
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.c != null) goto L5;
        this.c = new ArrayList();
    L5:
        List<o08.c> r5 = this.c;
        if (r5 == null) goto L9;
        ((ArrayList) r5).add(r4);
        return;
    }
}
