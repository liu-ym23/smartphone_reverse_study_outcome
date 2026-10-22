package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import e7.f0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements q9.c {
    public final /* synthetic */ g a;
    public final /* synthetic */ f0 b;
    public final /* synthetic */ ContentResolver c;

    @Override // q9.c
    public final void onResult(boolean r10, Map<String, ? extends PermissionStatus> r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        if (r10 == false) goto L5;
        this.a.j(this.b, this.c);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Iterator r12 = ((LinkedHashMap) r11).values().iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        if (((PermissionStatus) r12.next()) != PermissionStatus.DENIED) goto L7;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        g r14 = this.a;
        CreateCalendarEventResultModel r15 = new CreateCalendarEventResultModel();
        r15.a(CreateCalendarEventResultModel.Code.NoPermission);
        r15.b("user denied permission");
        r14.finishWithResult(r15);
        return;
    L14:
        g r16 = this.a;
        CreateCalendarEventResultModel r17 = new CreateCalendarEventResultModel();
        r17.a(CreateCalendarEventResultModel.Code.NoPermission);
        r17.b("user rejected permission");
        r16.finishWithResult(r17);
        return;
    L11:
        r13 = false;
        goto L12
    }

    public k(g r1, f0 r10, ContentResolver r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
