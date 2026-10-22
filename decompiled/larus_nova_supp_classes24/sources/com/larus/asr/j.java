package com.larus.asr;

import com.larus.bmhome.chat.bean.ChatPageContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ BottomViewModelSpeakerViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ wc9.e c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ ChatPageContext f;

    public /* synthetic */ j(BottomViewModelSpeakerViewModel r1, String r2, wc9.e r3, String r4, Function1 r5, ChatPageContext r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BottomViewModelSpeakerViewModel.No(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
