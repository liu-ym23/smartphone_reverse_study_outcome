package androidx.core.view;

import android.os.Build;
import android.view.ViewStructure;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    private static class Api23Impl {
        private Api23Impl() {
        }

        static void setClassName(ViewStructure r0, String r1) {
            r0.setClassName(r1);
        }

        static void setContentDescription(ViewStructure r2, CharSequence r3) {
            r2.setContentDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static void setDimens(ViewStructure r0, int r1, int r2, int r3, int r4, int r5, int r6) {
            r0.setDimens(r1, r2, r3, r4, r5, r6);
        }

        static void setText(ViewStructure r2, CharSequence r3) {
            r2.setText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    private ViewStructureCompat(ViewStructure r1) {
        this.mWrappedObj = r1;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure r1) {
        return new ViewStructureCompat(r1);
    }

    public void setClassName(String r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setClassName((ViewStructure) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ViewStructure.class, "com.obric.memorydata.plugin"), r3);
        return;
    }

    public void setContentDescription(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setContentDescription((ViewStructure) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ViewStructure.class, "com.obric.memorydata.plugin"), r5);
        return;
    }

    public void setDimens(int r8, int r9, int r10, int r11, int r12, int r13) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setDimens((ViewStructure) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ViewStructure.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13);
        return;
    }

    public void setText(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setText((ViewStructure) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ViewStructure.class, "com.obric.memorydata.plugin"), r5);
        return;
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ViewStructure.class, "com.obric.memorydata.plugin");
    }
}
