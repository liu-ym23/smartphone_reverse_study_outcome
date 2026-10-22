package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import com.larksuite.framework.callback.ICallback;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/block/excelpermission/IGetFilePermission;", "Lcom/larksuite/framework/callback/ICallback;", "onSuccess", BuildConfig.FLAVOR, "jsonObject", "Lorg/json/JSONObject;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGetFilePermission extends ICallback {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission.IGetFilePermission$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onSuccess(IGetFilePermission r0) {
        }

        public static void $default$onSuccess(IGetFilePermission r0, JSONObject r1) {
            Intrinsics.checkNotNullParameter(r1, "jsonObject");
        }
    }

    void onSuccess();

    void onSuccess(JSONObject r1);
}
