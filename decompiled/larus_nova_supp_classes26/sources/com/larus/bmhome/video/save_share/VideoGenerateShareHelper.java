package com.larus.bmhome.video.save_share;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.utils.c4;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class VideoGenerateShareHelper {
    public static final VideoGenerateShareHelper a = null;
    public static final a b = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/video/save_share/VideoGenerateShareHelper$SaveBigVideoShareInfoData;", "Landroid/os/Parcelable;", "shareId", "", "<init>", "(Ljava/lang/String;)V", "getShareId", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SaveBigVideoShareInfoData implements Parcelable {
        public static final Parcelable.Creator<SaveBigVideoShareInfoData> CREATOR = null;

        @SerializedName("share_id")
        private final String shareId;

        public static final class a implements Parcelable.Creator<SaveBigVideoShareInfoData> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SaveBigVideoShareInfoData createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                return new SaveBigVideoShareInfoData(r2.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SaveBigVideoShareInfoData[] newArray(int r1) {
                return new SaveBigVideoShareInfoData[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeString(this.shareId);
        }

        public SaveBigVideoShareInfoData() {
            this("");
        }

        public final String a() {
            return this.shareId;
        }

        public SaveBigVideoShareInfoData(String r1) {
            this.shareId = r1;
        }
    }

    public static final class VideoShareCallback implements com.larus.bmhome.share.panel.d {
        public final String a;
        public final View b;
        public final ShareScene c;
        public final CoroutineScope d;
        public final l0 e;
        public final c4 f;
        public final nr9.g g;
        public final Integer h;
        public final String i;
        public final Map<String, String> j;
        public String k;
        public DialogFragment l;
        public Function0<Unit> m;

        /* JADX INFO: renamed from: com.larus.bmhome.video.save_share.VideoGenerateShareHelper$VideoShareCallback$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateShareHelper$VideoShareCallback$1", f = "VideoGenerateShareHelper.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ VideoShareCallback this$0;

            public AnonymousClass1(VideoShareCallback r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r12) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                VideoShareCallback r2 = (VideoShareCallback) this.L$0;
                ResultKt.throwOnFailure(r12);
            L17:
                r2.k = (String) r12;
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r12);
                VideoShareCallback r13 = this.this$0;
                VideoGenerateShareHelper r3 = VideoGenerateShareHelper.a;
                View r4 = r13.b;
                ShareScene r5 = r13.c;
                String r6 = r13.a;
                nr9.g r7 = r13.g;
                if (r7 == null) goto L12;
                String r8 = r7.a;
                if (r8 == null) goto L12;
            L13:
                String r9 = r13.i;
                this.L$0 = r13;
                this.label = 1;
                Object r10 = r3.g(r4, r5, r6, r8, false, r9, this);
                if (r10 != r0) goto L16;
                return r0;
            L16:
                r2 = r13;
                r12 = r10;
            L12:
                r8 = "";
                goto L13
            }
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void f() {
            nr9.g r0 = this.g;
            if (r0 == null) goto L5;
            String r1 = r0.a;
        L6:
            String r2 = r1;
            String r3 = this.a;
            c4 r4 = this.f;
            String r5 = r4.a;
            String r6 = r4.c;
            String r7 = r4.g;
            String r8 = r4.j;
            Integer r9 = r4.i;
            String r10 = r4.h;
            String r11 = this.i;
            JSONObject r12 = r4.m;
            if (r12 != null) goto L9;
            r12 = new JSONObject();
        L9:
            a4.j(r2, r3, r5, "share_panel_click", r6, r7, r8, r9, r10, r11, r12, 2048);
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void onDismiss() {
            Function0<Unit> r0 = this.m;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.m = r2;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean d(String r2, String r3, Boolean r4) {
            if (z2.a.getCreationShareSettings().b() == true) goto L5;
            return true;
        L5:
            if (Intrinsics.areEqual(r2, "video") == true) goto L7;
        L9:
            boolean r5 = false;
        L11:
            return !r5;
        L7:
            if (Intrinsics.areEqual(r3, ShareChannel.SAVE_VIDEO) == false) goto L9;
            r5 = true;
            goto L11
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean b(Context r18, DialogFragment r19, View r20, jr9.a r21) {
            Intrinsics.checkNotNullParameter(r21, "shareItemConfig");
            VideoGenerateShareHelper r1 = VideoGenerateShareHelper.a;
            DialogFragment r4 = this.l;
            String r5 = this.a;
            View r6 = this.b;
            ShareScene r7 = this.c;
            CoroutineScope r8 = this.d;
            l0 r9 = this.e;
            c4 r10 = this.f;
            nr9.g r11 = this.g;
            String r12 = this.k;
            Integer r13 = this.h;
            String r14 = this.i;
            Map<String, String> r3 = this.j;
            r1.getClass();
            VideoGenerateShareHelper.h(r18, r19, r21, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r3);
            jr9.b r0 = r21.a;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L10;
            onDismiss();
        L10:
            return true;
        L5:
            if (r0.g != true) goto L7;
            r2 = true;
            goto L8
        }

        public VideoShareCallback(String r2, View r3, ShareScene r4, CoroutineScope r5, l0 r6, c4 r7, nr9.g r8, Integer r9, String r10, Map<String, String> r11) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "shareContainer");
            Intrinsics.checkNotNullParameter(r4, "shareScene");
            Intrinsics.checkNotNullParameter(r5, "scope");
            Intrinsics.checkNotNullParameter(r7, "eventParams");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            CoroutineDispatcher r12 = Dispatchers.getIO();
            VideoGenerateShareHelper.a.getClass();
            BuildersKt.launch$default(r5, r12.plus(VideoGenerateShareHelper.b), null, new AnonymousClass1(this, null), 2, null);
            this.k = "";
        }
    }

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("Video Edit Error", "sql execute err! msg=" + r4);
        }
    }

    public VideoGenerateShareHelper() {
    }

    static {
        a = new VideoGenerateShareHelper();
        b = new a(CoroutineExceptionHandler.Key);
    }

    public static void b(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void c(l0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static void a(BaseTipOffDialog r3, FragmentManager r4) {
        if ((r3 instanceof Fragment) == false) goto L5;
        BaseTipOffDialog r0 = r3;
    L6:
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, null, r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r2) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r3.show(r4, null);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final String d(VideoGenerateShareHelper r3, Context r4) {
        r3.getClass();
        if (r4 != null) goto L5;
        return "";
    L5:
        String r5 = AppHost.a.getAppStringName();
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(r4.getString(2131910938), Arrays.copyOf(new Object[]{r5}, 1));
    }

    public static final String e(VideoGenerateShareHelper r3, Context r4) {
        r3.getClass();
        if (r4 != null) goto L5;
        return "";
    L5:
        String r5 = AppHost.a.getAppStringName();
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(r4.getString(2131910939), Arrays.copyOf(new Object[]{r5}, 1));
    }

    public final Object g(View r22, ShareScene r23, String r24, String r25, boolean r26, String r27, Continuation<? super String> r28) {
        final View r1 = r22;
        ShareScene r0 = r23;
        if ((r28 instanceof VideoGenerateShareHelper$getShareVideoUrlAsMessage$1) == false) goto L7;
        VideoGenerateShareHelper$getShareVideoUrlAsMessage$1 r5 = (VideoGenerateShareHelper$getShareVideoUrlAsMessage$1) r28;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        Ref.ObjectRef r2 = (Ref.ObjectRef) r5.L$3;
        String r3 = (String) r5.L$2;
        ShareScene r8 = (ShareScene) r5.L$1;
        View r9 = (View) r5.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: NetworkErrorException -> L14
        Object r10 = r4;
        final Ref.ObjectRef r11 = r2;
        r1 = r9;
        String r12 = r3;
        r0 = r8;
        String r13 = "VideoGenerateShareHelper";
    L27:
        y r14 = (com.larus.network.http.a) r10;     // Catch: NetworkErrorException -> L47
        if ((r14 instanceof y) == false) goto L33;
        SaveBigVideoShareInfoData r16 = (SaveBigVideoShareInfoData) ((com.larus.network.http.a) r14).b;     // Catch: NetworkErrorException -> L47
        if (r16 == null) goto L33;
        String r17 = r16.a();     // Catch: NetworkErrorException -> L47
        if (r17 == null) goto L33;
    L35:
        if (r17.length() <= 0) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == false) goto L52;
        Uri.Builder r19 = UriProtector.parse(z2.a.videoGenerateShareHost()).buildUpon();     // Catch: NetworkErrorException -> L47
        r19.appendQueryParameter("source_type", "mobile");     // Catch: NetworkErrorException -> L47
        r19.appendQueryParameter("share_id", r17);     // Catch: NetworkErrorException -> L47
        r19.appendQueryParameter("video_id", r12);     // Catch: NetworkErrorException -> L47
        if (r0 != ShareScene.VIDEO_COMPREHEND) goto L42;
        r19.appendQueryParameter("share_scene", "share_video");     // Catch: NetworkErrorException -> L47
    L42:
        Uri r20 = r19.build();     // Catch: NetworkErrorException -> L47
        l0 r21 = (l0) r11.element;     // Catch: NetworkErrorException -> L47
        if (r21 == null) goto L45;
        b(r21);     // Catch: NetworkErrorException -> L47
    L45:
        return r20.toString();
    L47:
        e = e;
    L51:
        FLogger.a.i(r13, "share failed " + e);
    L52:
        r1.post(new e(r11));
        return "";
    L37:
        r18 = false;
    L33:
        r17 = "";
    L14:
        e = e;
        r11 = r2;
        r1 = r9;
    L50:
        r13 = "VideoGenerateShareHelper";
        goto L51
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r4);
        FLogger.a.i("VideoGenerateShareHelper", "getShareVideoUrlAsMessage shareScene:" + r0 + " messageId:" + r24 + " creationId:" + r27);
        r11 = new Ref.ObjectRef();
        if (r26 == false) goto L56;
        r1.post(new d(r11, r1));
    L56:
        r5.L$0 = r1;     // Catch: NetworkErrorException -> L49
        r5.L$1 = r0;     // Catch: NetworkErrorException -> L49
        r5.L$2 = r25;     // Catch: NetworkErrorException -> L49
        r5.L$3 = r11;     // Catch: NetworkErrorException -> L49
        r5.label = 1;     // Catch: NetworkErrorException -> L49
        JSONObject r110 = new JSONObject();     // Catch: NetworkErrorException -> L49
        r110.put(MusicAppletPage.KEY_MESSAGE_ID, r24);     // Catch: NetworkErrorException -> L49
        r110.put("creation_id", r27);     // Catch: NetworkErrorException -> L49
        Unit r29 = Unit.INSTANCE;     // Catch: NetworkErrorException -> L49
        r13 = "VideoGenerateShareHelper";
        r10 = HttpExtKt.k("Social", SaveBigVideoShareInfoData.class, "/alice/media/bigmusic/share_save", r110, null, null, false, null, null, null, r5, 1008);     // Catch: NetworkErrorException -> L47
        if (r10 != r15) goto L26;
        return r15;
    L26:
        r12 = r25;
    L49:
        e = e;
    L7:
        r5 = new VideoGenerateShareHelper$getShareVideoUrlAsMessage$1(this, r28);
        goto L8
    }

    public static VideoShareCallback f(VideoGenerateShareHelper r29, View r30, CoroutineScope r31, l0 r32, nr9.g r33, String r34, ShareScene r35, c4 r36, Integer r37, String r38, Map r39, int r40) {
        if ((r40 & 32) == 0) goto L5;
        ShareScene r5 = ShareScene.VIDEO_VIEWER;
    L7:
        if ((r40 & 128) == 0) goto L9;
        c4 r1 = null;
    L11:
        if ((r40 & 512) == 0) goto L13;
        Integer r10 = null;
    L15:
        if ((r40 & 2048) == 0) goto L17;
        Map r12 = null;
    L18:
        r29.getClass();
        Intrinsics.checkNotNullParameter(r30, "shareContainer");
        Intrinsics.checkNotNullParameter(r31, "scope");
        Intrinsics.checkNotNullParameter(r34, "messageId");
        Intrinsics.checkNotNullParameter(r5, "shareScene");
        if (r1 != null) goto L22;
        r1 = new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    L22:
        return new VideoShareCallback(r34, r30, r5, r31, r32, r1, r33, r10, r38, r12);
    L17:
        r12 = r39;
        goto L18
    L13:
        r10 = r37;
        goto L15
    L9:
        r1 = r36;
        goto L11
    L5:
        r5 = r35;
        goto L7
    }

    public static void i(View r19, CoroutineScope r20, l0 r21, nr9.g r22, String r23, ShareScene r24, com.larus.bmhome.share.panel.h r25, c4 r26, boolean r27, Integer r28, String r29, Map r30, Integer r31) {
        Intrinsics.checkNotNullParameter(r19, "shareContainer");
        Intrinsics.checkNotNullParameter(r20, "scope");
        Intrinsics.checkNotNullParameter(r23, "messageId");
        Intrinsics.checkNotNullParameter(r24, "shareScene");
        BuildersKt.launch$default(r20, Dispatchers.getIO(), null, new VideoGenerateShareHelper$shareWithShareService$1(r23, r19, r24, r20, r21, r26, r22, r28, r29, r30, r31, r25, r27, null), 2, null);
    }

    public static /* synthetic */ void j(VideoGenerateShareHelper r15, View r16, CoroutineScope r17, l0 r18, nr9.g r19, String r20, ShareScene r21, com.larus.bmhome.share.panel.h r22, c4 r23, Integer r24, String r25, Map r26, Integer r27, int r28) {
        if ((r28 & 32) == 0) goto L5;
        ShareScene r7 = ShareScene.VIDEO_VIEWER;
    L7:
        if ((r28 & 64) == 0) goto L9;
        com.larus.bmhome.share.panel.h r8 = null;
    L11:
        if ((r28 & 128) == 0) goto L13;
        c4 r9 = null;
    L15:
        if ((r28 & 256) == 0) goto L17;
        boolean r10 = true;
    L19:
        if ((r28 & 512) == 0) goto L21;
        Integer r11 = null;
    L23:
        if ((r28 & 2048) == 0) goto L25;
        Map r13 = null;
    L27:
        if ((r28 & 4096) == 0) goto L29;
        Integer r14 = null;
    L30:
        r15.getClass();
        i(r16, r17, r18, r19, r20, r7, r8, r9, r10, r11, r25, r13, r14);
        return;
    L29:
        r14 = r27;
        goto L30
    L25:
        r13 = r26;
        goto L27
    L21:
        r11 = r24;
        goto L23
    L17:
        r10 = false;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r8 = r22;
        goto L11
    L5:
        r7 = r21;
        goto L7
    }

    public static void h(final Context r34, DialogFragment r35, final jr9.a r36, DialogFragment r37, final String r38, View r39, ShareScene r40, CoroutineScope r41, l0 r42, c4 r43, final nr9.g r44, String r45, Integer r46, final String r47, Map r48) {
        String r15 = "VideoGenerateShareHelper";
        Intrinsics.checkNotNullParameter(r36, "shareItemConfig");
        Intrinsics.checkNotNullParameter(r38, "messageId");
        Intrinsics.checkNotNullParameter(r39, "shareContainer");
        Intrinsics.checkNotNullParameter(r40, "shareScene");
        Intrinsics.checkNotNullParameter(r41, "scope");
        Intrinsics.checkNotNullParameter(r43, "eventParams");
        if (r42 != null) goto L5;
        final l0 r12 = new l0(r39.getContext(), 0.0f, false, 6);
    L6:
        r12.setCancelable(true);
        if (r35 != null) goto L80;
    L14:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r45;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L71
        FLogger.a.i("VideoGenerateShareHelper", "Save video start type video , channel aweme currentType = " + r36.c());     // Catch: Throwable -> L71
        if (Intrinsics.areEqual(r36.b(), "report") == false) goto L79;
        IAIChatService.Companion r1 = IAIChatService.a;     // Catch: Throwable -> L71
        if (r46 == null) goto L20;
        int r18 = r46.intValue();     // Catch: Throwable -> L71
    L21:
        if (r46 != null) goto L24;
    L28:
        String r2 = r38;
    L29:
        Intrinsics.checkNotNullParameter(r2, "entityId");     // Catch: Throwable -> L71
        TipOffDialogParams r3 = new TipOffDialogParams(r18, r2, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L71
        r3.g = 0;     // Catch: Throwable -> L71
        BaseTipOffDialog r4 = r1.g8(r3);     // Catch: Throwable -> L71
        if (r37 == null) goto L32;
        a(r4, r37.getParentFragmentManager());     // Catch: Throwable -> L71
        return;
    L32:
        FragmentActivity r5 = r39.getContext();     // Catch: Throwable -> L71
        if ((r5 instanceof FragmentActivity) == false) goto L35;
        FragmentActivity r6 = r5;     // Catch: Throwable -> L71
    L36:
        if (r6 == null) goto L85;
        FragmentManager r7 = r6.getSupportFragmentManager();     // Catch: Throwable -> L71
        if (r7 == null) goto L86;
        a(r4, r7);     // Catch: Throwable -> L71
        return;
    L86:
        return;
    L85:
        return;
    L35:
        r6 = null;
        goto L36
    L24:
        if (r46.intValue() != 8) goto L28;
        if (r47 != null) goto L27;
        r2 = "";
        goto L29
    L27:
        r2 = r47;
        goto L29
    L20:
        r18 = 2;
        goto L21
    L79:
        if (Intrinsics.areEqual(r36.b(), ShareChannel.SAVE_VIDEO) == false) goto L65;
        c(r12);     // Catch: Throwable -> L71
        VideoGenerateSaver r8 = VideoGenerateSaver.a;     // Catch: Throwable -> L71
        JSONObject r9 = r43.m;     // Catch: Throwable -> L71
        if (r9 == null) goto L47;
        String r11 = r9.toString();     // Catch: Throwable -> L71
        if (r11 == null) goto L47;
    L48:
        JSONObject r13 = new JSONObject(r11);     // Catch: Throwable -> L71
        String r14 = (String) r36.b.get("_mixed_richmedia_download_trace");     // Catch: Throwable -> L71
        if (r14 == null) goto L51;
        r13.put("_mixed_richmedia_download_trace", r14);     // Catch: Throwable -> L71
    L51:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L71
        com.larus.bmhome.video.save_share.a.C0044a.a(r8, r34, r44, c4.a(r43, r13), "share_panel_click", r41, false, z2.a.Q3(), r43.m, r48, null, true, new f(r34, r12, r38, r47), 544);     // Catch: Throwable -> L62
        if (r37 != null) goto L82;
        return;
    L82:
        r37.dismiss();     // Catch: Exception -> L57 Throwable -> L62
    L89:
        return;
    L57:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L62
        Throwable r17 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L62
        if (r17 == null) goto L87;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L62
        return;
    L87:
        return;
    L47:
        r11 = "{}";
        goto L48
    L65:
        r15 = "VideoGenerateShareHelper";
        if (Intrinsics.areEqual(r36.b(), ShareChannel.DOUYIN) == false) goto L69;
        c(r12);     // Catch: Throwable -> L62
        com.larus.bmhome.video.save_share.a.C0044a.a(VideoGenerateSaver.a, r34, r44, new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383), "", r41, false, false, null, r48, null, true, new g(r34, r36, r44, r12), 704);     // Catch: Throwable -> L62
        return;
    L69:
        Object r19 = Result.constructor-impl(BuildersKt.launch$default(r41, Dispatchers.getIO(), null, new VideoGenerateShareHelper$shareVideo$1$6(r0, r39, r40, r38, r44, r47, r34, r36, null), 2, null));     // Catch: Throwable -> L62
    L74:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L90;
        FLogger.a.e(r15, "Save video error state ", r20);
        return;
    L90:
        return;
    L62:
        th = th;
    L73:
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L71:
        th = th;
        goto L73
    L80:
        r35.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r22 = DialogFragmentLancet.sLastShowStack;
        if (r22 == null) goto L14;
        com.bytedance.crash.d.d(r22, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L5:
        r12 = r42;
        goto L6
    }
}
