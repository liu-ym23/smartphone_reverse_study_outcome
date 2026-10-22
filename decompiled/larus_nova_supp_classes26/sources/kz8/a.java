package kz8;

import android.os.SystemClock;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.conversation.FtsSearchResult;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;
import tx9.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements IIMCallback<FtsSearchResult<Message>> {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Continuation<FtsSearchResult<Message>> c;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger.a.w("MessageSearch", "searchMessage :" + r5);
        i3.d(this.b, 0, SystemClock.elapsedRealtime() - this.a, 0);
        this.c.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r6) {
        FtsSearchResult r7 = (FtsSearchResult) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        FLogger.a.i("MessageSearch", "searchMessage size: " + r7.getData().size() + ", newCursor=" + r7.getNewCursor() + ", hasMore=" + r7.getHasMore());
        i3.d(this.b, 1, SystemClock.elapsedRealtime() - this.a, r7.getData().size());
        this.c.resumeWith(Result.constructor-impl(r7));
    }

    public a(long r1, String r3, SafeContinuation r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
