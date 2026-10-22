package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.ss.android.lark.chat.entity.sticker.StickerInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\tJ\u0006\u0010-\u001a\u00020\u0015J\b\u0010.\u001a\u0004\u0018\u00010'J\u0012\u0010/\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0016J\u0006\u00101\u001a\u00020\u0015J\b\u00102\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR6\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'0&j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'`(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00063"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/StickerContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "key", BuildConfig.FLAVOR, "width", BuildConfig.FLAVOR, "height", "(Ljava/lang/String;II)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "isAdded", BuildConfig.FLAVOR, "()Z", "setAdded", "(Z)V", "stickerInfo", "Lcom/ss/android/lark/chat/entity/sticker/StickerInfo;", "getStickerInfo", "()Lcom/ss/android/lark/chat/entity/sticker/StickerInfo;", "setStickerInfo", "(Lcom/ss/android/lark/chat/entity/sticker/StickerInfo;)V", "stickerSetId", "getStickerSetId", "setStickerSetId", "stickerId", "getStickerId", "setStickerId", "cleanResourceKeyScene", "Ljava/util/HashMap;", "Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "Lkotlin/collections/HashMap;", "getCleanResourceKeyScene", "()Ljava/util/HashMap;", "setCleanResourceKeyScene", "(Ljava/util/HashMap;)V", "resourceIsCleaned", "currentResourceScene", "isContentSame", "diffable", "isPaid", "getDescription", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "StickerContent")
public final class StickerContent extends Content {
    private HashMap<String, ResourceCleanScene> cleanResourceKeyScene;
    private int height;
    private boolean isAdded;
    private String key;
    private String stickerId;
    private StickerInfo stickerInfo;
    private String stickerSetId;
    private int width;

    public final ResourceCleanScene currentResourceScene() {
        String r0 = this.key;
        if (r0 == null) goto L5;
        ResourceCleanScene r1 = this.cleanResourceKeyScene.get(r0);
        if (r1 == null) goto L9;
        return r1;
    L9:
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    L5:
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    }

    public final String getDescription() {
        StickerInfo r0 = this.stickerInfo;
        if (r0 == null) goto L6;
        String r1 = r0.getDescription();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    public final boolean isPaid() {
        StickerInfo r0 = this.stickerInfo;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isHasPaid();
    }

    public final boolean resourceIsCleaned() {
        return !this.cleanResourceKeyScene.isEmpty();
    }

    public StickerContent() {
        this.cleanResourceKeyScene = new HashMap();
    }

    public final HashMap<String, ResourceCleanScene> getCleanResourceKeyScene() {
        return this.cleanResourceKeyScene;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getStickerId() {
        return this.stickerId;
    }

    public final StickerInfo getStickerInfo() {
        return this.stickerInfo;
    }

    public final String getStickerSetId() {
        return this.stickerSetId;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAdded() {
        return this.isAdded;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(StickerContent.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.StickerContent");
        StickerContent r6 = (StickerContent) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L16;
        return false;
    L16:
        if (this.width == r6.width) goto L19;
        return false;
    L19:
        if (this.height == r6.height) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.stickerSetId, r6.stickerSetId) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.stickerId, r6.stickerId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.cleanResourceKeyScene, r6.cleanResourceKeyScene) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setAdded(boolean r1) {
        this.isAdded = r1;
    }

    public final void setCleanResourceKeyScene(HashMap<String, ResourceCleanScene> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cleanResourceKeyScene = r2;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setKey(String r1) {
        this.key = r1;
    }

    public final void setStickerId(String r1) {
        this.stickerId = r1;
    }

    public final void setStickerInfo(StickerInfo r1) {
        this.stickerInfo = r1;
    }

    public final void setStickerSetId(String r1) {
        this.stickerSetId = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }

    public StickerContent(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this();
        this.key = r2;
        this.width = r3;
        this.height = r4;
    }
}
