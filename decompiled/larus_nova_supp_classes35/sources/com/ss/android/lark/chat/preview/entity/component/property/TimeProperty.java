package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0004\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "startTimeStamp", BuildConfig.FLAVOR, "isCountDown", BuildConfig.FLAVOR, "ntpActionId", BuildConfig.FLAVOR, "isEnd", "endTimeStamp", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getStartTimeStamp", "()Ljava/lang/Long;", "setStartTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setCountDown", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNtpActionId", "()Ljava/lang/String;", "setNtpActionId", "(Ljava/lang/String;)V", "setEnd", "getEndTimeStamp", "setEndTimeStamp", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeProperty extends BaseProperty {
    private Long endTimeStamp;
    private Boolean isCountDown;
    private Boolean isEnd;
    private String ntpActionId;
    private Long startTimeStamp;

    public TimeProperty() {
        this(null, null, null, null, null, 31, null);
    }

    public Props clone() {
        return new TimeProperty(this.startTimeStamp, this.isCountDown, this.ntpActionId, this.isEnd, this.endTimeStamp);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        Long r1 = this.startTimeStamp;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.isCountDown;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.ntpActionId;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.isEnd;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.endTimeStamp;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final Long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public final String getNtpActionId() {
        return this.ntpActionId;
    }

    public final Long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public final Boolean isCountDown() {
        return this.isCountDown;
    }

    public final Boolean isEnd() {
        return this.isEnd;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(TimeProperty.class, r2) == true) goto L13;
        return false;
    L13:
        if (super.equals(r5) == true) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.preview.entity.component.property.TimeProperty");
        TimeProperty r6 = (TimeProperty) r5;
        if (Intrinsics.areEqual(this.startTimeStamp, r6.startTimeStamp) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.isCountDown, r6.isCountDown) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.ntpActionId, r6.ntpActionId) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.isEnd, r6.isEnd) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.endTimeStamp, r6.endTimeStamp) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L37;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        Long r3 = null;
        Long r4 = null;
        Boolean r7 = null;
        String r8 = null;
        Boolean r9 = null;
        if (r1 == ComponentAttribute.start_time_stamp.getValue()) goto L9;
        if (r1 == ComponentAttribute.is_countdown.getValue()) goto L15;
        if (r1 == ComponentAttribute.ntp_action_id.getValue()) goto L21;
        if (r1 == ComponentAttribute.is_end.getValue()) goto L27;
        if (r1 != ComponentAttribute.end_time_stamp.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L36;
        r4 = r2.getLong();
    L36:
        this.endTimeStamp = r4;
        goto L6
    L27:
        PreviewData r10 = r0.getValue();
        if (r10 == null) goto L30;
        r7 = r10.getBoolean();
    L30:
        this.isEnd = r7;
        goto L6
    L21:
        PreviewData r11 = r0.getValue();
        if (r11 == null) goto L24;
        r8 = r11.getString();
    L24:
        this.ntpActionId = r8;
        goto L6
    L15:
        PreviewData r12 = r0.getValue();
        if (r12 == null) goto L18;
        r9 = r12.getBoolean();
    L18:
        this.isCountDown = r9;
        goto L6
    L9:
        PreviewData r13 = r0.getValue();
        if (r13 == null) goto L12;
        r3 = r13.getLong();
    L12:
        this.startTimeStamp = r3;
        goto L6
    }

    public final void setCountDown(Boolean r1) {
        this.isCountDown = r1;
    }

    public final void setEnd(Boolean r1) {
        this.isEnd = r1;
    }

    public final void setEndTimeStamp(Long r1) {
        this.endTimeStamp = r1;
    }

    public final void setNtpActionId(String r1) {
        this.ntpActionId = r1;
    }

    public final void setStartTimeStamp(Long r1) {
        this.startTimeStamp = r1;
    }

    public TimeProperty(Long r2, Boolean r3, String r4, Boolean r5, Long r6) {
        super(Type.TIME);
        this.startTimeStamp = r2;
        this.isCountDown = r3;
        this.ntpActionId = r4;
        this.isEnd = r5;
        this.endTimeStamp = r6;
    }

    public /* synthetic */ TimeProperty(Long r5, Boolean r6, String r7, Boolean r8, Long r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        Long r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        r6 = Boolean.FALSE;
    L9:
        Boolean r1 = r6;
        if ((r10 & 4) == 0) goto L12;
        String r2 = null;
    L14:
        if ((r10 & 8) == 0) goto L16;
        Boolean r3 = null;
    L18:
        if ((r10 & 16) == 0) goto L20;
        Long r13 = null;
    L21:
        this(r12, r1, r2, r3, r13);
        return;
    L20:
        r13 = r9;
        goto L21
    L16:
        r3 = r8;
        goto L18
    L12:
        r2 = r7;
        goto L14
    L5:
        r12 = r5;
        goto L7
    }
}
