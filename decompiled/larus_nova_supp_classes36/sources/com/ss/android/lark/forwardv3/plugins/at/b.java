package com.ss.android.lark.forwardv3.plugins.at;

import com.larksuite.framework.utils.AndroidThrottle;
import com.larksuite.rucket.job.compat.f;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements AndroidThrottle.e {
    public final /* synthetic */ ForwardAtStrategy a;

    public b(ForwardAtStrategy r1) {
        this.a = r1;
    }

    public final void a(final Collection<String> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        final ForwardAtStrategy r0 = this.a;
        r0.getClass();
        f.a(new ForwardAtStrategy$fetchChattersInChat$1(r6, r0)).then(Dispatchers.getMain(), new ForwardAtStrategy$fetchChattersInChat$2(r0, r6, null)).error(Dispatchers.getMain(), new ForwardAtStrategy$fetchChattersInChat$3(r0, r6, null));
    }
}
