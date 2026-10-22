package com.bytedance.android.live.base.model.emoji;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SelfEmoji extends BaseEmoji implements Serializable, ISelfEmoji {
    private static final long serialVersionUID = 0;

    @SerializedName("animate_type")
    private String animateType;

    @SerializedName("animatedImage")
    private ImageModel animatedImage;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("id")
    private String id;

    @SerializedName("isFromCache")
    private boolean isFromCache;

    @SerializedName("is_gif")
    private boolean isGif;

    @SerializedName("url_list")
    private List<String> mUrls;

    @SerializedName("origin_package_id")
    private long resourcesId;

    @SerializedName("selfPosition")
    private int[] selfPosition;

    @SerializedName("staticImage")
    private ImageModel staticImage;

    @SerializedName("sticker_type")
    private int stickerType;

    @SerializedName("height")
    private int viewHeight;

    @SerializedName("width")
    private int viewWidth;

    @SerializedName("web_uri")
    private String webUri;

    public SelfEmoji() {
        this.mUrls = new ArrayList();
        setType(BaseEmoji.Type.SelfEmoji);
    }

    /* JADX INFO: renamed from: getAnimatedImage, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ k m26getAnimatedImage() {
        return getAnimatedImage();
    }

    /* JADX INFO: renamed from: getStaticImage, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ k m27getStaticImage() {
        return getStaticImage();
    }

    public String getAnimateType() {
        return this.animateType;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public long getResourcesId() {
        return this.resourcesId;
    }

    public int[] getSelfPosition() {
        return this.selfPosition;
    }

    public int getStickerType() {
        return this.stickerType;
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    public int getViewWidth() {
        return this.viewWidth;
    }

    public String getWebUri() {
        return this.webUri;
    }

    public List<String> getmUrls() {
        return this.mUrls;
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public boolean isGif() {
        return this.isGif;
    }

    public ImageModel getAnimatedImage() {
        return this.animatedImage;
    }

    public ImageModel getStaticImage() {
        return this.staticImage;
    }

    public void setAnimateType(String r1) {
        this.animateType = r1;
    }

    public void setAnimatedImage(ImageModel r1) {
        this.animatedImage = r1;
    }

    public void setDisplayName(String r1) {
        this.displayName = r1;
    }

    public void setGif(boolean r1) {
        this.isGif = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setIsFromCache(boolean r1) {
        this.isFromCache = r1;
    }

    public void setResourcesId(long r1) {
        this.resourcesId = r1;
    }

    public void setSelfPosition(int[] r1) {
        this.selfPosition = r1;
    }

    public void setStaticImage(ImageModel r1) {
        this.staticImage = r1;
    }

    public void setStickerType(int r1) {
        this.stickerType = r1;
    }

    public void setUrls(List<String> r1) {
        this.mUrls = r1;
    }

    public void setViewHeight(int r1) {
        this.viewHeight = r1;
    }

    public void setViewWidth(int r1) {
        this.viewWidth = r1;
    }

    public void setWebUri(String r1) {
        this.webUri = r1;
    }
}
