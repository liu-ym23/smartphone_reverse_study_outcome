package t5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/settings/provider/AppletSettings;", "", "loginRequiredApps", "", "", "killOnDouyinUnbindApps", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getLoginRequiredApps", "()Ljava/util/List;", "getKillOnDouyinUnbindApps", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("kill_on_douyin_unbind_apps")
    private final List<String> killOnDouyinUnbindApps;

    @SerializedName("login_required_apps")
    private final List<String> loginRequiredApps;

    public c() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.loginRequiredApps, r11.loginRequiredApps) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.killOnDouyinUnbindApps, r11.killOnDouyinUnbindApps) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.loginRequiredApps.hashCode() * 31) + this.killOnDouyinUnbindApps.hashCode();
    }

    public final String toString() {
        return "AppletSettings(loginRequiredApps=" + this.loginRequiredApps + ", killOnDouyinUnbindApps=" + this.killOnDouyinUnbindApps + ')';
    }

    public final List<String> a() {
        return this.killOnDouyinUnbindApps;
    }

    public final List<String> b() {
        return this.loginRequiredApps;
    }

    public c(Object r10) {
        List<String> r0 = CollectionsKt.listOf("db_app_4PM0PUQ");
        List<String> r11 = CollectionsKt.listOf("db_app_4PM0PUQ");
        Intrinsics.checkNotNullParameter(r0, "loginRequiredApps");
        Intrinsics.checkNotNullParameter(r11, "killOnDouyinUnbindApps");
        this.loginRequiredApps = r0;
        this.killOnDouyinUnbindApps = r11;
    }
}
