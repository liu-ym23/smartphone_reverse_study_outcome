package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.component.cvs.ChatConversationVM;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j2 {
    public static final Lazy a = null;
    public static int b;
    public static Boolean c;

    static {
        a = LazyKt.lazy(new i2());
        b = 1;
        c = Boolean.FALSE;
    }

    public static void a(ChatConversationVM r7, LifecycleCoroutineScope r8) {
        Intrinsics.checkNotNullParameter(r7, "chatConversationVM");
        Intrinsics.checkNotNullParameter(r8, "scope");
        BuildersKt.launch$default(r8, null, null, new TemplateTabRepo$updateRuleForTemplateLastTab$1(r7, null), 3, null);
    }
}
