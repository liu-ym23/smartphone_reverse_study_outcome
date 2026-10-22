package us9;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.search.impl.combine.model.AutoSearchType;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;
import ws9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final String a;
    public final AutoSearchType b;
    public final ArrayList<e> c;
    public final ArrayList<c> d;
    public final ArrayList<Message> e;
    public final HashMap<String, e> f;
    public final HashMap<String, BotModel> g;
    public final long h;
    public final long i;
    public final long j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r1 = this.h;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.i;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.j;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        int r7 = 1231;
        if (this.k == false) goto L5;
        int r8 = 1231;
    L6:
        int r9 = (r6 + r8) * 31;
        if (this.l == false) goto L9;
        int r10 = 1231;
    L10:
        int r11 = (r9 + r10) * 31;
        if (this.m == true) goto L15;
        r7 = 1237;
    L15:
        return r11 + r7;
    L9:
        r10 = 1237;
        goto L10
    L5:
        r8 = 1237;
        goto L6
    }

    public final String toString() {
        return "SearchResultSnapshot(keyword=" + this.a + ", searchType=" + this.b + ", conversationResultList=" + this.c + ", botResultList=" + this.d + ", messageResultList=" + this.e + ", conversationMap=" + this.f + ", botModelMap=" + this.g + ", currentCursorConversation=" + this.h + ", currentCursorMessage=" + this.i + ", currentCursorBot=" + this.j + ", hasMoreConversation=" + this.k + ", hasMoreMessage=" + this.l + ", hasMoreBots=" + this.m + ')';
    }

    public a(String r10, AutoSearchType r11, ArrayList<e> r12, ArrayList<c> r13, ArrayList<Message> r14, HashMap<String, e> r15, HashMap<String, BotModel> r16, long r17, long r19, long r21, boolean r23, boolean r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r10, "keyword");
        Intrinsics.checkNotNullParameter(r11, "searchType");
        Intrinsics.checkNotNullParameter(r12, "conversationResultList");
        Intrinsics.checkNotNullParameter(r13, "botResultList");
        Intrinsics.checkNotNullParameter(r14, "messageResultList");
        Intrinsics.checkNotNullParameter(r15, "conversationMap");
        Intrinsics.checkNotNullParameter(r16, "botModelMap");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r19;
        this.j = r21;
        this.k = r23;
        this.l = r24;
        this.m = r25;
    }
}
