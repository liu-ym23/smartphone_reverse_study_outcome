package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.e5;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.utils.z2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PermissionGrantedItem {
    public boolean a;
    public qk1.a b;
    public final ReceiveGiftOpt c;
    public final AnchorRelationShipOpt d;
    public final np1.c e;

    public final class AnchorRelationShipOpt {
        public View a;
        public final /* synthetic */ PermissionGrantedItem b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ LiveSwitchButton a;

            public a(LiveSwitchButton r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                if (r3.l(r1.getContext()) == false) goto L8;
                LiveSwitchButton r2 = this.a;
                if (r2 == null) goto L9;
                r2.performClick();
                return;
            L9:
                return;
            }
        }

        public AnchorRelationShipOpt(PermissionGrantedItem r1) {
            this.b = r1;
        }

        public final void b(long r6) {
            if (this.b.a == true) goto L5;
            return;
        L5:
            View r0 = this.a;
            if (r0 == null) goto L8;
            RelativeLayout r1 = (RelativeLayout) r0.findViewById(2131362519);
        L8:
            View r2 = this.a;
            if (r2 == null) goto L11;
            final LiveSwitchButton r3 = (LiveSwitchButton) r2.findViewById(2131362521);
        L12:
            int r4 = b1.a;
            boolean r5 = true;
            b1.b(true, new PermissionGrantedItem$AnchorRelationShipOpt$updateAnchorRelation$1(this, r3));
            e r7 = com.bytedance.android.livesdk.sharedpref.b.f3;
            Long r8 = Long.valueOf(r6);
            r7.getClass();
            f.d(r7, r8);
            if (r6 == 1) goto L16;
            r5 = false;
        L16:
            if (r3 == null) goto L18;
            r3.setChecked(r5);
        L18:
            a(r3, r5);
            if (r3 == null) goto L22;
            r3.setOnClickListener(new PermissionGrantedItem$AnchorRelationShipOpt$updateAnchorRelation$2(this, r3));
            return;
        L22:
            return;
        L11:
            r3 = null;
            goto L12
        }

        public final void a(LiveSwitchButton r3, boolean r4) {
            r3.n(r3);
            View r0 = this.a;
            if (r0 == null) goto L5;
            r0.setOnClickListener(new a(r3));
        L5:
            View r5 = this.a;
            if (r5 == null) goto L8;
            r5.setImportantForAccessibility(1);
        L8:
            View r6 = this.a;
            if (r6 == null) goto L16;
            TextView r7 = (TextView) r6.findViewById(2131362522);
            if (r7 == null) goto L16;
            CharSequence r8 = r7.getText();
            if (r8 == null) goto L16;
            String r9 = r8.toString();
            if (r9 == null) goto L16;
        L17:
            if (r4 == false) goto L19;
            String r10 = "开启";
        L20:
            View r1 = this.a;
            if (r1 == null) goto L24;
            r1.setContentDescription(r9 + ' ' + r10);
            return;
        L24:
            return;
        L19:
            r10 = "关闭";
        L16:
            r9 = s1.B(2131914866);
            goto L17
        }
    }

    public final class ReceiveGiftOpt {
        public View a;
        public final /* synthetic */ PermissionGrantedItem b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ LiveSwitchButton a;

            public a(LiveSwitchButton r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                if (r3.l(r1.getContext()) == false) goto L8;
                LiveSwitchButton r2 = this.a;
                if (r2 == null) goto L9;
                r2.performClick();
                return;
            L9:
                return;
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ReceiveGiftOpt a;

            public b(ReceiveGiftOpt r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.b.e.closeSettingPanel();
                Context r2 = this.a.b.e.getContext();
                if (r2 == null) goto L6;
                e5.b(r2);
                return;
            }
        }

        public static final class c implements View.OnClickListener {
            public final /* synthetic */ ReceiveGiftOpt a;

            public c(ReceiveGiftOpt r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.b.e.closeSettingPanel();
                Activity r2 = z2.b.getActivity();
                if (r2 == null) goto L6;
                e5.a(r2);
                return;
            }
        }

        public ReceiveGiftOpt(PermissionGrantedItem r1) {
            this.b = r1;
        }

        public final void b(long r13) {
            View r0 = this.a;
            CharSequence r1 = null;
            if (r0 == null) goto L5;
            final LiveSwitchButton r2 = (LiveSwitchButton) r0.findViewById(2131362529);
        L6:
            View r3 = this.a;
            if (r3 == null) goto L9;
            TextView r4 = (TextView) r3.findViewById(2131362528);
        L10:
            View r5 = this.a;
            if (r5 == null) goto L13;
            RelativeLayout r6 = (RelativeLayout) r5.findViewById(2131362532);
        L14:
            View r7 = this.a;
            if (r7 == null) goto L17;
            LinearLayout r8 = (LinearLayout) r7.findViewById(2131392203);
        L18:
            View r9 = this.a;
            if (r9 == null) goto L21;
            TextView r10 = (TextView) r9.findViewById(2131362531);
        L22:
            Boolean r11 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.e3.getValue();
            if (r2 == null) goto L26;
            r2.setChecked(r11.booleanValue());
        L26:
            if (r2 != null) goto L28;
        L33:
            a(r2, r11.booleanValue());
            if (r2 == null) goto L37;
            r2.setOnClickListener(new PermissionGrantedItem$ReceiveGiftOpt$updateUserGiftUI$1(this, r2));
        L37:
            if (r13 != 5) goto L49;
            if (r6 == null) goto L40;
            r6.setVisibility(0);
        L40:
            if (r4 == null) goto L42;
            r4.setVisibility(8);
        L42:
            if (r10 == null) goto L44;
            r10.setVisibility(0);
        L44:
            if (r10 == null) goto L46;
            r10.setText(s1.B(2131914618));
        L46:
            if (r8 == null) goto L66;
            r8.setOnClickListener(new b(this));
        L66:
            if (r6 != null) goto L68;
        L71:
            int r14 = b1.a;
            b1.b(true, new PermissionGrantedItem$ReceiveGiftOpt$updateUserGiftUI$4(this));
            return;
        L68:
            if (r10 == null) goto L70;
            r1 = r10.getText();
        L70:
            r6.setContentDescription(String.valueOf(r1).concat("去认证"));
            goto L71
        L49:
            if (r13 != 7) goto L60;
            if (r6 == null) goto L52;
            r6.setVisibility(0);
        L52:
            if (r4 == null) goto L54;
            r4.setVisibility(8);
        L54:
            if (r10 == null) goto L56;
            r10.setVisibility(0);
        L56:
            if (r10 == null) goto L58;
            r10.setText(s1.B(2131914619));
        L58:
            if (r8 == null) goto L66;
            r8.setOnClickListener(new c(this));
            goto L66
        L60:
            if (r6 == null) goto L62;
            r6.setVisibility(8);
        L62:
            if (r4 == null) goto L64;
            r4.setVisibility(0);
        L64:
            if (r10 == null) goto L66;
            r10.setVisibility(8);
            goto L66
        L28:
            if (r2.isChecked() != true) goto L33;
            if (r6 == null) goto L31;
            r6.setVisibility(8);
        L31:
            if (r4 == null) goto L33;
            r4.setVisibility(0);
            goto L33
        L21:
            r10 = null;
            goto L22
        L17:
            r8 = null;
            goto L18
        L13:
            r6 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public final void a(LiveSwitchButton r3, boolean r4) {
            r3.n(r3);
            View r0 = this.a;
            if (r0 == null) goto L5;
            r0.setOnClickListener(new a(r3));
        L5:
            View r5 = this.a;
            if (r5 == null) goto L8;
            r5.setImportantForAccessibility(1);
        L8:
            View r6 = this.a;
            if (r6 == null) goto L16;
            TextView r7 = (TextView) r6.findViewById(2131362530);
            if (r7 == null) goto L16;
            CharSequence r8 = r7.getText();
            if (r8 == null) goto L16;
            String r9 = r8.toString();
            if (r9 == null) goto L16;
        L17:
            if (r4 == false) goto L19;
            String r10 = "开启";
        L20:
            View r1 = this.a;
            if (r1 == null) goto L24;
            r1.setContentDescription(r9 + ' ' + r10);
            return;
        L24:
            return;
        L19:
            r10 = "关闭";
        L16:
            r9 = s1.B(2131914620);
            goto L17
        }
    }

    public PermissionGrantedItem(np1.c r2) {
        Intrinsics.checkNotNullParameter(r2, "panelCtx");
        this.e = r2;
        this.a = true;
        this.c = new ReceiveGiftOpt(this);
        this.d = new AnchorRelationShipOpt(this);
    }

    public final np1.b a(final np1.c r3) {
        Intrinsics.checkNotNullParameter(r3, "panelContext");
        Intrinsics.checkNotNullParameter(r3, "panelContext");
        if ((!VrUtils.w(r3.getDataCenter())) == true) goto L5;
        return null;
    L5:
        np1.b.a r0 = np1.b.a;
        Function0<g> r1 = new PermissionGrantedItem$provide$1(r3);
        Function1<g, Unit> r4 = new PermissionGrantedItem$provide$2(this);
        r0.getClass();
        return np1.b.a.a(r1, r4);
    }
}
