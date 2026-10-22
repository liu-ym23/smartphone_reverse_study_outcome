package com.bytedance.lynx.service.network;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.tasm.service.ILynxHttpService;
import ko.i;
import nm.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxHttpServiceProvider implements ILynxHttpService {
    public LynxHttpServiceProvider() {
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void request(@NonNull HttpRequest r5, @NonNull i r10) {
        LynxHttpService.getInstance().request(r5, r10);
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void requestStreaming(@NonNull HttpRequest r5, @NonNull i r10, @NonNull a r11) {
        LynxHttpService.getInstance().requestStreaming(r5, r10, r11);
    }
}
