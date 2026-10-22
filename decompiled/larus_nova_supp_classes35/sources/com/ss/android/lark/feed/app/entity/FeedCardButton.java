package com.ss.android.lark.feed.app.entity;

import com.bytedance.lark.pb.basic.v1.AppFeedCardButton;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedCardButton;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "id", BuildConfig.FLAVOR, "url", "actionType", "Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ActionType;", "text", "buttonType", "Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ButtonType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ActionType;Ljava/lang/String;Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ButtonType;)V", "getId", "()Ljava/lang/String;", "getUrl", "getActionType", "()Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ActionType;", "getText", "getButtonType", "()Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ButtonType;", "isItemSame", BuildConfig.FLAVOR, "other", "isContentSame", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCardButton implements b<FeedCardButton>, Serializable {
    private final AppFeedCardButton.ActionType actionType;
    private final AppFeedCardButton.ButtonType buttonType;
    private final String id;
    private final String text;
    private final String url;

    public final AppFeedCardButton.ActionType getActionType() {
        return this.actionType;
    }

    public final AppFeedCardButton.ButtonType getButtonType() {
        return this.buttonType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean isContentSame(FeedCardButton r3) {
        if (r3 != null) goto L4;
    L14:
        return false;
    L4:
        if (Intrinsics.areEqual(this.id, r3.id) == false) goto L14;
        if (Intrinsics.areEqual(this.url, r3.url) == false) goto L14;
        if (this.actionType != r3.actionType) goto L14;
        if (Intrinsics.areEqual(this.text, r3.text) == false) goto L14;
        if (this.buttonType != r3.buttonType) goto L14;
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((FeedCardButton) r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((FeedCardButton) r1);
    }

    public boolean isItemSame(FeedCardButton r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public FeedCardButton(String r2, String r3, AppFeedCardButton.ActionType r4, String r5, AppFeedCardButton.ButtonType r6) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "buttonType");
        this.id = r2;
        this.url = r3;
        this.actionType = r4;
        this.text = r5;
        this.buttonType = r6;
    }
}
