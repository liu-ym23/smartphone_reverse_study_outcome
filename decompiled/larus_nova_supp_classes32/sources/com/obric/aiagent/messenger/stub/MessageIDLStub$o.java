package com.obric.aiagent.messenger.stub;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.im.bean.message.UplinkFileEntity;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$o implements oha.a {
    public final /* synthetic */ MessageIDLStub a;
    public final /* synthetic */ IImageXUploadCallbackIDL b;
    public final /* synthetic */ File c;

    public final void a(UplinkFileEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
    }

    public final void d(UplinkFileEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
    }

    public MessageIDLStub$o(MessageIDLStub r1, IImageXUploadCallbackIDL r2, PolarisFileWrapper r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void b(UplinkFileEntity r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.CODE_KEY);
        Intrinsics.checkNotNullParameter(r4, "msg");
    }

    public final void c(UplinkFileEntity r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "entity");
    }

    public final void onResult(boolean r8, String r9, String r10, String r11, String r12) {
        MessageIDLStub.access$notifyUploadResult(this.a, this.b, r8, r9, r10, r11, r12);
        this.c.delete();
    }
}
