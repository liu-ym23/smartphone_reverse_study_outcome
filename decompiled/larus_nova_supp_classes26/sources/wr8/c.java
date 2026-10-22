package wr8;

import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import ic8.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import wc9.e;
import wc9.j;
import wc9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements IIMCallback<j> {
    public final /* synthetic */ b a;
    public final /* synthetic */ long b;

    public final boolean mustInMain() {
        return false;
    }

    public final void onFailure(IIMError r14) {
        Intrinsics.checkNotNullParameter(r14, "error");
        FLogger.a.e("PreLoadConvListTask", "preloadConversationListV2 failed: " + r14);
        CompletableDeferred<List<l>> r0 = b.a;
        if (r0 == null) goto L5;
        r0.complete(CollectionsKt.emptyList());
    L5:
        b.f(this.a, false, this.b - ((Number) AppHost.a.getAppStartTime().getFirst()).longValue(), SystemClock.elapsedRealtime() - this.b, false, r14.getTips(), 0, 0, 96);
    }

    public final void onSuccess(Object r18) {
        j r1 = (j) r18;
        Intrinsics.checkNotNullParameter(r1, "result");
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("preloadConversationListV2 success: size = ");
        List r4 = r1.a;
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.size());
    L6:
        r3.append(r5);
        r3.append(", done = ");
        r3.append(r1.b);
        r2.i("PreLoadConvListTask", r3.toString());
        CompletableDeferred<List<l>> r6 = b.a;
        b.b = r1.b;
        CompletableDeferred<List<l>> r7 = b.a;
        if (r7 == null) goto L9;
        r7.complete(r1.a);
    L9:
        b r8 = this.a;
        long r9 = this.b - ((Number) AppHost.a.getAppStartTime().getFirst()).longValue();
        long r10 = SystemClock.elapsedRealtime() - this.b;
        List r11 = r1.a;
        if (r11 == null) goto L12;
        int r12 = r11.size();
    L13:
        List r13 = r1.a;
        if (r13 == null) goto L39;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L17:
        if (r15.hasNext() == false) goto L38;
        Object r16 = r15.next();
        l r17 = (l) r16;
        e r19 = r17.a;
        boolean r110 = true;
        if (r19 != null) goto L21;
    L36:
        if (r110 == true) goto L17;
        r14.add(r16);
        goto L17
    L21:
        if (n.r(r19) == true) goto L36;
        if (n.d(r17.a) == true) goto L36;
        e r111 = r17.a;
        if (r111 == null) goto L32;
        Integer r112 = r111.t;
        if (r112 == null) goto L32;
        if (r112.intValue() != 2) goto L32;
        boolean r113 = true;
    L33:
        if (r113 == true) goto L36;
        r110 = false;
    L32:
        r113 = false;
        goto L33
    L38:
        int r114 = r14.size();
    L40:
        b.f(r8, true, r9, r10, false, null, r12, r114, 24);
        return;
    L39:
        r114 = 0;
        goto L40
    L12:
        r12 = 0;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    public c(b r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
