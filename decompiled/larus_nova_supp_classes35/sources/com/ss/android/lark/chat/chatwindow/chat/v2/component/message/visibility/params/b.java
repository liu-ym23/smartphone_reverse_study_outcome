package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public a a;

    public static final class a {
        public final AIRecommendQuestions a;
        public final List<?> b;
        public final boolean c;
        public final boolean d;
        public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.a e;

        public a(AIRecommendQuestions r2, List<?> r3, boolean r4, boolean r5, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.a r6) {
            Intrinsics.checkNotNullParameter(r2, "summary");
            Intrinsics.checkNotNullParameter(r3, "messageList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public b() {
    }
}
