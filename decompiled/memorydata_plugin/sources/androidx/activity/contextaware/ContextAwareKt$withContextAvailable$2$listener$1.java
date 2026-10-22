package androidx.activity.contextaware;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "onContextAvailable", "", "context", "Landroid/content/Context;", "activity-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ n<R> $co;
    final /* synthetic */ Function1<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(n<? super R> r3, Function1<? super Context, ? extends R> r4) {
        n<R> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        Function1<Context, R> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        this.$co = r5;
        this.$onContextAvailable = r6;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Continuation r0 = this.$co;
        Function1<Context, R> r2 = this.$onContextAvailable;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        ContextAwareKt$withContextAvailable$2$listener$1 r4 = (ContextAwareKt$withContextAvailable$2$listener$1) ZeusTransformUtils.preCheckCast(this, ContextAwareKt$withContextAvailable$2$listener$1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(r2.invoke(r6));     // Catch: Throwable -> L5
    L7:
        r0.resumeWith(r7);
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
