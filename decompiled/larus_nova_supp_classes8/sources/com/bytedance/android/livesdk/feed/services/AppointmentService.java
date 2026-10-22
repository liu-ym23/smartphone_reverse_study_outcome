package com.bytedance.android.livesdk.feed.services;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.bytedance.android.livesdk.chatroom.api.AppointmentApi;
import com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService;
import com.bytedance.android.livesdk.feed.fragment.AppointmentListFragment;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.IRoomActionHandler;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-J-\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJD\u0010\u0013\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016JU\u0010\u0018\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J[\u0010 \u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!JA\u0010$\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b$\u0010%J7\u0010'\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010+\u001a\u00020*H\u0016¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/feed/services/AppointmentService;", "Lcom/bytedance/android/livesdk/chatroom/reserve/IAppointmentService;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedItem", "", "enterMethod", "", "appointmentId", "", "logOpenVideo", "(Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/Long;)V", "logClickLive", "", "Lcom/bytedance/android/live/base/model/Appointment$LiveFragments;", "extracts", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/base/model/Appointment;", "appointment", "openVideo", "roomId", "innerUrl", "", "scene", "openLive", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/live/base/model/feed/FeedItem;Lcom/bytedance/android/live/base/model/Appointment;Landroid/content/Context;Ljava/lang/String;)V", "", "reserved", "Landroid/widget/TextView;", "reserveButton", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "reserve", "(Ljava/lang/Boolean;Landroid/content/Context;Ljava/lang/Integer;Landroid/widget/TextView;Lcom/bytedance/android/live/base/model/feed/FeedItem;Lcom/bytedance/android/live/base/model/Appointment;Ljava/lang/String;Lio/reactivex/disposables/CompositeDisposable;)V", "clickType", "jumpType", "logClickReserve", "(Ljava/lang/String;Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "programType", "logAppointmentShow", "(Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "logAppointmentPageShow", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "createAppointmentListFragment", "<init>", "()V", "Companion", "a", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AppointmentService implements IAppointmentService {
    public static final a Companion = null;
    public static final long SOURCE_DRAWER = 10010;
    public static final long SOURCE_LIVE_END = 10009;
    public static final long SOURCE_SECONDARY = 10011;
    public static final long SOURCE_UNDEFINED = 10000;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ILoginCallback {
        public final /* synthetic */ AppointmentService a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ Integer d;
        public final /* synthetic */ TextView e;
        public final /* synthetic */ FeedItem f;
        public final /* synthetic */ Appointment g;
        public final /* synthetic */ String h;
        public final /* synthetic */ CompositeDisposable i;

        public final void onCancel(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
        }

        public final void onSuccess(IBaseUser r11) {
            Intrinsics.checkNotNullParameter(r11, "user");
            this.a.reserve(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }

        public b(AppointmentService r1, Boolean r2, Context r3, Integer r4, TextView r5, FeedItem r6, Appointment r7, String r8, CompositeDisposable r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AppointmentService a;
        public final /* synthetic */ Appointment b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ FeedItem d;
        public final /* synthetic */ String e;

        public c(AppointmentService r1, Appointment r2, TextView r3, FeedItem r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r8) {
            Response r9 = (Response) r8;
            Appointment r10 = this.b;
            r10.isReserved = Boolean.FALSE;
            f2.b(2131915454, 0);
            this.c.setText(s1.B(2131922190));
            Drawable r11 = this.c.getBackground();
            if ((r11 instanceof GradientDrawable) == true) goto L5;
            r11 = null;
        L5:
            GradientDrawable r12 = (GradientDrawable) r11;
            if (r12 == null) goto L8;
            r12.setColor(s1.h(2131107943));
        L8:
            this.a.logClickReserve("cancel_reserve", this.d, this.e, Long.valueOf(this.b.appointmentId), null);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AppointmentService a;
        public final /* synthetic */ FeedItem b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Appointment d;

        public d(AppointmentService r1, FeedItem r2, String r3, Appointment r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            String r0 = r10.getMessage();
            if (r0 != null) goto L5;
        L7:
            f2.b(2131922191, 0);
        L8:
            this.a.logClickReserve("reserve_fail", this.b, this.c, Long.valueOf(this.d.appointmentId), null);
            Logger.e(r10.getMessage());
            return;
        L5:
            if (StringsKt.contains$default(r0, "network not available", false, 2, null) != true) goto L7;
            f2.b(2131920665, 0);
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AppointmentService a;
        public final /* synthetic */ Appointment b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ FeedItem d;
        public final /* synthetic */ String e;

        public e(AppointmentService r1, Appointment r2, TextView r3, FeedItem r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r8) {
            Response r9 = (Response) r8;
            Appointment r10 = this.b;
            r10.isReserved = Boolean.TRUE;
            f2.b(2131922193, 0);
            this.c.setText(s1.B(2131917327));
            Drawable r11 = this.c.getBackground();
            if ((r11 instanceof GradientDrawable) == true) goto L5;
            r11 = null;
        L5:
            GradientDrawable r12 = (GradientDrawable) r11;
            if (r12 == null) goto L8;
            r12.setColor(s1.h(2131108318));
        L8:
            this.a.logClickReserve("reserve", this.d, this.e, Long.valueOf(this.b.appointmentId), null);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AppointmentService a;
        public final /* synthetic */ FeedItem b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Appointment d;

        public f(AppointmentService r1, FeedItem r2, String r3, Appointment r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            String r0 = r10.getMessage();
            if (r0 != null) goto L5;
        L7:
            f2.b(2131922191, 0);
        L8:
            this.a.logClickReserve("reserve_fail", this.b, this.c, Long.valueOf(this.d.appointmentId), null);
            Logger.e(r10.getMessage());
            return;
        L5:
            if (StringsKt.contains$default(r0, "network not available", false, 2, null) != true) goto L7;
            f2.b(2131920665, 0);
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    public AppointmentService() {
    }

    public BaseFragment createAppointmentListFragment() {
        return new AppointmentListFragment();
    }

    public void logAppointmentPageShow(FeedItem r3, String r4) {
        HashMap r0 = new HashMap();
        r0.put("enter_method", r4);
        if (r3 == null) goto L5;
        r0.put("log_pb", r3.logPb);
    L5:
        kw1.c.d("livesdk_live_program_page_show", r0);
    }

    private final void logClickLive(FeedItem r3, String r4, Long r5) {
        HashMap r0 = new HashMap();
        r0.put("enter_method", r4);
        if (r3 == null) goto L5;
        r0.put("log_pb", r3.logPb);
    L5:
        if (r5 == null) goto L7;
        String r6 = String.valueOf(r5.longValue());
    L8:
        r0.put("program_id", r6);
        kw1.c.d("livesdk_live_program_play", r0);
        return;
    L7:
        r6 = null;
        goto L8
    }

    private final void logOpenVideo(FeedItem r3, String r4, Long r5) {
        HashMap r0 = new HashMap();
        r0.put("enter_method", r4);
        if (r5 == null) goto L5;
        String r6 = String.valueOf(r5.longValue());
    L6:
        r0.put("program_id", r6);
        if (r3 == null) goto L9;
        r0.put("log_pb", r3.logPb);
    L9:
        kw1.c.d("livesdk_live_program_history_play", r0);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public void logAppointmentShow(FeedItem r3, String r4, String r5, Long r6) {
        HashMap r0 = new HashMap();
        r0.put("enter_method", r4);
        r0.put("program_type", r5);
        r0.put("program_id", String.valueOf(r6));
        if (r3 == null) goto L5;
        r0.put("log_pb", r3.logPb);
    L5:
        kw1.c.d("livesdk_live_program_list_show", r0);
    }

    public void logClickReserve(String r3, FeedItem r4, String r5, Long r6, String r7) {
        HashMap r0 = new HashMap();
        r0.put("enter_method", r5);
        r0.put("click_type", r3);
        if (r6 == null) goto L5;
        String r8 = String.valueOf(r6.longValue());
    L6:
        r0.put("program_id", r8);
        if (r4 == null) goto L9;
        r0.put("log_pb", r4.logPb);
    L9:
        if (r7 == null) goto L11;
        r0.put("jump_type", r7);
    L11:
        kw1.c.d("livesdk_live_program_reserve", r0);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void openVideo(Map<Long, ? extends Appointment.LiveFragments> r25, Context r26, FeedItem r27, String r28, Appointment r29) {
        Intrinsics.checkNotNullParameter(r25, "extracts");
        Appointment.LiveFragments r6 = r25.get(1L);
        Long r7 = null;
        String r8 = "";
        if (r6 == null) goto L19;
        List r9 = r6.extractItemIds;
        if (r9 == null) goto L19;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        Object[] r2 = new Object[3];
        r2[0] = ListProtector.get(r9, 0);
        r2[1] = CollectionsKt.joinToString$default(r9, null, null, null, 0, null, AppointmentService$openVideo$1$schema$1.INSTANCE, 31, null);
        if (r29 == null) goto L12;
        String r10 = String.valueOf(r29.appointmentId);
        if (r10 == null) goto L12;
        r8 = r10;
    L12:
        r2[2] = r8;
        String r3 = String.format("snssdk1128://aweme/detail_list/%d?refer=program_list_page&gids=%s&label=program_list_page&program_id=%s&content_type=live_replay", Arrays.copyOf(r2, 3));
        ILiveActionHandler r11 = k.f(ILiveActionHandler.class);
        if (r11 == null) goto L15;
        r11.handle(r26, r3);
    L15:
        if (r29 == null) goto L17;
        r7 = Long.valueOf(r29.appointmentId);
    L17:
        logOpenVideo(r27, r28, r7);
        return;
    L19:
        Appointment.LiveFragments r4 = r25.get(3L);
        if (r4 == null) goto L34;
        List r5 = r4.extractItemIds;
        if (r5 == null) goto L35;
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        Object[] r13 = new Object[3];
        r13[0] = ListProtector.get(r5, 0);
        r13[1] = CollectionsKt.joinToString$default(r5, null, null, null, 0, null, AppointmentService$openVideo$2$schema$1.INSTANCE, 31, null);
        if (r29 == null) goto L29;
        String r14 = String.valueOf(r29.appointmentId);
        if (r14 == null) goto L29;
        r8 = r14;
    L29:
        r13[2] = r8;
        String r15 = String.format("snssdk1128://aweme/detail_list/%d?refer=program_list_page&gids=%s&label=program_list_page&program_id=%s&content_type=live_replay", Arrays.copyOf(r13, 3));
        k.n(ILiveActionHandler.class).handle(r26, r15);
        if (r29 == null) goto L32;
        r7 = Long.valueOf(r29.appointmentId);
    L32:
        logOpenVideo(r27, r28, r7);
        return;
    L35:
        return;
    }

    public void openLive(Long r15, String r16, Integer r17, FeedItem r18, Appointment r19, Context r20, String r21) {
        long r5 = 0;
        Long r11 = null;
        if (r17 != null) goto L6;
    L53:
        ILiveActionHandler r7 = k.n(IRoomService.class).actionHandler();
        IRoomActionHandler.Params r8 = new IRoomActionHandler.Params();
        if (r15 == null) goto L56;
        r5 = r15.longValue();
    L56:
        IRoomActionHandler.Params r6 = r8.setRoomId(r5);
        if (r19 == null) goto L59;
        Long r9 = Long.valueOf(r19.appointmentId);
    L60:
        IBaseLiveActionHandler.DefaultImpls.openRoom$default(r7, r20, r6.setAppointmentId(r9).setEnterFromMerge(r21).setEnterMethod("live_program_list"), null, 4, null);
        if (r17 != null) goto L64;
    L66:
        if (r19 == null) goto L68;
        r11 = Long.valueOf(r19.appointmentId);
    L68:
        logClickLive(r18, r21, r11);
        return;
    L64:
        if (r17.intValue() != 1) goto L66;
        xs2.b.a().post(40);
        goto L66
    L59:
        r9 = null;
        goto L60
    L6:
        if (r17.intValue() != 2) goto L53;
        Room r10 = new Room();
        if (r15 == null) goto L10;
        r5 = r15.longValue();
    L10:
        r10.id = r5;
        if (r15 == null) goto L14;
        String r12 = String.valueOf(r15.longValue());
        if (r12 == null) goto L14;
    L15:
        r10.setIdStr(r12);
        if (r18 == null) goto L18;
        String r13 = r18.requestId();
    L19:
        r10.setRequestId(r13);
        if (r18 == null) goto L22;
        String r14 = r18.logPb;
    L23:
        r10.setLog_pb(r14);
        if (r19 == null) goto L27;
        String r22 = r19.getAnchorIdStr();
        if (r22 == null) goto L27;
    L28:
        r10.setOwnerUserIdString(r22);
        Bundle r23 = new Bundle();
        if (r18 == null) goto L31;
        String r24 = r18.logPb;
    L32:
        r23.putString("log_pb", r24);
        if (r18 == null) goto L35;
        String r25 = r18.resId;
    L36:
        r23.putString("request_id", r25);
        r23.putString("enter_from_merge", "drawer_chosen");
        r23.putString("enter_method", "live_program_list");
        if (r19 == null) goto L39;
        String r3 = String.valueOf(r19.appointmentId);
    L40:
        r23.putString("program_id", r3);
        Bundle r4 = LiveRoomIntentBuilder.buildBundle(r20, r10, "", r23);
        if (r4 != null) goto L43;
        return;
    L43:
        if (TTLiveSDK.hostService() != null) goto L45;
        return;
    L45:
        if (TTLiveSDK.hostService().action() == null) goto L72;
        r4.putAll(ArgumentsBuilder.buildRoomArgs(r10));
        if (r4.get("live.intent.extra.USER_ID") != null) goto L49;
        r4.putString("live.intent.extra.USER_ID", r10.getOwnerUserIdString());
    L49:
        r4.putString("live.intent.extra.FEED_URL", r16);
        r4.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r4.putString("enter_from_user_id", r10.getOwnerUserIdString());
        r4.putString("extra_live_new_room_back_source", "jump_source_square_drawer");
        kw1.c.b(r20, r23);
        TTLiveSDK.hostService().action().startLive(r20, r10.id, r4);
        if (r19 == null) goto L52;
        r11 = Long.valueOf(r19.appointmentId);
    L52:
        logClickLive(r18, r21, r11);
        xs2.b.a().post(new uv1.e(0));
        return;
    L72:
        return;
    L39:
        r3 = null;
        goto L40
    L35:
        r25 = null;
        goto L36
    L31:
        r24 = null;
    L27:
        r22 = "0";
        goto L28
    L22:
        r14 = null;
        goto L23
    L18:
        r13 = null;
    L14:
        r12 = "";
        goto L15
    }

    public void reserve(Boolean r19, Context r20, Integer r21, TextView r22, FeedItem r23, Appointment r24, String r25, CompositeDisposable r26) {
        Intrinsics.checkNotNullParameter(r22, "reserveButton");
        Intrinsics.checkNotNullParameter(r26, "subscriptions");
        Context r0 = null;
        if (r24 == null) goto L5;
        Long r1 = Long.valueOf(r24.appointmentId);
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r21 != null) goto L11;
    L14:
        if (r21 != null) goto L17;
    L19:
        if (r21 != null) goto L22;
    L24:
        long r2 = SOURCE_UNDEFINED;
    L13:
        long r15 = r2;
        if (k.n(IUserService.class).user().isLogin() == true) goto L36;
        if ((r20 instanceof FragmentActivity) == false) goto L31;
        r0 = r20;
    L31:
        FragmentActivity r11 = (FragmentActivity) r0;
        if (r11 == null) goto L40;
        TTLiveSDK.hostService().user().login(r11, new b(this, r19, r20, r21, r22, r23, r24, r25, r26), "", "", 0, "", "", "");
        return;
    L40:
        return;
    L36:
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == false) goto L38;
        r26.add(((AppointmentApi) com.bytedance.android.live.network.c.b().e(AppointmentApi.class)).cancelOneAppointment(r24.appointmentId, r24.appointmentType, r15, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r24, r22, r23, r25), new d(this, r23, r25, r24)));
        return;
    L38:
        r26.add(((AppointmentApi) com.bytedance.android.live.network.c.b().e(AppointmentApi.class)).makeOneAppointment(r24.appointmentId, r24.appointmentType, r15, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r24, r22, r23, r25), new f(this, r23, r25, r24)));
        return;
    L22:
        if (r21.intValue() != 3) goto L24;
        r2 = SOURCE_SECONDARY;
        goto L13
    L17:
        if (r21.intValue() != 2) goto L19;
        r2 = SOURCE_DRAWER;
        goto L13
    L11:
        if (r21.intValue() != 1) goto L14;
        r2 = SOURCE_LIVE_END;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
