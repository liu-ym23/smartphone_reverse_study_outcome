package com.bytedance.android.live.base.model.gift;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.gift.GiftExhibitionHomeResponse.Data")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/bytedance/android/live/base/model/gift/h;", "", "", "anchorName", "Ljava/lang/String;", "getAnchorName", "()Ljava/lang/String;", "setAnchorName", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/base/model/gift/c;", "lightenItems", "Ljava/util/List;", "getLightenItems", "()Ljava/util/List;", "setLightenItems", "(Ljava/util/List;)V", "unLightenItems", "getUnLightenItems", "setUnLightenItems", "defaultGift", "Lcom/bytedance/android/live/base/model/gift/c;", "getDefaultGift", "()Lcom/bytedance/android/live/base/model/gift/c;", "setDefaultGift", "(Lcom/bytedance/android/live/base/model/gift/c;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "rightImg", "Lcom/bytedance/android/live/base/model/ImageModel;", "getRightImg", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setRightImg", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "exhibitionEntranceUrl", "getExhibitionEntranceUrl", "setExhibitionEntranceUrl", "", "anchorId", "J", "getAnchorId", "()J", "setAnchorId", "(J)V", "Lcom/bytedance/android/live/base/model/gift/e;", "exhibitionNotice", "Lcom/bytedance/android/live/base/model/gift/e;", "getExhibitionNotice", "()Lcom/bytedance/android/live/base/model/gift/e;", "setExhibitionNotice", "(Lcom/bytedance/android/live/base/model/gift/e;)V", "Lcom/bytedance/android/live/base/model/gift/f;", "exhibitionStarInfo", "Lcom/bytedance/android/live/base/model/gift/f;", "getExhibitionStarInfo", "()Lcom/bytedance/android/live/base/model/gift/f;", "setExhibitionStarInfo", "(Lcom/bytedance/android/live/base/model/gift/f;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("anchor_id")
    protected long anchorId;

    @SerializedName("anchor_name")
    protected String anchorName;

    @SerializedName("default_gift")
    protected c defaultGift;

    @SerializedName("exhibition_entrance_url")
    protected String exhibitionEntranceUrl;

    @SerializedName("notice")
    protected e exhibitionNotice;

    @SerializedName("star_info")
    protected f exhibitionStarInfo;

    @SerializedName("lighted_items")
    protected List<c> lightenItems;

    @SerializedName("right_img")
    protected ImageModel rightImg;

    @SerializedName("unlighted_items")
    protected List<c> unLightenItems;

    public h() {
    }

    public h(am3.g r5) {
        this.lightenItems = new ArrayList();
        this.unLightenItems = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L17;
        switch(r2) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.exhibitionStarInfo = new f(r5);
        goto L3
    L8:
        this.exhibitionNotice = new e(r5);
        goto L3
    L9:
        this.anchorId = r5.j();
        goto L3
    L10:
        this.exhibitionEntranceUrl = am3.h.c(r5);
        goto L3
    L11:
        this.rightImg = x.a(r5);
        goto L3
    L12:
        this.defaultGift = new c(r5);
        goto L3
    L13:
        List<c> r3 = this.unLightenItems;
        c r4 = new c(r5);
    L15:
        r3.add(r4);
        goto L3
    L14:
        r3 = this.lightenItems;
        r4 = new c(r5);
        goto L15
    L16:
        this.anchorName = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L17:
        r5.d(r0);
    }
}
