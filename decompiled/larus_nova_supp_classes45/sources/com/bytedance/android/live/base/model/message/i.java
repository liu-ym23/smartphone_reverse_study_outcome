package com.bytedance.android.live.base.model.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.HotWord")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/base/model/message/i;", "", "", "seqId", "Ljava/lang/Long;", "getSeqId", "()Ljava/lang/Long;", "setSeqId", "(Ljava/lang/Long;)V", "repeatCount", "e", "setRepeatCount", "", "displayCount", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setDisplayCount", "(Ljava/lang/String;)V", "", "mockCounter", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setMockCounter", "(Ljava/lang/Boolean;)V", "preContent", "d", "setPreContent", "Lcom/bytedance/android/live/base/model/message/a5;", "content", "Lcom/bytedance/android/live/base/model/message/a5;", "a", "()Lcom/bytedance/android/live/base/model/message/a5;", "setContent", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "showDuration", "f", "setShowDuration", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i implements vh7.h {
    public Long a;
    public Long b;

    @SerializedName("rtf_content")
    protected a5 content;

    @SerializedName("display_count")
    protected String displayCount;

    @SerializedName("mock_counter")
    protected Boolean mockCounter;

    @SerializedName("pre_content")
    protected String preContent;

    @SerializedName("repeat_count")
    protected Long repeatCount;

    @SerializedName("sequence_id")
    protected Long seqId;

    @SerializedName("show_duration")
    protected Long showDuration;

    public i() {
        this.mockCounter = Boolean.FALSE;
        this.showDuration = 3000L;
    }

    public final a5 a() {
        return this.content;
    }

    public final String b() {
        return this.displayCount;
    }

    public final Boolean c() {
        return this.mockCounter;
    }

    public final String d() {
        return this.preContent;
    }

    public final Long e() {
        return this.repeatCount;
    }

    public final Long f() {
        return this.showDuration;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public i(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.showDuration = Long.valueOf(r5.j());
        goto L3
    L8:
        this.content = vh7.f.a(r5, a5.class);
        goto L3
    L9:
        this.preContent = am3.h.c(r5);
        goto L3
    L10:
        this.mockCounter = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L11:
        this.displayCount = am3.h.c(r5);
        goto L3
    L12:
        this.repeatCount = Long.valueOf(r5.j());
        goto L3
    L13:
        this.seqId = Long.valueOf(r5.j());
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L14:
        r5.d(r0);
        if (this.mockCounter != null) goto L18;
        this.mockCounter = Boolean.FALSE;
    L18:
        if (this.showDuration != null) goto L39;
        this.showDuration = 3000L;
        return;
    }
}
