package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.p;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import st0.g;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\u000e\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001a\u00108\u001a\u00020\u001a8\u0006X\u0086D¢\u0006\f\n\u0004\b6\u0010\u001c\u001a\u0004\b7\u0010\u001eR\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0005098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileAnnounceView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/g;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getAnnounceDescView", "()Landroid/widget/TextView;", "announceDescView", "b", "getAnnounceActionView", "announceActionView", "", "c", "Z", "getCanClick", "()Z", "setCanClick", "(Z)V", "canClick", "", "d", "Ljava/lang/String;", "getEnterFromMerge", "()Ljava/lang/String;", "setEnterFromMerge", "(Ljava/lang/String;)V", "enterFromMerge", "Lcom/bytedance/android/live/profile/ui/base/h;", "e", "Lcom/bytedance/android/live/profile/ui/base/h;", "getProfileContext", "()Lcom/bytedance/android/live/profile/ui/base/h;", "setProfileContext", "(Lcom/bytedance/android/live/profile/ui/base/h;)V", "profileContext", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "getNetworkDisposable", "()Lio/reactivex/disposables/Disposable;", "setNetworkDisposable", "(Lio/reactivex/disposables/Disposable;)V", "networkDisposable", "g", "getCurSubscribeStatus", "setCurSubscribeStatus", "curSubscribeStatus", "h", "getComponentViewName", "componentViewName", "Ljava/util/LinkedList;", "i", "Ljava/util/LinkedList;", "getUgDialogDataList", "()Ljava/util/LinkedList;", "ugDialogDataList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileAnnounceView extends FrameLayout implements e<g> {
    public final TextView a;
    public final TextView b;
    public boolean c;
    public String d;
    public h e;
    public Disposable f;
    public boolean g;
    public final String h;
    public final LinkedList<NewProfileUser> i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProfileAnnounceView a;
        public final /* synthetic */ NewProfileUser b;

        public a(ProfileAnnounceView r1, NewProfileUser r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            h r13 = this.a.getProfileContext();
            Disposable r0 = null;
            if (r13 == null) goto L7;
            NewProfileTrackUseCase r14 = r13.getLogUseCase();
            if (r14 == null) goto L7;
            r14.A(this.a.getComponentViewName(), null);
        L7:
            final ProfileAnnounceView r15 = this.a;
            final NewProfileUser r1 = this.b;
            r15.getClass();
            Intrinsics.checkNotNullParameter(r1, "user");
            p r2 = r1.anchorLiveConfig;
            if (r2 == null) goto L19;
            Long r3 = r2.getAppointmentId();
            if (r3 == null) goto L20;
            final long r4 = r3.longValue();
            Disposable r5 = r15.f;
            if (r5 == null) goto L14;
            r5.dispose();
        L14:
            IMiddlewareAnnouncementService r6 = k.f(IMiddlewareAnnouncementService.class);
            if (r6 == null) goto L17;
            r0 = r6.subscribeAnnouncementOpt(r4, r15.d, "webcast_user_profile", !r15.g, "10041", new ProfileAnnounceView$handleClick$$inlined$let$lambda$1(r4, r15, r1));
        L17:
            r15.f = r0;
            return;
        L20:
            return;
        }
    }

    public ProfileAnnounceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileAnnounceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final TextView getAnnounceActionView() {
        return this.b;
    }

    public final TextView getAnnounceDescView() {
        return this.a;
    }

    public final boolean getCanClick() {
        return this.c;
    }

    public final String getComponentViewName() {
        return this.h;
    }

    public final boolean getCurSubscribeStatus() {
        return this.g;
    }

    public final String getEnterFromMerge() {
        return this.d;
    }

    public final Disposable getNetworkDisposable() {
        return this.f;
    }

    public final h getProfileContext() {
        return this.e;
    }

    public final LinkedList<NewProfileUser> getUgDialogDataList() {
        return this.i;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(g r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        if (this.c == true) goto L6;
        setOnClickListener(null);
        setClickable(false);
        return;
    }

    public final Map<String, String> f(NewProfileUser r6) {
        Pair[] r0 = new Pair[7];
        boolean r2 = false;
        r0[0] = TuplesKt.to("enter_method", "profile_card");
        r0[1] = TuplesKt.to("enter_from_merge", this.d);
        r0[2] = TuplesKt.to("anchor_id", r6.baseProfileInfo.getIdStr());
        List r1 = r6.anchorLiveConfig.getScheduledWeekDays();
        if (r1 != null) goto L5;
    L6:
        r2 = true;
    L7:
        if (r2 == false) goto L9;
        String r3 = "single";
    L10:
        r0[3] = TuplesKt.to("announce_type", r3);
        if (this.g == false) goto L13;
        String r4 = DataType.FALSE;
    L14:
        r0[4] = TuplesKt.to("is_able_click", r4);
        p r7 = r6.anchorLiveConfig;
        if (r7 == null) goto L17;
        Long r8 = r7.getAppointmentId();
    L18:
        r0[5] = TuplesKt.to("appointment_id", String.valueOf(r8));
        r0[6] = TuplesKt.to("is_anchor", DataType.FALSE);
        return MapsKt.mutableMapOf(r0);
    L17:
        r8 = null;
        goto L18
    L13:
        r4 = DataType.TRUE;
        goto L14
    L9:
        r3 = "multiple";
        goto L10
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L6
    }

    public final void setCanClick(boolean r1) {
        this.c = r1;
    }

    public final void setCurSubscribeStatus(boolean r1) {
        this.g = r1;
    }

    public final void setEnterFromMerge(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setNetworkDisposable(Disposable r1) {
        this.f = r1;
    }

    public final void setProfileContext(h r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(g r1, NewProfileUser r2) {
        g(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void d(g r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
        ProfileCustomSkin r4 = r3.skin;
        if (r4 == null) goto L6;
        String r5 = r4.signatureColor;
        int r6 = m.a;
        m.e(this.a, r5);
        return;
    }

    public final void g(g r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        r3.getType();
        this.a.setText("直播预告：" + r4.anchorLiveConfig.getScheduledTimeText());
        Boolean r5 = r4.anchorLiveConfig.getSubscribeStatus();
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        this.g = r6;
        if (r6 == false) goto L9;
        this.b.setText("已预约");
        this.b.setTextColor(getResources().getColor(2131107368));
    L10:
        this.b.setOnClickListener(new a(this, r4));
        return;
    L9:
        this.b.setText("预约");
        this.b.setTextColor(getResources().getColor(2131107833));
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(g r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        e.a.update(this, r3, r4);
        g(r3, r4);
        ProfileSkin r5 = r4.mProfileSkin;
        if (r5 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "skin");
        ProfileCustomSkin r6 = r5.skin;
        if (r6 == null) goto L9;
        String r7 = r6.signatureColor;
        int r8 = m.a;
        m.e(this.a, r7);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(g r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileAnnounceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = true;
        this.d = "";
        this.h = "live_profile_announce";
        this.i = new LinkedList();
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_TEXT_INFO, r2, LayoutInflater.from(r2), this, true);
    L6:
        this.a = (TextView) findViewById(2131390143);
        this.b = (TextView) findViewById(2131390142);
        return;
    L5:
        LayoutInflater.from(r2).inflate(2131567197, this, true);
        goto L6
    }

    public static final void b(ProfileAnnounceView r1, NewProfileUser r2, boolean r3) {
        Map<String, String> r4 = r1.f(r2);
        if (r3 == false) goto L5;
        String r5 = "booking";
    L6:
        r4.put("booking_status", r5);
        r4.put("event_author_name", r2.getDisplayName());
        r4.put("event_author_id", r2.baseProfileInfo.getIdStr());
        j0.l().sendLog("livesdk_live_announce_card_click", r4, new Object[0]);
        return;
    L5:
        r5 = "cancel";
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(g r2, NewProfileUser r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        r4.recordBusinessShow(TrackArea.BottomOperatingArea, this.h);
        Map<String, String> r5 = f(r3);
        j0.l().sendLog("livesdk_live_announce_card_show", r5, new Object[0]);
    }

    public /* synthetic */ ProfileAnnounceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
