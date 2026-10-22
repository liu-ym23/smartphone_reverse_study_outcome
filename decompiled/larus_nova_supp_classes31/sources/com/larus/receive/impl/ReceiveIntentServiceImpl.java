package com.larus.receive.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.larus.receive.api.IReceiveIntentService;
import com.larus.receive.impl.handler.b;
import com.larus.receive.impl.handler.c;
import com.larus.receive.impl.handler.d;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/receive/impl/ReceiveIntentServiceImpl;", "Lcom/larus/receive/api/IReceiveIntentService;", "<init>", "()V", "handlers", "", "Lcom/larus/receive/impl/handler/IReceiveContentHandler;", "handler", "isReceive", "", "intent", "Landroid/content/Intent;", "parseUris", "", "Landroid/net/Uri;", "handle", "", "context", "Landroid/content/Context;", "currentPage", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ReceiveIntentServiceImpl implements IReceiveIntentService {
    public final List<b> a;
    public b b;

    public static final class a {
    }

    static {
    }

    public ReceiveIntentServiceImpl() {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.add(new c());
        r0.add(new d());
        r0.add(new com.larus.receive.impl.handler.a());
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("handle, handler:");
        b r2 = this.b;
        if (r2 == null) goto L5;
        String r3 = r2.getName();
    L6:
        r1.append(r3);
        r1.append(",currentPage:landing");
        r0.i("ReceiveIntentServiceImpl", r1.toString());
        b r4 = this.b;
        if (r4 == null) goto L9;
        r4.a(r5);
    L9:
        this.b = null;
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final boolean b(Intent r5) {
        Intrinsics.checkNotNullParameter(r5, "intent");
        String r1 = null;
        if (this.b != null) goto L12;
        Iterator<T> r0 = this.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        if (((b) r2).b(r5) == false) goto L6;
    L11:
        this.b = (b) r2;
        goto L12
    L10:
        r2 = null;
    L12:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("isReceive, type:");
        r4.append(r5.getType());
        r4.append(",handler:");
        b r6 = this.b;
        if (r6 == null) goto L15;
        r1 = r6.getName();
    L15:
        r4.append(r1);
        r3.i("ReceiveIntentServiceImpl", r4.toString());
        if (this.b == null) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final List<Uri> c(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return qs9.a.b(r2);
    }
}
