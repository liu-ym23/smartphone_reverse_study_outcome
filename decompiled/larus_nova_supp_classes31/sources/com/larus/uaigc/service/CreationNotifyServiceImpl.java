package com.larus.uaigc.service;

import android.app.Activity;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.d3;
import com.larus.platform.model.NotificationBusiness;
import com.larus.platform.model.NotificationType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.tencent.open.log.TraceLevel;
import hq9.n3;
import hq9.r3;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J<\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/uaigc/service/CreationNotifyServiceImpl;", "Lcom/larus/uaigc/service/ICreationNotifyService;", "<init>", "()V", "pushCreationNotify", "", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "activity", "Landroid/app/Activity;", "shareContainer", "Landroid/view/View;", "targetActivity", "skipChannel", "", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "enterMethod", "", "clickCallBack", "Lkotlin/Function0;", "dismissCreationNotify", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationNotifyServiceImpl implements ICreationNotifyService {

    public static final class a implements r3 {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ CreationDoSameNotifyInfo d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        @Override // hq9.r3
        public final void a() {
        }

        @Override // hq9.r3
        public final void b() {
        }

        @Override // hq9.r3
        public final void c() {
        }

        @Override // hq9.r3
        public final void d() {
            FLogger.a.i("CreationNotifyServiceImpl", "pushCreationDoSameNotify#onClickFallBack");
            this.a.invoke();
            int r0 = com.larus.uaigc.share.b.a;
            String r1 = this.b;
            FlowCommonAppCompatActivity r2 = this.c;
            String r3 = null;
            if ((r2 instanceof FlowCommonAppCompatActivity) == false) goto L5;
            FlowCommonAppCompatActivity r4 = r2;
        L6:
            if (r4 == null) goto L8;
            String r5 = r4.k();
        L9:
            CreationDoSameNotifyInfo r6 = this.d;
            if (r6 == null) goto L12;
            String r7 = r6.a;
        L13:
            if (r6 == null) goto L15;
            String r8 = r6.c;
        L16:
            if (r6 == null) goto L18;
            String r9 = r6.d;
        L19:
            if (r6 == null) goto L21;
            r3 = r6.e;
        L21:
            String r10 = this.e;
            String r11 = this.f;
            JSONObject r12 = new JSONObject();
            Intrinsics.checkNotNullParameter(r12, "params");
            r12.putOpt("enter_method", r1);     // Catch: JSONException -> L24
            r12.putOpt("current_page", r5);     // Catch: JSONException -> L24
            r12.putOpt("from_template_id", r7);     // Catch: JSONException -> L24
            r12.putOpt("template_source", r8);     // Catch: JSONException -> L24
            r12.putOpt("template_sub_type", r9);     // Catch: JSONException -> L24
            r12.putOpt("template_type", r3);     // Catch: JSONException -> L24
            r12.putOpt("title", r10);     // Catch: JSONException -> L24
            r12.putOpt("sub_title", r11);     // Catch: JSONException -> L24
        L26:
            TrackParams r13 = new TrackParams().merge(r12);
            by7.a r14 = new by7.a("click_creation_notification");
            r14.a.merge(r13);
            r14.b();
            return;
        L24:
            e = move-exception;
            FLogger.a.e("CreationNotifyEventHelper", "error in CreationNotifyEventHelper mobClickCreationNotification " + e.getLocalizedMessage());
            goto L26
        L18:
            r9 = null;
            goto L19
        L15:
            r8 = null;
            goto L16
        L12:
            r7 = null;
            goto L13
        L8:
            r5 = "";
            goto L9
        L5:
            r4 = null;
            goto L6
        }

        public a(Function0<Unit> r1, String r2, Activity r3, CreationDoSameNotifyInfo r4, String r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public CreationNotifyServiceImpl() {
    }

    @Override // com.larus.uaigc.service.ICreationNotifyService
    public final void y() {
        d3.a.d();
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [com.larus.uaigc.service.c] */
    @Override // com.larus.uaigc.service.ICreationNotifyService
    public final void J(final UserCreation r35, final FragmentActivity r36, final View r37, Activity r38, boolean r39) {
        Intrinsics.checkNotNullParameter(r35, "creation");
        Intrinsics.checkNotNullParameter(r36, "activity");
        Intrinsics.checkNotNullParameter(r37, "shareContainer");
        if (ShareServiceDelegate.b.a("aweme") == false) goto L6;
        if (r39 == true) goto L6;
        boolean r3 = true;
    L7:
        ArrayList r7 = new ArrayList();
        if (r3 == false) goto L15;
        r7.add(new z(new c(r36, r35, r37)));
        int r0 = com.larus.uaigc.share.b.a;
        String r1 = zp9.d.d(r35);
        String r13 = zp9.d.c(r35);
        String r14 = r35.a;
        JSONObject r15 = new JSONObject();
        Intrinsics.checkNotNullParameter(r15, "params");
        r15.putOpt("template_sub_type", r13);     // Catch: JSONException -> L12
        r15.putOpt("creation_id", r14);     // Catch: JSONException -> L12
        r15.putOpt("template_type", r1);     // Catch: JSONException -> L12
        r15.putOpt("button_name", "aweme");     // Catch: JSONException -> L12
    L14:
        TrackParams r2 = new TrackParams().merge(r15);
        by7.a r4 = new by7.a("show_creation_publish_notification_button");
        r4.a.merge(r2);
        r4.b();
    L12:
        e = move-exception;
        FLogger.a.e("CreationNotifyEventHelper", "error in CreationNotifyEventHelper mobShowCreationPublishNotificationButton " + e.getLocalizedMessage());
    L15:
        String r16 = r36.getString(2131908627);
        if (r3 == false) goto L18;
        String r5 = r36.getString(2131905278);
    L19:
        String r17 = r5;
        Intrinsics.checkNotNull(r17);
        int r6 = com.larus.uaigc.share.b.a;
        String r8 = zp9.d.d(r35);
        String r9 = zp9.d.c(r35);
        String r10 = r35.a;
        JSONObject r18 = new JSONObject();
        Intrinsics.checkNotNullParameter(r18, "params");
        r18.putOpt("template_sub_type", r9);     // Catch: JSONException -> L22
        r18.putOpt("creation_id", r10);     // Catch: JSONException -> L22
        r18.putOpt("template_type", r8);     // Catch: JSONException -> L22
    L24:
        TrackParams r11 = new TrackParams().merge(r18);
        by7.a r12 = new by7.a("show_creation_publish_notification");
        r12.a.merge(r11);
        r12.b();
        d3.a r19 = d3.a;
        String r25 = r35.e();
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r21 = r7.iterator();
    L26:
        if (r21.hasNext() == false) goto L28;
        r20.add(Integer.valueOf(((z) r21.next()).a));
        goto L26
    L28:
        if (r38 == null) goto L30;
        boolean r29 = true;
    L31:
        NotificationType r110 = NotificationType.LEFT_RIGHT_IMAGE;
        if ((r36 instanceof FlowCommonAppCompatActivity) == false) goto L34;
        FlowCommonAppCompatActivity r22 = (FlowCommonAppCompatActivity) r36;
    L35:
        if (r22 == null) goto L37;
        String r23 = r22.k();
    L38:
        r19.c(new n3(null, null, r16, r17, r110, 10000, NotificationBusiness.COMMUNITY, CollectionsKt.listOf(r23), null, null, r25, r20, new d(r7), r38, r29, null, false, null, 921095));
        return;
    L37:
        r23 = "";
        goto L38
    L34:
        r22 = null;
        goto L35
    L30:
        r29 = false;
    L22:
        e = move-exception;
        FLogger.a.e("CreationNotifyEventHelper", "error in CreationNotifyEventHelper mobShowCreationPublishNotification " + e.getLocalizedMessage());
        goto L24
    L18:
        r5 = r36.getString(2131908626);
    L6:
        r3 = false;
        goto L7
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.larus.uaigc.service.ICreationNotifyService
    public final void K(CreationDoSameNotifyInfo r30, Activity r31, Activity r32, String r33, Function0<Unit> r34) {
        Intrinsics.checkNotNullParameter(r31, "activity");
        Intrinsics.checkNotNullParameter(r34, "clickCallBack");
        FlowCommonAppCompatActivity r3 = null;
        if (r30 == null) goto L5;
        Integer r0 = Integer.valueOf(r30.b);
    L6:
        String r4 = "";
        if (r0 != null) goto L10;
    L11:
        if (r0 != null) goto L14;
    L16:
        if (r0 != null) goto L19;
    L21:
        if (r0 != null) goto L24;
    L25:
        if (r0 != null) goto L28;
    L29:
        if (r0 != null) goto L32;
    L33:
        if (r0 != null) goto L36;
    L37:
        if (r0 != null) goto L40;
    L41:
        if (r0 != null) goto L44;
    L45:
        if (r0 != null) goto L48;
    L50:
        String r11 = "";
    L54:
        Intrinsics.checkNotNull(r11);
        AppHost.Companion r1 = AppHost.a;
        String r12 = ContextCompat.getString(r1.getApplication(), 2131901219);
        String r20 = String.valueOf(y0.j("res://" + r1.getApplication().getPackageName() + "/2131240145"));
        int r2 = com.larus.uaigc.share.b.a;
        if ((r32 instanceof FlowCommonAppCompatActivity) == false) goto L57;
        FlowCommonAppCompatActivity r5 = (FlowCommonAppCompatActivity) r32;
    L58:
        if (r5 == null) goto L60;
        String r6 = r5.k();
    L61:
        if (r30 == null) goto L63;
        String r7 = r30.a;
    L64:
        if (r30 == null) goto L66;
        String r8 = r30.c;
    L67:
        if (r30 == null) goto L69;
        String r9 = r30.d;
    L70:
        if (r30 == null) goto L72;
        String r10 = r30.e;
    L73:
        JSONObject r13 = new JSONObject();
        Intrinsics.checkNotNullParameter(r13, "params");
        r13.putOpt("enter_method", r33);     // Catch: JSONException -> L78
        r13.putOpt("current_page", r6);     // Catch: JSONException -> L78
        r13.putOpt("from_template_id", r7);     // Catch: JSONException -> L78
        r13.putOpt("template_source", r8);     // Catch: JSONException -> L78
        r13.putOpt("template_sub_type", r9);     // Catch: JSONException -> L78
        r13.putOpt("template_type", r10);     // Catch: JSONException -> L78
        r13.putOpt("title", r11);     // Catch: JSONException -> L78
        r13.putOpt("sub_title", r12);     // Catch: JSONException -> L78
    L83:
        TrackParams r14 = new TrackParams().merge(r13);
        by7.a r15 = new by7.a("show_creation_notification");
        r15.a.merge(r14);
        r15.b();
        d3.a r16 = d3.a;
        NotificationType r23 = NotificationType.LEFT_RIGHT_IMAGE;
        if ((r31 instanceof FlowCommonAppCompatActivity) == false) goto L86;
        r3 = (FlowCommonAppCompatActivity) r31;
    L86:
        if (r3 == null) goto L88;
        r4 = r3.k();
    L88:
        r16.c(new n3(null, null, r11, r12, r23, 10000, NotificationBusiness.COMMUNITY, CollectionsKt.listOf(r4), null, null, r20, null, new a(r34, r33, r32, r30, r11, r12), r32, true, null, false, null, 929287));
        return;
    L78:
        e = move-exception;
        FLogger.a.e("CreationNotifyEventHelper", "error in CreationNotifyEventHelper mobShowCreationNotification " + e.getLocalizedMessage());
        goto L83
    L72:
        r10 = null;
        goto L73
    L69:
        r9 = null;
        goto L70
    L66:
        r8 = null;
        goto L67
    L63:
        r7 = null;
        goto L64
    L60:
        r6 = "";
        goto L61
    L57:
        r5 = null;
        goto L58
    L48:
        if (r0.intValue() != 12) goto L50;
    L51:
        String r17 = ContextCompat.getString(AppHost.a.getApplication(), 2131901220);
    L53:
        r11 = r17;
        goto L54
    L44:
        if (r0.intValue() == 11) goto L51;
    L40:
        if (r0.intValue() == 10) goto L51;
    L36:
        if (r0.intValue() == 9) goto L51;
    L32:
        if (r0.intValue() == 8) goto L51;
    L28:
        if (r0.intValue() == 7) goto L51;
    L24:
        if (r0.intValue() == 6) goto L51;
    L19:
        if (r0.intValue() != 3) goto L21;
        r17 = ContextCompat.getString(AppHost.a.getApplication(), 2131901218);
        goto L53
    L14:
        if (r0.intValue() != 5) goto L16;
    L52:
        r17 = ContextCompat.getString(AppHost.a.getApplication(), 2131901217);
        goto L53
    L10:
        if (r0.intValue() == 2) goto L52;
    L5:
        r0 = null;
        goto L6
    }
}
