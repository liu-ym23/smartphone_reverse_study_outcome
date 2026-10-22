package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.DialogInterface;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$Click;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$TextType;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupHitPointNew;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import s5c.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ CreateGroupScene a;

    public e(CreateGroupScene r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        CreateGroupExtraParams$Click r5 = CreateGroupExtraParams$Click.CONFIRM;
        h r6 = h.a;
        CreateGroupExtraParams$TextType r0 = a.b(this.a);
        int r1 = CreateGroupHitPointNew.a;
        s5c.d r7 = r5.plus(r6).plus(r0);
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        Statistics.sendEvent("im_chat_member_toplimit_click", s5c.b.a(ChatParamUtils.e(), r7).toJson());
    }
}
