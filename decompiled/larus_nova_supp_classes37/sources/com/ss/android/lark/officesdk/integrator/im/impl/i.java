package com.ss.android.lark.officesdk.integrator.im.impl;

import android.app.Activity;
import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.utils.DownloadAuthorizationEventType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.OpenFeishuMediaSecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class i implements kza.a {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GalleryType.Image.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements AuthorizationServiceV2.b {
        public final /* synthetic */ Function1<kza.s, Unit> a;

        public b(Function1<? super kza.s, Unit> r1) {
            this.a = r1;
        }

        public final void a(ValidateResult r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            this.a.invoke(new kza.s(owa.a.c().isAuthorizationPassed(r4)));
        }
    }

    @Inject
    public i() {
    }

    public final void E1(Context r16, kza.o r17, OpenFeishuMediaSecurityAction r18, Function1<? super kza.s, Unit> r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "securityContext");
        Intrinsics.checkNotNullParameter(r18, "action");
        Intrinsics.checkNotNullParameter(r19, "callback");
        kza.t r3 = r17.g;
        if (r3 != null) goto L6;
        r19.invoke(new kza.s(true));
        return;
    L6:
        kza.q r5 = r3.b;
        if (r5 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        if (r7 == true) goto L15;
        r19.invoke(new kza.s(true));
        return;
    L15:
        kza.r r4 = r3.a;
        if (r17.b == false) goto L50;
        if (r17.c == true) goto L50;
        if (r17.d == true) goto L50;
        if (r17.e == true) goto L50;
        if (r18 != OpenFeishuMediaSecurityAction.SHARE) goto L28;
        r19.invoke(new kza.s(true));
        return;
    L28:
        GalleryType r0 = r4.a;
        int[] r1 = a.a;
        int r2 = r1[r0.ordinal()];
        if (r2 == 1) goto L34;
        if (r2 != 2) goto L33;
        DownloadAuthorizationEventType r6 = DownloadAuthorizationEventType.IMAGE_DOWNLOAD;
    L35:
        DownloadAuthorizationEventType r8 = r6;
        int r9 = r1[r4.a.ordinal()];
        if (r9 == 1) goto L41;
        if (r9 != 2) goto L40;
        int r10 = 2131890280;
    L42:
        AuthorizationServiceV2 r11 = owa.a.c();
        String r12 = r5.a;
        if (r12 != null) goto L45;
        r12 = r5.b;
    L45:
        if (r12 != null) goto L47;
        r12 = "";
    L47:
        String r13 = r12;
        r11.g(r8, r13, r5.b, r4.c, r4.b, r5.c, r5.d, r16, Integer.valueOf(r10), new b(r19));
        return;
    L40:
        throw new NoWhenBranchMatchedException();
    L41:
        r10 = 2131890281;
        goto L42
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        r6 = DownloadAuthorizationEventType.VIDEO_DOWNLOAD;
    L50:
        if (r18 == OpenFeishuMediaSecurityAction.SAVE) goto L53;
        UDToast.show(r16, 2131891408);
    L56:
        r19.invoke(new kza.s(false));
        return;
    L53:
        if ((r16 instanceof Activity) == false) goto L55;
        new UDDialogBuilder(r16).title(2131890734).message(2131891039).addActionButton(2131391777, 2131890808, null).show();
        goto L56
    L55:
        UDToast.show(r16, 2131891039);
        goto L56
    L9:
        if (r5.e != true) goto L11;
        r7 = true;
        goto L12
    }
}
