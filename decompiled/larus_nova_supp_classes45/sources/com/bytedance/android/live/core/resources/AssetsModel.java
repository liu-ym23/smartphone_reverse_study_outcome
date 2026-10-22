package com.bytedance.android.live.core.resources;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.AssetStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 «\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0004¬\u0001\u00ad\u0001B\t¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0012R\"\u00103\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010!\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R*\u00107\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0015\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u000e\u001a\u0004\bR\u0010\u0010\"\u0004\bS\u0010\u0012R\"\u0010T\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bT\u0010\u000e\u001a\u0004\bU\u0010\u0010\"\u0004\bV\u0010\u0012R\"\u0010W\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bW\u0010\u000e\u001a\u0004\bX\u0010\u0010\"\u0004\bY\u0010\u0012R$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0015\u001a\u0004\bb\u0010\u0017\"\u0004\bc\u0010\u0019R\"\u0010d\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bd\u0010f\"\u0004\bg\u0010hR\"\u0010i\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010e\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR$\u0010m\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010v\u001a\u00020\f2\u0006\u0010s\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bt\u0010\u0010\"\u0004\bu\u0010\u0012R(\u0010y\u001a\u0004\u0018\u00010\u00132\b\u0010s\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bw\u0010\u0017\"\u0004\bx\u0010\u0019R(\u0010|\u001a\u0004\u0018\u00010\u00132\b\u0010s\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bz\u0010\u0017\"\u0004\b{\u0010\u0019R(\u0010\u007f\u001a\u0004\u0018\u00010\u00132\b\u0010s\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b}\u0010\u0017\"\u0004\b~\u0010\u0019R'\u0010\u0082\u0001\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010#\"\u0005\b\u0081\u0001\u0010%R+\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00132\b\u0010s\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0001\u0010\u0017\"\u0005\b\u0084\u0001\u0010\u0019R+\u0010\u0088\u0001\u001a\u0004\u0018\u00010)2\b\u0010s\u001a\u0004\u0018\u00010)8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010-\"\u0005\b\u0087\u0001\u0010/R'\u0010\u008b\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010\u0010\"\u0005\b\u008a\u0001\u0010\u0012R'\u0010\u008e\u0001\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010#\"\u0005\b\u008d\u0001\u0010%R\u001e\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010:R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00132\b\u0010s\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010\u0017\"\u0005\b\u0092\u0001\u0010\u0019R+\u0010\u0096\u0001\u001a\u0004\u0018\u00010C2\b\u0010s\u001a\u0004\u0018\u00010C8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010G\"\u0005\b\u0095\u0001\u0010IR+\u0010\u0099\u0001\u001a\u0004\u0018\u00010J2\b\u0010s\u001a\u0004\u0018\u00010J8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010N\"\u0005\b\u0098\u0001\u0010PR1\u0010\u009d\u0001\u001a\u00070\fj\u0003`\u009a\u00012\u000b\u0010s\u001a\u00070\fj\u0003`\u009a\u00018V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010\u0010\"\u0005\b\u009c\u0001\u0010\u0012R+\u0010 \u0001\u001a\u0004\u0018\u00010\u00132\b\u0010s\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009e\u0001\u0010\u0017\"\u0005\b\u009f\u0001\u0010\u0019R-\u0010¥\u0001\u001a\u0004\u0018\u00010@2\b\u0010s\u001a\u0004\u0018\u00010@8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\u0016\u0010¦\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010fR\u0018\u0010¨\u0001\u001a\u0004\u0018\u00010l8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010p¨\u0006®\u0001"}, d2 = {"Lcom/bytedance/android/live/core/resources/AssetsModel;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/core/resources/e;", "", "cdnDomainOpt", "", "setCdnDomainOpt", "", "obj", "equals", "", "hashCode", "", "_id", "J", "get_id", "()J", "set_id", "(J)V", "", "_name", "Ljava/lang/String;", "get_name", "()Ljava/lang/String;", "set_name", "(Ljava/lang/String;)V", "_describe", "get_describe", "set_describe", "md5", "getMd5", "setMd5", "_resourceType", "I", "get_resourceType", "()I", "set_resourceType", "(I)V", "_resourceUri", "get_resourceUri", "set_resourceUri", "Lcom/bytedance/android/live/core/resources/l;", "_resourceModel", "Lcom/bytedance/android/live/core/resources/l;", "get_resourceModel", "()Lcom/bytedance/android/live/core/resources/l;", "set_resourceModel", "(Lcom/bytedance/android/live/core/resources/l;)V", "_size", "get_size", "set_size", "_downloadType", "get_downloadType", "set_downloadType", "", "_modelRequirements", "Ljava/util/List;", "get_modelRequirements", "()Ljava/util/List;", "set_modelRequirements", "(Ljava/util/List;)V", "_lokiExtra", "get_lokiExtra", "set_lokiExtra", "Lcom/bytedance/android/live/core/resources/h;", "lokiExtraEntity", "Lcom/bytedance/android/live/core/resources/h;", "Lcom/bytedance/android/live/core/resources/j;", "_h265ResourceModel", "Lcom/bytedance/android/live/core/resources/j;", "get_h265ResourceModel", "()Lcom/bytedance/android/live/core/resources/j;", "set_h265ResourceModel", "(Lcom/bytedance/android/live/core/resources/j;)V", "Lcom/bytedance/android/live/core/resources/k;", "_h265SuperResourceModel", "Lcom/bytedance/android/live/core/resources/k;", "get_h265SuperResourceModel", "()Lcom/bytedance/android/live/core/resources/k;", "set_h265SuperResourceModel", "(Lcom/bytedance/android/live/core/resources/k;)V", "_modifyVersion", "get_modifyVersion", "set_modifyVersion", "minPlayTime", "getMinPlayTime", "setMinPlayTime", "playChannel", "getPlayChannel", "setPlayChannel", "Lcom/bytedance/android/live/core/resources/a;", "anchorGuide", "Lcom/bytedance/android/live/core/resources/a;", "getAnchorGuide", "()Lcom/bytedance/android/live/core/resources/a;", "setAnchorGuide", "(Lcom/bytedance/android/live/core/resources/a;)V", "_lynxSchema", "get_lynxSchema", "set_lynxSchema", "isTest", "Z", "()Z", "setTest", "(Z)V", "_isHighCostAsset", "get_isHighCostAsset", "set_isHighCostAsset", "Lcom/bytedance/android/live/core/resources/b;", "_cleanStrategy", "Lcom/bytedance/android/live/core/resources/b;", "get_cleanStrategy", "()Lcom/bytedance/android/live/core/resources/b;", "set_cleanStrategy", "(Lcom/bytedance/android/live/core/resources/b;)V", "value", "getId", "setId", "id", "getName", "setName", "name", "getDescribe", "setDescribe", "describe", "getMD5", "setMD5", "MD5", "getResourceType", "setResourceType", "resourceType", "getResourceUri", "setResourceUri", "resourceUri", "getResourceModel", "setResourceModel", "resourceModel", "getSize", "setSize", "size", "getDownloadType", "setDownloadType", "downloadType", "getModelRequirements", "modelRequirements", "getLokiExtra", "setLokiExtra", "lokiExtra", "getH265ResourceModel", "setH265ResourceModel", "h265ResourceModel", "getH265SuperResourceModel", "setH265SuperResourceModel", "h265SuperResourceModel", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getModifyVersion", "setModifyVersion", "modifyVersion", "getLynxSchema", "setLynxSchema", "lynxSchema", "getLokiExtraModel", "()Lcom/bytedance/android/live/core/resources/h;", "setLokiExtraModel", "(Lcom/bytedance/android/live/core/resources/h;)V", "lokiExtraModel", "isHighCostAsset", "getCleanStrategy", "cleanStrategy", "<init>", "()V", "Companion", "a", "ResourceType", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AssetsModel extends FlexModelBase<e> implements e, vh7.h {
    public static final a Companion = null;
    public static final int DOWNLOAD_TYPE_LAZY = 3;
    public static final int DOWNLOAD_TYPE_NO = 2;
    public static final int DOWNLOAD_TYPE_UNKONW = 0;
    public static final int DOWNLOAD_TYPE_YES = 1;
    public static final int NUM_31 = 31;
    public static final int NUM_32 = 32;
    public static final int RESOURCE_TYPE_ASSEMBLE = 11;
    public static final int RESOURCE_TYPE_ENTER_WEBP = 6;
    public static final int RESOURCE_TYPE_LOKI = 8;
    public static final int RESOURCE_TYPE_LOTTIE = 2;
    public static final int RESOURCE_TYPE_LOTTIE_NEW = 7;
    public static final int RESOURCE_TYPE_LYNX = 10;
    public static final int RESOURCE_TYPE_MP4 = 4;
    public static final int RESOURCE_TYPE_MULTI_EFFECT = 9;
    public static final int RESOURCE_TYPE_MULTI_INTERACT = 15;
    public static final int RESOURCE_TYPE_PARALLAX = 13;
    public static final int RESOURCE_TYPE_PROFILE_CARD = 14;
    public static final int RESOURCE_TYPE_STICKER = 5;
    public static final int RESOURCE_TYPE_TEXT = 12;
    public static final int RESOURCE_TYPE_WEBP = 1;

    @SerializedName("clean_strategy")
    protected b _cleanStrategy;

    @SerializedName("describe")
    protected String _describe;

    @SerializedName("download_type")
    protected int _downloadType;

    @SerializedName("format_265_resource")
    protected j _h265ResourceModel;

    @SerializedName("format_265_super_resource")
    protected k _h265SuperResourceModel;

    @SerializedName("id")
    protected long _id;

    @SerializedName("face_resource_repel_high_sticker")
    protected boolean _isHighCostAsset;

    @SerializedName("loki_extra")
    protected String _lokiExtra;

    @SerializedName("lynx_schema")
    protected String _lynxSchema;

    @SerializedName("model_requirements")
    protected List<String> _modelRequirements;

    @SerializedName("modify_version")
    protected long _modifyVersion;

    @SerializedName("name")
    protected String _name;

    @SerializedName("resource_url")
    protected l _resourceModel;

    @SerializedName("resource_type")
    protected int _resourceType;

    @SerializedName("resource_uri")
    protected String _resourceUri;

    @SerializedName("size")
    protected long _size;

    @SerializedName("anchor_guide")
    protected com.bytedance.android.live.core.resources.a anchorGuide;

    @IgnoreProtoFieldCheck
    @SerializedName("is_test")
    protected boolean isTest;

    @Expose(deserialize = false, serialize = false)
    private h lokiExtraEntity;

    @SerializedName("md5")
    protected String md5;

    @SerializedName("min_play_duration")
    protected long minPlayTime;

    @SerializedName("play_channel")
    protected long playChannel;

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/core/resources/AssetsModel$ResourceType;", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface ResourceType {
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AssetsModel() {
        super(e.class);
    }

    @Override // com.bytedance.android.live.core.resources.e
    public h getLokiExtraModel() {
        h r0 = this.lokiExtraEntity;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (TextUtils.isEmpty(getLokiExtra()) == true) goto L9;
        this.lokiExtraEntity = (h) GsonProtectorUtils.fromJson(GsonHelper.get(), getLokiExtra(), h.class);
    L9:
        return this.lokiExtraEntity;
    }

    public int hashCode() {
        int r1 = ((int) (getId() ^ (getId() >>> 32))) * 31;
        int r2 = 0;
        if (getName() == null) goto L7;
        String r0 = getName();
        if (r0 == null) goto L7;
        int r3 = r0.hashCode();
    L8:
        int r4 = (r1 + r3) * 31;
        if (getDescribe() == null) goto L13;
        String r5 = getDescribe();
        if (r5 == null) goto L13;
        int r6 = r5.hashCode();
    L14:
        int r7 = (r4 + r6) * 31;
        String r8 = this.md5;
        if (r8 == null) goto L18;
        if (r8 == null) goto L18;
        int r9 = r8.hashCode();
    L19:
        int r11 = (((r7 + r9) * 31) + getResourceType()) * 31;
        if (getResourceUri() == null) goto L24;
        String r12 = getResourceUri();
        if (r12 == null) goto L24;
        int r13 = r12.hashCode();
    L25:
        int r14 = (r11 + r13) * 31;
        if (getResourceModel() == null) goto L30;
        l r15 = getResourceModel();
        if (r15 == null) goto L30;
        int r16 = r15.hashCode();
    L31:
        long r17 = getSize();
        int r18 = (((((r14 + r16) * 31) + ((int) ((getSize() >>> 32) ^ r17))) * 31) + getDownloadType()) * 31;
        if (getH265ResourceModel() == null) goto L36;
        j r19 = getH265ResourceModel();
        if (r19 == null) goto L36;
        int r21 = r19.hashCode();
    L37:
        int r22 = (r18 + r21) * 31;
        if (getH265SuperResourceModel() == null) goto L43;
        k r23 = getH265SuperResourceModel();
        if (r23 == null) goto L43;
        r2 = r23.hashCode();
    L43:
        return r22 + r2;
    L36:
        r21 = 0;
    L30:
        r16 = 0;
    L24:
        r13 = 0;
    L18:
        r9 = 0;
    L13:
        r6 = 0;
    L7:
        r3 = 0;
        goto L8
    }

    public final com.bytedance.android.live.core.resources.a getAnchorGuide() {
        return this.anchorGuide;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public b getCleanStrategy() {
        return this._cleanStrategy;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public String getDescribe() {
        return this._describe;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public int getDownloadType() {
        return this._downloadType;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public j getH265ResourceModel() {
        return this._h265ResourceModel;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public k getH265SuperResourceModel() {
        return this._h265SuperResourceModel;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public long getId() {
        return this._id;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public String getLokiExtra() {
        return this._lokiExtra;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public String getLynxSchema() {
        return this._lynxSchema;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public String getMD5() {
        return this.md5;
    }

    public final String getMd5() {
        return this.md5;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public long getMinPlayTime() {
        return this.minPlayTime;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public List<String> getModelRequirements() {
        return this._modelRequirements;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public long getModifyVersion() {
        return this._modifyVersion;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public String getName() {
        return this._name;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public long getPlayChannel() {
        return this.playChannel;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public l getResourceModel() {
        return this._resourceModel;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public int getResourceType() {
        return this._resourceType;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public String getResourceUri() {
        return this._resourceUri;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public long getSize() {
        return this._size;
    }

    public final b get_cleanStrategy() {
        return this._cleanStrategy;
    }

    public final String get_describe() {
        return this._describe;
    }

    public final int get_downloadType() {
        return this._downloadType;
    }

    public final j get_h265ResourceModel() {
        return this._h265ResourceModel;
    }

    public final k get_h265SuperResourceModel() {
        return this._h265SuperResourceModel;
    }

    public final long get_id() {
        return this._id;
    }

    public final boolean get_isHighCostAsset() {
        return this._isHighCostAsset;
    }

    public final String get_lokiExtra() {
        return this._lokiExtra;
    }

    public final String get_lynxSchema() {
        return this._lynxSchema;
    }

    public final List<String> get_modelRequirements() {
        return this._modelRequirements;
    }

    public final long get_modifyVersion() {
        return this._modifyVersion;
    }

    public final String get_name() {
        return this._name;
    }

    public final l get_resourceModel() {
        return this._resourceModel;
    }

    public final int get_resourceType() {
        return this._resourceType;
    }

    public final String get_resourceUri() {
        return this._resourceUri;
    }

    public final long get_size() {
        return this._size;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public boolean isHighCostAsset() {
        return this._isHighCostAsset;
    }

    public final boolean isTest() {
        return this.isTest;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.live.core.resources.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.live.core.resources.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [com.bytedance.android.live.core.resources.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.core.resources.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.core.resources.j, java.lang.Object] */
    public AssetsModel(am3.g r6) {
        super(e.class);
        this._modelRequirements = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L34;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._name = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._resourceUri = am3.h.c(r6);
        goto L3
    L9:
        switch(r2) {
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            default: goto L10;
        };
    L25:
        this._lokiExtra = am3.h.c(r6);
        goto L3
    L26:
        this._size = r6.j();
        goto L3
    L27:
        this.md5 = am3.h.c(r6);
        goto L3
    L28:
        this._resourceType = r6.i();
        goto L3
    L29:
        this._id = r6.j();
        goto L3
    L30:
        this._describe = am3.h.c(r6);
        goto L3
    L31:
        this._resourceModel = vh7.f.a(r6, l.class);
        goto L3
    L10:
        switch(r2) {
            case 26: goto L24;
            case 27: goto L23;
            case 28: goto L22;
            case 29: goto L21;
            case 30: goto L20;
            case 31: goto L19;
            case 32: goto L18;
            case 33: goto L17;
            case 34: goto L16;
            default: goto L11;
        };
    L16:
        this._isHighCostAsset = am3.h.a(r6);
        goto L3
    L17:
        this._modifyVersion = r6.j();
        goto L3
    L18:
        this.isTest = am3.h.a(r6);
        goto L3
    L19:
        this.anchorGuide = vh7.f.a(r6, com.bytedance.android.live.core.resources.a.class);
        goto L3
    L20:
        this._h265SuperResourceModel = vh7.f.a(r6, k.class);
        goto L3
    L21:
        this._lynxSchema = am3.h.c(r6);
        goto L3
    L22:
        this._h265ResourceModel = vh7.f.a(r6, j.class);
        goto L3
    L23:
        this._modelRequirements.add(am3.h.c(r6));
        goto L3
    L24:
        this._downloadType = r6.i();
        goto L3
    L11:
        switch(r2) {
            case 38: goto L15;
            case 39: goto L14;
            case 40: goto L13;
            default: goto L12;
        };
    L13:
        this.playChannel = r6.j();
        goto L3
    L14:
        this.minPlayTime = r6.j();
        goto L3
    L15:
        this._cleanStrategy = vh7.f.a(r6, b.class);
        goto L3
    L12:
        am3.h.d(r3, r6);
        goto L3
    L34:
        r6.d(r0);
        setThreadSafe(true);
    }

    public boolean equals(Object r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if ((r7 instanceof AssetsModel) == true) goto L8;
        return false;
    L8:
        AssetsModel r8 = (AssetsModel) r7;
        if (getId() == r8.getId()) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(this.md5, r8.md5)) == false) goto L15;
        return false;
    L15:
        if (getH265ResourceModel() == null) goto L22;
        if (r8.getH265ResourceModel() == null) goto L22;
        if (TextUtils.equals(getH265ResourceModel().getMd5(), r8.getH265ResourceModel().getMd5()) == true) goto L22;
        return false;
    L22:
        if (getH265SuperResourceModel() != null) goto L24;
    L28:
        return true;
    L24:
        if (r8.getH265SuperResourceModel() == null) goto L28;
        if (TextUtils.equals(((j) getH265SuperResourceModel()).getMd5(), ((j) r8.getH265SuperResourceModel()).getMd5()) == true) goto L28;
        return false;
    }

    public final void setAnchorGuide(com.bytedance.android.live.core.resources.a r1) {
        this.anchorGuide = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setCdnDomainOpt(boolean r5) {
        if (getResourceModel() == null) goto L6;
        l r0 = getResourceModel();
        Intrinsics.checkNotNullParameter(r0, "resourceModel");
        KProperty[] r3 = m.a;
        Intrinsics.checkNotNullParameter(r0, "$this$setCdnDomainOpt");
        m.b(r0, Boolean.valueOf(r5));
    L6:
        if (getH265ResourceModel() == null) goto L9;
        j r1 = getH265ResourceModel();
        Intrinsics.checkNotNullParameter(r1, "resourceModel");
        KProperty[] r4 = m.a;
        Intrinsics.checkNotNullParameter(r1, "$this$setCdnDomainOpt");
        m.b(r1.getResourceModel(), Boolean.valueOf(r5));
    L9:
        if (getH265SuperResourceModel() == null) goto L12;
        k r2 = getH265SuperResourceModel();
        Intrinsics.checkNotNullParameter(r2, "resourceModel");
        KProperty[] r6 = m.a;
        Intrinsics.checkNotNullParameter(r2, "$this$setCdnDomainOpt");
        m.b(r2.getResourceModel(), Boolean.valueOf(r5));
        return;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setDescribe(String r1) {
        this._describe = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setDownloadType(int r1) {
        this._downloadType = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setH265ResourceModel(j r1) {
        this._h265ResourceModel = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setH265SuperResourceModel(k r1) {
        this._h265SuperResourceModel = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setId(long r1) {
        this._id = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setLokiExtra(String r1) {
        this._lokiExtra = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setLokiExtraModel(h r1) {
        this.lokiExtraEntity = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setLynxSchema(String r1) {
        this._lynxSchema = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setMD5(String r1) {
        this.md5 = r1;
    }

    public final void setMd5(String r1) {
        this.md5 = r1;
    }

    public void setMinPlayTime(long r1) {
        this.minPlayTime = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setModifyVersion(long r1) {
        this._modifyVersion = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setName(String r1) {
        this._name = r1;
    }

    public void setPlayChannel(long r1) {
        this.playChannel = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setResourceModel(l r1) {
        this._resourceModel = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setResourceType(int r1) {
        this._resourceType = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setResourceUri(String r1) {
        this._resourceUri = r1;
    }

    @Override // com.bytedance.android.live.core.resources.e
    public void setSize(long r1) {
        this._size = r1;
    }

    public final void setTest(boolean r1) {
        this.isTest = r1;
    }

    public final void set_cleanStrategy(b r1) {
        this._cleanStrategy = r1;
    }

    public final void set_describe(String r1) {
        this._describe = r1;
    }

    public final void set_downloadType(int r1) {
        this._downloadType = r1;
    }

    public final void set_h265ResourceModel(j r1) {
        this._h265ResourceModel = r1;
    }

    public final void set_h265SuperResourceModel(k r1) {
        this._h265SuperResourceModel = r1;
    }

    public final void set_id(long r1) {
        this._id = r1;
    }

    public final void set_isHighCostAsset(boolean r1) {
        this._isHighCostAsset = r1;
    }

    public final void set_lokiExtra(String r1) {
        this._lokiExtra = r1;
    }

    public final void set_lynxSchema(String r1) {
        this._lynxSchema = r1;
    }

    public final void set_modelRequirements(List<String> r1) {
        this._modelRequirements = r1;
    }

    public final void set_modifyVersion(long r1) {
        this._modifyVersion = r1;
    }

    public final void set_name(String r1) {
        this._name = r1;
    }

    public final void set_resourceModel(l r1) {
        this._resourceModel = r1;
    }

    public final void set_resourceType(int r1) {
        this._resourceType = r1;
    }

    public final void set_resourceUri(String r1) {
        this._resourceUri = r1;
    }

    public final void set_size(long r1) {
        this._size = r1;
    }
}
