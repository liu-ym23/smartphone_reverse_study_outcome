package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.depend.im.IHostIMService;
import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements ObservableOnSubscribe {
    public final /* synthetic */ List a;

    public i(List r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<List<IMEmoji>> r8) {
        Intrinsics.checkNotNullParameter(r8, "emitter");
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L27;
        IHostIMService r1 = r0.getHostIMService();
        if (r1 == null) goto L27;
        List r2 = r1.getInteractiveEmojiData();
        if (r2 == null) goto L27;
        if (r2.isEmpty() == true) goto L11;
        ArrayList r3 = new ArrayList(this.a.size());
        Iterator r4 = this.a.iterator();
    L15:
        if (r4.hasNext() == false) goto L26;
        String r5 = (String) r4.next();
        Iterator<T> r6 = r2.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        T r7 = r6.next();
        if (Intrinsics.areEqual(((IMEmoji) r7).getDisplayName(), r5) == false) goto L18;
    L23:
        IMEmoji r9 = (IMEmoji) r7;
        if (r9 == null) goto L15;
        r3.add(r9);
        goto L15
    L22:
        r7 = null;
        goto L23
    L26:
        r8.onNext(r3);
        return;
    L11:
        if (r8.isDisposed() == true) goto L37;
        r8.onError(new RuntimeException("no emoji data"));
        return;
    L37:
        return;
    L27:
        r8.onNext(CollectionsKt.emptyList());
    }
}
