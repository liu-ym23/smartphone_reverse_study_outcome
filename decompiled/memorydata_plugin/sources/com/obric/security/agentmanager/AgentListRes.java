package com.obric.security.agentmanager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AgentListRes {
    private List<String> agentUuids;
    private int status;

    public AgentListRes(int r2, List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public List<String> getAgentUuids() {
        throw new RuntimeException("Stub!!");
    }

    public int getResultCode() {
        throw new RuntimeException("Stub!!");
    }

    public void setAgentUuids(List<String> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public void setResultStatus(int r1) {
        throw new RuntimeException("Stub!!");
    }
}
