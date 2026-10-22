package com.obric.memorydata.personalcontext.search.bridge.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.personalcontext.search.bridge.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\fJ\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0019\u001a\u00020\fR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchParamsManager;", "", "<init>", "()V", "searchParams", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/obric/memorydata/personalcontext/search/bridge/SearchParamWrapper;", "isDestroyed", "", "addEntityParams", "", "type", "", OaidModel.KEY_ID, "", AutoTestConstant.PARAM, "getEntityParams", "", "getAllEntityParams", "getTypeByKey", "key", "clearAllParams", "getKey", "onDestroy", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<h>> f12286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12287b;

    public d() {
        this.f12286a = new ConcurrentHashMap();
    }

    private final String b(int r1, long r2) {
        return new StringBuilder().append(r1).append('_').append(r2).toString();
    }

    public final String a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        List r7 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"_"}, false, 0, 6, null);
        if (r7.size() == 2) goto L7;
        return StructuredDataId.RESERVED;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin");
    }

    public final List<h> a(int r2, long r3) {
        if (this.f12287b == false) goto L7;
        return null;
    L7:
        return (List) ZeusTransformUtils.preCheckCast(this.f12286a.get(b(r2, r3)), List.class, "com.obric.memorydata.plugin");
    }

    public final ConcurrentHashMap<String, List<h>> a() {
        return this.f12286a;
    }

    public final synchronized void a(int r4, long r5, h r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, AutoTestConstant.PARAM);     // Catch: Throwable -> L16
        if (this.f12287b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ConcurrentMap r0 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.f12286a, ConcurrentMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        String r6 = b(r4, r5);     // Catch: Throwable -> L16
        Object r8 = r0.get(r6);     // Catch: Throwable -> L16
        if (r8 != null) goto L13;
        r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Object r9 = r0.putIfAbsent(r6, r8);     // Catch: Throwable -> L16
        if (r9 == null) goto L13;
        r8 = r9;
    L13:
        ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")).add(r7);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void b() {
        if (this.f12287b == false) goto L5;
        return;
    L5:
        this.f12286a.clear();
    }

    public final void c() {
        this.f12287b = true;
        this.f12286a.clear();
    }
}
