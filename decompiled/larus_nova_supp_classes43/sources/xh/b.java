package xh;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0005\u0010\u000b\u0007\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lxh/b;", "", "", "module", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "event", "getEvent", "b", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "a", "(Ljava/lang/Object;)V", "<init>", "()V", "d", "e", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("data")
    private Object data;

    @SerializedName("event")
    private String event;

    @SerializedName("module")
    private String module;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lxh/b$a;", "", "", "host", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "path", "getPath", "b", "method", "getMethod", "a", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("host")
        private String host;

        @SerializedName("method")
        private String method;

        @SerializedName("path")
        private String path;

        public a() {
        }

        public final void a(String r1) {
            this.method = r1;
        }

        public final void b(String r1) {
            this.path = r1;
        }
    }

    /* JADX INFO: renamed from: xh.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lxh/b$b;", "", "", "host", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "path", "getPath", "c", "logId", "getLogId", "b", "", "errorCode", "Ljava/lang/Integer;", "getErrorCode", "()Ljava/lang/Integer;", "a", "(Ljava/lang/Integer;)V", com.bytedance.android.ec.core.event.a.KEY_STATUS_CODE, "getStatusCode", "d", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "getStatusMsg", "e", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0213b {

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE)
        private Integer errorCode;

        @SerializedName("host")
        private String host;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LOG_ID)
        private String logId;

        @SerializedName("path")
        private String path;

        @SerializedName("status_code")
        private Integer statusCode;

        @SerializedName("status_msg")
        private String statusMsg;

        public C0213b() {
        }

        public final void a(Integer r1) {
            this.errorCode = r1;
        }

        public final void b(String r1) {
            this.logId = r1;
        }

        public final void c(String r1) {
            this.path = r1;
        }

        public final void d(Integer r1) {
            this.statusCode = r1;
        }

        public final void e(String r1) {
            this.statusMsg = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lxh/b$c;", "", "", "host", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "path", "getPath", "b", "logId", "getLogId", "a", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_CODE, "Ljava/lang/Integer;", "getStatusCode", "()Ljava/lang/Integer;", "c", "(Ljava/lang/Integer;)V", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "getStatusMsg", "d", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("host")
        private String host;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LOG_ID)
        private String logId;

        @SerializedName("path")
        private String path;

        @SerializedName("status_code")
        private Integer statusCode;

        @SerializedName("status_msg")
        private String statusMsg;

        public c() {
        }

        public final void a(String r1) {
            this.logId = r1;
        }

        public final void b(String r1) {
            this.path = r1;
        }

        public final void c(Integer r1) {
            this.statusCode = r1;
        }

        public final void d(String r1) {
            this.statusMsg = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lxh/b$d;", "", "", "msgId", "Ljava/lang/String;", "getMsgId", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "targetRoomId", "getTargetRoomId", "d", "", "isFromVirtualChannel", "Z", "()Z", "b", "(Z)V", "content", "Ljava/lang/Object;", "getContent", "()Ljava/lang/Object;", "a", "(Ljava/lang/Object;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("content")
        private Object content;

        @SerializedName("is_from_virtual_channel")
        private boolean isFromVirtualChannel;

        @SerializedName("msg_id")
        private String msgId;

        @SerializedName("target_room_id")
        private String targetRoomId;

        public d() {
        }

        public final void a(Object r1) {
            this.content = r1;
        }

        public final void b(boolean r1) {
            this.isFromVirtualChannel = r1;
        }

        public final void c(String r1) {
            this.msgId = r1;
        }

        public final void d(String r1) {
            this.targetRoomId = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lxh/b$e;", "", "", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA)
        private String schema;

        public e() {
        }

        public final void a(String r1) {
            this.schema = r1;
        }
    }

    public b() {
    }

    public final void a(Object r1) {
        this.data = r1;
    }

    public final void b(String r1) {
        this.event = r1;
    }

    public final void c(String r1) {
        this.module = r1;
    }
}
