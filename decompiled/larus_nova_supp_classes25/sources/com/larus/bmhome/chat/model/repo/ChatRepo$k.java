package com.larus.bmhome.chat.model.repo;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatRepo$k implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ CompletableDeferred<Pair<List<Message>, String>> b;
    public final /* synthetic */ ChatRepo c;
    public final /* synthetic */ String d;
    public final /* synthetic */ List<Message> e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        Intrinsics.checkNotNullParameter(r7, "error");
        if (r7.getCode() == 710022004) goto L5;
    L24:
        this.b.complete(TuplesKt.to(CollectionsKt.emptyList(), "sdk error"));
        return;
    L5:
        if (this.a == false) goto L24;
        t19.s r0 = t19.s.a;
        AppHost.Companion r8 = AppHost.a;
        Application r1 = r8.getApplication();
        z2 r2 = z2.a;
        FlowDowngradeToastConfig r3 = r2.getFlowDowngradeToastConfig();
        String r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.getTrafficDegradationLoadingFailureCn();
    L10:
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L19;
        String r9 = r8.getApplication().getString(2131910603);
    L18:
        String r10 = r9;
        Intrinsics.checkNotNull(r10);
        t19.s.j(r0, r1, r10, null, false, 28);
        goto L24
    L19:
        FlowDowngradeToastConfig r11 = r2.getFlowDowngradeToastConfig();
        if (r11 == null) goto L22;
        r4 = r11.getTrafficDegradationLoadingFailureCn();
    L22:
        r9 = String.valueOf(r4);
        goto L18
    L12:
        if (r5.length() == 0) goto L15;
        r6 = false;
        goto L16
    L9:
        r5 = null;
        goto L10
    }

    public final void onSuccess(Object r11) {
        List r12 = (List) r11;
        Intrinsics.checkNotNullParameter(r12, "result");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ChatRepo$reportDeleteMessage$3$onSuccess$1(r12, this.c, this.d, this.e, null), 3, null);
        this.b.complete(TuplesKt.to(r12, null));
    }

    public ChatRepo$k(boolean r1, CompletableDeferred<Pair<List<Message>, String>> r2, ChatRepo r3, String r4, List<Message> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
