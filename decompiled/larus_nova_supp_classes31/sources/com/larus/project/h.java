package com.larus.project;

import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniProject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public final List<OmniProject> a;
    public final Map<String, List<wc9.e>> b;
    public final Map<String, Message> c;
    public final Set<String> d;
    public final int e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProjectListPage(projects=" + this.a + ", firstPageConversations=" + this.b + ", briefMessages=" + this.c + ", projectsWithMoreConversations=" + this.d + ", nextCursor=" + this.e + ", hasMore=" + this.f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<OmniProject> r2, Map<String, ? extends List<wc9.e>> r3, Map<String, Message> r4, Set<String> r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "projects");
        Intrinsics.checkNotNullParameter(r3, "firstPageConversations");
        Intrinsics.checkNotNullParameter(r4, "briefMessages");
        Intrinsics.checkNotNullParameter(r5, "projectsWithMoreConversations");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
