package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        Factory2Wrapper(LayoutInflaterFactory r3) {
            this.mDelegateFactory = (LayoutInflaterFactory) ZeusTransformUtils.wrapperContextForParams(r3, LayoutInflaterFactory.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
            return this.mDelegateFactory.onCreateView(r3, r4, r7, r8);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r3, Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
            return this.mDelegateFactory.onCreateView(null, r3, r6, r7);
        }

        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater r6, LayoutInflater.Factory2 r7) {
        LayoutInflater.Factory2 r8 = (LayoutInflater.Factory2) ZeusTransformUtils.wrapperContextForParams(r7, LayoutInflater.Factory2.class, "com.obric.memorydata.plugin");
        if (sCheckedField == false) goto L19;
    L10:
        Field r0 = sLayoutInflaterFactory2Field;
        if (r0 == null) goto L21;
        r0.set(r6, r8);     // Catch: IllegalAccessException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + r6 + "; inflation may have unexpected results.", e);
        return;
    L21:
        return;
    L19:
        Field r3 = LayoutInflater.class.getDeclaredField("mFactory2");     // Catch: NoSuchFieldException -> L7
        sLayoutInflaterFactory2Field = r3;     // Catch: NoSuchFieldException -> L7
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sCheckedField = true;
    L7:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
        goto L9
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater r2) {
        LayoutInflater.Factory r3 = r2.getFactory();
        if (ZeusTransformUtils.instanceOf(r3, Factory2Wrapper.class) == true) goto L5;
        return null;
    L5:
        return ((Factory2Wrapper) ZeusTransformUtils.preCheckCast(r3, Factory2Wrapper.class, "com.obric.memorydata.plugin")).mDelegateFactory;
    }

    @Deprecated
    public static void setFactory(LayoutInflater r3, LayoutInflaterFactory r4) {
        LayoutInflaterFactory r5 = (LayoutInflaterFactory) ZeusTransformUtils.wrapperContextForParams(r4, LayoutInflaterFactory.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r3.setFactory2(new Factory2Wrapper(r5));
        return;
    L5:
        Factory2Wrapper r0 = new Factory2Wrapper(r5);
        r3.setFactory2(r0);
        LayoutInflater.Factory r6 = r3.getFactory();
        if (ZeusTransformUtils.instanceOf(r6, LayoutInflater.Factory2.class) == false) goto L8;
        forceSetFactory2(r3, (LayoutInflater.Factory2) ZeusTransformUtils.preCheckCast(r6, LayoutInflater.Factory2.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        forceSetFactory2(r3, r0);
    }

    public static void setFactory2(LayoutInflater r3, LayoutInflater.Factory2 r4) {
        LayoutInflater.Factory2 r5 = (LayoutInflater.Factory2) ZeusTransformUtils.wrapperContextForParams(r4, LayoutInflater.Factory2.class, "com.obric.memorydata.plugin");
        r3.setFactory2(r5);
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        LayoutInflater.Factory r0 = r3.getFactory();
        if (ZeusTransformUtils.instanceOf(r0, LayoutInflater.Factory2.class) == false) goto L7;
        r5 = (LayoutInflater.Factory2) ZeusTransformUtils.preCheckCast(r0, LayoutInflater.Factory2.class, "com.obric.memorydata.plugin");
    L7:
        forceSetFactory2(r3, r5);
        return;
    }
}
