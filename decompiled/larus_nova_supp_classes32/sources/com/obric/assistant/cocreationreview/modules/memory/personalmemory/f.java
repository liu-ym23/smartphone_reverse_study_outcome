package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import hda.b1;
import hda.c1;
import hda.e1;
import hda.o0;
import hda.p0;
import hda.q0;
import hda.r0;
import hda.r1;
import hda.s1;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
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
        return r3.k;
    }

    @Override // hda.r0
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.l;
    }

    @Override // hda.r0
    public final com.obric.assistant.cocreationreview.a c(q0 r17) {
        Intrinsics.checkNotNullParameter(r17, "record");
        o0 r1 = new o0(r17);
        r1.a.getClass();
        e1 r13 = r1.f(r17);
        String r2 = r17.d;
        if (r2 != null) goto L7;
        r2 = r1.c(new String[]{"currentContent", "description", "embeddingContent", "displaySummary"});
        if (r2 != null) goto L7;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = b1.a(r2);
        String r4 = r1.c(new String[]{"semanticType", "semantic_type"});
        String r5 = r1.c(new String[]{"primaryCategory", "primary_category"});
        String r6 = r1.c(new String[]{"secondaryCategory", "secondary_category"});
        if (r4 == null) goto L29;
        String r7 = StringsKt.trim(r4).toString().toLowerCase(Locale.ROOT);
        switch(r7.hashCode()) {
            case -1459831589: goto L25;
            case -265850119: goto L21;
            case -261851592: goto L17;
            case 502611593: goto L13;
            default: goto L28;
        };
    L28:
        r5 = r4;
        goto L29
    L13:
        if (r7.equals("interests") == false) goto L28;
        r4 = "兴趣爱好";
        goto L28
    L17:
        if (r7.equals("relationship") == false) goto L28;
        r4 = "社交关系";
        goto L28
    L21:
        if (r7.equals("userinfo") == false) goto L28;
        r4 = "个人信息";
        goto L28
    L25:
        if (r7.equals("preference") == false) goto L28;
        r4 = "选择偏好";
    L29:
        String r8 = c1.c(r5);
        if (r6 != null) goto L32;
        r6 = r1.c(new String[]{"tagPath", "tag_path"});
    L32:
        Pair r9 = TuplesKt.to(r8, c1.c(r6));
        String r10 = r17.a;
        ModuleKey r11 = ModuleKey.PERSONAL_MEMORY;
        String r12 = s1.a(r17, r13.f);
        String r14 = p0.a(r17);
        String r15 = (String) r9.getFirst();
        String r16 = (String) r9.getSecond();
        String r18 = r13.c;
        String r19 = r13.d;
        if (StringsKt.isBlank(r19) == false) goto L35;
        String r110 = r3;
    L37:
        return new g(r10, r11, r12, r14, "个人信息记忆", r15, r16, r18, r110, r13, r17.e, r17.g);
    L35:
        r110 = r19;
        goto L37
    }
}
