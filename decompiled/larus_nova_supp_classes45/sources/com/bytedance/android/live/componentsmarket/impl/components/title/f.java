package com.bytedance.android.live.componentsmarket.impl.components.title;

import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSTitleIcon;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ TitleTetris a;

    public f(TitleTetris r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Boolean r7 = (Boolean) r6;
        TitleTetris r0 = this.a;
        ViewModel r1 = r0.p;
        if (r1 == null) goto L38;
        BaseTitleViewModel r2 = (BaseTitleViewModel) r1;
        if (r7.booleanValue() == false) goto L33;
        ALogger.d("TitleTetris", "isPrefixImgShow = true");
        SimpleDraweeView r8 = r0.C;
        if (r8 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r8);
    L9:
        LiveData<VSTitleIcon> r9 = r2.getLeftTitleIcon();
        ViewGroup.LayoutParams r3 = null;
        if (r9 == null) goto L12;
        VSTitleIcon r11 = (VSTitleIcon) r9.getValue();
    L14:
        if (r11 == null) goto L22;
        int r4 = r11.getSizeType();
        if (r4 != 1) goto L18;
        float r5 = UtilityKotlinExtentionsKt.h(82);
    L23:
        int r12 = (int) r5;
        SimpleDraweeView r13 = r0.C;
        if (r13 == null) goto L29;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L28;
        r14.width = r12;
        r14.height = UtilityKotlinExtentionsKt.i(42);
        Unit r15 = Unit.INSTANCE;
        r3 = r14;
    L28:
        r13.setLayoutParams(r3);
    L29:
        if (r11 == null) goto L39;
        py.k r16 = r11.getIcon();
        if (r16 == null) goto L40;
        ImageUtil.loadImage(r0.C, r16, 0);
        return;
    L40:
        return;
    L39:
        return;
    L18:
        if (r4 == 2) goto L20;
        r5 = UtilityKotlinExtentionsKt.h(82);
        goto L23
    L20:
        r5 = UtilityKotlinExtentionsKt.h(OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH);
        goto L23
    L22:
        r5 = UtilityKotlinExtentionsKt.h(82);
        goto L23
    L12:
        r11 = null;
        goto L14
    L33:
        ALogger.d("TitleTetris", "isPrefixImgShow = false");
        SimpleDraweeView r17 = r0.C;
        if (r17 == null) goto L42;
        UtilityKotlinExtentionsKt.t(r17);
        return;
    L42:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    }
}
