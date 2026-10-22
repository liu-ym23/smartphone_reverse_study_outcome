package com.ss.android.lark.compose.chatterselector;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final List<d> e;
    public final com.ss.android.lark.compose.chat_member_list.a f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "ChatterSelectorChatter(id=" + this.a + ", name=" + this.b + ", nickname=" + this.c + ", avatarKey=" + this.d + ", udTagParams=" + this.e + ", statusTag=" + this.f + ')';
    }

    public static a a(a r7, List r8) {
        String r1 = r7.a;
        String r2 = r7.b;
        String r3 = r7.c;
        String r4 = r7.d;
        com.ss.android.lark.compose.chat_member_list.a r6 = r7.f;
        Intrinsics.checkNotNullParameter(r1, "id");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r3, "nickname");
        Intrinsics.checkNotNullParameter(r4, "avatarKey");
        Intrinsics.checkNotNullParameter(r8, "udTagParams");
        Intrinsics.checkNotNullParameter(r6, "statusTag");
        return new a(r1, r2, r3, r4, r8, r6);
    }

    public a(String r2, String r3, String r4, String r5, List<d> r6, com.ss.android.lark.compose.chat_member_list.a r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r4, "nickname");
        Intrinsics.checkNotNullParameter(r5, "avatarKey");
        Intrinsics.checkNotNullParameter(r6, "udTagParams");
        Intrinsics.checkNotNullParameter(r7, "statusTag");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
