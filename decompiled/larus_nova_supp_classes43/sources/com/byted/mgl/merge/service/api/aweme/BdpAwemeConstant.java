package com.byted.mgl.merge.service.api.aweme;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/BdpAwemeConstant;", "", "()V", "KEY_APP_ID", "", "KEY_APP_NAME", "KEY_CALLING_SCHEMA", "KEY_MSG_SCHEMA", "KEY_PUSH_SCHEMA", "KEY_ROOM_ID", "KEY_SHARE_ICON", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public final class BdpAwemeConstant {
    public static final BdpAwemeConstant INSTANCE = null;
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_APP_NAME = "appName";
    public static final String KEY_CALLING_SCHEMA = "calling_schema";
    public static final String KEY_MSG_SCHEMA = "msg_schema";
    public static final String KEY_PUSH_SCHEMA = "push_schema";
    public static final String KEY_ROOM_ID = "roomId";
    public static final String KEY_SHARE_ICON = "shareIcon";

    private BdpAwemeConstant() {
    }

    static {
        INSTANCE = new BdpAwemeConstant();
    }
}
