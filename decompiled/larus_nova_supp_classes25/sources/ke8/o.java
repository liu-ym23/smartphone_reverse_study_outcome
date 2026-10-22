package ke8;

import android.R;
import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SelectTextAction;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.p1;
import com.larus.utils.m0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kc8.l0;
import kc8.v0;
import kc8.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o extends le8.a<he8.b> {
    public final Lazy b;
    public Message c;
    public final com.larus.bmhome.chat.cotdetail.list.processor.e d;
    public final Lazy e;
    public Boolean f;

    public static final class a {
    }

    public static final class b implements kc8.z {
        public final /* synthetic */ ie8.a a;
        public final /* synthetic */ o b;

        @Override // kc8.z
        public final void a(View r1) {
        }

        public b(ie8.a r1, o r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // kc8.z
        public final void b(View r79, st8.a r80, LongClickSource r81) {
            Intrinsics.checkNotNullParameter(r81, "longClickSource");
            kc8.y r2 = this.a.c;
            if (r2 == null) goto L46;
            Fragment r3 = r2.a;
            if (r3 == null) goto L47;
            RecyclerView r4 = this.b.getAttachedRecyclerView();
            if (r4 != null) goto L10;
            return;
        L10:
            String r5 = null;
            if (r80 == null) goto L13;
            st8.a r6 = r80;
        L19:
            o r7 = this.b;
            com.larus.bmhome.chat.cotdetail.list.processor.e r8 = r7.d;
            Message r9 = r7.c;
            if (r9 != null) goto L22;
            return;
        L22:
            kc8.y r10 = this.a.c;
            if (r10 == null) goto L28;
            Function0<BotModel> r11 = r10.l;
            if (r11 == null) goto L28;
            BotModel r12 = (BotModel) r11.invoke();
            if (r12 == null) goto L28;
        L36:
            if ((r79 instanceof CustomMarkdownTextView) == false) goto L38;
            CustomMarkdownTextView r1 = (CustomMarkdownTextView) r79;
        L39:
            kc8.y r13 = this.a.c;
            if (r13 == null) goto L44;
            Function0<String> r14 = r13.f;
            if (r14 == null) goto L44;
            r5 = (String) r14.invoke();
        L44:
            String r15 = r5;
            final o r16 = this.b;
            final ie8.a r17 = this.a;
            Function0 r18 = new p(r16, r17);
            r8.getClass();
            com.larus.bmhome.chat.cotdetail.list.processor.e.b(r3, r4, r6, r9, r12, r1, r81, r15, r18);
            return;
        L38:
            r1 = null;
        L28:
            Message r19 = this.b.c;
            if (r19 == null) goto L31;
            String r110 = r19.getSenderId();
        L32:
            if (r110 != null) goto L34;
            r110 = "";
        L34:
            r12 = new BotModel(r110, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
            goto L36
        L31:
            r110 = null;
            goto L32
        L13:
            if ((r79 instanceof st8.a) == false) goto L15;
            r6 = (st8.a) r79;
        L16:
            if (r6 != null) goto L19;
            return;
        L15:
            r6 = null;
            goto L16
        L47:
            return;
        }
    }

    static {
    }

    @Override // le8.a
    public final void b() {
        this.a = null;
        hk9.a r1 = getContainerView();
        if (r1 == null) goto L5;
        r1.a();
    L5:
        this.c = null;
        this.f = null;
    }

    private final hk9.a getContainerView() {
        return (hk9.a) this.b.getValue();
    }

    private final boolean getEnableIgnoreTyping() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public o(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = LazyKt.lazy(new k(r2, this));
        this.d = new com.larus.bmhome.chat.cotdetail.list.processor.e();
        this.e = LazyKt.lazy(new l());
    }

    /* JADX WARN: Type inference failed for: r8v11, types: [ke8.n] */
    @Override // le8.b
    public final void a(final ie8.a r149) {
        Intrinsics.checkNotNullParameter(r149, "state");
        if ((r149 instanceof he8.b) == true) goto L5;
        return;
    L5:
        Message r2 = r149.a;
        this.c = r2;
        List r3 = com.larus.im.bean.message.a.d(r2);
        kc8.f r11 = new kc8.f(r149.a, null, false, false, null, null, 510);
        r11.c = true;
        boolean r4 = false;
        r11.d = false;
        Intrinsics.checkNotNullParameter("cot_floatation", "<set-?>");
        r11.f = "cot_floatation";
        int r5 = ee8.q.a;
        Fragment r6 = null;
        if (p1.a.o() == true) goto L17;
        Map<String, Boolean> r7 = ge8.a.a;
        Message r8 = this.c;
        if (r8 == null) goto L11;
        String r9 = r8.getMessageId();
    L12:
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        Intrinsics.checkNotNullParameter(r9, "key");
        Boolean r10 = (Boolean) ((LinkedHashMap) ge8.a.a).get(r9);
        if (r10 == null) goto L17;
        boolean r12 = r10.booleanValue();
    L18:
        kc8.y r13 = r149.c;
        if (r13 == null) goto L23;
        Function0<BotModel> r14 = r13.l;
        if (r14 == null) goto L23;
        final BotModel r15 = (BotModel) r14.invoke();
    L24:
        if (r15 == null) goto L26;
        List r16 = r15.getSelectTextActions();
    L27:
        List r17 = r16;
        if (r17 != null) goto L30;
    L31:
        r4 = true;
    L32:
        if (r4 == false) goto L37;
        if (r15 != null) goto L35;
        BotModel r80 = new BotModel(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
    L36:
        BotModel r18 = BotModel.copy$default(r80, null, null, null, 0, null, null, null, null, null, CollectionsKt.listOf(new SelectTextAction(null, "tts", null, null, 13, null)), null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -513, Integer.MAX_VALUE, null);
    L38:
        Message r19 = r149.a;
        LruCache r20 = ko8.a.a;
        Long r110 = Long.valueOf(ko8.a.g());
        RecyclerView r111 = getAttachedRecyclerView();
        int r21 = com.larus.bmhome.chat.cotdetail.list.processor.f.f;
        kc8.y r22 = r149.c;
        if (r22 == null) goto L41;
        Fragment r23 = r22.a;
    L42:
        com.larus.bmhome.chat.cotdetail.list.processor.f r112 = com.larus.bmhome.chat.cotdetail.list.processor.f.a.a(r23, r149.a, r15);
        kc8.y r24 = r149.c;
        if (r24 == null) goto L47;
        Function0<String> r25 = r24.f;
        if (r25 == null) goto L47;
        String r26 = (String) r25.invoke();
    L48:
        final com.larus.bmhome.chat.deepresearch.view.a0 r27 = new com.larus.bmhome.chat.deepresearch.view.a0(r19, r18, r110, r111, "cot_detail", r112, null, null, r26, new n(this, r149, r15), 128);
        kc8.y r28 = r149.c;
        if (r28 == null) goto L51;
        kc8.l r29 = new kc8.l(new c(this, r149));
    L52:
        if (r28 == null) goto L54;
        kc8.y.a r30 = r28.b();
        r30.g = getAttachedRecyclerView();
        r30.D = new b(r149, this);
        final kc8.y r31 = r30.a();
    L55:
        int r32 = kc8.b.y;
        kc8.b.a r33 = new kc8.b.a();
        r33.x = r29;
        r33.s = new l0(new f(r149), Integer.valueOf(v19.c.b(2130970662, getContext(), 2131239046)));
        r33.h = new kc8.w(Integer.valueOf(v19.c.b(2130970662, null, 2131239046)));
        Boolean r113 = Boolean.TRUE;
        r33.k = new kc8.s(r113);
        if (r12 == false) goto L58;
        DeepThinkFoldStatus r34 = DeepThinkFoldStatus.CompleteExpand;
    L59:
        DeepThinkFoldStatus r114 = r34;
        int r35 = v19.c.b(2130970967, getContext(), 2131240188);
        r33.i = new kc8.r(r114, false, Integer.valueOf(ContextCompat.getColor(getContext(), v19.c.b(2130972085, getContext(), 2131103156))), Integer.valueOf(r35), Integer.valueOf(c7.b(320)), true);
        r33.m = new kc8.u(Integer.valueOf(v19.c.b(2130970662, null, 2131239046)), Integer.valueOf(v19.c.b(2130970920, null, 2131239998)));
        r33.p = new kc8.k(v19.c.b(2130970662, null, 2131239046));
        r33.j = new kc8.p(r113);
        r33.g = new kc8.x(Integer.valueOf(R.color.transparent));
        RectF r36 = new RectF(c7.b(16), c7.b(12), c7.b(16), c7.b(12));
        int r37 = m0.a;
        int r38 = m0.b(getContext()) - c7.b(32);
        r33.a = new v0(null, Integer.valueOf(r38), false, false, null, r113, r36, new g(r149, this), null, new h(r27), null, new jh8.b(null, Integer.valueOf(v19.c.b(2130970920, null, 2131239998)), 3), null, Boolean.valueOf(getEnableIgnoreTyping()), null, 95517);
        r33.g = new kc8.x(Integer.valueOf(R.color.transparent));
        r33.u = new kc8.m(true, new i(r149), 2);
        ToolBlockInteractType r39 = ToolBlockInteractType.OpenFloatingPage;
        ToolBlockInitStatus r40 = ToolBlockInitStatus.Fold;
        if (r31 == null) goto L65;
        Fragment r115 = r31.a;
        if (r115 == null) goto L65;
        r6 = r115;
    L68:
        r33.v = new w0(r39, r40, new com.larus.bmhome.block.presentation.a(r6, new j(r31, r149)));
        r33.l = new kc8.q(null, r113, null, null, null, null, null, null, null, null, null, null, 8189);
        r33.b = r31;
        kc8.b r41 = r33.a();
        hk9.a r42 = getContainerView();
        if (r42 == null) goto L71;
        r42.b(kc8.b.class, r41);
    L71:
        boolean r43 = !Intrinsics.areEqual(this.f, Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r149.a)));
        int r44 = ra8.a.a;
        ra8.a.d(getContainerView(), r3, r11, r43);
        this.f = Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r149.a));
        return;
    L65:
        kc8.y r116 = r149.c;
        if (r116 == null) goto L68;
        r6 = r116.a;
        goto L68
    L58:
        r34 = DeepThinkFoldStatus.HalfFold;
        goto L59
    L54:
        r31 = null;
        goto L55
    L51:
        r29 = null;
    L47:
        r26 = null;
        goto L48
    L41:
        r23 = null;
        goto L42
    L35:
        r80 = r15;
        goto L36
    L37:
        r18 = r15;
        goto L38
    L30:
        if (r17.isEmpty() == false) goto L32;
    L26:
        r16 = null;
    L23:
        r15 = null;
        goto L24
    L11:
        r9 = null;
    L17:
        r12 = true;
        goto L18
    }
}
