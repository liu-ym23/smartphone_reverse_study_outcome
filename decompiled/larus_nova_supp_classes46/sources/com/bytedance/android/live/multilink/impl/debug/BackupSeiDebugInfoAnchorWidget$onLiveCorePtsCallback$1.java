package com.bytedance.android.live.multilink.impl.debug;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class BackupSeiDebugInfoAnchorWidget$onLiveCorePtsCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $error;
    final /* synthetic */ int $from;
    final /* synthetic */ String $key;
    final /* synthetic */ long $pts;
    final /* synthetic */ BackupSeiDebugInfoAnchorWidget this$0;

    public BackupSeiDebugInfoAnchorWidget$onLiveCorePtsCallback$1(BackupSeiDebugInfoAnchorWidget r1, int r2, int r3, long r4, String r6) {
        this.this$0 = r1;
        this.$error = r2;
        this.$from = r3;
        this.$pts = r4;
        this.$key = r6;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m573invoke() {
        TextView r0 = this.this$0.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveCorePtsTv");
    L5:
        r0.setText("onLiveCorePtsCallback: \n error: " + this.$error + ", \n from: " + this.$from + ", \n pts: " + this.$pts + ", \n key: " + this.$key);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m573invoke();
        return Unit.INSTANCE;
    }
}
