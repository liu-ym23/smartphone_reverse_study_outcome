package com.ss.android.lark.profile_office.userprofile;

import android.content.Context;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final Context a;
    public final int b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = UIHelper.dp2px(640.0f);
        this.c = UIHelper.dp2px(160.0f);
    }
}
