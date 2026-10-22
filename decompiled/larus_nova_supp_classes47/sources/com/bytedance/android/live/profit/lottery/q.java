package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\n\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\"\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b \u0010\u0004R\u001a\u0010#\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b#\u0010\u0004¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/q;", "Lvh7/c;", "", "isWatching", "()Z", "isWatching$annotations", "()V", "getHasCommand", "getHasCommand$annotations", "hasCommand", "getHasFollow", "getHasFollow$annotations", "hasFollow", "isFansclubMember", "isFansclubMember$annotations", "getHasGift", "getHasGift$annotations", "hasGift", "", "getFansLevel", "()J", "getFansLevel$annotations", "fansLevel", "getFansclubStatusActive", "getFansclubStatusActive$annotations", "fansclubStatusActive", "getHasShared", "getHasShared$annotations", "hasShared", "getHasHelpWish", "getHasHelpWish$annotations", "hasHelpWish", "getHasActivated", "getHasActivated$annotations", "hasActivated", "isSubscribeMember", "isSubscribeMember$annotations", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q extends vh7.c<q> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "fans_level")
    long getFansLevel();

    @FieldName(name = "fansclub_status_active")
    boolean getFansclubStatusActive();

    @FieldName(name = "has_activated")
    boolean getHasActivated();

    @FieldName(name = "has_command")
    boolean getHasCommand();

    @FieldName(name = "has_follow")
    boolean getHasFollow();

    @FieldName(name = "has_gift")
    boolean getHasGift();

    @FieldName(name = "has_help_wish")
    boolean getHasHelpWish();

    @FieldName(name = "has_shared")
    boolean getHasShared();

    @FieldName(name = "is_fansclub_member")
    boolean isFansclubMember();

    @FieldName(name = "is_subscribe_member")
    boolean isSubscribeMember();

    @FieldName(name = "is_watching")
    boolean isWatching();
}
