package com.bytedance.android.live.lynx;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {
    void a(LynxViewBuilder r1, String r2);

    void b(boolean r1);

    List<com.lynx.tasm.behavior.a> c();

    void d(TemplateData r1);

    LynxGroup e(String r1, String[] r2, boolean r3, boolean r4, boolean r5, int r6);

    boolean isEnableDebug();

    void setEnableJSRuntime(LynxViewBuilder r1, boolean r2);
}
