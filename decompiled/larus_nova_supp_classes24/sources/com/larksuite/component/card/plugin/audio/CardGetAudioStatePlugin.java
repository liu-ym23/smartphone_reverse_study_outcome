package com.larksuite.component.card.plugin.audio;

import com.larksuite.component.card.component.audio.service.CardAudioStateEntity;
import com.larksuite.component.card.service.c;
import com.larksuite.component.card.service.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import j18.f;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J-\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0013J1\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin;", "Lcom/larksuite/component/card/plugin/audio/BaseCardAudioPlugin;", "<init>", "()V", "getAudioState", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin$CardApiGetAudioStateRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin$CardApiGetAudioStateResponse;", "observeAudioState", "audioService", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService;", "sessionIDs", "", "", "(Lcom/larksuite/framework/apiplugin/LKEvent;Lcom/larksuite/component/card/component/audio/service/ICardAudioService;[Ljava/lang/String;)V", "doGetAudioState", "", "Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin$CardApiAudioState;", "(Lcom/larksuite/component/card/component/audio/service/ICardAudioService;[Ljava/lang/String;)Ljava/util/Map;", "CardApiGetAudioStateRequest", "CardApiAudioState", "CardApiGetAudioStateResponse", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardGetAudioStatePlugin extends BaseCardAudioPlugin {
    private static final String API_NAME = "universalCardGetAudioState";
    private static final String BIZ_EXTRA_AUDIO_STATE_OBSERVER = "audio_state_observer";
    public static final a Companion = null;
    private static final String TAG = "CardGetAudioStatePlugin";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin$CardApiAudioState;", "Ljava/io/Serializable;", "<init>", "()V", "state", "", "getState", "()Ljava/lang/String;", "setState", "(Ljava/lang/String;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "duration", "getDuration", "setDuration", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiAudioState implements Serializable {
        private int duration;
        private int position;
        private String state;

        public CardApiAudioState() {
            this.state = CardAudioStateEntity.CardAudioStateEnum.STOPPED.getValue();
        }

        public final int getDuration() {
            return this.duration;
        }

        public final int getPosition() {
            return this.position;
        }

        public final String getState() {
            return this.state;
        }

        public final void setDuration(int r1) {
            this.duration = r1;
        }

        public final void setPosition(int r1) {
            this.position = r1;
        }

        public final void setState(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.state = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin$CardApiGetAudioStateRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "sessionIDs", "", "", "getSessionIDs", "()[Ljava/lang/String;", "setSessionIDs", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiGetAudioStateRequest extends LKBaseRequestModel {
        private String[] sessionIDs;

        public CardApiGetAudioStateRequest() {
        }

        public final String[] getSessionIDs() {
            return this.sessionIDs;
        }

        public final void setSessionIDs(String[] r1) {
            this.sessionIDs = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin$CardApiGetAudioStateResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "audios", "", "", "Lcom/larksuite/component/card/plugin/audio/CardGetAudioStatePlugin$CardApiAudioState;", "getAudios", "()Ljava/util/Map;", "setAudios", "(Ljava/util/Map;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiGetAudioStateResponse extends LKBaseResponseModel {
        private Map<String, CardApiAudioState> audios;

        public CardApiGetAudioStateResponse() {
            this.audios = MapsKt.emptyMap();
        }

        public final Map<String, CardApiAudioState> getAudios() {
            return this.audios;
        }

        public final void setAudios(Map<String, CardApiAudioState> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.audios = r2;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LKEvent a;
        public final /* synthetic */ CardGetAudioStatePlugin b;
        public final /* synthetic */ CardApiGetAudioStateRequest c;
        public final /* synthetic */ f<CardApiGetAudioStateResponse> d;

        public b(LKEvent r1, CardGetAudioStatePlugin r2, CardApiGetAudioStateRequest r3, f<CardApiGetAudioStateResponse> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            LKEvent r0 = this.a;
            if (r0 == null) goto L15;
            com.larksuite.component.card.component.audio.service.b r1 = this.b.getAudioService(r0);
            if (r1 == null) goto L15;
            CardGetAudioStatePlugin r2 = this.b;
            LKEvent r3 = this.a;
            CardApiGetAudioStateRequest r4 = this.c;
            String[] r5 = null;
            if (r4 == null) goto L9;
            String[] r6 = r4.getSessionIDs();
        L10:
            CardGetAudioStatePlugin.access$observeAudioState(r2, r3, r1, r6);
            CardGetAudioStatePlugin r7 = this.b;
            CardApiGetAudioStateRequest r8 = this.c;
            if (r8 == null) goto L13;
            r5 = r8.getSessionIDs();
        L13:
            Map<String, CardApiAudioState> r9 = CardGetAudioStatePlugin.access$doGetAudioState(r7, r1, r5);
            f<CardApiGetAudioStateResponse> r10 = this.d;
            CardApiGetAudioStateResponse r11 = new CardApiGetAudioStateResponse();
            r11.setAudios(r9);
            r10.callback(r11);
            return;
        L9:
            r6 = null;
        L15:
            f<CardApiGetAudioStateResponse> r12 = this.d;
            Log.e(CardGetAudioStatePlugin.TAG, "getAudioState audio service is null");
            CardApiGetAudioStateResponse r13 = new CardApiGetAudioStateResponse();
            r13.setApiErrNo(o18.a.e);
            r12.callback(r13);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public CardGetAudioStatePlugin() {
    }

    private final Map<String, CardApiAudioState> doGetAudioState(com.larksuite.component.card.component.audio.service.b r8, String[] r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r9 == null) goto L10;
        int r1 = r9.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        String r3 = r9[r2];
        CardAudioStateEntity r4 = r8.getState(r3);
        if (r4 == null) goto L9;
        CardApiAudioState r5 = new CardApiAudioState();
        r5.setState(r4.getState().getValue());
        r5.setPosition(r4.getPosition());
        r5.setDuration(r4.getDuration());
        r0.put(r3, r5);
    L9:
        r2 = r2 + 1;
    L10:
        return r0;
    }

    public static final /* synthetic */ Map access$doGetAudioState(CardGetAudioStatePlugin r0, com.larksuite.component.card.component.audio.service.b r1, String[] r2) {
        return r0.doGetAudioState(r1, r2);
    }

    private final void observeAudioState(LKEvent r5, com.larksuite.component.card.component.audio.service.b r6, String[] r7) {
        Object r8 = r5.h;
        com.larksuite.component.card.cardcontainer.a r1 = null;
        if ((r8 instanceof ILynxBridgeContext) == false) goto L5;
        ILynxBridgeContext r9 = (ILynxBridgeContext) r8;
    L7:
        if (r9 == null) goto L13;
        ILynxContainerContext r10 = r9.getContainerContext();
        if (r10 == null) goto L13;
        Map r11 = r10.getBizExtra();
        if (r11 == null) goto L13;
        Object r12 = r11.get(BIZ_EXTRA_AUDIO_STATE_OBSERVER);
    L15:
        if ((r12 instanceof az7.a) == true) goto L18;
        r12 = null;
    L18:
        if (((az7.a) r12) == null) goto L21;
        Log.i(TAG, "already registered observer");
        return;
    L21:
        Object r13 = r5.h;
        if ((r13 instanceof ILynxBridgeContext) == false) goto L24;
        ILynxBridgeContext r14 = (ILynxBridgeContext) r13;
    L25:
        if (r14 == null) goto L31;
        ILynxContainerContext r15 = r14.getContainerContext();
        if (r15 == null) goto L31;
        Map r16 = r15.getBizExtra();
        if (r16 == null) goto L31;
        Object r17 = r16.get("card_service");
    L33:
        if ((r17 instanceof d) == true) goto L35;
        r17 = null;
    L35:
        d r19 = (d) r17;
        if (r19 != null) goto L38;
        c r20 = null;
    L39:
        zy7.c r21 = (zy7.c) r20;
        if (r21 != null) goto L43;
        Log.e(TAG, "observeAudioState event service is null");
        return;
    L43:
        az7.a r2 = new az7.a(r21);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(BIZ_EXTRA_AUDIO_STATE_OBSERVER, "name");
        Intrinsics.checkNotNullParameter(r2, "value");
        Object r22 = r5.h;
        if ((r22 instanceof ILynxBridgeContext) == false) goto L46;
        ILynxBridgeContext r23 = (ILynxBridgeContext) r22;
    L47:
        if (r23 == null) goto L49;
        ILynxContainerContext r24 = r23.getContainerContext();
    L51:
        if ((r24 instanceof com.larksuite.component.card.cardcontainer.a) == false) goto L53;
        r1 = (com.larksuite.component.card.cardcontainer.a) r24;
    L53:
        if (r1 == null) goto L55;
        Intrinsics.checkNotNullParameter(BIZ_EXTRA_AUDIO_STATE_OBSERVER, "key");
        Intrinsics.checkNotNullParameter(r2, "bizData");
        r1.a.put(BIZ_EXTRA_AUDIO_STATE_OBSERVER, r2);
    L55:
        r6.e(r2);
        return;
    L49:
        r24 = null;
        goto L51
    L46:
        r23 = null;
        goto L47
    L38:
        r20 = r19.getService(zy7.c.class);
    L31:
        r17 = null;
        goto L33
    L24:
        r14 = null;
    L13:
        r12 = null;
        goto L15
    L5:
        r9 = null;
        goto L7
    }

    @LKPluginFunction(async = true, eventName = {API_NAME})
    public final void getAudioState(LKEvent r12, CardApiGetAudioStateRequest r13, f<CardApiGetAudioStateResponse> r14) {
        Intrinsics.checkNotNullParameter(r14, "invokeCallback");
        StringBuilder r0 = new StringBuilder("getAudioState with sessionIDs ");
        if (r13 == null) goto L7;
        String[] r2 = r13.getSessionIDs();
        if (r2 == null) goto L7;
        String r1 = ArraysKt.joinToString$default(r2, null, null, null, 0, null, null, 63, null);
    L8:
        r0.append(r1);
        Log.i(TAG, r0.toString());
        mz7.b.a(new b(r12, this, r13, r14));
        return;
    L7:
        r1 = null;
        goto L8
    }

    public static final /* synthetic */ void access$observeAudioState(CardGetAudioStatePlugin r0, LKEvent r1, com.larksuite.component.card.component.audio.service.b r2, String[] r3) {
        r0.observeAudioState(r1, r2, r3);
    }
}
