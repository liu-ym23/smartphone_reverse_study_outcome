package androidx.fragment.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0086\b¨\u0006\n"}, d2 = {"transaction", "", "Landroidx/fragment/app/FragmentManager;", "now", "", "allowStateLoss", "body", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "fragment-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class FragmentManagerKt {
    public static final void transaction(FragmentManager r2, boolean r3, boolean r4, Function1<? super FragmentTransaction, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        Intrinsics.checkParameterIsNotNull(r6, "body");
        FragmentTransaction r7 = r2.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(r7, "transaction");
        r6.invoke(r7);
        if (r3 == false) goto L7;
        if (r4 == false) goto L6;
        r7.commitNowAllowingStateLoss();
        return;
    L6:
        r7.commitNow();
        return;
    L7:
        if (r4 == false) goto L9;
        r7.commitAllowingStateLoss();
        return;
    L9:
        r7.commit();
    }

    public static /* synthetic */ void transaction$default(FragmentManager r1, boolean r2, boolean r3, Function1 r4, int r5, Object r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = false;
    L8:
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        Intrinsics.checkParameterIsNotNull(r7, "body");
        FragmentTransaction r8 = r1.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(r8, "transaction");
        r7.invoke(r8);
        if (r2 == false) goto L13;
        if (r3 == false) goto L12;
        r8.commitNowAllowingStateLoss();
        return;
    L12:
        r8.commitNow();
        return;
    L13:
        if (r3 == false) goto L15;
        r8.commitAllowingStateLoss();
        return;
    L15:
        r8.commit();
    }
}
