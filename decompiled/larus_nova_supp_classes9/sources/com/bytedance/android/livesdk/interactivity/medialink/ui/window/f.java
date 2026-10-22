package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ String a;

    public f(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((String) r2, "it");
        String r3 = this.a;
        if (r3 == null) goto L6;
        LiveSeiUtil.i.getClass();
        return LiveSeiUtil.c(r3);
    L6:
        return new JSONObject(this.a);
    }
}
