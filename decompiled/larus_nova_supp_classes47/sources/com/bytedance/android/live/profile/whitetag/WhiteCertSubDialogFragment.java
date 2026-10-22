package com.bytedance.android.live.profile.whitetag;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profile/whitetag/WhiteCertSubDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WhiteCertSubDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int j = 0;
    public View d;
    public WhiteCategoryCert.SubCertInfo e;
    public boolean f;
    public DataCenter g;
    public NewProfileUser h;
    public Disposable i;

    public static final class a {
        public static void a(Context r1, WhiteCategoryCert.SubCertInfo r2, boolean r3, DataCenter r4, NewProfileUser r5) {
            FragmentActivity r6 = ContextUtil.contextToFragmentActivity(r1);
            if (r6 == null) goto L13;
            WhiteCertSubDialogFragment r0 = new WhiteCertSubDialogFragment();
            r0.e = r2;
            r0.f = r3;
            r0.g = r4;
            r0.h = r5;
            FragmentManager r7 = r6.getSupportFragmentManager();
            LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "WhiteCertSubDialogFragment", r8);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r0, r8) == true) goto L14;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
        L8:
            r0.show(r7, "WhiteCertSubDialogFragment");
            return;
        L14:
            return;
        }
    }

    static {
    }

    public final void T90() {
        WhiteCategoryCert.SubCertInfo r0 = this.e;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.schema;
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L17;
        ALogger.e("WhiteCertSubDialogFragment", "schema is null or empty");
        return;
    L17:
        if (S90() == false) goto L24;
        IBaseLiveActionHandler r4 = k.f(IBaseLiveActionHandler.class);
        if (r4 == null) goto L38;
        Context r5 = getContext();
        WhiteCategoryCert.SubCertInfo r6 = this.e;
        if (r6 == null) goto L23;
        r1 = r6.schema;
    L23:
        r4.handle(r5, r1);
    L38:
        dismiss();     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L40;
        d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L40:
        return;
    L24:
        DataCenter r8 = this.g;
        if (r8 == null) goto L30;
        WhiteCategoryCert.SubCertInfo r9 = this.e;
        if (r9 == null) goto L29;
        r1 = r9.schema;
    L29:
        r8.put("data_white_cert_schema", r1);
    L30:
        xs2.b.a().post(new HorizontalPlayEvent(1));
        goto L38
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public final boolean S90() {
        Context r0 = getContext();
        if (r0 == null) goto L11;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L11;
        Configuration r2 = r1.getConfiguration();
        if (r2 == null) goto L11;
        if (r2.orientation != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public WhiteCertSubDialogFragment() {
    }

    public final void U90(View r6) {
        TextView r7 = (TextView) r6.findViewById(2131364981);
        if (r7 != null) goto L5;
        return;
    L5:
        WhiteCategoryCert.SubCertInfo r0 = this.e;
        if (r0 == null) goto L12;
        if (r0.certStatus != 1) goto L12;
        r7.setVisibility(8);
        return;
    L12:
        if (this.f == false) goto L17;
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setCornerRadius(UtilityKotlinExtentionsKt.h(2.0f));
        r1.setColor(-1);
        r7.setBackground(r1);
        r7.setText(s1.B(2131921760));
        r7.setTextColor(s1.h(2131107021));
        r7.setTextSize(1, 13.0f);
        Drawable r2 = s1.m(2131253447);
        if (r2 == null) goto L16;
        r2.setBounds(0, 0, UtilityKotlinExtentionsKt.i(14), UtilityKotlinExtentionsKt.i(14));
    L16:
        r7.setCompoundDrawables(r2, null, null, null);
        r7.setCompoundDrawablePadding(UtilityKotlinExtentionsKt.i(2));
        a1.p(r7, -2);
        return;
    L17:
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setCornerRadius(UtilityKotlinExtentionsKt.h(2.0f));
        r3.setColor(ColorProtector.parseColor("#FE2C55"));
        r7.setBackground(r3);
        r7.setText(s1.B(2131921759));
        r7.setTextColor(-1);
        r7.setTextSize(1, 15.0f);
        r7.setOnClickListener(new c(new WhiteCertSubDialogFragment$setButtonForAudience$1(this)));
    }

    public final void V90(View r9) {
        HSImageView r0 = r9.findViewById(2131363810);
        TextView r1 = (TextView) r9.findViewById(2131365438);
        HSImageView r2 = r9.findViewById(2131365437);
        TextView r10 = (TextView) r9.findViewById(2131365439);
        if (S90() == false) goto L5;
        int r3 = s1.y();
    L6:
        int r4 = 0;
        if (r0 == null) goto L9;
        int r5 = a1.f(r0);
    L10:
        int r6 = r3 - r5;
        if (r0 == null) goto L13;
        r4 = a1.g(r0);
    L13:
        int r7 = r6 - r4;
        int r8 = (int) (((double) r7) * 0.21574344023323616d);
        if (r0 == null) goto L16;
        a1.p(r0, r7);
    L16:
        if (r0 == null) goto L18;
        a1.k(r0, r8);
    L18:
        WhiteCategoryCert.SubCertInfo r12 = this.e;
        String r13 = null;
        if (r12 == null) goto L21;
        py.k r14 = r12.background;
    L22:
        ImageLoader.bindImage(r0, r14, r7, r8);
        if (r1 == null) goto L29;
        WhiteCategoryCert.SubCertInfo r15 = this.e;
        if (r15 == null) goto L27;
        String r16 = r15.name;
    L28:
        r1.setText(r16);
        goto L29
    L27:
        r16 = null;
    L29:
        WhiteCategoryCert.SubCertInfo r17 = this.e;
        if (r17 == null) goto L32;
        py.k r18 = r17.smallIcon;
    L33:
        ImageLoader.bindImage(r2, r18);
        if (r10 == null) goto L40;
        WhiteCategoryCert.SubCertInfo r19 = this.e;
        if (r19 == null) goto L38;
        r13 = r19.smallIconDesc;
    L38:
        r10.setText(r13);
        return;
    L40:
        return;
    L32:
        r18 = null;
        goto L33
    L21:
        r14 = null;
        goto L22
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = UtilityKotlinExtentionsKt.i(340);
        goto L6
    }

    public final void W90(View r13) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        if (S90() == false) goto L5;
        float r10 = 8;
        float[] r2 = {UtilityKotlinExtentionsKt.h(r10), UtilityKotlinExtentionsKt.h(r10), UtilityKotlinExtentionsKt.h(r10), UtilityKotlinExtentionsKt.h(r10), 0.0f, 0.0f, 0.0f, 0.0f};
    L6:
        r0.setCornerRadii(r2);
        r0.setColor(-1);
        View r14 = r13.findViewById(2131384813);
        if (r14 == null) goto L10;
        r14.setBackground(r0);
        return;
    L10:
        return;
    L5:
        float r12 = 8;
        r2 = new float[]{UtilityKotlinExtentionsKt.h(r12), UtilityKotlinExtentionsKt.h(r12), UtilityKotlinExtentionsKt.h(r12), UtilityKotlinExtentionsKt.h(r12), UtilityKotlinExtentionsKt.h(r12), UtilityKotlinExtentionsKt.h(r12), UtilityKotlinExtentionsKt.h(r12), UtilityKotlinExtentionsKt.h(r12)};
        goto L6
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L11;
        Window r5 = r4.getWindow();
        if (r5 != null) goto L8;
        return;
    L8:
        if (S90() == true) goto L12;
        r5.setType(WebcastRedirectException.UNKNOWN);
        r5.addFlags(1024);
        r5.setLayout(UtilityKotlinExtentionsKt.i(352), -2);
        r5.setGravity(8388693);
        return;
    L12:
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        ALogger.e("WhiteCertSubDialogFragment", "onConfigurationChanged");
        if (S90() == false) goto L30;
        View r4 = this.d;
        if (r4 == null) goto L14;
        W90(r4);
        V90(r4);
        TextView r0 = (TextView) r4.findViewById(2131365436);
        if (r0 == null) goto L13;
        WhiteCategoryCert.SubCertInfo r1 = this.e;
        if (r1 == null) goto L11;
        String r2 = r1.desc;
    L12:
        r0.setText(r2);
        goto L13
    L11:
        r2 = null;
    L13:
        U90(r4);
    L14:
        Dialog r5 = getDialog();
        if (r5 == null) goto L31;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L34;
        r6.setLayout(-1, -1);
        r6.setGravity(80);
        View r7 = this.d;
        if (r7 == null) goto L24;
        View r8 = r7.findViewById(2131377114);
        if (r8 == null) goto L24;
        a1.p(r8, -1);
    L24:
        View r9 = this.d;
        if (r9 == null) goto L32;
        View r10 = r9.findViewById(2131384813);
        if (r10 == null) goto L33;
        a1.l(r10, 0);
        a1.n(r10, 0);
        a1.p(r10, -1);
        return;
    L33:
        return;
    L32:
        return;
    L34:
        return;
    L31:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (S90() == false) goto L5;
        int r3 = 2131954579;
    L6:
        setStyle(1, r3);
        return;
    L5:
        r3 = 2131954852;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
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

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        W90(r4);
        V90(r4);
        TextView r6 = (TextView) r4.findViewById(2131365436);
        String r0 = null;
        if (r6 == null) goto L9;
        WhiteCategoryCert.SubCertInfo r1 = this.e;
        if (r1 == null) goto L7;
        String r2 = r1.desc;
    L8:
        r6.setText(r2);
        goto L9
    L7:
        r2 = null;
    L9:
        U90(r4);
        LinkedHashMap r7 = new LinkedHashMap();
        NewProfileUser r8 = this.h;
        if (r8 == null) goto L14;
        BaseProfileInfo r9 = r8.baseProfileInfo;
        if (r9 == null) goto L14;
        r0 = r9.getIdStr();
    L14:
        r7.put("to_user_id", String.valueOf(r0));
        WhiteCategoryCert.SubCertInfo r10 = this.e;
        String r3 = DataType.FALSE;
        if (r10 != null) goto L17;
    L19:
        String r12 = DataType.FALSE;
    L20:
        r7.put("tag_show_user_verify_status", r12);
        IMiddlewareUserService r13 = k.f(IMiddlewareUserService.class);
        if (r13 == null) goto L27;
        e r14 = r13.user();
        if (r14 == null) goto L27;
        String r15 = r14.n();
        if (r15 == null) goto L27;
        r3 = r15;
    L27:
        r7.put("user_id", r3);
        j0.l().sendLog("livesdk_profile_card_vertical_tag_verify_encouragement_show", r7, new Object[]{IRoom.class});
        return;
    L17:
        if (r10.certStatus != 1) goto L19;
        r12 = DataType.TRUE;
        goto L20
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565711, r3, false);
        this.d = r5;
        return r5;
    }
}
