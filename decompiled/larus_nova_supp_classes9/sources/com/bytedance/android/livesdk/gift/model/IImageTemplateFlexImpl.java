package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.ImageTemplate")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IImageTemplateFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/f2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "domainList$delegate", "Ljava/lang/Object;", "getDomainList", "()Ljava/util/List;", "domainList", BuildConfig.FLAVOR, "defaultParams$delegate", "getDefaultParams", "()Ljava/util/Map;", "defaultParams", "supportCustomParams$delegate", "getSupportCustomParams", "supportCustomParams", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IImageTemplateFlexImpl extends FlexModelBase<f2> implements f2, vh7.h {

    @SerializedName("default_params")
    protected Map<String, String> _$$defaultParams;

    @SerializedName("domain_list")
    protected List<String> _$$domainList;

    @SerializedName("support_custom_params")
    protected List<String> _$$supportCustomParams;

    public IImageTemplateFlexImpl() {
        super(f2.class);
        this._$$domainList = $defaultValue_domainList$();
        this._$$defaultParams = $defaultValue_defaultParams$();
        this._$$supportCustomParams = $defaultValue_supportCustomParams$();
    }

    public IImageTemplateFlexImpl(am3.g r11) {
        super(f2.class);
        this._$$domainList = new ArrayList();
        this._$$defaultParams = new HashMap();
        this._$$supportCustomParams = new ArrayList();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L31;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L10;
        long r7 = r11.c();
        String r3 = null;
        String r6 = null;
    L14:
        int r9 = r11.f();
        if (r9 == (-1)) goto L21;
        if (r9 != 1) goto L17;
        r3 = am3.h.c(r11);
        goto L14
    L17:
        if (r9 != 2) goto L18;
        r6 = am3.h.c(r11);
        goto L14
    L18:
        am3.h.e(r11);
        goto L14
    L21:
        r11.d(r7);
        Map<String, String> r4 = this._$$defaultParams;
        if (r3 == null) goto L28;
        if (r6 == null) goto L26;
        r4.put(r3, r6);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L10:
        if (r2 != 3) goto L11;
        List<String> r8 = this._$$supportCustomParams;
    L30:
        r8.add(am3.h.c(r11));
        goto L3
    L11:
        am3.h.d(r5, r11);
        goto L3
    L29:
        r8 = this._$$domainList;
        goto L30
    L31:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$domainList.isEmpty() == false) goto L35;
        this._$$domainList = $defaultValue_domainList$();
    L35:
        if (this._$$defaultParams != null) goto L38;
        this._$$defaultParams = $defaultValue_defaultParams$();
    L38:
        if (this._$$supportCustomParams.isEmpty() == false) goto L62;
        this._$$supportCustomParams = $defaultValue_supportCustomParams$();
        return;
    }

    public final Map<String, String> $defaultValue_defaultParams$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<String> $defaultValue_domainList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<String> $defaultValue_supportCustomParams$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.f2
    public final Map<String, String> getDefaultParams() {
        return this._$$defaultParams;
    }

    @Override // com.bytedance.android.livesdk.gift.model.f2
    public final List<String> getDomainList() {
        return this._$$domainList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.f2
    public final List<String> getSupportCustomParams() {
        return this._$$supportCustomParams;
    }
}
