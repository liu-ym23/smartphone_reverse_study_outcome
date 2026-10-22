package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class c0 implements Function1 {
    public final /* synthetic */ ImageSelectorComponent a;

    public /* synthetic */ c0(ImageSelectorComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r13) {
        ImageSelectorComponent r0 = this.a;
        ResourceUploadError r14 = (ResourceUploadError) r13;
        Lazy<Long> r1 = ImageSelectorComponent.X;
        Intrinsics.checkNotNullParameter(r14, "it");
        boolean r2 = true;
        if ((r0.X3().getCurState().getValue() instanceof sy9.b.e) == false) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r0.C != null) goto L13;
        if (r3 == true) goto L13;
        FLogger.a.i("ImageSelectorComponent", "[handleUploadFail] ignore stale failure, error=" + r14.getCode());
    L51:
        return Unit.INSTANCE;
    L13:
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L43;
        if (ICreationResourceAccessServiceKt.f(r14) == false) goto L18;
        t19.s r15 = t19.s.a;
        Context r4 = r0.getContext();
        r15.getClass();
        t19.s.s(r4, 2131908918);
        r0.X3().V5(new sy9.b.a(r0.h5()));
        r0.m.setValue(ry9.j.b.b);
        r0.D = null;
        r0.v4(false, "review");
        nz9.b.e("creation_page/album_upload", "-103", null);
        goto L51
    L18:
        String r5 = r14.getCode();
        ProcessFileResultCode[] r7 = ProcessFileResultCode.values();
        int r8 = r7.length;
        int r9 = 0;
    L19:
        if (r9 >= r8) goto L29;
        ProcessFileResultCode r10 = r7[r9];
        if (Intrinsics.areEqual(r10.getValue(), r5) == true) goto L23;
    L25:
        boolean r11 = false;
    L26:
        if (r11 == true) goto L27;
        r9 = r9 + 1;
        goto L19
    L27:
        boolean r12 = true;
    L30:
        if (r12 == true) goto L33;
        r2 = false;
    L40:
        if (r2 == false) goto L43;
    L33:
        if (Intrinsics.areEqual(r5, ProcessFileResultCode.PREPARE_OVER_SIZE.getValue()) == false) goto L36;
        t19.s r6 = t19.s.a;
        Context r16 = r0.getContext();
        r6.getClass();
        t19.s.s(r16, 2131906513);
    L39:
        r0.X3().V5(new sy9.b.a(r0.h5()));
        r0.m.setValue(ry9.j.b.b);
        r0.v4(false, "upload");
        nz9.b.e("creation_page/album_upload", "-101", null);
        goto L40
    L36:
        if (Intrinsics.areEqual(r5, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.getValue()) == false) goto L38;
        t19.s r17 = t19.s.a;
        Context r18 = r0.getContext();
        r17.getClass();
        t19.s.s(r18, 2131906526);
        goto L39
    L38:
        t19.s r19 = t19.s.a;
        Context r20 = r0.getContext();
        r19.getClass();
        t19.s.s(r20, 2131908214);
        goto L39
    L23:
        if (Intrinsics.areEqual(r10.getErrorType(), "send_file_preprocess_fail") == false) goto L25;
        r11 = true;
        goto L26
    L29:
        r12 = false;
    L43:
        if (NetworkUtils.isNetworkAvailable(r0.getContext()) == true) goto L45;
        t19.s r21 = t19.s.a;
        Context r22 = r0.getContext();
        r21.getClass();
        t19.s.s(r22, 2131908080);
    L46:
        r0.m.setValue(ry9.j.f.b);
        r0.R4();
        r0.v4(false, "upload");
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L49;
        nz9.b.e("upload", r14.getCode(), null);
    L49:
        nz9.b.e("creation_page/album_upload", "-102", null);
        goto L51
    L45:
        t19.s r23 = t19.s.a;
        Context r24 = r0.getContext();
        r23.getClass();
        t19.s.s(r24, 2131907666);
        goto L46
    L5:
        if ((r0.m.getValue() instanceof ry9.j.h) == true) goto L8;
        r3 = false;
        goto L10
    }
}
