package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.base.model.user.v;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;

    public q(d r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r29) {
        com.bytedance.android.live.profit.privilege.model.paygrade.a r1 = (com.bytedance.android.live.profit.privilege.model.paygrade.a) r29;
        com.bytedance.live.kmp.util.c r2 = com.bytedance.live.kmp.util.c.a;
        long r3 = System.currentTimeMillis() - this.b;
        com.bytedance.android.live.profit.privilege.e r4 = com.bytedance.android.live.profit.privilege.e.a;
        String r5 = this.a.f();
        long r6 = this.a.d();
        Intrinsics.checkNotNullParameter(r5, "userId");
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_pay_grade_status_all", com.bytedance.android.live.profit.privilege.e.k(true, null, null), com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r3)), com.bytedance.android.live.profit.privilege.e.m(r4, Long.valueOf(r6), 4));
        py.d r7 = this.a.b().getUserHonor();
        if (r7 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "$this$updateToUserHonor");
        Intrinsics.checkNotNullParameter(r7, "userHonor");
        r7.setScore(r1.getScore());
        long r8 = r1.getLevel();
        Intrinsics.checkNotNullParameter(r7, "$this$levelKt");
        r7.setLevel((int) r8);
        r7.setThisGradeMaxDiamond(r1.getThisGradeMaxDiamond());
        r7.setThisGradeMinDiamond(r1.getThisGradeMinDiamond());
        r7.setGradeDescribe(r1.getGradeDescribe());
        r7.setNewImIconWithLevel(r1.getNewImIconWithLevel());
        r7.setBuffInfo(r1.getBuffInfo());
        r7.setNewLiveIcon(r1.getNewLiveIcon());
        r7.setGradeDescribeShining(r1.getGradeDescribeShining());
        r7.setRecentConsumeBadge(r1.getRecentConsumeBadge());
    L5:
        com.bytedance.android.live.revenue.common.reactive.c r9 = this.a.f;
        Intrinsics.checkNotNullParameter(r1, "$this$toPayGrade");
        long r10 = r1.getScore();
        long r12 = r1.getLevel();
        long r13 = r1.getThisGradeMaxDiamond();
        long r14 = r1.getThisGradeMinDiamond();
        String r15 = r1.getGradeDescribe();
        py.k r16 = r1.getNewImIconWithLevel();
        v r17 = r1.getBuffInfo();
        r9.setValue(new PayGrade(r10, r12, r14, r13, r15, r16, r1.getNewLiveIcon(), r17, r1.getGradeDescribeShining(), r1.getDescribeType(), r1.getExtra(), r1.getEffectType(), r1.getShortDesc(), r1.getShortPreDesc(), r1.getJumpSchema(), r1.getEffectImg(), r1.getEffectDurationMilli(), r1.getEffectPlayTimes(), r1.getRecentConsumeBadge()));
    }
}
