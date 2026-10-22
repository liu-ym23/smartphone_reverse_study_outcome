package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements Runnable {
    public final /* synthetic */ MediaContentBlock a;
    public final /* synthetic */ MediaContentBlock.b b;
    public final /* synthetic */ y6b.a<MediaContentVO> c;

    public q(MediaContentBlock r1, MediaContentBlock.b r2, y6b.a<MediaContentVO> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        mya.h r0 = this.a.c.j5();
        FragmentActivity r1 = this.a.c.getContext();
        ImageView r2 = this.b.b;
        y6b.a<MediaContentVO> r3 = this.c;
        b3b.j r4 = (b3b.j) this.a.j.getValue();
        v4b.d r5 = this.a.e;
        w4b.u r6 = MessagePermissionUtil.a;
        com.ss.android.lark.chat.utils.d0.b(r1, r2, r3, r4, r0);
        ChatCoreModule.a().getChatDependency().s(this.a.c, this.c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
