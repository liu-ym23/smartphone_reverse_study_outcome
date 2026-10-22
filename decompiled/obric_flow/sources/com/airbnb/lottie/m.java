package com.airbnb.lottie;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.flow.cardlistpage.data.CardDatabase_Impl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Callable, pt.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1282b;

    public /* synthetic */ m(Object r5, int r10) {
        this.f1281a = r10;
        this.f1282b = r5;
    }

    @Override // pt.o
    public Object apply(Object r5) {
        return this.f1282b;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean r5 = true;
        Uri r10 = null;
        xd.b r11 = null;
        z4.a r12 = null;
        switch(this.f1281a) {
            case 0: goto L183;
            case 1: goto L181;
            case 2: goto L178;
            case 3: goto L165;
            case 4: goto L129;
            case 5: goto L125;
            case 6: goto L67;
            case 7: goto L65;
            case 8: goto L28;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L4;
        };
    L4:
        w.c r13 = (w.c) this.f1282b;
        monitor-enter(r13);
        w.c r14 = (w.c) this.f1282b;     // Catch: Throwable -> L10
        if (r14.f22661i != null) goto L12;
        monitor-exit(r13);     // Catch: Throwable -> L10
    L16:
        return null;
    L12:
        r14.N();     // Catch: Throwable -> L10
        if (((w.c) this.f1282b).n() == false) goto L15;
        ((w.c) this.f1282b).L();     // Catch: Throwable -> L10
        ((w.c) this.f1282b).f22663k = 0;     // Catch: Throwable -> L10
    L15:
        monitor-exit(r13);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L21:
        com.obric.flow.cardlistpage.data.h r15 = (com.obric.flow.cardlistpage.data.h) this.f1282b;
        com.obric.flow.cardlistpage.data.f r16 = r15.e;
        SupportSQLiteStatement r17 = r16.acquire();
        r17.bindString(1, "card_instance_id");
        r17.bindLong(2, 1);
        CardDatabase_Impl r18 = r15.f11479a;
        r18.beginTransaction();
        r17.executeInsert();     // Catch: Throwable -> L25
        r18.setTransactionSuccessful();     // Catch: Throwable -> L25
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r18.endTransaction();
        r16.release(r17);
        return r19;
    L25:
        th = move-exception;
        r18.endTransaction();
        r16.release(r17);
        throw th;
    L28:
        xd.a r20 = xd.c.f23102a;
        BulletCardView r110 = (BulletCardView) this.f1282b;
        Context r21 = r110.getContext().getApplicationContext();
        com.bytedance.ies.bullet.ui.common.b r111 = r110.f6173k;
        Intrinsics.checkNotNullParameter(r21, "appContext");
        if (r111 == null) goto L64;
        AtomicBoolean r22 = xd.c.f23104c;
        if (r22.get() == false) goto L35;
    L56:
        CopyOnWriteArrayList r23 = xd.c.d;
        Iterator r24 = r23.iterator();
    L58:
        if (r24.hasNext() == false) goto L62;
        if (Intrinsics.areEqual(((WeakReference) r24.next()).get(), r111) == false) goto L58;
    L62:
        r23.add(new WeakReference(r111));
        goto L64
    L35:
        if (xd.c.f23102a != null) goto L38;
        Uri r25 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullParameter(r25, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r21, "appContext");
        xd.c.f23102a = new xd.a(r21, r25);
    L38:
        if (xd.c.f23103b != null) goto L184;
        xd.c.f23103b = new xd.b(r21, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    L184:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L43
        ContentResolver r27 = r21.getContentResolver();     // Catch: Throwable -> L43
        Uri r28 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;     // Catch: Throwable -> L43
        xd.a r29 = xd.c.f23102a;     // Catch: Throwable -> L43
        if (r29 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("internalObserver");     // Catch: Throwable -> L43
        r29 = null;
    L45:
        r27.registerContentObserver(r28, true, r29);     // Catch: Throwable -> L43
        ContentResolver r30 = r21.getContentResolver();     // Catch: Throwable -> L43
        Uri r31 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L43
        xd.b r32 = xd.c.f23103b;     // Catch: Throwable -> L43
        if (r32 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("externalObserver");     // Catch: Throwable -> L43
    L49:
        r30.registerContentObserver(r31, true, r11);     // Catch: Throwable -> L43
        Object r33 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L52:
        Throwable r34 = Result.m127exceptionOrNullimpl(r33);
        if (r34 == null) goto L55;
        r34.printStackTrace();
    L55:
        r22.set(true);
        goto L56
    L48:
        r11 = r32;
    L43:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r33 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L64:
        return Unit.INSTANCE;
    L65:
        ((a6.a) this.f1282b).run();
        return Unit.INSTANCE;
    L67:
        com.bytedance.ies.bullet.service.monitor.h r112 = (com.bytedance.ies.bullet.service.monitor.h) this.f1282b;
        s6.c r36 = r112.f6053o;
        com.bytedance.ies.bullet.core.e r113 = r112.o();
        r36.getClass();
        Intrinsics.checkNotNullParameter(r113, "context");
        JSONObject r37 = r113.d.f5324c;
        z4.a r38 = r113.f5308w.f5278i;
        if (r38 == null) goto L70;
        r12 = r38;
    L70:
        if (r12 == null) goto L124;
        AtomicBoolean r39 = (AtomicBoolean) r12.f23391c;
        if (r39 == null) goto L124;
        if (r39.get() != true) goto L124;
        JSONObject r40 = new JSONObject();
        Intrinsics.checkNotNullParameter("memory_warning", "stepName");
        Long r41 = (Long) ((ConcurrentHashMap) r12.f23390b).get("memory_warning");
        if (r41 != null) goto L78;
        long r42 = -1;
    L80:
        if (r42 == (-1)) goto L82;
        r40.put("stack_on_memory_warning", (String) r12.e);
    L82:
        JSONObject r43 = new JSONObject();
        Iterator r44 = ((ConcurrentHashMap) r12.f23389a).keySet().iterator();
    L84:
        if (r44.hasNext() == false) goto L90;
        String r45 = (String) r44.next();
        Intrinsics.checkNotNullParameter(r45, "stepName");
        Double r114 = (Double) ((ConcurrentHashMap) r12.f23389a).get(r45);
        if (r114 != null) goto L88;
        double r115 = -1.0d;
    L89:
        r43.put(r45, r115);
        goto L84
    L88:
        r115 = r114.doubleValue();
        goto L89
    L90:
        JSONObject r46 = new JSONObject();
        Iterator r47 = ((ConcurrentHashMap) r12.f23390b).keySet().iterator();
    L92:
        if (r47.hasNext() == false) goto L98;
        String r116 = (String) r47.next();
        Intrinsics.checkNotNullParameter(r116, "stepName");
        Long r117 = (Long) ((ConcurrentHashMap) r12.f23390b).get(r116);
        if (r117 != null) goto L96;
        long r118 = -1;
    L97:
        r46.put(r116, r118);
        goto L92
    L96:
        r118 = r117.longValue();
        goto L97
    L98:
        r113.f5293c.k("bdx_monitor_memory", r40, r46);
        r113.f5293c.k("bdx_monitor_cpu", r40, r43);
        com.bytedance.ies.bullet.service.base.x r48 = (com.bytedance.ies.bullet.service.base.x) r36.f21829c;
        if (((ad.a) r48.f6027j) != null) goto L101;
        r48.f6027j = r113.f5303q;
    L101:
        JSONObject r49 = (JSONObject) ((com.bytedance.ies.bullet.service.base.x) r36.f21829c).e;
        if (r49 == null) goto L104;
        td.b.f(r49, r37);
    L104:
        tc.c r50 = tc.c.f22119c;
        tc.c r51 = tc.c.f22119c;
        String r52 = r113.f;
        String r53 = "default_bid";
        if (r52 != null) goto L107;
        r52 = "default_bid";
    L107:
        com.bytedance.ies.bullet.service.base.i r54 = (com.bytedance.ies.bullet.service.base.i) r51.a(com.bytedance.ies.bullet.service.base.i.class, r52);
        if (r54 == null) goto L110;
        ((com.bytedance.ies.bullet.service.monitor.i) r54).d((com.bytedance.ies.bullet.service.base.x) r36.f21829c);
    L110:
        com.bytedance.ies.bullet.service.base.x r55 = (com.bytedance.ies.bullet.service.base.x) r36.f21828b;
        if (((ad.a) r55.f6027j) != null) goto L113;
        r55.f6027j = r113.f5303q;
    L113:
        JSONObject r56 = (JSONObject) ((com.bytedance.ies.bullet.service.base.x) r36.f21828b).e;
        if (r56 == null) goto L116;
        td.b.f(r56, r37);
    L116:
        tc.c r57 = tc.c.f22119c;
        String r119 = r113.f;
        if (r119 == null) goto L120;
        r53 = r119;
    L120:
        com.bytedance.ies.bullet.service.base.i r120 = (com.bytedance.ies.bullet.service.base.i) r57.a(com.bytedance.ies.bullet.service.base.i.class, r53);
        if (r120 == null) goto L124;
        ((com.bytedance.ies.bullet.service.monitor.i) r120).d((com.bytedance.ies.bullet.service.base.x) r36.f21828b);
        goto L124
    L78:
        r42 = r41.longValue();
    L124:
        return Unit.INSTANCE;
    L125:
        fo.b r121 = (fo.b) this.f1282b;
        if (r121 == null) goto L203;
        r121.a("file not found");
        return Unit.INSTANCE;
    L203:
        return null;
    L129:
        com.bytedance.ies.bullet.lynx.d r58 = ((com.bytedance.ies.bullet.lynx.h) this.f1282b).f5637b;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.settings.b.class, "clazz");
        tc.c r59 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r60 = (com.bytedance.ies.bullet.settings.b) tc.c.f22119c.a(com.bytedance.ies.bullet.settings.b.class, r58.f22117a);
        if (r60 == null) goto L136;
        com.bytedance.ies.bullet.service.base.d r61 = (com.bytedance.ies.bullet.service.base.d) r60.f6163b.getValue();
        if (r61 == null) goto L136;
        ArrayList r62 = r61.f5963a;
        if (r62 == null) goto L136;
    L137:
        boolean r63 = r62.isEmpty();
        Iterator r64 = r62.iterator();
    L139:
        if (r64.hasNext() == false) goto L147;
        String r65 = (String) r64.next();
        com.bytedance.ies.bullet.service.base.a0 r66 = ((com.bytedance.ies.bullet.lynx.h) this.f1282b).f5642k;
        if (r66 == null) goto L143;
        Uri r67 = r66.f5932a;
    L145:
        if (StringsKt.g(String.valueOf(r67), r65) == false) goto L139;
    L148:
        com.bytedance.ies.bullet.service.base.a0 r68 = ((com.bytedance.ies.bullet.lynx.h) this.f1282b).f5642k;
        if (r68 == null) goto L156;
        InputStream r69 = r68.c();
        if (r69 == null) goto L156;
        r69.reset();     // Catch: Throwable -> L154
    L154:
        th = move-exception;
        boolean r70 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "lynx error, read file failed " + th.getMessage(), "XLynxKit");
    L156:
        if (r5 == false) goto L164;
        if (((com.bytedance.ies.bullet.lynx.h) this.f1282b).f5642k == null) goto L164;
        boolean r71 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r72 = new StringBuilder("lynx error, 100 error,delete local resource url=");
        com.bytedance.ies.bullet.service.base.a0 r73 = ((com.bytedance.ies.bullet.lynx.h) this.f1282b).f5642k;
        if (r73 == null) goto L162;
        r10 = r73.f5932a;
    L162:
        r72.append(r10);
        com.bytedance.ies.bullet.service.base.b.a(2, r72.toString(), "XLynxKit");
        ConcurrentHashMap r74 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        com.bytedance.ies.bullet.kit.resourceloader.h r75 = com.bytedance.ies.bullet.kit.resourceloader.g.a(((com.bytedance.ies.bullet.lynx.h) this.f1282b).f5637b.f22117a);
        com.bytedance.ies.bullet.service.base.a0 r122 = ((com.bytedance.ies.bullet.lynx.h) this.f1282b).f5642k;
        Intrinsics.checkNotNull(r122);
        r75.f(r122);
    L164:
        return Unit.INSTANCE;
    L143:
        r67 = null;
        goto L145
    L147:
        r5 = r63;
    L136:
        r62 = new ArrayList();
        goto L137
    L165:
        com.bytedance.android.anniex.worker.b r76 = com.bytedance.android.anniex.worker.b.f3505a;
        Uri r123 = Uri.parse((String) this.f1282b);
        Intrinsics.checkNotNullParameter(r123, "<this>");
        if (Intrinsics.areEqual(r123.getScheme(), "http") == false) goto L168;
    L175:
        String r77 = r123.toString();
    L176:
        String r124 = String.valueOf(r77);
        Intrinsics.checkNotNullParameter(r124, "url");
        String r125 = Uri.parse(r124).buildUpon().clearQuery().build().toString();
        HashMap r78 = new HashMap();
        r78.put("current_page_url", r125);
        com.bytedance.ies.xbridge.event.a r126 = new com.bytedance.ies.xbridge.event.a("page_destroy", System.currentTimeMillis());
        r126.f6325c = r78;
        com.bytedance.ies.xbridge.event.b.a(r126);
        com.bytedance.android.anniex.worker.b.d("page_destroy", r78);
        return Unit.INSTANCE;
    L168:
        if (Intrinsics.areEqual(r123.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L175;
        r77 = io.reactivex.exceptions.a.h(r123, "a_surl");
        if (r77 != null) goto L176;
        r77 = io.reactivex.exceptions.a.h(r123, "surl");
        if (r77 != null) goto L176;
        r77 = io.reactivex.exceptions.a.h(r123, "url");
        goto L176
    L178:
        ((Function0) this.f1282b).invoke();
        return Unit.INSTANCE;
    L20:
        return this.f1282b;
    L181:
        return new a0((h) this.f1282b);
    L183:
        return n.b((ByteArrayInputStream) this.f1282b, null);
    }
}
