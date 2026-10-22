package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001e\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b5\u00106R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\b¨\u00067"}, d2 = {"Lw20/ue;", "", "", "viewId", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "setViewId", "(Ljava/lang/String;)V", "type", "getType", "setType", "qrCodeScheme", "g", "setQrCodeScheme", "Lw20/ue$a;", "gameInfo", "Lw20/ue$a;", "b", "()Lw20/ue$a;", "setGameInfo", "(Lw20/ue$a;)V", "qrShareScene", "h", "setQrShareScene", "", "posterActivityVideoType", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setPosterActivityVideoType", "(Ljava/lang/Integer;)V", "publishMusicId", "f", "setPublishMusicId", "contentType", "a", "setContentType", "moduleType", "d", "setModuleType", "unmodifiablePublishParams", "k", "setUnmodifiablePublishParams", "saveViewId", "i", "setSaveViewId", "schemaParams", "j", "setSchemaParams", "logParams", "c", "setLogParams", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ue {

    @SerializedName("contentType")
    private String contentType;

    @SerializedName("gameInfo")
    private a gameInfo;

    @SerializedName("logParams")
    private String logParams;

    @SerializedName("moduleType")
    private String moduleType;

    @SerializedName("posterActivityVideoType")
    private Integer posterActivityVideoType;

    @SerializedName("publishMusicId")
    private String publishMusicId;

    @SerializedName("qrCodeScheme")
    private String qrCodeScheme;

    @SerializedName("qrShareScene")
    private String qrShareScene;

    @SerializedName("saveViewId")
    private String saveViewId;

    @SerializedName("schemaParams")
    private String schemaParams;

    @SerializedName("type")
    private String type;

    @SerializedName("unmodifiablePublishParams")
    private String unmodifiablePublishParams;

    @SerializedName("viewId")
    private String viewId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lw20/ue$a;", "", "", "scheduleTime", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setScheduleTime", "(Ljava/lang/String;)V", "round", "a", "setRound", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("round")
        private String round;

        @SerializedName("scheduleTime")
        private String scheduleTime;

        public a() {
        }

        public final String a() {
            return this.round;
        }

        public final String b() {
            return this.scheduleTime;
        }
    }

    public ue() {
    }

    public final String a() {
        return this.contentType;
    }

    public final a b() {
        return this.gameInfo;
    }

    public final String c() {
        return this.logParams;
    }

    public final String d() {
        return this.moduleType;
    }

    public final Integer e() {
        return this.posterActivityVideoType;
    }

    public final String f() {
        return this.publishMusicId;
    }

    public final String g() {
        return this.qrCodeScheme;
    }

    public final String getType() {
        return this.type;
    }

    public final String h() {
        return this.qrShareScene;
    }

    public final String i() {
        return this.saveViewId;
    }

    public final String j() {
        return this.schemaParams;
    }

    public final String k() {
        return this.unmodifiablePublishParams;
    }

    public final String l() {
        return this.viewId;
    }
}
