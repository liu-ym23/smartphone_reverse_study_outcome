package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import com.bytedance.android.annie.bridge.method.abs.DeleteCalendarEventResultModel;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import e7.g0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements q9.c {
    public final /* synthetic */ o a;
    public final /* synthetic */ g0 b;
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
        o r14 = this.a;
        DeleteCalendarEventResultModel r15 = new DeleteCalendarEventResultModel();
        r15.a(DeleteCalendarEventResultModel.Code.NoPermission);
        r15.b("user denied permission");
        r14.finishWithResult(r15);
        return;
    L14:
        o r16 = this.a;
        DeleteCalendarEventResultModel r17 = new DeleteCalendarEventResultModel();
        r17.a(DeleteCalendarEventResultModel.Code.NoPermission);
        r17.b("user rejected permission");
        r16.finishWithResult(r17);
        return;
    L11:
        r13 = false;
        goto L12
    }

    public p(o r1, g0 r10, ContentResolver r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
