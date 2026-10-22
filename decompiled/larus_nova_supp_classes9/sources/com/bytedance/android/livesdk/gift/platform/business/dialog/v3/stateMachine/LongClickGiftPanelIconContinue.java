package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@TraceExclude
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/LongClickGiftPanelIconContinue;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", BuildConfig.FLAVOR, "position", "I", "getPosition", "()I", "positionX", "getPositionX", "positionY", "getPositionY", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "showInfo", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "getShowInfo", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", BuildConfig.FLAVOR, "isSearch", "Z", "()Z", "<init>", "(IIIIILcom/bytedance/android/livesdk/gift/platform/core/model/n;Z)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongClickGiftPanelIconContinue extends GiftUIAction {
    private final int counterPosition;
    private final boolean isSearch;
    private final int position;
    private final int positionX;
    private final int positionY;
    private final n showInfo;
    private final int topicPagerPosition;

    public final int getCounterPosition() {
        return this.counterPosition;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getPositionX() {
        return this.positionX;
    }

    public final int getPositionY() {
        return this.positionY;
    }

    public final n getShowInfo() {
        return this.showInfo;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public LongClickGiftPanelIconContinue(int r5, int r6, int r7, int r8, int r9, n r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "showInfo");
        super(false, "LongClickGiftPanelIconContinue", 1, null);
        this.position = r5;
        this.positionX = r6;
        this.positionY = r7;
        this.counterPosition = r8;
        this.topicPagerPosition = r9;
        this.showInfo = r10;
        this.isSearch = r11;
    }

    public /* synthetic */ LongClickGiftPanelIconContinue(int r11, int r13, int r14, int r15, int r16, n r17, boolean r18, int r19, DefaultConstructorMarker r110) {
        if ((r19 & 8) == 0) goto L5;
        int r6 = -1;
    L7:
        if ((r19 & 16) == 0) goto L9;
        int r7 = -1;
    L11:
        if ((r19 & 32) == 0) goto L13;
        n r8 = new n(null, null, 7);
    L15:
        if ((r19 & 64) == 0) goto L17;
        boolean r9 = false;
    L18:
        this(r11, r13, r14, r6, r7, r8, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }
}
