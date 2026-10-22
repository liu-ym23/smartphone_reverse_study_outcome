package com.obric.aikernel.init.tasks.presetRes;

import android.util.Log;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_preset.api.IModelPresetResKt;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetResInitTask extends d {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public PresetResInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d("PresetResInitTask", "run");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        IModelPresetResKt.getModelPresetRes().init();     // Catch: Throwable -> L5
        Object r11 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 == null) goto L10;
        AIKLog.INSTANCE.e("PresetResInitTask", "ModelPresetRes should not init failed! " + ExceptionsKt.stackTraceToString(r12));
    L10:
        AIKLog.INSTANCE.d("PresetResInitTask", "run done");
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
