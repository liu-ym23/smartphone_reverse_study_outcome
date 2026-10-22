package hrb;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: hrb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0276a {
    }

    public interface b {
    }

    RichTextElement.AtProperty getAtProperty(com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty r1) throws Exception;

    int getChatThreadLynxCardMessageWidth(Integer r1);

    Context getContext();

    String getDynamicDomain(String r1);

    boolean getFgValue(String r1);

    boolean getFgValue(String r1, boolean r2);

    RichTextElement.ImageProperty getImageProperty(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r1) throws Exception;

    Locale getLanguageSetting();

    String getLoginTenantId();

    String getLoginUserId();

    int getLynxCardMessageWidth(boolean r1, Integer r2);

    int getMaxMessageWidth(int r1);

    int getThreadDetailLynxCardMessageWidth(boolean r1, Integer r2);

    int getThreadLynxCardMessageWidth(boolean r1, Integer r2);

    boolean is12HourClock();

    void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    void openUrl(Context r1, String r2, boolean r3, boolean r4, Boolean r5, String r6);

    RichText parsePbFromRichText(com.ss.android.lark.widget.richtext.RichText r1);

    com.ss.android.lark.widget.richtext.RichText parseRichTextFromPb(RichText r1);

    com.ss.android.lark.widget.richtext.RichText parseRichTextFromPbWithStyleMerge(RichText r1, HashMap r2);

    void pickGroupMember(Activity r1, String r2, List<String> r3, boolean r4, String r5, IGetDataCallback<List<ChatChatter>> r6);

    void pickTargetMember(Activity r1, List<String> r2, List<String> r3, boolean r4, String r5, IGetDataCallback<List<ChatChatter>> r6);

    void setBgForCustomHeader(View r1, View r2, int[] r3);
}
