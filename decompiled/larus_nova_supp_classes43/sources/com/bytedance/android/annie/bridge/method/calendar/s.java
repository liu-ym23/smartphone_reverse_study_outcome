package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import com.bytedance.android.annie.bridge.method.abs.ReadCalendarEventResultModel;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import e7.q0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s implements q9.c {
    public final /* synthetic */ r a;
    public final /* synthetic */ q0 b;
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
        r r14 = this.a;
        ReadCalendarEventResultModel r15 = new ReadCalendarEventResultModel();
        r15.b(ReadCalendarEventResultModel.Code.NoPermission);
        r15.e("user denied permission");
        r14.finishWithResult(r15);
        return;
    L14:
        r r16 = this.a;
        ReadCalendarEventResultModel r17 = new ReadCalendarEventResultModel();
        r17.b(ReadCalendarEventResultModel.Code.NoPermission);
        r17.e("user rejected permission");
        r16.finishWithResult(r17);
        return;
    L11:
        r13 = false;
        goto L12
    }

    public s(r r1, q0 r10, ContentResolver r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
