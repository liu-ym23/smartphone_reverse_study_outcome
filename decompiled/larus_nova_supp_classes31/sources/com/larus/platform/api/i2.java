package com.larus.platform.api;

import android.content.Context;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface i2 {

    public static final class a {
        public static /* synthetic */ void a(i2 r9, Message r10, String r11, boolean r12, String r13, Context r14, String r15, String r16) {
            r9.Q1(r10, r11, r12, r13, r14, r15, r16, null);
        }
    }

    void Q1(Message r1, String r2, boolean r3, String r4, Context r5, String r6, String r7, String r8);

    int R();

    String a(Message r1);

    String b(Message r1);

    String c(Message r1);

    String d(Message r1);

    Integer e(Message r1);
}
