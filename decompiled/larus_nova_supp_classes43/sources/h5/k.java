package h5;

import android.view.ViewGroup;
import com.bytedance.ai.model.objects.WidgetInfo;
import java.util.Map;
import k2.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class k {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public WidgetInfo f;
    public final ViewGroup g;
    public final u h;
    public final int i;
    public final Map<String, String> j;
    public final Map<String, Object> k;
    public final boolean l;
    public final Map<String, Object> m;
    public final Map<String, Object> n;
    public final Function1<Boolean, Unit> o;

    public k() {
        throw null;
    }

    public String b() {
        return null;
    }

    public final String a() {
        WidgetInfo r0 = this.f;
        if (r0 == null) goto L5;
        String r1 = r0.getMixtureCardId();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        return r1;
    L14:
        return this.a;
    L8:
        if (r1.length() == 0) goto L11;
        r10 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public k(String r10, String r11, String r12, String r13, String r14, WidgetInfo r15, ViewGroup r16, u r17, int r18, Map r19, Map r110, boolean r111, Map r20, Map r21, int r22) {
        if ((r22 & 4096) == 0) goto L5;
        boolean r23 = true;
    L7:
        if ((r22 & 8192) == 0) goto L9;
        Map r24 = null;
    L11:
        if ((r22 & 16384) == 0) goto L13;
        Map r25 = null;
    L14:
        Intrinsics.checkNotNullParameter(r10, "messageId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r23;
        this.m = r24;
        this.n = r25;
        this.o = null;
        return;
    L13:
        r25 = r21;
        goto L14
    L9:
        r24 = r20;
        goto L11
    L5:
        r23 = r111;
        goto L7
    }
}
