package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h6 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ w20.ua b;

    public h6(String r1, w20.ua r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        File r1 = new PolarisFileWrapper(this.a);
        ArrayList r2 = new ArrayList();
        File[] r3 = r1.listFiles();
        boolean r5 = false;
        long r6 = 0;
        if (r3 == null) goto L11;
        int r8 = r3.length;
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L11;
        File r11 = r3[r9];
        r6 = r6 + (r11.length() / ((long) 1048576));
        String r12 = r11.getName();
        int r13 = StringsKt.indexOf$default(r12, Item.MIX_ID_SEPERATOR, 0, false, 6, null);
        if (r12 == null) goto L10;
        r2.add(Long.valueOf(CastLongProtector.parseLong(r12.substring(0, r13))));
        r9 = r9 + 1;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        CollectionsKt.sort(r2);
        Integer r4 = this.b.a();
        if (r4 == null) goto L14;
        long r14 = r4.intValue();
    L15:
        ALogger.i("LiveHighlightTranscodingMethod", "current size = " + r6 + ", maxSize = " + r14);
        int r7 = 0;
    L17:
        if (r6 < r14) goto L36;
        if (r7 >= r2.size()) goto L46;
        String r15 = String.valueOf(((Number) ListProtector.get(r2, r7)).longValue());
        File[] r16 = r1.listFiles();
        if (r16 == null) goto L34;
        int r17 = r16.length;
        int r18 = 0;
    L23:
        if (r18 >= r17) goto L33;
        File r19 = r16[r18];
        File r110 = r1;
        if (StringsKt.contains$default(r19.getName(), r15, r5, 2, null) == false) goto L30;
        long r111 = r6;
        long r0 = r19.length() / ((long) 1048576);
        if (r19.delete() == false) goto L29;
        r6 = r111 - r0;
        ALogger.i("LiveHighlightTranscodingMethod", "delete file path: " + r19.getPath() + ", current size = " + r6);
    L32:
        r18 = r18 + 1;
        r1 = r110;
        r5 = false;
        goto L23
    L29:
        ALogger.e("LiveHighlightTranscodingMethod", "delete failed, file path is " + r19.getPath());
    L31:
        r6 = r111;
        goto L32
    L30:
        r111 = r6;
        goto L31
    L33:
        File r112 = r1;
    L35:
        r7 = r7 + 1;
        r1 = r112;
        r5 = false;
        goto L17
    L34:
        r112 = r1;
        goto L35
    L46:
        return;
    L36:
        return;
    L14:
        r14 = 500;
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
