package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0004\u0019\u0007\u000e\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$Code;", "a", "(Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$a;", "data", "Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$a;", "getData", "()Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$a;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "c", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectMediaResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        static {
            Code r1 = new Code("Success", 0, 1);
            Success = r1;
            Code r2 = new Code("Failed", 1, 0);
            Failed = r2;
            Code r3 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r3;
            Code r4 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r4;
            a = new Code[]{r1, r2, r3, r4};
        }

        public static Code valueOf(String r1) {
            return (Code) r27.a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$a;", "", "", "Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$b;", "mediaList", "Ljava/util/List;", "getMediaList", "()Ljava/util/List;", "a", "(Ljava/util/List;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("mediaList")
        private List<b> mediaList;

        public a() {
        }

        public final void a(List<b> r1) {
            this.mediaList = r1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000f¨\u0006("}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$b;", "", "", "fileName", "Ljava/lang/String;", "getFileName", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "fileSize", "Ljava/lang/Number;", "getFileSize", "()Ljava/lang/Number;", "e", "(Ljava/lang/Number;)V", "absolutePath", "getAbsolutePath", "c", "fileUri", "getFileUri", "f", "mediaType", "a", "h", "Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$c;", "videoInfo", "Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$c;", "b", "()Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$c;", "i", "(Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$c;)V", "height", "getHeight", "g", "width", "getWidth", "j", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("absolutePath")
        private String absolutePath;

        @SerializedName("fileName")
        private String fileName;

        @SerializedName("fileSize")
        private Number fileSize;

        @SerializedName("fileUri")
        private String fileUri;

        @SerializedName("height")
        private Number height;

        @SerializedName("mediaType")
        private String mediaType;

        @SerializedName("videoInfo")
        private c videoInfo;

        @SerializedName("width")
        private Number width;

        public b() {
        }

        public final void c() {
            this.absolutePath = null;
        }

        public final String a() {
            return this.mediaType;
        }

        public final c b() {
            return this.videoInfo;
        }

        public final void d(String r1) {
            this.fileName = r1;
        }

        public final void e(Number r1) {
            this.fileSize = r1;
        }

        public final void f(String r1) {
            this.fileUri = r1;
        }

        public final void g(Number r1) {
            this.height = r1;
        }

        public final void h(String r1) {
            this.mediaType = r1;
        }

        public final void i(c r1) {
            this.videoInfo = r1;
        }

        public final void j(Number r1) {
            this.width = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SelectMediaResultModel$c;", "", "", "duration", "Ljava/lang/Number;", "getDuration", "()Ljava/lang/Number;", "b", "(Ljava/lang/Number;)V", "", "coverData", "Ljava/lang/String;", "getCoverData", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("coverData")
        private String coverData;

        @SerializedName("duration")
        private Number duration;

        public c() {
        }

        public final void a(String r1) {
            this.coverData = r1;
        }

        public final void b(Number r1) {
            this.duration = r1;
        }
    }

    public SelectMediaResultModel() {
    }

    public final void a(Code r1) {
        this.code = r1;
    }

    public final void b(a r1) {
        this.data = r1;
    }
}
