package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.util.GiftListFetchAction;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface i extends dy0.c {
    void F(List<? extends h1> r1);

    String F5(int r1);

    void J2(com.bytedance.android.livesdk.gift.platform.core.model.i r1, int r2, int r3, boolean r4, List<? extends w1> r5, ReceiverType r6, boolean r7, List<Long> r8, Integer r9, long r10, long r13, String r14);

    GiftListFetchAction K3(int r1);

    void N(long r1, int r3, @MostlyUsedGiftOperateAction int r4, ReceiverType r5);

    int N0();

    com.bytedance.android.livesdk.gift.platform.core.model.j N3();

    void R(int r1);

    w1 U(int r1);

    void X(h1 r1);

    long c5();

    h1 d(String r1);

    py.k f3();

    Map<String, String> getExtraParam();

    List<h1> getStickerGifts();

    void h3(Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i> r1);

    boolean isGiftListLoaded();

    com.bytedance.android.livesdk.gift.platform.core.model.d j0();

    Map<String, Long> n3();

    com.bytedance.android.livesdk.gift.platform.core.model.l n5();

    h1 o4(long r1, Integer r3);

    List<com.bytedance.android.livesdk.gift.platform.core.model.e> q();

    void s5(List<? extends h1> r1);

    void y(List<? extends h1> r1);

    h1 y3(long r1);

    h1 z1(long r1, Integer r3);
}
