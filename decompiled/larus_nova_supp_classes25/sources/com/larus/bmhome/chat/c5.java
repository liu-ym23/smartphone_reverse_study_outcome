package com.larus.bmhome.chat;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c5 extends BaseControllerListener<ImageInfo> {
    public final boolean a;
    public final String b;
    public final Message c;
    public final boolean d;
    public final AttachmentAreaType e;
    public final d5 f;
    public final Function0<Unit> g;

    public static final class a {
    }

    static {
    }

    public final void onFailure(String r14, Throwable r15) {
        d5 r16 = this.f;
        String r0 = this.b;
        if (r16 == null) goto L5;
        Uri r1 = r16.b;
    L6:
        boolean r2 = Intrinsics.areEqual(r0, String.valueOf(r1));
        FLogger.a.w("SendImgControllerListener", "load " + this.a + " failed(" + r2 + "), err:" + r15);
        Message r3 = this.c;
        if (r3 == null) goto L15;
        String r6 = r3.getLocalMessageId();
        if (r6 == null) goto L15;
        int r4 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r7 = this.c.getMessageId();
        String r8 = "load " + this.a + " failed(" + r2 + "), err:" + r15;
        String r9 = this.b;
        if (this.e != AttachmentAreaType.MULTI_ATTACHMENT) goto L13;
        boolean r11 = true;
    L14:
        com.larus.bmhome.chat.trace.multimodal.a.a(r6, r7, r8, r9, "user-sent", r11, MapsKt.mapOf(TuplesKt.to("extra_is_reload", Integer.valueOf(this.d ? 1 : 0))));
        goto L15
    L13:
        r11 = false;
    L15:
        if (r2 == false) goto L19;
        if (r16 == null) goto L20;
        r16.setResult(Boolean.FALSE);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onSubmit(String r9, Object r10) {
        super.onSubmit(r9, r10);
        Message r11 = this.c;
        if (r11 == null) goto L9;
        int r12 = MultimodalSendCostTrace.a;
        String r13 = r11.getLocalMessageId();
        if (r13 != null) goto L7;
        r13 = "";
    L7:
        String r2 = r11.getConversationId();
        MultimodalSendCostTrace.b(r13, r11.getLocalMessageId(), r2, null, this.e, null, null, null);
        return;
    }

    public final void onFinalImageSet(String r8, Object r9, Animatable r10) {
        ImageInfo r11 = (ImageInfo) r9;
        d5 r12 = this.f;
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L18;
        Message r14 = this.c;
        if (r14 == null) goto L18;
        String r1 = r14.getLocalMessageId();
        if (r1 == null) goto L18;
        int r15 = MultimodalSendCostTrace.a;
        String r2 = this.b;
        String r3 = this.c.getMessageId();
        if (this.e != AttachmentAreaType.MULTI_ATTACHMENT) goto L16;
        boolean r5 = true;
    L17:
        MultimodalSendCostTrace.e(r1, r2, r3, "user-sent", r5, MapsKt.mapOf(TuplesKt.to("extra_is_reload", Integer.valueOf(this.d ? 1 : 0))));
        goto L18
    L16:
        r5 = false;
    L18:
        d5 r16 = this.f;
        String r17 = this.b;
        if (r16 == null) goto L21;
        Uri r0 = r16.b;
    L22:
        boolean r18 = Intrinsics.areEqual(r17, String.valueOf(r0));
        FLogger.a.d("SendImgControllerListener", "onFinalImageSet() id " + r8 + " load " + this.a + " success(" + r18 + ')');
        if (r18 == false) goto L26;
        if (r16 == null) goto L26;
        r16.setResult(Boolean.TRUE);
    L26:
        this.g.invoke();
        return;
    L21:
        r0 = null;
        goto L22
    L5:
        if (r12.e == true) goto L7;
        r13 = true;
        goto L8
    }

    public c5(boolean r2, String r3, Message r4, boolean r5, AttachmentAreaType r6, d5 r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r3, "uriStr");
        Intrinsics.checkNotNullParameter(r6, "attachmentAreaType");
        Intrinsics.checkNotNullParameter(r8, "onFinalImageSet");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
