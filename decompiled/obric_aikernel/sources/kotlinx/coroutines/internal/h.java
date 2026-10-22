package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h {
    public static /* synthetic */ Iterator a() {
        return Arrays.asList(new kotlinx.coroutines.h0[]{new kotlinx.coroutines.android.b()}).iterator();
    L5:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    }
}
