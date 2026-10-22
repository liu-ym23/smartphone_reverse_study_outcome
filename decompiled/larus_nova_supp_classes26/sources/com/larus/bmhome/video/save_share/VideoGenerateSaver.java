package com.larus.bmhome.video.save_share;

import android.content.Context;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.IVideoDownloadLoadingMgrService;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.o;
import com.larus.uaigc.service.ICreationMetadataService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class VideoGenerateSaver implements a {
    public static final VideoGenerateSaver a = null;

    static {
        a = new VideoGenerateSaver();
    }

    public VideoGenerateSaver() {
    }

    @Override // com.larus.bmhome.video.save_share.a
    public final void b(Context r17, final nr9.g r18, final c4 r19, final String r20, final CoroutineScope r21, final boolean r22, boolean r23, final JSONObject r24, Map<String, String> r25, String r26, boolean r27, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r28) {
        Intrinsics.checkNotNullParameter(r19, "videoDetailEventParams");
        Intrinsics.checkNotNullParameter(r20, "clickMethod");
        Intrinsics.checkNotNullParameter(r21, "scope");
        Intrinsics.checkNotNullParameter(r28, "dismissLoadingCallback");
        FlowFileProtectionService r1 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        boolean r2 = false;
        if (r17 == null) goto L20;
        if (r1 != null) goto L6;
    L8:
        boolean r6 = false;
    L9:
        if (r6 == false) goto L20;
        o r0 = o.a;
        JSONObject r3 = new JSONObject();
        r3.put("action", "save_album");
        r3.put("entry", "video_generate_saver");
        r3.put("channel", "album");
        r3.put("content_type", "video");
        Unit r4 = Unit.INSTANCE;
        r0.reportEvent("flow_enterprise_file_egress_block", r3);
        String r5 = r1.H0();
        if (r5 != null) goto L13;
    L18:
        r28.invoke(602, "", 0L, null);
        return;
    L13:
        if ((!StringsKt.isBlank(r5)) == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        s.j(s.a, r17, r5, null, false, 28);
        goto L18
    L6:
        if (r1.I0() != true) goto L8;
        r6 = true;
    L20:
        ICreationMetadataService.Companion r7 = ICreationMetadataService.a;
        Message r8 = r19.l;
        String r11 = r19.h;
        Integer r12 = r19.i;
        if (r12 == null) goto L23;
        String r13 = r12.toString();
    L24:
        UserCreationFromIM r9 = r7.I(r8, r11, r13);
        if (r9 == null) goto L27;
        final String r14 = r9.getCreationId();
    L28:
        if (r27 == false) goto L38;
        if (r18 == null) goto L31;
        String r10 = r18.a;
    L32:
        if (r10 != null) goto L34;
    L35:
        r2 = true;
    L36:
        if (r2 == true) goto L38;
        Function1<? super Continuation<? super String>, ? extends Object> r15 = new VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$1(r18, r26, null);
    L39:
        Function1<? super Continuation<? super String>, ? extends Object> r16 = r15;
        IVideoDownloadLoadingMgrService.a.getClass();
        IVideoDownloadLoadingMgrService r110 = (IVideoDownloadLoadingMgrService) IVideoDownloadLoadingMgrService.a.b.getValue();
        if (r110 == null) goto L43;
        final String r29 = r14;
        r110.b(r17, UUID.randomUUID().toString(), r18, r21, new b(r22, r18, r19, r20, r29, r24), r23, r25, r28, new c(r21, r14, r19), r16, r27);
        return;
    L43:
        return;
    L34:
        if (r10.length() != 0) goto L36;
    L31:
        r10 = null;
    L38:
        r15 = new VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2(r18, r26, null);
        goto L39
    L27:
        r14 = null;
        goto L28
    L23:
        r13 = null;
        goto L24
    }
}
