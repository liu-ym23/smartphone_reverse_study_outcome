package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ MessageListRendererFeature a;

    public m(MessageListRendererFeature r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        List<? extends y6b.c<?>> r7 = (List) r6;
        PerfLog.start("chat_show_message_list", BuildConfig.FLAVOR);
        com.ss.android.lark.chat.chatwindow.chat.a r0 = this.a.I();
        Intrinsics.checkNotNull(r7);
        r0.setData(r7);
        ChatCoreModule.a().getPerfEnterChatMonitor().i();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r1 = this.a.H();
        if (r1 == null) goto L5;
        r1.m0(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.i.a);
    L5:
        this.a.I().q0(new k(this.a));
        MessageListRendererFeature r2 = this.a;
        if (r2.n == true) goto L10;
        r2.n = true;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r3 = r2.H();
        if (r3 == null) goto L10;
        r3.m0(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.h.a);
    L10:
        PointRecoderRecyclerView r4 = this.a.d;
        RecyclerView r5 = null;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r4 = null;
    L13:
        r4.post(new l(this.a));
        StringBuilder r8 = new StringBuilder("list update, ");
        r8.append(r7.size());
        r8.append(", ");
        PointRecoderRecyclerView r9 = this.a.d;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r9 = null;
    L16:
        r8.append(r9.hashCode());
        r8.append(", ");
        RecyclerView r10 = this.a.d;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
    L20:
        r8.append(r5.isAttachedToWindow());
        Log.i("MessageListRendererFeature", r8.toString());
        return;
    L19:
        r5 = r10;
        goto L20
    }
}
