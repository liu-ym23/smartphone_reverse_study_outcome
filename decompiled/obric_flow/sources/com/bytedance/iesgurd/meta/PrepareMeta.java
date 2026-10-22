package com.bytedance.iesgurd.meta;

import androidx.annotation.Keep;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.geckox.AppSettingsManager$IGeckoAppSettings;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.Resources;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import l9.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010&R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010-R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010*\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0006\n\u0004\b0\u0010*R$\u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010*\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010-R\u001a\u00105\u001a\u0002048\u0006X\u0087D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u00109\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0019R\u0014\u0010>\u001a\u00020=8\u0002X\u0083D¢\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b@\u0010:\u001a\u0004\bA\u0010\u0016R*\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\bI\u0010:\u001a\u0004\bJ\u0010\u0016R\"\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010*\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010-R\"\u0010N\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010:\u001a\u0004\bO\u0010\u0016\"\u0004\bP\u0010\u0019R\"\u0010Q\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010:\u001a\u0004\bR\u0010\u0016\"\u0004\bS\u0010\u0019R\"\u0010T\u001a\u0002048F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u00106\u001a\u0004\bU\u00108\"\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010\u0013R\"\u0010]\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010?\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010i\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010:\u001a\u0004\bi\u0010\u0016\"\u0004\bj\u0010\u0019R$\u0010l\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bl\u0010:\u001a\u0004\bm\u0010\u0016R$\u0010n\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bn\u0010:\u001a\u0004\bo\u0010\u0016R\"\u0010p\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u00106\u001a\u0004\bq\u00108\"\u0004\br\u0010WR\"\u0010s\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u00106\u001a\u0004\bt\u00108\"\u0004\bu\u0010WR\u0016\u0010v\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010*R*\u0010x\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010:\u001a\u0004\by\u0010\u0016\"\u0004\bz\u0010\u0019R\"\u0010{\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010?\u001a\u0004\b|\u0010_\"\u0004\b}\u0010aR%\u0010~\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010*\u001a\u0004\b\u007f\u0010\u000e\"\u0005\b\u0080\u0001\u0010-R(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010*\u001a\u0005\b\u0082\u0001\u0010\u000e\"\u0005\b\u0083\u0001\u0010-R&\u0010\u0084\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010:\u001a\u0005\b\u0084\u0001\u0010\u0016\"\u0005\b\u0085\u0001\u0010\u0019R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R,\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R*\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R*\u0010\u009b\u0001\u001a\u00030\u0094\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u0096\u0001\u001a\u0006\b\u009c\u0001\u0010\u0098\u0001\"\u0006\b\u009d\u0001\u0010\u009a\u0001R*\u0010\u009e\u0001\u001a\u00030\u0094\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u0096\u0001\u001a\u0006\b\u009f\u0001\u0010\u0098\u0001\"\u0006\b \u0001\u0010\u009a\u0001R&\u0010¡\u0001\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u00106\u001a\u0005\b¢\u0001\u00108\"\u0005\b£\u0001\u0010WR&\u0010¤\u0001\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u00106\u001a\u0005\b¥\u0001\u00108\"\u0005\b¦\u0001\u0010WR&\u0010§\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010:\u001a\u0005\b¨\u0001\u0010\u0016\"\u0005\b©\u0001\u0010\u0019R(\u0010ª\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bª\u0001\u0010*\u001a\u0005\b«\u0001\u0010\u000e\"\u0005\b¬\u0001\u0010-R\u001a\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010*R\u0018\u0010®\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010*R\u0018\u0010¯\u0001\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u00106R\u0018\u0010°\u0001\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b°\u0001\u00106R\u0018\u0010±\u0001\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b±\u0001\u00106R\u0018\u0010²\u0001\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b²\u0001\u00106R\u0018\u0010³\u0001\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b³\u0001\u00106R*\u0010µ\u0001\u001a\u00030´\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001¨\u0006»\u0001"}, d2 = {"Lcom/bytedance/iesgurd/meta/PrepareMeta;", "", "<init>", "()V", "", "accessKey", LynxMonitorService.KEY_CHANNEL, "(Ljava/lang/String;Ljava/lang/String;)V", "", "ignoreBlocks", "Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "getPackage", "()Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "toString", "()Ljava/lang/String;", "checkValid", "Lcom/bytedance/iesgurd/core/ReqType;", "reqType", "initByRequest", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "", "checkOnDemandWhenUpdate", "()Z", "needLog", "updateBlockType", "(Z)V", "upload", "updateOnDemandBySettings", "isOccasionUpdate", "uploadPrepareMeta", "Lorg/json/JSONObject;", "jsonObject", "putCommonData", "(Lorg/json/JSONObject;)V", "fullPackage", "Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "getFullPackage", "setFullPackage", "(Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;)V", "patch", "getPatch", "setPatch", "Ljava/lang/String;", "getAccessKey", "setAccessKey", "(Ljava/lang/String;)V", "getChannel", "setChannel", "resourceType", "groupName", "getGroupName", "setGroupName", "", "downloadDelay", "J", "getDownloadDelay", "()J", "useZstd", "Z", "getUseZstd", "setUseZstd", "", "onDemandEnum", "I", "usePcdn", "getUsePcdn", "", "groups", "Ljava/util/List;", "getGroups", "()Ljava/util/List;", "setGroups", "(Ljava/util/List;)V", "needAppLog", "getNeedAppLog", "hashVersion", "getHashVersion", "setHashVersion", "onDemand", "getOnDemand", "setOnDemand", "alwaysOnDemand", "getAlwaysOnDemand", "setAlwaysOnDemand", "version", "getVersion", "setVersion", "(J)V", "metaReqType", "Lcom/bytedance/iesgurd/core/ReqType;", "getReqType", "()Lcom/bytedance/iesgurd/core/ReqType;", "setReqType", "updatePriority", "getUpdatePriority", "()I", "setUpdatePriority", "(I)V", "Lcom/bytedance/iesgurd/core/BlockType;", "blockType", "Lcom/bytedance/iesgurd/core/BlockType;", "getBlockType", "()Lcom/bytedance/iesgurd/core/BlockType;", "setBlockType", "(Lcom/bytedance/iesgurd/core/BlockType;)V", "isSingleFile", "setSingleFile", "<set-?>", "ignoreStorage", "getIgnoreStorage", "ignoreBlockList", "getIgnoreBlockList", "localVersion", "getLocalVersion", "setLocalVersion", "localVersionOld", "getLocalVersionOld", "setLocalVersionOld", "fullPatchStr", "value", "updateWithPatch", "getUpdateWithPatch", "setUpdateWithPatch", "notUsePatchReason", "getNotUsePatchReason", "setNotUsePatchReason", "logId", "getLogId", "setLogId", "apiVersion", "getApiVersion", "setApiVersion", "isRetry", "setRetry", "Lcom/bytedance/iesgurd/meta/h;", "statisticModel", "Lcom/bytedance/iesgurd/meta/h;", "getStatisticModel", "()Lcom/bytedance/iesgurd/meta/h;", "setStatisticModel", "(Lcom/bytedance/iesgurd/meta/h;)V", "Lla/a;", "updateBuffer", "Lla/a;", "getUpdateBuffer", "()Lla/a;", "setUpdateBuffer", "(Lla/a;)V", "Ljava/io/File;", "destDir", "Ljava/io/File;", "getDestDir", "()Ljava/io/File;", "setDestDir", "(Ljava/io/File;)V", "updatingDir", "getUpdatingDir", "setUpdatingDir", "downloadFile", "getDownloadFile", "setDownloadFile", "timeAddQueue", "getTimeAddQueue", "setTimeAddQueue", "timeUpdateStart", "getTimeUpdateStart", "setTimeUpdateStart", "inQueue", "getInQueue", "setInQueue", "preTriggerChannel", "getPreTriggerChannel", "setPreTriggerChannel", "odlFallbackReason", "odlUseUrl", "odlDuration", "odlP2PReceivedBytes", "odlCDNReceivedBytes", "originCDNDuration", "originCDNReceivedBytes", "Lsa/a;", "pack", "Lsa/a;", "getPack", "()Lsa/a;", "setPack", "(Lsa/a;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class PrepareMeta {

    @SerializedName("access_key")
    private String accessKey;
    private boolean alwaysOnDemand;
    private String apiVersion;
    private BlockType blockType;

    @SerializedName("channel_name")
    private String channel;
    public File destDir;

    @SerializedName("download_delay")
    private final long downloadDelay;
    public File downloadFile;

    @SerializedName("package")
    private PrepareMetaPackage fullPackage;
    private String fullPatchStr;

    @SerializedName("group_name")
    private String groupName;

    @SerializedName("groups")
    private List<String> groups;

    @SerializedName("hash_version")
    private String hashVersion;
    private boolean ignoreBlockList;
    private boolean ignoreStorage;
    private boolean inQueue;
    private boolean isRetry;
    private boolean isSingleFile;
    private long localVersion;
    private long localVersionOld;
    private String logId;
    private ReqType metaReqType;

    @SerializedName("need_app_log")
    private final boolean needAppLog;
    private int notUsePatchReason;

    @JvmField
    public long odlCDNReceivedBytes;

    @JvmField
    public long odlDuration;

    @JvmField
    public String odlFallbackReason;

    @JvmField
    public long odlP2PReceivedBytes;

    @JvmField
    public String odlUseUrl;
    private boolean onDemand;

    @SerializedName("on_demand")
    private final int onDemandEnum;

    @JvmField
    public long originCDNDuration;

    @JvmField
    public long originCDNReceivedBytes;
    public sa.a pack;

    @SerializedName("patch")
    private PrepareMetaPackage patch;
    private String preTriggerChannel;
    private ReqType reqType;

    @SerializedName("resource_type")
    private final String resourceType;
    private h statisticModel;
    private long timeAddQueue;
    private long timeUpdateStart;
    private la.a updateBuffer;
    private int updatePriority;
    private boolean updateWithPatch;
    public File updatingDir;

    @SerializedName("use_pcdn")
    private final boolean usePcdn;

    @SerializedName("use_zstd")
    private boolean useZstd;
    private long version;

    public PrepareMeta() {
        this.accessKey = "";
        this.channel = "";
        this.resourceType = "";
        this.useZstd = true;
        this.hashVersion = "";
        ReqType r5 = ReqType.NONE;
        this.metaReqType = r5;
        this.reqType = r5;
        this.updatePriority = -1;
        this.fullPatchStr = OpenPageMethod.APP_FULL;
        this.odlUseUrl = "";
        this.odlDuration = -1;
        this.odlP2PReceivedBytes = -1;
        this.odlCDNReceivedBytes = -1;
        this.originCDNDuration = -1;
        this.originCDNReceivedBytes = -1;
    }

    private final boolean isOccasionUpdate() {
        ReqType r5 = this.reqType;
        if (r5 != ReqType.POLLING) goto L5;
    L7:
        HashMap r10 = ab.a.f153a;
        monitor-enter(r10);
        Iterator r11 = r10.values().iterator();     // Catch: Throwable -> L19
    L11:
        if (r11.hasNext() == false) goto L21;
        DeploymentsData r12 = (DeploymentsData) ((Map) r11.next()).get(getAccessKey());     // Catch: Throwable -> L19
        if (r12 == null) goto L11;
        if (r12.isHit(getGroups(), getChannel()) == false) goto L11;
        monitor-exit(r10);
        return true;
    L21:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r10);
        return false;
    L19:
        th = move-exception;
        throw th;
    L5:
        if (r5 == ReqType.QUEUE) goto L7;
        return false;
    }

    private final void putCommonData(JSONObject r10) {
        r10.put("access_key", this.accessKey);
        r10.put(LynxMonitorService.KEY_CHANNEL, this.channel);
        r10.put("req_type", this.reqType.getType());
        r10.put("id", getVersion());
        r10.put("is_zstd", this.useZstd ? 1 : 0);
        r10.put("api_version", this.apiVersion);
        r10.put("update_priority", this.updatePriority);
        r10.put("hash_version", this.hashVersion);
        if (this.isSingleFile == false) goto L5;
        r10.put("is_single_file", 1);
    L5:
        String r5 = this.groupName;
        if (r5 == null) goto L8;
        r10.put("group_name", r5);
    L8:
        String r11 = this.logId;
        if (r11 != null) goto L11;
    L14:
        long r12 = this.localVersion;
        if (r12 == 0) goto L17;
        r10.put("local_version", r12);
    L17:
        PrepareMetaPackage r13 = this.patch;
        if (r13 == null) goto L20;
        r10.put("patch_id", r13.getId());
    L20:
        BlockType r14 = this.blockType;
        if (r14 == null) goto L23;
        r10.put("block_type", r14.f6598a);
    L23:
        long r15 = this.downloadDelay;
        if (r15 <= 0) goto L26;
        r10.put("download_delay", r15);
    L26:
        List<String> r16 = this.groups;
        if (r16 == null) goto L30;
        r10.put("groups", r16.toString());
        return;
    L30:
        return;
    L11:
        if (r11.length() == 0) goto L14;
        r10.put("x_tt_logid", this.logId);
        goto L14
    }

    public static /* synthetic */ void updateBlockType$default(PrepareMeta r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = true;
    L5:
        r5.updateBlockType(r10);
    }

    private final void updateOnDemandBySettings() {
        AppSettingsManager$IGeckoAppSettings r5 = com.bytedance.geckox.b.f4736a.a();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getOnDemandPolicy() == 0) goto L34;
        Map<String, Resources> r10 = r5.getOnDemandList();
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.isEmpty() == true) goto L35;
        Resources r11 = r5.getOnDemandList().get(this.accessKey);
        if (r11 != null) goto L15;
        return;
    L15:
        if (r11.getChannels() != null) goto L20;
        if (r11.getGroups() != null) goto L20;
        return;
    L20:
        if (r11.isHit$geckox_noasanRelease(this.groups, this.channel) == true) goto L23;
        return;
    L23:
        if (r5.getOnDemandPolicy() != 1) goto L27;
        this.onDemand = true;
        return;
    L27:
        if (r5.getOnDemandPolicy() != 2) goto L33;
        this.onDemand = true;
        this.alwaysOnDemand = true;
        return;
    L33:
        return;
    L35:
        return;
    }

    private final void uploadPrepareMeta() {
        JSONObject r5 = new JSONObject();
        putCommonData(r5);
        if (this.usePcdn == false) goto L5;
        r5.put("use_pcdn", 1);
    L5:
        PrepareMetaPackage r10 = this.fullPackage;
        if (r10 == null) goto L10;
        UltraUpdateResource r11 = r10.getUltraUpdateResource();
        if (r11 == null) goto L10;
        r5.put("ultra_update_resource", r11.toString());
    L10:
        j.g("geckosdk_prepare_meta_stats", r5);
    }

    public final boolean checkOnDemandWhenUpdate() {
        updateOnDemandBySettings();
        if (this.onDemand == true) goto L5;
        return false;
    L5:
        String r5 = this.accessKey;
        String r10 = this.channel;
        if (this.alwaysOnDemand == false) goto L8;
        return true;
    L8:
        if (com.bytedance.geckox.utils.a.a(r5, r10) == false) goto L13;
        GeckoLogger.a(r5 + '-' + r10 + " used, do update");
        return false;
    L13:
        return true;
    }

    public final String checkValid() {
        String r5 = this.accessKey;
        if (r5 == null) goto L30;
        if (r5.length() == 0) goto L30;
        String r10 = this.channel;
        if (r10 == null) goto L30;
        if (r10.length() == 0) goto L30;
        if (getVersion() <= 0) goto L30;
        PrepareMetaPackage r11 = this.fullPackage;
        if (r11 != null) goto L18;
    L21:
        PrepareMetaPackage r12 = this.patch;
        if (r12 != null) goto L24;
        return null;
    L24:
        if (r12.checkValid() == false) goto L26;
        return null;
    L26:
        return String.valueOf(this.patch);
    L18:
        if (r11.checkValid() == true) goto L21;
        return String.valueOf(this.fullPackage);
    L30:
        return toString();
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final boolean getAlwaysOnDemand() {
        return this.alwaysOnDemand;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final BlockType getBlockType() {
        return this.blockType;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final File getDestDir() {
        File r5 = this.destDir;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("destDir");
    L5:
        return r5;
    }

    public final long getDownloadDelay() {
        return this.downloadDelay;
    }

    public final File getDownloadFile() {
        File r5 = this.downloadFile;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("downloadFile");
    L5:
        return r5;
    }

    public final PrepareMetaPackage getFullPackage() {
        return this.fullPackage;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final String getHashVersion() {
        return this.hashVersion;
    }

    public final boolean getIgnoreBlockList() {
        return this.ignoreBlockList;
    }

    public final boolean getIgnoreStorage() {
        return this.ignoreStorage;
    }

    public final boolean getInQueue() {
        return this.inQueue;
    }

    public final long getLocalVersion() {
        return this.localVersion;
    }

    public final long getLocalVersionOld() {
        return this.localVersionOld;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final boolean getNeedAppLog() {
        return this.needAppLog;
    }

    public final int getNotUsePatchReason() {
        return this.notUsePatchReason;
    }

    public final boolean getOnDemand() {
        return this.onDemand;
    }

    public final sa.a getPack() {
        sa.a r5 = this.pack;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pack");
    L5:
        return r5;
    }

    public final PrepareMetaPackage getPackage() {
        if (this.updateWithPatch == false) goto L8;
        PrepareMetaPackage r5 = this.patch;
        if (r5 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        return r5;
    L8:
        PrepareMetaPackage r10 = this.fullPackage;
        if (r10 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        return r10;
    }

    public final PrepareMetaPackage getPatch() {
        return this.patch;
    }

    public final String getPreTriggerChannel() {
        return this.preTriggerChannel;
    }

    public final ReqType getReqType() {
        return this.reqType;
    }

    public final h getStatisticModel() {
        return this.statisticModel;
    }

    public final long getTimeAddQueue() {
        return this.timeAddQueue;
    }

    public final long getTimeUpdateStart() {
        return this.timeUpdateStart;
    }

    public final la.a getUpdateBuffer() {
        return this.updateBuffer;
    }

    public final int getUpdatePriority() {
        return this.updatePriority;
    }

    public final boolean getUpdateWithPatch() {
        return this.updateWithPatch;
    }

    public final File getUpdatingDir() {
        File r5 = this.updatingDir;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("updatingDir");
    L5:
        return r5;
    }

    public final boolean getUsePcdn() {
        return this.usePcdn;
    }

    public final boolean getUseZstd() {
        return this.useZstd;
    }

    public final long getVersion() {
        PrepareMetaPackage r5 = this.fullPackage;
        if (r5 == null) goto L7;
        return r5.getId();
    L7:
        return this.version;
    }

    public final void ignoreBlocks() {
        this.ignoreStorage = true;
        this.ignoreBlockList = true;
    }

    public final void initByRequest(ReqType r5) {
        this.pack = new sa.a(this.channel, getVersion());
        this.reqType = r5;
        this.metaReqType = r5;
        this.isSingleFile = Intrinsics.areEqual(this.resourceType, "UNCOMPRESSED_SINGLE_FILE");
        int r10 = this.onDemandEnum;
        if (r10 != 1) goto L6;
        this.onDemand = true;
    L9:
        if (this.needAppLog == false) goto L12;
        updateBlockType(false);
        uploadPrepareMeta();
    L12:
        StringBuilder r11 = new StringBuilder("prepare_meta: ");
        r11.append(this.accessKey);
        r11.append('-');
        r11.append(this.channel);
        r11.append('-');
        r11.append(getVersion());
        r11.append('-');
        r11.append(this.groups);
        r11.append('-');
        r11.append(this.blockType);
        r11.append('-');
        PrepareMetaPackage r12 = this.patch;
        if (r12 == null) goto L15;
        Long r13 = Long.valueOf(r12.getId());
    L16:
        r11.append(r13);
        r11.append("-delay:");
        r11.append(this.downloadDelay);
        r11.append("-onDemandEnum:");
        r11.append(this.onDemandEnum);
        r11.append("-onDemand:");
        r11.append(this.onDemand);
        r11.append("-alwaysOnDemand:");
        r11.append(this.alwaysOnDemand);
        r11.append(']');
        GeckoLogger.a(r11.toString());
        return;
    L15:
        r13 = null;
        goto L16
    L6:
        if (r10 != 2) goto L9;
        this.onDemand = true;
        this.alwaysOnDemand = true;
        goto L9
    }

    public final boolean isRetry() {
        return this.isRetry;
    }

    public final boolean isSingleFile() {
        return this.isSingleFile;
    }

    public final void setAccessKey(String r5) {
        this.accessKey = r5;
    }

    public final void setAlwaysOnDemand(boolean r5) {
        this.alwaysOnDemand = r5;
    }

    public final void setApiVersion(String r5) {
        this.apiVersion = r5;
    }

    public final void setBlockType(BlockType r5) {
        this.blockType = r5;
    }

    public final void setChannel(String r5) {
        this.channel = r5;
    }

    public final void setDestDir(File r5) {
        this.destDir = r5;
    }

    public final void setDownloadFile(File r5) {
        this.downloadFile = r5;
    }

    public final void setFullPackage(PrepareMetaPackage r5) {
        this.fullPackage = r5;
    }

    public final void setGroupName(String r5) {
        this.groupName = r5;
    }

    public final void setGroups(List<String> r5) {
        this.groups = r5;
    }

    public final void setHashVersion(String r5) {
        this.hashVersion = r5;
    }

    public final void setInQueue(boolean r5) {
        this.inQueue = r5;
    }

    public final void setLocalVersion(long r5) {
        this.localVersion = r5;
    }

    public final void setLocalVersionOld(long r5) {
        this.localVersionOld = r5;
    }

    public final void setLogId(String r5) {
        this.logId = r5;
    }

    public final void setNotUsePatchReason(int r5) {
        this.notUsePatchReason = r5;
    }

    public final void setOnDemand(boolean r5) {
        this.onDemand = r5;
    }

    public final void setPack(sa.a r5) {
        this.pack = r5;
    }

    public final void setPatch(PrepareMetaPackage r5) {
        this.patch = r5;
    }

    public final void setPreTriggerChannel(String r5) {
        this.preTriggerChannel = r5;
    }

    public final void setReqType(ReqType r5) {
        this.reqType = r5;
    }

    public final void setRetry(boolean r5) {
        this.isRetry = r5;
    }

    public final void setSingleFile(boolean r5) {
        this.isSingleFile = r5;
    }

    public final void setStatisticModel(h r5) {
        this.statisticModel = r5;
    }

    public final void setTimeAddQueue(long r5) {
        this.timeAddQueue = r5;
    }

    public final void setTimeUpdateStart(long r5) {
        this.timeUpdateStart = r5;
    }

    public final void setUpdateBuffer(la.a r5) {
        this.updateBuffer = r5;
    }

    public final void setUpdatePriority(int r5) {
        this.updatePriority = r5;
    }

    public final void setUpdateWithPatch(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "patch";
    L5:
        this.fullPatchStr = r10;
        this.updateWithPatch = r5;
        return;
    L4:
        r10 = OpenPageMethod.APP_FULL;
        goto L5
    }

    public final void setUpdatingDir(File r5) {
        this.updatingDir = r5;
    }

    public final void setUseZstd(boolean r5) {
        this.useZstd = r5;
    }

    public final void setVersion(long r5) {
        this.version = r5;
    }

    public String toString() {
        return this.accessKey + '-' + this.channel + '-' + getVersion() + '-' + this.fullPatchStr;
    }

    public final void updateBlockType(boolean r5) {
        BlockType r10 = this.blockType;
        this.blockType = null;
        if (checkOnDemandWhenUpdate() == false) goto L5;
        this.blockType = BlockType.f6596b;
    L11:
        if (r5 == true) goto L13;
        return;
    L13:
        if (this.blockType == r10) goto L17;
        GeckoLogger.a(this.accessKey + '_' + this.channel + " block type from " + r10 + " to " + this.blockType);
        return;
    L17:
        return;
    L5:
        ConcurrentHashMap r11 = va.b.f22564a;
        System.currentTimeMillis();
        getAccessKey();
        com.bytedance.geckox.c r12 = com.bytedance.geckox.b.f4736a;
        if (isOccasionUpdate() == false) goto L9;
        this.blockType = BlockType.d;
        goto L11
    L9:
        if (o.h(this) == true) goto L11;
        this.blockType = BlockType.f6597c;
        goto L11
    }

    public final void upload() {
        JSONObject r5 = new JSONObject();
        putCommonData(r5);
        r5.put("time_update_start", this.timeUpdateStart);
        r5.put("dur_wait_download", this.timeUpdateStart - this.timeAddQueue);
        r5.put("meta_req_type", this.metaReqType.getType());
        long r10 = this.localVersionOld;
        if (r10 == 0) goto L5;
        r5.put("local_version_old", r10);
    L5:
        int r11 = this.notUsePatchReason;
        if (r11 == 0) goto L8;
        r5.put("not_use_patch_reason", r11);
    L8:
        Long r12 = null;
        if (this.updateWithPatch == false) goto L14;
        PrepareMetaPackage r13 = this.patch;
        if (r13 == null) goto L13;
        r12 = Long.valueOf(r13.getLength());
    L13:
        r5.put("package_size", r12);
    L18:
        h r14 = this.statisticModel;
        if (r14 == null) goto L62;
        r5.put("update_result", !r14.f6656a ? 1 : 0);
        long r15 = r14.f6657b;
        if (r15 <= 0) goto L23;
        r5.put("dur_total", r15);
    L23:
        long r16 = r14.f6658c;
        if (r16 <= 0) goto L26;
        r5.put("dur_last_stage", r16);
    L26:
        long r17 = r14.d;
        if (r17 <= 0) goto L29;
        r5.put("dur_download", r17);
    L29:
        long r18 = r14.e;
        if (r18 <= 0) goto L32;
        r5.put("dur_download_last_time", r18);
    L32:
        long r19 = r14.f;
        if (r19 <= 0) goto L35;
        r5.put("dur_active", r19);
    L35:
        long r20 = r14.g;
        if (r20 <= 0) goto L38;
        r5.put("dur_unzip", r20);
    L38:
        long r21 = r14.f6659h;
        if (r21 <= 0) goto L41;
        r5.put("dur_decompress_zstd", r21);
    L41:
        long r22 = r14.f6660i;
        if (r22 <= 0) goto L44;
        r5.put("dur_bytepatch", r22);
    L44:
        long r23 = r14.f6661j;
        if (r23 <= 0) goto L47;
        r5.put("dur_zip_patch", r23);
    L47:
        Iterator r24 = r14.f6662k.values().iterator();
    L49:
        if (r24.hasNext() == false) goto L62;
        g r25 = (g) r24.next();
        r25.getClass();
        String r26 = r25.g;
        r5.put(r26.concat("result"), !r25.f6653a ? 1 : 0);
        r5.put(r26.concat("url"), r25.d);
        String r27 = r25.f6655c;
        if (r27 == null) goto L57;
        if (r27.length() == 0) goto L57;
        r5.put(r26.concat("err_msg"), r25.f6655c);
    L57:
        if (r25.f6654b == 0) goto L60;
        r5.put(r26.concat("err_code"), r25.f6654b);
    L60:
        if (r25.e <= 0) goto L49;
        r5.put(r26.concat("download_failed_times"), r25.e);
    L62:
        String r28 = this.preTriggerChannel;
        if (r28 == null) goto L66;
        r5.put("pre_trigger_channel", r28);
    L66:
        if (this.isRetry == false) goto L69;
        r5.put("is_retry", 1);
    L69:
        if (this.usePcdn == false) goto L74;
        r5.put("should_use_odl", 1);
        String r29 = this.odlFallbackReason;
        if (r29 != null) goto L73;
        r29 = "";
    L73:
        r5.put("odl_fallback_reason", r29);
        r5.put("odl_use_url", this.odlUseUrl);
        r5.put("odl_duration", this.odlDuration);
        r5.put("odl_p2p_received_bytes", this.odlP2PReceivedBytes);
        r5.put("odl_cdn_received_bytes", this.odlCDNReceivedBytes);
        r5.put("origin_cdn_duration", this.originCDNDuration);
        r5.put("origin_cdn_received_bytes", this.originCDNReceivedBytes);
    L74:
        j.g("geckosdk_update_aggr_stats", r5);
        return;
    L14:
        PrepareMetaPackage r30 = this.fullPackage;
        if (r30 == null) goto L17;
        r12 = Long.valueOf(r30.getLength());
    L17:
        r5.put("package_size", r12);
        goto L18
    }

    public PrepareMeta(String r5, String r10) {
        this.accessKey = "";
        this.channel = "";
        this.resourceType = "";
        this.useZstd = true;
        this.hashVersion = "";
        ReqType r11 = ReqType.NONE;
        this.metaReqType = r11;
        this.reqType = r11;
        this.updatePriority = -1;
        this.fullPatchStr = OpenPageMethod.APP_FULL;
        this.odlUseUrl = "";
        this.odlDuration = -1;
        this.odlP2PReceivedBytes = -1;
        this.odlCDNReceivedBytes = -1;
        this.originCDNDuration = -1;
        this.originCDNReceivedBytes = -1;
        this.channel = r10;
        this.accessKey = r5;
        this.pack = new sa.a(r10, 0);
    }
}
