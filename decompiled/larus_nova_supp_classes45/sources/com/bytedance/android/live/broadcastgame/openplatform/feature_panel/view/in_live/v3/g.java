package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureTabPageAdapterV3;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;

    public g(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        c20.c r12 = (c20.c) r11;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.c.isEmpty() == false) goto L7;
        LiveOpenFeatureChooseListFragmentV3.W90(this.a, false);
    L8:
        LiveOpenFeatureChooseListFragmentV3 r0 = this.a;
        if (r0.isAdded() == false) goto L80;
        r0.C.clear();
        Iterator<T> r3 = r12.d.iterator();
        int r4 = 0;
    L12:
        if (r3.hasNext() == false) goto L20;
        T r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        c20.d r7 = (c20.d) r5;
        if (r0.C.containsKey(Integer.valueOf(r4)) == true) goto L19;
        r0.C.put(Integer.valueOf(r4), new LiveOpenFeatureChooseListFragmentV3.b(-1, -1));
    L19:
        r4 = r6;
        goto L12
    L20:
        LivePagerSlidingTabStrip r8 = r0.p;
        if (r8 == null) goto L23;
        UtilityKotlinExtentionsKt.v(r8, true);
    L23:
        ViewPager r9 = r0.r;
        if (r9 == null) goto L26;
        UtilityKotlinExtentionsKt.v(r9, true);
    L26:
        LinearLayout r13 = r0.o;
        if (r13 == null) goto L30;
        UtilityKotlinExtentionsKt.v(r13, false);
    L30:
        if (r12.d.size() != 1) goto L34;
        LivePagerSlidingTabStrip r14 = r0.p;
        if (r14 == null) goto L37;
        r14.setTextColorResource(2131107981);
    L37:
        OpenFeatureTabPageAdapterV3 r15 = r0.e;
        if (r15 == null) goto L41;
        r15.g(r12.c, r12.d);
    L41:
        if (((k81) ft0.a.getValue()).b() == true) goto L89;
    L77:
        ViewPager r1 = r0.f;
        if (r1 == null) goto L80;
        r1.post(new m(r0, r12));
        goto L80
    L89:
        if (r12.d.size() <= 1) goto L77;
        if (r0.l == false) goto L77;
        if (r12.f == false) goto L72;
        Iterator<T> r16 = r12.c.iterator();     // Catch: Exception -> L76
    L51:
        if (r16.hasNext() == false) goto L66;
        T r17 = r16.next();     // Catch: Exception -> L76
        List<f10.f> r18 = ((c20.a) r17).b;     // Catch: Exception -> L76
        if ((r18 instanceof Collection) == true) goto L55;
    L57:
        Iterator<T> r19 = r18.iterator();     // Catch: Exception -> L76
    L59:
        if (r19.hasNext() == false) goto L63;
        if (((f10.f) r19.next()).u == false) goto L59;
        boolean r21 = true;
    L64:
        if (r21 == false) goto L51;
    L67:
        c20.a r22 = r17;     // Catch: Exception -> L76
        if (r22 == null) goto L77;
        long r23 = r22.a;     // Catch: Exception -> L76
        OpenFeatureTabPageAdapterV3 r2 = r0.e;     // Catch: Exception -> L76
        if (r2 == null) goto L77;
        r2.h(r12.d, r0.f, MapsKt.mapOf(TuplesKt.to("selected_group_id", Long.valueOf(r23))));     // Catch: Exception -> L76
    L63:
        r21 = false;
        goto L64
    L55:
        if (r18.isEmpty() == false) goto L57;
    L66:
        r17 = (T) null;
        goto L67
    L72:
        r0.l = false;     // Catch: Exception -> L76
        OpenFeatureTabPageAdapterV3 r24 = r0.e;     // Catch: Exception -> L76
        if (r24 == null) goto L77;
        r24.h(r12.d, r0.f, MapsKt.mapOf(TuplesKt.to("selected_group_id", Long.valueOf(r12.e))));     // Catch: Exception -> L76
        goto L77
    L34:
        LivePagerSlidingTabStrip r25 = r0.p;
        if (r25 == null) goto L37;
        r25.setTextColorResource(2131107974);
    L80:
        Room r110 = jc1.k.n(IRoomService.class).getCurrentRoom();
        if (r110 != null) goto L83;
    L87:
        r0.X90();
        return;
    L83:
        if (r110.isVirtualLive != true) goto L87;
        ImageView r111 = r0.z;
        if (r111 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r111);
        goto L87
    L7:
        LiveOpenFeatureChooseListFragmentV3.W90(this.a, true);
        goto L8
    }
}
