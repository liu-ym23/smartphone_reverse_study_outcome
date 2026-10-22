package ee8;

import com.larus.bmhome.chat.cotdetail.CotDetailFragment;
import com.larus.im.bean.thread.ThreadData;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements IIMCallback<ThreadData> {
    public final /* synthetic */ CotDetailFragment a;
    public final /* synthetic */ String b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("CotDetailFragment", "get thread data failed, threadId: " + this.b + ", error: " + r4);
        Iterator<T> r5 = this.a.i.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((Function1) r5.next()).invoke(null);
        goto L4
    L6:
        this.a.i.clear();
    }

    public final void onSuccess(Object r4) {
        ThreadData r5 = (ThreadData) r4;
        FLogger.a.i("CotDetailFragment", "get thread data success, result: " + r5);
        CotDetailFragment r0 = this.a;
        r0.h = r5;
        Iterator<Function1<ThreadData, Unit>> r6 = r0.i.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.next().invoke(r0.h);
        goto L4
    L6:
        this.a.i.clear();
    }

    public p(CotDetailFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
