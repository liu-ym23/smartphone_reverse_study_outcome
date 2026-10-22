package com.bytedance.android.live.profit.vip.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u0004\u0018\u00010#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b$\u0010%R\u001c\u0010,\u001a\u0004\u0018\u00010(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/g;", "Lvh7/c;", "", "getEmojiStatus", "()J", "getEmojiStatus$annotations", "()V", "emojiStatus", "", "Lcom/bytedance/android/live/profit/vip/model/a;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getEmojiList", "()Ljava/util/List;", "getEmojiList$annotations", "emojiList", "Lcom/bytedance/android/live/profit/vip/model/d;", "getEmojiTabInfo", "()Lcom/bytedance/android/live/profit/vip/model/d;", "getEmojiTabInfo$annotations", "emojiTabInfo", "", "isMember", "()Z", "isMember$annotations", "getEntrance", "getEntrance$annotations", "entrance", "getEntranceTab", "getEntranceTab$annotations", "entranceTab", "", "getMemberType", "()I", "getMemberType$annotations", "memberType", "Lcom/bytedance/android/live/profit/vip/d;", "getUserData", "()Lcom/bytedance/android/live/profit/vip/d;", "getUserData$annotations", "userData", "Lcom/bytedance/android/live/profit/vip/model/h;", "getAnchorData", "()Lcom/bytedance/android/live/profit/vip/model/h;", "getAnchorData$annotations", "anchorData", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g extends vh7.c<g> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "anchor_data")
    h getAnchorData();

    @FieldName(name = "emoji_list")
    List<com.bytedance.android.live.profit.vip.model.a> getEmojiList();

    @FieldName(name = "emoji_status")
    long getEmojiStatus();

    @FieldName(name = "emoji_tab_info")
    d getEmojiTabInfo();

    @FieldName(name = "entrance")
    boolean getEntrance();

    @FieldName(name = "entrance_tab")
    boolean getEntranceTab();

    @FieldName(name = "member_type")
    int getMemberType();

    @FieldName(name = "user_data")
    com.bytedance.android.live.profit.vip.d getUserData();

    @FieldName(name = "is_member")
    boolean isMember();
}
