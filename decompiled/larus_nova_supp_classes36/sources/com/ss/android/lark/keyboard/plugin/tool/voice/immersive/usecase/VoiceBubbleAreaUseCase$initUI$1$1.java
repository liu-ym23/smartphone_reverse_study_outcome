package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.audio.voiceinput.AsrSessionState;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.IconWithTitleItemId;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SwitchActionItemId;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.VoiceBubbleMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.vote.DownVoteInputAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceBubbleAreaUseCase$initUI$1$1 implements AudioAsrLanguageSwitcher.b {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;
    public final /* synthetic */ AppCompatImageView b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[IconWithTitleItemId.values().length];
            r0[IconWithTitleItemId.SubmitFeedback.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r0[IconWithTitleItemId.RollBackAudio.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            a = r0;
            int[] r1 = new int[SwitchActionItemId.values().length];
            r1[SwitchActionItemId.PolishVoiceInput.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
    public final void a(rob.j r18) {
        Intrinsics.checkNotNullParameter(r18, "itemData");
        if (a.b[r18.d.ordinal()] != 1) goto L11;
        final boolean r1 = !r18.c;
        if (r1 == false) goto L7;
        sob.d r16 = sob.d.a;
        String r5 = this.a.f().currentChatId$keyboard_biz_voice_release();
        String r3 = this.a.f().getCurrentRecordSourceId();
        String r6 = this.a.f().currentHitPointScene$keyboard_biz_voice_release();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intrinsics.checkNotNullParameter(r3, "sourceId");
        Intrinsics.checkNotNullParameter(r6, "scene");
        sob.d.f("im_voice_input_more_click", new Pair[]{new Pair("chat_id", r5), new Pair("source_id", r3), new Pair("click", "auto_format_enable"), new Pair("location", "im_input_button"), new Pair("voice_input_scene", r6)});
    L8:
        final VoiceBubbleAreaUseCase r2 = this.a;
        AudioAsrLanguageSwitcher r4 = r2.v;
        Function0<Unit> r7 = new VoiceBubbleAreaUseCase$initUI$1$1$onClickItem$3(r1, r2);
        final VoiceBubbleAreaUseCase r8 = this.a;
        Function0<Unit> r9 = new VoiceBubbleAreaUseCase$initUI$1$1$onClickItem$4(r8);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "onSuccess");
        Intrinsics.checkNotNullParameter(r9, "onError");
        AudioAsrLanguageSwitcher.e(r4.e, Boolean.valueOf(r1), r7, r9);
        return;
    L7:
        sob.d r10 = sob.d.a;
        String r11 = this.a.f().currentChatId$keyboard_biz_voice_release();
        String r12 = this.a.f().getCurrentRecordSourceId();
        String r13 = this.a.f().currentHitPointScene$keyboard_biz_voice_release();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "sourceId");
        Intrinsics.checkNotNullParameter(r13, "scene");
        sob.d.f("im_voice_input_more_click", new Pair[]{new Pair("chat_id", r11), new Pair("source_id", r12), new Pair("click", "auto_format_disable"), new Pair("location", "im_input_button"), new Pair("voice_input_scene", r13)});
        goto L8
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
    public final void b(rob.e r6) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        IconWithTitleItemId r7 = r6.c;
        int r8 = a.a[r7.ordinal()];
        if (r8 != 1) goto L5;
        this.a.f().whenClickFeedbackEntrance();
        ArrayList r9 = new ArrayList();
        r9.add(2131891442);
        r9.add(2131891443);
        r9.add(2131891447);
        r9.add(2131891444);
        ArrayList r0 = new ArrayList();
        AppCompatImageView r1 = this.b;
        Iterator r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        int r2 = ((Number) r10.next()).intValue();
        r0.add(UIUtils.getString(r1.getContext(), r2));
        goto L11
    L13:
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        Context r3 = this.b.getContext();
        final VoiceBubbleAreaUseCase r4 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.vote.d r5 = new com.ss.android.lark.keyboard.plugin.tool.voice.vote.d(r3, r0, new VoiceBubbleAreaUseCase$initUI$1$1$onClickItem$1(r4, r11));
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r5);
    L18:
        String r12 = UIUtils.getString(r5.getContext(), 2131891441);
        Intrinsics.checkNotNullParameter(r12, "string");
        TextView r13 = r5.e;
        if (r13 == null) goto L21;
        r13.setText(r12);
    L21:
        String r14 = UIUtils.getString(r5.getContext(), 2131891445);
        Intrinsics.checkNotNullParameter(r14, "hint");
        DownVoteInputAdapter r15 = r5.i;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "hint");
        SCAppCompatEditText r16 = r15.a;
        if (r16 == null) goto L24;
        r16.setHint(r14);
    L24:
        r11.element = r5;
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L17:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L18
    L5:
        if (r8 != 2) goto L8;
        this.a.f().rollbackToOldAudio();
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
    public final void d(SendType r6) {
        Intrinsics.checkNotNullParameter(r6, "sendType");
        AsrSessionState r0 = (AsrSessionState) this.a.f().getAsrSessionState().getValue();
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        Integer r4 = null;
        if (r6 != SendType.VoiceWithAsr) goto L17;
        if (r1 == false) goto L22;
        VoiceBubbleAreaUseCase r2 = this.a;
        VoiceBubbleMotionScene r3 = r2.w;
        AsrSessionState r5 = (AsrSessionState) r2.f().getAsrSessionState().getValue();
        if (r5 == null) goto L16;
        r4 = Integer.valueOf(r5.getState());
    L16:
        r3.e(true, false, r4, this.a.f().isSecondVoiceInput());
    L22:
        this.a.f().whenClickSwitchSendType(r6);
        return;
    L17:
        if (r1 == false) goto L22;
        VoiceBubbleAreaUseCase r7 = this.a;
        VoiceBubbleMotionScene r8 = r7.w;
        AsrSessionState r9 = (AsrSessionState) r7.f().getAsrSessionState().getValue();
        if (r9 == null) goto L21;
        r4 = Integer.valueOf(r9.getState());
    L21:
        r8.e(false, false, r4, this.a.f().isSecondVoiceInput());
        goto L22
    L5:
        if (r0.getState() < 1100) goto L9;
        if (r0.getState() > 1103) goto L9;
        r1 = true;
        goto L10
    }

    public VoiceBubbleAreaUseCase$initUI$1$1(VoiceBubbleAreaUseCase r1, AppCompatImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
    public final void c(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "curLangName");
        Intrinsics.checkNotNullParameter(r5, "curLangKey");
        Log.i(this.a.e, "switchLanguage: " + r4 + ", " + r5 + ", " + r6);
        if (r6 == false) goto L5;
        return;
    L5:
        sob.c.e(this.a.f().getBeforeInsetSelection(), new Pair(0, Integer.valueOf(this.a.d.a().getEditableText().length())));
        sob.c.e(this.a.f().getInsertPeriodRichText(), new RichText());
        sob.c.e(this.a.f().getInsertPeriod(), "");
        this.a.d.i().setVisibility(4);
        this.a.f().switchLanguage(r4, r5);
    }

    public static final void e(VoiceBubbleAreaUseCase r3, boolean r4, UDButton r5, com.ss.android.lark.keyboard.plugin.tool.voice.vote.d r6) {
        int r0 = UIUtils.dp2px(r3.a.getContext(), 128.0f);
        if (r5 == null) goto L5;
        r5.setBackgroundColor(UDColorUtils.getColorStateList(r5.getContext(), 2131108881));
        r5.setEnabled(true);
    L5:
        if (r6 == null) goto L23;
        Handler r7 = DialogLancet.resolveDialogHandler(r6);
        if (r7 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r6);
        goto L23
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r8 == null) goto L20;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r7.getLooper()) goto L11;
        r7.post(DialogLancet.createDismissRunnable(r6));
    L23:
        Context r9 = r3.a.getContext();
        Intrinsics.checkNotNullParameter(r9, "context");
        FlowToast.a r10 = FlowToast.a(r9);
        if (r4 == false) goto L26;
        int r11 = 2131891438;
    L27:
        r10.e(r11);
        if (r4 == false) goto L30;
        int r12 = 2131256306;
    L31:
        r10.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r9, r12));
        r10.c(80, 0, r0);
        r10.a().show();
        return;
    L30:
        r12 = 2131254345;
        goto L31
    L26:
        r11 = 2131891713;
        goto L27
    }
}
