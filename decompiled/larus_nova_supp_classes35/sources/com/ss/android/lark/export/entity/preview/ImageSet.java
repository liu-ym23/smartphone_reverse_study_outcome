package com.ss.android.lark.export.entity.preview;

import com.ss.android.lark.image.entity.Image;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0000J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ji\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006)"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ImageSet;", "Ljava/io/Serializable;", "key", BuildConfig.FLAVOR, "origin", "Lcom/ss/android/lark/image/entity/Image;", "thumbnail", "middle", "thumbnailWebp", "middleWebp", "middleMp4", "cover", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;)V", "getKey", "()Ljava/lang/String;", "getOrigin", "()Lcom/ss/android/lark/image/entity/Image;", "getThumbnail", "getMiddle", "getThumbnailWebp", "getMiddleWebp", "getMiddleMp4", "getCover", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSet implements Serializable {
    private final Image cover;
    private final String key;
    private final Image middle;
    private final Image middleMp4;
    private final Image middleWebp;
    private final Image origin;
    private final Image thumbnail;
    private final Image thumbnailWebp;

    public ImageSet() {
        this(null, null, null, null, null, null, null, null, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    }

    public static /* synthetic */ ImageSet copy$default(ImageSet r9, String r10, Image r11, Image r12, Image r13, Image r14, Image r15, Image r16, Image r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.key;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Image r3 = r9.origin;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Image r4 = r9.thumbnail;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Image r5 = r9.middle;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Image r6 = r9.thumbnailWebp;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Image r7 = r9.middleWebp;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Image r8 = r9.middleMp4;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Image r1 = r9.cover;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final Image component2() {
        return this.origin;
    }

    public final Image component3() {
        return this.thumbnail;
    }

    public final Image component4() {
        return this.middle;
    }

    public final Image component5() {
        return this.thumbnailWebp;
    }

    public final Image component6() {
        return this.middleWebp;
    }

    public final Image component7() {
        return this.middleMp4;
    }

    public final Image component8() {
        return this.cover;
    }

    public final ImageSet copy(String r11, Image r12, Image r13, Image r14, Image r15, Image r16, Image r17, Image r18) {
        return new ImageSet(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public String toString() {
        return "ImageSet(key=" + this.key + ", origin=" + this.origin + ", thumbnail=" + this.thumbnail + ", middle=" + this.middle + ", thumbnailWebp=" + this.thumbnailWebp + ", middleWebp=" + this.middleWebp + ", middleMp4=" + this.middleMp4 + ", cover=" + this.cover + ')';
    }

    public final ImageSet clone() {
        return new ImageSet(this.key, this.origin, this.thumbnail, this.middle, this.thumbnailWebp, this.middleWebp, this.middleMp4, this.cover);
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Image r4 = this.origin;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Image r7 = this.thumbnail;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Image r10 = this.middle;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Image r13 = this.thumbnailWebp;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Image r16 = this.middleWebp;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Image r19 = this.middleMp4;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Image r22 = this.cover;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final Image getCover() {
        return this.cover;
    }

    public final String getKey() {
        return this.key;
    }

    public final Image getMiddle() {
        return this.middle;
    }

    public final Image getMiddleMp4() {
        return this.middleMp4;
    }

    public final Image getMiddleWebp() {
        return this.middleWebp;
    }

    public final Image getOrigin() {
        return this.origin;
    }

    public final Image getThumbnail() {
        return this.thumbnail;
    }

    public final Image getThumbnailWebp() {
        return this.thumbnailWebp;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(ImageSet.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.ImageSet");
        ImageSet r6 = (ImageSet) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.origin, r6.origin) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.thumbnail, r6.thumbnail) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.middle, r6.middle) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.thumbnailWebp, r6.thumbnailWebp) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.middleWebp, r6.middleWebp) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.middleMp4, r6.middleMp4) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.cover, r6.cover) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public ImageSet(String r1, Image r2, Image r3, Image r4, Image r5, Image r6, Image r7, Image r8) {
        this.key = r1;
        this.origin = r2;
        this.thumbnail = r3;
        this.middle = r4;
        this.thumbnailWebp = r5;
        this.middleWebp = r6;
        this.middleMp4 = r7;
        this.cover = r8;
    }

    public /* synthetic */ ImageSet(String r10, Image r11, Image r12, Image r13, Image r14, Image r15, Image r16, Image r17, int r18, DefaultConstructorMarker r19) {
        Image r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Image r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Image r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Image r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Image r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Image r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Image r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
