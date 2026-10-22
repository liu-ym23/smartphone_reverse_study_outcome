package com.bytedance.android.live.profile;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSetting;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.base.model.user.ProfileStyleTemplate;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel.ProfileSettingListView;
import com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel.SwitchButton;
import com.bytedance.android.live.profile.ui.util.s;
import com.bytedance.android.live.profile.ui.util.v;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profile/ProfileEcomSetDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileEcomSetDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int n = 0;
    public DataCenter d;
    public NewProfileUser e;
    public View f;
    public HSImageView g;
    public TextView h;
    public ProfileSettingListView i;
    public ImageView j;
    public SwitchButton k;
    public boolean l;
    public long m;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ProfileEcomSetDialogFragment a;

        public b(ProfileEcomSetDialogFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageView r1 = this.a.j;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            v.a r0 = v.b;     // Catch: Throwable -> L6
            ViewGroup r2 = UtilityKotlinExtentionsKt.p(r1);     // Catch: Throwable -> L6
            r0.getClass();     // Catch: Throwable -> L6
            Intrinsics.checkNotNullParameter(r1, "$this$addTouchDelegateToAncestor");     // Catch: Throwable -> L6
            v.a.a(r1, r2, UtilityKotlinExtentionsKt.i(4), UtilityKotlinExtentionsKt.i(4), UtilityKotlinExtentionsKt.i(4), UtilityKotlinExtentionsKt.i(4));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final class c implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ProfileEcomSetDialogFragment$onCreateView$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass1(ProfileEcomSetDialogFragment r8) {
            super(1, r8, ProfileEcomSetDialogFragment.class, "onSettingItemClick", "onSettingItemClick(J)V", 0);
        }

        public final void invoke(long r10) {
            ProfileEcomSetDialogFragment r0 = (ProfileEcomSetDialogFragment) ((CallableReference) this).receiver;
            int r1 = ProfileEcomSetDialogFragment.n;
            r0.getClass();
            ALogger.i("ProfileEcomSetDialogFragment", "onSettingItemClick: " + r10 + ", isSmartSwitch: " + r0.l);
            r0.m = r10;
            r0.S90(r10);
            if (r0.l == false) goto L8;
            r0.l = false;
            SwitchButton r2 = r0.k;
            if (r2 == null) goto L7;
            r2.setState(false);
        L7:
            r0.U90(r10, 1, 0);
        L10:
            if (r10 != ProfileStyleTemplate.TEMPLATE_LOCAL_LIFE) goto L13;
            String r3 = "3";
        L16:
            j0.l().sendLog("livesdk_showcase_choose_click", MapsKt.mapOf(TuplesKt.to("status_type", r3)), new Object[]{IRoom.class});
            HashMap<String, String> r4 = s.a(r0.d);
            if (r10 != ProfileStyleTemplate.TEMPLATE_LOCAL_LIFE) goto L20;
            String r12 = "展示团购";
        L37:
            r4.put("click_area", r12);
            j0.l().sendLog("livesdk_personal_card_setting_click", r4, new Object[0]);
            return;
        L20:
            if (r10 == ProfileStyleTemplate.TEMPLATE_HONOUR) goto L36;
            NewProfileUser r13 = r0.e;
            if (r13 == null) goto L29;
            EcomInfo r14 = r13.ecomInfo;
            if (r14 == null) goto L29;
            if (r14.getEcomType() != EcomInfo.ECOM_TYPE_WINDOW) goto L29;
            r12 = "展示橱窗";
        L29:
            NewProfileUser r15 = r0.e;
            if (r15 == null) goto L36;
            EcomInfo r16 = r15.ecomInfo;
            if (r16 == null) goto L36;
            if (r16.getEcomType() != EcomInfo.ECOM_TYPE_SHOP) goto L36;
            r12 = "展示店铺";
        L36:
            r12 = "展示直播荣誉";
            goto L37
        L13:
            if (r10 != ProfileStyleTemplate.TEMPLATE_ECOM) goto L15;
            r3 = "2";
            goto L16
        L15:
            r3 = DataType.TRUE;
            goto L16
        L8:
            r0.U90(r10, 0, 0);
            goto L10
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3) {
            invoke(((Number) r3).longValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ProfileEcomSetDialogFragment$onCreateView$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<View, Unit> {
        public AnonymousClass2(ProfileEcomSetDialogFragment r8) {
            super(1, r8, ProfileEcomSetDialogFragment.class, "onSmartSwitchDescIconClick", "onSmartSwitchDescIconClick(Landroid/view/View;)V", 0);
        }

        public final void invoke(View r4) {
            ProfileEcomSetDialogFragment r0 = (ProfileEcomSetDialogFragment) ((CallableReference) this).receiver;
            int r1 = ProfileEcomSetDialogFragment.n;
            r0.getClass();
            ALogger.i("ProfileEcomSetDialogFragment", "onSmartSwitchDescIconClick");
            if (r4 == null) goto L6;
            r4.post(new i(r0, r4));
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((View) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ProfileEcomSetDialogFragment$onCreateView$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass4(ProfileEcomSetDialogFragment r8) {
            super(1, r8, ProfileEcomSetDialogFragment.class, "onSmartSwitchButtonClick", "onSmartSwitchButtonClick(Z)V", 0);
        }

        public final void invoke(boolean r12) {
            ProfileEcomSetDialogFragment r1 = (ProfileEcomSetDialogFragment) ((CallableReference) this).receiver;
            int r0 = ProfileEcomSetDialogFragment.n;
            r1.getClass();
            ALogger.i("ProfileEcomSetDialogFragment", "onSmartSwitchButtonClick: " + r12);
            r1.l = r12;
            if (r12 == true) goto L5;
            r1.U90(r1.m, 1, 0);
        L33:
            if (r12 == false) goto L35;
            String r13 = "on";
        L36:
            j0.l().sendLog("livesdk_showcase_auto_choose_click", MapsKt.mapOf(TuplesKt.to("status", r13)), new Object[]{IRoom.class});
            return;
        L35:
            r13 = "off";
            goto L36
        L5:
            if (y3.m(r1.d).n(ToolbarButton.COMMERCE) == false) goto L8;
            long r2 = ProfileStyleTemplate.TEMPLATE_ECOM;
        L28:
            r1.m = r2;
            r1.S90(r2);
            ProfileSettingListView r3 = r1.i;
            if (r3 == null) goto L31;
            r3.setItemChecked(r1.m);
        L31:
            r1.U90(r1.m, 1, 1);
            goto L33
        L8:
            if (y3.m(r1.d).n(ToolbarButton.GROUP_PURCHASE) == false) goto L27;
            NewProfileUser r4 = r1.e;
            if (r4 == null) goto L24;
            ProfileSetting r5 = r4.profileSetting;
            if (r5 == null) goto L24;
            List r6 = r5.getStyleTemplates();
            if (r6 == null) goto L24;
            Iterator r7 = r6.iterator();
        L17:
            if (r7.hasNext() == false) goto L24;
            ProfileStyleTemplate r8 = (ProfileStyleTemplate) r7.next();
            if (r8 == null) goto L17;
            if (r8.getTemplateId() != ProfileStyleTemplate.TEMPLATE_LOCAL_LIFE) goto L17;
            ALogger.i("ProfileEcomSetDialogFragment", "hasGroupPurchaseTemplate: true");
            boolean r9 = true;
        L25:
            if (r9 == false) goto L27;
            r2 = ProfileStyleTemplate.TEMPLATE_LOCAL_LIFE;
        L24:
            ALogger.i("ProfileEcomSetDialogFragment", "hasGroupPurchaseTemplate: false");
            r9 = false;
        L27:
            r2 = ProfileStyleTemplate.TEMPLATE_HONOUR;
            goto L28
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public ProfileEcomSetDialogFragment() {
    }

    public final void S90(long r7) {
        ALogger.i("ProfileEcomSetDialogFragment", "changeModeTo: " + r7);
        NewProfileUser r0 = this.e;
        if (r0 == null) goto L20;
        ProfileSetting r1 = r0.profileSetting;
        if (r1 == null) goto L20;
        List r2 = r1.getStyleTemplates();
        if (r2 == null) goto L20;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        ProfileStyleTemplate r4 = (ProfileStyleTemplate) r3.next();
        if (r4 == null) goto L10;
        if (r4.getTemplateId() != r7) goto L10;
        ImageLoader.bindImage(this.g, r4.getTemplateUrl());
        TextView r8 = this.h;
        if (r8 == null) goto L28;
        r8.setText(r4.getTemplateDescription());
        return;
    L28:
        return;
    L20:
        ALogger.e("ProfileEcomSetDialogFragment", "error: don't find templateId in styleTemplates");
    }

    public final void T90(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onDismiss(r2);
        ALogger.i("ProfileEcomSetDialogFragment", "showAnchorProfile on dismiss");
        DataCenter r3 = this.d;
        if (r3 == null) goto L12;
        IRoom r4 = (IRoom) r3.get("data_room");
        if (r4 == null) goto L13;
        IBaseUser r5 = r4.getOwner();
        if (r5 == null) goto L14;
        UserProfileEvent r0 = new UserProfileEvent(r5.getIdString());
        r0.mSource = "livestore_setting";
        r0.setClickUserPosition("live_open_top_left_anchor");
        r0.setReportType("data_card_anchor");
        xs2.b.a().post(r0);
        os0.b.b(this.d).userInfoAutoAntiDeterioration();
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (isVertical() == false) goto L5;
        int r3 = 2131954579;
    L6:
        setStyle(1, r3);
        return;
    L5:
        r3 = 2131954852;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        T90(r2);     // Catch: Throwable -> L5
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

    public final void U90(long r12, long r14, long r16) {
        ALogger.i("ProfileEcomSetDialogFragment", "reportModeChange, checkProfileStyle: " + r12 + ", hasProfileStyleSmartSwitch: " + r14 + ", profileStyleSmartSwitch: " + r16);
        xs2.b r0 = xs2.b.a();
        NewProfileUser r2 = this.e;
        if (r2 == null) goto L7;
        BaseProfileInfo r3 = r2.baseProfileInfo;
        if (r3 == null) goto L7;
        String r4 = r3.getIdStr();
    L8:
        r0.post(new v2(String.valueOf(r4), r12, r14, r16));
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r12 = r8.inflate(2131565603, r9, false);
        this.f = r12;
        SwitchButton r13 = null;
        if (r12 == null) goto L5;
        HSImageView r14 = (HSImageView) r12.findViewById(2131376511);
    L6:
        this.g = r14;
        View r15 = this.f;
        if (r15 == null) goto L9;
        TextView r16 = (TextView) r15.findViewById(2131383254);
    L10:
        this.h = r16;
        View r17 = this.f;
        if (r17 == null) goto L13;
        ProfileSettingListView r18 = (ProfileSettingListView) r17.findViewById(2131386008);
    L14:
        this.i = r18;
        if (r18 == null) goto L17;
        r18.setItemClickListener(new AnonymousClass1(this));
    L17:
        View r19 = this.f;
        if (r19 == null) goto L20;
        ImageView r20 = (ImageView) r19.findViewById(2131386956);
    L21:
        this.j = r20;
        if (r20 == null) goto L24;
        r20.setOnClickListener(new c(new AnonymousClass2(this)));
    L24:
        ImageView r22 = this.j;
        if (r22 == null) goto L27;
        r22.post(new b(this));
    L27:
        View r23 = this.f;
        if (r23 == null) goto L30;
        r13 = (SwitchButton) r23.findViewById(2131387878);
    L30:
        this.k = r13;
        if (r13 == null) goto L33;
        r13.setSwitchListener(new AnonymousClass4(this));
    L33:
        NewProfileUser r24 = this.e;
        if (r24 == null) goto L38;
        ProfileStyleParams r25 = r24.getProfileStyleParams();
        if (r25 == null) goto L38;
        boolean r26 = r25.isSmartSwitch();
    L39:
        this.l = r26;
        SwitchButton r27 = this.k;
        if (r27 == null) goto L42;
        r27.c = r26;
        r27.a(r26);
        r27.b(r26, false);
    L42:
        NewProfileUser r28 = this.e;
        if (r28 == null) goto L47;
        ProfileStyleParams r29 = r28.getProfileStyleParams();
        if (r29 == null) goto L47;
        long r30 = r29.getProfileStyle();
    L48:
        this.m = r30;
        NewProfileUser r32 = this.e;
        if (r32 == null) goto L79;
        ProfileSetting r33 = r32.profileSetting;
        if (r33 == null) goto L79;
        List r34 = r33.getStyleTemplates();
        if (r34 == null) goto L79;
        Iterator r35 = r34.iterator();
    L56:
        if (r35.hasNext() == false) goto L79;
        ProfileStyleTemplate r110 = (ProfileStyleTemplate) r35.next();
        if (r110 == null) goto L56;
        ALogger.i("ProfileEcomSetDialogFragment", "create item, id: " + r110.getTemplateId() + ", name: " + r110.getTemplateName());
        String r5 = "";
        if (r110.getTemplateId() == this.m) goto L62;
        ProfileSettingListView r1 = this.i;
        if (r1 == null) goto L56;
        long r2 = r110.getTemplateId();
        String r111 = r110.getTemplateName();
        if (r111 == null) goto L78;
        r5 = r111;
    L78:
        r1.createItem(r2, r5, false);
        goto L56
    L62:
        ImageLoader.bindImage(this.g, r110.getTemplateUrl());
        TextView r3 = this.h;
        if (r3 == null) goto L65;
        r3.setText(r110.getTemplateDescription());
    L65:
        ProfileSettingListView r4 = this.i;
        if (r4 == null) goto L56;
        long r6 = r110.getTemplateId();
        String r112 = r110.getTemplateName();
        if (r112 == null) goto L71;
        r5 = r112;
    L71:
        r4.createItem(r6, r5, true);
    L79:
        ProfileSettingListView r36 = this.i;
        if (r36 == null) goto L82;
        r36.layout();
    L82:
        j0.l().sendLog("livesdk_personal_card_setting_show", s.a(this.d), new Object[0]);
        ALogger.i("ProfileEcomSetDialogFragment", "init state, isSmartSwitch: " + this.l + ", checkedType: " + this.m);
        return this.f;
    L47:
        r30 = 0;
    L38:
        r26 = false;
        goto L39
    L20:
        r20 = null;
        goto L21
    L13:
        r18 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }
}
