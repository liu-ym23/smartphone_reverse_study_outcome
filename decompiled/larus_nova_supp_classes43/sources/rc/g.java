package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bG\u0010HR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\"\u00109\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR\"\u0010A\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000e\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\"\u0010D\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000e\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012¨\u0006I"}, d2 = {"Lrc/g;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "initBugfixEnable", "getInitBugfixEnable", "setInitBugfixEnable", "", "maxBindNodeCount", "I", "getMaxBindNodeCount", "()I", "setMaxBindNodeCount", "(I)V", "", "minSampleCycle", "J", "getMinSampleCycle", "()J", "setMinSampleCycle", "(J)V", "coverViewSelfDiscoveryEnable", "getCoverViewSelfDiscoveryEnable", "setCoverViewSelfDiscoveryEnable", "Lrc/c;", "alogUploadConfig", "Lrc/c;", "getAlogUploadConfig", "()Lrc/c;", "setAlogUploadConfig", "(Lrc/c;)V", "errorMonitorEnable", "getErrorMonitorEnable", "setErrorMonitorEnable", "Lrc/e;", "backupEventConfig", "Lrc/e;", "getBackupEventConfig", "()Lrc/e;", "setBackupEventConfig", "(Lrc/e;)V", "Lrc/d;", "alphaIgnoreConfig", "Lrc/d;", "getAlphaIgnoreConfig", "()Lrc/d;", "setAlphaIgnoreConfig", "(Lrc/d;)V", "monitorExposureStep", "getMonitorExposureStep", "setMonitorExposureStep", "Lrc/o;", "paramDiffConfig", "Lrc/o;", "getParamDiffConfig", "()Lrc/o;", "setParamDiffConfig", "(Lrc/o;)V", "isABConfigInnerEnable", "setABConfigInnerEnable", "fixBstMemLeak", "getFixBstMemLeak", "setFixBstMemLeak", "fixPipelineManagerLateInit", "getFixPipelineManagerLateInit", "setFixPipelineManagerLateInit", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class g {

    @SerializedName("alog_upload_config")
    private c alogUploadConfig;

    @SerializedName("alpha_ignore_config")
    private d alphaIgnoreConfig;

    @SerializedName("backup_event_Config")
    private e backupEventConfig;

    @SerializedName("cover_view_self_discovery")
    private boolean coverViewSelfDiscoveryEnable;

    @SerializedName("switch")
    private boolean enable;

    @SerializedName("error_monitor_enable")
    private boolean errorMonitorEnable;

    @SerializedName("bst_sdk_leak_mem_fix")
    private int fixBstMemLeak;

    @SerializedName("bst_pipeline_manager_lateinit_fix")
    private int fixPipelineManagerLateInit;

    @SerializedName("fix_init_bugfix")
    private boolean initBugfixEnable;

    @SerializedName("is_ab_config_inner_enable")
    private boolean isABConfigInnerEnable;

    @SerializedName("max_node_count")
    private int maxBindNodeCount;

    @SerializedName("sampling_frequency")
    private long minSampleCycle;

    @SerializedName("monitor_exposure_step")
    private boolean monitorExposureStep;

    @SerializedName("bst_alert_config")
    private o paramDiffConfig;

    public g() {
        this.initBugfixEnable = true;
        this.maxBindNodeCount = 500;
        this.minSampleCycle = 16;
        this.coverViewSelfDiscoveryEnable = true;
        this.alogUploadConfig = new c();
        this.errorMonitorEnable = true;
        this.backupEventConfig = new e();
        this.alphaIgnoreConfig = new d();
        this.paramDiffConfig = new o();
        this.fixBstMemLeak = 1;
    }
}
