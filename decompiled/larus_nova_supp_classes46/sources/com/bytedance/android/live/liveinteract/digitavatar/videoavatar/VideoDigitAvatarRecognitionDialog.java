package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.digitavatar.AvatarGender;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog;
import com.bytedance.android.live.liveinteract.digitavatar.h0;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/videoavatar/VideoDigitAvatarRecognitionDialog;", "Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarRecognitionDialog;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoDigitAvatarRecognitionDialog extends DigitAvatarRecognitionDialog {
    public static final /* synthetic */ int P = 0;
    public e M;
    public com.bytedance.android.live.pushstream.d N;
    public Integer O;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog
    public final void ba0() {
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog
    public final void W90() {
        super.W90();
        DataCenter r0 = this.z;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
    L11:
        DigitAvatarContext.a r2 = DigitAvatarContext.Companion;
        DigitAvatarContext r3 = r2.getContext();
        if (r3 == null) goto L14;
        VideoShowMode r4 = r3.getCurrentVideoShowMode();
    L15:
        VideoShowMode r5 = VideoShowMode.DIGIT_AVATAR;
        if (r4 != r5) goto L25;
        DigitAvatarRecognitionDialog.RecognitionType r6 = this.x;
        if (r6 != DigitAvatarRecognitionDialog.RecognitionType.CAMERA) goto L20;
    L21:
        f2.b(2131918205, 0);
    L22:
        DigitAvatarContext r7 = r2.getContext();
        if (r7 == null) goto L33;
        r7.getRequestUpdateAvatar().post(new h0(((com.bytedance.android.live.liveinteract.digitavatar.n) r7.getDigitAvatar().getValue()).b));
        return;
    L33:
        return;
    L20:
        if (r6 != DigitAvatarRecognitionDialog.RecognitionType.PHOTO) goto L22;
    L25:
        DigitAvatarContext r8 = r2.getContext();
        if (r8 == null) goto L28;
        r8.setSkipFrequencyCheck(true);
    L28:
        DigitAvatarContext r9 = r2.getContext();
        if (r9 == null) goto L35;
        DigitAvatarContext.setVideoShowMode$default(r9, r5, null, 2, null);
        return;
    L35:
        return;
    L14:
        r4 = null;
        goto L15
    L10:
        if (hd0.c.f().h() == true) goto L11;
        return;
    L5:
        if (a0.d(r0, false) != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        e r0 = this.M;
        if (r0 == null) goto L8;
        DownloadTask r2 = r0.a;
        if (r2 == null) goto L7;
        r2.subThreadListener(null);
    L7:
        r0.b.clear();
    L8:
        DigitAvatarContext r1 = DigitAvatarContext.Companion.getContext();
        if (r1 == null) goto L31;
        VideoShowMode r3 = r1.getCurrentVideoShowMode();
        if (r3 == null) goto L32;
        VideoShowMode r4 = VideoShowMode.VIDEO;
        if (r3 == r4) goto L17;
        if (r3 == VideoShowMode.DIGIT_AVATAR) goto L17;
        return;
    L17:
        if (((Boolean) vm2.h.A6.getValue(null, vm2.h.a[389(0x185, float:5.45E-43)])).booleanValue() == false) goto L27;
        if (r3 != r4) goto L27;
        Integer r5 = this.O;
        if (r5 == null) goto L27;
        if (r5.intValue() != 2) goto L27;
        com.bytedance.android.live.pushstream.d r6 = this.N;
        if (r6 == null) goto L34;
        r6.Z0(2, new uv0.a(LiveRequestSourceRole.Business, "VideoDigitAvatarRecognitionDialog.switchBack", null));
        return;
    L34:
        return;
    L27:
        com.bytedance.android.live.pushstream.d r7 = this.N;
        if (r7 == null) goto L36;
        r7.Z0(1, new uv0.a(LiveRequestSourceRole.Business, "VideoDigitAvatarRecognitionDialog.switchFront", null));
        return;
    L36:
        return;
    L32:
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (((Boolean) vm2.d.c3.getValue(null, vm2.d.a[208(0xd0, float:2.91E-43)])).booleanValue() == false) goto L6;
        m60.c.d(getContext(), new String[]{"android.permission.CAMERA"});
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (((Boolean) vm2.d.c3.getValue(null, vm2.d.a[208(0xd0, float:2.91E-43)])).booleanValue() == true) goto L5;
    L7:
        jc1.k.n(IMiddlewareRoomService.class).setIsOpenCropImagePage(false);
        return;
    L5:
        if (m60.c.d(getContext(), new String[]{"android.permission.CAMERA"}) == false) goto L7;
        jc1.k.n(IMiddlewareRoomService.class).isOpenCropImagePage();
        goto L7
    }

    public VideoDigitAvatarRecognitionDialog() {
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog
    public final void V90(AvatarGender r3) {
        Intrinsics.checkNotNullParameter(r3, "gender");
        Intrinsics.checkNotNullParameter(r3, "gender");
        e r0 = this.M;
        if (r0 == null) goto L6;
        r0.b(r3, false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        DataCenter r8 = this.z;
        boolean r1 = true;
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        e r2 = null;
        if (r9 == false) goto L13;
        com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.z, null, 2).getLiveStream();
        if (r10 == null) goto L16;
        com.bytedance.android.live.pushstream.d r11 = (com.bytedance.android.live.pushstream.d) r10.getValue();
    L17:
        this.N = r11;
        if (r11 == null) goto L22;
        d0 r12 = r11.getLiveCore();
        if (r12 == null) goto L22;
        this.O = Integer.valueOf(r12.g());
    L22:
        com.bytedance.android.live.pushstream.d r13 = this.N;
        if (r13 == null) goto L25;
        r13.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "VideoDigitAvatarRecognitionDialog.switchRadioInit", null));
    L25:
        DigitAvatarContext r14 = DigitAvatarContext.Companion.getContext();
        if (r14 == null) goto L28;
        VideoShowMode r15 = r14.getCurrentVideoShowMode();
    L30:
        if (r15 != VideoShowMode.VIDEO) goto L42;
        IMiddlewareUserService r16 = jc1.k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L34;
        com.bytedance.android.livesdk.user.e r3 = r16.user();
    L35:
        if (r3 == null) goto L42;
        py.k r4 = r16.user().b().getAvatarMedium();
        if (r4 != null) goto L41;
        String r17 = r16.user().b().getAvatarUrl();
        if (TextUtils.isEmpty(r17) == true) goto L41;
        ArrayList r5 = new ArrayList();
        Intrinsics.checkNotNull(r17);
        r5.add(r17);
        r4 = qy.a.b(null, r5);
    L41:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r4, new g(this));
        goto L42
    L34:
        r3 = null;
    L42:
        DigitAvatarMsgController r18 = this.D;
        if (r18 == null) goto L51;
        DataCenter r6 = this.z;
        if (r6 != null) goto L47;
    L49:
        r1 = false;
    L50:
        r2 = new e(r18, r1, false);
        goto L51
    L47:
        if (a0.d(r6, false) != true) goto L49;
    L51:
        this.M = r2;
        return;
    L28:
        r15 = null;
    L16:
        r11 = null;
        goto L17
    L13:
        rj0.l.n2.getClass();
        rj0.l r19 = rj0.l.a.a();
        if (r19 == null) goto L16;
        r11 = r19.getLiveStream();
        goto L17
    L5:
        if (a0.d(r8, false) != true) goto L7;
        r9 = true;
        goto L8
    }
}
