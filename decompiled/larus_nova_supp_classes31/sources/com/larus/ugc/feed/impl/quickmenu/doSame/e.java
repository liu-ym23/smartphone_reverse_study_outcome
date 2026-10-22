package com.larus.ugc.feed.impl.quickmenu.doSame;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ugc.feed.impl.component.q;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import sq9.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final Lazy a = null;

    public e() {
    }

    static {
        a = LazyKt.lazy(new a());
    }

    public static final b0 a() {
        return (b0) a.getValue();
    }

    public static void b(FragmentActivity r14, UserCreation r15, o0a.a r16, String r17, q r18) {
        Intrinsics.checkNotNullParameter(r14, "activity");
        Intrinsics.checkNotNullParameter(r15, "userCreation");
        Intrinsics.checkNotNullParameter(r16, "tracker");
        Intrinsics.checkNotNullParameter(r18, "onItemClick");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), Dispatchers.getMain().getImmediate(), null, new DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(r15, r14, r16, r17, "template_list", r18, null, null), 2, null);
    }
}
