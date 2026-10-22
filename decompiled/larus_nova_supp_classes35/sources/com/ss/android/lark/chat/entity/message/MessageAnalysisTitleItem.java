package com.ss.android.lark.chat.entity.message;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageAnalysisTitleItem;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", IPortraitService.NAME, BuildConfig.FLAVOR, "iconUrl", "jumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getIconUrl", "getJumpUrl", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "component1", "component2", "component3", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageAnalysisTitleItem implements b<MessageAnalysisTitleItem>, Serializable {
    private final String iconUrl;
    private final String jumpUrl;
    private final String name;

    public static /* synthetic */ MessageAnalysisTitleItem copy$default(MessageAnalysisTitleItem r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.iconUrl;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.jumpUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final MessageAnalysisTitleItem copy(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r3, "iconUrl");
        Intrinsics.checkNotNullParameter(r4, "jumpUrl");
        return new MessageAnalysisTitleItem(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageAnalysisTitleItem) == true) goto L8;
        return false;
    L8:
        MessageAnalysisTitleItem r6 = (MessageAnalysisTitleItem) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jumpUrl, r6.jumpUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    public String toString() {
        return "MessageAnalysisTitleItem(name=" + this.name + ", iconUrl=" + this.iconUrl + ", jumpUrl=" + this.jumpUrl + ')';
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getName() {
        return this.name;
    }

    public boolean isContentSame(MessageAnalysisTitleItem r4) {
        String r0 = this.name;
        if (r4 == null) goto L5;
        String r1 = r4.name;
    L7:
        if (Intrinsics.areEqual(r0, r1) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iconUrl, r4.iconUrl) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((MessageAnalysisTitleItem) r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((MessageAnalysisTitleItem) r1);
    }

    public boolean isItemSame(MessageAnalysisTitleItem r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public MessageAnalysisTitleItem(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r3, "iconUrl");
        Intrinsics.checkNotNullParameter(r4, "jumpUrl");
        this.name = r2;
        this.iconUrl = r3;
        this.jumpUrl = r4;
    }
}
