package bl8;

import al8.f;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cb8.x1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.FlowMarkdownCodeView;
import com.larus.bmhome.chat.standarduikit.fileoperation.view.FileOperateView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolViewStage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.im.bean.message.block.FileOperationBlock;
import com.larus.im.bean.message.block.FileOperationDisplayContentBlock;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jl8.g;
import kc8.i0;
import kc8.p;
import kc8.w0;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends jc8.b<bl8.a> {
    public y d;
    public f e;

    public static final class a implements dl8.c {
        public final y a;
        public final Function0<Unit> b;
        public final Lazy c;

        @Override // dl8.c
        public final void a() {
            this.b.invoke();
        }

        public a(y r2, c r3) {
            Intrinsics.checkNotNullParameter(r3, "onRebind");
            this.a = r2;
            this.b = r3;
            this.c = LazyKt.lazy(new d(this));
        }

        @Override // dl8.c
        public final void b(Message r44, String r45, int r46) {
            ri8.c r1 = ri8.c.a;
            y r2 = this.a;
            if (r2 == null) goto L8;
            q0 r3 = r2.x;
            if (r3 == null) goto L8;
            LruSet r4 = r3.E7();
            if (r4 == null) goto L8;
        L9:
            LruSet r5 = r4;
            String r6 = null;
            if (r44 == null) goto L12;
            String r7 = r44.getMessageId();
        L13:
            y r8 = this.a;
            if (r8 == null) goto L18;
            Function0 r9 = r8.f;
            if (r9 == null) goto L18;
            String r10 = (String) r9.invoke();
        L19:
            if (r44 == null) goto L21;
            String r11 = r44.getReplyId();
        L22:
            ChatParam r12 = (ChatParam) this.c.getValue();
            if (r12 == null) goto L25;
            String r13 = r12.d;
        L27:
            if (r13 != null) goto L29;
            String r14 = "";
        L30:
            ChatParam r15 = (ChatParam) this.c.getValue();
            if (r15 == null) goto L33;
            String r16 = r15.c;
        L34:
            y r17 = this.a;
            if (r17 == null) goto L41;
            Function0 r18 = r17.l;
            if (r18 == null) goto L41;
            BotModel r19 = (BotModel) r18.invoke();
            if (r19 == null) goto L41;
            String r20 = r19.getBotId();
        L42:
            if (r44 == null) goto L44;
            r6 = com.larus.bmhome.chat.bean.d.x(r44).getReqId();
        L44:
            LruCache<String, wc9.e> r21 = ko8.a.a;
            String r22 = ko8.a.c(r44);
            if (r22 != null) goto L47;
            String r29 = "";
        L48:
            ri8.c.n(r5, null, r7, r10, r11, r14, r16, Integer.valueOf(r46), 1, "slideshow", "within_text", "tool_card", r20, null, null, null, null, r6, null, null, null, null, null, null, null, null, r29, null, r45, null, null, null, null, null, null, null, null, null, -335683582, 63);
            return;
        L47:
            r29 = r22;
        L41:
            r20 = null;
            goto L42
        L33:
            r16 = null;
            goto L34
        L29:
            r14 = r13;
            goto L30
        L25:
            r13 = null;
            goto L27
        L21:
            r11 = null;
        L18:
            r10 = null;
            goto L19
        L12:
            r7 = null;
        L8:
            r4 = new LruSet(1);
            goto L9
        }
    }

    public /* synthetic */ class b {
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

    public final String c() {
        return "FileOperationBlockHolder";
    }

    public final void i() {
        f r0 = this.e;
        if (r0 == null) goto L6;
        ((oj8.c) r0.d.getValue()).c();
        return;
    }

    public e() {
    }

    public final jc8.d f(jc8.a r2) {
        bl8.a r3 = (bl8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final /* bridge */ /* synthetic */ void g(jc8.a r1) {
        j((bl8.a) r1);
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        f r0 = new f(r3.getContext());
        this.e = r0;
        FileOperateView r4 = (FileOperateView) r0.b.getValue();
        FlowMarkdownCodeView r1 = ((oj8.c) r0.d.getValue()).b();
        if (r1 != null) goto L5;
        r4.getClass();
    L7:
        return (FileOperateView) r0.b.getValue();
    L5:
        r4.a.b.addView(r1);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [bl8.c] */
    public final void j(final bl8.a r53) {
        Intrinsics.checkNotNullParameter(r53, "blockModel");
        kc8.b r2 = jc8.c.a(this, kc8.b.class);
        if (r2 == null) goto L5;
        y r4 = r2.a;
    L6:
        this.d = r4;
        Block r5 = ((jc8.a) r53).a;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L9;
        FileOperationBlock r10 = r6.getFileOperationBlock();
    L10:
        if (r2 == null) goto L12;
        w0 r7 = r2.v;
    L13:
        int r12 = x1.b(((jc8.b) this).a, r53, bl8.a.class);
        jc8.a r8 = r53.k();
        int r16 = 0;
    L14:
        if (r8 == null) goto L16;
        r16 = r16 + 1;
        r8 = r8.k();
        goto L14
    L16:
        String r9 = r5.getBlockId();
        if (r9 != null) goto L19;
        String r11 = "";
    L20:
        Pair r13 = new Pair(0, 0);
        Message r14 = r53.j();
        boolean r15 = il8.b.a(r53);
        if (r2 == null) goto L25;
        p r3 = r2.e;
        if (r3 == null) goto L25;
        Integer r17 = Integer.valueOf(r3.a);
    L26:
        y r18 = this.d;
        jc8.f r19 = ((jc8.a) r53).d;
        if (r19 == null) goto L47;
        jc8.a r20 = r19.c;
        if (r20 != null) goto L31;
    L33:
        boolean r21 = false;
    L34:
        if (r21 == true) goto L44;
        i0 r22 = r19.e;
        if (r22 != null) goto L38;
    L40:
        boolean r23 = false;
    L41:
        if (r23 == true) goto L44;
        boolean r24 = false;
    L45:
        if (r24 != true) goto L47;
        boolean r25 = true;
    L48:
        if (r25 == false) goto L50;
    L53:
        boolean r26 = true;
    L54:
        if (r7 == null) goto L56;
        ToolBlockInteractType r27 = r7.a;
    L58:
        if (r27 != ToolBlockInteractType.OpenFloatingPage) goto L60;
        Function0 r110 = new bl8.b(this, r53);
    L61:
        if (r7 == null) goto L63;
        ToolBlockInteractType r28 = r7.a;
    L65:
        if (r28 != ToolBlockInteractType.DisableHeaderInteract) goto L67;
        boolean r111 = true;
    L68:
        if (r7 == null) goto L70;
        ToolBlockInitStatus r29 = r7.b;
    L72:
        if (r29 != null) goto L74;
        int r30 = -1;
    L76:
        if (r30 == (-1)) goto L86;
        if (r30 == 1) goto L85;
        if (r30 != 2) goto L80;
        Boolean r31 = Boolean.FALSE;
    L87:
        int r32 = 0;
        dl8.b r33 = new dl8.b(r11, r13, r14, r10, r15, r12, r17, r18, r16, r26, r110, r111, r31);
        f r34 = this.e;
        if (r34 == null) goto L266;
        a r35 = new a(this.d, new c(this, r53));
        Intrinsics.checkNotNullParameter(r33, "vmData");
        dl8.f r36 = (dl8.f) r34.c.getValue();
        r36.getClass();
        Intrinsics.checkNotNullParameter(r33, "vmData");
        r36.a = r33;
        r36.b = r35;
        FileOperationBlock r1 = r33.d;
        if (r1 == null) goto L134;
        FileOperationDisplayContentBlock r37 = r1.displayContent;
        if (r37 == null) goto L134;
        String r112 = "diff";
        if (Intrinsics.areEqual(r1.fileType, "diff") == false) goto L104;
        String r38 = r37.diff;
        if (r38 != null) goto L99;
        r38 = "";
    L99:
        String r39 = r1.fileName;
        if (r39 == null) goto L103;
        r112 = r39;
    L103:
        dl8.a r40 = new dl8.a.C0104a(r38, "git", r112);
    L135:
        r36.e = r40;
        if (Intrinsics.areEqual(r36.d, r33.a) == true) goto L142;
        Boolean r41 = r33.m;
        if (r41 == null) goto L140;
        boolean r113 = r41.booleanValue();
    L141:
        r36.c = r113;
        r36.d = r33.a;
        goto L142
    L140:
        r113 = false;
    L142:
        FileOperateView r42 = (FileOperateView) r34.b.getValue();
        dl8.f r43 = (dl8.f) r34.c.getValue();
        dl8.b r44 = r43.a;
        if (r44 != null) goto L145;
        cl8.a r45 = new cl8.a(r32);
    L187:
        final dl8.f r46 = (dl8.f) r34.c.getValue();
        r46.getClass();
        Function0 r47 = new dl8.d(r46);
        Function0 r114 = new dl8.e(r46);
        cl8.b r48 = new cl8.b(r47, r114);
        r42.getClass();
        Intrinsics.checkNotNullParameter(r45, "input");
        Intrinsics.checkNotNullParameter(r48, "output");
        GenericToolView r49 = r42.a.c;
        jl8.f r50 = r45.a;
        if (r45.d == true) goto L191;
        r114 = null;
    L191:
        r49.a(r50, new g(r47, r114));
        if (r45.b == true) goto L194;
    L196:
        e1.o(r42.a.b);
    L197:
        dl8.a r51 = ((dl8.f) r34.c.getValue()).e;
        if ((r51 instanceof dl8.a.C0104a) == false) goto L267;
        dl8.a.C0104a r52 = (dl8.a.C0104a) r51;
        final y r54 = r33.h;
        oj8.c r55 = (oj8.c) r34.d.getValue();
        if (r54 == null) goto L207;
        Function0 r56 = r54.l;
        if (r56 == null) goto L207;
        BotModel r57 = (BotModel) r56.invoke();
        if (r57 == null) goto L207;
        String r58 = r57.getBotId();
        if (r58 == null) goto L207;
    L210:
        String r210 = r58;
    L212:
        Message r59 = r33.c;
        if (r54 == null) goto L215;
        boolean r211 = r54.a();
    L216:
        if (r54 == null) goto L218;
        Long r212 = r54.b;
    L219:
        int r60 = r33.i;
        if (r54 == null) goto L222;
        by7.e r213 = r54.c;
    L223:
        if (r54 == null) goto L225;
        RecyclerView r214 = r54.d;
    L226:
        Function0 r115 = new al8.d(r54);
        Function0 r116 = new al8.e(r54);
        if (r33.j == false) goto L229;
        Context r117 = r34.a;
        hh8.a r310 = new hh8.a(true, false, false, Integer.valueOf(ContextCompat.getColor(r117, v19.c.b(2130972087, r117, 2131103162))), Float.valueOf(r34.a.getResources().getDimension(v19.c.b(2130971163, r34.a, 2131166696))), true, 6);
    L230:
        if (r54 == null) goto L232;
        Function0 r311 = r54.s;
    L233:
        if (r54 == null) goto L239;
        Function0 r61 = r54.m;
        if (r61 == null) goto L239;
        ChatParam r62 = (ChatParam) r61.invoke();
        if (r62 == null) goto L239;
        String r312 = r62.d;
    L240:
        String r63 = r52.a;
        String r118 = r52.b;
        boolean r119 = r33.e;
        boolean r120 = r33.j;
        if (r54 == null) goto L243;
        q0 r410 = r54.x;
    L244:
        if (r54 == null) goto L246;
        q0.a r411 = r54.u;
    L247:
        String r64 = r52.c;
        boolean r412 = Intrinsics.areEqual(r118, "git");
        FileOperationBlock r65 = r33.d;
        if (r65 == null) goto L252;
        FileOperationDisplayContentBlock r66 = r65.displayContent;
        if (r66 == null) goto L252;
        Integer r413 = r66.addedLines;
    L253:
        if (r65 == null) goto L257;
        FileOperationDisplayContentBlock r67 = r65.displayContent;
        if (r67 == null) goto L257;
        Integer r414 = r67.deletedLines;
    L258:
        r55.a(new rj8.a(r210, r59, r211, r212, r60, r213, r214, r115, r116, r310, r311, r312, r63, null, r118, r119, r120, null, null, r410, r411, null, r64, true, r412, r413, r414, null, 136708096), null);
        return;
    L257:
        r414 = null;
    L252:
        r413 = null;
        goto L253
    L246:
        r411 = null;
        goto L247
    L243:
        r410 = null;
    L239:
        r312 = null;
        goto L240
    L232:
        r311 = null;
        goto L233
    L229:
        r310 = null;
        goto L230
    L225:
        r214 = null;
        goto L226
    L222:
        r213 = null;
        goto L223
    L218:
        r212 = null;
        goto L219
    L215:
        r211 = false;
    L207:
        Message r68 = r33.c;
        if (r68 == null) goto L211;
        r58 = r68.getSenderId();
        goto L210
    L211:
        r210 = null;
        goto L212
    L267:
        return;
    L194:
        if (r45.c == true) goto L196;
        e1.x(r42.a.b);
        goto L197
    L145:
        FileOperationBlock r69 = r44.d;
        if (r69 != null) goto L149;
        r45 = new cl8.a(r32);
        goto L187
    L149:
        if (r44.e == false) goto L151;
        GenericToolViewStage r121 = GenericToolViewStage.FINISHED;
    L152:
        GenericToolViewStage r215 = r121;
        boolean r122 = r43.e instanceof dl8.a.C0104a;
        DisplayHeader r123 = r69.header;
        if (r123 == null) goto L155;
        String r216 = r123.getIconUrl();
    L156:
        DisplayHeader r124 = r69.header;
        if (r124 == null) goto L159;
        String r217 = r124.getIconUrlDark();
    L160:
        DisplayHeader r70 = r69.header;
        if (r70 == null) goto L163;
        String r218 = r70.getSummary();
    L164:
        Pair<Integer, Integer> r71 = r44.b;
        Message r125 = r44.c;
        if (r125 == null) goto L167;
        String r219 = r125.getMessageId();
    L168:
        int r126 = r44.f;
        Integer r127 = r44.g;
        if (r122 == true) goto L171;
    L173:
        boolean r313 = false;
    L174:
        if (r122 == true) goto L176;
    L178:
        boolean r314 = false;
    L179:
        jl8.f r128 = new jl8.f(r216, r217, r218, r215, r71, r219, r126, r127, r313, r314, false, 0, 0, 0, 15360);
        boolean r72 = r43.c;
        if (r44.l == true) goto L185;
        if (r122 == false) goto L183;
    L184:
        boolean r129 = true;
    L186:
        r45 = new cl8.a(r128, r122, r72, r129);
        goto L187
    L183:
        if (r44.k != null) goto L184;
    L185:
        r129 = false;
        goto L186
    L176:
        if (r43.c == true) goto L178;
        r314 = true;
        goto L179
    L171:
        if (r44.l == true) goto L173;
        r313 = true;
        goto L174
    L167:
        r219 = null;
        goto L168
    L163:
        r218 = null;
        goto L164
    L159:
        r217 = null;
        goto L160
    L155:
        r216 = null;
        goto L156
    L151:
        r121 = GenericToolViewStage.LOADING;
        goto L152
    L104:
        List r73 = CollectionsKt.listOfNotNull(new String[]{r37.operation, r37.result});
        ArrayList r130 = new ArrayList();
        Iterator r74 = r73.iterator();
    L106:
        if (r74.hasNext() == false) goto L113;
        Object r75 = r74.next();
        if (((String) r75).length() <= 0) goto L110;
        boolean r131 = true;
    L111:
        if (r131 == false) goto L106;
        r130.add(r75);
        goto L106
    L110:
        r131 = false;
        goto L111
    L113:
        String r76 = CollectionsKt.joinToString$default(r130, "\n\n", null, null, 0, null, null, 62, null);
        String r132 = "shell";
        if (Intrinsics.areEqual(r1.fileType, "shell") == true) goto L118;
        String r77 = r1.fileType;
        if (r77 == null) goto L118;
    L119:
        String r133 = r1.fileName;
        if (r133 != null) goto L122;
    L125:
        boolean r134 = true;
    L126:
        if (r134 == true) goto L128;
        String r78 = r1.fileName;
    L130:
        if (r78 == null) goto L133;
        r132 = r78;
    L133:
        r40 = new dl8.a.C0104a(r76, r77, r132);
        goto L135
    L128:
        r78 = r1.fileType;
        goto L130
    L122:
        if (StringsKt.isBlank(r133) == true) goto L125;
        r134 = false;
    L118:
        r77 = "clike";
    L134:
        r40 = dl8.a.b.a;
        goto L135
    L266:
        return;
    L80:
        if (r30 == 3) goto L86;
        throw new NoWhenBranchMatchedException();
    L85:
        r31 = Boolean.TRUE;
    L86:
        r31 = null;
        goto L87
    L74:
        r30 = b.a[r29.ordinal()];
        goto L76
    L70:
        r29 = null;
        goto L72
    L67:
        r111 = false;
        goto L68
    L63:
        r28 = null;
        goto L65
    L60:
        r110 = null;
        goto L61
    L56:
        r27 = null;
        goto L58
    L50:
        if (Intrinsics.areEqual(((jc8.a) r53).e.f, "cot_tool_preview") == true) goto L53;
        r26 = false;
        goto L54
    L38:
        if (r22.b != j.A) goto L40;
        r23 = true;
    L44:
        r24 = true;
        goto L45
    L31:
        if (r20.l() != j.A) goto L33;
        r21 = true;
    L47:
        r25 = false;
    L25:
        r17 = null;
        goto L26
    L19:
        r11 = r9;
        goto L20
    L12:
        r7 = null;
        goto L13
    L9:
        r10 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
