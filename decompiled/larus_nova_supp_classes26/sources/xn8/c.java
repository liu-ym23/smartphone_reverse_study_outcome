package xn8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cb8.x1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.RelatedVideoViewModel;
import com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import com.larus.im.bean.message.block.SearchVideoContainerAttribute;
import com.larus.im.bean.message.block.SearchVideoItem;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc8.d;
import jc8.k;
import kc8.m0;
import kc8.n0;
import kc8.o0;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zn8.l;
import zn8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends jc8.b<xn8.a> {
    public kc8.b d;
    public wn8.c e;
    public final Lazy f;
    public FrameLayout g;

    public static final class a implements e {
        public final y a;
        public final m0 b;
        public final o0 c;

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final void a() {
            o0 r0 = this.c;
            if (r0 == null) goto L8;
            Function0 r1 = r0.b;
            if (r1 == null) goto L9;
            r1.invoke();
            return;
        L9:
            return;
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final String b() {
            y r0 = this.a;
            if (r0 == null) goto L9;
            Function0 r1 = r0.m;
            if (r1 == null) goto L9;
            ChatParam r2 = (ChatParam) r1.invoke();
            if (r2 == null) goto L9;
            return r2.c;
        L9:
            return null;
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final Boolean d() {
            y r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.g;
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final String getBotId() {
            y r0 = this.a;
            if (r0 == null) goto L9;
            Function0 r1 = r0.l;
            if (r1 == null) goto L9;
            BotModel r2 = (BotModel) r1.invoke();
            if (r2 == null) goto L9;
            return r2.getBotId();
        L9:
            return null;
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final String getChatType() {
            y r0 = this.a;
            if (r0 == null) goto L10;
            Function0 r1 = r0.m;
            if (r1 == null) goto L10;
            ChatParam r2 = (ChatParam) r1.invoke();
            if (r2 == null) goto L10;
            String r3 = r2.e;
            if (r3 == null) goto L10;
            return r3;
        L10:
            return "other_default";
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final String getConversationId() {
            y r0 = this.a;
            if (r0 == null) goto L7;
            Function0 r1 = r0.f;
            if (r1 == null) goto L7;
            return (String) r1.invoke();
        L7:
            return null;
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final String getCurrentPage() {
            y r0 = this.a;
            if (r0 == null) goto L9;
            Function0 r1 = r0.m;
            if (r1 == null) goto L9;
            ChatParam r2 = (ChatParam) r1.invoke();
            if (r2 == null) goto L9;
            return r2.d;
        L9:
            return null;
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final String j() {
            m0 r0 = this.b;
            if (r0 == null) goto L7;
            Function0 r1 = r0.b;
            if (r1 == null) goto L7;
            return (String) r1.invoke();
        L7:
            return null;
        }

        public a(c r3) {
            kc8.b r4 = r3.d;
            o0 r0 = null;
            if (r4 == null) goto L5;
            y r1 = r4.a;
        L6:
            this.a = r1;
            if (r4 == null) goto L11;
            n0 r2 = r4.d;
            if (r2 == null) goto L11;
            m0 r5 = r2.a;
        L12:
            this.b = r5;
            if (r4 == null) goto L17;
            n0 r6 = r4.d;
            if (r6 == null) goto L17;
            r0 = r6.b;
        L17:
            this.c = r0;
            return;
        L11:
            r5 = null;
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e
        public final Boolean h(Message r2) {
            m0 r0 = this.b;
            if (r0 == null) goto L7;
            Function1 r1 = r0.a;
            if (r1 == null) goto L7;
            return (Boolean) r1.invoke(r2);
        L7:
            return null;
        }
    }

    public final String c() {
        return "RelatedVideoBlockHolder";
    }

    public final void i() {
        wn8.c r0 = this.e;
        if (r0 == null) goto L6;
        ((RelatedVideoViewModel) r0.b.getValue()).c = null;
        ExposeXTrackerExtKt.e(r0.b().getCoverView());
        return;
    }

    public c() {
        this.f = LazyKt.lazy(new b(this));
    }

    public final d f(jc8.a r2) {
        xn8.a r3 = (xn8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r14) {
        xn8.a r15 = (xn8.a) r14;
        Intrinsics.checkNotNullParameter(r15, "blockModel");
        this.d = jc8.c.a(this, kc8.b.class);
        FrameLayout r0 = this.g;
        if (r0 == null) goto L122;
        BlockContent r1 = ((jc8.a) r15).a.getContent();
        if (r1 == null) goto L120;
        SearchRichMediaBlock r2 = r1.getRichMediaBlock();
        if (r2 == null) goto L123;
        List r3 = r2.creations;
        boolean r4 = true;
        ArrayList r5 = null;
        if (r3 == null) goto L30;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r3.iterator();
    L14:
        if (r7.hasNext() == false) goto L24;
        Object r8 = r7.next();
        Integer r9 = ((RichMediaItem) r8).type;
        int r10 = RichMediaType.SEARCH_VIDEO.getValue();
        if (r9 != null) goto L19;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == false) goto L14;
        r6.add(r8);
        goto L14
    L19:
        if (r9.intValue() != r10) goto L21;
        r11 = true;
        goto L22
    L24:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r6.iterator();
    L26:
        if (r13.hasNext() == false) goto L31;
        SearchVideoItem r16 = ((RichMediaItem) r13.next()).video;
        if (r16 == null) goto L26;
        r12.add(r16);
    L31:
        SearchVideoContainerAttribute r17 = r2.containerAttribute;
        long r18 = 0;
        if (r17 == null) goto L36;
        Long r19 = r17.videoHeight;
        if (r19 == null) goto L36;
        long r20 = r19.longValue();
    L37:
        if (r17 == null) goto L42;
        Long r110 = r17.videoWidth;
        if (r110 == null) goto L42;
        r18 = r110.longValue();
    L42:
        if (r20 > r18) goto L46;
        r4 = false;
    L46:
        if (r0.getChildCount() != 0) goto L51;
        wn8.c r21 = this.e;
        if (r21 != null) goto L50;
        r21 = new wn8.c(r0.getContext(), r4);
        this.e = r21;
    L50:
        r0.addView(r21.b());
    L51:
        k r22 = ((jc8.b) this).a;
        if (r22 == null) goto L54;
        Integer r111 = Integer.valueOf(x1.b(r22, r15, xn8.a.class));
    L55:
        boolean r23 = r15.m();
        boolean r24 = r15.n();
        if (r17 == null) goto L60;
        Boolean r25 = r17.videoTitleShow;
        if (r25 == null) goto L60;
        boolean r26 = r25.booleanValue();
    L61:
        kc8.b r27 = this.d;
        if (r27 == null) goto L68;
        n0 r28 = r27.d;
        if (r28 == null) goto L68;
        o0 r29 = r28.b;
        if (r29 == null) goto L68;
        int r30 = r29.a;
    L69:
        l r31 = new l(r23, r24, r26, r30);
        if (r12 == null) goto L96;
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r33 = r12.iterator();
    L73:
        if (r33.hasNext() == false) goto L95;
        SearchVideoItem r34 = (SearchVideoItem) r33.next();
        q.a r35 = new q.a();
        r35.a = String.valueOf(r34.id);
        r35.b = r34.itemId;
        r35.c = r34.hostPageUrl;
        r35.p = r34.appJumpUrl;
        r35.d = r34.sourceAppIcon;
        r35.e = r34.sourceAppIconV2;
        r35.f = r34.albumImage;
        Long r36 = r34.width;
        if (r36 == null) goto L77;
        Integer r37 = Integer.valueOf((int) r36.longValue());
    L78:
        r35.g = r37;
        Long r38 = r34.height;
        if (r38 == null) goto L81;
        Integer r39 = Integer.valueOf((int) r38.longValue());
    L82:
        r35.h = r39;
        r35.i = r34.needFillEdge;
        r35.j = r34.videoCaptions;
        if (r17 == null) goto L85;
        String r40 = r17.videoTitle;
    L86:
        r35.k = r40;
        r35.l = r34.videoFirstFrameImage;
        Long r41 = r34.videoFirstFrameImageWidth;
        if (r41 == null) goto L89;
        Integer r42 = Integer.valueOf((int) r41.longValue());
    L90:
        r35.m = r42;
        Long r43 = r34.videoFirstFrameImageHeight;
        if (r43 == null) goto L93;
        Integer r44 = Integer.valueOf((int) r43.longValue());
    L94:
        r35.n = r44;
        r35.o = r34.sourceFrom;
        r32.add(r35.a());
        goto L73
    L93:
        r44 = null;
        goto L94
    L89:
        r42 = null;
        goto L90
    L85:
        r40 = null;
        goto L86
    L81:
        r39 = null;
        goto L82
    L77:
        r37 = null;
        goto L78
    L95:
        r5 = r32;
    L96:
        if (r5 != null) goto L98;
        List r45 = CollectionsKt.emptyList();
    L99:
        Message r112 = r15.j();
        Boolean r113 = r2.videoInfinite;
        if (r113 == null) goto L102;
        boolean r114 = r113.booleanValue();
    L103:
        com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r115 = new com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a(r31, r45, r112, r111, r114);
        wn8.c r46 = this.e;
        if (r46 == null) goto L121;
        r46.a(r115, (a) this.f.getValue());
        return;
    L121:
        return;
    L102:
        r114 = false;
        goto L103
    L98:
        r45 = r5;
    L68:
        int r47 = com.larus.utils.m0.a;
        r30 = com.larus.utils.m0.b(AppHost.a.getApplication());
    L60:
        r26 = false;
        goto L61
    L54:
        r111 = null;
    L36:
        r20 = 0;
        goto L37
    L30:
        r12 = null;
        goto L31
    L123:
        return;
    L120:
        return;
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FrameLayout r0 = new FrameLayout(r4.getContext());
        this.g = r0;
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }
}
