package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.FansClubMedal;
import com.bytedance.android.live.base.model.user.FansClubData;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveProfileSettingDialog extends LiveDialogFragment implements com.bytedance.android.livesdk.chatroom.presenter.j.a, View.OnClickListener {
    public static final /* synthetic */ int o = 0;
    public boolean d;
    public com.bytedance.android.livesdk.chatroom.presenter.j e;
    public IUser f;
    public DataCenter g;
    public List<FansClubMedal> h;
    public FansClubData i;
    public FansClubMedal j;
    public View k;
    public RecyclerView l;
    public final r7 m;
    public boolean n;

    public final void uT() {
        if (this.d == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.core.utils.f2.b(2131922320, 0);
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L15;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public LiveProfileSettingDialog() {
        this.m = new r7(this);
        setNoTitleAndCancelOutside(true);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.d = false;
        ((q46.b) this.e).a = null;
    }

    static {
    }

    public final void Xq(Throwable r2) {
        if (this.d == true) goto L5;
        return;
    L5:
        if ((r2 instanceof ApiServerException) == false) goto L7;
        com.bytedance.android.live.core.utils.f2.c(((ApiServerException) r2).getPrompt(), 0);
        return;
    L7:
        ExceptionUtils.handleException(getContext(), r2);
    }

    public final void onActivityCreated(Bundle r5) {
        Dialog r0 = getDialog();
        super.onActivityCreated(r5);
        Window r6 = r0.getWindow();
        if (r6 != null) goto L5;
        return;
    L5:
        if (this.n == true) goto L7;
        r6.setGravity(8388613);
        r6.setLayout(-2, -1);
        r6.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L7:
        r6.setGravity(80);
        r6.setLayout(-1, -2);
        r6.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (r2.getId() != 2131385100) goto L26;
        FansClubData r3 = this.i;
        if (r3 != null) goto L10;
        FansClubMedal r0 = this.j;
        if (r0 == null) goto L10;
        this.e.c0(String.valueOf(r0.getAnchor().getIdStr()));
        return;
    L10:
        if (r3 != null) goto L12;
    L15:
        if (r3 != null) goto L17;
    L24:
        uT();
        return;
    L17:
        if (this.j == null) goto L24;
        if (TextUtils.isEmpty(r3.getClubName()) == true) goto L24;
        if (this.i.getClubName().equals(this.j.getBadge().getTitle()) == true) goto L24;
        this.e.c0(String.valueOf(this.j.getAnchor().getIdStr()));
        return;
    L12:
        if (this.j != null) goto L15;
        this.e.c0("");
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (this.n == false) goto L5;
        int r3 = 2131954579;
    L6:
        setStyle(1, r3);
        this.d = true;
        com.bytedance.android.livesdk.chatroom.presenter.j r4 = new com.bytedance.android.livesdk.chatroom.presenter.j();
        this.e = r4;
        ((q46.b) r4).a = this;
        return;
    L5:
        r3 = 2131954584;
        goto L6
    }

    public final void onDismiss(DialogInterface r3) {
        super.onDismiss(r3);     // Catch: Throwable -> L7
        DataCenter r4 = this.g;     // Catch: Throwable -> L7
        if (r4 == null) goto L5;
        r4.put("cmd_show_user_profile", new UserProfileEvent(this.f));     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        ((TextView) r3.findViewById(2131385100)).setOnClickListener(this);
        RecyclerView r5 = r3.findViewById(2131372093);
        this.l = r5;
        r5.setLayoutManager(new GridLayoutManager(getContext(), 3));
        FansClubMedalAdapter r6 = new FansClubMedalAdapter(this.h, this.i, this.m);
        this.l.setAdapter(r6);
        if (this.n == true) goto L6;
        this.k.post(new s7(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131566070, r3, false);
        this.k = r5;
        return r5;
    }
}
