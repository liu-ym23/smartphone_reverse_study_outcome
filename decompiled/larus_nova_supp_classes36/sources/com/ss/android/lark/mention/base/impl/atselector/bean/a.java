package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.chat.entity.chatter.TagInfo;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.tag.TagData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Comparable<a> {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final List<String> e;
    public final List<String> f;
    public final Chatter.ChatterType g;
    public final ChatterDescription h;
    public final boolean i;
    public boolean j;
    public boolean k;
    public final String l;
    public final WorkStatus m;
    public final long n;
    public final boolean o;
    public final List<TagInfo> p;
    public ChatterSensitiveInfo q;
    public List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r;
    public TagData s;
    public final boolean t;
    public final boolean u;

    public final boolean b() {
        return "mention_ai_knowledge".equals(this.a);
    }

    public a() {
        this.q = null;
    }

    public final int a(a r5) {
        String r0 = this.c;
        if (TextUtils.isEmpty(this.l) == false) goto L5;
    L7:
        String r1 = r5.l;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L11:
        r1 = r5.c;
    L13:
        if (TextUtils.isEmpty(r0) == false) goto L15;
        return 0;
    L15:
        if (TextUtils.isEmpty(r0) == false) goto L17;
        return 0;
    L17:
        if (r0.compareToIgnoreCase(r1) != 0) goto L21;
        return this.a.compareTo(r5.a);
    L21:
        return r0.compareToIgnoreCase(r1);
    L10:
        if (r1.equals("#") == false) goto L13;
    L5:
        if (this.l.equals("#") == true) goto L7;
        r0 = this.l;
        goto L7
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a r1) {
        return a(r1);
    }

    public a(String r2, String r3, Chatter.ChatterType r4) {
        this.q = null;
        this.a = "mention_ai_knowledge";
        this.c = r2;
        this.h = new ChatterDescription(r3, ChatterDescription.Type.DEFAULT);
        this.g = r4;
        this.l = "z";
        this.e = new ArrayList();
        new ArrayList();
        this.d = "";
        this.n = 0;
        this.p = new ArrayList();
        this.r = new ArrayList();
    }

    public a(String r22, String r23, String r24, String r25, List r26, List r27, Chatter.ChatterType r28, ChatterDescription r29, boolean r30, String r31, WorkStatus r32, long r33, boolean r35, List r36, List r37, TagData r38, boolean r39, boolean r40) {
        this(r22, r23, r24, r25, r26, r27, r28, r29, r30, false, r31, r32, r33, r35, r36, r37, r38, r39, r40);
    }

    public a(String r4, String r5, String r6, String r7, List r8, List r9, Chatter.ChatterType r10, ChatterDescription r11, boolean r12, boolean r13, String r14, WorkStatus r15, long r16, boolean r18, List r19, List r20, TagData r21, boolean r22, boolean r23) {
        this.q = null;
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r18;
        this.p = r19;
        this.r = r20;
        this.s = r21;
        this.u = r23;
        this.t = r22;
    }
}
