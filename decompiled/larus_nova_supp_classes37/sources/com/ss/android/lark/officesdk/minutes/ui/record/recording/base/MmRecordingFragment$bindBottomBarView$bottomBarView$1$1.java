package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.content.MmRecordingContentController;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.k;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.m;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.w;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.y;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingFragment$bindBottomBarView$bottomBarView$1$1 extends FunctionReferenceImpl implements Function1<l, Boolean> {
    public MmRecordingFragment$bindBottomBarView$bottomBarView$1$1(Object r8) {
        super(1, r8, MmRecordingFragment.class, "goToSubtitle", "goToSubtitle(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteSubtitleNavigationRequest;)Z", 0);
    }

    public final Boolean invoke(l r22) {
        Intrinsics.checkNotNullParameter(r22, "p0");
        MmRecordingFragment r0 = (MmRecordingFragment) ((CallableReference) this).receiver;
        int r1 = MmRecordingFragment.J;
        r0.getClass();
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "goToSubtitle", "request=" + r22, r0.U90());
        if (r0.ka0() == false) goto L217;
        MmRecordingContentController r10 = r0.p;
        if (r10 == null) goto L214;
        Intrinsics.checkNotNullParameter(r22, "request");
        Iterator<? extends com.ss.android.lark.officesdk.minutes.ui.record.recording.content.h> r3 = r10.l.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L16;
        if (r3.next().getTabType() != MmRecordingUITab.SUBTITLE) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L14;
        r4 = r4 + 1;
        goto L8
    L14:
        int r12 = r4;
    L17:
        if (r12 >= 0) goto L19;
        int r6 = bwb.b.a;
        bwb.b.h(MmUiLogScene.CONTENT, "goToSubtitle", "subtitle tab missing, request=" + r22, r10.c());
    L149:
        boolean r7 = false;
    L209:
        if (r7 != true) goto L214;
        boolean r8 = true;
    L215:
        if (r8 == false) goto L217;
        boolean r9 = true;
    L219:
        return Boolean.valueOf(r9);
    L19:
        MmRecordingViewModel r11 = r10.d;
        if (r11 == null) goto L28;
        MmRecordingSubtitleRepo r13 = r11.getSubtitleRepo();
        if (r13 == null) goto L28;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a r14 = r13.l();
        if (r14 == null) goto L28;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d r15 = r14.m();
        if (r15 == null) goto L28;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h> r16 = r15.a;
    L29:
        if (r16 != null) goto L31;
        r16 = CollectionsKt.emptyList();
    L31:
        boolean r17 = r22 instanceof l.b;
        if (r17 == false) goto L56;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r16.iterator();
    L35:
        if (r19.hasNext() == false) goto L43;
        Object r110 = r19.next();
        int r111 = r12;
        MmRecordingContentController r112 = r10;
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r110).c > ((l.b) r22).a) goto L39;
        boolean r20 = true;
    L40:
        if (r20 == false) goto L42;
        r18.add(r110);
    L42:
        r12 = r111;
        r10 = r112;
        goto L35
    L39:
        r20 = false;
        goto L40
    L43:
        MmRecordingContentController r113 = r10;
        int r114 = r12;
        Iterator r21 = r18.iterator();
        if (r21.hasNext() == true) goto L46;
        Object r23 = null;
    L55:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r24 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r23;
    L105:
        int r25 = bwb.b.a;
        MmUiLogScene r26 = MmUiLogScene.CONTENT;
        StringBuilder r27 = new StringBuilder("hasTarget=");
        if (r24 == null) goto L108;
        boolean r28 = true;
    L109:
        r27.append(r28);
        r27.append(", subtitleCount=");
        r27.append(r16.size());
        r27.append(", targetRelTime=");
        if (r24 == null) goto L112;
        Long r115 = Long.valueOf(r24.c);
    L113:
        r27.append(r115);
        String r116 = ", targetAbsTime=";
        r27.append(", targetAbsTime=");
        if (r24 == null) goto L116;
        Long r117 = Long.valueOf(r24.d);
    L117:
        r27.append(r117);
        r27.append(", request=");
        r27.append(r22);
        bwb.b.f(r26, "hasSubtitleJumpTarget", r27.toString(), r113.c());
        if (r24 == null) goto L120;
        boolean r29 = true;
    L121:
        if (r29 == true) goto L123;
        bwb.b.f(r26, "goToSubtitle", "skip switch, no subtitle target, request=" + r22, r113.c());
        goto L149
    L123:
        StringBuilder r30 = new StringBuilder("switch first, subtitlePosition=");
        int r118 = r114;
        r30.append(r118);
        r30.append(", currentItem=");
        MmRecordingContentController r119 = r113;
        r30.append(r119.a.b().getCurrentItem());
        r30.append(", request=");
        r30.append(r22);
        bwb.b.f(r26, "goToSubtitle", r30.toString(), r119.c());
        r119.f(MmRecordingUITab.SUBTITLE, "goToSubtitle");
        Fragment r31 = r119.c;
        if (r31 == null) goto L146;
        FragmentManager r32 = r31.getChildFragmentManager();
        if (r32 == null) goto L146;
        List r33 = r32.getFragments();
        if (r33 == null) goto L146;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r33.iterator();
    L131:
        if (r35.hasNext() == false) goto L135;
        Object r36 = r35.next();
        if ((r36 instanceof MmSubtitleFragment) == false) goto L131;
        r34.add(r36);
        goto L131
    L135:
        Iterator r37 = r34.iterator();
    L137:
        if (r37.hasNext() == false) goto L144;
        Object r38 = r37.next();
        if (((MmSubtitleFragment) r38).getView() == null) goto L141;
        boolean r39 = true;
    L142:
        if (r39 == false) goto L137;
    L145:
        MmSubtitleFragment r40 = (MmSubtitleFragment) r38;
    L147:
        if (r40 != null) goto L151;
        int r41 = bwb.b.a;
        bwb.b.h(MmUiLogScene.CONTENT, "goToSubtitle", "subtitle fragment missing after switch, request=" + r22, r119.c());
        goto L149
    L151:
        Intrinsics.checkNotNullParameter(r22, "request");
        mwb.i r42 = r40.m;
        if (r42 != null) goto L155;
        int r120 = r118;
        MmRecordingContentController r121 = r119;
    L205:
        r7 = false;
    L206:
        int r43 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "goToSubtitle", "after switch, jumped=" + r7 + ", request=" + r22, r121.c());
        if (r7 == false) goto L209;
        MmRecordingContentController r44 = r121;
        r44.a.b().post(new com.ss.android.lark.officesdk.minutes.ui.record.recording.content.b(r44, r22, r120));
        goto L209
    L155:
        if (r40.o != null) goto L157;
    L204:
        r120 = r118;
        r121 = r119;
        int r45 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUBTITLE, "goToSubtitle", "view not initialized, request=" + r22, r40.U90());
        goto L205
    L157:
        if (r40.v == null) goto L204;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h> r46 = r40.ga0().getState().b;
        if (r17 == false) goto L172;
        Iterable r47 = CollectionsKt.withIndex(r46);
        ArrayList r48 = new ArrayList();
        Iterator r49 = r47.iterator();
    L163:
        if (r49.hasNext() == false) goto L171;
        Object r122 = r49.next();
        int r123 = r118;
        MmRecordingContentController r124 = r119;
        mwb.i r210 = r42;
        String r125 = r116;
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r122).getValue()).c > ((l.b) r22).a) goto L167;
        boolean r50 = true;
    L168:
        if (r50 == false) goto L170;
        r48.add(r122);
    L170:
        r118 = r123;
        r119 = r124;
        r116 = r125;
        r42 = r210;
        goto L163
    L167:
        r50 = false;
        goto L168
    L171:
        mwb.i r211 = r42;
        String r126 = r116;
        r120 = r118;
        r121 = r119;
        IndexedValue r51 = (IndexedValue) CollectionsKt.maxWithOrNull(r48, new com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.j(new com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.g()));
    L196:
        if (r51 != null) goto L198;
        int r52 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUBTITLE, "goToSubtitle", "no subtitle target, subtitleCount=" + r46.size() + ", request=" + r22, r40.U90());
        goto L205
    L198:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r53 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r51.getValue();
        int r54 = r51.getIndex();
        int r55 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUBTITLE, "goToSubtitle", "targetPosition=" + r54 + ", targetRelTime=" + r53.c + r126 + r53.d + ", request=" + r22 + ", subtitleCount=" + r46.size(), r40.U90());
        r40.ga0().dispatchEvent(new y.c(MmSubtitleScrollMode.FREE));
        w r56 = r40.v;
        if (r56 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("stackFromEndController");
        r56 = null;
    L201:
        r56.e(true, "goToSubtitle");
        mwb.i r57 = r211;
        r57.b.stopScroll();
        r57.b.post(new m(r40, r54, r22, r53, r57));
        r7 = true;
        goto L206
    L172:
        r211 = r42;
        r126 = ", targetAbsTime=";
        r120 = r118;
        r121 = r119;
        if ((r22 instanceof l.a) == false) goto L203;
        Iterable r58 = CollectionsKt.withIndex(r46);
        ArrayList r59 = new ArrayList();
        Iterator r60 = r58.iterator();
    L176:
        if (r60.hasNext() == false) goto L183;
        Object r61 = r60.next();
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r61).getValue()).d <= 0) goto L180;
        boolean r127 = true;
    L181:
        if (r127 == false) goto L176;
        r59.add(r61);
        goto L176
    L180:
        r127 = false;
        goto L181
    L183:
        l.a r62 = (l.a) r22;
        if (r62.b == false) goto L186;
        r51 = (IndexedValue) CollectionsKt.minWithOrNull(r59, new k(new com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.h(r22)));
        goto L196
    L186:
        ArrayList r63 = new ArrayList();
        Iterator r64 = r59.iterator();
    L188:
        if (r64.hasNext() == false) goto L195;
        Object r128 = r64.next();
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r128).getValue()).d > r62.a) goto L192;
        boolean r129 = true;
    L193:
        if (r129 == false) goto L188;
        r63.add(r128);
        goto L188
    L192:
        r129 = false;
        goto L193
    L195:
        r51 = (IndexedValue) CollectionsKt.maxWithOrNull(r63, new com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.l(new com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.i()));
        goto L196
    L203:
        throw new NoWhenBranchMatchedException();
    L141:
        r39 = false;
        goto L142
    L144:
        r38 = null;
    L146:
        r40 = null;
        goto L147
    L120:
        r29 = false;
        goto L121
    L116:
        r117 = null;
        goto L117
    L112:
        r115 = null;
        goto L113
    L108:
        r28 = false;
        goto L109
    L46:
        r23 = r21.next();
        if (r21.hasNext() == false) goto L55;
        long r130 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r23).c;
    L50:
        Object r131 = r21.next();
        long r132 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r131).c;
        if (r130 >= r132) goto L54;
        r23 = r131;
        r130 = r132;
    L54:
        if (r21.hasNext() == true) goto L50;
    L56:
        r113 = r10;
        r114 = r12;
        if ((r22 instanceof l.a) == false) goto L212;
        ArrayList r65 = new ArrayList();
        Iterator<T> r66 = r16.iterator();
    L60:
        if (r66.hasNext() == false) goto L67;
        Object r133 = r66.next();
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r133).d <= 0) goto L64;
        boolean r134 = true;
    L65:
        if (r134 == false) goto L60;
        r65.add(r133);
        goto L60
    L64:
        r134 = false;
        goto L65
    L67:
        l.a r67 = (l.a) r22;
        if (r67.b == false) goto L83;
        Iterator r135 = r65.iterator();
        if (r135.hasNext() == true) goto L72;
        Object r68 = null;
    L81:
        r24 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r68;
        goto L105
    L72:
        r68 = r135.next();
        if (r135.hasNext() == false) goto L81;
        long r136 = Math.abs(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r68).d - r67.a);
    L76:
        Object r137 = r135.next();
        long r69 = Math.abs(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r137).d - r67.a);
        if (r136 <= r69) goto L80;
        r136 = r69;
        r68 = r137;
    L80:
        if (r135.hasNext() == true) goto L76;
    L83:
        ArrayList r70 = new ArrayList();
        Iterator r71 = r65.iterator();
    L85:
        if (r71.hasNext() == false) goto L92;
        Object r72 = r71.next();
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r72).d > r67.a) goto L89;
        boolean r138 = true;
    L90:
        if (r138 == false) goto L85;
        r70.add(r72);
        goto L85
    L89:
        r138 = false;
        goto L90
    L92:
        Iterator r73 = r70.iterator();
        if (r73.hasNext() == true) goto L95;
        Object r74 = null;
    L104:
        r24 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r74;
        goto L105
    L95:
        r74 = r73.next();
        if (r73.hasNext() == false) goto L104;
        long r75 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r74).d;
    L99:
        Object r76 = r73.next();
        long r139 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r76).d;
        if (r75 >= r139) goto L103;
        r74 = r76;
        r75 = r139;
    L103:
        if (r73.hasNext() == true) goto L99;
    L212:
        throw new NoWhenBranchMatchedException();
    L28:
        r16 = null;
        goto L29
    L12:
        r5 = false;
        goto L13
    L16:
        r12 = -1;
    L214:
        r8 = false;
    L217:
        r9 = false;
        goto L219
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((l) r1);
    }
}
