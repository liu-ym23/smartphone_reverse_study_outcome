package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.base.model.user.MyLiveTab;
import com.bytedance.android.live.base.model.user.MyLiveTabs;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils.TabDataHelper;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.tabs.TabLayout;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileTabsComponent extends com.bytedance.android.live.profile.ui.base.k {
    public static final int m = 0;
    public static final int n = 0;
    public List<b> b;
    public View c;
    public View d;
    public TabLayout e;
    public View f;
    public ViewPager2 g;
    public m h;
    public final CompositeDisposable i;
    public int j;
    public final h k;
    public final com.bytedance.android.live.profile.ui.base.h l;

    public static final class a {
    }

    public interface b {
        void a(int r1, boolean r2);
    }

    public static final class c implements m.b {
        public final HashSet<Integer> a;
        public final /* synthetic */ ProfileTabsComponent b;
        public final /* synthetic */ TabLayout c;
        public final /* synthetic */ List d;
        public final /* synthetic */ MyLiveTabs e;

        public final int c() {
            List r0 = this.e.getTabs();
            if (r0 == null) goto L14;
            Iterator r1 = r0.iterator();
            int r2 = 0;
        L6:
            if (r1.hasNext() == false) goto L18;
            Object r3 = r1.next();
            int r4 = r2 + 1;
            if (r2 >= 0) goto L11;
            CollectionsKt.throwIndexOverflow();
        L11:
            if (Intrinsics.areEqual(((MyLiveTab) r3).getBizName(), this.e.getDefaultTab()) == true) goto L12;
            r2 = r4;
            goto L6
        L12:
            return r2;
        L18:
            return -1;
        L14:
            return -1;
        }

        @Override // com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.m.b
        public final void b(int r9) {
            List<b> r0 = this.b.b;
            if (r0 == null) goto L8;
            Iterator r1 = ((ArrayList) r0).iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            ((b) r1.next()).a(r9, !this.a.contains(Integer.valueOf(r9)));
        L8:
            this.a.add(Integer.valueOf(r9));
            int r2 = this.c.getTabCount();
            int r3 = 0;
        L9:
            if (r3 >= r2) goto L31;
            TabLayout.Tab r4 = this.c.getTabAt(r3);
            View r5 = null;
            if (r4 == null) goto L13;
            View r6 = r4.getCustomView();
        L15:
            if ((r6 instanceof TextView) == false) goto L18;
            r5 = r6;
        L18:
            TextView r7 = (TextView) r5;
            if (r4 != null) goto L21;
        L26:
            if (r7 == null) goto L28;
            r7.setTextColor(ProfileTabsComponent.m);
        L28:
            if (r7 == null) goto L30;
            r7.setTypeface(Typeface.defaultFromStyle(0));
        L30:
            r3 = r3 + 1;
            goto L9
        L21:
            if (r4.getPosition() != r9) goto L26;
            if (r7 == null) goto L24;
            r7.setTextColor(ProfileTabsComponent.n);
        L24:
            if (r7 == null) goto L30;
            r7.setTypeface(Typeface.defaultFromStyle(1));
            goto L30
        L13:
            r6 = null;
            goto L15
        L31:
            ProfileTabsComponent r8 = this.b;
            String r10 = "";
            if (r8.j < 0) goto L49;
            List r12 = this.e.getTabs();
            if (r12 == null) goto L39;
            MyLiveTab r13 = (MyLiveTab) CollectionsKt.getOrNull(r12, this.b.j);
            if (r13 == null) goto L39;
            String r14 = r13.getBizName();
            if (r14 == null) goto L39;
        L40:
            List r15 = this.e.getTabs();
            if (r15 == null) goto L48;
            MyLiveTab r16 = (MyLiveTab) CollectionsKt.getOrNull(r15, r9);
            if (r16 == null) goto L48;
            String r17 = r16.getBizName();
            if (r17 == null) goto L48;
            r10 = r17;
        L48:
            ProfileTabsComponent.j(r8, r14, r10);
        L58:
            this.b.j = r9;
            return;
        L39:
            r14 = "";
            goto L40
        L49:
            List r18 = this.e.getTabs();
            if (r18 == null) goto L57;
            MyLiveTab r19 = (MyLiveTab) CollectionsKt.getOrNull(r18, r9);
            if (r19 == null) goto L57;
            String r20 = r19.getBizName();
            if (r20 == null) goto L57;
            r10 = r20;
        L57:
            ProfileTabsComponent.j(r8, "my_live", r10);
            goto L58
        }

        @Override // com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.m.b
        public final void a(TabLayout.Tab r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "tab");
            TextView r0 = new TextView(this.c.getContext());
            String r5 = (String) CollectionsKt.getOrNull(this.d, r4);
            if (r5 != null) goto L6;
            r5 = "";
        L6:
            r0.setText(r5);
            r0.setGravity(17);
            r0.setTextColor(ProfileTabsComponent.m);
            r0.setTextSize(1, 15.0f);
            r3.setCustomView(r0);
        }

        public c(ProfileTabsComponent r1, TabLayout r2, List r3, MyLiveTabs r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.a = new HashSet();
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
    }

    static {
        m = ColorProtector.parseColor("#99161823");
        n = ColorProtector.parseColor("#161823");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        m r0 = this.h;
        if (r0 == null) goto L8;
        RecyclerView.Adapter<?> r1 = r0.d;
        if (r1 == null) goto L7;
        r1.unregisterAdapterDataObserver(r0.h);
        r0.h = null;
    L7:
        r0.a.removeOnTabSelectedListener(r0.g);
        r0.b.unregisterOnPageChangeCallback(r0.f);
        r0.g = null;
        r0.f = null;
        r0.d = null;
        r0.e = false;
    L8:
        this.j = -1;
        com.bytedance.android.live.profile.ui.base.m r2 = com.bytedance.android.live.profile.ui.base.i.n(this.l);
        if (r2 == null) goto L11;
        r2.a(this.k);
    L11:
        List<b> r3 = this.b;
        if (r3 == null) goto L14;
        ((ArrayList) r3).clear();
    L14:
        this.i.clear();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.TabsComponent.INSTANCE;
    }

    public ProfileTabsComponent(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.l = r2;
        this.i = new CompositeDisposable();
        this.j = -1;
        this.k = new h(this);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        ((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567192, true);
        this.c = i(2131380570);
        this.d = i(2131380569);
        this.e = i(2131388030);
        this.f = i(2131388032);
        ViewPager2 r4 = i(2131392567);
        this.g = r4;
        if (r4 == null) goto L6;
        int r0 = com.bytedance.android.live.profile.ui.base.i.a(this.l) - UtilityKotlinExtentionsKt.i(40);
        int r1 = com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.a.i;
        a1.k(r4, r0 - UtilityKotlinExtentionsKt.i(52));
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r12) {
        Intrinsics.checkNotNullParameter(r12, "user");
        ProfileOpenArea r0 = r12.openArea;
        String r1 = null;
        if (r0 == null) goto L5;
        final MyLiveTabs r2 = r0.myLiveTabs;
    L7:
        if (r2 != null) goto L15;
        View r13 = this.c;
        if (r13 == null) goto L11;
        r13.setVisibility(0);
    L11:
        View r14 = this.d;
        if (r14 == null) goto L81;
        r14.setVisibility(8);
        return;
    L81:
        return;
    L15:
        View r4 = this.c;
        if (r4 == null) goto L18;
        r4.setVisibility(8);
    L18:
        View r3 = this.d;
        if (r3 == null) goto L21;
        r3.setVisibility(0);
    L21:
        final TabLayout r5 = this.e;
        if (r5 != null) goto L24;
        return;
    L24:
        ViewPager2 r6 = this.g;
        if (r6 != null) goto L27;
        return;
    L27:
        List r7 = r2.getTabs();
        if (r7 == null) goto L35;
        ?? r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L31:
        if (r9.hasNext() == false) goto L36;
        String r10 = ((MyLiveTab) r9.next()).getTitle();
        if (r10 == null) goto L31;
        r8.add(r10);
    L36:
        TabAdapter r15 = new TabAdapter(this.l.getRoomDataCenter(), this.l, this);
        r15.b = new ProfileTabsComponent$bindUserData$$inlined$apply$lambda$1(this, r5, r2);
        List r16 = r2.getTabs();
        if (r16 != null) goto L39;
        r16 = CollectionsKt.emptyList();
    L39:
        Intrinsics.checkNotNullParameter(r16, "tabs");
        Iterator r17 = ((ArrayList) r15.a).iterator();
    L41:
        if (r17.hasNext() == false) goto L43;
        ((TabDataHelper) r17.next()).getClass();
        goto L41
    L43:
        ((ArrayList) r15.a).clear();
        Iterator r18 = r16.iterator();
    L45:
        if (r18.hasNext() == false) goto L47;
        MyLiveTab r19 = (MyLiveTab) r18.next();
        ((ArrayList) r15.a).add(new TabDataHelper(r19));
        goto L45
    L47:
        r15.notifyDataSetChanged();
        Unit r20 = Unit.INSTANCE;
        r6.setAdapter(r15);
        c r22 = new c(this, r5, r8, r2);
        m r23 = new m(r5, r6, r22);
        if (r23.e == true) goto L73;
        RecyclerView.Adapter<?> r24 = r6.getAdapter();
        r23.d = r24;
        if (r24 == null) goto L71;
        r23.e = true;
        m.c r25 = new m.c(r23.a, r23.c);
        r23.f = r25;
        r6.registerOnPageChangeCallback(r25);
        m.d r26 = new m.d(r6, true);
        r23.g = r26;
        r5.addOnTabSelectedListener(r26);
        m.a r27 = new m.a(r23);
        r23.h = r27;
        r23.d.registerAdapterDataObserver(r27);
        r23.a();
        int r28 = r22.c();
        if (r28 < 0) goto L54;
        r6.setCurrentItem(r28, false);
    L54:
        r5.setScrollPosition(r6.getCurrentItem(), 0.0f, true);
        this.h = r23;
        ProfileSkin r110 = r12.mProfileSkin;
        if (r110 == null) goto L63;
        ProfileCustomSkin r111 = r110.skin;
        if (r111 == null) goto L63;
        ProfileCustomSkin.BgUI r112 = r111.bgSkin;
        if (r112 == null) goto L63;
        ProfileCustomSkin.GradientColor r113 = r112.bgColor;
        if (r113 == null) goto L63;
        r1 = r113.from;
    L63:
        View r114 = this.f;
        if (r114 == null) goto L66;
        com.bytedance.android.live.profile.ui.util.m.f(r114, r1);
    L66:
        com.bytedance.android.live.profile.ui.base.m r115 = com.bytedance.android.live.profile.ui.base.i.n(this.l);
        if (r115 == null) goto L82;
        r115.d(this.k);
        return;
    L82:
        return;
    L71:
        throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
    L73:
        throw new IllegalStateException("TabLayoutMediator is already attached");
    L35:
        r8 = CollectionsKt.emptyList();
        goto L36
    L5:
        r2 = null;
        goto L7
    }

    public static final void j(ProfileTabsComponent r2, String r3, String r4) {
        r2.getClass();
        LinkedHashMap r5 = new LinkedHashMap();
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L8;
        String r6 = r1.n();
        if (r6 == null) goto L8;
    L9:
        r5.put("user_id", r6);
        r5.put("previous_page", r3);
        r5.put("enter_page", r4);
        j0.l().sendLog("livesdk_my_live_my_page_enter", r5, new Object[0]);
        return;
    L8:
        r6 = DataType.FALSE;
        goto L9
    }
}
