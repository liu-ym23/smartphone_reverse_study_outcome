package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class StringMapMessage extends MapMessage<StringMapMessage, String> {
    private static final long serialVersionUID = 1;

    public StringMapMessage() {
    }

    public StringMapMessage(int r1) {
        super(r1);
    }

    public StringMapMessage(Map<String, String> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public /* synthetic */ MapMessage newInstance(Map<String, String> r3) {
        return newInstance2((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    /* JADX INFO: renamed from: newInstance, reason: avoid collision after fix types in other method */
    public StringMapMessage newInstance2(Map<String, String> r2) {
        return new StringMapMessage((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
    }
}
