package z7;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13802a = null;

    static {
        f13802a = new a();
    }

    private a() {
    }

    public final Object a(Continuation<? super com.obric.aikernel.a> r10) {
        return AIKernelApi.j(AIKernelManager.INSTANCE.getInstance$sdk_release(), 0, r10, 1, null);
    }

    public final boolean b() {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().k();
    }
}
