package com.bytedance.android.live.room.share.ui;

import am2.x;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.sq0;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import fa1.e;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/share/ui/ScreenShotAutoObserveLandscapeDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenShotAutoObserveLandscapeDialog extends LiveDialogFragment {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public String e;
    public Disposable f;
    public MatchShareParam g;
    public ea1.a h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ScreenShotAutoObserveLandscapeDialog a;

        public b(ScreenShotAutoObserveLandscapeDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ScreenShotAutoObserveLandscapeDialog r3 = this.a;
            r3.i = true;
            r3.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            ea1.a r4 = this.a.h;
            if (r4 == null) goto L15;
            r4.onDismiss();
            return;
        L15:
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L9;
            d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ScreenShotAutoObserveLandscapeDialog a;

        public c(ScreenShotAutoObserveLandscapeDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            FragmentActivity r3 = this.a.getActivity();
            if (r3 == null) goto L6;
            r3.isFinishing();
            return;
        }
    }

    static {
    }

    public ScreenShotAutoObserveLandscapeDialog() {
        this.d = new LinkedHashMap();
        this.e = "";
        setNoTitleAndCancelOutside(true);
        setVertical(false);
    }

    public final View U90() {
        return LayoutInflater.from(getContext()).inflate(2131566561, null);
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

    public final void T90(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        Disposable r1 = this.f;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        super.onDismiss(r3);
        FragmentManager r4 = getFragmentManager();     // Catch: Exception -> L14 IllegalStateException -> L16
        if (r4 == null) goto L19;
        FragmentTransaction r5 = r4.beginTransaction();     // Catch: Exception -> L14 IllegalStateException -> L16
        if (r5 == null) goto L19;
        FragmentTransaction r6 = r5.remove(this);     // Catch: Exception -> L14 IllegalStateException -> L16
        if (r6 == null) goto L19;
        r6.commit();     // Catch: Exception -> L14 IllegalStateException -> L16
    L19:
        if (this.i == true) goto L26;
        ea1.a r7 = this.h;
        if (r7 == null) goto L27;
        r7.onDismiss();
        return;
    L27:
        return;
    L26:
        return;
    L16:
        e = move-exception;
        ALogger.e("ScreenShotAutoObserveLandscapeDialog", e);
    L14:
        e = move-exception;
        ALogger.e("ScreenShotAutoObserveLandscapeDialog", e);
        goto L19
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(5);
        r5.setLayout(UtilityKotlinExtentionsKt.i(375), s1.w());
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.addFlags(2);
        r5.setDimAmount(0.0f);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (((Boolean) sq0.a.getValue()).booleanValue() == false) goto L5;
        setStyle(1, 2131954702);
        return;
    L5:
        setStyle(1, 2131954701);
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

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LinearLayout r9 = (LinearLayout) S90(2131389634);
        if (r9 == null) goto L5;
        r9.setLayoutParams(new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(375), s1.w()));
    L5:
        LinearLayout r10 = (LinearLayout) S90(2131385195);
        if (r10 == null) goto L40;
        r10.removeAllViews();
        ArrayList r12 = new ArrayList();
        View r0 = U90();
        V90(r0, 2131251495, "私信好友");
        r0.setOnClickListener(new fa1.c(this));
        Intrinsics.checkNotNullParameter(r12, "list");
        r12.add(r0);
        View r2 = null;
        if (puc.a.isInstalledApp(getContext(), "com.tencent.mm") == true) goto L10;
        View r1 = null;
    L11:
        Intrinsics.checkNotNullParameter(r12, "list");
        if (r1 == null) goto L15;
        r12.add(r1);
    L15:
        View r3 = U90();
        MatchShareParam r4 = this.g;
        if (r4 == null) goto L18;
        IRoom r5 = r4.f;
    L20:
        if ((r5 instanceof Room) == true) goto L22;
        r5 = null;
    L22:
        Room r6 = (Room) r5;
        if (r6 == null) goto L29;
        User r13 = r6.getOwner();
        if (r13 == null) goto L29;
        V90(r3, 2131251505, "举报");
        r3.setOnClickListener(new fa1.d(this, r6, r13));
        r2 = r3;
    L29:
        Intrinsics.checkNotNullParameter(r12, "list");
        if (r2 == null) goto L33;
        r12.add(r2);
    L33:
        Iterator r14 = r12.iterator();
    L35:
        if (r14.hasNext() == false) goto L40;
        View r15 = (View) r14.next();
        int r16 = UtilityKotlinExtentionsKt.i(18);
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        if (r15 == null) goto L35;
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams((int) UIUtils.dip2Px(getContext(), 64.0f), -2);
        r17.leftMargin = r16;
        r10.addView(r15, r17);
        goto L35
    L18:
        r5 = null;
        goto L20
    L10:
        r1 = U90();
        V90(r1, 2131251510, "分享微信");
        r1.setOnClickListener(new e(this));
    L40:
        this.f = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        ImageView r18 = (ImageView) S90(2131376031);
        if (r18 == null) goto L43;
        r18.setOnClickListener(new b(this));
    L43:
        g r19 = u.l();
        HashMap r20 = new HashMap();
        r20.put("request_page", "live_screenshot");
        r19.sendLog("livesdk_screenshot_pannel_show", r20, new Object[]{Room.class, x.class});
    }

    public static void V90(View r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r3, "title");
        ImageView r0 = (ImageView) r1.findViewById(2131385197);
        if (r0 == null) goto L5;
        r0.setBackgroundResource(r2);
    L5:
        TextView r4 = (TextView) r1.findViewById(2131385200);
        if (r4 == null) goto L9;
        r4.setText(r3);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (r4 == null) goto L11;
        dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L11;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L11:
        return r2.inflate(2131566560, r3, false);
    }
}
