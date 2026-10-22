package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class f<T extends Content> extends v5b.a<T> {
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public f<T> g;

    public boolean e() {
        int r0 = this.f;
        if (r0 == 1) goto L17;
        if (r0 == 0) goto L18;
        String r1 = this.b;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return false;
    L14:
        if (this.g == null) goto L20;
        return true;
    L20:
        return false;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L18:
        return false;
    L17:
        return false;
    }

    public f(T r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.b = BuildConfig.FLAVOR;
    }

    @Override // v5b.a
    public boolean d(v5b.a<?> r7) {
        if (super.d(r7) == true) goto L6;
        return false;
    L6:
        if ((r7 instanceof f) == false) goto L46;
        f r8 = (f) r7;
        if (y28.a.a(this.b, r8.b) == true) goto L10;
    L24:
        boolean r0 = false;
    L25:
        f<T> r3 = this.g;
        if (r3 == null) goto L45;
        f<T> r9 = r8.g;
        if (r9 == null) goto L45;
        if ((r3 instanceof c) == false) goto L45;
        if ((r9 instanceof c) == false) goto L45;
        T r4 = r3.a;
        MergeForwardContent r5 = null;
        if ((r4 instanceof MergeForwardContent) == false) goto L36;
        MergeForwardContent r6 = (MergeForwardContent) r4;
    L37:
        T r10 = r9.a;
        if ((r10 instanceof MergeForwardContent) == false) goto L40;
        r5 = (MergeForwardContent) r10;
    L40:
        if (r0 == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(r6, r5) == false) goto L48;
        return true;
    L48:
        return false;
    L36:
        r6 = null;
    L45:
        return r0;
    L10:
        if (this.c != r8.c) goto L24;
        if (this.d != r8.d) goto L24;
        if (this.e != r8.e) goto L24;
        if (this.f != r8.f) goto L24;
        if (Intrinsics.areEqual(this.g, r8.g) == true) goto L23;
        f<T> r1 = this.g;
        if (r1 == null) goto L24;
        Intrinsics.checkNotNull(r1);
        if (r1.d(r8.g) == false) goto L24;
    L23:
        r0 = true;
        goto L25
    L46:
        return false;
    }
}
