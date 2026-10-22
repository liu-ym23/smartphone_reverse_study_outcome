package com.ss.android.lark.chat.entity.image;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001bB;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0000H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/image/ImagePassThrough;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "fsUnit", BuildConfig.FLAVOR, "key", "crypto", "Lcom/ss/android/lark/chat/entity/image/Crypto;", "fileType", BuildConfig.FLAVOR, "width", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/image/Crypto;III)V", "getFsUnit", "()Ljava/lang/String;", "getKey", "getCrypto", "()Lcom/ss/android/lark/chat/entity/image/Crypto;", "getFileType", "()I", "getWidth", "getHeight", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePassThrough implements Serializable, b<ImagePassThrough> {
    public static final a Companion = null;

    @SerializedName("crypto")
    private final Crypto crypto;

    @SerializedName(IPortraitService.TYPE)
    private final int fileType;

    @SerializedName("fsUnit")
    private final String fsUnit;

    @SerializedName("height")
    private final int height;

    @SerializedName("key")
    private final String key;

    @SerializedName("width")
    private final int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final Crypto getCrypto() {
        return this.crypto;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getFsUnit() {
        return this.fsUnit;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getWidth() {
        return this.width;
    }

    public boolean isContentSame(ImagePassThrough r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<ImagePassThrough> r2 = ImagePassThrough.class;
    L10:
        if (Intrinsics.areEqual(ImagePassThrough.class, r2) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.fsUnit, r5.fsUnit) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.key, r5.key) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.crypto, r5.crypto) == true) goto L22;
        return false;
    L22:
        if (this.fileType == r5.fileType) goto L25;
        return false;
    L25:
        if (this.width == r5.width) goto L28;
        return false;
    L28:
        if (this.height == r5.height) goto L30;
        return false;
    L30:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((ImagePassThrough) r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((ImagePassThrough) r1);
    }

    public boolean isItemSame(ImagePassThrough r1) {
        return isContentSame(r1);
    }

    public ImagePassThrough(String r2, String r3, Crypto r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "key");
        this.fsUnit = r2;
        this.key = r3;
        this.crypto = r4;
        this.fileType = r5;
        this.width = r6;
        this.height = r7;
    }
}
