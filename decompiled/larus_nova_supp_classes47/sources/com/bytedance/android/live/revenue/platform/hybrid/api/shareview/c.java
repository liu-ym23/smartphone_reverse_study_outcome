package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import android.content.Context;
import com.lynx.tasm.LynxView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {
    void a(String r1, Map<String, ? extends Object> r2);

    void b();

    Context getContext();

    LynxView getLynxView();

    boolean isValid();

    void release();
}
