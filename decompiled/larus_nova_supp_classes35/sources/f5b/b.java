package f5b;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.ding.entity.DingStatus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b extends p5b.c, Cloneable {
    boolean canShow();

    b clone();

    List<String> getAuthFileKeys();

    String getId();

    Message getMessage();

    MessageFoldDetail getMessageFoldDetail();

    ChatChatter getMessageSender();

    ArrayList<String> getMsgIdPathList();

    b getParent();

    Pin getPin();

    List<ReactionInfo> getReactionInfoList();

    Content getTranslateContent(boolean r1);

    TranslateInfo getTranslateInfo();

    long getUpdateTime();

    String getcId();

    boolean isIntermediateMessage();

    boolean isNoTraceDelete();

    boolean isPreMessage();

    boolean isShowMessageOriginContent();

    boolean isTranslating();

    boolean isTranslatingInited();

    void setDingStatus(DingStatus r1);

    void setForceUpdate(boolean r1);

    void setIsTranslating(boolean r1);

    void setMessage(Message r1);

    void setMessageFoldDetail(MessageFoldDetail r1);

    void setMessageSender(ChatChatter r1);

    void setTranslateInfo(TranslateInfo r1);
}
