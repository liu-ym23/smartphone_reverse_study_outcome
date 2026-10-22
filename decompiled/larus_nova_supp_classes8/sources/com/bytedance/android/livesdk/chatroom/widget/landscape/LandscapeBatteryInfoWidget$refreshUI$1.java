package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LandscapeBatteryInfoWidget$refreshUI$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LandscapeBatteryInfoWidget this$0;

    public LandscapeBatteryInfoWidget$refreshUI$1(LandscapeBatteryInfoWidget r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m405invoke() {
        LandscapeBatteryInfoWidget r0 = this.this$0;
        int r1 = (r0.d * 100) / r0.c;
        TextView r2 = r0.a;
        if (r2 == null) goto L5;
        StringBuilder r3 = new StringBuilder();
        r3.append(r1);
        r3.append('%');
        r2.setText(r3.toString());
    L5:
        LandscapeBatteryInfoWidget r4 = this.this$0;
        int r5 = r4.e;
        if (r5 != 2) goto L8;
    L11:
        boolean r6 = true;
    L12:
        float r7 = r4.d / r4.c;
        if (r7 <= 1.0f) goto L15;
        r7 = 1.0f;
    L15:
        LandscapeBatteryView r8 = r4.b;
        if (r8 == null) goto L19;
        r8.b = r7;
        r8.c = r6;
        r8.e();
        r8.invalidate();
        return;
    L19:
        return;
    L8:
        if (r5 == 5) goto L11;
        r6 = false;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m405invoke();
        return Unit.INSTANCE;
    }
}
