package com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.f60;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/fragment/OpenLiveVideoTalkFragmentNew;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "LayoutType", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpenLiveVideoTalkFragmentNew extends LiveDialogFragment {
    public static final /* synthetic */ int w = 0;
    public Context d;
    public String e;
    public boolean f;
    public int g;
    public int h;
    public qd0.g i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public TextView s;
    public View t;
    public Switch u;
    public View v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/fragment/OpenLiveVideoTalkFragmentNew$LayoutType;", "", "BigWindow", "Dynamic", "Fixed", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LayoutType extends Enum<LayoutType> {
        public static final LayoutType BigWindow = null;
        public static final LayoutType Dynamic = null;
        public static final LayoutType Fixed = null;
        public static final /* synthetic */ LayoutType[] a = null;

        static {
            LayoutType r1 = new LayoutType("BigWindow", 0);
            BigWindow = r1;
            LayoutType r2 = new LayoutType("Dynamic", 1);
            Dynamic = r2;
            LayoutType r3 = new LayoutType("Fixed", 2);
            Fixed = r3;
            a = new LayoutType[]{r1, r2, r3};
        }

        public static LayoutType valueOf(String r1) {
            return (LayoutType) r27.a.a(LayoutType.class, r1);
        }

        public static LayoutType[] values() {
            return (LayoutType[]) a.clone();
        }

        public LayoutType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew a;

        public b(OpenLiveVideoTalkFragmentNew r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r7, boolean r8) {
            OpenLiveVideoTalkFragmentNew r9 = this.a;
            if (r8 == false) goto L14;
            r9.f = true;
            if (r9.g != 0) goto L8;
            r9.g = 12;
        L8:
            if (r9.h != 0) goto L10;
            r9.h = 2;
        L10:
            qd0.g r3 = r9.i;
            if (r3 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L13:
            r3.update(r9.f, r9.g, r9.h);
        L18:
            r9.updateView();
            if (r8 == false) goto L21;
            String r10 = "on";
        L22:
            HashMap<String, String> r1 = new HashMap();
            r9.T90(r1);
            boolean r4 = r9.f;
            if (r4 == true) goto L25;
        L27:
            if (r4 == true) goto L29;
        L31:
            String r11 = "live";
        L32:
            r1.put("function_type", r11);
            r1.put("action_type", r10);
            j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_setting_switch", r1, new Object[0]);
            return;
        L29:
            if (r9.g != 8) goto L31;
            r11 = "radio";
            goto L32
        L25:
            if (r9.g != 12) goto L27;
            r11 = "party";
            goto L32
        L21:
            r10 = "off";
            goto L22
        L14:
            r9.f = false;
            qd0.g r5 = r9.i;
            if (r5 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L17:
            r5.update(r9.f, 0, 0);
            goto L18
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew a;

        public c(OpenLiveVideoTalkFragmentNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            OpenLiveVideoTalkFragmentNew r5 = this.a;
            if (r5.g != 8) goto L5;
            return;
        L5:
            ImageView r6 = r5.j;
            if (r6 == null) goto L8;
            r6.setBackgroundResource(2131253276);
        L8:
            ImageView r7 = this.a.k;
            if (r7 == null) goto L11;
            r7.setBackground(null);
        L11:
            ImageView r8 = this.a.j;
            int r0 = 1;
            if (r8 == null) goto L14;
            r8.setSelected(true);
        L14:
            ImageView r9 = this.a.k;
            if (r9 == null) goto L17;
            r9.setSelected(false);
        L17:
            OpenLiveVideoTalkFragmentNew r10 = this.a;
            r10.g = 8;
            if (r10.h != 2) goto L20;
            r0 = 7;
        L20:
            r10.h = r0;
            r10.X90();
            OpenLiveVideoTalkFragmentNew r11 = this.a;
            r11.V90(r11.h);
            qd0.g r12 = this.a.i;
            if (r12 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L23:
            OpenLiveVideoTalkFragmentNew r1 = this.a;
            r12.update(r1.f, r1.g, r1.h);
            OpenLiveVideoTalkFragmentNew.S90(this.a, "layout");
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew a;

        public d(OpenLiveVideoTalkFragmentNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            OpenLiveVideoTalkFragmentNew r5 = this.a;
            if (r5.g != 12) goto L5;
            return;
        L5:
            ImageView r6 = r5.j;
            if (r6 == null) goto L8;
            r6.setBackground(null);
        L8:
            ImageView r7 = this.a.k;
            if (r7 == null) goto L11;
            r7.setBackgroundResource(2131253276);
        L11:
            ImageView r8 = this.a.j;
            if (r8 == null) goto L14;
            r8.setSelected(false);
        L14:
            ImageView r9 = this.a.k;
            if (r9 == null) goto L17;
            r9.setSelected(true);
        L17:
            OpenLiveVideoTalkFragmentNew r10 = this.a;
            r10.g = 12;
            if (r10.h != 1) goto L20;
            int r0 = 5;
        L21:
            r10.h = r0;
            r10.X90();
            OpenLiveVideoTalkFragmentNew r11 = this.a;
            r11.V90(r11.h);
            qd0.g r12 = this.a.i;
            if (r12 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L24:
            OpenLiveVideoTalkFragmentNew r1 = this.a;
            r12.update(r1.f, r1.g, r1.h);
            OpenLiveVideoTalkFragmentNew.S90(this.a, "layout");
            return;
        L20:
            r0 = 2;
            goto L21
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew a;

        public e(OpenLiveVideoTalkFragmentNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            OpenLiveVideoTalkFragmentNew r5 = this.a;
            r5.h = 102;
            r5.V90(102);
            qd0.g r6 = this.a.i;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L5:
            OpenLiveVideoTalkFragmentNew r0 = this.a;
            r6.update(r0.f, r0.g, r0.h);
            OpenLiveVideoTalkFragmentNew.S90(this.a, "seat_fit");
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew a;

        public f(OpenLiveVideoTalkFragmentNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            OpenLiveVideoTalkFragmentNew r5 = this.a;
            int r0 = r5.g;
            if (r0 != 8) goto L5;
            r5.h = 7;
        L9:
            r5.V90(r5.h);
            qd0.g r6 = this.a.i;
            if (r6 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L12:
            OpenLiveVideoTalkFragmentNew r1 = this.a;
            r6.update(r1.f, r1.g, r1.h);
            OpenLiveVideoTalkFragmentNew.S90(this.a, "seat_fit");
            return;
        L5:
            if (r0 != 12) goto L9;
            r5.h = 2;
            goto L9
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew a;

        public g(OpenLiveVideoTalkFragmentNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            OpenLiveVideoTalkFragmentNew r5 = this.a;
            int r0 = r5.g;
            if (r0 != 8) goto L5;
            r5.h = 1;
        L9:
            r5.V90(r5.h);
            qd0.g r6 = this.a.i;
            if (r6 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L12:
            OpenLiveVideoTalkFragmentNew r1 = this.a;
            r6.update(r1.f, r1.g, r1.h);
            OpenLiveVideoTalkFragmentNew.S90(this.a, "seat_fit");
            return;
        L5:
            if (r0 != 12) goto L9;
            r5.h = 5;
            goto L9
        }
    }

    static {
    }

    public final void X90() {
        if (this.g != 8) goto L17;
        ImageView r0 = this.o;
        if (r0 == null) goto L7;
        r0.setImageResource(2131253247);
    L7:
        ImageView r1 = this.q;
        if (r1 == null) goto L10;
        r1.setImageResource(2131253248);
    L10:
        TextView r2 = this.p;
        if (r2 == null) goto L13;
        r2.setText(2131917655);
    L13:
        TextView r3 = this.r;
        if (r3 == null) goto L16;
        r3.setText(2131917656);
    L16:
        W90(this.g);
        return;
    L17:
        ImageView r4 = this.o;
        if (r4 == null) goto L20;
        r4.setImageResource(2131253278);
    L20:
        ImageView r5 = this.q;
        if (r5 == null) goto L23;
        r5.setImageResource(2131253279);
    L23:
        TextView r6 = this.p;
        if (r6 == null) goto L26;
        r6.setText(2131918040);
    L26:
        TextView r7 = this.r;
        if (r7 == null) goto L29;
        r7.setText(2131918041);
    L29:
        W90(this.g);
    }

    public final void show() {
        FragmentActivity r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
    L5:
        if (r0 == null) goto L13;
        FragmentManager r1 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "OpenLiveVideoTalkFragment", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, this, r2) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L10:
        super.show(r1, "OpenLiveVideoTalkFragment");
        return;
    L17:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void updateView() {
        boolean r0 = this.f;
        boolean r3 = false;
        if (r0 == true) goto L5;
    L31:
        if (r0 == true) goto L33;
    L59:
        Switch r1 = this.u;
        if (r1 == null) goto L62;
        r1.setChecked(false);
    L62:
        TextView r2 = this.s;
        if (r2 == null) goto L65;
        UtilityKotlinExtentionsKt.u(r2);
    L65:
        View r4 = this.t;
        if (r4 == null) goto L71;
        UtilityKotlinExtentionsKt.u(r4);
        return;
    L71:
        return;
    L33:
        if (this.g != 12) goto L59;
        Switch r5 = this.u;
        if (r5 == null) goto L37;
        r5.setChecked(true);
    L37:
        ImageView r6 = this.j;
        if (r6 == null) goto L40;
        r6.setBackground(null);
    L40:
        ImageView r7 = this.k;
        if (r7 == null) goto L43;
        r7.setBackgroundResource(2131253276);
    L43:
        ImageView r8 = this.k;
        if (r8 == null) goto L46;
        r8.setSelected(true);
    L46:
        ImageView r9 = this.j;
        if (r9 == null) goto L49;
        r9.setSelected(false);
    L49:
        X90();
        V90(this.h);
        TextView r10 = this.s;
        if (r10 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r10);
    L52:
        View r11 = this.t;
        if (r11 == null) goto L56;
        UtilityKotlinExtentionsKt.w(r11);
    L56:
        if (this.h != 2) goto L58;
        r3 = true;
    L58:
        U90(r3);
        return;
    L5:
        if (this.g != 8) goto L31;
        Switch r12 = this.u;
        if (r12 == null) goto L9;
        r12.setChecked(true);
    L9:
        ImageView r13 = this.j;
        if (r13 == null) goto L12;
        r13.setBackgroundResource(2131253276);
    L12:
        ImageView r14 = this.k;
        if (r14 == null) goto L15;
        r14.setBackground(null);
    L15:
        ImageView r15 = this.j;
        if (r15 == null) goto L18;
        r15.setSelected(true);
    L18:
        ImageView r16 = this.k;
        if (r16 == null) goto L21;
        r16.setSelected(false);
    L21:
        X90();
        V90(this.h);
        TextView r17 = this.s;
        if (r17 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r17);
    L24:
        View r18 = this.t;
        if (r18 == null) goto L28;
        UtilityKotlinExtentionsKt.w(r18);
    L28:
        if (this.h != 7) goto L30;
        r3 = true;
    L30:
        U90(r3);
    }

    public OpenLiveVideoTalkFragmentNew() {
    }

    public final void onDestroyView() {
        super.onDestroyView();
    }

    public final void T90(HashMap<String, String> r3) {
        r3.put("live_type", "video_live");
        r3.put("anchor_id", je0.d.b0().toString());
        String r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("source");
    L5:
        r3.put("request_page", r0);
    }

    public final void U90(boolean r5) {
        HashMap<String, String> r0 = new HashMap();
        T90(r0);
        boolean r1 = this.f;
        if (r1 == true) goto L5;
    L7:
        if (r1 == true) goto L9;
    L11:
        String r2 = "live";
    L12:
        r0.put("layout_type", r2);
        int r3 = this.h;
        if (r3 != 1) goto L15;
    L18:
        String r4 = "1";
    L19:
        r0.put("empty_seat_show", r4);
        if (r5 == false) goto L22;
        String r6 = "seat_fit";
    L23:
        r0.put("default_layout_type", r6);
        j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_setting_show", r0, new Object[0]);
        return;
    L22:
        r6 = "normal";
        goto L23
    L15:
        if (r3 == 5) goto L18;
        r4 = "0";
        goto L19
    L9:
        if (this.g != 8) goto L11;
        r2 = "radio";
        goto L12
    L5:
        if (this.g != 12) goto L7;
        r2 = "party";
        goto L12
    }

    public final void V90(int r6) {
        if (r6 != 2) goto L5;
    L10:
        LayoutType r7 = LayoutType.Dynamic;
    L11:
        int r8 = if0.a.a[r7.ordinal()];
        if (r8 == 1) goto L50;
        if (r8 == 2) goto L32;
        ImageView r9 = this.l;
        if (r9 == null) goto L17;
        r9.setSelected(false);
    L17:
        ImageView r10 = this.l;
        if (r10 == null) goto L20;
        r10.setBackground(null);
    L20:
        ImageView r11 = this.m;
        if (r11 == null) goto L23;
        r11.setSelected(false);
    L23:
        ImageView r12 = this.m;
        if (r12 == null) goto L26;
        r12.setBackground(null);
    L26:
        ImageView r13 = this.n;
        if (r13 == null) goto L29;
        r13.setBackgroundResource(2131253276);
    L29:
        ImageView r14 = this.n;
        if (r14 == null) goto L69;
        r14.setSelected(true);
        return;
    L69:
        return;
    L32:
        ImageView r15 = this.l;
        if (r15 == null) goto L35;
        r15.setSelected(false);
    L35:
        ImageView r16 = this.l;
        if (r16 == null) goto L38;
        r16.setBackground(null);
    L38:
        ImageView r17 = this.m;
        if (r17 == null) goto L41;
        r17.setBackgroundResource(2131253276);
    L41:
        ImageView r18 = this.m;
        if (r18 == null) goto L44;
        r18.setSelected(true);
    L44:
        ImageView r19 = this.n;
        if (r19 == null) goto L47;
        r19.setSelected(false);
    L47:
        ImageView r20 = this.n;
        if (r20 == null) goto L71;
        r20.setBackground(null);
        return;
    L71:
        return;
    L50:
        ImageView r21 = this.l;
        if (r21 == null) goto L53;
        r21.setBackgroundResource(2131253276);
    L53:
        ImageView r22 = this.l;
        if (r22 == null) goto L56;
        r22.setSelected(true);
    L56:
        ImageView r23 = this.m;
        if (r23 == null) goto L59;
        r23.setSelected(false);
    L59:
        ImageView r24 = this.m;
        if (r24 == null) goto L62;
        r24.setBackground(null);
    L62:
        ImageView r25 = this.n;
        if (r25 == null) goto L65;
        r25.setSelected(false);
    L65:
        ImageView r26 = this.n;
        if (r26 == null) goto L73;
        r26.setBackground(null);
        return;
    L73:
        return;
    L5:
        if (r6 == 7) goto L10;
        if (r6 == 102) goto L9;
        r7 = LayoutType.Fixed;
        goto L11
    L9:
        r7 = LayoutType.BigWindow;
        goto L11
    }

    public final void W90(int r7) {
        Long r0 = (Long) f60.a.getValue();
        ViewGroup.LayoutParams r1 = null;
        if (r0 != null) goto L6;
    L62:
        ImageView r8 = this.l;
        if (r8 == null) goto L65;
        UtilityKotlinExtentionsKt.t(r8);
    L65:
        View r9 = this.v;
        if (r9 == null) goto L68;
        UtilityKotlinExtentionsKt.t(r9);
    L68:
        ImageView r10 = this.m;
        if (r10 == null) goto L71;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L73:
        if ((r11 instanceof ConstraintLayout.LayoutParams) == true) goto L75;
        r11 = null;
    L75:
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (r12 == null) goto L78;
        ((ViewGroup.MarginLayoutParams) r12).leftMargin = s1.f(0.0f);
    L78:
        TextView r13 = this.p;
        if (r13 == null) goto L81;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L83:
        if ((r14 instanceof LinearLayout.LayoutParams) == true) goto L85;
        r14 = null;
    L85:
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        if (r15 == null) goto L88;
        r15.leftMargin = s1.f(8.0f);
    L88:
        ImageView r16 = this.n;
        if (r16 == null) goto L91;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L93:
        if ((r17 instanceof ConstraintLayout.LayoutParams) == true) goto L95;
        r17 = null;
    L95:
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
        if (r18 == null) goto L98;
        ((ViewGroup.MarginLayoutParams) r18).leftMargin = s1.f(14.0f);
    L98:
        TextView r19 = this.r;
        if (r19 == null) goto L101;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
    L103:
        if ((r20 instanceof LinearLayout.LayoutParams) == false) goto L106;
        r1 = r20;
    L106:
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
        if (r2 == null) goto L109;
        r2.leftMargin = s1.f(8.0f);
    L109:
        TextView r21 = this.p;
        if (r21 == null) goto L112;
        r21.setTextSize(14.0f);
    L112:
        TextView r22 = this.r;
        if (r22 == null) goto L118;
        r22.setTextSize(14.0f);
        return;
    L118:
        return;
    L101:
        r20 = null;
        goto L103
    L91:
        r17 = null;
        goto L93
    L81:
        r14 = null;
        goto L83
    L71:
        r11 = null;
        goto L73
    L6:
        if (r0.longValue() != 2) goto L62;
        if (r7 != 8) goto L62;
        ImageView r23 = this.l;
        if (r23 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r23);
    L12:
        View r24 = this.v;
        if (r24 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r24);
    L15:
        ImageView r25 = this.m;
        if (r25 == null) goto L18;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
    L20:
        if ((r26 instanceof ConstraintLayout.LayoutParams) == true) goto L22;
        r26 = null;
    L22:
        ConstraintLayout.LayoutParams r27 = (ConstraintLayout.LayoutParams) r26;
        if (r27 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r27).leftMargin = s1.f(2.0f);
    L25:
        ImageView r28 = this.n;
        if (r28 == null) goto L28;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
    L30:
        if ((r29 instanceof ConstraintLayout.LayoutParams) == true) goto L32;
        r29 = null;
    L32:
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
        if (r30 == null) goto L35;
        ((ViewGroup.MarginLayoutParams) r30).leftMargin = s1.f(2.0f);
    L35:
        TextView r31 = this.p;
        if (r31 == null) goto L38;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
    L40:
        if ((r32 instanceof LinearLayout.LayoutParams) == true) goto L42;
        r32 = null;
    L42:
        LinearLayout.LayoutParams r33 = (LinearLayout.LayoutParams) r32;
        if (r33 == null) goto L45;
        r33.leftMargin = s1.f(4.0f);
    L45:
        TextView r34 = this.r;
        if (r34 == null) goto L48;
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
    L50:
        if ((r35 instanceof LinearLayout.LayoutParams) == false) goto L53;
        r1 = r35;
    L53:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r1;
        if (r3 == null) goto L56;
        r3.leftMargin = s1.f(4.0f);
    L56:
        TextView r36 = this.p;
        if (r36 == null) goto L59;
        r36.setTextSize(11.0f);
    L59:
        TextView r37 = this.r;
        if (r37 == null) goto L116;
        r37.setTextSize(11.0f);
        return;
    L116:
        return;
    L48:
        r35 = null;
        goto L50
    L38:
        r32 = null;
        goto L40
    L28:
        r29 = null;
        goto L30
    L18:
        r26 = null;
        goto L20
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L8;
        String r0 = r3.getString("source");
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        this.e = r0;
        this.f = r3.getBoolean("autoOpen");
        this.g = r3.getInt("scene");
        this.h = r3.getInt("uiLayout");
    L8:
        setStyle(1, 2131954580);
    }

    public static final void S90(OpenLiveVideoTalkFragmentNew r4, String r5) {
        r4.getClass();
        HashMap<String, String> r0 = new HashMap();
        r4.T90(r0);
        boolean r1 = r4.f;
        if (r1 == true) goto L5;
    L7:
        if (r1 == true) goto L9;
    L14:
        String r2 = "live";
    L15:
        r0.put("layout_type", r2);
        int r6 = r4.h;
        if (r6 != 1) goto L18;
    L21:
        String r7 = "1";
    L22:
        r0.put("empty_seat_show", r7);
        r0.put("switch_type", r5);
        j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_layout_switch", r0, new Object[]{IRoom.class, x.class});
        return;
    L18:
        if (r6 == 5) goto L21;
        r7 = "0";
        goto L22
    L9:
        if (r4.g != 8) goto L14;
        if (r4.h != 102) goto L13;
        r2 = "big_frame";
        goto L15
    L13:
        r2 = "radio";
        goto L15
    L5:
        if (r4.g != 12) goto L7;
        r2 = "party";
        goto L15
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.j = (ImageView) r2.findViewById(2131376483);
        this.k = (ImageView) r2.findViewById(2131376485);
        this.l = (ImageView) r2.findViewById(2131376343);
        this.m = (ImageView) r2.findViewById(2131376344);
        this.n = (ImageView) r2.findViewById(2131376345);
        this.v = r2.findViewById(2131378728);
        this.o = (ImageView) r2.findViewById(2131377482);
        this.p = (TextView) r2.findViewById(2131377483);
        this.q = (ImageView) r2.findViewById(2131377502);
        this.r = (TextView) r2.findViewById(2131377503);
        this.u = (Switch) r2.findViewById(2131387925);
        this.s = (TextView) r2.findViewById(2131390851);
        this.t = r2.findViewById(2131366873);
        updateView();
        Switch r4 = this.u;
        if (r4 == null) goto L5;
        r4.setOnCheckedChangeListener(new b(this));
    L5:
        r3.c(this.j, s1.B(2131917652), true);
        r3.c(this.k, s1.B(2131918039), true);
        r3.c(this.m, s1.B(2131917604), true);
        r3.c(this.n, s1.B(2131917617), true);
        ImageView r5 = this.j;
        if (r5 == null) goto L8;
        r5.setOnClickListener(new c(this));
    L8:
        ImageView r6 = this.k;
        if (r6 == null) goto L11;
        r6.setOnClickListener(new d(this));
    L11:
        ImageView r7 = this.l;
        if (r7 == null) goto L14;
        r7.setOnClickListener(new e(this));
    L14:
        ImageView r8 = this.m;
        if (r8 == null) goto L17;
        r8.setOnClickListener(new f(this));
    L17:
        ImageView r9 = this.n;
        if (r9 == null) goto L21;
        r9.setOnClickListener(new g(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565684, r3, false);
    }
}
