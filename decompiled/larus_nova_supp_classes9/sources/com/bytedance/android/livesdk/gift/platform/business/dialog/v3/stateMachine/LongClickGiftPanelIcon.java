package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/LongClickGiftPanelIcon;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", BuildConfig.FLAVOR, "position", "I", "getPosition", "()I", "listPagerPosition", "getListPagerPosition", "positionX", "getPositionX", "positionY", "getPositionY", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "showInfo", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "getShowInfo", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", BuildConfig.FLAVOR, "isSearch", "Z", "()Z", "<init>", "(IIIIIILcom/bytedance/android/livesdk/gift/platform/core/model/n;Z)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongClickGiftPanelIcon extends GiftUIAction {
    private final int counterPosition;
    private final boolean isSearch;
    private final int listPagerPosition;
    private final int position;
    private final int positionX;
    private final int positionY;
    private final n showInfo;
    private final int topicPagerPosition;

    public final int getCounterPosition() {
        return this.counterPosition;
    }

    public final int getListPagerPosition() {
        return this.listPagerPosition;
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

    public LongClickGiftPanelIcon(int r5, int r6, int r7, int r8, int r9, int r10, n r11, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "showInfo");
        super(false, "LongClickGiftPanelIcon", 1, null);
        this.position = r5;
        this.listPagerPosition = r6;
        this.positionX = r7;
        this.positionY = r8;
        this.counterPosition = r9;
        this.topicPagerPosition = r10;
        this.showInfo = r11;
        this.isSearch = r13;
    }

    public /* synthetic */ LongClickGiftPanelIcon(int r13, int r14, int r15, int r16, int r17, int r18, n r19, boolean r20, int r21, DefaultConstructorMarker r23) {
        if ((r21 & 16) == 0) goto L5;
        int r8 = -1;
    L7:
        if ((r21 & 32) == 0) goto L9;
        int r9 = -1;
    L11:
        if ((r21 & 64) == 0) goto L13;
        n r10 = new n(null, null, 7);
    L15:
        if ((r21 & 128) == 0) goto L17;
        boolean r11 = false;
    L18:
        this(r13, r14, r15, r16, r8, r9, r10, r11);
        return;
    L17:
        r11 = r20;
        goto L18
    L13:
        r10 = r19;
        goto L15
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }
}
