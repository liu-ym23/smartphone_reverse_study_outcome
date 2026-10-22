package com.bytedance.android.live.lynx.open;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIImage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/lynx/open/OpenImage;", "Lcom/lynx/tasm/ui/image/UIImage;", "Lcom/lynx/tasm/ui/image/FrescoImageView;", "", "durationMs", "", "setFadeDuration", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenImage extends UIImage<FrescoImageView> {

    public static final class a {
    }

    static {
    }

    public OpenImage(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX INFO: renamed from: createView, reason: collision with other method in class */
    public final FrescoImageView m511createView(Context r2) {
        FrescoImageView r3 = super.createView(r2);
        r3.setFadeDuration(300);
        return r3;
    }

    @LynxProp(name = "fade-duration")
    public final void setFadeDuration(int r2) {
        if (getView() == null) goto L6;
        getView().setFadeDuration(r2);
        return;
    }

    public final void setSource(String r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(UriProtector.parse(r5));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        Uri r2 = (Uri) r1;
        if (r2 == null) goto L12;
        String r3 = r2.getScheme();
    L14:
        if (Intrinsics.areEqual(r3, "http") == true) goto L22;
        if (r2 == null) goto L17;
        String r4 = r2.getScheme();
    L19:
        if (Intrinsics.areEqual(r4, "https") == true) goto L22;
        boolean r6 = false;
    L23:
        if (r6 == false) goto L26;
        m7a.a r7 = new m7a.a(getSign(), "error");
        r7.a("errMsg", "WebImage is not allowed.");
        r7.a("errCode", 40001);
        getLynxContext().getEventEmitter().sendCustomEvent(r7);
        super.setSource(null);
        return;
    L26:
        super.setSource(r5);
        return;
    L17:
        r4 = null;
    L22:
        r6 = true;
        goto L23
    L12:
        r3 = null;
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final /* bridge */ /* synthetic */ View createView(Context r1) {
        return m511createView(r1);
    }
}
