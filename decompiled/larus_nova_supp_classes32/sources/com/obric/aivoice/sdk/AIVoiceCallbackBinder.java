package com.obric.aivoice.sdk;

import android.os.Bundle;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.AIVoiceListener;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.core.data.IdlKeys;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackBinder;", "Lcom/obric/aivoice/AIVoiceListener$Stub;", "()V", "getVersion", NameKeys.UnloadStrategy_No_Strategy, "onAsrResponse", "taskId", NameKeys.UnloadStrategy_No_Strategy, "resp", "onResult", NameKeys.UnloadStrategy_No_Strategy, "response", "Landroid/os/Bundle;", "onTtsResponse", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceCallbackBinder extends AIVoiceListener.Stub {
    public static final Companion Companion = null;
    public static final String TAG = "AIVoiceCallbackBinder";
    private static final int VERSION = 1;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackBinder$Companion;", NameKeys.UnloadStrategy_No_Strategy, "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "VERSION", NameKeys.UnloadStrategy_No_Strategy, "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int getVersion() {
        return 1;
    }

    public AIVoiceCallbackBinder() {
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public void onResult(Bundle r3) {
        Integer r0 = null;
        if (r3 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r3.getBoolean(IdlKeys.Args_OfflineServerStatus));
    L6:
        if (r3 == null) goto L8;
        r0 = Integer.valueOf(r3.getInt(IdlKeys.Args_OfflineWorkMode));
    L8:
        if (r1 == null) goto L12;
        if (r0 == null) goto L13;
        AIVoiceManagerInner.INSTANCE.onOfflineStatusChanged(r1.booleanValue(), r0.intValue());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int onAsrResponse(String r4, String r5) {
        boolean r0 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L17;
        if (r5 != null) goto L12;
    L15:
        if (r0 == true) goto L17;
        AIVoiceTask.INSTANCE.onAsrResult(r4, r5);
        goto L17
    L12:
        if (r5.length() == 0) goto L15;
        r0 = false;
    L17:
        return 0;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int onTtsResponse(String r4, byte[] r5, String r6) {
        boolean r1 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L24;
        if (r5 == null) goto L24;
        if (r5.length != 0) goto L14;
        boolean r3 = true;
    L16:
        if ((!r3) == false) goto L24;
        if (r6 != null) goto L19;
    L22:
        if (r1 == true) goto L24;
        AIVoiceTask.INSTANCE.onTtsResult(r4, r5, r6);
        goto L24
    L19:
        if (r6.length() == 0) goto L22;
        r1 = false;
        goto L22
    L14:
        r3 = false;
    L24:
        return 0;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
