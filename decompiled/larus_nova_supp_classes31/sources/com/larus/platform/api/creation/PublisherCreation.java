package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xt7.d;
import zp9.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u00ad\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u00105\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\u000fJ\u0006\u00107\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010E\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010F\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J´\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u00020\u0006J\u0013\u0010J\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\u0006HÖ\u0001J\t\u0010N\u001a\u00020\u0004HÖ\u0001J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R#\u0010-\u001a\u0004\u0018\u00010.8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b3\u00104\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u0006T"}, d2 = {"Lcom/larus/platform/api/creation/PublisherCreation;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "creationId", "", "creationType", "", "fromIMCreationType", "messageId", "prompt", "imageUrl", "refContent", "index", "taskId", "ignoreCheckInfoEnough", "", "materialId", "canvasId", "", "canvasSubId", "canvasMode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getCreationId", "()Ljava/lang/String;", "getCreationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFromIMCreationType", "getMessageId", "getPrompt", "getImageUrl", "getRefContent", "getIndex", "getTaskId", "getIgnoreCheckInfoEnough", "()Z", "getMaterialId", "getCanvasId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCanvasSubId", "getCanvasMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "refContentBean", "Lcom/larus/platform/api/creation/UserCreationRefContent;", "getRefContentBean$annotations", "()V", "getRefContentBean", "()Lcom/larus/platform/api/creation/UserCreationRefContent;", "refContentBean$delegate", "Lkotlin/Lazy;", "isValid", "isVideo", "hasRefResource", "isInfoNotEnough", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/platform/api/creation/PublisherCreation;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PublisherCreation implements Parcelable, Serializable {
    public static final Parcelable.Creator<PublisherCreation> CREATOR = null;

    @SerializedName("canvas_id")
    private final Long canvasId;

    @SerializedName("canvas_mode")
    private final Boolean canvasMode;

    @SerializedName("canvas_sub_id")
    private final Long canvasSubId;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("creation_type")
    private final Integer creationType;

    @SerializedName("form_im_creation_type")
    private final Integer fromIMCreationType;

    @SerializedName("ignore_check_info_enough")
    private final boolean ignoreCheckInfoEnough;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("index")
    private final Integer index;

    @SerializedName("material_id")
    private final String materialId;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("prompt")
    private final String prompt;

    @SerializedName("ref_content")
    private final String refContent;
    private final Lazy refContentBean$delegate;

    @SerializedName("task_id")
    private final String taskId;

    public static final class a implements Parcelable.Creator<PublisherCreation> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PublisherCreation createFromParcel(Parcel r20) {
            Intrinsics.checkNotNullParameter(r20, "parcel");
            String r2 = r20.readString();
            if (r20.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            if (r20.readInt() != 0) goto L9;
            Integer r5 = null;
        L10:
            String r6 = r20.readString();
            String r7 = r20.readString();
            String r8 = r20.readString();
            String r9 = r20.readString();
            if (r20.readInt() != 0) goto L13;
            Integer r10 = null;
        L14:
            String r11 = r20.readString();
            boolean r13 = false;
            if (r20.readInt() == 0) goto L17;
            boolean r12 = true;
        L18:
            String r15 = r20.readString();
            if (r20.readInt() != 0) goto L21;
            Long r16 = null;
        L23:
            if (r20.readInt() != 0) goto L25;
            Long r17 = null;
        L27:
            if (r20.readInt() != 0) goto L30;
            Boolean r18 = null;
        L34:
            return new PublisherCreation(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r15, r16, r17, r18);
        L30:
            if (r20.readInt() == 0) goto L32;
            r13 = true;
        L32:
            r18 = Boolean.valueOf(r13);
            goto L34
        L25:
            r17 = Long.valueOf(r20.readLong());
            goto L27
        L21:
            r16 = Long.valueOf(r20.readLong());
            goto L23
        L17:
            r12 = false;
            goto L18
        L13:
            r10 = Integer.valueOf(r20.readInt());
            goto L14
        L9:
            r5 = Integer.valueOf(r20.readInt());
            goto L10
        L5:
            r3 = Integer.valueOf(r20.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PublisherCreation[] newArray(int r1) {
            return new PublisherCreation[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PublisherCreation() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ PublisherCreation copy$default(PublisherCreation r15, String r16, Integer r17, Integer r18, String r19, String r20, String r21, String r22, Integer r23, String r24, boolean r25, String r26, Long r27, Long r28, Boolean r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.creationId;
    L7:
        if ((r30 & 2) == 0) goto L9;
        Integer r3 = r15.creationType;
    L11:
        if ((r30 & 4) == 0) goto L13;
        Integer r4 = r15.fromIMCreationType;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r5 = r15.messageId;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.prompt;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = r15.imageUrl;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r8 = r15.refContent;
    L31:
        if ((r30 & 128) == 0) goto L33;
        Integer r9 = r15.index;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r10 = r15.taskId;
    L39:
        if ((r30 & 512) == 0) goto L41;
        boolean r11 = r15.ignoreCheckInfoEnough;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = r15.materialId;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Long r13 = r15.canvasId;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        Long r14 = r15.canvasSubId;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        Boolean r1 = r15.canvasMode;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public static /* synthetic */ void getRefContentBean$annotations() {
    }

    public final String component1() {
        return this.creationId;
    }

    public final boolean component10() {
        return this.ignoreCheckInfoEnough;
    }

    public final String component11() {
        return this.materialId;
    }

    public final Long component12() {
        return this.canvasId;
    }

    public final Long component13() {
        return this.canvasSubId;
    }

    public final Boolean component14() {
        return this.canvasMode;
    }

    public final Integer component2() {
        return this.creationType;
    }

    public final Integer component3() {
        return this.fromIMCreationType;
    }

    public final String component4() {
        return this.messageId;
    }

    public final String component5() {
        return this.prompt;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.refContent;
    }

    public final Integer component8() {
        return this.index;
    }

    public final String component9() {
        return this.taskId;
    }

    public final PublisherCreation copy(String r17, @UserCreationType Integer r18, @UserCreationType Integer r19, String r20, String r21, String r22, String r23, Integer r24, String r25, boolean r26, String r27, Long r28, Long r29, Boolean r30) {
        return new PublisherCreation(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PublisherCreation) == true) goto L8;
        return false;
    L8:
        PublisherCreation r6 = (PublisherCreation) r5;
        if (Intrinsics.areEqual(this.creationId, r6.creationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationType, r6.creationType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fromIMCreationType, r6.fromIMCreationType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imageUrl, r6.imageUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.refContent, r6.refContent) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.index, r6.index) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L36;
        return false;
    L36:
        if (this.ignoreCheckInfoEnough == r6.ignoreCheckInfoEnough) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.materialId, r6.materialId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.canvasId, r6.canvasId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.canvasSubId, r6.canvasSubId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.canvasMode, r6.canvasMode) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r0 = this.creationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.creationType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.fromIMCreationType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.messageId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.prompt;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.imageUrl;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.refContent;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.index;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.taskId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        if (this.ignoreCheckInfoEnough == false) goto L41;
        int r28 = 1231;
    L42:
        int r29 = (r27 + r28) * 31;
        String r30 = this.materialId;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        Long r33 = this.canvasId;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        Long r36 = this.canvasSubId;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        Boolean r39 = this.canvasMode;
        if (r39 == null) goto L59;
        r1 = r39.hashCode();
    L59:
        return r38 + r1;
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = 1237;
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final boolean isValid() {
        return true;
    }

    public final boolean isVideo() {
        return CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{7, 6, 9, 8, 10, 11, 12}), this.creationType);
    }

    public String toString() {
        return "PublisherCreation(creationId=" + this.creationId + ", creationType=" + this.creationType + ", fromIMCreationType=" + this.fromIMCreationType + ", messageId=" + this.messageId + ", prompt=" + this.prompt + ", imageUrl=" + this.imageUrl + ", refContent=" + this.refContent + ", index=" + this.index + ", taskId=" + this.taskId + ", ignoreCheckInfoEnough=" + this.ignoreCheckInfoEnough + ", materialId=" + this.materialId + ", canvasId=" + this.canvasId + ", canvasSubId=" + this.canvasSubId + ", canvasMode=" + this.canvasMode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.creationId);
        Integer r7 = this.creationType;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Integer r8 = this.fromIMCreationType;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        r5.writeString(this.messageId);
        r5.writeString(this.prompt);
        r5.writeString(this.imageUrl);
        r5.writeString(this.refContent);
        Integer r9 = this.index;
        if (r9 != null) goto L13;
        r5.writeInt(0);
    L14:
        r5.writeString(this.taskId);
        r5.writeInt(this.ignoreCheckInfoEnough ? 1 : 0);
        r5.writeString(this.materialId);
        Long r10 = this.canvasId;
        if (r10 != null) goto L17;
        r5.writeInt(0);
    L18:
        Long r11 = this.canvasSubId;
        if (r11 != null) goto L21;
        r5.writeInt(0);
    L22:
        Boolean r12 = this.canvasMode;
        if (r12 != null) goto L25;
        r5.writeInt(0);
        return;
    L25:
        r5.writeInt(1);
        r5.writeInt(r12.booleanValue() ? 1 : 0);
        return;
    L21:
        r5.writeInt(1);
        r5.writeLong(r11.longValue());
        goto L22
    L17:
        r5.writeInt(1);
        r5.writeLong(r10.longValue());
        goto L18
    L13:
        r5.writeInt(1);
        r5.writeInt(r9.intValue());
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.intValue());
        goto L6
    }

    public final UserCreationRefContent getRefContentBean() {
        return (UserCreationRefContent) this.refContentBean$delegate.getValue();
    }

    public final boolean isInfoNotEnough() {
        boolean r1 = false;
        if (this.ignoreCheckInfoEnough == false) goto L5;
        return false;
    L5:
        String r0 = this.creationId;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L25;
        String r3 = this.prompt;
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L25;
        if (this.creationType == null) goto L25;
        boolean r5 = false;
    L26:
        if (r5 == true) goto L33;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("isInfoNotEnough: ");
        r7.append(this.creationId);
        r7.append(',');
        String r8 = this.prompt;
        if (r8 != null) goto L30;
    L31:
        r1 = true;
    L32:
        r7.append(r1);
        r7.append(',');
        r7.append(this.creationType);
        r6.i("PublisherCreation", r7.toString());
        goto L33
    L30:
        if (r8.length() != 0) goto L32;
    L33:
        return r5;
    L16:
        if (r3.length() == 0) goto L19;
        r4 = false;
    L25:
        r5 = true;
        goto L26
    L8:
        if (r0.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public final boolean hasRefResource() {
        UserCreationRefContent r0 = getRefContentBean();
        if (r0 == null) goto L5;
        List<Resource> r1 = r0.c;
    L6:
        List<Resource> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return false;
    L15:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{5, 4, 3, 7, 9, 8, 10, 11, 12}), this.creationType) == false) goto L19;
        return true;
    L19:
        return false;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final Long getCanvasId() {
        return this.canvasId;
    }

    public final Boolean getCanvasMode() {
        return this.canvasMode;
    }

    public final Long getCanvasSubId() {
        return this.canvasSubId;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final Integer getCreationType() {
        return this.creationType;
    }

    public final Integer getFromIMCreationType() {
        return this.fromIMCreationType;
    }

    public final boolean getIgnoreCheckInfoEnough() {
        return this.ignoreCheckInfoEnough;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getRefContent() {
        return this.refContent;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public static UserCreationRefContent a(PublisherCreation r3) {
        String r4 = r3.refContent;
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L22;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl((UserCreationRefContent) d.b.c(UserCreationRefContent.Companion.serializer(), r4));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L18;
        r0 = r5;
    L18:
        return (UserCreationRefContent) r0;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public PublisherCreation(String r1, @UserCreationType Integer r2, @UserCreationType Integer r3, String r4, String r5, String r6, String r7, Integer r8, String r9, boolean r10, String r11, Long r12, Long r13, Boolean r14) {
        this.creationId = r1;
        this.creationType = r2;
        this.fromIMCreationType = r3;
        this.messageId = r4;
        this.prompt = r5;
        this.imageUrl = r6;
        this.refContent = r7;
        this.index = r8;
        this.taskId = r9;
        this.ignoreCheckInfoEnough = r10;
        this.materialId = r11;
        this.canvasId = r12;
        this.canvasSubId = r13;
        this.canvasMode = r14;
        this.refContentBean$delegate = LazyKt.lazy(new v(this));
    }

    public /* synthetic */ PublisherCreation(String r16, Integer r17, Integer r18, String r19, String r20, String r21, String r22, Integer r23, String r24, boolean r25, String r26, Long r27, Long r28, Boolean r29, int r30, DefaultConstructorMarker r31) {
        Boolean r2 = null;
        if ((r30 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        boolean r11 = false;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        Long r14 = null;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r2 = r29;
    L58:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2);
        return;
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
