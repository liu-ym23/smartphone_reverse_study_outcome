package com.bytedance.forest.pollyfill;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public static final List f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f4528c;
    public c d;
    public final long e;

    static {
        f = CollectionsKt.listOf(new Integer[]{408, 503, 504});
    }

    public l(int r5, String r10, Map r11, c r12, long r13) {
        this.f4526a = r5;
        this.f4527b = r10;
        this.f4528c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean a() {
        List r5 = com.bytedance.forest.utils.k.f4646a;
        int r10 = this.f4526a;
        if (200 > r10) goto L9;
        if (300 < r10) goto L9;
    L12:
        if (r10 == 206) goto L28;
        Map r11 = this.f4528c;
        if (Intrinsics.areEqual((String) r11.get("vary"), XPath.WILDCARD) == true) goto L28;
        String r12 = (String) r11.get("cache-control");
        if (r12 == null) goto L25;
        Iterator r13 = com.bytedance.forest.utils.k.f4646a.iterator();
    L20:
        if (r13.hasNext() == false) goto L25;
        if (StringsKt.g(r12, (String) r13.next()) == false) goto L20;
        return false;
    L25:
        if (com.bytedance.forest.utils.k.b(this) == null) goto L28;
        return true;
    L28:
        return false;
    L9:
        if (r10 == 304) goto L12;
        return false;
    }
}
