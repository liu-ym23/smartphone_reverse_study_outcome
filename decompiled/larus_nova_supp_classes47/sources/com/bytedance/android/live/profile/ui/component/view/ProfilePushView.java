package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.Appointment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.live.NotificationSettingCallBack;
import com.bytedance.android.livesdkapi.live.UGDialoOnClickCallBack;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.LinkedList;
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
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B'\b\u0007\u0012\u0006\u0010n\u001a\u00020m\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010o\u0012\b\b\u0002\u0010r\u001a\u00020q¢\u0006\u0004\bs\u0010tJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u00138\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u00100\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010<\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001b\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR\"\u0010D\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010O\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\bM\u0010#\u001a\u0004\bN\u0010%R\u001a\u0010R\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\bP\u0010#\u001a\u0004\bQ\u0010%R\u001a\u0010U\u001a\u00020=8\u0006X\u0086D¢\u0006\f\n\u0004\bS\u0010?\u001a\u0004\bT\u0010AR\u001a\u0010X\u001a\u00020=8\u0006X\u0086D¢\u0006\f\n\u0004\bV\u0010?\u001a\u0004\bW\u0010AR\u001a\u0010[\u001a\u00020=8\u0006X\u0086D¢\u0006\f\n\u0004\bY\u0010?\u001a\u0004\bZ\u0010AR\u001a\u0010^\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\b\\\u0010#\u001a\u0004\b]\u0010%R\u001a\u0010a\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\b_\u0010#\u001a\u0004\b`\u0010%R\u001a\u0010d\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\bb\u0010#\u001a\u0004\bc\u0010%R\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00060e8\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u001a\u0010k\u001a\u00020=8\u0006X\u0086D¢\u0006\f\n\u0004\bk\u0010?\u001a\u0004\bl\u0010A¨\u0006u"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfilePushView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/g;", "Lcom/bytedance/android/livesdkapi/live/UGDialoOnClickCallBack;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getPushDescView", "()Landroid/widget/TextView;", "pushDescView", "b", "getPushActionView", "pushActionView", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "getPushImageView", "()Landroid/widget/ImageView;", "pushImageView", "", "d", "Z", "getCanClick", "()Z", "setCanClick", "(Z)V", "canClick", "", "e", "Ljava/lang/String;", "getEnterFromMerge", "()Ljava/lang/String;", "setEnterFromMerge", "(Ljava/lang/String;)V", "enterFromMerge", "f", "getRequestId", "setRequestId", "requestId", "g", "getLiveType", "setLiveType", "liveType", "Lcom/bytedance/android/live/profile/ui/base/h;", "h", "Lcom/bytedance/android/live/profile/ui/base/h;", "getProfileContext", "()Lcom/bytedance/android/live/profile/ui/base/h;", "setProfileContext", "(Lcom/bytedance/android/live/profile/ui/base/h;)V", "profileContext", "i", "getCurSubscribeStatus", "setCurSubscribeStatus", "curSubscribeStatus", "", "j", "J", "getPushStatus", "()J", "setPushStatus", "(J)V", "pushStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "k", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getLiveRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setLiveRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "liveRoom", "l", "getComponentViewName", "componentViewName", "m", "getEVENT_PAGE", "EVENT_PAGE", "n", "getALL_PUSH_STATUS", "ALL_PUSH_STATUS", "o", "getPERSONALISE_PUSH_STATUS", "PERSONALISE_PUSH_STATUS", "p", "getNO_PUSH_STATUS", "NO_PUSH_STATUS", "q", "getENTER_FROM_SETTING", "ENTER_FROM_SETTING", "r", "getENTER_FROM_OTHERS_HOMEPAGE", "ENTER_FROM_OTHERS_HOMEPAGE", "s", "getENTER_FROM_LONG_PRESS", "ENTER_FROM_LONG_PRESS", "Ljava/util/LinkedList;", "t", "Ljava/util/LinkedList;", "getUgDialogDataList", "()Ljava/util/LinkedList;", "ugDialogDataList", "DEFAULT_PUSH_STATUS", "getDEFAULT_PUSH_STATUS", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfilePushView extends FrameLayout implements e<g>, UGDialoOnClickCallBack {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public boolean d;
    public String e;
    public String f;
    public String g;
    public h h;
    public boolean i;
    public long j;
    public IRoom k;
    public final String l;
    public final String m;
    public final long n;
    public final long o;
    public final long p;
    public final String q;
    public final String r;
    public final String s;
    public final LinkedList<NewProfileUser> t;

    public static final class a implements NotificationSettingCallBack {
        public final /* synthetic */ ProfilePushView a;
        public final /* synthetic */ NewProfileUser b;

        public final void onFailure() {
        }

        public a(ProfilePushView r1, NewProfileUser r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onSuccess(String r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "anchorId");
            this.a.setPushStatus(r6);
            ProfilePushView r7 = this.a;
            if (r6 != r7.n) goto L5;
            boolean r8 = true;
        L6:
            r7.setCurSubscribeStatus(r8);
            ProfilePushView r9 = this.a;
            r9.g(r9.getPushStatus());
            h r10 = this.a.getProfileContext();
            if (r10 == null) goto L13;
            NewProfileUser r12 = r10.getTargetUser();
            if (r12 == null) goto L13;
            Appointment r13 = r12.appointment;
            if (r13 == null) goto L13;
            r13.PushStates = this.a.getPushStatus();
        L13:
            ProfilePushView r14 = this.a;
            NewProfileUser r15 = this.b;
            boolean r16 = r14.getCurSubscribeStatus();
            Map<String, String> r0 = r14.b(r15);
            if (r16 == false) goto L16;
            r0.put("click_type", "watch");
        L17:
            r0.put("event_author_name", r15.getDisplayName());
            r0.put("event_author_id", r15.baseProfileInfo.getIdStr());
            if (r14.i == true) goto L20;
            String r17 = "set";
        L21:
            r0.put("status", r17);
            j0.l().sendLog("livesdk_watch_express_click", r0, new Object[0]);
            return;
        L20:
            r17 = "not_set";
            goto L21
        L16:
            r0.put("click_type", "cancel");
            goto L17
        L5:
            r8 = false;
            goto L6
        }
    }

    public ProfilePushView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfilePushView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final long getDEFAULT_PUSH_STATUS() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IMiddlewareLiveService r0 = k.f(IMiddlewareLiveService.class);
        if (r0 == null) goto L6;
        r0.unRegisterUgDialog(this);
        return;
    }

    public final long getALL_PUSH_STATUS() {
        return this.n;
    }

    public final boolean getCanClick() {
        return this.d;
    }

    public final String getComponentViewName() {
        return this.l;
    }

    public final boolean getCurSubscribeStatus() {
        return this.i;
    }

    public final String getENTER_FROM_LONG_PRESS() {
        return this.s;
    }

    public final String getENTER_FROM_OTHERS_HOMEPAGE() {
        return this.r;
    }

    public final String getENTER_FROM_SETTING() {
        return this.q;
    }

    public final String getEVENT_PAGE() {
        return this.m;
    }

    public final String getEnterFromMerge() {
        return this.e;
    }

    public final IRoom getLiveRoom() {
        return this.k;
    }

    public final String getLiveType() {
        return this.g;
    }

    public final long getNO_PUSH_STATUS() {
        return this.p;
    }

    public final long getPERSONALISE_PUSH_STATUS() {
        return this.o;
    }

    public final h getProfileContext() {
        return this.h;
    }

    public final TextView getPushActionView() {
        return this.b;
    }

    public final TextView getPushDescView() {
        return this.a;
    }

    public final ImageView getPushImageView() {
        return this.c;
    }

    public final long getPushStatus() {
        return this.j;
    }

    public final String getRequestId() {
        return this.f;
    }

    public final LinkedList<NewProfileUser> getUgDialogDataList() {
        return this.t;
    }

    public final Map<String, String> b(NewProfileUser r4) {
        Pair[] r0 = new Pair[8];
        r0[0] = TuplesKt.to("room_id", String.valueOf(r4.getLiveRoomId()));
        r0[1] = TuplesKt.to("author_id", r4.baseProfileInfo.getIdStr());
        r0[2] = TuplesKt.to("enter_method", "profile_card");
        r0[3] = TuplesKt.to("enter_from_merge", this.e);
        h r1 = this.h;
        if (r1 == null) goto L8;
        ps0.b r2 = r1.getRoom();
        if (r2 == null) goto L8;
        String r3 = r2.getRequestId();
        if (r3 == null) goto L8;
    L9:
        r0[4] = TuplesKt.to("request_id", r3);
        r0[5] = TuplesKt.to("action_type", "click");
        r0[6] = TuplesKt.to("anchor_id", r4.baseProfileInfo.getIdStr());
        r0[7] = TuplesKt.to("event_page", this.m);
        return MapsKt.mutableMapOf(r0);
    L8:
        r3 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(g r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        if (this.d == true) goto L6;
        setOnClickListener(null);
        setClickable(false);
        return;
    }

    public final void g(long r5) {
        if (r5 != this.n) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        setVisibility(0);
        this.b.setText(s1.B(2131919562));
        this.b.setTextColor(getResources().getColor(2131107368));
        return;
    L9:
        if (r5 != this.p) goto L11;
    L14:
        setVisibility(0);
        this.b.setText(s1.B(2131919561));
        this.b.setTextColor(getResources().getColor(2131107833));
        return;
    L11:
        if (r5 == this.o) goto L14;
        setVisibility(8);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onDialog(Boolean r3) {
        boolean r4 = r3.booleanValue();
        if (this.t.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.t.isEmpty() == true) goto L16;
        NewProfileUser r0 = this.t.pop();
        if (r4 == false) goto L6;
        f(r0, false);
        goto L6
    }

    public final void setCanClick(boolean r1) {
        this.d = r1;
    }

    public final void setCurSubscribeStatus(boolean r1) {
        this.i = r1;
    }

    public final void setEnterFromMerge(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setLiveRoom(IRoom r1) {
        this.k = r1;
    }

    public final void setLiveType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setProfileContext(h r1) {
        this.h = r1;
    }

    public final void setPushStatus(long r1) {
        this.j = r1;
    }

    public final void setRequestId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void c(g r5, NewProfileUser r6) {
        g r7 = r5;
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r6, "user");
        r7.getType();
        this.c.setBackground(null);
        this.c.setImageResource(2131251365);
        ViewGroup.LayoutParams r0 = this.c.getLayoutParams();
        r0.width = s1.f(12.0f);
        r0.height = s1.f(12.0f);
        this.c.setLayoutParams(r0);
        this.a.setText(r7.b);
        Appointment r8 = r6.appointment;
        if (r8 == null) goto L9;
        long r1 = r8.PushStates;
        this.j = r1;
        if (r1 != this.n) goto L7;
        boolean r9 = true;
    L8:
        this.i = r9;
        goto L9
    L7:
        r9 = false;
    L9:
        g(this.j);
        this.b.setOnClickListener(new c(this, r6));
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

    public final void f(NewProfileUser r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "user");
        IMiddlewareLiveService r1 = k.f(IMiddlewareLiveService.class);
        if (r1 == null) goto L10;
        Context r2 = getContext();
        String r3 = r10.baseProfileInfo.getIdStr();
        IMiddlewareLiveService r0 = k.f(IMiddlewareLiveService.class);
        if (r0 == null) goto L7;
        long r4 = r0.getNotificationOppositeValue(this.j);
    L8:
        r1.notificationSettingModify(r2, r3, r4, this.r, new a(this, r10), r12);
        return;
    L7:
        r4 = this.n;
        goto L8
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(g r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        e.a.update(this, r3, r4);
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

    public ProfilePushView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.d = true;
        this.e = "";
        this.f = "";
        this.g = "";
        this.l = "live_profile_push";
        this.m = "profile_card";
        this.n = 1;
        this.o = 2;
        this.p = 3;
        this.q = "setting";
        this.r = "others_homepage";
        this.s = "long_press";
        this.t = new LinkedList();
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_TEXT_INFO, r3, LayoutInflater.from(r3), this, true);
    L6:
        this.a = (TextView) findViewById(2131390143);
        this.b = (TextView) findViewById(2131390142);
        this.c = (ImageView) findViewById(2131380775);
        return;
    L5:
        LayoutInflater.from(r3).inflate(2131567197, this, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(g r5, NewProfileUser r6, f r7) {
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r6, "user");
        Intrinsics.checkNotNullParameter(r7, "logUseCase");
        IMiddlewareLiveService r8 = k.f(IMiddlewareLiveService.class);
        if (r8 == null) goto L5;
        r8.registerUgDialog(this);
    L5:
        r7.recordBusinessShow(TrackArea.BottomOperatingArea, this.l);
        Appointment r9 = r6.appointment;
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.PushStates <= 0) goto L16;
        Map<String, String> r10 = b(r6);
        r10.put("event_author_name", r6.getDisplayName());
        r10.put("event_author_id", r6.baseProfileInfo.getIdStr());
        if (this.i == false) goto L12;
        String r12 = "set";
    L13:
        r10.put("status", r12);
        j0.l().sendLog("livesdk_watch_express_show", r10, new Object[0]);
        return;
    L12:
        r12 = "not_set";
        goto L13
    }

    public /* synthetic */ ProfilePushView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
