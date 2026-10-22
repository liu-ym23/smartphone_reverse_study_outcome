package nha;

import android.app.Activity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.api.window.IChatWindowActivity;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g implements cy7.b {
    public static final Set<String> a = null;
    public static final Set<String> b = null;

    public static final class a {
    }

    public g() {
    }

    static {
        a = SetsKt.setOf(new String[]{"long_press_message", "chat_action_bar_click", "chat_action_bar_show", "click_camera", "click_upload_entrance", "click_upload_file_entrance", "click_call", "obric_assistant_launch", "send_message_status", "send_message"});
        b = SetsKt.setOf(new String[]{"send_message", "send_message_status"});
    }

    public final void intercept(String r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r12, DBDefinition.NAME);
        if (r13 != null) goto L5;
        return;
    L5:
        boolean r0 = b.contains(r12);
        boolean r3 = false;
        if (a.contains(r12) == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r0 == true) goto L14;
        if (r1 == true) goto L14;
        return;
    L14:
        IAssistantChatWindow r5 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r5 != null) goto L17;
    L19:
        boolean r6 = false;
    L20:
        Object r7 = null;
        if (r1 == false) goto L33;
        IObricActivityStackService r8 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r8 == null) goto L33;
        List r9 = r8.b();
        if (r9 == null) goto L33;
        ListIterator r10 = r9.listIterator(r9.size());
    L28:
        if (r10.hasPrevious() == false) goto L32;
        Object r11 = r10.previous();
        if ((!(((Activity) r11) instanceof lba.a)) == false) goto L28;
        r7 = r11;
    L32:
        r7 = (Activity) r7;
    L33:
        if (r6 == false) goto L35;
    L38:
        boolean r14 = true;
    L39:
        if (r14 == false) goto L49;
        if (r0 == false) goto L49;
        if (r5 == null) goto L47;
        WindowLayoutInfo r2 = r5.getWindowLayoutInfo();
        if (r2 == null) goto L47;
        if (r2.isLandscapeWindowLayout() != true) goto L47;
        r3 = true;
    L47:
        if (r3 == false) goto L49;
        r13.put("obric_screen_orientation", "landscape");
    L49:
        if (r1 == false) goto L59;
        FLogger.a.i("WindowParamInterceptor", r12 + " isWindow: " + r14 + ", lastActivity = " + r7);
        if (r14 == false) goto L53;
        String r15 = "window";
    L54:
        r13.put("obric_panel_type", r15);
        return;
    L53:
        r15 = "activity";
        goto L54
    L59:
        return;
    L35:
        if ((r7 instanceof IChatWindowActivity) == true) goto L38;
        r14 = false;
        goto L39
    L17:
        if (r5.isShowing() != true) goto L19;
        r6 = true;
        goto L20
    L8:
        if (r13.has("obric_panel_type") == true) goto L10;
        r1 = true;
        goto L11
    }
}
