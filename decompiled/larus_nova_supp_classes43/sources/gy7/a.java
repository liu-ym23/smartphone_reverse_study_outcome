package gy7;

import com.lark.kmp.basic.ActionContext;
import com.lark.kmp.basic.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends b {
    public a(ActionContext r10) {
        Intrinsics.checkNotNullParameter(r10, "actionContext");
        super(new u(UserState.OFFLINE, r10), null);
    }
}
