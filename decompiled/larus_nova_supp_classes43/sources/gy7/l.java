package gy7;

import com.lark.kmp.basic.ActionContext;
import com.lark.kmp.basic.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l extends b {
    public l(p r10, ActionContext r11) {
        Intrinsics.checkNotNullParameter(r10, "userPayload");
        Intrinsics.checkNotNullParameter(r11, "actionContext");
        super(new u(UserState.ONLINE, r11), r10);
    }
}
