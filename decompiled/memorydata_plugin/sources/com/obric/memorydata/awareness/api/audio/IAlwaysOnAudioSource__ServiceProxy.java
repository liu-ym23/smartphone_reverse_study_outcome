package com.obric.memorydata.awareness.api.audio;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.awareness.audio.AlwaysOnAudioSourceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class IAlwaysOnAudioSource__ServiceProxy implements IServiceProxy<IAlwaysOnAudioSource> {
    public IAlwaysOnAudioSource__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.awareness.api.audio.IAlwaysOnAudioSource", "com.obric.memorydata.awareness.audio.AlwaysOnAudioSourceImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAlwaysOnAudioSource newInstance() {
        return AlwaysOnAudioSourceImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAlwaysOnAudioSource newInstance() {
        return newInstance();
    }
}
