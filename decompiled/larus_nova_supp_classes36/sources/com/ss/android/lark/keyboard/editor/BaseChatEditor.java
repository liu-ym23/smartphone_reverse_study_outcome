package com.ss.android.lark.keyboard.editor;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.x;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.dto.draft.ScheduleDraftInfo;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.base.o;
import com.ss.android.lark.keyboard.base.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import mob.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseChatEditor<T extends mob.a> implements com.ss.android.lark.biz.im.api.extension.chat_window.d<T>, cya.f {
    public final KeyboardViewModel a;

    public static final class a {
    }

    public static final class b implements KeyboardViewModel.b {
        public final /* synthetic */ kotlinx.coroutines.i<a7b.a> a;

        public b(j r1) {
            this.a = r1;
        }

        public final void a(a7b.a r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a.resumeWith(Result.constructor-impl(r2));
        }
    }

    static {
    }

    public Object a(boolean r1, Continuation<? super cya.h> r2) {
        return c(this, r1, r2);
    }

    public final void isEnable() {
    }

    public BaseChatEditor(KeyboardViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardViewModel");
        this.a = r2;
    }

    public void b(cya.h r14) {
        Intrinsics.checkNotNullParameter(r14, "state");
        n r15 = r14.a;
        Set r0 = x.a;
        Intrinsics.checkNotNullParameter(r15, "params");
        Object r1 = r15.a(cya.b.h);
        Boolean r2 = Boolean.TRUE;
        boolean r3 = Intrinsics.areEqual(r1, r2);
        Intrinsics.checkNotNullParameter(r15, "params");
        boolean r4 = Intrinsics.areEqual(r15.a(com.ss.android.lark.keyboard.inputstate.d.h), r2);
        Log.i("Flow_KB_BaseChatEditor", "saveDraft: clearGeneralDraft == " + r3 + ", clearScheduleDraft=" + r4);
        if (r3 == false) goto L5;
        this.a.clearChatGeneralDraft();
    L5:
        if (r4 == false) goto L7;
        this.a.clearChatScheduleDraft();
    L7:
        KeyboardViewModel r5 = this.a;
        Intrinsics.checkNotNullParameter(r15, "params");
        Draft r6 = new Draft();
        ReEditInfo r7 = (ReEditInfo) r15.a(ReEditInfo.Companion);
        cya.i r8 = (cya.i) r15.a(cya.i.h);
        cya.a r9 = (cya.a) r15.a(cya.a.c);
        o r10 = (o) r15.a(o.f);
        QueryStatusInfo r11 = (QueryStatusInfo) r15.a(QueryStatusInfo.Companion);
        StringBuilder r12 = new StringBuilder("parseDraftFromParams: reEditInfo is null ? ");
        boolean r13 = true;
        if (r7 != null) goto L10;
        boolean r16 = true;
    L11:
        r12.append(r16);
        r12.append(" , replyInfo is null ? ");
        if (r8 != null) goto L14;
        boolean r17 = true;
    L15:
        r12.append(r17);
        r12.append(" , editInfo is null ? ");
        if (r9 != null) goto L18;
        boolean r18 = true;
    L19:
        r12.append(r18);
        r12.append(" , scheduleSendInfo is null ? ");
        if (r10 != null) goto L22;
        boolean r19 = true;
    L23:
        r12.append(r19);
        r12.append(",queryStatusInfo is null ? ");
        if (r11 != null) goto L26;
        boolean r110 = true;
    L27:
        r12.append(r110);
        Log.i("KeyboardEditUtils", r12.toString());
        PartialReplyInfo r20 = null;
        if (r9 == null) goto L30;
        RichText r111 = r9.a;
    L31:
        r6.contentRichText = r111;
        if (r9 == null) goto L34;
        RichText r112 = r9.a;
    L35:
        r6.postRichText = r112;
        if (r9 == null) goto L38;
        String r21 = r9.b;
    L39:
        r6.title = r21;
        if (r8 == null) goto L42;
        String r22 = r8.a;
    L43:
        r6.messageId = r22;
        if (r7 == null) goto L46;
        r6.type = 6;
        r6.reEditMessageId = r7.getMessageId();
    L46:
        if (r10 == null) goto L61;
        r6.type = 7;
        ScheduleDraftInfo r23 = new ScheduleDraftInfo();
        r23.setScheduleSendTime(r10.a);
        r23.setScheduleMessageId(r10.d);
        r23.setPreScheduleMessage(r10.e);
        r6.scheduleDraftInfo = r23;
        p r24 = r10.c;
        if (r24 != null) goto L50;
    L52:
        r13 = false;
    L53:
        if (r13 == false) goto L61;
        String r25 = "";
        r6.messageId = "";
        if (r24 == null) goto L60;
        String r26 = r24.c;
        if (r26 == null) goto L60;
        r25 = r26;
    L60:
        r6.threadId = r25;
        goto L61
    L50:
        if (r24.a != 2) goto L52;
    L61:
        if (r8 == null) goto L63;
        r20 = r8.g;
    L63:
        r6.partialReplyInfo = r20;
        r6.queryStatusInfo = r11;
        Intrinsics.checkNotNullParameter(r15, "params");
        Boolean r113 = (Boolean) r15.a(cya.h.d);
        if (r113 == null) goto L66;
        boolean r114 = r113.booleanValue();
    L67:
        r5.saveAllDraft(r6, r114, false);
        return;
    L66:
        r114 = false;
        goto L67
    L42:
        r22 = null;
        goto L43
    L38:
        r21 = null;
        goto L39
    L34:
        r112 = null;
        goto L35
    L30:
        r111 = null;
        goto L31
    L26:
        r110 = false;
        goto L27
    L22:
        r19 = false;
        goto L23
    L18:
        r18 = false;
        goto L19
    L14:
        r17 = false;
        goto L15
    L10:
        r16 = false;
        goto L11
    }

    public static /* synthetic */ <T extends mob.a> Object c(BaseChatEditor<T> r4, boolean r5, Continuation<? super cya.h> r6) {
        if ((r6 instanceof BaseChatEditor$loadInputState$1) == false) goto L7;
        BaseChatEditor$loadInputState$1 r0 = (BaseChatEditor$loadInputState$1) r6;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        BaseChatEditor r8 = (BaseChatEditor) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L20:
        return x.c((a7b.a) r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r4;
        r0.Z$0 = r5;
        r0.label = 1;
        j r9 = new j(IntrinsicsKt.intercepted(r0), 1);
        r9.C();
        r4.a.resetChatDraft(r5, new b(r9));
        r7 = r9.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L17:
        if (r7 != r2) goto L20;
        return r2;
    L7:
        r0 = new BaseChatEditor$loadInputState$1(r4, r6);
        goto L8
    }
}
