package r4;

import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f21659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f21660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f21661c;
    public q4.c d;

    public d() {
        this.f21659a = new HashMap();
        this.f21660b = new ArrayList();
        this.f21661c = new ArrayList();
    }

    public final a a(HashMap r10) {
        Object r5 = r10.get("tp");
        q4.c r11 = null;
        if (r5 == null) goto L5;
        String r12 = r5.toString();
    L6:
        if (r12 == null) goto L81;
        HashMap r13 = this.f21659a;
        if (r13.containsKey(r12) == false) goto L14;
        List r14 = (List) r13.get(r12);
        if (r14 == null) goto L14;
        if (r14.isEmpty() == true) goto L14;
        Object r15 = r14.remove(0);
    L15:
        a r16 = (a) r15;
        if (r16 == null) goto L18;
    L82:
        if (r16 == null) goto L88;
        q4.c r17 = this.d;
        if (r17 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("drawDataManager");
    L87:
        r16.e(r10, r11);
        goto L88
    L86:
        r11 = r17;
    L88:
        return r16;
    L18:
        switch(r12.hashCode()) {
            case 3181: goto L78;
            case 3183: goto L74;
            case 3276: goto L70;
            case 3278: goto L66;
            case 3355: goto L62;
            case 3364: goto L58;
            case 3587: goto L54;
            case 3645: goto L50;
            case 3664: goto L46;
            case 3679: goto L42;
            case 3681: goto L38;
            case 3698: goto L34;
            case 3711: goto L30;
            case 110754: goto L26;
            case 114208: goto L21;
            default: goto L90;
        };
    L90:
        r16 = null;
        goto L82
    L21:
        if (r12.equals("sta") == false) goto L91;
        b r18 = new b(2);
        r18.f21658c = "";
        a r19 = r18;
    L24:
        r16 = r19;
        goto L82
    L91:
        r16 = null;
        goto L82
    L26:
        if (r12.equals("pas") == false) goto L92;
        r19 = new j();
        goto L24
    L92:
        r16 = null;
        goto L82
    L30:
        if (r12.equals("ts") == false) goto L93;
        r19 = new l(1);
        goto L24
    L93:
        r16 = null;
        goto L82
    L34:
        if (r12.equals("tf") == false) goto L94;
        m r20 = new m();
        r20.d = 1.0f;
        r20.e = 1.0f;
        r19 = r20;
        goto L24
    L94:
        r16 = null;
        goto L82
    L38:
        if (r12.equals("st") == false) goto L95;
        f r21 = new f(1);
        r21.f21665c = "";
        r19 = r21;
        goto L24
    L95:
        r16 = null;
        goto L82
    L42:
        if (r12.equals("sr") == false) goto L96;
        r19 = new e(1);
        goto L24
    L96:
        r16 = null;
        goto L82
    L46:
        if (r12.equals("sc") == false) goto L97;
        l r22 = new l(0);
        r22.f21691c = 1.0f;
        r22.d = 1.0f;
        r19 = r22;
        goto L24
    L97:
        r16 = null;
        goto L82
    L50:
        if (r12.equals("ro") == false) goto L98;
        r19 = new k();
        goto L24
    L98:
        r16 = null;
        goto L82
    L54:
        if (r12.equals("ps") == false) goto L99;
        i r23 = new i();
        r23.f21674b = Paint.Cap.BUTT;
        r23.f21675c = Paint.Join.BEVEL;
        r23.d = Paint.Align.LEFT;
        r23.e = 20.0f;
        r23.f = ViewCompat.MEASURED_STATE_MASK;
        r23.g = ViewCompat.MEASURED_STATE_MASK;
        r23.f21676h = 20.0f;
        r23.f21684p = "";
        r23.f21685q = "alphabetic";
        r23.f21686r = Typeface.DEFAULT;
        r19 = r23;
        goto L24
    L99:
        r16 = null;
        goto L82
    L58:
        if (r12.equals("im") == false) goto L100;
        r19 = new g();
        goto L24
    L100:
        r16 = null;
        goto L82
    L62:
        if (r12.equals("id") == false) goto L101;
        r19 = new h();
        goto L24
    L101:
        r16 = null;
        goto L82
    L66:
        if (r12.equals("ft") == false) goto L102;
        f r24 = new f(0);
        r24.f21665c = "";
        r19 = r24;
        goto L24
    L102:
        r16 = null;
        goto L82
    L70:
        if (r12.equals("fr") == false) goto L103;
        r19 = new e(0);
        goto L24
    L103:
        r16 = null;
        goto L82
    L74:
        if (r12.equals("cr") == false) goto L104;
        r19 = new b(0);
        goto L24
    L104:
        r16 = null;
        goto L82
    L78:
        if (r12.equals("cp") == false) goto L89;
        r19 = new b(1);
        goto L24
    L89:
        r16 = null;
    L14:
        r15 = null;
        goto L15
    L81:
        r16 = null;
        goto L82
    L5:
        r12 = null;
        goto L6
    }

    public final void b(List r10, boolean r11) {
        if (r10.isEmpty() == true) goto L36;
        HashMap r5 = this.f21659a;
        if (r11 == true) goto L23;
        ArrayList r12 = this.f21660b;
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L14;
        a r14 = (a) r13.next();
        List r15 = (List) r5.get(r14.f21656a);
        if (r15 != null) goto L13;
        r15 = new ArrayList();
        r5.put(r14.f21656a, r15);
    L13:
        r15.add(r14);
        goto L9
    L14:
        r12.clear();
        q4.c r16 = this.d;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("drawDataManager");
        r16 = null;
    L17:
        r16.f21484j.clear();
        Iterator r17 = r10.iterator();
    L19:
        if (r17.hasNext() == false) goto L53;
        a r18 = a((HashMap) r17.next());
        if (r18 == null) goto L19;
        r12.add(r18);
        goto L19
    L53:
        return;
    L23:
        ArrayList r19 = this.f21661c;
        Iterator r20 = r19.iterator();
    L25:
        if (r20.hasNext() == false) goto L30;
        a r21 = (a) r20.next();
        List r22 = (List) r5.get(r21.f21656a);
        if (r22 != null) goto L29;
        r22 = new ArrayList();
        r5.put(r21.f21656a, r22);
    L29:
        r22.add(r21);
        goto L25
    L30:
        r19.clear();
        Iterator r23 = r10.iterator();
    L32:
        if (r23.hasNext() == false) goto L54;
        a r24 = a((HashMap) r23.next());
        if (r24 == null) goto L32;
        r19.add(r24);
        goto L32
    L54:
        return;
    }
}
