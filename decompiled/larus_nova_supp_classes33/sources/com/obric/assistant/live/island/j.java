package com.obric.assistant.live.island;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.live.template.IObricTemplate;
import com.obric.assistant.live.template.ObricAINotificationDescription;
import com.obric.assistant.live.template.ObricAINotificationTemplate;
import com.obric.assistant.live.template.ObricAINotificationTemplateIcon;
import com.obric.assistant.live.template.ObricAINotificationTemplateText;
import com.obric.assistant.live.template.ObricCommonCollapsedTemplate;
import com.obric.assistant.live.template.ObricExpandedTemplate;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.obric.livecard.api.island.IslandApi;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public j() {
    }

    public static PendingIntent d(r r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        AppHost.Companion r0 = AppHost.a;
        Context r1 = r0.getApplication().getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r2 = 67108864;
    L6:
        int r3 = r6.a.hashCode();
        Context r4 = r0.getApplication().getApplicationContext();
        Intent r5 = new Intent();
        r5.setPackage(r4.getPackageName());
        r5.setAction("com.obric.assistant.obric.live.pending.action");
        r5.putExtra("live_state", -100);
        r5.putExtra(WindowEvent.Params.LAUNCH_METHOD, "dynamic_island");
        r5.putExtra("is_complex_task_scene", true);
        r5.putExtra("request_lock_screen_authentication", true);
        sea.b r7 = sea.b.a;
        Bundle r8 = r6.d;
        r7.getClass();
        sea.b.e(r5, r8);
        return PendingIntent.getBroadcast(r1, r3, r5, r2 | 134217728);
    L5:
        r2 = 0;
        goto L6
    }

    public static IslandSession e(u r24) {
        Intrinsics.checkNotNullParameter(r24, "params");
        IslandWidget r3 = r24.a;
        IslandWidget r4 = r24.b;
        IslandWidget r6 = r24.c;
        t r1 = r24.d;
        PendingIntent r7 = r1.a;
        LiveCardType r12 = LiveCardType.ASSISTANT;
        long r8 = r24.e;
        JsonObject r15 = r1.b;
        return new IslandSession(r3, r4, null, r6, r7, r1.c, null, 0, r12, null, Boolean.FALSE, r15, r8, null, null, null, 0, 123588, null);
    }

    public static void f(IslandSession r1) {
        Intrinsics.checkNotNullParameter(r1, "session");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.destroySession(r1);
        return;
    }

    public static void g(IslandSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.createSession(r2, AppHost.a.getApplication().getApplicationContext());
        return;
    }

    public static IslandWidget a(Icon r8, Text r9) {
        Intrinsics.checkNotNullParameter(r8, "startIcon");
        return IObricTemplate.a.a(new ObricCommonCollapsedTemplate(null, r9, r8, null, 8, null));
    }

    public static IslandWidget b(Icon r10, Text r11, Text r12, List r13, List r14) {
        Intrinsics.checkNotNullParameter(r10, "icon");
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r13, "buttonList");
        Intrinsics.checkNotNullParameter(r14, "buttonV2List");
        if ((!r14.isEmpty()) == true) goto L7;
        r14 = null;
    L7:
        return IObricTemplate.a.a(new ObricExpandedTemplate(r13, r12, r10, r11, null, r14, 16, null));
    }

    public static IslandWidget c(ObricAINotificationTemplateText r9, ObricAINotificationTemplateText r10, ObricAINotificationTemplateIcon r11, Icon r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        ObricAINotificationTemplateIcon r4 = null;
    L7:
        if ((r13 & 32) == 0) goto L9;
        Icon r3 = null;
    L10:
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, "content");
        return IObricTemplate.a.a(new ObricAINotificationTemplate(r3, r4, r9, new ObricAINotificationDescription(null, r10, 1, null), null, null));
    L9:
        r3 = r12;
        goto L10
    L5:
        r4 = r11;
        goto L7
    }
}
