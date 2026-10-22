package com.bytedance.ai.file;

import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final File a;
    public final File b;

    public static List c(String r10) {
        List r11 = StringsKt.split$default(r10, new char[]{File.separatorChar}, false, 0, 6, null);
        ArrayList r1 = new ArrayList();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        if (((String) r13).length() <= 0) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L4;
        r1.add(r13);
        goto L4
    L8:
        r14 = false;
        goto L9
    L11:
        return r1;
    }

    public final File a(a r23) {
        Intrinsics.checkNotNullParameter(r23, "file");
        if (r23.c() == false) goto L6;
        File r10 = this.a;
        int r11 = e.a;
        Uri r0 = r23.a;
        Intrinsics.checkNotNullParameter(r0, "uri");
        Pair r1 = TuplesKt.to(r10, r0.getEncodedPath());
    L8:
        File r12 = (File) r1.component1();
        String r13 = (String) r1.component2();
        String r14 = "";
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        String r15 = StringsKt.removeSuffix(StringsKt.removePrefix(r13, "/"), "/");
        boolean r16 = false;
        if (r15.length() != 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == true) goto L52;
        List r18 = StringsKt.split$default(r15, new String[]{"/"}, false, 0, 6, null);
        ArrayList r19 = new ArrayList(r18.size());
        Iterator r20 = r18.iterator();
    L19:
        if (r20.hasNext() == false) goto L50;
        String r21 = (String) r20.next();
        if (r21.length() != 0) goto L23;
        boolean r22 = true;
    L24:
        if (r22 == true) goto L49;
        if (StringsKt.contains(r21, "%2F", true) == true) goto L47;
        String r24 = Uri.decode(r21);
        if (r24 == null) goto L45;
        if (StringsKt.contains$default(r24, '\\', false, 2, null) == true) goto L43;
        if (StringsKt.contains$default(r24, 0, false, 2, null) == true) goto L41;
        if (Intrinsics.areEqual(r24, ".") == true) goto L39;
        if (Intrinsics.areEqual(r24, "..") == true) goto L39;
        r19.add(r24);
    L39:
        throw AppletFileError.InvalidUri.INSTANCE;
    L41:
        throw AppletFileError.InvalidUri.INSTANCE;
    L43:
        throw AppletFileError.InvalidUri.INSTANCE;
    L45:
        throw AppletFileError.InvalidUri.INSTANCE;
    L47:
        throw AppletFileError.InvalidUri.INSTANCE;
    L49:
        throw AppletFileError.InvalidUri.INSTANCE;
    L23:
        r22 = false;
        goto L24
    L50:
        r14 = CollectionsKt.joinToString$default(r19, File.separator, null, null, 0, null, null, 62, null);
    L52:
        if (r14.length() != 0) goto L54;
        r16 = true;
    L54:
        if (r16 == false) goto L56;
        File r25 = r12;
    L74:
        File r26 = r25.getCanonicalFile();     // Catch: Throwable -> L67
        File r27 = r12.getCanonicalFile();     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r26);
        Intrinsics.checkNotNull(r27);
        if (d(r26, r27) == false) goto L63;
        return r26;
    L63:
        throw AppletFileError.PathEscape.INSTANCE;
    L64:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L67:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L56:
        r25 = new PolarisFileWrapper(r12, r14);
        goto L74
    L14:
        r17 = false;
        goto L15
    L6:
        if (r23.b() == false) goto L71;
        File r28 = this.b;
        int r29 = e.a;
        Uri r30 = r23.a;
        Intrinsics.checkNotNullParameter(r30, "uri");
        r1 = TuplesKt.to(r28, r30.getEncodedPath());
        goto L8
    L71:
        throw AppletFileError.InvalidUri.INSTANCE;
    }

    public d(PolarisFileWrapper r10, PolarisFileWrapper r11) {
        Intrinsics.checkNotNullParameter(r10, "userRoot");
        Intrinsics.checkNotNullParameter(r11, "tempRoot");
        this.a = r10;
        this.b = r11;
    }

    public static String b(File r10, File r11) {
        List r12 = c(r10.getPath());
        List r13 = c(r11.getPath());
        ArrayList r14 = (ArrayList) r12;
        ArrayList r15 = (ArrayList) r13;
        if (r14.size() != r15.size()) goto L7;
        return "";
    L7:
        return CollectionsKt.joinToString$default(r14.subList(r15.size(), r14.size()), File.separator, null, null, 0, null, null, 62, null);
    }

    public static boolean d(File r10, File r11) {
        List r12 = c(r10.getPath());
        List r13 = c(r11.getPath());
        ArrayList r1 = (ArrayList) r13;
        if (((ArrayList) r12).size() >= r1.size()) goto L5;
        return false;
    L5:
        int r0 = r1.size();
        int r14 = 0;
    L6:
        if (r14 >= r0) goto L11;
        if (Intrinsics.areEqual(ListProtector.get(r12, r14), ListProtector.get(r13, r14)) == false) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}
