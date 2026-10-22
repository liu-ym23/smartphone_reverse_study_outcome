package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.i3;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkWithAudienceAVPermissionDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkWithAudienceAVPermissionDialog extends CommonBottomDialog {
    public static final a d = null;
    public final Map<String, Boolean> a;
    public final CompositeDisposable b;
    public final Room c;

    public static final class a {
        public a() {
        }
    }

    public final int getLayoutId() {
        return 2131565690;
    }

    static {
        d = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.J0;
        if (Intrinsics.areEqual(r2, r3.getName()) == false) goto L14;
        if ((!Intrinsics.areEqual((Boolean) r1.getValue(), (Boolean) r3.getValue())) == false) goto L14;
        String r4 = s1.B(2131917811);
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L12;
        String r5 = "on";
    L13:
        int r6 = el0.j.b;
        Intrinsics.checkNotNullParameter(r4, "switchName");
        Intrinsics.checkNotNullParameter(r5, "actionType");
        LinkedHashMap r7 = new LinkedHashMap();
        el0.j.i(r7);
        el0.j.m(r7);
        el0.j.k(r7);
        r7.put("play_mode", com.bytedance.android.live.liveinteract.utils.w.a());
        r7.put("switch_name", r4);
        r7.put("action_type", r5);
        el0.j.n(r7, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_ktv_anchor_live_manage", r7, new Object[]{Room.class});
        goto L4
    L12:
        r5 = "off";
    L14:
        ALogger.i("PkWithAudienceAVPermissionDialog", "no setting change");
        goto L4
    L15:
        ((LinkedHashMap) this.a).clear();
        Handler r8 = DialogLancet.resolveDialogHandler(this);
        if (r8 != null) goto L18;
    L20:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(this);
        return;
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r9 == null) goto L29;
        com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L18:
        if (Looper.myLooper() == r8.getLooper()) goto L20;
        r8.post(DialogLancet.createDismissRunnable(this));
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.dispose();
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (((Boolean) i3.a.getValue()).booleanValue() == false) goto L11;
        FrameLayout r9 = (FrameLayout) findViewById(2131374065);
        if (r9 == null) goto L7;
        r9.setVisibility(0);
    L7:
        Switch r2 = (Switch) findViewById(2131387907);
        if (r2 == null) goto L10;
        r2.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.J0.getValue()).booleanValue());
    L10:
        ((Switch) findViewById(2131387907)).setOnCheckedChangeListener(new r(this));
    L14:
        int r10 = dl0.n.a();
        if (tc0.c.h().E == false) goto L29;
        ((FrameLayout) findViewById(2131365090)).setVisibility(0);
        Switch r3 = (Switch) findViewById(2131387888);
        Ref.BooleanRef r5 = new Ref.BooleanRef();
        r5.element = false;
        q r6 = new q(this, r5, r10);
        r3.setChecked(((Boolean) b6.h.getValue()).booleanValue());
        r3.setOnCheckedChangeListener(r6);
        ((RelativeLayout) findViewById(2131368745)).setVisibility(8);
        if (fm3.c.c == false) goto L19;
    L22:
        boolean r1 = true;
    L24:
        if (sj1.a(r10, r1) == false) goto L30;
        ((RelativeLayout) findViewById(2131368745)).setVisibility(0);
        ((Switch) findViewById(2131387890)).setClickable(false);
        ((Switch) findViewById(2131387890)).setChecked(((Boolean) b6.g.getValue()).booleanValue());
        ((FrameLayout) findViewById(2131387891)).setOnClickListener(x0.a(new PkWithAudienceAVPermissionDialog$initLinkVideoSetting$1(this)));
        ((Switch) findViewById(2131387890)).setOnCheckedChangeListener(new p(this, r10));
        if (((Switch) findViewById(2131387888)).isChecked() == true) goto L28;
        ((Switch) findViewById(2131387890)).setChecked(false);
    L28:
        HashMap r4 = new HashMap();
        r4.put("button_type", String.valueOf(((Switch) findViewById(2131387890)).isChecked()));
        el0.j.l(r4, r10);
        el0.j.j(r4, Integer.valueOf(r10));
        el0.j.n(r4, Integer.valueOf(r10));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_auto_video_button_show", r4, new Object[]{Room.class});
    L30:
        Map<String, Boolean> r11 = this.a;
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.J0;
        r11.put(r0.getName(), (Boolean) r0.getValue());
        return;
    L19:
        if (fm3.c.a == true) goto L22;
        r1 = false;
        goto L24
    L29:
        ((FrameLayout) findViewById(2131365090)).setVisibility(8);
        ((RelativeLayout) findViewById(2131368745)).setVisibility(8);
        goto L30
    L11:
        FrameLayout r12 = (FrameLayout) findViewById(2131374065);
        if (r12 == null) goto L14;
        r12.setVisibility(8);
        goto L14
    }

    public PkWithAudienceAVPermissionDialog(Room r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.c = r2;
        this.a = new LinkedHashMap();
        this.b = new CompositeDisposable();
    }
}
