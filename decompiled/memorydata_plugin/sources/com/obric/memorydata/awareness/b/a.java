package com.obric.memorydata.awareness.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.utils.c;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/oauto/OAutoAppWhiteList;", "", "<init>", "()V", "TAG", "", "queryOAutoWhiteListApp", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8541a = null;

    static {
        f8541a = new a();
    }

    private a() {
    }

    public final List<String> a() {
        Cursor r8 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider/settings/user_whitelist"), null, null, null, null, "com.obric.memorydata.plugin");
        if (r8 == null) goto L28;
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Integer r3 = Integer.valueOf(r1.getColumnIndex("package_name"));     // Catch: Throwable -> L22
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L8;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L21;
        int r4 = r3.intValue();     // Catch: Throwable -> L22
    L16:
        if (r1.moveToNext() == false) goto L21;
        String r5 = r1.getString(r4);     // Catch: Throwable -> L22
        c r6 = c.f13193a;     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L22
        c.a r7 = c.a(r6, r5, null, 2, null);     // Catch: Throwable -> L22
        if (r7 == null) goto L16;
        r2.add(r7.a());     // Catch: Throwable -> L22
    L21:
        CloseableKt.closeFinally(r9, null);
        return r2;
    L8:
        r0 = false;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L28:
        return CollectionsKt.emptyList();
    }
}
