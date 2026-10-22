package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class c extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function4<Integer, Integer, Integer, Boolean, Unit> f5920a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.f5920a = r10;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        Log.d("WsStatusReceiver", "onReceive() called with: context = " + r10 + ", intent = " + r11);
        Boolean r12 = null;
        if (r11 == null) goto L5;
        Integer r13 = Integer.valueOf(r11.getIntExtra("ws_status_channel_id", 0));
    L6:
        if (r11 == null) goto L8;
        Integer r14 = Integer.valueOf(r11.getIntExtra("ws_status_channel_type", 0));
    L9:
        if (r11 == null) goto L11;
        Integer r15 = Integer.valueOf(r11.getIntExtra("ws_connection_state", 0));
    L12:
        if (r11 == null) goto L14;
        r12 = Boolean.valueOf(r11.getBooleanExtra("ws_is_connected", false));
    L14:
        Function4<Integer, Integer, Integer, Boolean, Unit> r16 = this.f5920a;
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r12);
        r16.invoke(r14, r15, r13, r12);
        return;
    L11:
        r15 = null;
        goto L12
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }
}
