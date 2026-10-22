package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.interactivity.api.highlight.indicator.LiveDuxCarouselIndicator;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.PinContainerAppLogger;
import com.bytedance.android.livesdk.interactivity.pin.ui.HighlightViewPager;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/container/v2/PinWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "Lg42/g;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinWidget extends RoomWidget implements g42.g, Observer<KVData> {
    public HighlightViewPager b;
    public LiveDuxCarouselIndicator c;
    public final List<g42.b> d;
    public final List<Pair<HighlightItem, g42.e>> e;
    public final com.bytedance.android.livesdk.interactivity.pin.ui.a f;
    public AnonymousClass1 g;
    public o92.b h;
    public com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b i;
    public String j;
    public Boolean k;
    public final h l;
    public final g42.c m;

    public static final class a extends PagerAdapter {
        public final List<Pair<HighlightItem, g42.e>> a;

        public final int getCount() {
            return this.a.size();
        }

        public a(List<? extends Pair<HighlightItem, ? extends g42.e>> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }

        public final Object instantiateItem(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            View r4 = ((g42.e) ((Pair) ListProtector.get(this.a, r3)).getSecond()).getView();
            r2.addView(r4);
            return r4;
        }

        public final boolean isViewFromObject(View r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "object");
            return Intrinsics.areEqual(r2, r3);
        }

        public final void destroyItem(ViewGroup r1, int r2, Object r3) {
            Intrinsics.checkNotNullParameter(r1, "container");
            Intrinsics.checkNotNullParameter(r3, "object");
            r1.removeView((View) r3);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PinWidget a;

        public b(PinWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            List<HighlightItem> r11 = (List) r10;
            PinWidget r0 = this.a;
            Iterator r1 = ((ArrayList) r0.e).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Pair r2 = (Pair) r1.next();
            ((g42.e) r2.getSecond()).b(r0.m, (HighlightItem) r2.getFirst());
            goto L4
        L6:
            ((ArrayList) r0.e).clear();
            if (r11.isEmpty() == false) goto L14;
            o32.a.a("highlight items is empty");
            HighlightViewPager r13 = r0.b;
            if (r13 == null) goto L11;
            r13.setAdapter(null);
        L11:
            com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r14 = r0.i;
            if (r14 == null) goto L52;
            r14.a(CollectionsKt.emptyList());
            return;
        L52:
            return;
        L14:
            ViewPager r3 = r0.b;
            if (r3 == null) goto L54;
            List<Pair<HighlightItem, g42.e>> r4 = r0.e;
            Iterator<T> r5 = r11.iterator();
        L19:
            if (r5.hasNext() == false) goto L26;
            HighlightItem r6 = (HighlightItem) r5.next();
            Context r7 = r3.getContext();
            g42.f r8 = r0.m.m(r6);
            if (r8 == null) goto L24;
            g42.e r9 = r8.o(r7);
            if (r9 == null) goto L24;
        L25:
            r9.c(((Widget) r0).dataCenter, r0.m, r6);
            Pair r15 = new Pair(r6, r9);
            ((ArrayList) r4).add(r15);
        L24:
            r9 = new i(r7);
            goto L25
        L26:
            r3.setAdapter(new a(r0.e));
            LiveDuxCarouselIndicator r16 = r0.c;
            if (r16 == null) goto L29;
            r16.setViewPager(r3);
        L29:
            com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r17 = r0.i;
            if (r17 == null) goto L32;
            r17.a(r11);
        L32:
            o92.b r18 = r0.h;
            if (r18 == null) goto L38;
            Disposable r19 = r18.a;
            if (r19 == null) goto L37;
            r19.dispose();
        L37:
            r18.a = null;
        L38:
            r0.h = new o92.b(r3, Math.max(15000, r0.m.e()));
            if (((ArrayList) r0.e).size() > 1) goto L43;
            LiveDuxCarouselIndicator r110 = r0.c;
            if (r110 == null) goto L46;
            UtilityKotlinExtentionsKt.t(r110);
        L46:
            r3.post(new j(r0, r3));
            return;
        L43:
            LiveDuxCarouselIndicator r111 = r0.c;
            if (r111 == null) goto L46;
            UtilityKotlinExtentionsKt.w(r111);
            goto L46
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.pin.container.v2.PinWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/interactivity/pin/container/v2/PinWidget$onCreate$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 implements ViewPager.OnPageChangeListener {
        public boolean a;
        public final /* synthetic */ PinWidget b;
        public final /* synthetic */ HighlightViewPager c;

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public final void onPageScrollStateChanged(int r2) {
            if (r2 != 0) goto L4;
            this.a = false;
            return;
        L4:
            if (r2 != 1) goto L10;
            this.a = true;
            return;
        }

        public final void onPageSelected(int r7) {
            Pair r8 = (Pair) CollectionsKt.getOrNull(this.b.e, r7);
            if (r8 != null) goto L5;
            return;
        L5:
            g42.e r0 = (g42.e) r8.getSecond();
            HighlightItem r9 = (HighlightItem) r8.getFirst();
            int r1 = r0.getContentHeight();
            if (r1 != 0) goto L8;
            r0.getView().measure(0, 0);
            r1 = r0.getView().getMeasuredHeight();
            o32.a.a("get page content error, measureHeight = " + r1);
        L8:
            int r2 = Math.max(r0.getMinHeight(), r1);
            com.bytedance.android.livesdk.interactivity.pin.ui.a r3 = this.b.f;
            r3.c = r2;
            r3.invalidateSelf();
            this.c.setContentHeight(r2);
            Iterator r4 = ((ArrayList) this.b.d).iterator();
        L10:
            if (r4.hasNext() == false) goto L12;
            ((g42.b) r4.next()).onPageSelected();
            goto L10
        L12:
            String r5 = this.b.m.c(r9);
            boolean r6 = this.b.m.i(r9);
            if ((!Intrinsics.areEqual(r5, this.b.j)) == false) goto L15;
        L16:
            r0.a(r9);
            if (this.a == false) goto L19;
            String r10 = "user";
        L20:
            PinWidget r11 = this.b;
            g42.f r13 = r11.m.m(r9);
            if (r13 == null) goto L23;
            PinType r14 = r13.f();
        L24:
            int r15 = PinContainerAppLogger.a;
            PinContainerAppLogger.g(r9, r14, r10, r11.m.g(r14));
        L25:
            PinWidget r16 = this.b;
            r16.j = r5;
            r16.k = Boolean.valueOf(r6);
            return;
        L23:
            r14 = null;
            goto L24
        L19:
            r10 = "auto";
            goto L20
        L15:
            if ((!Intrinsics.areEqual(Boolean.valueOf(r6), this.b.k)) == false) goto L25;
            goto L16
        }

        public AnonymousClass1(PinWidget r1, HighlightViewPager r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public final int getLayoutId() {
        return 2131566663;
    }

    public final void onDestroy() {
        this.m.d(this);
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        ((ArrayList) this.e).clear();
        SSViewPager r0 = this.b;
        o32.b r1 = null;
        if (r0 == null) goto L5;
        r0.setBackground(null);
    L5:
        HighlightViewPager r2 = this.b;
        if (r2 == null) goto L8;
        r2.clearOnPageChangeListeners();
    L8:
        HighlightViewPager r3 = this.b;
        if (r3 == null) goto L11;
        r3.setAdapter(null);
    L11:
        o92.b r4 = this.h;
        if (r4 == null) goto L17;
        Disposable r5 = r4.a;
        if (r5 == null) goto L16;
        r5.dispose();
    L16:
        r4.a = null;
    L17:
        Iterator r6 = ((ArrayList) this.e).iterator();
    L19:
        if (r6.hasNext() == false) goto L21;
        Pair r7 = (Pair) r6.next();
        ((g42.e) r7.getSecond()).b(this.m, (HighlightItem) r7.getFirst());
        goto L19
    L21:
        ((ArrayList) this.d).clear();
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r8 = this.i;
        if (r8 == null) goto L24;
        r8.a(CollectionsKt.emptyList());
    L24:
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r9 = this.i;
        if (r9 == null) goto L27;
        ((LinkedHashMap) r9.a).clear();
    L27:
        this.i = null;
        this.j = null;
        this.k = null;
        o32.b r10 = o.a();
        if (r10 != null) goto L30;
        return;
    L30:
        if ((!r10.getCleared()) == false) goto L32;
        r1 = r10;
    L32:
        if (r1 == null) goto L39;
        m<Boolean> r11 = r1.isPinContainerShown();
        if (r11 == null) goto L40;
        r11.setValue(Boolean.FALSE);
        return;
    L40:
        return;
    }

    public final void onCreate() {
        super.onCreate();
        this.b = (HighlightViewPager) findViewById(2131370405);
        this.c = (LiveDuxCarouselIndicator) findViewById(2131370407);
        HighlightViewPager r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.i = new com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b(this.m);
        AnonymousClass1 r1 = new AnonymousClass1(this, r0);
        this.g = r1;
        r0.addOnPageChangeListener(r1);
        ((ObservableSubscribeProxy) this.m.k().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b(this));
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        DataCenter r3 = r2.observe("cmd_anchor_broadcast_end", this);
        if (r3 == null) goto L10;
        r3.observe("cmd_change_interactivity_component_visibility", this);
    L10:
        o32.b r4 = o.a();
        if (r4 == null) goto L15;
        m<Boolean> r5 = r4.isPinContainerShown();
        if (r5 == null) goto L15;
        r5.setValue(Boolean.TRUE);
    L15:
        this.m.a(this);
    }

    public PinWidget(PinContainerHighlightProcessor r2) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        this.m = r2;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new com.bytedance.android.livesdk.interactivity.pin.ui.a(ColorProtector.parseColor("#B2FFFFFF"));
        this.l = new h(new k(this));
    }

    public final void onChanged(Object r13) {
        KVData r14 = (KVData) r13;
        if (r14 == null) goto L56;
        String r0 = r14.getKey();
        int r1 = r0.hashCode();
        Object r3 = null;
        if (r1 == (-1677062600)) goto L23;
        if (r1 == (-826138222)) goto L11;
        return;
    L11:
        if (r0.equals("cmd_change_interactivity_component_visibility") == false) goto L51;
        Object r15 = r14.getData();
        if ((r15 instanceof cc2.e) == false) goto L16;
        r3 = r15;
    L16:
        cc2.e r4 = (cc2.e) r3;
        if (r4 == null) goto L52;
        cc2.f r16 = r4.b(cc2.k.class);
        if (r16 == null) goto L58;
        this.l.e(r16.a, r16.b);
        return;
    L58:
        return;
    L52:
        return;
    L51:
        return;
    L23:
        if (r0.equals("cmd_anchor_broadcast_end") == true) goto L25;
        return;
    L25:
        if (z.e(this.m.getDataCenter(), false) == false) goto L44;
        Iterator r17 = ((ArrayList) this.e).iterator();
    L28:
        if (r17.hasNext() == false) goto L44;
        HighlightItem r5 = (HighlightItem) ((Pair) r17.next()).getFirst();
        g42.f r2 = this.m.m(r5);
        if (r2 == null) goto L32;
        PinType r6 = r2.f();
    L33:
        if (r2 == null) goto L35;
        com.bytedance.android.livesdk.wrds.syncdata.highlight.b r7 = r2.q(r5);
    L36:
        if (r7 == null) goto L38;
        long r8 = r7.getMessageId();
    L39:
        if (r7 == null) goto L42;
        String r9 = r7.getCommentContent();
        if (r9 == null) goto L42;
    L43:
        String r10 = r9;
        int r11 = PinContainerAppLogger.a;
        PinContainerAppLogger.f(r5, r6, r8, r10, z.e(((Widget) this).dataCenter, false), "live_end", this.m.g(r6));
    L42:
        r9 = BuildConfig.FLAVOR;
        goto L43
    L38:
        r8 = 0;
        goto L39
    L35:
        r7 = null;
        goto L36
    L32:
        r6 = null;
    L44:
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r18 = this.i;
        if (r18 == null) goto L55;
        r18.a(CollectionsKt.emptyList());
        return;
    L55:
        return;
    }
}
