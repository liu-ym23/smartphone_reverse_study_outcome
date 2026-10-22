package com.bytedance.android.livesdk.interactivity.api.publicscreen.listener;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import kotlin.Metadata;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/listener/ITextMessageView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITextMessageView extends IWidget {
    void Br(String r1);

    void DD(int r1, int r2, long r3);

    void Ev();

    void V50(int r1, boolean r2);

    void VA(int r1, long r2);

    void XD(int r1, long r2);

    void ZE();

    void a40();

    boolean d();

    /* synthetic */ Context getContext();

    void lU(d r1);

    void pa(int r1);

    void sU(int r1);
}
