package com.larksuite.component.card.component.audio.monitor;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardAudioMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationEnum;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PLAY", "PAUSE", "STOP", "SEEK", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AudioOperationEnum extends Enum<AudioOperationEnum> {
        public static final AudioOperationEnum PAUSE = null;
        public static final AudioOperationEnum PLAY = null;
        public static final AudioOperationEnum SEEK = null;
        public static final AudioOperationEnum STOP = null;
        public static final /* synthetic */ AudioOperationEnum[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<AudioOperationEnum> getEntries() {
            return b;
        }

        static {
            AudioOperationEnum r0 = new AudioOperationEnum("PLAY", 0, "play");
            PLAY = r0;
            AudioOperationEnum r1 = new AudioOperationEnum("PAUSE", 1, "pause");
            PAUSE = r1;
            AudioOperationEnum r2 = new AudioOperationEnum("STOP", 2, "stop");
            STOP = r2;
            AudioOperationEnum r4 = new AudioOperationEnum("SEEK", 3, "seek");
            SEEK = r4;
            AudioOperationEnum[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static AudioOperationEnum[] values() {
            return (AudioOperationEnum[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AudioOperationEnum valueOf(String r1) {
            return (AudioOperationEnum) a.a(AudioOperationEnum.class, r1);
        }

        public AudioOperationEnum(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationFailType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESOURCE", "PLAYER", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AudioOperationFailType extends Enum<AudioOperationFailType> {
        public static final AudioOperationFailType PLAYER = null;
        public static final AudioOperationFailType RESOURCE = null;
        public static final /* synthetic */ AudioOperationFailType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<AudioOperationFailType> getEntries() {
            return b;
        }

        static {
            AudioOperationFailType r0 = new AudioOperationFailType("RESOURCE", 0, "resource");
            RESOURCE = r0;
            AudioOperationFailType r1 = new AudioOperationFailType("PLAYER", 1, "player");
            PLAYER = r1;
            AudioOperationFailType[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static AudioOperationFailType[] values() {
            return (AudioOperationFailType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AudioOperationFailType valueOf(String r1) {
            return (AudioOperationFailType) a.a(AudioOperationFailType.class, r1);
        }

        public AudioOperationFailType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAIL", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AudioResult extends Enum<AudioResult> {
        public static final AudioResult FAIL = null;
        public static final AudioResult SUCCESS = null;
        public static final /* synthetic */ AudioResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<AudioResult> getEntries() {
            return b;
        }

        static {
            AudioResult r0 = new AudioResult("SUCCESS", 0, "Success");
            SUCCESS = r0;
            AudioResult r1 = new AudioResult("FAIL", 1, "Fail");
            FAIL = r1;
            AudioResult[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static AudioResult[] values() {
            return (AudioResult[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AudioResult valueOf(String r1) {
            return (AudioResult) a.a(AudioResult.class, r1);
        }

        public AudioResult(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
    }

    public static void b(String r4, AudioOperationEnum r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "bizID");
        Intrinsics.checkNotNullParameter(r5, "operation");
        JSONObject r1 = new JSONObject();
        r1.put("result", AudioResult.SUCCESS.getValue());     // Catch: Throwable -> L9
        r1.put("biz_id", r4);     // Catch: Throwable -> L9
        r1.put("operation", r5.getValue());     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        r1.put("source", r6);     // Catch: Throwable -> L9
    L6:
        if (r7 == null) goto L11;
        r1.put("file_key", r7);     // Catch: Throwable -> L9
    L11:
        Statistics.sendEvent("universal_card_audio_operation", r1);
        return;
    L9:
        th = move-exception;
        Log.e("CardAudioMonitor", "reportLoadResourceSuccess json error", th);
        goto L11
    }

    public static void a(String r4, AudioOperationEnum r5, String r6, String r7, AudioOperationFailType r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "bizID");
        Intrinsics.checkNotNullParameter(r5, "operation");
        Intrinsics.checkNotNullParameter(r8, "failType");
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        JSONObject r1 = new JSONObject();
        r1.put("result", AudioResult.FAIL.getValue());     // Catch: Throwable -> L10
        r1.put("biz_id", r4);     // Catch: Throwable -> L10
        r1.put("operation", r5.getValue());     // Catch: Throwable -> L10
        if (r6 == null) goto L6;
        r1.put("source", r6);     // Catch: Throwable -> L10
    L6:
        if (r7 == null) goto L8;
        r1.put("file_key", r7);     // Catch: Throwable -> L10
    L8:
        r1.put("fail_type", r8.getValue());     // Catch: Throwable -> L10
        r1.put("error_code", r9);     // Catch: Throwable -> L10
        r1.put("error_msg", r10);     // Catch: Throwable -> L10
    L12:
        Statistics.sendEvent("universal_card_audio_operation", r1);
        return;
    L10:
        th = move-exception;
        Log.e("CardAudioMonitor", "reportLoadResourceSuccess json error", th);
        goto L12
    }
}
