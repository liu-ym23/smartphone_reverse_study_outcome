package com.ss.android.lark.keyboard.biz.mention;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m<T> implements AndroidThrottle.e {
    public final /* synthetic */ IMCommonAtStrategy a;

    public m(IMCommonAtStrategy r1) {
        this.a = r1;
    }

    public final void a(final Collection<String> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        final IMCommonAtStrategy r0 = this.a;
        final String r1 = (String) r0.c.invoke();
        List r2 = CollectionsKt.toMutableList(r6);
        Function0<Map<String, ? extends ChatChatter>> r3 = new IMCommonAtStrategy$getChatters$1(r1, r6, r0);
        int r7 = com.larksuite.rucket.job.compat.f.a;
        Intrinsics.checkNotNullParameter(r3, "action");
        new com.larksuite.rucket.job.impl.a(r3).then(Dispatchers.getMain(), new IMCommonAtStrategy$getChatters$2(r0, r2, null)).error(Dispatchers.getMain(), new IMCommonAtStrategy$getChatters$3(r0, r2, null));
    }
}
