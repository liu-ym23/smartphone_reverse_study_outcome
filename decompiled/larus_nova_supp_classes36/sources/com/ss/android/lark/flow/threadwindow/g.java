package com.ss.android.lark.flow.threadwindow;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.BaseKeyboardComponentV2;
import com.ss.android.lark.flow.chat.databinding.FragmentFlowThreadWindowBinding;
import com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin;
import com.ss.android.lark.keyboard.component.FlowKeyboardComponent;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LinearLayout a;
    public final /* synthetic */ FlowThreadWindowFragment b;

    public static final class a implements Runnable {
        public final /* synthetic */ FlowThreadWindowFragment a;

        public a(FlowThreadWindowFragment r1) {
            this.a = r1;
        }

        public final void a() {
            FlowKeyboardComponent r0 = this.a.p;
            if (r0 == null) goto L34;
            com.ss.android.lark.keyboard.b r1 = ((BaseKeyboardComponentV2) r0).n;
            if (r1 == null) goto L35;
            VoiceInnerEndPlugin r2 = null;
            if (r1 == null) goto L10;
            com.ss.android.lark.keyboard.keyboard2.b r3 = r1.L();
        L11:
            mob.a r4 = (mob.a) r3;
            if ((r4 instanceof FlowChatKeyboardEditor) == false) goto L14;
            FlowChatKeyboardEditor r5 = (FlowChatKeyboardEditor) r4;
        L15:
            if (r5 == null) goto L36;
            VoiceInnerEndPlugin.b r6 = VoiceInnerEndPlugin.t;
            wnb.b r7 = r5.H();
            if (r7 != null) goto L20;
        L32:
            r5.c().requestFocus();
            com.ss.android.lark.c.f(r1);
            return;
        L20:
            if ((r7 instanceof VoiceInnerEndPlugin) == false) goto L22;
            r2 = (VoiceInnerEndPlugin) r7;
        L22:
            if (r2 == null) goto L32;
            r2.n = false;
            fya.a r8 = r2.p();
            if (r8 == null) goto L26;
            r8.v5(false);
        L26:
            wnb.d r9 = r2.e;
            if (r9 == null) goto L30;
            Fragment r10 = r9.a;
            if (r10 == null) goto L30;
        L31:
            r2.m(r10, false);
        L30:
            r10 = r2.a.a;
            goto L31
        L36:
            return;
        L14:
            r5 = null;
            goto L15
        L10:
            r3 = null;
            goto L11
        L35:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g(LinearLayout r1, FlowThreadWindowFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.setVisibility(8);
        FragmentFlowThreadWindowBinding r5 = this.b.n;
        FragmentFlowThreadWindowBinding r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L5:
        r5.b.setVisibility(0);
        FragmentFlowThreadWindowBinding r6 = this.b.n;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r0.b.post(new a(this.b));
        return;
    L8:
        r0 = r6;
        goto L9
    }
}
