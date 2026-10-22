package com.bytedance.android.live.profile.mysteriousman;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MysteriousManViewHolder {
    public static final /* synthetic */ int m = 0;
    public int a;
    public final View b;
    public final LiveDialogFragment c;
    public final DataCenter d;
    public final IRoom e;
    public final boolean f;
    public final UserProfileEvent g;
    public final IBaseUser h;
    public final String i;
    public final int j;
    public final NewProfileUser k;
    public final Function0<Unit> l;

    public static final class a {
    }

    static {
    }

    public final boolean c() {
        UserProfileEvent r0 = this.g;
        String r1 = r0.mSource;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = r0.mReportTypeForLog;
        if (r3 == null) goto L10;
        r2 = r3;
    L10:
        if (TextUtils.equals(NewProfileInfoViewModel.PAGE_NAME, r1) == false) goto L12;
    L15:
        boolean r4 = true;
    L16:
        String r5 = getType(r1, r2, r4);
        if (r5.hashCode() == (-246517770)) goto L20;
        return false;
    L20:
        if (r5.equals("report_user") == false) goto L23;
        return true;
    L23:
        return false;
    L12:
        if (TextUtils.equals("live_barrage", r1) == true) goto L15;
        r4 = false;
        goto L16
    }

    public final int getType() {
        return this.a;
    }

    public static void a(LiveDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    private final String getType(String r5, String r6, boolean r7) {
        if (r7 == false) goto L6;
        return "report_message";
    L6:
        if (r5 != null) goto L8;
    L9:
        if (r6 != null) goto L11;
    L12:
        if (r6 != null) goto L14;
        return "report_user";
    L14:
        if (StringsKt.contains$default(r6, "data_card_linked_audience", false, 2, null) != true) goto L21;
        return "report_anchor";
    L21:
        return "report_user";
    L11:
        if (StringsKt.contains$default(r6, "anchor", false, 2, null) != true) goto L12;
        return "report_anchor";
    L8:
        if (StringsKt.contains$default(r5, "anchor", false, 2, null) != true) goto L9;
        return "report_anchor";
    }

    public final void b(View r1, int r2, final int r3, final boolean r4) {
        if (r1 == null) goto L11;
        TextView r5 = (TextView) r1.findViewById(r2);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getVisibility() == r3) goto L8;
        r5.setVisibility(r3);
    L8:
        if (r4 == false) goto L13;
        r5.setOnClickListener(x0.a(new MysteriousManViewHolder$configButtonView$$inlined$let$lambda$1(this, r3, r4)));
        return;
    L13:
        return;
    }

    public MysteriousManViewHolder(View r2, LiveDialogFragment r3, DataCenter r4, IRoom r5, boolean r6, UserProfileEvent r7, IBaseUser r8, String r9, NewProfileUser r10, Function0 r12) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "dialogFragment");
        Intrinsics.checkNotNullParameter(r7, "userProfileEvent");
        Intrinsics.checkNotNullParameter(r8, "targetUser");
        Intrinsics.checkNotNullParameter(r12, "dismiss");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = 3;
        this.k = r10;
        this.l = r12;
        this.a = 3;
    }
}
