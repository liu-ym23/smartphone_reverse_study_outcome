package rk8;

import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.block.newheader.foldcontainer.FolderContainerView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.standarduikit.elapsedblock.viewmodel.ElapsedBlockStatus;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockControlInfo;
import com.larus.im.bean.message.block.ElapsedBlock;
import ib8.n;
import ib8.w0;
import java.util.Map;
import kc8.o;
import kc8.v;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uk8.g;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends jc8.b<rk8.a> {
    public qk8.c d;
    public FolderContainerView e;
    public kc8.b f;
    public rk8.a g;
    public final b h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f a;

        @Override // java.lang.Runnable
        public final void run() {
            rk8.a r0 = this.a.g;     // Catch: Throwable -> L12
            if (r0 != null) goto L6;
            return;
        L6:
            if (f.k(r0) == false) goto L19;
            this.a.j(r0);     // Catch: Throwable -> L12
            FolderContainerView r1 = this.a.e;     // Catch: Throwable -> L12
            if (r1 == null) goto L20;
            r1.postDelayed(this, 1000);     // Catch: Throwable -> L12
            return;
        L20:
            return;
        L19:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public b(f r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void i() {
        FolderContainerView r0 = this.e;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.h);
    L5:
        qk8.c r1 = this.d;
        if (r1 == null) goto L8;
        r1.f();
    L8:
        this.f = null;
        this.g = null;
    }

    public f() {
        this.h = new b(this);
        this.i = LazyKt.lazy(new c(this));
    }

    public static boolean k(rk8.a r2) {
        BlockContent r0 = ((jc8.a) r2).a.getContent();
        if (r0 == null) goto L7;
        ElapsedBlock r1 = r0.getElapsedBlock();
        if (r1 == null) goto L7;
        Long r3 = r1.getEndTimeS();
    L9:
        if (r3 == null) goto L11;
        return false;
    L11:
        Message r4 = r2.j();
        if (com.larus.bmhome.chat.bean.d.Q0(r4) == false) goto L14;
    L15:
        return true;
    L14:
        if (com.larus.bmhome.chat.bean.d.j0(r4) == false) goto L15;
        return false;
    L7:
        r3 = null;
        goto L9
    }

    public final jc8.d f(jc8.a r3) {
        rk8.a r4 = (rk8.a) r3;
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return jc8.d.a(jc8.d.a(jc8.e.d(r4), 0, 0, 0, 10), 0, 0, 0, 13);
    }

    public final void g(jc8.a r4) {
        rk8.a r5 = (rk8.a) r4;
        Intrinsics.checkNotNullParameter(r5, "blockModel");
        this.f = jc8.c.a(this, kc8.b.class);
        this.g = r5;
        j(r5);
        FolderContainerView r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.h);
    L6:
        if (k(r5) == false) goto L11;
        FolderContainerView r6 = this.e;
        if (r6 == null) goto L12;
        r6.postDelayed(this.h, 1000);
        return;
    L12:
        return;
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        qk8.c r0 = new qk8.c(r2.getContext());
        this.d = r0;
        FolderContainerView r3 = (FolderContainerView) r0.a.getValue();
        this.e = r3;
        return r3;
    }

    public final void j(rk8.a r52) {
        qk8.c r2 = this.d;
        if (r2 == null) goto L121;
        kc8.b r4 = this.f;
        int r5 = uk8.c.a;
        Block r6 = ((jc8.a) r52).a;
        BlockContent r7 = r6.getContent();
        if (r7 == null) goto L11;
        ElapsedBlock r8 = r7.getElapsedBlock();
        if (r8 == null) goto L11;
        Long r9 = r8.getEndTimeS();
        if (r9 == null) goto L11;
        Long r10 = Long.valueOf(r9.longValue());
    L38:
        kc8.b r11 = this.f;
        if (r11 == null) goto L43;
        v r12 = r11.w;
        if (r12 == null) goto L43;
        Boolean r13 = r12.a;
    L44:
        boolean r14 = com.larus.bmhome.chat.bean.d.j0(r52.j());
        Intrinsics.checkNotNullParameter(r6, "block");
        BlockContent r15 = r6.getContent();
        if (r15 == null) goto L47;
        ElapsedBlock r16 = r15.getElapsedBlock();
    L48:
        BlockControlInfo r17 = r6.getControlInfo();
        if (r17 == null) goto L51;
        boolean r18 = Intrinsics.areEqual(r17.isCollapsed(), Boolean.TRUE);
    L52:
        int r19 = g.a;
        if (r16 == null) goto L55;
        Long r110 = r16.getStartTimeS();
    L56:
        long r111 = 1;
        if (r110 == null) goto L62;
        if (r10 == null) goto L62;
        r111 = RangesKt.coerceAtLeast(r10.longValue() - r110.longValue(), 1);
    L62:
        long r112 = r111 / 86400;
        long r20 = (r111 % 86400) / 3600;
        long r113 = (r111 % 3600) / 60;
        long r114 = r111 % 60;
        Application r21 = AppHost.a.getApplication();
        if (r112 <= 0) goto L71;
        if (r18 == true) goto L68;
        if (r14 == true) goto L68;
        int r22 = 2131906605;
    L69:
        String r23 = r21.getString(r22, new Object[]{Long.valueOf(r112), Long.valueOf(r20), Long.valueOf(r113), Long.valueOf(r114)});
        Intrinsics.checkNotNull(r23);
    L92:
        if (r13 == 0) goto L94;
        boolean r24 = r13.booleanValue();
    L95:
        uk8.d r3 = new uk8.d(r52, r4, new uk8.b(r23, r18, r24));
        qk8.e r1 = (qk8.e) this.i.getValue();
        Intrinsics.checkNotNullParameter(r3, "vmData");
        uk8.f r25 = (uk8.f) r2.b.getValue();
        r25.getClass();
        Intrinsics.checkNotNullParameter(r3, "vmData");
        String r26 = ((jc8.a) r3.a).e.a + ':' + ((jc8.a) r3.a).g;
        r25.a = r3;
        r25.b = r1;
        uk8.a r27 = r25.c;
        uk8.b r28 = r3.c;
        boolean r29 = r28.b;
        boolean r30 = r28.c;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r26, "blockKey");
        if (Intrinsics.areEqual(r27.a, r26) == true) goto L98;
    L102:
        r27.a = r26;
        r27.b = r29;
        r27.c = r30;
        if (r29 == false) goto L106;
        if (r30 == false) goto L106;
        ElapsedBlockStatus r31 = ElapsedBlockStatus.Folded;
    L107:
        r27.d = r31;
        DeepThinkFoldStatus r32 = r31.toContainerStatus();
        r27.e = new ib8.c(true, r32, r32, 2);
    L108:
        FolderContainerView r33 = (FolderContainerView) r2.a.getValue();
        final uk8.f r34 = (uk8.f) r2.b.getValue();
        uk8.d r35 = r34.a;
        if (r35 == null) goto L120;
        uk8.b r36 = r35.c;
        kc8.b r37 = r35.b;
        if (r37 == null) goto L113;
        o r210 = r37.b;
    L114:
        String r38 = r36.a;
        if (r34.c.d != ElapsedBlockStatus.Expanded) goto L117;
        float r40 = 90.0f;
    L118:
        w0 r211 = new w0(false, false, r38, null, null, r40, r36.b, false, 411);
        ib8.c r39 = r34.c.e;
        boolean r41 = r36.b;
        ib8.a r115 = new ib8.a(new n(false, false, r210, r211, false, false, false, true, false, r39, false, false, false, new uk8.e(r34), false, false, null, null, null, null, "elapsed_block_header", r41, r41, c7.b(16), c7.b(12), true, c7.b(Double.valueOf(9.5d)), false, 538959184), null, null, null, null, new tk8.e(r35.a.i(), r35.a.j(), r35.b), 30);
        uk8.a r42 = r34.c;
        DeepThinkFoldStatus r43 = r42.d.toContainerStatus();
        r42.e = new ib8.c(false, r43, r43, 3);
        r33.o6(r115, ((uk8.f) r2.b.getValue()).e);
        return;
    L117:
        r40 = 0.0f;
        goto L118
    L113:
        r210 = null;
        goto L114
    L120:
        throw new IllegalStateException("Required value was null.".toString());
    L106:
        r31 = ElapsedBlockStatus.Expanded;
        goto L107
    L98:
        if (r27.b != r29) goto L102;
        if (r27.c != r30) goto L102;
    L94:
        r24 = r18;
    L68:
        r22 = 2131906601;
        goto L69
    L71:
        if (r20 <= 0) goto L79;
        if (r18 == true) goto L76;
        if (r14 == true) goto L76;
        int r44 = 2131906606;
    L77:
        r23 = r21.getString(r44, new Object[]{Long.valueOf(r20), Long.valueOf(r113), Long.valueOf(r114)});
        Intrinsics.checkNotNull(r23);
    L76:
        r44 = 2131906602;
        goto L77
    L79:
        if (r113 <= 0) goto L86;
        if (r18 == true) goto L84;
        if (r14 == true) goto L84;
        int r45 = 2131906607;
    L85:
        r23 = r21.getString(r45, new Object[]{Long.valueOf(r113), Long.valueOf(r114)});
        Intrinsics.checkNotNull(r23);
    L84:
        r45 = 2131906603;
        goto L85
    L86:
        if (r18 == true) goto L90;
        if (r14 == true) goto L90;
        int r46 = 2131906608;
    L91:
        r23 = r21.getString(r46, new Object[]{Long.valueOf(r114)});
        Intrinsics.checkNotNull(r23);
    L90:
        r46 = 2131906604;
        goto L91
    L55:
        r110 = null;
        goto L56
    L51:
        r18 = false;
        goto L52
    L47:
        r16 = null;
    L43:
        r13 = null;
    L11:
        Message r47 = r52.j();
        if (com.larus.bmhome.chat.bean.d.Q0(r47) == false) goto L14;
    L37:
        r10 = Long.valueOf(System.currentTimeMillis() / 1000);
        goto L38
    L14:
        if (com.larus.bmhome.chat.bean.d.j0(r47) == false) goto L37;
        if (r47.getMessageStatusLocal() != 23) goto L19;
    L22:
        Map r48 = r47.getBusinessExt();
        if (r48 == null) goto L29;
        String r49 = (String) r48.get("elapsed_finish_time_s");
        if (r49 == null) goto L29;
        Long r50 = StringsKt.toLongOrNull(r49);
        if (r50 == null) goto L29;
        final long r51 = r50.longValue();
    L36:
        r10 = Long.valueOf(r51);
    L29:
        r51 = System.currentTimeMillis() / 1000;
        Map r116 = r47.getBusinessExt();
        if (r116 == null) goto L32;
        String r117 = (String) r116.put("elapsed_finish_time_s", String.valueOf(r51));
    L32:
        IChatRepoService r118 = zh8.a.a;
        String r53 = r47.getLocalMessageId();
        if (r53 != null) goto L35;
        r53 = "";
    L35:
        r118.r1(r53, new rk8.b(r51));
        goto L36
    L19:
        if (r47.getMessageStatusLocal() == 22) goto L22;
        r10 = null;
        goto L38
    }
}
