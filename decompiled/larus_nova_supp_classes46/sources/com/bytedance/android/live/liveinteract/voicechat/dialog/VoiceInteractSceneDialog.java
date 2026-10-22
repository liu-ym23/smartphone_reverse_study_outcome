package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.voicechat.util.VoiceInteractSceneUtil;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.e6;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/VoiceInteractSceneDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceInteractSceneDialog extends CommonBottomDialog {
    public final boolean a;
    public final Function0<Unit> b;
    public final Context c;
    public final DataContext d;

    public final int getLayoutId() {
        return 2131567948;
    }

    public final void onCreate(Bundle r17) {
        super.onCreate(r17);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("link_icon");
        HashMap r3 = new HashMap();
        VoiceInteractSceneUtil r4 = VoiceInteractSceneUtil.a;
        VoiceInteractSceneUtil.c(r3);
        j0.l().sendLog("livesdk_chorus_anchor_switch_mode_icon_click", r3, new Object[]{IRoom.class});
        if (vm2.d.D() == false) goto L5;
        ((TextView) findViewById(2131385156)).setText(s1.B(2131920100));
    L6:
        ConstraintLayout r5 = findViewById(2131365585);
        if (r5 == null) goto L9;
        r5.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L9:
        ConstraintLayout r6 = findViewById(2131377041);
        int r7 = 8;
        Integer r8 = null;
        if (r6 != null) goto L12;
    L16:
        ConstraintLayout r9 = findViewById(2131377041);
        if (r9 == null) goto L19;
        r9.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L19:
        ConstraintLayout r10 = findViewById(2131376895);
        if (r10 == null) goto L54;
        Integer r11 = (Integer) e6.a.getValue();
        if (r11 != null) goto L25;
    L40:
        if (r11 != null) goto L43;
    L45:
        if (r11 != null) goto L48;
    L50:
        boolean r12 = false;
    L51:
        if (r12 == false) goto L53;
        r7 = 0;
    L53:
        r10.setVisibility(r7);
        goto L54
    L48:
        if (r11.intValue() != 2) goto L50;
    L49:
        r12 = true;
        goto L51
    L43:
        if (r11.intValue() != 1) goto L45;
    L25:
        if (r11.intValue() != 0) goto L40;
        com.bytedance.android.livesdk.chatroom.o r13 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r13 == null) goto L37;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L37;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L37;
        Map r16 = r15.getAnchorABMap();
        if (r16 == null) goto L37;
        String r18 = (String) r16.get("real_time_chorus");
        if (r18 == null) goto L37;
        int r19 = CastIntegerProtector.parseInt(r18);
    L38:
        if (r19 <= 0) goto L50;
    L37:
        r19 = 0;
    L54:
        ConstraintLayout r20 = findViewById(2131376895);
        if (r20 == null) goto L57;
        r20.setOnClickListener(x0.a(new AnonymousClass3(this)));
    L57:
        removeAccessOutSideForcuse();
        if (this.a == false) goto L122;
        UtilityKotlinExtentionsKt.w(findViewById(2131385158));
        ((TextView) findViewById(2131385158)).setOnClickListener(x0.a(new AnonymousClass4(this)));
        com.bytedance.live.datacontext.j r21 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.d).s();
        if (r21 == null) goto L66;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r21.getValue();
        if (r22 == null) goto L66;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r23 = r22.t();
        if (r23 == null) goto L66;
        int r24 = r23.a;
    L67:
        u r25 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r25 == null) goto L77;
        com.bytedance.live.datacontext.j r26 = r25.s();
        if (r26 == null) goto L77;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r27 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r26.getValue();
        if (r27 == null) goto L77;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r28 = r27.t();
        if (r28 == null) goto L77;
        r8 = Integer.valueOf(r28.b);
    L77:
        if (r24 == 5) goto L86;
        if (r24 != 9) goto L87;
        if (r8 != null) goto L83;
    L85:
        UtilityKotlinExtentionsKt.w(findViewById(2131376923));
        r3.a(findViewById(2131377041), s1.B(2131915929) + s1.B(2131923151));
        r3.a(findViewById(2131365585), s1.B(2131915931) + s1.B(2131923161));
        r3.a(findViewById(2131376895), s1.B(2131915931) + s1.B(2131923152));
        goto L87
    L83:
        if (r8.intValue() != 61) goto L85;
        UtilityKotlinExtentionsKt.w(findViewById(2131376894));
        r3.a(findViewById(2131376895), s1.B(2131915929) + s1.B(2131923152));
        r3.a(findViewById(2131377041), s1.B(2131915931) + s1.B(2131923151));
        r3.a(findViewById(2131365585), s1.B(2131915931) + s1.B(2131923161));
    L87:
        int r1 = com.bytedance.android.live.liveinteract.voicechat.util.l.a;
        Map r29 = MapsKt.mapOf(new Pair[]{TuplesKt.to(5, findViewById(2131365585)), TuplesKt.to(9, findViewById(2131377041))});
        Intrinsics.checkNotNullParameter(r29, "sceneViews");
        if (vm2.e.m() == false) goto L91;
        return;
    L91:
        if (r24 == 5) goto L113;
        if (r24 == 9) goto L104;
        if (r24 != 10) goto L131;
        View r30 = (View) r29.get(5);
        if (r30 == null) goto L98;
        r30.setAlpha(0.6f);
    L98:
        View r31 = (View) r29.get(9);
        if (r31 == null) goto L101;
        r31.setAlpha(0.6f);
    L101:
        View r32 = (View) r29.get(10);
        if (r32 == null) goto L124;
        r32.setAlpha(1.0f);
        return;
    L124:
        return;
    L131:
        return;
    L104:
        View r33 = (View) r29.get(5);
        if (r33 == null) goto L107;
        r33.setAlpha(1.0f);
    L107:
        View r34 = (View) r29.get(9);
        if (r34 == null) goto L110;
        r34.setAlpha(1.0f);
    L110:
        View r35 = (View) r29.get(10);
        if (r35 == null) goto L126;
        r35.setAlpha(0.6f);
        return;
    L126:
        return;
    L113:
        View r36 = (View) r29.get(5);
        if (r36 == null) goto L116;
        r36.setAlpha(1.0f);
    L116:
        View r37 = (View) r29.get(9);
        if (r37 == null) goto L119;
        r37.setAlpha(1.0f);
    L119:
        View r38 = (View) r29.get(10);
        if (r38 == null) goto L128;
        r38.setAlpha(0.6f);
        return;
    L128:
        return;
    L86:
        UtilityKotlinExtentionsKt.w(findViewById(2131365525));
        r3.a(findViewById(2131365585), s1.B(2131915929) + s1.B(2131923161));
        r3.a(findViewById(2131377041), s1.B(2131915931) + s1.B(2131923151));
        r3.a(findViewById(2131376895), s1.B(2131915931) + s1.B(2131923152));
    L66:
        r24 = 0;
        goto L67
    L122:
        UtilityKotlinExtentionsKt.t(findViewById(2131385158));
        return;
    L12:
        if (((Boolean) vm2.d.w6.getValue(null, vm2.d.a[384(0x180, float:5.38E-43)])).booleanValue() == false) goto L14;
        int r39 = 0;
    L15:
        r6.setVisibility(r39);
        goto L16
    L14:
        r39 = 8;
        goto L15
    L5:
        ((TextView) findViewById(2131385156)).setText(s1.B(2131920101));
        goto L6
    }

    public VoiceInteractSceneDialog(int r2, Context r3, DataContext r4, CompositeDisposable r5) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r5, "compositeDisposable");
        super(r3);
        this.c = r3;
        this.d = r4;
        if (r2 != 8) goto L5;
        boolean r6 = true;
    L6:
        this.a = r6;
        this.b = new VoiceInteractSceneDialog$dismissCallback$1(this);
        return;
    L5:
        r6 = false;
        goto L6
    }
}
