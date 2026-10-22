package com.obric.aivoice.sdk;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.aivoice.core.log.AIVoiceLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceTask;", NameKeys.UnloadStrategy_No_Strategy, "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "mAsrListener", "Lcom/obric/aivoice/sdk/IAsrListener;", "mTtsListener", "Lcom/obric/aivoice/sdk/ITtsListener;", "addAsrListener", NameKeys.UnloadStrategy_No_Strategy, "listener", "addTtsListener", "createAsrTask", NameKeys.UnloadStrategy_No_Strategy, "asrConfig", "createFileAsrTask", "Lcom/obric/aivoice/sdk/FileAsrTaskListener;", "createTtsTask", "ttsConfig", "onAsrResult", "taskId", "resp", "onTtsResult", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "queryFileAsrTask", "removeAsrTask", "removeTtsTask", "writeAsrData", "asrData", "writeTtsEnd", "writeTtsText", "text", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceTask {
    public static final AIVoiceTask INSTANCE = null;
    public static final String TAG = "AIVoiceTask";
    private static IAsrListener mAsrListener;
    private static ITtsListener mTtsListener;

    static {
        INSTANCE = new AIVoiceTask();
    }

    private AIVoiceTask() {
    }

    public final void addAsrListener(IAsrListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        mAsrListener = r2;
    }

    public final void addTtsListener(ITtsListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        mTtsListener = r2;
    }

    public final int createAsrTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "asrConfig");
        return AIVoiceManagerInner.INSTANCE.createAsrTask(r2);
    }

    public final int createTtsTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "ttsConfig");
        return AIVoiceManagerInner.INSTANCE.createTtsTask(r2);
    }

    public final String queryFileAsrTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return AIVoiceManagerInner.INSTANCE.queryFileAsrTask(r2);
    }

    public final int removeAsrTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return AIVoiceManagerInner.INSTANCE.removeAsrTask(r2);
    }

    public final int removeTtsTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return AIVoiceManagerInner.INSTANCE.removeTtsTask(r2);
    }

    public final int writeTtsEnd(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return AIVoiceManagerInner.INSTANCE.writeTtsEnd(r2);
    }

    public final String createFileAsrTask(String r2, FileAsrTaskListener r3) {
        Intrinsics.checkNotNullParameter(r2, "asrConfig");
        return AIVoiceManagerInner.INSTANCE.createFileAsrTask(r2, r3);
    }

    public final void onAsrResult(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "resp");
        IAsrListener r0 = mAsrListener;
        if (r0 == null) goto L6;
        r0.onAsrResponse(r2, r3);
        return;
    }

    public final int writeAsrData(byte[] r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r3, "asrData");
        return AIVoiceManagerInner.INSTANCE.writeAsrData(r2, r3);
    }

    public final int writeTtsText(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "text");
        return AIVoiceManagerInner.INSTANCE.writeTtsText(r2, r3);
    }

    public final void onTtsResult(String r4, byte[] r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r6, "resp");
        AIVoiceLog.INSTANCE.d(TAG, "onAsrResult mTtsListener:" + mTtsListener);
        ITtsListener r0 = mTtsListener;
        if (r0 == null) goto L6;
        r0.onTtsResponse(r4, r5, r6);
        return;
    }
}
