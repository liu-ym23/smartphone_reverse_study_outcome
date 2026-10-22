package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.ui.EditIntroductionActivity;
import com.bytedance.android.livesdk.chatroom.ui.EditIntroductionFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.xe;
import w20.ye;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showPaidLiveTicketEditPage")
public final class ShowPaidLiveTicketEditPageMethod extends w20.p6<xe, ye> implements com.bytedance.android.livesdk.chatroom.ui.n6 {
    public com.bytedance.android.live.browser.jsbridge.upload.q a;
    public xe b;
    public CallContext c;
    public JSONObject d;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShowPaidLiveTicketEditPageMethod$ShowPaidLiveTicketEditPageMethodApi;", "", "", LiveSlardarConstants.EXTRA_KEY_URL, "uri", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShowPaidLiveTicketEditPageMethod$b;", "ticketImgGet", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ShowPaidLiveTicketEditPageMethodApi {
        @GET
        Observable<com.bytedance.android.live.network.response.e<b>> ticketImgGet(@Url String r1, @Query("uri") String r2);
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShowPaidLiveTicketEditPageMethod$b;", "", "Lpy/k;", "image", "Lpy/k;", "a", "()Lpy/k;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("image")
        private final py.k image;

        public b() {
        }

        public final py.k a() {
            return this.image;
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
            py.k r4 = ((b) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r3)).data).a();
            if (r4 == null) goto L7;
            List<String> r5 = r4.getUrls();
            if (r5 == null) goto L7;
            String r6 = (String) CollectionsKt.firstOrNull(r5);
        L8:
            Iterator r0 = ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.b).iterator();
        L10:
            if (r0.hasNext() == false) goto L12;
            ((com.bytedance.android.livesdk.chatroom.utils.d0) r0.next()).z9(r6);
            goto L10
        L12:
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public final void i() {
    }

    public final void onTerminate() {
        this.b = null;
        this.c = null;
    }

    public ShowPaidLiveTicketEditPageMethod() {
    }

    public static boolean j(xe r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.d() != null) goto L8;
        return false;
    L8:
        xe.a r1 = r3.d();
        String r2 = null;
        if (r1 == null) goto L11;
        String r4 = r1.e();
    L13:
        if (mz.c.b(r4) == false) goto L15;
        return false;
    L15:
        xe.a r5 = r3.d();
        if (r5 == null) goto L18;
        String r6 = r5.c();
    L20:
        if (mz.c.b(r6) == false) goto L22;
        return false;
    L22:
        xe.a r7 = r3.d();
        if (r7 == null) goto L25;
        String r8 = r7.a();
    L27:
        if (mz.c.b(r8) == false) goto L29;
        return false;
    L29:
        xe.a r9 = r3.d();
        if (r9 == null) goto L32;
        String r11 = r9.d();
    L34:
        if (mz.c.b(r11) == false) goto L36;
        return false;
    L36:
        xe.a r12 = r3.d();
        if (r12 == null) goto L39;
        String r13 = r12.f();
    L41:
        if (mz.c.b(r13) == false) goto L43;
        return false;
    L43:
        xe.a r14 = r3.d();
        if (r14 == null) goto L46;
        String r15 = r14.b();
    L48:
        if (mz.c.b(r15) == false) goto L50;
        return false;
    L50:
        xe.a r16 = r3.d();
        if (r16 != null) goto L53;
    L77:
        return false;
    L53:
        if (r16.g() == null) goto L77;
        xe.a r17 = r3.d();
        if (r17 == null) goto L77;
        xe.b r18 = r17.g();
        if (r18 == null) goto L77;
        Integer r19 = r18.a();
        if (r19 == null) goto L77;
        r19.intValue();
        xe.a r21 = r3.d();
        if (r21 == null) goto L77;
        xe.b r22 = r21.g();
        if (r22 == null) goto L77;
        Integer r23 = r22.b();
        if (r23 == null) goto L77;
        r23.intValue();
        xe.a r24 = r3.d();
        if (r24 == null) goto L73;
        xe.b r25 = r24.g();
        if (r25 == null) goto L73;
        r2 = r25.c();
    L73:
        if (mz.c.b(r2) == false) goto L75;
        return false;
    L75:
        return true;
    L46:
        r15 = null;
        goto L48
    L39:
        r13 = null;
        goto L41
    L32:
        r11 = null;
        goto L34
    L25:
        r8 = null;
        goto L27
    L18:
        r6 = null;
        goto L20
    L11:
        r4 = null;
        goto L13
    }

    public final void A9(Fragment r13) {
        Intrinsics.checkNotNullParameter(r13, "fragment");
        xe r1 = this.b;     // Catch: Exception -> L10
        if (r1 == null) goto L8;
        JsonObject r2 = r1.f();     // Catch: Exception -> L10
        if (r2 == null) goto L8;
        JSONObject r3 = tv5.a.c(r2);     // Catch: Exception -> L10
    L113:
    L18:
        this.d = r3;
        this.a = new com.bytedance.android.live.browser.jsbridge.upload.q(r13);
        if (this.d == null) goto L116;
        CallContext r14 = this.c;
        if (r14 != null) goto L23;
        return;
    L23:
        if (j(this.b) == false) goto L103;
        com.bytedance.android.live.browser.jsbridge.upload.q r4 = this.a;
        if (r4 == null) goto L103;
        xe r5 = this.b;
        if (r5 == null) goto L34;
        xe.a r6 = r5.d();
        if (r6 == null) goto L34;
        String r7 = r6.c();
        if (r7 == null) goto L34;
        String r8 = r7;
    L35:
        xe r9 = this.b;
        if (r9 == null) goto L43;
        xe.a r11 = r9.d();
        if (r11 == null) goto L43;
        String r12 = r11.a();
        if (r12 == null) goto L43;
        String r15 = r12;
    L44:
        xe r16 = this.b;
        if (r16 == null) goto L52;
        xe.a r17 = r16.d();
        if (r17 == null) goto L52;
        String r18 = r17.d();
        if (r18 == null) goto L52;
        String r19 = r18;
    L53:
        xe r21 = this.b;
        if (r21 == null) goto L61;
        xe.a r22 = r21.d();
        if (r22 == null) goto L61;
        String r23 = r22.f();
        if (r23 == null) goto L61;
        String r24 = r23;
    L62:
        xe r25 = this.b;
        if (r25 == null) goto L70;
        xe.a r26 = r25.d();
        if (r26 == null) goto L70;
        String r27 = r26.e();
        if (r27 == null) goto L70;
        String r28 = r27;
    L71:
        xe r29 = this.b;
        if (r29 == null) goto L81;
        xe.a r31 = r29.d();
        if (r31 == null) goto L81;
        xe.b r32 = r31.g();
        if (r32 == null) goto L81;
        String r33 = r32.c();
        if (r33 == null) goto L81;
        String r34 = r33;
    L82:
        xe r0 = this.b;
        if (r0 == null) goto L91;
        xe.a r35 = r0.d();
        if (r35 == null) goto L91;
        xe.b r36 = r35.g();
        if (r36 == null) goto L91;
        Integer r37 = r36.a();
        if (r37 == null) goto L91;
        int r38 = r37.intValue();
    L92:
        xe r39 = this.b;
        if (r39 == null) goto L101;
        xe.a r41 = r39.d();
        if (r41 == null) goto L101;
        xe.b r42 = r41.g();
        if (r42 == null) goto L101;
        Integer r43 = r42.b();
        if (r43 == null) goto L101;
        int r110 = r43.intValue();
    L102:
        r4.E = new com.bytedance.android.live.browser.jsbridge.upload.z(r8, r15, r19, r24, r28, r34, r38, r110);
    L101:
        r110 = 0;
    L91:
        r38 = 0;
    L81:
        r34 = "";
    L70:
        r28 = "";
    L61:
        r24 = "";
    L52:
        r19 = "";
    L43:
        r15 = "";
    L34:
        r8 = "";
    L103:
        com.bytedance.android.live.browser.jsbridge.upload.q r44 = this.a;
        if (r44 == null) goto L118;
        JSONObject r45 = this.d;
        Intrinsics.checkNotNull(r45);
        r44.D = this;
        r44.invoke(r45, r14);     // Catch: Exception -> L108
        return;
    L108:
        e = move-exception;
        ALogger.e("EncryptedUploadMethod", "native upload failure " + e.getMessage());
        return;
    L118:
        return;
    L116:
        return;
    L8:
        r3 = new JSONObject("");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        StringBuilder r46 = new StringBuilder("create json object crash, ");
        r46.append(e.getMessage());
        r46.append(", ");
        xe r47 = this.b;
        if (r47 == null) goto L16;
        JsonObject r48 = r47.f();
        if (r48 == null) goto L16;
        String r49 = r48.toString();
    L17:
        r46.append(r49);
        ALogger.e("PreloadReplayMethod", r46.toString());
        r3 = new JSONObject();
    L16:
        r49 = null;
        goto L17
    }

    public final void B9(String r3) {
        ye r0 = new ye();
        r0.a(1);
        ye.a r1 = new ye.a();
        r1.a(r3);
        Unit r4 = Unit.INSTANCE;
        r0.b(r1);
        finishWithResult(r0);
    }

    public final void z9(String r6) {
        String r1 = "";
        if (j(this.b) == false) goto L31;
        if (r6 != null) goto L6;
        return;
    L6:
        xe r0 = this.b;
        if (r0 == null) goto L54;
        xe.a r2 = r0.d();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.b() == null) goto L60;
        ShowPaidLiveTicketEditPageMethodApi r3 = (ShowPaidLiveTicketEditPageMethodApi) com.bytedance.android.live.network.c.b().e(ShowPaidLiveTicketEditPageMethodApi.class);
        if (r3 == null) goto L56;
        xe r4 = this.b;
        if (r4 == null) goto L23;
        xe.a r5 = r4.d();
        if (r5 == null) goto L23;
        String r7 = r5.b();
        if (r7 == null) goto L23;
        r1 = r7;
    L23:
        Observable<com.bytedance.android.live.network.response.e<b>> r8 = r3.ticketImgGet(r1, r6);
        if (r8 == null) goto L57;
        Observable r9 = r8.subscribeOn(Schedulers.io());
        if (r9 == null) goto L58;
        Observable r11 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r11 == null) goto L59;
        r11.subscribe(c.a, d.a);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L60:
        return;
    L54:
        return;
    L31:
        xe r12 = this.b;
        if (r12 == null) goto L38;
        String r13 = r12.c();
        if (r13 == null) goto L38;
        r1 = r13;
    L38:
        if (r1.length() != 0) goto L40;
        boolean r14 = true;
    L41:
        if (r14 == false) goto L45;
        ALogger.i("PreloadReplayMethod", "prefix is empty, " + this.b);
        return;
    L45:
        if (StringsKt.endsWith$default(r1, "/", false, 2, null) == false) goto L47;
        String r15 = r1 + r6;
    L48:
        Iterator r16 = ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.b).iterator();
    L50:
        if (r16.hasNext() == false) goto L52;
        ((com.bytedance.android.livesdk.chatroom.utils.d0) r16.next()).z9(r15);
        goto L50
    L52:
        return;
    L47:
        r15 = r1 + '/' + r6;
        goto L48
    L40:
        r14 = false;
        goto L41
    }

    public final void invoke(Object r13, CallContext r14) {
        xe r15 = (xe) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        this.b = r15;
        this.c = r14;
        Integer r1 = r15.e();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.intValue();
    L6:
        ALogger.i("PreloadReplayMethod", "jsb params.pageHeight: " + r15.e());
        String r6 = "";
        if (r3 != 0) goto L20;
        Context r16 = r14.getContext();
        Bundle r0 = new Bundle();
        String r4 = String.valueOf(r16.hashCode()) + String.valueOf(System.currentTimeMillis());
        Map r8 = com.bytedance.android.livesdk.chatroom.utils.s4.a;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(this, "callback");
        com.bytedance.android.livesdk.chatroom.utils.s4.a.put(r4, this);
        r0.putString("upload_callback_key", r4);
        xe r17 = this.b;
        if (r17 == null) goto L14;
        String r18 = r17.b();
        if (r18 == null) goto L14;
        r6 = r18;
    L14:
        r0.putString("edit_content", r6);
        xe r19 = this.b;
        if (r19 == null) goto L19;
        Boolean r110 = r19.a();
        if (r110 == null) goto L19;
        r2 = r110.booleanValue();
    L19:
        r0.putBoolean("add_image_directly", r2);
        Intent r111 = new Intent(r16, EditIntroductionActivity.class);
        r111.putExtras(r0);
        r16.startActivity(r111);
        return;
    L20:
        Context r112 = r14.getContext();
        Bundle r9 = new Bundle();
        String r11 = String.valueOf(r112.hashCode()) + String.valueOf(System.currentTimeMillis());
        Map r12 = com.bytedance.android.livesdk.chatroom.utils.s4.a;
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(this, "callback");
        com.bytedance.android.livesdk.chatroom.utils.s4.a.put(r11, this);
        r9.putString("upload_callback_key", r11);
        xe r113 = this.b;
        if (r113 == null) goto L26;
        String r114 = r113.b();
        if (r114 == null) goto L26;
        r6 = r114;
    L26:
        r9.putString("edit_content", r6);
        xe r115 = this.b;
        if (r115 == null) goto L31;
        Boolean r116 = r115.a();
        if (r116 == null) goto L31;
        boolean r117 = r116.booleanValue();
    L32:
        r9.putBoolean("add_image_directly", r117);
        r9.putInt("page_height", r3);
        int r118 = EditIntroductionFragment.p;
        Intrinsics.checkNotNullParameter(r112, "context");
        Intrinsics.checkNotNullParameter(r9, "extras");
        FragmentActivity r119 = ContextUtil.contextToFragmentActivity(r112);
        if (r119 == null) goto L36;
        FragmentManager r120 = r119.getSupportFragmentManager();
        if (r120 == null) goto L36;
    L41:
        if (r120 != null) goto L43;
        x8.a.b("EditIntroductionFragment", "fragmentManager is null", false);
        return;
    L43:
        EditIntroductionFragment r5 = new EditIntroductionFragment();
        r9.putBoolean("open_as_dialog_fragment", true);
        Unit r7 = Unit.INSTANCE;
        r5.setArguments(r9);
        LandscapeRestrictionOperation r21 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, "EditIntroductionFragment", r21);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r120, r5, r21) == true) goto L54;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
    L47:
        r5.show(r120, "EditIntroductionFragment");
        return;
    L54:
        return;
    L36:
        FragmentActivity r121 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r121 == null) goto L39;
        r120 = r121.getSupportFragmentManager();
        goto L41
    L39:
        r120 = null;
    L31:
        r117 = false;
        goto L32
    L5:
        r3 = 0;
        goto L6
    }

    public final void C9(int r2, int r3, Intent r4) {
        com.bytedance.android.live.browser.jsbridge.upload.q r0 = this.a;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.onActivityResult(r2, r3, r4);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        ALogger.e("PreloadReplayMethod", "upload fail " + e.getMessage());
    }
}
