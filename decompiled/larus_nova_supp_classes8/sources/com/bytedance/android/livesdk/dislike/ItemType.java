package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.bytedance.android.live.base.model.longpresspanel.LiveLongPressItemType;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\t\u0010\r\u001a\u00020\fH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u000b\u0010&R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bE¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/ItemType;", "", "Lcom/bytedance/android/livesdk/dislike/k;", "", "", "isFeed", "", "getPriority", "(Z)Ljava/lang/Integer;", "", "getIdentity", "getItemType", "Lq61/b;", "entrance", "Lq61/b$a;", "entranceBuilder", "Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "identity", "Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "()Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "type", "I", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "priority", "hasLandingPage", "Z", "getHasLandingPage", "()Z", "imgRes", "Ljava/lang/Integer;", "getImgRes", "()Ljava/lang/Integer;", "Lcom/bytedance/android/live/base/model/longpresspanel/LiveLongPressItemType;", "itemType", "Lcom/bytedance/android/live/base/model/longpresspanel/LiveLongPressItemType;", "()Lcom/bytedance/android/live/base/model/longpresspanel/LiveLongPressItemType;", "clearColorFilter", "getClearColorFilter", "setClearColorFilter", "(Z)V", "BLANK_SPACE", "MORE_FRIENDS", "CLEAR_SCREEN", "SHARE", "SHARE_FANS", "DISLIKE", "IM_MESSAGE", "IMAGE_RECOGNITION", "SHARE_LIVE_TO_DAILY", "LIVE_NOTIFICATION", "OPT_RECOMMEND", "DISLIKE_CURRENT_LIVE", "DISLIKE_CONTENT", "DISLIKE_ANCHOR", "DISLIKE_TYPE", "REPORT", "RECOMMEND_TO_FRIENDS", "WATCH_LATER", "FOLLOW", "UNFOLLOW", "FLOAT_WINDOW", "ADD_TO_DESKTOP", "FEED_LIVE_SHARE", "SCREEN_RECORD", "AUDIO_FEEDBACK", "PK_FEEDBACK", "DOU_PLUS", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemType extends Enum<ItemType> implements k {
    public static final ItemType ADD_TO_DESKTOP = null;
    public static final ItemType AUDIO_FEEDBACK = null;
    public static final ItemType BLANK_SPACE = null;
    public static final ItemType CLEAR_SCREEN = null;
    public static final ItemType DISLIKE = null;
    public static final ItemType DISLIKE_ANCHOR = null;
    public static final ItemType DISLIKE_CONTENT = null;
    public static final ItemType DISLIKE_CURRENT_LIVE = null;
    public static final ItemType DISLIKE_TYPE = null;
    public static final ItemType DOU_PLUS = null;
    public static final ItemType FEED_LIVE_SHARE = null;
    public static final ItemType FLOAT_WINDOW = null;
    public static final ItemType FOLLOW = null;
    public static final ItemType IMAGE_RECOGNITION = null;
    public static final ItemType IM_MESSAGE = null;
    public static final ItemType LIVE_NOTIFICATION = null;
    public static final ItemType MORE_FRIENDS = null;
    public static final ItemType OPT_RECOMMEND = null;
    public static final ItemType PK_FEEDBACK = null;
    public static final ItemType RECOMMEND_TO_FRIENDS = null;
    public static final ItemType REPORT = null;
    public static final ItemType SCREEN_RECORD = null;
    public static final ItemType SHARE = null;
    public static final ItemType SHARE_FANS = null;
    public static final ItemType SHARE_LIVE_TO_DAILY = null;
    public static final ItemType UNFOLLOW = null;
    public static final ItemType WATCH_LATER = null;
    public static final /* synthetic */ ItemType[] a = null;
    private boolean clearColorFilter;
    private final String desc;
    private final boolean hasLandingPage;
    private final ItemIdentity identity;
    private final Integer imgRes;
    private final LiveLongPressItemType itemType;
    private final int priority;
    private final int type;

    public ItemType() {
        throw null;
    }

    public static ItemType valueOf(String r1) {
        return (ItemType) r27.a.a(ItemType.class, r1);
    }

    public static ItemType[] values() {
        return (ItemType[]) a.clone();
    }

    public q61.b entrance() {
        return this.identity.entrance();
    }

    public q61.b.a entranceBuilder() {
        return this.identity.entranceBuilder();
    }

    static {
        ItemType[] r0 = new ItemType[27];
        ItemType r14 = new ItemType("BLANK_SPACE", 0, ItemIdentity.BLANK, 0, "占位", 0, false, null, null, false, 224, null);
        BLANK_SPACE = r14;
        r0[0] = r14;
        ItemType r1 = new ItemType("MORE_FRIENDS", 1, ItemIdentity.MORE_FRIENDS, 1, "更多朋友", 0, false, null, null, false, 224, null);
        MORE_FRIENDS = r1;
        r0[1] = r1;
        ItemType r2 = new ItemType("CLEAR_SCREEN", 2, ItemIdentity.CLEAR_SCREEN, 1, "清屏", 0, false, null, null, false, 224, null);
        CLEAR_SCREEN = r2;
        r0[2] = r2;
        ItemType r3 = new ItemType("SHARE", 3, ItemIdentity.SHARE, 1, "分享", 0, false, null, null, false, 224, null);
        SHARE = r3;
        r0[3] = r3;
        ItemType r4 = new ItemType("SHARE_FANS", 4, ItemIdentity.SHARE_FANS, 1, "分享到粉丝", 0, false, null, null, false, 224, null);
        SHARE_FANS = r4;
        r0[4] = r4;
        ItemType r5 = new ItemType("DISLIKE", 5, ItemIdentity.DISLIKE, 1, "不感兴趣", 0, false, null, null, false, 224, null);
        DISLIKE = r5;
        r0[5] = r5;
        ItemType r6 = new ItemType("IM_MESSAGE", 6, ItemIdentity.IM_MESSAGE, 1, "私信站内好友", 0, false, null, null, false, 224, null);
        IM_MESSAGE = r6;
        r0[6] = r6;
        ItemType r7 = new ItemType("IMAGE_RECOGNITION", 7, ItemIdentity.IMAGE_RECOGNITION, 1, "识图", 0, false, null, null, false, 224, null);
        IMAGE_RECOGNITION = r7;
        r0[7] = r7;
        ItemIdentity r8 = ItemIdentity.SHARE_LIVE_TO_DAILY;
        IMiddlewareHostApp r9 = jc1.k.f(IMiddlewareHostApp.class);
        if (r9 == null) goto L6;
        String r10 = r9.replaceBrand("转发到{social_brand}");
        if (r10 == null) goto L6;
    L7:
        ItemType r11 = new ItemType("SHARE_LIVE_TO_DAILY", 8, r8, 1, r10, 0, false, null, null, false, 224, null);
        SHARE_LIVE_TO_DAILY = r11;
        r0[8] = r11;
        ItemType r12 = new ItemType("LIVE_NOTIFICATION", 9, ItemIdentity.LIVE_NOTIFICATION, 2, "开播提醒", 2000, false, 2131252519, null, false, 192, null);
        LIVE_NOTIFICATION = r12;
        r0[9] = r12;
        ItemType r13 = new ItemType("OPT_RECOMMEND", 10, ItemIdentity.OPT_RECOMMEND, 2, "优化推荐", 1900, true, 2131252556, null, false, 192, null);
        OPT_RECOMMEND = r13;
        r0[10] = r13;
        ItemType r15 = new ItemType("DISLIKE_CURRENT_LIVE", 11, ItemIdentity.DISLIKE_CURRENT_LIVE, 2, "不感兴趣当前直播", 1700, false, 2131250345, null, false, 192, null);
        DISLIKE_CURRENT_LIVE = r15;
        r0[11] = r15;
        ItemType r16 = new ItemType("DISLIKE_CONTENT", 12, ItemIdentity.DISLIKE_CONTENT, 2, "减少此类型直播", 1700, false, 2131250347, null, false, 192, null);
        DISLIKE_CONTENT = r16;
        r0[12] = r16;
        ItemType r17 = new ItemType("DISLIKE_ANCHOR", 13, ItemIdentity.DISLIKE_ANCHOR, 2, "不看该主播", 1600, false, 2131250343, null, false, 192, null);
        DISLIKE_ANCHOR = r17;
        r0[13] = r17;
        ItemType r18 = new ItemType("DISLIKE_TYPE", 14, ItemIdentity.DISLIKE_TYPE, 2, "减少直播推荐", 1500, false, 2131250346, null, false, 192, null);
        DISLIKE_TYPE = r18;
        r0[14] = r18;
        ItemType r19 = new ItemType("REPORT", 15, ItemIdentity.REPORT, 2, "举报", 1400, false, 2131252842, null, false, 192, null);
        REPORT = r19;
        r0[15] = r19;
        ItemType r20 = new ItemType("RECOMMEND_TO_FRIENDS", 16, ItemIdentity.RECOMMEND_TO_FRIENDS, 1, "推荐给朋友", 9999, true, 2131252739, null, true, 64, null);
        RECOMMEND_TO_FRIENDS = r20;
        r0[16] = r20;
        ItemType r21 = new ItemType("WATCH_LATER", 17, ItemIdentity.WATCH_LATER, 2, "稍后再看", 1900, false, 2131251666, null, false, 192, null);
        WATCH_LATER = r21;
        r0[17] = r21;
        ItemType r22 = new ItemType("FOLLOW", 18, ItemIdentity.FOLLOW, 2, "关注", 1800, false, 2131250630, null, false, 192, null);
        FOLLOW = r22;
        r0[18] = r22;
        ItemType r23 = new ItemType("UNFOLLOW", 19, ItemIdentity.UNFOLLOW, 2, "取消关注", 1300, false, 2131253172, null, false, 192, null);
        UNFOLLOW = r23;
        r0[19] = r23;
        ItemType r24 = new ItemType("FLOAT_WINDOW", 20, ItemIdentity.FLOAT_WINDOW, 2, "小窗播放", 1200, false, 2131250618, null, false, 192, null);
        FLOAT_WINDOW = r24;
        r0[20] = r24;
        ItemType r25 = new ItemType("ADD_TO_DESKTOP", 21, ItemIdentity.ADD_TO_DESKTOP, 2, "添加到桌面", 1100, false, 2131248574, null, false, 192, null);
        ADD_TO_DESKTOP = r25;
        r0[21] = r25;
        ItemType r26 = new ItemType("FEED_LIVE_SHARE", 22, ItemIdentity.FEED_LIVE_SHARE, 2, "一起看", BubbleId.PadCast, true, 2131252239, null, false, 192, null);
        FEED_LIVE_SHARE = r26;
        r0[22] = r26;
        ItemType r27 = new ItemType("SCREEN_RECORD", 23, ItemIdentity.SCREEN_RECORD, 2, "开始录屏", 900, false, 2131252915, null, false, 192, null);
        SCREEN_RECORD = r27;
        r0[23] = r27;
        ItemType r28 = new ItemType("AUDIO_FEEDBACK", 24, ItemIdentity.AUDIO_FEEDBACK, 2, "音视频反馈", 800, false, 2131248679, null, false, 192, null);
        AUDIO_FEEDBACK = r28;
        r0[24] = r28;
        ItemType r29 = new ItemType("PK_FEEDBACK", 25, ItemIdentity.PK_FEEDBACK, 2, "pk反馈", 700, false, 2131252589, null, false, 192, null);
        PK_FEEDBACK = r29;
        r0[25] = r29;
        ItemType r30 = new ItemType("DOU_PLUS", 26, ItemIdentity.DOU_PLUS, 2, "上热门", 700, false, 2131252494, null, false, 192, null);
        DOU_PLUS = r30;
        r0[26] = r30;
        a = r0;
        return;
    L6:
        r10 = "转发到日常";
        goto L7
    }

    public final boolean getClearColorFilter() {
        return this.clearColorFilter;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getHasLandingPage() {
        return this.hasLandingPage;
    }

    public final ItemIdentity getIdentity() {
        return this.identity;
    }

    public final Integer getImgRes() {
        return this.imgRes;
    }

    public final LiveLongPressItemType getItemType() {
        return this.itemType;
    }

    public String getIdentity(boolean r2) {
        String r3 = o.a(this.identity, r2).getIdentity();
        if (r3 != null) goto L9;
        String r4 = this.identity.name();
        Locale r0 = Locale.ROOT;
        if (r4 == null) goto L8;
        return r4.toLowerCase(r0);
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        return r3;
    }

    @Override // com.bytedance.android.livesdk.dislike.k
    public Integer getItemType(boolean r2) {
        Integer r3 = o.a(this.identity, r2).getType();
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return Integer.valueOf(r4);
    L5:
        r4 = this.type;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.dislike.k
    public Integer getPriority(boolean r2) {
        Integer r3 = o.a(this.identity, r2).getPriority();
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return Integer.valueOf(r4);
    L5:
        r4 = this.priority;
        goto L7
    }

    public final void setClearColorFilter(boolean r1) {
        this.clearColorFilter = r1;
    }

    public ItemType(String r1, int r2, ItemIdentity r3, int r4, String r5, int r6, boolean r7, Integer r8, LiveLongPressItemType r9, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 32) == 0) goto L6;
        r8 = null;
    L6:
        if ((r11 & 64) == 0) goto L9;
        r9 = LiveLongPressItemType.NORMAL;
    L9:
        if ((r11 & 128) == 0) goto L11;
        r10 = false;
    L11:
        super(r1, r2);
        this.identity = r3;
        this.type = r4;
        this.desc = r5;
        this.priority = r6;
        this.hasLandingPage = r7;
        this.imgRes = r8;
        this.itemType = r9;
        this.clearColorFilter = r10;
    }
}
