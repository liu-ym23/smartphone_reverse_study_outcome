package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher r2, LifecycleOwner r3, final boolean r4, Function1<? super OnBackPressedCallback, Unit> r5) {
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r7, "onBackPressed");
        OnBackPressedCallback r0 = new OnBackPressedDispatcherKt$addCallback$callback$1(r4, r7);
        if (r6 == null) goto L5;
        r2.addCallback(r6, (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(r0, OnBackPressedCallback.class, "com.obric.memorydata.plugin"));
    L7:
        return (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(r0, OnBackPressedCallback.class, "com.obric.memorydata.plugin");
    L5:
        r2.addCallback((OnBackPressedCallback) ZeusTransformUtils.preCheckCast(r0, OnBackPressedCallback.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher r1, LifecycleOwner r2, boolean r3, Function1 r4, int r5, Object r6) {
        LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r2, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        return addCallback(r1, r7, r3, r8);
    }
}
