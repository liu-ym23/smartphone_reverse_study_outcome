package com.larus.camera.api;

import com.larus.bmhome.chat.component.input.InjectInputServiceProxy;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import kotlin.Metadata;
import op8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/api/IInputServiceProvider;", "", "createInjectToCameraService", "Lcom/larus/bmhome/injectinput/IInjectInputService;", "callback", "Lcom/larus/bmhome/injectinput/IInjectInputCallback;", "createInjectToPhotoPickerService", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IInputServiceProvider {
    InjectInputServiceProxy a(ResultInputControlBinder.a r1);

    InjectInputServiceProxy b(c r1);
}
