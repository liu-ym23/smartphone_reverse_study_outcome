package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.pb.recognition.SpeechLang;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AudioChooseLanguageDialogAdapter a;
    public final /* synthetic */ int b;

    public a(AudioChooseLanguageDialogAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        List<SpeechLang> r7 = this.a.a;
        int r0 = 0;
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L16;
        int r9 = this.b;
        if (r9 == 0) goto L15;
        if (r9 != 1) goto L16;
        b.c("en_us");
        goto L16
    L15:
        b.c("zh_ch");
    L16:
        int r10 = this.b;
        List<SpeechLang> r1 = this.a.a;
        if (r1 == null) goto L19;
        r0 = r1.size();
    L19:
        AudioChooseLanguageDialogAdapter.a r2 = null;
        if (r10 >= r0) goto L24;
        List<SpeechLang> r11 = this.a.a;
        if (r11 == null) goto L24;
        SpeechLang r12 = (SpeechLang) ListProtector.get(r11, this.b);
    L25:
        AudioChooseLanguageDialogAdapter r3 = this.a;
        String r4 = r3.d;
        String r5 = "";
        if (r4 != null) goto L28;
        r4 = "";
    L28:
        if (r12 == null) goto L31;
        String r13 = r12.mlangCode;
        if (r13 == null) goto L31;
    L32:
        r3.d = r13;
        if (r12 == null) goto L36;
        String r14 = r12.mlangName;
        if (r14 == null) goto L36;
    L40:
        AudioChooseLanguageDialogAdapter.a r15 = this.a.e;
        if (r15 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mItemClickListener");
    L44:
        String r16 = this.a.d;
        if (r16 == null) goto L48;
        r5 = r16;
    L48:
        r2.j4(r4, r5, r14);
        return;
    L43:
        r2 = r15;
    L36:
        List<String> r17 = r3.c;
        if (r17 == null) goto L39;
        r14 = (String) ListProtector.get(r17, this.b);
        goto L40
    L39:
        r14 = "";
    L31:
        r13 = "";
    L24:
        r12 = null;
        goto L25
    L5:
        if (r7.isEmpty() == true) goto L8;
        r8 = false;
        goto L9
    }
}
