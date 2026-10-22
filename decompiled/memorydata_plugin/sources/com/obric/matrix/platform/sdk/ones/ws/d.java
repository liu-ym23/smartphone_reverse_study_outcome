package com.obric.matrix.platform.sdk.ones.ws;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB+\u0012$\u0010\u0002\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R,\u0010\u0002\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver;", "Landroid/content/BroadcastReceiver;", "listener", "Lkotlin/Function4;", "", "", "", "(Lkotlin/jvm/functions/Function4;)V", "onReceive", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class d extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function4<Integer, Integer, Integer, Boolean, Unit> f8151b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver$Companion;", "", "()V", "TAG", "", "WS_CHANNEL_ID", "WS_CHANNEL_TYPE", "WS_CONNECTION_STATE", "WS_IS_CONNECTED", "WS_STATUS_BROADCAST_ACTION", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8150a = new a(null);
    }

    public d(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r3) {
        Function4<Integer, Integer, Integer, Boolean, Unit> r4 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f8151b = r4;
    }

    public void onReceive(Context r5, Intent r6) {
        Log.d("WsStatusReceiver", "onReceive() called with: context = " + ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")) + ", intent = " + r6);
        Boolean r0 = null;
        if (r6 == null) goto L5;
        Integer r1 = Integer.valueOf(r6.getIntExtra("ws_status_channel_id", 0));
    L6:
        if (r6 == null) goto L8;
        Integer r2 = Integer.valueOf(r6.getIntExtra("ws_status_channel_type", 0));
    L9:
        if (r6 == null) goto L11;
        Integer r3 = Integer.valueOf(r6.getIntExtra("ws_connection_state", 0));
    L12:
        if (r6 == null) goto L14;
        r0 = Boolean.valueOf(r6.getBooleanExtra("ws_is_connected", false));
    L14:
        Function4<Integer, Integer, Integer, Boolean, Unit> r4 = this.f8151b;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r0);
        r4.invoke(r2, r3, r1, r0);
        return;
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
