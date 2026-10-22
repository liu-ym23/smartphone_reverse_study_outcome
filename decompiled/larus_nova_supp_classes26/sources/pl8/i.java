package pl8;

import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.p0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import va8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements pl8.a {
    public final fh8.f a;
    public final TextView b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

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

    public static final class d implements Function0<p> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p.class));
        }
    }

    public static final class e implements Function0<ChatParam> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    @Override // pl8.a
    public final void a() {
        this.b.performLongClick();
    }

    @Override // pl8.a
    public final String b() {
        ChatParam r0 = (ChatParam) this.d.getValue();
        if (r0 == null) goto L8;
        String r1 = r0.c;
        if (r1 == null) goto L8;
        String r2 = p0.a(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        fh8.f r3 = this.a;
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.f;
    }

    @Override // pl8.a
    public final LifecycleCoroutineScope c() {
        Fragment r0 = (Fragment) this.i.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r0);
    }

    @Override // pl8.a
    public final Boolean d() {
        o r0 = (o) this.g.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.i0());
    }

    @Override // pl8.a
    public final com.larus.trace.tracknode.a f() {
        com.larus.trace.tracknode.a r0 = (Fragment) this.i.getValue();
        if ((r0 instanceof com.larus.trace.tracknode.a) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    @Override // pl8.a
    public final q0 getAdapter() {
        fh8.f r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q;
    }

    @Override // pl8.a
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

    @Override // pl8.a
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

    @Override // pl8.a
    public final String getConversationId() {
        y r0 = (y) this.f.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.Y1();
        if (r1 == null) goto L6;
        return r1;
    L6:
        fh8.f r2 = this.a;
        if (r2 == null) goto L11;
        Message r3 = r2.b;
        if (r3 == null) goto L11;
        return r3.getConversationId();
    L11:
        return null;
    }

    @Override // pl8.a
    public final String getCurrentPage() {
        ChatParam r0 = (ChatParam) this.d.getValue();
        if (r0 == null) goto L8;
        String r1 = r0.d;
        if (r1 == null) goto L8;
        String r2 = p0.a(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        fh8.f r3 = this.a;
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.e;
    }

    @Override // pl8.a
    public final FragmentManager getFragmentManager() {
        Fragment r0 = (Fragment) this.i.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getParentFragmentManager();
    }

    @Override // pl8.a
    public final BotModel i() {
        y r0 = (y) this.f.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j0();
    }

    public i(fh8.f r2, TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new pl8.b(this));
        this.d = LazyKt.lazy(new pl8.c(this));
        this.e = LazyKt.lazy(new pl8.d(this));
        this.f = LazyKt.lazy(new pl8.e(this));
        this.g = LazyKt.lazy(new f(this));
        this.h = LazyKt.lazy(new g(this));
        this.i = LazyKt.lazy(new h(this));
    }
}
