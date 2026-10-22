package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\"\u0010\u000b\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/u;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "", "getSearchType", "()I", "setSearchType", "(I)V", "getSearchType$annotations", "()V", "searchType", "Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "getWaitingInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "setWaitingInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/n0;)V", "getWaitingInfo$annotations", "waitingInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getInviteInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "setInviteInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;)V", "getInviteInfo$annotations", "inviteInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u extends vh7.c<u> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "invite_user")
    ILinkPlayerInfoBridge getInviteInfo();

    @FieldName(name = "search_type")
    int getSearchType();

    IBaseUser getUser();

    @FieldName(name = "waiting_user")
    n0 getWaitingInfo();

    @FieldName(name = "invite_user#setter")
    void setInviteInfo(ILinkPlayerInfoBridge r1);

    @FieldName(name = "search_type#setter")
    void setSearchType(int r1);

    @FieldName(name = "waiting_user#setter")
    void setWaitingInfo(n0 r1);
}
