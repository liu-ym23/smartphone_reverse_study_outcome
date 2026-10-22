package com.bytedance.android.live.liveinteract.bgComponent.theme;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.android.livesdkapi.depend.model.live.audio.UploadFileResponse;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ File d;
    public final /* synthetic */ IThemeShowArea e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;
    public final /* synthetic */ String h;

    public r(j r1, String r2, PolarisFileWrapper r3, IThemeShowArea r4, int r5, long r6, String r8) {
        this.a = r1;
        this.b = true;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r8;
    }

    public final void accept(Object r22) {
        String r5 = ((UploadFileResponse) ((Response) r22).data).uri;
        if (r5 == null) goto L53;
        km3.g r0 = this.a.d;
        if (r0 != null) goto L7;
    L29:
        f2.b(2131916134, 0);
        if (this.b == false) goto L42;
        IVoiceLiveTheme r1 = vh7.f.c(IVoiceLiveTheme.class);
        r1.setLocalPath(this.c);
        r1.setImageType(1);
        r1.setBgStatus(1);
        r1.setImageUri(r5);
        if (this.a.y(this.d) == false) goto L39;
        IAnimatedBgInfo r4 = vh7.f.c(IAnimatedBgInfo.class);
        r4.setThemeShowArea(this.e);
        String r6 = this.d.getName();
        int r7 = StringsKt.lastIndexOf$default(r6, ".", 0, false, 6, null) + 1;
        if (r6 == null) goto L37;
        r4.setFileFormat(r6.substring(r7));
        py.k r8 = vh7.f.c(py.k.class);
        r8.setUri(r5);
        r4.setAnimatedBg(r8);
        r1.setAnimatedBgInfo(r4);
        r1.setFormatType(2);
        goto L39
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L39:
        if (this.a.x(this.d) == false) goto L41;
        r1.setFormatType(1);
    L41:
        r1.setBgType(this.f);
        this.a.c(r1, this.f);
    L42:
        WeakReference<ThemeUpLoadListener> r2 = this.a.g;
        if (r2 == null) goto L47;
        ThemeUpLoadListener r3 = r2.get();
        if (r3 == null) goto L47;
        r3.onUploaded();
    L47:
        long r9 = this.g;
        if (r9 == 0) goto L50;
        this.a.u(r9, r5, this.h, this.e, this.f, false);
        goto L53
    L50:
        ReadOnlyProperty r10 = vm2.d.C7;
        KProperty[] r11 = vm2.d.a;
        if (((List) r10.getValue(null, r11[441(0x1b9, float:6.18E-43)])).contains(String.valueOf(this.f)) == false) goto L53;
        ALogger.d("[VideoTalk]VoiceLiveThemeManager", "uploadFile success and preload preList:" + CollectionsKt.joinToString$default((List) r10.getValue(null, r11[441(0x1b9, float:6.18E-43)]), null, null, null, 0, null, null, 63, null) + " bgType:" + this.f);
        this.a.u(this.g, r5, this.h, this.e, this.f, true);
        goto L53
    L7:
        if (r0.isShowing() != true) goto L29;
        km3.g r12 = this.a.d;
        if (r12 == null) goto L28;
        Handler r13 = DialogLancet.resolveDialogHandler(r12);
        if (r13 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r12);
        r12.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L25:
        DialogLancet.afterDialogDismiss(r12);
        goto L28
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r12);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r14 == null) goto L25;
        com.bytedance.crash.d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L25
    L13:
        if (Looper.myLooper() == r13.getLooper()) goto L15;
        r13.post(DialogLancet.createDismissRunnable(r12));
    L28:
        this.a.d = null;
    L53:
        ALogger.d("[VideoTalk]VoiceLiveThemeManager", "uploadFile success roomId=" + this.g + " bgType:" + this.f);
    }
}
