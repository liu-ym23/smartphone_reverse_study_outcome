package com.ss.android.lark.forwardv3;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.gson.JsonArray;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle;
import com.ss.android.lark.forwardv3.utils.FileUtils;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.Source;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;
import z5c.b3;
import z5c.c3;
import z5c.d3;
import z5c.e3;
import z5c.r;
import z5c.t1;
import z5c.t2;
import z5c.u2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1 implements qib.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ForwardNewFragment b;
    public final /* synthetic */ List<SearchBaseInfo> c;
    public final /* synthetic */ s5c.d d;
    public final /* synthetic */ ForwardNewFragment.b e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ForwardNewFragment a;
        public final /* synthetic */ FragmentActivity b;

        public a(ForwardNewFragment r1, FragmentActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            StringBuilder r0 = new StringBuilder("click custom content container, clickable is: ");
            ForwardV3ViewModel r1 = this.a.f;
            ForwardV3ViewModel r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r1 = null;
        L5:
            r0.append(r1.getDialogContent().k);
            Log.i("NewForward", r0.toString());
            ForwardV3ViewModel r3 = this.a.f;
            if (r3 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r3 = null;
        L9:
            if (r3.getDialogContent().k == false) goto L18;
            s5c.a r4 = r.b1;
            s5c.h r5 = s5c.h.a;
            int r7 = zib.e.a;
            r4.getClass();
            zib.e.a.c(s5c.d.b.b(r4, r5));
            ForwardV3ViewModel r8 = this.a.f;
            if (r8 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L14:
            OnCustomForwardConfirmDialogContentView r9 = r2.getCustomConfirmDialogContentView();
            if (r9 == null) goto L19;
            FragmentActivity r10 = this.b;
            ForwardNewFragment r11 = this.a;
            Intrinsics.checkNotNull(r6);
            r9.p(r10, r11, r6);
            return;
        L19:
            return;
        L13:
            r2 = r8;
            goto L14
        }
    }

    public static final class b implements OnCustomForwardConfirmDialogContentView.a {
        public b() {
        }
    }

    @Override // qib.a
    public final void a() {
        s5c.a r0 = r.d;
        s5c.h r1 = s5c.h.a;
        int r2 = zib.e.a;
        r0.getClass();
        zib.e.a.e(s5c.d.b.b(r0, r1));
        ForwardV3ViewModel r3 = this.b.f;
        tib.e r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        oib.c r5 = r3.getConfirmDialogListener();
        if (r5 == null) goto L8;
        r5.onCancelButtonClick();
    L8:
        tib.e r6 = this.b.e;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
    L12:
        r4.i(true);
        return;
    L11:
        r4 = r6;
        goto L12
    }

    @Override // qib.a
    public final void onDismissForward() {
        boolean r0 = zib.b.d;
        zib.b.b();
        ForwardV3ViewModel r1 = null;
        if (this.b.isAdded() == false) goto L19;
        ForwardV3ViewModel r2 = this.b.f;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L8:
        if (r2.getSource() == Forward$Source.MY_AI) goto L16;
        ForwardV3ViewModel r3 = this.b.f;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L13:
        if (r3.getSource() == Forward$Source.KNOWLEDGE_AI) goto L16;
        int r4 = com.ss.android.lark.forwardv3.utils.n.a;
        if (com.ss.android.lark.forwardv3.utils.n.f(this.b.getActivity()) == false) goto L19;
    L16:
        FragmentTransaction r5 = this.b.getChildFragmentManager().beginTransaction();
        Fragment r6 = this.b.getChildFragmentManager().findFragmentByTag("frowardDialog");
        if (r6 == null) goto L19;
        r5.remove(r6);
        r5.commitAllowingStateLoss();
    L19:
        ForwardV3ViewModel r7 = this.b.f;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        oib.c r8 = r1.getConfirmDialogListener();
        if (r8 == null) goto L27;
        r8.onDismissForward();
        return;
    L27:
        return;
    L22:
        r1 = r7;
        goto L23
    }

    public final void c(ConstraintLayout r27) {
        Intrinsics.checkNotNullParameter(r27, "baseContentContainer");
        Log.i("NewForward", "setup base forward content");
        int r3 = com.ss.android.lark.forwardv3.utils.n.a;
        Context r4 = this.a;
        ForwardV3ViewModel r5 = this.b.f;
        IMFileResult r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L5:
        Message r7 = r5.getDisplayMessage();
        ForwardV3ViewModel r8 = this.b.f;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L8:
        BasicDialogContentConfig r12 = r8.getDialogContent();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r27, "baseContentContainer");
        Intrinsics.checkNotNullParameter(r12, "dialogContent");
        FrameLayout r2 = (FrameLayout) r27.findViewById(2131367661);
        GifImageView r13 = r27.findViewById(2131367660);
        ImageView r14 = (ImageView) r27.findViewById(2131367662);
        LinearLayout r15 = (LinearLayout) r27.findViewById(2131367659);
        TextView r11 = (TextView) r27.findViewById(2131367668);
        TextView r10 = (TextView) r27.findViewById(2131367666);
        TextView r9 = (TextView) r27.findViewById(2131367667);
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r9);
        int r16 = FileUtils.a;
        if (r7 == null) goto L14;
        ValidateIMFileResult r17 = r7.getValidateIMFileResult();
        if (r17 == null) goto L14;
        r6 = r17.getResultType();
    L14:
        if (r6 != null) goto L16;
        FileUtils.ReceiveAuthorizationState r18 = FileUtils.ReceiveAuthorizationState.NORMAL_STATE;
    L30:
        Intrinsics.checkNotNullParameter(r18, "receiveAuthorizationState");
        int r19 = FileUtils.a.a[r18.ordinal()];
        if (r19 == 1) goto L34;
        if (r19 == 2) goto L34;
        boolean r20 = false;
    L36:
        if (r20 == false) goto L42;
        r13.setVisibility(0);
        r13.setImageResource(2131244040);
        r14.setVisibility(8);
        if (r18 != FileUtils.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L40;
        String r21 = y9c.d.h(2131891244);
    L41:
        r9.setText(r21);
        r9.setVisibility(0);
        TextView r110 = r9;
        TextView r22 = r10;
        TextView r23 = r11;
        int r0 = 0;
        int r24 = 8;
        boolean r111 = true;
    L82:
        if (r13.getVisibility() != 0) goto L84;
        boolean r25 = true;
    L86:
        if (r14.getVisibility() != 0) goto L88;
        boolean r26 = true;
    L90:
        if (r23.getVisibility() != 0) goto L92;
        boolean r28 = true;
    L94:
        if (r22.getVisibility() != 0) goto L96;
        boolean r112 = true;
    L98:
        if (r110.getVisibility() == 0) goto L101;
        r111 = false;
    L101:
        int r113 = y9c.d.a(10);
        int r114 = y9c.d.a(5);
        if (r25 == false) goto L111;
        if (r28 == true) goto L106;
        if (r112 == true) goto L106;
        if (r111 == false) goto L111;
    L106:
        Intrinsics.checkNotNull(r2);
        r2.setVisibility(r0);
        Intrinsics.checkNotNull(r15);
        r15.setVisibility(r0);
        if (r26 == true) goto L110;
        r0 = 8;
    L110:
        r14.setVisibility(r0);
        ViewGroup.LayoutParams r1 = r15.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r29 = (ConstraintLayout.LayoutParams) r1;
        ((ViewGroup.MarginLayoutParams) r29).leftMargin = r113;
        r15.setLayoutParams(r29);
        com.ss.android.lark.forwardv3.utils.n.a(r4, r114, r28, r23, r112, r22, r111, r110);
        return;
    L111:
        if (r25 == true) goto L116;
        if (r28 == true) goto L115;
        if (r112 == true) goto L115;
        if (r111 == false) goto L116;
    L115:
        Intrinsics.checkNotNull(r2);
        r2.setVisibility(r24);
        Intrinsics.checkNotNull(r15);
        r15.setVisibility(r0);
        r14.setVisibility(r24);
        com.ss.android.lark.forwardv3.utils.n.a(r4, r114, r28, r23, r112, r22, r111, r110);
        return;
    L116:
        if (r25 == false) goto L125;
        if (r28 == true) goto L125;
        if (r112 == true) goto L125;
        if (r111 == true) goto L125;
        Intrinsics.checkNotNull(r2);
        r2.setVisibility(r0);
        Intrinsics.checkNotNull(r15);
        r15.setVisibility(r24);
        if (r26 == false) goto L123;
        int r115 = 0;
    L124:
        r14.setVisibility(r115);
        return;
    L123:
        r115 = 8;
    L125:
        if (r25 == true) goto L134;
        if (r28 == true) goto L135;
        if (r112 == true) goto L136;
        if (r111 == true) goto L137;
        r27.setVisibility(r24);
        return;
    L137:
        return;
    L136:
        return;
    L135:
        return;
    L134:
        return;
    L96:
        r112 = false;
        goto L98
    L92:
        r28 = false;
        goto L94
    L88:
        r26 = false;
        goto L90
    L84:
        r25 = false;
        goto L86
    L40:
        r21 = "";
        goto L41
    L42:
        boolean r116 = ForwardModuleV3.a().hasFilePreviewPermissionFromMessage(r7);
        if (r116 == true) goto L46;
        r13.setVisibility(0);
        r13.setImageResource(2131244040);
    L48:
        TextView r210 = r9;
        TextView r211 = r10;
        TextView r212 = r11;
        r0 = 0;
        r24 = 8;
        r111 = true;
    L60:
        if (r116 == true) goto L63;
        r14.setVisibility(r24);
    L68:
        if (TextUtils.isEmpty(r12.b) == true) goto L70;
        r23 = r212;
        r23.setVisibility(r0);
        r23.setText(r12.b);
    L72:
        if (TextUtils.isEmpty(r12.c) == true) goto L74;
        r22 = r211;
        r22.setVisibility(r0);
        r22.setText(r12.c);
    L75:
        if (r116 == true) goto L77;
        r110 = r210;
        r110.setVisibility(r0);
        r110.setText(y9c.d.h(2131891415));
        goto L82
    L77:
        r110 = r210;
        if (TextUtils.isEmpty(r12.d) == true) goto L80;
        r110.setVisibility(r0);
        r110.setText(r12.d);
        goto L82
    L80:
        r110.setVisibility(r24);
        goto L82
    L74:
        r22 = r211;
        r22.setVisibility(r24);
        goto L75
    L70:
        r23 = r212;
        r23.setVisibility(r24);
        goto L72
    L63:
        if (r13.getVisibility() == r24) goto L68;
        if (r12.e <= 0) goto L68;
        r14.setVisibility(r0);
        r14.setImageResource(r12.e);
        goto L68
    L46:
        if (r12.f <= 0) goto L50;
        r13.setVisibility(0);
        r13.setImageResource(r12.f);
        goto L48
    L50:
        if (r12.h == null) goto L52;
        r13.setVisibility(0);
        r111 = true;
        r210 = r9;
        r211 = r10;
        r212 = r11;
        r0 = 0;
        com.ss.android.lark.forwardv3.utils.a.a(r4, r13, r12.j, r12.h, false, true, 0, 0);
    L58:
        r24 = 8;
        goto L60
    L52:
        r210 = r9;
        r211 = r10;
        r212 = r11;
        r0 = 0;
        r111 = true;
        if (r12.g == null) goto L56;
        r13.setVisibility(0);
        com.ss.android.lark.forwardv3.utils.a.a(r4, r13, r12.j, r12.g, true, false, 0, 0);
        goto L58
    L56:
        if (r12.i == null) goto L59;
        r13.setVisibility(0);
        ForwardModuleV3.a().showSquareMessageStickerThumb(r4, r13, r12.i);
        goto L58
    L59:
        r24 = 8;
        r13.setVisibility(8);
    L34:
        r20 = true;
        goto L36
    L16:
        FileUtils.ReceiveAuthorizationState.a r30 = FileUtils.ReceiveAuthorizationState.Companion;
        int r31 = r6.getValue();
        r30.getClass();
        if (r31 == 0) goto L29;
        if (r31 == 1) goto L28;
        if (r31 != 2) goto L21;
        r18 = FileUtils.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS;
        goto L30
    L21:
        if (r31 != 3) goto L23;
        r18 = FileUtils.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY;
        goto L30
    L23:
        if (r31 == 4) goto L25;
        r18 = FileUtils.ReceiveAuthorizationState.UNKNOWN;
        goto L30
    L25:
        r18 = FileUtils.ReceiveAuthorizationState.NORMAL_STATE;
        goto L30
    L28:
        r18 = FileUtils.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE;
        goto L30
    L29:
        r18 = FileUtils.ReceiveAuthorizationState.UNKNOWN;
        goto L30
    }

    public final void d(ConstraintLayout r8) {
        Intrinsics.checkNotNullParameter(r8, "customContentContainer");
        Log.i("NewForward", "setup custom forward content");
        ForwardNewFragment r2 = this.b;
        b r1 = new b();
        Activity r3 = r2.getActivity();
        if (r3 == null) goto L15;
        ForwardNewFragment r0 = this.b;
        ForwardV3ViewModel r4 = r0.f;
        ForwardV3ViewModel r5 = null;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L7:
        OnCustomForwardConfirmDialogContentView r6 = r4.getCustomConfirmDialogContentView();
        if (r6 == null) goto L14;
        ForwardV3ViewModel r7 = r0.f;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r6.E1(r3, r8, r5.getDialogContent(), r1);
        goto L14
    L12:
        r5 = r7;
    L14:
        r8.setOnClickListener(new a(r0, r3));
        return;
    L15:
        Log.e("NewForward", "activity is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qib.a
    public final void b(final String r23, final RichText r24) {
        Intrinsics.checkNotNullParameter(r23, "note");
        Intrinsics.checkNotNullParameter(r24, "richText");
        final BeforeForwardErrorHandle r8 = new BeforeForwardErrorHandle(this.a);
        i08.a.b(this.a, y9c.d.h(2131892207));
        String r2 = com.ss.android.lark.widget.richtext.i.g(r24, true);
        ForwardNewFragment r3 = this.b;
        List<SearchBaseInfo> r4 = this.c;
        s5c.d r5 = this.d;
        int r6 = ForwardNewFragment.t;
        r3.getClass();
        s5c.a r7 = r.f;
        s5c.h r9 = s5c.h.a;
        if (TextUtils.isEmpty(r23) == false) goto L5;
    L8:
        s5c.a r11 = t1.d;
    L9:
        int r12 = zib.e.a;
        ForwardV3ViewModel r10 = r3.f;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L12:
        sib.a r13 = (sib.a) r10.getRecommendData().getValue();
        Intrinsics.checkNotNullParameter(r4, "selectedInfo");
        JsonArray r14 = new JsonArray();
        Iterator r15 = r4.iterator();
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r110 = 0;
    L14:
        if (r15.hasNext() == false) goto L43;
        SearchChatInfo r111 = (SearchBaseInfo) r15.next();
        if ((r111 instanceof SearchChatInfo) == false) goto L22;
        if (r111.isSecretChat() == false) goto L20;
        r16 = r16 + 1;
    L20:
        r18 = r18 + 1;
    L26:
        Iterator r21 = r15;
    L27:
        Source.Type r1 = r111.getSource();
        if (r1 != null) goto L30;
        int r20 = -1;
    L32:
        if (r20 == 1) goto L42;
        if (r20 != 2) goto L36;
        r110 = r110 + 1;
        goto L42
    L36:
        if (r20 != 3) goto L42;
        if ((r13 instanceof sib.a.b) == false) goto L42;
        r14.add(Integer.valueOf(((rib.b) ((sib.a.b) r13).a).a.indexOf(r111)));
    L42:
        r15 = r21;
        goto L14
    L30:
        r20 = zib.e.a.C0353a.a[r1.ordinal()];
        goto L32
    L22:
        if ((r111 instanceof SearchChatterInfo) == false) goto L26;
        r17 = r17 + 1;
        r21 = r15;
        if (((SearchChatterInfo) r111).getChatterType() != Chatter.ChatterType.BOT) goto L27;
        r19 = r19 + 1;
        goto L27
    L43:
        s5c.a r22 = c3.c.a(String.valueOf(r16));
        s5c.a r25 = e3.c.a(String.valueOf(r17));
        s5c.a r26 = d3.c.a(String.valueOf(r18));
        s5c.a r112 = b3.c.a(String.valueOf(r19));
        s5c.d r27 = s5c.d.b.b(u2.c.a(String.valueOf(r110)), t2.c.a(r14.toString())).plus(r112).plus(r22).plus(r25).plus(r26);
        int r28 = zib.e.a;
        r7.getClass();
        zib.e.a.e(s5c.d.b.b(r7, r5).plus(r9).plus(r27).plus(r11));
        ForwardV3ViewModel r29 = this.b.f;
        if (r29 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r29 = null;
    L46:
        oib.c r30 = r29.getConfirmDialogListener();
        if (r30 == null) goto L49;
        r30.onConfirmButtonClick(r23, r2);
    L49:
        final ForwardNewFragment r31 = this.b;
        final Context r32 = this.a;
        final List<SearchBaseInfo> r33 = this.c;
        final ForwardNewFragment.b r34 = this.e;
        UIGetDataCallback<List<ForwardTargetBaseInfoNew>> r113 = new ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1$onConfirmForward$prepareChatCallback$1(r31, r32, r33, r23, r24, r34, r8);
        if (this.e.a.isEmpty() == false) goto L55;
        ForwardNewFragment r35 = this.b;
        Context r36 = this.a;
        List<SearchBaseInfo> r37 = this.c;
        z r38 = r35.l;
        if (r38 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("forwardSendHelper");
        r38 = null;
    L54:
        LifecycleCoroutineScope r39 = LifecycleOwnerKt.getLifecycleScope(r35);
        r38.a(r39, r36, r37, r23, r24);
    L60:
        boolean r40 = zib.b.d;
        zib.b.a = 0;
        zib.b.b = 0;
        zib.b.c = 0;
        return;
    L55:
        ForwardV3ViewModel r41 = this.b.f;
        if (r41 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        ForwardV3ViewModel r114 = null;
    L59:
        r114.prepareChatBeforeForward(this.e.a, r113);
        goto L60
    L58:
        r114 = r41;
        goto L59
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r11 = t1.c;
        goto L9
    }

    public ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1(Context r1, ForwardNewFragment r2, List r3, s5c.a r4, ForwardNewFragment.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
