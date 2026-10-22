package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.preview.actions.ActionImpl;
import com.ss.android.lark.export.entity.preview.Parameters;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ InitChatPreviewTask b;

    public a(Context r1, InitChatPreviewTask r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(Context r2, String r3, String r4) {
        if (r2 != null) goto L5;
        r2 = this.a;
    L5:
        if (r2 != null) goto L8;
        Log.e("[URLPreview]InitChatPreviewTask", "context is null, open url failed");
        return;
    L8:
        if (r3 != null) goto L11;
        Log.e("[URLPreview]InitChatPreviewTask", "url is null. previewId: " + r4);
        return;
    L11:
        int r5 = FlowChatModule.d;
        FlowChatModule.a.a().a().getBrowserDependency().openUrl(r2, r3);
    }

    public final void b(Parameters r2, String r3, ActionImpl.onActionTriggered.1 r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        IIMApi r0 = InitChatPreviewTask.j(this.b);
        if (r0 == null) goto L5;
        r0.putReviewAction(r2, r3, r4);
        return;
    L5:
        this.b.getClass();
        CoreThreadPool.getDefault().getUIExecutor().execute(new i(r4));
    }

    public final void c(String r11, String r12, String r13, String r14, String r15, String r16, String r17, Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r13, "clickParam");
        Intrinsics.checkNotNullParameter(r18, "messageParams");
        IIMApi r1 = InitChatPreviewTask.j(this.b);
        if (r1 == null) goto L6;
        r1.sendUrlClick(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    }
}
