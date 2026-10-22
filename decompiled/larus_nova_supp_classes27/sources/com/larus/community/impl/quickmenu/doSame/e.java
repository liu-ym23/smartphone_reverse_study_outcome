package com.larus.community.impl.quickmenu.doSame;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.api.creation.UserCreation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import sq9.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
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

    public static void b(FragmentActivity r12, UserCreation r13, JSONObject r14, Function2 r15) {
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r13, "userCreation");
        Intrinsics.checkNotNullParameter(r15, "onItemClick");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), Dispatchers.getMain().getImmediate(), null, new DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(r13, r12, r14, r15, null, null), 2, null);
    }
}
