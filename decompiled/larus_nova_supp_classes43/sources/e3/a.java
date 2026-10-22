package e3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.context.RefType;
import com.google.gson.JsonObject;
import d3.a0;
import d3.w;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements d {
    public final g a;
    public final Map<Class<?>, f<?>> b;
    public WeakReference<View> c;
    public final SparseArray<String> d;

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0153a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefType.values().length];
            r0[RefType.WEAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RefType.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // e3.d
    public final a0 getContainerContext() {
        return (a0) d(a0.class);
    }

    @Override // e3.d
    public final View getEngineView() {
        WeakReference<View> r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // e3.d
    public final Activity getOwnerActivity() {
        a0 r0 = (a0) d(a0.class);
        Context r1 = null;
        if (r0 == null) goto L5;
        ContainerType r10 = r0.getContainerType();
    L7:
        if (r10 != ContainerType.WORKER) goto L9;
        return null;
    L9:
        if (getEngineView() == null) goto L17;
        View r11 = getEngineView();
        if (r11 == null) goto L15;
        r1 = r11.getContext();
    L15:
        return getActivity(r1);
    L17:
        return null;
    L5:
        r10 = null;
        goto L7
    }

    @Override // e3.d
    public final g getJsEventDelegate() {
        return this.a;
    }

    public a(w.d r10) {
        Intrinsics.checkNotNullParameter(r10, "jsEventDelegate");
        this.a = r10;
        this.b = new ConcurrentHashMap();
        this.d = new SparseArray();
    }

    private final Activity getActivity(Context r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10 == null) goto L13;
        if ((r10 instanceof Activity) == true) goto L9;
        if ((r10 instanceof ContextWrapper) == false) goto L13;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L5
    L9:
        return (Activity) r10;
    L13:
        return null;
    }

    @Override // e3.d
    public final String c(int r10) {
        return this.d.get(r10);
    }

    @Override // e3.d
    public final <T> T d(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        f r11 = (f) ((ConcurrentHashMap) this.b).get(r10);
        if (r11 == null) goto L5;
        Object r12 = r11.provideInstance();
    L6:
        if (r12 != null) goto L9;
        return null;
    L9:
        return (T) r12;
    L5:
        r12 = null;
        goto L6
    }

    @Override // e3.d
    public final void a(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.a.b(r10, r11);
    }

    public final <T> void e(Class<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        b(r10, r11, RefType.NORMAL);
    }

    @Override // e3.d
    public final <T> void b(Class<T> r10, T r11, RefType r12) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r12, "refType");
        int r13 = C0153a.a[r12.ordinal()];
        if (r13 != 1) goto L5;
        Map<Class<?>, f<?>> r14 = this.b;
        ConcurrentHashMap r15 = (ConcurrentHashMap) r14;
        r15.put(r10, new h(r11));
        return;
    L5:
        if (r13 != 2) goto L8;
        Map<Class<?>, f<?>> r16 = this.b;
        ConcurrentHashMap r17 = (ConcurrentHashMap) r16;
        r17.put(r10, new c(r11));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
