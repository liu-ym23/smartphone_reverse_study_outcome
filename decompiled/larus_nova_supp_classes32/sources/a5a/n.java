package a5a;

import android.app.Activity;
import android.content.Context;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public final WeakHashMap<Context, l> a;

    public static class a {
        public static final n a = null;

        static {
            a = new n();
        }
    }

    public n() {
        this.a = new WeakHashMap();
    }

    public final void a(String r7, LogBoxLogLevel r8, Context r9, LogBoxProxy r10) {
        if ((r9 instanceof Activity) == true) goto L6;
    L7:
        l r11 = null;
    L12:
        if (r11 == null) goto L54;
        if (r10 == null) goto L60;
        l.a r0 = (l.a) ((HashMap) r11.b).get(r8);
        if (r0 == null) goto L61;
        r0.d++;
        boolean r3 = false;
        if (((ArrayList) r0.b).contains(r10) == true) goto L21;
        ((ArrayList) r0.b).add(r10);
        boolean r1 = true;
    L22:
        b r4 = r11.d;
        if (r4 == null) goto L49;
        if (r4.isShowing() == false) goto L49;
        m r5 = r11.c;
        if (r5 == null) goto L30;
        ((HashMap) r5.d).put(r8, Boolean.TRUE);
    L30:
        if (r11.d.d != r8) goto L62;
        int r6 = ((ArrayList) r0.b).indexOf(r10);
        if (r6 != (-1)) goto L35;
    L37:
        if (r3 == false) goto L39;
        r11.d.d(r10.getErrorNamespace(), r7);
        return;
    L39:
        if (r1 == false) goto L56;
        b r12 = r11.d;
        int r13 = r0.c + 1;
        int r2 = ((ArrayList) r0.b).size();
        l.a r14 = (l.a) ((HashMap) r11.b).get(r8);
        String r15 = NameKeys.UnloadStrategy_No_Strategy;
        if (r14 == null) goto L47;
        LogBoxProxy r16 = r14.a();
        if (r16 == null) goto L47;
        r15 = r16.getEntryUrlForLogSrc();
    L47:
        r12.e(r13, r2, r8, r15);
        return;
    L56:
        return;
    L35:
        if (r6 != r0.c) goto L37;
        r3 = true;
        goto L37
    L62:
        return;
    L49:
        if (r11.c != null) goto L51;
        return;
    L51:
        if (l.c(r11.a.get()) == false) goto L59;
        r11.c.c(r8, l.b(r7), r0.d);
        return;
    L59:
        return;
    L21:
        r1 = false;
        goto L22
    L61:
        return;
    L60:
        return;
    L54:
        return;
    L6:
        if (((Activity) r9).isFinishing() == true) goto L7;
        l r17 = this.a.get(r9);
        if (r17 != null) goto L11;
        r17 = new l(r9);
        this.a.put(r9, r17);
    L11:
        r11 = r17;
        goto L12
    }
}
