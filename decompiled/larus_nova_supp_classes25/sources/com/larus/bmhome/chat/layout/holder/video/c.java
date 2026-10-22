package com.larus.bmhome.chat.layout.holder.video;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusVideoPreviewCardBinding;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.home.impl.sdk.b1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ GenerateVideoBox a;
    public final /* synthetic */ AiGenVideoContentData b;

    public /* synthetic */ c(GenerateVideoBox r1, AiGenVideoContentData r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r32) {
        final GenerateVideoBox r1 = this.a;
        AiGenVideoContentData r2 = this.b;
        Intrinsics.checkNotNullParameter((ImageView) r32, "it");
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L6;
        r3.D0();
        b1.a.c("chat_thumbnail_download");
    L6:
        if (r1.A == true) goto L44;
        LarusVideoPreviewCardBinding r4 = r1.z;
        if (r4 == null) goto L13;
        ProgressBar r5 = r4.e;
        if (r5 == null) goto L13;
        e1.x(r5);
    L13:
        LarusVideoPreviewCardBinding r6 = r1.z;
        if (r6 == null) goto L18;
        ImageView r7 = r6.d;
        if (r7 == null) goto L18;
        e1.q(r7);
    L18:
        r1.A = true;
        q0.a r8 = r1.u;
        if (r8 == null) goto L43;
        LifecycleCoroutineScope r10 = r8.F9();
        if (r10 == null) goto L43;
        ICreationMetadataService.Companion r9 = ICreationMetadataService.a;
        Map r14 = r9.s(r9.I(r1.x, null, "0"), null);
        VideoGenerateSaver r11 = VideoGenerateSaver.a;
        Context r12 = r1.getContext();
        nr9.g r13 = ff8.a.a(r2);
        q0.a r15 = r1.u;
        if (r15 == null) goto L28;
        y r16 = r15.u0();
        if (r16 == null) goto L28;
        String r17 = r16.getBotId();
    L29:
        Message r18 = r1.p;
        if (r18 == null) goto L32;
        String r19 = r18.getMessageId();
    L33:
        ChatControlTrace r20 = ChatControlTrace.b;
        r20.getClass();
        String r110 = r20.bb(ChatControlTrace.y);
        Message r21 = r1.p;
        if (r21 == null) goto L36;
        String r25 = tz9.a.a(r21);
    L37:
        c4 r22 = new c4(r17, r19, r110, null, null, null, null, null, 1, r25, null, r1.p, null, null, 13560);
        boolean r111 = z2.a.Q3();
        JSONObject r112 = r1.n();
        Integer r23 = r2.getTaskType();
        if (r23 == null) goto L40;
        String r113 = DataConverterKt.h(r23.intValue());
    L41:
        com.larus.bmhome.video.save_share.a.a.a(r11, r12, r13, r22, "overview_click", r10, false, r111, r112, r14, r113, true, new e(r1), 32);
        return Unit.INSTANCE;
    L40:
        r113 = null;
        goto L41
    L36:
        r25 = null;
        goto L37
    L32:
        r19 = null;
    L28:
        r17 = null;
    L43:
        return Unit.INSTANCE;
    L44:
        return Unit.INSTANCE;
    }
}
