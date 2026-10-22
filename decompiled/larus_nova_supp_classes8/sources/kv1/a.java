package kv1;

import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ies.utility.SharedPrefHelper;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static volatile a a;

    public a() {
        SharedPrefHelper.c(k.f(IHostContext.class).context(), "live_fans_comment_guide");
    }
}
