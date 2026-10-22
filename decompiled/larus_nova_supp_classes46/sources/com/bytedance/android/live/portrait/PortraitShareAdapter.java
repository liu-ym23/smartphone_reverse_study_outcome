package com.bytedance.android.live.portrait;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.helper.LiveShareHelper;
import com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter;
import com.bytedance.android.livesdk.chatroom.view.f;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.MatchShareBackground;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/portrait/PortraitShareAdapter;", "Lcom/bytedance/android/live/uikit/viewpager/AbsPagerAdapter;", "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitShareAdapter extends AbsPagerAdapter {
    public final Map<Integer, f> a;
    public final Map<Integer, Long> b;
    public MatchShareParam c;
    public int d;
    public boolean e;
    public boolean f;
    public final int g;
    public final FragmentActivity h;
    public final Context i;
    public final LiveVerticalViewPager j;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            int r3 = r2.getAction();
            if (r3 != 0) goto L5;
            this.a.setAlpha(0.5f);
            return false;
        L5:
            if (r3 != 1) goto L7;
        L9:
            this.a.setAlpha(1.0f);
            return false;
        L7:
            if (r3 == 3) goto L9;
            return false;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FrameLayout a;

        public c(FrameLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();     // Catch: Throwable -> L7
            if (r0 == null) goto L6;
            r0.height = (int) (s1.t() * 0.5625f);     // Catch: Throwable -> L7
            this.a.setLayoutParams(r0);     // Catch: Throwable -> L7
            this.a.requestLayout();     // Catch: Throwable -> L7
            return;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PortraitShareAdapter a;
        public final /* synthetic */ int b;

        public d(PortraitShareAdapter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            PortraitShareAdapter.f(this.a, this.b);
        }
    }

    public static final class e implements com.bytedance.android.livesdk.chatroom.view.c {
        public final /* synthetic */ PortraitShareAdapter a;
        public final /* synthetic */ int b;

        public final void a() {
            List r0 = this.a.c.d;
            if (r0 == null) goto L8;
            CollectionItem r1 = (CollectionItem) CollectionsKt.getOrNull(r0, this.b);
            if (r1 == null) goto L8;
            String r2 = r1.getCollectionId();
            if (r2 == null) goto L8;
        L9:
            jl0.a.c(r2);
            return;
        L8:
            r2 = "";
            goto L9
        }

        public final void onPause() {
            List r0 = this.a.c.d;
            if (r0 == null) goto L8;
            CollectionItem r1 = (CollectionItem) CollectionsKt.getOrNull(r0, this.b);
            if (r1 == null) goto L8;
            String r2 = r1.getCollectionId();
            if (r2 == null) goto L8;
        L9:
            long r3 = System.currentTimeMillis();
            Long r4 = (Long) ((LinkedHashMap) this.a.b).get(Integer.valueOf(this.b));
            if (r4 == null) goto L12;
            long r6 = r4.longValue();
        L13:
            jl0.a.b(r2, r3 - r6);
            this.a.b.put(Integer.valueOf(this.b), 0L);
            return;
        L12:
            r6 = 0;
        L8:
            r2 = "";
            goto L9
        }

        public final void onPlay() {
            List r0 = this.a.c.d;
            String r1 = "";
            if (r0 == null) goto L8;
            CollectionItem r2 = (CollectionItem) CollectionsKt.getOrNull(r0, this.b);
            if (r2 == null) goto L8;
            String r3 = r2.getCollectionId();
            if (r3 == null) goto L8;
        L9:
            MatchShareParam r4 = this.a.c;
            if (r4 == null) goto L15;
            String r5 = r4.a;
            if (r5 == null) goto L15;
            r1 = r5;
        L15:
            jl0.a.a(r3, r1);
            this.a.b.put(Integer.valueOf(this.b), Long.valueOf(System.currentTimeMillis()));
            return;
        L8:
            r3 = "";
            goto L9
        }

        public e(PortraitShareAdapter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final int getCount() {
        List r0 = this.c.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final Context getContext() {
        return this.i;
    }

    public static final void f(PortraitShareAdapter r5, int r6) {
        MatchShareParam r0 = r5.c;
        if (r0.f == null) goto L5;
    L7:
        HashMap r1 = new HashMap();
        List r2 = r5.c.d;
        String r3 = null;
        if (r2 == null) goto L10;
        CollectionItem r7 = (CollectionItem) ListProtector.get(r2, r6);
    L11:
        MatchShareParam r4 = r5.c;
        String r8 = "";
        if (r7 == null) goto L15;
        String r9 = r7.getCollectionId();
        if (r9 == null) goto L15;
    L16:
        r4.c = r9;
        if (r7 == null) goto L20;
        r3 = r7.getCollectionId();
    L20:
        if (TextUtils.isEmpty(r3) == true) goto L27;
        if (r7 == null) goto L26;
        String r10 = r7.getCollectionId();
        if (r10 == null) goto L26;
        r8 = r10;
    L26:
        r1.put("collection_id", r8);
        r1.put("multitab_select_tabid", "4");
    L27:
        LiveShareHelper.b(r5.h, r5.c, r7, r1);
        return;
    L15:
        r9 = "";
        goto L16
    L10:
        r7 = null;
        goto L11
    L5:
        if (r0.g != null) goto L7;
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        return Intrinsics.areEqual(r2, r3);
    }

    public PortraitShareAdapter(FragmentActivity r21, Context r22, LiveVerticalViewPager r23) {
        Intrinsics.checkNotNullParameter(r21, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "viewPager");
        super(r22, LayoutInflater.from(r22));
        this.h = r21;
        this.i = r22;
        this.j = r23;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
        this.d = -1;
        r23.setOnPageChangeListener(new PortraitShareAdapter$mPageChangeListener$1(this));
        if (s1.d(r22) == false) goto L5;
        int r1 = s1.o();
    L6:
        this.g = r1;
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        super.destroyItem(r2, r3, r4);
        this.a.remove(Integer.valueOf(r3));
    }

    public final View getView(int r11, View r12, ViewGroup r13) {
        if (r12 != null) goto L5;
        r12 = ((AbsPagerAdapter) this).mInflater.inflate(2131567984, r13, false);
    L5:
        TextView r14 = (TextView) r12.findViewById(2131389916);
        FrameLayout r1 = (FrameLayout) r12.findViewById(2131389915);
        View r2 = r12.findViewById(2131389910);
        HSImageView r3 = r12.findViewById(2131389914);
        TextView r4 = (TextView) r12.findViewById(2131389912);
        List r5 = this.c.d;
        Room r6 = null;
        if (r5 == null) goto L8;
        CollectionItem r7 = (CollectionItem) ListProtector.get(r5, r11);
    L9:
        if (r7 == null) goto L11;
        Integer r8 = Integer.valueOf(r7.getCollectionType());
    L12:
        boolean r9 = true;
        if (r8 != null) goto L16;
    L18:
        if (r8 != null) goto L21;
    L23:
        MatchShareParam r10 = this.c;
        if (r10.f != null) goto L28;
        if (r10.g != null) goto L28;
    L30:
        r9 = false;
    L31:
        UtilityKotlinExtentionsKt.A(r2, r9);
        r2.setOnTouchListener(new b(r2));
        ViewGroup.LayoutParams r15 = r2.getLayoutParams();
        if (r15 == null) goto L83;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.bottomMargin = this.g + s1.f(12.0f);
        r2.setLayoutParams(r16);
        if (r1 == null) goto L36;
        r1.post(new c(r1));
    L36:
        if (r7 == null) goto L39;
        String r17 = r7.getTitle();
        if (r17 == null) goto L39;
    L42:
        if (r17 != null) goto L45;
        r17 = "";
    L45:
        r14.setText(r17);
        if (((LinkedHashMap) this.a).get(Integer.valueOf(r11)) != null) goto L48;
        this.a.put(Integer.valueOf(r11), new f(new e(this, r11)));
    L48:
        f r18 = (f) ((LinkedHashMap) this.a).get(Integer.valueOf(r11));
        if (r18 == null) goto L51;
        com.bytedance.android.live.c.b(false, r1, r18, s1.t(), r7);
    L51:
        MatchShareParam r19 = this.c;
        if (r19.f == null) goto L54;
    L56:
        Room r110 = this.c.f;
        if ((r110 instanceof Room) == false) goto L60;
        r6 = r110;
    L60:
        Room r20 = r6;
        if (r20 == null) goto L71;
        EpisodeExtraInfo r111 = r20.getEpisodeExtra2();
        if (r111 == null) goto L71;
        IMatchRoomInfo r112 = r111.getMatchRoomInfo();
        if (r112 == null) goto L71;
        IMatchShareBackground r113 = r112.getMatchShareBackground();
        if (r113 == null) goto L71;
        k r114 = r113.getVerticalBackground();
        if (r114 == null) goto L71;
        ImageUtil.loadImage(r3, r114, 0);
    L71:
        Episode r115 = this.c.g;
        if (r115 == null) goto L80;
        EpisodeBasicInfo r116 = r115.episodeBasicInfo;
        if (r116 == null) goto L80;
        MatchShareBackground r117 = r116.getMatchShareBackground();
        if (r117 == null) goto L80;
        k r118 = r117.getVerticalBackground();
        if (r118 == null) goto L80;
        ImageUtil.loadImage(r3, r118, 0);
    L80:
        r2.setOnClickListener(new d(this, r11));
        return r12;
    L54:
        if (r19.g != null) goto L56;
        UtilityKotlinExtentionsKt.t(r2);
    L39:
        if (r7 == null) goto L41;
        r17 = r7.getLocalPreviewTopTitle();
        goto L42
    L41:
        r17 = null;
        goto L42
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L28:
        if (r10.j != null) goto L30;
    L21:
        if (r8.intValue() != 2) goto L23;
        r4.setText("分享视频");
        goto L23
    L16:
        if (r8.intValue() != 1) goto L18;
        r4.setText("分享图片");
        goto L23
    L11:
        r8 = null;
        goto L12
    L8:
        r7 = null;
        goto L9
    }
}
