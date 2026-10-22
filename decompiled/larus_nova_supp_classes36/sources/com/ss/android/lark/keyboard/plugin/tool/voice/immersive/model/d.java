package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class d implements l {
    public final Object a;
    public final int b;
    public l c;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public boolean b() {
        return false;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final String getString() {
        return a(this.b);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final l c() {
        return this.c;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final int getState() {
        return this.b;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final String a(int r2) {
        switch(r2) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        String r3 = "unknownState";
    L13:
        return "[ImmersiveVoiceState]".concat(r3);
    L5:
        r3 = "RecognizingAfterSwitchLanguage";
        goto L13
    L6:
        r3 = "AsrResultState";
        goto L13
    L7:
        r3 = "CancelingState";
        goto L13
    L8:
        r3 = "RecognizingState";
        goto L13
    L9:
        r3 = "RecordingState";
        goto L13
    L10:
        r3 = "RecordPreparingState";
        goto L13
    L11:
        r3 = "IdleState";
        goto L13
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final void d(l r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.c = r2;
    }

    public d(Object r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
