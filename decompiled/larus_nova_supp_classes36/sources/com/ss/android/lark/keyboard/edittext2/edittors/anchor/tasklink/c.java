package com.ss.android.lark.keyboard.edittext2.edittors.anchor.tasklink;

import android.net.Uri;
import android.text.Spannable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import fob.d;
import fob.f;
import hob.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends f<i> {

    public static final class a {
    }

    static {
    }

    public static i d(com.ss.android.lark.keyboard.edittext2.utils.b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "parseInfo");
        Uri r0 = UriProtector.parse(r4.a);
        String r2 = r4.a;
        String r1 = UriProtector.getQueryParameter(r0, "suite_entity_num");
        if (r1 != null) goto L6;
        r1 = r4.a;
    L6:
        return new i(r2, r1);
    }

    @Override // fob.f
    public final List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r8) {
        Intrinsics.checkNotNullParameter(r8, "target");
        String r0 = StringsKt.trim(r8.toString()).toString();
        if (TextUtils.isEmpty(r0) == true) goto L25;
        if (URLUtil.isValidUrl(r0) == false) goto L25;
        int r1 = StringsKt.indexOf$default(r8.toString(), r0, 0, false, 6, null);
        Uri r2 = UriProtector.parse(r0);
        if (r2.isOpaque() == true) goto L10;
        Set r3 = UriProtector.getQueryParameterNames(r2);
        ova.f.m().getClass();
        if (ova.f.q(r2) == false) goto L23;
        if (Intrinsics.areEqual(r2.getPath(), "/client/todo/detail") == false) goto L23;
        if (r3.contains("suite_entity_num") == false) goto L23;
        if (r3.contains("guid") == false) goto L23;
        if (r3.size() != 2) goto L23;
        return CollectionsKt.listOf(new com.ss.android.lark.keyboard.edittext2.utils.b.a(r8.toString(), r1, r0.length(), false));
    L23:
        return CollectionsKt.emptyList();
    L10:
        return CollectionsKt.emptyList();
    L25:
        return CollectionsKt.emptyList();
    }

    @Override // fob.f
    public final /* bridge */ /* synthetic */ hob.b b(com.ss.android.lark.keyboard.edittext2.utils.b.a r1) {
        return d(r1);
    }

    @Override // fob.f
    public final fob.c.a<List<f.b<i>>> c(Spannable r7) {
        Intrinsics.checkNotNullParameter(r7, "value");
        List<com.ss.android.lark.keyboard.edittext2.utils.b.a> r8 = a(r7);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        com.ss.android.lark.keyboard.edittext2.utils.b.a r1 = (com.ss.android.lark.keyboard.edittext2.utils.b.a) r9.next();
        i r2 = d(r1);
        int r5 = r1.b;
        r0.add(new f.b(r2, new IntRange(r5, r1.a.length() + r5)));
        goto L4
    L7:
        return new fob.c.a(!r0.isEmpty(), r0);
    }

    @Override // fob.f, fob.c
    public final /* bridge */ /* synthetic */ fob.c.a resolve(Spannable r1) {
        return c(r1);
    }

    public c(d<i> r2, eob.a r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "editor");
        super(r2, r3);
    }
}
