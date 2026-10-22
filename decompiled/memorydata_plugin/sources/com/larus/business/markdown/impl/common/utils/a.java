package com.larus.business.markdown.impl.common.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u001a(\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00030\f*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004\u001a\u001f\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0002\u0010\u0013\u001a'\u0010\u0014\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0012*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0012¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004\"(\u0010\u0000\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"H\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003*\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00038B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"allExtras", "Ljava/util/WeakHashMap;", "", "", "", EventBody.KEY_VALUE, "extras", "getExtras", "(Ljava/lang/Object;)Ljava/util/Map;", "setExtras", "(Ljava/lang/Object;Ljava/util/Map;)V", "cleanExtra", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "containsExtra", "", "key", "getExtra", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "putExtra", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "removeExtra", "", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<Object, Map<String, Object>> f5174a = null;

    static {
        f5174a = new WeakHashMap();
    }

    public static final <T> T a(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        WeakHashMap<Object, Map<String, Object>> r0 = f5174a;
        monitor-enter(r0);
        Map<String, Object> r4 = a(r2);     // Catch: Throwable -> L13
        T r1 = null;
        if (r4 == null) goto L11;
        Object r5 = r4.get(r3);     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        r1 = (T) r5;
    L11:
        monitor-exit(r0);
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public static final <T> Object a(Object r4, String r5, T r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "key");
        WeakHashMap<Object, Map<String, Object>> r0 = f5174a;
        monitor-enter(r0);
        Map<String, Object> r1 = a(r4);     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        a(r4, r1);     // Catch: Throwable -> L10
    L7:
        Object r7 = r1.put(r5, r6);     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r7;
    L10:
        th = move-exception;
        throw th;
    }

    private static final Map<String, Object> a(Object r2) {
        return (Map) ZeusTransformUtils.preCheckCast(f5174a.get(r2), Map.class, "com.obric.memorydata.plugin");
    }

    private static final void a(Object r3, Map<String, Object> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(f5174a, Map.class, "com.obric.memorydata.plugin")).put(r3, r5);
    }
}
