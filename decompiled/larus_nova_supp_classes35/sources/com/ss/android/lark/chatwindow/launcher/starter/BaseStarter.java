package com.ss.android.lark.chatwindow.launcher.starter;

import com.ss.android.lark.chatwindow.launcher.ChatLauncherV2;
import com.ss.android.lark.chatwindow.launcher.transform.d;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseStarter implements a {
    public BaseStarter() {
    }

    public void b(d r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
    }

    public abstract boolean c(ChatLauncherV2.b r1, d r2);

    @Override // com.ss.android.lark.chatwindow.launcher.starter.a
    public final Object a(ChatLauncherV2.b r4, d r5, Continuation<? super Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        b(r5);
        return BuildersKt.withContext(Dispatchers.getMain(), new BaseStarter$executeStart$2(this, r4, r5, null), r6);
    }
}
