package com.obric.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.SideBarPage;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.home.obric.ObricChatActivity;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.chat.IObricInteractionService;
import com.obric.assistant.util.OrionChatExtensionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/ObricInteractionImpl;", "Lcom/obric/assistant/spi/chat/IObricInteractionService;", "<init>", "()V", "adaptSlideBarFragmentArguments", "Landroid/os/Bundle;", "page", NameKeys.UnloadStrategy_No_Strategy, "arguments", "prepareSideBarMainChatForActivation", NameKeys.UnloadStrategy_No_Strategy, "activity", "Landroidx/fragment/app/FragmentActivity;", "getOChatContainer", NameKeys.UnloadStrategy_No_Strategy, "getOrionChatExtensionUtilsCallback", "Lcom/obric/assistant/spi/chat/callback/IObricChatExtensionUtilsCallback;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionImpl implements IObricInteractionService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public ObricInteractionImpl() {
    }

    public final String a() {
        return "O";
    }

    public final void b(final FragmentActivity r9) {
        if (HomeService.a.o() == true) goto L7;
        FLogger.a.i("ObricInteractionImpl", "skip prepare main chat: sidebar is disabled enabled");
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L11;
        FLogger.a.i("ObricInteractionImpl", "dispatch prepare main chat to main thread");
        com.larus.utils.t0.e(new j1(this, r9));
        return;
    L11:
        if (r9 != null) goto L16;
        Activity r10 = AppHost.a.a().getCurrentActivity();
        if ((r10 instanceof FragmentActivity) == false) goto L15;
        r9 = (FragmentActivity) r10;
        goto L16
    L15:
        r9 = null;
    L16:
        if (r9 != null) goto L19;
        FLogger.a.i("ObricInteractionImpl", "skip prepare main chat: activity is null");
        return;
    L19:
        Lifecycle.State r2 = r9.getLifecycle().getCurrentState();
        FLogger r3 = FLogger.a;
        r3.i("ObricInteractionImpl", "prepare main chat, activity=" + r9 + ", lifecycle=" + r2);
        if (r2.isAtLeast(Lifecycle.State.RESUMED) == true) goto L23;
        r3.i("ObricInteractionImpl", "skip prepare main chat: activity is not resumed");
        return;
    L23:
        List r4 = r9.getSupportFragmentManager().getFragments();
        ListIterator r5 = r4.listIterator(r4.size());
    L25:
        if (r5.hasPrevious() == false) goto L34;
        Object r6 = r5.previous();
        Fragment r7 = (Fragment) r6;
        if (r7.isVisible() == true) goto L29;
    L31:
        boolean r8 = false;
    L32:
        if (r8 == false) goto L25;
    L35:
        com.larus.bmhome.a0 r11 = (Fragment) r6;
        if (r11 != null) goto L43;
        FLogger r0 = FLogger.a;
        StringBuilder r12 = new StringBuilder("skip prepare main chat: no visible sidebar host, fragments=");
        List r13 = r9.getSupportFragmentManager().getFragments();
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L39:
        if (r15.hasNext() == false) goto L41;
        Fragment r16 = (Fragment) r15.next();
        r14.add(r16.getClass().getSimpleName() + "(added=" + r16.isAdded() + ", visible=" + r16.isVisible() + ')');
        goto L39
    L41:
        r12.append(r14);
        r0.i("ObricInteractionImpl", r12.toString());
        return;
    L43:
        com.larus.bmhome.a0 r17 = r11;
        if (r17.Ga() == true) goto L47;
        FLogger.a.i("ObricInteractionImpl", "skip prepare main chat: sidebar is closed, currentPage=" + r17.ub());
        return;
    L47:
        FLogger r18 = FLogger.a;
        r18.i("ObricInteractionImpl", "prepare main chat, host=" + r11 + ", previousPage=" + r17.ub());
        r17.v7(false);
        r17.Q9(null, 1);
        r11.getChildFragmentManager().executePendingTransactions();
        r18.i("ObricInteractionImpl", "main chat selected, currentPage=" + r17.ub() + ", sidebarOpen=" + r17.Ga());
        return;
    L29:
        if ((r7 instanceof com.larus.bmhome.a0) == false) goto L31;
        r8 = true;
        goto L32
    L34:
        r6 = null;
        goto L35
    }

    public final jga.a d(ObricChatActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (ObricFeatureServiceDelegate.b.c() == true) goto L7;
        return null;
    L7:
        return new OrionChatExtensionUtils(r2);
    }

    public final Bundle c(int r8, Bundle r9) {
        SideBarPage.a r0 = SideBarPage.Companion;
        Integer r10 = Integer.valueOf(r8);
        r0.getClass();
        if (SideBarPage.a.c(r10) == false) goto L50;
        String r1 = null;
        if (r9 == null) goto L7;
        String r2 = r9.getString("as_container");
    L8:
        boolean r3 = false;
        if (r2 != null) goto L11;
    L14:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
    L20:
        if (r9 == null) goto L22;
        r1 = r9.getString("argConversationId");
    L22:
        if (r1 != null) goto L25;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L25:
        if (r9 == null) goto L27;
        int r5 = r9.getInt("argBotConversationType", -1);
    L28:
        if (r5 == (-1)) goto L30;
    L34:
        if (r5 != 1) goto L36;
    L39:
        boolean r6 = true;
    L40:
        if (r6 == false) goto L49;
        FLogger r7 = FLogger.a;
        StringBuilder r11 = new StringBuilder("adapt chat arguments: apply O container, hasConversationId=");
        if (r1.length() <= 0) goto L44;
        r3 = true;
    L44:
        r11.append(r3);
        r7.i("ObricInteractionImpl", r11.toString());
        if (r9 == null) goto L47;
        r9 = new Bundle(r9);
    L48:
        r9.putString("as_container", "O");
        goto L50
    L47:
        r9 = new Bundle();
        goto L48
    L49:
        FLogger.a.i("ObricInteractionImpl", "adapt chat arguments: keep non-main conversation");
        goto L50
    L36:
        if (com.larus.bmhome.utils.i.g(r1) == true) goto L39;
        r6 = false;
        goto L40
    L30:
        if (r1.length() != 0) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == true) goto L39;
    L32:
        r12 = false;
        goto L33
    L27:
        r5 = -1;
        goto L28
    L18:
        if (Intrinsics.areEqual(r2, "DEFAULT") == true) goto L20;
        FLogger.a.i("ObricInteractionImpl", "adapt chat arguments: keep explicit container=" + r2);
        goto L50
    L11:
        if (r2.length() == 0) goto L14;
        r4 = false;
        goto L16
    L7:
        r2 = null;
    L50:
        return r9;
    }
}
