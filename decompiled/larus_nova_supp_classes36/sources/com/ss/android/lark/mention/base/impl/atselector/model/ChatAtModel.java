package com.ss.android.lark.mention.base.impl.atselector.model;

import android.text.TextUtils;
import ccb.d;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.GetMentionChatterSensitiveInfoRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetContinualDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.AtPresenter;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.model.loader.RecommendDataLoader;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ChatAtModel extends BaseAtModel {
    public RecommendDataLoader i;
    public Chat j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final a n;

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel$3, reason: invalid class name */
    class AnonymousClass3 implements IGetDataCallback<d> {
        final /* synthetic */ ChatAtModel this$0;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ String val$requestID;

        public void onError(ErrorResult r3) {
            if (this.this$0.h.equals(this.val$requestID) == true) goto L5;
            return;
        L5:
            IGetDataCallback r0 = this.val$callback;
            if (r0 == null) goto L9;
            r0.onError(r3);
            return;
        }

        public void onSuccess(d r3) {
            if (this.this$0.h.equals(this.val$requestID) == true) goto L5;
            return;
        L5:
            IGetDataCallback r0 = this.val$callback;
            if (r0 == null) goto L9;
            r0.onSuccess(r3);
            return;
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((d) r1);
        }

        public AnonymousClass3(ChatAtModel r1, String r2, IGetDataCallback r3) {
            this.this$0 = r1;
            this.val$requestID = r2;
            this.val$callback = r3;
        }
    }

    public class a extends aqb.a {
        public final /* synthetic */ ChatAtModel a;

        public a(ChatAtModel r1) {
            this.a = r1;
        }

        @Override // aqb.a
        public final void onPushChat(Chat r4) {
            ChatAtModel r0 = this.a;
            r0.getClass();
            if (r4.getId().equals(r0.a) == true) goto L5;
            return;
        L5:
            if (r4.isP2PChat() == true) goto L20;
            Chat.AtAllPermission r1 = r4.getAtAllPermission();
            if (MentionUtils.d(r4) == false) goto L10;
            return;
        L10:
            if (r1 != Chat.AtAllPermission.ALL_MEMBERS) goto L13;
            com.ss.android.lark.mention.base.impl.atselector.d.a r5 = r0.b;
            final List<BaseAtBean> r2 = r0.d;
            final AtPresenter.a r6 = (AtPresenter.a) r5;
            r6.getClass();
            final boolean r3 = true;
            UICallbackExecutor.execute(new com.ss.android.lark.mention.base.impl.atselector.a(r6, r2, r3));
            return;
        L13:
            if (r1 != Chat.AtAllPermission.ONLY_OWNER) goto L19;
            com.ss.android.lark.mention.base.impl.atselector.d.a r7 = r0.b;
            final List<BaseAtBean> r8 = r0.d;
            final AtPresenter.a r9 = (AtPresenter.a) r7;
            r9.getClass();
            final boolean r10 = false;
            UICallbackExecutor.execute(new com.ss.android.lark.mention.base.impl.atselector.a(r9, r8, r10));
            return;
        L19:
            return;
        }
    }

    public final void destroy() {
        arb.a.b.V(String.valueOf(hashCode()), this.a);
        super.destroy();
    }

    public final boolean p() {
        if (this.c.getIsInterruptAtAll() == false) goto L5;
    L13:
        return false;
    L5:
        if (s() == null) goto L13;
        if (s().getType() != Chat.Type.GROUP) goto L13;
        int r0 = MentionUtils.a;
        if (MentionUtils.d(s()) == false) goto L11;
    L12:
        return true;
    L11:
        if (s().getAtAllPermission() != Chat.AtAllPermission.ALL_MEMBERS) goto L13;
        goto L12
    }

    public final Chat s() {
        Chat r0 = this.j;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (TextUtils.isEmpty(this.a) == false) goto L10;
        return null;
    L10:
        return ImSdkService.b().we(this.a);
    }

    public final List<BaseAtBean> w() {
        if (CollectionUtils.isEmpty(this.d) == true) goto L5;
        Iterator<BaseAtBean> r0 = this.d.iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next().getId();
        Pattern r2 = o.a;
        if (r1.equals("all") == false) goto L8;
        r0.remove();
    L13:
        return this.d;
    L5:
        return new ArrayList();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final boolean T0() {
        Chat r0 = s();
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isEnable("group.mention.new.tips");
        if (r0 != null) goto L5;
    L10:
        return false;
    L5:
        if (r0.getChatMode() != Chat.ChatMode.THREAD_V2) goto L10;
        if (r0.isPublic() == false) goto L10;
        if (r1 == false) goto L10;
        return true;
    }

    public final void create() {
        super.create();
        this.i = new RecommendDataLoader(this.a, this.k, this.m, this.l);
        arb.a.b.c0(String.valueOf(hashCode()), this.a, this.n);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.mention.base.impl.atselector.model.a(this));
    }

    public final List<BaseAtBean> o() {
        if (p() == true) goto L7;
        return this.d;
    L7:
        if (CollectionUtils.isEmpty(this.d) == true) goto L9;
        HashMap r0 = new HashMap();
        Iterator r1 = ((ArrayList) this.d).iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        BaseAtBean r2 = (BaseAtBean) r1.next();
        r0.put(r2.getId(), r2);
        goto L12
    L14:
        Chat r3 = s();
        if (r3 != null) goto L17;
    L19:
        int r4 = 0;
    L20:
        Pattern r5 = o.a;
        if (r0.containsKey("all") == true) goto L24;
        ListProtector.add(this.d, 0, new AllAtBean(r4));
    L24:
        return this.d;
    L17:
        if (this.m == false) goto L19;
        r4 = r3.getUserCount();
        goto L20
    L9:
        return new ArrayList();
    }

    public ChatAtModel(AtSelectInitData r2) {
        super(r2);
        this.n = new a(this);
        this.a = r2.getChannelId();
        this.k = r2.isEnableMyAI();
        this.m = r2.isUserCountVisible();
        this.l = r2.isEnableAIKnowledge();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void U7(final IGetDataCallback<List<BaseAtBean>> r3) {
        Log.i("ChatAtModel", "start loadRecommendData, channelId: " + this.a);
        UIGetContinualDataCallback r0 = new UIGetContinualDataCallback(new AnonymousClass2(this, r3));
        RecommendDataLoader r4 = this.i;
        IGetDataCallback r1 = getCallbackManager().wrapAndAddCallback(r0);
        r4.getClass();
        RxScheduledExecutor.justInIO(new com.ss.android.lark.mention.base.impl.atselector.model.loader.b(r4, r1));
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void d1(Map<String, ChatterSensitiveInfo> r4, List<BaseAtBean> r5) {
        if (CollectionUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(r5) == true) goto L32;
        Iterator<BaseAtBean> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L33;
        BaseAtBean r0 = r6.next();
        if ((r0 instanceof SearchBean) == false) goto L9;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r1 = ((SearchBean) r0).getChatterInfo();
        if (r1 == null) goto L9;
        if (r4.containsKey(r1.a) == false) goto L19;
        if (r4.get(r1.a) == null) goto L19;
        r1.q = r4.get(r1.a);
    L19:
        Log.e("ChatAtModel", "chatterId2SensitiveInfo not contains key: " + r1.a);
        goto L9
    L33:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void N2(String r10, String r11, IGetDataCallback<d> r12) {
        StringBuilder r0 = new StringBuilder("netSearch, searchKey length: ");
        if (r10 == null) goto L5;
        int r1 = r10.length();
    L6:
        r0.append(r1);
        r0.append(", requestID: ");
        r0.append(r11);
        Log.i("ChatAtModel", r0.toString());
        this.g = r10;
        this.h = r11;
        ChatService.c.a.m(this.a, r10, r11, true, this.l, getCallbackManager().wrapAndAddGetDataCallback(new AnonymousClass3(this, r11, r12)));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void m2(List r6, final String r7, IGetDataCallback r8) {
        if (CollectionUtils.isEmpty(r6) == false) goto L6;
        Log.e("ChatAtModel", "beanList is null or empty");
        return;
    L6:
        final ArrayList r0 = new ArrayList();
        Iterator r9 = r6.iterator();
    L8:
        if (r9.hasNext() == false) goto L22;
        BaseAtBean r3 = (BaseAtBean) r9.next();
        if ((r3 instanceof SearchBean) == false) goto L8;
        SearchBean r4 = (SearchBean) r3;
        if (r4.getChatterInfo() == null) goto L8;
        if (r4.getChatterInfo().b() == true) goto L8;
        Long r5 = CastLongProtector.valueOf(r4.getChatterInfo().a);     // Catch: Throwable -> L18
    L20:
        r0.add(r5);
    L18:
        th = move-exception;
        Log.e("ChatAtModel", th);
        r5 = null;
        goto L20
    L22:
        if (CollectionUtils.isEmpty(r0) == false) goto L25;
        Log.e("ChatAtModel", "beanList is null or empty");
        return;
    L25:
        Log.i("ChatAtModel", "request chatter ids size: " + r0.size());
        GetMentionChatterSensitiveInfoRequest.Builder r10 = new GetMentionChatterSensitiveInfoRequest.Builder();
        r10.strategy(SyncDataStrategy.FORCE_SERVER);
        r10.chatter_ids(r0);
        SdkSender.asynSendRequestNonWrap(Command.GET_MENTION_CHATTER_SENSITIVE_INFO, r10, r7, r8, new b(this, r0, r7));
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void z1(String r10, String r11, IGetDataCallback<d> r12) {
        StringBuilder r0 = new StringBuilder("localSearch, searchKey length: ");
        if (r10 == null) goto L5;
        int r1 = r10.length();
    L6:
        r0.append(r1);
        r0.append(", requestID: ");
        r0.append(r11);
        Log.i("ChatAtModel", r0.toString());
        this.g = r10;
        this.h = r11;
        ChatService.c.a.m(this.a, r10, r11, false, this.l, getCallbackManager().wrapAndAddGetDataCallback(new AnonymousClass3(this, r11, r12)));
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
