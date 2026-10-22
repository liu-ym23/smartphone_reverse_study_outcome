package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdkapi.interact.OpenVSMsgBoardInputEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/VSMsgBoardBaseWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class VSMsgBoardBaseWidget extends LiveRecyclableWidget {
    public final CompositeDisposable a;
    public VSMsgBoardDataContext b;
    public VSMsgBoardPortraitInputDialog c;
    public boolean d;
    public String e;

    public final void onInit(Object[] r1) {
    }

    public abstract Map<String, String> wq();

    public abstract com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> xq(DataCenter r1);

    public abstract ylc.e yq(DataCenter r1);

    public abstract void zq(String r1, Map<String, String> r2, String r3);

    public final void onUnload() {
        this.a.clear();
        VSMsgBoardPortraitInputDialog r0 = this.c;
        if (r0 != null) goto L22;
    L10:
        String r1 = this.e;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.length() <= 0) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L19;
        r1 = null;
    L19:
        if (r1 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.w().removePublishCallback(r1);
        return;
    L25:
        return;
    L15:
        r2 = false;
        goto L16
    L22:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L10;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public VSMsgBoardBaseWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onLoad(Object[] r5) {
        nm1.e r6 = pm1.f.c();
        com.bytedance.android.livesdk.chatroom.msgboard.a r0 = null;
        if (r6 == null) goto L5;
        ReplayDataContext r7 = r6.h(((Widget) this).dataCenter);
    L6:
        if (r7 == null) goto L8;
        boolean r8 = true;
    L9:
        this.d = r8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> r9 = xq(((Widget) this).dataCenter);
        if (r9 != null) goto L12;
    L18:
        VSMsgBoardDataContext r1 = new VSMsgBoardDataContext();
        boolean r2 = r1.isReplay();
        DataCenter r3 = ((Widget) this).dataCenter;
        r1.init(r2, r3, yq(r3));
        if (r9 == null) goto L21;
        r9.d(r1);
    L21:
        this.b = r1;
    L22:
        Observable r10 = xs2.b.a().b(OpenVSMsgBoardInputEvent.class);
        if (r10 == null) goto L28;
        Disposable r11 = r10.subscribe(new e1(this));
        if (r11 == null) goto L29;
        RxUtilKt.c(r11, this.a);
        return;
    L29:
        return;
    L28:
        return;
    L12:
        if (r9.hasValue() == false) goto L18;
        com.bytedance.android.livesdk.chatroom.msgboard.a r13 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r9.getValue();
        if ((r13 instanceof VSMsgBoardDataContext) == false) goto L17;
        r0 = r13;
    L17:
        this.b = (VSMsgBoardDataContext) r0;
        goto L22
    L8:
        r8 = false;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public static void Aq(JSONObject r2, String r3, String r4) {
        r2.put(r3, CastLongProtector.parseLong(r4));     // Catch: Exception -> L4
        return;
    L4:
        r2.put(r3, 0);
    }
}
