package com.larus.voicecall.impl.tile;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/voicecall/impl/tile/RealtimeVideoTileLocaleChangedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeVideoTileLocaleChangedReceiver extends BroadcastReceiver {
    public RealtimeVideoTileLocaleChangedReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "intent");
        if (Intrinsics.areEqual(r3.getAction(), "android.intent.action.LOCALE_CHANGED") == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        TileService.requestListeningState(r2, new ComponentName(r2, RealtimeVideoTileService.class));
        return;
    }
}
