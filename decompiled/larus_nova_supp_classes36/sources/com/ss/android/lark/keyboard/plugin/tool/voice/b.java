package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements AudioRecordMutexController.b {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ AudioRecordMutexController c;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.AudioRecordMutexController.b
    public final void a(Scene r3, MediaType r4) {
        Intrinsics.checkNotNullParameter(r3, "byScene");
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r3 == Scene.VC_MEETING) goto L5;
        return;
    L5:
        if (r4 != MediaType.Audio_Record) goto L9;
        UICallbackExecutor.execute(new a(this.a, this.b, this.c, this));
        return;
    }

    public b(Function0<Unit> r1, Context r2, AudioRecordMutexController r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
