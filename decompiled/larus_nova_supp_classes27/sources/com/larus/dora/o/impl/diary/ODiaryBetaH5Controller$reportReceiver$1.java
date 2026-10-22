package com.larus.dora.o.impl.diary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/diary/ODiaryBetaH5Controller$reportReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryBetaH5Controller$reportReceiver$1 extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ f a;

    public ODiaryBetaH5Controller$reportReceiver$1(f r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r9, Intent r10) {
        if (r10 == null) goto L10;
        String r1 = r10.getStringExtra("date");
        if (r1 == null) goto L12;
        final f.b r11 = new f.b(r1, r10.getStringExtra("diary_id"), r10.getStringExtra("last_update_time"), r10.getStringExtra("earliest_date"), r10.getIntExtra("recorded_diary_days", 0), r10.getStringExtra("report_source"), Intrinsics.areEqual(r10.getStringExtra("report_entry"), "diary_page"));
        FLogger.a.i("ODiaryBetaH5", "h5 report date=" + r11.a + " source=" + r11.f + " fromDiaryPage=" + r11.g + " earliest=" + r11.d + " days=" + r11.e);
        View r12 = this.a.a.getView();
        if (r12 == null) goto L11;
        final f r0 = this.a;
        r12.post(new h(r11, r0));
        return;
    L11:
        return;
    L12:
        return;
    }
}
