package com.larksuite.component.card.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.layout.WindowMetricsCalculator;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardHostInfoManager implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final a f = null;
    public final Context a;
    public final ILarkLynxContainer b;
    public Size c;
    public final b d;
    public final Set<c> e;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/card/utils/UniversalCardHostInfoManager$HostInfo;", "Ljava/io/Serializable;", "pageSize", "Lcom/larksuite/component/card/utils/UniversalCardHostInfoManager$PageSize;", "statusBarHeight", "", "overlayWidth", "overlayHeight", "<init>", "(Lcom/larksuite/component/card/utils/UniversalCardHostInfoManager$PageSize;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPageSize", "()Lcom/larksuite/component/card/utils/UniversalCardHostInfoManager$PageSize;", "getStatusBarHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOverlayWidth", "getOverlayHeight", "component1", "component2", "component3", "component4", "copy", "(Lcom/larksuite/component/card/utils/UniversalCardHostInfoManager$PageSize;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larksuite/component/card/utils/UniversalCardHostInfoManager$HostInfo;", "equals", "", "other", "", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class HostInfo implements Serializable {
        private final Integer overlayHeight;
        private final Integer overlayWidth;
        private final PageSize pageSize;
        private final Integer statusBarHeight;

        public static /* synthetic */ HostInfo copy$default(HostInfo r0, PageSize r1, Integer r2, Integer r3, Integer r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.pageSize;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.statusBarHeight;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.overlayWidth;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.overlayHeight;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final PageSize component1() {
            return this.pageSize;
        }

        public final Integer component2() {
            return this.statusBarHeight;
        }

        public final Integer component3() {
            return this.overlayWidth;
        }

        public final Integer component4() {
            return this.overlayHeight;
        }

        public final HostInfo copy(PageSize r2, Integer r3, Integer r4, Integer r5) {
            return new HostInfo(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof HostInfo) == true) goto L8;
            return false;
        L8:
            HostInfo r6 = (HostInfo) r5;
            if (this.pageSize == r6.pageSize) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.statusBarHeight, r6.statusBarHeight) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.overlayWidth, r6.overlayWidth) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.overlayHeight, r6.overlayHeight) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            PageSize r0 = this.pageSize;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.statusBarHeight;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.overlayWidth;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.overlayHeight;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "HostInfo(pageSize=" + this.pageSize + ", statusBarHeight=" + this.statusBarHeight + ", overlayWidth=" + this.overlayWidth + ", overlayHeight=" + this.overlayHeight + ')';
        }

        public final Integer getOverlayHeight() {
            return this.overlayHeight;
        }

        public final Integer getOverlayWidth() {
            return this.overlayWidth;
        }

        public final PageSize getPageSize() {
            return this.pageSize;
        }

        public final Integer getStatusBarHeight() {
            return this.statusBarHeight;
        }

        public HostInfo(PageSize r1, Integer r2, Integer r3, Integer r4) {
            this.pageSize = r1;
            this.statusBarHeight = r2;
            this.overlayWidth = r3;
            this.overlayHeight = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/utils/UniversalCardHostInfoManager$PageSize;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NORMAL", "WIDE", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PageSize extends Enum<PageSize> {
        public static final PageSize NORMAL = null;
        public static final PageSize WIDE = null;
        public static final /* synthetic */ PageSize[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<PageSize> getEntries() {
            return b;
        }

        static {
            PageSize r0 = new PageSize("NORMAL", 0, "normal");
            NORMAL = r0;
            PageSize r1 = new PageSize("WIDE", 1, "wide");
            WIDE = r1;
            PageSize[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static PageSize[] values() {
            return (PageSize[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static PageSize valueOf(String r1) {
            return (PageSize) r27.a.a(PageSize.class, r1);
        }

        public PageSize(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }

        public static Size a(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            int r0 = UIUtils.getNavigationBarHeight(r7);
            Activity r1 = UIUtils.getActivityFromContext(r7);
            if (r1 == null) goto L6;
            Rect r8 = WindowMetricsCalculator.Companion.getOrCreate().computeCurrentWindowMetrics(r1).getBounds();
            Log.d("UniversalCardHostWindowManager", "getWindowAvailSize using WindowMetricsCalculator, " + r8.width() + 'x' + r8.height() + ", navBarHeight=" + r0);
            return new Size(r8.width(), RangesKt.coerceAtLeast(r8.height() - r0, 0));
        L6:
            Object r9 = r7.getSystemService("window");
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager r10 = (WindowManager) r9;
            if (Build.VERSION.SDK_INT < 30) goto L9;
            Rect r11 = r10.getCurrentWindowMetrics().getBounds();
            Log.d("UniversalCardHostWindowManager", "getWindowAvailSize using windowMetrics, " + r11.width() + 'x' + r11.height() + ", navBarHeight=" + r0);
            return new Size(r11.width(), RangesKt.coerceAtLeast(r11.height() - r0, 0));
        L9:
            DisplayMetrics r2 = new DisplayMetrics();
            r10.getDefaultDisplay().getMetrics(r2);
            Log.d("UniversalCardHostWindowManager", "getWindowAvailSize using displayMetrics, " + r2.widthPixels + 'x' + r2.heightPixels + ", navBarHeight=" + r0);
            return new Size(r2.widthPixels, r2.heightPixels);
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final WeakReference<UniversalCardHostInfoManager> a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            UniversalCardHostInfoManager r0 = this.a.get();
            if (r0 == null) goto L6;
            r0.onGlobalLayout();
            return;
        }

        public b(UniversalCardHostInfoManager r2) {
            Intrinsics.checkNotNullParameter(r2, "hostInfoManager");
            this.a = new WeakReference(r2);
        }
    }

    public interface c {
        void a(Size r1);
    }

    static {
        f = new a();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a r0 = f;
        Context r1 = this.a;
        r0.getClass();
        Size r2 = a.a(r1);
        if (this.c.getWidth() > 0) goto L5;
    L22:
        this.c = r2;
        return;
    L5:
        if (this.c.getHeight() <= 0) goto L22;
        if (r2.getWidth() <= 0) goto L22;
        if (r2.getHeight() <= 0) goto L22;
        if (Intrinsics.areEqual(r2, this.c) == true) goto L22;
        Log.d("UniversalCardHostWindowManager", "window size change: " + r2.getWidth() + 'x' + r2.getHeight());
        Iterator<T> r3 = this.e.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        ((c) r3.next()).a(r2);
        goto L14
    L16:
        LynxView r4 = this.b.getLynxView();
        if ((r4 instanceof LynxView) == false) goto L19;
        LynxView r5 = r4;
    L20:
        if (r5 == null) goto L22;
        JavaOnlyArray r6 = new JavaOnlyArray();
        JavaOnlyMap r7 = new JavaOnlyMap();
        r7.put("overlayWidth", Integer.valueOf(r2.getWidth()));
        r7.put("overlayHeight", Integer.valueOf(r2.getHeight()));
        r6.pushMap(r7);
        r5.sendGlobalEvent("universalcardHostInfoChange", r6);
        goto L22
    L19:
        r5 = null;
        goto L20
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public UniversalCardHostInfoManager(Context r2, ILarkLynxContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lynxContainer");
        this.a = r2;
        this.b = r3;
        this.c = new Size(0, 0);
        this.d = new b(this);
        this.e = Collections.newSetFromMap(new WeakHashMap());
    }
}
