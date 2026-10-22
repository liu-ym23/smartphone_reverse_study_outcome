package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.v;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.x;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ThemedCompetitionViewManager implements pj0.c {
    public final HSImageView a;
    public boolean b;
    public final List<String> c;
    public final ViewGroup d;
    public final SeatAnimManager e;

    public final void b() {
        HSImageView r0 = this.a;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        HSImageView r1 = this.a;
        if (r1 == null) goto L9;
        f.a(r1, LiveCommonConstants.assembleTosObjectUrl(d.b), new ThemedCompetitionViewManager$startEffect$1(this));
        return;
    }

    public final void a(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "userIdList");
        ArrayList r6 = (ArrayList) r5;
        if (r6.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.b == false) goto L9;
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(r6);
        return;
    L9:
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L22;
        String r0 = (String) r7.next();
        SeatAnimManager r1 = this.e;
        if (r1 == null) goto L11;
        x r2 = new x(r0, LiveCommonConstants.assembleTosObjectUrl(d.d));
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r1.f(r2.a) == false) goto L17;
        r1.g(r2.a);
    L17:
        Map<String, SeatAnimationView> r3 = r1.a;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        SeatAnimationView r8 = (SeatAnimationView) r4.get(r2.a.toString());
        if (r8 == null) goto L11;
        Intrinsics.checkNotNullParameter(r2, "event");
        v r9 = r8.a;
        if (r9 == null) goto L11;
        r9.c(r2);
        goto L11
    L22:
        ((ArrayList) this.c).clear();
    }

    public ThemedCompetitionViewManager(ViewGroup r1, SeatAnimManager r2) {
        this.d = r1;
        this.e = r2;
        if (r1 == null) goto L5;
        HSImageView r3 = (HSImageView) r1.findViewById(2131388569);
    L6:
        this.a = r3;
        this.c = new ArrayList();
        pj0.b r4 = ThemedCompetitionContext.Companion.c();
        if (r4 == null) goto L10;
        r4.ee(this);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
