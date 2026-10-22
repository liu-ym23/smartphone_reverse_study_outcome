package com.ss.android.lark.integrator.im.impl;

import android.content.Context;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.api.z;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.mergeforward.FlowMergeForwardLauncher$startMergeForwardDetailActivityByDoubao$callback$1;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements z {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void a(Context r10, Message r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, INotificationHitPoint.NoticeType.MESSAGE);
        int r0 = FlowChatModule.d;
        egb.e r1 = FlowChatModule.a.a().a().getForwardDependency();
        String r2 = r11.getSourceId();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        egb.d.a(r1, r10, 1, r11, r2, false, null, 80);
    }

    public final void b(Context r4, Message r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "msg");
        int r2 = FlowChatModule.d;
        FlowChatModule.a.a().getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "msg");
        KeyboardUtils.hideKeyboard(r4);
        com.ss.android.lark.flow.mergeforward.c.c(r4, r5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1] */
    public final void c(final Context r6, final com.ss.android.lark.biz.im.api.i r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "data");
        int r2 = FlowChatModule.d;
        FlowChatModule.a.a().getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "data");
        KeyboardUtils.hideKeyboard(r6);
        int r1 = com.ss.android.lark.flow.mergeforward.c.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "doubaoForwardData");
        ByteString r0 = r7.c;
        List<String> r3 = r7.b;
        int r4 = 0;
        if (r0 == null) goto L5;
        final boolean r5 = true;
    L6:
        final IGetDataCallback<Message> r8 = new FlowMergeForwardLauncher$startMergeForwardDetailActivityByDoubao$callback$1(r5, r6, r7);
        int r9 = com.ss.android.lark.mergeforward.c.a;
        Intrinsics.checkNotNullParameter(r8, "callback");
        StringBuilder r10 = new StringBuilder("parseDoubaoForwardData start: messageByteSize=");
        if (r0 == null) goto L9;
        int r11 = r0.size();
    L10:
        r10.append(r11);
        r10.append(", messageIdsCount=");
        if (r3 == null) goto L13;
        r4 = r3.size();
    L13:
        r10.append(r4);
        Log.i("ParseMergeForwardDataUtils", r10.toString());
        if (r0 == null) goto L16;
        final String r12 = "parseServerMessage";
        ImSdkService.f().Z8(CollectionsKt.listOf(r0), new ParseMergeForwardDataUtils$wrapCallback$1(r12, r8));
        return;
    L16:
        if (r3 == null) goto L18;
        final String r13 = "packMergeForwardMessage";
        ImSdkService.f().Jc(null, r3, new ParseMergeForwardDataUtils$wrapCallback$1(r13, r8));
        return;
    L18:
        Log.e("ParseMergeForwardDataUtils", "parseDoubaoForwardData failed: messageByte & messageIds are null");
        r8.onError(new ErrorResult("parseDoubaoForwardData failed: messageByte & messageIds are null"));
        return;
    L9:
        r11 = 0;
        goto L10
    L5:
        r5 = false;
        goto L6
    }
}
