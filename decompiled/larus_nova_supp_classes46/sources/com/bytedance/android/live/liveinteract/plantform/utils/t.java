package com.bytedance.android.live.liveinteract.plantform.utils;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ List a;

        public a(List r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<JSONArray> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            int r0 = t.a;
            r2.onNext(t.c(this.a));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            t.b((JSONArray) r1);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            ALogger.e("ttlive_link", "notifyOnlineListChangeToJsb, stackTrace: " + ExceptionsKt.stackTraceToString((Throwable) r3));
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(List<? extends ILinkPlayerInfoBridge> r3) {
        Intrinsics.checkNotNullParameter(r3, "userList");
        if (r3.isEmpty() == false) goto L6;
        return;
    L6:
        if (((Boolean) vm2.d.t6.getValue(null, vm2.d.a[381(0x17d, float:5.34E-43)])).booleanValue() == true) goto L8;
        b(c(r3));
        return;
    L8:
        RxUtilKt.h(Observable.create(new a(r3)).subscribeOn(Schedulers.io())).subscribe(b.a, c.a);
    }

    public static void b(JSONArray r3) {
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "event_linkmic_onlinelist_update");
        r0.put("list", r3);
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r0);
    }

    public static JSONArray c(List r9) {
        ArrayList r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L25;
        ILinkPlayerInfoBridge r1 = (ILinkPlayerInfoBridge) r10.next();
        if (r1.getUser() == null) goto L4;
        if (TextUtils.isEmpty(r1.getInteractId()) == true) goto L4;
        Intrinsics.checkNotNullParameter(r1, "$this$toAnchorLinkUser");
        com.bytedance.android.livesdk.link.model.bridge.k r2 = vh7.f.c(com.bytedance.android.livesdk.link.model.bridge.k.class);
        r2.setUser(r1.getUser());
        r2.setKSongUid(r1.getKSongUid());
        r2.setLinkMicIdStr(r1.getInteractId());
        r2.setLinkMicUniqueIdStr(r1.getMLinkMicUniqueIdStr());
        r2.setStatus(r1.getLinkStatus());
        r2.setLinkType(r1.getLinkType());
        r2.setUserPosition(r1.getUserPosition());
        r2.setSilenceStatus(r1.getSilenceStatus());
        r2.setModifyTime(r1.getModifyTime());
        r2.setRoleType(r1.getRoleType());
        r2.setMcStatus(r1.getMcStatus());
        r2.setBackground(r1.isBackground() ? 1 : 0);
        r2.setContent(vh7.f.c(k1.class));
        r2.setMicPosTagInfo(r1.getMicPosTagInfo());
        l1 r3 = vh7.f.c(l1.class);
        r3.setFanTicket(r1.getFanTicket());
        r3.setFanTicketFuzzyStr(r1.getFanTicketDisplayStr());
        r3.setHost(r1.isHost());
        r3.setClientVersion(r1.getClientVersion());
        r3.setAppId(r1.getAppId());
        r3.setDevicePlatform(r1.getDevicePlatform());
        com.bytedance.android.live.liveinteract.plantform.model.o r4 = r1.getLinkedListUserInfo();
        long r5 = 0;
        if (r4 == null) goto L13;
        long r7 = r4.getJoinChannelTime();
    L14:
        r3.setJoinChannelTime(r7);
        com.bytedance.android.live.liveinteract.plantform.model.o r6 = r1.getLinkedListUserInfo();
        if (r6 == null) goto L17;
        long r8 = r6.getExpectLeaveTime();
    L18:
        r3.setExpectLeaveTime(r8);
        com.bytedance.android.live.liveinteract.plantform.model.o r11 = r1.getLinkedListUserInfo();
        if (r11 == null) goto L21;
        r5 = r11.getCurrentTime();
    L21:
        r3.setCurrentTime(r5);
        r3.setListUserRole(r1.getListUserRole());
        k1 r12 = r2.getContent();
        if (r12 == null) goto L24;
        r12.setLinkMicAudienceContent(r3);
    L24:
        r0.add(r2);
        goto L4
    L17:
        r8 = 0;
        goto L18
    L13:
        r7 = 0;
        goto L14
    L25:
        String r13 = GsonProtectorUtils.toJson(GsonHelper.get(), r0);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L28
        Object r15 = Result.constructor-impl(new JSONArray(r13));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r15) == false) goto L33;
        r15 = null;
    L33:
        JSONArray r16 = (JSONArray) r15;
        if (r16 == null) goto L36;
        return r16;
    L36:
        return new JSONArray();
    L28:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }
}
