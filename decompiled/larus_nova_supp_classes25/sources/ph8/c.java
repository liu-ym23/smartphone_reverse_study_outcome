package ph8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import fh8.s;
import fh8.u;
import java.util.Map;
import km8.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements usc.f {
    public final Context a;
    public final Lazy b;
    public g c;
    public final Lazy d;
    public Integer e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/markdown/memory/FlowMemoryWidget$listTypeToken$2$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/chat/markdown/memory/MemoryItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<e> {
        public b() {
        }
    }

    static {
    }

    public final void a() {
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final void f() {
    }

    public final View asView() {
        return ((hm8.c) this.b.getValue()).b();
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new ph8.a(this));
        this.d = LazyKt.lazy(new ph8.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Size d(TextView r20, Spanned r21, final usc.e r22, int r23, Map<String, ? extends Object> r24) {
        Intrinsics.checkNotNullParameter(r20, "textView");
        Intrinsics.checkNotNullParameter(r21, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r22, "span");
        final b r6 = (b) this.d.getValue();
        Intrinsics.checkNotNullParameter("FlowMemoryWidgetBinder", "source");
        Intrinsics.checkNotNullParameter(r21, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r22, "span");
        Intrinsics.checkNotNullParameter(r6, "data");
        int r4 = r21.getSpanStart(r22);
        int r5 = r21.getSpanEnd(r22);
        boolean r8 = true;
        if (r4 != 0) goto L5;
        boolean r7 = true;
    L7:
        if (r5 == r21.length()) goto L10;
        r8 = false;
    L10:
        Message r9 = null;
        if (r24 != null) goto L62;
        Object r0 = null;
    L15:
        if ((r0 instanceof fh8.f) == false) goto L17;
        final fh8.f r1 = (fh8.f) r0;     // Catch: Exception -> L24
    L18:
        Function0 r11 = new u(r22, r1, r6);     // Catch: Exception -> L24
        if (TypeIntrinsics.isFunctionOfArity(r11, 0) == false) goto L21;
        u r12 = r11;
    L22:
        s r10 = new s(r1, r12, r7, r8);     // Catch: Exception -> L24
    L26:
        if (r10 == null) goto L30;
        fh8.f r2 = r10.a;
        if (r2 == null) goto L30;
        q0 r17 = r2.q;
    L31:
        if (r10 == null) goto L35;
        fh8.f r3 = r10.a;
        if (r3 == null) goto L35;
        AttachReceiver r13 = r3.o;
    L36:
        this.c = new g(r13, null, null, null, null, r17, 30);
        if (r10 == null) goto L41;
        Function0<T> r14 = r10.b;
        if (r14 == 0) goto L41;
        e r15 = (e) r14.invoke();
    L42:
        if (r15 != null) goto L46;
        return new Size(0, 0);
    L46:
        if (r10.c == false) goto L50;
        Pair r16 = new Pair(0, Integer.valueOf(i5.r0()));
    L48:
        Pair r18 = r16;
        fh8.f r19 = r10.a;
        if (r19 == null) goto L56;
        r9 = r19.b;
    L56:
        Message r110 = r9;
        Integer r25 = this.e;
        if (r25 != null) goto L60;
        ri8.c r26 = ri8.c.a;
        r25 = ri8.c.k(r21, r22);
        this.e = r25;
    L60:
        km8.a r27 = new km8.a(r18, r23, r110, r15, r25);
        ((hm8.c) this.b.getValue()).a(r27, this.c);
        hm8.c r28 = (hm8.c) this.b.getValue();
        r28.getClass();
        Intrinsics.checkNotNullParameter(r27, "vmData");
        return r28.b().f(r28.d, r23);
    L50:
        if (r10.d == false) goto L52;
        r16 = new Pair(Integer.valueOf(i5.r0()), 0);
        goto L48
    L52:
        r16 = new Pair(Integer.valueOf(i5.r0()), Integer.valueOf(i5.r0()));
    L41:
        r15 = null;
    L35:
        r13 = null;
    L30:
        r17 = null;
    L24:
        e = move-exception;
        FLogger.a.e("FlowMemoryWidgetBinder", "bindData called failed, " + e.getMessage());
        EnsureManager.ensureNotReachHere(e);
        r10 = null;
        goto L26
    L21:
        r12 = 0;
        goto L22
    L17:
        r1 = null;
        goto L18
    L62:
        r0 = r24.get("markdown_common_input_data");     // Catch: Exception -> L24
        goto L15
    L5:
        r7 = false;
        goto L7
    }
}
