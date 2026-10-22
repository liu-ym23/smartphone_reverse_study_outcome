package com.ss.android.lark.chat.api.service.impl.smartreply;

import a2b.j;
import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.GetSmartAIReplyRequest;
import com.bytedance.lark.pb.im.v1.GetSmartAIReplyResponse;
import com.bytedance.lark.pb.im.v1.PushSmartAIReply;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class SmartApplyAnswerService implements j {
    public final b38.b a;
    public final List<j.b> b;
    public final Lazy c;

    public static final class a {
    }

    public interface b {
        @SdkCall(50519)
        RucketJob<GetSmartAIReplyResponse> getSmartAIReply(GetSmartAIReplyRequest r1);

        @SdkPush(50518)
        RucketJob<PushSmartAIReply> pushSmartAIReply();
    }

    static {
    }

    @Inject
    public SmartApplyAnswerService(b38.b r2) {
        Intrinsics.checkNotNullParameter(r2, "rucket");
        this.a = r2;
        this.b = new CopyOnWriteArrayList();
        this.c = LazyKt.lazy(new SmartApplyAnswerService$service$2(this));
    }

    @Override // a2b.j
    public final MessageInfo u3(MessageInfo r9, Function0<? extends j.a> r10) {
        Intrinsics.checkNotNullParameter(r9, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r10, "getSmartApplyAnswerDependencyLoader");
        Message r0 = r9.getMessage();
        if (r0.getAiSmartReply() != null) goto L36;
        List<ReactionInfo> r1 = r9.getReactionInfoList();
        String r2 = r0.getFromId();
        j.a r11 = (j.a) r10.invoke();
        boolean r3 = false;
        if (r1 != null) goto L7;
    L34:
        if (r3 == false) goto L36;
        Log.i("SmartApplyAnswerCache", "fetch message smartReply " + r0.getId());
        Log.e("SmartApplyAnswerCache", "CoroutineScope not launch!");
        Unit r12 = Unit.INSTANCE;
        goto L36
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L34;
        if (r11 == null) goto L34;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.disable_ai_nailed_it") == true) goto L34;
        List<ReactionInfo> r4 = r1;
        if ((r4 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r5 = r4.iterator();
    L20:
        if (r5.hasNext() == false) goto L29;
        ReactionInfo r6 = (ReactionInfo) r5.next();
        if (Intrinsics.areEqual(r6.getReaction().getType(), "AINailedIt") == true) goto L24;
    L26:
        boolean r7 = false;
    L27:
        if (r7 == false) goto L20;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L32;
    L33:
        r3 = true;
        goto L34
    L32:
        if (Intrinsics.areEqual(r2, r11.a()) == false) goto L34;
    L24:
        if (r6.getReactionChatters().keySet().contains(r2) == false) goto L26;
        r7 = true;
    L29:
        r8 = false;
        goto L30
    L16:
        if (r4.isEmpty() == false) goto L18;
    L36:
        return r9;
    }
}
