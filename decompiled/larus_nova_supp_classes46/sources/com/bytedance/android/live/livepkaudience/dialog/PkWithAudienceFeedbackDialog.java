package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.FeedbackApi;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkWithAudienceFeedbackDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkWithAudienceFeedbackDialog extends LiveDialogFragment {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> d;
    public final int e;
    public Room f;
    public boolean g;
    public int h;
    public String i;
    public com.bytedance.android.livesdk.rank.model.g j;
    public gd0.c k;
    public boolean l;

    public static final class a {
        public a() {
        }

        public static PkWithAudienceFeedbackDialog a(int r1, boolean r2, String r3) {
            int r0 = PkWithAudienceFeedbackDialog.m;
            Intrinsics.checkNotNullParameter(r3, "requestPage");
            PkWithAudienceFeedbackDialog r4 = new PkWithAudienceFeedbackDialog();
            r4.f = jc1.k.n(IRoomService.class).getCurrentRoom();
            r4.g = r2;
            r4.h = r1;
            r4.setCancelable(false);
            r4.l = false;
            return r4;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkWithAudienceFeedbackDialog a;

        public b(PkWithAudienceFeedbackDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            if (r7 == null) goto L17;
            com.bytedance.android.livesdk.rank.model.g r8 = (com.bytedance.android.livesdk.rank.model.g) r7.data;
            if (r8 == null) goto L19;
            PkWithAudienceFeedbackDialog r0 = this.a;
            r0.j = r8;
            if (r0.isViewValid() == false) goto L22;
            com.bytedance.android.livesdk.rank.model.g r9 = r0.j;
            if (r9 == null) goto L20;
            ((PkWithAudienceFeedbackView) r0.S90(2131372320)).setVisibility(0);
            ((TextView) r0.S90(2131380667)).setVisibility(8);
            PkWithAudienceFeedbackView r1 = (PkWithAudienceFeedbackView) r0.S90(2131372320);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r9, "issues");
            r1.b = r9;
            ((LinearLayout) r1.a(2131388092)).setVisibility(0);
            List r10 = r9.getIssueCategories();
            if (r10 == null) goto L21;
            Iterator r11 = r10.iterator();
        L15:
            if (r11.hasNext() == false) goto L23;
            TextView r2 = r1.b(((com.bytedance.android.livesdk.rank.model.b) r11.next()).getCategory());
            r2.setOnClickListener(r1.h);
            ViewGroup.LayoutParams r3 = new ViewGroup.LayoutParams(-2, -2);
            r1.a(2131388163).addView(r2, r3);
            goto L15
        L23:
            return;
        L21:
            return;
        L20:
            return;
        L22:
            return;
        L19:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkWithAudienceFeedbackDialog a;

        public c(PkWithAudienceFeedbackDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            PkWithAudienceFeedbackDialog r5 = this.a;
            int r0 = PkWithAudienceFeedbackDialog.m;
            if (r5.isViewValid() == false) goto L7;
            ((PkWithAudienceFeedbackView) r5.S90(2131372320)).setVisibility(8);
            ((TextView) r5.S90(2131380667)).setVisibility(0);
            return;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkWithAudienceFeedbackDialog a;

        public d(PkWithAudienceFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            PkWithAudienceFeedbackDialog r3 = this.a;
            int r0 = PkWithAudienceFeedbackDialog.m;
            r3.W90();
        }
    }

    static {
        new a();
    }

    public final void initData() {
        Room r0 = this.f;
        if (r0 == null) goto L6;
        FeedbackApi r2 = (FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class);
        long r5 = r0.id;
        FeedbackApi.a.a(r2, r5, r5, 8, this.i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        return;
    }

    public PkWithAudienceFeedbackDialog() {
        this.d = new LinkedHashMap();
        this.e = 1000;
        this.i = "";
    }

    public final void W90() {
        Dialog r0 = getDialog();
        Context r1 = getContext();
        if (r0 == null) goto L18;
        if (r1 == null) goto L20;
        Object r2 = r1.getSystemService("input_method");
        if (r2 == null) goto L17;
        InputMethodManager r3 = (InputMethodManager) r2;
        if (r3.isActive() == false) goto L19;
        PkWithAudienceFeedbackView r4 = (PkWithAudienceFeedbackView) S90(2131372320);
        if (r4 == null) goto L13;
        IBinder r5 = r4.getWindowToken();
    L14:
        r3.hideSoftInputFromWindow(r5, 0);
        return;
    L13:
        r5 = null;
        goto L14
    L19:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L20:
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.k = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public static final boolean T90(PkWithAudienceFeedbackDialog r1) {
        String r0 = ((PkWithAudienceFeedbackView) r1.S90(2131372320)).getSelectedSubTag();
        if (r0 == null) goto L10;
        if (StringsKt.trim(r0).toString().length() <= r1.e) goto L7;
        f2.b(2131922732, 0);
        return false;
    L7:
        return true;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final void U90(PkWithAudienceFeedbackDialog r1) {
        if (r1.g == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r2 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r2 == null) goto L11;
        r2.finishInteract("stop_normally");
        return;
    L11:
        return;
    L7:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r3 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r3 == null) goto L13;
        com.bytedance.android.live.livepkaudience.service.d.b.b(r3);
        return;
    }

    public static final void V90(PkWithAudienceFeedbackDialog r9) {
        r9.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        tc0.c r1 = tc0.c.h();
        String r3 = ((PkWithAudienceFeedbackView) r9.S90(2131372320)).getSelectedTag();
        String r2 = ((PkWithAudienceFeedbackView) r9.S90(2131372320)).getSelectedSubTag();
        Room r4 = r9.f;
        long r5 = 0;
        if (r4 == null) goto L5;
        long r7 = r4.id;
    L6:
        r0.put("room_id", Long.valueOf(r7));
        Room r6 = r9.f;
        if (r6 == null) goto L9;
        r5 = r6.id;
    L9:
        r0.put("channel_id", Long.valueOf(r5));
        if (r3 != null) goto L12;
        String r8 = "";
    L13:
        r0.put("issue_category", r8);
        r0.put("issue_content", r2);
        r0.put("scene", 8);
        r0.put("vendor", "byte");
        Room r10 = r9.f;
        if (r10 == null) goto L17;
        String r11 = r10.getOwnerUserIdString();
        if (r11 == null) goto L17;
    L18:
        r0.put("anchor_id", r11);
        r0.put("self_id", jc1.k.n(IUserService.class).user().n());
        boolean r12 = false;
        if (r9.i.length() <= 0) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L24;
        r0.put("third_party_scene", r9.i);
    L24:
        JSONObject r14 = new JSONObject();
        int r15 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        r14.put("link_mode", r15);
        if (r15 != 0) goto L27;
        String r16 = "none";
    L34:
        r14.put("link_type", r16);
        if (r9.g == true) goto L37;
    L40:
        r14.put("link_mic_str", r1.f);
        r0.put("extra_str", r14.toString());
        ((ObservableSubscribeProxy) ((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class)).feedback(r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r9.getActivity()))).subscribe(new z(r9, r3, r2), a0.a);
        return;
    L37:
        if (r1.u != 1) goto L39;
        r12 = true;
    L39:
        r14.put("is_client_mixstream", r12);
        goto L40
    L27:
        if (r15 != 4) goto L29;
        r16 = "video_audience";
        goto L34
    L29:
        if (r15 == 32) goto L31;
        r16 = PbRequest.SwitchType.OTHER;
        goto L34
    L31:
        r16 = "video_talk";
        goto L34
    L21:
        r13 = false;
    L17:
        r11 = "0";
        goto L18
    L12:
        r8 = r3;
        goto L13
    L5:
        r7 = 0;
        goto L6
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

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        r4.setOnCancelListener(new d(this));
        r4.setCanceledOnTouchOutside(true);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setLayout(-1, -1);
        r0.setSoftInputMode(32);
    L5:
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        W90();     // Catch: Throwable -> L5
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
        if (this.g == false) goto L5;
        ((TextView) S90(2131388772)).setText(s1.B(2131922747));
        ((TextView) S90(2131387553)).setText(s1.B(2131922737));
        ((Button) S90(2131389551)).setText(s1.B(2131922738));
    L6:
        S90(2131389652).setOnClickListener(new u(this));
        ((Button) S90(2131389551)).setOnClickListener(new v(this));
        ((Button) S90(2131389494)).setOnClickListener(new w(this));
        ((TextView) S90(2131380667)).setOnClickListener(new x(this));
        ((PkWithAudienceFeedbackView) S90(2131372320)).setListener(new y(this));
        if (this.l == false) goto L23;
        TextView r6 = (TextView) S90(2131388772);
        if (r6 == null) goto L11;
        r6.setText(s1.B(2131922765));
    L11:
        LinearLayout r7 = (LinearLayout) S90(2131372568);
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        Button r1 = (Button) S90(2131389780);
        if (r1 == null) goto L17;
        r1.setVisibility(0);
    L17:
        Button r2 = (Button) S90(2131389780);
        if (r2 == null) goto L20;
        r2.setAlpha(0.34f);
    L20:
        ((PkWithAudienceFeedbackView) S90(2131372320)).setListener(new s(this));
        Button r8 = (Button) S90(2131389780);
        if (r8 == null) goto L23;
        r8.setOnClickListener(new t(this));
    L23:
        initData();
        LinkedHashMap r9 = new LinkedHashMap();
        if (this.g == false) goto L26;
        String r10 = "anchor";
    L27:
        r9.put("user_type", r10);
        int r11 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        el0.j.l(r9, r11);
        el0.j.j(r9, Integer.valueOf(r11));
        el0.j.o(r9);
        r9.put("is_ksong", "0");
        boolean r3 = this.g;
        if (r3 == false) goto L41;
        if (r3 == false) goto L36;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r12 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r12 == null) goto L36;
        com.bytedance.android.live.livepkaudience.base.i r13 = r12.getLinkUserCenter();
        if (r13 == null) goto L36;
        int r14 = r13.b();
    L37:
        if (r14 <= 0) goto L39;
        String r15 = "end_ahead";
    L40:
        r9.put("request_page", r15);
        goto L41
    L39:
        r15 = "normal";
    L36:
        r14 = 0;
    L41:
        el0.j.n(r9, Integer.valueOf(r11));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_chat_feedback_show", r9, new Object[]{am2.x.class, Room.class});
        return;
    L26:
        r10 = "guest";
        goto L27
    L5:
        ((TextView) S90(2131388772)).setText(s1.B(2131922747));
        ((Button) S90(2131389551)).setText(s1.B(2131922741));
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565704, r3, false);
    }
}
