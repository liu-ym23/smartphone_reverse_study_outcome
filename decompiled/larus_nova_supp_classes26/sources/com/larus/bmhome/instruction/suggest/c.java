package com.larus.bmhome.instruction.suggest;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.instruction.f;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Fragment a;
    public final PromptContent.SuggestV2ExtraForMultiAction b;
    public final String c;
    public final String d;
    public final eq8.a e;
    public final Lazy f;
    public final String g;

    public final f c() {
        return (f) this.f.getValue();
    }

    public static final void a(c r3, String r4) {
        r3.getClass();
        if (o0.d(r4) == false) goto L17;
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L7;
        String r5 = "sslocal://flow/realtime_chat?trigger_hello=true&enter_method=" + r3.c + "&bot_say_hello_text_key=" + r3.b.getSpeechKey() + "&conversation_id=" + r4;
        SmartRouter.buildRoute(r0, r5).d();
        FLogger.a.i("PromptSelectActionDispatcher", "not directCall, schema: " + r5);
    L7:
        String r6 = r3.b.getSpeechKey();
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L18;
        eq8.a r8 = r3.e;
        int r9 = eq8.a.d;
        r8.c("handleUgcBotCall", "speechKey is null", null);
        return;
    L18:
        return;
    L10:
        if (r6.length() == 0) goto L13;
        r7 = false;
        goto L14
    }

    public static String b(PromptContent.SuggestV2ExtraForMultiAction r3, String r4) {
        List r5 = r3.getDefaultOptionList();
        if (r5 == null) goto L24;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        PromptContent.DefaultOptionItem r2 = (PromptContent.DefaultOptionItem) r1;
        if (r2 == null) goto L10;
        String r7 = r2.getLabel();
    L12:
        if (Intrinsics.areEqual(r7, r4) == false) goto L6;
    L15:
        PromptContent.DefaultOptionItem r8 = (PromptContent.DefaultOptionItem) r1;
        if (r8 == null) goto L25;
        Integer r9 = r8.getDefaultSelectionId();
        if (r9 != null) goto L20;
        return null;
    L20:
        return r9.toString();
    L25:
        return null;
    L10:
        r7 = null;
        goto L12
    L14:
        r1 = null;
        goto L15
    L24:
        return null;
    }

    public c(Fragment r2, PromptContent.SuggestV2ExtraForMultiAction r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "suggestV2ExtraForMultiAction");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        Intrinsics.checkNotNullParameter(r5, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new eq8.a();
        this.f = LazyKt.lazy(new b(this));
        this.g = r3.getUserPrompt();
    }
}
