package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010l\u001a\u00020\u0002¢\u0006\u0004\bm\u0010nJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001R\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010'\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001e\u0010.\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\u001c\u00101\u001a\u00020\u00158\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001e\u00107\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010=\u001a\u0004\u0018\u0001088\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010@\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010 R\u0014\u0010A\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010\u0010R\u001e\u0010D\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R\u001e\u0010J\u001a\u0004\u0018\u00010E8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010M\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R\u0014\u0010O\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010\u001eR\u001c\u0010S\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010P8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR \u0010W\u001a\u00060\u001cj\u0002`T8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 R\u001e\u0010Z\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bX\u0010$\"\u0004\bY\u0010&R\u0014\u0010\\\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b[\u0010\u001eR\u001e\u0010b\u001a\u0004\u0018\u00010]8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010e\u001a\u00020\u00158\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bc\u0010\u0018\"\u0004\bd\u0010\u001aR\u001e\u0010h\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bf\u0010$\"\u0004\bg\u0010&R\u001c\u0010k\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bi\u0010\u001e\"\u0004\bj\u0010 ¨\u0006o"}, d2 = {"Lcom/bytedance/android/live/core/resources/IMainAssetModelExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/core/resources/e;", "Lcom/bytedance/android/live/core/resources/f;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "cdnDomainOpt", "", "setCdnDomainOpt", "isTest", "()Z", "Lcom/bytedance/android/live/core/resources/a;", "getAnchorGuide", "()Lcom/bytedance/android/live/core/resources/a;", "anchorGuide", "", "value", "getAssetSource", "()I", "setAssetSource", "(I)V", "assetSource", "", "getExpireTime", "()J", "setExpireTime", "(J)V", "expireTime", "", "getMD5", "()Ljava/lang/String;", "setMD5", "(Ljava/lang/String;)V", "MD5", "Lcom/bytedance/android/live/core/resources/b;", "getCleanStrategy", "()Lcom/bytedance/android/live/core/resources/b;", "cleanStrategy", "getDescribe", "setDescribe", "describe", "getDownloadType", "setDownloadType", "downloadType", "Lcom/bytedance/android/live/core/resources/j;", "getH265ResourceModel", "()Lcom/bytedance/android/live/core/resources/j;", "setH265ResourceModel", "(Lcom/bytedance/android/live/core/resources/j;)V", "h265ResourceModel", "Lcom/bytedance/android/live/core/resources/k;", "getH265SuperResourceModel", "()Lcom/bytedance/android/live/core/resources/k;", "setH265SuperResourceModel", "(Lcom/bytedance/android/live/core/resources/k;)V", "h265SuperResourceModel", "getId", "setId", "id", "isHighCostAsset", "getLokiExtra", "setLokiExtra", "lokiExtra", "Lcom/bytedance/android/live/core/resources/h;", "getLokiExtraModel", "()Lcom/bytedance/android/live/core/resources/h;", "setLokiExtraModel", "(Lcom/bytedance/android/live/core/resources/h;)V", "lokiExtraModel", "getLynxSchema", "setLynxSchema", "lynxSchema", "getMinPlayTime", "minPlayTime", "", "getModelRequirements", "()Ljava/util/List;", "modelRequirements", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getModifyVersion", "setModifyVersion", "modifyVersion", "getName", "setName", "name", "getPlayChannel", "playChannel", "Lcom/bytedance/android/live/core/resources/l;", "getResourceModel", "()Lcom/bytedance/android/live/core/resources/l;", "setResourceModel", "(Lcom/bytedance/android/live/core/resources/l;)V", "resourceModel", "getResourceType", "setResourceType", "resourceType", "getResourceUri", "setResourceUri", "resourceUri", "getSize", "setSize", "size", "base", "<init>", "(Lcom/bytedance/android/live/core/resources/e;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainAssetModelExtensionImpl extends ModelExtensionBase<e, f> implements f, e {
    private final /* synthetic */ e $$delegate_0;

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public <R extends vh7.e<e>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public <R extends vh7.e<e>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public b getCleanStrategy() {
        return this.$$delegate_0.getCleanStrategy();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public String getDescribe() {
        return this.$$delegate_0.getDescribe();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public int getDownloadType() {
        return this.$$delegate_0.getDownloadType();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public j getH265ResourceModel() {
        return this.$$delegate_0.getH265ResourceModel();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public k getH265SuperResourceModel() {
        return this.$$delegate_0.getH265SuperResourceModel();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public long getId() {
        return this.$$delegate_0.getId();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public String getLokiExtra() {
        return this.$$delegate_0.getLokiExtra();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public h getLokiExtraModel() {
        return this.$$delegate_0.getLokiExtraModel();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public String getLynxSchema() {
        return this.$$delegate_0.getLynxSchema();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public String getMD5() {
        return this.$$delegate_0.getMD5();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public long getMinPlayTime() {
        return this.$$delegate_0.getMinPlayTime();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public List<String> getModelRequirements() {
        return this.$$delegate_0.getModelRequirements();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public long getModifyVersion() {
        return this.$$delegate_0.getModifyVersion();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public String getName() {
        return this.$$delegate_0.getName();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public long getPlayChannel() {
        return this.$$delegate_0.getPlayChannel();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public l getResourceModel() {
        return this.$$delegate_0.getResourceModel();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public int getResourceType() {
        return this.$$delegate_0.getResourceType();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public String getResourceUri() {
        return this.$$delegate_0.getResourceUri();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public long getSize() {
        return this.$$delegate_0.getSize();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public boolean isHighCostAsset() {
        return this.$$delegate_0.isHighCostAsset();
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setCdnDomainOpt(boolean r2) {
        this.$$delegate_0.setCdnDomainOpt(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setDescribe(String r2) {
        this.$$delegate_0.setDescribe(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setDownloadType(int r2) {
        this.$$delegate_0.setDownloadType(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setH265ResourceModel(j r2) {
        this.$$delegate_0.setH265ResourceModel(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setH265SuperResourceModel(k r2) {
        this.$$delegate_0.setH265SuperResourceModel(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setId(long r2) {
        this.$$delegate_0.setId(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setLokiExtra(String r2) {
        this.$$delegate_0.setLokiExtra(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setLokiExtraModel(h r2) {
        this.$$delegate_0.setLokiExtraModel(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setLynxSchema(String r2) {
        this.$$delegate_0.setLynxSchema(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setMD5(String r2) {
        this.$$delegate_0.setMD5(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setModifyVersion(long r2) {
        this.$$delegate_0.setModifyVersion(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setName(String r2) {
        this.$$delegate_0.setName(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setResourceModel(l r2) {
        this.$$delegate_0.setResourceModel(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setResourceType(int r2) {
        this.$$delegate_0.setResourceType(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setResourceUri(String r2) {
        this.$$delegate_0.setResourceUri(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e
    public void setSize(long r2) {
        this.$$delegate_0.setSize(r2);
    }

    @Override // com.bytedance.android.live.core.resources.f
    public a getAnchorGuide() {
        return (a) get(31, f.class);
    }

    @Override // com.bytedance.android.live.core.resources.f
    public int getAssetSource() {
        return ((Number) get(36, f.class, 0)).intValue();
    }

    @Override // com.bytedance.android.live.core.resources.f
    public long getExpireTime() {
        return ((Number) get(37, f.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.live.core.resources.f
    public boolean isTest() {
        return ((Boolean) get(32, f.class, Boolean.FALSE)).booleanValue();
    }

    public IMainAssetModelExtensionImpl(e r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.live.core.resources.f
    public void setAssetSource(int r4) {
        set(36, "asset_source", f.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.live.core.resources.f
    public void setExpireTime(long r3) {
        set(37, "expire_time", f.class, Long.valueOf(r3));
    }
}
