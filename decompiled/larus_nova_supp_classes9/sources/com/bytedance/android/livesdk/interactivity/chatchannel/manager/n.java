package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.depend.im.IHostIMService;
import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements s22.b {
    public Disposable a;
    public List<IMEmoji> b;
    public Map<String, IMEmoji> c;
    public boolean d;

    @Override // s22.b
    public final List<IMEmoji> getEmojiList() {
        List<IMEmoji> r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public n() {
        this.d = true;
    }

    @Override // s22.b
    public final IMEmoji a(String r2) {
        Map<String, IMEmoji> r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    @Override // s22.b
    public final void b(String r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (this.d == false) goto L13;
        if (r3 == null) goto L13;
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L11;
        IHostIMService r1 = r0.getHostIMService();
        if (r1 == null) goto L11;
        r1.getEmojiVideoPathByName(r3, r4);
        return;
    L11:
        r4.invoke(null);
        return;
    L13:
        r4.invoke(null);
    }
}
