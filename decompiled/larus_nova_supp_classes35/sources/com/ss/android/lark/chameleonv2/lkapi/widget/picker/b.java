package com.ss.android.lark.chameleonv2.lkapi.widget.picker;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$CameraDevice;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$MediaPickerShowOptions;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.widget.photopicker.s;
import itb.e;
import itb.g;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends AbsChameleonHandler<IWidget$MediaPickerShowOptions> {
    public Callback a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.b = LKAPIModules.Widget.ShowMediaPicker.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.b;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(IWidget$MediaPickerShowOptions r19, Callback r20) {
        final IWidget$MediaPickerShowOptions r2 = r19;
        Intrinsics.checkNotNullParameter(r2, "req");
        Intrinsics.checkNotNullParameter(r20, "callback");
        this.a = r20;
        e r3 = OfficeSDKManager.getHostGlobalService(e.class);
        boolean r4 = false;
        if (r3 == null) goto L61;
        IChameleonHandlerContext r5 = getContext();
        FragmentActivity r6 = null;
        if (r5 == null) goto L10;
        Fragment r7 = r5.getFragment();
        if (r7 == null) goto L10;
        FragmentActivity r8 = r7.getActivity();
    L12:
        if ((r8 instanceof FragmentActivity) == false) goto L14;
        r6 = r8;
    L14:
        if (r6 == null) goto L61;
        ArrayList<String> r9 = r2.getSourceType();
        if (r9 != null) goto L19;
    L26:
        boolean r10 = false;
    L27:
        ArrayList<String> r11 = r2.getMediaType();
        if (r11 == null) goto L30;
        boolean r12 = r11.contains("image");
    L31:
        if (r11 == null) goto L33;
        boolean r13 = r11.contains("video");
    L34:
        ArrayList<String> r14 = r2.getSizeType();
        if (r14 != null) goto L37;
        boolean r16 = false;
    L44:
        int r15 = r2.getMaxSelectedCount();
        Integer r17 = r2.getMaxDuration();
        if (r17 == null) goto L47;
        int r18 = r17.intValue() * 1000;
    L48:
        Boolean r21 = r2.isSaveToAlbum();
        if (r21 == null) goto L51;
        boolean r110 = r21.booleanValue();
    L53:
        if (r2.getCameraDevice() != IWidget$CameraDevice.Front) goto L55;
        boolean r111 = true;
    L56:
        g r22 = new g(r15, r12, r13, r18, r110, r16, r111);
        c r23 = new c(this);
        if (r10 == false) goto L59;
        boolean r24 = r3.M0(r6, r22, r23);
    L60:
        r4 = r24;
        goto L61
    L59:
        r24 = r3.f0(r6, r22, r23);
        goto L60
    L55:
        r111 = false;
        goto L56
    L51:
        r110 = false;
        goto L53
    L47:
        r18 = 60000;
        goto L48
    L37:
        if (r14.contains("original") == true) goto L39;
    L41:
        boolean r25 = false;
    L42:
        r16 = r25;
        goto L44
    L39:
        if (r14.contains("compressed") == true) goto L41;
        r25 = true;
        goto L42
    L33:
        r13 = false;
        goto L34
    L30:
        r12 = true;
        goto L31
    L19:
        if (r9.contains("camera") == true) goto L21;
    L23:
        boolean r26 = false;
    L24:
        if (r26 != true) goto L26;
        r10 = true;
        goto L27
    L21:
        if (r9.contains("album") == true) goto L23;
        r26 = true;
    L10:
        r8 = null;
    L61:
        if (r4 == true) goto L77;
        int r27 = s.C;
        com.ss.android.lark.widget.photopicker.e r28 = new com.ss.android.lark.widget.photopicker.e(s.b.a(new ShowMediaPickerHandler$handle$picker$1(r2)));
        IChameleonHandlerContext r29 = getContext();
        if (r29 == null) goto L73;
        Context r30 = r29.getCmlContext();
        if (r30 == null) goto L73;
        IChameleonHandlerContext r31 = getContext();
        if (r31 == null) goto L72;
        Fragment r32 = r31.getFragment();
        if (r32 == null) goto L72;
        r28.b(r30, r32, 97);
        return;
    L72:
        r20.error(new LKAPIError(-1, "fragment is null"));
        return;
    L73:
        r20.error(new LKAPIError(-1, "appContext is null"));
        return;
    }
}
