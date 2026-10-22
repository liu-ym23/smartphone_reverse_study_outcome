package com.obric.memorydata.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\b\u0002\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072&\u0010\u000e\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00110\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"paginationQuery", "", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "projection", "", "", "paginationColumnName", "pageLimit", "", "selection", "selectionArgs", "callback", "Lkotlin/Function1;", "", "", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class aj {
    public static final void a(ContentResolver r20, Uri r21, String[] r22, String r23, int r24, String r25, String[] r26, Function1<? super List<? extends Map<String, String>>, Unit> r27) {
        String[] r0 = r22;
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r27, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "contentResolver");
        Intrinsics.checkNotNullParameter(r21, "uri");
        Intrinsics.checkNotNullParameter(r0, "projection");
        Intrinsics.checkNotNullParameter(r23, "paginationColumnName");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Long r16 = null;
    L3:
        if (r16 == null) goto L5;
        String r1 = r23 + " > ?";
    L7:
        if (r16 == null) goto L9;
        String[] r2 = {r16.toString()};
    L10:
        if (r25 == null) goto L14;
        if (r1 == null) goto L13;
        r1 = r25 + " AND " + r1;
        goto L14
    L13:
        String r4 = r25;
    L15:
        if (r26 == null) goto L19;
        if (r2 == null) goto L18;
        String[] r5 = (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r26, r2), String[].class, "com.obric.memorydata.plugin");
    L20:
        Cursor r3 = ZeusProviderTransform.query(r20, r21, r22, r4, r5, r23 + " ASC", "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L40;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r8 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
    L25:
        if (r8.moveToNext() == false) goto L30;
        long r9 = r8.getLong(r8.getColumnIndexOrThrow(r23));     // Catch: Throwable -> L32
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        int r11 = r0.length;     // Catch: Throwable -> L32
        int r15 = 0;
    L27:
        if (r15 >= r11) goto L29;
        int r17 = r11;
        String r13 = r0[r15];     // Catch: Throwable -> L32
        r10.put(r13, r8.getString(r8.getColumnIndexOrThrow(r13)));     // Catch: Throwable -> L32
        r15 = r15 + 1;     // Catch: Throwable -> L32
        r0 = r22;
        r11 = r17;
        goto L27
    L29:
        r6.add(r10);     // Catch: Throwable -> L32
        r16 = Long.valueOf(r9);     // Catch: Throwable -> L32
        r0 = r22;
        goto L25
    L30:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L32
        CloseableKt.closeFinally(r7, null);
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L40:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L43;
        r12.invoke(r6);
    L43:
        if (r6.size() < r24) goto L44;
        r0 = r22;
        goto L3
    L44:
        return;
    L18:
        r5 = r26;
        goto L20
    L19:
        r5 = r2;
    L14:
        r4 = r1;
        goto L15
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
