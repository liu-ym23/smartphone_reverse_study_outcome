package ad2;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#¨\u0006)"}, d2 = {"Lad2/c0;", BuildConfig.FLAVOR, "Lad2/c0$a;", "authInfo", "Lad2/c0$a;", "a", "()Lad2/c0$a;", "setAuthInfo", "(Lad2/c0$a;)V", BuildConfig.FLAVOR, "uploadServerPath", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUploadServerPath", "(Ljava/lang/String;)V", "videoUploadExtra", "g", "setVideoUploadExtra", "fileType", "c", "setFileType", BuildConfig.FLAVOR, "filePathList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setFilePathList", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "useUploaderV2", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "setUseUploaderV2", "(Ljava/lang/Boolean;)V", "needEncrypt", "d", "setNeedEncrypt", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("authInfo")
    private a authInfo;

    @SerializedName("filePathList")
    private List<String> filePathList;

    @SerializedName("fileType")
    private String fileType;

    @SerializedName("needEncrypt")
    private Boolean needEncrypt;

    @SerializedName("uploadServerPath")
    private String uploadServerPath;

    @SerializedName("useUploaderV2")
    private Boolean useUploaderV2;

    @SerializedName("videoUploadExtra")
    private String videoUploadExtra;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lad2/c0$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "ak", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setAk", "(Ljava/lang/String;)V", "sk", "b", "setSk", "st", "d", "setSt", "spaceName", "c", "setSpaceName", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("ak")
        private String ak;

        @SerializedName("sk")
        private String sk;

        @SerializedName("spaceName")
        private String spaceName;

        @SerializedName("st")
        private String st;

        public a() {
        }

        public final String a() {
            return this.ak;
        }

        public final String b() {
            return this.sk;
        }

        public final String c() {
            return this.spaceName;
        }

        public final String d() {
            return this.st;
        }
    }

    public c0() {
    }

    public final a a() {
        return this.authInfo;
    }

    public final List<String> b() {
        return this.filePathList;
    }

    public final String c() {
        return this.fileType;
    }

    public final Boolean d() {
        return this.needEncrypt;
    }

    public final String e() {
        return this.uploadServerPath;
    }

    public final Boolean f() {
        return this.useUploaderV2;
    }

    public final String g() {
        return this.videoUploadExtra;
    }
}
