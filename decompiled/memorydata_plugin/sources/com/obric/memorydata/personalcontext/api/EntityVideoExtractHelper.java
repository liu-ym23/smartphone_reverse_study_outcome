package com.obric.memorydata.personalcontext.api;

import android.net.Uri;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0096\u0001J'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0096\u0001J#\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/EntityVideoExtractHelper;", "Lcom/obric/memorydata/personalcontext/api/IEntityVideoExtractHelper;", "<init>", "()V", "calculateVideoClip", "", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "entityJson", "intervalParam", "video", "Landroid/net/Uri;", "deleteTempPicPath", "", "uri", "extractFrame", "timestampMs", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityVideoExtractHelper implements IEntityVideoExtractHelper {
    public static final EntityVideoExtractHelper INSTANCE = null;
    private final /* synthetic */ IEntityVideoExtractHelper $$delegate_0;

    static {
        INSTANCE = new EntityVideoExtractHelper();
    }

    private EntityVideoExtractHelper() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IEntityVideoExtractHelper.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IEntityVideoExtractHelper) ZeusTransformUtils.preCheckCast(r0, IEntityVideoExtractHelper.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public List<Long> calculateVideoClip(String r2, Uri r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "video");
        return this.$$delegate_0.calculateVideoClip(r2, r3, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public List<Long> calculateVideoClip(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "entityJson");
        return this.$$delegate_0.calculateVideoClip(r2, r3, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public void deleteTempPicPath(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.$$delegate_0.deleteTempPicPath(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public Uri extractFrame(String r2, Uri r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "video");
        return this.$$delegate_0.extractFrame(r2, r3, r4);
    }
}
