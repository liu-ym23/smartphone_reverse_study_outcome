package com.ss.android.lark.inline.ai.logic;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.inline.ai.api.ui.ParamDetail;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import com.ss.android.lark.inline.ai.api.ui.TextContentList;
import com.ss.android.lark.inline.ai.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair a(j r13) {
        Intrinsics.checkNotNullParameter(r13, "userInputText");
        if ((r13 instanceof j.a) == false) goto L6;
        return new Pair(((j.a) r13).a, null);
    L6:
        if ((r13 instanceof j.b) == false) goto L24;
        j.b r14 = (j.b) r13;
        boolean r2 = true;
        if (r14.b.size() != 1) goto L17;
        String r0 = ((j.b.a) ListProtector.get(r14.b, 0)).c;
        if (r0 != null) goto L12;
    L15:
        if (r2 == false) goto L17;
        return new Pair(r14.a + ((j.b.a) ListProtector.get(r14.b, 0)).b + ((j.b.a) ListProtector.get(r14.b, 0)).d, null);
    L12:
        if (r0.length() == 0) goto L15;
        r2 = false;
    L17:
        TextContentList r1 = new TextContentList();
        r1.setDisplayName(r14.a);
        ArrayList r3 = new ArrayList();
        Iterator<T> r15 = r14.b.iterator();
    L19:
        if (r15.hasNext() == false) goto L21;
        j.b.a r4 = (j.b.a) r15.next();
        r3.add(new ParamDetail(r4.a, r4.b, r4.c, r4.d, null, 16, null));
        goto L19
    L21:
        r1.setParamDetails(r3);
        return new Pair("", r1);
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public static ArrayList b(List r24, j r25) {
        Intrinsics.checkNotNullParameter(r24, "promptGroups");
        Intrinsics.checkNotNullParameter(r25, "userInputText");
        if ((r25 instanceof j.b) == true) goto L5;
        ArrayList r2 = new ArrayList();
        Iterator r0 = r24.iterator();
    L8:
        if (r0.hasNext() == false) goto L45;
        m r3 = (m) r0.next();
        PromptGroup r4 = new PromptGroup(r3.a, new ArrayList());
        Iterator<T> r5 = r3.b.iterator();
    L11:
        if (r5.hasNext() == false) goto L36;
        slb.j r6 = (slb.j) r5.next();
        if ((r25 instanceof j.a) == false) goto L23;
        j.a r8 = (j.a) r25;
        if (r8.a.length() <= 0) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == false) goto L23;
        if (StringsKt.indexOf$default(r6.d, r8.a, 0, false, 6, null) < 0) goto L22;
        StringUtils r10 = StringUtils.a;
        String r11 = r6.d;
        String r12 = r8.a;
        r10.getClass();
        String r13 = StringUtils.c(r11, r12);
    L24:
        String r15 = r13;
        if (r15 == null) goto L11;
        ArrayList<Prompt> r14 = r4.getPrompts();
        if (r14 == null) goto L11;
        String r16 = r6.a;
        int r17 = r6.c;
        String r18 = r6.d;
        ArrayList<slb.j> r7 = r6.g;
        if (r7 != null) goto L31;
    L34:
        boolean r19 = true;
    L35:
        r14.add(new Prompt(null, r16, null, null, r17, r15, null, r18, !r19, null, null, r6.i, 1613, null));
        goto L11
    L31:
        if (r7.isEmpty() == true) goto L34;
        r19 = false;
        goto L35
    L22:
        r13 = null;
        goto L24
    L17:
        r9 = false;
    L23:
        r13 = r6.d;
        goto L24
    L36:
        ArrayList<Prompt> r20 = r4.getPrompts();
        if (r20 != null) goto L39;
    L42:
        boolean r21 = true;
    L43:
        if (r21 == true) goto L8;
        r2.add(r4);
        goto L8
    L39:
        if (r20.isEmpty() == true) goto L42;
        r21 = false;
        goto L43
    L45:
        return r2;
    L5:
        return new ArrayList();
    }
}
