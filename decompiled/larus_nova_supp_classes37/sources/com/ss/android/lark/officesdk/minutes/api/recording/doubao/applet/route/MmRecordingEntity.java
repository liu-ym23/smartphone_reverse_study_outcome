package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J]\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingEntity;", "Ljava/io/Serializable;", "recordingId", "", "openSource", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "messageId", "conversationId", "botId", "doubaoStatisticInfo", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;)V", "getRecordingId", "()Ljava/lang/String;", "getOpenSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "getMessageId$annotations", "()V", "getMessageId", "getConversationId$annotations", "getConversationId", "getBotId$annotations", "getBotId", "getDoubaoStatisticInfo", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;", "getSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingEntity implements Serializable {
    private final String botId;
    private final String conversationId;
    private final DoubaoStatisticInfo doubaoStatisticInfo;
    private final String messageId;
    private final MmRecordingPageOpenSource openSource;
    private final String recordingId;
    private final MmRecordingSource source;
    private final MmRecordingUILaunchMode uiLaunchMode;

    public static /* synthetic */ MmRecordingEntity copy$default(MmRecordingEntity r9, String r10, MmRecordingPageOpenSource r11, MmRecordingUILaunchMode r12, String r13, String r14, String r15, DoubaoStatisticInfo r16, MmRecordingSource r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.recordingId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        MmRecordingPageOpenSource r3 = r9.openSource;
    L11:
        if ((r18 & 4) == 0) goto L13;
        MmRecordingUILaunchMode r4 = r9.uiLaunchMode;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.messageId;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.conversationId;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.botId;
    L27:
        if ((r18 & 64) == 0) goto L29;
        DoubaoStatisticInfo r8 = r9.doubaoStatisticInfo;
    L31:
        if ((r18 & 128) == 0) goto L33;
        MmRecordingSource r1 = r9.source;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    @Deprecated(message = "use doubaoStatisticInfo")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @Deprecated(message = "use doubaoStatisticInfo")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @Deprecated(message = "use doubaoStatisticInfo")
    public static /* synthetic */ void getMessageId$annotations() {
    }

    public final String component1() {
        return this.recordingId;
    }

    public final MmRecordingPageOpenSource component2() {
        return this.openSource;
    }

    public final MmRecordingUILaunchMode component3() {
        return this.uiLaunchMode;
    }

    public final String component4() {
        return this.messageId;
    }

    public final String component5() {
        return this.conversationId;
    }

    public final String component6() {
        return this.botId;
    }

    public final DoubaoStatisticInfo component7() {
        return this.doubaoStatisticInfo;
    }

    public final MmRecordingSource component8() {
        return this.source;
    }

    public final MmRecordingEntity copy(String r11, MmRecordingPageOpenSource r12, MmRecordingUILaunchMode r13, String r14, String r15, String r16, DoubaoStatisticInfo r17, MmRecordingSource r18) {
        Intrinsics.checkNotNullParameter(r11, "recordingId");
        Intrinsics.checkNotNullParameter(r12, "openSource");
        Intrinsics.checkNotNullParameter(r13, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r14, "messageId");
        Intrinsics.checkNotNullParameter(r15, "conversationId");
        Intrinsics.checkNotNullParameter(r16, "botId");
        return new MmRecordingEntity(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRecordingEntity) == true) goto L8;
        return false;
    L8:
        MmRecordingEntity r6 = (MmRecordingEntity) r5;
        if (Intrinsics.areEqual(this.recordingId, r6.recordingId) == true) goto L12;
        return false;
    L12:
        if (this.openSource == r6.openSource) goto L15;
        return false;
    L15:
        if (this.uiLaunchMode == r6.uiLaunchMode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.doubaoStatisticInfo, r6.doubaoStatisticInfo) == true) goto L30;
        return false;
    L30:
        if (this.source == r6.source) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.recordingId.hashCode() * 31) + this.openSource.hashCode()) * 31) + this.uiLaunchMode.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.conversationId.hashCode()) * 31) + this.botId.hashCode()) * 31;
        DoubaoStatisticInfo r1 = this.doubaoStatisticInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        MmRecordingSource r5 = this.source;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MmRecordingEntity(recordingId=" + this.recordingId + ", openSource=" + this.openSource + ", uiLaunchMode=" + this.uiLaunchMode + ", messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ", doubaoStatisticInfo=" + this.doubaoStatisticInfo + ", source=" + this.source + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final DoubaoStatisticInfo getDoubaoStatisticInfo() {
        return this.doubaoStatisticInfo;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final MmRecordingPageOpenSource getOpenSource() {
        return this.openSource;
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final MmRecordingSource getSource() {
        return this.source;
    }

    public final MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }

    public MmRecordingEntity(String r2, MmRecordingPageOpenSource r3, MmRecordingUILaunchMode r4, String r5, String r6, String r7, DoubaoStatisticInfo r8, MmRecordingSource r9) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "openSource");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r6, "conversationId");
        Intrinsics.checkNotNullParameter(r7, "botId");
        this.recordingId = r2;
        this.openSource = r3;
        this.uiLaunchMode = r4;
        this.messageId = r5;
        this.conversationId = r6;
        this.botId = r7;
        this.doubaoStatisticInfo = r8;
        this.source = r9;
    }

    public /* synthetic */ MmRecordingEntity(String r12, MmRecordingPageOpenSource r13, MmRecordingUILaunchMode r14, String r15, String r16, String r17, DoubaoStatisticInfo r18, MmRecordingSource r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 4) == 0) goto L5;
        MmRecordingUILaunchMode r5 = MmRecordingUILaunchMode.UNKNOWN;
    L7:
        if ((r20 & 8) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r20 & 16) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r20 & 32) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r20 & 64) == 0) goto L21;
        DoubaoStatisticInfo r9 = null;
    L23:
        if ((r20 & 128) == 0) goto L25;
        MmRecordingSource r10 = null;
    L26:
        this(r12, r13, r5, r6, r7, r8, r9, r10);
        return;
    L25:
        r10 = r19;
        goto L26
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
