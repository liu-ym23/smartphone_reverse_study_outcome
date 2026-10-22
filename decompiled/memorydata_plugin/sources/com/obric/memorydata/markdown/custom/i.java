package com.obric.memorydata.markdown.custom;

import android.view.View;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.az;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0002¨\u0006\u0007"}, d2 = {"combine", "", "Lcom/obric/memorydata/markdown/custom/OMenuDialog$Item;", "titles", "", "listeners", "Landroid/view/View$OnClickListener;", "markdown_lite_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class i {
    private static final String a(String r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return new Regex("[\\s\\u00A0\\u3000]").replace(r3, "");
    }

    public static final /* synthetic */ List a(List r2, List r3) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private static final List<h.c> b(List<String> r10, List<? extends View.OnClickListener> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r12.size() != r13.size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L27;
        RunLog.INSTANCE.debug("OMenuDialog", "titles: " + r12);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L9:
        if (r14.hasNext() == false) goto L20;
        Object r5 = r14.next();
        int r6 = r2 + 1;
        if (r2 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        View.OnClickListener r3 = (View.OnClickListener) ZeusTransformUtils.preCheckCast(r13.get(r2), View.OnClickListener.class, "com.obric.memorydata.plugin");
        String r8 = a(az.c(r7));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
        r1.putIfAbsent(r8, TuplesKt.to(r7, r3));
    L19:
        r2 = r6;
        goto L9
    L16:
        r9 = false;
        goto L17
    L20:
        Collection r15 = r1.values();
        Intrinsics.checkNotNullExpressionValue(r15, "<get-values>(...)");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L22:
        if (r18.hasNext() == false) goto L25;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r18.next(), Pair.class, "com.obric.memorydata.plugin");
        r17.add(new h.c((String) ZeusTransformUtils.preCheckCast(r4.component1(), String.class, "com.obric.memorydata.plugin"), (View.OnClickListener) ZeusTransformUtils.preCheckCast(r4.component2(), View.OnClickListener.class, "com.obric.memorydata.plugin"), 0, true, 4, null));
        goto L22
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L27:
        throw new IllegalArgumentException(("The size of titles list does not match listeners list! Titles count: " + r12.size() + ", Listeners count: " + r13.size()).toString());
    L5:
        r0 = false;
        goto L6
    }
}
