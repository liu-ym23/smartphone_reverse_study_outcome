package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.SimpleSettingManager;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.OpenParams;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/setting/SimpleZDanmakuSettingDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/setting/b$a;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleZDanmakuSettingDialogFragment extends LiveDialogFragment implements b.a {
    public static final /* synthetic */ int i = 0;
    public final o d;
    public final Lazy e;
    public TextView f;
    public TextView g;
    public OpenParams h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b.a
    public final void dR() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = SimpleSettingManager.a;
        SimpleSettingManager.e(null);
    }

    public SimpleZDanmakuSettingDialogFragment() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = SimpleSettingManager.a;
        this.d = SimpleSettingManager.b();
        this.e = LazyKt.lazy(new SimpleZDanmakuSettingDialogFragment$settingComponents$2(this));
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (isVertical() == false) goto L5;
        int r3 = 2131954579;
    L6:
        setStyle(1, r3);
        return;
    L5:
        r3 = 2131954852;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r2);     // Catch: Throwable -> L9
        Iterator r3 = ((List) this.e.getValue()).iterator();     // Catch: Throwable -> L9
    L4:
        if (r3.hasNext() == false) goto L7;
        ((b) r3.next()).e();     // Catch: Throwable -> L9
        goto L4
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b.a
    public final void yR(ChangeSettingSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = SimpleSettingManager.a;
        SimpleSettingManager.f(this.d, r2);
        int r3 = i.a;
        i.c("saveSimpleDanmakuConfigSP: " + this.d);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Iterator r4 = ((List) this.e.getValue()).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((b) r4.next()).d();
        goto L4
    L6:
        TextView r5 = this.f;
        if (r5 == null) goto L9;
        r5.setOnClickListener(x0.a(new SimpleZDanmakuSettingDialogFragment$configResetButton$1(this)));
    L9:
        TextView r6 = this.g;
        if (r6 == null) goto L12;
        r6.setOnClickListener(x0.a(new SimpleZDanmakuSettingDialogFragment$configCloseButton$1(this)));
    L12:
        sendLog("livesdk_preview_bullet_comment_setting_panel_show", null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b.a
    public final void sendLog(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("event_page", "live");
        OpenParams r1 = this.h;
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L8;
        Map r3 = r1.getLiveGlobalParams();
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("action_type");
        if (r4 == null) goto L8;
    L9:
        r0.put("action_type", r4);
        OpenParams r7 = this.h;
        if (r7 == null) goto L15;
        Map r8 = r7.getLiveGlobalParams();
        if (r8 == null) goto L15;
        String r9 = (String) r8.get("enter_from_merge");
        if (r9 == null) goto L15;
    L16:
        r0.put("enter_from_merge", r9);
        OpenParams r10 = this.h;
        if (r10 == null) goto L22;
        Map r11 = r10.getLiveGlobalParams();
        if (r11 == null) goto L22;
        String r13 = (String) r11.get("enter_method");
        if (r13 == null) goto L22;
    L23:
        r0.put("enter_method", r13);
        OpenParams r14 = this.h;
        if (r14 == null) goto L29;
        Map r15 = r14.getLiveGlobalParams();
        if (r15 == null) goto L29;
        String r16 = (String) r15.get("request_id");
        if (r16 == null) goto L29;
    L30:
        r0.put("request_id", r16);
        OpenParams r17 = this.h;
        if (r17 == null) goto L36;
        Room r18 = r17.getRoom();
        if (r18 == null) goto L36;
        String r19 = r18.getIdStr();
        if (r19 == null) goto L36;
    L37:
        r0.put("room_id", r19);
        OpenParams r20 = this.h;
        if (r20 == null) goto L45;
        Room r21 = r20.getRoom();
        if (r21 == null) goto L45;
        String r23 = r21.getOwnerUserIdString();
        if (r23 == null) goto L45;
        r2 = r23;
    L45:
        r0.put("anchor_id", r2);
        if (r6 == null) goto L48;
        r0.putAll(r6);
    L48:
        j0.l().sendLog(r5, r0, new Object[0]);
        return;
    L36:
        r19 = BuildConfig.FLAVOR;
    L29:
        r16 = BuildConfig.FLAVOR;
    L22:
        r13 = BuildConfig.FLAVOR;
    L15:
        r9 = BuildConfig.FLAVOR;
    L8:
        r4 = BuildConfig.FLAVOR;
        goto L9
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131566755, r4, false);
        if (r6 == null) goto L9;
        Iterator r7 = ((List) this.e.getValue()).iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        b r0 = (b) r7.next();
        r0.c(r3, (ViewGroup) r6.findViewById(r0.a()));
        goto L6
    L8:
        this.f = (TextView) r6.findViewById(2131384417);
        this.g = (TextView) r6.findViewById(2131366982);
        return r6;
    L9:
        return null;
    }
}
