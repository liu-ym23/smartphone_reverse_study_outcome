package com.obric.cae.utils.bridge;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/obric/cae/utils/bridge/PythonBridgeRegistry;", "", "", "module", TypedValues.AttributesType.S_TARGET, "", "register", "", "unregister", "find", "<init>", "()V", "CommSenseAAR_release"}, k = 1, mv = {1, 8, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f7364b = null;
    public static final Regex c = null;

    static {
        f7363a = new a();
        f7364b = new ConcurrentHashMap();
        c = new Regex("[A-Za-z0-9_.-]{1,64}");
    }

    public a() {
    }

    public final Object a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "module");
        return f7364b.get(r1);
    }

    public final void a(String r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "module");
        Intrinsics.checkNotNullParameter(r8, TypedValues.AttributesType.S_TARGET);
        if (c.matches(r7) == false) goto L30;
        Method[] r6 = r8.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(r6, "target.javaClass.methods");
        int r0 = r6.length;
        boolean r1 = false;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L16;
        Method r4 = r6[r2];
        if (Modifier.isPublic(r4.getModifiers()) == true) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == true) goto L14;
        r2 = r2 + 1;
        goto L6
    L14:
        boolean r9 = true;
    L18:
        if (r9 == false) goto L28;
        Object r10 = f7364b.putIfAbsent(r7, r8);
        if (r10 == null) goto L22;
        if (r10 == r8) goto L22;
    L23:
        if (r1 == false) goto L26;
        return;
    L26:
        throw new IllegalArgumentException(("Bridge module " + r7 + " is already registered").toString());
    L22:
        r1 = true;
        goto L23
    L28:
        throw new IllegalArgumentException(("Bridge module " + r7 + " does not expose any @PythonBridgeMethod").toString());
    L10:
        if (r4.isAnnotationPresent(PythonBridgeMethod.class) == false) goto L12;
        r5 = true;
        goto L13
    L16:
        r9 = false;
        goto L18
    L30:
        throw new IllegalArgumentException("Invalid bridge module name".toString());
    }

    public final boolean b(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "module");
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        return f7364b.remove(r1, r2);
    }
}
