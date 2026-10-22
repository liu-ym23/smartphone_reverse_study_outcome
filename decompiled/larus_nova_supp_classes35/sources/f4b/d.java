package f4b;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class d extends yya.a {
    public final Context d;
    public final c e;
    public final Fragment f;
    public final PageType g;
    public final v h;

    @Deprecated(message = "unused for full screen", replaceWith = @ReplaceWith(expression = "getMessage()", imports = {}))
    public final p5b.c k() {
        return null;
    }

    public final Chatter q() {
        return null;
    }

    public final Chatter u() {
        return null;
    }

    public final Message g() {
        return this.e.b;
    }

    public final <T extends x1b.b> T get() {
        v r0 = this.h;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type T of com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.action.FullScreenActionContext.get");
        return r0;
    }

    public FragmentActivity getActivity() {
        return this.f.requireActivity();
    }

    public final Chat getChat() {
        return this.e.a;
    }

    public final Message.Type l() {
        return this.e.b.getType();
    }

    public final v5b.c<?> m() {
        y6b.a<?> r0 = this.e.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final Fragment d() {
        return this.f;
    }

    public Context getContext() {
        return this.d;
    }

    public final PageType r() {
        return this.g;
    }

    public d(Context r2, c r3, Fragment r4, PageType r5, v r6, View r7) {
        Intrinsics.checkNotNullParameter(r2, "contextParam");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r4, "fragmentParam");
        Intrinsics.checkNotNullParameter(r5, "pageTypeParam");
        Intrinsics.checkNotNullParameter(r6, "chatContainer");
        Intrinsics.checkNotNullParameter(r7, "view");
        super(r7);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
    }
}
