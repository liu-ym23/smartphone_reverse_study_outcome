package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class InteractEmojiAnim extends d implements vh7.c.a<f>, f {
    public static final int TYPE_ICON_MOVE = 1;
    public static final int TYPE_MIC_SEAT = 4;
    public static final int TYPE_TRACK_EFFECT = 2;
    public static final int TYPE_TRANS_EFFECT = 3;
    public static final int TYPE_UNDEFINED = 0;

    @SerializedName("interact_emoji")
    public py.k dynamicImage;

    @SerializedName("own_emoji")
    public py.k extraDynamicImage;
    private transient FlexModelDelegate<f> modelDefaultDelegate;

    @IgnoreProtoFieldCheck
    @SerializedName("interact_emojis")
    public List<py.k> resources;

    public InteractEmojiAnim() {
        this.modelDefaultDelegate = new FlexModelDelegate(f.class, this);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.d, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k dynamicImage() {
        return this.dynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.d, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k extraDynamicImage() {
        return this.extraDynamicImage;
    }

    public FlexModelDelegate<f> getDelegate() {
        return this.modelDefaultDelegate;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k getDynamicImage() {
        return this.dynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getExtraDuration() {
        return this.extraDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k getExtraDynamicImage() {
        return this.extraDynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getOffset() {
        return this.offset;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getOffsetStart() {
        return this.offsetStart;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public boolean getReshape() {
        return this.reshape;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public Long getReshapeStart() {
        return this.reshapeStart;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public List<py.k> getResources() {
        return this.resources;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getSizeScale() {
        return this.sizeScale;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public String getSoundUrl() {
        return this.soundUrl;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getStart() {
        return this.start;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getTimeOffset() {
        return this.timeOffset;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getType() {
        return this.type;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getX() {
        return this.x;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getY() {
        return this.y;
    }

    public boolean isReshape() {
        return this.reshape;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.d, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public List<? extends py.k> resources() {
        return this.resources;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public <R extends vh7.e<f>> R castTo(Class<R> r2) {
        return (R) this.modelDefaultDelegate.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public <R extends vh7.e<f>> R castToOrNull(Class<R> r2) {
        return (R) this.modelDefaultDelegate.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setDuration(long r1) {
        this.duration = r1;
    }

    public void setDynamicImage(py.k r1) {
        this.dynamicImage = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setExtraDuration(long r1) {
        this.extraDuration = r1;
    }

    public void setExtraDynamicImage(py.k r1) {
        this.extraDynamicImage = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setLevel(int r1) {
        this.level = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setOffset(long r1) {
        this.offset = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setOffsetStart(int r1) {
        this.offsetStart = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setReshape(boolean r1) {
        this.reshape = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setReshapeStart(Long r1) {
        this.reshapeStart = r1;
    }

    public void setResources(List<py.k> r1) {
        this.resources = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setSizeScale(long r1) {
        this.sizeScale = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setSoundUrl(String r1) {
        this.soundUrl = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setStart(long r1) {
        this.start = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setTimeOffset(int r1) {
        this.timeOffset = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setType(int r1) {
        this.type = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setX(int r1) {
        this.x = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setY(int r1) {
        this.y = r1;
    }
}
