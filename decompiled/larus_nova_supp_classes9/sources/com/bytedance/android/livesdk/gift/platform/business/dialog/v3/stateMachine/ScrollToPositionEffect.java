package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.a0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollToPositionEffect;", "Lcom/bytedance/android/anya/a0;", BuildConfig.FLAVOR, "pagerPosition", "I", "getPagerPosition", "()I", "position", "getPosition", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", BuildConfig.FLAVOR, "isDefault", "Z", "()Z", "isSearchLocate", "<init>", "(IIIIZZ)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollToPositionEffect implements a0 {
    private final int counterPosition;
    private final boolean isDefault;
    private final boolean isSearchLocate;
    private final int pagerPosition;
    private final int position;
    private final int topicPagerPosition;

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

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final boolean isSearchLocate() {
        return this.isSearchLocate;
    }

    public ScrollToPositionEffect(int r1, int r2, int r3, int r4, boolean r5, boolean r6) {
        this.pagerPosition = r1;
        this.position = r2;
        this.counterPosition = r3;
        this.topicPagerPosition = r4;
        this.isDefault = r5;
        this.isSearchLocate = r6;
    }

    public /* synthetic */ ScrollToPositionEffect(int r8, int r9, int r10, int r11, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L5;
        int r4 = -1;
    L7:
        if ((r15 & 16) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r15 & 32) == 0) goto L13;
        boolean r6 = false;
    L14:
        this(r8, r9, r10, r4, r5, r6);
        return;
    L13:
        r6 = r14;
        goto L14
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }
}
