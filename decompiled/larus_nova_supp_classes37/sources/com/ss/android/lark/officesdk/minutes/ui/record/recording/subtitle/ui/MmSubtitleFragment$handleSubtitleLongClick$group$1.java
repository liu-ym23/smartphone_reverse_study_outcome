package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmSubtitleFragment$handleSubtitleLongClick$group$1 extends FunctionReferenceImpl implements Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, String> {
    public MmSubtitleFragment$handleSubtitleLongClick$group$1(Object r8) {
        super(1, r8, MmSubtitleFragment.class, "resolveMarkSpeakerName", "resolveMarkSpeakerName(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;)Ljava/lang/String;", 0);
    }

    public final String invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        MmSubtitleFragment r0 = (MmSubtitleFragment) ((CallableReference) this).receiver;
        int r1 = MmSubtitleFragment.E;
        r0.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r2 = r6.h;
        if (r2 == null) goto L7;
        String r3 = r2.b;
        if (r3 == null) goto L7;
        String r4 = StringsKt.trim(r3).toString();
    L8:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        boolean r5 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L26;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r7 = r0.ea0().getUserContext().O().f(r6.g);
        if (r7 == null) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r8 = r6.g;
        String r9 = r7.f;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.f = r9;
        if (r6.g.g.length() == 0) goto L19;
        r5 = false;
    L19:
        if (r5 == false) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r10 = r6.g;
        String r11 = r7.g;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.g = r11;
    L21:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c r12 = r6.b();
        if (r7 == null) goto L25;
        r12 = r12.b(r7);
    L25:
        return StringsKt.trim(r12.a(MmSubtitleFragment$resolveMarkSpeakerName$2.INSTANCE)).toString();
    L26:
        return r4;
    L7:
        r4 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r1);
    }
}
