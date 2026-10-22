package com.larus.bmhome.chat.markdown.reference;

import com.larus.im.bean.message.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final String a(SearchReferenceData r8) {
        if (r8 != null) goto L27;
        String r1 = null;
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        int r2 = StringsKt.split$default(r1, new String[]{"%s"}, false, 0, 6, null).size() - 1;     // Catch: Exception -> L26
        if (r8 == null) goto L13;
        List<String> r5 = r8.getQueries();     // Catch: Exception -> L26
        if (r5 == null) goto L13;
        int r6 = r5.size();     // Catch: Exception -> L26
    L14:
        if (r8 == null) goto L18;
        List<Reference> r9 = r8.getReference();     // Catch: Exception -> L26
        if (r9 == null) goto L18;
        int r10 = r9.size();     // Catch: Exception -> L26
    L19:
        if (r2 != 1) goto L21;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L26
        return String.format(r1, Arrays.copyOf(new Object[]{String.valueOf(r10)}, 1));
    L21:
        if (r2 != 2) goto L28;
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L26
        return String.format(r1, Arrays.copyOf(new Object[]{String.valueOf(r6), Integer.valueOf(r10)}, 2));
    L28:
        return r1;
    L18:
        r10 = 0;
    L13:
        r6 = 0;
        goto L14
    L27:
        r1 = r8.getTitle();     // Catch: Exception -> L26
    L26:
        return "";
    }

    public static final List<String> b(SearchReferenceData r10) {
        String r0 = null;
        if (r10 == null) goto L15;
        List<String> r1 = r10.getQueries();
        if (r1 == null) goto L15;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L16;
        String r6 = (String) r3.next();
        String r4 = r10.getSearchLoadingText();
        if (r4 == null) goto L12;
        String r5 = StringsKt.replace$default(r4, "%s", r6, false, 4, null);
    L13:
        if (r5 == null) goto L8;
        r2.add(r5);
        goto L8
    L12:
        r5 = null;
    L16:
        ArrayList r7 = r2;
        if (r7 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L35;
        if (r10 == null) goto L26;
        r0 = r10.getSearchLoadingText();
    L26:
        if (r0 != null) goto L29;
        r0 = "";
    L29:
        return CollectionsKt.listOf(r0);
    L35:
        return r2;
    L19:
        if (r7.isEmpty() == true) goto L22;
        r8 = false;
    L15:
        r2 = null;
        goto L16
    }
}
