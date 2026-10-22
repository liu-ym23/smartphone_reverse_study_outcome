package com.ss.android.lark.chatwindow.launcher;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {

    public static final class a {
        public final String a;
        public final Chat b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Chat r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ChatWrapper(chatId=" + this.a + ", chat=" + this.b + ')';
        }

        public a(String r2, Chat r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final String a;

            public a(String r2) {
                Intrinsics.checkNotNullParameter(r2, ChameleonOpenTracker.ParamKey.ERRORMSG);
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.launcher.c$b$b, reason: collision with other inner class name */
        public static final class C0118b extends b {
            public final a a;

            public C0118b(a r2) {
                Intrinsics.checkNotNullParameter(r2, "chat");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    void U7(Context r1, Fragment r2, ChatBundleInput r3, IGetDataCallback<Unit> r4);
}
