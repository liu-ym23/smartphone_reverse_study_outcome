package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.hilt.EntryPoints;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class InitMinutesRecordingTask implements com.ss.android.lark.passportc.task.d {
    public static final j0c.b b = null;

    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;

    public static final class a {
    }

    @Inject
    public InitMinutesRecordingTask() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(j0c.e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    static {
        b = new j0c.b("resume_minutes_recording");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return b;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L8
        OfficeSDKUserComponent r8 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Throwable -> L8
        if (r8 == null) goto L10;
        Result.constructor-impl((hub.a) ((OfficeSDKUserEntryPoint) EntryPoints.get(r8, OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(hub.a.class));     // Catch: Throwable -> L8
    L10:
        Object r9 = vub.a.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r10 = this.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r0 = null;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("componentContext");
        r10 = null;
    L14:
        String r11 = r10.getCurrentUserId();
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2 = this.a;
        if (r2 == null) goto L17;
        r0 = r2;
    L18:
        InitMinutesRecordingTask$execute$1 r1 = new InitMinutesRecordingTask$execute$1(r0.I());
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r1, "startRuntime");
        Object r3 = vub.a.a;
        monitor-enter(r3);
        long r4 = vub.a.b + 1;     // Catch: Throwable -> L24
        vub.a.b = r4;     // Catch: Throwable -> L24
        monitor-exit(r3);
        lvb.a.e("MmD1204RuntimeStartup", "[onUserScopeReady] user=" + vub.a.b(r11) + ", generation=" + r4);
        vub.a.a(r11, r4);
        return Observable.just(new j0c.c(b, true, "", 4));
    L24:
        th = move-exception;
        throw th;
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("componentContext");
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
