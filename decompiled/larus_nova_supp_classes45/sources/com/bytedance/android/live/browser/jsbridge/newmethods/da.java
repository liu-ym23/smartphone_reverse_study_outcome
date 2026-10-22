package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/da;", "", "", "reported_user_id", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setReported_user_id", "(Ljava/lang/String;)V", "reported_sec_user_id", "d", "setReported_sec_user_id", "reported_comment", "c", "setReported_comment", "msg_id", "a", "setMsg_id", "room_id", "getRoom_id", "setRoom_id", "stream_type", "getStream_type", "setStream_type", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "source", "g", "setSource", "request_page", "f", "setRequest_page", "report_type", "b", "setReport_type", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class da {

    @SerializedName("msg_id")
    private String msg_id;

    @SerializedName("report_type")
    private String report_type;

    @SerializedName("reported_comment")
    private String reported_comment;

    @SerializedName("reported_sec_user_id")
    private String reported_sec_user_id;

    @SerializedName("reported_user_id")
    private String reported_user_id;

    @SerializedName("request_page")
    private String request_page;

    @SerializedName("room_id")
    private String room_id;

    @SerializedName("source")
    private String source;

    @SerializedName("stream_type")
    private String stream_type;

    @SerializedName("type")
    private Integer type;

    public da() {
    }

    public final String a() {
        return this.msg_id;
    }

    public final String b() {
        return this.report_type;
    }

    public final String c() {
        return this.reported_comment;
    }

    public final String d() {
        return this.reported_sec_user_id;
    }

    public final String e() {
        return this.reported_user_id;
    }

    public final String f() {
        return this.request_page;
    }

    public final String g() {
        return this.source;
    }

    public final Integer getType() {
        return this.type;
    }
}
