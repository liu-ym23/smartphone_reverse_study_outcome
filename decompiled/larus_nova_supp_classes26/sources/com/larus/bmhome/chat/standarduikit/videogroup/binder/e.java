package com.larus.bmhome.chat.standarduikit.videogroup.binder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MixerMedia;
import com.larus.im.bean.message.VLMMixerSearchResult;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import do8.i;
import do8.j;
import do8.k;
import fh8.h;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import usc.f;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements f {
    public final Lazy a;
    public final int b;
    public Integer c;

    public static final class a {
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
        return ((bo8.c) this.a.getValue()).b();
    }

    public e(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new c(r2));
        this.b = c7.b(15) * 2;
    }

    public final Size d(TextView r33, Spanned r34, final usc.e r35, int r36, Map<String, ? extends Object> r37) {
        Intrinsics.checkNotNullParameter(r33, "textView");
        Intrinsics.checkNotNullParameter(r34, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r35, "span");
        fh8.f r14 = h.b(r37);
        if (r14 == null) goto L5;
        final Message r12 = r14.b;
    L6:
        if (r12 == null) goto L9;
        r12.getMessageId();
    L9:
        if (r14 == null) goto L13;
        Message r5 = r14.b;
        if (r5 == null) goto L13;
        int r3 = w.c(w.a, r33.getContext(), r5, 0, Boolean.FALSE, false, false, null, r33, 96);
    L14:
        int r13 = r3 + this.b;
        Pair r4 = (Pair) fh8.b.a(r35, new d(this, r35, r12));
        ContainerAttribute r6 = (ContainerAttribute) r4.component1();
        List r7 = (List) r4.component2();
        if (r6 == null) goto L20;
        Boolean r8 = r6.isTop();
        if (r8 == null) goto L20;
        r8.booleanValue();
    L20:
        if (r34.getSpanStart(r35) != 0) goto L22;
        boolean r20 = true;
    L24:
        if (r34.getSpanEnd(r35) != r34.length()) goto L26;
        boolean r21 = true;
    L27:
        if (r7 == null) goto L29;
        MixerMedia r9 = (MixerMedia) CollectionsKt.firstOrNull(r7);
    L30:
        if (r9 == null) goto L34;
        Integer r10 = r9.getAlbumImageWidth();
        if (r10 == null) goto L34;
        r10.intValue();
    L34:
        if (r9 == null) goto L38;
        Integer r11 = r9.getAlbumImageHeight();
        if (r11 == null) goto L38;
        r11.intValue();
    L38:
        if (r7 == null) goto L40;
        r7.size();
    L40:
        VLMMixerSearchResult r15 = new VLMMixerSearchResult(r7, null, 2, null);
        Integer r16 = this.c;
        if (r16 == null) goto L43;
        Integer r1 = r16;
    L44:
        JSONObject r17 = new JSONObject();
        if (r14 == null) goto L47;
        Function0 r23 = r14.x;
    L48:
        j r24 = new j(true, true, r20, r21, true, r23);
        if (r6 == null) goto L53;
        Boolean r18 = r6.getVideoInfinite();
        if (r18 == null) goto L53;
        boolean r19 = r18.booleanValue();
    L54:
        Lazy r22 = yn8.b.a;
        if (r12 != 0) goto L58;
    L79:
        boolean r25 = false;
    L86:
        FLogger r26 = FLogger.a;
        StringBuilder r110 = new StringBuilder("needPreloadRecommend[");
        r110.append(r25);
        r110.append("], msgId[");
        if (r12 == 0) goto L89;
        String r111 = r12.getMessageId();
    L90:
        r110.append(r111);
        r110.append("], isFinished[");
        if (r12 == 0) goto L93;
        Boolean r112 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r12));
    L94:
        r110.append(r112);
        r110.append("], time[");
        Integer r38 = r1;
        r110.append(SystemClock.elapsedRealtime());
        r110.append(']');
        r26.i("MainBotVideoGroupPreloadHelper", r110.toString());
        if (r6 == null) goto L97;
        List r0 = r6.getSplitQuery();
    L98:
        i r27 = new i(r19, true, r25, r0);
        if (r14 == null) goto L101;
        Boolean r28 = r14.u;
    L102:
        if (r14 == null) goto L104;
        Function1 r29 = r14.y;
    L105:
        k r2 = new k(r13, null, r12, r15, r38, true, r17, r24, r27, r28, null, r29, null, 9218);
        if (r14 == null) goto L108;
        AttachReceiver r30 = r14.o;
    L110:
        if (r14 == null) goto L112;
        q0 r113 = r14.q;
    L113:
        if (r14 == null) goto L115;
        LruSet r31 = r14.g;
    L116:
        if (r14 == null) goto L118;
        Boolean r114 = r14.h;
    L119:
        do8.h r32 = new do8.h(r30, null, null, null, null, null, null, r113, r31, r114, r14, r33, 126);
        ((bo8.c) this.a.getValue()).a(r2, r32);
        bo8.c r39 = (bo8.c) this.a.getValue();
        r39.getClass();
        Intrinsics.checkNotNullParameter(r2, "vmData");
        return r39.b().B(r39.e, r13);
    L118:
        r114 = null;
        goto L119
    L115:
        r31 = null;
        goto L116
    L112:
        r113 = null;
        goto L113
    L108:
        r30 = null;
        goto L110
    L104:
        r29 = null;
        goto L105
    L101:
        r28 = null;
        goto L102
    L97:
        r0 = null;
        goto L98
    L93:
        r112 = null;
        goto L94
    L89:
        r111 = null;
        goto L90
    L58:
        if (com.larus.bmhome.chat.bean.d.j0(r12) == true) goto L64;
        if (Intrinsics.areEqual(yn8.b.b, r12.getMessageId()) == true) goto L79;
        yn8.b.b = r12.getMessageId();
    L85:
        r25 = true;
        goto L86
    L64:
        if (Intrinsics.areEqual(yn8.b.b, r12.getMessageId()) == false) goto L67;
        yn8.b.b = null;
    L67:
        long r115 = SystemClock.elapsedRealtime();
        Iterator r116 = ((ConcurrentHashMap) yn8.b.a.getValue()).keySet().iterator();
    L69:
        if (r116.hasNext() == false) goto L84;
        WeakReference r40 = (WeakReference) r116.next();
        Lazy r117 = yn8.b.a;
        Long r41 = (Long) ((ConcurrentHashMap) r117.getValue()).get(r40);
        if (r41 == null) goto L82;
        long r118 = r41.longValue();
        Message r42 = (Message) r40.get();
        if (r42 != null) goto L76;
        ((ConcurrentHashMap) r117.getValue()).remove(r40);
        goto L69
    L76:
        if (Intrinsics.areEqual(r42.getMessageId(), r12.getMessageId()) == false) goto L82;
        if ((r115 - r118) < 5000) goto L79;
        Long r43 = Long.valueOf(r115);
        ((ConcurrentHashMap) r117.getValue()).put(r40, r43);
    L82:
        r116 = r116;
        goto L69
    L84:
        Long r44 = Long.valueOf(r115);
        ((ConcurrentHashMap) yn8.b.a.getValue()).put(new WeakReference(r12), r44);
    L53:
        r19 = false;
        goto L54
    L47:
        r23 = null;
        goto L48
    L43:
        ri8.c r45 = ri8.c.a;
        r1 = ri8.c.k(r34, r35);
        this.c = r1;
        goto L44
    L29:
        r9 = null;
        goto L30
    L26:
        r21 = false;
        goto L27
    L22:
        r20 = false;
    L13:
        r3 = r36;
        goto L14
    L5:
        r12 = null;
        goto L6
    }
}
