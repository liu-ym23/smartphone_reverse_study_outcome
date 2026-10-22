package com.larus.community.impl.home;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.IAICreationSidebarLauncher;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/community/impl/home/AICreationSidebarLauncher;", "Lcom/larus/home/api/main/IAICreationSidebarLauncher;", "<init>", "()V", "open", "", "context", "Landroid/content/Context;", "extraBundle", "Landroid/os/Bundle;", "enterMethod", "", "findAICreationActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "mainBotId", "createFallbackAICreationActionBarItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AICreationSidebarLauncher implements IAICreationSidebarLauncher {

    public static final class a {
    }

    public static final class b implements zs8.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getChatType() {
            return "default";
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String getBotId() {
            return this.b;
        }

        public final String getEnterMethod() {
            return this.a;
        }

        public b(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public AICreationSidebarLauncher() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(Context r510, Bundle r60, String r61) {
        Intrinsics.checkNotNullParameter(r61, "enterMethod");
        if (z2.a.enableAICreationApplet() == true) goto L5;
        return false;
    L5:
        Object r5 = null;
        if ((r510 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r0 = (FragmentActivity) r510;
    L10:
        if (r0 != null) goto L18;
        FragmentActivity r1 = AppHost.a.a().getCurrentActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L14;
        r0 = r1;
    L15:
        if (r0 != null) goto L18;
        FLogger.a.e("AICreationSidebarLauncher", "open fallback: activity is null");
        return false;
    L14:
        r0 = null;
    L18:
        FragmentActivity r7 = r0;
        e0 r2 = (e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L23;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L23;
        String r6 = r3.W();
    L75:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L26
        Object r8 = Result.constructor-impl((IActionBarService) ServiceManager.get().getService(IActionBarService.class));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r8) == false) goto L31;
        r8 = null;
    L31:
        IActionBarService r9 = (IActionBarService) r8;
        if (r9 == null) goto L36;
        Object r10 = r9.e(28);
        if (r10 == null) goto L36;
    L65:
        if (r10 != null) goto L67;
        FLogger.a.i("AICreationSidebarLauncher", "use fallback AI creation actionBarItem");
        Object r11 = new z0(null, null, new g1(null, null, null, null, 31), new g1(null, null, null, null, 31), "AI 创作", null, null, null, null, null, new r(28, null, null, null, null, "AI 创作", null, null, 4030), null, true, null, null, -1610678301, 15);
    L68:
        Bundle r12 = new Bundle();
        if (r60 == null) goto L71;
        r12.putAll(r60);
    L71:
        r12.putBoolean("suppress_action_bar_item_id_on_send", true);
        r12.putString("recent_enter_feed_from", "fixed_tab");
        FLogger.a.i("AICreationSidebarLauncher", "open AI creation applet, mainBotId=" + r6);
        IUgcAIGCService.a.W(new ny9.b(true, r7, r11, new ChatParam(null, r6, null, null, "default", 237), true, false, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, new b(r61, r6), null, r12, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, -10485792, 131071));
        return true;
    L67:
        r11 = r10;
    L36:
        if (r9 != null) goto L73;
        List r13 = null;
    L41:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L38
    L45:
        if (Result.isFailure-impl(r14) == false) goto L47;
        r14 = null;
    L47:
        List r15 = (List) r14;
        if (r15 == null) goto L64;
        Iterator r16 = r15.iterator();
    L51:
        if (r16.hasNext() == false) goto L63;
        Object r17 = r16.next();
        r r18 = ((z0) r17).q;
        if (r18 == null) goto L60;
        Integer r110 = r18.a;
        if (r110 == null) goto L60;
        if (r110.intValue() != 28) goto L60;
        boolean r111 = true;
    L61:
        if (r111 == false) goto L51;
        r5 = r17;
    L60:
        r111 = false;
    L63:
        r5 = (z0) r5;
    L64:
        r10 = r5;
    L38:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L73:
        r13 = r9.f(r6);     // Catch: Throwable -> L38
    L26:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        r6 = null;
        goto L75
    L8:
        r0 = null;
        goto L10
    }
}
