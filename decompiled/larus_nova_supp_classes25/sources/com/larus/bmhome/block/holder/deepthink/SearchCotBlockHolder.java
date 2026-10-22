package com.larus.bmhome.block.holder.deepthink;

import android.view.View;
import android.view.ViewGroup;
import cb8.x1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.standarduikit.searchcot.view.SearchCotView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import kc8.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SearchCotBlockHolder extends jc8.b<gb8.h> {
    public kc8.b d;
    public final Lazy e;
    public in8.d f;

    public static final class SearchCotVMDependencyImpl implements kn8.b {
        public final ChatParam a;
        public final kn8.a b;

        public final void c() {
        }

        public final ChatParam f() {
            ChatParam r0 = this.a;
            String r1 = null;
            if (r0 == null) goto L5;
            String r7 = r0.d;
        L6:
            if (r0 == null) goto L8;
            String r6 = r0.c;
        L9:
            if (r0 == null) goto L12;
            r1 = r0.e;
        L12:
            return new ChatParam(null, null, r6, r7, r1, 227);
        L8:
            r6 = null;
            goto L9
        L5:
            r7 = null;
            goto L6
        }

        public SearchCotVMDependencyImpl(ChatParam r1, kn8.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(int r26, Reference r27, Integer r28) {
            kn8.a r1 = this.b;
            String r2 = null;
            if (r1 == null) goto L5;
            Message r3 = r1.b;
        L6:
            if (r3 == null) goto L48;
            if (r27 == null) goto L49;
            TextCard r4 = r27.getTextCard();
            if (r4 == null) goto L15;
            Long r5 = r4.getId();
            if (r5 == null) goto L13;
            String r6 = r5.toString();
        L14:
            oi8.n.a r7 = new oi8.n.a(r6, r4.getUrl(), r4.getDocId(), r4.getSearchId());
        L19:
            int r8 = oi8.n.a;
            String r9 = r3.getSenderId();
            if (r9 != null) goto L22;
            String r10 = "";
        L23:
            ChatParam r11 = f();
            if (r7 == null) goto L27;
            Object r12 = r7.a;
            if (r12 == null) goto L27;
        L28:
            String r13 = r12.toString();
            if (r7 == null) goto L31;
            String r19 = r7.b;
        L32:
            if (r7 == null) goto L34;
            String r18 = r7.c;
        L35:
            kn8.a r14 = this.b;
            if (r14 == null) goto L43;
            SearchReferenceData r15 = r14.f;
            if (r15 == null) goto L43;
            String r16 = r15.getToolType();
            if (r16 == null) goto L43;
            String r20 = r16;
        L44:
            if (r7 == null) goto L46;
            r2 = r7.d;
        L46:
            oi8.n.a(r3, r11, Integer.valueOf(r26), r28, r13, "link", r10, "open_media", null, null, null, null, Boolean.TRUE, null, null, r18, r19, r20, null, null, r2, 1629952);
            return;
        L43:
            r20 = "";
            goto L44
        L34:
            r18 = null;
            goto L35
        L31:
            r19 = null;
        L27:
            r12 = 0;
            goto L28
        L22:
            r10 = r9;
            goto L23
        L13:
            r6 = null;
            goto L14
        L15:
            VideoCard r17 = r27.getVideoCard();
            if (r17 == null) goto L18;
            r7 = new oi8.n.a(r17.getId(), r17.getMainSiteUrl(), r17.getItemId(), r17.getSearchId());
            goto L19
        L18:
            r7 = null;
            goto L19
        L49:
            return;
        L48:
            return;
        L5:
            r3 = null;
            goto L6
        }

        public final void a(Integer r12, Integer r13, String r14, Reference r15) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SearchCotBlockHolder$SearchCotVMDependencyImpl$trackReferenceShow$1(this, r15, r14, r12, r13, null), 3, null);
        }

        public final void d(String r24, Integer r25, String r26, String r27) {
            Intrinsics.checkNotNullParameter(r24, "cardType");
            Intrinsics.checkNotNullParameter(r26, "clickEffect");
            Intrinsics.checkNotNullParameter(r27, "toolName");
            kn8.a r1 = this.b;
            if (r1 == null) goto L5;
            Message r2 = r1.b;
        L6:
            if (r2 == null) goto L12;
            int r3 = oi8.n.a;
            String r4 = r2.getSenderId();
            if (r4 != null) goto L10;
            r4 = "";
        L10:
            String r18 = r4;
            oi8.n.a(r2, f(), null, r25, null, r24, r18, r26, null, null, null, null, Boolean.TRUE, null, null, null, null, r27, null, null, null, 3923732);
            return;
        L12:
            return;
        L5:
            r2 = null;
            goto L6
        }

        public final void e(String r17, Integer r18, String r19, String r20) {
            Intrinsics.checkNotNullParameter(r17, "cardType");
            Intrinsics.checkNotNullParameter(r19, "status");
            Intrinsics.checkNotNullParameter(r20, "toolName");
            kn8.a r0 = this.b;
            if (r0 == null) goto L5;
            Message r1 = r0.b;
        L6:
            Message r2 = r1;
            if (r2 == null) goto L10;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SearchCotBlockHolder$SearchCotVMDependencyImpl$trackSearchCotShow$1(r2, this, r18, r17, r19, true, r20, null), 3, null);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolBlockInitStatus.values().length];
            r0[ToolBlockInitStatus.Fold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToolBlockInitStatus.Expand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToolBlockInitStatus.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // jc8.b
    public final String c() {
        return "SearchCotBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        this.f = null;
    }

    public SearchCotBlockHolder() {
        this.e = LazyKt.lazy(new h0(this));
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        gb8.h r3 = (gb8.h) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return j0.a(this.a, r3);
    }

    @Override // jc8.b
    public final void g(jc8.a r21) {
        final gb8.h r1 = (gb8.h) r21;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = (kc8.b) jc8.c.a(this, kc8.b.class);
        this.d = r2;
        Boolean r3 = null;
        if (r2 == null) goto L5;
        final w0 r4 = r2.v;
    L6:
        if (r4 == null) goto L8;
        ToolBlockInteractType r5 = r4.a;
    L10:
        if (r5 != ToolBlockInteractType.DisableHeaderInteract) goto L12;
        boolean r6 = true;
    L13:
        cd8.a r7 = (cd8.a) jc8.c.a(this, cd8.a.class);
        if (r7 == null) goto L16;
        int r10 = r7.a;
    L17:
        final tb8.a r8 = (tb8.a) jc8.c.a(this, tb8.a.class);
        Function0 r14 = new i0(r4, this, r1, r8);
        if (r4 == null) goto L20;
        ToolBlockInitStatus r9 = r4.b;
    L22:
        if (r9 != null) goto L24;
        int r11 = -1;
    L25:
        if (r11 == (-1)) goto L37;
        if (r11 != 1) goto L28;
        Boolean r12 = Boolean.TRUE;
    L36:
        Boolean r18 = r12;
    L38:
        Message r13 = r1.j();
        if (r2 == null) goto L47;
        kc8.y r15 = r2.a;
        if (r15 == null) goto L47;
        Function0<wc9.e> r16 = r15.e;
        if (r16 == null) goto L47;
        wc9.e r17 = (wc9.e) r16.invoke();
        if (r17 == null) goto L47;
        String r19 = ic8.n.f(r17);
    L48:
        jc8.k r20 = this.a;
        if (r20 == null) goto L51;
        Integer r110 = Integer.valueOf(x1.b(r20, r1, gb8.h.class));
    L52:
        SearchReferenceData r111 = r1.o();
        if (r2 == null) goto L57;
        kc8.p r22 = r2.e;
        if (r22 == null) goto L57;
        Integer r112 = Integer.valueOf(r22.a);
    L58:
        Boolean r113 = Boolean.valueOf(r6);
        if (r2 == null) goto L63;
        kc8.p r23 = r2.e;
        if (r23 == null) goto L63;
        r3 = r23.b;
    L63:
        kn8.a r24 = new kn8.a(r10, r13, r19, r110, r14, r111, r112, r113, r18, r3);
        SearchCotVMDependencyImpl r25 = new SearchCotVMDependencyImpl((ChatParam) this.e.getValue(), r24);
        in8.d r26 = this.f;
        if (r26 == null) goto L67;
        Intrinsics.checkNotNullParameter(r24, "vmData");
        kn8.c r27 = r26.a();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r24, "vmData");
        r27.e = r24;
        r27.d = r25;
        r26.a().f = new in8.c(r26);
        ((SearchCotView) r26.b.getValue()).b(r26.a().a(), r26.a().a);
        return;
    L67:
        return;
    L57:
        r112 = null;
        goto L58
    L51:
        r110 = null;
    L47:
        r19 = null;
        goto L48
    L28:
        if (r11 != 2) goto L30;
        r12 = Boolean.FALSE;
        goto L36
    L30:
        if (r11 == 3) goto L37;
        throw new NoWhenBranchMatchedException();
    L37:
        r18 = null;
        goto L38
    L24:
        r11 = a.a[r9.ordinal()];
        goto L25
    L20:
        r9 = null;
        goto L22
    L16:
        r10 = 0;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        in8.d r0 = new in8.d(r2.getContext());
        this.f = r0;
        return (SearchCotView) r0.b.getValue();
    }
}
