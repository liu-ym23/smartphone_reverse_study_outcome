package com.ss.android.lark.keyboard.biz.mention;

import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.FlowMentionDoubaoTip$loadDoubaoAvatarIfNeed$1", f = "FlowMentionDoubaoTip.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class FlowMentionDoubaoTip$loadDoubaoAvatarIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j.b $holder;
    int label;
    final /* synthetic */ j this$0;

    public FlowMentionDoubaoTip$loadDoubaoAvatarIfNeed$1(j r1, j.b r2, Continuation<? super FlowMentionDoubaoTip$loadDoubaoAvatarIfNeed$1> r3) {
        this.this$0 = r1;
        this.$holder = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowMentionDoubaoTip$loadDoubaoAvatarIfNeed$1(this.this$0, this.$holder, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Chatter r8 = (Chatter) r7;
        if (r8 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (this.this$0.e != this.$holder) goto L18;
        String r3 = r8.getAvatarKey();
        String r4 = r8.getId();
        if (r3.length() != 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == true) goto L42;
        if (r4.length() == 0) goto L28;
        r2 = false;
    L28:
        if (r2 == true) goto L42;
        this.this$0.getClass();
        itb.a r6 = OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r6 == null) goto L34;
        String r9 = r6.i();
        if (r9 == null) goto L34;
    L35:
        String r10 = com.ss.android.lark.chat.utils.m.b(r8, ChatterNameDisplayRule.ALIAS_NAME, false);
        if (r10 == null) goto L39;
        r9 = r10;
    L39:
        TextView r11 = this.$holder.d;
        String r12 = UIUtils.getString(this.this$0.d, 2131890150);
        ICUUtils.FormatArgsBuilder r13 = new ICUUtils.FormatArgsBuilder();
        r13.b("brandName", r9);
        r11.setText(ICUUtils.icuFormat(r12, r13.a));
        TextView r14 = this.$holder.e;
        String r15 = UIUtils.getString(this.this$0.d, 2131890149);
        ICUUtils.FormatArgsBuilder r16 = new ICUUtils.FormatArgsBuilder();
        r16.b("brandName", r9);
        r14.setText(ICUUtils.icuFormat(r15, r16.a));
        int r17 = UIUtils.dp2px(this.$holder.a.getContext(), 72.0f);
        LoadParams r18 = new LoadParams();
        r18.a = r17;
        r18.b = r17;
        ImageModule.a(this.$holder.a.getContext(), this.$holder.c, r3, r4, r18);
        return Unit.INSTANCE;
    L34:
        r9 = "";
    L42:
        return Unit.INSTANCE;
    L22:
        r5 = false;
        goto L23
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        KeyboardModel r19 = (KeyboardModel) this.this$0.f.getValue();
        SyncDataStrategy r20 = SyncDataStrategy.TRY_LOCAL;
        this.label = 1;
        r7 = r19.a(r20, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
