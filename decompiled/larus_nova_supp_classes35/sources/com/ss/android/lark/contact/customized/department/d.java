package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.ExtendParam;
import com.bytedance.lark.pb.contact.v1.GetDepartmentCombineChatRequest;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, int r4, DepartmentStructureViewModel$fetchCurrent$resp$1$1$1 r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        ExtendParam.Builder r0 = new ExtendParam.Builder().in_chat_id(null);
        Intrinsics.checkNotNull(r0);
        Boolean r1 = Boolean.TRUE;
        r0.has_lead_perm(r1);
        r0.select_enterprise_email(Boolean.FALSE);
        r0.need_user_profile_fields(r1);
        GetDepartmentCombineChatRequest.Builder r6 = new GetDepartmentCombineChatRequest.Builder().department_id(r3).count(100).offset(Integer.valueOf(r4)).need_path(r1).sub_department_paging(r1).use_display_order(r1).extend_param(r0.build());
        SdkSender.asynSendRequestNonWrap(Command.GET_DEPARTMENT_COMBINE_CHAT, r6, r5, c.a);
    }
}
