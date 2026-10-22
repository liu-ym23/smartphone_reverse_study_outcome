package com.bytedance.iesgurd.settings;

import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra;", "", "<init>", "()V", "", "", "noLocalAk", "Ljava/util/List;", "getNoLocalAk", "()Ljava/util/List;", "setNoLocalAk", "(Ljava/util/List;)V", "Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "pcdnInfo", "Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "getPcdnInfo", "()Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "setPcdnInfo", "(Lcom/bytedance/iesgurd/settings/SettingsExtra$a;)V", "Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "probeInfo", "Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "getProbeInfo", "()Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "setProbeInfo", "(Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;)V", "a", "ProbeInfo", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class SettingsExtra {

    @SerializedName("no_local_ak")
    private List<String> noLocalAk;

    @SerializedName("p2p")
    private a pcdnInfo;

    @SerializedName("probe")
    private ProbeInfo probeInfo;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "", "()V", "probeThreshold", "", "getProbeThreshold", "()I", "setProbeThreshold", "(I)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class ProbeInfo {

        @SerializedName("probe_threshold")
        private int probeThreshold;

        public ProbeInfo() {
        }

        public final int getProbeThreshold() {
            return this.probeThreshold;
        }

        public final void setProbeThreshold(int r5) {
            this.probeThreshold = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "", "<init>", "()V", "", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setBusinessId", "(Ljava/lang/Integer;)V", "businessId", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "groupId", "c", "setTestId", "testId", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(WsConstants.KEY_SESSION_ID)
        private Integer f6685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("pcdn_groupid")
        private String f6686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("pcdn_testid")
        private String f6687c;

        public a() {
            this.f6686b = "";
            this.f6687c = "";
        }

        public final Integer a() {
            return this.f6685a;
        }

        public final String b() {
            return this.f6686b;
        }

        public final String c() {
            return this.f6687c;
        }
    }

    public SettingsExtra() {
    }

    public final List<String> getNoLocalAk() {
        return this.noLocalAk;
    }

    public final a getPcdnInfo() {
        return this.pcdnInfo;
    }

    public final ProbeInfo getProbeInfo() {
        return this.probeInfo;
    }

    public final void setNoLocalAk(List<String> r5) {
        this.noLocalAk = r5;
    }

    public final void setPcdnInfo(a r5) {
        this.pcdnInfo = r5;
    }

    public final void setProbeInfo(ProbeInfo r5) {
        this.probeInfo = r5;
    }
}
