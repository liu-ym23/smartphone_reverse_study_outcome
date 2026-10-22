package com.ss.android.lark.chat.chatwindow.chat.data.reply;

import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseReplyMsgDigestCreator implements com.ss.android.lark.chat.chatwindow.chat.data.reply.a {
    public final v a;
    public final Lazy b;
    public final String c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public abstract CharSequence b(ChatChatter r1, MessageInfo r2, boolean r3, PartialReplyInfo r4);

    public BaseReplyMsgDigestCreator(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        this.a = r2;
        this.b = LazyKt.lazy(BaseReplyMsgDigestCreator$mLoginDependency$2.INSTANCE);
        int r3 = a.a[ReplyInThreadUtil.d(r2.C()).ordinal()];
        if (r3 != 1) goto L5;
    L11:
        String r4 = BuildConfig.FLAVOR;
    L12:
        this.c = r4;
        return;
    L5:
        if (r3 == 2) goto L11;
        if (r3 != 3) goto L10;
        r4 = UIHelper.getString(2131892131) + ' ';
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.reply.a
    public final CharSequence a(ChatChatter r6, MessageInfo r7, boolean r8, PartialReplyInfo r9) {
        if (r7 == null) goto L4;
        Message r0 = r7.getMessage();
        if (r0.getStatus() != Message.Status.DELETED) goto L14;
        if (r6 != null) goto L9;
        return null;
    L9:
        String r10 = this.c;
        if (Intrinsics.areEqual(r6.getId(), ((u) this.b.getValue()).getUserId()) == true) goto L23;
        return r10 + UIHelper.mustacheFormat(2131891672, IPortraitService.NAME, m.b(r6, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true));
    L23:
        return r10 + UIHelper.getString(2131891668);
    L14:
        if (r0.isRemoved() == false) goto L17;
        String r11 = UIHelper.getString(2131891303);
        ICUUtils.FormatArgsBuilder r12 = new ICUUtils.FormatArgsBuilder();
        r12.b(IPortraitService.NAME, m.b(r6, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true));
        r12.b("content", UIHelper.getString(2131891925));
        return ICUUtils.icuFormat(r11, r12.a);
    L17:
        if (r0.isDecryptFailed() == false) goto L20;
        return this.c + UIHelper.getString(2131890914);
    L20:
        return b(r6, r7, r8, r9);
    L4:
        return this.c;
    }
}
