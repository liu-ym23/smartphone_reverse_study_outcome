package com.ss.android.lark.chat.mergeforward;

import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(List r2, boolean r3) {
        List r4 = (List) BuildersKt.runBlocking$default(null, new MessagePreviewAttachHelper$completeMessages$1(r2, r3, null), 1, null);
    }
}
