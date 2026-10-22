package com.larksuite.component.card.plugin.audio;

import com.larksuite.component.card.cardcontainer.c;
import com.larksuite.component.card.plugin.h;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import j18.f;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J*\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u0017\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin;", "Lcom/larksuite/component/card/plugin/audio/BaseCardAudioPlugin;", "<init>", "()V", "operateAudio", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiOperateAudioRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiOperateAudioResponse;", "handleOperation", "audioService", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService;", "operation", "Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiAudioOperation;", "monitorData", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService$CardAudioMonitorData;", "handlePlay", "handlePause", "handleStop", "handleSeek", "getMonitorData", "CardApiOperateAudioRequest", "CardApiAudioOperation", "CardApiAudioOperationType", "CardApiOperateAudioResponse", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardOperateAudioPlugin extends BaseCardAudioPlugin {
    private static final String API_NAME = "universalCardOperateAudio";
    public static final a Companion = null;
    private static final String TAG = "CardOperateAudioPlugin";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\t¨\u0006#"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiAudioOperation;", "Ljava/io/Serializable;", "<init>", "()V", "sessionID", "", "getSessionID", "()Ljava/lang/String;", "setSessionID", "(Ljava/lang/String;)V", "type", "getType", "setType", "fileID", "getFileID", "setFileID", "position", "", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "duration", "getDuration", "setDuration", "isTranslateElement", "", "()Ljava/lang/Boolean;", "setTranslateElement", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "source", "getSource", "setSource", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiAudioOperation implements Serializable {
        private Integer duration;
        private String fileID;
        private Boolean isTranslateElement;
        private Integer position;
        private String sessionID;
        private String source;
        private String type;

        public CardApiAudioOperation() {
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final String getFileID() {
            return this.fileID;
        }

        public final Integer getPosition() {
            return this.position;
        }

        public final String getSessionID() {
            return this.sessionID;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getType() {
            return this.type;
        }

        public final Boolean isTranslateElement() {
            return this.isTranslateElement;
        }

        public final void setDuration(Integer r1) {
            this.duration = r1;
        }

        public final void setFileID(String r1) {
            this.fileID = r1;
        }

        public final void setPosition(Integer r1) {
            this.position = r1;
        }

        public final void setSessionID(String r1) {
            this.sessionID = r1;
        }

        public final void setSource(String r1) {
            this.source = r1;
        }

        public final void setTranslateElement(Boolean r1) {
            this.isTranslateElement = r1;
        }

        public final void setType(String r1) {
            this.type = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiOperateAudioRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "operations", "", "Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiAudioOperation;", "getOperations", "()[Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiAudioOperation;", "setOperations", "([Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiAudioOperation;)V", "[Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiAudioOperation;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiOperateAudioRequest extends LKBaseRequestModel {
        private CardApiAudioOperation[] operations;

        public CardApiOperateAudioRequest() {
        }

        public final CardApiAudioOperation[] getOperations() {
            return this.operations;
        }

        public final void setOperations(CardApiAudioOperation[] r1) {
            this.operations = r1;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/CardOperateAudioPlugin$CardApiOperateAudioResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiOperateAudioResponse extends LKBaseResponseModel {
        public CardApiOperateAudioResponse() {
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LKEvent a;
        public final /* synthetic */ CardOperateAudioPlugin b;
        public final /* synthetic */ CardApiOperateAudioRequest c;
        public final /* synthetic */ f<CardApiOperateAudioResponse> d;

        public b(LKEvent r1, CardOperateAudioPlugin r2, CardApiOperateAudioRequest r3, f<CardApiOperateAudioResponse> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            LKEvent r0 = this.a;
            if (r0 == null) goto L14;
            com.larksuite.component.card.component.audio.service.b r1 = this.b.getAudioService(r0);
            if (r1 == null) goto L14;
            CardApiOperateAudioRequest r2 = this.c;
            if (r2 == null) goto L13;
            CardApiAudioOperation[] r3 = r2.getOperations();
            if (r3 == null) goto L17;
            CardOperateAudioPlugin r4 = this.b;
            LKEvent r5 = this.a;
            int r6 = r3.length;
            int r7 = 0;
        L11:
            if (r7 >= r6) goto L18;
            CardApiAudioOperation r8 = r3[r7];
            CardOperateAudioPlugin.access$handleOperation(r4, r5, r1, r8, CardOperateAudioPlugin.access$getMonitorData(r4, r8, r5));
            r7 = r7 + 1;
            goto L11
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L14:
            f<CardApiOperateAudioResponse> r9 = this.d;
            CardApiOperateAudioResponse r10 = new CardApiOperateAudioResponse();
            r10.setApiErrNo(o18.a.e);
            r9.callback(r10);
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

    public CardOperateAudioPlugin() {
    }

    private final com.larksuite.component.card.component.audio.service.b.a getMonitorData(CardApiAudioOperation r2, LKEvent r3) {
        if (r3 == null) goto L4;
        c r4 = h.a(r3);
    L5:
        if (r4 == null) goto L12;
        CardContext r5 = r4.c;
        if (r5 == null) goto L12;
        BizContext r6 = r5.getBizContext();
        if (r6 == null) goto L12;
        String r7 = r6.getBizId();
        if (r7 == null) goto L12;
    L14:
        return new com.larksuite.component.card.component.audio.service.b.a(r7, r2.getSource());
    L12:
        r7 = "";
        goto L14
    L4:
        r4 = null;
        goto L5
    }

    public static final /* synthetic */ com.larksuite.component.card.component.audio.service.b.a access$getMonitorData(CardOperateAudioPlugin r0, CardApiAudioOperation r1, LKEvent r2) {
        return r0.getMonitorData(r1, r2);
    }

    private final void handlePause(com.larksuite.component.card.component.audio.service.b r1, CardApiAudioOperation r2, com.larksuite.component.card.component.audio.service.b.a r3) {
        String r4 = r2.getSessionID();
        if (r4 != null) goto L6;
        Log.e(TAG, "handlePause sessionID is null");
        return;
    L6:
        r1.l(r4, r3);
    }

    private final void handleStop(com.larksuite.component.card.component.audio.service.b r1, CardApiAudioOperation r2, com.larksuite.component.card.component.audio.service.b.a r3) {
        String r4 = r2.getSessionID();
        if (r4 != null) goto L6;
        Log.e(TAG, "handlePause sessionID is null");
        return;
    L6:
        r1.c(r4, r3);
    }

    @LKPluginFunction(async = true, eventName = {API_NAME})
    public final void operateAudio(LKEvent r2, CardApiOperateAudioRequest r3, f<CardApiOperateAudioResponse> r4) {
        Intrinsics.checkNotNullParameter(r4, "invokeCallback");
        mz7.b.a(new b(r2, this, r3, r4));
        r4.callback(new CardApiOperateAudioResponse());
    }

    private final void handleOperation(LKEvent r3, com.larksuite.component.card.component.audio.service.b r4, CardApiAudioOperation r5, com.larksuite.component.card.component.audio.service.b.a r6) {
        String r0 = r5.getType();
        if (r0 != null) goto L5;
        return;
    L5:
        switch(r0.hashCode()) {
            case 3443508: goto L20;
            case 3526264: goto L16;
            case 3540994: goto L12;
            case 106440182: goto L8;
            default: goto L28;
        };
    L28:
        return;
    L8:
        if (r0.equals("pause") == false) goto L29;
        handlePause(r4, r5, r6);
        return;
    L29:
        return;
    L12:
        if (r0.equals("stop") == false) goto L30;
        handleStop(r4, r5, r6);
        return;
    L30:
        return;
    L16:
        if (r0.equals("seek") == false) goto L31;
        handleSeek(r3, r4, r5, r6);
        return;
    L31:
        return;
    L20:
        if (r0.equals("play") == false) goto L32;
        handlePlay(r3, r4, r5, r6);
        return;
    }

    private final void handlePlay(LKEvent r7, com.larksuite.component.card.component.audio.service.b r8, CardApiAudioOperation r9, com.larksuite.component.card.component.audio.service.b.a r10) {
        String r1 = r9.getSessionID();
        if (r1 != null) goto L6;
        Log.e(TAG, "handlePlay sessionID is null");
        return;
    L6:
        String r2 = r9.getFileID();
        if (r2 != null) goto L10;
        Log.e(TAG, "handlePlay fileID is null");
        return;
    L10:
        CardAttachment r3 = null;
        if (Intrinsics.areEqual(r9.isTranslateElement(), Boolean.TRUE) == false) goto L20;
        if (r7 == null) goto L28;
        c r11 = h.a(r7);
        if (r11 == null) goto L28;
        CardData r12 = r11.b;
        if (r12 == null) goto L28;
        CardContent r13 = r12.getTranslateContent();
        if (r13 == null) goto L28;
        r3 = r13.getAttachment();
    L28:
        if (r3 == null) goto L36;
        HashMap<String, AudioInfo> r14 = r3.getAudios();
        if (r14 == null) goto L36;
        AudioInfo r4 = r14.get(r2);
        if (r4 == null) goto L36;
        r8.j(r1, r4, 0, r10, false);
        return;
    L36:
        Log.e(TAG, "handlePlay cannot find AudioInfo");
        return;
    L20:
        if (r7 == null) goto L28;
        c r15 = h.a(r7);
        if (r15 == null) goto L28;
        CardData r16 = r15.b;
        if (r16 == null) goto L28;
        CardContent r17 = r16.getCardContent();
        if (r17 == null) goto L28;
        r3 = r17.getAttachment();
        goto L28
    }

    private final void handleSeek(LKEvent r6, com.larksuite.component.card.component.audio.service.b r7, CardApiAudioOperation r8, com.larksuite.component.card.component.audio.service.b.a r9) {
        String r0 = r8.getSessionID();
        if (r0 != null) goto L6;
        Log.e(TAG, "handlePause sessionID is null");
        return;
    L6:
        String r2 = r8.getFileID();
        if (r2 != null) goto L10;
        Log.e(TAG, "handleSeek fileID is null");
        return;
    L10:
        CardAttachment r4 = null;
        if (Intrinsics.areEqual(r8.isTranslateElement(), Boolean.TRUE) == false) goto L20;
        if (r6 == null) goto L28;
        c r10 = h.a(r6);
        if (r10 == null) goto L28;
        CardData r11 = r10.b;
        if (r11 == null) goto L28;
        CardContent r12 = r11.getTranslateContent();
        if (r12 == null) goto L28;
        r4 = r12.getAttachment();
    L28:
        if (r4 == null) goto L40;
        HashMap<String, AudioInfo> r13 = r4.getAudios();
        if (r13 == null) goto L40;
        AudioInfo r14 = r13.get(r2);
        if (r14 == null) goto L40;
        Integer r15 = r8.getPosition();
        if (r15 == null) goto L37;
        int r16 = r15.intValue();
    L38:
        r7.f(r0, r14, r16, r9);
        return;
    L37:
        r16 = 0;
    L40:
        Log.e(TAG, "handleSeek cannot find AudioInfo");
        return;
    L20:
        if (r6 == null) goto L28;
        c r17 = h.a(r6);
        if (r17 == null) goto L28;
        CardData r19 = r17.b;
        if (r19 == null) goto L28;
        CardContent r20 = r19.getCardContent();
        if (r20 == null) goto L28;
        r4 = r20.getAttachment();
        goto L28
    }

    public static final /* synthetic */ void access$handleOperation(CardOperateAudioPlugin r0, LKEvent r1, com.larksuite.component.card.component.audio.service.b r2, CardApiAudioOperation r3, com.larksuite.component.card.component.audio.service.b.a r4) {
        r0.handleOperation(r1, r2, r3, r4);
    }
}
