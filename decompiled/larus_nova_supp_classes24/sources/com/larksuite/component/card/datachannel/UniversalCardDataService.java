package com.larksuite.component.card.datachannel;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.openplatform.v1.GetUniversalCardEntityByBizParamRequest;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizParam;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardEntityAddedNotify;
import com.larksuite.component.card.service.f;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.g;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/datachannel/UniversalCardDataService;", "Ljava/io/Serializable;", "bizType", "Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;", "<init>", "(Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;)V", "getBizType", "()Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;", "setBizType", "memoryCardEntityCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "bizCardEntityObserverMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larksuite/component/card/datachannel/UniversalCardDataObserver;", "onPushEntity", "", "request", "", "getCardEntity", "bizId", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/datachannel/GetCardEntityResponse;", "getCardEntityFromNativeCache", "addObserver", "observer", "removeObserver", "destroy", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardDataService implements Serializable {
    public static final b Companion = null;
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<UniversalCardDataObserver>> bizCardEntityObserverMap;
    private UniversalCardBizType bizType;
    private final ConcurrentHashMap<String, UniversalCardEntity> memoryCardEntityCache;

    public static final class a implements g.b {
        public final /* synthetic */ UniversalCardDataService a;

        public a(UniversalCardDataService r1) {
            this.a = r1;
        }

        public final void a(byte[] r2) {
            UniversalCardDataService.access$onPushEntity(this.a, r2);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public final void destroy() {
        Log.i("UniversalCardDataService", "destroy " + this.bizType);
        g.e.a.c(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED);
        this.memoryCardEntityCache.clear();
        this.bizCardEntityObserverMap.clear();
    }

    public final UniversalCardBizType getBizType() {
        return this.bizType;
    }

    public UniversalCardDataService(UniversalCardBizType r3) {
        Intrinsics.checkNotNullParameter(r3, "bizType");
        this.bizType = r3;
        this.memoryCardEntityCache = new ConcurrentHashMap();
        this.bizCardEntityObserverMap = new ConcurrentHashMap();
        g.e.a.b(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED, new a(this));
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMemoryCardEntityCache$p(UniversalCardDataService r0) {
        return r0.memoryCardEntityCache;
    }

    public final UniversalCardEntity getCardEntityFromNativeCache(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        return this.memoryCardEntityCache.get(r2);
    }

    public final void setBizType(UniversalCardBizType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bizType = r2;
    }

    public static final void access$onPushEntity(UniversalCardDataService r6, byte[] r7) {
        r6.getClass();
        if (r7 == null) goto L36;
        Iterator r8 = ((UniversalCardEntityAddedNotify) UniversalCardEntityAddedNotify.ADAPTER.decode(r7)).universal_card_entity_infos.iterator();
    L7:
        if (r8.hasNext() == false) goto L37;
        UniversalCardEntityAddedNotify.UniversalCardEntityInfo r0 = (UniversalCardEntityAddedNotify.UniversalCardEntityInfo) r8.next();
        UniversalCardBizParam r1 = r0.biz_param;
        String r2 = null;
        if (r1 == null) goto L11;
        String r3 = r1.biz_id;
    L12:
        if (r3 == null) goto L7;
        Log.i("UniversalCardDataService", "push card data bizId: " + r3 + ", version: " + r0.entity.version);
        if (r6.memoryCardEntityCache.get(r3) == null) goto L21;
        String r4 = r0.entity.version;
        UniversalCardEntity r5 = r6.memoryCardEntityCache.get(r3);
        if (r5 == null) goto L19;
        r2 = r5.version;
    L19:
        if (Intrinsics.areEqual(r4, r2) == false) goto L21;
        Log.i("UniversalCardDataService", "push version is same cache version");
        return;
    L21:
        r6.memoryCardEntityCache.put(r3, r0.entity);
        CopyOnWriteArrayList<UniversalCardDataObserver> r9 = r6.bizCardEntityObserverMap.get(r3);
        if (r9 == null) goto L7;
        Iterator<UniversalCardDataObserver> r10 = r9.iterator();
    L25:
        if (r10.hasNext() == false) goto L7;
        r10.next().notify(r3, r0.entity);
        goto L25
    L11:
        r3 = null;
        goto L12
    L37:
        return;
    }

    public final void addObserver(String r3, UniversalCardDataObserver r4) {
        Intrinsics.checkNotNullParameter(r3, "bizId");
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (this.bizCardEntityObserverMap.get(r3) != null) goto L5;
        this.bizCardEntityObserverMap.put(r3, new CopyOnWriteArrayList());
    L5:
        CopyOnWriteArrayList<UniversalCardDataObserver> r5 = this.bizCardEntityObserverMap.get(r3);
        if (r5 == null) goto L9;
        r5.add(r4);
        return;
    }

    public final void getCardEntity(final String r5, final IGetDataCallback<com.larksuite.component.card.datachannel.a> r6) {
        Intrinsics.checkNotNullParameter(r5, "bizId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        Log.i("UniversalCardDataService", "get card entity bizId is empty");
    L5:
        UniversalCardEntity r2 = getCardEntityFromNativeCache(r5);
        if (r2 == null) goto L8;
        r6.onSuccess(new com.larksuite.component.card.datachannel.a(r2, true));
        return;
    L8:
        IGetDataCallback<UniversalCardEntity> r3 = new UniversalCardDataService$getCardEntity$2$requestCallback$1(this, r5, r6);
        int r7 = com.larksuite.component.card.service.g.a;
        UniversalCardBizType r8 = this.bizType;
        Intrinsics.checkNotNullParameter(r5, "bizId");
        Intrinsics.checkNotNullParameter(r8, "bizType");
        Intrinsics.checkNotNullParameter(r3, "callback");
        UniversalCardBizParam.Builder r9 = new UniversalCardBizParam.Builder().biz_id(r5).biz_type(Integer.valueOf(r8.getValue()));
        GetUniversalCardEntityByBizParamRequest.Builder r10 = new GetUniversalCardEntityByBizParamRequest.Builder().biz_param(r9.build()).strategy(GetUniversalCardEntityByBizParamRequest.Strategy.force_net);
        SdkSender.asynSendRequestNonWrap(Command.GET_UNIVERSAL_CARD_BY_BIZ_PARAM, r10, r3, f.a);
    }

    public final void removeObserver(String r4, UniversalCardDataObserver r5) {
        Intrinsics.checkNotNullParameter(r4, "bizId");
        Intrinsics.checkNotNullParameter(r5, "observer");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<UniversalCardDataObserver> r0 = this.bizCardEntityObserverMap.get(r4);
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == false) goto L15;
        CopyOnWriteArrayList<UniversalCardDataObserver> r6 = this.bizCardEntityObserverMap.get(r4);
        if (r6 == null) goto L16;
        r6.remove(r5);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r0.contains(r5) != true) goto L10;
        r1 = true;
        goto L10
    }
}
