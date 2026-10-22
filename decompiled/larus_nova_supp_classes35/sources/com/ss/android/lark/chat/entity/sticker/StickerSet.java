package com.ss.android.lark.chat.entity.sticker;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.entity.Image;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StickerSet implements Serializable {
    private Archive mArchive;
    private String mAuthorId;
    private Image mCover;
    private String mDescription;
    private boolean mHasPaid;
    private Image mIcon;
    private Perm mPerm;
    private Image mPreview;
    private String mStickerSetId;
    private StickerSetType mStickerSetType;
    private List<Sticker> mStickers;
    private String mTitle;
    private long mUpdateTime;
    private int mVersion;

    public static final enum Perm extends Enum<Perm> {
        public static final Perm ALONE = null;
        public static final Perm OWN = null;
        public static final Perm UNKNOWN = null;
        public static final /* synthetic */ Perm[] a = null;
        private int mValue;

        static {
            Perm r0 = new Perm("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Perm r1 = new Perm("ALONE", 1, 1);
            ALONE = r1;
            Perm r3 = new Perm("OWN", 2, 2);
            OWN = r3;
            a = new Perm[]{r0, r1, r3};
        }

        public static Perm[] values() {
            return (Perm[]) a.clone();
        }

        public int getNumber() {
            return this.mValue;
        }

        public static Perm forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return OWN;
        L12:
            return ALONE;
        L14:
            return UNKNOWN;
        }

        public static Perm valueOf(String r1) {
            return (Perm) a.a(Perm.class, r1);
        }

        public static Perm valueOf(int r0) {
            return forNumber(r0);
        }

        public Perm(String r1, int r2, int r3) {
            super(r1, r2);
            this.mValue = r3;
        }
    }

    public StickerSet() {
    }

    public String getArchiveKey() {
        Archive r0 = this.mArchive;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0.getKey();
    }

    public String getArchiveUrl() {
        Archive r0 = this.mArchive;
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        List<String> r1 = r0.getUrls();
        if (CollectionUtils.isEmpty(r1) == false) goto L9;
        return BuildConfig.FLAVOR;
    L9:
        return (String) ListProtector.get(r1, 0);
    }

    public String getPreviewKey() {
        Image r0 = this.mPreview;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0.getKey();
    }

    public boolean isAdded() {
        if (this.mPerm != Perm.OWN) goto L5;
        return true;
    L5:
        return false;
    }

    public Archive getArchive() {
        return this.mArchive;
    }

    public String getAuthorId() {
        return this.mAuthorId;
    }

    public Image getCover() {
        return this.mCover;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Image getIcon() {
        return this.mIcon;
    }

    public Perm getPerm() {
        return this.mPerm;
    }

    public Image getPreview() {
        return this.mPreview;
    }

    public String getStickerSetId() {
        return this.mStickerSetId;
    }

    public StickerSetType getStickerSetType() {
        return this.mStickerSetType;
    }

    public List<Sticker> getStickers() {
        return this.mStickers;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean isHasPaid() {
        return this.mHasPaid;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L31;
        StickerSet r8 = (StickerSet) r7;
        if (TextUtils.equals(this.mStickerSetId, r8.getStickerSetId()) == true) goto L14;
        return false;
    L14:
        if (this.mPerm == r8.mPerm) goto L16;
        return false;
    L16:
        List<Sticker> r2 = this.mStickers;
        if (r2 == null) goto L31;
        if (r8.mStickers == null) goto L31;
        if (r2.size() == r8.getStickers().size()) goto L24;
        return false;
    L24:
        int r3 = this.mStickers.size();
        int r4 = 0;
    L25:
        if (r4 >= r3) goto L30;
        if (((Sticker) ListProtector.get(this.mStickers, r4)).equals(ListProtector.get(r8.getStickers(), r4)) == false) goto L28;
        r4 = r4 + 1;
        goto L25
    L28:
        return false;
    L30:
        return true;
    }

    public void setArchive(Archive r1) {
        this.mArchive = r1;
    }

    public void setAuthorId(String r1) {
        this.mAuthorId = r1;
    }

    public void setCover(Image r1) {
        this.mCover = r1;
    }

    public void setDescription(String r1) {
        this.mDescription = r1;
    }

    public void setHasPaid(boolean r1) {
        this.mHasPaid = r1;
    }

    public void setIcon(Image r1) {
        this.mIcon = r1;
    }

    public void setPerm(Perm r1) {
        this.mPerm = r1;
    }

    public void setPreview(Image r1) {
        this.mPreview = r1;
    }

    public void setStickerSetId(String r1) {
        this.mStickerSetId = r1;
    }

    public void setStickerSetType(StickerSetType r1) {
        this.mStickerSetType = r1;
    }

    public void setStickers(List<Sticker> r1) {
        this.mStickers = r1;
    }

    public void setTitle(String r1) {
        this.mTitle = r1;
    }

    public void setUpdateTime(long r1) {
        this.mUpdateTime = r1;
    }

    public void setVersion(int r1) {
        this.mVersion = r1;
    }
}
