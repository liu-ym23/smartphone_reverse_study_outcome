package io.reactivex.internal.observers;

import ai.j0;
import android.net.Uri;
import android.text.TextUtils;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.j;
import com.squareup.kotlinpoet.z;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mt.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h implements u {
    public static volatile boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f17638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.observers.d f17639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.reactivex.internal.queue.a f17640c;
    public volatile boolean d;
    public volatile boolean e;
    public Throwable f;

    public h(io.reactivex.observers.d r5, io.reactivex.internal.queue.a r10) {
        this.f17638a = new AtomicInteger();
        this.f17639b = r5;
        this.f17640c = r10;
    }

    public static com.bytedance.pia.core.setting.a a(Uri r5) {
        com.bytedance.pia.core.setting.a r10 = com.bytedance.pia.core.setting.a.f;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.getBooleanQueryParameter("_pia_", false) == false) goto L8;
    L10:
        Lazy r11 = Settings.B;
        if (Settings.D == false) goto L13;
    L14:
        com.bytedance.pia.core.setting.b.f7084a.a(r5);
        boolean r12 = com.bytedance.pia.core.setting.d.f7088a;
        System.currentTimeMillis();
        if (r5.getBooleanQueryParameter("_pia_", false) == false) goto L22;
        String r13 = j.k(r5, null);
        if (CollectionsKt.contains(com.bytedance.pia.core.setting.d.f7090c, r13) == true) goto L20;
        return null;
    L20:
        return new com.bytedance.pia.core.setting.a(SetsKt.setOf(new String[]{"nsr", "prefetch", "snapshot", "cache"}), 14);
    L22:
        return null;
    L13:
        return com.bytedance.pia.core.setting.a.g;
    L8:
        if (r5.getBooleanQueryParameter("__pia_manifest__", false) == false) goto L10;
        goto L10
    }

    public static String b(String r5, String r10) {
        return j0.j(r5, r10);
    }

    public static void c(z8.c r10, Header r11, CrashType r12) {
        JSONObject r13 = r10.f23416a;
        if (r13 == null) goto L19;
        if (r12 == null) goto L23;
        long r5 = r13.optLong("crash_time");
        String r14 = n.g().e();
        if (r5 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r12.getName()) == true) goto L21;
        String r15 = "android__" + r14 + "_" + r5 + "_" + r12;     // Catch: JSONException -> L14
        JSONObject r16 = r11.f4029a;     // Catch: JSONException -> L14
        if (r16 == null) goto L22;
        r16.put("unique_key", r15);     // Catch: JSONException -> L14
        return;
    L22:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    L23:
        return;
    }

    public static boolean e(String r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        if (r5.trim().length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static void f(String r5, boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r5);
    }

    public static void g(Object r5) {
        h(r5, "Argument must not be null");
    }

    public static void h(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10);
    }

    public static com.squareup.kotlinpoet.u o(ParameterizedType r10, LinkedHashMap r11) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "map");
        Type r5 = r10.getRawType();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.Class<*>");
        com.squareup.kotlinpoet.c r12 = mh.e.r((Class) r5);
        com.squareup.kotlinpoet.u r13 = null;
        if ((r10.getOwnerType() instanceof ParameterizedType) == false) goto L7;
        Type r14 = r10.getRawType();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.Class<*>");
        if (Modifier.isStatic(((Class) r14).getModifiers()) == true) goto L7;
        Type r15 = r10.getOwnerType();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        ParameterizedType r16 = (ParameterizedType) r15;
    L8:
        Type[] r17 = r10.getActualTypeArguments();
        ArrayList r18 = new ArrayList(r17.length);
        int r19 = r17.length;
        int r20 = 0;
    L9:
        if (r20 >= r19) goto L11;
        r18.add(z.a(r17[r20], r11));
        r20 = r20 + 1;
        goto L9
    L11:
        if (r16 == null) goto L14;
        com.squareup.kotlinpoet.u r21 = o(r16, r11);
        String r22 = r12.e();
        Intrinsics.checkNotNullParameter(r22, "name");
        Intrinsics.checkNotNullParameter(r18, "typeArguments");
        return new com.squareup.kotlinpoet.u(r21, r21.f.f(r22), r18);
    L14:
        return new com.squareup.kotlinpoet.u(r13, r12, r18);
    L7:
        r16 = null;
        goto L8
    }

    public static av.c r(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r5 = r10.length();
        String r11 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        if (r5 <= 5) goto L22;
        if (r10.substring(0, 6).toLowerCase().equals("backup") == false) goto L22;
        Matcher r12 = av.a.f782c.matcher(r10);
        if (r12.matches() == false) goto L20;
        String r13 = s(r12.group(2));
        String r14 = s(r12.group(3));
        if (r13 == null) goto L18;
        if (r13.length() == 0) goto L18;
        r11 = r13;
    L18:
        return new av.a(r11, r14);
    L20:
        throw new SQLException("syntax error: ".concat(r10));
    L22:
        if (r10.length() > 6) goto L24;
    L37:
        return null;
    L24:
        if (r10.substring(0, 7).toLowerCase().equals("restore") == false) goto L37;
        Matcher r15 = av.b.f785c.matcher(r10);
        if (r15.matches() == false) goto L36;
        String r16 = s(r15.group(2));
        String r17 = s(r15.group(3));
        if (r16 == null) goto L34;
        if (r16.length() == 0) goto L34;
        r11 = r16;
    L34:
        return new av.b(r11, r17);
    L36:
        throw new SQLException("syntax error: ".concat(r10));
    }

    public static String s(String r5) {
        if (r5 != null) goto L5;
        return r5;
    L5:
        if (r5.startsWith("\"") == false) goto L9;
        if (r5.endsWith("\"") == false) goto L9;
    L13:
        return androidx.constraintlayout.motion.widget.a.n(r5, 1, 1);
    L9:
        if (r5.startsWith("'") == true) goto L11;
        return r5;
    L11:
        if (r5.endsWith("'") == true) goto L13;
        return r5;
    }

    public void d(io.reactivex.observers.d r5, Object r10) {
    }

    public final boolean i() {
        if (this.f17638a.getAndIncrement() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean j() {
        AtomicInteger r5 = this.f17638a;
        if (r5.get() == 0) goto L5;
        return false;
    L5:
        if (r5.compareAndSet(0, 1) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final void k(Object r10, Disposable r11) {
        AtomicInteger r5 = this.f17638a;
        int r12 = r5.get();
        io.reactivex.observers.d r13 = this.f17639b;
        io.reactivex.internal.queue.a r14 = this.f17640c;
        if (r12 == 0) goto L5;
    L9:
        r14.offer(r10);
        if (i() == true) goto L12;
        return;
    L12:
        com.lynx.tasm.behavior.utils.d.k(r14, r13, r11, this);
        return;
    L5:
        if (r5.compareAndSet(0, 1) == false) goto L9;
        d(r13, r10);
        if (r5.addAndGet(-1) != 0) goto L12;
    }

    public final void l(Object r10, Disposable r11) {
        AtomicInteger r5 = this.f17638a;
        int r12 = r5.get();
        io.reactivex.observers.d r13 = this.f17639b;
        io.reactivex.internal.queue.a r14 = this.f17640c;
        if (r12 == 0) goto L5;
    L12:
        r14.offer(r10);
        if (i() == true) goto L15;
        return;
    L15:
        com.lynx.tasm.behavior.utils.d.k(r14, r13, r11, this);
        return;
    L5:
        if (r5.compareAndSet(0, 1) == false) goto L12;
        if (r14.isEmpty() == false) goto L11;
        d(r13, r10);
        if (r5.addAndGet(-1) != 0) goto L15;
        return;
    L11:
        r14.offer(r10);
        goto L15
    }
}
