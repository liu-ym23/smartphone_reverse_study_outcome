package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.luckybox.BoxListResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bx\u0010yR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR/\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001bR+\u0010!\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010 R+\u0010%\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010 R+\u0010,\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020&8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010/\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\r\u001a\u0004\b.\u0010\u001bR+\u00103\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\r\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010 R\u001b\u00106\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b5\u0010\u0016R\u001b\u00109\u001a\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\r\u001a\u0004\b9\u0010:R\u001b\u0010=\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\r\u001a\u0004\b<\u0010)R\u001b\u0010@\u001a\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\r\u001a\u0004\b?\u0010:R7\u0010H\u001a\b\u0012\u0004\u0012\u00020B0A2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020B0A8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\r\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR+\u0010L\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\r\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010 R\u001b\u0010O\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\r\u001a\u0004\bN\u0010)R\u001b\u0010R\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\r\u001a\u0004\bQ\u0010)R\u001b\u0010U\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\r\u001a\u0004\bT\u0010)R\u001b\u0010X\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\r\u001a\u0004\bW\u0010)R\u001b\u0010[\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\r\u001a\u0004\bZ\u0010\u0016R/\u0010_\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010\r\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR/\u0010c\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\r\u001a\u0004\ba\u0010\u0007\"\u0004\bb\u0010\tR+\u0010e\u001a\u0002072\u0006\u0010\u000b\u001a\u0002078V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010\r\u001a\u0004\be\u0010:\"\u0004\bf\u0010gR/\u0010n\u001a\u0004\u0018\u00010h2\b\u0010\u000b\u001a\u0004\u0018\u00010h8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bi\u0010\r\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001b\u0010q\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\r\u001a\u0004\bp\u0010\u001bR\u001b\u0010t\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\br\u0010\r\u001a\u0004\bs\u0010\u0016R\u001b\u0010w\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\r\u001a\u0004\bv\u0010\u001b¨\u0006z"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/ILuckyBoxResponseDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/redpacket/model/b;", "Lpy/k;", "background", "Lpy/k;", "getBackground", "()Lpy/k;", "setBackground", "(Lpy/k;)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<set-?>", "user$delegate", "Ljava/lang/Object;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "", "boxId$delegate", "getBoxId", "()J", "boxId", "", "boxIdStr$delegate", "getBoxIdStr", "()Ljava/lang/String;", "boxIdStr", "sendTime$delegate", "getSendTime", "setSendTime", "(J)V", "sendTime", "delayTime$delegate", "getDelayTime", "setDelayTime", "delayTime", "", "boxType$delegate", "getBoxType", "()I", "setBoxType", "(I)V", "boxType", "title$delegate", "getTitle", "title", "diamondCount$delegate", "getDiamondCount", "setDiamondCount", "diamondCount", "style$delegate", "getStyle", "style", "", "isOfficial$delegate", "isOfficial", "()Z", "priority$delegate", "getPriority", "priority", "large$delegate", "getLarge", "large", "", "Lcom/bytedance/android/live/profit/redpacket/model/c;", "descriptionList$delegate", "getDescriptionList", "()Ljava/util/List;", "setDescriptionList", "(Ljava/util/List;)V", "descriptionList", "displayDuration$delegate", "getDisplayDuration", "setDisplayDuration", "displayDuration", "boxStatus$delegate", "getBoxStatus", "boxStatus", "flatDuration$delegate", "getFlatDuration", "flatDuration", "unpackType$delegate", "getUnpackType", "unpackType", "rushCondition$delegate", "getRushCondition", "rushCondition", "businessType$delegate", "getBusinessType", "businessType", "topCoverImage$delegate", "getTopCoverImage", "setTopCoverImage", "topCoverImage", "bottomCoverImage$delegate", "getBottomCoverImage", "setBottomCoverImage", "bottomCoverImage", "isRiskyOwner$delegate", "isRiskyOwner", "setRiskyOwner", "(Z)V", "Lcom/bytedance/android/live/profit/redpacket/model/b$b;", "dressInfo$delegate", "getDressInfo", "()Lcom/bytedance/android/live/profit/redpacket/model/b$b;", "setDressInfo", "(Lcom/bytedance/android/live/profit/redpacket/model/b$b;)V", "dressInfo", "activityId$delegate", "getActivityId", "activityId", "joinFrozenDuration$delegate", "getJoinFrozenDuration", "joinFrozenDuration", "bizExtra$delegate", "getBizExtra", "bizExtra", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ILuckyBoxResponseDataFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("activity_id")
    protected String _$$activityId;

    @SerializedName("biz_extra")
    protected String _$$bizExtra;

    @SerializedName("bottom_cover_image")
    protected py.k _$$bottomCoverImage;

    @SerializedName("box_id")
    protected long _$$boxId;

    @SerializedName("box_id_str")
    protected String _$$boxIdStr;

    @SerializedName("box_status")
    protected int _$$boxStatus;

    @SerializedName("box_type")
    protected int _$$boxType;

    @SerializedName("business_type")
    protected long _$$businessType;

    @SerializedName("delay_time")
    protected long _$$delayTime;

    @SerializedName("description_list")
    protected List<? extends c> _$$descriptionList;

    @SerializedName("diamond_count")
    protected long _$$diamondCount;

    @SerializedName("display_duration")
    protected long _$$displayDuration;

    @SerializedName("dress_info")
    protected b.InterfaceC0048b _$$dressInfo;

    @SerializedName("flat_duration")
    protected int _$$flatDuration;

    @SerializedName("is_official")
    protected boolean _$$isOfficial;

    @SerializedName("is_risky_owner")
    protected boolean _$$isRiskyOwner;

    @SerializedName("join_frozen_duration")
    protected long _$$joinFrozenDuration;

    @SerializedName("large")
    protected boolean _$$large;

    @SerializedName("priority")
    protected int _$$priority;

    @SerializedName("rush_condition")
    protected int _$$rushCondition;

    @SerializedName("send_time")
    protected long _$$sendTime;

    @SerializedName("style")
    protected long _$$style;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("top_cover_image")
    protected py.k _$$topCoverImage;

    @SerializedName("unpack_type")
    protected int _$$unpackType;

    @SerializedName("user")
    protected IBaseUser _$$user;

    @SerializedName("background")
    protected py.k background;

    public ILuckyBoxResponseDataFlexImpl() {
        super(b.class);
        this._$$boxIdStr = "";
        this._$$title = "";
        this._$$isOfficial = false;
        this._$$large = false;
        this._$$descriptionList = $defaultValue_descriptionList$();
        this._$$isRiskyOwner = false;
        this._$$activityId = "";
        this._$$bizExtra = "";
    }

    public final List<c> $defaultValue_descriptionList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final String getActivityId() {
        return this._$$activityId;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public py.k getBackground() {
        return this.background;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final String getBizExtra() {
        return this._$$bizExtra;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final py.k getBottomCoverImage() {
        return this._$$bottomCoverImage;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getBoxId() {
        return this._$$boxId;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final String getBoxIdStr() {
        return this._$$boxIdStr;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final int getBoxStatus() {
        return this._$$boxStatus;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final int getBoxType() {
        return this._$$boxType;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getBusinessType() {
        return this._$$businessType;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getDelayTime() {
        return this._$$delayTime;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final List<c> getDescriptionList() {
        return this._$$descriptionList;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getDisplayDuration() {
        return this._$$displayDuration;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final b.InterfaceC0048b getDressInfo() {
        return this._$$dressInfo;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final int getFlatDuration() {
        return this._$$flatDuration;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getJoinFrozenDuration() {
        return this._$$joinFrozenDuration;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final boolean getLarge() {
        return this._$$large;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final int getPriority() {
        return this._$$priority;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final int getRushCondition() {
        return this._$$rushCondition;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getSendTime() {
        return this._$$sendTime;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final long getStyle() {
        return this._$$style;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final py.k getTopCoverImage() {
        return this._$$topCoverImage;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final int getUnpackType() {
        return this._$$unpackType;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final IBaseUser getUser() {
        return this._$$user;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final boolean isOfficial() {
        return this._$$isOfficial;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final boolean isRiskyOwner() {
        return this._$$isRiskyOwner;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v23, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v25, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v28, types: [com.bytedance.android.live.profit.redpacket.model.b$b, java.lang.Object] */
    public ILuckyBoxResponseDataFlexImpl(am3.g r8) {
        super(b.class);
        this._$$descriptionList = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L35;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        switch(r4) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L7;
            case 19: goto L17;
            case 20: goto L16;
            case 21: goto L15;
            case 22: goto L14;
            case 23: goto L13;
            case 24: goto L12;
            case 25: goto L7;
            case 26: goto L7;
            case 27: goto L7;
            case 28: goto L7;
            case 29: goto L7;
            case 30: goto L11;
            case 31: goto L10;
            case 32: goto L9;
            case 33: goto L8;
            default: goto L7;
        };
    L8:
        this._$$bizExtra = am3.h.c(r8);
        goto L3
    L9:
        this._$$joinFrozenDuration = r8.j();
        r3 = r3 | 65536;
        goto L3
    L10:
        this._$$boxIdStr = am3.h.c(r8);
        goto L3
    L11:
        this._$$activityId = am3.h.c(r8);
        goto L3
    L12:
        this._$$dressInfo = vh7.f.a(r8, b.InterfaceC0048b.class);
        goto L3
    L13:
        this._$$isRiskyOwner = am3.h.a(r8);
        r3 = r3 | 32768;
        goto L3
    L14:
        this._$$bottomCoverImage = vh7.f.a(r8, py.k.class);
        goto L3
    L15:
        this._$$topCoverImage = vh7.f.a(r8, py.k.class);
        goto L3
    L16:
        this._$$businessType = r8.j();
        r3 = r3 | 16384;
        goto L3
    L17:
        this._$$rushCondition = r8.i();
        r3 = r3 | 8192;
        goto L3
    L18:
        this._$$unpackType = r8.i();
        r3 = r3 | 4096;
        goto L3
    L19:
        this._$$flatDuration = r8.i();
        r3 = r3 | 2048;
        goto L3
    L20:
        this._$$boxStatus = r8.i();
        r3 = r3 | 1024;
        goto L3
    L21:
        this._$$displayDuration = r8.j();
        r3 = r3 | 512;
        goto L3
    L22:
        this._$$descriptionList.add(vh7.f.a(r8, c.class));
        goto L3
    L23:
        this._$$large = am3.h.a(r8);
        r3 = r3 | DefaultConfig.MAX_CACHE_ENTRIES;
        goto L3
    L24:
        this._$$priority = r8.i();
        r3 = r3 | 128;
        goto L3
    L25:
        this._$$isOfficial = am3.h.a(r8);
        r3 = r3 | 64;
        goto L3
    L26:
        this.background = vh7.f.a(r8, py.k.class);
        goto L3
    L27:
        this._$$style = r8.j();
        r3 = r3 | 32;
        goto L3
    L28:
        this._$$diamondCount = r8.j();
        r3 = r3 | 16;
        goto L3
    L29:
        this._$$title = am3.h.c(r8);
        goto L3
    L30:
        this._$$boxType = r8.i();
        r3 = r3 | 8;
        goto L3
    L31:
        this._$$delayTime = r8.j();
        r3 = r3 | 4;
        goto L3
    L32:
        this._$$sendTime = r8.j();
        r3 = r3 | 2;
        goto L3
    L33:
        this._$$boxId = r8.j();
        r3 = r3 | 1;
        goto L3
    L34:
        this._$$user = vh7.f.a(r8, IBaseUser.class);
        goto L3
    L7:
        am3.h.d(r5, r8);
        goto L3
    L35:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$boxIdStr != null) goto L39;
        this._$$boxIdStr = "";
    L39:
        if (this._$$title != null) goto L42;
        this._$$title = "";
    L42:
        if ((r3 & 64) != 0) goto L45;
        this._$$isOfficial = false;
    L45:
        if ((r3 & DefaultConfig.MAX_CACHE_ENTRIES) != 0) goto L48;
        this._$$large = false;
    L48:
        if (this._$$descriptionList.isEmpty() == false) goto L51;
        this._$$descriptionList = $defaultValue_descriptionList$();
    L51:
        if ((r3 & 32768) != 0) goto L54;
        this._$$isRiskyOwner = false;
    L54:
        if (this._$$activityId != null) goto L57;
        this._$$activityId = "";
    L57:
        if (this._$$bizExtra != null) goto L118;
        this._$$bizExtra = "";
        return;
    }

    public void setBackground(py.k r1) {
        this.background = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setBottomCoverImage(py.k r1) {
        this._$$bottomCoverImage = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setBoxType(int r1) {
        this._$$boxType = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setDelayTime(long r1) {
        this._$$delayTime = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setDescriptionList(List<? extends c> r1) {
        this._$$descriptionList = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setDiamondCount(long r1) {
        this._$$diamondCount = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setDisplayDuration(long r1) {
        this._$$displayDuration = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setDressInfo(b.InterfaceC0048b r1) {
        this._$$dressInfo = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setRiskyOwner(boolean r1) {
        this._$$isRiskyOwner = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setSendTime(long r1) {
        this._$$sendTime = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setTopCoverImage(py.k r1) {
        this._$$topCoverImage = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b
    public final void setUser(IBaseUser r1) {
        this._$$user = r1;
    }
}
