package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.a0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowGiftExposureAnim;", "Lcom/bytedance/android/anya/a0;", BuildConfig.FLAVOR, "pagerPosition", "I", "getPagerPosition", "()I", "position", "getPosition", "Lpy/k;", "anim", "Lpy/k;", "getAnim", "()Lpy/k;", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "<init>", "(IILpy/k;II)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowGiftExposureAnim implements a0 {
    private final k anim;
    private final int counterPosition;
    private final int pagerPosition;
    private final int position;
    private final int topicPagerPosition;

    public final k getAnim() {
        return this.anim;
    }

    public final int getCounterPosition() {
        return this.counterPosition;
    }

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public ShowGiftExposureAnim(int r1, int r2, k r3, int r4, int r5) {
        this.pagerPosition = r1;
        this.position = r2;
        this.anim = r3;
        this.counterPosition = r4;
        this.topicPagerPosition = r5;
    }

    public /* synthetic */ ShowGiftExposureAnim(int r8, int r9, k r10, int r11, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        int r5 = -1;
    L7:
        if ((r14 & 16) == 0) goto L9;
        int r6 = -1;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r13;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
