package com.larus.bmhome.resource.access;

import com.larus.bmhome.rc.FlowResourceScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceUploadSceneResolver;", "", "key", "", "getKey", "()Ljava/lang/String;", "priority", "", "getPriority", "()I", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "resolve", "Lcom/larus/bmhome/rc/FlowResourceScene;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ResourceUploadSceneResolver {
    FlowResourceScene a(h0 r1);

    boolean b(h0 r1);

    String getKey();

    void getPriority();
}
