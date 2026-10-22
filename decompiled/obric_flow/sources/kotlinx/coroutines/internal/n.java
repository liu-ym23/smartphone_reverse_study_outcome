package kotlinx.coroutines.internal;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MainCoroutineDispatcher f18945a = null;

    static {
        int r5 = u.f18952a;
        Object r10 = null;
        String r11 = System.getProperty("kotlinx.coroutines.fast.service.loader");     // Catch: SecurityException -> L5
    L6:
        if (r11 == null) goto L38;
        Boolean.parseBoolean(r11);
    L38:
        Iterator r12 = SequencesKt.toList(SequencesKt.asSequence(Arrays.asList(new wt.a[]{new wt.a()}).iterator())).iterator();
        if (r12.hasNext() == false) goto L21;
        r10 = r12.next();
        if (r12.hasNext() == false) goto L21;
        int r13 = ((wt.a) r10).a();
    L16:
        Object r14 = r12.next();
        int r15 = ((wt.a) r14).a();
        if (r13 >= r15) goto L20;
        r10 = r14;
        r13 = r15;
    L20:
        if (r12.hasNext() == true) goto L16;
    L21:
        wt.a r16 = (wt.a) r10;
        if (r16 == null) goto L34;
        r16.getClass();     // Catch: Throwable -> L30
        Looper r17 = Looper.getMainLooper();     // Catch: Throwable -> L30
        if (r17 == null) goto L29;
        f18945a = new wt.d(wt.e.a(r17));
        return;
    L29:
        throw new IllegalStateException("The main looper is not available");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r16.getClass();
        throw th;
    L34:
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    L35:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    L5:
        r11 = null;
        goto L6
    }
}
