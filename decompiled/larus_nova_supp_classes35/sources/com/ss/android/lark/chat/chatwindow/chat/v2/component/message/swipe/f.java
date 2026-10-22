package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.message.menu.MessageActionManager;
import com.ss.android.lark.chat.message.menu.context.HiveMessageListActionItemHook;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.recyclerview.hive.HiveViewHolder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yya.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements b.a {
    public final m2b.a a;
    public final d b;

    public static final class a implements b {
        public final m2b.a a;
        public final y6b.c<?> b;
        public final int c;
        public final d d;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.f$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0072a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final boolean a() {
            return this.d.b().a(this.a.e());
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.b
        public final void performAction() {
            LinkedHashMap r0 = new LinkedHashMap();
            Map<String, Object> r1 = ChatParamUtils.f(this.a.getChatId());
            if (r1 == null) goto L5;
            r0.putAll(r1);
        L5:
            r0.putAll(ChatParamUtils.i(this.b));
            r0.put("click", "right_slide_reply");
            Statistics.sendEvent("im_chat_main_click", new JSONObject(r0));
            this.d.d(this.b, this.c);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.b
        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            ReplyInThreadUtil.ReplyOptimizeFGState r0 = ReplyInThreadUtil.e(((v) this.a.get()).C(), this.a.getChat());
            int r1 = C0072a.a[r0.ordinal()];
            if (r1 != 1) goto L5;
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage() == false) goto L15;
            int r2 = 2131255543;
        L17:
            return UDIconUtils.getIconDrawable(r3, r2, UDColorUtils.getColor(r3, 2131103614));
        L15:
            r2 = 2131255540;
            goto L17
        L5:
            if (r1 != 2) goto L7;
        L11:
            r2 = 2131237591;
            goto L17
        L7:
            if (r1 == 3) goto L11;
            throw new NoWhenBranchMatchedException();
        }

        public a(m2b.a r2, y6b.c<?> r3, int r4, d r5) {
            Intrinsics.checkNotNullParameter(r2, "chatContext");
            Intrinsics.checkNotNullParameter(r3, "messageItem");
            Intrinsics.checkNotNullParameter(r5, "dependency");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public f(m2b.a r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.d r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.b.a
    public final a a(RecyclerView.ViewHolder r8, y6b.c r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "viewHolder");
        Intrinsics.checkNotNullParameter(r9, "messageItem");
        if (r9.G == null) goto L5;
        return null;
    L5:
        boolean r2 = false;
        if ((r8 instanceof BlueprintCellViewHolder) == false) goto L15;
        h3b.b r11 = ((BlueprintCellViewHolder) r8).a;
        if ((r11 instanceof h3b.b) == false) goto L10;
        h3b.b r12 = r11;
    L11:
        if (r12 != null) goto L13;
        return null;
    L13:
        n r0 = new com.ss.android.lark.chat.message.menu.context.a(r12, r9, new Point(0, 0));
    L29:
        s2b.b r13 = this.b.c(r9, r0);
        if (r13 != null) goto L32;
        return null;
    L32:
        List<yya.l> r1 = this.b.a();
        if (r1 != null) goto L35;
        r1 = CollectionsKt.emptyList();
    L35:
        List r3 = CollectionsKt.plus(MessageActionManager.d(r13), r1);
        MessageActionType r4 = MessageActionType.REPLY;
        Iterator r5 = r3.iterator();
    L36:
        boolean r6 = true;
        if (r5.hasNext() == false) goto L52;
        yya.e r7 = (yya.l) r5.next();
        if (r7.a(r4, r13) == true) goto L53;
        if ((r7 instanceof yya.e) == false) goto L44;
        yya.e r14 = r7;
    L45:
        if (r14 != null) goto L47;
    L49:
        r6 = false;
    L50:
        if (r6 == false) goto L36;
    L47:
        if (r14.b(r4, r13) != true) goto L49;
    L44:
        r14 = null;
    L53:
        if (r2 == true) goto L55;
        return null;
    L55:
        return new a(this.a, r9, r10, this.b);
    L52:
        r2 = true;
        goto L53
    L10:
        r12 = null;
        goto L11
    L15:
        if ((r8 instanceof HiveViewHolder) == false) goto L62;
        HiveViewHolder r15 = (HiveViewHolder) r8;
        aec.c r16 = r15.b;
        if ((r16 instanceof aec.c) == false) goto L19;
        aec.c r17 = r16;
    L20:
        if (r17 != null) goto L22;
        return null;
    L22:
        aec.d r18 = r15.a;
        if ((r18 instanceof aec.d) == false) goto L25;
        aec.d r19 = r18;
    L26:
        if (r19 != null) goto L28;
        return null;
    L28:
        r0 = new HiveMessageListActionItemHook(r17, r19, r9);
        goto L29
    L25:
        r19 = null;
        goto L26
    L19:
        r17 = null;
        goto L20
    L62:
        return null;
    }
}
