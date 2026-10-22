package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.google.gson.annotations.SerializedName;
import e7.j0;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/AsrStateChangeEvent;", "", "Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/AsrStateChangeEvent$Type;", "type", "Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/AsrStateChangeEvent$Type;", "getType", "()Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/AsrStateChangeEvent$Type;", "b", "(Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/AsrStateChangeEvent$Type;)V", "", "textMsg", "Ljava/lang/String;", "getTextMsg", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "", "isConnected", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setConnected", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Type", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AsrStateChangeEvent {

    @SerializedName("isConnected")
    private Boolean isConnected;

    @SerializedName("textMsg")
    private String textMsg;

    @SerializedName("type")
    private Type type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/AsrStateChangeEvent$Type;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Started", "GetResulted", "Finished", "Failed", "WebSocketStateChanged", "GetPartialResulted", "GetAudioFile", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Type extends Enum<Type> implements j0 {
        public static final Type Failed = null;
        public static final Type Finished = null;
        public static final Type GetAudioFile = null;
        public static final Type GetPartialResulted = null;
        public static final Type GetResulted = null;
        public static final Type Started = null;
        public static final Type WebSocketStateChanged = null;
        public static final /* synthetic */ Type[] a = null;
        private final int value;

        static {
            Type r1 = new Type("Started", 0, 100);
            Started = r1;
            Type r2 = new Type("GetResulted", 1, 101);
            GetResulted = r2;
            Type r3 = new Type("Finished", 2, 102);
            Finished = r3;
            Type r4 = new Type("Failed", 3, 103);
            Failed = r4;
            Type r5 = new Type("WebSocketStateChanged", 4, 104);
            WebSocketStateChanged = r5;
            Type r6 = new Type("GetPartialResulted", 5, com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER);
            GetPartialResulted = r6;
            Type r7 = new Type("GetAudioFile", 6, 106);
            GetAudioFile = r7;
            a = new Type[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public AsrStateChangeEvent() {
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();
        Type r1 = this.type;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getCode());
    L6:
        r0.put("type", r2);
        r0.put("textMsg", this.textMsg);
        r0.put("isConnected", this.isConnected);
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public final Type getType() {
        return this.type;
    }

    public final void a(String r1) {
        this.textMsg = r1;
    }

    public final void b(Type r1) {
        this.type = r1;
    }
}
