package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnClickGiftPanelIconKeyUp;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "position", BuildConfig.FLAVOR, "positionX", "positionY", "counterPosition", "topicPagerPosition", "isSearch", BuildConfig.FLAVOR, "(IIIIIZ)V", "getCounterPosition", "()I", "()Z", "getPosition", "getPositionX", "getPositionY", "getTopicPagerPosition", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnClickGiftPanelIconKeyUp extends GiftUIAction {
    private final int counterPosition;
    private final boolean isSearch;
    private final int position;
    private final int positionX;
    private final int positionY;
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

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public OnClickGiftPanelIconKeyUp(int r5, int r6, int r7, int r8, int r9, boolean r10) {
        super(false, "OnClickGiftPanelIconKeyUp", 1, null);
        this.position = r5;
        this.positionX = r6;
        this.positionY = r7;
        this.counterPosition = r8;
        this.topicPagerPosition = r9;
        this.isSearch = r10;
    }

    public /* synthetic */ OnClickGiftPanelIconKeyUp(int r10, int r11, int r13, int r14, int r15, boolean r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 8) == 0) goto L5;
        int r6 = -1;
    L7:
        if ((r17 & 16) == 0) goto L9;
        int r7 = -1;
    L11:
        if ((r17 & 32) == 0) goto L13;
        boolean r8 = false;
    L14:
        this(r10, r11, r13, r6, r7, r8);
        return;
    L13:
        r8 = r16;
        goto L14
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }
}
