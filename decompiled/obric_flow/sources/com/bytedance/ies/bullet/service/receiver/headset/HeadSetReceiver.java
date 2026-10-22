package com.bytedance.ies.bullet.service.receiver.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/receiver/headset/HeadSetReceiver;", "Landroid/content/BroadcastReceiver;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nHeadSetReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeadSetReceiver.kt\ncom/bytedance/ies/bullet/service/receiver/headset/HeadSetReceiver\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,122:1\n181#2,2:123\n181#2,2:125\n*E\n*S KotlinDebug\n*F\n+ 1 HeadSetReceiver.kt\ncom/bytedance/ies/bullet/service/receiver/headset/HeadSetReceiver\n*L\n94#1,2:123\n102#1,2:125\n*E\n"})
public final class HeadSetReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f6124b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6125a;

    public HeadSetReceiver() {
        this.f6125a = new LinkedHashMap();
    }

    public final void a() {
        LinkedHashMap r5 = this.f6125a;
        monitor-enter(r5);
        Iterator r10 = this.f6125a.entrySet().iterator();     // Catch: Throwable -> L9
        if (r10.hasNext() == true) goto L12;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L12:
        if (((Map.Entry) r10.next()).getValue() != null) goto L16;
        throw null;     // Catch: Throwable -> L9
    L16:
        throw new ClassCastException();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r10, Intent r11) {
        boolean r12 = b.f5956a;
        StringBuilder r13 = new StringBuilder("onReceive broadcast receiver, action=");
        if (r11 == null) goto L5;
        String r5 = r11.getAction();
    L6:
        r13.append(r5);
        String r14 = r13.toString();
        LogLevel r15 = LogLevel.f5954b;
        b.c(r15, r14);
        if (r11 == null) goto L49;
        String r16 = r11.getAction();
        if (r16 == null) goto L47;
        int r17 = r16.hashCode();
        if (r17 == (-1676458352)) goto L29;
        if (r17 == 545516589) goto L17;
        return;
    L17:
        if (r16.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L51;
        int r18 = r11.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
        String r19 = r11.getStringExtra("android.bluetooth.device.extra.DEVICE");
        b.c(r15, "action = ACTION_CONNECTION_STATE_CHANGED, state=" + r18 + ", device=" + r19);
        if (r18 != 0) goto L22;
        b.c(r15, "BT headset connection state change, device=" + r19 + ", disconnected");
        a();
        return;
    L22:
        if (r18 != 2) goto L52;
        b.c(r15, "BT headset connection state change, device=" + r19 + ", connected");
        a();
        return;
    L52:
        return;
    L51:
        return;
    L29:
        if (r16.equals("android.intent.action.HEADSET_PLUG") == false) goto L53;
        b.c(r15, "action = ACTION_HEADSET_PLUG, state=" + r11.getIntExtra("state", -1) + ", device=" + r11.getStringExtra("name") + ", hasMicrophone=" + r11.getIntExtra("microphone", -1));
        LinkedHashMap r20 = this.f6125a;
        monitor-enter(r20);
        Iterator r21 = this.f6125a.entrySet().iterator();     // Catch: Throwable -> L38
        if (r21.hasNext() == true) goto L41;
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r20);
        return;
    L41:
        if (((Map.Entry) r21.next()).getValue() != null) goto L44;
        throw null;     // Catch: Throwable -> L38
    L44:
        throw new ClassCastException();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L53:
        return;
    L47:
        return;
    L49:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
