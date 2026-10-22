package com.bytedance.salamander.anniex;

import ai.j0;
import android.util.Log;
import android.widget.LinearLayout;
import com.bytedance.common.wschannel.event.ChannelType;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.google.gson.JsonObject;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.core.LynxEngineProxy;
import com.obric.oui.calendar.CalendarDay;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements com.obric.oui.calendar.e, Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7247c;
    public Object d;

    public /* synthetic */ b0(int r5, byte r10) {
        this.f7245a = r5;
    }

    @Override // com.obric.oui.calendar.e
    public int a(CalendarDay r5) {
        WeekFields r10 = WeekFields.of((DayOfWeek) this.d, 1);
        LocalDate r11 = r5.f12167a.with(r10.dayOfWeek(), 1);
        return (int) ChronoUnit.WEEKS.between(((CalendarDay) this.f7247c).f12167a, r11);
    }

    public String b() {
        StringBuilder r5 = new StringBuilder("$");
        int r10 = this.f7246b + 1;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L19;
        Object r12 = ((Object[]) this.f7247c)[r11];
        if ((r12 instanceof kotlinx.serialization.descriptors.g) == false) goto L15;
        kotlinx.serialization.descriptors.g r13 = (kotlinx.serialization.descriptors.g) r12;
        if (Intrinsics.areEqual(r13.getKind(), kotlinx.serialization.descriptors.n.f19244c) == true) goto L9;
        int r14 = ((int[]) this.d)[r11];
        if (r14 < 0) goto L17;
        r5.append(".");
        r5.append(r13.e(r14));
    L17:
        r11 = r11 + 1;
        goto L3
    L9:
        if (((int[]) this.d)[r11] == (-1)) goto L17;
        r5.append("[");
        r5.append(((int[]) this.d)[r11]);
        r5.append("]");
        goto L17
    L15:
        if (r12 == kotlinx.serialization.json.internal.g.f19424a) goto L17;
        r5.append("['");
        r5.append(r12);
        r5.append("']");
        goto L17
    L19:
        return r5.toString();
    }

    public void c(Object r5) {
        ConcurrentLinkedQueue r10 = (ConcurrentLinkedQueue) this.f7247c;
        r10.add(r5);
        if (r10.size() <= this.f7246b) goto L12;
        Object r11 = r10.poll();
        if (((m.b) this.d) == null) goto L13;
        p7.b r12 = (p7.b) r11;
        if (h7.a.f17286b == false) goto L14;
        String r13 = "evicted Monitorable " + r12;
        if (td.b.f22124a == false) goto L15;
        Log.e("APM-CommonEvent", r13);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.obric.oui.calendar.e
    public int getCount() {
        return this.f7246b;
    }

    @Override // com.obric.oui.calendar.e
    public CalendarDay getItem(int r5) {
        return CalendarDay.c(((CalendarDay) this.f7247c).f12167a.plusWeeks(r5));
    }

    @Override // com.lynx.react.bridge.Callback
    public void invoke(Object... r5) {
        LynxEngineProxy r10 = (LynxEngineProxy) ((WeakReference) this.f7247c).get();
        if (r10 != null) goto L7;
        LynxLog.b(2, "LynxLepusModule", "triggerLepusBridgeAsync failed, LynxEngine has been released.");
        return;
    L7:
        if (r5.length <= 0) goto L10;
        ByteBuffer r11 = kn.b.b(r5[0]);
        com.lynx.tasm.utils.j.f(new com.bytedance.ies.xelement.input.h(r10, this.f7246b, (String) this.d, r11));
        return;
    }

    public String toString() {
        switch(this.f7245a) {
            case 5: goto L11;
            case 6: goto L8;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder("JSBError{isSync=0, errorCode=");
        r5.append(this.f7246b);
        r5.append(", eventType='null', errorMessage='");
        r5.append((String) this.f7247c);
        r5.append("', bridgeName='");
        return j0.q(r5, (String) this.d, "', errorUrl='null', errorActivity='null'}");
    L8:
        StringBuilder r10 = new StringBuilder("ConnectEvent{mType=");
        r10.append((ChannelType) this.f7247c);
        r10.append(", connectionState=");
        r10.append((ConnectionState) this.d);
        r10.append(", mChannelId=");
        return j0.n(r10, this.f7246b, '}');
    L5:
        return super.toString();
    L11:
        return b();
    }

    public b0(int r5, int r10) {
        this.f7245a = r10;
        switch(r10) {
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        ValidateResultCode r11 = ValidateResultCode.f7233c;
        Intrinsics.checkNotNullParameter("validate failed and the field is discarded", "reason");
        Intrinsics.checkNotNullParameter(r11, "code");
        this.f7247c = r11;
        this.f7246b = r5;
        return;
    L6:
        this.f7247c = new ConcurrentLinkedQueue();
        this.f7246b = r5;
    }

    public b0() {
        this.f7245a = 8;
        this.f7247c = new LinkedList();
        this.d = new AtomicBoolean(false);
        this.f7246b = 200;
    }

    public b0(int r5, String r10, JsonObject r11) {
        this.f7245a = 4;
        Intrinsics.checkNotNullParameter(r10, "name");
        this.f7246b = r5;
        this.f7247c = r10;
        this.d = r11;
    }

    public b0(ConnectionState r5, ChannelType r10, int r11) {
        this.f7245a = 6;
        this.d = r5;
        this.f7247c = r10;
        this.f7246b = r11;
    }

    public b0(Throwable r5) {
        this.f7245a = 3;
        this.f7246b = -1;
        this.f7247c = r5;
    }

    public b0(WeakReference r5, int r10, String r11) {
        this.f7245a = 7;
        this.f7247c = r5;
        this.f7246b = r10;
        this.d = r11;
    }

    public b0(Object r5) {
        this.f7245a = 3;
        this.d = r5;
    }

    public b0(String r5, Object r10) {
        this.f7245a = 0;
        ValidateResultCode r11 = ValidateResultCode.f7232b;
        Intrinsics.checkNotNullParameter(r5, "reason");
        Intrinsics.checkNotNullParameter(r11, "code");
        this.f7247c = r11;
        this.d = r10;
    }

    public b0(String r5, int r10, String r11) {
        this.f7245a = 0;
        ValidateResultCode r12 = ValidateResultCode.d;
        Intrinsics.checkNotNullParameter(r5, "reason");
        Intrinsics.checkNotNullParameter(r12, "code");
        this.f7247c = r12;
        this.f7246b = r10;
        this.d = r11;
    }

    public b0(CalendarDay r5, CalendarDay r10, DayOfWeek r11) {
        this.f7245a = 1;
        this.d = r11;
        org.threeten.bp.temporal.g r12 = WeekFields.of(r11, 1).dayOfWeek();
        this.f7247c = CalendarDay.c(r5.f12167a.with(r12, 1));
        this.f7246b = a(r10) + 1;
    }

    public b0(com.obric.oui.privacy.b r5, LinearLayout r10, int r11) {
        this.f7245a = 2;
        this.f7247c = r5;
        this.d = r10;
        this.f7246b = r11;
    }
}
