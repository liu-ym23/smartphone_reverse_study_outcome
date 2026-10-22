package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/user/x;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/y;", "getProfile", "()Lcom/bytedance/android/live/base/model/user/y;", "setProfile", "(Lcom/bytedance/android/live/base/model/user/y;)V", "getProfile$annotations", "()V", "profile", "Lcom/bytedance/android/live/base/model/user/z;", "getRoom", "()Lcom/bytedance/android/live/base/model/user/z;", "setRoom", "(Lcom/bytedance/android/live/base/model/user/z;)V", "getRoom$annotations", NewBroadcastMonitor.PAGE.ROOM, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface x extends vh7.c<x> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "profile")
    y getProfile();

    @FieldName(name = NewBroadcastMonitor.PAGE.ROOM)
    z getRoom();

    @FieldName(name = "profile#setter")
    void setProfile(y r1);

    @FieldName(name = "room#setter")
    void setRoom(z r1);
}
