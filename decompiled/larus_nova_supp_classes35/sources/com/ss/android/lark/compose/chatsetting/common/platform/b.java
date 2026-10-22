package com.ss.android.lark.compose.chatsetting.common.platform;

import android.content.Context;
import com.lark.kmp.pb.basic.v1.Chat;
import com.ss.android.lark.compose.chatsetting.report.ChatSettingFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {
    boolean a(Context r1, ChatSettingFunction r2);

    void b(Chat.Type r1, boolean r2, boolean r3);

    Object c(Context r1, String r2);

    boolean d(Context r1);

    Object e(Context r1, e r2);

    Object f(Context r1);

    boolean g(Context r1);

    void h(Chat r1);

    Object i(Context r1, d r2);

    void j(String r1, boolean r2);

    Object k(Context r1, String r2, CoroutineScope r3);

    void l(String r1, boolean r2);

    void m(Context r1, Throwable r2);

    void n(Context r1, c r2);

    void o(ChatSettingTrackEvent r1, Boolean r2);
}
