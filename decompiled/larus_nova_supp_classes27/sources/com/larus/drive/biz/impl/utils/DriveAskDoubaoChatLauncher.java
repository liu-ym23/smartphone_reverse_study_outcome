package com.larus.drive.biz.impl.utils;

import android.content.Context;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.service.r;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveAskDoubaoChatLauncher {
    public static final DriveAskDoubaoChatLauncher a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new DriveAskDoubaoChatLauncher();
    }

    public DriveAskDoubaoChatLauncher() {
    }

    public final Object a(Continuation<? super String> r6) {
        if ((r6 instanceof DriveAskDoubaoChatLauncher$getMainBotId$1) == false) goto L7;
        DriveAskDoubaoChatLauncher$getMainBotId$1 r0 = (DriveAskDoubaoChatLauncher$getMainBotId$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L21:
        List r8 = (List) r7;
        if (r8 == null) goto L31;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L31;
        if ((!StringsKt.isBlank(r9)) == true) goto L29;
        r9 = null;
    L29:
        if (r9 == null) goto L31;
    L40:
        return r9;
    L31:
        e0 r10 = (e0) AuthModelDelegate.b.e().getValue();
        if (r10 == null) goto L41;
        LaunchInfo r11 = r10.a;
        if (r11 == null) goto L42;
        r9 = r11.W();
        if (r9 != null) goto L38;
        return null;
    L38:
        if ((!StringsKt.isBlank(r9)) == true) goto L40;
        return null;
    L42:
        return null;
    L41:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        wc9.e r12 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r12 == null) goto L31;
        String r13 = r12.a;
        if (r13 == null) goto L31;
        r0.label = 1;
        r7 = ic8.n.b(r13, r0);
        if (r7 != r2) goto L21;
        return r2;
    L7:
        r0 = new DriveAskDoubaoChatLauncher$getMainBotId$1(this, r6);
        goto L8
    }

    public final Object b(Context r25, DriveFileItem r26, boolean r27, Continuation<? super Boolean> r28) {
        if ((r28 instanceof DriveAskDoubaoChatLauncher$openAskDoubaoChat$1) == false) goto L7;
        DriveAskDoubaoChatLauncher$openAskDoubaoChat$1 r2 = (DriveAskDoubaoChatLauncher$openAskDoubaoChat$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L23;
        if (r5 == 1) goto L22;
        if (r5 == 2) goto L21;
        if (r5 == 3) goto L20;
        if (r5 == 4) goto L18;
        if (r5 != 5) goto L17;
        ResultKt.throwOnFailure(r1);
    L94:
        return Boxing.boxBoolean(true);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        boolean r6 = r2.Z$0;
        String r9 = (String) r2.L$4;
        BotModel r10 = (BotModel) r2.L$3;
        String r11 = (String) r2.L$2;
        DriveFileItem r12 = (DriveFileItem) r2.L$1;
        Context r13 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
        boolean r14 = r6;
        String r7 = r9;
    L19:
        DriveFileItem r8 = r12;
        Object r15 = CollectionsKt.firstOrNull((List) r1);
        String r16 = (String) r15;
        if (r16 != null) goto L68;
    L71:
        boolean r17 = true;
    L73:
        if (r17 == false) goto L76;
        r15 = null;
    L76:
        String r18 = (String) r15;
        if (r18 != null) goto L79;
        String r110 = r11;
    L81:
        if (StringsKt.isBlank(r7) == false) goto L83;
    L95:
        FLogger.a.i("DriveAskDoubaoLauncher", "openAskDoubaoChat skipped because conversation or bot is invalid, conversationIdEmpty=" + StringsKt.isBlank(r7) + ", botIdEmpty=" + StringsKt.isBlank(r110));
        return Boxing.boxBoolean(false);
    L83:
        if (StringsKt.isBlank(r110) == true) goto L95;
        BotInfoCache.INSTANCE.put(r7, r10);
        LocalSubConvHelper r20 = LocalSubConvHelper.a;
        BotOnBoarding r21 = r10.getOnBoarding();
        if (r21 == null) goto L89;
        List r22 = r21.getMessageList();
        if (r22 == null) goto L89;
    L90:
        LocalSubConvHelper.j(r7, r22, true);
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        DriveAskDoubaoChatLauncher$openAskDoubaoChat$2 r24 = new DriveAskDoubaoChatLauncher$openAskDoubaoChat$2(r13, r7, r110, r8, r14, null);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 5;
        if (BuildersKt.withContext(r23, r24, r2) != r4) goto L94;
        return r4;
    L89:
        r22 = CollectionsKt.emptyList();
        goto L90
    L79:
        r110 = r18;
        goto L81
    L68:
        if (StringsKt.isBlank(r16) == true) goto L71;
        r17 = false;
        goto L73
    L20:
        boolean r30 = r2.Z$0;
        r10 = (BotModel) r2.L$3;
        r11 = (String) r2.L$2;
        r12 = (DriveFileItem) r2.L$1;
        r13 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L57:
        wc9.e r31 = (wc9.e) r1;
        if (r31 == null) goto L60;
        String r32 = r31.a;
        r2.L$0 = r13;
        r2.L$1 = r12;
        r2.L$2 = r11;
        r2.L$3 = r10;
        r2.L$4 = r32;
        r2.Z$0 = r30;
        r2.label = 4;
        Object r33 = ic8.n.b(r32, r2);
        if (r33 != r4) goto L64;
        return r4;
    L64:
        r14 = r30;
        r7 = r32;
        r1 = r33;
        goto L19
    L60:
        return Boxing.boxBoolean(false);
    L21:
        r30 = r2.Z$0;
        r11 = (String) r2.L$2;
        r12 = (DriveFileItem) r2.L$1;
        r13 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L43:
        BotModel r34 = (BotModel) r1;
        if (r34 == null) goto L46;
        r2.L$0 = r13;
        r2.L$1 = r12;
        r2.L$2 = r11;
        r2.L$3 = r34;
        r2.Z$0 = r30;
        r2.label = 3;
        kotlinx.coroutines.j r111 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r111.C();
        if (AccountService.a.isEnterpriseAccount() == false) goto L50;
        int r112 = 2131908160;
    L51:
        r.a.a(com.larus.im.d.d(), r34, 3, Boxing.boxInt(1), MapsKt.mapOf(TuplesKt.to("conv_name", r13.getString(r112))), null, new com.larus.drive.biz.impl.utils.a(r111), 16);
        Object r35 = r111.B();
        if (r35 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L54:
        if (r35 != r4) goto L56;
        return r4;
    L56:
        r10 = r34;
        r1 = r35;
        goto L57
    L50:
        r112 = 2131908104;
        goto L51
    L46:
        return Boxing.boxBoolean(false);
    L22:
        r30 = r2.Z$0;
        r12 = (DriveFileItem) r2.L$1;
        r13 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L27:
        String r36 = (String) r1;
        if (r36 != null) goto L30;
    L33:
        boolean r113 = true;
    L34:
        if (r113 == false) goto L37;
        FLogger.a.i("DriveAskDoubaoLauncher", "openAskDoubaoChat skipped because botId is blank.");
        return Boxing.boxBoolean(false);
    L37:
        r2.L$0 = r13;
        r2.L$1 = r12;
        r2.L$2 = r36;
        r2.Z$0 = r30;
        r2.label = 2;
        kotlinx.coroutines.j r114 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r114.C();
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r36, false, "sub", new b(r114), 8);
        Object r115 = r114.B();
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L40:
        if (r115 != r4) goto L42;
        return r4;
    L42:
        r11 = r36;
        r1 = r115;
        goto L43
    L30:
        if (StringsKt.isBlank(r36) == true) goto L33;
        r113 = false;
        goto L34
    L23:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r25;
        r2.L$1 = r26;
        r2.Z$0 = r27;
        r2.label = 1;
        Object r116 = a(r2);
        if (r116 != r4) goto L26;
        return r4;
    L26:
        r13 = r25;
        r1 = r116;
        r12 = r26;
        r30 = r27;
    L7:
        r2 = new DriveAskDoubaoChatLauncher$openAskDoubaoChat$1(this, r28);
        goto L8
    }
}
