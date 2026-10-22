package com.larus.bmhome.bot;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupUserInfo$1$1", f = "CommonSettingFragment.kt", i = {}, l = {1140}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupUserInfo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $context;
    final /* synthetic */ LifecycleOwner $owner;
    final /* synthetic */ com.larus.bmhome.setting.c $this_run;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupUserInfo$1$1(com.larus.bmhome.setting.c r1, CommonSettingFragment r2, LifecycleOwner r3, FragmentActivity r4, Continuation<? super CommonSettingFragment$setupUserInfo$1$1> r5) {
        this.$this_run = r1;
        this.this$0 = r2;
        this.$owner = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CommonSettingFragment$setupUserInfo$1$1(this.$this_run, this.this$0, this.$owner, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L15:
        if (((Boolean) r11).booleanValue() == true) goto L21;
        FLogger.a.e(this.this$0.e, "user info cache is empty, hide user container");
        RelativeLayout r12 = this.$this_run.d1();
        if (r12 == null) goto L20;
        com.larus.utils.e1.o(r12);
    L20:
        return Unit.INSTANCE;
    L21:
        com.larus.bmhome.setting.c r13 = this.this$0.g;
        ViewGroup r2 = null;
        if (r13 == null) goto L24;
        View r14 = r13.P0();
    L26:
        if (r14 != this.$this_run.P0()) goto L129;
        if (this.$owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L129;
        AccountService r15 = AccountService.a;
        final String r3 = r15.s();
        if (r3 != null) goto L33;
        r3 = "";
    L33:
        RoundAvatarImageView r4 = this.$this_run.c1();
        if (r4 == null) goto L36;
        RoundAvatarImageView.f(r4, r3, "settings_itg.user", false, 12);
    L36:
        ViewGroup r5 = (ViewGroup) this.$this_run.P0().findViewById(2131380416);
        AppHost.Companion r6 = AppHost.a;
        if (r6.isOversea() == false) goto L39;
    L62:
        com.larus.platform.api.n4 r7 = this.this$0.h;
        if (r7 == null) goto L65;
        r7.release();
    L65:
        this.this$0.h = null;
        if (r5 == null) goto L68;
        com.larus.utils.e1.o(r5);
    L68:
        RoundAvatarImageView r8 = this.$this_run.c1();
        final FragmentActivity r9 = this.$context;
        final CommonSettingFragment r10 = this.this$0;
        com.larus.utils.e1.d(r8, new i5(r9, r3, r10));
        TextView r16 = this.$this_run.u0();
        if (r16 == null) goto L71;
        r16.setText(r15.getNickname());
    L71:
        TextView r17 = this.$this_run.e1();
        if (r17 == null) goto L75;
        com.larus.utils.e1.x(r17);
    L75:
        if (r6.isOversea() == false) goto L80;
        TextView r18 = this.$this_run.e1();
        if (r18 == null) goto L98;
        r18.setText("@".concat(r15.getUserName()));
    L98:
        List r19 = CollectionsKt.listOf(new View[]{this.$this_run.w0(), this.$this_run.e1()});
        final FragmentActivity r20 = this.$context;
        final CommonSettingFragment r21 = this.this$0;
        Iterator r22 = r19.iterator();
    L100:
        if (r22.hasNext() == false) goto L103;
        com.larus.utils.e1.d((View) r22.next(), new j5(r20, r21));
        goto L100
    L103:
        if (com.larus.platform.service.z2.a.g1() == false) goto L110;
        AppCompatImageView r23 = this.$this_run.v0();
        if (r23 == null) goto L107;
        com.larus.utils.e1.x(r23);
    L107:
        ViewGroup r24 = this.$this_run.w0();
        if (r24 == null) goto L113;
        final FragmentActivity r25 = this.$context;
        com.larus.utils.e1.d(r24, new k5(r25));
    L113:
        GradientDrawable r26 = new GradientDrawable();
        FragmentActivity r27 = this.$context;
        r26.setCornerRadius(r27.getResources().getDimension(v19.c.b(2130971163, r27, 2131166696)));
        r26.setColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{ContextCompat.getColor(r27, v19.c.b(2130972118, r27, 2131103188)), ContextCompat.getColor(r27, v19.c.b(2130970532, r27, 2131102539))}));
        TextView r110 = this.$this_run.c();
        if (r110 == null) goto L116;
        r110.setBackground(r26);
    L116:
        AppHost.Companion r111 = AppHost.a;
        if (r111.isOversea() == false) goto L119;
        String r112 = String.format(this.$context.getString(2131909252), Arrays.copyOf(new Object[]{r111.getAppStringName()}, 1));
    L120:
        TextView r28 = this.$this_run.c();
        if (r28 == null) goto L123;
        r28.setText(r112);
    L123:
        TextView r113 = this.$this_run.c();
        if (r113 == null) goto L127;
        final FragmentActivity r29 = this.$context;
        com.larus.utils.e1.d(r113, new l5(r29));
    L127:
        return Unit.INSTANCE;
    L119:
        r112 = String.format(this.$context.getString(2131909250), Arrays.copyOf(new Object[]{r111.getAppStringName()}, 1));
        goto L120
    L110:
        AppCompatImageView r30 = this.$this_run.v0();
        if (r30 == null) goto L113;
        com.larus.utils.e1.o(r30);
        goto L113
    L80:
        if (r15.isEnterpriseAccount() == false) goto L95;
        String r114 = r15.getTenantName();
        if (r114 != null) goto L84;
    L87:
        boolean r31 = true;
    L88:
        if (r31 == false) goto L92;
        TextView r115 = this.$this_run.e1();
        if (r115 == null) goto L98;
        com.larus.utils.e1.o(r115);
        goto L98
    L92:
        TextView r32 = this.$this_run.e1();
        if (r32 == null) goto L98;
        r32.setText(r114);
        goto L98
    L84:
        if (r114.length() == 0) goto L87;
        r31 = false;
        goto L88
    L95:
        TextView r33 = this.$this_run.e1();
        if (r33 == null) goto L98;
        r33.setText(this.$context.getString(2131904190) + ' ' + r15.getUserName());
        goto L98
    L39:
        if (com.larus.platform.service.z2.a.g1() == false) goto L62;
        if (r5 == null) goto L62;
        CommonSettingFragment r34 = this.this$0;
        if (r34.h != null) goto L44;
        r34.h = r15.h(r34);
    L44:
        CommonSettingFragment r35 = this.this$0;
        com.larus.platform.api.n4 r36 = r35.h;
        if (r36 == null) goto L61;
        com.larus.bmhome.setting.c r37 = r35.g;
        if (r37 == null) goto L49;
        View r38 = r37.P0();
    L51:
        if (r38 != this.$this_run.P0()) goto L61;
        View r39 = r36.getView();
        if (r39.getParent() == r5) goto L60;
        ViewParent r40 = r39.getParent();
        if ((r40 instanceof ViewGroup) == false) goto L57;
        r2 = (ViewGroup) r40;
    L57:
        if (r2 == null) goto L59;
        r2.removeView(r39);
    L59:
        r5.removeAllViews();
        r5.addView(r39);
    L60:
        com.larus.utils.e1.x(r5);
        r36.J(false);
        goto L68
    L49:
        r38 = null;
    L61:
        com.larus.utils.e1.o(r5);
    L129:
        return Unit.INSTANCE;
    L24:
        r14 = null;
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        RelativeLayout r116 = this.$this_run.d1();
        if (r116 == null) goto L11;
        com.larus.utils.e1.x(r116);
    L11:
        AccountService r117 = AccountService.a;
        this.label = 1;
        r11 = r117.e("settings_page", this);
        if (r11 != r0) goto L15;
        return r0;
    }
}
