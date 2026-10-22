package com.larus.uaigc.chat.notification;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/chat/notification/CreationService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Lcom/larus/uaigc/chat/notification/CreationService$CreationServiceBinder;", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "onDestroy", "", "CreationServiceBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationService extends Service {
    public final a a;

    public final class a extends Binder {
        public final /* synthetic */ CreationService a;

        public a(CreationService r1) {
            this.a = r1;
        }
    }

    public CreationService() {
        this.a = new a(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return this.a;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r6, int r7) {
        if (r5 == null) goto L5;
        String r1 = r5.getAction();
    L7:
        if (Intrinsics.areEqual(r1, "delete") == false) goto L20;
        CreationRefreshNotificationStrategy r2 = CreationRefreshNotificationStrategy.a;
        Bundle r3 = r5.getExtras();
        if (r3 == null) goto L20;
        String r4 = r3.getString("task_id");
        if (r4 == null) goto L20;
        int r8 = r3.getInt("notify_id");
        CreationRefreshNotificationStrategy.e.add(r4);
        if (r8 != 107) goto L20;
        CreationRefreshNotificationStrategy.f = true;
        Iterator r9 = CreationRefreshNotificationStrategy.c.entrySet().iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        Job.DefaultImpls.cancel$default(((CreationRefreshNotificationStrategy$a) ((Map.Entry) r9.next()).getValue()).b, null, 1, null);
        goto L17
    L19:
        CreationRefreshNotificationStrategy.c.clear();
        f.d();
    L20:
        super.onStartCommand(r5, r6, r7);
        return 2;
    L5:
        r1 = null;
        goto L7
    }
}
