package nb2;

import ak6.f;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.richcontent.config.b;
import com.bytedance.android.livesdk.l7;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ik6.c;
import ik6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements c {
    public final int a;

    public a() {
        this.a = s1.f(16.0f);
    }

    public final void a(SpanRendClient r14, d r15) {
        Intrinsics.checkNotNullParameter(r14, "client");
        Intrinsics.checkNotNullParameter(r15, "rendItem");
        f r16 = r15.b;
        boolean r0 = r16 instanceof b;
        if (r0 == true) goto L5;
        f r2 = null;
    L6:
        b r3 = (b) r2;
        if (r3 == null) goto L9;
        boolean r4 = r3.c;
    L10:
        SpannableString r11 = r15.c;
        if (r4 == false) goto L91;
        if (r11 == null) goto L93;
        if (r0 == true) goto L16;
        r16 = null;
    L16:
        b r17 = (b) r16;
        if (r17 == null) goto L19;
        int r18 = r17.d;
    L20:
        if (r18 > 0) goto L23;
        r18 = this.a;
    L23:
        if (((Boolean) l7.a.getValue()).booleanValue() == false) goto L68;
        ArrayList r1 = new ArrayList();
        List r5 = r15.a.a;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L25:
        boolean r13 = true;
        if (r7.hasNext() == false) goto L37;
        Object r8 = r7.next();
        jb2.d r9 = (ek6.d) r8;
        if ((r9 instanceof jb2.d) == false) goto L32;
        if (r9.g == true) goto L32;
    L35:
        if (r13 == false) goto L25;
        r6.add(r8);
    L32:
        if ((r9 instanceof jb2.c) == true) goto L35;
        r13 = false;
        goto L35
    L37:
        Iterator r10 = r6.iterator();
    L39:
        if (r10.hasNext() == false) goto L47;
        ek6.d r19 = (ek6.d) r10.next();
        Intrinsics.checkNotNullParameter(r19, "content");
        Map r20 = r15.d;
        if (r20 == null) goto L43;
        ak6.c r21 = (ak6.c) r20.get(r19);
    L44:
        if (r21 == null) goto L39;
        r1.add(r21);
        goto L39
    L43:
        r21 = null;
        goto L44
    L47:
        if ((!r1.isEmpty()) == false) goto L67;
        ab2.b.a().b.getClass();
        Iterator r110 = ((ArrayList) bb2.a.c(r11)).iterator();
    L50:
        if (r110.hasNext() == false) goto L94;
        db2.a r23 = (db2.a) r110.next();
        int r24 = r23.b;
        int r25 = r23.c;
        int r26 = 0;
    L53:
        if (r26 >= r1.size()) goto L60;
        if (r24 < ((ak6.c) ListProtector.get(r1, r26)).a) goto L59;
        if (r25 > ((ak6.c) ListProtector.get(r1, r26)).b) goto L59;
        boolean r27 = true;
    L61:
        if (r27 == true) goto L50;
        Drawable r28 = r23.a;
        if (r28 == null) goto L50;
        bb2.a.a(r11, r28, r23.b, r23.c, (int) (fb2.c.b(r18, r28, false) + 0.5f), r18, null);
    L59:
        r26 = r26 + 1;
        goto L53
    L60:
        r27 = false;
        goto L61
    L94:
        return;
    L67:
        ab2.b.a().b(r11, r18);
        return;
    L68:
        ab2.b.a().b(r11, r18);
        return;
    L19:
        r18 = 0;
        goto L20
    L93:
        return;
    L91:
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = r16;
        goto L6
    }
}
