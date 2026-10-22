package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenFragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.ExtraData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import f4b.d;
import f4b.e;
import f4b.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ActionContextCreator {
    public final Context a;
    public final Fragment b;
    public final v c;
    public final Chat d;
    public final MessageFullScreenLaunchData e;
    public final y6b.a<?> f;
    public Function2<? super String, ? super PageType, Unit> g;
    public Function3<? super String, ? super PageType, ? super PartialReplyInfo, Unit> h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageType.values().length];
            r0[PageType.CHAT_WINDOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[PageType.CHAT_THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[PageType.REPLY_IN_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[PageType.THREAD_WINDOW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[PageType.THREAD_DETAIL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public final Context getContext() {
        return this.a;
    }

    public final d a(View r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        MessageFullScreenLaunchData r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        Message r4 = r0.getMessage();
        if (r4 != null) goto L8;
        return null;
    L8:
        PageType r1 = this.e.getPageType();
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L11;
        Context r8 = this.a;
        Chat r3 = this.d;
        MessageFullScreenLaunchData r5 = this.e;
        f4b.a r6 = new f4b.a(r8, new f4b.c(r3, r4, r5, r5.getOpenApp(), this.f), this.b, this.c, r12);
        r6.i = this.e.getOpenApp();
        ExtraData r13 = this.e.getExtraData();
        if (r13 == null) goto L31;
        r13.isThreadDisplayMode();
    L31:
        return r6;
    L11:
        if (r2 != 2) goto L13;
        Context r9 = this.a;
        Chat r7 = this.d;
        MessageFullScreenLaunchData r10 = this.e;
        f4b.b r11 = new f4b.b(r9, new f4b.c(r7, r4, r10, r10.getOpenApp(), this.f), this.b, this.c, r12);
        r11.i = this.e.getOpenApp();
        return r11;
    L13:
        if (r2 != 3) goto L15;
        Context r14 = this.a;
        Chat r15 = this.d;
        MessageFullScreenLaunchData r16 = this.e;
        e r17 = new e(r14, new f4b.c(r15, r4, r16, r16.getOpenApp(), this.f), this.b, this.c, r12);
        r17.i = this.e.getOpenApp();
        r17.j = new ActionContextCreator$createActionContext$3$1(this);
        return r17;
    L15:
        if (r2 != 4) goto L17;
    L19:
        Context r18 = this.a;
        Chat r19 = this.d;
        MessageFullScreenLaunchData r20 = this.e;
        g r21 = new g(r18, new f4b.c(r19, r4, r20, r20.getOpenApp(), this.f), this.b, this.c, r12);
        ExtraData r110 = this.e.getExtraData();
        if (r110 == null) goto L22;
        r110.isThreadClosed();
    L22:
        new ActionContextCreator$createActionContext$4$1(this);
        return r21;
    L17:
        if (r2 == 5) goto L19;
        return null;
    }

    public ActionContextCreator(Context r2, MessageFullScreenFragment r3, v r4, Chat r5, MessageFullScreenLaunchData r6, y6b.a r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "chatContainer");
        Intrinsics.checkNotNullParameter(r5, "chat");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
