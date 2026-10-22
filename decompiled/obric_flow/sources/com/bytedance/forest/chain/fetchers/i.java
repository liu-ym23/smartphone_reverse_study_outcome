package com.bytedance.forest.chain.fetchers;

import android.text.TextUtils;
import com.lynx.tasm.ui.image.f0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f4298a = null;

    static {
        f4298a = new i();
    }

    @Override // ya.a
    public final void b(String r5, JSONObject r10) {
        if (TextUtils.isEmpty(r5) == true) goto L7;
        if (r10 == null) goto L8;
        f0.h(GeckoXAdapter.TAG, 60, "event:" + r5 + ",data:" + r10, false);
        return;
    L8:
        return;
    }
}
