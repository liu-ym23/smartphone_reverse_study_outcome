package com.bytedance.android.livesdk.chatroom.viewmodule.backtrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.audiencerecord.LiveAudienceBacktrackPreviewDialog;
import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.android.livesdk.audiencerecord.o;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveAnchorBacktrackPreviewDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se1.c;
import zf1.e;
import zf1.f;
import zf1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/backtrack/LiveBacktrackWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/backtrack/a;", "Lse1/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBacktrackWidget extends LiveRecyclableWidget implements a, se1.a, Observer<KVData> {
    public LiveBacktrackHandleBallController a;
    public c b;
    public se1.b c;
    public IAnchorBacktrackService d;

    public final int getLayoutId() {
        return 2131567741;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.backtrack.a
    public final void Un() {
        Context r0 = ((Widget) this).context;
        if (r0 != null) goto L5;
        return;
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 != null) goto L8;
        return;
    L8:
        LiveBacktrackHandleBallController r2 = this.a;
        if (r2 == null) goto L12;
        r2.b();
    L12:
        if (isAnchor() == false) goto L18;
        LiveAnchorBacktrackPreviewDialog r3 = new LiveAnchorBacktrackPreviewDialog(r0, r1);
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    L18:
        LiveAudienceBacktrackPreviewDialog.p.getClass();
        LiveAudienceBacktrackPreviewDialog.b.a(r0, r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.backtrack.a
    public final LiveMode Z7() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (LiveMode) r0.get("data_live_mode");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.backtrack.a
    public final boolean isAnchor() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return z.e(r0, false);
    }

    public final void onUnload() {
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV7() == false) goto L7;
        se1.b r0 = this.c;
        if (r0 == null) goto L7;
        r0.d(this);
    L7:
        LiveBacktrackHandleBallController r1 = this.a;
        if (r1 == null) goto L10;
        r1.b();
    L10:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L14;
        r2.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.backtrack.a
    public final boolean isPortrait() {
        return isScreenPortrait();
    }

    public LiveBacktrackWidget() {
    }

    public final void G0(float r2) {
        LiveBacktrackHandleBallController r0 = this.a;
        if (r0 == null) goto L6;
        r0.d((int) r2);
        return;
    }

    public final void UL(BacktrackState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        int r3 = b.c[r2.ordinal()];
        if (r3 != 1) goto L5;
        LiveBacktrackHandleBallController r4 = this.a;
        if (r4 == null) goto L27;
        r4.b();
        return;
    L27:
        return;
    L5:
        if (r3 != 2) goto L7;
        wq(false);
        LiveBacktrackHandleBallController r0 = this.a;
        if (r0 == null) goto L25;
        r0.d(0);
        return;
    L25:
        return;
    L7:
        if (r3 != 5) goto L9;
    L13:
        LiveBacktrackHandleBallController r5 = this.a;
        if (r5 == null) goto L23;
        r5.b();
        return;
    L23:
        return;
    L9:
        if (r3 == 6) goto L13;
        if (r3 == 7) goto L13;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("data_backtrack_state_changed", r5.getKey()) == false) goto L36;
        g r6 = (g) r5.getData();
        if (r6 == null) goto L75;
        IAnchorBacktrackService.State r0 = r6.b;
        if (r0 != null) goto L14;
        return;
    L14:
        switch(b.d[r0.ordinal()]) {
            case 1: goto L22;
            case 2: goto L19;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            default: goto L25;
        };
    L16:
        LiveBacktrackHandleBallController r1 = this.a;
        if (r1 == null) goto L25;
        r1.b();
        goto L25
    L19:
        wq(false);
        LiveBacktrackHandleBallController r2 = this.a;
        if (r2 == null) goto L25;
        r2.d(0);
        goto L25
    L22:
        LiveBacktrackHandleBallController r3 = this.a;
        if (r3 == null) goto L25;
        r3.b();
    L25:
        IAnchorBacktrackService.State r7 = r6.a;
        if (r7 != IAnchorBacktrackService.State.DOWNLOAD) goto L31;
        if (r0 != IAnchorBacktrackService.State.DONE) goto L31;
        f2.c(s1.B(2131915235), 0);
        return;
    L31:
        if (r7 == IAnchorBacktrackService.State.SAVE_DRAFT) goto L33;
        return;
    L33:
        if (r0 != IAnchorBacktrackService.State.DONE) goto L63;
        f2.c(s1.B(2131921975), 0);
        return;
    L63:
        return;
    L75:
        return;
    L36:
        if (Intrinsics.areEqual("data_backtrack_operation_progress_changed", r5.getKey()) == false) goto L43;
        e r8 = (e) r5.getData();
        if (r8 == null) goto L65;
        LiveBacktrackHandleBallController r9 = this.a;
        if (r9 == null) goto L66;
        r9.d(r8.a);
        return;
    L66:
        return;
    L65:
        return;
    L43:
        if (Intrinsics.areEqual("data_backtrack_progress_changed", r5.getKey()) == false) goto L50;
        f r10 = (f) r5.getData();
        if (r10 == null) goto L68;
        LiveBacktrackHandleBallController r11 = this.a;
        if (r11 == null) goto L69;
        r11.d(r10.a);
        return;
    L69:
        return;
    L68:
        return;
    L50:
        if (Intrinsics.areEqual("cmd_backtrack_preview_dialog_show", r5.getKey()) == false) goto L71;
        Boolean r12 = (Boolean) r5.getData();
        if (r12 != null) goto L55;
        r12 = Boolean.FALSE;
    L55:
        if (r12.booleanValue() == false) goto L59;
        LiveBacktrackHandleBallController r13 = this.a;
        if (r13 == null) goto L72;
        r13.b();
        return;
    L72:
        return;
    L59:
        wq(true);
        return;
    }

    public final void onInit(Object[] r4) {
        RecordDragParentView r5 = (RecordDragParentView) ((Widget) this).contentView.findViewById(2131370212);
        View r0 = LayoutInflater.from(((Widget) this).context).inflate(2131565204, r5, false);
        if (r0 == null) goto L7;
        this.a = new LiveBacktrackHandleBallController(this, r5, (RecordDragContainer) r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer");
    }

    public final void onLoad(Object[] r3) {
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L5;
        r4.observeForever("cmd_backtrack_preview_dialog_show", this);
    L5:
        o r0 = null;
        if (isAnchor() == false) goto L14;
        this.d = (IAnchorBacktrackService) ((Widget) this).dataCenter.get("data_backtrack_service", null);
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L20;
        DataCenter r6 = r5.observeForever("data_backtrack_state_changed", this);
        if (r6 == null) goto L20;
        DataCenter r7 = r6.observeForever("data_backtrack_operation_progress_changed", this);
        if (r7 == null) goto L20;
        r7.observeForever("data_backtrack_progress_changed", this);
    L20:
        wq(true);
        return;
    L14:
        c r8 = (c) ((Widget) this).dataCenter.get("data_audience_backtrace_service");
        this.b = r8;
        if (r8 == null) goto L17;
        r0 = r8.a();
    L17:
        this.c = r0;
        if (r0 == null) goto L20;
        r0.b(this);
        goto L20
    }

    public final void wq(boolean r5) {
        int r1 = 0;
        if (isAnchor() == false) goto L22;
        IAnchorBacktrackService r0 = this.d;
        if (r0 == null) goto L21;
        IAnchorBacktrackService.State r2 = r0.getState();
        if (r2 != null) goto L10;
        return;
    L10:
        if (b.a[r2.ordinal()] != 1) goto L49;
        LiveBacktrackHandleBallController r3 = this.a;
        if (r3 == null) goto L15;
        r3.c(r5);
    L15:
        LiveBacktrackHandleBallController r6 = this.a;
        if (r6 == null) goto L45;
        IAnchorBacktrackService r4 = this.d;
        if (r4 == null) goto L20;
        r1 = r4.getOperationProgress();
    L20:
        r6.d(r1);
        return;
    L45:
        return;
    L49:
        return;
    L21:
        return;
    L22:
        se1.b r7 = this.c;
        if (r7 == null) goto L47;
        BacktrackState r8 = r7.a();
        if (r8 == null) goto L50;
        int r9 = b.b[r8.ordinal()];
        if (r9 != 1) goto L30;
    L34:
        LiveBacktrackHandleBallController r10 = this.a;
        if (r10 == null) goto L37;
        r10.c(r5);
    L37:
        LiveBacktrackHandleBallController r11 = this.a;
        if (r11 == null) goto L48;
        se1.b r12 = this.c;
        if (r12 == null) goto L42;
        r1 = (int) r12.c();
    L42:
        r11.d(r1);
        return;
    L48:
        return;
    L30:
        if (r9 == 2) goto L34;
        if (r9 == 3) goto L34;
        return;
    L50:
        return;
    }
}
