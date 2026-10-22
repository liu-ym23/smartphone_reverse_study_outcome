package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface c extends vh7.c<c> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "app_id")
    long getAppId();

    @FieldName(name = "client_version")
    long getClientVersion();

    @FieldName(name = "current_time")
    long getCurrentTime();

    @FieldName(name = "device_platform")
    String getDevicePlatform();

    @FieldName(name = "expected_leave_time")
    long getExpectLeaveTime();

    @FieldName(name = "fan_ticket")
    long getFanTicket();

    @FieldName(name = "fan_ticket_fuzzy_str")
    String getFanTicketFuzzyStr();

    @FieldName(name = "fan_ticket_real_str")
    String getFanTicketRealStr();

    @FieldName(name = "join_channel_time")
    long getJoinChannelTime();

    @FieldName(name = "list_user_role")
    int getListUserRole();

    @FieldName(name = "host_permission")
    boolean isHost();
}
