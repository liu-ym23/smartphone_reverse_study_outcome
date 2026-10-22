package com.bytedance.android.livesdk.interactivity.like.utils;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.logsdk.format.Spm;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u32.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements l.a {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    public final void a(String r3) {
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a175.a999").addArg("info", r3), "DoubleLikeTracer");
    }

    @Override // u32.l.a
    public final void b(l r2, com.bytedance.android.livesdk.interactivity.api.like.model.a r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "detail");
        a("onDoubleLikeStart, detail info is " + JsonUtil.toJSONString(r3));
    }

    @Override // u32.l.a
    public final void e(l r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        a("onDoubleLikeEnd, local like count is " + r3);
    }

    @Override // u32.l.a
    public final void k(l r2, List<d4> r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "userRank");
        a("onDoubleLikeUserRankUpdate, list size is " + r3.size());
    }

    @Override // u32.l.a
    public final void l(l r2, com.bytedance.android.livesdk.interactivity.api.like.model.a r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "detail");
        a("onDoubleLikeRenewalUpdate, detail info is " + JsonUtil.toJSONString(r3));
    }

    @Override // u32.l.a
    public final void d(l r2, int r3, int r4, Text r5, Text r6) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r5, "normalText");
        Intrinsics.checkNotNullParameter(r6, "joinText");
        a("onDoubleLikeSummary, local like count is " + r3 + ", real double like count is " + r4);
    }
}
