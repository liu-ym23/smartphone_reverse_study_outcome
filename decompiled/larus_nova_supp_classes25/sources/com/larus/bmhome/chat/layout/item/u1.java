package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u1 extends xc8.h {
    public final t1 p;
    public Integer q;

    public static final class a {
    }

    public static final class b implements h38.c {
        public final /* synthetic */ u1 a;

        public final void b() {
            this.a.setBackground(null);
        }

        public final void a() {
            u1 r0 = this.a;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L7;
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            r2.setMarginEnd(0);
            r0.setLayoutParams(r2);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        public final void c() {
            u1 r0 = this.a;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L7;
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            r2.setMarginEnd(i5.h());
            r0.setLayoutParams(r2);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        public b(u1 r1) {
            this.a = r1;
        }
    }

    static {
    }

    private final Fragment o() {
        t1a.b r0 = ei9.c.a(this);
        if (r0 == null) goto L7;
        va8.m r1 = r0.getAbility(va8.m.class);
        if (r1 == null) goto L7;
        return r1.getChatFragment();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.larus.bmhome.chat.layout.item.t1] */
    public u1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        ?? r0 = new t1(r3);
        this.p = r0;
        addView(r0, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r5, boolean r6) {
        Lazy r7 = com.larus.bmhome.utils.z1.a;
        boolean r8 = com.larus.bmhome.utils.z1.a(o());
        Integer r0 = this.q;
        if (r0 == null) goto L23;
        int r1 = r0.intValue();
        boolean r2 = true;
        if (r5 == true) goto L17;
        t1a.b r9 = ei9.c.a(this);
        if (r9 == null) goto L13;
        IChatMessageShareAbility r10 = r9.getAbility(IChatMessageShareAbility.class);
        if (r10 == null) goto L13;
        if (r10.H1() != true) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L17;
        r2 = false;
    L13:
        r11 = false;
    L17:
        int r12 = q(r1, r2, r8);
        t1 r3 = this.p;
        Integer r13 = Integer.valueOf(r12);
        r13.intValue();
        if (r8 == true) goto L21;
        r13 = null;
    L21:
        r3.setUpCompactMaxWidth(r13);
        return;
    L23:
        FLogger.a.i("NewNestedFileBox", "currentMessageStatus is null ");
    }

    public final void n(Message r9, NestedFileContent r10, BaseResourceViewHolder.a r11) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List r0 = r10.getEntities();
        boolean r1 = false;
        Integer r2 = null;
        if (r0 == null) goto L58;
        Iterator r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L58;
        UplinkFileEntity r4 = (UplinkFileEntity) r3.next();
        UplinkEntityContent r5 = r4.getUplinkEntityContent();
        if (r5 == null) goto L20;
        UplinkFileInfo r6 = r5.getUplinkFileInfo();
        if (r6 == null) goto L20;
        Integer r7 = r6.getFileType();
        int r8 = FileType.FileTypeVideo.getValue();
        if (r7 != null) goto L16;
    L19:
        boolean r12 = true;
    L21:
        if (r12 == true) goto L57;
        UplinkEntityContent r13 = r4.getUplinkEntityContent();
        if (r13 == null) goto L25;
        Image r14 = r13.getUplinkImageInfo();
    L26:
        if (r14 == null) goto L28;
        boolean r15 = true;
    L29:
        UplinkEntityContent r16 = r4.getUplinkEntityContent();
        if (r16 == null) goto L34;
        Image r17 = r16.getUplinkImageInfo();
        if (r17 == null) goto L34;
        String r18 = r17.localResPath;
    L36:
        if (com.larus.utils.o0.d(r18) == true) goto L49;
        UplinkEntityContent r19 = r4.getUplinkEntityContent();
        if (r19 == null) goto L44;
        Image r20 = r19.getUplinkImageInfo();
        if (r20 == null) goto L44;
        ImageObj r21 = r20.imageOri;
        if (r21 == null) goto L44;
        String r22 = r21.url;
    L46:
        if (com.larus.utils.o0.d(r22) == true) goto L49;
        boolean r23 = false;
    L50:
        if (r15 == false) goto L53;
        if (r23 == false) goto L53;
        boolean r24 = true;
    L54:
        if (r24 == true) goto L57;
        FLogger.a.e("NestedFileView", "[isContentInvalid] invalid content: " + r4);
    L53:
        r24 = false;
    L44:
        r22 = null;
    L49:
        r23 = true;
    L34:
        r18 = null;
        goto L36
    L28:
        r15 = false;
        goto L29
    L25:
        r14 = null;
    L57:
        boolean r25 = false;
    L59:
        if (r25 == false) goto L61;
        return;
    L61:
        this.q = Integer.valueOf(r9.getMessageStatusLocal());
        setBackground(null);
        t1 r26 = this.p;
        t1a.b r27 = ei9.c.a(this);
        if (r27 == null) goto L68;
        com.larus.bmhome.chat.component.cvs.y r28 = r27.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r28 == null) goto L68;
        BotModel r29 = r28.j0();
        if (r29 == null) goto L68;
        Integer r30 = r29.getBotType();
    L69:
        r26.setBotType(r30);
        Lazy r31 = com.larus.bmhome.utils.z1.a;
        boolean r32 = com.larus.bmhome.utils.z1.a(o());
        int r33 = r9.getMessageStatusLocal();
        t1a.b r34 = ei9.c.a(this);
        if (r34 == null) goto L76;
        IChatMessageShareAbility r35 = r34.getAbility(IChatMessageShareAbility.class);
        if (r35 == null) goto L76;
        if (r35.H1() != true) goto L76;
        r1 = true;
    L76:
        int r36 = q(r33, r1, r32);
        t1 r37 = this.p;
        Integer r38 = Integer.valueOf(r36);
        r38.intValue();
        if (r32 == false) goto L79;
        r2 = r38;
    L79:
        r37.setUpCompactMaxWidth(r2);
        this.p.setupDelegateCallback(new b(this));
        this.p.a(r9, r10, r11);
        return;
    L68:
        r30 = null;
        goto L69
    L16:
        if (r7.intValue() != r8) goto L19;
        if (r6.getVideo() != null) goto L19;
    L20:
        r12 = false;
    L58:
        r25 = true;
        goto L59
    }

    public final int q(int r2, boolean r3, boolean r4) {
        if (r4 == false) goto L4;
        Lazy r5 = com.larus.bmhome.utils.z1.a;
        int r6 = com.larus.bmhome.utils.z1.e(o());
    L8:
        if (r2 == 12) goto L10;
        if (r3 == true) goto L10;
    L11:
        setMaxWidth(r6);
        return r6;
    L10:
        r6 = r6 - i5.b0();
        goto L11
    L4:
        Resources r7 = AppHost.a.getApplication().getResources();
        r6 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).widthPixels;
        if (com.larus.platform.service.e2.a.isPad() == false) goto L8;
        r6 = RangesKt.coerceAtMost(r6, com.larus.platform.api.f3.a.a());
        goto L8
    }
}
