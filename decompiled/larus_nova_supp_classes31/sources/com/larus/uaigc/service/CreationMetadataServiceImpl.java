package com.larus.uaigc.service;

import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.AwemeAnchor;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/uaigc/service/CreationMetadataServiceImpl;", "Lcom/larus/uaigc/service/ICreationMetadataService;", "<init>", "()V", "getVideoMetaData", "", "", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "taskId", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getImageMetadata", "getUserCreationFromIM", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "position", "checkVideoMetaDataValid", "", "metaData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationMetadataServiceImpl implements ICreationMetadataService {
    public CreationMetadataServiceImpl() {
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final boolean M(Map<String, String> r4) {
        iz9.c.a.getClass();
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        if (r4.containsKey("LvMetaInfo") == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r4.size() != 1) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> B(UserCreation r2, String r3) {
        if (r2 == null) goto L4;
        iz9.c.a.getClass();
        return iz9.c.f(r2, r3);
    L4:
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> H(UserCreation r6, String r7) {
        if (r6 == null) goto L22;
        iz9.c.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (iz9.c.b == true) goto L23;
        String r1 = r6.a;
        AwemeAnchor r8 = r6.q;
        if (r8 == null) goto L10;
        String r2 = r8.a;
    L11:
        if (r8 == null) goto L13;
        String r9 = r8.b;
    L14:
        boolean r3 = true;
        String r10 = iz9.c.d(r1, r2, iz9.c.b(r9, true), "UserCreation image", r7);
        if (r10.length() == 0) goto L18;
        r3 = false;
    L18:
        if (r3 == false) goto L21;
        return null;
    L21:
        return MapsKt.mapOf(TuplesKt.to("UserComment", r10));
    L13:
        r9 = null;
        goto L14
    L10:
        r2 = null;
        goto L11
    L23:
        return null;
    L22:
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> L(UserCreationFromIM r2, String r3) {
        if (r2 == null) goto L4;
        iz9.c.a.getClass();
        return iz9.c.e(r2, r3);
    L4:
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final Map<String, String> s(UserCreationFromIM r2, String r3) {
        if (r2 == null) goto L4;
        iz9.c.a.getClass();
        return iz9.c.g(r2, r3);
    L4:
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationMetadataService
    public final UserCreationFromIM I(Message r3, String r4, String r5) {
        if (r3 == null) goto L17;
        iz9.c.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map r6 = r3.getExt();
        if (r6 == null) goto L7;
        String r7 = (String) r6.get("user_creation");
    L9:
        if (com.larus.utils.o0.d(r7) == false) goto L18;
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        LinkedHashMap r8 = (LinkedHashMap) DataConverterKt.d(r7);
        UserCreationFromIM r9 = (UserCreationFromIM) r8.get(r4);
        if (r9 != null) goto L16;
        return (UserCreationFromIM) r8.get(String.valueOf(r5));
    L16:
        return r9;
    L18:
        return null;
    L7:
        r7 = null;
        goto L9
    L17:
        return null;
    }
}
