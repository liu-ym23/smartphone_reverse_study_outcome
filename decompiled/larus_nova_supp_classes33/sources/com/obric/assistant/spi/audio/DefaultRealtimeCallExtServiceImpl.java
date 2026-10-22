package com.obric.assistant.spi.audio;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J6\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#H\u0096@¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u0014H\u0016¨\u0006)"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultRealtimeCallExtServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "<init>", "()V", "init", "", "setShowWhenLockedForExistingRealtimeCallActivity", "onRealtimeCallActivityFinish", "activity", "Landroidx/fragment/app/FragmentActivity;", "onRealtimeCallActivityOnNewIntent", "newIntent", "Landroid/content/Intent;", "fragment", "Landroidx/fragment/app/Fragment;", "getNotificationPendingIntent", "Landroid/app/PendingIntent;", "packageContext", "Landroid/content/Context;", "isGoToChatPage", "", "currentContext", "isRealtimeCallActivity", MemorySourceLinkType.INTENT, "hasRealtimeCallActivity", "getCurrentCallType", "Lcom/obric/assistant/spi/audio/CallType;", "launchRealtimeCall", "Lcom/obric/assistant/spi/audio/LaunchRealtimeCallResult;", "callType", "from", "", "delayJumpMS", "", "onPreJump", "Lkotlin/Function0;", "(Lcom/obric/assistant/spi/audio/CallType;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeCallType", "currentCallType", "targetCallType", "isAssistantListening", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultRealtimeCallExtServiceImpl implements IObricRealtimeCallExtService {
    public DefaultRealtimeCallExtServiceImpl() {
    }

    public final CallType getCurrentCallType() {
        return null;
    }

    public final PendingIntent getNotificationPendingIntent(Context r1, boolean r2, Context r3) {
        Intrinsics.checkNotNullParameter(r1, "packageContext");
        return null;
    }

    public final boolean hasRealtimeCallActivity() {
        return false;
    }

    public final void init() {
    }

    public final boolean isAssistantListening() {
        return false;
    }

    public final void onRealtimeCallActivityFinish(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onRealtimeCallActivityOnNewIntent(FragmentActivity r1, Intent r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
    }

    public final void setShowWhenLockedForExistingRealtimeCallActivity() {
    }

    public final Object launchRealtimeCall(CallType r1, String r2, long r3, Function0<Unit> r5, Continuation<? super a> r6) {
        return new a.f();
    }
}
