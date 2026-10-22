package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f665b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f666c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f667d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n.h<String, Constructor<? extends View>> f668e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f669a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f671b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Method f672m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Context f673n;

        public a(View r8, String r10) {
            this.f670a = r8;
            this.f671b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            if (this.f672m != null) goto L34;
            View r10 = this.f670a;
            Context r11 = r10.getContext();
        L5:
            String r12 = this.f671b;
            if (r11 == null) goto L17;
            if (r11.isRestricted() == true) goto L14;
            Method r13 = r11.getClass().getMethod(r12, new Class[]{View.class});     // Catch: NoSuchMethodException -> L31
            if (r13 == null) goto L14;
            this.f672m = r13;     // Catch: NoSuchMethodException -> L31
            this.f673n = r11;     // Catch: NoSuchMethodException -> L31
        L14:
            if ((r11 instanceof ContextWrapper) == true) goto L15;
            r11 = null;
            goto L5
        L15:
            r11 = ((ContextWrapper) r11).getBaseContext();
            goto L5
        L17:
            int r14 = r10.getId();
            if (r14 != (-1)) goto L20;
            String r15 = "";
        L21:
            StringBuilder r16 = defpackage.b.h("Could not find method ", r12, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
            r16.append(r10.getClass());
            r16.append(r15);
            throw new IllegalStateException(r16.toString());
        L20:
            r15 = " with id '" + r10.getContext().getResources().getResourceEntryName(r14) + "'";
        L34:
            this.f672m.invoke(this.f673n, new Object[]{r8});     // Catch: InvocationTargetException -> L25 IllegalAccessException -> L28
            return;
        L28:
            e = move-exception;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        L25:
            e = move-exception;
            throw new IllegalStateException("Could not execute method for android:onClick", e);
        }
    }

    static {
        f665b = new Class[]{Context.class, AttributeSet.class};
        f666c = new int[]{R.attr.onClick};
        f667d = new String[]{"android.widget.", "android.view.", "android.webkit."};
        f668e = new n.h();
    }

    public p() {
        this.f669a = new Object[2];
    }

    public androidx.appcompat.widget.c a(Context r8, AttributeSet r10) {
        return new androidx.appcompat.widget.c(r8, r10);
    }

    public androidx.appcompat.widget.e b(Context r8, AttributeSet r10) {
        return new androidx.appcompat.widget.e(r8, r10);
    }

    public androidx.appcompat.widget.f c(Context r8, AttributeSet r10) {
        return new androidx.appcompat.widget.f(r8, r10);
    }

    public androidx.appcompat.widget.r d(Context r8, AttributeSet r10) {
        return new androidx.appcompat.widget.r(r8, r10);
    }

    public y e(Context r8, AttributeSet r10) {
        return new y(r8, r10);
    }

    public final View f(Context r8, String r10, String r11) {
        n.h<String, Constructor<? extends View>> r12 = f668e;
        Constructor<? extends View> r13 = r12.getOrDefault(r10, null);
        if (r13 != null) goto L8;
        if (r11 != null) goto L11;
        String r14 = r10;
    L7:
        r13 = Class.forName(r14, false, r8.getClassLoader()).asSubclass(View.class).getConstructor(f665b);     // Catch: Exception -> L10
        r12.put(r10, r13);     // Catch: Exception -> L10
        goto L8
    L11:
        r14 = r11.concat(r10);     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r13.setAccessible(true);     // Catch: Exception -> L10
        return r13.newInstance(this.f669a);
    }
}
