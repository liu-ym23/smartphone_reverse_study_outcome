package m2b;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends r5b.a, b {
    boolean A8();

    boolean B8();

    String D8();

    boolean E8(c r1);

    MergeForwardContent F8();

    void G8(CoreMessageListComponent.b r1);

    o3b.a H8();

    z2b.b I8();

    int[] J8();

    y6b.b K8();

    boolean L8();

    ThreadTopic N1();

    OpenApp e();

    Chat getChat();

    @Override // r5b.a
    /* synthetic */ FragmentActivity getContext();

    boolean isClickable();

    @Override // r5b.a
    boolean isGroup();

    @Override // r5b.a
    boolean isSecretChat();

    boolean q8();

    ChatThemeInfo r8();

    boolean s8();

    void t8(o3b.a r1);

    void u8(MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r1);

    void v8(int[] r1);

    void w8(int r1);

    y6b.b x8();

    boolean y8(c r1);

    void z8(String r1);
}
