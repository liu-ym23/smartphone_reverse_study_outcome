package r4;

import android.graphics.Paint;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21656a;

    public a() {
        this.f21656a = d();
    }

    public static float a(String r5, float r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r5, "baselineType");
        Intrinsics.checkNotNullParameter(r11, "paint");
        if (Intrinsics.areEqual(r5, "alphabetic") == true) goto L31;
        Paint.FontMetrics r12 = r11.getFontMetrics();
        float r13 = r12.top;
        float r14 = r12.bottom;
        int r15 = r5.hashCode();
        if (r15 == (-1383228885)) goto L30;
        if (r15 == (-1074341483)) goto L25;
        if (r15 == 115029) goto L20;
        if (r15 != 692890160) goto L31;
        if (r5.equals("hanging") == false) goto L31;
        return r10 - r13;
    L20:
        if (r5.equals("top") == false) goto L31;
        return r10 - r13;
    L25:
        if (r5.equals("middle") == false) goto L31;
        return (r10 - (r12.ascent / 2)) - r12.descent;
    L30:
        if (r5.equals("bottom") == false) goto L31;
        return r10 - r14;
    L31:
        return r10;
    }

    public static float b(String r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Double r11 = (Double) r10.get(r5);
        if (r11 != null) goto L5;
        return 0.0f;
    L5:
        return (float) r11.doubleValue();
    }

    public static int c(String r5, HashMap r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Double r11 = (Double) r10.get(r5);
        if (r11 != null) goto L5;
        return 0;
    L5:
        return (int) r11.doubleValue();
    }

    public static float[] g(HashMap r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter("ps", STGroup.DICT_KEY);
        Object r10 = r5.get("ps");
        if (r10 == null) goto L14;
        List r11 = (List) r10;
        ArrayList r12 = new ArrayList();
        int r13 = r11.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L12;
        Object r15 = r11.get(r14);
        if (r15 == null) goto L10;
        r12.add(Float.valueOf((float) ((Double) r15).doubleValue()));
        r14 = r14 + 1;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L12:
        return CollectionsKt.toFloatArray(r12);
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    }

    public static int[] h(HashMap r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter("cs", STGroup.DICT_KEY);
        ArrayList r10 = new ArrayList();
        Object r11 = r5.get("cs");
        if (r11 == null) goto L16;
        List r12 = (List) r11;
        int r13 = r12.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L14;
        HashMap r15 = s4.a.f21814a;
        Object r16 = r12.get(r14);
        if ((r16 instanceof String) == false) goto L9;
        String r17 = (String) r16;
    L10:
        if (r17 != null) goto L12;
        r17 = "";
    L12:
        r10.add(Integer.valueOf(com.lynx.tasm.utils.k.h(r17)));
        r14 = r14 + 1;
        goto L5
    L9:
        r17 = null;
        goto L10
    L14:
        return CollectionsKt.toIntArray(r10);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    }

    public abstract String d();

    public abstract void e(HashMap r5, q4.c r10);

    public abstract void f(q4.b r5);
}
