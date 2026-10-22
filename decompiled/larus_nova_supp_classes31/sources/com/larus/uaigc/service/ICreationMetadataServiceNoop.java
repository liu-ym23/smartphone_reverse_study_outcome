package com.larus.uaigc.service;

import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/uaigc/service/ICreationMetadataServiceNoop;", "Lcom/larus/uaigc/service/ICreationMetadataService;", "<init>", "()V", "getVideoMetaData", "", "", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "taskId", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getImageMetadata", "getUserCreationFromIM", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "position", "checkVideoMetaDataValid", "", "metaData", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationMetadataServiceNoop implements ICreationMetadataService {
    public ICreationMetadataServiceNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> B(UserCreation r1, String r2) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> H(UserCreation r1, String r2) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final UserCreationFromIM I(Message r1, String r2, String r3) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> L(UserCreationFromIM r1, String r2) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final boolean M(Map<String, String> r1) {
        return false;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> s(UserCreationFromIM r1, String r2) {
        return null;
    }
}
