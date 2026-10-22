package androidx.fragment.app;

import androidx.annotation.MainThread;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a=\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"commit", "", "Landroidx/fragment/app/FragmentManager;", "allowStateLoss", "", "body", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "commitNow", "transaction", "now", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentManagerKt {
    public static final void commit(FragmentManager r5, boolean r10, Function1<? super FragmentTransaction, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "body");
        FragmentTransaction r12 = r5.beginTransaction();
        r11.invoke(r12);
        if (r10 == false) goto L5;
        r12.commitAllowingStateLoss();
        return;
    L5:
        r12.commit();
    }

    public static /* synthetic */ void commit$default(FragmentManager r5, boolean r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = false;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "body");
        FragmentTransaction r14 = r5.beginTransaction();
        r11.invoke(r14);
        if (r10 == false) goto L8;
        r14.commitAllowingStateLoss();
        return;
    L8:
        r14.commit();
    }

    @MainThread
    public static final void commitNow(FragmentManager r5, boolean r10, Function1<? super FragmentTransaction, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "body");
        FragmentTransaction r12 = r5.beginTransaction();
        r11.invoke(r12);
        if (r10 == false) goto L5;
        r12.commitNowAllowingStateLoss();
        return;
    L5:
        r12.commitNow();
    }

    public static /* synthetic */ void commitNow$default(FragmentManager r5, boolean r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = false;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "body");
        FragmentTransaction r14 = r5.beginTransaction();
        r11.invoke(r14);
        if (r10 == false) goto L8;
        r14.commitNowAllowingStateLoss();
        return;
    L8:
        r14.commitNow();
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(FragmentManager r5, boolean r10, boolean r11, Function1<? super FragmentTransaction, Unit> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r12, "body");
        FragmentTransaction r13 = r5.beginTransaction();
        r12.invoke(r13);
        if (r10 == false) goto L7;
        if (r11 == false) goto L6;
        r13.commitNowAllowingStateLoss();
        return;
    L6:
        r13.commitNow();
        return;
    L7:
        if (r11 == false) goto L9;
        r13.commitAllowingStateLoss();
        return;
    L9:
        r13.commit();
    }

    public static /* synthetic */ void transaction$default(FragmentManager r5, boolean r10, boolean r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = false;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r12, "body");
        FragmentTransaction r15 = r5.beginTransaction();
        r12.invoke(r15);
        if (r10 == false) goto L13;
        if (r11 == false) goto L12;
        r15.commitNowAllowingStateLoss();
        return;
    L12:
        r15.commitNow();
        return;
    L13:
        if (r11 == false) goto L15;
        r15.commitAllowingStateLoss();
        return;
    L15:
        r15.commit();
    }
}
