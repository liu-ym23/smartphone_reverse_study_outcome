package com.larus.business.markdown.impl.markwon;

import androidx.core.util.PatternsCompat;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.bmhome.share.panel.ShareType;
import io.noties.markwon.core.CoreProps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.j;
import lsc.m;
import lsc.q;
import lsc.r;
import lsc.u;
import lsc.x;
import lsc.y;
import msc.o;
import msc.p;
import org.commonmark.node.Link;
import tsc.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends atc.a {
    public final Integer a;
    public final int b;
    public final n c;

    public static class a extends atc.a.a {
        public static final Pattern c = null;
        public final Integer b;

        /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.b$a$a, reason: collision with other inner class name */
        public static final class C0072a {
        }

        static {
            c = PatternProtector.compile("[a-zA-Z]*\\.[a-zA-Z]*");
        }

        public a(Integer r1, int r2, n r3) {
            this.b = r1;
        }

        public final void a(m r8, String r9, int r10, uvc.b r11) {
            Intrinsics.checkNotNullParameter(r8, "visitor");
            Intrinsics.checkNotNullParameter(r9, ShareType.TEXT);
            Intrinsics.checkNotNullParameter(r11, "node");
            if (this.b == null) goto L8;
            if (r9.length() <= this.b.intValue()) goto L8;
            return;
        L8:
            if ((r11.a instanceof Link) == false) goto L10;
            return;
        L10:
            x r12 = r8.B().e.a(Link.class);
            if (r12 != null) goto L13;
            return;
        L13:
            Matcher r13 = atc.a.a.a.matcher(r9);
        L15:
            if (r13.find() == false) goto L25;
            int r0 = r13.start();
            int r1 = r13.end();
            String r2 = r13.group();
            if (StringsKt.startsWith$default(r2, "@", false, 2, null) == true) goto L15;
            if (c.matcher(r2).matches() == true) goto L15;
            if (PatternsCompat.EMAIL_ADDRESS.matcher(r2).find() == true) goto L15;
            u r3 = r8.r();
            y r4 = r8.builder();
            CoreProps.g.c(r3, r2);
            q r5 = p.d;
            ((HashMap) r3.a).remove(r5);
            y.f(r4, r12.a(r8.B(), r3), r0 + r10, r1 + r10);
            goto L15
        }
    }

    public final void j(j.a r5) {
        Intrinsics.checkNotNullParameter(r5, "registry");
        o r6 = ((r) r5).c(o.class);
        Intrinsics.checkNotNullParameter(r6, "corePlugin");
        a r0 = new a(this.a, this.b, this.c);
        ((ArrayList) r6.a).add(r0);
    }

    public b(Integer r1, int r2, n r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
