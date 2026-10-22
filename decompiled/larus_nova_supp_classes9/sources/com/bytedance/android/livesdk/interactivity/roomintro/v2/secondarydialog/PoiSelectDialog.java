package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.PoiInfo;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r52.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/secondarydialog/PoiSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PoiSelectDialog extends LiveDialogFragment {
    public static final /* synthetic */ int l = 0;
    public RoomIntroDataSource d;
    public Integer e;
    public View f;
    public LiveSwitchButton g;
    public TextView h;
    public HSImageView i;
    public View j;
    public boolean k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PoiSelectDialog a;

        public b(PoiSelectDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public PoiSelectDialog() {
    }

    public final void S90(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super.onDismiss(r3);
        RoomIntroDataSource r4 = this.d;
        boolean r0 = false;
        if (r4 == null) goto L9;
        PropertyOwner r5 = r4.k;
        if (r5 == null) goto L9;
        Boolean r6 = (Boolean) r5.a;
        if (r6 == null) goto L9;
        boolean r7 = r6.booleanValue();
    L11:
        if (this.k == true) goto L34;
        if (r7 == false) goto L35;
        RoomIntroDataSource r8 = this.d;
        if (r8 == null) goto L36;
        String r9 = r8.a();
        if (r9 != null) goto L18;
    L19:
        r0 = true;
    L20:
        if (r0 != true) goto L37;
        RoomIntroDataSource r10 = this.d;
        if (r10 == null) goto L38;
        PoiInfo r11 = r10.o.g();
        if (r11 == null) goto L26;
        String r13 = r11.getDefaultIntro();
    L27:
        if (r13 == null) goto L39;
        RoomIntroDataSource r1 = this.d;
        if (r1 == null) goto L40;
        Intrinsics.checkNotNullParameter(r13, "text");
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a r2 = r1.c;
        if (r2 == null) goto L41;
        r2.a(r13);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L26:
        r13 = null;
        goto L27
    L38:
        return;
    L37:
        return;
    L18:
        if (r9.length() != 0) goto L20;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L9:
        r7 = false;
        goto L11
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
        setShouldUseNewPanel(true);
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
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

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        View r7 = this.f;
        if (r7 == null) goto L9;
        Integer r0 = this.e;
        if (r0 == null) goto L7;
        int r1 = r0.intValue();
    L8:
        a1.k(r7, Math.max(466, r1));
        goto L9
    L7:
        r1 = 0;
    L9:
        LiveSwitchButton r8 = this.g;
        if (r8 == null) goto L12;
        r8.setOnCheckedChangeListener(new com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog.b(this));
    L12:
        RoomIntroDataSource r9 = this.d;
        if (r9 == null) goto L19;
        PropertyOwner r10 = r9.k;
        if (r10 == null) goto L19;
        Boolean r11 = (Boolean) r10.a;
        if (r11 == null) goto L19;
        boolean r13 = r11.booleanValue();
    L20:
        this.k = r13;
        LiveSwitchButton r2 = this.g;
        if (r2 == null) goto L23;
        boolean r3 = r2.isChecked();
    L24:
        if (r13 == r3) goto L28;
        LiveSwitchButton r14 = this.g;
        if (r14 == null) goto L28;
        r14.f(false, false);
    L28:
        int r15 = s1.y() - UtilityKotlinExtentionsKt.i(40);
        RoomIntroDataSource r16 = this.d;
        if (r16 == null) goto L31;
        double r4 = ((double) ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) r16.a.getValue()).b()) / ((double) ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) r16.a.getValue()).d());
    L32:
        int r17 = (int) (r4 * ((double) r15));
        HSImageView r18 = this.i;
        if (r18 == null) goto L35;
        a1.k(r18, r17);
    L35:
        HSImageView r19 = this.i;
        RoomIntroDataSource r20 = this.d;
        String r21 = null;
        if (r20 == null) goto L38;
        String r23 = ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) r20.a.getValue()).c();
    L39:
        ImageLoader.bindImage(r19, r23);
        TextView r24 = this.h;
        if (r24 != null) goto L42;
    L45:
        View r25 = this.j;
        if (r25 == null) goto L49;
        r25.setOnClickListener(new b(this));
        return;
    L49:
        return;
    L42:
        if (this.d == null) goto L44;
        r21 = (String) z1.a.getValue();
    L44:
        r24.setText(r21);
        goto L45
    L38:
        r23 = null;
        goto L39
    L31:
        r4 = 0.5313432835820896d;
        goto L32
    L23:
        r3 = false;
    L19:
        r13 = false;
        goto L20
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565706, r3, false);
        this.f = r5;
        this.g = r5.findViewById(2131382725);
        this.h = (TextView) r5.findViewById(2131382720);
        this.i = r5.findViewById(2131382719);
        this.j = r5.findViewById(2131382718);
        return r5;
    }
}
