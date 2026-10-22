package com.larus.bmhome.taskskill.service;

import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniProject;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public final OmniProject a;
    public final List<wc9.e> b;
    public final Map<String, Message> c;
    public final boolean d;

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
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProjectListItem(project=" + this.a + ", firstPageConversations=" + this.b + ", briefMessages=" + this.c + ", hasMoreConversations=" + this.d + ')';
    }

    public /* synthetic */ h(OmniProject r4) {
        this(r4, CollectionsKt.emptyList(), MapsKt.emptyMap(), false);
    }

    public h(OmniProject r2, List<wc9.e> r3, Map<String, Message> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "project");
        Intrinsics.checkNotNullParameter(r3, "firstPageConversations");
        Intrinsics.checkNotNullParameter(r4, "briefMessages");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
