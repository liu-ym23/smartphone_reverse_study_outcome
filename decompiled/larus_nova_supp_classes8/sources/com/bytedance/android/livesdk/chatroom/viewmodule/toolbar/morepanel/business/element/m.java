package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMSharePostscriptConfig;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareTitleParams;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareTitleWithConListConfig;
import com.bytedance.android.livehostapi.business.shareinter.LivePaddingParams;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.u2;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ AudienceShareIMElement a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ ViewGroup d;

    public m(AudienceShareIMElement r1, Activity r2, ViewGroup r3, ViewGroup r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r11) {
        ShareParams r12 = (ShareParams) r11;
        if (r12 == null) goto L53;
        this.a.m = new HashMap(r12.getLiveCommonShareParams());
        ILiveShareService r0 = jc1.k.f(ILiveShareService.class);
        Object r3 = null;
        if (r0 == null) goto L18;
        AudienceShareIMElement r4 = this.a;
        Activity r5 = this.b;
        ViewGroup r6 = this.c;
        r4.getClass();
        LiveIMShareTitleWithConListConfig.Builder r7 = new LiveIMShareTitleWithConListConfig.Builder(r5);
        r7.setParent(r6);
        WeakReference<b2> r8 = r4.p.c();
        if (r8 == null) goto L12;
        b2 r9 = r8.get();
        if (r9 == null) goto L12;
        Fragment r10 = r9.W();
    L13:
        r7.setFragment(r10);
        r7.setSupportIM(true);
        r7.setSupportTitle(!((Boolean) r4.o.getValue()).booleanValue());
        if (((Boolean) r4.o.getValue()).booleanValue() == false) goto L16;
        r7.setContactListPaddingParams(new LivePaddingParams(10, 0, 6, 0));
    L16:
        r7.setSharePackage(r12);
        r7.setShareTitleParams(new LiveIMShareTitleParams.Builder().build());
        r7.setOnlyLightMode(true);
        r7.setListener(new i(r4, r6));
        r7.setShareCallback(new j(r4, r6));
        r0.addShareContactsListComponent(r7.build());
    L12:
        r10 = null;
    L18:
        if (((Boolean) u2.a.getValue()).booleanValue() == false) goto L22;
        Map<String, String> r1 = this.a.m;
        if (r1 == null) goto L22;
        r12.setLiveCommonShareParams(new HashMap(r1));
    L22:
        ILiveShareService r2 = jc1.k.f(ILiveShareService.class);
        if (r2 == null) goto L50;
        AudienceShareIMElement r13 = this.a;
        Activity r14 = this.b;
        ViewGroup r15 = this.d;
        View r16 = r13.g;
        LiveIMSharePostscriptConfig.Builder r17 = new LiveIMSharePostscriptConfig.Builder(r14);
        r17.setParent(r15);
        WeakReference<b2> r18 = r13.p.c();
        if (r18 == null) goto L29;
        b2 r19 = r18.get();
        if (r19 == null) goto L29;
        Fragment r20 = r19.W();
    L30:
        r17.setFragment(r20);
        r17.setSharePackage(r12);
        r17.setEnableBigFontMode(false);
        r17.setOnlyLightMode(true);
        r17.setPostscriptListener(new k(r13, r15, r16));
        ILiveIMSharePostscriptComponent r110 = r2.addSharePostscriptComponent(r17.build());
        if (r110 == null) goto L51;
        AudienceShareIMElement r21 = this.a;
        View r22 = r21.p.findView(2131389843);
        if (r22 == null) goto L35;
        r22.setOnClickListener(new f(r110));
    L35:
        WeakReference<b2> r23 = r21.p.c();
        if (r23 == null) goto L38;
        b2 r24 = r23.get();
    L40:
        if ((r24 instanceof Dialog) == false) goto L43;
        r3 = r24;
    L43:
        Dialog r25 = (Dialog) r3;
        if (r25 == null) goto L46;
        r25.setOnKeyListener(new g(r110));
    L46:
        View r26 = r21.h;
        if (r26 == null) goto L52;
        r26.setOnClickListener(new h(r110));
        return;
    L52:
        return;
    L38:
        r24 = null;
        goto L40
    L51:
        return;
    L29:
        r20 = null;
        goto L30
    L50:
        return;
    }
}
