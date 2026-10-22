package n1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.context.RefType;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import m1.f;
import m1.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f20195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f20196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f20197c;
    public final SparseArray d;

    public a(f r5) {
        Intrinsics.checkNotNullParameter(r5, "jsEventDelegate");
        this.f20195a = r5;
        this.f20196b = new ConcurrentHashMap();
        this.d = new SparseArray();
    }

    public final View a() {
        WeakReference r5 = this.f20197c;
        if (r5 != null) goto L5;
        return null;
    L5:
        return (View) r5.get();
    }

    public final Object b(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        b r10 = (b) this.f20196b.get(r5);
        if (r10 != null) goto L5;
        Object r11 = null;
    L12:
        if (r11 != null) goto L14;
        return null;
    L14:
        return r11;
    L5:
        switch(r10.f20198a) {
            case 0: goto L10;
            default: goto L6;
        };
    L6:
        WeakReference r12 = (WeakReference) r10.f20199b;
        if (r12 == null) goto L9;
        r11 = r12.get();
        goto L12
    L9:
        r11 = null;
        goto L12
    L10:
        r11 = r10.f20199b;
        goto L12
    }

    public final void c(Class r5, Object r10, RefType r11) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r11, "refType");
        int r12 = r11.ordinal();
        ConcurrentHashMap r13 = this.f20196b;
        if (r12 != 0) goto L5;
        b r14 = new b(0);
        r14.f20199b = r10;
        r13.put(r5, r14);
        return;
    L5:
        if (r12 != 1) goto L13;
        b r15 = new b(1);
        if (r10 != null) goto L9;
        WeakReference r16 = null;
    L10:
        r15.f20199b = r16;
        r13.put(r5, r15);
        return;
    L9:
        r16 = new WeakReference(r10);
        goto L10
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final Activity d() {
        j r5 = (j) b(j.class);
        if (r5 == null) goto L5;
        ContainerType r10 = r5.d();
    L7:
        if (r10 != ContainerType.d) goto L9;
    L25:
        return null;
    L9:
        if (a() == null) goto L25;
        View r11 = a();
        if (r11 == null) goto L14;
        Context r12 = r11.getContext();
    L15:
        if (r12 != null) goto L17;
        return null;
    L17:
        if (r12 == null) goto L25;
        if ((r12 instanceof Activity) == true) goto L21;
        if ((r12 instanceof ContextWrapper) == false) goto L25;
        r12 = ((ContextWrapper) r12).getBaseContext();
        goto L17
    L21:
        return (Activity) r12;
    L14:
        r12 = null;
        goto L15
    L5:
        r10 = null;
        goto L7
    }
}
