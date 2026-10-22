package yyb;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class a implements b {
    @Inject
    public a() {
    }

    @Override // yyb.b
    public final void a(Activity r1, String r2, JSONObject r3, IGetDataCallback r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.onSuccess(null);
    }
}
