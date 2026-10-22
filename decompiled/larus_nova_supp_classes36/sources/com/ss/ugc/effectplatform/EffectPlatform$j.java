package com.ss.ugc.effectplatform;

import bytekn.foundation.io.file.FileManager;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ResourceListModel;
import com.ss.ugc.effectplatform.model.i;
import com.ss.ugc.effectplatform.repository.k;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.task.x;
import com.ss.ugc.effectplatform.util.p;
import com.ss.ugc.effectplatform.util.q;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EffectPlatform$j implements IEffectPlatformBaseListener<ResourceListModel> {
    public final /* synthetic */ EffectPlatform a;
    public final /* synthetic */ IEffectPlatformBaseListener b;
    public final /* synthetic */ IEffectPlatformBaseListener c;

    public final void onSuccess(Object r13) {
        ResourceListModel r14 = (ResourceListModel) r13;
        IEffectPlatformBaseListener r0 = this.b;
        if (r0 == null) goto L5;
        r0.onSuccess(r14);
    L5:
        List<String> r1 = r14.getUrl_prefix();
        if ((!r1.isEmpty()) == false) goto L16;
        String r7 = p.a(this.a.getEffectConfig().i) + "resource_ex";
        String r2 = FileManager.a;
        if (FileManager.d(r7) == true) goto L10;
        FileManager.i(r7);
    L10:
        Iterator<T> r15 = r14.getResource_list().iterator();
    L12:
        if (r15.hasNext() == false) goto L22;
        ResourceListModel.ResourceListBean r3 = (ResourceListModel.ResourceListBean) r15.next();
        String r8 = p.a(r7) + r3.getResource_uri() + "_zip";
        i r9 = new i(r1, r3.getResource_uri());
        k r10 = EffectPlatform.access$getResourceRepository$p(this.a);
        e r11 = new e(r3, r8, r7, r1, this);
        r10.getClass();
        String r4 = q.a();
        r10.a.N.b(r4, r11);
        EffectConfig r5 = r10.a;
        x r6 = new x(r5, r9, r8, r4);
        q1 r12 = r5.D;
        if (r12 == null) goto L12;
        r12.a(r6);
        goto L12
    L22:
        return;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        ResourceListModel r4 = (ResourceListModel) r2;
        IEffectPlatformBaseListener r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFail(r4, r3);
        return;
    }

    public EffectPlatform$j(EffectPlatform r1, IEffectPlatformBaseListener r2, IEffectPlatformBaseListener r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
