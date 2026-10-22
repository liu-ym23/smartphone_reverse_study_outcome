package com.bytedance.android.live.liveinteract.digitavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.effect.event.ReleaseStatus;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.voicechat.api.KtvDigitAvatarApi;
import com.bytedance.android.live.room.IMiddlewareLiveSDKService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.PermissionGrantStatus;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.config.y8;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.file.FileUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarRecognitionDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "RecognitionType", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class DigitAvatarRecognitionDialog extends LiveDialogFragment {
    public static final /* synthetic */ int L = 0;
    public com.bytedance.android.live.effect.api.o A;
    public Sticker B;
    public Sticker C;
    public DigitAvatarMsgController D;
    public File E;
    public String F;
    public AvatarGender G;
    public final Lazy H;
    public boolean I;
    public d J;
    public b K;
    public View d;
    public FrameLayout e;
    public ConstraintLayout f;
    public FrameLayout g;
    public HSImageView h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public ConstraintLayout l;
    public ImageView m;
    public ImageView n;
    public LinearLayout o;
    public LiveDoubleColorBallAnimationView p;
    public TextView q;
    public FrameLayout r;
    public ImageView s;
    public HSImageView t;
    public TextView u;
    public ImageView v;
    public TextView w;
    public RecognitionType x;
    public com.bytedance.android.live.room.g y;
    public DataCenter z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarRecognitionDialog$RecognitionType;", "", "DEFAULT", "PHOTO", "CAMERA", "RESULT", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RecognitionType extends Enum<RecognitionType> {
        public static final RecognitionType CAMERA = null;
        public static final RecognitionType DEFAULT = null;
        public static final RecognitionType PHOTO = null;
        public static final RecognitionType RESULT = null;
        public static final /* synthetic */ RecognitionType[] a = null;

        static {
            RecognitionType r1 = new RecognitionType("DEFAULT", 0);
            DEFAULT = r1;
            RecognitionType r2 = new RecognitionType("PHOTO", 1);
            PHOTO = r2;
            RecognitionType r3 = new RecognitionType("CAMERA", 2);
            CAMERA = r3;
            RecognitionType r4 = new RecognitionType("RESULT", 3);
            RESULT = r4;
            a = new RecognitionType[]{r1, r2, r3, r4};
        }

        public static RecognitionType valueOf(String r1) {
            return (RecognitionType) r27.a.a(RecognitionType.class, r1);
        }

        public static RecognitionType[] values() {
            return (RecognitionType[]) a.clone();
        }

        public RecognitionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements y.a {
        public final /* synthetic */ DigitAvatarRecognitionDialog a;
        public final /* synthetic */ AvatarGender b;

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r4) {
            Intrinsics.checkNotNullParameter(r4, "sticker");
            this.a.U90("[" + this.b + "] avatar sticker download success，id=" + this.b.getStickId());
            if (this.a.isViewValid() == true) goto L6;
            this.a.U90("recogniton dialog view invalid");
            return;
        L6:
            DigitAvatarRecognitionDialog r0 = this.a;
            r0.C = r4;
            r0.V90(this.b);
            DigitAvatarRecognitionDialog r5 = this.a;
            RecognitionType r1 = r5.x;
            if (r1 == RecognitionType.CAMERA) goto L38;
            if (r1 == RecognitionType.PHOTO) goto L38;
            if (r1 != RecognitionType.DEFAULT) goto L15;
            AvatarGender r2 = c0.b();
            r5.F = "{}";
            r5.G = r2;
            DigitAvatarRecognitionDialog.S90(this.a);
            return;
        L15:
            if (r1 == RecognitionType.RESULT) goto L17;
            return;
        L17:
            if (r5.I == true) goto L43;
            DigitAvatarContext.a r3 = DigitAvatarContext.Companion;
            DigitAvatarContext r6 = r3.getContext();
            if (r6 == null) goto L26;
            com.bytedance.live.datacontext.m<n> r7 = r6.getDigitAvatar();
            if (r7 == null) goto L26;
            n r8 = (n) r7.getValue();
            if (r8 == null) goto L26;
            String r9 = r8.d;
            if (r9 == null) goto L26;
        L27:
            DigitAvatarContext r10 = r3.getContext();
            if (r10 == null) goto L35;
            com.bytedance.live.datacontext.m<n> r11 = r10.getDigitAvatar();
            if (r11 == null) goto L35;
            n r12 = (n) r11.getValue();
            if (r12 == null) goto L35;
            AvatarGender r13 = r12.b;
            if (r13 == null) goto L35;
        L36:
            r5.F = r9;
            r5.G = r13;
            DigitAvatarRecognitionDialog.S90(this.a);
            return;
        L35:
            r13 = c0.b();
        L26:
            r9 = "";
            goto L27
        L43:
            return;
        L38:
            if (r5.F == null) goto L45;
            r5.U90("形象道具下载完后， 形象识别数据已经有了，so 直接直接加载道具，展示");
            f2.c(s1.B(2131918222), 0);
            DigitAvatarRecognitionDialog.S90(this.a);
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            DigitAvatarRecognitionDialog r0 = this.a;
            String r1 = "[" + this.b + "] avatar sticker download fail，id=" + this.b.getStickId();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "msg");
            ALogger.e("KtvDigitAvatar", r1, r6);
            f2.c("形象资源下载失败,请重新识别", 0);
            if (this.a.x == RecognitionType.RESULT) goto L13;
            int r7 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.g("[" + this.b + "] avatar sticker download fail，id=" + this.b.getStickId());
            TalkRoomBusinessFullLinkMonitor r8 = TalkRoomBusinessFullLinkMonitor.a;
            String r2 = "[" + this.b + "] avatar sticker download fail，id=" + this.b.getStickId();
            r8.getClass();
            TalkRoomBusinessFullLinkMonitor.k(r2);
        L13:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r9 = DialogFragmentLancet.sLastShowStack;
            if (r9 == null) goto L15;
            com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(DigitAvatarRecognitionDialog r1, AvatarGender r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d implements y.a {
        public final /* synthetic */ DigitAvatarRecognitionDialog a;

        public d(DigitAvatarRecognitionDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r4) {
            Intrinsics.checkNotNullParameter(r4, "sticker");
            DigitAvatarRecognitionDialog r0 = this.a;
            StringBuilder r1 = new StringBuilder("recognition sticker download success，id=");
            String r2 = i.a;
            r1.append(i.a);
            r0.U90(r1.toString());
            if (this.a.isViewValid() == true) goto L6;
            this.a.U90("recognition dialog view invalid");
            return;
        L6:
            DigitAvatarRecognitionDialog r3 = this.a;
            r3.B = r4;
            r3.getClass();
            this.a.U90("recognition sticker added, waiting for it ready");
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r5) {
            Intrinsics.checkNotNullParameter(r5, "e");
            DigitAvatarRecognitionDialog r0 = this.a;
            StringBuilder r1 = new StringBuilder("recognition sticker download fail，id=");
            String r3 = i.a;
            r1.append(r3);
            String r2 = r1.toString();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r2, "msg");
            ALogger.e("KtvDigitAvatar", r2, r5);
            f2.c("形象生成资源下载失败,请重新识别", 0);
            int r6 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.g("recognition sticker download fail，id=" + r3);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.k("recognition sticker download fail，id=" + r3);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L12;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ DigitAvatarRecognitionDialog a;

        public e(DigitAvatarRecognitionDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ DigitAvatarRecognitionDialog a;

        public static final class a implements DialogInterface.OnClickListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public f(DigitAvatarRecognitionDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            Context r7 = this.a.getContext();
            x0.d r0 = new x0.d();
            r0.b = r7;
            r0.a = 0;
            r0.a = 4;
            r0.d = r0.b.getText(2131916217);
            a r1 = a.a;
            CharSequence r2 = r0.b.getText(2131914411);
            x0.c[] r3 = r0.g;
            x0.c r4 = r3[0];
            if (r4 != null) goto L5;
            r4 = new x0.c();
            r3[0] = r4;
        L5:
            r4.a = r2;
            r4.b = r1;
            r0.k = false;
            r0.l = false;
            x0.b.g(new x0(r0.b, r0));
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ DigitAvatarRecognitionDialog a;
        public final /* synthetic */ Function0 b;

        public g(DigitAvatarRecognitionDialog r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.bytedance.android.livesdk.sharedpref.e r3 = b6.w;
            Boolean r0 = Boolean.TRUE;
            r3.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r3, r0);
            FrameLayout r4 = this.a.r;
            if (r4 == null) goto L5;
            UtilityKotlinExtentionsKt.t(r4);
        L5:
            this.b.invoke();
        }
    }

    static {
    }

    public void V90(AvatarGender r2) {
        Intrinsics.checkNotNullParameter(r2, "gender");
    }

    public abstract void ba0();

    public void W90() {
        if (this.x == RecognitionType.RESULT) goto L51;
        String r0 = l.a;
        PolarisFileWrapper r1 = new PolarisFileWrapper(s1.getContext().getExternalCacheDir(), l.b);
        if (r1.exists() == true) goto L7;
        r1.mkdirs();
    L7:
        File[] r2 = r1.listFiles();
        if (r2 == null) goto L17;
        PolarisFileWrapper r3 = l.b();
        int r4 = r2.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L17;
        File r6 = r2[r5];
        PolarisFileWrapper r7 = new PolarisFileWrapper(r3, r6.getName());
        FileUtils.rename(r6, r7);     // Catch: Exception -> L14
    L16:
        r5 = r5 + 1;
    L14:
        e = move-exception;
        ALogger.e("KtvDigitAvatar", "file rename to fail. srcfile=" + r6.getPath() + ", dstFile=" + r7.getPath(), e);
    L17:
        DigitAvatarContext.a r8 = DigitAvatarContext.Companion;
        DigitAvatarContext r9 = r8.getContext();
        if (r9 == null) goto L26;
        com.bytedance.live.datacontext.m<n> r10 = r9.getDigitAvatar();
        if (r10 == null) goto L26;
        if (this.x != RecognitionType.DEFAULT) goto L24;
        boolean r11 = true;
    L25:
        r10.setValue(new n(r11, this.G, this.F, 48));
        goto L26
    L24:
        r11 = false;
    L26:
        DigitAvatarContext r12 = r8.getContext();
        if (r12 == null) goto L30;
        r12.saveDigitAvatar();
    L30:
        if (this.x == RecognitionType.DEFAULT) goto L51;
        U90("fire uploadImage2Audit()...");
        File r13 = this.E;
        File r14 = l.a();
        if (r13 == null) goto L42;
        if (r14 == null) goto L42;
        DataCenter r15 = this.z;
        if (r15 == null) goto L40;
        IRoom r16 = com.bytedance.android.live.core.utils.a0.o(r15);
        if (r16 == null) goto L40;
        long r17 = r16.getId();
    L41:
        U90("start 上传图片去审核...");
        TypedOutput r18 = new MultipartTypedOutput();
        r18.addPart("origin_file", new TypedFile("image/jpeg", r13));
        r18.addPart("avatar_file", new TypedFile("image/jpeg", r14));
        ((KtvDigitAvatarApi) com.bytedance.android.live.network.c.b().e(KtvDigitAvatarApi.class)).uploadImage4Audit(r17, r18).compose(RxUtil.rxSchedulerHelper()).subscribe(new t(this), new u(this));
    L40:
        r17 = 0;
    L42:
        StringBuilder r19 = new StringBuilder("originFile is null (");
        if (r13 != null) goto L45;
        boolean r20 = true;
    L46:
        r19.append(r20);
        r19.append(") or avatarFile is null (");
        if (r14 != null) goto L49;
        boolean r21 = true;
    L50:
        r19.append(r21);
        r19.append(").");
        U90(r19.toString());
        goto L51
    L49:
        r21 = false;
        goto L50
    L45:
        r20 = false;
    L51:
        com.bytedance.android.livesdk.sharedpref.e r22 = b6.s;
        if (((Boolean) r22.getValue()).booleanValue() == false) goto L54;
        com.bytedance.android.livesdk.sharedpref.f.d(r22, Boolean.FALSE);
    L54:
        int r23 = x.a;
        boolean r24 = com.bytedance.android.live.core.utils.a0.d(this.z, false);
        LinearLayout r25 = this.i;
        if (r25 != null) goto L57;
    L59:
        boolean r26 = false;
    L60:
        LinkedHashMap r27 = new LinkedHashMap();
        x.c(r27, r24);
        r27.put("avatar_type", "undefault");
        if (r26 == false) goto L63;
        String r28 = "on";
    L64:
        r27.put("is_emoji_allow", r28);
        j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_model_confirm_click", r27, new Object[]{am2.x.class, IRoom.class});
        dismissAllowingStateLoss();     // Catch: Exception -> L67
        return;
    L67:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r29 = DialogFragmentLancet.sLastShowStack;
        if (r29 == null) goto L79;
        com.bytedance.crash.d.d(r29, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L79:
        return;
    L63:
        r28 = "off";
        goto L64
    L57:
        if (r25.isSelected() != true) goto L59;
        r26 = true;
        goto L60
    }

    public final void aa0() {
        if (this.x == RecognitionType.RESULT) goto L6;
    L64:
        ConstraintLayout r0 = this.f;
        if (r0 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r0);
    L67:
        ConstraintLayout r1 = this.l;
        if (r1 == null) goto L70;
        UtilityKotlinExtentionsKt.t(r1);
    L70:
        int r2 = x.a;
        boolean r3 = com.bytedance.android.live.core.utils.a0.d(this.z, false);
        if (this.x != RecognitionType.DEFAULT) goto L73;
        boolean r4 = true;
    L74:
        LinkedHashMap r5 = new LinkedHashMap();
        x.c(r5, r3);
        if (r4 == false) goto L77;
        String r6 = MultiLinkOpenSource.DEFAULT;
    L78:
        r5.put("avatar_type", r6);
        j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_model_confirm_show", r5, new Object[]{am2.x.class, IRoom.class});
        return;
    L77:
        r6 = "undefault";
        goto L78
    L73:
        r4 = false;
        goto L74
    L6:
        if (this.I == false) goto L53;
        HSImageView r7 = this.h;
        if (r7 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r7);
    L10:
        File r8 = l.a();
        DigitAvatarContext r9 = DigitAvatarContext.Companion.getContext();
        if (r9 == null) goto L36;
        com.bytedance.live.datacontext.m<n> r10 = r9.getDigitAvatar();
        if (r10 == null) goto L36;
        n r11 = (n) r10.getValue();
        if (r11 == null) goto L36;
        if (r11.b() != true) goto L36;
        if (r8 == null) goto L36;
        Uri r12 = Uri.fromFile(r8);
        ImagePipeline r13 = Fresco.getImagePipeline();
        if (r13 == null) goto L22;
        r13.evictFromCache(r12);
    L22:
        ImagePipelineFactory r14 = Fresco.getImagePipelineFactory();
        if (r14 == null) goto L27;
        FileCache r15 = r14.getMainFileCache();
        if (r15 == null) goto L27;
        r15.remove(new SimpleCacheKey(r12.toString()));
    L27:
        ImagePipelineFactory r16 = Fresco.getImagePipelineFactory();
        if (r16 == null) goto L32;
        FileCache r17 = r16.getSmallImageFileCache();
        if (r17 == null) goto L32;
        r17.remove(new SimpleCacheKey(r12.toString()));
    L32:
        HSImageView r18 = this.h;
        if (r18 == null) goto L53;
        r18.setImageURI(r12, null);
    L36:
        if (this.G != AvatarGender.Female) goto L45;
        HSImageView r19 = this.h;
        if (r19 == null) goto L53;
        String r20 = ((y8) vm2.k.m.getValue(null, vm2.k.a[11])).girlWithBg;
        String r21 = y8.b;
        if (r20 != null) goto L42;
    L43:
        r20 = r21;
    L44:
        r19.setImageURI(r20, this);
        goto L53
    L42:
        if (r20.isEmpty() == false) goto L44;
    L45:
        HSImageView r22 = this.h;
        if (r22 == null) goto L53;
        String r23 = ((y8) vm2.k.m.getValue(null, vm2.k.a[11])).boyWithBg;
        String r24 = y8.a;
        if (r23 != null) goto L50;
    L51:
        r23 = r24;
    L52:
        r22.setImageURI(r23, this);
        goto L53
    L50:
        if (r23.isEmpty() == false) goto L52;
    L53:
        DigitAvatarContext r25 = DigitAvatarContext.Companion.getContext();
        if (r25 == null) goto L64;
        com.bytedance.live.datacontext.m<n> r26 = r25.getDigitAvatar();
        if (r26 == null) goto L64;
        n r27 = (n) r26.getValue();
        if (r27 == null) goto L64;
        if (r27.e == false) goto L64;
        if (r27.c == true) goto L64;
        f2.b(2131918200, 0);
        goto L64
    }

    public DigitAvatarRecognitionDialog() {
        System.currentTimeMillis();
        this.G = c0.b();
        this.H = LazyKt.lazy(DigitAvatarRecognitionDialog$uiHandler$2.INSTANCE);
        new c();
    }

    public final void X90() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isPickImageWidthCamera();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.TRUE);
    L9:
        xs2.b.a().post(new n90.e(ReleaseStatus.Start));
        k2 r2 = this.y;
        if (r2 == null) goto L13;
        k2 r3 = r2;
        jc1.k.f(IRoomService.class).setIsOnNeedMuteAudioFullPage(true);
        r3.f = String.valueOf(System.currentTimeMillis());
        jc1.k.f(IRoomService.class).savePermissionGrantStatus(PermissionGrantStatus.GRANT_DOING);
        com.bytedance.android.live.core.utils.q.k(r3.a, r3.c, 40004, r3.d, r3.f(), k2.B, r3.z);
        return;
    }

    public final void Y90() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isPickImageWithGallery();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.TRUE);
    L9:
        xs2.b.a().post(new n90.e(ReleaseStatus.Start));
        k2 r2 = this.y;
        if (r2 == null) goto L13;
        k2 r3 = r2;
        jc1.k.f(IRoomService.class).setIsOnNeedMuteAudioFullPage(true);
        r3.f = String.valueOf(System.currentTimeMillis());
        jc1.k.f(IRoomService.class).savePermissionGrantStatus(PermissionGrantStatus.GRANT_DOING);
        com.bytedance.android.live.core.utils.q.p(r3.a, r3.c, 40003, k2.B, r3.z);
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        jc1.k.n(IMiddlewareRoomService.class).setIsOpenCropImagePage(false);
        DigitAvatarMsgController r0 = this.D;
        if (r0 == null) goto L8;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r2 = ILiveWrappedEffectSDKService.a.a();
        if (r2 == null) goto L7;
        r2.getMessageCenter();
    L7:
        r0.a.removeCallbacksAndMessages(null);
    L8:
        ((Handler) this.H.getValue()).removeCallbacksAndMessages(null);
        this.K = null;
        this.J = null;
    }

    public static final void S90(DigitAvatarRecognitionDialog r2) {
        Sticker r0 = r2.B;
        if (r0 == null) goto L8;
        com.bytedance.android.live.effect.api.o r1 = r2.A;
        if (r1 == null) goto L8;
        r1.e(r0);
    L8:
        if (r2.C == null) goto L10;
        r2.aa0();
        r2.U90("waiting avatar sticker ready...");
        return;
    L10:
        Intrinsics.checkNotNullParameter("形象识别成功后，形象道具还未下载完成", "msg");
        ALogger.e("KtvDigitAvatar", "形象识别成功后，形象道具还未下载完成", null);
    }

    public final void T90(AvatarGender r3) {
        LinearLayout r0 = this.o;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        boolean r1 = tb1.d.a;
        LiveDoubleColorBallAnimationView r2 = this.p;
        if (r2 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r2);
    L8:
        LiveDoubleColorBallAnimationView r4 = this.p;
        if (r4 == null) goto L11;
        r4.b();
    L11:
        TextView r5 = this.q;
        if (r5 == null) goto L14;
        r5.setText(2131918223);
    L14:
        U90("start download sticker: [" + r3 + "] avatar sticker[id:" + r3.getStickId() + ']');
        this.K = new b(this, r3);
        y.b(r3, this.K);
    }

    public final void U90(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        ALogger.i("KtvDigitAvatar", r2);
    }

    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        setStyle(2, getTheme());
        Bundle r14 = getArguments();
        if (r14 == null) goto L5;
        Serializable r15 = r14.getSerializable("rec_type");
    L7:
        if ((r15 instanceof RecognitionType) == true) goto L9;
        r15 = null;
    L9:
        RecognitionType r16 = (RecognitionType) r15;
        if (r16 != null) goto L12;
        r16 = RecognitionType.PHOTO;
    L12:
        this.x = r16;
        Context r17 = getContext();
        if (r17 == null) goto L15;
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).createDigitAvatarPreView(r17);
    L15:
        this.A = jc1.k.n(IMiddlewareEffectService.class).effectContext(LiveEffectContextFactoryType.DIGIT_AVATAR).b();
        this.D = new DigitAvatarMsgController(null);
        this.y = jc1.k.n(IMiddlewareLiveSDKService.class).createImagePicker(getActivity(), this, "KtvDigitAvatarRecognitionImagePicker", null, 10, 15, 360, 640, new p(this), null, ".png");
        U90("DigitAvatarRecognitionDialog: recType=" + this.x);
        RecognitionType r18 = this.x;
        if (r18 == RecognitionType.RESULT) goto L30;
        int r0 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        String r1 = "";
        if (r18 == null) goto L21;
        String r19 = r18.name();
        if (r19 == null) goto L21;
    L22:
        Intrinsics.checkNotNullParameter(r19, "type");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("type", r19);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("digit_avatar_start_recognition", r2);
        TalkRoomBusinessFullLinkMonitor r110 = TalkRoomBusinessFullLinkMonitor.a;
        RecognitionType r3 = this.x;
        if (r3 == null) goto L28;
        String r4 = r3.name();
        if (r4 == null) goto L28;
        r1 = r4;
    L28:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r1, "type");
        JSONObject r5 = new JSONObject();
        r5.put("type", r1);
        nd0.c.o(nd0.c.a, LinkMonitorData.AvatarStartRecognitionMonitorData, r5, 0, null, false, 28);
        return;
    L21:
        r19 = "";
        goto L22
    L30:
        return;
    L5:
        r15 = null;
        goto L7
    }

    public final void Z90(RecognitionType r5, Function0<Unit> r6) {
        FrameLayout r0 = this.r;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        HSImageView r1 = this.t;
        if (r1 == null) goto L14;
        String r2 = ((y8) vm2.k.m.getValue(null, vm2.k.a[11])).authIcon;
        String r3 = y8.c;
        if (r2 != null) goto L10;
    L11:
        r2 = r3;
    L12:
        r1.setImageURI(r2);
        goto L14
    L10:
        if (r2.isEmpty() == false) goto L12;
    L14:
        if (r5 != RecognitionType.CAMERA) goto L21;
        TextView r7 = this.u;
        if (r7 == null) goto L18;
        r7.setText(s1.B(2131918198));
    L18:
        TextView r8 = this.w;
        if (r8 == null) goto L27;
        r8.setText(s1.B(2131918196));
    L27:
        ImageView r9 = this.s;
        if (r9 == null) goto L30;
        r9.setOnClickListener(new e(this));
    L30:
        ImageView r10 = this.v;
        if (r10 == null) goto L33;
        r10.setOnClickListener(new f(this));
    L33:
        TextView r11 = this.w;
        if (r11 == null) goto L37;
        r11.setOnClickListener(new g(this, r6));
        return;
    L37:
        return;
    L21:
        TextView r12 = this.u;
        if (r12 == null) goto L24;
        r12.setText(s1.B(2131918199));
    L24:
        TextView r13 = this.w;
        if (r13 == null) goto L27;
        r13.setText(s1.B(2131918197));
        goto L27
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        r11.setCanceledOnTouchOutside(true);
    L5:
        Dialog r12 = getDialog();
        if (r12 == null) goto L22;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L22;
        View r4 = r13.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L14:
        r4.setPadding(0, 0, 0, 0);
        if (PadConfigUtils.c() == true) goto L17;
    L19:
        r13.setLayout(-1, (int) (s1.w() * 0.75f));
    L20:
        r13.setGravity(80);
        r13.setBackgroundDrawable(new ColorDrawable(0));
        goto L22
    L17:
        if (e5.n() == true) goto L19;
        r13.setLayout(-1, (int) (s1.w() * 0.5f));
    L22:
        if (PadConfigUtils.c() == true) goto L24;
    L26:
        UIUtils.updateLayout(r9, -3, (int) (s1.w() * 0.75f));
    L27:
        LinearLayout r14 = this.i;
        if (r14 == null) goto L31;
        UtilityKotlinExtentionsKt.t(r14);
    L31:
        if (this.D == null) goto L35;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r15 = ILiveWrappedEffectSDKService.a.a();
        if (r15 == null) goto L35;
        r15.getMessageCenter();
    L35:
        FrameLayout r16 = this.r;
        if (r16 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r16);
    L38:
        RecognitionType r17 = this.x;
        if (r17 == null) goto L72;
        int r18 = o.a[r17.ordinal()];
        if (r18 == 1) goto L69;
        if (r18 == 2) goto L65;
        if (r18 != 3) goto L48;
        T90(c0.b());
        goto L72
    L48:
        if (r18 != 4) goto L72;
        ba0();
        this.I = false;
        U90("是否是静态预览：" + this.I);
        if (this.I == false) goto L53;
        aa0();
        goto L72
    L53:
        DigitAvatarContext r19 = DigitAvatarContext.Companion.getContext();
        if (r19 == null) goto L61;
        com.bytedance.live.datacontext.m<n> r20 = r19.getDigitAvatar();
        if (r20 == null) goto L61;
        n r21 = (n) r20.getValue();
        if (r21 == null) goto L61;
        AvatarGender r22 = r21.b;
        if (r22 == null) goto L61;
    L62:
        T90(r22);
    L61:
        r22 = c0.b();
        goto L62
    L65:
        if (((Boolean) b6.w.getValue()).booleanValue() == false) goto L67;
        Y90();
        goto L72
    L67:
        Z90(RecognitionType.PHOTO, new AnonymousClass3(this));
        goto L72
    L69:
        if (((Boolean) b6.w.getValue()).booleanValue() == false) goto L71;
        X90();
        goto L72
    L71:
        Z90(RecognitionType.CAMERA, new AnonymousClass2(this));
    L72:
        RecognitionType r23 = this.x;
        if (r23 != RecognitionType.CAMERA) goto L75;
    L76:
        U90("start download sticker: recognition sticker[id:" + i.a + ']');
        this.J = new d(this);
        y.a(this.J);
        return;
    L75:
        if (r23 == RecognitionType.PHOTO) goto L76;
        return;
    L24:
        if (e5.n() == true) goto L26;
        UIUtils.updateLayout(r9, -3, (int) (s1.w() * 0.5f));
        goto L27
    }

    @Deprecated(message = "Deprecated in Java")
    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        if (vm2.d.M() == true) goto L5;
    L9:
        k2 r0 = this.y;
        if (r0 == null) goto L15;
        r0.q(r3, r4, r5);
        return;
    L15:
        return;
    L5:
        if (r3 != 40003) goto L9;
        k2 r1 = this.y;
        if (r1 == null) goto L13;
        r1.r(r3, r4, r5);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565571, r3, false);
        this.d = r5;
        TextView r6 = null;
        if (r5 == null) goto L5;
        ConstraintLayout r7 = (ConstraintLayout) r5.findViewById(2131383904);
    L6:
        this.f = r7;
        View r8 = this.d;
        if (r8 == null) goto L9;
        FrameLayout r9 = (FrameLayout) r8.findViewById(2131369105);
    L10:
        this.e = r9;
        View r10 = this.d;
        if (r10 == null) goto L13;
        FrameLayout r11 = (FrameLayout) r10.findViewById(2131382889);
    L14:
        this.g = r11;
        View r12 = this.d;
        if (r12 == null) goto L17;
        HSImageView r13 = (HSImageView) r12.findViewById(2131363634);
    L18:
        this.h = r13;
        View r14 = this.d;
        if (r14 == null) goto L21;
        LinearLayout r15 = (LinearLayout) r14.findViewById(2131373080);
    L22:
        this.i = r15;
        View r16 = this.d;
        if (r16 == null) goto L25;
        TextView r17 = (TextView) r16.findViewById(2131383728);
    L26:
        this.j = r17;
        View r18 = this.d;
        if (r18 == null) goto L29;
        TextView r19 = (TextView) r18.findViewById(2131381426);
    L30:
        this.k = r19;
        View r20 = this.d;
        if (r20 == null) goto L33;
        ConstraintLayout r21 = (ConstraintLayout) r20.findViewById(2131383903);
    L34:
        this.l = r21;
        View r22 = this.d;
        if (r22 == null) goto L37;
        HSImageView r23 = r22.findViewById(2131382211);
    L37:
        View r24 = this.d;
        if (r24 == null) goto L40;
        ImageView r25 = (ImageView) r24.findViewById(2131381496);
    L41:
        this.m = r25;
        View r26 = this.d;
        if (r26 == null) goto L44;
        ImageView r27 = (ImageView) r26.findViewById(2131381494);
    L45:
        this.n = r27;
        View r28 = this.d;
        if (r28 == null) goto L48;
        LinearLayout r29 = (LinearLayout) r28.findViewById(2131378982);
    L49:
        this.o = r29;
        View r30 = this.d;
        if (r30 == null) goto L52;
        LiveDoubleColorBallAnimationView r31 = (LiveDoubleColorBallAnimationView) r30.findViewById(2131370130);
    L53:
        this.p = r31;
        View r32 = this.d;
        if (r32 == null) goto L56;
        ImageView r33 = (ImageView) r32.findViewById(2131374552);
    L56:
        View r34 = this.d;
        if (r34 == null) goto L59;
        TextView r35 = (TextView) r34.findViewById(2131378986);
    L60:
        this.q = r35;
        View r36 = this.d;
        if (r36 == null) goto L63;
        FrameLayout r37 = (FrameLayout) r36.findViewById(2131391982);
    L64:
        this.r = r37;
        View r38 = this.d;
        if (r38 == null) goto L67;
        ImageView r39 = (ImageView) r38.findViewById(2131362320);
    L68:
        this.s = r39;
        View r40 = this.d;
        if (r40 == null) goto L71;
        HSImageView r41 = (HSImageView) r40.findViewById(2131362321);
    L72:
        this.t = r41;
        View r42 = this.d;
        if (r42 == null) goto L75;
        LinearLayout r43 = (LinearLayout) r42.findViewById(2131362324);
    L75:
        View r44 = this.d;
        if (r44 == null) goto L78;
        TextView r45 = (TextView) r44.findViewById(2131362323);
    L79:
        this.u = r45;
        View r46 = this.d;
        if (r46 == null) goto L82;
        ImageView r47 = (ImageView) r46.findViewById(2131369104);
    L83:
        this.v = r47;
        View r48 = this.d;
        if (r48 == null) goto L86;
        r6 = (TextView) r48.findViewById(2131362322);
    L86:
        this.w = r6;
        ImageView r49 = this.m;
        if (r49 == null) goto L89;
        r49.setOnClickListener(new q(this));
    L89:
        ImageView r50 = this.n;
        if (r50 == null) goto L92;
        r50.setOnClickListener(new r(this));
    L92:
        TextView r51 = this.j;
        if (r51 == null) goto L95;
        r51.setOnClickListener(new DigitAvatarRecognitionDialog$initListener$3(this));
    L95:
        TextView r52 = this.k;
        if (r52 == null) goto L99;
        r52.setOnClickListener(new s(this));
    L99:
        return this.d;
    L82:
        r47 = null;
        goto L83
    L78:
        r45 = null;
        goto L79
    L71:
        r41 = null;
        goto L72
    L67:
        r39 = null;
        goto L68
    L63:
        r37 = null;
        goto L64
    L59:
        r35 = null;
        goto L60
    L52:
        r31 = null;
        goto L53
    L48:
        r29 = null;
        goto L49
    L44:
        r27 = null;
        goto L45
    L40:
        r25 = null;
        goto L41
    L33:
        r21 = null;
        goto L34
    L29:
        r19 = null;
        goto L30
    L25:
        r17 = null;
        goto L26
    L21:
        r15 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
