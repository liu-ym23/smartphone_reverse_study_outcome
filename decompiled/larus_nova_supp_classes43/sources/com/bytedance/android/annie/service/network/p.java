package com.bytedance.android.annie.service.network;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final p a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RequestMethod.values().length];
            r0[RequestMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[RequestMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[RequestMethod.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[RequestMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[RequestMethod.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
        a = new p();
    }

    public p() {
    }

    public static Triple a(g r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        Pair r11 = UrlUtils.parseUrl(new UrlBuilder(r10.a).build(), r0);
        return new Triple((String) r11.first, (String) r11.second, r0);
    }

    public static List b(g r10) {
        ArrayList r0 = new ArrayList();
        LinkedHashMap<String, String> r11 = r10.b;
        if (r11 == null) goto L8;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r12.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
    L8:
        return r0;
    }

    public static int c(String r14) {
        if (r14 != null) goto L13;
        return 0;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        int r10 = StringsKt.lastIndexOf$default(r14, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L7
        return CastIntegerProtector.parseInt(r14.substring(r10 + 18, StringsKt.indexOf$default(r14, ',', r10, false, 4, null)));
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r15) == false) goto L12;
        r15 = 0;
    L12:
        return ((Number) r15).intValue();
    }

    public static TypedOutput d(g r10) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        LinkedHashMap<String, File> r1 = r10.e;
        if (r1 == null) goto L21;
        if ((!r1.isEmpty()) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L21;
        MultipartTypedOutput r11 = new MultipartTypedOutput();
        Map<String, String> r12 = r10.d;
        if (r12 == null) goto L15;
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        Map.Entry<String, String> r14 = r13.next();
        r11.addPart(r14.getKey(), new TypedString(r14.getValue()));
    L15:
        Iterator<Map.Entry<String, File>> r15 = r1.entrySet().iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        Map.Entry<String, File> r16 = r15.next();
        r11.addPart(r16.getKey(), new TypedFile(null, r16.getValue()));
        goto L17
    L19:
        r0.element = r11;
    L21:
        return (TypedOutput) r0.element;
    }
}
