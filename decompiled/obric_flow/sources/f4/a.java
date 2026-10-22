package f4;

import ai.j0;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.bytedance.android.anniex.scene.core.i;
import com.lynx.tasm.utils.j;
import dj.d;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.g;
import org.json.JSONObject;
import rd.c;
import ym.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16877a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
    public static Class a(Class r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Class<?>[] r5 = r10.getDeclaredClasses();
        ?? r11 = new ArrayList();
        int r12 = r5.length;
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L10;
        Class<?> r15 = r5[r14];
        if (r15.getAnnotation(d.class) == null) goto L8;
        r11.add(r15);
    L8:
        r14 = r14 + 1;
        goto L4
    L10:
        if (r11.isEmpty() == false) goto L23;
        Class r16 = r10.getSuperclass();
        if (r16 == null) goto L21;
        Class<?>[] r17 = r16.getDeclaredClasses();
        if (r17 == null) goto L21;
        r11 = new ArrayList();
        int r18 = r17.length;
    L16:
        if (r13 >= r18) goto L23;
        Class<?> r19 = r17[r13];
        if (r19.getAnnotation(d.class) == null) goto L20;
        r11.add(r19);
    L20:
        r13 = r13 + 1;
    L21:
        r11 = CollectionsKt.emptyList();
    L23:
        if (r11.isEmpty() == false) goto L26;
        return null;
    L26:
        Object r20 = CollectionsKt.first(r11);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type java.lang.Class<out com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel>");
        return (Class) r20;
    }

    public static String b(StringBuilder r5, int r10, String r11) {
        r5.append(r10);
        r5.append(r11);
        String r12 = r5.toString();
        Intrinsics.checkNotNullParameter("WidgetResourceLoader", "tag");
        return r12;
    }

    public static final boolean c(byte[] r5, byte[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        if (r5[r14 + r11] != r10[r14 + r12]) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final void d(long r5, long r10, long r11) {
        if ((r10 | r11) >= 0) goto L5;
    L9:
        StringBuilder r12 = j0.t(r5, "size=", " offset=");
        r12.append(r10);
        r12.append(" byteCount=");
        r12.append(r11);
        throw new ArrayIndexOutOfBoundsException(r12.toString());
    L5:
        if (r10 > r5) goto L9;
        if ((r5 - r10) < r11) goto L9;
    }

    public static int e(int r5) {
        int r10 = (r5 & (~(r5 >> 31))) - 255;
        return (r10 & (r10 >> 31)) + 255;
    }

    public static /* synthetic */ Object f(eu.a r5, g r10, int r11, kotlinx.serialization.b r12) {
        return r5.y(r10, r11, r12, null);
    }

    public static long g(byte r5, byte r10, byte r11, byte r12, byte r13, byte r14, byte r15, byte r16) {
        long r17 = (((long) r5) & 255) << 56;
        return ((((((((((long) r10) & 255) << 48) | r17) | ((((long) r11) & 255) << 40)) | ((((long) r12) & 255) << 32)) | ((((long) r13) & 255) << 24)) | ((((long) r14) & 255) << 16)) | ((((long) r15) & 255) << 8)) | (((long) r16) & 255);
    }

    public static float[] h(float r5, float r10, float r11, float r12) {
        float r13 = (r5 / 2.0f) + 0.5f;
        float r14 = r12 + 0.0f;
        float r15 = 1.0f - (r11 / 2.0f);
        float r16 = 1.0f - r10;
        return new float[]{-1.0f, -1.0f, 0.0f, r13, r14, 1.0f, -1.0f, 0.0f, r15, r14, -1.0f, 1.0f, 0.0f, r13, r16, 1.0f, 1.0f, 0.0f, r15, r16};
    }

    public static String i(Context r10) {
        if (f16877a != null) goto L23;
        String r5 = j.f11180b;
        if (TextUtils.isEmpty(r5) == true) goto L31;
    L21:
        String r11 = r5.replace(r10.getPackageName(), LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME).replace(":", "_");
        f16877a = r11;
        f16877a = r11.replace(".", "_");
        goto L23
    L31:
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L25
    L10:
        int r14 = r12.read();     // Catch: Throwable -> L25
        if (r14 <= 0) goto L13;
        r13.append((char) r14);     // Catch: Throwable -> L25
        goto L10
    L13:
        r5 = r13.toString();     // Catch: Throwable -> L25
        r12.close();     // Catch: Exception -> L24
    L20:
        j.f11180b = r5;
    L17:
        if (r12 != null) goto L29;
    L19:
        r5 = null;
        goto L20
    L29:
        r12.close();     // Catch: Exception -> L26
    L16:
        r12 = null;
    L23:
        return f16877a;
    }

    public static float[] j(float r5, float r10, float r11, float r12) {
        float r13 = (r5 * 2.0f) - 1.0f;
        float r14 = (r12 * 2.0f) - 1.0f;
        float r15 = 1.0f - (r11 * 2.0f);
        float r16 = 1.0f - (r10 * 2.0f);
        return new float[]{r13, r14, 0.0f, 0.5f, 0.0f, r15, r14, 0.0f, 1.0f, 0.0f, r13, r16, 0.0f, 0.5f, 1.0f, r15, r16, 0.0f, 1.0f, 1.0f};
    }

    public static void k(String r5, String r10, JSONObject r11) {
        z6.b.f23409a.d(new i(22, r5, r11, r10));
    }

    public static final int l(int r5) {
        int r10 = ((((-16777216) & r5) >>> 24) | ((16711680 & r5) >>> 8)) | ((65280 & r5) << 8);
        return ((r5 & 255) << 24) | r10;
    }

    public static final long m(long r10) {
        long r5 = ((((((((-72057594037927936L) & r10) >>> 56) | ((71776119061217280L & r10) >>> 40)) | ((280375465082880L & r10) >>> 24)) | ((1095216660480L & r10) >>> 8)) | ((4278190080L & r10) << 8)) | ((16711680 & r10) << 24)) | ((65280 & r10) << 40);
        return ((r10 & 255) << 56) | r5;
    }

    public static void n(lr.b r16, View r17, float[] r18) {
        Class<?> r10 = r17.getClass();
        String r11 = "set" + r16.f19696b;
        boolean r12 = true;
        switch(jr.a.f18430a[r16.f19697c.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L30;
        };     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L6:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L13:
        Method r5 = r10.getMethod(r11, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        if (r18[0] > 0.5f) goto L17;
        r12 = false;
    L17:
        r5.invoke(r17, new Object[]{Boolean.valueOf(r12)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L20:
        Method r13 = r10.getMethod(r11, new Class[]{Integer.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r14 = e((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r15 = e((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r13.invoke(r17, new Object[]{Integer.valueOf((((r14 << 16) | (e((int) (r18[3] * 255.0f)) << 24)) | (r15 << 8)) | e((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L21:
        Method r19 = r10.getMethod(r11, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r20 = e((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r21 = e((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r22 = (((r20 << 16) | (e((int) (r18[3] * 255.0f)) << 24)) | (r21 << 8)) | e((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        ColorDrawable r23 = new ColorDrawable();     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r23.setColor(r22);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r19.invoke(r17, new Object[]{r23});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L22:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L23:
        r10.getMethod(r11, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((int) r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L30:
        return;
    L19:
        throw new RuntimeException("unable to interpolate strings " + r16.f19696b);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L9:
        e = move-exception;
        StringBuilder r24 = j0.x("Cannot access method ", r11, " on View \"");
        r24.append(k.h(r17));
        r24.append("\"");
        Log.e("CustomSupport", r24.toString(), e);
        return;
    L11:
        e = move-exception;
        StringBuilder r25 = j0.x("No method ", r11, " on View \"");
        r25.append(k.h(r17));
        r25.append("\"");
        Log.e("CustomSupport", r25.toString(), e);
        return;
    L7:
        e = move-exception;
        StringBuilder r26 = j0.x("Cannot invoke method ", r11, " on View \"");
        r26.append(k.h(r17));
        r26.append("\"");
        Log.e("CustomSupport", r26.toString(), e);
    }

    public static final String o(byte r5) {
        char[] r10 = ou.b.f21307a;
        return new String(new char[]{r10[(r5 >> 4) & 15], r10[r5 & 15]});
    }
}
