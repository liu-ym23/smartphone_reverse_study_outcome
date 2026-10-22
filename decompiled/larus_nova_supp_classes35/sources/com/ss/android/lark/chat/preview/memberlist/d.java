package com.ss.android.lark.chat.preview.memberlist;

import com.larksuite.arch.jack.j;
import com.larksuite.arch.jack.m;
import com.larksuite.arch.jack.s;
import com.ss.android.lark.chat.entity.preview.PullUrlPreviewChatterListResponse;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements j {
    public final String a;
    public final com.larksuite.arch.jack.a<PullUrlPreviewChatterListResponse> b;
    public final ArrayList<ChatterPreviewChatterInfo> c;
    public final boolean d;
    public final boolean e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MemberListState(title=" + this.a + ", request=" + this.b + ", chatterInfoList=" + this.c + ", showEmptyView=" + this.d + ", showErrorView=" + this.e + ')';
    }

    public final boolean b() {
        PullUrlPreviewChatterListResponse r0 = (PullUrlPreviewChatterListResponse) this.b.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getHasMore();
    }

    public final String c() {
        PullUrlPreviewChatterListResponse r0 = (PullUrlPreviewChatterListResponse) this.b.a();
        if (r0 == null) goto L6;
        String r1 = r0.getNextToken();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    public /* synthetic */ d(int r7) {
        this(BuildConfig.FLAVOR, s.a, new ArrayList(), false, false);
    }

    public d(String r2, com.larksuite.arch.jack.a<PullUrlPreviewChatterListResponse> r3, ArrayList<ChatterPreviewChatterInfo> r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "chatterInfoList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public static d a(d r6, String r7, m r8, ArrayList r9, boolean r10, boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        m r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.c;
    L11:
        ArrayList r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.d;
    L14:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L17;
        r11 = r6.e;
    L17:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "chatterInfoList");
        return new d(r1, r2, r3, r4, r11);
    }
}
