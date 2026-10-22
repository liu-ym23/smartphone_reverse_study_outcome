package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

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
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/TalkRoomFeedbackDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkRoomFeedbackDialog extends LiveDialogFragment {
    public static final /* synthetic */ int r = 0;
    public Map<Integer, View> d;
    public final int e;
    public IRoom f;
    public boolean g;
    public int h;
    public String i;
    public com.bytedance.android.livesdk.rank.model.g j;
    public String k;
    public gd0.c l;
    public boolean m;
    public final boolean n;
    public n o;
    public Integer p;
    public Object q;

    public static final class a {
        public a() {
        }

        public static TalkRoomFeedbackDialog a(int r3, boolean r4, String r5, com.bytedance.android.live.liveinteract.service.n r6, boolean r7, n r8, Integer r9, zi0.d.a r10, int r11) {
            int r0 = TalkRoomFeedbackDialog.r;
            if ((r11 & 16) == 0) goto L6;
            r6 = null;
        L6:
            if ((r11 & 64) == 0) goto L9;
            r7 = false;
        L9:
            if ((r11 & 128) == 0) goto L12;
            r8 = null;
        L12:
            if ((r11 & 256) == 0) goto L15;
            r9 = null;
        L15:
            if ((r11 & 512) == 0) goto L17;
            r10 = null;
        L17:
            Intrinsics.checkNotNullParameter(r5, "requestPage");
            TalkRoomFeedbackDialog r12 = new TalkRoomFeedbackDialog();
            r12.f = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            r12.g = r4;
            r12.h = r3;
            r12.k = r5;
            r12.setCancelable(false);
            if (r6 == null) goto L20;
            r12.l = r6;
        L20:
            r12.m = r7;
            r12.o = r8;
            r12.p = r9;
            r12.q = r10;
            return r12;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TalkRoomFeedbackDialog a;

        public b(TalkRoomFeedbackDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            if (r7 == null) goto L24;
            com.bytedance.android.livesdk.rank.model.g r8 = (com.bytedance.android.livesdk.rank.model.g) r7.data;
            if (r8 == null) goto L26;
            TalkRoomFeedbackDialog r0 = this.a;
            r0.j = r8;
            if (r0.isViewValid() == false) goto L29;
            com.bytedance.android.livesdk.rank.model.g r9 = r0.j;
            if (r9 != null) goto L12;
            return;
        L12:
            if (r0.m == false) goto L14;
        L17:
            ((TalkRoomFeedbackView) r0.S90(2131372320)).setVisibility(0);
        L18:
            ((TextView) r0.S90(2131380667)).setVisibility(8);
            TalkRoomFeedbackView r1 = (TalkRoomFeedbackView) r0.S90(2131372320);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r9, "issues");
            r1.b = r9;
            ((LinearLayout) r1.a(2131388092)).setVisibility(0);
            List r10 = r9.getIssueCategories();
            if (r10 == null) goto L28;
            Iterator r11 = r10.iterator();
        L22:
            if (r11.hasNext() == false) goto L30;
            TextView r2 = r1.b(((com.bytedance.android.livesdk.rank.model.b) r11.next()).getCategory());
            r2.setOnClickListener(r1.i);
            ViewGroup.LayoutParams r3 = new ViewGroup.LayoutParams(-2, -2);
            r1.a(2131388163).addView(r2, r3);
            goto L22
        L30:
            return;
        L28:
            return;
        L14:
            if (r0.n == false) goto L17;
            ((TalkRoomFeedbackView) r0.S90(2131372320)).setVisibility(8);
            goto L18
        L29:
            return;
        L26:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TalkRoomFeedbackDialog a;

        public c(TalkRoomFeedbackDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            TalkRoomFeedbackDialog r5 = this.a;
            int r0 = TalkRoomFeedbackDialog.r;
            if (r5.isViewValid() == false) goto L7;
            ((TalkRoomFeedbackView) r5.S90(2131372320)).setVisibility(8);
            ((TextView) r5.S90(2131380667)).setVisibility(0);
            return;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ TalkRoomFeedbackDialog a;

        public d(TalkRoomFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            TalkRoomFeedbackDialog r3 = this.a;
            int r0 = TalkRoomFeedbackDialog.r;
            r3.Z90();
        }
    }

    static {
        new a();
    }

    public final int Y90() {
        if (this.g == true) goto L5;
        return 0;
    L5:
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r0, 32) == false) goto L14;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 == null) goto L21;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = r1.getLinkUserInfoCenter();
        if (r2 != null) goto L12;
        return 0;
    L12:
        return r2.b();
    L21:
        return 0;
    L14:
        if (gd0.v.a(r0, 8) == false) goto L23;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r3 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r3 == null) goto L24;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r4 = r3.getLinkUserInfoCenter();
        if (r4 != null) goto L20;
        return 0;
    L20:
        return r4.b();
    L24:
        return 0;
    L23:
        return 0;
    }

    public final void initData() {
        IRoom r0 = this.f;
        if (r0 == null) goto L6;
        ((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class)).getFeedbackType(r0.getId(), r0.getId(), this.h, this.i, this.p).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        return;
    }

    public TalkRoomFeedbackDialog() {
        this.d = new LinkedHashMap();
        this.e = 1000;
        this.i = "";
        this.k = "";
        this.n = ((Boolean) vm2.h.p6.getValue(null, vm2.h.a[378(0x17a, float:5.3E-43)])).booleanValue();
    }

    public final void Z90() {
        Dialog r0 = getDialog();
        Context r1 = getContext();
        if (r0 == null) goto L18;
        if (r1 == null) goto L20;
        Object r2 = r1.getSystemService("input_method");
        if (r2 == null) goto L17;
        InputMethodManager r3 = (InputMethodManager) r2;
        if (r3.isActive() == false) goto L19;
        TalkRoomFeedbackView r4 = (TalkRoomFeedbackView) S90(2131372320);
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

    public final void aa0() {
        TextView r0 = (TextView) S90(2131387553);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L5;
    L8:
        String r1 = s1.B(2131922737);
    L9:
        r0.setText(r1);
        TextView r2 = (TextView) S90(2131388142);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L12;
    L15:
        String r3 = s1.B(2131922745);
    L16:
        r2.setText(r3);
        return;
    L12:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L15;
        r3 = s1.B(2131922744);
        goto L16
    L5:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L8;
        r1 = s1.B(2131922736);
        goto L9
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.l = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment*/.onStart();
        Integer r0 = this.p;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 16) goto L9;
        g2 r1 = zi0.d.b;
        Object r2 = this.q;
        LinkedHashMap r3 = new LinkedHashMap();
        zi0.d.a(r3, r2);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_grouppk_breakoff_quest_show", r3, new Object[]{am2.x.class, IRoom.class});
        return;
    }

    public static final boolean T90(TalkRoomFeedbackDialog r1) {
        String r0 = ((TalkRoomFeedbackView) r1.S90(2131372320)).getSelectedSubTag();
        if (r0 == null) goto L10;
        if (StringsKt.trim(r0).toString().length() <= r1.e) goto L7;
        f2.b(2131922732, 0);
        return false;
    L7:
        return true;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final void X90(TalkRoomFeedbackDialog r10) {
        r10.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        tc0.c r1 = tc0.c.h();
        String r3 = ((TalkRoomFeedbackView) r10.S90(2131372320)).getSelectedTag();
        String r2 = ((TalkRoomFeedbackView) r10.S90(2131372320)).getSelectedSubTag();
        boolean r5 = false;
        if (r10.n == true) goto L5;
    L7:
        IRoom r4 = r10.f;
        long r6 = 0;
        if (r4 == null) goto L10;
        long r8 = r4.getId();
    L11:
        r0.put("room_id", Long.valueOf(r8));
        IRoom r7 = r10.f;
        if (r7 == null) goto L14;
        r6 = r7.getId();
    L14:
        r0.put("channel_id", Long.valueOf(r6));
        String r9 = "";
        if (r3 != null) goto L17;
        String r11 = "";
    L18:
        r0.put("issue_category", r11);
        r0.put("issue_content", r2);
        r0.put("scene", Integer.valueOf(r10.h));
        r0.put("vendor", 4);
        IRoom r12 = r10.f;
        if (r12 == null) goto L24;
        String r13 = r12.getOwnerUserIdString();
        if (r13 == null) goto L24;
        r9 = r13;
    L24:
        r0.put("anchor_id", r9);
        r0.put("self_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        Integer r14 = r10.p;
        if (r14 == null) goto L28;
        r0.put("play_mode", String.valueOf(r14.intValue()));
    L28:
        if (r10.i.length() <= 0) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == false) goto L33;
        r0.put("third_party_scene", r10.i);
    L33:
        JSONObject r16 = new JSONObject();
        int r17 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        r16.put("link_mode", r17);
        if (r17 != 0) goto L36;
        String r18 = "none";
    L46:
        r16.put("link_type", r18);
        if (r10.g == true) goto L49;
    L52:
        r16.put("link_mic_str", r1.f);
        r0.put("extra_str", r16.toString());
        ((ObservableSubscribeProxy) ((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class)).feedback(r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r10.getActivity()))).subscribe(new n0(r10, r3, r2), o0.a);
        return;
    L49:
        if (r1.u != 1) goto L51;
        r5 = true;
    L51:
        r16.put("is_client_mixstream", r5);
        goto L52
    L36:
        if (r17 != 2) goto L38;
        r18 = "video_audience";
        goto L46
    L38:
        if (r17 != 8) goto L40;
        r18 = "audio_talk";
        goto L46
    L40:
        if (r17 == 32) goto L42;
        r18 = PbRequest.SwitchType.OTHER;
        goto L46
    L42:
        r18 = "video_talk";
        goto L46
    L30:
        r15 = false;
        goto L31
    L17:
        r11 = r3;
        goto L18
    L10:
        r8 = 0;
        goto L11
    L5:
        if (mz.c.b(r2) == false) goto L7;
        f2.b(2131918393, 0);
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

    @Deprecated(message = "Deprecated in Java")
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
        c1.b(r5, 0, 14);
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
        Z90();     // Catch: Throwable -> L5
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

    public static final void U90(TalkRoomFeedbackDialog r7, boolean r8) {
        String r0 = r7.k;
        int r1 = r0.hashCode();
        if (r1 == (-1383228885)) goto L11;
        if (r1 == 3526149) goto L8;
    L13:
        int r2 = 200;
    L14:
        int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r3, 32) == false) goto L25;
        if (r7.g == false) goto L21;
        rj0.k.m2.getClass();
        rj0.k r9 = rj0.k.a.a();
        if (r9 == null) goto L35;
        rj0.k.b.a(r9);
        return;
    L35:
        return;
    L21:
        rj0.l.n2.getClass();
        rj0.l r10 = rj0.l.a.a();
        if (r10 == null) goto L37;
        rj0.l.b.d(r10, r2, !r8, false, 12);
        return;
    L37:
        return;
    L25:
        if (gd0.v.a(r3, 8) == true) goto L27;
        return;
    L27:
        if (r7.g == false) goto L31;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r11 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r11 == null) goto L40;
        r11.finishAudioTalk(r7.k);
        return;
    L40:
        return;
    L31:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
        if (r4 == null) goto L42;
        IVoiceChatGuestService.b.b(r4, r2, false, !r8, false, 24);
        return;
    L42:
        return;
    L8:
        if (r0.equals("seat") == false) goto L13;
        r2 = 201;
        goto L14
    L11:
        if (r0.equals("bottom") == false) goto L13;
        r2 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
        goto L14
    }

    public static final void V90(TalkRoomFeedbackDialog r3, String r4) {
        Integer r0 = r3.p;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 16) goto L9;
        g2 r1 = zi0.d.b;
        Object r5 = r3.q;
        Intrinsics.checkNotNullParameter(r4, "clickType");
        LinkedHashMap r2 = new LinkedHashMap();
        zi0.d.a(r2, r5);
        r2.put("click_type", r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_grouppk_breakoff_quest_click", r2, new Object[]{am2.x.class, IRoom.class});
        return;
    }

    public static final void W90(TalkRoomFeedbackDialog r3, String r4) {
        Integer r0 = r3.p;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 16) goto L9;
        g2 r1 = zi0.d.b;
        Object r5 = r3.q;
        Intrinsics.checkNotNullParameter(r4, "overType");
        LinkedHashMap r2 = new LinkedHashMap();
        zi0.d.a(r2, r5);
        r2.put("over_type", r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_grouppk_breakoff_quest_over", r2, new Object[]{am2.x.class, IRoom.class});
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        if (this.g == false) goto L31;
        TextView r12 = (TextView) S90(2131388772);
        if (Intrinsics.areEqual(this.k, "scene_panel") == false) goto L7;
    L10:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L18;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 29) goto L16;
        String r1 = s1.B(2131922747);
    L24:
        r12.setText(r1);
        aa0();
        if (je0.d.O() == true) goto L27;
    L29:
        ((Button) S90(2131389551)).setText(s1.B(2131922738));
    L40:
        if (this.h != 10) goto L43;
        ((TalkRoomFeedbackView) S90(2131372320)).setTagTitleText(s1.B(2131922528));
    L43:
        S90(2131389652).setOnClickListener(new i0(this));
        ((Button) S90(2131389551)).setOnClickListener(new j0(this));
        ((Button) S90(2131389494)).setOnClickListener(new k0(this));
        ((TextView) S90(2131380667)).setOnClickListener(new l0(this));
        ((TalkRoomFeedbackView) S90(2131372320)).setListener(new m0(this));
        if (this.m == false) goto L89;
        if (this.o == null) goto L73;
        TextView r13 = (TextView) S90(2131388772);
        if (r13 == null) goto L56;
        n r3 = this.o;
        if (r3 == null) goto L54;
        String r4 = r3.a;
        if (r4 == null) goto L54;
    L55:
        r13.setText(r4);
    L54:
        r4 = s1.B(2131922765);
    L56:
        n r14 = this.o;
        if (r14 == null) goto L66;
        String r15 = r14.b;
        if (r15 == null) goto L66;
        TextView r2 = (TextView) S90(2131387553);
        if (r2 == null) goto L63;
        r2.setText(r15);
    L63:
        TextView r16 = (TextView) S90(2131387553);
        if (r16 == null) goto L66;
        r16.setTextColor(ColorProtector.parseColor("#A3A3A3"));
    L66:
        n r17 = this.o;
        if (r17 == null) goto L76;
        String r18 = r17.c;
        if (r18 == null) goto L76;
        TalkRoomFeedbackView r5 = (TalkRoomFeedbackView) S90(2131372320);
        if (r5 == null) goto L76;
        r5.setTagTitleText(r18);
    L76:
        LinearLayout r19 = (LinearLayout) S90(2131372568);
        if (r19 == null) goto L79;
        r19.setVisibility(8);
    L79:
        Button r6 = (Button) S90(2131389780);
        if (r6 == null) goto L82;
        r6.setVisibility(0);
    L82:
        Button r8 = (Button) S90(2131389780);
        if (r8 == null) goto L85;
        r8.setAlpha(0.34f);
    L85:
        ((TalkRoomFeedbackView) S90(2131372320)).setListener(new g0(this));
        Button r110 = (Button) S90(2131389780);
        if (r110 == null) goto L91;
        r110.setOnClickListener(new h0(this));
    L91:
        initData();
        LinkedHashMap r111 = new LinkedHashMap();
        if (this.g == false) goto L94;
        String r9 = "anchor";
    L95:
        r111.put("user_type", r9);
        int r20 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.I0(r111, r20);
        TalkRoomLogUtils.B0(r111, Integer.valueOf(r20), null, 4);
        TalkRoomLogUtils.Q0(r111);
        r111.put("is_ksong", "0");
        if (this.g == true) goto L98;
    L102:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_chat_feedback_show", r111, new Object[]{am2.x.class, IRoom.class});
        return;
    L98:
        if (Y90() <= 0) goto L100;
        String r21 = "end_ahead";
    L101:
        r111.put("request_page", r21);
        goto L102
    L100:
        r21 = "normal";
        goto L101
    L94:
        r9 = "guest";
        goto L95
    L73:
        TextView r112 = (TextView) S90(2131388772);
        if (r112 == null) goto L76;
        r112.setText(s1.B(2131922765));
        goto L76
    L89:
        if (this.n == false) goto L91;
        ((TextView) S90(2131390610)).setVisibility(0);
        ((TextView) S90(2131390610)).setOnClickListener(new e0(this));
        ((TalkRoomFeedbackView) S90(2131372320)).setSubitemSelectCountListener(new f0(this));
        goto L91
    L27:
        if (je0.d.F() == false) goto L29;
        ((TextView) S90(2131387553)).setText(s1.B(2131922730));
        ((TextView) S90(2131387553)).setTextColor(ColorProtector.parseColor("#FE2C55"));
        goto L29
    L16:
        r1 = s1.B(2131920103);
        goto L24
    L18:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L20;
    L23:
        r1 = s1.B(2131922747);
        goto L24
    L20:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L23;
        r1 = s1.B(2131922746);
        goto L24
    L7:
        if (Intrinsics.areEqual(this.k, "link_panel") == true) goto L10;
        r7 = false;
        goto L12
    L31:
        if (this.h == 10) goto L37;
        TextView r113 = (TextView) S90(2131388772);
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 29) goto L35;
        String r22 = s1.B(2131922748);
    L36:
        r113.setText(r22);
    L38:
        aa0();
        ((Button) S90(2131389551)).setText(s1.B(2131922741));
        goto L40
    L35:
        r22 = s1.B(2131922746);
        goto L36
    L37:
        ((TextView) S90(2131388772)).setText(s1.B(2131922529));
        ((TextView) S90(2131387553)).setText(s1.B(2131922527));
        goto L38
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565781, r3, false);
    }
}
