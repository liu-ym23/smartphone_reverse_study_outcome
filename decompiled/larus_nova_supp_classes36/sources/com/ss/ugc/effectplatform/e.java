package com.ss.ugc.effectplatform;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import clc.a;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ResourceListModel;
import com.ss.ugc.effectplatform.util.p;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements IEffectPlatformBaseListener<Float> {
    public final /* synthetic */ ResourceListModel.ResourceListBean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;
    public final /* synthetic */ EffectPlatform$j e;

    public final void onSuccess(Object r8) {
        ((Number) r8).floatValue();
        String r9 = p.a(this.c) + this.a.getResource_uri();
        String r0 = this.b;
        a r1 = (a) this.e.a.getEffectConfig().w.a;     // Catch: Exception -> L12
        if (r1 == null) goto L7;
        r1.a();     // Catch: Exception -> L12
    L10:
        String r2 = FileManager.a;     // Catch: Exception -> L12
        FileManager.o(this.b);     // Catch: Exception -> L12
    L14:
        IEffectPlatformBaseListener r3 = this.e.c;
        if (r3 == null) goto L20;
        r3.onSuccess(new com.ss.ugc.effectplatform.model.g(this.a, r9));
        return;
    L20:
        return;
    L7:
        if (this.e.a.getEffectConfig().p == false) goto L9;
        String r4 = FileManager.a;     // Catch: Exception -> L12
        FileManager.r(this.b, r9);     // Catch: Exception -> L12
        goto L10
    L9:
        String r5 = FileManager.a;     // Catch: Exception -> L12
        FileManager.q(this.b, r9);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "effect_platform", "resourceRepository unzip failed: " + e, null, 4, null);
        r9 = r0;
        goto L14
    }

    public final void onFail(Object r4, ExceptionResult r5) {
        Float r6 = (Float) r4;
        IEffectPlatformBaseListener r7 = this.e.c;
        if (r7 == null) goto L6;
        r7.onFail(new com.ss.ugc.effectplatform.model.g(this.a, ""), r5);
        return;
    }

    public e(ResourceListModel.ResourceListBean r1, String r2, String r3, List r4, EffectPlatform$j r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
