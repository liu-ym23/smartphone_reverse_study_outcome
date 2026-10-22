package com.larus.dora.o.impl.diary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/diary/ODiaryBetaH5Controller$feedbackReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryBetaH5Controller$feedbackReceiver$1 extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ f a;

    public ODiaryBetaH5Controller$feedbackReceiver$1(f r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        final String r10 = r9.getStringExtra("diary_id");
        String r0 = "";
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        final int r1 = r9.getIntExtra("feedback_action", -1);
        if (r10.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L36;
        if (r1 >= 0) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L38;
        int r4 = r9.getIntExtra("feedback_target_type", 1);
        String r5 = r9.getStringExtra("feedback_target_id");
        if (r5 != null) goto L22;
    L27:
        r5 = r10;
    L28:
        String r6 = r9.getStringExtra("feedback_snapshot_json");
        if (r6 == null) goto L32;
        r0 = r6;
    L32:
        final l0 r7 = new l0(r4, r5, r0, r9.getIntExtra("feedback_diary_version", 0));
        FLogger.a.i("ODiaryBetaH5", "h5 feedback diary=" + r10 + " action=" + r1 + " targetType=" + r7.a + " targetId=" + r7.b + " snapshotLen=" + r7.c.length() + " v=" + r7.d);
        View r11 = this.a.a.getView();
        if (r11 == null) goto L37;
        final f r12 = this.a;
        r11.post(new g(r12, r10, r1, r7));
        return;
    L37:
        return;
    L22:
        if ((true ^ StringsKt.isBlank(r5)) == true) goto L25;
        r5 = null;
    L25:
        if (r5 == null) goto L27;
    L38:
        return;
    L14:
        if (r1 >= 3) goto L16;
        r3 = true;
        goto L17
    L36:
        return;
    L10:
        r2 = false;
        goto L11
    }
}
