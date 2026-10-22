package com.larus.community.impl.publish;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishSetLayoutBinding;
import com.larus.community.impl.publish.viewmodel.CreationPublishViewModel;
import com.larus.doc.sdk.impl.v2.plugins.snapshot.DocShotConsts;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.service.z2;
import com.larus.ugc.community.adapter.RefViewAdapter;
import com.larus.utils.e1;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishSetComponent$initView$1", f = "CreationPublishSetComponent.kt", i = {}, l = {DocShotConsts.INPUT_VIEW_HEIGHT}, m = "invokeSuspend", n = {}, s = {})
final class CreationPublishSetComponent$initView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationPublishSetComponent this$0;

    /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishSetComponent$initView$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/community/impl/publish/viewmodel/PublishCreationState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishSetComponent$initView$1$1", f = "CreationPublishSetComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.community.impl.publish.viewmodel.h, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationPublishSetComponent this$0;

        public AnonymousClass1(CreationPublishSetComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.larus.community.impl.publish.viewmodel.h r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.larus.community.impl.publish.viewmodel.h) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L177;
            ResultKt.throwOnFailure(r14);
            com.larus.community.impl.publish.viewmodel.h r15 = (com.larus.community.impl.publish.viewmodel.h) this.L$0;
            if (r15 != null) goto L7;
        L9:
            boolean r1 = false;
        L11:
            if (r1 == false) goto L148;
            final PublisherCreation r16 = r15.a;
            if (r16 == null) goto L148;
            final CreationPublishSetComponent r2 = this.this$0;
            LarusCommunityCreationPublishSetLayoutBinding r3 = r2.p;
            if (r3 == null) goto L19;
            View r4 = r3.f;
            if (r4 == null) goto L19;
            e1.o(r4);
        L19:
            LarusCommunityCreationPublishSetLayoutBinding r5 = r2.p;
            if (r5 == null) goto L24;
            View r6 = r5.g;
            if (r6 == null) goto L24;
            e1.o(r6);
        L24:
            LarusCommunityCreationPublishSetLayoutBinding r7 = r2.p;
            if (r7 == null) goto L29;
            ConstraintLayout r8 = r7.c;
            if (r8 == null) goto L29;
            j19.c.f(r8);
        L29:
            LarusCommunityCreationPublishSetLayoutBinding r9 = r2.p;
            if (r9 == null) goto L34;
            View r10 = r9.l;
            if (r10 == null) goto L34;
            j19.c.f(r10);
        L34:
            LarusCommunityCreationPublishSetLayoutBinding r11 = r2.p;
            if (r11 == null) goto L39;
            ConstraintLayout r12 = r11.b;
            if (r12 == null) goto L39;
            j19.c.f(r12);
        L39:
            boolean r13 = r16.hasRefResource();
            if (r13 == true) goto L61;
            LarusCommunityCreationPublishSetLayoutBinding r17 = r2.p;
            if (r17 == null) goto L46;
            View r18 = r17.d;
            if (r18 == null) goto L46;
            e1.o(r18);
        L46:
            LarusCommunityCreationPublishSetLayoutBinding r20 = r2.p;
            if (r20 == null) goto L51;
            RecyclerView r21 = r20.h;
            if (r21 == null) goto L51;
            e1.o(r21);
        L51:
            LarusCommunityCreationPublishSetLayoutBinding r22 = r2.p;
            if (r22 == null) goto L56;
            View r23 = r22.l;
            if (r23 == null) goto L56;
            e1.o(r23);
        L56:
            LarusCommunityCreationPublishSetLayoutBinding r24 = r2.p;
            if (r24 == null) goto L61;
            ConstraintLayout r25 = r24.b;
            if (r25 == null) goto L61;
            e1.o(r25);
        L61:
            final String r26 = r16.getPrompt();
            if (r26 == null) goto L132;
            LarusCommunityCreationPublishSetLayoutBinding r27 = r2.p;
            if (r27 == null) goto L127;
            TextView r28 = r27.k;
            if (r28 == null) goto L127;
            if (z2.a.F3() == false) goto L125;
            Integer r30 = r16.getCreationType();
            if (r30 != null) goto L73;
        L74:
            if (r30 != null) goto L77;
        L78:
            if (r30 != null) goto L81;
        L83:
            if (r30 != null) goto L86;
        L87:
            if (r30 != null) goto L90;
        L91:
            if (r30 != null) goto L94;
        L95:
            if (r30 != null) goto L98;
        L99:
            if (r30 != null) goto L102;
        L103:
            if (r30 != null) goto L106;
        L107:
            if (r30 != null) goto L110;
        L112:
            if (r30 != null) goto L115;
        L117:
            if (r30 != null) goto L120;
        L122:
            String r31 = r2.getContext().getString(2131906514) + r16.getPrompt();
        L126:
            r28.setText(r31);
            goto L127
        L120:
            if (r30.intValue() != 3) goto L122;
            r31 = r2.getContext().getString(2131906027) + r16.getPrompt();
            goto L126
        L115:
            if (r30.intValue() != 1) goto L117;
            r31 = r2.getContext().getString(2131906026) + r16.getPrompt();
            goto L126
        L110:
            if (r30.intValue() != 12) goto L112;
        L123:
            r31 = r2.getContext().getString(2131906028) + r16.getPrompt();
            goto L126
        L106:
            if (r30.intValue() == 11) goto L123;
        L102:
            if (r30.intValue() == 10) goto L123;
        L98:
            if (r30.intValue() == 8) goto L123;
        L94:
            if (r30.intValue() == 9) goto L123;
        L90:
            if (r30.intValue() == 6) goto L123;
        L86:
            if (r30.intValue() == 7) goto L123;
        L81:
            if (r30.intValue() != 4) goto L83;
        L124:
            r31 = r2.getContext().getString(2131906025) + r16.getPrompt();
            goto L126
        L77:
            if (r30.intValue() == 2) goto L124;
        L73:
            if (r30.intValue() == 5) goto L124;
        L125:
            r31 = r2.getContext().getString(2131906514) + r16.getPrompt();
        L127:
            LarusCommunityCreationPublishSetLayoutBinding r32 = r2.p;
            if (r32 == null) goto L132;
            TextView r33 = r32.k;
            if (r33 == null) goto L132;
            r33.setOnLongClickListener(new q(r26, r2, r16));
        L132:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), null, null, new CreationPublishSetComponent$handlePublishInfoValid$2(r2, null), 3, null);
            if (r13 == false) goto L144;
            LarusCommunityCreationPublishSetLayoutBinding r110 = r2.p;
            if (r110 == null) goto L139;
            TextView r111 = r110.j;
            if (r111 == null) goto L139;
            r111.setText(r2.getContext().getString(2131899481));
        L139:
            LarusCommunityCreationPublishSetLayoutBinding r112 = r2.p;
            if (r112 == null) goto L144;
            CustomSwitchCompat r113 = r112.i;
            if (r113 == null) goto L144;
            r113.setThumbResource(2131239770);
            r113.setTrackResource(2131239772);
            r113.setOnCheckedChangeListener(new r(r2));
            r113.setChecked(true);
        L144:
            n29.a r114 = (n29.a) s1a.d.a(r2).getAbility(n29.a.class);
            if (r114 == null) goto L147;
            r114.Hb();
        L147:
            m29.a.c("CreationPublishSetComponent", "handlePublishInfoValid");
        L175:
            return Unit.INSTANCE;
        L148:
            CreationPublishSetComponent r115 = this.this$0;
            LarusCommunityCreationPublishSetLayoutBinding r0 = r115.p;
            if (r0 == null) goto L153;
            View r34 = r0.f;
            if (r34 == null) goto L153;
            w0.e(r34, i5.Y());
            j19.c.f(r34);
        L153:
            LarusCommunityCreationPublishSetLayoutBinding r35 = r115.p;
            if (r35 == null) goto L158;
            View r36 = r35.g;
            if (r36 == null) goto L158;
            w0.e(r36, i5.Y());
            j19.c.f(r36);
        L158:
            LarusCommunityCreationPublishSetLayoutBinding r37 = r115.p;
            if (r37 == null) goto L163;
            ConstraintLayout r38 = r37.c;
            if (r38 == null) goto L163;
            e1.o(r38);
        L163:
            LarusCommunityCreationPublishSetLayoutBinding r40 = r115.p;
            if (r40 == null) goto L168;
            View r41 = r40.l;
            if (r41 == null) goto L168;
            e1.o(r41);
        L168:
            LarusCommunityCreationPublishSetLayoutBinding r116 = r115.p;
            if (r116 == null) goto L173;
            ConstraintLayout r117 = r116.b;
            if (r117 == null) goto L173;
            e1.o(r117);
        L173:
            m29.a.c("CreationPublishSetComponent", "handlePublishInfoLoading");
            goto L175
        L7:
            if (r15.b != true) goto L9;
            r1 = true;
            goto L11
        L177:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationPublishSetComponent$initView$1(CreationPublishSetComponent r1, Continuation<? super CreationPublishSetComponent$initView$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationPublishSetComponent$initView$1(this.this$0, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CreationPublishSetComponent r8 = this.this$0;
        LarusCommunityCreationPublishSetLayoutBinding r2 = r8.p;
        if (r2 == null) goto L11;
        RefViewAdapter r3 = new RefViewAdapter(new o());
        r8.q = r3;
        r2.h.setAdapter(r3);
        r2.h.setLayoutManager(new LinearLayoutManager(r8.getContext(), 0, false));
        r2.h.addItemDecoration(new CreationPublishSetComponent$initRefViews$1$2());
    L11:
        i1<com.larus.community.impl.publish.viewmodel.h> r9 = ((CreationPublishViewModel) this.this$0.m.getValue()).getPublisherCreationFlow();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r9, r4, this) != r0) goto L15;
        return r0;
    }
}
