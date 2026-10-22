package zu0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lzu0/h;", "", "Lzu0/h$a;", "profitCheckTaskData", "Lzu0/h$a;", "a", "()Lzu0/h$a;", "setProfitCheckTaskData", "(Lzu0/h$a;)V", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("profitCheckTaskData")
    private a profitCheckTaskData;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lzu0/h$a;", "", "", "exhibitionInfoTask", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setExhibitionInfoTask", "(Ljava/lang/String;)V", "userHonorTask", "f", "setUserHonorTask", "wishInfoTask", "g", "setWishInfoTask", "fansClubTask", "c", "setFansClubTask", "audienceRanklist", "a", "setAudienceRanklist", "linkmicContributeRanklist", "e", "setLinkmicContributeRanklist", "generalTask", "d", "setGeneralTask", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("audienceRanklist")
        private String audienceRanklist;

        @SerializedName("exhibitionInfoTask")
        private String exhibitionInfoTask;

        @SerializedName("fansClubTask")
        private String fansClubTask;

        @SerializedName("generalTask")
        private String generalTask;

        @SerializedName("linkmicContributeRanklist")
        private String linkmicContributeRanklist;

        @SerializedName("userHonorTask")
        private String userHonorTask;

        @SerializedName("wishInfoTask")
        private String wishInfoTask;

        public a() {
        }

        public final String a() {
            return this.audienceRanklist;
        }

        public final String b() {
            return this.exhibitionInfoTask;
        }

        public final String c() {
            return this.fansClubTask;
        }

        public final String d() {
            return this.generalTask;
        }

        public final String e() {
            return this.linkmicContributeRanklist;
        }

        public final String f() {
            return this.userHonorTask;
        }

        public final String g() {
            return this.wishInfoTask;
        }
    }

    public h() {
    }

    public final a a() {
        return this.profitCheckTaskData;
    }
}
