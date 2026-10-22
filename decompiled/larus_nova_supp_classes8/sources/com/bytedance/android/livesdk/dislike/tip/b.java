package com.bytedance.android.livesdk.dislike.tip;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.config.ne0;
import com.bytedance.android.livesdk.config.setting.l;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.live.ILiveOptRecommendHintService;
import com.bytedance.android.livesdkapi.model.LiveOptRecommendHintConfig;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements ILiveOptRecommendHintService {
    public final String a;
    public final Set<String> b;
    public final int c;
    public final boolean d;

    public b() {
        this(true);
    }

    public final boolean a() {
        LiveOptRecommendHintConfig r0 = ne0.a.getValue();
        Object r3 = null;
        if (this.d == false) goto L12;
        Iterator<T> r1 = l.b().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r6 = r1.next();
        if (Intrinsics.areEqual(((ItemConfig) r6).getIdentity(), "opt_recommend") == false) goto L6;
        r3 = r6;
    L10:
        if (r3 != null) goto L19;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == true) goto L23;
        return false;
    L23:
        if (r0.getTipEnable() == true) goto L25;
        return false;
    L25:
        if (r0.getTipAbVersion() > 0) goto L27;
        return false;
    L27:
        if (r0.getTipShowMaxTime() > 0) goto L29;
        return false;
    L29:
        if (r0.getSkipRoomLimit() <= 1) goto L42;
        return true;
    L42:
        return false;
    L19:
        r2 = true;
        goto L21
    L12:
        Iterator<T> r4 = l.a().iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        Object r7 = r4.next();
        if (Intrinsics.areEqual(((ItemConfig) r7).getIdentity(), "opt_recommend") == false) goto L14;
        r3 = r7;
    L18:
        if (r3 == null) goto L20;
        goto L19
    }

    public final LiveOptRecommendHintConfig getConfig() {
        return ne0.a.getValue();
    }

    public final void markOptRecommendTipShow() {
        b("markOptRecommendTipShow");
        int r0 = a.e().getInt("key_optimize_recommend_tip_show_times", 0) + 1;
        a.e().storeInt("key_optimize_recommend_tip_show_times", r0);
        if (TextUtils.equals(a.c(), a.f()) == true) goto L6;
        a.e().storeString("key_optimize_recommend_tip_show_last_date", a.f());
    L6:
        this.b.clear();
    }

    public final void updateOptRecommendUsedDate() {
        b("updateOptRecommendUsedDate");
        if (TextUtils.equals(a.a(), a.f()) == true) goto L6;
        a.e().storeString("key_optimize_recommend_use_last_date", a.f());
    L6:
        this.b.clear();
    }

    public final boolean canShowOptRecommendTip() {
        if (a() == true) goto L5;
        return false;
    L5:
        ne0 r0 = ne0.a;
        LiveOptRecommendHintConfig r2 = r0.getValue();
        int r3 = a.e().getInt("key_optimize_recommend_ab_version", 0);
        if (r2.getTipAbVersion() <= 0) goto L17;
        if (r2.getTipAbVersion() <= r3) goto L17;
        b("ab_version update: " + r3 + " -> " + r2.getTipAbVersion());
        a.e().storeInt("key_optimize_recommend_ab_version", r2.getTipAbVersion());
        if (r2.getTipShowTimesReset() == false) goto L14;
        a.e().storeInt("key_optimize_recommend_tip_show_times", 0);
        b("tip show times reset");
    L14:
        if (r2.getTipShowDateReset() == false) goto L17;
        a.e().storeString("key_optimize_recommend_tip_show_last_date", "");
        b("tip show date reset");
    L17:
        if (this.b.size() < r0.getValue().getSkipRoomLimit()) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == true) goto L24;
        b("累计跳过的roomId" + this.b);
        return false;
    L24:
        if (a.b() < this.c) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == true) goto L31;
        b("上次使用优化推荐日期" + a.a());
        return false;
    L31:
        if (a.d() < r0.getValue().getTipShowInterval()) goto L33;
        boolean r6 = true;
    L34:
        if (r6 == true) goto L38;
        b("上次展现tip日期" + a.c());
        return false;
    L38:
        if (a.e().getInt("key_optimize_recommend_tip_show_times", 0) < r0.getValue().getTipShowMaxTime()) goto L40;
        boolean r1 = true;
    L41:
        if (r1 == false) goto L44;
        b("tip累计展现" + a.e().getInt("key_optimize_recommend_tip_show_times", 0));
        return false;
    L44:
        b("last_use_date:" + a.a() + " , last_use_interval:" + a.b() + ", last_tip_date:" + a.c() + ", last_tip_interval:" + a.d() + ", tip_show_times:" + a.e().getInt("key_optimize_recommend_tip_show_times", 0));
        return true;
    L40:
        r1 = false;
        goto L41
    L33:
        r6 = false;
        goto L34
    L26:
        r5 = false;
        goto L27
    L19:
        r4 = false;
        goto L20
    }

    public b(boolean r1) {
        this.d = r1;
        this.a = "optimize_recommend_tip";
        this.b = new LinkedHashSet();
        this.c = 14;
    }

    public final void b(String r3) {
        b0 r0 = b0.o();
        String r1 = this.a;
        r0.getClass();
        g.i(r1, r3);
    }

    public final void recordSkipRoom(long r4) {
        if (a() == true) goto L6;
        return;
    L6:
        if (r4 > 0) goto L8;
        return;
    L8:
        this.b.add(String.valueOf(r4));
    }
}
