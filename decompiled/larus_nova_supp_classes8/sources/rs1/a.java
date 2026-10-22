package rs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lrs1/a;", "", "Lrs1/b;", "openCleanScreen", "Lrs1/b;", "b", "()Lrs1/b;", "setOpenCleanScreen", "(Lrs1/b;)V", "closeCleanScreen", "a", "setCloseCleanScreen", "", "isAnchorDefaultOpenCleanScreen", "Z", "c", "()Z", "setAnchorDefaultOpenCleanScreen", "(Z)V", "isGuestDefaultOpenCleanScreen", "d", "setGuestDefaultOpenCleanScreen", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("close_clean_screen")
    private b closeCleanScreen;

    @SerializedName("is_anchor_default_open_clean_screen")
    private boolean isAnchorDefaultOpenCleanScreen;

    @SerializedName("is_guest_default_open_clean_screen")
    private boolean isGuestDefaultOpenCleanScreen;

    @SerializedName("open_clean_screen")
    private b openCleanScreen;

    public a() {
        b r0 = new b();
        r0.d("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_enter_clean_screen.png");
        r0.f("游戏操作");
        Unit r1 = Unit.INSTANCE;
        this.openCleanScreen = r0;
        b r2 = new b();
        r2.d("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_exit_clean_screen.png");
        r2.e();
        r2.f("退出操作");
        this.closeCleanScreen = r2;
    }

    public final b a() {
        return this.closeCleanScreen;
    }

    public final b b() {
        return this.openCleanScreen;
    }

    public final boolean c() {
        return this.isAnchorDefaultOpenCleanScreen;
    }

    public final boolean d() {
        return this.isGuestDefaultOpenCleanScreen;
    }
}
