package androidx.fragment.app;

import android.os.Build;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class FragmentTransition {
    static final FragmentTransitionImpl PLATFORM_IMPL = null;
    static final FragmentTransitionImpl SUPPORT_IMPL = null;

    static {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        FragmentTransitionCompat21 r0 = new FragmentTransitionCompat21();
    L6:
        PLATFORM_IMPL = r0;
        SUPPORT_IMPL = resolveSupportImpl();
        return;
    L5:
        r0 = null;
        goto L6
    }

    private FragmentTransition() {
    }

    static void callSharedElementStartEnd(Fragment r5, Fragment r6, boolean r7, ArrayMap<String, View> r8, boolean r9) {
        if (r7 == false) goto L4;
        SharedElementCallback r10 = r6.getEnterTransitionCallback();
    L5:
        if (r10 == null) goto L19;
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        int r0 = 0;
        if (r8 != null) goto L9;
        int r1 = 0;
    L10:
        if (r0 >= r1) goto L13;
        r12.add((String) ZeusTransformUtils.preCheckCast(r8.keyAt(r0), String.class, "com.obric.memorydata.plugin"));
        r11.add((View) ZeusTransformUtils.preCheckCast(r8.valueAt(r0), View.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L10
    L13:
        if (r9 == false) goto L15;
        r10.onSharedElementStart(r12, r11, null);
        return;
    L15:
        r10.onSharedElementEnd(r12, r11, null);
        return;
    L9:
        r1 = r8.size();
        goto L10
    L19:
        return;
    L4:
        r10 = r5.getEnterTransitionCallback();
        goto L5
    }

    static String findKeyForValue(ArrayMap<String, String> r3, String r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r4.equals(r3.valueAt(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r3.keyAt(r1), String.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        return (FragmentTransitionImpl) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("androidx.transition.FragmentTransitionSupport", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), FragmentTransitionImpl.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    static void retainValues(ArrayMap<String, String> r4, ArrayMap<String, View> r5) {
        int r0 = r4.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r5.containsKey((String) ZeusTransformUtils.preCheckCast(r4.valueAt(r0), String.class, "com.obric.memorydata.plugin")) == true) goto L7;
        r4.removeAt(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    static void setViewVisibility(ArrayList<View> r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        ((View) ZeusTransformUtils.preCheckCast(r4.get(r0), View.class, "com.obric.memorydata.plugin")).setVisibility(r5);
        r0 = r0 - 1;
        goto L5
    }

    static boolean supportsTransition() {
        if (PLATFORM_IMPL == null) goto L5;
    L8:
        return true;
    L5:
        if (SUPPORT_IMPL != null) goto L8;
        return false;
    }
}
