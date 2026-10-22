package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.live.datacontext.i;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/DebugMenuDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugMenuDialog extends CommonBottomDialog {
    public static final /* synthetic */ int c = 0;
    public final LinkedList<c> a;
    public final IQRCodeService.b b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DebugMenuDialog a;

        public a(DebugMenuDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final int getLayoutId() {
        return 2131567090;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.clear();
        LinkedList<c> r0 = this.a;
        LinkedList r1 = new LinkedList();
        r1.add(new c(new com.bytedance.android.live.openplatform.impl.miniappanchor.debug.a(this)));
        r0.addAll(r1);
        RecyclerView r2 = findViewById(2131384071);
        if (r2 == null) goto L8;
        RecyclerView.Adapter r3 = r2.getAdapter();
        if (r3 == null) goto L9;
        r3.notifyDataSetChanged();
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L9;
        i r7 = r6.isAnchor();
        if (r7 == null) goto L9;
        Boolean r8 = (Boolean) r7.getValue();
        if (r8 == null) goto L9;
        r8.booleanValue();
    L9:
        RecyclerView r9 = findViewById(2131384071);
        if (r9 == null) goto L12;
        r9.setAdapter(new DebugMenuAdapter(this.a));
        r9.setLayoutManager(new LinearLayoutManager(r9.getContext(), 1, false));
        r9.addItemDecoration(new DividerItemDecoration(r9.getContext(), 1));
    L12:
        TextView r10 = (TextView) findViewById(2131365114);
        if (r10 == null) goto L16;
        r10.setOnClickListener(new a(this));
        return;
    }

    public DebugMenuDialog(Context r2, IQRCodeService.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scanResultListener");
        super(r2);
        this.b = r3;
        LinkedList<c> r4 = new LinkedList();
        r4.add(new c(new com.bytedance.android.live.openplatform.impl.miniappanchor.debug.a(this)));
        this.a = r4;
    }
}
