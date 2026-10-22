package com.ss.android.lark.im.sdk.message.resend;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.message.send.CompressMediaStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements jkb.d<h> {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public g() {
    }

    @Override // jkb.d
    public final String getName() {
        return "ReUploadMediaStep";
    }

    @Override // jkb.d
    public final void a(jkb.b r6, final jkb.c r7) {
        h r8 = (h) r6;
        Intrinsics.checkNotNullParameter(r8, "pipelineContext");
        Intrinsics.checkNotNullParameter(r7, "pipelineControl");
        Message r0 = r8.a;
        final IGetDataCallback<String> r9 = r8.b;
        CompressMediaStep.UploadMediaCallback r1 = new ReUploadMediaStep$process$mediaUploadCallback$1(r7, r9);
        Message.Type r10 = r0.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 != 1) goto L9;
        p6b.d.b r12 = new p6b.d.b();
        r12.a = ImSdkProxy.e().getCurrentUserId();
        r12.b = r0;
        r12.c = 1;
        r12.d = true;
        r12.e = r1;
        r12.f = true;
        r12.g = false;
    L13:
        if (r12 != null) goto L15;
        r7.b(new jkb.e("SendInfo build failed for message, cid is " + r0.getcId() + ", type is " + r0.getType()));
        return;
    L15:
        com.ss.android.lark.im.sdk.a.b("ReUploadMediaStep", "Start compress media");
        p6b.d.a.a.b(r12);
        return;
    L9:
        if (r11 == 2) goto L11;
        r12 = null;
        goto L13
    L11:
        r12 = q6b.a.a(r0, r1, true);
        r12.g = false;
        goto L13
    L5:
        r11 = b.a[r10.ordinal()];
        goto L7
    }
}
