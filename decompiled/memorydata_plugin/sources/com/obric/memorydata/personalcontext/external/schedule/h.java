package com.obric.memorydata.personalcontext.external.schedule;

import androidx.core.app.NotificationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/IcsEvent;", "Lcom/obric/memorydata/personalcontext/external/schedule/IcsComponent;", "<init>", "()V", "alarms", "", "Lcom/obric/memorydata/personalcontext/external/schedule/IcsAlarm;", "addAlarm", "", NotificationCompat.CATEGORY_ALARM, "toString", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f12172a;

    public h() {
        super("VEVENT");
        this.f12172a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public final void a(e r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_ALARM);
        this.f12172a.add(r2);
    }

    @Override // com.obric.memorydata.personalcontext.external.schedule.g
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("BEGIN:" + a() + "\r\n");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.append(((i) ZeusTransformUtils.preCheckCast(r1.next(), i.class, "com.obric.memorydata.plugin")).toString()).append("\r\n");
        goto L4
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12172a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.append(((e) ZeusTransformUtils.preCheckCast(r2.next(), e.class, "com.obric.memorydata.plugin")).toString());
        goto L8
    L10:
        r0.append("END:" + a() + "\r\n");
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }
}
