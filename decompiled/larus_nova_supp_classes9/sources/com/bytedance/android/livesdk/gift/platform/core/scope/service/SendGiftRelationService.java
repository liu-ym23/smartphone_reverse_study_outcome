package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SendGiftRelationService implements dy0.c, com.bytedance.android.scope.o {
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final a e = null;
    public final ArrayDeque<p3> a;
    public volatile boolean b;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "sendGiftRelationCacheCount", "getSendGiftRelationCacheCount()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "sendGiftRelationExpireTime", "getSendGiftRelationExpireTime()I", 0))};
        }

        public a() {
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    static {
        e = new a();
        Class r2 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_relation_cache_count", 10, r2, false);
        KProperty[] r1 = a.a;
        KProperty r10 = r1[0];
        c = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_relation_expire_time", 7, r2, false);
        KProperty r8 = r1[1];
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r8);
    }

    public SendGiftRelationService() {
        this.a = new ArrayDeque();
    }

    public final int a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L21:
        return 0;
    L5:
        if (this.a.isEmpty() == true) goto L21;
        Iterator r0 = CollectionsKt.toList(this.a).iterator();
    L9:
        if (r0.hasNext() == false) goto L21;
        p3 r2 = (p3) r0.next();
        if (r2 == null) goto L13;
        String r3 = r2.b();
    L15:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        if (Intrinsics.areEqual(r5, r2.b()) == false) goto L9;
        return r2.getType();
    L13:
        r3 = null;
        goto L15
    }

    public final boolean f(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (a(r4) != 0) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void g(String r9, SendGiftSource r10) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        Intrinsics.checkNotNullParameter(r10, "sendSource");
        if (r10 != SendGiftSource.GiftDialog) goto L5;
        int r11 = 2;
    L7:
        if (TextUtils.isEmpty(r9) == false) goto L9;
        return;
    L9:
        Iterator r0 = this.a.iterator();
        int r4 = 0;
    L11:
        if (r0.hasNext() == false) goto L23;
        p3 r5 = (p3) r0.next();
        if (r5 != null) goto L15;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == true) goto L24;
        r4 = r4 + 1;
    L24:
        if (r4 != (-1)) goto L30;
        p3 r1 = new p3(r9, System.currentTimeMillis(), r11);
    L26:
        int r13 = this.a.size();
        a r14 = e;
        r14.getClass();
        if (r13 < ((Number) c.getValue(r14, a.a[0])).intValue()) goto L29;
        this.a.removeFirst();
        goto L26
    L29:
        this.a.addLast(r1);
    L35:
        Single.create(new q3(new SendGiftRelationService$onSendGift$1(this))).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L30:
        p3 r15 = (p3) this.a.remove(r4);
        r15.c(System.currentTimeMillis());
        if (r15.getType() == 2) goto L34;
        if (r11 != 2) goto L34;
        r15.d(r11);
    L34:
        this.a.addLast(r15);
        goto L35
    L15:
        if (TextUtils.isEmpty(r5.b()) == true) goto L19;
        if (Intrinsics.areEqual(r5.b(), r9) == false) goto L19;
        r6 = true;
        goto L20
    L23:
        r4 = -1;
        goto L24
    L5:
        r11 = 1;
        goto L7
    }
}
