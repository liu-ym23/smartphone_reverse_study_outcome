package com.ss.android.lark.officesdk.applink;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final Set<String> a = null;

    static {
        a = SetsKt.setOf(new String[]{"http", "https", "lark", "feishu"});
    }

    public static Uri a(String r6) {
        Uri r7 = UriProtector.parse(r6);     // Catch: Exception -> L35
        if (r7.isHierarchical() == false) goto L34;
        String r1 = r7.getHost();     // Catch: Exception -> L35
        boolean r2 = false;
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L34;
        Set<String> r4 = a;     // Catch: Exception -> L35
        if ((r4 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r5 = r4.iterator();     // Catch: Exception -> L35
    L21:
        if (r5.hasNext() == false) goto L25;
        if (StringsKt.equals((String) r5.next(), r7.getScheme(), true) == false) goto L21;
    L26:
        if (r2 == false) goto L29;
        return null;
    L29:
        if (Intrinsics.areEqual(r7.getPath(), "/client/chat/chatter/add_by_link") == true) goto L42;
        if (Intrinsics.areEqual(r7.getPath(), "/client/chat/chatter/add_by_link/") == true) goto L42;
        return null;
    L42:
        return r7;
    L25:
        r2 = true;
        goto L26
    L17:
        if (r4.isEmpty() == false) goto L19;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r3 = false;
    L34:
        return null;
    L35:
        Log.w("OfficeSDKGroupInviteLink", "parse group invite link failed");
        return null;
    }
}
