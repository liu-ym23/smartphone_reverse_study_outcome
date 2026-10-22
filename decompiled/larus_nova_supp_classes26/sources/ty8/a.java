package ty8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements jy9.a {
    public final BotModel a;
    public final Message b;
    public final com.larus.trace.tracknode.a c;
    public final CoroutineScope d;
    public final q0 e;
    public final int f;
    public final Context g;
    public final View h;
    public final int i;
    public final Function0<List<Message>> j;
    public final jy9.c k;

    public a() {
        throw null;
    }

    public final void b() {
    }

    public final boolean d() {
        return false;
    }

    public final Function4<g, String, Map<String, String>, Map<String, String>, Unit> e() {
        return null;
    }

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(null, null) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(null, null) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        BotModel r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        Message r3 = this.b;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) * 31;
        com.larus.trace.tracknode.a r6 = this.c;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r5 + r7) * 31) + this.d.hashCode()) * 31;
        q0 r9 = this.e;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (((((r8 + r10) * 31) + this.f) * 31) + this.g.hashCode()) * 31;
        View r12 = this.h;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (((r11 + r13) * 31) + this.i) * 31;
        Function0<List<Message>> r15 = this.j;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        jy9.c r18 = this.k;
        if (r18 != null) goto L29;
        int r19 = 0;
    L31:
        return ((((((r17 + r19) * 31) + 0) * 31) + 0) * 31) + 0;
    L29:
        r19 = r18.hashCode();
        goto L31
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatGalleryContext(botModel=" + this.a + ", message=" + this.b + ", trackNode=" + this.c + ", scope=" + this.d + ", adapter=" + this.e + ", clickPosition=" + this.f + ", context=" + this.g + ", startView=" + this.h + ", clickMessageIndex=" + this.i + ", messageListProvider=" + this.j + ", beautifyEnv=" + this.k + ", chatSession=null, chatInput=null, chatCamera=null)";
    }

    public final Fragment g() {
        q0 r0 = getAdapter();
        if (r0 == null) goto L7;
        Function0 r1 = r0.getHostFragment();
        if (r1 == null) goto L7;
        return (Fragment) r1.invoke();
    L7:
        return null;
    }

    public final jy9.c a() {
        return this.k;
    }

    public final Function0<List<Message>> c() {
        return this.j;
    }

    public final com.larus.trace.tracknode.a f() {
        return this.c;
    }

    public final q0 getAdapter() {
        return this.e;
    }

    public Context getContext() {
        return this.g;
    }

    public final Message getMessage() {
        return this.b;
    }

    public final CoroutineScope getScope() {
        return this.d;
    }

    public final BotModel i() {
        return this.a;
    }

    public a(BotModel r3, Message r4, com.larus.trace.tracknode.a r5, CoroutineScope r6, q0 r7, int r8, Context r9, View r10, int r11, int r12) {
        if ((r12 & 32) == 0) goto L6;
        r8 = 0;
    L6:
        if ((r12 & 128) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 256) == 0) goto L11;
        r11 = -1;
    L11:
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r9, "context");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = null;
        this.k = null;
    }
}
