package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\fH\u0007J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u000fH\u0007J,\u0010\u001b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0007R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/fragment/app/FragmentTransition;", "", "()V", "PLATFORM_IMPL", "Landroidx/fragment/app/FragmentTransitionImpl;", "SUPPORT_IMPL", "callSharedElementStartEnd", "", "inFragment", "Landroidx/fragment/app/Fragment;", "outFragment", "isPop", "", "sharedElements", "Landroidx/collection/ArrayMap;", "", "Landroid/view/View;", "isStart", "resolveSupportImpl", "setViewVisibility", "views", "", "visibility", "", "supportsTransition", "findKeyForValue", "value", "retainValues", "namedViews", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFragmentTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentTransition.kt\nandroidx/fragment/app/FragmentTransition\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n515#2:123\n500#2,6:124\n125#3:130\n152#3,3:131\n125#3:134\n152#3,3:135\n125#3:138\n152#3,3:139\n1855#4,2:142\n*S KotlinDebug\n*F\n+ 1 FragmentTransition.kt\nandroidx/fragment/app/FragmentTransition\n*L\n50#1:123\n50#1:124,6\n53#1:130\n53#1:131,3\n98#1:134\n98#1:135,3\n99#1:138\n99#1:139,3\n113#1:142,2\n*E\n"})
public final class FragmentTransition {
    public static final FragmentTransition INSTANCE = null;

    @JvmField
    public static final FragmentTransitionImpl PLATFORM_IMPL = null;

    @JvmField
    public static final FragmentTransitionImpl SUPPORT_IMPL = null;

    static {
        FragmentTransition r5 = new FragmentTransition();
        INSTANCE = r5;
        PLATFORM_IMPL = new FragmentTransitionCompat21();
        SUPPORT_IMPL = r5.resolveSupportImpl();
    }

    private FragmentTransition() {
    }

    @JvmStatic
    public static final void callSharedElementStartEnd(Fragment r5, Fragment r10, boolean r11, ArrayMap<String, View> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "inFragment");
        Intrinsics.checkNotNullParameter(r10, "outFragment");
        Intrinsics.checkNotNullParameter(r12, "sharedElements");
        if (r11 == false) goto L5;
        SharedElementCallback r14 = r10.getEnterTransitionCallback();
    L6:
        if (r14 == null) goto L22;
        ArrayList r15 = new ArrayList(r12.size());
        Iterator<Map.Entry<String, View>> r16 = r12.entrySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        r15.add(r16.next().getValue());
        goto L9
    L11:
        ArrayList r17 = new ArrayList(r12.size());
        Iterator<Map.Entry<String, View>> r18 = r12.entrySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L16;
        r17.add(r18.next().getKey());
        goto L13
    L16:
        if (r13 == false) goto L18;
        r14.onSharedElementStart(r17, r15, null);
        return;
    L18:
        r14.onSharedElementEnd(r17, r15, null);
        return;
    L22:
        return;
    L5:
        r14 = r5.getEnterTransitionCallback();
        goto L6
    }

    @JvmStatic
    public static final String findKeyForValue(ArrayMap<String, String> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "value");
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r12 = r5.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<String, String> r13 = r12.next();
        if (Intrinsics.areEqual(r13.getValue(), r10) == false) goto L4;
        r11.put(r13.getKey(), r13.getValue());
        goto L4
    L8:
        ArrayList r14 = new ArrayList(r11.size());
        Iterator r15 = r11.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L13;
        r14.add((String) ((Map.Entry) r15.next()).getKey());
        goto L10
    L13:
        return (String) CollectionsKt.firstOrNull(r14);
    }

    private final FragmentTransitionImpl resolveSupportImpl() {
        Intrinsics.checkNotNull(FragmentTransitionSupport.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");     // Catch: Exception -> L6
        return (FragmentTransitionImpl) FragmentTransitionSupport.class.getDeclaredConstructor(null).newInstance(null);
    L9:
        return null;
    }

    @JvmStatic
    public static final void retainValues(ArrayMap<String, String> r5, ArrayMap<String, View> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "namedViews");
        int r11 = r5.size();
    L3:
        r11 = r11 - 1;
        if ((-1) >= r11) goto L9;
        if (r10.containsKey(r5.valueAt(r11)) == true) goto L3;
        r5.removeAt(r11);
        goto L3
    }

    @JvmStatic
    public static final void setViewVisibility(List<? extends View> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "views");
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((View) r11.next()).setVisibility(r10);
        goto L4
    }

    @JvmStatic
    public static final boolean supportsTransition() {
        if (PLATFORM_IMPL == null) goto L5;
    L8:
        return true;
    L5:
        if (SUPPORT_IMPL != null) goto L8;
        return false;
    }
}
