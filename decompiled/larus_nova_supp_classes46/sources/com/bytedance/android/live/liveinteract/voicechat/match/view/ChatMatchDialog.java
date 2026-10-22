package com.bytedance.android.live.liveinteract.voicechat.match.view;

import am2.x;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.plantform.model.ListUserTag;
import com.bytedance.android.live.liveinteract.voicechat.match.logger.ChatMatchFailReason;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.android.livesdk.chatroom.model.c1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.i6;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.desc.CountDownWithDescTextView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/match/view/ChatMatchDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatMatchDialog extends LiveDialogFragment {
    public static final /* synthetic */ int V = 0;
    public HSImageView A;
    public ImageView B;
    public CountDownWithDescTextView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public FrameLayout G;
    public TextView H;
    public HSImageView I;
    public HSImageView J;
    public LinearLayout K;
    public View L;
    public TextView M;
    public CountDownWithDescTextView N;
    public LinearLayout O;
    public TextView P;
    public HSImageView Q;
    public TextView R;
    public TextView S;
    public RecyclerView T;
    public final b U;
    public Map<Integer, View> d;
    public final int e;
    public final int f;
    public IRoom g;
    public ChatMatchViewModel h;
    public DataCenter i;
    public a5 j;
    public boolean k;
    public boolean l;
    public gk0.a m;
    public ValueAnimator n;
    public final ik0.g o;
    public boolean p;
    public final String q;
    public final String r;
    public ek0.c s;
    public boolean t;
    public LinearLayout u;
    public View v;
    public ImageView w;
    public TextView x;
    public TextView y;
    public ConstraintLayout z;

    public static final class a {
        public static ChatMatchDialog a(IRoom r1, DataCenter r2, a5 r3, boolean r4, ChatMatchViewModel r5, Boolean r6) {
            ChatMatchDialog r0 = new ChatMatchDialog();
            r0.g = r1;
            r0.i = r2;
            r0.j = r3;
            r0.k = r4;
            if (r5 != null) goto L5;
            String r7 = ChatMatchWidget.o;
            r5 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        L5:
            r0.h = r5;
            r0.l = Intrinsics.areEqual(r6, Boolean.TRUE);
            return r0;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ChatMatchDialog a;

        public b(ChatMatchDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.intValue() != 2) goto L23;
            ChatMatchViewModel r0 = this.a.h;
            if (r0 == null) goto L11;
            MutableLiveData<Boolean> r1 = r0.getMatchingState();
            if (r1 == null) goto L11;
            Boolean r2 = (Boolean) r1.getValue();
        L13:
            if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L19;
            ChatMatchDialog r3 = this.a;
            ChatMatchViewModel r4 = r3.h;
            if (r4 == null) goto L19;
            gk0.a r7 = r3.m;
            if (r7 == null) goto L19;
            gk0.a.C0214a r8 = gk0.a.b;
            Integer r9 = (Integer) r4.getMatchType().getValue();
            Boolean r10 = (Boolean) r4.getRematch().getValue();
            r8.getClass();
            r7.b(gk0.a.C0214a.b(r9, r10).getValue(), ChatMatchFailReason.OCCUPATION.getValue());
        L19:
            ChatMatchViewModel r11 = this.a.h;
            if (r11 == null) goto L22;
            r11.release();
        L22:
            this.a.U90();
        L11:
            r2 = null;
        L23:
            ChatMatchDialog r12 = this.a;
            int r13 = r6.intValue();
            int r14 = ChatMatchDialog.V;
            r12.Z90(r13);
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ ChatMatchDialog a;

        public d(ChatMatchDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            ChatMatchDialog r4 = this.a;
            int r0 = ChatMatchDialog.V;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L18;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L9;
            View r6 = r5.getCurrentFocus();
        L10:
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L15;
            return;
        L15:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L9:
            r6 = null;
            goto L10
        L21:
            return;
        }
    }

    static {
    }

    public ChatMatchDialog() {
        this.d = new LinkedHashMap();
        this.e = 1;
        this.f = 2;
        this.o = new ik0.g();
        this.q = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/fast_match_icon_style_v2.webp";
        this.r = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_multi_link_fast_match_avatar_animation.webp";
        this.U = new b(this);
    }

    public final void U90() {
        if (isShowing() == false) goto L13;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L14;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final void W90() {
        if (vm2.d.e().e() == false) goto L7;
        AbstractDraweeController r0 = Fresco.newDraweeControllerBuilder().setUri(this.q).setAutoPlayAnimations(true).build();
        HSImageView r1 = this.A;
        if (r1 == null) goto L11;
        r1.setController(r0);
        return;
    L11:
        return;
    L7:
        HSImageView r2 = this.A;
        if (r2 == null) goto L13;
        r2.setImageResource(2131251987);
        return;
    }

    public final void X90() {
        if (hd0.c.f().j() == false) goto L5;
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
    L6:
        Z90(r0.intValue());
        final ChatMatchViewModel r1 = this.h;
        if (r1 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual((Boolean) r1.getMatchingState().getValue(), Boolean.TRUE) == false) goto L12;
        return;
    L12:
        if (getContext() == null) goto L14;
        int r2 = ik0.g.b;
        Y90(0);
    L16:
        if (r1.getWaitingCount().getValue() == null) goto L20;
        View r3 = getView();
        if (r3 == null) goto L23;
        r3.post(new ChatMatchDialog$startMatchForShake$$inlined$let$lambda$1(r1, this));
        return;
    L23:
        return;
    L20:
        ChatMatchViewModel.startMatch$default(r1, this.g, false, 1, 2, null);
        return;
    L14:
        this.p = true;
        goto L16
    L5:
        r0 = -1;
        goto L6
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ValueAnimator r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        hd0.c.f().e(this.U);
        ik0.g r1 = this.o;
        Vibrator r2 = r1.a;
        if (r2 == null) goto L11;
        r2.cancel();
        r1.a = null;
    L11:
        ChatMatchViewModel r3 = this.h;
        if (r3 == null) goto L15;
        r3.release();
        return;
    L15:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        r0.removeAllListeners();
        r0.removeAllUpdateListeners();
        r0.cancel();
        goto L7
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

    public final void Y90(int r8) {
        int r1 = 1;
        if (vm2.h.b0().c() == 1) goto L5;
        return;
    L5:
        ik0.g r0 = this.o;
        Context r2 = getContext();
        r0.getClass();
        int r4 = 255;
        if (r8 != 2) goto L8;
        long r5 = 400;
        int r9 = 255;
    L11:
        if (r2 != null) goto L14;
        return;
    L14:
        if (r0.a != null) goto L20;
        Object r3 = r2.getSystemService("vibrator");
        if (r3 == null) goto L19;
        r0.a = (Vibrator) r3;
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L20:
        Vibrator r6 = r0.a;
        if (r6 == null) goto L25;
        r6.cancel();
    L25:
        if (Build.VERSION.SDK_INT >= 26) goto L29;
        Vibrator r10 = r0.a;
        if (r10 == null) goto L42;
        r10.vibrate(r5);
        return;
    L42:
        return;
    L29:
        if (r9 <= 0) goto L32;
        r1 = r9;
    L32:
        if (r1 > 255) goto L36;
        r4 = r1;
    L36:
        if (r5 > 0) goto L38;
        r5 = 1;
    L38:
        VibrationEffect r11 = VibrationEffect.createOneShot(r5, r4);
        Vibrator r7 = r0.a;
        if (r7 == null) goto L44;
        r7.vibrate(r11);
        return;
    L44:
        return;
    L8:
        if (r8 != 1) goto L10;
        r9 = 120;
        r5 = 250;
        goto L11
    L10:
        r9 = 10;
        r5 = 110;
        goto L11
    }

    public final void Z90(int r4) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.k == false) goto L11;
        ca0(8);
        ConstraintLayout r5 = this.z;
        if (r5 == null) goto L38;
        r5.setBackgroundResource(0);
        return;
    L38:
        return;
    L11:
        if (r4 != 0) goto L22;
        ca0(0);
        TextView r6 = this.y;
        if (r6 == null) goto L15;
        r6.setText(s1.B(2131917504));
    L15:
        TextView r7 = this.x;
        if (r7 == null) goto L18;
        r7.setText(s1.B(2131917503));
    L18:
        ImageView r8 = this.w;
        if (r8 == null) goto L39;
        r8.setVisibility(8);
        return;
    L39:
        return;
    L22:
        if (r4 != 1) goto L34;
        ca0(0);
        TextView r9 = this.y;
        if (r9 == null) goto L26;
        r9.setText(s1.B(2131917484));
    L26:
        a5 r10 = this.j;
        if (r10 == null) goto L31;
        TextView r0 = this.x;
        if (r0 == null) goto L31;
        r0.setText(sb2.a.h(r10, "", false));
    L31:
        ImageView r11 = this.w;
        if (r11 == null) goto L41;
        r11.setVisibility(0);
        return;
    L41:
        return;
    L34:
        ca0(8);
        ConstraintLayout r12 = this.z;
        if (r12 == null) goto L43;
        r12.setBackgroundResource(0);
        return;
    }

    public final void aa0(b1 r15) {
        HSImageView r0 = this.I;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        HSImageView r1 = this.J;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        if (r15.getMatchedRoomId() > 0) goto L11;
        return;
    L11:
        if (r15.getMatchedUser() == null) goto L254;
        ImageUtil.loadRoundImage(this.I, r15.getMatchedUser().getAvatarThumbKt());
        HSImageView r2 = this.J;
        if (r2 == null) goto L15;
        r2.setVisibility(0);
    L15:
        int r3 = r15.getMatchedUser().getGender();
        if (r3 != this.e) goto L21;
        HSImageView r4 = this.J;
        if (r4 == null) goto L28;
        r4.setImageResource(2131250688);
    L28:
        LiveMode r5 = null;
        String r8 = "";
        if (((Boolean) vm2.h.R5.getValue(null, vm2.h.a[354(0x162, float:4.96E-43)])).booleanValue() == false) goto L55;
        IBaseUser r6 = r15.getMatchedUser();
        String r9 = r15.getRoomTitle();
        if (vm2.h.U().f() == true) goto L33;
    L35:
        TextView r7 = (TextView) S90(2131363721);
        Object[] r10 = new Object[1];
        String r11 = r6.getRealNickName();
        if (r11 != null) goto L38;
        r11 = "";
    L38:
        r10[0] = i6.a(r11, 12);
        r7.setText(s1.C(2131918042, r10));
    L39:
        CountDownWithDescTextView r12 = this.N;
        if (r12 == null) goto L42;
        r12.setCountDownViewWidth(s1.f(36.0f));
    L42:
        ChatMatchViewModel r13 = this.h;
        if (r13 == null) goto L49;
        MutableLiveData<b1> r14 = r13.getMatchData();
        if (r14 == null) goto L49;
        b1 r16 = (b1) r14.getValue();
        if (r16 == null) goto L49;
        int r17 = r16.getScene();
    L50:
        ChatMatchViewModel r18 = this.h;
        if (r18 == null) goto L81;
        MutableLiveData<Integer> r19 = r18.getWaitingCount();
        if (r19 == null) goto L81;
        r19.observe(this, new com.bytedance.android.live.liveinteract.voicechat.match.view.c(this, r17));
    L81:
        if (vm2.h.U().f() == false) goto L135;
        HSImageView r20 = this.Q;
        if (r20 == null) goto L85;
        r20.setController(Fresco.newDraweeControllerBuilder().setUri(this.r).setAutoPlayAnimations(true).build());
    L85:
        RecyclerView r21 = this.T;
        if (r21 == null) goto L105;
        List r22 = jm2.a.c(r15.getLinkedUser());
        V90(r15, r22);
        if (r22.isEmpty() == false) goto L97;
        UtilityKotlinExtentionsKt.t(r21);
        TextView r23 = this.P;
        if (r23 == null) goto L93;
        UtilityKotlinExtentionsKt.t(r23);
    L93:
        if (r2.a(r15.getText()) == false) goto L105;
        TextView r24 = this.P;
        if (r24 == null) goto L105;
        r24.setVisibility(0);
        r24.setText(r15.getText());
        goto L105
    L97:
        UtilityKotlinExtentionsKt.w(r21);
        LinearLayoutManager r25 = new LinearLayoutManager(getContext());
        r25.setOrientation(0);
        Unit r26 = Unit.INSTANCE;
        r21.setLayoutManager(r25);
        r21.setAdapter(new ChatMatchGuestAvatarAdapter(s1.getContext(), r22));
        TextView r27 = this.P;
        if (r27 == null) goto L101;
        UtilityKotlinExtentionsKt.w(r27);
    L101:
        if (r2.a(r15.getText()) == false) goto L105;
        TextView r28 = this.P;
        if (r28 == null) goto L105;
        r28.setText(r15.getText());
    L105:
        TextView r29 = this.R;
        if (r29 != null) goto L242;
    L216:
        gk0.a r30 = this.m;
        if (r30 == null) goto L219;
        r30.c(LinkMatchType.TRY_AGAIN.getValue());
    L219:
        HashMap r31 = new HashMap();
        r31.put("room_id", String.valueOf(r15.getMatchedRoomId()));
        IBaseUser r110 = r15.getMatchedUser();
        if (r110 == null) goto L225;
        String r111 = r110.getIdString();
        if (r111 == null) goto L225;
        r8 = r111;
    L225:
        r31.put("anchor_id", r8);
        r31.put("enter_from_merge", "live_detail");
        ChatMatchViewModel r112 = this.h;
        if (r112 == null) goto L230;
        MutableLiveData<Integer> r113 = r112.getMatchType();
        if (r113 == null) goto L230;
        Integer r114 = (Integer) r113.getValue();
    L231:
        if (r114 != null) goto L234;
    L236:
        String r115 = ChatMatchViewModel.ENTER_METHOD_MATCH;
    L237:
        r31.put("enter_method", r115);
        r31.put("action_type", "click");
        IRoom r116 = this.g;
        if (r116 == null) goto L240;
        r5 = r116.getStreamType();
    L240:
        int r117 = h1.a;
        r31.put("live_type", i1.a(r5));
        j0.l().sendLog("livesdk_live_show", r31, new Object[]{x.class, PadLoggerData.class});
        return;
    L234:
        if (r114.intValue() != 1) goto L236;
        r115 = ChatMatchViewModel.ENTER_METHOD_SHAKE;
    L230:
        r114 = null;
        goto L231
    L242:
        ListUserTag r32 = r15.getTag();     // Catch: IllegalArgumentException -> L126
        if (r32 == null) goto L124;
        r29.setVisibility(0);     // Catch: IllegalArgumentException -> L126
        String r33 = r32.getTextColor();     // Catch: IllegalArgumentException -> L126
        if (r33 != null) goto L112;
        r33 = "#80161823";
    L112:
        Long r34 = r32.getBgRadius();     // Catch: IllegalArgumentException -> L126
        if (r34 == null) goto L115;
        float r35 = r34.longValue();     // Catch: IllegalArgumentException -> L126
    L116:
        String r36 = r32.getBgColor();     // Catch: IllegalArgumentException -> L126
        if (r36 != null) goto L119;
        r36 = "#0D161823";
    L119:
        GradientDrawable r37 = new GradientDrawable();     // Catch: IllegalArgumentException -> L126
        r37.setCornerRadius(r35);     // Catch: IllegalArgumentException -> L126
        r37.setColor(Color.parseColor(r36));     // Catch: IllegalArgumentException -> L126
        r29.setBackground(r37);     // Catch: IllegalArgumentException -> L126
        r29.setText(r32.getContent());     // Catch: IllegalArgumentException -> L126
        Long r38 = r32.getTextSize();     // Catch: IllegalArgumentException -> L126
        if (r38 == null) goto L122;
        float r39 = r38.longValue();     // Catch: IllegalArgumentException -> L126
    L123:
        r29.setTextSize(r39);     // Catch: IllegalArgumentException -> L126
        r29.setTextColor(Color.parseColor(r33));     // Catch: IllegalArgumentException -> L126
        goto L216
    L122:
        r39 = 9.0f;
        goto L123
    L115:
        r35 = 2.0f;
        goto L116
    L124:
        r29.setVisibility(8);     // Catch: IllegalArgumentException -> L126
    L126:
        StringBuilder r40 = new StringBuilder("Invalid color, bgColor=");
        ListUserTag r41 = r15.getTag();
        if (r41 == null) goto L129;
        String r42 = r41.getBgColor();
    L130:
        r40.append(r42);
        r40.append(", textColor=");
        ListUserTag r43 = r15.getTag();
        if (r43 == null) goto L133;
        String r44 = r43.getTextColor();
    L134:
        r40.append(r44);
        ALogger.i("ChatMatchDialog", r40.toString());
        goto L216
    L133:
        r44 = null;
        goto L134
    L129:
        r42 = null;
        goto L130
    L135:
        LinearLayout r45 = this.K;
        if (r45 == null) goto L169;
        TextView r46 = this.E;
        if (r46 == null) goto L140;
        UtilityKotlinExtentionsKt.t(r46);
    L140:
        r45.removeAllViews();
        List r47 = r15.getResultTagList();
        if (r47 != null) goto L143;
    L146:
        boolean r48 = true;
    L147:
        if (r48 == false) goto L149;
        UtilityKotlinExtentionsKt.t(r45);
        goto L169
    L149:
        UtilityKotlinExtentionsKt.w(r45);
        Iterator r49 = r15.getResultTagList().iterator();
    L151:
        if (r49.hasNext() == false) goto L169;
        String r50 = ((c1) r49.next()).getValue();
        if (TextUtils.isEmpty(r50) == true) goto L151;
        FastMatchTopicItemView r51 = new FastMatchTopicItemView(s1.getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r50, "desc");
        if (TextUtils.isEmpty(r50) == false) goto L159;
    L168:
        r45.addView(r51);
        goto L151
    L159:
        if (r51.a != null) goto L161;
        r51.a = new LinkedHashMap();
    L161:
        View r52 = (View) ((LinkedHashMap) r51.a).get(2131389250);
        if (r52 != null) goto L167;
        r52 = r51.findViewById(2131389250);
        if (r52 == null) goto L166;
        r51.a.put(2131389250, r52);
        goto L167
    L166:
        r52 = null;
    L167:
        ((TextView) r52).setText(i6.a(r50, 5));
        goto L168
    L143:
        if (r47.isEmpty() == true) goto L146;
        r48 = false;
    L169:
        LinearLayout r53 = this.O;
        if (r53 == null) goto L216;
        r53.removeAllViews();
        List r54 = jm2.a.c(r15.getLinkedUser());
        V90(r15, r54);
        List r55 = r54;
        if (r55.isEmpty() == false) goto L176;
        UtilityKotlinExtentionsKt.t(r53);
        TextView r56 = this.P;
        if (r56 == null) goto L216;
        UtilityKotlinExtentionsKt.t(r56);
        goto L216
    L176:
        UtilityKotlinExtentionsKt.w(r53);
        int r57 = r55.size();
        int r58 = 0;
    L177:
        if (r58 >= r57) goto L210;
        if (r58 >= 3) goto L210;
        HSImageView r59 = new HSImageView(s1.getContext());
        r59.setLayoutParams(new LinearLayout.LayoutParams((int) s1.e(20.0f), (int) s1.e(20.0f)));
        r59.setPadding(0, 0, (int) s1.e(4.0f), 0);
        IBaseUser r60 = ((com.bytedance.android.livesdk.link.model.bridge.k) ListProtector.get(r54, r58)).getUser();
        if (r60 == null) goto L184;
        py.k r118 = r60.getAvatarThumbKt();
    L186:
        if (r118 == null) goto L208;
        if (r60 == null) goto L191;
        py.k r119 = r60.getAvatarThumbKt();
        if (r119 == null) goto L191;
        List r120 = r119.getUrls();
    L193:
        if (CollectionUtils.isEmpty(r120) == true) goto L208;
        if (r59.getTag(2131389795) == null) goto L203;
        Object r121 = r59.getTag(2131389795);
        py.k r122 = r60.getAvatarThumbKt();
        if (r122 == null) goto L200;
        List r123 = r122.getUrls();
    L202:
        if ((!Intrinsics.areEqual(r121, r123)) == true) goto L203;
    L209:
        r53.addView(r59);
        r58 = r58 + 1;
        goto L177
    L200:
        r123 = null;
    L203:
        py.k r124 = r60.getAvatarThumbKt();
        if (r124 == null) goto L206;
        List r125 = r124.getUrls();
    L207:
        r59.setTag(2131389795, r125);
        a1.v(r59, r60.getAvatarThumbKt(), 2131251889);
        goto L209
    L206:
        r125 = null;
    L191:
        r120 = null;
    L208:
        ImageUtil.loadRoundResource(r59, 2131251889, -1, -1);
        goto L209
    L184:
        r118 = null;
    L210:
        TextView r61 = this.P;
        if (r61 == null) goto L213;
        UtilityKotlinExtentionsKt.w(r61);
    L213:
        TextView r62 = this.P;
        if (r62 == null) goto L216;
        r62.setText(s1.C(2131916558, new Object[]{Integer.valueOf(r54.size())}));
    L49:
        r17 = 5;
        goto L50
    L33:
        if (r2.a(r9) == false) goto L35;
        ((TextView) S90(2131363721)).setText(r9);
        goto L39
    L55:
        IBaseUser r63 = r15.getMatchedUser();
        String r65 = r15.getRoomTitle();
        if (vm2.h.U().f() == true) goto L58;
    L60:
        TextView r66 = (TextView) S90(2131363721);
        Object[] r67 = new Object[1];
        String r68 = r63.getRealNickName();
        if (r68 != null) goto L63;
        r68 = "";
    L63:
        r67[0] = i6.a(r68, 12);
        r66.setText(s1.C(2131918042, r67));
    L64:
        ChatMatchViewModel r69 = this.h;
        if (r69 == null) goto L71;
        MutableLiveData<b1> r70 = r69.getMatchData();
        if (r70 == null) goto L71;
        b1 r71 = (b1) r70.getValue();
        if (r71 == null) goto L71;
        int r72 = r71.getScene();
    L73:
        if (r72 != 9) goto L77;
        CountDownWithDescTextView r73 = this.N;
        if (r73 == null) goto L81;
        r73.setDescText(s1.B(2131917773));
        goto L81
    L77:
        CountDownWithDescTextView r74 = this.N;
        if (r74 == null) goto L81;
        r74.setDescText(s1.B(2131917764));
    L71:
        r72 = 5;
        goto L73
    L58:
        if (r2.a(r65) == false) goto L60;
        ((TextView) S90(2131363721)).setText(r65);
        goto L64
    L21:
        if (r3 != this.f) goto L25;
        HSImageView r75 = this.J;
        if (r75 == null) goto L28;
        r75.setImageResource(2131250687);
        goto L28
    L25:
        HSImageView r76 = this.J;
        if (r76 == null) goto L28;
        r76.setVisibility(4);
        goto L28
    }

    public final void ba0(boolean r3) {
        TextView r0 = this.E;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        LinearLayout r1 = this.F;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r1);
    L8:
        if (r3 == false) goto L27;
        TextView r4 = this.D;
        if (r4 == null) goto L12;
        r4.setText(s1.B(2131917593));
    L12:
        TextView r5 = this.E;
        if (r5 == null) goto L15;
        r5.setText(s1.B(2131917594));
    L15:
        String r6 = s1.B(2131915442);
        int r2 = s1.h(2131106926);
        CountDownWithDescTextView r7 = this.C;
        if (r7 == null) goto L18;
        r7.setDescText(r6);
    L18:
        CountDownWithDescTextView r8 = this.C;
        if (r8 == null) goto L21;
        r8.setContainerBackgroundResource(2131250161);
    L21:
        CountDownWithDescTextView r9 = this.C;
        if (r9 == null) goto L24;
        r9.setTextColor(r2);
    L24:
        Dialog r10 = getDialog();
        if (r10 == null) goto L54;
        r10.setCanceledOnTouchOutside(!this.t);
        return;
    L54:
        return;
    L27:
        Integer r11 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r11 != null) goto L31;
    L38:
        TextView r12 = this.D;
        if (r12 == null) goto L41;
        r12.setText(s1.B(2131917769));
    L41:
        TextView r13 = this.E;
        if (r13 == null) goto L44;
        r13.setText(s1.B(2131917770));
    L44:
        String r14 = s1.B(2131917774);
        int r15 = s1.h(2131108569);
        CountDownWithDescTextView r16 = this.C;
        if (r16 == null) goto L47;
        r16.setDescText(r14);
    L47:
        CountDownWithDescTextView r17 = this.C;
        if (r17 == null) goto L50;
        r17.setContainerBackgroundResource(2131250157);
    L50:
        CountDownWithDescTextView r18 = this.C;
        if (r18 == null) goto L56;
        r18.setTextColor(r15);
        return;
    L56:
        return;
    L31:
        if (r11.intValue() != 2) goto L38;
        TextView r19 = this.D;
        if (r19 == null) goto L35;
        r19.setText(s1.B(2131917772));
    L35:
        TextView r20 = this.E;
        if (r20 == null) goto L44;
        r20.setText(s1.B(2131917771));
        goto L44
    }

    public final void ca0(int r5) {
        if (r5 != 8) goto L5;
        UIUtils.updateLayoutMargin(this.z, -3, 0, -3, 0);
    L6:
        LinearLayout r0 = this.u;
        if (r0 == null) goto L10;
        r0.setVisibility(r5);
        return;
    L10:
        return;
    L5:
        UIUtils.updateLayoutMargin(this.z, -3, s1.j(2131168620), -3, s1.j(2131168620));
        goto L6
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L7;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L7;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
    L7:
        setBottomSheetSlideProcessor(c.a);
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        IRoom r5 = this.g;
        if (r5 == null) goto L5;
        this.m = new gk0.a(r5);
    L5:
        ChatMatchViewModel r6 = this.h;
        if (r6 == null) goto L8;
        this.s = new ek0.c(getContext(), this.i, r6);
    L8:
        setStyle(1, 2131954719);
        DataCenter r7 = this.i;
        if (r7 == null) goto L11;
        Boolean r8 = (Boolean) r7.get("data_is_anchor", Boolean.FALSE);
    L12:
        this.t = Intrinsics.areEqual(r8, Boolean.TRUE);
        return;
    L11:
        r8 = null;
        goto L12
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new d(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        ChatMatchViewModel r3 = this.h;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.setHasMatchSuccessOrFail(false);     // Catch: Throwable -> L7
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

    public static void V90(b1 r2, List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.link.model.bridge.k r0 = (com.bytedance.android.livesdk.link.model.bridge.k) r4.next();
        String r1 = r2.getMatchedUser().getIdString();
        IBaseUser r5 = r0.getUser();
        if (r5 == null) goto L8;
        String r6 = r5.getIdString();
    L10:
        if (Intrinsics.areEqual(r1, r6) == false) goto L4;
        r4.remove();
        goto L4
    L8:
        r6 = null;
        goto L10
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Integer r10 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r10 != null) goto L6;
    L7:
        hd0.c.f().c(this.U);
    L9:
        if (vm2.h.U().f() == false) goto L11;
        LayoutInflater.from(getContext()).inflate(2131565308, (ViewGroup) S90(2131364335));
    L12:
        ConstraintLayout r11 = r8.findViewById(2131365553);
        this.u = (LinearLayout) r8.findViewById(2131389108);
        this.v = r8.findViewById(2131387114);
        this.w = (ImageView) r8.findViewById(2131375946);
        this.x = (TextView) r8.findViewById(2131390048);
        this.y = (TextView) r8.findViewById(2131390009);
        this.z = r8.findViewById(2131364329);
        this.A = r8.findViewById(2131375914);
        TextView r12 = (TextView) r8.findViewById(2131372153);
        this.B = (ImageView) r8.findViewById(2131375913);
        this.C = r8.findViewById(2131364615);
        this.D = (TextView) r8.findViewById(2131390008);
        this.E = (TextView) r8.findViewById(2131390007);
        this.F = (LinearLayout) r8.findViewById(2131389247);
        FrameLayout r13 = (FrameLayout) r8.findViewById(2131364335);
        this.G = r13;
        if (r13 == null) goto L19;
        if (vm2.h.U().f() == false) goto L17;
        this.H = (TextView) r13.findViewById(2131365123);
        this.I = r13.findViewById(2131389468);
        this.Q = r13.findViewById(2131389464);
        TextView r14 = (TextView) r13.findViewById(2131363721);
        this.R = (TextView) r13.findViewById(2131363734);
        this.O = (LinearLayout) r13.findViewById(2131363711);
        this.P = (TextView) r13.findViewById(2131377989);
        this.S = (TextView) r13.findViewById(2131380325);
        this.N = r13.findViewById(2131379681);
        this.T = r13.findViewById(2131363729);
        goto L19
    L17:
        this.H = (TextView) r13.findViewById(2131365123);
        this.I = r13.findViewById(2131389468);
        this.J = r13.findViewById(2131363664);
        TextView r15 = (TextView) r13.findViewById(2131363721);
        this.K = (LinearLayout) r13.findViewById(2131363747);
        this.L = r13.findViewById(2131365414);
        this.M = (TextView) r13.findViewById(2131384218);
        this.N = r13.findViewById(2131379681);
        this.O = (LinearLayout) r13.findViewById(2131363711);
        this.P = (TextView) r13.findViewById(2131377989);
    L19:
        if (this.l == false) goto L26;
        int r16 = us1.g.a;
        DataCenter r17 = this.i;
        if (r17 == null) goto L23;
        Boolean r18 = (Boolean) r17.get("data_room_video_talk_integration_audience_has_send_prepare_apply_flag", Boolean.FALSE);
    L24:
        Z90(Intrinsics.areEqual(r18, Boolean.TRUE) ? 1 : 0);
    L30:
        ChatMatchViewModel r19 = this.h;
        if (r19 == null) goto L48;
        MutableLiveData<Boolean> r20 = r19.getMatchingState();
        if (r20 == null) goto L48;
        if (Intrinsics.areEqual((Boolean) r20.getValue(), Boolean.FALSE) == false) goto L39;
        gk0.a r2 = this.m;
        if (r2 == null) goto L39;
        r2.c(LinkMatchType.MATCH.getValue());
    L39:
        Boolean r3 = (Boolean) r20.getValue();
        Boolean r4 = Boolean.TRUE;
        ba0(Intrinsics.areEqual(r3, r4));
        if (Intrinsics.areEqual((Boolean) r20.getValue(), r4) == false) goto L44;
        ImageView r5 = this.w;
        if (r5 == null) goto L47;
        r5.setVisibility(8);
    L47:
        r20.observe(this, new l(this));
        goto L48
    L44:
        ImageView r6 = this.w;
        if (r6 == null) goto L47;
        r6.setVisibility(0);
    L48:
        ChatMatchViewModel r21 = this.h;
        if (r21 == null) goto L56;
        MutableLiveData<b1> r22 = r21.getMatchData();
        if (r22 == null) goto L56;
        b1 r7 = (b1) r22.getValue();
        if (r7 == null) goto L55;
        aa0(r7);
    L55:
        r22.observe(this, new k(this));
    L56:
        ChatMatchViewModel r23 = this.h;
        if (r23 == null) goto L61;
        MutableLiveData<a5> r24 = r23.getDisplayText();
        if (r24 == null) goto L61;
        r24.observe(this, new com.bytedance.android.live.liveinteract.voicechat.match.view.d(this));
    L61:
        ChatMatchViewModel r25 = this.h;
        if (r25 == null) goto L66;
        MutableLiveData<Boolean> r26 = r25.isPrepareApplySuccess();
        if (r26 == null) goto L66;
        r26.observe(this, new n(this));
    L66:
        ChatMatchViewModel r27 = this.h;
        if (r27 == null) goto L71;
        MutableLiveData<Boolean> r28 = r27.getPrepareApplyCancel();
        if (r28 == null) goto L71;
        r28.observe(this, new m(this));
    L71:
        W90();
        IRoom r29 = this.g;
        if (r29 != null) goto L74;
    L86:
        TextView r30 = this.y;
        if (r30 == null) goto L89;
        r30.setOnClickListener(new e(this));
    L89:
        CountDownWithDescTextView r31 = this.C;
        if (r31 == null) goto L92;
        r31.setOnClickListener(new f(this));
    L92:
        TextView r32 = this.H;
        if (r32 == null) goto L95;
        r32.setOnClickListener(new g(this));
    L95:
        TextView r33 = this.M;
        if (r33 == null) goto L99;
        r33.setOnClickListener(new ChatMatchDialog$initOnClickListener$4(this));
    L99:
        if (vm2.h.U().f() == false) goto L106;
        TextView r34 = this.S;
        if (r34 == null) goto L103;
        r34.setOnClickListener(new h(this));
    L103:
        HSImageView r35 = this.I;
        if (r35 == null) goto L106;
        r35.setOnClickListener(new i(this));
    L106:
        CountDownWithDescTextView r36 = this.N;
        if (r36 == null) goto L110;
        r36.setOnClickListener(new j(this));
    L110:
        if (this.p == false) goto L113;
        this.p = false;
        int r37 = ik0.g.b;
        Y90(0);
        return;
    L113:
        return;
    L74:
        if (this.j != null) goto L86;
        Integer r38 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r38 != null) goto L79;
    L80:
        ImageView r0 = this.w;
        if (r0 == null) goto L83;
        r0.setVisibility(8);
    L83:
        ChatMatchViewModel r39 = this.h;
        if (r39 == null) goto L86;
        r39.getUserWaitingRankPosition(r29);
        goto L86
    L79:
        if (r38.intValue() == 2) goto L86;
    L23:
        r18 = null;
        goto L24
    L26:
        if (hd0.c.f().j() == false) goto L28;
        Integer r40 = (Integer) ((ge1.a) hd0.c.f()).b;
    L29:
        Z90(r40.intValue());
        goto L30
    L28:
        r40 = -1;
        goto L29
    L11:
        LayoutInflater.from(getContext()).inflate(2131565307, (ViewGroup) S90(2131364335));
        goto L12
    L6:
        if (r10.intValue() == 2) goto L9;
        goto L7
    }

    public static final void T90(ChatMatchDialog r9, b1 r10, Function0 r11) {
        r9.getClass();
        if (vm2.d.e().b() == true) goto L5;
        r11.invoke();
        return;
    L5:
        boolean r0 = hd0.c.f().j();
        if (r9.k == true) goto L10;
        if (r0 == false) goto L10;
        boolean r7 = false;
    L12:
        if (r7 == false) goto L14;
        int r1 = s1.j(2131168619);
    L16:
        if (vm2.h.U().f() == false) goto L19;
        int r2 = s1.j(2131168618);
    L18:
        int r6 = r2;
        ValueAnimator r3 = r9.n;
        if (r3 != null) goto L29;
    L31:
        float[] r4 = {1.0f, 0.0f};
        if (r10 == null) goto L35;
        r4 = {x00c4: FILL_ARRAY_DATA  (LINE:50331844), data: [0, 1065353216} // fill-array;
    L35:
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r9.n = r5;
        if (r5 == null) goto L38;
        r5.addUpdateListener(new com.bytedance.android.live.liveinteract.voicechat.match.view.a(r9, r6, r1, r7));
    L38:
        ValueAnimator r8 = r9.n;
        if (r8 == null) goto L41;
        r8.addListener(new com.bytedance.android.live.liveinteract.voicechat.match.view.b(r9, r10, r6, r7, r11));
    L41:
        ValueAnimator r12 = r9.n;
        if (r12 == null) goto L44;
        r12.setDuration(200);
    L44:
        ValueAnimator r13 = r9.n;
        if (r13 == null) goto L49;
        r13.start();
        return;
    L49:
        return;
    L29:
        if (r3.isRunning() == false) goto L31;
        r3.cancel();
        goto L31
    L19:
        if (r10 == null) goto L25;
        List r14 = r10.getTopicStrList();
        if (r14 == null) goto L25;
        if ((!r14.isEmpty()) != true) goto L25;
        r2 = s1.j(2131168616);
    L25:
        r2 = s1.j(2131168617);
        goto L18
    L14:
        r1 = (s1.j(2131168620) * 2) + (s1.j(2131168621) + s1.j(2131168619));
    L10:
        r7 = true;
        goto L12
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565418, r2);
    }
}
