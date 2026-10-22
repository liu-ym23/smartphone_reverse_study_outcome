package tib;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface g {
    void attachGlobalWatermark(Dialog r1);

    c createForwardChatPicker(Context r1);

    String getAppLinkDomain();

    Map<String, Chatter> getChatterMap(Map<String, com.bytedance.lark.pb.basic.v1.Chatter> r1);

    String getCreateGroupChatResultKey();

    String getCreateGroupSelectedDataKey();

    zib.a getEventParams(List<String> r1);

    IExternalForwardExecutor getExternalForwardExecutor(ExternalForwardDirection r1, String r2, List<String> r3, String r4, boolean r5, String r6);

    String getExternalTargetId();

    a getExternalTargetItem();

    int getLoginUserAuthorityDeniedReason();

    String getLoginUserId();

    void go2Chat(Context r1, String r2, Bundle r3);

    void go2Chat(Context r1, String r2, Chat.ChatMode r3, Bundle r4);

    void go2Thread(Context r1, String r2);

    boolean hasFilePreviewPermissionFromMessage(Message r1);

    boolean isDoubaoWorkTabEnabled();

    boolean isEnterSendEnabled();

    void showNoIMPermissionDialog(String r1);

    void showSquareMessageStickerThumb(Context r1, ImageView r2, StickImage r3);

    void startCreateGroup(Fragment r1, boolean r2, int r3);

    void startCreateGroupWithFilter(Context r1, Fragment r2, Bundle r3, IGetDataCallback<Chat> r4);

    void startProfile(Context r1, String r2);
}
