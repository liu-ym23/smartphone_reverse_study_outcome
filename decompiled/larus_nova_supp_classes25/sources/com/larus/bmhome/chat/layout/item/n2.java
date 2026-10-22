package com.larus.bmhome.chat.layout.item;

import android.view.View;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.list.cell.prompt.PromptCell$e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n2 implements Function0 {
    public final /* synthetic */ PromptSpan a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ PromptContent d;
    public final /* synthetic */ OnboardingActionCardData.CardScene e;
    public final /* synthetic */ OnboardingActionCardData f;
    public final /* synthetic */ View.OnClickListener g;
    public final /* synthetic */ Function3 h;
    public final /* synthetic */ Function0 i;
    public final /* synthetic */ String j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ int l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ Boolean n;
    public final /* synthetic */ String o;
    public final /* synthetic */ String p;

    public /* synthetic */ n2(PromptSpan r3, String r4, boolean r5, PromptContent r6, OnboardingActionCardData.CardScene r7, OnboardingActionCardData r8, com.larus.bmhome.chat.list.cell.prompt.g0 r9, PromptCell$e r10, com.larus.bmhome.chat.list.cell.prompt.i0 r11, String r12, boolean r13, int r14, boolean r15, Boolean r16, String r17, String r18) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
    }

    public final Object invoke() {
        PromptSpan.C(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
        return Unit.INSTANCE;
    }
}
