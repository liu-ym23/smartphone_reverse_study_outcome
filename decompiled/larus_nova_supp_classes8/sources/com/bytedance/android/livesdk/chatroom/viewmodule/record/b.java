package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.user.api.a a;
    public final /* synthetic */ AdminRecordPermissionChanger b;

    public b(com.bytedance.android.live.user.api.a r1, AdminRecordPermissionChanger r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        List r5 = (List) r4;
        AdminRecordPermissionChanger r0 = this.b;
        com.bytedance.android.live.user.api.a r1 = this.a;
        r0.getClass();
        if (((Boolean) r1.isAdmin().getValue()).booleanValue() == false) goto L10;
        Intrinsics.checkNotNullParameter(r5, "$this$getAllPermissions");
        List r6 = r5;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r2.add(((ec1.a) r7.next()).a);
        goto L6
    L8:
        LiveRoomPermission.D.getClass();
        if (r2.contains(LiveRoomPermission.y) == true) goto L10;
        return;
    L10:
        ALogger.i(r0.a, "录屏权限被下掉了");
        Function1<Boolean, Unit> r8 = r0.e;
        if (r8 == null) goto L16;
        Unit r9 = (Unit) r8.invoke(Boolean.FALSE);
        return;
    }
}
