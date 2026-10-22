package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveOuterFollowListView implements ry.b {
    public Function1<? super Boolean, Unit> a;
    public Function1<? super Boolean, Unit> b;
    public Function1<? super Integer, Unit> c;
    public final HorizontalLiveListView d;

    public static final class a<T> implements Observer {
        public final /* synthetic */ LiveOuterFollowListView a;

        public a(LiveOuterFollowListView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 == null) goto L8;
            boolean r4 = r3.booleanValue();
            Function1<? super Boolean, Unit> r0 = this.a.b;
            if (r0 == null) goto L9;
            Unit r5 = (Unit) r0.invoke(Boolean.valueOf(r4));
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ LiveOuterFollowListView a;

        public b(LiveOuterFollowListView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 == null) goto L8;
            boolean r4 = r3.booleanValue();
            Function1<? super Boolean, Unit> r0 = this.a.a;
            if (r0 == null) goto L9;
            Unit r5 = (Unit) r0.invoke(Boolean.valueOf(r4));
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LiveOuterFollowListView a;

        public c(LiveOuterFollowListView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 == null) goto L8;
            int r4 = r3.intValue();
            Function1<? super Integer, Unit> r0 = this.a.c;
            if (r0 == null) goto L9;
            Unit r5 = (Unit) r0.invoke(Integer.valueOf(r4));
            return;
        L9:
            return;
        }
    }

    public final void a(final sy.a<Boolean> r2) {
        this.b = new LiveOuterFollowListView$setEmptyListener$1(r2);
    }

    public final void b(final sy.a<Boolean> r2) {
        this.a = new LiveOuterFollowListView$setErrorListener$1(r2);
    }

    public final void c(final sy.a<Integer> r2) {
        this.c = new LiveOuterFollowListView$setRoomCountListener$1(r2);
    }

    public LiveOuterFollowListView(Context r5, Bundle r6, ry.f r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 != null) goto L5;
        r6 = new Bundle();
    L6:
        String r0 = r6.getString("enter_from_merge", "homepage_follow");
        String r1 = r6.getString("feed_type");
        if (r1 == null) goto L20;
        int r2 = r1.hashCode();
        if (r2 == (-1925189774)) goto L18;
        if (r2 != (-290803120)) goto L20;
        if (r1.equals("hot_feed") == false) goto L20;
        FeedType r3 = FeedType.HOT_FEED;
    L21:
        int r4 = r6.getInt("background_color", -1);
        HorFollowListParams.Builder r8 = new HorFollowListParams.Builder(r0).feedType(r3).backgroundColor(r4);
        if (r6.containsKey("live_tag_color") == false) goto L25;
        r8.liveTagColor(r6.getInt("live_tag_color"));
    L25:
        if (r6.containsKey("live_tag_radius") == false) goto L27;
        r8.liveTagRadius(r6.getInt("live_tag_radius"));
    L27:
        if (r7 == null) goto L29;
        r8.avatarBorderAnimController(r7);
    L29:
        HorizontalLiveListView r9 = new HorizontalLiveListView(r8.build(), r5, null, 0);
        this.d = r9;
        MutableLiveData<Boolean> r10 = r9.j;
        if (r10 == null) goto L32;
        r10.observe(r9, new a(this));
    L32:
        MutableLiveData<Boolean> r11 = r9.h;
        if (r11 == null) goto L35;
        r11.observe(r9, new b(this));
    L35:
        MutableLiveData<Integer> r12 = r9.l;
        if (r12 == null) goto L39;
        r12.observe(r9, new c(this));
        return;
    L39:
        return;
    L18:
        if (r1.equals("common_feed") == false) goto L20;
        r3 = FeedType.COMMON_FEED;
    L20:
        r3 = FeedType.FOLLOW_FEED;
        goto L21
    L5:
        Intrinsics.checkNotNull(r6);
        goto L6
    }
}
