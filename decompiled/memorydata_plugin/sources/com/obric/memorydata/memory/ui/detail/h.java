package com.obric.memorydata.memory.ui.detail;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/IdentifierTagHandler;", "Lcom/obric/memorydata/memory/ui/detail/BaseTagHandler;", "<init>", "()V", "supportedTags", "", "", "extractValue", LocationMonitorConst.TAG, "Lio/noties/markwon/html/HtmlTag;", "getClickHandler", "Lcom/obric/memorydata/memory/ui/detail/IdentifierLinkHandler;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends b {
    public h() {
    }

    @Override // com.obric.memorydata.memory.ui.detail.b
    public String a(io.noties.markwon.html.j r2) {
        io.noties.markwon.html.j r1 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.e().get(EventBody.KEY_VALUE), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public List<String> a() {
        return CollectionsKt.listOf(MemoryKeyInfoEntity.KEY_IDENTIFIER);
    }

    @Override // io.noties.markwon.html.u
    public /* synthetic */ Collection b() {
        return (Collection) ZeusTransformUtils.preCheckCast(a(), Collection.class, "com.obric.memorydata.plugin");
    }

    public g c() {
        return new g(null, 1, null);
    }

    @Override // com.obric.memorydata.memory.ui.detail.b
    public /* synthetic */ com.obric.memorydata.markdown.custom.d d() {
        return (com.obric.memorydata.markdown.custom.d) ZeusTransformUtils.preCheckCast(c(), com.obric.memorydata.markdown.custom.d.class, "com.obric.memorydata.plugin");
    }
}
