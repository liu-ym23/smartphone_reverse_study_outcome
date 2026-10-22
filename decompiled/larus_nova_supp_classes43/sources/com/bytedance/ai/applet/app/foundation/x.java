package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.applet.app.base.ApplicationStorage;
import com.bytedance.keva.Keva;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x implements ApplicationStorage, w {
    public final Keva a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final void clear() {
        this.a.clear();
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final ApplicationStorage.b getInfo() {
        Map r0 = this.a.getAll();
        Intrinsics.checkNotNull(r0);
        Iterator r1 = r0.entrySet().iterator();
        long r10 = 0;
    L4:
        if (r1.hasNext() == false) goto L15;
        Map.Entry r11 = (Map.Entry) r1.next();
        String r12 = (String) r11.getKey();
        Object r13 = r11.getValue();
        Intrinsics.checkNotNull(r12);
        Charset r14 = Charsets.UTF_8;
        r10 = r10 + ((long) r12.getBytes(r14).length);
        if (r13 != null) goto L9;
        String r15 = null;
    L12:
        if (r15 == null) goto L4;
        r10 = r10 + ((long) r15.getBytes(r14).length);
        goto L4
    L9:
        if ((r13 instanceof String) == false) goto L11;
        r15 = (String) r13;
        goto L12
    L11:
        r15 = r13.toString();
        goto L12
    L15:
        return new ApplicationStorage.b(CollectionsKt.toList(r0.keySet()), (int) (r10 / ((long) 1024)));
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final String get(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.a.getString(r10, null);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final void remove(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.a.erase(r10);
    }

    public x(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "userId");
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
        this.a = Keva.getRepo("applet_app_storage_" + r10 + '_' + r11);
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final ApplicationStorage.a b(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        if (r12 != null) goto L6;
        remove(r11);
        return ApplicationStorage.a.b.a;
    L6:
        long r0 = r12.getBytes(Charsets.UTF_8).length;
        if (r0 > 1048576) goto L9;
        Map r10 = this.a.getAll();
        Intrinsics.checkNotNull(r10);
        Iterator r13 = r10.entrySet().iterator();
        long r14 = 0;
    L12:
        if (r13.hasNext() == false) goto L25;
        Map.Entry r15 = (Map.Entry) r13.next();
        String r16 = (String) r15.getKey();
        Object r17 = r15.getValue();
        if (Intrinsics.areEqual(r16, r11) == true) goto L12;
        Intrinsics.checkNotNull(r16);
        Charset r18 = Charsets.UTF_8;
        r14 = r14 + ((long) r16.getBytes(r18).length);
        if (r17 != null) goto L19;
        String r19 = null;
    L22:
        if (r19 == null) goto L12;
        r14 = r14 + ((long) r19.getBytes(r18).length);
        goto L12
    L19:
        if ((r17 instanceof String) == false) goto L21;
        r19 = (String) r17;
        goto L22
    L21:
        r19 = r17.toString();
        goto L22
    L25:
        if ((r14 + (((long) r11.getBytes(Charsets.UTF_8).length) + r0)) > 10485760) goto L27;
        this.a.storeString(r11, r12);
        return ApplicationStorage.a.b.a;
    L27:
        return new ApplicationStorage.a.C0015a(ApplicationStorage.StorageError.EXCEED_TOTAL_MAX_SIZE);
    L9:
        return new ApplicationStorage.a.C0015a(ApplicationStorage.StorageError.EXCEED_ITEM_MAX_SIZE);
    }
}
