package com.bytedance.android.live.lynx.api;

import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c extends ka0.c {
    LynxView getLynxView();

    @Deprecated(message = "use render instead")
    void renderTemplate(String r1, Map<String, ? extends Object> r2);

    void updateData(Map<String, ? extends Object> r1);

    void updateData(Map<String, ? extends Object> r1, boolean r2, String r3);
}
