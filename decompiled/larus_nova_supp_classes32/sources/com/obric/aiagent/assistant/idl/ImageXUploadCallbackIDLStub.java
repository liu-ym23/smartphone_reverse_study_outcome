package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JQ\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f2\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\f2\u000e\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\f0\f2\u000e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/aiagent/assistant/idl/ImageXUploadCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IImageXUploadCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IImageXUploadCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onResult", NameKeys.UnloadStrategy_No_Strategy, "success", NameKeys.UnloadStrategy_No_Strategy, "tosKey", NameKeys.UnloadStrategy_No_Strategy, "kotlin.jvm.PlatformType", "resId", LynxResourceModule.CODE_KEY, "msg", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ImageXUploadCallbackIDLStub extends IImageXUploadCallbackIDL.Stub {
    private final /* synthetic */ IImageXUploadCallbackIDL $$delegate_0;

    public void onResult(boolean r7, String r8, String r9, String r10, String r11) {
        this.$$delegate_0.onResult(r7, r8, r9, r10, r11);
    }

    public ImageXUploadCallbackIDLStub() {
        IImageXUploadCallbackIDL r0 = (IImageXUploadCallbackIDLSPI) ServiceManager.get().getService(IImageXUploadCallbackIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IImageXUploadCallbackIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
