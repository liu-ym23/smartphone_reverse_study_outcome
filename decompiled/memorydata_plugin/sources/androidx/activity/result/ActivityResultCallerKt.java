package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000b\u001aY\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "I", "O", "Landroidx/activity/result/ActivityResultCaller;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "callback", "Lkotlin/Function1;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/activity/result/ActivityResultRegistry;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ActivityResultCallerKt {
    public static /* synthetic */ void lambda$IxsKVMp9hSCX4lNHsExE1MpniBw(Function1 r0, Object r1) {
        m8registerForActivityResult$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$iuyrlw5W9LCXAzBi34UVLjiGmDs(Function1 r0, Object r1) {
        m7registerForActivityResult$lambda0(r0, r1);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller r2, ActivityResultContract<I, O> r3, I r4, ActivityResultRegistry r5, Function1<? super O, Unit> r6) {
        ActivityResultCaller r7 = (ActivityResultCaller) ZeusTransformUtils.wrapperContextForParams(r2, ActivityResultCaller.class, "com.obric.memorydata.plugin");
        final Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r3, "contract");
        Intrinsics.checkNotNullParameter(r5, "registry");
        Intrinsics.checkNotNullParameter(r8, "callback");
        ActivityResultLauncher<I> r9 = r7.registerForActivityResult(r3, r5, new $$Lambda$ActivityResultCallerKt$iuyrlw5W9LCXAzBi34UVLjiGmDs(r8));
        Intrinsics.checkNotNullExpressionValue(r9, "registerForActivityResul…egistry) { callback(it) }");
        return (ActivityResultLauncher) ZeusTransformUtils.preCheckCast(new ActivityResultCallerLauncher(r9, r3, r4), ActivityResultLauncher.class, "com.obric.memorydata.plugin");
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller r2, ActivityResultContract<I, O> r3, I r4, Function1<? super O, Unit> r5) {
        ActivityResultCaller r6 = (ActivityResultCaller) ZeusTransformUtils.wrapperContextForParams(r2, ActivityResultCaller.class, "com.obric.memorydata.plugin");
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r3, "contract");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ActivityResultLauncher<I> r8 = r6.registerForActivityResult(r3, new $$Lambda$ActivityResultCallerKt$IxsKVMp9hSCX4lNHsExE1MpniBw(r7));
        Intrinsics.checkNotNullExpressionValue(r8, "registerForActivityResul…ontract) { callback(it) }");
        return (ActivityResultLauncher) ZeusTransformUtils.preCheckCast(new ActivityResultCallerLauncher(r8, r3, r4), ActivityResultLauncher.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: registerForActivityResult$lambda-0, reason: not valid java name */
    private static final void m7registerForActivityResult$lambda0(Function1 r2, Object r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$callback");
        r4.invoke(r3);
    }

    /* JADX INFO: renamed from: registerForActivityResult$lambda-1, reason: not valid java name */
    private static final void m8registerForActivityResult$lambda1(Function1 r2, Object r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$callback");
        r4.invoke(r3);
    }
}
