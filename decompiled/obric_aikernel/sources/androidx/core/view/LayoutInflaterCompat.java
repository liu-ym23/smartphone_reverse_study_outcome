package androidx.core.view;

import android.content.Context;
import android.os.Build;
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

    static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        Factory2Wrapper(LayoutInflaterFactory r10) {
            this.mDelegateFactory = r10;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View r10, String r11, Context r12, AttributeSet r13) {
            return this.mDelegateFactory.onCreateView(r10, r11, r12, r13);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r10, Context r11, AttributeSet r12) {
            return this.mDelegateFactory.onCreateView(null, r10, r11, r12);
        }

        @NonNull
        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater r10, LayoutInflater.Factory2 r11) {
        if (sCheckedField == false) goto L17;
    L10:
        Field r12 = sLayoutInflaterFactory2Field;
        if (r12 == null) goto L21;
        r12.set(r10, r11);     // Catch: IllegalAccessException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + r10 + "; inflation may have unexpected results.", e);
        return;
    L21:
        return;
    L17:
        Field r13 = LayoutInflater.class.getDeclaredField("mFactory2");     // Catch: NoSuchFieldException -> L7
        sLayoutInflaterFactory2Field = r13;     // Catch: NoSuchFieldException -> L7
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sCheckedField = true;
    L7:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
        goto L9
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater r10) {
        LayoutInflater.Factory r11 = r10.getFactory();
        if ((r11 instanceof Factory2Wrapper) == true) goto L5;
        return null;
    L5:
        return ((Factory2Wrapper) r11).mDelegateFactory;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater r10, @NonNull LayoutInflaterFactory r11) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r10.setFactory2(new Factory2Wrapper(r11));
        return;
    L5:
        Factory2Wrapper r12 = new Factory2Wrapper(r11);
        r10.setFactory2(r12);
        LayoutInflater.Factory r13 = r10.getFactory();
        if ((r13 instanceof LayoutInflater.Factory2) == false) goto L8;
        forceSetFactory2(r10, (LayoutInflater.Factory2) r13);
        return;
    L8:
        forceSetFactory2(r10, r12);
    }

    public static void setFactory2(@NonNull LayoutInflater r10, @NonNull LayoutInflater.Factory2 r11) {
        r10.setFactory2(r11);
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        LayoutInflater.Factory r12 = r10.getFactory();
        if ((r12 instanceof LayoutInflater.Factory2) == false) goto L7;
        forceSetFactory2(r10, (LayoutInflater.Factory2) r12);
        return;
    L7:
        forceSetFactory2(r10, r11);
        return;
    }
}
