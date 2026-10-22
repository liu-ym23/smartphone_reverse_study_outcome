package com.ss.ugc.live.sdk.msg.utils;

import android.text.TextUtils;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(List<com.ss.ugc.live.sdk.msg.network.d> r5) {
        if (r5 == null) goto L18;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        if (StringsKt.equals("im-internal_ext", ((com.ss.ugc.live.sdk.msg.network.d) r1).a, true) == false) goto L6;
    L11:
        com.ss.ugc.live.sdk.msg.network.d r2 = (com.ss.ugc.live.sdk.msg.network.d) r1;
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.b;
    L10:
        r1 = null;
        goto L11
    L18:
        return null;
    }

    @JvmStatic
    public static final String b(List<UMGWCustomData> r6) {
        if (r6 == null) goto L26;
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L15;
        Object r1 = r7.next();
        UMGWCustomData r2 = (UMGWCustomData) r1;
        boolean r5 = true;
        if (StringsKt.equals("im-internal_ext", r2.key, true) == true) goto L13;
        if (StringsKt.equals("internal_ext", r2.key, true) == true) goto L13;
        r5 = false;
    L13:
        if (r5 == false) goto L6;
    L16:
        UMGWCustomData r3 = (UMGWCustomData) r1;
        if (r3 != null) goto L19;
        return null;
    L19:
        return r3.value;
    L15:
        r1 = null;
        goto L16
    L26:
        return null;
    }

    @JvmStatic
    public static final String c(com.ss.ugc.live.sdk.msg.network.g r4) {
        if (r4 == null) goto L17;
        List<com.ss.ugc.live.sdk.msg.network.d> r5 = r4.c;
        if (r5 == null) goto L17;
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        if (StringsKt.equals("x-tt-logid", ((com.ss.ugc.live.sdk.msg.network.d) r0).a, true) == false) goto L7;
    L12:
        com.ss.ugc.live.sdk.msg.network.d r1 = (com.ss.ugc.live.sdk.msg.network.d) r0;
        if (r1 == null) goto L17;
        String r7 = r1.b;
        if (r7 == null) goto L17;
        return r7;
    L11:
        r0 = null;
    L17:
        return "";
    }

    @JvmStatic
    public static final String d(SdkResponse r5) {
        if (r5 == null) goto L9;
        List<SdkMessage> r6 = r5.messages;
        if (r6 == null) goto L9;
        List<SdkMessage> r7 = r6;
        Collection r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        SdkMessage r1 = (SdkMessage) r8.next();
        r0.add(r1.method + ':' + r1.msg_type + ':' + r1.msg_id);
    L11:
        return TextUtils.join(",", r0);
    L9:
        r0 = CollectionsKt.emptyList();
        goto L11
    }

    @JvmStatic
    public static final Long e(List<com.ss.ugc.live.sdk.msg.network.d> r5) {
        if (r5 == null) goto L20;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        if (StringsKt.equals("im-now", ((com.ss.ugc.live.sdk.msg.network.d) r1).a, true) == false) goto L6;
    L11:
        com.ss.ugc.live.sdk.msg.network.d r2 = (com.ss.ugc.live.sdk.msg.network.d) r1;
        if (r2 == null) goto L21;
        String r7 = r2.b;
        if (r7 != null) goto L16;
        return null;
    L16:
        return StringsKt.toLongOrNull(r7);
    L21:
        return null;
    L10:
        r1 = null;
        goto L11
    L20:
        return null;
    }
}
