package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/t1;", "Lvh7/c;", "", "getToUserId", "()J", "toUserId", "getInviteTimeoutDurationInSecond", "inviteTimeoutDurationInSecond", "getInviterId", "inviterId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t1 extends vh7.c<t1> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "invite_timeout_duration_s")
    long getInviteTimeoutDurationInSecond();

    @FieldName(name = "inviter_id")
    long getInviterId();

    @FieldName(name = "to_user_id")
    long getToUserId();
}
