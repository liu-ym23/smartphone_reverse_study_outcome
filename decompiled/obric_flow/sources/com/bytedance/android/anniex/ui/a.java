package com.bytedance.android.anniex.ui;

import android.content.ContentResolver;
import android.content.Context;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.airbnb.lottie.m;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.bytedance.salamander.anniex.b0;
import com.obric.flow.cardlistpage.data.CardDatabase_Impl;
import com.obric.flow.cardlistpage.data.f;
import com.obric.flow.cardlistpage.data.h;
import com.obric.flow.cardlistpage.data.j;
import fo.g;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3494c;

    public /* synthetic */ a(int r5, Object r10, Object r11) {
        this.f3492a = r5;
        this.f3493b = r10;
        this.f3494c = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        int r5 = 2;
        boolean r10 = false;
        String r11 = null;
        xd.b r12 = null;
        r11 = null;
        Object r13 = this.f3493b;
        Object r14 = this.f3494c;
        switch(this.f3492a) {
            case 0: goto L114;
            case 1: goto L98;
            case 2: goto L94;
            case 3: goto L90;
            case 4: goto L65;
            case 5: goto L53;
            case 6: goto L22;
            case 7: goto L15;
            default: goto L4;
        };
    L4:
        h r15 = (h) r14;
        f r16 = r15.d;
        SupportSQLiteStatement r17 = r16.acquire();
        String r18 = (String) r13;
        if (r18 != null) goto L7;
        r17.bindNull(1);
    L8:
        CardDatabase_Impl r19 = r15.f11479a;
        r19.beginTransaction();
        r17.executeUpdateDelete();     // Catch: Throwable -> L12
        r19.setTransactionSuccessful();     // Catch: Throwable -> L12
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r19.endTransaction();
        r16.release(r17);
        return r20;
    L12:
        th = move-exception;
        r19.endTransaction();
        r16.release(r17);
        throw th;
    L7:
        r17.bindString(1, r18);
        goto L8
    L15:
        h r21 = (h) r14;
        CardDatabase_Impl r22 = r21.f11479a;
        r22.beginTransaction();
        r21.f11481c.handleMultiple((j[]) r13);     // Catch: Throwable -> L19
        r22.setTransactionSuccessful();     // Catch: Throwable -> L19
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r22.endTransaction();
        return r23;
    L19:
        th = move-exception;
        r22.endTransaction();
        throw th;
    L22:
        xd.a r24 = xd.c.f23102a;
        Context r25 = ((BulletCardView) r13).getContext().getApplicationContext();
        Intrinsics.checkNotNullParameter(r25, "appContext");
        com.bytedance.ies.bullet.ui.common.b r26 = (com.bytedance.ies.bullet.ui.common.b) r14;
        if (r26 == null) goto L52;
        Iterator r27 = xd.c.d.iterator();
    L27:
        if (r27.hasNext() == false) goto L34;
        WeakReference r28 = (WeakReference) r27.next();
        if (Intrinsics.areEqual(r28.get(), r26) == true) goto L32;
        if (r28.get() != null) goto L27;
    L32:
        xd.c.d.remove(r28);
        goto L27
    L34:
        if (xd.c.d.size() != 0) goto L52;
        if (xd.c.f23104c.get() == false) goto L52;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L41
        ContentResolver r30 = r25.getContentResolver();     // Catch: Throwable -> L41
        xd.a r31 = xd.c.f23102a;     // Catch: Throwable -> L41
        if (r31 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("internalObserver");     // Catch: Throwable -> L41
        r31 = null;
    L43:
        r30.unregisterContentObserver(r31);     // Catch: Throwable -> L41
        ContentResolver r32 = r25.getContentResolver();     // Catch: Throwable -> L41
        xd.b r33 = xd.c.f23103b;     // Catch: Throwable -> L41
        if (r33 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("externalObserver");     // Catch: Throwable -> L41
    L47:
        r32.unregisterContentObserver(r12);     // Catch: Throwable -> L41
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L50:
        xd.c.f23104c.set(false);
        goto L52
    L46:
        r12 = r33;
    L41:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L52:
        return Unit.INSTANCE;
    L53:
        byte[] r35 = ((a0) r13).b();
        g r36 = (g) r14;
        if (r35 != null) goto L56;
    L62:
        b0 r37 = new b0(new Error("InputStream is null"));
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
        r36.a(r37);
        boolean r38 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("get external js resource failed: InputStream is null", LogLevel.d, "XLynxKit ExternalJSProvider");
    L64:
        return Unit.INSTANCE;
    L56:
        if (r35.length != 0) goto L58;
        char r39 = true;
    L60:
        if ((r39 ^ true) != true) goto L62;
        b0 r40 = new b0(r35);
        r40.f7246b = 0;
        r36.a(r40);
        boolean r41 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("get external js resource success", LogLevel.f5954b, "XLynxKit ExternalJSProvider");
        goto L64
    L58:
        r39 = false;
        goto L60
    L65:
        fo.b r42 = (fo.b) r14;
        InputStream r43 = ((a0) r13).c();     // Catch: Throwable -> L73
        if (r43 == null) goto L153;
        ByteArrayOutputStream r44 = new ByteArrayOutputStream();     // Catch: Throwable -> L75
        ByteStreamsKt.copyTo$default(r43, r44, 0, 2, null);     // Catch: Throwable -> L77
        h.f r45 = h.f.b(new a(r5, r42, r44.toByteArray()), h.f.f17263i);     // Catch: Throwable -> L77
        CloseableKt.closeFinally(r44, null);     // Catch: Throwable -> L75
        CloseableKt.closeFinally(r43, null);     // Catch: Throwable -> L73
        return r45;
    L77:
        th = move-exception;
        throw th;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        CloseableKt.closeFinally(r44, th);     // Catch: Throwable -> L75
        throw th;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        throw th;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        CloseableKt.closeFinally(r43, th);     // Catch: Throwable -> L73
        throw th;     // Catch: Throwable -> L73
    L153:
        return h.f.b(new m(r42, 5), h.f.f17263i);
    L73:
        th = move-exception;
        return h.f.b(new a(3, r42, th), h.f.f17263i);
    L90:
        fo.b r46 = (fo.b) r13;
        if (r46 == null) goto L154;
        r46.a("stream write error, " + ((Throwable) r14).getMessage());
        return Unit.INSTANCE;
    L154:
        return null;
    L94:
        fo.b r47 = (fo.b) r13;
        if (r47 == null) goto L155;
        r47.b((byte[]) r14);
        return Unit.INSTANCE;
    L155:
        return null;
    L98:
        ln.a r48 = (ln.a) r14;
        byte[] r49 = ((a0) r13).b();     // Catch: Throwable -> L107
        if (r49 != null) goto L102;
    L109:
        ((zm.c) r48).m(null, new Throwable("ResourceLoader stream empty"));     // Catch: Throwable -> L107
    L133:
    L113:
        return Unit.INSTANCE;
    L102:
        if (r49.length != 0) goto L105;
        r10 = true;
    L105:
        if ((!r10) != true) goto L109;
        ((zm.c) r48).m(r49, null);     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        ((zm.c) r48).m(null, th);
        goto L113
    L114:
        a0 r50 = (a0) r13;
        InputStream r51 = r50.c();
        if (r51 != null) goto L142;
    L120:
        boolean r52 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "lynx error, 100 error,delete local resource url=" + r50.f5932a, "XLynxKit");
        ConcurrentHashMap r53 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        WeakReference r54 = ((b) r14).d;
        if (r54 == null) goto L125;
        AnnieXLynxView r55 = (AnnieXLynxView) r54.get();
        if (r55 == null) goto L125;
        r11 = r55.getBid();
    L125:
        com.bytedance.ies.bullet.kit.resourceloader.g.a(r11).f(r50);
        return Unit.INSTANCE;
    L142:
        r51.reset();     // Catch: Throwable -> L118
    L118:
        th = move-exception;
        boolean r56 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "lynx error, read file failed " + th.getMessage(), "XLynxKit");
        goto L120
    }

    public /* synthetic */ a(h r5, Serializable r10, int r11) {
        this.f3492a = r11;
        this.f3494c = r5;
        this.f3493b = r10;
    }
}
