package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    public static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        public Factory2Wrapper(LayoutInflaterFactory r5) {
            this.mDelegateFactory = r5;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r5, Context r10, AttributeSet r11) {
            return this.mDelegateFactory.onCreateView(null, r5, r10, r11);
        }

        @NonNull
        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View r5, String r10, Context r11, AttributeSet r12) {
            return this.mDelegateFactory.onCreateView(r5, r10, r11, r12);
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater r10, LayoutInflater.Factory2 r11) {
        if (sCheckedField == false) goto L17;
    L10:
        Field r5 = sLayoutInflaterFactory2Field;
        if (r5 == null) goto L21;
        r5.set(r10, r11);     // Catch: IllegalAccessException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + r10 + "; inflation may have unexpected results.", e);
        return;
    L21:
        return;
    L17:
        Field r12 = LayoutInflater.class.getDeclaredField("mFactory2");     // Catch: NoSuchFieldException -> L7
        sLayoutInflaterFactory2Field = r12;     // Catch: NoSuchFieldException -> L7
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sCheckedField = true;
    L7:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
        goto L9
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater r5) {
        LayoutInflater.Factory r10 = r5.getFactory();
        if ((r10 instanceof Factory2Wrapper) == true) goto L5;
        return null;
    L5:
        return ((Factory2Wrapper) r10).mDelegateFactory;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater r5, @NonNull LayoutInflaterFactory r10) {
        r5.setFactory2(new Factory2Wrapper(r10));
    }

    public static void setFactory2(@NonNull LayoutInflater r5, @NonNull LayoutInflater.Factory2 r10) {
        r5.setFactory2(r10);
    }
}
