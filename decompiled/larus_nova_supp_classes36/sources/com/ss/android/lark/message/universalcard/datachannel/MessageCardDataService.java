package com.ss.android.lark.message.universalcard.datachannel;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardEntityAddedNotify;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.p;
import com.ss.android.lark.sdk.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessageCardDataService implements com.ss.android.lark.message.universalcard.datachannel.a, g.b {
    public static final Lazy<Boolean> c = null;
    public static final List<g.b> d = null;
    public final UniversalCardSubscriptionManager a;
    public final HashMap<String, CardRenderData> b;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        c = LazyKt.lazy(MessageCardDataService$Companion$streamingCardMergeEnable$2.INSTANCE);
        d = new ArrayList();
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void onDestroy() {
        Log.i("MessageCardDataService", "destroy");
        if (((Boolean) c.getValue()).booleanValue() == true) goto L8;
        Log.i("MessageCardDataService", "unRegisterPushListener");
        ArrayList r1 = (ArrayList) d;
        r1.remove(this);
        if (r1.isEmpty() == false) goto L8;
        Log.i("MessageCardDataService", "unRegisterPushListener to sdk");
        g.e.a.c(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED);
    L8:
        UniversalCardSubscriptionManager r0 = this.a;
        if (r0.d == false) goto L11;
        Log.e("UniversalCardSubscriptionManager", "destroy, already destroyed");
    L12:
        this.b.clear();
        return;
    L11:
        Log.i("UniversalCardSubscriptionManager", "start destroy");
        r0.d = true;
        r0.c.offer(new UniversalCardSubscriptionManager.DestroyTask(r0));
        r0.a.quitSafely();
        goto L12
    }

    public MessageCardDataService() {
        this.a = new UniversalCardSubscriptionManager();
        this.b = new HashMap();
        if (((Boolean) c.getValue()).booleanValue() == true) goto L13;
        Log.i("MessageCardDataService", "registerPushListener");
        ArrayList r0 = (ArrayList) d;
        if (r0.isEmpty() == false) goto L9;
        Log.i("MessageCardDataService", "registerPushListener to sdk");
        g.e.a.b(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED, d.a);
    L9:
        if (r0.contains(this) == true) goto L12;
        r0.add(this);
        return;
    L12:
        return;
    }

    public final void a(byte[] r4) {
        if (r4 == null) goto L15;
        UniversalCardEntityAddedNotify r5 = (UniversalCardEntityAddedNotify) UniversalCardEntityAddedNotify.ADAPTER.decode(r4);
        if (r5 == null) goto L13;
        List r6 = r5.universal_card_entity_infos;
        if (r6 == null) goto L16;
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L17;
        UniversalCardEntityAddedNotify.UniversalCardEntityInfo r0 = (UniversalCardEntityAddedNotify.UniversalCardEntityInfo) r7.next();
        Log.i("MessageCardDataService", "onPushEntity card_id=" + r0.entity.card_id);
        UniversalCardEntity r1 = r0.entity;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        CardDataUtils.a.getClass();
        r2.element = CardDataUtils.b(r1);
        ThreadUtils.runOnUIThread(new c(r2, this));
        goto L11
    L17:
        return;
    L16:
        return;
    L13:
        return;
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final CardRenderData d(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return this.b.get(r2);
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void g(CardRenderData r14, boolean r15) {
        CardRenderData.LinkType r0 = r14.component1();
        CardData r1 = r14.component3();
        String r2 = r1.getUniversalCardID();
        if (r2 == null) goto L79;
        boolean r6 = false;
        boolean r7 = true;
        if (r2.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        Object r8 = null;
        if (r5 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L79;
        String r9 = r1.getUniversalCardVersion();
        if (r9 == null) goto L19;
        Long r10 = StringsKt.toLongOrNull(r9);
        if (r10 == null) goto L19;
    L24:
        long r11 = r10.longValue();
        CardRenderData r12 = this.b.get(r2);
        StringBuilder r13 = new StringBuilder("UpdateCardRenderData ");
        r13.append(r14.getBizID());
        r13.append(" cache: ");
        if (r12 == null) goto L29;
        CardData r16 = r12.getCardData();
        if (r16 == null) goto L29;
        String r17 = r16.getUniversalCardVersion();
    L30:
        r13.append(r17);
        r13.append(", new: ");
        r13.append(r1.getUniversalCardVersion());
        r13.append(", source: ");
        r13.append(r0);
        Log.i("MessageCardDataService", r13.toString());
        if (r12 != null) goto L33;
        this.b.put(r2, r14);
    L56:
        if (r15 == false) goto L76;
        if (r7 == false) goto L85;
        CardRenderData r18 = this.b.get(r2);
        if (r18 == null) goto L62;
        r14 = r18;
    L62:
        UniversalCardSubscriptionManager r19 = this.a;
        r19.getClass();
        Iterator r110 = new HashMap(r19.e).values().iterator();
    L64:
        if (r110.hasNext() == false) goto L68;
        Object r3 = r110.next();
        if (Intrinsics.areEqual(((UniversalCardSubscriptionManager.b) r3).a, r2) == false) goto L64;
        r8 = r3;
    L68:
        UniversalCardSubscriptionManager.b r20 = (UniversalCardSubscriptionManager.b) r8;
        if (r20 == null) goto L86;
        Map<b, String> r111 = r20.c;
        if (r111 == null) goto L87;
        Iterator<Map.Entry<b, String>> r112 = r111.entrySet().iterator();
    L74:
        if (r112.hasNext() == false) goto L88;
        r112.next().getKey().a(r14);
        goto L74
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L76:
        return;
    L33:
        String r4 = r12.getCardData().getUniversalCardVersion();
        if (r4 == null) goto L37;
        Long r21 = StringsKt.toLongOrNull(r4);
        if (r21 == null) goto L37;
    L41:
        if (r21 != null) goto L45;
        Log.e("MessageCardDataService", "UpdateCardRenderData " + r14.getBizID() + " cardDataVersion or dataVersion is null");
        return;
    L45:
        if (r11 < r21.longValue()) goto L48;
        this.b.put(r2, r14);
    L48:
        if (r14.getLinkType() != CardRenderData.LinkType.MESSAGE) goto L53;
        CardRenderData r22 = this.b.get(r2);
        if (r22 == null) goto L53;
        r22.setCardContext(r14.getCardContext());
        r22.setCardConfig(r14.getCardConfig());
    L53:
        if (r11 <= r21.longValue()) goto L55;
        r6 = true;
    L55:
        r7 = r6;
    L37:
        String r23 = r12.getCardData().getVersion();
        if (r23 == null) goto L40;
        r21 = StringsKt.toLongOrNull(r23);
        goto L41
    L40:
        r21 = null;
    L29:
        r17 = null;
    L19:
        String r24 = r1.getVersion();
        if (r24 == null) goto L22;
        r10 = StringsKt.toLongOrNull(r24);
    L23:
        if (r10 != null) goto L24;
        Log.i("MessageCardDataService", "UpdateCardRenderData " + r14.getBizID() + " universalCardVersion is null");
        return;
    L22:
        r10 = null;
        goto L23
    L7:
        r5 = false;
    L79:
        Log.i("MessageCardDataService", "UpdateCardRenderData " + r14.getBizID() + " universalCardID is empty");
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void b(String r9, String r10, p r11) {
        Intrinsics.checkNotNullParameter(r11, "subscriber");
        boolean r1 = true;
        if (r9 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        Log.e("MessageCardDataService", "subscribeCardRenderData messageID is null");
        return;
    L13:
        if (r10 != null) goto L15;
    L18:
        if (r1 == false) goto L21;
        Log.e("MessageCardDataService", "subscribeCardRenderData universalCardID is null");
        return;
    L21:
        CardRenderData r2 = this.b.get(r10);
        if (r2 != null) goto L26;
        Log.e("MessageCardDataService", "subscribeCardRenderData render data is null");
        return;
    L26:
        if (r2.getCardData().isStreamingMode() == false) goto L32;
        UniversalCardSubscriptionManager r4 = this.a;
        int r5 = UniversalCardBizType.BIZ_TYPE_MESSAGE_CARD.getValue();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r9, "bizID");
        Intrinsics.checkNotNullParameter(r10, "universalCardID");
        Intrinsics.checkNotNullParameter(r11, "subscriber");
        if (r4.d == false) goto L30;
        Log.e("UniversalCardSubscriptionManager", "subscribeCardRenderData, already destroyed");
        return;
    L30:
        UniversalCardSubscriptionManager.SubscriptionTask r0 = new UniversalCardSubscriptionManager.SubscriptionTask(r4, r9, r5, r10, r11);
        r4.c.offer(r0);
        return;
    L32:
        return;
    L15:
        if (r10.length() == 0) goto L18;
        r1 = false;
        goto L18
    L5:
        if (r9.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void e(String r6, String r7, p r8) {
        Intrinsics.checkNotNullParameter(r8, "subscriber");
        boolean r1 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        Log.w("MessageCardDataService", "unsubscribeCardRenderData messageID is null");
        return;
    L13:
        if (r7 != null) goto L15;
    L18:
        if (r1 == false) goto L22;
        Log.w("MessageCardDataService", "unsubscribeCardRenderData universalCardID is null");
        return;
    L22:
        if (this.b.get(r7) != null) goto L25;
        Log.w("MessageCardDataService", "unsubscribeCardRenderData render data is null");
        return;
    L25:
        UniversalCardSubscriptionManager r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "bizID");
        Intrinsics.checkNotNullParameter(r7, "universalCardID");
        Intrinsics.checkNotNullParameter(r8, "subscriber");
        if (r2.d == false) goto L28;
        Log.e("UniversalCardSubscriptionManager", "unsubscribeCardRenderData, already destroyed");
        return;
    L28:
        UniversalCardSubscriptionManager.UnSubscriptionTask r0 = new UniversalCardSubscriptionManager.UnSubscriptionTask(r2, r6, r7, r8);
        r2.c.offer(r0);
        return;
    L15:
        if (r7.length() == 0) goto L18;
        r1 = false;
        goto L18
    L5:
        if (r6.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void c(String r8, CardData r9, CardContext r10, CardConfig r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "messageID");
        Intrinsics.checkNotNullParameter(r9, "cardData");
        Intrinsics.checkNotNullParameter(r10, "cardContext");
        Intrinsics.checkNotNullParameter(r11, "cardConfig");
        g(new CardRenderData(CardRenderData.LinkType.MESSAGE, r8, r9, r10, r11), r12);
    }
}
