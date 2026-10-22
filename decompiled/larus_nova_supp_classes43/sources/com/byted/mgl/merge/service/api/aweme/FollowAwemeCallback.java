package com.byted.mgl.merge.service.api.aweme;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0017\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/FollowAwemeCallback;", "", "onFailure", "", "code", "", MessageIndication.MESSAGE_TYPE_MSG, "", "onFollowAwemeResult", "hasFollowed", "", "(Ljava/lang/Boolean;)V", "Companion", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface FollowAwemeCallback {
    public static final String BUNDLE_KEY_FOLLOW_CALLBACK_CODE = "followAwemeCode";
    public static final String BUNDLE_KEY_FOLLOW_CALLBACK_MSG = "followAwemeMSG";
    public static final String BUNDLE_KEY_FOLLOW_STATE = "followAwemeState";
    public static final int CODE_DIALOG_SHOWING = -3;
    public static final int CODE_ERROR = -1;
    public static final int CODE_NOT_SUPPORT = -2;
    public static final int CODE_USER_CANCEL = -4;
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/FollowAwemeCallback$Companion;", "", "()V", "BUNDLE_KEY_FOLLOW_CALLBACK_CODE", "", "BUNDLE_KEY_FOLLOW_CALLBACK_MSG", "BUNDLE_KEY_FOLLOW_STATE", "CODE_DIALOG_SHOWING", "", "CODE_ERROR", "CODE_NOT_SUPPORT", "CODE_USER_CANCEL", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String BUNDLE_KEY_FOLLOW_CALLBACK_CODE = "followAwemeCode";
        public static final String BUNDLE_KEY_FOLLOW_CALLBACK_MSG = "followAwemeMSG";
        public static final String BUNDLE_KEY_FOLLOW_STATE = "followAwemeState";
        public static final int CODE_DIALOG_SHOWING = -3;
        public static final int CODE_ERROR = -1;
        public static final int CODE_NOT_SUPPORT = -2;
        public static final int CODE_USER_CANCEL = -4;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onFailure(int r1, String r10);

    void onFollowAwemeResult(Boolean r1);
}
