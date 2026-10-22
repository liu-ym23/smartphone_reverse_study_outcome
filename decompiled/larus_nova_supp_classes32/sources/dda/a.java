package dda;

import android.app.Activity;
import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.i;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.chat.p;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lha.f;
import td8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements td8.c {
    public final d a;

    /* JADX INFO: renamed from: dda.a$a, reason: collision with other inner class name */
    public static final class C0082a {
    }

    static {
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final boolean a(int r11, xc8.b r12, xc8.b r13, List<? extends xc8.b> r14) {
        Intrinsics.checkNotNullParameter(r13, "current");
        Intrinsics.checkNotNullParameter(r14, "input");
        xc8.b r15 = (xc8.b) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L9;
        Message r16 = r15.getMessage();
        if (r16 == null) goto L9;
        String r17 = r16.getConversationId();
        if (r17 == null) goto L9;
        boolean r18 = i.g(r17);
    L10:
        Context r19 = this.a.j();
        String r110 = NameKeys.UnloadStrategy_No_Strategy;
        if (r19 == null) goto L13;
        String r111 = r19.getClass().getName();
    L14:
        AppHost.Companion r0 = AppHost.a;
        Activity r1 = r0.a().getCurrentActivity();
        if (r1 == null) goto L17;
        String r2 = r1.getClass().getName();
    L18:
        if (r2 == null) goto L21;
        r110 = r2;
    L21:
        HomeService r3 = HomeService.a;
        if (Intrinsics.areEqual(r111, r3.r()) == false) goto L24;
    L27:
        boolean r4 = true;
    L28:
        boolean r5 = IWindowContextKt.isWindowContext(this.a.j());
        boolean r6 = ((Boolean) SessionAuthenticationServiceDelegate.b.o().getValue()).booleanValue();
        boolean r7 = IKeyguardStateKt.getKeyguardState().isDeviceLocked();
        FLogger.a.i("Pipeline_List_OKeyguardCutTask", "canProcess: isKeyguardLocked = " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", isDeviceLocked: " + r7 + ", isBiometricAuthenticated: " + r6 + ", lock time = " + IKeyguardStateKt.getKeyguardState().getKeyguardLockTime() + ", isMainBotExceptCocoSub: " + r18 + ", isObricChatActivity: " + r4 + ", uiContextClassName: " + r111 + ", topActivityClassName = " + r110 + ", isChatWindow = " + r5);
        if (ObricFeatureServiceDelegate.b.c() == true) goto L31;
        return false;
    L31:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L53;
        if (r7 == false) goto L54;
        if (r6 == true) goto L55;
        if (r5 == true) goto L48;
        if (r4 == false) goto L56;
        if (r18 == true) goto L50;
        return false;
    L50:
        t1a.b r112 = p.a(r0.a().getCurrentActivity());     // Catch: Throwable -> L45
        if (r112 == null) goto L46;
        laa.d r113 = r112.getAbility(laa.d.class);     // Catch: Throwable -> L45
        if (r113 == null) goto L46;
        if (r113.isFullScreen() == true) goto L46;
        boolean r114 = true;
    L47:
        if (r114 == true) goto L48;
        return false;
    L46:
        r114 = false;
        goto L47
    L56:
        return false;
    L48:
        return true;
    L55:
        return false;
    L54:
        return false;
    L53:
        return false;
    L24:
        if (Intrinsics.areEqual(r110, r3.r()) == true) goto L27;
        r4 = false;
        goto L28
    L17:
        r2 = null;
        goto L18
    L13:
        r111 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r18 = false;
        goto L10
    }

    public final List<xc8.b> b(int r48, xc8.b r49, xc8.b r50, List<xc8.b> r51) {
        Intrinsics.checkNotNullParameter(r50, "current");
        Intrinsics.checkNotNullParameter(r51, "input");
        FLogger.a.i("Pipeline_List_OKeyguardCutTask", "start OKeyguardCutTask, start input size is " + r51.size());
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L57;
        long r1 = f.a().b();
        String r4 = String.valueOf(r1);
        LinkedHashSet r5 = new LinkedHashSet();
        LinkedHashSet r6 = new LinkedHashSet();
        ArrayList r7 = new ArrayList();
        Iterator r0 = CollectionsKt.reversed(r51).iterator();
    L5:
        String r9 = null;
        if (r0.hasNext() == false) goto L39;
        xc8.b r8 = (xc8.b) r0.next();
        Message r10 = r8.getMessage();
        if (r10.getCreateTime() >= r1) goto L15;
        if (r10.getCreateTime() != 0) goto L5;
        if (o0.d(r10.getReplyId()) == false) goto L5;
        if (Intrinsics.areEqual(r10.getReplyId(), "0") == true) goto L5;
    L15:
        Map r11 = r10.getExt();
        if (r11 == null) goto L19;
        r9 = (String) r11.get("keyguard_lock_time");
    L19:
        if (Intrinsics.areEqual(r9, r4) == false) goto L24;
        String r12 = r10.getMessageId();
        if (r12 == null) goto L24;
        r5.add(r12);
    L24:
        if (CollectionsKt.contains(r5, r10.getMessageId()) == false) goto L26;
    L31:
        String r13 = r10.getMessageId();
        if (r13 == null) goto L35;
        r6.add(r13);
    L35:
        if (CollectionsKt.contains(r6, r10.getMessageId()) == true) goto L38;
        if (CollectionsKt.contains(r6, r10.getReplyId()) == false) goto L5;
    L38:
        r7.add(r8);
        goto L5
    L26:
        if (CollectionsKt.contains(r5, r10.getReplyId()) == true) goto L31;
        if (com.larus.bmhome.chat.bean.d.G0(r10) == true) goto L35;
        if (Intrinsics.areEqual(r10.getReplyId(), "0") == false) goto L35;
    L39:
        List<xc8.b> r2 = CollectionsKt.toMutableList(CollectionsKt.reversed(r7));
        FLogger r3 = FLogger.a;
        StringBuilder r14 = new StringBuilder("end OKeyguardCutTask, lastMessage: ");
        xc8.b r15 = (xc8.b) CollectionsKt.firstOrNull(r2);
        if (r15 == null) goto L42;
        r9 = r15.getMessage();
    L42:
        r14.append(r9);
        r3.i("Pipeline_List_OKeyguardCutTask", r14.toString());
        ListProtector.add(r2, r2.size(), xc8.f.f(b0.j(new Message(null, null, null, 0, 0, null, 1001, false, null, com.larus.im.internal.core.message.converter.a.a(new TextContent(AppHost.a.getApplication().getString(2131912642), null, null, null, null, null, null, null, 254, null), TextContent.Companion.serializer()), null, null, null, null, null, null, 0, 0, false, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("o_keyguard_tips_message", "1")}), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194881, 31, null), 3)));
        return r2;
    L57:
        return r51;
    }
}
