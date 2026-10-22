package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastAnnounceService;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdkapi.announcement.AnnounceChoosePage;
import com.bytedance.android.livesdkapi.announcement.AnnounceCommand;
import com.bytedance.android.livesdkapi.announcement.AnnounceCommandCallback;
import com.bytedance.android.livesdkapi.announcement.AnnounceSettingPage;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceBaseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceChooseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceSettingConfig;
import com.bytedance.android.livesdkapi.announcement.OpenSharePanelConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openTimeSchedule")
public final class j9 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {
    public final String a;
    public Disposable b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/j9$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "enterFrom", "b", "", "enterFromType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "style", "I", "e", "()I", "enablePublishVideo", "a", "", "extra", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("enable_publish_video")
        private final int enablePublishVideo;

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("enter_from_type")
        private final Integer enterFromType;

        @SerializedName("extra")
        private final Map<String, String> extra;

        @SerializedName("style")
        private final int style;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L18;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.enterFrom, r4.enterFrom) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.enterFromType, r4.enterFromType) == true) goto L12;
            return false;
        L12:
            if (this.style == r4.style) goto L14;
            return false;
        L14:
            if (this.enablePublishVideo == r4.enablePublishVideo) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.enterFrom;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.enterFromType;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (((((r6 + r8) * 31) + this.style) * 31) + this.enablePublishVideo) * 31;
            Map<String, String> r11 = this.extra;
            if (r11 == null) goto L18;
            r1 = r11.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Param(type=" + this.type + ", enterFrom=" + this.enterFrom + ", enterFromType=" + this.enterFromType + ", style=" + this.style + ", enablePublishVideo=" + this.enablePublishVideo + ", extra=" + this.extra + ")";
        }

        public final int a() {
            return this.enablePublishVideo;
        }

        public final String b() {
            return this.enterFrom;
        }

        public final Integer c() {
            return this.enterFromType;
        }

        public final Map<String, String> d() {
            return this.extra;
        }

        public final int e() {
            return this.style;
        }

        public final String getType() {
            return this.type;
        }

        public a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(null, "enterFrom");
            this.type = r3;
            this.enterFrom = null;
            this.enterFromType = null;
            this.style = 0;
            this.enablePublishVideo = 0;
            this.extra = null;
        }
    }

    public static final class b implements IAnnouncementService.SettingDialogCloseAction {
        public final /* synthetic */ j9 a;
        public final /* synthetic */ CallContext b;

        public final void onDismiss() {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onDismiss(this);
        }

        public final void onAnnouncementSwitchChange(boolean r1) {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onAnnouncementSwitchChange(this, r1);
        }

        public b(j9 r1, CallContext r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onAnnouncementSubmit(boolean r2, AnnouncementInfo r3, com.bytedance.android.livesdk.announce.b r4) {
            if (r2 == false) goto L14;
            if (r3 == null) goto L6;
            String r5 = r3.content;
            if (r5 == null) goto L6;
        L7:
            if (r3 == null) goto L11;
            boolean r6 = true;
            if (r3.switchStatus != true) goto L11;
        L12:
            j9.k(this.a, this.b, r5, r6);
            j9.j(this.a, r5, r6);
            return;
        L11:
            r6 = false;
        L6:
            r5 = "";
            goto L7
        }
    }

    public static final class c implements nz.y {
        public c() {
        }
    }

    public static final class d implements IAnnouncementService.SettingDialogCloseAction {
        public final /* synthetic */ j9 a;
        public final /* synthetic */ CallContext b;

        public final void onDismiss() {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onDismiss(this);
        }

        public final void onAnnouncementSwitchChange(boolean r1) {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onAnnouncementSwitchChange(this, r1);
        }

        public d(j9 r1, CallContext r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onAnnouncementSubmit(boolean r2, AnnouncementInfo r3, com.bytedance.android.livesdk.announce.b r4) {
            if (r2 == false) goto L14;
            if (r3 == null) goto L6;
            String r5 = r3.content;
            if (r5 == null) goto L6;
        L7:
            if (r3 == null) goto L11;
            boolean r6 = true;
            if (r3.switchStatus != true) goto L11;
        L12:
            j9.k(this.a, this.b, r5, r6);
            j9.j(this.a, r5, r6);
            return;
        L11:
            r6 = false;
        L6:
            r5 = "";
            goto L7
        }
    }

    public static final class e implements nz.y {
        public e() {
        }
    }

    public static final class f implements IAnnouncementService.AnnouncementDialogCallback {
        public final /* synthetic */ j9 a;
        public final /* synthetic */ CallContext b;

        public final void onJustDismiss() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onJustDismiss(this);
        }

        public final void onOuterDeleteStickOrExtension() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onOuterDeleteStickOrExtension(this);
        }

        public final void onAnnnounceListChanged(IAnnouncementService.CloseAction r2) {
            Intrinsics.checkNotNullParameter(r2, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onAnnnounceListChanged(this, r2);
        }

        public final void onBackData(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackData(this, r2);
        }

        public final void onBackFE(IAnnouncementService.CloseAction r4) {
            Intrinsics.checkNotNullParameter(r4, "closeAction");
            if (r4.equals(IAnnouncementService.CloseAction.CREATE_SUCCESS) == false) goto L6;
            j9.k(this.a, this.b, "", true);
            j9.j(this.a, "", true);
            return;
        }

        public final void onBackFansGroup(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackFansGroup(this, r2);
        }

        public final void onBackLiveStart(IAnnouncementService.CloseAction r2) {
            Intrinsics.checkNotNullParameter(r2, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackLiveStart(this, r2);
        }

        public final void onBackOtherPlace(IAnnouncementService.CloseAction r2) {
            Intrinsics.checkNotNullParameter(r2, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackOtherPlace(this, r2);
        }

        public f(j9 r1, CallContext r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements AnnounceCommandCallback {
        public final /* synthetic */ j9 a;
        public final /* synthetic */ CallContext b;

        public final void onCommand(AnnounceCommand r8) {
            Intrinsics.checkNotNullParameter(r8, "command");
            if ((r8 instanceof AnnounceSettingPage.CreateSuccess) == false) goto L6;
            j9 r0 = this.a;
            AnnounceSettingPage.CreateSuccess r9 = (AnnounceSettingPage.CreateSuccess) r8;
            String r4 = String.valueOf(r9.getAppointmentId());
            String r11 = String.valueOf(r9.getTimestamp());
            r0.getClass();
            JSONObject r5 = new JSONObject();
            r5.put("announcementID", r4);
            r5.put("latestLiveTimestamp", r11);
            r0.finishWithResult(r5);
        L14:
            j9.k(this.a, this.b, "", true);
            j9.j(this.a, "", true);
            return;
        L6:
            if ((r8 instanceof AnnounceSettingPage.ClosePageWithoutCreate) == false) goto L9;
            j9 r12 = this.a;
            r12.getClass();
            JSONObject r1 = new JSONObject();
            r1.put("announcementID", "");
            r12.finishWithResult(r1);
            goto L14
        L9:
            if ((r8 instanceof AnnounceChoosePage.LinkResult) == false) goto L12;
            j9 r2 = this.a;
            AnnounceChoosePage.LinkResult r13 = (AnnounceChoosePage.LinkResult) r8;
            String r6 = r13.getAppointmentId();
            String r14 = r13.getTimeStamp();
            r2.getClass();
            JSONObject r7 = new JSONObject();
            r7.put("announcementID", r6);
            r7.put("latestLiveTimestamp", r14);
            r2.finishWithResult(r7);
            goto L14
        L12:
            if ((r8 instanceof AnnounceSettingPage.CreateFailed) == false) goto L14;
            j9 r15 = this.a;
            r15.getClass();
            JSONObject r3 = new JSONObject();
            r3.put("result", "create_failed");
            r15.finishWithResult(r3);
            goto L14
        }

        public g(j9 r1, CallContext r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h implements IAnnouncementService.AnnouncementDialogCallback {
        public final /* synthetic */ j9 a;
        public final /* synthetic */ CallContext b;

        public final void onJustDismiss() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onJustDismiss(this);
        }

        public final void onOuterDeleteStickOrExtension() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onOuterDeleteStickOrExtension(this);
        }

        public final void onAnnnounceListChanged(IAnnouncementService.CloseAction r2) {
            Intrinsics.checkNotNullParameter(r2, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onAnnnounceListChanged(this, r2);
        }

        public final void onBackData(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackData(this, r2);
        }

        public final void onBackFE(IAnnouncementService.CloseAction r4) {
            Intrinsics.checkNotNullParameter(r4, "closeAction");
            j9.k(this.a, this.b, "", true);
            j9.j(this.a, "", true);
        }

        public final void onBackFansGroup(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackFansGroup(this, r2);
        }

        public final void onBackLiveStart(IAnnouncementService.CloseAction r2) {
            Intrinsics.checkNotNullParameter(r2, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackLiveStart(this, r2);
        }

        public final void onBackOtherPlace(IAnnouncementService.CloseAction r2) {
            Intrinsics.checkNotNullParameter(r2, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackOtherPlace(this, r2);
        }

        public h(j9 r1, CallContext r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void onTerminate() {
    }

    public j9() {
        this.a = "announcement_id";
    }

    public final /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r2) {
        l((a) r1, r2);
    }

    public final void l(a r22, CallContext r23) {
        Intrinsics.checkNotNullParameter(r22, "p0");
        Intrinsics.checkNotNullParameter(r23, "p1");
        IAnnouncementService r2 = jc1.k.f(IAnnouncementService.class);
        String r4 = r22.getType();
        Disposable r6 = null;
        switch(r4.hashCode()) {
            case -1352294148: goto L68;
            case -347231239: goto L54;
            case -122153707: goto L44;
            case -121879484: goto L24;
            case 3322014: goto L17;
            case 403708324: goto L6;
            default: goto L92;
        };
    L92:
        return;
    L6:
        if (r4.equals("share_panel") == false) goto L77;
        Map<String, String> r3 = r22.d();
        if (r3 == null) goto L10;
        String r5 = r3.get(this.a);
    L11:
        IBroadcastAnnounceService r7 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r5 == null) goto L78;
        if (r7 == null) goto L15;
        r6 = r7.openSharePanel(new OpenSharePanelConfig(r5, r23.getContext()));
    L15:
        this.b = r6;
        return;
    L78:
        return;
    L10:
        r5 = null;
        goto L11
    L77:
        return;
    L17:
        if (r4.equals("list") == false) goto L80;
        IAnnouncementService r8 = jc1.k.n(IAnnouncementService.class);
        Context r9 = r23.getContext();
        Integer r11 = r22.c();
        if (r11 == null) goto L21;
        int r12 = r11.intValue();
    L22:
        r8.openAnnouncementChooseDialogOpt(new OpenAnnounceChooseConfig(r9, r12, null, new g(this, r23), null, null, null, r22.d(), 68, null));
        return;
    L21:
        r12 = OpenAnnounceBaseConfig.Companion.getFeTrendHomePage();
        goto L22
    L80:
        return;
    L24:
        if (r4.equals("setting_opt") == false) goto L82;
        Map<String, String> r13 = r22.d();
        if (r13 == null) goto L29;
        r6 = (String) r13.get(this.a);
    L29:
        if (r6 != null) goto L75;
    L34:
        long r14 = 0;
    L36:
        if (r14 == 0) goto L42;
        IAnnouncementService r15 = jc1.k.n(IAnnouncementService.class);
        Context r16 = r23.getContext();
        Integer r17 = r22.c();
        if (r17 == null) goto L40;
        int r18 = r17.intValue();
    L41:
        r15.openAnnouncementCreateDialogOpt(new OpenAnnounceSettingConfig(r16, r18, new h(this, r23), null, Long.valueOf(r14), false, false, null, 232, null));
        return;
    L40:
        r18 = OpenAnnounceBaseConfig.Companion.getFeTrendHomePage();
        goto L41
    L42:
        com.bytedance.android.live.core.utils.f2.c("打开失败", 0);
        return;
    L75:
        r14 = CastLongProtector.parseLong(r6);     // Catch: Exception -> L33
    L82:
        return;
    L44:
        if (r4.equals("settingView") == false) goto L85;
        Intrinsics.checkNotNull(r2);
        if (r2.enable() == false) goto L52;
        Context r19 = r23.getContext();
        if (r22.e() != 1) goto L50;
        boolean r21 = true;
    L51:
        IAnnouncementService.DefaultImpls.openAnnouncementSettingDialog$default(r2, r19, r21, false, null, r22.b(), false, new d(this, r23), 40, null);
        return;
    L50:
        r21 = false;
        goto L51
    L52:
        ((IBroadcastService) jc1.k.n(IBroadcastService.class)).openForenoticeDialog(r23.getContext(), false, false, null, new e(), 1, r22.b());
        return;
    L85:
        return;
    L54:
        if (r4.equals("switchView") == false) goto L88;
        Intrinsics.checkNotNull(r2);
        if (r2.enable() == false) goto L66;
        Context r24 = r23.getContext();
        if (r22.e() != 1) goto L60;
        boolean r25 = true;
    L61:
        String r26 = r22.b();
        if (r22.a() != 1) goto L64;
        boolean r110 = true;
    L65:
        r2.openAnnouncementSettingDialog(r24, r25, false, r26, "center", r110, new b(this, r23));
        return;
    L64:
        r110 = false;
        goto L65
    L60:
        r25 = false;
        goto L61
    L66:
        ((IBroadcastService) jc1.k.n(IBroadcastService.class)).openForenoticeDialog(r23.getContext(), false, true, null, new c(), 1, r22.b());
        return;
    L88:
        return;
    L68:
        if (r4.equals("create") == false) goto L91;
        IAnnouncementService r27 = jc1.k.n(IAnnouncementService.class);
        Context r28 = r23.getContext();
        Integer r29 = r22.c();
        if (r29 == null) goto L72;
        int r31 = r29.intValue();
    L73:
        r27.openAnnouncementCreateDialogOpt(new OpenAnnounceSettingConfig(r28, r31, new f(this, r23), null, null, false, false, null, 232, null));
        return;
    L72:
        r31 = OpenAnnounceBaseConfig.Companion.getFeTrendHomePage();
        goto L73
    }

    public static final void j(j9 r2, String r3, boolean r4) {
        r2.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("timeText", r3);
        r0.put("masterSwitch", r4 ? 1 : 0);
        r2.finishWithResult(r0);
    }

    public static final void k(j9 r1, CallContext r2, String r3, boolean r4) {
        r1.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("timeText", r3);
        r5.put("masterSwitch", r4 ? 1 : 0);
        Unit r6 = Unit.INSTANCE;
        r2.b("H5_openTimeSchedule", r5);
    }
}
