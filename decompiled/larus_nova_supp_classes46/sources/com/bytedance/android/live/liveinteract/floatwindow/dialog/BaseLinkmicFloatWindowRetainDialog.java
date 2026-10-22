package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import am2.x;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/dialog/BaseLinkmicFloatWindowRetainDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseLinkmicFloatWindowRetainDialog extends AppCompatDialog {
    public final CompositeDisposable a;
    public final IRoom b;
    public final Runnable c;

    public String I0() {
        return null;
    }

    public int J0() {
        return 0;
    }

    public int L0() {
        return 0;
    }

    public void M0() {
        O0(findViewById(2131383716).isChecked(), false);
        boolean r1 = k.a;
        k.a(findViewById(2131383716).isChecked(), "refuse");
        k.e();
    }

    public void N0() {
        O0(findViewById(2131383716).isChecked(), true);
        boolean r1 = k.a;
        k.a(findViewById(2131383716).isChecked(), "open");
        HashMap r2 = new HashMap();
        if (findViewById(2131383716).isChecked() == false) goto L5;
        String r0 = "on";
    L6:
        r2.put("auto_open", r0);
        HashMap r3 = new HashMap();
        if (k.a == false) goto L9;
        String r4 = "1";
    L10:
        r3.put("is_song_order", r4);
        Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r5 != null) goto L14;
    L16:
        if (r5 != null) goto L19;
    L21:
        String r6 = PbRequest.SwitchType.OTHER;
    L22:
        r3.put("link_status", r6);
        r3.putAll(r2);
        j0.l().sendLog("livesdk_audience_apply_reserve_open", r3, new Object[]{IRoom.class, x.class});
        return;
    L19:
        if (r5.intValue() != 1) goto L21;
        r6 = "apply";
        goto L22
    L14:
        if (r5.intValue() != 2) goto L16;
        r6 = "link";
        goto L22
    L9:
        r4 = "0";
        goto L10
    L5:
        r0 = "off";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.a.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        setContentView(2131565594);
        Window r8 = getWindow();
        if (r8 == null) goto L5;
        r8.setLayout(-2, -2);
    L5:
        Window r9 = getWindow();
        if (r9 == null) goto L8;
        r9.setGravity(17);
    L8:
        Window r10 = getWindow();
        if (r10 == null) goto L11;
        r10.setBackgroundDrawable(new ColorDrawable(0));
    L11:
        ((LinearLayout) findViewById(2131383717)).setOnClickListener(new a(this));
        findViewById(2131365123).setOnClickListener(new b(this));
        findViewById(2131367647).setOnClickListener(new c(this));
        setOnCancelListener(d.a);
        if (L0() == 0) goto L15;
        ((TextView) findViewById(2131388772)).setText(L0());
    L15:
        if (J0() == 0) goto L17;
        ((TextView) findViewById(2131379974)).setText(J0());
    L17:
        ImageLoader.bindImage(findViewById(2131374209), I0());
        boolean r11 = k.a;
        HashMap r12 = new HashMap();
        r12.put("trigger_scene", "connection");
        j0.l().sendLog("livesdk_mini_window_popup_show", r12, new Object[]{IRoom.class, x.class});
        HashMap r13 = new HashMap();
        if (k.a == false) goto L20;
        String r1 = "1";
    L21:
        r13.put("is_song_order", r1);
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L25;
    L27:
        if (r2 != null) goto L30;
    L32:
        String r3 = PbRequest.SwitchType.OTHER;
    L33:
        r13.put("link_status", r3);
        j0.l().sendLog("livesdk_audience_apply_reserve_popup_show", r13, new Object[]{IRoom.class, x.class});
        return;
    L30:
        if (r2.intValue() != 1) goto L32;
        r3 = "apply";
        goto L33
    L25:
        if (r2.intValue() != 2) goto L27;
        r3 = "link";
        goto L33
    L20:
        r1 = "0";
        goto L21
    }

    public static void O0(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.j;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, 1);
        return;
    L5:
        if (r2 == false) goto L7;
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.z;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, 0);
        return;
    L7:
        com.bytedance.android.livesdk.sharedpref.e r5 = b6.z;
        com.bytedance.android.livesdk.sharedpref.f.d(r5, Integer.valueOf(((Integer) r5.getValue()).intValue() + 1));
        com.bytedance.android.livesdk.sharedpref.e r6 = b6.j;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, 2);
    }

    public BaseLinkmicFloatWindowRetainDialog(Context r2, IRoom r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        super(r2);
        this.b = r3;
        this.c = r4;
        this.a = new CompositeDisposable();
    }
}
