package do8;

import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements a {
    public final AttachReceiver a;
    public final Function0<ChatParam> b;
    public final Function0<de8.c> c;
    public final Function0<BotModel> d;
    public final String e;
    public final Fragment f;
    public final com.larus.trace.tracknode.a g;
    public final q0 h;
    public final LruSet<String> i;
    public final Boolean j;
    public final fh8.f k;
    public final TextView l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;

    @Override // do8.a
    public final boolean a() {
        TextView r0 = this.l;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.performLongClick();
    }

    @Override // do8.a
    public final String b() {
        ChatParam r0 = (ChatParam) this.n.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    @Override // do8.a
    public final String getBotId() {
        Function0<BotModel> r0 = this.d;
        if (r0 == null) goto L8;
        BotModel r1 = (BotModel) r0.invoke();
        if (r1 == null) goto L8;
        String r2 = r1.getBotId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        y r3 = (y) this.m.getValue();
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.getBotId();
    }

    @Override // do8.a
    public final String getChatType() {
        de8.c r0 = (de8.c) this.o.getValue();
        if (r0 == null) goto L5;
        long r1 = r0.n;
    L6:
        LruCache<String, wc9.e> r2 = ko8.a.a;
        return ko8.a.e(r1);
    L5:
        r1 = 0;
        goto L6
    }

    @Override // do8.a
    public final String getConversationId() {
        String r0 = this.e;
        if (r0 != null) goto L9;
        y r1 = (y) this.m.getValue();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.Y1();
    L9:
        return r0;
    }

    @Override // do8.a
    public final String getCurrentPage() {
        ChatParam r0 = (ChatParam) this.n.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // do8.a
    public final Fragment getHostFragment() {
        Fragment r0 = this.f;
        if (r0 != null) goto L11;
        fh8.f r1 = this.k;
        if (r1 == null) goto L9;
        Function0 r2 = r1.m;
        if (r2 == null) goto L9;
        return (Fragment) r2.invoke();
    L9:
        return null;
    L11:
        return r0;
    }

    @Override // do8.a
    public final BotModel i() {
        Function0<BotModel> r0 = this.d;
        if (r0 == null) goto L6;
        BotModel r1 = (BotModel) r0.invoke();
        if (r1 == null) goto L6;
        return r1;
    L6:
        y r2 = (y) this.m.getValue();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.j0();
    }

    @Override // do8.a
    public final String j() {
        fh8.f r0 = this.k;
        if (r0 == null) goto L7;
        q0 r1 = r0.q;
        if (r1 == null) goto L7;
        List<Message> r2 = r1.getCurrentList();
    L9:
        return xc8.m.a(r2);
    L7:
        r2 = null;
        goto L9
    }

    @Override // do8.a
    public final CoroutineScope c() {
        Fragment r0 = getHostFragment();
        if (r0 == null) goto L8;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L8;
        return r1;
    L8:
        return CoroutineScopeKt.MainScope();
    }

    @Override // do8.a
    public final Boolean d() {
        return this.j;
    }

    @Override // do8.a
    public final q0 e() {
        return this.h;
    }

    @Override // do8.a
    public final com.larus.trace.tracknode.a f() {
        return this.g;
    }

    @Override // do8.a
    public final LruSet<String> g() {
        return this.i;
    }

    @Override // do8.a
    public final Boolean h(Message r2) {
        if (r2 == null) goto L10;
        fh8.f r0 = this.k;
        if (r0 == null) goto L8;
        q0 r1 = r0.q;
        if (r1 == null) goto L8;
        List<Message> r3 = r1.getCurrentList();
    L9:
        boolean r4 = xc8.m.b(r2, r3);
    L12:
        return Boolean.valueOf(r4);
    L8:
        r3 = null;
        goto L9
    L10:
        r4 = false;
        goto L12
    }

    public h(AttachReceiver r3, Function0 r4, Function0 r5, Function0 r6, String r7, Fragment r8, com.larus.trace.tracknode.a r9, q0 r10, LruSet r11, Boolean r12, fh8.f r13, TextView r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r15 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r15 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r15 & 128) == 0) goto L27;
        r10 = null;
    L27:
        if ((r15 & 256) == 0) goto L30;
        r11 = null;
    L30:
        if ((r15 & 512) == 0) goto L33;
        r12 = null;
    L33:
        if ((r15 & 1024) == 0) goto L36;
        r13 = null;
    L36:
        if ((r15 & 2048) == 0) goto L38;
        r14 = null;
    L38:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new d(this));
    }
}
