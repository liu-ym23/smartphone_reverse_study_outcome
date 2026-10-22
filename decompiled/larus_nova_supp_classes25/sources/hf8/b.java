package hf8;

import android.view.View;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.handler.q;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import fh8.f;
import fh8.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import lw8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public r A;
    public Function0<? extends Map<String, ? extends Object>> B;
    public Integer C;
    public View D;
    public boolean E;
    public String F;
    public ConcurrentHashMap<String, CharSequence> a;
    public Message b;
    public BotModel c;
    public ChatParam d;
    public f e;
    public q0 f;
    public Boolean g;
    public d h;
    public q0.a i;
    public AttachReceiver j;
    public v0 k;
    public ThreeLoadingIndicator l;
    public Function2<? super CustomMarkdownTextView, ? super Long, Unit> m;
    public Function2<? super CustomMarkdownTextView, ? super st8.a, Unit> n;
    public Integer o;
    public Boolean p;
    public String q;
    public Boolean r;
    public Boolean s;
    public Boolean t;
    public q u;
    public Function1<? super CustomMarkdownTextView, Unit> v;
    public Function1<? super CustomMarkdownTextView, Unit> w;
    public final boolean x;
    public Map<String, ? extends Object> y;
    public Block z;

    public final a a() {
        ConcurrentHashMap<String, CharSequence> r2 = this.a;
        Message r1 = this.b;
        if (r1 != null) goto L5;
        r1 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L5:
        Message r3 = r1;
        BotModel r4 = this.c;
        if (r4 != null) goto L8;
        r4 = new BotModel(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
    L8:
        BotModel r5 = r4;
        ChatParam r6 = this.d;
        if (r6 != null) goto L11;
        ChatParam r7 = new ChatParam(null, null, null, null, null, 255);
    L12:
        f r8 = this.e;
        q0 r9 = this.f;
        Boolean r10 = this.g;
        d r11 = this.h;
        if (r11 != null) goto L15;
        r11 = new d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    L15:
        d r12 = r11;
        q0.a r13 = this.i;
        AttachReceiver r14 = this.j;
        v0 r15 = this.k;
        ThreeLoadingIndicator r16 = this.l;
        Function2<? super CustomMarkdownTextView, ? super Long, Unit> r17 = this.m;
        Function2<? super CustomMarkdownTextView, ? super st8.a, Unit> r18 = this.n;
        Integer r19 = this.o;
        Boolean r20 = this.p;
        if (r20 == null) goto L18;
        boolean r110 = r20.booleanValue();
    L19:
        String r21 = this.q;
        if (r21 != null) goto L22;
        r21 = "";
    L22:
        String r111 = r21;
        Boolean r22 = this.r;
        if (r22 == null) goto L25;
        boolean r23 = r22.booleanValue();
    L26:
        Boolean r24 = this.s;
        if (r24 == null) goto L29;
        boolean r25 = r24.booleanValue();
    L30:
        Boolean r26 = this.t;
        if (r26 == null) goto L33;
        boolean r35 = r26.booleanValue();
    L34:
        boolean r112 = r110;
        boolean r113 = r23;
        boolean r27 = r25;
        boolean r28 = r35;
        return new a(r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r112, r111, r113, r27, r28, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F);
    L33:
        r35 = false;
        goto L34
    L29:
        r25 = false;
        goto L30
    L25:
        r23 = false;
        goto L26
    L18:
        r110 = false;
        goto L19
    L11:
        r7 = r6;
        goto L12
    }

    public b() {
        this.g = Boolean.FALSE;
        this.x = true;
    }
}
