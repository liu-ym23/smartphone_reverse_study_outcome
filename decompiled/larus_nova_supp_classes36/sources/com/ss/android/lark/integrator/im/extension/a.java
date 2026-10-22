package com.ss.android.lark.integrator.im.extension;

import com.ss.android.lark.biz.im.api.extension.message.k;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.im.base.c;
import com.ss.android.lark.locationmessage.message.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.b;
import com.ss.android.lark.message.lynxcard.message.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import r5b.e;
import w4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements d, c {
    @Inject
    public a() {
    }

    public final List<e<?, ?, ?>> c() {
        ArrayList r0 = new ArrayList();
        nmb.a.a().getOpenFeatureDependency().a(r0);
        new b();
        ArrayList r1 = new ArrayList();
        r1.add(new com.ss.android.lark.message.vote.message.c());
        r1.add(new m());
        r0.addAll(r1);
        new lqb.b(com.ss.android.lark.integrator.im.message.d.a);
        r0.add(new f());
        return r0;
    }

    @Override // com.ss.android.lark.im.base.c
    public final void b() {
        ExtensionManager.a();
        Log.i("ExtensionManager", "injectImExtensionsIfNeed");
    }

    public final Collection<k> d() {
        return (CopyOnWriteArrayList) ExtensionManager.a().e.getValue();
    }

    public final gya.a<Content> a(MessageType r1) {
        return ExtensionManager.b(r1);
    }
}
