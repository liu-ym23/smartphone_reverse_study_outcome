package com.ss.android.lark.chat.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReplyInThreadUtil {
    public static Boolean a;
    public static Boolean b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/utils/ReplyInThreadUtil$ReplyOptimizeFGState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ONLINE_STATE", "EXP1_STATE", "EXP2_STATE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReplyOptimizeFGState extends Enum<ReplyOptimizeFGState> {
        public static final ReplyOptimizeFGState EXP1_STATE = null;
        public static final ReplyOptimizeFGState EXP2_STATE = null;
        public static final ReplyOptimizeFGState ONLINE_STATE = null;
        public static final /* synthetic */ ReplyOptimizeFGState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ReplyOptimizeFGState> getEntries() {
            return b;
        }

        static {
            ReplyOptimizeFGState r0 = new ReplyOptimizeFGState("ONLINE_STATE", 0);
            ONLINE_STATE = r0;
            ReplyOptimizeFGState r1 = new ReplyOptimizeFGState("EXP1_STATE", 1);
            EXP1_STATE = r1;
            ReplyOptimizeFGState r3 = new ReplyOptimizeFGState("EXP2_STATE", 2);
            EXP2_STATE = r3;
            ReplyOptimizeFGState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ReplyOptimizeFGState[] values() {
            return (ReplyOptimizeFGState[]) a.clone();
        }

        public static ReplyOptimizeFGState valueOf(String r1) {
            return (ReplyOptimizeFGState) r27.a.a(ReplyOptimizeFGState.class, r1);
        }

        public ReplyOptimizeFGState(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(p5b.c r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((r2 instanceof MessageInfo) == true) goto L8;
        return false;
    L8:
        Message r3 = ((MessageInfo) r2).getMessage();
        w4b.c.f r1 = ChatCoreModule.a().getMyAIDependency();
        r3.getAiChatModeId();
        r1.b();
        if (r3.getThreadMessageType() != null) goto L11;
        return false;
    L11:
        if (r3.getThreadMessageType() == Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L15;
        return true;
    L15:
        return false;
    }

    @JvmStatic
    public static final boolean b(y6b.a<? extends v5b.a<? extends Content>> r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        w4b.c.f r1 = ChatCoreModule.a().getMyAIDependency();
        r2.o();
        r1.b();
        if ((r2 instanceof y6b.c) == true) goto L9;
        return false;
    L9:
        if (((y6b.c) r2).S1 != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L12;
        return true;
    L12:
        return false;
    }

    @JvmStatic
    public static final ReplyOptimizeFGState d(jdb.g r2) {
        Intrinsics.checkNotNullParameter(r2, "fgService");
        if (a != null) goto L5;
        a = Boolean.valueOf(r2.isEnable("messenger.message.reply_optimize"));
    L5:
        Boolean r0 = a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Boolean");
        if (r0.booleanValue() == false) goto L16;
        if (b != null) goto L10;
        b = Boolean.valueOf(r2.isEnable("messenger.message.reply_optimize_exp1"));
    L10:
        Boolean r3 = b;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Boolean");
        if (r3.booleanValue() == false) goto L14;
        return ReplyOptimizeFGState.EXP1_STATE;
    L14:
        return ReplyOptimizeFGState.EXP2_STATE;
    L16:
        return ReplyOptimizeFGState.ONLINE_STATE;
    }

    @JvmStatic
    public static final ReplyOptimizeFGState e(jdb.g r1, Chat r2) {
        Intrinsics.checkNotNullParameter(r1, "fgService");
        if (r2 != null) goto L7;
        return ReplyOptimizeFGState.ONLINE_STATE;
    L7:
        if (r2.isSecret() == false) goto L11;
        return ReplyOptimizeFGState.ONLINE_STATE;
    L11:
        if (a != null) goto L13;
        a = Boolean.valueOf(r1.isEnable("messenger.message.reply_optimize"));
    L13:
        Boolean r3 = a;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Boolean");
        if (r3.booleanValue() == false) goto L24;
        if (b != null) goto L18;
        b = Boolean.valueOf(r1.isEnable("messenger.message.reply_optimize_exp1"));
    L18:
        Boolean r4 = b;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Boolean");
        if (r4.booleanValue() == false) goto L22;
        return ReplyOptimizeFGState.EXP1_STATE;
    L22:
        return ReplyOptimizeFGState.EXP2_STATE;
    L24:
        return ReplyOptimizeFGState.ONLINE_STATE;
    }

    @JvmStatic
    public static final void c(Context r1, com.ss.android.lark.biz.im.api.l1 r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        if (ForsetiConfig.a(r1) == false) goto L6;
        if (r3 == null) goto L6;
        ChatCoreModule.a().getChatDependency().g(r1, r2, r3);
        return;
    L6:
        ChatCoreModule.a().getChatDependency().j(r1, r2);
    }
}
