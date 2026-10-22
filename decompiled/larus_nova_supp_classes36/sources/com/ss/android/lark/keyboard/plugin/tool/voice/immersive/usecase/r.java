package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.voiceinput.AsrSessionState;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;
    public final /* synthetic */ ArrayList<View> b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ ImmersiveVoiceViewModel d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AsrSessionState.values().length];
            r0[AsrSessionState.AsrSessionSwitchLanguage.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[AsrSessionState.AsrSessionWaitRecognizing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[AsrSessionState.AsrSessionEndWithText.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[AsrSessionState.AsrSessionEndWithTextTimeout.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AsrSessionState.AsrSessionEndNoText.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[AsrSessionState.AsrSessionEndNoTextTimeout.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public r(VoiceBubbleAreaUseCase r1, ArrayList<View> r2, Context r3, ImmersiveVoiceViewModel r4, int r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void onChanged(Object r10) {
        AsrSessionState r11 = (AsrSessionState) r10;
        boolean r2 = false;
        if (r11.getState() != 1002) goto L6;
        VoiceBubbleAreaUseCase r0 = this.a;
        r0.w.e(r0.f().isSupportVoiceWithAsr(), true, Integer.valueOf(r11.getState()), false);
    L6:
        switch(a.a[r11.ordinal()]) {
            case 1: goto L41;
            case 2: goto L33;
            case 3: goto L33;
            case 4: goto L33;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L59;
        };
    L8:
        this.a.d.m().setVisibility(0);
        if (this.a.f().isSecondVoiceInput() == false) goto L18;
        this.a.d.a().setEnabled(true);
        VoiceBubbleAreaUseCase r12 = this.a;
        Context r1 = r12.a.getContext();
        int r3 = UIUtils.getColor(r1, 2131102439);
        Drawable r4 = r12.d.o().getBackground();
        if (r4 == null) goto L13;
        r4.setTint(r3);
    L13:
        Drawable r5 = r12.d.b().getBackground();
        if (r5 == null) goto L16;
        r5.setTint(r3);
    L16:
        r12.d.s().b(r12.h());
        r12.d.r().setTextColor(UIUtils.getColor(r1, r12.h()));
        return;
    L18:
        if (r11 != AsrSessionState.AsrSessionEndNoText) goto L20;
        this.a.d.a().setEnabled(true);
    L20:
        this.a.d.s().b(((Number) this.a.t.getValue()).intValue());
        ArrayList<View> r6 = this.b;
        int r7 = this.f;
        Iterator<T> r8 = r6.iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        ((View) r8.next()).getBackground().setTint(r7);
        goto L22
    L24:
        sob.c.f(this.a.d.o(), this.a.m);
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c r9 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c(this.a.a);
        final VoiceBubbleAreaUseCase r13 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c.a(r9, r13.d.o(), VoiceBubbleAreaUseCase$initObserver$1$11$5$1.INSTANCE);
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c.a(r9, r13.a, new VoiceBubbleAreaUseCase$initObserver$1$11$5$2(r13));
        r9.b(new VoiceBubbleAreaUseCase$initObserver$1$11$5$3(r13));
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c.c(r9, null, null, 0, null, 15);
        AppCompatTextView r14 = (AppCompatTextView) this.a.d.n.getValue();
        if (r11 == AsrSessionState.AsrSessionEndNoTextTimeout) goto L27;
        String r15 = UIUtils.getString(this.c, 2131890968);
    L31:
        r14.setText(r15);
        return;
    L27:
        if (this.a.f().isSupportVoiceWithAsr() == false) goto L29;
        r15 = UIUtils.getString(this.c, 2131890419);
        goto L31
    L29:
        r15 = UIUtils.getString(this.c, 2131890966);
        goto L31
    L41:
        this.a.d.a().setEnabled(false);
        if (this.a.d.s().getVisibility() != 0) goto L44;
        boolean r16 = true;
    L45:
        VoiceBubbleAreaUseCase.e(this.a, CollectionsKt.mutableListOf(new Integer[]{2131363256}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131387916, 2131386396, 2131388751, 2131388770, 2131392750}));
        if (r16 == false) goto L54;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.d r17 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.d(this.a.d.o());
        VoiceBubbleAreaUseCase r18 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.b r19 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.b(2131392773);
        r19.g();
        r19.k();
        r19.j();
        r19.n(0);
        r19.b(0);
        if (r18.d.a().getVisibility() != 0) goto L50;
        r2 = true;
    L50:
        if (r2 == false) goto L52;
        r19.x(2131363256);
    L53:
        r19.w(r18.k);
        r19.a(r18.l);
        r17.a(r19);
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.d.b(r17);
        r17.c.applyTo(r17.a);
        goto L54
    L52:
        r19.x(2131388770);
    L54:
        ArrayList<View> r110 = this.b;
        int r20 = this.e;
        Iterator<T> r111 = r110.iterator();
    L56:
        if (r111.hasNext() == false) goto L58;
        ((View) r111.next()).getBackground().setTint(r20);
        goto L56
    L58:
        this.a.d.s().b(this.a.h());
        this.a.d.r().setTextColor(UIUtils.getColor(this.c, this.a.h()));
        return;
    L44:
        r16 = false;
        goto L45
    L59:
        ((AppCompatTextView) this.a.d.n.getValue()).setVisibility(8);
        ArrayList<View> r112 = this.b;
        int r21 = this.e;
        Iterator<T> r113 = r112.iterator();
    L61:
        if (r113.hasNext() == false) goto L72;
        ((View) r113.next()).getBackground().setTint(r21);
        goto L61
    L72:
        return;
    L33:
        if (r11 == AsrSessionState.AsrSessionWaitRecognizing) goto L40;
        this.d.showEditableTipsIfNeed();
        this.a.d.a().setEnabled(true);
        this.a.d.m().setVisibility(0);
        AppCompatImageView r114 = this.a.d.m();
        VoiceBubbleAreaUseCase r22 = this.a;
        if (r114.isLaidOut() == true) goto L37;
    L39:
        r114.addOnLayoutChangeListener(new s(r22));
        return;
    L37:
        if (r114.isLayoutRequested() == true) goto L39;
        VoiceImeWrapperUseCase.f(r22.c, r22.d.f().getHeight(), false, 6);
        AppCompatImageView r115 = r22.d.m();
        int r23 = r22.j;
        com.larksuite.framework.utils.g0.a(r115, r23, r23, r23, r23);
        return;
    L40:
        this.a.d.m().setVisibility(8);
    }
}
