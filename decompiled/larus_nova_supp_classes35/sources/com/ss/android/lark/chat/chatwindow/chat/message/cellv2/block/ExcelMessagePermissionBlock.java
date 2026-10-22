package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.preview.components.view.SpinButton;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExcelMessagePermissionBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public static final /* synthetic */ int p = 0;
    public final IMMessageKeys$Blocks g;
    public final ArrayList<String> h;
    public final Map<String, String> i;
    public final jdb.g j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;

    public static final class a implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final TextView b;
        public final SpinButton c;

        public final View getView() {
            return this.a;
        }

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = (TextView) r2.findViewById(2131371840);
            this.c = (SpinButton) r2.findViewById(2131371838);
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$update$1", f = "ExcelMessagePermissionBlock.kt", i = {}, l = {101, 109}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $blockView;
        final /* synthetic */ y6b.c<?> $item;
        final /* synthetic */ com.ss.android.lark.blueprint.q<y6b.a<?>> $layout;
        int label;
        final /* synthetic */ ExcelMessagePermissionBlock this$0;

        public AnonymousClass1(ExcelMessagePermissionBlock r1, a r2, y6b.c<?> r3, com.ss.android.lark.blueprint.q<y6b.a<?>> r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$blockView = r2;
            this.$item = r3;
            this.$layout = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$blockView, this.$item, this.$layout, r8);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L52:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L14:
            if (Intrinsics.areEqual(this.$blockView.a.getTag(2131372397), Boxing.boxInt(1)) == false) goto L50;
            ExcelMessagePermissionBlock r12 = this.this$0;
            a r2 = this.$blockView;
            Boolean r3 = Boxing.boxBoolean(this.$item.i);
            int r5 = ExcelMessagePermissionBlock.p;
            r12.getClass();
            TextView r6 = r2.b;
            r6.setVisibility(0);
            if (h18.f.a(r12.getContext()) == false) goto L19;
            r6.setTextColor(com.ss.android.lark.chat.utils.p.b(r12.getContext()));
        L19:
            if (r12.c.isAIChat() == false) goto L26;
            boolean r4 = Intrinsics.areEqual(r2.a.getTag(2131372419), 1);
            Context r13 = r12.getContext();
            if (r4 == false) goto L23;
            String r14 = r13.getString(2131890688);
        L24:
            r6.setText(r14);
        L43:
            if (this.$item.i == true) goto L45;
        L49:
            this.$blockView.c.setVisibility(8);
            goto L52
        L45:
            if (this.this$0.c.isAIChat() == true) goto L49;
            ExcelMessagePermissionBlock r15 = this.this$0;
            a r7 = this.$blockView;
            y6b.c<?> r8 = this.$item;
            this.label = 2;
            if (ExcelMessagePermissionBlock.h(r15, r7, r8, this) != r0) goto L52;
            return r0;
        L23:
            r14 = r13.getString(2131890689);
            goto L24
        L26:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L28;
            boolean r9 = Intrinsics.areEqual(r2.a.getTag(2131372419), 1);
            Context r16 = r12.getContext();
            if (r9 == false) goto L40;
            String r17 = r16.getString(2131890688);
        L41:
            r6.setText(r17);
            goto L43
        L40:
            r17 = r16.getString(2131890689);
            goto L41
        L28:
            if (r12.c.isGroup() == false) goto L31;
            r6.setText(r12.getContext().getString(2131890358));
            goto L43
        L31:
            if (r12.c.d() == false) goto L43;
            Chat r18 = r12.c.getChat();
            if (r18 == null) goto L35;
            String r19 = r18.getName();
        L36:
            r6.setText(r19);
            goto L43
        L35:
            r19 = null;
            goto L36
        L50:
            ExcelMessagePermissionBlock r110 = this.this$0;
            r110.g(this.$layout, r110.g, IMMessageKeys$Slots.FOOTER);
            goto L52
        L10:
            ResultKt.throwOnFailure(r11);
            ExcelMessagePermissionBlock r111 = this.this$0;
            a r10 = this.$blockView;
            y6b.c<?> r20 = this.$item;
            this.label = 1;
            int r21 = ExcelMessagePermissionBlock.p;
            if (r111.k(r10, r20, this) != r0) goto L14;
            return r0;
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ExcelMessagePermissionBlock(com.ss.android.lark.blueprint.g r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        super(r4);
        this.g = IMMessageKeys$Blocks.EXCEL_PERMISSION;
        ArrayList<String> r5 = new ArrayList();
        this.h = r5;
        LinkedHashMap r0 = new LinkedHashMap();
        this.i = r0;
        this.j = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).C();
        this.k = BuildConfig.FLAVOR;
        this.l = BuildConfig.FLAVOR;
        r5.add(getContext().getString(2131890665));
        r5.add(getContext().getString(2131890667));
        r0.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        r0.put("application/vnd.ms-excel", "xls");
    }

    public final String i(y6b.c<?> r2) {
        if (r2 == null) goto L4;
        Object r3 = r2.o;
    L6:
        if ((r3 instanceof FileContentVO) == false) goto L9;
        FileContentVO r4 = (FileContentVO) r3;
        this.k = r4.e();
        Map<String, String> r0 = this.i;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        this.l = String.valueOf(r1.get((String) r4.r.getValue()));
    L9:
        return this.k;
    L4:
        r3 = null;
        goto L6
    }

    public final void j(a r11) {
        Object r0 = r11.a.getTag(2131368313);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
        int r1 = ((Integer) r0).intValue();
        Log.i("ExcelMessagePermissionBlock", "setSpinButtonData: index = " + r1);
        int r9 = (int) (((float) UIHelper.dp2px(10.0f)) * zz7.b.d().getMultiplier());
        r11.c.c((String) ListProtector.get(this.h, r1), null, new FontLevel(FontType.BODY, 2), null, 2131254256, r9, r9);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.FOOTER);
    }

    public final Object k(a r12, y6b.c<?> r13, Continuation<? super Unit> r14) {
        String r0 = i(r13);
        r12.a.setTag(2131372414, r0);
        SafeContinuation r1 = new SafeContinuation(IntrinsicsKt.intercepted(r14));
        Log.i("ExcelMessagePermissionBlock", "hasChangePermission() execute");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.c.getContext()), null, null, new ExcelMessagePermissionBlock$hasChangePermission$2$1(r12, this, r13, r1, null), 3, null);
        Object r15 = r1.getOrThrow();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L6:
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        r15 = Unit.INSTANCE;
    L10:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r15;
    L13:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r12, com.ss.android.lark.blueprint.q<y6b.a<?>> r13, y6b.a<?> r14) {
        Intrinsics.checkNotNullParameter(r12, "cell");
        Intrinsics.checkNotNullParameter(r13, "layout");
        Intrinsics.checkNotNullParameter(r14, Keys.API_RETURN_KEY_DATA);
        if ((r14 instanceof y6b.c) == false) goto L5;
        y6b.c r4 = (y6b.c) r14;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        T r15 = r4.o;
        boolean r1 = false;
        if ((r15 instanceof FileContentVO) == false) goto L36;
        FileContentVO r16 = (FileContentVO) r15;
        String r17 = r16.f();
        boolean r2 = com.ss.android.lark.chat.utils.s.b(this.j, r17);
        boolean r0 = MessagePermissionUtil.f(r4, this.c.getChat(), null);
        StringBuilder r3 = new StringBuilder("canShowBlock: name = ");
        r3.append(r17);
        r3.append(", filePreviewEnable = ");
        r3.append(r2);
        r3.append(", hasFileReadPerm = ");
        r3.append(r0);
        r3.append("hasPreviewBodyAndUrl = ");
        r3.append(com.ss.android.lark.chat.utils.s.a(r16));
        r3.append("isAbilityUnsupport = ");
        FileContent.FileAbility r18 = (FileContent.FileAbility) r16.y.getValue();
        FileContent.FileAbility r5 = FileContent.FileAbility.SUPPORT_EDIT;
        if (r5 != r18) goto L13;
    L17:
        boolean r19 = false;
    L18:
        r3.append(r19);
        Log.i("ExcelMessagePermissionBlock", r3.toString());
        if (r2 == false) goto L36;
        if (com.ss.android.lark.chat.utils.s.a(r16) == false) goto L36;
        if (this.c.b0() == true) goto L36;
        if (r0 == false) goto L36;
        FileContent.FileAbility r110 = (FileContent.FileAbility) r16.y.getValue();
        if (r5 != r110) goto L28;
    L32:
        boolean r111 = false;
    L33:
        if (r111 == true) goto L36;
        r1 = true;
        goto L36
    L28:
        if (FileContent.FileAbility.SUPPORT_PREVIEW == r110) goto L32;
        if (FileContent.FileAbility.NOT_SUPPORT_PREVIEW == r110) goto L32;
        r111 = true;
        goto L33
    L13:
        if (FileContent.FileAbility.SUPPORT_PREVIEW == r18) goto L17;
        if (FileContent.FileAbility.NOT_SUPPORT_PREVIEW == r18) goto L17;
        r19 = true;
    L36:
        if (r1 == true) goto L39;
        g(r13, this.g, IMMessageKeys$Slots.FOOTER);
        return;
    L39:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.c.getContext()), null, null, new AnonymousClass1(this, (a) r13.c(this.g, IMMessageKeys$Slots.FOOTER, new ExcelMessagePermissionBlock$update$blockView$1(this)), r4, r13, null), 3, null);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }

    public static final Object h(final ExcelMessagePermissionBlock r4, final a r5, final y6b.c r6, Continuation r7) {
        r4.getClass();
        if ((r7 instanceof ExcelMessagePermissionBlock$setupSpinButton$1) == false) goto L7;
        ExcelMessagePermissionBlock$setupSpinButton$1 r0 = (ExcelMessagePermissionBlock$setupSpinButton$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        SpinButton r9 = (SpinButton) r0.L$2;
        r6 = (y6b.c) r0.L$1;
        a r10 = (a) r0.L$0;
        ResultKt.throwOnFailure(r8);
        final SpinButton r11 = r9;
        r5 = r10;
    L17:
        r4.j(r5);
        r11.setOnClickListener(new ExcelMessagePermissionBlock$setupSpinButton$2(r4, r5, r6, r11));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r11 = r5.c;
        r11.setVisibility(0);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.L$2 = r11;
        r0.label = 1;
        if (r4.k(r5, r6, r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new ExcelMessagePermissionBlock$setupSpinButton$1(r4, r7);
        goto L8
    }
}
