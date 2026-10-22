package com.larus.bmhome.chat.component.share;

import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.databinding.LarusPageChatBottomShareBinding;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Dispatchers;
import ld8.n;
import s1a.d;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ ChatShareBottomComponent a;
    public final /* synthetic */ IChatMessageShareAbility$ActionType b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ List d;
    public final /* synthetic */ Map e;

    public /* synthetic */ p(ChatShareBottomComponent r1, IChatMessageShareAbility$ActionType r2, Message r3, List r4, Map r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        final ChatShareBottomComponent r2 = this.a;
        IChatMessageShareAbility$ActionType r3 = this.b;
        Message r4 = this.c;
        List<Message> r5 = this.d;
        Map<String, Object> r6 = this.e;
        com.larus.bmhome.chat.component.bottom.multimodal.latest.a r0 = (com.larus.bmhome.chat.component.bottom.multimodal.latest.a) r2.F.getValue();
        if (r0 == null) goto L6;
        r0.g0("ChatShareBottomComponent#enterSelectMode");
    L6:
        if (r3 != IChatMessageShareAbility$ActionType.SHARE) goto L10;
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r1 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) d.a(r2).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r1 == null) goto L10;
        r1.Ro();
    L10:
        nda.d.a().xa(s1a.a.e(r2));
        ViewStub r7 = r2.P;
        MessageAdapter r8 = null;
        if (r7 != null) goto L13;
    L78:
        r2.e4().enterSelectMode(r3, r4, r5, r6);
        IFlowMainBot.Companion r9 = IFlowMainBot.a;
        u7 r10 = r2.Z3();
        if (r10 == null) goto L81;
        MessageAdapter r11 = r10.MF();
    L83:
        if ((r11 instanceof MessageAdapter) == false) goto L85;
        r8 = r11;
    L85:
        IFlowMainBot.a.a(r9, r8, false, r4, 2);
        return Unit.INSTANCE;
    L81:
        r11 = null;
        goto L83
    L13:
        if (r2.n != null) goto L78;
        r7.setLayoutResource(2131563013);
        View r12 = r7.inflate();
        ConstraintLayout.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof ConstraintLayout.LayoutParams) == false) goto L17;
        ConstraintLayout.LayoutParams r14 = r13;
    L18:
        boolean r15 = true;
        if (r14 == null) goto L30;
        va8.f0 r16 = d.a(r2).getAbility(va8.f0.class);
        if (r16 != null) goto L23;
    L25:
        boolean r17 = false;
    L26:
        if (r17 == false) goto L28;
        r14.bottomToTop = -1;
        r14.topToBottom = -1;
        r14.bottomToBottom = 0;
        r12.setBackgroundColor(ContextCompat.getColor(r12.getContext(), c.b(2130970534, r12.getContext(), 2131102545)));
    L29:
        r12.setLayoutParams(r14);
        FLogger.a.i("ChatShareBottomComponent", "configure share layout, isLegacyFloatChat=" + r17 + ", bottomToBottom=" + r14.bottomToBottom);
        goto L30
    L28:
        r14.bottomToTop = 2131367164;
        r14.topToBottom = 2131367905;
        goto L29
    L23:
        if (r16.R() != true) goto L25;
        r17 = true;
    L30:
        int r18 = 2131378749;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131378749);
        if (r19 == null) goto L77;
        r18 = 2131378750;
        LinearLayout r110 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131378750);
        if (r110 == null) goto L77;
        r18 = 2131380012;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r12, 2131380012);
        if (r20 == null) goto L77;
        r18 = 2131380013;
        AppCompatCheckBox r21 = ViewBindings.findChildViewById(r12, 2131380013);
        if (r21 == null) goto L77;
        r18 = 2131380014;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r12, 2131380014);
        if (r22 == null) goto L77;
        r18 = 2131380976;
        Button r23 = (Button) ViewBindings.findChildViewById(r12, 2131380976);
        if (r23 == null) goto L77;
        r18 = 2131380977;
        LinearLayout r24 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131380977);
        if (r24 == null) goto L77;
        r18 = 2131380978;
        View r25 = ViewBindings.findChildViewById(r12, 2131380978);
        if (r25 == null) goto L77;
        r18 = 2131381863;
        FrameLayout r26 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131381863);
        if (r26 == null) goto L77;
        r18 = 2131381864;
        RelativeLayout r27 = (RelativeLayout) ViewBindings.findChildViewById(r12, 2131381864);
        if (r27 == null) goto L77;
        r2.n = new LarusPageChatBottomShareBinding((LinearLayout) r12, r19, r110, r20, r21, r22, r23, r24, r25, r26, r27);
        CompletableDeferred r28 = wr8.d.a;
        if (r28 != null) goto L53;
    L87:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L67
        Intrinsics.checkNotNullParameter(r2, "<this>");     // Catch: Throwable -> L67
        if (com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getView() == null) goto L64;
        r2.i4();     // Catch: Throwable -> L67
    L65:
        Object r30 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
    L69:
        Throwable r31 = Result.exceptionOrNull-impl(r30);
        if (r31 == null) goto L73;
        EnsureManager.ensureNotReachHere("initMessageShareMode err! msg=" + r31.getMessage());
    L73:
        n r32 = (n) r2.D.getValue();
        if (r32 == null) goto L78;
        r32.AE(BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON, new u(r2));
        goto L78
    L64:
        FLogger.a.e("ChatShareBottomComponent", "provider.fragment().view is null! stop init");     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L53:
        if (r28.isCompleted() == true) goto L56;
        r15 = false;
    L56:
        if (r15 == true) goto L87;
        if (com.larus.bmhome.social.userchat.model.e0.b == false) goto L87;
        FLogger.a.d("ChatShareBottomComponent", "initMessageShareModeOpt shareViewModel.hashCode=" + r2.e4().hashCode());
        r2.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), Dispatchers.getIO(), null, new ChatShareBottomComponent$initMessageShareModeOpt$3(r2, null), 2, null);
    L77:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r18)));
    L17:
        r14 = null;
        goto L18
    }
}
