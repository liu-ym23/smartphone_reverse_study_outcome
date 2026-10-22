package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.chat.api.service.track.sample.BaseSampleRecorder$Scene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageStreamStatus;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", BaseSampleRecorder$Scene.UNKNOWN, "Transport", "Over", "Error", "Break", "Prepare", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageStreamStatus extends Enum<MessageStreamStatus> {
    public static final MessageStreamStatus Break = null;
    public static final a Companion = null;
    public static final MessageStreamStatus Error = null;
    public static final MessageStreamStatus Over = null;
    public static final MessageStreamStatus Prepare = null;
    public static final MessageStreamStatus Transport = null;
    public static final MessageStreamStatus Unknown = null;
    public static final /* synthetic */ MessageStreamStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MessageStreamStatus> getEntries() {
        return b;
    }

    static {
        MessageStreamStatus r0 = new MessageStreamStatus(BaseSampleRecorder$Scene.UNKNOWN, 0, 0);
        Unknown = r0;
        MessageStreamStatus r1 = new MessageStreamStatus("Transport", 1, 1);
        Transport = r1;
        MessageStreamStatus r3 = new MessageStreamStatus("Over", 2, 2);
        Over = r3;
        MessageStreamStatus r5 = new MessageStreamStatus("Error", 3, 3);
        Error = r5;
        MessageStreamStatus r7 = new MessageStreamStatus("Break", 4, 4);
        Break = r7;
        MessageStreamStatus r9 = new MessageStreamStatus("Prepare", 5, 5);
        Prepare = r9;
        MessageStreamStatus[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static MessageStreamStatus[] values() {
        return (MessageStreamStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MessageStreamStatus fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L22;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L20;
        return Unknown;
    L20:
        return Prepare;
    L21:
        return Break;
    L22:
        return Error;
    L23:
        return Over;
    L18:
        return Transport;
    }

    public static MessageStreamStatus valueOf(String r1) {
        return (MessageStreamStatus) r27.a.a(MessageStreamStatus.class, r1);
    }

    public MessageStreamStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
