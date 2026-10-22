package com.larus.bmhome.music.protocol;

import android.accounts.NetworkErrorException;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.music.save_video.MusicVideoSaver;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.home.impl.sdk.b1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.security.api.ReportDialogHelper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.StringReader;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kr8.t;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MusicShareApi {
    public static final MusicShareApi a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/music/protocol/MusicShareApi$SaveBigMusicShareInfoData;", "Landroid/os/Parcelable;", "shareId", "", "<init>", "(Ljava/lang/String;)V", "getShareId", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SaveBigMusicShareInfoData implements Parcelable {
        public static final Parcelable.Creator<SaveBigMusicShareInfoData> CREATOR = null;

        @SerializedName("share_id")
        private final String shareId;

        public static final class a implements Parcelable.Creator<SaveBigMusicShareInfoData> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SaveBigMusicShareInfoData createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                return new SaveBigMusicShareInfoData(r2.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SaveBigMusicShareInfoData[] newArray(int r1) {
                return new SaveBigMusicShareInfoData[r1];
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

        public SaveBigMusicShareInfoData() {
            this("");
        }

        public final String a() {
            return this.shareId;
        }

        public SaveBigMusicShareInfoData(String r1) {
            this.shareId = r1;
        }
    }

    public static final class ShareCallback implements com.larus.bmhome.share.panel.d {
        public final ViewGroup a;
        public final CoroutineScope b;
        public final l0 c;
        public final String d;
        public final MusicCreationContent e;
        public final String f;
        public final Message g;
        public final kr8.o h;
        public String i;
        public DialogFragment j;
        public com.larus.bmhome.share.panel.h k;

        /* JADX INFO: renamed from: com.larus.bmhome.music.protocol.MusicShareApi$ShareCallback$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.music.protocol.MusicShareApi$ShareCallback$1", f = "MusicShareApi.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ ShareCallback this$0;

            public AnonymousClass1(ShareCallback r1, Continuation<? super AnonymousClass1> r2) {
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

            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ShareCallback r2 = (ShareCallback) this.L$0;
                ResultKt.throwOnFailure(r11);
            L12:
                r2.i = (String) r11;
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r11);
                ShareCallback r12 = this.this$0;
                MusicShareApi r3 = MusicShareApi.a;
                ViewGroup r4 = r12.a;
                String r5 = r12.f;
                Message r6 = r12.g;
                MusicCreationContent r7 = r12.e;
                this.L$0 = r12;
                this.label = 1;
                Object r8 = r3.b(r4, r5, r6, r7, false, this);
                if (r8 != r0) goto L11;
                return r0;
            L11:
                r2 = r12;
                r11 = r8;
                goto L12
            }
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean d(String r1, String r2, Boolean r3) {
            return true;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void f() {
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void onDismiss() {
        }

        public static void a(l0 r3) {
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

        @Override // com.larus.bmhome.share.panel.d
        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r27v0, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r27v1 */
        /* JADX WARN: Type inference failed for: r27v2 */
        /* JADX WARN: Type inference failed for: r27v3 */
        /* JADX WARN: Type inference failed for: r27v4 */
        /* JADX WARN: Type inference failed for: r27v5 */
        /* JADX WARN: Type inference failed for: r27v6 */
        /* JADX WARN: Type inference failed for: r27v7 */
        /* JADX WARN: Type inference failed for: r27v8 */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
        @Override // com.larus.bmhome.share.panel.d
        public final boolean b(final Context r25, DialogFragment r26, View r27, final jr9.a r28) {
            Intrinsics.checkNotNullParameter(r28, "shareItemConfig");
            if (r26 != null) goto L83;
        L10:
            com.larus.bmhome.share.panel.h r0 = this.k;
            FragmentActivity r4 = null;
            if (r0 == null) goto L13;
            String r1 = r0.e;
        L15:
            if (Intrinsics.areEqual(r1, "creation_detail") == false) goto L17;
            String r2 = "profile_private_music_share_save_video";
        L18:
            IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r5 == null) goto L82;
            r5.D0();
            b1.a.c(r2);
        L82:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L71
            FLogger.a.i("MusicShareApi", "Save music video start type video , channel aweme");     // Catch: Throwable -> L71
            if (Intrinsics.areEqual(r28.b(), "report") == false) goto L30;
            ReportDialogHelper r6 = ReportDialogHelper.a;     // Catch: Throwable -> L71
            DialogFragment r7 = this.j;     // Catch: Throwable -> L71
            if (r7 == null) goto L27;
            r4 = r7.getActivity();     // Catch: Throwable -> L71
        L27:
            String r8 = this.f;     // Catch: Throwable -> L71
            String r9 = this.i;     // Catch: Throwable -> L71
            Function0 r10 = new l(this, r25);     // Catch: Throwable -> L71
            r6.getClass();     // Catch: Throwable -> L71
            ReportDialogHelper.c(r4, r8, r9, r10);     // Catch: Throwable -> L71
            return true;
        L30:
            if (TextUtils.isEmpty(this.e.getLyricsSeekContent()) == true) goto L32;
            JsonReader r11 = new JsonReader(new StringReader(this.e.getLyricsSeekContent()));     // Catch: Throwable -> L71
            r11.setLenient(true);     // Catch: Throwable -> L71
            LyricsSeekContent r12 = (LyricsSeekContent) HttpExtKt.f.fromJson(r11, LyricsSeekContent.class);     // Catch: Throwable -> L71
        L85:
            if (Intrinsics.areEqual(r28.b(), ShareChannel.SAVE_VIDEO) == false) goto L57;
            l0 r13 = this.c;     // Catch: Throwable -> L71
            if (r13 != null) goto L38;
        L43:
            MusicVideoSaver r14 = MusicVideoSaver.a;     // Catch: Throwable -> L71
            boolean r17 = true;
            r27 = "MusicShareApi";
            MusicVideoSaver.k(r25, this.a, UUID.randomUUID().toString(), this.e, r12, this.d, "click_share", this.g, this.b, this.h, new m(r25, this), 512);     // Catch: Throwable -> L54
            DialogFragment r15 = this.j;     // Catch: Throwable -> L54
            if (r15 != null) goto L80;
        L56:
            return true;
        L80:
            r15.dismiss();     // Catch: Exception -> L49 Throwable -> L54
        L49:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L54
            Throwable r16 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L54
            if (r16 == null) goto L56;
            com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L54
            goto L56
        L38:
            if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L88;
            DialogLancet.handleBlockedDialogShow(r13);     // Catch: Throwable -> L71
            goto L43
        L88:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L78 Throwable -> L71
        L42:
            DialogLancet.beforeDialogShow(r13);     // Catch: Throwable -> L71
            r13.show();     // Catch: Throwable -> L71
            DialogLancet.afterDialogShow(r13);     // Catch: Throwable -> L71
            goto L43
        L57:
            ?? r29 = "MusicShareApi";
            r17 = true;
            if (Intrinsics.areEqual(r28.b(), ShareChannel.DOUYIN) == false) goto L69;
            l0 r18 = this.c;     // Catch: Throwable -> L54
            if (r18 != null) goto L62;
        L67:
            MusicVideoSaver r19 = MusicVideoSaver.a;     // Catch: Throwable -> L54
            MusicVideoSaver.k(r25, this.a, UUID.randomUUID().toString(), this.e, r12, this.d, "click_share", this.g, this.b, this.h, new n(r25, r28, this), 512);     // Catch: Throwable -> L54
            return true;
        L62:
            if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L86;
            DialogLancet.handleBlockedDialogShow(r18);     // Catch: Throwable -> L54
            goto L67
        L86:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Throwable -> L54 Exception -> L79
        L66:
            DialogLancet.beforeDialogShow(r18);     // Catch: Throwable -> L54
            r18.show();     // Catch: Throwable -> L54
            DialogLancet.afterDialogShow(r18);     // Catch: Throwable -> L54
            goto L67
        L69:
            Object r20 = Result.constructor-impl(BuildersKt.launch$default(this.b, Dispatchers.getIO().plus(t.a), null, new MusicShareApi$ShareCallback$onInterceptClick$1$4(this, r25, r28, null), 2, null));     // Catch: Throwable -> L54
        L74:
            Throwable r21 = Result.exceptionOrNull-impl(r20);
            if (r21 == null) goto L77;
            FLogger.a.e(r29, "Save music video error state ", r21);
        L77:
            return r17;
        L54:
            th = th;
            ?? r210 = r27;
        L73:
            Result.Companion r22 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
            r29 = r210;
            goto L74
        L32:
            r12 = null;
        L71:
            th = th;
            r210 = "MusicShareApi";
            r17 = true;
            goto L73
        L17:
            r2 = "music_share_save_video_chat";
            goto L18
        L13:
            r1 = null;
            goto L15
        L83:
            r26.dismiss();     // Catch: Exception -> L6
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r23 = DialogFragmentLancet.sLastShowStack;
            if (r23 == null) goto L10;
            com.bytedance.crash.d.d(r23, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
        }

        public ShareCallback(ViewGroup r2, CoroutineScope r3, l0 r4, String r5, String r6, MusicCreationContent r7, String r8, Message r9, kr8.o r10) {
            Intrinsics.checkNotNullParameter(r2, "shareContainer");
            Intrinsics.checkNotNullParameter(r3, "scope");
            Intrinsics.checkNotNullParameter(r5, "currentPage");
            Intrinsics.checkNotNullParameter(r6, "clickFrom");
            Intrinsics.checkNotNullParameter(r7, "musicContent");
            Intrinsics.checkNotNullParameter(r8, "messageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = "";
            BuildersKt.launch$default(r3, Dispatchers.getIO().plus(t.a), null, new AnonymousClass1(this, null), 2, null);
        }
    }

    static {
        a = new MusicShareApi();
    }

    public MusicShareApi() {
    }

    public static void a(l0 r3) {
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

    public final Object b(View r6, String r7, Message r8, MusicCreationContent r9, boolean r10, Continuation<? super String> r11) {
        if (r9.getContentType() != 1) goto L6;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.larus.bmhome.instruction.core.model.music.MusicGenTemplate");
        bq8.a r12 = (bq8.a) r9;
        return UriProtector.parse(r12.getShareInfo()).buildUpon().appendQueryParameter("vid", r12.getVid()).appendQueryParameter("source_type", "mobile").appendQueryParameter("template_id", String.valueOf(r12.a)).build().toString();
    L6:
        if (r9.getContentType() != 2) goto L10;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.larus.bmhome.music.protocol.MusicGenCreation");
        f r13 = (f) r9;
        return UriProtector.parse(r13.getShareInfo()).buildUpon().appendQueryParameter("vid", r13.getVid()).appendQueryParameter("source_type", "mobile").appendQueryParameter("creation_id", String.valueOf(r13.a)).build().toString();
    L10:
        return c(r6, r7, r8, r9, r10, r11);
    }

    public final Object c(View r25, String r26, Message r27, MusicCreationContent r28, boolean r29, Continuation<? super String> r30) {
        final View r1 = r25;
        if ((r30 instanceof MusicShareApi$getShareMusicUrlAsMessage$1) == false) goto L7;
        MusicShareApi$getShareMusicUrlAsMessage$1 r2 = (MusicShareApi$getShareMusicUrlAsMessage$1) r30;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MusicShareApi$getShareMusicUrlAsMessage$1 r14 = r2;
        Object r0 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L25;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        Context r6 = (Context) r14.L$3;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r14.L$2;
        MusicCreationContent r8 = (MusicCreationContent) r14.L$1;
        View r9 = (View) r14.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: NetworkErrorException -> L15
        View r20 = r9;
        String r23 = "task_id";
        MusicCreationContent r10 = r8;
        final Ref.ObjectRef r11 = r7;
        Context r12 = r6;
        int r13 = 2131909350;
    L90:
        y r15 = (com.larus.network.http.a) r0;     // Catch: NetworkErrorException -> L68
        if ((r15 instanceof y) == false) goto L55;
        SaveBigMusicShareInfoData r16 = (SaveBigMusicShareInfoData) ((com.larus.network.http.a) r15).b;     // Catch: NetworkErrorException -> L68
        if (r16 == null) goto L55;
        String r17 = r16.a();     // Catch: NetworkErrorException -> L68
        if (r17 == null) goto L55;
    L57:
        if (r17.length() <= 0) goto L59;
        boolean r18 = true;
    L60:
        if (r18 == false) goto L66;
        Uri r19 = UriProtector.parse(r10.getShareInfo()).buildUpon().appendQueryParameter("vid", r10.getVid()).appendQueryParameter("source_type", "mobile").appendQueryParameter("share_id", r17).appendQueryParameter(r23, r10.getPlayList().getItemId()).build();     // Catch: NetworkErrorException -> L68
        l0 r21 = (l0) r11.element;     // Catch: NetworkErrorException -> L68
        if (r21 == null) goto L65;
        a(r21);     // Catch: NetworkErrorException -> L68
    L65:
        return r19.toString();
    L66:
        String r22 = r12.getString(r13);     // Catch: NetworkErrorException -> L68
        s r24 = s.a;     // Catch: NetworkErrorException -> L68
        Application r31 = AppHost.a.getApplication();     // Catch: NetworkErrorException -> L68
        r24.getClass();     // Catch: NetworkErrorException -> L68
        s.c(r31, r22);     // Catch: NetworkErrorException -> L68
    L78:
        r20.post(new k(r11));
        return "";
    L59:
        r18 = false;
    L55:
        r17 = "";
    L68:
        e = e;
    L69:
        Context r32 = r12;
    L77:
        String r33 = r32.getString(r13);
        s r34 = s.a;
        Application r35 = AppHost.a.getApplication();
        r34.getClass();
        s.c(r35, r33);
        FLogger.a.i("MusicShareApi", "share failed " + e);
    L15:
        e = e;
        r11 = r7;
        r20 = r9;
        r12 = r6;
    L24:
        r13 = 2131909350;
        goto L69
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Context r36 = (Context) r14.L$4;
        r11 = (Ref.ObjectRef) r14.L$3;
        MusicCreationContent r37 = (MusicCreationContent) r14.L$2;
        String r38 = (String) r14.L$1;
        View r39 = (View) r14.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: NetworkErrorException -> L22
        Context r40 = r36;
        r1 = r39;
    L36:
        Context r110 = r40;
        Ref.ObjectRef r111 = r11;
        MusicCreationContent r41 = r37;
    L80:
        String r42 = r41.getPlayList().getItemId();     // Catch: NetworkErrorException -> L72
        r14.L$0 = r1;     // Catch: NetworkErrorException -> L72
        r14.L$1 = r41;     // Catch: NetworkErrorException -> L72
        r14.L$2 = r111;     // Catch: NetworkErrorException -> L72
        r14.L$3 = r110;     // Catch: NetworkErrorException -> L72
        r14.L$4 = null;     // Catch: NetworkErrorException -> L72
        r14.label = 2;     // Catch: NetworkErrorException -> L72
        JSONObject r43 = new JSONObject();     // Catch: NetworkErrorException -> L72
        r43.put(MusicAppletPage.KEY_MESSAGE_ID, r38);     // Catch: NetworkErrorException -> L72
        if (TextUtils.isEmpty(r42) == true) goto L43;
        r43.put("task_id", r42);     // Catch: NetworkErrorException -> L72
    L43:
        Unit r44 = Unit.INSTANCE;     // Catch: NetworkErrorException -> L72
        Context r112 = r110;
        Ref.ObjectRef r113 = r111;
        r23 = "task_id";
        r20 = r1;
        r13 = 2131909350;
        Object r45 = HttpExtKt.k("Social", SaveBigMusicShareInfoData.class, "/alice/media/bigmusic/share_save", r43, null, null, false, null, null, null, r14, 1008);     // Catch: NetworkErrorException -> L70
        if (r45 != r4) goto L48;
        return r4;
    L48:
        r10 = r41;
        r0 = r45;
        r12 = r112;
        r11 = r113;
    L70:
        e = e;
    L74:
        r32 = r112;
        r11 = r113;
    L72:
        e = e;
        r20 = r1;
        r112 = r110;
        r113 = r111;
        r13 = 2131909350;
    L22:
        e = e;
        r12 = r36;
        r20 = r39;
        goto L24
    L25:
        ResultKt.throwOnFailure(r0);
        r11 = new Ref.ObjectRef();
        r32 = r25.getContext();
        if (TextUtils.isEmpty(r26) == false) goto L28;
        return "";
    L28:
        if (r29 == false) goto L86;
        r1.post(new j(r11, r1));
    L86:
        if (TextUtils.isEmpty(r28.getVid()) == true) goto L88;
        r38 = r26;
        r111 = r11;
        r110 = r32;
        r41 = r28;
        goto L80
    L88:
        MusicPullingApi r46 = MusicPullingApi.a;     // Catch: NetworkErrorException -> L37
        String r47 = r28.getPlayList().getItemId();     // Catch: NetworkErrorException -> L37
        r14.L$0 = r1;     // Catch: NetworkErrorException -> L37
        r38 = r26;
        r14.L$1 = r38;     // Catch: NetworkErrorException -> L37
        r14.L$2 = r28;     // Catch: NetworkErrorException -> L37
        r14.L$3 = r11;     // Catch: NetworkErrorException -> L37
        r14.L$4 = r32;     // Catch: NetworkErrorException -> L37
        r14.label = 1;     // Catch: NetworkErrorException -> L37
        if (MusicPullingApi.a.b(r27, r47, 20, r14) != r4) goto L35;
        return r4;
    L35:
        r40 = r32;
        r37 = r28;
    L37:
        e = e;
        r20 = r1;
        r12 = r32;
    L75:
        e = e;
        r13 = 2131909350;
        r20 = r25;
    L7:
        r2 = new MusicShareApi$getShareMusicUrlAsMessage$1(this, r30);
        goto L8
    }

    public static void d(ViewGroup r19, CoroutineScope r20, l0 r21, String r22, String r23, String r24, Message r25, MusicCreationContent r26, ShareScene r27, com.larus.bmhome.share.panel.h r28, String r29, kr8.o r30, int r31) {
        if ((r31 & 256) == 0) goto L5;
        ShareScene r13 = ShareScene.MUSIC_VIDEO;
    L7:
        if ((r31 & 512) == 0) goto L9;
        com.larus.bmhome.share.panel.h r12 = null;
    L11:
        if ((r31 & 1024) == 0) goto L13;
        boolean r14 = true;
    L15:
        if ((r31 & 2048) == 0) goto L17;
        String r15 = null;
    L19:
        if ((r31 & 4096) == 0) goto L21;
        kr8.o r11 = null;
    L22:
        Intrinsics.checkNotNullParameter(r19, "shareContainer");
        Intrinsics.checkNotNullParameter(r20, "scope");
        Intrinsics.checkNotNullParameter(r22, "currentPage");
        Intrinsics.checkNotNullParameter(r23, "clickFrom");
        Intrinsics.checkNotNullParameter(r24, "messageId");
        Intrinsics.checkNotNullParameter(r26, "musicContent");
        Intrinsics.checkNotNullParameter(r13, "shareScene");
        BuildersKt.launch$default(r20, Dispatchers.getIO().plus(t.a), null, new MusicShareApi$shareWithShareService$1(r19, r20, r21, r22, r23, r26, r24, r25, r11, r12, r13, r14, r15, null), 2, null);
        return;
    L21:
        r11 = r30;
        goto L22
    L17:
        r15 = r29;
        goto L19
    L13:
        r14 = false;
        goto L15
    L9:
        r12 = r28;
        goto L11
    L5:
        r13 = r27;
        goto L7
    }
}
