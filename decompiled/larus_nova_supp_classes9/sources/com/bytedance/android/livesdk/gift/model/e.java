package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/e;", "Lvh7/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/d0;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAudienceReceiverList", "()Ljava/util/List;", "setAudienceReceiverList", "(Ljava/util/List;)V", "getAudienceReceiverList$annotations", "()V", "audienceReceiverList", "Companion", "a", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.c<e> {
    public static final a Companion = null;
    public static final String FETCH_FROM_GIFT_PANEL = "gift_panel";
    public static final String FETCH_FROM_SETTING = "setting";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "audience_receiver_list")
    List<d0> getAudienceReceiverList();

    @FieldName(name = "audience_receiver_list#setter")
    void setAudienceReceiverList(List<? extends d0> r1);
}
