package com.larus.bmhome.chat.markdown.code;

import android.content.Context;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 implements jw8.c {
    public final Context a;
    public final lw8.d b;
    public fh8.f c;
    public AttachReceiver d;
    public final Lazy e;

    public final void f() {
        ((oj8.c) this.e.getValue()).c();
    }

    public final View a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ((oj8.c) this.e.getValue()).b();
    }

    public q0(Context r2, lw8.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.e = LazyKt.lazy(new l0(this));
    }

    public final Size b(TextView r44, Spanned r45, jw8.b r46, Map r47, int r48, boolean r49) {
        Intrinsics.checkNotNullParameter(r44, "textView");
        Intrinsics.checkNotNullParameter(r45, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r46, "span");
        if (r47 == null) goto L5;
        fh8.f r6 = fh8.h.b(r47);
    L6:
        this.c = r6;
        if (r6 == null) goto L9;
        AttachReceiver r7 = r6.o;
    L10:
        this.d = r7;
        p0 r8 = new p0(this);
        if (r7 == null) goto L13;
        final t1a.b r9 = s1a.d.a(r7);
    L14:
        if (r9 != null) goto L21;
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L20;
        r10.P();
        Fragment r11 = ChatServiceImpl.a.f();
        if (r11 == null) goto L20;
        r9 = s1a.a.g(r11);
    L20:
        r9 = null;
    L21:
        if (r9 == null) goto L23;
        va8.p r12 = (va8.p) r9.getAbility(va8.p.class);
    L24:
        fh8.f r13 = this.c;
        if (r13 == null) goto L29;
        Function0<? extends Fragment> r14 = r13.m;
        if (r14 == null) goto L29;
        Fragment r15 = (Fragment) r14.invoke();
    L30:
        fh8.f r16 = this.c;
        if (r16 == null) goto L35;
        Message r17 = r16.b;
        if (r17 == null) goto L35;
        int r18 = com.larus.bmhome.chat.cotdetail.list.processor.f.f;
        com.larus.bmhome.chat.cotdetail.list.processor.f r19 = com.larus.bmhome.chat.cotdetail.list.processor.f.a.a(r15, r17, null);
    L36:
        fh8.f r110 = this.c;
        if (r110 == null) goto L39;
        String r111 = r110.d;
    L40:
        if (r110 == null) goto L42;
        Message r112 = r110.b;
    L43:
        if (r9 == null) goto L47;
        de8.c r113 = (de8.c) r9.a(de8.c.class);
        if (r113 == null) goto L47;
        Integer r114 = r113.m();
    L49:
        if (r114 == null) goto L51;
        boolean r115 = true;
    L52:
        LruCache r116 = ko8.a.a;
        long r117 = ko8.a.g();
        Integer r118 = r46.getStartIndex();
        if (r118 == null) goto L55;
        int r119 = r118.intValue();
    L56:
        if (r12 == null) goto L58;
        RecyclerView r20 = r12.Ly();
    L59:
        if (r19 == null) goto L61;
        by7.e r120 = r19;
    L64:
        lw8.d r5 = this.b;
        if (r5 == null) goto L69;
        CodeBlockConfig r21 = r5.v;
        if (r21 == null) goto L69;
        boolean r22 = r21.getEnableCodeBlockStroke();
    L70:
        lw8.d r23 = this.b;
        if (r23 == null) goto L75;
        CodeBlockConfig r24 = r23.v;
        if (r24 == null) goto L75;
        boolean r25 = r24.getEnableCodeBlockHeaderBackground();
    L76:
        hh8.a r26 = new hh8.a(r22, r25, false, null, null, false, 60);
        fh8.f r27 = this.c;
        if (r27 == null) goto L79;
        Function0<Map<String, Object>> r28 = r27.s;
    L80:
        if (r19 == null) goto L94;
        if (r15 == null) goto L83;
        by7.e r29 = by7.h.h(r15);
    L85:
        if ((r29 instanceof TraceFragment) == false) goto L87;
        TraceFragment r30 = (TraceFragment) r29;
    L88:
        if (r30 == null) goto L91;
        String r31 = r30.k();
        if (r31 == null) goto L91;
    L96:
        String r210 = r31;
    L98:
        String r32 = r46.getCode();
        if (r32 != null) goto L101;
        String r211 = "";
    L102:
        String r33 = r46.getLanguage();
        if (r33 != null) goto L105;
        String r212 = "";
    L106:
        Intrinsics.checkNotNullParameter(r45, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r46, "span");
        if (z2.a.getMarkdownCodeRenderConfig().c == true) goto L109;
        boolean r213 = r49;
    L131:
        fh8.f r1 = this.c;
        if (r1 == null) goto L134;
        fh8.c r2 = r1.k;
    L135:
        if (r2 == null) goto L137;
        boolean r34 = true;
    L138:
        if (r1 == null) goto L142;
        jh8.b r3 = r1.v;
        if (r3 == null) goto L142;
        Integer r35 = r3.a;
    L143:
        if (r1 == null) goto L147;
        jh8.b r4 = r1.v;
        if (r4 == null) goto L147;
        Integer r36 = r4.c;
    L148:
        if (r1 == null) goto L150;
        com.larus.bmhome.chat.api.q0 r37 = r1.q;
    L151:
        if (r1 == null) goto L153;
        com.larus.bmhome.chat.api.q0.a r38 = r1.n;
    L154:
        if (r1 == null) goto L156;
        RecyclerView.Adapter<?> r39 = r1.p;
    L158:
        if ((r39 instanceof ry8.d) == false) goto L160;
        ry8.d r310 = (ry8.d) r39;
    L161:
        rj8.a r40 = new rj8.a(r111, r112, r115, Long.valueOf(r117), r119, r120, r20, new m0(r9), new n0(r9), r26, r28, r210, r211, null, r212, r213, r34, r35, r36, r37, r38, r310, null, false, false, null, null, null, 264241152);
        ((oj8.c) this.e.getValue()).a(r40, r8);
        oj8.c r41 = (oj8.c) this.e.getValue();
        r41.getClass();
        Intrinsics.checkNotNullParameter(r40, "vmData");
        return r41.b().g(((rj8.d) r41.c.getValue()).a(), r48);
    L160:
        r310 = null;
        goto L161
    L156:
        r39 = null;
        goto L158
    L153:
        r38 = null;
        goto L154
    L150:
        r37 = null;
    L147:
        r36 = null;
    L142:
        r35 = null;
        goto L143
    L137:
        r34 = false;
        goto L138
    L134:
        r2 = null;
        goto L135
    L109:
        if (r49 == true) goto L120;
        fh8.f r42 = this.c;
        if (r42 == null) goto L129;
        Message r43 = r42.b;
        if (r43 == null) goto L129;
        if (com.larus.im.bean.message.a.w0(r43) == false) goto L119;
    L121:
        Integer r50 = r46.getEndIndex();
        if (r50 == null) goto L124;
        int r51 = r50.intValue();
    L126:
        if (r51 < (r45.length() - 1)) goto L129;
        boolean r52 = false;
    L130:
        r213 = r52;
        goto L131
    L124:
        r51 = 0;
        goto L126
    L119:
        if (com.larus.bmhome.chat.bean.d.j0(r43) == false) goto L121;
    L129:
        r52 = true;
    L120:
        r213 = true;
        goto L131
    L105:
        r212 = r33;
        goto L106
    L101:
        r211 = r32;
    L91:
        fh8.f r53 = this.c;
        if (r53 == null) goto L97;
        r31 = r53.e;
    L97:
        r210 = null;
        goto L98
    L87:
        r30 = null;
        goto L88
    L83:
        r29 = null;
        goto L85
    L94:
        if (r27 == null) goto L97;
        r31 = r27.e;
        goto L96
    L79:
        r28 = null;
    L75:
        r25 = false;
    L69:
        r22 = false;
        goto L70
    L61:
        if (r15 == null) goto L63;
        r120 = by7.h.h(r15);
        goto L64
    L63:
        r120 = null;
        goto L64
    L58:
        r20 = null;
        goto L59
    L55:
        r119 = 0;
        goto L56
    L51:
        r115 = false;
    L47:
        r114 = null;
        goto L49
    L42:
        r112 = null;
        goto L43
    L39:
        r111 = null;
    L35:
        r19 = null;
    L29:
        r15 = null;
        goto L30
    L23:
        r12 = null;
        goto L24
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
