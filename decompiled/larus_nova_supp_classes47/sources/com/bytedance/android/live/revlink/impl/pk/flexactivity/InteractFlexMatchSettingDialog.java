package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.presenter.k;
import com.bytedance.android.livesdk.link.model.IBattlePrecisionMatcher;
import com.bytedance.android.livesdk.link.model.d2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/InteractFlexMatchSettingDialog;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/RevInteractDialogFragmentBaseContract$View;", "", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractFlexMatchSettingDialog extends RevInteractDialogFragmentBaseContract$View<Object> {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> g;
    public String h;
    public d2 i;
    public k j;
    public final long k;
    public final w0 l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return 154.0f;
    }

    public InteractFlexMatchSettingDialog() {
        this.g = new LinkedHashMap();
        this.h = "";
        this.k = 1;
        this.l = new w0(new InteractFlexMatchSettingDialog$mListener$1(this), 500);
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = r0.getString(2131917819);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567411, null);
        if (r0 == null) goto L7;
        return (ViewGroup) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.g.clear();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        ca0("3");
    }

    public final View ba0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void ca0(String r10) {
        HashMap r0 = new HashMap();
        d2 r1 = this.i;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("battlePrecisionMatch");
    L5:
        Iterator r2 = r1.getMatcherList().iterator();
    L6:
        boolean r4 = true;
        String r5 = null;
        if (r2.hasNext() == false) goto L23;
        IBattlePrecisionMatcher r3 = (IBattlePrecisionMatcher) r2.next();
        String r6 = r3.getUserId();
        yz0.k r7 = (yz0.k) f.d(j.C0.a(), yz0.k.class);
        if (r7 == null) goto L15;
        IRoom r8 = r7.getRoom();
        if (r8 == null) goto L15;
        IBaseUser r9 = r8.getOwner();
        if (r9 == null) goto L15;
        String r12 = iz.a.a(r9);
    L17:
        if ((!Intrinsics.areEqual(r6, r12)) == false) goto L6;
        String r13 = r3.getUserId();
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r0.put("inviter_id", r13);
    L15:
        r12 = null;
    L23:
        d2 r14 = this.i;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("battlePrecisionMatch");
    L26:
        if (r14 == null) goto L37;
        String r15 = r14.getActivityId();
        if (r15 == null) goto L37;
        if (r15.length() > 0) goto L33;
        r4 = false;
    L33:
        if (r4 == false) goto L35;
        r5 = r15;
    L35:
        if (r5 == null) goto L37;
        r0.put("invitee_list", "flex_activity");
        r0.put("flex_activity_id", r5);
        r0.put("activity_id", r5);
        r0.put("panel_select", r10);
    L37:
        n r16 = new n();
        Map<String, String> r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r17.putAll(r0);
        m r18 = new m();
        r18.b(LogCommon.PAGE_SOURCE_LOG);
        r18.b(LogCommon.ROOM);
        ((ArrayList) r16.b).addAll(r18.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r20);
        ((i) ((f80.a) r20)).w3("livesdk_pk_disturb_settings_panel_click", r16.a, r16.b);
    }

    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super.onViewCreated(r18, r19);
        ((TextView) ba0(2131385976)).setOnClickListener(this.l);
        ((LinearLayout) ba0(2131385975)).setOnClickListener(this.l);
        String r2 = this.h;
        if (r2 != null) goto L5;
    L13:
        HashMap r1 = new HashMap();
        d2 r3 = this.i;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("battlePrecisionMatch");
    L16:
        Iterator r4 = r3.getMatcherList().iterator();
    L17:
        String r9 = "";
        if (r4.hasNext() == false) goto L34;
        IBattlePrecisionMatcher r7 = (IBattlePrecisionMatcher) r4.next();
        String r10 = r7.getUserId();
        yz0.k r12 = (yz0.k) f.d(j.C0.a(), yz0.k.class);
        if (r12 == null) goto L26;
        IRoom r13 = r12.getRoom();
        if (r13 == null) goto L26;
        IBaseUser r14 = r13.getOwner();
        if (r14 == null) goto L26;
        String r15 = iz.a.a(r14);
    L28:
        if ((!Intrinsics.areEqual(r10, r15)) == false) goto L17;
        String r5 = r7.getUserId();
        if (r5 != null) goto L33;
        r5 = "";
    L33:
        r1.put("inviter_id", r5);
    L26:
        r15 = null;
    L34:
        d2 r6 = this.i;
        if (r6 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("battlePrecisionMatch");
    L38:
        if (r6 == null) goto L50;
        String r8 = r6.getActivityId();
        if (r8 == null) goto L50;
        if (r8.length() <= 0) goto L44;
        boolean r16 = true;
    L45:
        if (r16 == true) goto L48;
        r8 = null;
    L48:
        if (r8 == null) goto L50;
        r1.put("invitee_list", "flex_activity");
        r1.put("flex_activity_id", r8);
        r1.put("activity_id", r8);
        goto L50
    L44:
        r16 = false;
    L50:
        n r17 = new n();
        Map<String, String> r110 = r17.a;
        Intrinsics.checkNotNullParameter(r110, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r110.putAll(r1);
        m r20 = new m();
        r20.b(LogCommon.PAGE_SOURCE_LOG);
        r20.b(LogCommon.ROOM);
        ((ArrayList) r17.b).addAll(r20.a);
        cy0.e.a.getClass();
        cy0.j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r23);
        ((i) ((f80.a) r23)).w3("livesdk_pk_disturb_settings_click", r17.a, r17.b);
        HashMap r24 = new HashMap();
        d2 r25 = this.i;
        if (r25 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("battlePrecisionMatch");
    L53:
        Iterator r26 = r25.getMatcherList().iterator();
    L55:
        if (r26.hasNext() == false) goto L70;
        IBattlePrecisionMatcher r111 = (IBattlePrecisionMatcher) r26.next();
        String r112 = r111.getUserId();
        yz0.k r27 = (yz0.k) f.d(j.C0.a(), yz0.k.class);
        if (r27 == null) goto L63;
        IRoom r28 = r27.getRoom();
        if (r28 == null) goto L63;
        IBaseUser r29 = r28.getOwner();
        if (r29 == null) goto L63;
        String r30 = iz.a.a(r29);
    L65:
        if ((!Intrinsics.areEqual(r112, r30)) == false) goto L55;
        String r32 = r111.getUserId();
        if (r32 == null) goto L69;
        r9 = r32;
    L69:
        r24.put("inviter_id", r9);
    L63:
        r30 = null;
    L70:
        d2 r33 = this.i;
        if (r33 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("battlePrecisionMatch");
    L73:
        if (r33 == null) goto L85;
        String r34 = r33.getActivityId();
        if (r34 == null) goto L85;
        if (r34.length() <= 0) goto L79;
        boolean r35 = true;
    L80:
        if (r35 == false) goto L82;
        String r36 = r34;
    L83:
        if (r36 == null) goto L85;
        r24.put("invitee_list", "flex_activity");
        r24.put("flex_activity_id", r36);
        r24.put("activity_id", r36);
        goto L85
    L82:
        r36 = null;
        goto L83
    L79:
        r35 = false;
    L85:
        n r37 = new n();
        Map<String, String> r38 = r37.a;
        Intrinsics.checkNotNullParameter(r38, "map");
        Intrinsics.checkNotNullParameter(r24, "map");
        r38.putAll(r24);
        m r39 = new m();
        r39.b(LogCommon.PAGE_SOURCE_LOG);
        r39.b(LogCommon.ROOM);
        ((ArrayList) r37.b).addAll(r39.a);
        cy0.e.a.getClass();
        cy0.j r40 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r42 = com.bytedance.android.scope.m.b(r40).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r42);
        ((i) ((f80.a) r42)).w3("livesdk_pk_disturb_settings_panel_show", r37.a, r37.b);
        return;
    L5:
        if (r2.length() <= 0) goto L7;
        boolean r43 = true;
    L8:
        if (r43 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        ((TextView) ba0(2131385976)).setText(r2);
        goto L13
    L7:
        r43 = false;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566203, r3, false);
    }
}
