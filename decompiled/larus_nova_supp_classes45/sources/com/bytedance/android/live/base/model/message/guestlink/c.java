package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R>\u0010\u0013\u001a\u001e\u0012\b\u0012\u00060\u000bj\u0002`\f\u0018\u00010\nj\u000e\u0012\b\u0012\u00060\u000bj\u0002`\f\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/c;", "Lvh7/c;", "", "getBannerType", "()I", "setBannerType", "(I)V", "getBannerType$annotations", "()V", "bannerType", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getChannelUsers", "()Ljava/util/List;", "setChannelUsers", "(Ljava/util/List;)V", "getChannelUsers$annotations", "channelUsers", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "banner_type")
    int getBannerType();

    @FieldName(name = "channel_users")
    List<IBaseUser> getChannelUsers();

    @FieldName(name = "banner_type#setter")
    void setBannerType(int r1);

    @FieldName(name = "channel_users#setter")
    void setChannelUsers(List<? extends IBaseUser> r1);
}
