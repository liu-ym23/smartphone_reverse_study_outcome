package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SuffixAsrSpan;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;
    public final /* synthetic */ ImmersiveVoiceViewModel b;

    public z(VoiceBubbleAreaUseCase r1, ImmersiveVoiceViewModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r15) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r16 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c) r15;
        if (r16.f == false) goto L5;
        final VoiceBubbleAreaUseCase r0 = this.a;
        Intrinsics.checkNotNull(r16);
        r0.getClass();
        final RichText r17 = r16.a;
        final RichTextEditor r1 = (RichTextEditor) r0.d.a().q(RichTextEditor.t);
        sob.c.d(r0, "renderOriginalToEditText", new VoiceBubbleAreaUseCase$renderOriginalToEditText$1(r0, r1, r17));
        return;
    L5:
        RichText r2 = r16.a;
        boolean r3 = r16.c;
        Boolean r4 = r16.d;
        if (r4 == null) goto L8;
        boolean r5 = r4.booleanValue();
    L9:
        SpannableStringBuilder r6 = r16.b;
        String r18 = r16.e;
        if (KeyboardVoiceFGUtils.a.f() == false) goto L64;
        final SpannableStringBuilder r7 = new SpannableStringBuilder();
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        RichTextEditor r9 = (RichTextEditor) this.a.d.a().q(RichTextEditor.t);
        final Editable r10 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(r9).getEditableText();
        if (r10 == null) goto L68;
        Pair<Integer, Integer> r11 = this.a.g(r10.length());
        if (r11 == null) goto L69;
        r9.R(r2, r8);
        Character r12 = StringsKt.lastOrNull(r8);
        if (r12 != null) goto L21;
    L23:
        if (r3 == true) goto L28;
        if (this.a.f().isVoiceInputMarkdownFg() == false) goto L28;
        Lazy r13 = SpannableStringUtils.a;
        SpannableStringUtils.e(r8, r18, new SuffixAsrSpan(UIUtils.getColor(this.a.a.getContext(), 2131108741)));
    L28:
        if (this.a.f().isVoiceInputMarkdownFg() == false) goto L36;
        RichText r19 = (RichText) this.b.getInsertPeriodRichText().getValue();
        if (r19 == null) goto L42;
        if (com.ss.android.lark.widget.richtext.i.l(r19) == true) goto L42;
        if (com.ss.android.lark.widget.richtext.i.l(r2) == true) goto L42;
        SpannableStringBuilder r14 = new SpannableStringBuilder();
        r9.R(r19, r14);
        r7.append(r14);
    L42:
        if (this.a.f().isVoiceInputMarkdownFg() == false) goto L55;
        if (r5 == false) goto L55;
        if (((Number) r11.getFirst()).intValue() >= r10.length()) goto L55;
        String r110 = r10.subSequence(0, ((Number) r11.getFirst()).intValue()).toString();
        if ((!StringsKt.isBlank(r110)) == false) goto L55;
        Character r111 = StringsKt.lastOrNull(r110);
        if (r111 != null) goto L52;
    L53:
        r7.append("\n");
        goto L55
    L52:
        if (r111.charValue() != '\n') goto L53;
    L55:
        if (KeyboardVoiceFGUtils.i() == false) goto L63;
        y9b.a[] r112 = (y9b.a[]) r8.getSpans(0, r8.length(), y9b.a.class);
        if (r112.length != 0) goto L59;
        boolean r20 = true;
    L61:
        if ((true ^ r20) == false) goto L63;
        r112[0].g(ListHeadType.VirtualHead);
        goto L63
    L59:
        r20 = false;
    L63:
        r7.append(r8);
        r7.append(r6);
        final y r113 = new y();
        r7.setSpan(r113, 0, r7.length(), 34);
        ImmersiveVoiceViewModel r21 = this.b;
        final VoiceBubbleAreaUseCase r22 = this.a;
        sob.c.d(r21, "updateAsrResult", new VoiceBubbleAreaUseCase$initObserver$1$6$3(r22, r10, r7, r113));
        return;
    L36:
        String r114 = (String) this.b.getInsertPeriod().getValue();
        if (r114 == null) goto L42;
        if (com.ss.android.lark.widget.richtext.i.l(r2) == true) goto L42;
        r7.append(r114);
        goto L42
    L21:
        if (r12.charValue() != '\n') goto L23;
        r8.delete(r8.length() - 1, r8.length());
        goto L23
    L69:
        return;
    L68:
        return;
    L64:
        final SpannableStringBuilder r115 = new SpannableStringBuilder();
        ((RichTextEditor) this.a.d.a().q(RichTextEditor.t)).R(r2, r115);
        r115.append(r6);
        ImmersiveVoiceViewModel r23 = this.b;
        final VoiceBubbleAreaUseCase r24 = this.a;
        sob.c.d(r23, "updateAsrResult", new VoiceBubbleAreaUseCase$initObserver$1$6$4(r24, r115));
        return;
    L8:
        r5 = false;
        goto L9
    }
}
