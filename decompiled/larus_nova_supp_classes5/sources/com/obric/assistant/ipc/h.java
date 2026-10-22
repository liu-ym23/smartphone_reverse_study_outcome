package com.obric.assistant.ipc;

import com.larus.account.base.api.IMultiAccountService;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class h implements IMultiAccountService.a {
    public /* synthetic */ h() {
    }

    public final void a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<unused var>");
        Intrinsics.checkNotNullParameter(r8, "removedUid");
        IpcMessenger.a.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IpcMessenger.handleAccountRemoved.1(r8, null), 3, null);
    }
}
