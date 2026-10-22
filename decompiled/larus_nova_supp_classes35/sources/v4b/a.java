package v4b;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import h18.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a {
    public static int A;
    public static int B;
    public static int C;
    public static int D;
    public static int E;
    public static int F;
    public static int G;
    public static int H;
    public static int I;
    public static int J;
    public static int K;
    public static int L;
    public static int M;
    public static int N;
    public static int O;
    public static int P;
    public static int Q;
    public static int R;
    public static int S;
    public static int T;
    public static int U;
    public static Boolean V;
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int h;
    public static int i;
    public static int j;
    public static int k;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public static int y;
    public static int z;

    static {
        a(LarkContext.getApplication().getApplicationContext());
    }

    public static void a(Context r18) {
        if (V != null) goto L5;
        Log.i("BubbleConfigExport", "isNightMode null");
    L6:
        Boolean r1 = V;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        Log.i("BubbleConfigExport", "needAssignColor " + r2);
        if (r2 == true) goto L16;
        return;
    L16:
        V = Boolean.valueOf(f.a(r18));
        Log.i("BubbleConfigExport", "new isNightMode " + V);
        b r3 = (b) ClaymoreServiceLoader.loadFirstOrNull(b.class);
        if (r3 == null) goto L20;
        r3.assignColor(r18);
        return;
    L20:
        a = UDColorUtils.getColor(r18, 2131102439);
        b = j08.b.b(y9c.d.c(r18, 2131102446), 0.0f);
        c = UDColorUtils.getColor(r18, 2131102439);
        d = y9c.d.c(r18, 2131108623);
        e = y9c.d.c(r18, 2131106607);
        f = y9c.d.c(r18, 2131102444);
        g = 2131106607;
        h = y9c.d.c(r18, 2131103353);
        i = j08.b.b(y9c.d.c(r18, 2131106607), 1.0f);
        j = j08.b.b(y9c.d.c(r18, 2131106616), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131103404), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131106521), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131105580), 1.0f);
        k = 2131106607;
        j08.b.b(y9c.d.c(r18, 2131105580), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131103463), 1.0f);
        l = 2131102454;
        m = 2131102456;
        n = j08.b.b(y9c.d.c(r18, 2131108730), 0.16f);
        o = 2131106620;
        p = y9c.d.c(r18, 2131108724);
        q = j08.b.b(y9c.d.c(r18, 2131103449), 0.8f);
        r = j08.b.b(y9c.d.c(r18, 2131108723), 0.5f);
        s = j08.b.b(y9c.d.c(r18, 2131103449), 0.5f);
        t = 2131106616;
        u = y9c.d.c(r18, 2131106622);
        v = y9c.d.c(r18, 2131102464);
        w = y9c.d.c(r18, 2131106607);
        z = UDColorUtils.getColor(r18, 2131102440);
        A = j08.b.b(y9c.d.c(r18, 2131102447), 0.0f);
        B = UDColorUtils.getColor(r18, 2131102440);
        C = y9c.d.c(r18, 2131108731);
        D = y9c.d.c(r18, 2131106607);
        E = y9c.d.c(r18, 2131102445);
        F = 2131106607;
        G = y9c.d.c(r18, 2131103353);
        H = j08.b.b(y9c.d.c(r18, 2131106607), 1.0f);
        I = j08.b.b(y9c.d.c(r18, 2131106616), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131103404), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131103449), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131103406), 1.0f);
        J = 2131106607;
        j08.b.b(y9c.d.c(r18, 2131103406), 1.0f);
        j08.b.b(y9c.d.c(r18, 2131103463), 1.0f);
        K = 2131102454;
        L = 2131102456;
        M = j08.b.b(y9c.d.c(r18, 2131108730), 0.16f);
        N = y9c.d.c(r18, 2131108724);
        O = j08.b.b(y9c.d.c(r18, 2131103449), 0.8f);
        P = j08.b.b(y9c.d.c(r18, 2131108723), 0.5f);
        Q = j08.b.b(y9c.d.c(r18, 2131103449), 0.5f);
        R = y9c.d.c(r18, 2131106622);
        S = y9c.d.c(r18, 2131106607);
        x = 2131232605;
        T = 2131232605;
        y = -1;
        U = -1;
        return;
    L9:
        if (r1.booleanValue() != f.a(r18)) goto L12;
        r2 = false;
        goto L13
    L5:
        Log.i("BubbleConfigExport", "isNightMode " + V);
        goto L6
    }
}
