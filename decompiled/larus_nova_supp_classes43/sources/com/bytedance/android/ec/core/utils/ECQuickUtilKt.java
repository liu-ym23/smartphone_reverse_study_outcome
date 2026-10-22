package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECQuickUtilKt {
    public static final ECQuickUtilKt$DEFAULT_LIFECYCLE$1 a = null;
    public static final ECQuickUtilKt$DEFAULT_LIFECYCLE_OWNER$1 b = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.ec.core.utils.ECQuickUtilKt$DEFAULT_LIFECYCLE$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.ec.core.utils.ECQuickUtilKt$DEFAULT_LIFECYCLE_OWNER$1] */
    static {
        a = new ECQuickUtilKt$DEFAULT_LIFECYCLE$1();
        b = new ECQuickUtilKt$DEFAULT_LIFECYCLE_OWNER$1();
    }

    public static final LifecycleOwner a(QContext r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$lifecycleOwnerSafe");
        LifecycleOwner r0 = r1.a;
        if (r0 != null) goto L9;
        Activity r10 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r1.c());
        if ((r10 instanceof LifecycleOwner) == true) goto L8;
        r10 = null;
    L8:
        r0 = (LifecycleOwner) r10;
    L9:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return b;
    }

    public static final <F extends Fragment> F b(QContext r10, Class<F> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$uniqueFragment");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        FragmentActivity r12 = l0.c(r10.c());
        if (r12 == null) goto L16;
        FragmentManager r1 = r12.getSupportFragmentManager();
        if (r1 == null) goto L16;
        List r13 = r1.getFragments();
        if (r13 == null) goto L16;
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((Fragment) r15).getClass(), r11) == false) goto L10;
    L15:
        F r16 = (F) r15;
    L17:
        if (r16 == null) goto L19;
        return r16;
    L19:
        if (r12 == null) goto L47;
        FragmentManager r17 = r12.getSupportFragmentManager();
        if (r17 == null) goto L47;
        List r18 = r17.getFragments();
        if (r18 == null) goto L47;
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L26:
        if (r20.hasNext() == false) goto L33;
        Object r21 = r20.next();
        if (((Fragment) r21).getHost() == null) goto L30;
        boolean r22 = true;
    L31:
        if (r22 == false) goto L26;
        r19.add(r21);
        goto L26
    L30:
        r22 = false;
        goto L31
    L33:
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r24 = r19.iterator();
    L35:
        if (r24.hasNext() == false) goto L37;
        r23.add(((Fragment) r24.next()).getChildFragmentManager().getFragments());
        goto L35
    L37:
        List r25 = CollectionsKt.flatten(r23);
        if (r25 == null) goto L47;
        Iterator r26 = r25.iterator();
    L41:
        if (r26.hasNext() == false) goto L45;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((Fragment) r27).getClass(), r11) == false) goto L41;
    L46:
        Fragment r28 = (Fragment) r27;
    L49:
        if ((r28 instanceof Fragment) == true) goto L52;
        return null;
    L52:
        return (F) r28;
    L45:
        r27 = null;
    L47:
        r28 = null;
        goto L49
    L14:
        r15 = null;
    L16:
        r16 = null;
        goto L17
    }

    public static final <T extends QViewModel> T c(QContext r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$vmOfActivitySafe");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        Activity r0 = l0.b(r10.c());
        if ((r0 instanceof ViewModelStoreOwner) == true) goto L5;
        Activity r1 = null;
    L6:
        ViewModelStoreOwner r12 = (ViewModelStoreOwner) r1;
        if ((r0 instanceof QViewModelOwner) == true) goto L9;
        r0 = null;
    L9:
        QViewModelOwner r13 = (QViewModelOwner) r0;
        if (r12 == null) goto L16;
        if (r13 == null) goto L16;
        return new ViewModelProvider(r12, r13.o6()).get(r11);
    L16:
        return (T) r10.f(r11);
    L5:
        r1 = r0;
        goto L6
    }

    public static final <T extends QViewModel, F extends Fragment & QViewModelOwner> T d(QContext r10, Class<T> r11, Class<F> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$vmOfFragmentOrActivitySafe");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        Intrinsics.checkNotNullParameter(r12, "fragmentType");
        FragmentActivity r0 = l0.c(r10.c());
        Fragment r1 = null;
        Object r13 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        if (r0 == null) goto L16;
        FragmentManager r14 = r0.getSupportFragmentManager();
        if (r14 == null) goto L16;
        List r15 = r14.getFragments();
        if (r15 == null) goto L16;
        Iterator r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L14;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((Fragment) r17).getClass(), r12) == false) goto L10;
    L15:
        Fragment r18 = (Fragment) r17;
    L17:
        if (r18 != null) goto L19;
        if (r0 == null) goto L47;
        FragmentManager r19 = r0.getSupportFragmentManager();
        if (r19 == null) goto L47;
        List r20 = r19.getFragments();
        if (r20 == null) goto L47;
        ArrayList r21 = new ArrayList();
        Iterator r22 = r20.iterator();
    L27:
        if (r22.hasNext() == false) goto L34;
        Object r23 = r22.next();
        if (((Fragment) r23).getHost() == null) goto L31;
        boolean r24 = true;
    L32:
        if (r24 == false) goto L27;
        r21.add(r23);
        goto L27
    L31:
        r24 = false;
        goto L32
    L34:
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r26 = r21.iterator();
    L36:
        if (r26.hasNext() == false) goto L38;
        r25.add(((Fragment) r26.next()).getChildFragmentManager().getFragments());
        goto L36
    L38:
        List r27 = CollectionsKt.flatten(r25);
        if (r27 == null) goto L47;
        Iterator r28 = r27.iterator();
    L42:
        if (r28.hasNext() == false) goto L46;
        Object r29 = r28.next();
        if (Intrinsics.areEqual(((Fragment) r29).getClass(), r12) == false) goto L42;
        r13 = r29;
    L46:
        r1 = (Fragment) r13;
    L47:
        if (r1 == null) goto L51;
        return (T) QContext.h(r11, r1);
    L51:
        return (T) c(r10, r11);
    L19:
        return (T) QContext.h(r11, r18);
    L14:
        r17 = null;
    L16:
        r18 = null;
        goto L17
    }
}
