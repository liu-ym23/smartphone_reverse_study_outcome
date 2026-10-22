package com.larus.uaigc.service;

import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J,\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J,\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J(\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&J\u001e\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/service/ICreationMetadataService;", "", "getVideoMetaData", "", "", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "taskId", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getImageMetadata", "getUserCreationFromIM", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "position", "checkVideoMetaDataValid", "", "metaData", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationMetadataService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096\u0001J+\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0096\u0001J+\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0096\u0001J)\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0096\u0001J+\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0096\u0001J+\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/larus/uaigc/service/ICreationMetadataService$Companion;", "Lcom/larus/uaigc/service/ICreationMetadataService;", "<init>", "()V", "checkVideoMetaDataValid", "", "metaData", "", "", "getImageMetadata", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "taskId", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "getUserCreationFromIM", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "position", "getVideoMetaData", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationMetadataService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationMetadataService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationMetadataService
        public final Map<String, String> B(UserCreation r2, String r3) {
            return this.b.B(r2, r3);
        }

        @Override // com.larus.uaigc.service.ICreationMetadataService
        public final Map<String, String> H(UserCreation r2, String r3) {
            return this.b.H(r2, r3);
        }

        @Override // com.larus.uaigc.service.ICreationMetadataService
        public final UserCreationFromIM I(Message r2, String r3, String r4) {
            return this.b.I(r2, r3, r4);
        }

        @Override // com.larus.uaigc.service.ICreationMetadataService
        public final Map<String, String> L(UserCreationFromIM r2, String r3) {
            return this.b.L(r2, r3);
        }

        @Override // com.larus.uaigc.service.ICreationMetadataService
        public final boolean M(Map<String, String> r2) {
            return this.b.M(r2);
        }

        @Override // com.larus.uaigc.service.ICreationMetadataService
        public final Map<String, String> s(UserCreationFromIM r2, String r3) {
            return this.b.s(r2, r3);
        }

        private Companion() {
            ICreationMetadataService r0 = (ICreationMetadataService) ServiceManager.get().getService(ICreationMetadataService.class);
            if (r0 != null) goto L5;
            r0 = new ICreationMetadataServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    Map<String, String> B(UserCreation r1, String r2);

    Map<String, String> H(UserCreation r1, String r2);

    UserCreationFromIM I(Message r1, String r2, String r3);

    Map<String, String> L(UserCreationFromIM r1, String r2);

    boolean M(Map<String, String> r1);

    Map<String, String> s(UserCreationFromIM r1, String r2);
}
