package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.adapter.binding.SwitchSettingItemBinder;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/AnchorPublicScreenSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdkapi/interfaces/ListDialogAbility;", BuildConfig.FLAVOR, "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPublicScreenSettingDialog extends LiveDialogFragment implements ListDialogAbility {
    public static final /* synthetic */ int v = 0;
    public boolean d;
    public View e;
    public TextView f;
    public RecyclerView g;
    public TextView h;
    public RecyclerView i;
    public MultiTypeAdapter j;
    public MultiTypeAdapter k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public mx.j q;
    public Function1<? super ListDialogAbility, ? extends mx.j> r;
    public final String s;
    public final LiveMode t;
    public final Function0<Boolean> u;

    public static final class a {
    }

    static {
    }

    public final m22.a T90() {
        return (m22.a) this.m.getValue();
    }

    public final void jumpSubpage(int r1) {
    }

    public final MultiTypeAdapter listAdapter() {
        return null;
    }

    public final void refreshSettingItems() {
    }

    public final List<mx.a> U90() {
        ArrayList r0 = new ArrayList();
        mx.j r1 = this.q;
        if (r1 != null) goto L10;
        Function1<? super ListDialogAbility, ? extends mx.j> r2 = this.r;
        if (r2 == null) goto L9;
        r1 = (mx.j) r2.invoke(this);
        if (r1 == null) goto L9;
        this.q = r1;
    L9:
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        r0.add(r1);
    L13:
        if (((Boolean) this.u.invoke()).booleanValue() == false) goto L17;
        r0.add(T90());
        if (((mx.l) T90()).l == false) goto L17;
        r0.add((mx.g) this.n.getValue());
        r0.add((mx.g) this.o.getValue());
        r0.add((mx.g) this.p.getValue());
    L17:
        return r0;
    }

    public final void dismissDialog() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void S90(DialogInterface r13) {
        Intrinsics.checkNotNullParameter(r13, "dialog");
        super.onDismiss(r13);
        if (this.d == true) goto L35;
        boolean r14 = true;
        this.d = true;
        boolean r1 = ((mx.a) T90()).g;
        boolean r2 = ((mx.a) ((mx.g) this.n.getValue())).g;
        boolean r3 = ((mx.a) ((mx.g) this.o.getValue())).g;
        boolean r4 = ((mx.a) ((mx.g) this.p.getValue())).g;
        m22.b r0 = new m22.b(r1, r2, r3, r4);
        if (((mx.g) T90()).p != 1) goto L7;
        boolean r6 = true;
    L9:
        if (((mx.g) this.n.getValue()).p != 1) goto L11;
        boolean r8 = true;
    L13:
        if (((mx.g) this.o.getValue()).p != 1) goto L15;
        boolean r9 = true;
    L17:
        if (((mx.g) this.p.getValue()).p == 1) goto L20;
        r14 = false;
    L20:
        m22.b r5 = new m22.b(r6, r8, r9, r14);
        int r10 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;
        String r11 = this.s;
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r0, "oldSwitch");
        Intrinsics.checkNotNullParameter(r5, "newSwitch");
        HashMap r7 = new HashMap();
        r7.put("page_from", r11);
        r7.put("room_id", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a());
        r7.put("voice_recognition_before", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r1));
        r7.put("voice_recognition_after", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r6));
        r7.put("welcome_recognition_before", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r2));
        r7.put("welcome_recognition_after", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r8));
        r7.put("thank_recognition_before", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r3));
        r7.put("thank_recognition_after", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r9));
        r7.put("congrats_recognition_before", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r4));
        r7.put("congrats_recognition_after", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.c(r14));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_comment_setting_panel_setting_submit", r7, new Object[0]);
        if (((Boolean) this.u.invoke()).booleanValue() == false) goto L36;
        long r15 = 0;
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r16 == null) goto L29;
        com.bytedance.live.datacontext.m r17 = r16.getRoom();
        if (r17 == null) goto L29;
        Room r18 = (Room) r17.getValue();
        if (r18 == null) goto L29;
        r15 = r18.id;
    L29:
        long r19 = r15;
        if (((mx.l) T90()).l == false) goto L32;
        int r20 = 55;
    L33:
        com.bytedance.android.livesdk.chatroom.model.b r110 = new com.bytedance.android.livesdk.chatroom.model.b();
        r110.status = ((mx.g) T90()).p;
        r110.switchWelcome = ((mx.g) this.n.getValue()).p;
        r110.switchThanks = ((mx.g) this.o.getValue()).p;
        r110.switchCongrats = ((mx.g) this.p.getValue()).p;
        String r21 = GsonProtectorUtils.toJson(GsonHelper.get(), r110);
        ((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class)).updateAudioChatSwitch(r19, r20, 0, r21).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.interactivity.api.anchorsetting.a(r21, r110), b.a);
        return;
    L32:
        r20 = 56;
        goto L33
    L36:
        return;
    L15:
        r9 = false;
        goto L17
    L11:
        r8 = false;
        goto L13
    L7:
        r6 = false;
        goto L9
    }

    public final void V90(FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r3, "fm");
        ALogger.i("AnchorPublicScreenSettingDialog", "open. source=" + this.s);
    L13:
        e = move-exception;
        SafetyGuard.a("open AnchorPublicScreenSettingDialog failed", e, null);
        return;
    L4:
        if (r3.isDestroyed() == false) goto L6;
        return;
    L6:
        if (r3.isStateSaved() == true) goto L22;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "AnchorPublicScreenSettingDialog", r0);     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        show(r3, "AnchorPublicScreenSettingDialog");     // Catch: Exception -> L13
        return;
    L23:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954585);
        setShouldUseNewPanel(true);
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        View r10 = this.e;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        a1.k(r10, UtilityKotlinExtentionsKt.i(484));
        Context r11 = r8.getContext();
        ArrayList r0 = new ArrayList();
        LiveMode r1 = this.t;
        int r2 = PublicScreenStyleHelper.a;
        if (r1 == LiveMode.VIDEO) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L13;
        r0.add((mx.j) this.l.getValue());
    L13:
        RecyclerView r4 = this.g;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rvBasicSettings");
    L16:
        r4.setLayoutManager(new LinearLayoutManager(r11, 1, false));
        MultiTypeAdapter r13 = new MultiTypeAdapter();
        mx.k r5 = new mx.k(false);
        AnchorPublicScreenSettingDialog$getSimpleSettingItemBinder$1$1 r6 = AnchorPublicScreenSettingDialog$getSimpleSettingItemBinder$1$1.INSTANCE;
        r5.b = r6;
        r13.z2(mx.j.class, r5);
        Unit r7 = Unit.INSTANCE;
        this.j = r13;
        r13.a = r0;
        RecyclerView r14 = this.g;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rvBasicSettings");
    L19:
        MultiTypeAdapter r15 = this.j;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("basicSettingsAdapter");
    L22:
        r14.setAdapter(r15);
        if (r0.isEmpty() == false) goto L31;
        TextView r16 = this.f;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("basicSettingTitle");
    L27:
        UtilityKotlinExtentionsKt.t(r16);
        RecyclerView r17 = this.g;
        if (r17 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rvBasicSettings");
    L30:
        UtilityKotlinExtentionsKt.t(r17);
    L38:
        Context r18 = r8.getContext();
        List<mx.a> r19 = U90();
        RecyclerView r20 = this.i;
        if (r20 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("rvInterActivitySettings");
    L41:
        r20.setLayoutManager(new LinearLayoutManager(r18, 1, false));
        MultiTypeAdapter r21 = new MultiTypeAdapter();
        mx.k r23 = new mx.k(false);
        r23.b = r6;
        r21.z2(mx.j.class, r23);
        SwitchSettingItemBinder r24 = new SwitchSettingItemBinder(false);
        r24.b = AnchorPublicScreenSettingDialog$getSwitchSettingItemBinder$1$1.INSTANCE;
        r21.z2(mx.l.class, r24);
        this.k = r21;
        r21.a = r19;
        RecyclerView r25 = this.i;
        if (r25 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("rvInterActivitySettings");
    L44:
        MultiTypeAdapter r26 = this.k;
        if (r26 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("interactivitySettingsAdapter");
    L47:
        r25.setAdapter(r26);
        RecyclerView r27 = this.i;
        if (r27 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("rvInterActivitySettings");
    L50:
        DividerItemDecoration r28 = new DividerItemDecoration(r18, 1);
        GradientDrawable r29 = new GradientDrawable();
        r29.setColor(s1.h(2131107287));
        r29.setSize(0, UtilityKotlinExtentionsKt.i(1));
        r28.setDrawable(r29);
        r27.addItemDecoration(r28);
        if (((ArrayList) r19).isEmpty() == false) goto L59;
        TextView r30 = this.h;
        if (r30 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("interactivitySettingsTitle");
    L55:
        UtilityKotlinExtentionsKt.t(r30);
        RecyclerView r31 = this.i;
        if (r31 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("rvInterActivitySettings");
    L58:
        UtilityKotlinExtentionsKt.t(r31);
    L66:
        int r33 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;
        String r34 = this.s;
        Intrinsics.checkNotNullParameter(r34, "source");
        HashMap r35 = new HashMap();
        r35.put("page_from", r34);
        r35.put("room_id", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_comment_setting_panel_show", r35, new Object[0]);
        this.d = false;
        return;
    L59:
        TextView r36 = this.h;
        if (r36 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("interactivitySettingsTitle");
    L62:
        UtilityKotlinExtentionsKt.w(r36);
        RecyclerView r37 = this.i;
        if (r37 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("rvInterActivitySettings");
    L65:
        UtilityKotlinExtentionsKt.w(r37);
        goto L66
    L31:
        TextView r38 = this.f;
        if (r38 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("basicSettingTitle");
    L34:
        UtilityKotlinExtentionsKt.w(r38);
        RecyclerView r39 = this.g;
        if (r39 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("rvBasicSettings");
    L37:
        UtilityKotlinExtentionsKt.w(r39);
        goto L38
    L8:
        if (PublicScreenStyleHelper.b().c() == false) goto L10;
        r3 = true;
        goto L11
    }

    public AnchorPublicScreenSettingDialog(String r2, LiveMode r3, Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r4, "supportAsr");
        this.s = r2;
        this.t = r3;
        this.u = r4;
        this.l = LazyKt.lazy(new AnchorPublicScreenSettingDialog$heightAndTextSizeSettingItem$2(this));
        this.m = LazyKt.lazy(new AnchorPublicScreenSettingDialog$anchorAsrSetting$2(this));
        this.n = LazyKt.lazy(AnchorPublicScreenSettingDialog$asrWelcomeSetting$2.INSTANCE);
        this.o = LazyKt.lazy(AnchorPublicScreenSettingDialog$asrThanksSetting$2.INSTANCE);
        this.p = LazyKt.lazy(AnchorPublicScreenSettingDialog$asrCongratsSetting$2.INSTANCE);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565144, r3, false);
        this.e = r5;
        this.f = (TextView) r5.findViewById(2131364007);
        this.g = r5.findViewById(2131384918);
        this.h = (TextView) r5.findViewById(2131375555);
        this.i = r5.findViewById(2131384967);
        return r5;
    }
}
