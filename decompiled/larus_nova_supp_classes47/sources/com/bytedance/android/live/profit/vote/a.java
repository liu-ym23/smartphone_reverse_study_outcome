package com.bytedance.android.live.profit.vote;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0018\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\nR\u001a\u0010\u001e\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\nR\u001a\u0010!\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/profit/vote/a;", "Lvh7/c;", "", "getText", "()Ljava/lang/String;", "getText$annotations", "()V", "text", "", "getCount", "()J", "getCount$annotations", "count", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "getGiftId", "getGiftId$annotations", "giftId", "getGiftName", "getGiftName$annotations", "giftName", "getDiamondCount", "getDiamondCount$annotations", "diamondCount", "getGiftType", "getGiftType$annotations", "giftType", "getCountStr", "getCountStr$annotations", "countStr", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0054a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "count")
    long getCount();

    @FieldName(name = "count_str")
    String getCountStr();

    @FieldName(name = "diamond_count")
    long getDiamondCount();

    @FieldName(name = "gift_id")
    long getGiftId();

    @FieldName(name = "name")
    String getGiftName();

    @FieldName(name = "gift_type")
    long getGiftType();

    @FieldName(name = "icon")
    py.k getIcon();

    @FieldName(name = "text")
    String getText();
}
