package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGiftPanelIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CounterData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemDataType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LongClickGiftPanelIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnDialogFullyShowed;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollToPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicPagerListData;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006*\u001e\u0012\u0004\u0012\u00020\u00010\u0000R\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/anya/dsl/l$a;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$Idle;", "Lcom/bytedance/android/anya/dsl/l;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftVerticalState;", "Lcom/bytedance/android/anya/r;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftAction;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/anya/dsl/l$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class GiftMVIVerticalListViewModel$buildStateMachine$1 extends Lambda implements Function1<com.bytedance.android.anya.dsl.l<GiftVerticalState, r, GiftAction>.a<GiftListBusinessState.Idle>, Unit> {
    final /* synthetic */ GiftMVIVerticalListViewModel this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftMVIVerticalListViewModel$buildStateMachine$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/android/anya/l0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftVerticalState;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnDialogFullyShowed;", "a", "state", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$Idle;", "businessState", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/anya/l0;Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnDialogFullyShowed;Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftVerticalState;Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$Idle;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function4<l0<GiftVerticalState>, OnDialogFullyShowed, GiftVerticalState, GiftListBusinessState.Idle, Unit> {
        final /* synthetic */ GiftMVIVerticalListViewModel$buildStateMachine$1 this$0;

        public AnonymousClass3(GiftMVIVerticalListViewModel$buildStateMachine$1 r1) {
            this.this$0 = r1;
            super(4);
        }

        public final void invoke(l0<GiftVerticalState> r33, OnDialogFullyShowed r34, GiftVerticalState r35, GiftListBusinessState.Idle r36) {
            Intrinsics.checkNotNullParameter(r33, "$receiver");
            Intrinsics.checkNotNullParameter(r34, "a");
            Intrinsics.checkNotNullParameter(r35, "state");
            Intrinsics.checkNotNullParameter(r36, "businessState");
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h r0 = this.this$0.this$0.z;
            LocateGiftInfo r3 = r34.getLocateGiftInfo();
            int r4 = this.this$0.this$0.P1.N0();
            r0.getClass();
            LocateGiftInfo r1 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h.c(r3, r4);
            this.this$0.this$0.z.d(r33, r35, r1, r34.toString());
            final r r10 = r33.i(r35);
            if (this.this$0.this$0.Y.getTargetGiftId() <= 0) goto L5;
            boolean r13 = true;
        L6:
            final Ref.BooleanRef r14 = new Ref.BooleanRef();
            r14.element = false;
            final Ref.IntRef r15 = new Ref.IntRef();
            r15.element = 0;
            if ((r10 instanceof GiftListBusinessState.GiftSelected) == false) goto L73;
            u1 r2 = this.this$0.this$0.b1;
            if (r2 == null) goto L15;
            int r5 = com.bytedance.android.livesdk.gift.platform.core.model.k.f;
            vz1.e r6 = ((GiftListBusinessState.GiftSelected) r10).getIconModel();
            if (r6 == null) goto L13;
            com.bytedance.android.livesdk.gift.platform.core.model.k r7 = r6.x;
        L14:
            r2.g = com.bytedance.android.livesdk.gift.platform.core.model.k.a.a(r7);
            goto L15
        L13:
            r7 = null;
        L15:
            GiftMVIVerticalListViewModel r8 = this.this$0.this$0;
            GiftListBusinessState.GiftSelected r16 = (GiftListBusinessState.GiftSelected) r10;
            int r9 = r16.getSelectedPagePosition();
            ((Number) com.bytedance.android.anya.h.b(r35.getCurrentPagePosition())).intValue();
            GiftMVIVerticalListViewModel.e3(r8, r33, r35, r9, false, "click", false, 40);
            this.this$0.this$0.K0(new ScrollToPositionEffect(r16.getSelectedPagePosition(), r16.getSelectedPosition(), r16.getSelectCounterPosition(), r16.getTopicPagerPosition(), true, false, 32, null));
            l0.a r11 = l0.e(r35.getPanelList(), r16.getSelectedPagePosition());
            l0 r17 = r11.b;
            final PagerListData r18 = (PagerListData) r11.a;
            k0 r19 = r17.b;
            t0<PagerListData, ItemListData> r20 = r18.getItemDataList();
            r19.getClass();
            List r21 = k0.c(r20);
            ArrayList r23 = new ArrayList();
            Iterator r24 = r21.iterator();
        L17:
            if (r24.hasNext() == false) goto L24;
            Object r25 = r24.next();
            if (((ItemDataType) com.bytedance.android.anya.h.b(((ItemListData) r25).getItemDataType())) != ItemDataType.NORMAL_ITEM) goto L21;
            boolean r26 = true;
        L22:
            if (r26 == false) goto L17;
            r23.add(r25);
            goto L17
        L21:
            r26 = false;
            goto L22
        L24:
            final int r30 = r23.size();
            if (r16.getSelectCounterPosition() == (-1)) goto L27;
        L29:
            int r110 = -1;
        L31:
            if (r16.getSelectCounterPosition() == r110) goto L42;
            if (r16.getSelectCounterPosition() >= com.bytedance.android.anya.h.a(r18.getCounterDataList())) goto L42;
            l0.a r27 = l0.e(r18.getCounterDataList(), r16.getSelectCounterPosition());
            l0 r28 = r27.b;
            CounterData r29 = (CounterData) r27.a;
            int r31 = r16.getSelectedPosition();
            t0<CounterData, ItemListData> r37 = r29.getItemDataList();
            r28.getClass();
            if (r31 >= com.bytedance.android.anya.h.a(r37)) goto L42;
            l0.a r38 = l0.e(r29.getItemDataList(), r16.getSelectedPosition());
            l0 r39 = r38.b;
            ItemListData r40 = (ItemListData) r38.a;
            GiftMVIVerticalListViewModel r41 = this.this$0.this$0;
            u1 r43 = r41.b1;
            DataCenter r44 = r41.p0;
            IRoom r210 = r41.k0.getRoom();
            String r211 = this.this$0.this$0.H2.a.getIdString();
            r0<PagerListData, Integer> r45 = r18.getTabType();
            r39.getClass();
            int r212 = ((Number) com.bytedance.android.anya.h.b(r45)).intValue();
            if (((Number) com.bytedance.android.anya.h.b(r18.getTabType())).intValue() != 5) goto L39;
            boolean r213 = true;
        L40:
            r43.e0(r44, r210, r211, r212, r213, ((vz1.e) com.bytedance.android.anya.h.b(r40.getItemData())).b, r16.getSelectedPagePosition(), this.this$0.this$0.p1.j(), this.this$0.this$0.H2.c, r30);
            goto L42
        L39:
            r213 = false;
        L42:
            if (r16.getTopicPagerPosition() != r110) goto L44;
        L52:
            long r46 = this.this$0.this$0.Y.getTargetGiftId();
            vz1.e r47 = r16.getIconModel();
            if (r47 != null) goto L55;
        L57:
            if (r13 == true) goto L59;
        L65:
            if (r13 == false) goto L75;
            boolean r48 = d0.a;
            long r49 = this.this$0.this$0.Y.getTargetGiftId();
            int r50 = this.this$0.this$0.Y.getTargetPageType();
            GiftMVIVerticalListViewModel r51 = this.this$0.this$0;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r53 = r51.H2;
            d0.d(false, r49, r50, r53.a, r51.v1.f(r53.b));
            return;
        L75:
            return;
        L59:
            if (r14.element == false) goto L65;
            boolean r54 = d0.a;
            long r55 = this.this$0.this$0.Y.getTargetGiftId();
            Map<Integer, Integer> r56 = this.this$0.this$0.L0.c;
            LinkedHashMap r57 = (LinkedHashMap) r56;
            Integer r58 = (Integer) r57.get(Integer.valueOf(r15.element));
            if (r58 == null) goto L63;
            int r59 = r58.intValue();
        L64:
            GiftMVIVerticalListViewModel r60 = this.this$0.this$0;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r61 = r60.H2;
            d0.d(true, r55, r59, r61.a, r60.v1.f(r61.b));
            return;
        L63:
            r59 = 0;
            goto L64
        L55:
            if (r46 != r47.b) goto L57;
            r14.element = true;
            r15.element = r16.getSelectedPagePosition();
            goto L57
        L44:
            if (r16.getTopicPagerPosition() >= com.bytedance.android.anya.h.a(r18.getTopicPagerListData())) goto L52;
            l0.a r63 = l0.e(r18.getTopicPagerListData(), r16.getTopicPagerPosition());
            l0 r64 = r63.b;
            TopicPagerListData r65 = (TopicPagerListData) r63.a;
            int r66 = r16.getSelectedPosition();
            t0<TopicPagerListData, ItemListData> r67 = r65.getItemDataList();
            r64.getClass();
            if (r66 >= com.bytedance.android.anya.h.a(r67)) goto L52;
            l0.a r68 = l0.e(r65.getItemDataList(), r16.getSelectedPosition());
            l0 r69 = r68.b;
            ItemListData r70 = (ItemListData) r68.a;
            GiftMVIVerticalListViewModel r71 = this.this$0.this$0;
            u1 r73 = r71.b1;
            DataCenter r74 = r71.p0;
            IRoom r214 = r71.k0.getRoom();
            String r215 = this.this$0.this$0.H2.a.getIdString();
            r0<PagerListData, Integer> r75 = r18.getTabType();
            r69.getClass();
            int r216 = ((Number) com.bytedance.android.anya.h.b(r75)).intValue();
            if (((Number) com.bytedance.android.anya.h.b(r18.getTabType())).intValue() != 5) goto L50;
            boolean r217 = true;
        L51:
            r73.e0(r74, r214, r215, r216, r217, ((vz1.e) com.bytedance.android.anya.h.b(r70.getItemData())).b, r16.getSelectedPagePosition(), this.this$0.this$0.p1.j(), this.this$0.this$0.H2.c, r30);
            goto L52
        L50:
            r217 = false;
            goto L51
        L27:
            if (r16.getTopicPagerPosition() != (-1)) goto L29;
            l0.a r76 = l0.e(r18.getItemDataList(), r16.getSelectedPosition());
            final l0 r77 = r76.b;
            final ItemListData r78 = (ItemListData) r76.a;
            GiftPanelBizBoostUtils.E.getClass();
            r110 = -1;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(GiftPanelBizBoostUtils.b().y0(), new GiftMVIVerticalListViewModel$buildStateMachine$1$3$$special$$inlined$invoke$lambda$2(r77, r78, r18, r30, this, r10, r14, r15));
            goto L31
        L73:
            return;
        L5:
            r13 = false;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((l0) r1, (OnDialogFullyShowed) r2, (GiftVerticalState) r3, (GiftListBusinessState.Idle) r4);
            return Unit.INSTANCE;
        }
    }

    public GiftMVIVerticalListViewModel$buildStateMachine$1(GiftMVIVerticalListViewModel r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.anya.dsl.l<GiftVerticalState, r, GiftAction>.a<GiftListBusinessState.Idle> r5) {
        Intrinsics.checkNotNullParameter(r5, "$receiver");
        final Function4<l0<GiftVerticalState>, ClickGiftPanelIcon, GiftVerticalState, GiftListBusinessState.Idle, Unit> r0 = new AnonymousClass1(this);
        r5.a.put(ClickGiftPanelIcon.class, new GiftMVIVerticalListViewModel$buildStateMachine$1$$special$$inlined$on$1(r0));
        final Function4<l0<GiftVerticalState>, LongClickGiftPanelIcon, GiftVerticalState, GiftListBusinessState.Idle, Unit> r1 = new AnonymousClass2(this);
        r5.a.put(LongClickGiftPanelIcon.class, new GiftMVIVerticalListViewModel$buildStateMachine$1$$special$$inlined$on$2(r1));
        final AnonymousClass3 r2 = new AnonymousClass3(this);
        r5.a.put(OnDialogFullyShowed.class, new GiftMVIVerticalListViewModel$buildStateMachine$1$$special$$inlined$on$3(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.anya.dsl.l.a) r1);
        return Unit.INSTANCE;
    }
}
