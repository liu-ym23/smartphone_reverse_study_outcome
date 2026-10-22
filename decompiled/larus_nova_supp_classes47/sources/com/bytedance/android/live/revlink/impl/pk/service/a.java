package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.live.revlink.impl.control.s;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import i41.p;
import java.util.List;
import kotlin.jvm.functions.Function1;
import y31.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.service.a$a, reason: collision with other inner class name */
    public static final class C0175a {
        public static /* synthetic */ void a(a r6, long r7, b0 r9, PkAutoMatchManager.AutoMatchRequestSource r10) {
            r6.e(r7, r9, r10, null);
        }
    }

    void a(j r1);

    NextLiveData<k> b();

    void c(s r1);

    h0 d();

    void dismissDialog();

    void e(long r1, b0 r3, PkAutoMatchManager.AutoMatchRequestSource r4, Function1 r5);

    void f(AutoMatchSource r1);

    List<p> getListeners();

    boolean isInviting();
}
