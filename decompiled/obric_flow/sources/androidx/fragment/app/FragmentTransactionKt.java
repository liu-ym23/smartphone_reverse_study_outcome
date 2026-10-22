package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b¨\u0006\u000b"}, d2 = {"add", "Landroidx/fragment/app/FragmentTransaction;", "F", "Landroidx/fragment/app/Fragment;", "containerViewId", "", "tag", "", "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r5, @IdRes int r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        return r5.add(r10, Fragment.class, r12, r11);
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r5, int r10, String r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        return r5.add(r10, Fragment.class, r12, r11);
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction r5, @IdRes int r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        return r5.replace(r10, Fragment.class, r12, r11);
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction r5, int r10, String r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        return r5.replace(r10, Fragment.class, r12, r11);
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r5, String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        return r5.add(Fragment.class, r11, r10);
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r5, String r10, Bundle r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        return r5.add(Fragment.class, r11, r10);
    }
}
