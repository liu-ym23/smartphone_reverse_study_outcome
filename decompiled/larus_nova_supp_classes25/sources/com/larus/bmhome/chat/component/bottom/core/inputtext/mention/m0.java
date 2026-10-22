package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.content.Context;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.y1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 {
    public final Context a;
    public final Function0<Boolean> b;
    public boolean c;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
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
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.e;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "OptionTrace(mentionType=" + this.a + ", itemType=" + this.b + ", itemName=" + this.c + ", isSearchResult=" + this.d + ", index=" + this.e + ')';
        }

        public b(String r2, String r3, String r4, boolean r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "mentionType");
            Intrinsics.checkNotNullParameter(r3, "itemType");
            Intrinsics.checkNotNullParameter(r4, "itemName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public static String a(b r9) {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{"mention_panel_option", r9.a, r9.b, r9.c, Boolean.valueOf(r9.d), Integer.valueOf(r9.e)}), ":", null, null, 0, null, null, 62, null);
    }

    public final h0 b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "mentionType");
        return new h0(r4, "more", this.a.getString(2131898328));
    }

    public final void c(b r6) {
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L5;
        return;
    L5:
        String r0 = r6.a;
        String r1 = r6.b;
        String r2 = r6.c;
        boolean r7 = r6.d;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter("", "skillId");
        Intrinsics.checkNotNullParameter(r0, "mentionType");
        Intrinsics.checkNotNullParameter(r1, "itemType");
        Intrinsics.checkNotNullParameter(r2, "itemName");
        JSONObject r8 = y1.a(r0, r2, r7);
        r8.put("item_type", r1);
        y1.b("mention_panel_option_click", r8);
    }

    public final void d(b r7) {
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L5;
        return;
    L5:
        String r0 = r7.a;
        String r1 = r7.b;
        String r2 = r7.c;
        boolean r3 = r7.d;
        int r8 = r7.e;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter("", "skillId");
        Intrinsics.checkNotNullParameter(r0, "mentionType");
        Intrinsics.checkNotNullParameter(r1, "itemType");
        Intrinsics.checkNotNullParameter(r2, "itemName");
        JSONObject r4 = y1.a(r0, r2, r3);
        r4.put("item_type", r1);
        r4.put("index", r8);
        y1.b("mention_panel_option_show", r4);
    }

    public m0(Context r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "shouldTrack");
        this.a = r2;
        this.b = r3;
    }
}
