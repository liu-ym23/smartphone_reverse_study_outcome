package com.larus.drive.sdk.impl.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.floatchat.IFloatChatService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveChatServiceDelegate implements e89.a {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public DriveChatServiceDelegate() {
    }

    public static final Fragment b(DriveChatServiceDelegate r7, final Bundle r8, boolean r9) {
        r7.getClass();
        return IFloatChatService.a.a((IFloatChatService) ServiceManager.get().getService(IFloatChatService.class), r8, r9, null, null, new com.larus.drive.sdk.impl.service.a(r8), 12);
    }

    @Override // e89.a
    public final Object a(Fragment r16, Bundle r17, boolean r18, Continuation<? super Fragment> r110) {
        boolean r0 = true;
        CompletableDeferred<Fragment> r9 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String r1 = r17.getString("conversation_id", null);
        if (r1 != null) goto L5;
    L8:
        if (r0 == true) goto L17;
        LifecycleOwner r2 = (LifecycleOwner) r16.getViewLifecycleOwnerLiveData().getValue();
        if (r2 == null) goto L15;
        LifecycleCoroutineScope r10 = LifecycleOwnerKt.getLifecycleScope(r2);
        if (r10 == null) goto L15;
        if (BuildersKt.launch$default(r10, null, null, new DriveChatServiceDelegate$withRemoteConv$1(r1, r17, r9, this, r18, r16, null), 3, null) == null) goto L15;
    L19:
        return r9.await(r110);
    L15:
        r9.complete(null);
        goto L19
    L17:
        c(r9, r16, r17, r18);
        goto L19
    L5:
        if (r1.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public final void c(CompletableDeferred<Fragment> r12, Fragment r13, Bundle r14, boolean r15) {
        LifecycleOwner r0 = (LifecycleOwner) r13.getViewLifecycleOwnerLiveData().getValue();
        if (r0 == null) goto L8;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L8;
        if (BuildersKt.launch$default(r1, null, null, new DriveChatServiceDelegate$withLocalConv$1(r13, r12, r14, this, r15, null), 3, null) == null) goto L8;
        return;
    L8:
        r12.complete(null);
    }
}
