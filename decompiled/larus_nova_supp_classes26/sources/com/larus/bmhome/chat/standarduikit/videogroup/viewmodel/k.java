package com.larus.bmhome.chat.standarduikit.videogroup.viewmodel;

import android.widget.TextView;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import xc8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements e {
    public final fh8.f a;
    public final TextView b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    public static final class b implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class c implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class d implements Function0<ChatParam> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(ChatParam.class));
        }
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final void a() {
        this.b.performLongClick();
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final String b() {
        ChatParam r0 = (ChatParam) this.d.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final Boolean d() {
        o r0 = (o) this.g.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.i0());
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final String getBotId() {
        y r0 = (y) this.f.getValue();
        if (r0 == null) goto L8;
        BotModel r1 = r0.j0();
        if (r1 == null) goto L8;
        String r2 = r1.getBotId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        fh8.f r3 = this.a;
        if (r3 == null) goto L13;
        Message r4 = r3.b;
        if (r4 == null) goto L13;
        return r4.getSenderId();
    L13:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final String getChatType() {
        LruCache<String, wc9.e> r0 = ko8.a.a;
        de8.c r1 = (de8.c) this.e.getValue();
        if (r1 == null) goto L5;
        long r2 = r1.n;
    L7:
        return ko8.a.e(r2);
    L5:
        r2 = 0;
        goto L7
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final String getConversationId() {
        y r0 = (y) this.f.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y1();
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final String getCurrentPage() {
        ChatParam r0 = (ChatParam) this.d.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final String j() {
        fh8.f r0 = this.a;
        if (r0 == null) goto L7;
        q0 r1 = r0.q;
        if (r1 == null) goto L7;
        List<Message> r2 = r1.getCurrentList();
    L9:
        return m.a(r2);
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
    public final Boolean h(Message r2) {
        if (r2 == null) goto L10;
        fh8.f r0 = this.a;
        if (r0 == null) goto L8;
        q0 r1 = r0.q;
        if (r1 == null) goto L8;
        List<Message> r3 = r1.getCurrentList();
    L9:
        boolean r4 = m.b(r2, r3);
    L12:
        return Boolean.valueOf(r4);
    L8:
        r3 = null;
        goto L9
    L10:
        r4 = false;
        goto L12
    }

    public k(fh8.f r2, TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new f(this));
        this.d = LazyKt.lazy(new g(this));
        this.e = LazyKt.lazy(new h(this));
        this.f = LazyKt.lazy(new i(this));
        this.g = LazyKt.lazy(new j(this));
    }
}
