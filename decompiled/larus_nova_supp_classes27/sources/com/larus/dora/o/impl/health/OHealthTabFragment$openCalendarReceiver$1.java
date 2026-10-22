package com.larus.dora.o.impl.health;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import x69.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/health/OHealthTabFragment$openCalendarReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OHealthTabFragment$openCalendarReceiver$1 extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ OHealthTabFragment a;

    public OHealthTabFragment$openCalendarReceiver$1(OHealthTabFragment r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (r4 == null) goto L10;
        final String r5 = r4.getStringExtra("date");
        if (r5 == null) goto L12;
        FLogger.a.i("OHealthH5", "h5 open calendar date=".concat(r5));
        View r6 = this.a.getView();
        if (r6 == null) goto L11;
        final OHealthTabFragment r0 = this.a;
        r6.post(new c(r0, r5));
        return;
    L11:
        return;
    L12:
        return;
    }
}
