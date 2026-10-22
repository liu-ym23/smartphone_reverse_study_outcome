package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    static class Api18Impl {
        private Api18Impl() {
        }

        static int getLayoutMode(ViewGroup r0) {
            return r0.getLayoutMode();
        }

        static void setLayoutMode(ViewGroup r0, int r1) {
            r0.setLayoutMode(r1);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static int getNestedScrollAxes(ViewGroup r0) {
            return r0.getNestedScrollAxes();
        }

        static boolean isTransitionGroup(ViewGroup r0) {
            return r0.isTransitionGroup();
        }

        static void setTransitionGroup(ViewGroup r0, boolean r1) {
            r0.setTransitionGroup(r1);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(ViewGroup r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return 0;
    L5:
        return Api18Impl.getLayoutMode(r2);
    }

    public static int getNestedScrollAxes(ViewGroup r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getNestedScrollAxes(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingParent.class) == true) goto L9;
        return 0;
    L9:
        return ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r2, NestedScrollingParent.class, "com.obric.memorydata.plugin")).getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(ViewGroup r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_transition_group, OaidModel.KEY_ID, "tag_transition_group")), Boolean.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        if (r0.booleanValue() == false) goto L11;
    L16:
        return true;
    L11:
        if (r3.getBackground() != null) goto L16;
        if (ViewCompat.getTransitionName(r3) != null) goto L16;
        return false;
    L5:
        return Api21Impl.isTransitionGroup(r3);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup r0, View r1, AccessibilityEvent r2) {
        return r0.onRequestSendAccessibilityEvent(r1, r2);
    }

    public static void setLayoutMode(ViewGroup r2, int r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.setLayoutMode(r2, r3);
        return;
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup r0, boolean r1) {
        r0.setMotionEventSplittingEnabled(r1);
    }

    public static void setTransitionGroup(ViewGroup r3, boolean r4) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.setTransitionGroup(r3, r4);
        return;
    L5:
        r3.setTag(ZeusTransformUtils.mapRes(R.id.tag_transition_group, OaidModel.KEY_ID, "tag_transition_group"), Boolean.valueOf(r4));
    }
}
