package com.bytedance.android.live.broadcastgame.opengame.debug.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.debug.c;
import com.bytedance.android.live.broadcastgame.opengame.debug.j;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.crash.d;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n10.b;
import n10.f;
import n10.g;
import n10.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/dialog/DebugMenuDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugMenuDialog extends CommonBottomDialog {
    public final LinkedList<h> a;
    public boolean b;
    public final c c;

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
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final int getLayoutId() {
        return 2131567090;
    }

    public final LinkedList<h> M0() {
        int r0 = n10.a.a[this.c.getPluginType().ordinal()];
        if (r0 != 1) goto L5;
    L13:
        LinkedList<h> r1 = new LinkedList();
        InteractGameContext r3 = InteractGameContext.Companion.getContext();
        if (r3 == null) goto L18;
        n<Boolean> r4 = r3.getHasOpenGameLaunch();
        if (r4 == null) goto L18;
        Boolean r5 = (Boolean) r4.getValue();
    L20:
        if ((!Intrinsics.areEqual(r5, Boolean.TRUE)) == false) goto L22;
        r1.add(new h("扫描", new n10.c(this)));
        return r1;
    L22:
        r1.add(new h("弹起小插件", new n10.d(this)));
        if (this.b == false) goto L50;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r6 = AnchorGameContext.a.a();
        if (r6 == null) goto L31;
        m<Boolean> r7 = r6.getOpenGamePerfPanel();
        if (r7 == null) goto L31;
        Boolean r8 = (Boolean) r7.getValue();
        if (r8 == null) goto L31;
        boolean r9 = r8.booleanValue();
    L32:
        r1.add(new h(r9));
        AnchorGameContext r2 = AnchorGameContext.a.a();
        if (r2 == null) goto L51;
        m<Boolean> r11 = r2.isLaunchFromPerfTest();
        if (r11 != null) goto L37;
        return r1;
    L37:
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L53;
        AnchorGameContext r12 = AnchorGameContext.a.a();
        if (r12 == null) goto L54;
        m<Boolean> r13 = r12.getOpenGamePerfUploadState();
        if (r13 != null) goto L43;
        return r1;
    L43:
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L56;
        r1.add(new h("停止性能数据上报", new f(this)));
        return r1;
    L56:
        return r1;
    L54:
        return r1;
    L53:
        return r1;
    L51:
        return r1;
    L31:
        r9 = false;
        goto L32
    L50:
        return r1;
    L18:
        r5 = null;
        goto L20
    L5:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L9;
        LinkedList<h> r14 = new LinkedList();
        r14.add(new h("扫描", new g(this)));
        return r14;
    L9:
        if ((this.c instanceof j) == false) goto L47;
        LinkedList<h> r15 = new LinkedList();
        r15.add(new h("扫描", new b(this)));
        return r15;
    L47:
        return new LinkedList();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.clear();
        this.a.addAll(M0());
        RecyclerView r0 = findViewById(2131384071);
        if (r0 == null) goto L8;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L9;
        r1.notifyDataSetChanged();
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
        boolean r9 = r8.booleanValue();
    L10:
        this.b = r9;
        RecyclerView r11 = findViewById(2131384071);
        if (r11 == null) goto L13;
        r11.setAdapter(new DebugMenuAdapter(this.a));
        r11.setLayoutManager(new LinearLayoutManager(r11.getContext(), 1, false));
        r11.addItemDecoration(new DividerItemDecoration(r11.getContext(), 1));
    L13:
        TextView r12 = (TextView) findViewById(2131365114);
        if (r12 == null) goto L17;
        r12.setOnClickListener(new a(this));
        return;
    L17:
        return;
    L9:
        r9 = false;
        goto L10
    }

    public DebugMenuDialog(Context r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "executor");
        super(r2);
        this.c = r3;
        this.a = M0();
    }
}
