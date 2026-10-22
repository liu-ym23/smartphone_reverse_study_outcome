package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.config.ol;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r52.d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/CommentSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentSettingDialog extends LiveDialogFragment {
    public static final /* synthetic */ int t = 0;
    public Map<Integer, View> d;
    public boolean e;
    public boolean f;
    public DataCenter g;
    public long h;
    public ListDialogAbility i;
    public boolean j;
    public long k;
    public String l;
    public final Map<String, String> m;
    public final Map<Integer, Integer> n;
    public final Map<Integer, Integer> o;
    public final int p;
    public int q;
    public boolean r;
    public boolean s;

    public static final class a {
        public static void a(CommentSettingDialog r2, FragmentManager r3) {
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "CommentSettingDialog", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r2.showNow(r3, "CommentSettingDialog");
        }
    }

    static {
    }

    public CommentSettingDialog() {
        this.d = new LinkedHashMap();
        this.l = BuildConfig.FLAVOR;
        this.m = new LinkedHashMap();
        this.n = MapsKt.mapOf(new Pair[]{TuplesKt.to(2131373099, 9), TuplesKt.to(2131373100, 3), TuplesKt.to(2131373111, 5)});
        this.o = MapsKt.mapOf(new Pair[]{TuplesKt.to(9, 2131373099), TuplesKt.to(3, 2131373100), TuplesKt.to(5, 2131373111)});
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.W0;
        this.p = ((Number) r0.getValue()).intValue();
        this.q = ((Number) r0.getValue()).intValue();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void T90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        super.onDismiss(r6);
        Ref.IntRef r7 = new Ref.IntRef();
        int r0 = this.q;
        r7.element = r0;
        if (r0 != this.p) goto L5;
        return;
    L5:
        if (this.s == true) goto L10;
        this.s = true;
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), this.h, 46, r7.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r7), m.a);
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954585);
        setAnimationType("right");
        setShouldUseNewPanel(true);
    }

    public final void onDismiss(DialogInterface r2) {
        T90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(final View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        int r11 = b1.a;
        b1.b(true, new CommentSettingDialog$initDialogUI$1(r9));
        ConstraintLayout r13 = S90(2131381825);
        int r2 = 0;
        if (this.j == false) goto L5;
        int r0 = 0;
    L6:
        r13.setVisibility(r0);
        S90(2131381826).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.b.b1.getValue()).booleanValue());
        S90(2131381826).setOnCheckedChangeListener(new d(this));
        ((TextView) S90(2131382846)).setVisibility(0);
        S90(2131367432).setVisibility(0);
        ((RadioGroup) S90(2131373959)).setVisibility(0);
        LiveSwitchButton r3 = S90(2131367435);
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.W0;
        Integer r5 = (Integer) r4.getValue();
        if (r5 != null) goto L10;
    L11:
        boolean r6 = true;
    L13:
        r3.setChecked(r6);
        LinearLayout r7 = (LinearLayout) S90(2131367434);
        Integer r8 = (Integer) r4.getValue();
        if (r8 != null) goto L17;
    L18:
        int r14 = 0;
    L20:
        r7.setVisibility(r14);
        S90(2131367435).setOnCheckedChangeListener(new e(this));
        Integer r1 = (Integer) r4.getValue();
        if (r1 != null) goto L24;
    L25:
        Integer r15 = this.o.get(r4.getValue());
        if (r15 == null) goto L28;
        ((RadioGroup) S90(2131373959)).check(r15.intValue());
    L28:
        ((RadioGroup) S90(2131373959)).setOnCheckedChangeListener(new f(this));
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.c1;
        Integer r17 = (Integer) r16.getValue();
        if (r17 != null) goto L32;
    L33:
        S90(2131384773).setVisibility(0);
        ((TextView) S90(2131384767)).setVisibility(0);
        S90(2131384764).setVisibility(0);
    L35:
        LiveSwitchButton r18 = S90(2131384774);
        Integer r19 = (Integer) r16.getValue();
        if (r19 != null) goto L39;
    L41:
        boolean r110 = false;
    L42:
        r18.setChecked(r110);
        S90(2131384774).setOnCheckedChangeListener(new g(this));
        DataCenter r111 = this.g;
        if (this.f == false) goto L45;
        boolean r20 = ((Boolean) com.bytedance.android.livesdk.sharedpref.b.Y0.getValue()).booleanValue();
        S90(2131363495).setChecked(r20);
        S90(2131363409).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.b.Z0.getValue()).booleanValue());
    L57:
        S90(2131363495).setOnCheckedChangeListener(new h(this, r111));
        ConstraintLayout r21 = S90(2131367430);
        if (r20 == false) goto L60;
        int r23 = 0;
    L61:
        r21.setVisibility(r23);
        S90(2131363409).setOnCheckedChangeListener(new i(this, r111));
        if (((Number) ol.a.getValue()).intValue() <= 1) goto L73;
        S90(2131382848).setVisibility(0);
        ((TextView) S90(2131382850)).setVisibility(0);
        S90(2131367439).setVisibility(0);
        if (this.f == false) goto L66;
        S90(2131392375).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.b.a1.getValue()).booleanValue());
    L72:
        S90(2131392375).setOnCheckedChangeListener(new j(this, r111));
    L74:
        ConstraintLayout r24 = S90(2131373872);
        com.bytedance.android.livesdk.sharedpref.e r25 = com.bytedance.android.livesdk.sharedpref.b.e1;
        if (((Boolean) r25.getValue()).booleanValue() == true) goto L78;
        r2 = 8;
    L78:
        r24.setVisibility(r2);
        d2 r26 = d2.a;
        if ((!Intrinsics.areEqual(r26.getValue(), Boolean.TRUE)) == false) goto L81;
    L82:
        S90(2131382847).setVisibility(8);
        S90(2131383066).setVisibility(8);
        ((TextView) S90(2131382845)).setVisibility(8);
        S90(2131373872).setVisibility(8);
    L84:
        if (((Boolean) r26.getValue()).booleanValue() == false) goto L88;
        S90(2131383067).setChecked(((Boolean) r25.getValue()).booleanValue());
        S90(2131383067).setOnCheckedChangeListener(new k(this));
        TextView r27 = (TextView) S90(2131362572);
        if (r27 == null) goto L88;
        r27.setSelected(true);
    L88:
        S90(2131373872).setOnClickListener(new c(this));
        return;
    L81:
        if (this.e == false) goto L84;
    L66:
        if (r111 == null) goto L70;
        Boolean r28 = (Boolean) r111.get("data_room_video_comment_share_enable", Boolean.TRUE);
        if (r28 == null) goto L70;
        boolean r29 = r28.booleanValue();
    L71:
        S90(2131392375).setChecked(r29);
    L70:
        r29 = true;
        goto L71
    L73:
        S90(2131382848).setVisibility(8);
        ((TextView) S90(2131382850)).setVisibility(8);
        S90(2131367439).setVisibility(8);
        goto L74
    L60:
        r23 = 8;
        goto L61
    L45:
        if (r111 == null) goto L49;
        Boolean r30 = (Boolean) r111.get("data_room_audio_comment_enable", Boolean.TRUE);
        if (r30 == null) goto L49;
        r20 = r30.booleanValue();
    L50:
        S90(2131363495).setChecked(r20);
        LiveSwitchButton r31 = S90(2131363409);
        if (r111 == null) goto L55;
        Boolean r33 = (Boolean) r111.get("data_room_audio_comment_auto_play", Boolean.TRUE);
        if (r33 == null) goto L55;
        boolean r34 = r33.booleanValue();
    L56:
        r31.setChecked(r34);
    L55:
        r34 = true;
    L49:
        r20 = true;
        goto L50
    L39:
        if (r19.intValue() != 1) goto L41;
        r110 = true;
        goto L42
    L32:
        if (r17.intValue() != 0) goto L33;
        S90(2131384773).setVisibility(8);
        ((TextView) S90(2131384767)).setVisibility(8);
        S90(2131384764).setVisibility(8);
        goto L35
    L24:
        if (r1.intValue() == 1) goto L28;
    L17:
        if (r8.intValue() != 1) goto L18;
        r14 = 8;
        goto L20
    L10:
        if (r5.intValue() != 1) goto L11;
        r6 = false;
        goto L13
    L5:
        r0 = 8;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565425, r3, false);
    }
}
