package cs8;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.taskskill.f;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.AgentTaskParam;
import com.larus.im.bean.message.AgentTaskParamChange;
import com.larus.im.bean.message.GeneralTaskParam;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import td8.c;
import v19.i5;
import zd9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements c {

    public static final class a {
        public static String a(GeneralTaskParam r2) {
            AgentTaskParam r3 = r2.getAgentTaskParam();
            if (r3 == null) goto L18;
            Integer r0 = r3.getRuntimeType();
            boolean r1 = true;
            if (r0 != null) goto L8;
        L10:
            String r4 = r3.getDeviceName();
            if (r4 != null) goto L13;
        L16:
            if (r1 == true) goto L18;
            return r3.getDeviceName();
        L13:
            if (StringsKt.isBlank(r4) == true) goto L16;
            r1 = false;
            goto L16
        L8:
            if (r0.intValue() != 1) goto L10;
            return AppHost.a.getApplication().getString(2131908244);
        L18:
            return null;
        }

        public static String b(GeneralTaskParam r9, String r10) {
            AgentTaskParam r11 = r9.getAgentTaskParam();
            if (r11 == null) goto L5;
            String r12 = r11.getLocalAppId();
        L7:
            if (Intrinsics.areEqual(r12, "1044603") == false) goto L9;
            int r13 = cs8.a.a;
            int r14 = 2131900727;
        L11:
            if (r10 != null) goto L13;
        L16:
            boolean r2 = true;
        L17:
            if (r2 == true) goto L20;
            return StringsKt.replace$default(AppHost.a.getApplication().getString(r14, new Object[]{r10}), "{ label }", r10, false, 4, null);
        L20:
            return StringsKt.replace$default(AppHost.a.getApplication().getString(r14, new Object[]{r10}), "{ label }", "", false, 4, null);
        L13:
            if (StringsKt.isBlank(r10) == true) goto L16;
            r2 = false;
            goto L17
        L9:
            int r15 = cs8.a.a;
            r14 = 2131900725;
            goto L11
        L5:
            r12 = null;
            goto L7
        }
    }

    static {
    }

    public b() {
    }

    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    public final List<xc8.b> b(int r69, xc8.b r70, xc8.b r71, List<xc8.b> r72) {
        Intrinsics.checkNotNullParameter(r71, "current");
        Intrinsics.checkNotNullParameter(r72, "input");
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r72.iterator();
    L3:
        boolean r3 = false;
        if (r0.hasNext() == false) goto L13;
        Object r2 = r0.next();
        Integer r6 = b0.c(((xc8.b) r2).getMessage());
        if (r6 != null) goto L9;
    L11:
        if (r3 == true) goto L3;
        r1.add(r2);
        goto L3
    L9:
        if (r6.intValue() != 15) goto L11;
        r3 = true;
        goto L11
    L13:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r1.iterator();
        int r7 = 0;
    L15:
        if (r5.hasNext() == false) goto L74;
        Object r8 = r5.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        xc8.b r10 = (xc8.b) r8;
        r4.add(r10);
        Message r11 = r10.getMessage();
        String r12 = null;
        if (d.G0(r11) == false) goto L43;
        Map r13 = r11.getExt();
        if (r13 == null) goto L43;
        String r14 = (String) r13.get("general_task_param");
        if (r14 == null) goto L43;
        if ((!StringsKt.isBlank(r14)) == true) goto L30;
        r14 = null;
    L30:
        if (r14 == null) goto L43;
        GeneralTaskParam r15 = (GeneralTaskParam) i.a(r14, GeneralTaskParam.Companion.serializer());
        if (r15 == null) goto L43;
        AgentTaskParamChange r16 = r15.getAgentTaskParamChange();
        if (r16 == null) goto L43;
        if (r16.getRuntimeChanged() != true) goto L41;
    L44:
        if (r15 == null) goto L73;
        if (r7 == CollectionsKt.getLastIndex(r1)) goto L73;
        FLogger.a.i("Pipeline_List_DeviceOrRuntimeChangedTask", "add device/runtime changed tip for message id: " + r10.getMessage().getMessageId());
        Message r17 = r10.getMessage();
        String r33 = com.larus.im.internal.core.message.converter.a.a(new TextContent(a.b(r15, a.a(r15)), null, null, null, null, null, null, null, 254, null), TextContent.Companion.serializer());
        Message r18 = b0.j(new Message(r17.getConversationId(), null, null, 0, 21, null, 1001, false, null, r33, null, null, null, null, null, r17.getMessageId() + "-device-runtime-changed", r17.getLocalIndex() - 1, 0, false, r17.getSectionId(), null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 15);
        Application r19 = AppHost.a.getApplication();
        String r110 = a.a(r15);
        if (r110 == null) goto L51;
        r12 = "￼".concat(r110);
    L51:
        CharSequence r111 = a.b(r15, r12);
        int r112 = StringsKt.indexOf$default(r111, "￼", 0, false, 6, null);
        if (r112 < 0) goto L72;
        AgentTaskParam r20 = r15.getAgentTaskParam();
        if (r20 == null) goto L62;
        Integer r21 = r20.getRuntimeType();
        if (r21 == null) goto L62;
        if (r21.intValue() != 1) goto L62;
        boolean r22 = true;
    L63:
        if (r22 == false) goto L65;
        int r23 = 2131241905;
    L66:
        Drawable r24 = ContextCompat.getDrawable(r19, r23);
        if (r24 == null) goto L72;
        Drawable r25 = r24.mutate();
        if (r25 == null) goto L72;
        DrawableCompat.setTint(r25, ContextCompat.getColor(r19, v19.c.b(2130972081, r19, 2131103143)));
        SpannableStringBuilder r113 = new SpannableStringBuilder(r111);
        r113.setSpan(new f(r25, i5.m(), i5.z()), r112, r112 + 1, 33);
        r111 = r113;
        goto L72
    L65:
        r23 = 2131241906;
    L62:
        r22 = false;
    L72:
        r4.add(new zr8.b(r18, r111));
    L73:
        r7 = r9;
        goto L15
    L41:
        if (r16.getDeviceChanged() == true) goto L44;
    L43:
        r15 = null;
        goto L44
    L74:
        return r4;
    }
}
