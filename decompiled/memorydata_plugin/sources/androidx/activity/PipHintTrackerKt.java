package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"trackPipAnimationHintView", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PipHintTrackerKt {
    public static final /* synthetic */ Rect access$trackPipAnimationHintView$positionInWindow(View r0) {
        return trackPipAnimationHintView$positionInWindow(r0);
    }

    public static final Object trackPipAnimationHintView(Activity r3, View r4, Continuation<? super Unit> r5) {
        final Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r8 = k.b((Function2) ZeusTransformUtils.preCheckCast(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(r4, null), Function2.class, "com.obric.memorydata.plugin")).collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6), j.class, "com.obric.memorydata.plugin"), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    private static final Rect trackPipAnimationHintView$positionInWindow(View r1) {
        Rect r0 = new Rect();
        r1.getGlobalVisibleRect(r0);
        return r0;
    }
}
