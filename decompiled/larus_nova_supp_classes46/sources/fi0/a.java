package fi0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.profit.vote.e;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.collections.CollectionsKt;
import xh0.f;
import xh0.g;
import xh0.h;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends xh0.a {
    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final ArrayList<f> getIncompatibleSourceList() {
        IncompatibleTag r2 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new f[]{new f(r2, 5), new f(r2, 6, ""), new f(r2, 7, ""), new f(r2, 11, ""), new f(r2, 16, ""), new f(r2, 17, ""), new f(r2, 19, ""), new f(r2, 21, ""), new f(r2, 22, ""), new f(r2, 23, "")});
    }

    @Override // xh0.b
    public final h getPlayModeInfo() {
        return new h(29, s1.B(2131914601));
    }

    @Override // xh0.b
    public final boolean isOpen() {
        AdventureContext.Companion.getClass();
        return AdventureContext.a.a();
    }

    public a() {
    }

    @Override // xh0.a, xh0.b
    public final g isCanOpen(HashMap<String, Object> r9) {
        if (k.n(IKtvService.class).currentIsMultipleKtvModeV2() == false) goto L6;
        IncompatibleTag r3 = IncompatibleTag.PLAY_MODE;
        return new g(r3, 21, false, r3 + "_21", s1.C(2131914602, new Object[]{s1.B(2131918331)}));
    L6:
        e r0 = c.m();
        if (r0 == null) goto L13;
        if (r0.fi() != true) goto L13;
        return new g(IncompatibleTag.PLAY_MODE, getPlayModeInfo().a, false, "giftVote", s1.B(2131918828));
    L13:
        if (InteractiveSongContext.Companion.f() == false) goto L17;
        return new g(IncompatibleTag.PLAY_MODE, getPlayModeInfo().a, false, "giftVote", s1.B(2131918829));
    L17:
        return super.isCanOpen(r9);
    }
}
