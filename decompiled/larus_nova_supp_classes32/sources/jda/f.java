package jda;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import hda.b1;
import hda.e1;
import hda.o0;
import hda.p0;
import hda.q0;
import hda.r0;
import hda.r1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements r0<g> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // hda.r0
    public final String a(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.h;
    }

    @Override // hda.r0
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.i;
    }

    @Override // hda.r0
    public final com.obric.assistant.cocreationreview.a c(q0 r12) {
        Intrinsics.checkNotNullParameter(r12, "record");
        o0 r0 = new o0(r12);
        r1.a.getClass();
        e1 r8 = r1.f(r12);
        String r1 = r12.d;
        if (r1 != null) goto L7;
        r1 = r0.c(new String[]{"displaySummary", "memoryContent", LynxAccessibilityModule.MSG_CONTENT});
        if (r1 != null) goto L7;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = b1.a(r1);
        String r3 = r12.a;
        ModuleKey r4 = ModuleKey.COLLECTION_MEMORY;
        String r5 = p0.a(r12);
        String r6 = r8.c;
        String r7 = r8.d;
        if (StringsKt.isBlank(r7) == false) goto L10;
        String r9 = r2;
    L12:
        return new g(r3, r4, r5, r6, r9, r8, r12.e, r12.g);
    L10:
        r9 = r7;
        goto L12
    }
}
