package com.bytedance.android.livesdk.interactivity.roomintro.view;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.LabelGroup;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.PoiInfo;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorLocationPoiInfo;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.roomintro.v2.c b;

    public m(FragmentActivity r1, com.bytedance.android.livesdk.interactivity.roomintro.v2.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r18) {
        Response r1 = (Response) r18;
        Unit r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r5 = (com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) ((BaseResponse) r1).data;
    L6:
        boolean r3 = false;
        if (r5 != null) goto L9;
        String r4 = rm3.c.a;
        rm3.c.f(this.a, 2131923023, false, 28);
        return;
    L9:
        RoomIntroDialogV2 r14 = new RoomIntroDialogV2();
        RoomIntroDataSource.a r6 = RoomIntroDataSource.x;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r7 = this.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "paramsV2");
        Intrinsics.checkNotNullParameter(r5, "data");
        List<LabelGroup> r8 = r5.f();
        if (r8 != null) goto L12;
        r8 = CollectionsKt.emptyList();
    L12:
        List<LabelGroup> r9 = r8;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L14:
        if (r11.hasNext() == false) goto L19;
        List<RoomIntroLabel> r13 = ((LabelGroup) r11.next()).getLabels();
        if (r13 != null) goto L18;
        r13 = CollectionsKt.emptyList();
    L18:
        CollectionsKt.addAll(r10, r13);
        goto L14
    L19:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r10.iterator();
    L21:
        if (r16.hasNext() == false) goto L25;
        Object r17 = r16.next();
        if (((RoomIntroLabel) r17).getSelected() == false) goto L21;
        r15.add(r17);
        goto L21
    L25:
        List r19 = CollectionsKt.toMutableList(r15);
        if (r19.size() <= 1) goto L28;
        CollectionsKt.sortWith(r19, new com.bytedance.android.livesdk.interactivity.roomintro.v2.a());
    L28:
        boolean r20 = RoomIntroDataSource.a.a();
        PoiInfo r21 = r5.g();
        if (r21 == null) goto L31;
        PropertyOwner r110 = new PropertyOwner(Boolean.valueOf(r21.getEnabled()));
        Unit r23 = Unit.INSTANCE;
        PropertyOwner r111 = null;
        PropertyOwner r112 = r110;
    L36:
        if (r23 != null) goto L52;
        AnchorLocationPoiInfo r24 = r5.a();
        if (r24 == null) goto L51;
        if (r20 == true) goto L42;
        r24 = null;
    L42:
        if (r24 == null) goto L51;
        gz.b r25 = new gz.b();
        r25.a = r24.getEnabled();
        String r113 = r24.getPoiIdStr();
        String r114 = BuildConfig.FLAVOR;
        if (r113 != null) goto L46;
        r113 = BuildConfig.FLAVOR;
    L46:
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r25.c = r113;
        String r26 = r24.getText();
        if (r26 == null) goto L50;
        r114 = r26;
    L50:
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r25.b = r114;
        Unit r27 = Unit.INSTANCE;
        PropertyOwner r28 = new PropertyOwner(r25);
        r2 = Unit.INSTANCE;
    L53:
        if (r2 == null) goto L55;
    L68:
        PropertyOwner r115 = r28;
    L69:
        r14.d = new RoomIntroDataSource(r7, r5, r9, r10, r5.d(), new PropertyOwner(r19), new PropertyOwner(Integer.valueOf(r19.size())), r112, r111, r115);
        FragmentManager r29 = this.a.getSupportFragmentManager();
        LandscapeRestrictionOperation r30 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "RoomIntroDialogV2", r30);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r29, r14, r30) == true) goto L87;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L73:
        r14.show(r29, "RoomIntroDialogV2");
        return;
    L87:
        return;
    L55:
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L59;
        g00.c r31 = (g00.c) com.bytedance.android.scope.m.e.d(f00.a.b, g00.c.class);
        if (r31 == null) goto L62;
        r3 = r31.hasPoiPermission();
    L62:
        if (r20 == false) goto L68;
        if (r3 == false) goto L68;
        gz.b r33 = new gz.b();
        gz.b r34 = r7.d;
        if (r34 == null) goto L67;
        r33.a = r34.a;
        String r35 = r34.c;
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        r33.c = r35;
        String r36 = r34.b;
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r33.b = r36;
    L67:
        Unit r37 = Unit.INSTANCE;
        r115 = new PropertyOwner(r33);
        goto L69
    L59:
        IBroadcastService r38 = jc1.k.f(IBroadcastService.class);
        if (r38 == null) goto L62;
        r3 = r38.hasPoiPermission();
    L51:
        r28 = null;
        goto L53
    L52:
        Unit r116 = r23;
        r28 = null;
        r2 = r116;
        goto L53
    L31:
        AppointmentInfo r39 = r5.b();
        if (r39 == null) goto L34;
        PropertyOwner r117 = new PropertyOwner(Boolean.valueOf(r39.getEnabled()));
        r23 = Unit.INSTANCE;
        r112 = null;
        r111 = r117;
        goto L36
    L34:
        r23 = null;
        r112 = null;
        r111 = null;
        goto L36
    L5:
        r5 = null;
        goto L6
    }
}
