package u00;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lu00/a;", "", "", "id", "J", "getId", "()J", "Lu00/a$a;", "status", "Lu00/a$a;", "getStatus", "()Lu00/a$a;", "", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("id")
    private final long id;

    @SerializedName("task_stats")
    private final C0283a status;

    @SerializedName("task_version")
    private final String version;

    /* JADX INFO: renamed from: u00.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lu00/a$a;", "", "", "isNewTask", "Z", "()Z", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0283a {

        @SerializedName("task_icon_flag")
        private final boolean isNewTask;

        public C0283a() {
        }
    }

    public final int hashCode() {
        long r0 = this.id;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return String.valueOf(this.id);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof a) == true) goto L5;
        r5 = null;
    L5:
        a r6 = (a) r5;
        if (r6 != null) goto L8;
    L10:
        return false;
    L8:
        if (r6.id != this.id) goto L10;
        return true;
    }
}
