package com.ss.android.lark.flow.chat.file;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import b3b.h;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.biz.officesdk.im.file.FlowFilePreviewData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import jza.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowFileMessageClickListener implements h {
    public final Chat a;
    public final Context b;
    public final IMessageListViewModel c;
    public final m2b.a d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.b;
    }

    public final void q(String r12) {
        Intrinsics.checkNotNullParameter(r12, "messageId");
        IMessageListViewModel r0 = this.c;
        if (r0 == null) goto L32;
        MessageInfo r13 = r0.getMessageInfoById(r12);
        if (r13 != null) goto L8;
        return;
    L8:
        if (r13.getMessage().getType() == Message.Type.FILE) goto L10;
        return;
    L10:
        m2b.a r1 = this.d;
        if (r1 != null) goto L13;
        return;
    L13:
        Fragment r2 = r1.R();
        if (r2 == null) goto L33;
        final LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
        if (r3 == null) goto L35;
        Message r14 = r13.getMessage();
        FileContent r4 = r14.getContent();
        if ((r4 instanceof FileContent) == false) goto L21;
        FileContent r5 = r4;
    L22:
        if (r5 != null) goto L24;
        return;
    L24:
        String r6 = r5.getName();
        final FlowFilePreviewData r7 = FlowFilePreviewData.a(((c) this.e.getValue()).a(r14.getId(), null, r6, r5.getKey(), r14, this.a), FlowFilePreviewData.Source.LOCAL, "imkey://" + r5.getKey(), FileUtils.k(r6), null, 413);
        if (((c) this.e.getValue()).b(this.b, r14, this.a) == false) goto L27;
        return;
    L27:
        final jza.b r15 = OfficeSDKManager.getHostGlobalService(jza.b.class);
        if (r15 != null) goto L30;
        return;
    L30:
        ((c) this.e.getValue()).c(this.b, r7, new FlowFileMessageClickListener$onFileClick$1(r15, this, r3, r7));
        return;
    L21:
        r5 = null;
        goto L22
    L35:
        return;
    L33:
        return;
    }

    public FlowFileMessageClickListener(Chat r2, Context r3, IMessageListViewModel r4, m2b.a r5) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = LazyKt.lazy(FlowFileMessageClickListener$fileSecurityService$2.INSTANCE);
    }
}
