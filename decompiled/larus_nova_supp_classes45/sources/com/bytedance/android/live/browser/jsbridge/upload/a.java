package com.bytedance.android.live.browser.jsbridge.upload;

import android.app.Activity;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.jsbridge.base.CropAndUploadEmojiResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.profit.api.IProfitServiceExternal;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.yv0;
import com.bytedance.android.livesdk.config.zv0;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.k0;
import w20.q8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends k0<q8, CropAndUploadEmojiResultModel> implements com.bytedance.android.live.room.g.b {
    public Disposable a;
    public com.bytedance.android.live.room.g b;
    public String c;
    public String d;
    public final String e;
    public final Fragment f;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.upload.a$a, reason: collision with other inner class name */
    public static final class C0127a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public b(a r1, long r2, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            jc1.k.n(IProfitServiceExternal.class).getPrivilegeSlardarMonitor().h(this.a.e, this.c, SystemClock.uptimeMillis() - this.b);
            f2.c(s1.B(2131916084), 0);
            a r13 = this.a;
            int r1 = this.d;
            String r2 = r13.d;
            String r3 = jc1.k.n(IUserService.class).user().n();
            if (r2.length() <= 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == true) goto L8;
        L10:
            r2 = r3;
            boolean r5 = false;
        L11:
            com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r7 = new Pair[6];
            r7[0] = TuplesKt.to("anchor_id", r2);
            if (r5 == false) goto L14;
            String r8 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        L15:
            r7[1] = TuplesKt.to("is_admin", r8);
            RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r9 == null) goto L23;
            com.bytedance.live.datacontext.m r14 = r9.getRoom();
            if (r14 == null) goto L23;
            Room r15 = (Room) r14.getValue();
            if (r15 == null) goto L23;
            String r16 = r15.getIdStr();
            if (r16 == null) goto L23;
        L24:
            r7[2] = TuplesKt.to("room_id", r16);
            r7[3] = TuplesKt.to("request_page", r13.c);
            if (r1 != 0) goto L27;
            String r17 = "4:3";
        L28:
            r7[4] = TuplesKt.to("emoji_scale", r17);
            r7[5] = TuplesKt.to("emoji_type", "album");
            r6.sendLog("livesdk_livevip_anchor_emoji_upload_success", MapsKt.mapOf(r7), new Object[0]);
            a r18 = this.a;
            CropAndUploadEmojiResultModel r19 = new CropAndUploadEmojiResultModel();
            r19.a(CropAndUploadEmojiResultModel.Code.Success);
            r19.b(1);
            Unit r21 = Unit.INSTANCE;
            r18.finishWithResult(r19);
            IMiddlewareRoomService r110 = jc1.k.f(IMiddlewareRoomService.class);
            if (r110 == null) goto L32;
            r110.setOpenImagePickerForCustomEmoji(false);
            return;
        L32:
            return;
        L27:
            r17 = "3:1";
        L23:
            r16 = "";
            goto L24
        L14:
            r8 = "0";
            goto L15
        L8:
            if ((!Intrinsics.areEqual(r3, r2)) == false) goto L10;
            r5 = true;
            goto L11
        L5:
            r4 = false;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ File c;

        public c(a r1, int r2, PolarisFileWrapper r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            zt0.f r0 = jc1.k.n(IProfitServiceExternal.class).getPrivilegeSlardarMonitor();
            String r1 = this.a.e;
            int r2 = this.b;
            String r3 = o1.a(r7);
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            r0.g(r1, r2, r3, com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r7));
            ALogger.e("CropAndUploadEmojiMethod", r7);
            this.c.delete();
            f2.c(s1.B(2131916083), 0);
            a r8 = this.a;
            r8.getClass();
            CropAndUploadEmojiResultModel r4 = new CropAndUploadEmojiResultModel();
            r4.a(CropAndUploadEmojiResultModel.Code.Success);
            r4.b(0);
            Unit r5 = Unit.INSTANCE;
            r8.finishWithResult(r4);
            IMiddlewareRoomService r9 = jc1.k.f(IMiddlewareRoomService.class);
            if (r9 == null) goto L9;
            r9.setOpenImagePickerForCustomEmoji(false);
            return;
        }
    }

    static {
    }

    public final void b(String r1, String r2, IThemeShowArea r3, ThemeUpLoadListener r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "filePath");
        Intrinsics.checkNotNullParameter(r2, "originDate");
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e(String r1, String r2, String r3) {
    }

    public final /* synthetic */ void h() {
    }

    public final /* synthetic */ void onError(String r1) {
    }

    public final void onCanceled() {
        IMiddlewareRoomService r0 = jc1.k.f(IMiddlewareRoomService.class);
        if (r0 == null) goto L5;
        r0.setOpenImagePickerForCustomEmoji(false);
    L5:
        CropAndUploadEmojiResultModel r1 = new CropAndUploadEmojiResultModel();
        r1.a(CropAndUploadEmojiResultModel.Code.Success);
        r1.b(0);
        Unit r2 = Unit.INSTANCE;
        finishWithResult(r1);
    }

    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.f = r2;
        this.c = "";
        this.d = "";
        IUserService r3 = jc1.k.f(IUserService.class);
        if (r3 == null) goto L8;
        com.bytedance.android.livesdk.user.f r4 = r3.user();
        if (r4 == null) goto L8;
        String r5 = r4.n();
        if (r5 == null) goto L8;
    L9:
        this.e = r5;
        return;
    L8:
        r5 = "0";
        goto L9
    }

    public final void g(String r11, int r12) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r11);
        MultipartTypedOutput r13 = new MultipartTypedOutput();
        r13.addPart("file", new TypedFile("multipart/form-data", r0));
        long r5 = SystemClock.uptimeMillis();
        int r2 = (int) (r0.length() / ((long) RomUtils.SZ));
        this.a = jc1.k.n(IProfitServiceExternal.class).uploadVipCustomEmoji(r12, this.d, r13).subscribe(new b(this, r5, r2, r12), new c(this, r2, r0));
    }

    public final void invoke(Object r16, CallContext r17) {
        q8 r13 = (q8) r16;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r17, "context");
        Integer r0 = (Integer) zv0.a.getValue();
        Integer r1 = (Integer) yv0.a.getValue();
        k2 r2 = jc1.k.n(ILiveSDKService.class).createImagePicker(null, this.f, "upload_custom_emoji", null, r0.intValue(), r1.intValue(), r0.intValue(), r1.intValue(), this, null, null);
        this.b = r2;
        String r3 = "";
        if (r2 == null) goto L8;
        String r4 = r13.b();
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        k2 r5 = r2;
        r5.f = String.valueOf(System.currentTimeMillis());
        r5.t = r4;
        Activity r6 = r5.a;
        Fragment r7 = r5.c;
        TokenCert r8 = k2.B;
        com.bytedance.android.live.core.utils.q.m(r6, r7, 40005, r8, new String[0]);
    L8:
        IMiddlewareRoomService r9 = jc1.k.f(IMiddlewareRoomService.class);
        if (r9 == null) goto L11;
        r9.setOpenImagePickerForCustomEmoji(true);
    L11:
        String r11 = r13.b();
        if (r11 != null) goto L14;
        r11 = "";
    L14:
        this.c = r11;
        String r12 = r13.a();
        if (r12 == null) goto L18;
        r3 = r12;
    L18:
        this.d = r3;
    }
}
