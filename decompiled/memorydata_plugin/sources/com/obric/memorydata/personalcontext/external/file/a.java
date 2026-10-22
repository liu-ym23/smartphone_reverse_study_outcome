package com.obric.memorydata.personalcontext.external.file;

import android.content.ContentResolver;
import android.content.Context;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/file/ExternalCollectorFileEntitySupplier;", "Lcom/obric/capabilitykit/EntitySupplier;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "provideAllEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements EntitySupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12129a;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f12129a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        ContentResolver r1 = this.f12129a.getContentResolver();
        b r0 = b.f12130a;
        Intrinsics.checkNotNull(r1);
        return r0.a(r1);
    }
}
