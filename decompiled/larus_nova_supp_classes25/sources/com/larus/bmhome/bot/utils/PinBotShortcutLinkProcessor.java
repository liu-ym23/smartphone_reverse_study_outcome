package com.larus.bmhome.bot.utils;

import android.app.Activity;
import android.net.Uri;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PinBotShortcutLinkProcessor {
    public static final PinBotShortcutLinkProcessor a = null;

    public static final class a {
        public final BotModel a;
        public final String b;
        public final boolean c;
        public final String d;
        public final Boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((r0 + r1) * 31) + this.d.hashCode()) * 31;
            Boolean r3 = this.e;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Parameter(botModel=" + this.a + ", conversationId=" + this.b + ", openChat=" + this.c + ", currentPage=" + this.d + ", ifCanUploadImage=" + this.e + ')';
        }

        public a(BotModel r2, String r3, boolean r4, String r5, Boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "botModel");
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r5, "currentPage");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
        a = new PinBotShortcutLinkProcessor();
    }

    public PinBotShortcutLinkProcessor() {
    }

    public static void e(Uri r7) {
        Intrinsics.checkNotNullParameter(r7, "uri");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PinBotShortcutLinkProcessor$process$2(r7, null), 3, null);
    }

    public static final void b(PinBotShortcutLinkProcessor r11, a r12) {
        r11.getClass();
        String r13 = r12.d;
        String r0 = r12.a.getBotId();
        ChatControlTrace r1 = ChatControlTrace.b;
        r1.getClass();
        String r2 = r1.h(ChatControlTrace.y);
        Boolean r3 = Boolean.valueOf(ve8.c.c(r12.a));
        Boolean r4 = r12.e;
        String r5 = null;
        if (r4 == null) goto L5;
        boolean r6 = r4.booleanValue();
    L28:
        JSONObject r10 = tx9.c.a(r13, r0, r2, r3, Boolean.valueOf(r6));
        IShortcutPlatformService r7 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
        if (r7 == null) goto L40;
        String r8 = r12.b;
        String r9 = r12.a.getName();
        BotIconImage r14 = r12.a.getIconImage();
        if (r14 == null) goto L33;
        r5 = r14.getOriginUrl();
    L33:
        r7.c(r8, r9, r5, vb8.a.a(r12.a), r10);
        return;
    L40:
        return;
    L5:
        BotModel r15 = r12.a;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        List r16 = r15.getBotConf();
        if (r16 == null) goto L22;
        Iterator r17 = r16.iterator();
    L9:
        if (r17.hasNext() == false) goto L18;
        Object r18 = r17.next();
        BotConfItem r19 = (BotConfItem) r18;
        if (Intrinsics.areEqual(r19.getConfGroupKey(), "show_icon") == true) goto L13;
    L15:
        boolean r20 = false;
    L16:
        if (r20 == false) goto L9;
    L19:
        BotConfItem r21 = (BotConfItem) r18;
        if (r21 == null) goto L22;
        String r22 = r21.getConfValue();
    L23:
        boolean r23 = Intrinsics.areEqual(r22, "1");
        if (FeatureKitDelegate.b.U().b() == false) goto L27;
        if (r23 == false) goto L27;
        r6 = true;
    L27:
        r6 = false;
        goto L28
    L13:
        if (Intrinsics.areEqual(r19.getConfKey(), "show_image_icon") == false) goto L15;
        r20 = true;
        goto L16
    L18:
        r18 = null;
    L22:
        r22 = null;
        goto L23
    }

    public static void d(Activity r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "host");
        Intrinsics.checkNotNullParameter(r8, "uri");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PinBotShortcutLinkProcessor$process$1(r8, r7, null), 3, null);
    }

    public final Object c(String r14, Continuation<? super String> r15) {
        if ((r15 instanceof PinBotShortcutLinkProcessor$findConversationIdByBot$1) == false) goto L7;
        PinBotShortcutLinkProcessor$findConversationIdByBot$1 r0 = (PinBotShortcutLinkProcessor$findConversationIdByBot$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        PinBotShortcutLinkProcessor$findConversationIdByBot$1 r11 = r0;
        Object r16 = r11.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L35:
        e r17 = (e) r16;
        if (r17 == null) goto L43;
        Map r18 = r17.x;
        if (r18 == null) goto L41;
        Map r19 = MapsKt.toMutableMap(r18);
        if (r19 == null) goto L41;
    L42:
        r19.put("is_from_local_discovery", "1");
        RepoDispatcherDelegate.b.f().c(r17, r19);
    L41:
        r19 = new HashMap();
    L43:
        if (r17 == null) goto L46;
        String r110 = r17.a;
        if (r110 == null) goto L46;
        return r110;
    L46:
        return "";
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (String) r11.L$0;
        ResultKt.throwOnFailure(r16);
    L19:
        e r111 = (e) r16;
        if (r111 == null) goto L27;
        Integer r4 = r111.t;
        if (r4 == null) goto L27;
        if (r4.intValue() != 1) goto L27;
        String r112 = r111.a;
    L28:
        if (r112 != null) goto L30;
    L32:
        IConversationRepoService r113 = RepoDispatcherDelegate.b.f();
        r11.L$0 = null;
        r11.label = 2;
        r16 = IConversationRepoService$a.a(r113, r14, 2, null, null, false, null, null, null, null, r11, 508);
        if (r16 != r2) goto L35;
        return r2;
    L30:
        if (StringsKt.contains$default(r112, "local", false, 2, null) == true) goto L32;
        return r112;
    L27:
        r112 = null;
        goto L28
    L16:
        ResultKt.throwOnFailure(r16);
        IConversationRepoService r114 = RepoDispatcherDelegate.b.f();
        r11.L$0 = r14;
        r11.label = 1;
        r16 = r114.a(r14, r11);
        if (r16 != r2) goto L19;
        return r2;
    L7:
        r0 = new PinBotShortcutLinkProcessor$findConversationIdByBot$1(this, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(PinBotShortcutLinkProcessor r18, Uri r19, Continuation r20) {
        Uri r1 = r19;
        r18.getClass();
        if ((r20 instanceof PinBotShortcutLinkProcessor$buildParameter$1) == false) goto L7;
        PinBotShortcutLinkProcessor$buildParameter$1 r3 = (PinBotShortcutLinkProcessor$buildParameter$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        PinBotShortcutLinkProcessor$buildParameter$1 r9 = r3;
        Object r2 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        boolean r11 = true;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        boolean r0 = r9.Z$0;
        String r7 = (String) r9.L$2;
        String r8 = (String) r9.L$1;
        Uri r10 = (Uri) r9.L$0;
        ResultKt.throwOnFailure(r2);
        boolean r12 = r0;
        String r13 = r7;
    L34:
        BotModel r14 = (BotModel) r2;
        Object r15 = null;
        if (r14 != null) goto L38;
        FLogger.a.e("PinBotShortcutLinkProcessor", "[buildParameter] failed, cannot find botModel");
    L52:
        return r15;
    L38:
        if (r13.length() == 0) goto L41;
        r11 = false;
    L41:
        if (r11 == false) goto L44;
        FLogger.a.e("PinBotShortcutLinkProcessor", "[buildParameter] failed, conversationId is empty");
        goto L52
    L44:
        String r16 = y0.f(r10, "shortcut_if_can_upload_image");
        if (r16 == null) goto L47;
        r15 = Boxing.boxBoolean(Intrinsics.areEqual(r16, "1"));
    L47:
        Boolean r17 = r15;
        if (r8 != null) goto L50;
        String r21 = "";
    L51:
        r15 = new a(r14, r13, r12, r21, r17);
        goto L52
    L50:
        r21 = r8;
        goto L51
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r22 = (String) r9.L$2;
        String r23 = (String) r9.L$1;
        Uri r24 = (Uri) r9.L$0;
        ResultKt.throwOnFailure(r2);
        String r25 = r23;
        r1 = r24;
        Object r26 = r2;
    L25:
        String r110 = r22;
        String r27 = (String) r26;
    L27:
        boolean r111 = Intrinsics.areEqual(y0.f(r1, "open_chat"), "1");
        FLogger.a.i("PinBotShortcutLinkProcessor", "[buildParameter] url_params(bot_id:" + r25 + ", conversation_id:" + r27 + ", open_chat:" + r111 + ", current_page:" + r110 + ')');
        RepoDispatcher.a.getClass();
        BotRepo r28 = RepoDispatcher.g;
        if (r25 != null) goto L30;
        r25 = "";
    L30:
        r9.L$0 = r1;
        r9.L$1 = r110;
        r9.L$2 = r27;
        r9.Z$0 = r111;
        r9.label = 2;
        Object r29 = IBotRepoService.b.a(r28, r25, false, null, false, r9, 30);
        if (r29 == r5) goto L54;
        r13 = r27;
        r12 = r111;
        r2 = r29;
        r8 = r110;
        r10 = r1;
        goto L34
    L54:
        return r5;
    L16:
        ResultKt.throwOnFailure(r2);
        r25 = y0.f(r1, "bot_id");
        String r30 = y0.f(r1, "current_page");
        String r31 = y0.f(r1, "conversation_id");
        if (r31 != null) goto L26;
        if (r25 != null) goto L20;
        String r32 = "";
    L21:
        r9.L$0 = r1;
        r9.L$1 = r25;
        r9.L$2 = r30;
        r9.label = 1;
        Object r33 = r18.c(r32, r9);
        if (r33 == r5) goto L53;
        r26 = r33;
        r22 = r30;
        goto L25
    L53:
        return r5;
    L20:
        r32 = r25;
        goto L21
    L26:
        r110 = r30;
        r27 = r31;
    L7:
        r3 = new PinBotShortcutLinkProcessor$buildParameter$1(r18, r20);
        goto L8
    }
}
