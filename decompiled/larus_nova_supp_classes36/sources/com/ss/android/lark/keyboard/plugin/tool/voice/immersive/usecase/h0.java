package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h0 implements View.OnClickListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public h0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        sob.d r8 = sob.d.a;
        String r0 = this.a.f().currentChatId$keyboard_biz_voice_release();
        String r1 = this.a.f().getCurrentRecordSourceId();
        String r2 = this.a.f().currentHitPointScene$keyboard_biz_voice_release();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "chatId");
        Intrinsics.checkNotNullParameter(r1, "sourceId");
        Intrinsics.checkNotNullParameter(r2, "scene");
        sob.d.f("im_voice_input_click", new Pair[]{new Pair("click", "retry"), new Pair("chat_id", r0), new Pair("source_id", r1), new Pair("voice_input_scene", r2)});
        ((AppCompatTextView) this.a.d.n.getValue()).setVisibility(8);
        VoiceBubbleAreaUseCase r9 = this.a;
        Context r3 = r9.a.getContext();
        int r4 = UIUtils.getColor(r3, 2131102439);
        Drawable r5 = r9.d.o().getBackground();
        if (r5 == null) goto L5;
        r5.setTint(r4);
    L5:
        Drawable r6 = r9.d.b().getBackground();
        if (r6 == null) goto L8;
        r6.setTint(r4);
    L8:
        sob.c.f(r9.d.o(), 0);
        r9.d.s().b(r9.h());
        r9.d.a().setVisibility(0);
        r9.d.r().setTextColor(UIUtils.getColor(r3, r9.h()));
        VoiceBubbleAreaUseCase r10 = this.a;
        AppCompatEditText r11 = r10.d.a();
        Editable r12 = r11.getEditableText();
        if (r12 == null) goto L15;
        Pair<Integer, Integer> r13 = r10.g(r12.length());
        if (r13 == null) goto L15;
        int r14 = ((Number) r13.component1()).intValue();
        r12.replace(r14, ((Number) r13.component2()).intValue(), "");
        r11.setSelection(r14);
        sob.c.e(r10.f().getBeforeInsetSelection(), new Pair(Integer.valueOf(r14), Integer.valueOf(r14)));
    L15:
        ImmersiveVoiceViewModel r15 = this.a.f();
        int r16 = AudioAsrLanguageSwitcher.i;
        if (r15.retryLastVoiceInput(AudioAsrLanguageSwitcher.a.a()) == true) goto L19;
        Context r17 = this.a.a.getContext();
        Intrinsics.checkNotNullParameter(r17, "context");
        FlowToast.a r18 = FlowToast.a(r17);
        r18.e(2131891713);
        r18.a().show();
        return;
    }
}
