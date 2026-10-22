package k0;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.manager.RequestManagerFragment;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import java.util.HashMap;
import q0.i;
import ym.o;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Handler.Callback {
    public static final t9.a f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bumptech.glide.g f18575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f18576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f18577c;
    public final Handler d;
    public final t9.a e;

    static {
        f = new t9.a();
    }

    public f() {
        this.f18576b = new HashMap();
        this.f18577c = new HashMap();
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.e = f;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    public static Activity a(Context r5) {
        if ((r5 instanceof Activity) == false) goto L7;
        return (Activity) r5;
    L7:
        if ((r5 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return a(((ContextWrapper) r5).getBaseContext());
    }

    public static boolean e(Context r5) {
        Activity r10 = a(r5);
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isFinishing() == false) goto L8;
        return false;
    }

    public final com.bumptech.glide.g b(Context r5) {
        if (r5 == null) goto L60;
        char[] r10 = i.f21459a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L46;
        if ((r5 instanceof Application) == true) goto L46;
        boolean r11 = false;
        if ((r5 instanceof FragmentActivity) == false) goto L24;
        FragmentActivity r12 = (FragmentActivity) r5;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L12;
        r11 = true;
    L12:
        if (r11 == true) goto L15;
        return b(r12.getApplicationContext());
    L15:
        if (r12.isDestroyed() == true) goto L22;
        SupportRequestManagerFragment r13 = d(r12.getSupportFragmentManager(), e(r12));
        com.bumptech.glide.g r14 = r13.e;
        if (r14 != null) goto L20;
        com.bumptech.glide.b r15 = com.bumptech.glide.b.b(r12);
        zm.c r16 = r13.f1669b;
        this.e.getClass();
        com.bumptech.glide.g r17 = new com.bumptech.glide.g(r15, r13.f1668a, r16, r12);
        r13.e = r17;
        return r17;
    L20:
        return r14;
    L22:
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    L24:
        if ((r5 instanceof Activity) == false) goto L40;
        Activity r18 = (Activity) r5;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L28;
        r11 = true;
    L28:
        if (r11 == true) goto L31;
        return b(r18.getApplicationContext());
    L31:
        if (r18.isDestroyed() == true) goto L38;
        RequestManagerFragment r19 = c(r18.getFragmentManager(), e(r18));
        com.bumptech.glide.g r20 = r19.d;
        if (r20 != null) goto L36;
        com.bumptech.glide.b r21 = com.bumptech.glide.b.b(r18);
        o r22 = r19.f1666b;
        this.e.getClass();
        com.bumptech.glide.g r23 = new com.bumptech.glide.g(r21, r19.f1665a, r22, r18);
        r19.d = r23;
        return r23;
    L36:
        return r20;
    L38:
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    L40:
        if ((r5 instanceof ContextWrapper) == false) goto L46;
        ContextWrapper r24 = (ContextWrapper) r5;
        if (r24.getBaseContext().getApplicationContext() == null) goto L46;
        return b(r24.getBaseContext());
    L46:
        if (this.f18575a != null) goto L58;
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L49:
        if (this.f18575a != null) goto L53;
        com.bumptech.glide.b r25 = com.bumptech.glide.b.b(r5.getApplicationContext());     // Catch: Throwable -> L51
        t9.a r26 = this.e;     // Catch: Throwable -> L51
        r9.c r27 = new r9.c(11);     // Catch: Throwable -> L51
        sj.e r28 = new sj.e();     // Catch: Throwable -> L51
        Context r29 = r5.getApplicationContext();     // Catch: Throwable -> L51
        r26.getClass();     // Catch: Throwable -> L51
        this.f18575a = new com.bumptech.glide.g(r25, r27, r28, r29);     // Catch: Throwable -> L51
    L53:
        monitor-exit(this);     // Catch: Throwable -> L51
    L58:
        return this.f18575a;
    L60:
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final RequestManagerFragment c(FragmentManager r5, boolean r10) {
        RequestManagerFragment r11 = (RequestManagerFragment) r5.findFragmentByTag("com.bumptech.glide.manager");
        if (r11 != null) goto L12;
        HashMap r12 = this.f18576b;
        RequestManagerFragment r13 = (RequestManagerFragment) r12.get(r5);
        if (r13 != null) goto L11;
        r13 = new RequestManagerFragment();
        if (r10 == false) goto L9;
        r13.f1665a.g();
    L9:
        r12.put(r5, r13);
        r5.beginTransaction().add(r13, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(1, r5).sendToTarget();
    L11:
        return r13;
    L12:
        return r11;
    }

    public final SupportRequestManagerFragment d(androidx.fragment.app.FragmentManager r5, boolean r10) {
        SupportRequestManagerFragment r11 = (SupportRequestManagerFragment) r5.findFragmentByTag("com.bumptech.glide.manager");
        if (r11 != null) goto L12;
        HashMap r12 = this.f18577c;
        SupportRequestManagerFragment r13 = (SupportRequestManagerFragment) r12.get(r5);
        if (r13 != null) goto L11;
        r13 = new SupportRequestManagerFragment();
        if (r10 == false) goto L9;
        r13.f1668a.g();
    L9:
        r12.put(r5, r13);
        r5.beginTransaction().add(r13, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(2, r5).sendToTarget();
    L11:
        return r13;
    L12:
        return r11;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r5) {
        int r10 = r5.what;
        boolean r11 = true;
        if (r10 != 1) goto L5;
        Object r12 = (FragmentManager) r5.obj;
        Object r13 = this.f18576b.remove(r12);
    L9:
        if (r11 == false) goto L14;
        if (r13 != null) goto L14;
        if (Log.isLoggable("RMRetriever", 5) == false) goto L14;
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + r12);
    L14:
        return r11;
    L5:
        if (r10 == 2) goto L7;
        r13 = null;
        r11 = false;
        r12 = null;
        goto L9
    L7:
        r12 = (androidx.fragment.app.FragmentManager) r5.obj;
        r13 = this.f18577c.remove(r12);
        goto L9
    }
}
