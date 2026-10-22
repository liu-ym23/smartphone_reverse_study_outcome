package com.ss.android.lark.flow.chat.message.image;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kza.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static void a(String r6, List r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "photoItems");
        if (r8 >= 0) goto L5;
    L77:
        Log.e("FlowMediaSecurityAuditHelper", "reportPreviewAudit, invalid currentPosition: " + r8 + ", photoItems: " + r7.size());
        return;
    L5:
        if (r8 >= r7.size()) goto L77;
        PhotoItem r9 = (PhotoItem) ListProtector.get(r7, r8);
        boolean r1 = false;
        String r3 = "video";
        if ((r9 instanceof FlowPhotoItem) == false) goto L36;
        m r10 = ((FlowPhotoItem) r9).getPreviewItem();
        if (r10 != null) goto L12;
        Log.e("FlowMediaSecurityAuditHelper", "reportFlowPreviewAudit failed, previewItem is null");
        return;
    L12:
        int r11 = a.a[r10.getType().ordinal()];
        if (r11 != 1) goto L15;
        r3 = LoadParams.ImageFormat.IMAGE;
    L20:
        String r12 = r10.d;
        if (r6 != null) goto L23;
    L26:
        boolean r13 = true;
    L27:
        if (r13 == false) goto L29;
    L34:
        Log.e("FlowMediaSecurityAuditHelper", "reportFlowPreviewAudit failed, chatId or fileId is empty");
        return;
    L29:
        if (r12.length() != 0) goto L31;
        r1 = true;
    L31:
        if (r1 == true) goto L34;
        ChatCoreModule.a().getAuditDependency().e(r6, r12, r3, r3);
        return;
    L23:
        if (r6.length() == 0) goto L26;
        r13 = false;
        goto L27
    L15:
        if (r11 == 2) goto L20;
        throw new NoWhenBranchMatchedException();
    L36:
        w4b.a r14 = ChatCoreModule.a().getAuditDependency();
        if (r9.isVideo() == false) goto L59;
        MessageIdentity r4 = r9.getMessageIdentity();
        if (r4 == null) goto L42;
        String r5 = r4.getMessageId();
        if (r5 == null) goto L42;
    L43:
        if (r6 != null) goto L45;
    L48:
        boolean r15 = true;
    L49:
        if (r15 == true) goto L57;
        if (r5 != null) goto L52;
    L53:
        r1 = true;
    L54:
        if (r1 == true) goto L57;
        r14.e(r6, r5, "video", "video");
        return;
    L52:
        if (r5.length() != 0) goto L54;
    L57:
        Log.e("FlowMediaSecurityAuditHelper", "reportPreviewAudit video failed, chatId or fileId is empty");
        return;
    L45:
        if (r6.length() == 0) goto L48;
        r15 = false;
    L42:
        r5 = r9.getMessageId();
        goto L43
    L59:
        String r16 = r9.getImageKey();
        if (r6 != null) goto L62;
    L65:
        boolean r17 = true;
    L66:
        if (r17 == true) goto L75;
        if (r16 != null) goto L69;
    L70:
        r1 = true;
    L71:
        if (r1 == true) goto L75;
        r14.e(r6, r16, LoadParams.ImageFormat.IMAGE, LoadParams.ImageFormat.IMAGE);
        return;
    L69:
        if (r16.length() != 0) goto L71;
    L75:
        Log.e("FlowMediaSecurityAuditHelper", "reportPreviewAudit image failed, chatId or imageKey is empty");
        return;
    L62:
        if (r6.length() == 0) goto L65;
        r17 = false;
        goto L66
    }
}
