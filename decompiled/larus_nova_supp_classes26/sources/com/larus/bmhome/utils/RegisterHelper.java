package com.larus.bmhome.utils;

import com.larus.bmhome.rc.ResourceCenterPostUploadSupport;
import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.utils.logger.FLogger;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RegisterHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public RegisterHelper() {
    }

    public static final Object a(String r38, String r39, String r40, ResourceAttachmentExtra r41, ResourceInstantUploadInfo r42, Image r43, Continuation r44) {
        ResourceCenterPostUploadSupport r0 = ResourceCenterPostUploadSupport.a;
        mr9.l r1 = new mr9.l(r38, null, null, null, null, false, null, 126);
        if (r43 == null) goto L5;
        int r19 = UplinkEntityType.EntityTypeImage.getValue();
        UplinkFileEntity r2 = new UplinkFileEntity(Integer.valueOf(r19), new UplinkEntityContent(null, Image.copy$default(r43, null, null, null, null, null, null, r39, null, null, null, null, null, null, null, 16319, null), 1, null), r39, null, null, null, null, null, null, false, null, null, null, null, 16376, null);
    L7:
        return ResourceCenterPostUploadSupport.b(r1, r2, r41, r40, r39, FlowResourceType.Image, r42, null, r44, 128);
    L5:
        r2 = null;
        goto L7
    }

    public static void b(String r15, String r16, String r17, String r18, String r19, String r20, ResourceUploadInstantInfo r21, Image r22, String r23) {
        Intrinsics.checkNotNullParameter(r18, "tosKey");
        Intrinsics.checkNotNullParameter(r19, "sceneId");
        FLogger r0 = FLogger.a;
        r0.i("RegisterHelper", "registerResource tosKey#" + r18 + " msgId#" + r15);
        if (r15 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r0.e("RegisterHelper", "registerResource localMessageId is null");
        return;
    L12:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RegisterHelper$registerResource$1(r20, r21, r19, r17, r16, r23, r15, r18, r22, null), 2, null);
        return;
    L5:
        if (r15.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static /* synthetic */ void c(String r12, String r13, String r14, String r15, String r16, ResourceUploadInstantInfo r17, Image r18, String r19, int r20) {
        if ((r20 & 16) == 0) goto L5;
        String r7 = "";
    L7:
        if ((r20 & 32) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r20 & 64) == 0) goto L13;
        ResourceUploadInstantInfo r9 = null;
    L15:
        if ((r20 & 128) == 0) goto L17;
        Image r10 = null;
    L19:
        if ((r20 & 256) == 0) goto L21;
        String r11 = null;
    L22:
        b(r12, r13, r14, r15, r7, r8, r9, r10, r11);
        return;
    L21:
        r11 = r19;
        goto L22
    L17:
        r10 = r18;
        goto L19
    L13:
        r9 = r17;
        goto L15
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = null;
        goto L7
    }
}
