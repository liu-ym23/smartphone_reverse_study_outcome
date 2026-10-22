package com.bytedance.android.livesdk.feed;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.drawer.ILiveDrawerCommonFragment;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerPageAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerPageAdapter extends FragmentPagerAdapter {
    public final List<com.bytedance.android.livesdk.feed.feed.e> a;
    public final HashMap<Long, Fragment> b;
    public final HashMap<Integer, ILiveDrawerCommonFragment> c;
    public final IDrawerFeedAction d;
    public final LiveDrawerTabViewModel e;
    public final qv1.a f;
    public final Fragment g;

    public final int getCount() {
        return ((ArrayList) this.a).size();
    }

    public final Fragment getItem(int r10) {
        if (r10 >= 0) goto L5;
    L67:
        LiveDrawerFeedCategoryFragment r1 = new LiveDrawerFeedCategoryFragment();
        com.bytedance.android.livesdk.feed.feed.e r11 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.a, r10);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r1.u = r11;
        r1.v = this.d;
        r1.w = this.e;
        r1.x = this.f;
        r1.setArguments(this.g.getArguments());
        return r1;
    L5:
        if (r10 >= ((ArrayList) this.a).size()) goto L67;
        com.bytedance.android.livesdk.feed.feed.e r2 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.a, r10);
        if (this.b.containsKey(Long.valueOf(r2.f())) == false) goto L9;
    L65:
        Fragment r12 = this.b.get(Long.valueOf(r2.f()));
        Intrinsics.checkNotNull(r12);
        return r12;
    L9:
        if (r2.getType() != 11) goto L61;
        if (r2.o() == false) goto L13;
    L14:
        wv1.k0 r3 = new wv1.k0();
        r3.a = r2;
        Fragment r4 = this.g;
        Intrinsics.checkNotNullParameter(r4, "fragment");
        if ((r4 instanceof LiveDrawerFeedPageFragment) == false) goto L18;
        r3.b = new WeakReference(r4);
    L18:
        IHostCommerceServiceLive r5 = jc1.k.f(IHostCommerceServiceLive.class);
        String r6 = null;
        if (r5 == null) goto L21;
        ILiveDrawerCommonFragment r7 = r5.getLiveDrawerCommonFragment(r3);
    L22:
        this.c.put(Integer.valueOf(r2.getType()), r7);
        Bundle r8 = new Bundle();
        r8.putAll(this.g.getArguments());
        Bundle r9 = new Bundle();
        com.bytedance.android.livesdk.log.filter.n0 r13 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r13 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L30;
        com.bytedance.android.livesdk.log.filter.n0 r14 = r13;
        if (((com.bytedance.android.livesdk.log.filter.a) r14).b.containsKey("enter_from_merge") == false) goto L28;
        r9.putString("enter_from_merge", (String) ((com.bytedance.android.livesdk.log.filter.a) r14).b.get("enter_from_merge"));
    L28:
        if (((com.bytedance.android.livesdk.log.filter.a) r14).b.containsKey("enter_method") == false) goto L30;
        r9.putString("enter_method", (String) ((com.bytedance.android.livesdk.log.filter.a) r14).b.get("enter_method"));
    L30:
        r8.putAll(r9);
        RoomContext r15 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r15 == null) goto L52;
        com.bytedance.live.datacontext.m r16 = r15.getRoom();
        if (r16 == null) goto L52;
        Room r17 = (Room) r16.getValue();
        if (r17 == null) goto L52;
        r8.putString("roomId", String.valueOf(r17.getRoomId()));
        IUser r18 = r17.author();
        if (r18 == null) goto L39;
        String r19 = r18.getIdString();
    L40:
        String r20 = "";
        if (r19 != null) goto L43;
        r19 = "";
    L43:
        r8.putString("authorId", r19);
        IUser r21 = r17.author();
        if (r21 == null) goto L48;
        Intrinsics.checkNotNullParameter(r21, "$this$secUidExt");
        String r22 = r21.getCastSecUid();
        if (r22 == null) goto L48;
        r6 = r22;
    L48:
        if (r6 == null) goto L51;
        r20 = r6;
    L51:
        r8.putString("secAuthorId", r20);
        goto L52
    L39:
        r19 = null;
    L52:
        if (r7 == null) goto L56;
        Fragment r23 = r7.getFragment();
        if (r23 == null) goto L56;
        r23.setArguments(r8);
    L56:
        if (r7 == null) goto L61;
        Fragment r24 = r7.getFragment();
        if (r24 == null) goto L61;
        this.b.put(Long.valueOf(r2.f()), r24);
        goto L61
    L21:
        r7 = null;
        goto L22
    L13:
        if (com.bytedance.android.livesdk.feed.tab.repository.newtab.b.c == true) goto L14;
    L61:
        if (this.b.containsKey(Long.valueOf(r2.f())) == false) goto L64;
        Fragment r110 = this.b.get(Long.valueOf(r2.f()));
        Intrinsics.checkNotNull(r110);
        return r110;
    L64:
        Fragment r25 = new LiveDrawerFeedCategoryFragment();
        r25.setArguments(this.g.getArguments());
        com.bytedance.android.livesdk.feed.feed.e r111 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.a, r10);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r25.u = r111;
        r25.v = this.d;
        r25.w = this.e;
        r25.x = this.f;
        this.b.put(Long.valueOf(r2.f()), r25);
        goto L65
    }

    public final CharSequence getPageTitle(int r5) {
        Object r0 = ListProtector.get(this.a, r5);
        com.bytedance.android.livesdk.feed.feed.e r1 = (com.bytedance.android.livesdk.feed.feed.e) r0;
        IHostBusiness r2 = jc1.k.f(IHostBusiness.class);
        boolean r3 = true;
        if (r2 == null) goto L7;
        if (r2.isEnablePersonalRecommend() != true) goto L7;
    L9:
        r3 = false;
    L10:
        if (r3 == true) goto L14;
        r0 = null;
    L14:
        if (((com.bytedance.android.livesdk.feed.feed.e) r0) == null) goto L19;
        String r4 = s1.B(2131916622);
        if (r4 == null) goto L19;
        return r4;
    L19:
        return ((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.a, r5)).i();
    L7:
        if (r1.getType() != 1) goto L9;
        goto L9
    }

    public LiveDrawerPageAdapter(FragmentManager r2, IDrawerFeedAction r3, LiveDrawerTabViewModel r4, qv1.a r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r5, "callBack");
        Intrinsics.checkNotNullParameter(r6, "pageFragment");
        super(r2);
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = new HashMap();
    }
}
