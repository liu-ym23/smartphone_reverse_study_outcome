package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingContentController {
    public static final /* synthetic */ int p = 0;
    public final mwb.e a;
    public final Lazy b;
    public Fragment c;
    public MmRecordingViewModel d;
    public MmRecordingPagerAdapter e;
    public g f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public List<? extends h> l;
    public boolean m;
    public boolean n;
    public Runnable o;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingUITab.values().length];
            r0[MmRecordingUITab.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmRecordingUITab.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MmRecordingContentController a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public c(MmRecordingContentController r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.a.a.b().getCurrentItem() != this.b) goto L6;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.CONTENT, "switchToTab", "post sync tab selected, reason=" + this.c + ", position=" + this.b, this.a.c());
            this.a.e(this.b, this.c + "_post", Intrinsics.areEqual(this.c, "goToSubtitle"));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final String c() {
        return (String) this.b.getValue();
    }

    public MmRecordingContentController(mwb.e r2) {
        Intrinsics.checkNotNullParameter(r2, "recordingView");
        this.a = r2;
        this.b = LazyKt.lazy(new MmRecordingContentController$logDetail$2(this));
        this.h = -1;
        this.i = -1;
        this.l = CollectionsKt.emptyList();
    }

    public static final void a(MmRecordingContentController r2) {
        ViewPager2 r0 = r2.a.b();
        if (r0.getWidth() <= 0) goto L6;
        r2.i = r0.getWidth();
        return;
    }

    public final void d(final MmRecordingFragment r4, final String r5) {
        if (this.n == false) goto L5;
        return;
    L5:
        Runnable r0 = this.o;
        if (r0 == null) goto L8;
        this.a.b().removeCallbacks(r0);
    L8:
        Runnable r1 = new MmRecordingContentController$scheduleDelayedViewPagerSetup$delayedSetup$1(this, r4, r5);
        this.o = r1;
        this.a.b().postDelayed(r1, 100);
    }

    public final void f(MmRecordingUITab r8, String r9) {
        Iterator<? extends h> r0 = this.l.iterator();
        int r2 = 0;
    L3:
        boolean r4 = true;
        if (r0.hasNext() == false) goto L12;
        if (r0.next().getTabType() != r8) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 < 0) goto L29;
        int r1 = this.a.b().getCurrentItem();
        com.larksuite.component.universe_design.tab.b r5 = this.a.a().getTabAt(r2);
        if (r5 == null) goto L21;
        View r6 = r5.e;
        if (r6 == null) goto L21;
        if (r6.isSelected() != true) goto L21;
    L22:
        int r7 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "switchToTab", "reason=" + r9 + ", tab=" + r8 + ", position=" + r2 + ", currentItem=" + r1 + ", isTabSelected=" + r4, c());
        if (r2 == r1) goto L25;
        this.a.b().setCurrentItem(r2, false);
    L25:
        e(r2, r9, Intrinsics.areEqual(r9, "goToSubtitle"));
        this.a.a().post(new c(this, r2, r9));
        return;
    L21:
        r4 = false;
        goto L22
    L29:
        return;
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }

    public final void e(int r5, String r6, boolean r7) {
        int r0 = this.a.a().getSelectPosition();
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "selectTabAt", "reason=" + r6 + ", position=" + r5 + ", currentSelectedPosition=" + r0 + ", forceIndicator=" + r7, c());
        if (r7 == false) goto L6;
        if (r0 != r5) goto L6;
        this.a.a().selectTabAt(-1);
    L6:
        this.a.a().selectTabAt(r5);
    }

    public final void b(MmRecordingViewModel r3, MmRecordingFragment r4, MmRecordingFragment r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        this.d = r3;
        this.c = r4;
        this.m = r6;
        List<? extends h> r7 = CollectionsKt.mutableListOf(new h[]{new i()});
        if (this.m == true) goto L5;
        r7.add(new j());
    L5:
        this.l = r7;
        if (this.m == false) goto L12;
        this.a.c().b.setVisibility(8);
        mwb.d r8 = this.a.i;
        if (r8 == null) goto L17;
        View r9 = r8.e;
        if (r9 == null) goto L17;
        r9.setVisibility(8);
    L17:
        this.e = new MmRecordingPagerAdapter(r4, this.l);
        this.a.b().setAdapter(this.e);
        d(r4, "bind");
        new UDTabLayoutCoordinator2(this.a.a(), this.a.b(), new f(this)).a();
        this.f = new g(this.a.a(), this.a.c().d);
        f(r3.getState().q, "restore");
        r3.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r5), MmRecordingContentController$subscribeTabState$1.INSTANCE, new MmRecordingContentController$subscribeTabState$2(this, null));
        r3.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r5), MmRecordingContentController$subscribeHintState$1.INSTANCE, new MmRecordingContentController$subscribeHintState$2(this, null));
        this.a.b().post(new com.ss.android.lark.officesdk.minutes.ui.record.recording.content.a(this));
        return;
    L12:
        this.a.c().b.setVisibility(0);
        mwb.d r10 = this.a.i;
        if (r10 == null) goto L17;
        View r11 = r10.e;
        if (r11 == null) goto L17;
        r11.setVisibility(0);
        goto L17
    }
}
