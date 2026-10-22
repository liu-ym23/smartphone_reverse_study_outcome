package com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qd0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/fragment/OpenLiveVideoTalkFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getActivity", "()Landroid/content/Context;", "activity", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpenLiveVideoTalkFragment extends LiveDialogFragment {
    public Map<Integer, View> d;
    public final boolean e;
    public final Context f;
    public final String g;
    public boolean h;
    public int i;
    public int j;
    public final g k;

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ OpenLiveVideoTalkFragment a;

        public a(OpenLiveVideoTalkFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r7, boolean r8) {
            OpenLiveVideoTalkFragment r9 = this.a;
            if (r8 == false) goto L15;
            r9.h = true;
            if (r9.i != 0) goto L8;
            r9.i = 8;
        L8:
            if (r9.j == 0) goto L10;
        L14:
            r9.k.update(true, r9.i, r9.j);
        L16:
            r9.updateView();
            if (r8 == false) goto L19;
            String r10 = "on";
        L20:
            HashMap<String, String> r2 = new HashMap();
            r9.U90(r2);
            boolean r3 = r9.h;
            if (r3 == true) goto L23;
        L25:
            if (r3 == true) goto L27;
        L29:
            String r11 = "live";
        L30:
            r2.put("function_type", r11);
            r2.put("action_type", r10);
            j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_setting_switch", r2, new Object[0]);
            return;
        L27:
            if (r9.i != 8) goto L29;
            r11 = "radio";
            goto L30
        L23:
            if (r9.i != 12) goto L25;
            r11 = "party";
            goto L30
        L19:
            r10 = "off";
            goto L20
        L10:
            if (r9.e == false) goto L12;
            int r4 = 7;
        L13:
            r9.j = r4;
            goto L14
        L12:
            r4 = 1;
            goto L13
        L15:
            r9.h = false;
            r9.k.update(false, 0, 0);
            goto L16
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OpenLiveVideoTalkFragment a;

        public b(OpenLiveVideoTalkFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            OpenLiveVideoTalkFragment r7 = this.a;
            if (r7.i != 8) goto L5;
            return;
        L5:
            ((ImageView) r7.S90(2131376719)).setBackgroundResource(2131253276);
            ((ImageView) this.a.S90(2131376219)).setBackground(null);
            boolean r0 = true;
            ((ImageView) this.a.S90(2131376719)).setSelected(true);
            ((ImageView) this.a.S90(2131376219)).setSelected(false);
            OpenLiveVideoTalkFragment r8 = this.a;
            r8.i = 8;
            if (r8.j != 2) goto L8;
            int r1 = 7;
        L9:
            r8.j = r1;
            Switch r9 = (Switch) r8.S90(2131387900);
            OpenLiveVideoTalkFragment r2 = this.a;
            if (r2.e == false) goto L15;
            if (r2.j == 1) goto L18;
        L17:
            r0 = false;
        L18:
            r9.setChecked(r0);
            OpenLiveVideoTalkFragment r10 = this.a;
            r10.k.update(r10.h, r10.i, r10.j);
            OpenLiveVideoTalkFragment.T90(this.a, "layout");
            return;
        L15:
            if (r2.j != 7) goto L17;
        L8:
            r1 = 1;
            goto L9
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OpenLiveVideoTalkFragment a;

        public c(OpenLiveVideoTalkFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            OpenLiveVideoTalkFragment r8 = this.a;
            if (r8.i != 12) goto L5;
            return;
        L5:
            ((ImageView) r8.S90(2131376719)).setBackground(null);
            ((ImageView) this.a.S90(2131376219)).setBackgroundResource(2131253276);
            boolean r2 = true;
            ((ImageView) this.a.S90(2131376219)).setSelected(true);
            ((ImageView) this.a.S90(2131376719)).setSelected(false);
            OpenLiveVideoTalkFragment r9 = this.a;
            r9.i = 12;
            if (r9.j != 7) goto L8;
            int r1 = 2;
        L9:
            r9.j = r1;
            Switch r10 = (Switch) r9.S90(2131387900);
            OpenLiveVideoTalkFragment r3 = this.a;
            if (r3.e == false) goto L15;
            if (r3.j == 5) goto L18;
        L17:
            r2 = false;
        L18:
            r10.setChecked(r2);
            OpenLiveVideoTalkFragment r11 = this.a;
            r11.k.update(r11.h, r11.i, r11.j);
            OpenLiveVideoTalkFragment.T90(this.a, "layout");
            return;
        L15:
            if (r3.j != 2) goto L17;
        L8:
            r1 = 5;
            goto L9
        }
    }

    public static final class d implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ OpenLiveVideoTalkFragment a;

        public d(OpenLiveVideoTalkFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            OpenLiveVideoTalkFragment r7 = this.a;
            int r0 = r7.i;
            if (r0 != 8) goto L5;
            int r2 = 7;
            if (r7.e == false) goto L19;
            if (r6 == true) goto L21;
        L22:
            r7.j = r2;
        L23:
            r7.k.update(r7.h, r0, r7.j);
            OpenLiveVideoTalkFragment.T90(this.a, "seat_fit");
            return;
        L21:
            r2 = 1;
            goto L22
        L19:
            if (r6 == false) goto L21;
        L5:
            if (r0 != 12) goto L23;
            int r3 = 2;
            if (r7.e == false) goto L11;
            if (r6 == true) goto L13;
        L14:
            r7.j = r3;
        L13:
            r3 = 5;
            goto L14
        L11:
            if (r6 == false) goto L13;
            goto L13
        }
    }

    public final void V90() {
        HashMap<String, String> r0 = new HashMap();
        U90(r0);
        boolean r1 = this.h;
        if (r1 == true) goto L5;
    L7:
        if (r1 == true) goto L9;
    L11:
        String r2 = "live";
    L12:
        r0.put("layout_type", r2);
        int r3 = this.j;
        if (r3 != 1) goto L15;
    L18:
        String r4 = "1";
    L19:
        r0.put("empty_seat_show", r4);
        j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_setting_show", r0, new Object[0]);
        return;
    L15:
        if (r3 == 5) goto L18;
        r4 = "0";
        goto L19
    L9:
        if (this.i != 8) goto L11;
        r2 = "radio";
        goto L12
    L5:
        if (this.i != 12) goto L7;
        r2 = "party";
        goto L12
    }

    public final void show() {
        FragmentActivity r0 = this.f;
        if (r0 == null) goto L11;
        FragmentManager r1 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "OpenLiveVideoTalkFragment", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, this, r2) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L8:
        super.show(r1, "OpenLiveVideoTalkFragment");
        return;
    L15:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void updateView() {
        boolean r0 = this.h;
        boolean r9 = false;
        if (r0 == true) goto L5;
    L15:
        if (r0 == true) goto L17;
    L27:
        ((Switch) S90(2131387925)).setChecked(false);
        UtilityKotlinExtentionsKt.u(S90(2131390849));
        UtilityKotlinExtentionsKt.u(S90(2131366871));
        return;
    L17:
        if (this.i != 12) goto L27;
        ((Switch) S90(2131387925)).setChecked(true);
        ((ImageView) S90(2131376719)).setBackground(null);
        ((ImageView) S90(2131376219)).setBackgroundResource(2131253276);
        ((ImageView) S90(2131376219)).setSelected(true);
        ((ImageView) S90(2131376719)).setSelected(false);
        Switch r1 = (Switch) S90(2131387900);
        if (this.e == false) goto L24;
        if (this.j == 5) goto L25;
    L26:
        r1.setChecked(r9);
        UtilityKotlinExtentionsKt.w(S90(2131390849));
        UtilityKotlinExtentionsKt.w(S90(2131366871));
        V90();
        return;
    L25:
        r9 = true;
        goto L26
    L24:
        if (this.j != 2) goto L26;
    L5:
        if (this.i != 8) goto L15;
        ((Switch) S90(2131387925)).setChecked(true);
        ((ImageView) S90(2131376719)).setBackgroundResource(2131253276);
        ((ImageView) S90(2131376219)).setBackground(null);
        ((ImageView) S90(2131376719)).setSelected(true);
        ((ImageView) S90(2131376219)).setSelected(false);
        Switch r2 = (Switch) S90(2131387900);
        if (this.e == false) goto L12;
        if (this.j == 1) goto L13;
    L14:
        r2.setChecked(r9);
        UtilityKotlinExtentionsKt.w(S90(2131390849));
        UtilityKotlinExtentionsKt.w(S90(2131366871));
        V90();
        return;
    L13:
        r9 = true;
        goto L14
    L12:
        if (this.j != 7) goto L14;
        goto L13
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final Context getActivity() {
        return this.f;
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

    public final void U90(HashMap<String, String> r3) {
        r3.put("live_type", "video_live");
        r3.put("anchor_id", je0.d.b0().toString());
        r3.put("request_page", this.g);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954580);
    }

    public static final void T90(OpenLiveVideoTalkFragment r4, String r5) {
        r4.getClass();
        HashMap<String, String> r0 = new HashMap();
        r4.U90(r0);
        boolean r1 = r4.h;
        if (r1 == true) goto L5;
    L7:
        if (r1 == true) goto L9;
    L11:
        String r2 = "live";
    L12:
        r0.put("layout_type", r2);
        int r6 = r4.j;
        if (r6 != 1) goto L15;
    L18:
        String r7 = "1";
    L19:
        r0.put("empty_seat_show", r7);
        r0.put("switch_type", r5);
        j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_layout_switch", r0, new Object[0]);
        return;
    L15:
        if (r6 == 5) goto L18;
        r7 = "0";
        goto L19
    L9:
        if (r4.i != 8) goto L11;
        r2 = "radio";
        goto L12
    L5:
        if (r4.i != 12) goto L7;
        r2 = "party";
        goto L12
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        if (this.e == false) goto L5;
        ((TextView) S90(2131390544)).setText(s1.B(2131917606));
    L6:
        updateView();
        ((Switch) S90(2131387925)).setOnCheckedChangeListener(new a(this));
        r3.c(S90(2131376719), s1.B(2131918075), true);
        r3.c(S90(2131376219), s1.B(2131917612), true);
        ((ImageView) S90(2131376719)).setOnClickListener(new b(this));
        ((ImageView) S90(2131376219)).setOnClickListener(new c(this));
        ((Switch) S90(2131387900)).setOnCheckedChangeListener(new d(this));
        return;
    L5:
        ((TextView) S90(2131390544)).setText(s1.B(2131917605));
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565683, r3, false);
    }

    public OpenLiveVideoTalkFragment(Context r2, String r3, boolean r4, int r5, int r6, g r7) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.d = new LinkedHashMap();
        this.e = vm2.d.h0().a();
    }
}
