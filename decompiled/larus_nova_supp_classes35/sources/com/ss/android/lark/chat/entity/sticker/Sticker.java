package com.ss.android.lark.chat.entity.sticker;

import android.text.TextUtils;
import com.ss.android.lark.image.entity.BaseImageSet;
import com.ss.android.lark.image.entity.Image;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import r27.a;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Sticker implements Serializable, Comparable, b<Sticker> {
    private String mDesc;
    private boolean mHasPaid;
    private BaseImageSet mImageSet;
    private Mode mMode;
    private int mPosition;
    private String mSmallUrl;
    private String mStickerId;
    private String mStickerSetId;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode MEME = null;
        public static final Mode STICKER = null;
        public static final Mode UNKNOWN = null;
        public static final /* synthetic */ Mode[] a = null;
        private int mValue;

        static {
            Mode r0 = new Mode("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Mode r1 = new Mode("STICKER", 1, 1);
            STICKER = r1;
            Mode r3 = new Mode("MEME", 2, 2);
            MEME = r3;
            a = new Mode[]{r0, r1, r3};
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public int getNumber() {
            return this.mValue;
        }

        public static Mode forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return MEME;
        L12:
            return STICKER;
        L14:
            return UNKNOWN;
        }

        public static Mode valueOf(String r1) {
            return (Mode) a.a(Mode.class, r1);
        }

        public static Mode valueOf(int r0) {
            return forNumber(r0);
        }

        public Mode(String r1, int r2, int r3) {
            super(r1, r2);
            this.mValue = r3;
        }
    }

    public Sticker() {
    }

    public int hashCode() {
        String r0 = this.mStickerId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        String r3 = getOriginImageKey();
        int r4 = r2 * 31;
        if (r3 == null) goto L9;
        int r5 = r3.hashCode();
    L10:
        int r6 = r4 + r5;
        String r7 = getThumbnailImageKey();
        int r8 = r6 * 31;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r8 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String getImageKey() {
        String r0 = getThumbnailImageKey();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = getSmallUrl();
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        return getOriginImageKey();
    }

    public int getOriginImageHeight() {
        BaseImageSet r0 = getImageSet();
        if (r0 != null) goto L5;
        Image r1 = null;
    L6:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.getHeight();
    L5:
        r1 = r0.getOrigin();
        goto L6
    }

    public String getOriginImageKey() {
        BaseImageSet r0 = getImageSet();
        if (r0 != null) goto L5;
        Image r1 = null;
    L6:
        if (r1 != null) goto L10;
        return BuildConfig.FLAVOR;
    L10:
        return r1.getKey();
    L5:
        r1 = r0.getOrigin();
        goto L6
    }

    public int getOriginImageWidth() {
        BaseImageSet r0 = getImageSet();
        if (r0 != null) goto L5;
        Image r1 = null;
    L6:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.getWidth();
    L5:
        r1 = r0.getOrigin();
        goto L6
    }

    public String getThumbnailImageKey() {
        BaseImageSet r0 = getImageSet();
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        Image r1 = r0.getThumbnail();
        if (r1 != null) goto L9;
        return BuildConfig.FLAVOR;
    L9:
        return r1.getKey();
    }

    public String getDesc() {
        return this.mDesc;
    }

    public BaseImageSet getImageSet() {
        return this.mImageSet;
    }

    public Mode getMode() {
        return this.mMode;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public String getSmallUrl() {
        return this.mSmallUrl;
    }

    public String getStickerId() {
        return this.mStickerId;
    }

    public String getStickerSetId() {
        return this.mStickerSetId;
    }

    public boolean isHasPaid() {
        return this.mHasPaid;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r4) {
        if ((r4 instanceof Sticker) == false) goto L12;
        Sticker r5 = (Sticker) r4;
        if (getPosition() >= r5.getPosition()) goto L9;
        return -1;
    L9:
        if (getPosition() <= r5.getPosition()) goto L12;
        return 1;
    L12:
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        Sticker r6 = (Sticker) r5;
        if (TextUtils.equals(this.mStickerId, r6.getStickerId()) == true) goto L13;
    L17:
        return false;
    L13:
        if (TextUtils.equals(getOriginImageKey(), r6.getOriginImageKey()) == false) goto L17;
        if (TextUtils.equals(getThumbnailImageKey(), r6.getThumbnailImageKey()) == false) goto L17;
        return true;
    }

    public boolean isContentSame(Sticker r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (isItemSame(r4) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(getOriginImageKey(), r4.getOriginImageKey()) == true) goto L10;
        return false;
    L10:
        if (TextUtils.equals(getThumbnailImageKey(), r4.getThumbnailImageKey()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isItemSame(Sticker r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.mStickerId, r4.getStickerId()) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(this.mStickerSetId, r4.getStickerSetId()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void setDesc(String r1) {
        this.mDesc = r1;
    }

    public void setHasPaid(boolean r1) {
        this.mHasPaid = r1;
    }

    public void setImageSet(BaseImageSet r1) {
        this.mImageSet = r1;
    }

    public void setMode(Mode r1) {
        this.mMode = r1;
    }

    public void setPosition(int r1) {
        this.mPosition = r1;
    }

    public void setSmallUrl(String r1) {
        this.mSmallUrl = r1;
    }

    public void setStickerId(String r1) {
        this.mStickerId = r1;
    }

    public void setStickerSetId(String r1) {
        this.mStickerSetId = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Sticker) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Sticker) r1);
    }
}
