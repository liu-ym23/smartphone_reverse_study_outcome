package com.larus.dora.impl.dynamic.quicknote;

import com.larus.dora.impl.databinding.LarusDoraPageQuickNoteDetailBinding;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.c0;
import com.larus.dora.impl.dynamic.quicknote.views.QuickNoteItemTextSelectorSubTitle;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.network.z;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class QuickNoteDetailFragment$setupObservers$2$1<T> implements FlowCollector {
    public final /* synthetic */ QuickNoteDetailFragment a;

    public QuickNoteDetailFragment$setupObservers$2$1(QuickNoteDetailFragment r1) {
        this.a = r1;
    }

    public final Object a(c0 r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof QuickNoteDetailFragment$setupObservers$2$1$emit$1) == false) goto L7;
        QuickNoteDetailFragment$setupObservers$2$1$emit$1 r0 = (QuickNoteDetailFragment$setupObservers$2$1$emit$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        LarusDoraPageQuickNoteDetailBinding r16 = (LarusDoraPageQuickNoteDetailBinding) r0.L$3;
        QuickNoteDetailFragment r4 = (QuickNoteDetailFragment) r0.L$2;
        LarusDoraPageQuickNoteDetailBinding r5 = (LarusDoraPageQuickNoteDetailBinding) r0.L$1;
        c0 r6 = (c0) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L22:
        z r17 = (z) r15;
        String r7 = null;
        if (r17 == null) goto L25;
        String r8 = r17.b();
    L27:
        if (r8 != null) goto L29;
    L32:
        boolean r9 = true;
    L34:
        if (r9 == false) goto L36;
        QuickNoteItemTextSelectorSubTitle r10 = r16.c;
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        String r12 = r4.getString(2131902405);
        GestureSettingsRepository r18 = GestureSettingsRepository.a;
        Byte r110 = ((c0.c) r6).a.get(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK);
        r18.getClass();
        r10.setSubTitle(String.format(r12, Arrays.copyOf(new Object[]{GestureSettingsRepository.i(r110)}, 1)));
    L36:
        if (r17 == null) goto L38;
        r7 = r17.d();
    L38:
        if (r7 != null) goto L40;
    L43:
        boolean r111 = true;
    L44:
        if (r111 == false) goto L54;
        QuickNoteItemTextSelectorSubTitle r112 = r16.d;
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        String r114 = r4.getString(2131902405);
        GestureSettingsRepository r20 = GestureSettingsRepository.a;
        Byte r21 = ((c0.c) r6).a.get(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK);
        r20.getClass();
        r112.setSubTitle(String.format(r114, Arrays.copyOf(new Object[]{GestureSettingsRepository.i(r21)}, 1)));
    L54:
        return Unit.INSTANCE;
    L40:
        if (r7.length() == 0) goto L43;
        r111 = false;
        goto L44
    L29:
        if (r8.length() == 0) goto L32;
        r9 = false;
        goto L34
    L25:
        r8 = null;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if ((r13 instanceof c0.c) == false) goto L47;
        QuickNoteDetailFragment r115 = this.a;
        LarusDoraPageQuickNoteDetailBinding r22 = r115.f;
        if (r22 == null) goto L54;
        QuickNoteRepo r23 = QuickNoteRepo.a;
        r0.L$0 = r13;
        r0.L$1 = r22;
        r0.L$2 = r115;
        r0.L$3 = r22;
        r0.label = 1;
        Object r24 = r23.c(r0);
        if (r24 != r2) goto L21;
        return r2;
    L21:
        r4 = r115;
        r15 = r24;
        r6 = r13;
        r16 = r22;
        goto L22
    L47:
        if (Intrinsics.areEqual(r13, c0.b.a) == true) goto L54;
        if (Intrinsics.areEqual(r13, c0.a.a) == true) goto L54;
        throw new NoWhenBranchMatchedException();
    L7:
        r0 = new QuickNoteDetailFragment$setupObservers$2$1$emit$1(this, r14);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
        return a((c0) r1, r2);
    }
}
