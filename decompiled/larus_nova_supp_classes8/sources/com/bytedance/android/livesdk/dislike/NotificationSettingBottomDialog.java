package com.bytedance.android.livesdk.dislike;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.dislike.layout.NotificationSettingItemLayout;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/NotificationSettingBottomDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "b", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NotificationSettingBottomDialog extends LiveDialogFragment {
    public static final /* synthetic */ int u = 0;
    public ActionsManager d;
    public final List<w> e;
    public LinearLayout f;
    public FrameLayout g;
    public HSImageView h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public View l;
    public b m;
    public String n;
    public String o;
    public Long p;
    public String q;
    public ImageModel r;
    public final float s;
    public final float t;

    public static final class a {
        public String a;
        public String b;
        public Long c;
        public String d;
        public ImageModel e;

        public a() {
        }

        public final NotificationSettingBottomDialog a() {
            int r0 = NotificationSettingBottomDialog.u;
            Intrinsics.checkNotNullParameter(this, "builder");
            NotificationSettingBottomDialog r1 = new NotificationSettingBottomDialog();
            r1.q = this.d;
            r1.n = this.a;
            r1.p = this.c;
            r1.o = this.b;
            r1.r = this.e;
            return r1;
        }
    }

    public interface b {
        void onFailure();

        void onSuccess(String r1, long r2);
    }

    public static final class c {
    }

    public static final class d implements m {
        public final /* synthetic */ NotificationSettingBottomDialog a;
        public final /* synthetic */ View b;

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ String a() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ void b() {
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ boolean c() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final /* synthetic */ void refreshData() {
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void dismiss() {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public Context getContext() {
            return this.b.getContext();
        }

        public d(NotificationSettingBottomDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ NotificationSettingBottomDialog a;

        public e(NotificationSettingBottomDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public NotificationSettingBottomDialog() {
        this.e = new ArrayList();
        this.s = 44.0f;
        this.t = 40.0f;
        setNoTitleAndCancelOutside(true);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == true) goto L11;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L16;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    L11:
        if (TTLiveSDK.hostService().hostBusiness().isLivePushOpen() == true) goto L18;
        TTLiveSDK.hostService().hostBusiness().updateLivePushOpen();
        f2.i(getContext(), s1.B(2131920767), 0);
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
        return;
    L5:
        if (getActivity() != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(this.n, "setting") == false) goto L9;
    L10:
        Window r1 = r0.getWindow();
        if (r1 == null) goto L13;
        r1.setBackgroundDrawableResource(R.color.transparent);
    L13:
        Window r2 = r0.getWindow();
        if (r2 == null) goto L16;
        WindowManager.LayoutParams r3 = r2.getAttributes();
    L17:
        if (r3 == null) goto L19;
        r3.dimAmount = 0.6f;
    L19:
        Window r4 = r0.getWindow();
        if (r4 == null) goto L26;
        r4.setAttributes(r3);
        return;
    L26:
        return;
    L16:
        r3 = null;
        goto L17
    L9:
        if (Intrinsics.areEqual(this.n, "others_homepage") == true) goto L10;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setBackgroundDrawable(new ColorDrawable(s1.h(2131107008)));
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.dimAmount = 0.0f;
        r5.setAttributes(r0);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954578);
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        d r2 = new d(this, r12);
        Room r3 = null;
        String r0 = this.n;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.d = new ActionsManager(r2, r3, r0, "", Boolean.FALSE, 32);
        LinearLayout r14 = (LinearLayout) r12.findViewById(2131385992);
        this.f = (LinearLayout) r12.findViewById(2131392029);
        this.i = (TextView) r12.findViewById(2131392049);
        this.h = r12.findViewById(2131391990);
        this.j = (ImageView) r12.findViewById(2131385975);
        this.l = r12.findViewById(2131388762);
        this.k = (TextView) r12.findViewById(2131381057);
        this.g = (FrameLayout) r12.findViewById(2131381056);
        String r15 = this.n;
        boolean r1 = true;
        if (r15 == null) goto L55;
        int r4 = r15.hashCode();
        if (r4 == (-326696768)) goto L42;
        if (r4 == 809483594) goto L37;
        if (r4 != 1985941072) goto L55;
        if (r15.equals("setting") == false) goto L55;
        View r16 = this.l;
        if (r16 == null) goto L20;
        r16.setVisibility(8);
    L20:
        LinearLayout r17 = this.f;
        if (r17 == null) goto L23;
        r17.setVisibility(0);
    L23:
        LinearLayout r18 = this.f;
        if (r18 == null) goto L28;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L28;
        r19.height = (int) UIUtils.dip2Px(getContext(), this.s);
    L28:
        FrameLayout r110 = this.g;
        if (r110 == null) goto L33;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L33;
        r111.height = (int) UIUtils.dip2Px(getContext(), this.t);
    L33:
        TextView r112 = this.k;
        if (r112 == null) goto L55;
        r112.setText(s1.B(2131920750));
        goto L55
    L37:
        if (r15.equals("others_homepage") == false) goto L55;
        TextView r113 = this.k;
        if (r113 == null) goto L55;
        r113.setText(s1.B(2131920750));
        goto L55
    L42:
        if (r15.equals("long_press") == false) goto L55;
        ImageView r114 = this.j;
        if (r114 == null) goto L46;
        r114.setVisibility(8);
    L46:
        TextView r115 = this.k;
        if (r115 == null) goto L49;
        a1.j(r115, 1);
    L49:
        TextView r116 = this.k;
        if (r116 == null) goto L52;
        a1.m(r116, 0);
    L52:
        TextView r117 = this.k;
        if (r117 == null) goto L55;
        r117.setText(s1.B(2131920747));
    L55:
        ImageView r118 = this.j;
        if (r118 == null) goto L58;
        r118.setOnClickListener(new e(this));
    L58:
        String r119 = this.q;
        if (r119 == null) goto L63;
        TextView r5 = this.i;
        if (r5 == null) goto L63;
        r5.setText(r119);
    L63:
        ImageModel r120 = this.r;
        if (r120 == null) goto L69;
        HSImageView r6 = this.h;
        if (((Boolean) j40.k.a.getValue()).booleanValue() == false) goto L68;
        ImageLoader.bindImage(r6, r120, 2131251889);
        goto L69
    L68:
        com.bytedance.android.livesdk.chatroom.utils.a1.v(r6, r120, 2131251889);
    L69:
        List<w> r121 = this.e;
        Long r7 = this.p;
        if (r7 != null) goto L73;
    L75:
        boolean r8 = false;
    L76:
        nt1.b r9 = new nt1.b(2131252480, 2131920748, r8);
        ActionsManager r10 = this.d;
        if (r10 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mActionsManager");
    L79:
        com.bytedance.android.livesdk.dislike.action.c r11 = new com.bytedance.android.livesdk.dislike.action.c(r10, this.o, this.m);
        ItemType r20 = ItemType.LIVE_NOTIFICATION;
        ArrayList r122 = (ArrayList) r121;
        r122.add(new w(r9, r11, r20));
        if (jc1.k.n(IHostBusiness.class).isEnablePersonalRecommend() == false) goto L92;
        List<w> r123 = this.e;
        Long r21 = this.p;
        if (r21 != null) goto L85;
    L87:
        boolean r22 = false;
    L88:
        nt1.b r23 = new nt1.b(2131252478, 2131920761, r22);
        ActionsManager r24 = this.d;
        if (r24 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mActionsManager");
    L91:
        ArrayList r124 = (ArrayList) r123;
        r124.add(new w(r23, new com.bytedance.android.livesdk.dislike.action.t(r24, this.o, this.m), r20));
        goto L92
    L85:
        if (r21.longValue() != 2) goto L87;
        r22 = true;
    L92:
        List<w> r125 = this.e;
        Long r25 = this.p;
        if (r25 != null) goto L96;
    L98:
        r1 = false;
    L99:
        nt1.b r26 = new nt1.b(2131252482, 2131920759, r1);
        ActionsManager r27 = this.d;
        if (r27 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mActionsManager");
    L102:
        ArrayList r126 = (ArrayList) r125;
        r126.add(new w(r26, new com.bytedance.android.livesdk.dislike.action.q(r27, this.o, this.m), r20));
        Iterator r127 = ((ArrayList) this.e).iterator();
    L104:
        if (r127.hasNext() == false) goto L108;
        w r28 = (w) r127.next();
        Context r29 = getContext();
        if (r29 == null) goto L104;
        NotificationSettingItemLayout r30 = new NotificationSettingItemLayout(r29);
        r30.setOnClickListener(new v(r28));
        r30.update(r28.c);
        r14.addView(r30);
        goto L104
    L108:
        return;
    L96:
        if (r25.longValue() != 3) goto L98;
    L73:
        if (r7.longValue() != 1) goto L75;
        r8 = true;
        goto L76
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565675, r3, false);
    }
}
