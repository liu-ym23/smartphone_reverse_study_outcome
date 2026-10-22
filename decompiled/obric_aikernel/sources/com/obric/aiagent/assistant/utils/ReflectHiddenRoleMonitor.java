package com.obric.aiagent.assistant.utils;

import android.annotation.SuppressLint;
import android.app.role.RoleManager;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"LongLogTag"})
public final class ReflectHiddenRoleMonitor {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f4362j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f4363k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile ReflectHiddenRoleMonitor f4364l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f4366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f4367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f4368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f4369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f4370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f4371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f4373i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final ReflectHiddenRoleMonitor a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            ReflectHiddenRoleMonitor r11 = ReflectHiddenRoleMonitor.d();
            if (r11 != null) goto L13;
            monitor-enter(this);
            r11 = ReflectHiddenRoleMonitor.d();     // Catch: Throwable -> L10
            if (r11 != null) goto L8;
            Context r12 = r10.getApplicationContext();     // Catch: Throwable -> L10
            Intrinsics.checkNotNullExpressionValue(r12, "context.applicationContext");     // Catch: Throwable -> L10
            r11 = new ReflectHiddenRoleMonitor(r12, null);     // Catch: Throwable -> L10
            a r13 = ReflectHiddenRoleMonitor.f4362j;     // Catch: Throwable -> L10
            ReflectHiddenRoleMonitor.e(r11);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r11;
        }
    }

    static {
        f4362j = new a(null);
        f4363k = "android.permission.MANAGE_ROLE_HOLDERS";
    }

    private ReflectHiddenRoleMonitor(Context r10) {
        this.f4365a = r10;
        this.f4366b = LazyKt.lazy(new ReflectHiddenRoleMonitor$roleManager$2(this));
        this.f4367c = LazyKt.lazy(ReflectHiddenRoleMonitor$roleChangeListenerClass$2.INSTANCE);
        this.f4369e = LazyKt.lazy(new ReflectHiddenRoleMonitor$mainUserHandle$2(this));
        this.f4370f = LazyKt.lazy(new ReflectHiddenRoleMonitor$mainExecutor$2(this));
    }

    public /* synthetic */ ReflectHiddenRoleMonitor(Context r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static /* synthetic */ Object a(int r10, ReflectHiddenRoleMonitor r11, Object r12, Method r13, Object[] r14) {
        return g(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ UserHandle b(ReflectHiddenRoleMonitor r10, int r11) {
        return r10.h(r11);
    }

    public static final /* synthetic */ Context c(ReflectHiddenRoleMonitor r10) {
        return r10.f4365a;
    }

    public static final /* synthetic */ ReflectHiddenRoleMonitor d() {
        return f4364l;
    }

    public static final /* synthetic */ void e(ReflectHiddenRoleMonitor r10) {
        f4364l = r10;
    }

    @RequiresApi(29)
    private final void f(Class<?> r10) {
        final int r11 = System.identityHashCode(this);
        InvocationHandler r12 = new c(r11, this);
        this.f4368d = Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, r12);
        Log.d("ReflectHiddenRoleMonitor", "Dynamic proxy instance created successfully");
    }

    private static final Object g(int r10, ReflectHiddenRoleMonitor r11, Object r12, Method r13, Object[] r14) {
        Intrinsics.checkNotNullParameter(r11, "this$0");
        String r15 = r13.getName();
        String r16 = r13.getDeclaringClass().getName();
        if (Intrinsics.areEqual(r15, "hashCode") == true) goto L5;
    L8:
        boolean r17 = true;
        if (Intrinsics.areEqual(r15, "equals") == false) goto L22;
        if (Intrinsics.areEqual(r16, "java.lang.Object") == false) goto L22;
        if (r14 == null) goto L22;
        if (r14.length != 1) goto L22;
        if (r12 == r14[0]) goto L19;
        r17 = false;
    L19:
        Log.d("ReflectHiddenRoleMonitor", "Proxy calls equals(), return: " + r17);
        return Boolean.valueOf(r17);
    L22:
        if (Intrinsics.areEqual(r15, "toString") == false) goto L28;
        if (Intrinsics.areEqual(r16, "java.lang.Object") == false) goto L28;
        String r18 = "OnRoleHoldersChangedListenerProxy@" + r10;
        Log.d("ReflectHiddenRoleMonitor", "Proxy calls toString(), return: " + r18);
        return r18;
    L28:
        if (Intrinsics.areEqual(r15, "onRoleHoldersChanged") == false) goto L53;
        if (r14 == null) goto L53;
        Object r19 = ArraysKt.getOrNull(r14, 0);     // Catch: Exception -> L50
        if ((r19 instanceof String) == false) goto L33;
        String r20 = (String) r19;     // Catch: Exception -> L50
    L34:
        if (r20 != null) goto L36;
        return null;
    L36:
        Object r110 = ArraysKt.getOrNull(r14, 1);     // Catch: Exception -> L50
        if ((r110 instanceof UserHandle) == false) goto L39;
        UserHandle r111 = (UserHandle) r110;     // Catch: Exception -> L50
    L40:
        if (r111 != null) goto L42;
        return null;
    L42:
        Log.d("ReflectHiddenRoleMonitor", "onRoleHoldersChanged: role=" + r20 + "，holders=" + r111);     // Catch: Exception -> L50
        if (Intrinsics.areEqual(r20, "android.app.role.ASSISTANT") == true) goto L45;
    L52:
        return null;
    L45:
        if (r11.f4372h == false) goto L52;
        if (r11.f4371g == null) goto L52;
        r11.n();     // Catch: Exception -> L50
        goto L52
    L39:
        r111 = null;
        goto L40
    L33:
        r20 = null;
    L50:
        e = move-exception;
        Log.e("ReflectHiddenRoleMonitor", "Exception occurred while handling onRoleHoldersChanged", e);
    L53:
        Log.w("ReflectHiddenRoleMonitor", "Proxy calls unhandled method: " + r15);
        String r21 = r13.getReturnType().getName();
        switch(r21.hashCode()) {
            case 104431: goto L69;
            case 3327612: goto L65;
            case 64711720: goto L61;
            case 1195259493: goto L57;
            default: goto L78;
        };
    L78:
        return null;
    L57:
        if (r21.equals("java.lang.String") == false) goto L79;
        return "";
    L79:
        return null;
    L61:
        if (r21.equals(TypedValues.Custom.S_BOOLEAN) == true) goto L76;
        return null;
    L76:
        return Boolean.FALSE;
    L65:
        if (r21.equals("long") == true) goto L77;
        return null;
    L77:
        return 0L;
    L69:
        if (r21.equals("int") == true) goto L72;
        return null;
    L72:
        return 0;
    L5:
        if (Intrinsics.areEqual(r16, "java.lang.Object") == false) goto L8;
        Log.d("ReflectHiddenRoleMonitor", "Proxy calls hashCode(), return: " + r10);
        return Integer.valueOf(r10);
    }

    private final UserHandle h(int r10) {
        Method r11 = UserHandle.class.getMethod("of", new Class[]{Integer.TYPE});     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L16 NoSuchMethodException -> L18 ClassNotFoundException -> L20
        r11.setAccessible(true);     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L16 NoSuchMethodException -> L18 ClassNotFoundException -> L20
        Object r12 = r11.invoke(null, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L16 NoSuchMethodException -> L18 ClassNotFoundException -> L20
        if ((r12 instanceof UserHandle) == false) goto L6;
        UserHandle r13 = (UserHandle) r12;     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L16 NoSuchMethodException -> L18 ClassNotFoundException -> L20
    L7:
        Log.d("ReflectHiddenRoleMonitor", "Successfully created UserHandle instance (userId=" + r10 + ')');     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L16 NoSuchMethodException -> L18 ClassNotFoundException -> L20
    L26:
        return r13;
    L6:
        r13 = null;
    L20:
        e = move-exception;
        StringBuilder r14 = new StringBuilder();
        r14.append("Could not find UserHandle class: ");
        String r15 = e.getMessage();
        Throwable r16 = e;
    L22:
        r14.append(r15);
        Log.e("ReflectHiddenRoleMonitor", r14.toString(), r16);
        return null;
    L16:
        e = move-exception;
        r14 = new StringBuilder();
        r14.append("Failed to access UserHandle.of method: ");
        r15 = e.getMessage();
        r16 = e;
    L18:
        e = move-exception;
        r14 = new StringBuilder();
        r14.append("Could not find UserHandle.of(int) method: ");
        r15 = e.getMessage();
        r16 = e;
    L11:
        e = move-exception;
        r14 = new StringBuilder();
        r14.append("Failed to invoke UserHandle.of method: ");
        Throwable r17 = e.getCause();
        if (r17 == null) goto L15;
        r15 = r17.getMessage();
        r16 = e;
        goto L22
    L15:
        r15 = null;
        r16 = e;
    L9:
        e = move-exception;
        r14 = new StringBuilder();
        r14.append("Failed to create UserHandle via reflection: ");
        r15 = e.getMessage();
        r16 = e;
        goto L22
    }

    @RequiresApi(29)
    private final String i() {
        RoleManager r10 = m();
        if (r10 != null) goto L18;
        return null;
    L18:
    L15:
        e = move-exception;
        Log.e("ReflectHiddenRoleMonitor", "get default assistant pkg fail", e);
        return null;
    L6:
        if (o() == true) goto L8;
        return null;
    L8:
        Method r11 = r10.getClass().getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L15
        r11.setAccessible(true);     // Catch: Exception -> L15
        Object r12 = r11.invoke(r10, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L15
        if ((r12 instanceof List) == false) goto L11;
        List r13 = (List) r12;     // Catch: Exception -> L15
    L12:
        if (r13 == null) goto L20;
        return (String) CollectionsKt.getOrNull(r13, 0);
    L20:
        return null;
    L11:
        r13 = null;
        goto L12
    }

    private final Executor j() {
        return (Executor) this.f4370f.getValue();
    }

    private final UserHandle k() {
        return (UserHandle) this.f4369e.getValue();
    }

    private final Class<?> l() {
        return (Class) this.f4367c.getValue();
    }

    private final RoleManager m() {
        return (RoleManager) this.f4366b.getValue();
    }

    @RequiresApi(29)
    private final void n() {
        String r10 = i();
        boolean r11 = true;
        String r12 = this.f4373i;
        if (r10 != null) goto L7;
        if (r12 != null) goto L10;
    L9:
        r11 = false;
    L10:
        if (r11 == false) goto L16;
        Log.d("ReflectHiddenRoleMonitor", "default assistant changed：" + this.f4373i + " → " + r10);
        b r13 = this.f4371g;
        if (r13 == null) goto L14;
        r13.a(this.f4373i, r10);
    L14:
        this.f4373i = r10;
        return;
    L16:
        return;
    L7:
        if (Intrinsics.areEqual(r10, r12) == true) goto L9;
        goto L9
    }

    @RequiresApi(23)
    private final boolean o() {
        if (this.f4365a.checkSelfPermission(f4363k) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(23)
    private final boolean p() {
        if (this.f4365a.checkSelfPermission("android.permission.OBSERVE_ROLE_HOLDERS") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void q(b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        RoleManager r11 = m();
        if (r11 != null) goto L7;
        String r12 = "RoleManager instance is null (SDK version < 33)";
    L5:
        Log.w("ReflectHiddenRoleMonitor", r12);
        return;
    L7:
        Class<?> r13 = l();
        if (r13 != null) goto L11;
        r12 = "Hidden listener interface Class is null";
        goto L5
    L11:
        if (Build.VERSION.SDK_INT >= 33) goto L13;
    L35:
        r12 = "cannot starting listening";
        goto L5
    L13:
        if (p() == false) goto L35;
        if (this.f4372h == true) goto L35;
        this.f4371g = r10;
        f(r13);     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        Object r14 = this.f4368d;     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        if (r14 == null) goto L21;
        Method r15 = r11.getClass().getMethod("addOnRoleHoldersChangedListenerAsUser", (Class[]) Arrays.copyOf(new Class[]{Executor.class, r13, UserHandle.class}, 3));     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        r15.setAccessible(true);     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        r15.invoke(r11, new Object[]{j(), r14, k()});     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        this.f4372h = true;     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        this.f4373i = i();     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        Log.d("ReflectHiddenRoleMonitor", "Listening started successfully (reflected UserHandle, main user ID=0)");     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        return;
    L21:
        throw new IllegalStateException("Proxy Instance is null");     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
    L30:
        e = move-exception;
        Log.e("ReflectHiddenRoleMonitor", "Failed to access hidden method addOnRoleHoldersChangedListenerAsUser", e);
        e.printStackTrace();
        return;
    L32:
        e = move-exception;
        Log.e("ReflectHiddenRoleMonitor", "Method addOnRoleHoldersChangedListenerAsUser not found (parameter signature mismatch)", e);
        e.printStackTrace();
        return;
    L24:
        e = move-exception;
        StringBuilder r16 = new StringBuilder();
        r16.append("Failed to invoke method: ");
        Throwable r17 = e.getCause();
        if (r17 == null) goto L28;
        String r18 = r17.getMessage();
    L29:
        r16.append(r18);
        Log.e("ReflectHiddenRoleMonitor", r16.toString(), e);
        e.printStackTrace();
        return;
    L28:
        r18 = null;
    L22:
        e = move-exception;
        Log.e("ReflectHiddenRoleMonitor", "Exception while starting listening", e);
        e.printStackTrace();
    }
}
