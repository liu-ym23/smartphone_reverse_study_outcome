package com.larus.bmhome.music.widget;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.e4;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageWebpLoadingBgView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.music.edit.MusicInfoEditHelper;
import com.larus.bmhome.music.protocol.MusicShareApi;
import com.larus.bmhome.music.utils.MusicCreationHelperKt;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.utils.SwipingControlVm;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.LyricsUtterances;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LyricsToSongCardView extends FrameLayout implements com.larus.bmhome.music.player.a.InterfaceC0021a {
    public static final /* synthetic */ int U = 0;
    public final View A;
    public boolean B;
    public int C;
    public LyricsSeekContent D;
    public Map<String, Pair<String, Integer>> E;
    public final ViewGroup F;
    public final RoundConstraintLayout G;
    public int H;
    public final TextView I;
    public int J;
    public b K;
    public boolean L;
    public Function0<Unit> M;
    public String N;
    public String O;
    public boolean P;
    public final LyricsToSongCardView$lifecycleObserver$1 Q;
    public boolean R;
    public boolean S;
    public final Lazy T;
    public final Context a;
    public final FrameLayout b;
    public final TextView c;
    public final AuthorView d;
    public final SimpleDraweeView e;
    public final ImageWebpLoadingBgView f;
    public final SimpleDraweeView g;
    public final com.larus.bmhome.music.player.a h;
    public Message i;
    public MusicCreationContent j;
    public com.larus.bmhome.chat.api.q0.a k;
    public Fragment l;
    public int m;
    public String n;
    public final CircleProgressBar o;
    public final LottieAdapterView p;
    public final ImageView q;
    public final ImageView r;
    public final View s;
    public final View t;
    public final View u;
    public final TextView v;
    public final MusicBoxLyricView w;
    public final FrameLayout x;
    public final ImageView y;
    public final ImageView z;

    public static final class a {
    }

    public interface b {
        void mK(Message r1);
    }

    public static final class c implements com.larus.bmhome.music.edit.a {
        public final /* synthetic */ LyricsToSongCardView a;

        @Override // com.larus.bmhome.music.edit.a
        public final void b(ModifiedUserCreationMusic r1) {
        }

        @Override // com.larus.bmhome.music.edit.a
        public final com.larus.bmhome.music.edit.j c() {
            Message r1 = this.a.i;
            if (r1 == null) goto L6;
            String r2 = r1.getMessageId();
            if (r2 == null) goto L6;
        L8:
            return new com.larus.bmhome.music.edit.j(r2, "", this.a.j);
        L6:
            r2 = "";
            goto L8
        }

        public c(LyricsToSongCardView r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.music.edit.a
        public final void a(com.larus.bmhome.music.edit.v r5) {
            Intrinsics.checkNotNullParameter(r5, "status");
            com.larus.common_ui.dialog.l0 r0 = LyricsToSongCardView.e(this.a);
            if (r0 == null) goto L22;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r0);
            goto L22
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r2 == null) goto L18;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L7:
            if (Looper.myLooper() == r1.getLooper()) goto L9;
            r1.post(DialogLancet.createDismissRunnable(r0));
        L22:
            if ((r5 instanceof com.larus.bmhome.music.edit.v.a) == false) goto L28;
            t19.s r3 = t19.s.a;
            Context r4 = this.a.getViewContext();
            String r6 = ((com.larus.bmhome.music.edit.v.a) r5).a;
            r3.getClass();
            t19.s.c(r4, r6);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.music.widget.LyricsToSongCardView$setCreationPrivacy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$setCreationPrivacy$1", f = "LyricsToSongCardView.kt", i = {0}, l = {621, 623}, m = "invokeSuspend", n = {"creationId"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $buttonStatus;
        final /* synthetic */ int $previousStatus;
        final /* synthetic */ int $privateStatus;
        Object L$0;
        int label;
        final /* synthetic */ LyricsToSongCardView this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.music.widget.LyricsToSongCardView$setCreationPrivacy$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$setCreationPrivacy$1$1", f = "LyricsToSongCardView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $previousStatus;
            int label;
            final /* synthetic */ LyricsToSongCardView this$0;

            public C00281(LyricsToSongCardView r1, int r2, Continuation<? super C00281> r3) {
                this.this$0 = r1;
                this.$previousStatus = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00281(this.this$0, this.$previousStatus, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                LyricsToSongCardView r4 = this.this$0;
                int r0 = this.$previousStatus;
                int r1 = LyricsToSongCardView.U;
                r4.p(r0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(LyricsToSongCardView r1, int r2, int r3, int r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$privateStatus = r2;
            this.$buttonStatus = r3;
            this.$previousStatus = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$privateStatus, this.$buttonStatus, this.$previousStatus, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r2 = "";
            String r5 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L84:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r9);
        L44:
            Pair r10 = (Pair) r9;
            if (r10 == null) goto L47;
            Boolean r11 = (Boolean) r10.getFirst();
        L49:
            if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == true) goto L54;
            MainCoroutineDispatcher r12 = Dispatchers.getMain();
            C00281 r4 = new C00281(this.this$0, this.$previousStatus, null);
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(r12, r4, this) != r0) goto L84;
            return r0;
        L54:
            if (this.$privateStatus != 2) goto L60;
            Context r13 = this.this$0.getContext();
            if (r13 == null) goto L66;
            Resources r14 = r13.getResources();
            if (r14 == null) goto L66;
            int r6 = 2131900633;
        L65:
            r5 = r14.getString(r6);
        L66:
            t19.s r15 = t19.s.a;
            Context r7 = this.this$0.getContext();
            if (r5 != null) goto L69;
            r5 = "";
        L69:
            r15.getClass();
            t19.s.p(r7, r5);
            if (this.$privateStatus != 2) goto L72;
            com.larus.platform.service.e0.a.X0(r3);
        L72:
            LyricsToSongCardView r16 = this.this$0;
            r16.J = this.$buttonStatus;
            Map<String, Pair<String, Integer>> r8 = r16.E;
            if (r8 == null) goto L84;
            String r17 = LyricsToSongCardView.n(r16.j);
            LyricsToSongCardView r18 = this.this$0;
            Map<String, Pair<String, Integer>> r19 = r18.E;
            if (r19 == null) goto L82;
            Pair r20 = (Pair) ((LinkedHashMap) r19).get(LyricsToSongCardView.n(r18.j));
            if (r20 == null) goto L82;
            String r21 = (String) r20.getFirst();
            if (r21 == null) goto L82;
            r2 = r21;
        L82:
            r8.put(r17, TuplesKt.to(r2, Boxing.boxInt(this.$privateStatus)));
            goto L84
        L60:
            Context r22 = this.this$0.getContext();
            if (r22 == null) goto L66;
            r14 = r22.getResources();
            if (r14 == null) goto L66;
            r6 = 2131900634;
            goto L65
        L47:
            r11 = null;
            goto L49
        L10:
            ResultKt.throwOnFailure(r9);
            LyricsToSongCardView r23 = this.this$0;
            Map<String, Pair<String, Integer>> r24 = r23.E;
            if (r24 == null) goto L22;
            MusicCreationContent r25 = r23.j;
            if (r25 == null) goto L15;
            String r26 = zc9.i0.a(r25);
        L16:
            Pair r27 = (Pair) ((LinkedHashMap) r24).get(r26);
            if (r27 == null) goto L22;
            String r28 = (String) r27.getFirst();
            if (r28 == null) goto L22;
            r3 = r28;
        L24:
            if (r3.length() != 0) goto L26;
            boolean r29 = true;
        L27:
            if (r29 == false) goto L30;
            this.this$0.u();
            return Unit.INSTANCE;
        L30:
            com.larus.platform.service.e0 r30 = com.larus.platform.service.e0.a;
            LyricsToSongCardView r31 = this.this$0;
            Map<String, Pair<String, Integer>> r32 = r31.E;
            if (r32 == null) goto L40;
            MusicCreationContent r33 = r31.j;
            if (r33 == null) goto L35;
            String r34 = zc9.i0.a(r33);
        L36:
            Pair r35 = (Pair) ((LinkedHashMap) r32).get(r34);
            if (r35 == null) goto L40;
            String r36 = (String) r35.getFirst();
            if (r36 == null) goto L40;
        L41:
            int r37 = this.$privateStatus;
            this.L$0 = r3;
            this.label = 1;
            r9 = r30.h(r36, r37, this);
            if (r9 != r0) goto L44;
            return r0;
        L35:
            r34 = null;
        L40:
            r36 = "";
            goto L41
        L26:
            r29 = false;
            goto L27
        L15:
            r26 = null;
        L22:
            r3 = "";
            goto L24
        }
    }

    static {
    }

    public final void l() {
        this.B = true;
        if (this.S == false) goto L5;
        return;
    L5:
        this.S = true;
        FLogger r0 = FLogger.a;
        r0.i("LyricsToSong", "loading view start animation");
        r0.i("LyricsToSong", "loading view show");
        LottieAdapterView r1 = this.p;
        if (r1 == null) goto L8;
        r1.setAlpha(1.0f);
    L8:
        LottieAdapterView r2 = this.p;
        if (r2 == null) goto L11;
        r2.setRepeatCount(-1);
    L11:
        LottieAdapterView r3 = this.p;
        if (r3 == null) goto L14;
        r3.setAnimation(2131820617);
    L14:
        LottieAdapterView r4 = this.p;
        if (r4 == null) goto L18;
        r4.playAnimation();
        return;
    }

    private final boolean getAutoPauseWhenFragmentPaused() {
        if ((AppHost.a.a().getCurrentActivity() instanceof e4) == false) goto L5;
    L8:
        return true;
    L5:
        if ((getCurBottomTabChatFrag() instanceof IChatDoubleTabAbility) == true) goto L8;
        return false;
    }

    private final Fragment getCurBottomTabChatFrag() {
        if (z2.a.enableChatWithTab() == true) goto L5;
        return null;
    L5:
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L9;
        r0.f0();
        return com.larus.home.impl.sdk.i.a.a();
    L9:
        return null;
    }

    private final com.larus.common_ui.dialog.l0 getLoadingDialog() {
        return (com.larus.common_ui.dialog.l0) this.T.getValue();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lf() {
        CircleProgressBar r0 = this.o;
        if (r0 == null) goto L6;
        r0.setProgress(2);
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lr() {
        FLogger.a.i("StreamingMusicPlayer", "play icon show");
        if (com.larus.bmhome.music.protocol.a.a(this.j) == false) goto L7;
        ImageView r0 = this.q;
        if (r0 == null) goto L13;
        r0.setImageDrawable(ResourcesCompat.getDrawable(getResources(), 2131243100, null));
    L13:
        ImageView r1 = this.q;
        if (r1 == null) goto L16;
        com.larus.utils.e1.x(r1);
    L16:
        ImageView r2 = this.r;
        if (r2 == null) goto L19;
        com.larus.utils.e1.q(r2);
    L19:
        MusicBoxLyricView r3 = this.w;
        if (r3 == null) goto L23;
        r3.U5();
        return;
    L23:
        return;
    L7:
        ImageView r4 = this.q;
        if (r4 == null) goto L10;
        r4.setImageDrawable(ResourcesCompat.getDrawable(getResources(), 2131243095, null));
    L10:
        CircleProgressBar r5 = this.o;
        if (r5 == null) goto L13;
        com.larus.utils.e1.q(r5);
        goto L13
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void OK() {
        ImageView r0 = this.q;
        if (r0 == null) goto L5;
        com.larus.utils.e1.q(r0);
    L5:
        ImageView r1 = this.r;
        if (r1 == null) goto L8;
        com.larus.utils.e1.x(r1);
    L8:
        ImageView r2 = this.r;
        if (r2 == null) goto L11;
        r2.setBackgroundResource(2131243097);
    L11:
        MusicBoxLyricView r3 = this.w;
        if (r3 == null) goto L15;
        r3.T5();
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void UY() {
        CircleProgressBar r0 = this.o;
        if (r0 == null) goto L6;
        com.larus.utils.e1.x(r0);
        return;
    }

    public final String getCurrentStatus() {
        int r0 = this.H;
        if (r0 != 1) goto L5;
        return "-1";
    L5:
        if (r0 != 2) goto L7;
        return TriggerSendLoading.NO_LOADING;
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "1";
    }

    public final String getItemName() {
        RoundConstraintLayout r0 = this.G;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return "go_public";
    L10:
        return "already_public";
    L5:
        if (r0.getVisibility() != 0) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public CoroutineScope getScope() {
        com.larus.bmhome.chat.api.q0.a r0 = this.k;
        if (r0 == null) goto L7;
        LifecycleCoroutineScope r1 = r0.F9();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return GlobalScope.INSTANCE;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void hideLoadingView() {
        CircleProgressBar r0 = this.o;
        if (r0 == null) goto L5;
        com.larus.utils.e1.x(r0);
    L5:
        ImageView r1 = this.r;
        if (r1 == null) goto L9;
        r1.setBackgroundResource(2131243097);
        return;
    }

    public final void k() {
        ImageView r0 = this.y;
        if (r0 == null) goto L5;
        r0.setImageDrawable(ContextCompat.getDrawable(getContext(), 2131242071));
    L5:
        ImageView r1 = this.z;
        if (r1 == null) goto L8;
        r1.setImageDrawable(ContextCompat.getDrawable(getContext(), 2131241234));
    L8:
        ImageView r2 = this.y;
        if (r2 == null) goto L11;
        com.larus.utils.e1.d(r2, new n(this));
    L11:
        ImageView r3 = this.z;
        if (r3 == null) goto L15;
        com.larus.utils.e1.d(r3, new o(this));
        return;
    }

    public final void m() {
        com.larus.bmhome.music.player.f r1 = com.larus.bmhome.music.player.f.a;
        WeakReference<com.larus.bmhome.music.player.a> r2 = com.larus.bmhome.music.player.f.d;
        if (r2 == null) goto L13;
        com.larus.bmhome.music.player.a r3 = r2.get();
        if (r3 == null) goto L13;
        com.larus.bmhome.music.player.j r4 = r3.data();
        if (r4 == null) goto L13;
        ad9.b r5 = r4.g;
        if (r5 == null) goto L13;
        String r6 = r5.getItemId();
        if (r6 == null) goto L13;
        int r7 = CastIntegerProtector.parseInt(r6);
    L14:
        Message r8 = this.i;
        if (r8 == null) goto L18;
        String r9 = r8.getMessageId();
        if (r9 == null) goto L18;
    L19:
        SwipingControlVm.a r0 = new SwipingControlVm.a(r7, r9);
        FLogger.a.i("LyricsToSong", "[emitCurrentlyPlayingMusicInfo] emit:" + r0);
        com.larus.bmhome.chat.api.q0.a r10 = this.k;
        if (r10 == null) goto L27;
        SwipingControlVm r11 = r10.O9();
        if (r11 == null) goto L28;
        MutableSharedFlow<SwipingControlVm.a> r12 = r11.getScrollToPlayingMusicCardFlow();
        if (r12 == null) goto L29;
        r12.tryEmit(r0);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L18:
        r9 = "";
    L13:
        r7 = -1;
        goto L14
    }

    public final void q() {
        FLogger r0 = FLogger.a;
        r0.i("LyricsToSong", "cover image start lottie animation");
        if (this.L == false) goto L15;
        ImageWebpLoadingBgView r2 = this.f;
        if (r2 != null) goto L7;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        r0.i("LyricsToSong", "already show loading bg, skip");
    L21:
        SimpleDraweeView r1 = this.e;
        if (r1 == null) goto L24;
        r1.setImageDrawable(ContextCompat.getDrawable(this.a, 2131239857));
    L24:
        l();
        setShapeCornerColorTint(null);
        return;
    L7:
        if (r2.getVisibility() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 != true) goto L12;
        r3 = true;
        goto L13
    L9:
        r4 = false;
    L15:
        this.L = true;
        ImageWebpLoadingBgView r5 = this.f;
        if (r5 == null) goto L18;
        com.larus.utils.e1.x(r5);
    L18:
        ImageWebpLoadingBgView r6 = this.f;
        if (r6 == null) goto L21;
        com.larus.bmhome.chat.layout.holder.progressloading.e r7 = IAIChatUgcAIGCService.a.x0();
        int r8 = ImageWebpLoadingBgView.d;
        r6.f(r7, false, null, "gen_lyrics_to_song_loading_bg");
        goto L21
    }

    public final void s() {
        ImageView r0 = this.q;
        if (r0 == null) goto L5;
        r0.setImageDrawable(ResourcesCompat.getDrawable(getResources(), 2131243095, null));
    L5:
        ImageView r1 = this.q;
        if (r1 == null) goto L8;
        com.larus.utils.e1.x(r1);
    L8:
        ImageView r2 = this.r;
        if (r2 == null) goto L11;
        com.larus.utils.e1.q(r2);
    L11:
        CircleProgressBar r3 = this.o;
        if (r3 == null) goto L15;
        com.larus.utils.e1.q(r3);
        return;
    }

    public final void u() {
        t19.s r0 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        String r2 = getViewContext().getString(2131907956);
        r0.getClass();
        t19.s.t(r1, r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.larus.bmhome.music.player.a r0 = this.h;
        if (r0 == null) goto L5;
        r0.onAttachedToWindow();
    L5:
        com.larus.bmhome.music.player.a r1 = this.h;
        if (r1 == null) goto L9;
        r1.onResumed();
    L9:
        if (this.P == true) goto L26;
        if (getAutoPauseWhenFragmentPaused() == false) goto L19;
        Fragment r2 = this.l;
        if (r2 == null) goto L24;
        LifecycleOwner r3 = r2.getViewLifecycleOwner();
        if (r3 == null) goto L24;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L24;
        r4.addObserver(this.Q);
    L24:
        this.P = true;
        goto L26
    L19:
        Fragment r5 = this.l;
        if (r5 == null) goto L24;
        Lifecycle r6 = r5.getLifecycle();
        if (r6 == null) goto L24;
        r6.addObserver(this.Q);
    L26:
        if (this.B == false) goto L29;
        l();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.larus.bmhome.music.player.a r0 = this.h;
        if (r0 == null) goto L6;
        r0.onDetachedFromWindow();
        return;
    }

    public final void r() {
        FragmentActivity r0 = getContext();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 != null) goto L9;
        FLogger.a.e("LyricsToSong", "[launchEditMusicName] context is not FragmentActivity");
        return;
    L9:
        MusicInfoEditHelper.f(r1, new c(this), false, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void showLoadingView() {
        OK();
        ImageView r0 = this.r;
        if (r0 == null) goto L5;
        com.larus.utils.e1.x(r0);
    L5:
        CircleProgressBar r1 = this.o;
        if (r1 == null) goto L8;
        com.larus.utils.e1.x(r1);
    L8:
        CircleProgressBar r2 = this.o;
        if (r2 == null) goto L12;
        r2.setProgress(2);
    L12:
        if (com.larus.bmhome.music.protocol.a.a(this.j) == false) goto L16;
        ImageView r3 = this.r;
        if (r3 == null) goto L18;
        r3.setBackgroundResource(2131243097);
        return;
    L18:
        return;
    L16:
        s();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void F6() {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.b();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void FK() {
        Lr();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void f20() {
        OK();
    }

    public final Function0<Unit> getRebindListener() {
        return this.M;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public Context getViewContext() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.bmhome.music.widget.LyricsToSongCardView$lifecycleObserver$1] */
    public LyricsToSongCardView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "mContext");
        super(r5);
        this.a = r5;
        this.n = "";
        this.J = 2;
        View r0 = LayoutInflater.from(getContext()).inflate(2131563261, this);
        this.c = (TextView) r0.findViewById(2131386981);
        this.d = (AuthorView) r0.findViewById(2131386977);
        SimpleDraweeView r1 = r0.findViewById(2131368153);
        this.e = r1;
        com.larus.utils.w0.e(r1, c7.b(10));
        ImageWebpLoadingBgView r2 = r0.findViewById(2131368161);
        this.f = r2;
        com.larus.utils.w0.e(r2, c7.b(10));
        this.g = r0.findViewById(2131368156);
        this.b = (FrameLayout) r0.findViewById(2131382465);
        this.o = r0.findViewById(2131383297);
        this.p = r0.findViewById(2131379091);
        this.q = (ImageView) r0.findViewById(2131382435);
        this.r = (ImageView) r0.findViewById(2131381978);
        ImageView r3 = (ImageView) r0.findViewById(2131364832);
        this.y = r3;
        if (AppHost.a.isPlugin() == false) goto L6;
        if (r3 == null) goto L6;
        com.larus.utils.e1.o(r3);
    L6:
        this.t = r0.findViewById(2131364716);
        this.z = (ImageView) r0.findViewById(2131364714);
        this.A = r0.findViewById(2131364715);
        this.u = r0.findViewById(2131371618);
        this.v = (TextView) r0.findViewById(2131372066);
        this.w = (MusicBoxLyricView) r0.findViewById(2131379326);
        this.s = r0.findViewById(2131388700);
        this.x = (FrameLayout) r0.findViewById(2131386121);
        this.F = (ViewGroup) r0.findViewById(2131383028);
        this.G = r0.findViewById(2131383424);
        this.I = (TextView) r0.findViewById(2131383046);
        com.larus.bmhome.music.player.f r4 = com.larus.bmhome.music.player.f.a;
        this.h = com.larus.bmhome.music.player.f.b(this, "music_gen");
        this.M = new LyricsToSongCardView$rebindListener$1(this);
        this.N = "";
        this.O = "";
        this.Q = new LyricsToSongCardView$lifecycleObserver$1(this);
        this.T = LazyKt.lazy(new m(this));
    }

    public static final /* synthetic */ boolean d(LyricsToSongCardView r0) {
        return r0.getAutoPauseWhenFragmentPaused();
    }

    public static final /* synthetic */ com.larus.common_ui.dialog.l0 e(LyricsToSongCardView r0) {
        return r0.getLoadingDialog();
    }

    public static String n(MusicCreationContent r2) {
        if (r2 == null) goto L6;
        boolean r1 = true;
        if (r2.isBlock() != true) goto L6;
    L8:
        if (r1 == false) goto L14;
        String r3 = r2.getUniqueTaskId();
        if (r3 != null) goto L13;
        return TriggerSendLoading.NO_LOADING;
    L13:
        return r3;
    L14:
        if (r2 == null) goto L18;
        ad9.b r4 = r2.getPlayList();
        if (r4 == null) goto L18;
        String r5 = r4.getItemId();
    L20:
        if (com.larus.utils.o0.d(r5) == false) goto L30;
        if (r2 == null) goto L31;
        ad9.b r6 = r2.getPlayList();
        if (r6 == null) goto L32;
        String r7 = r6.getItemId();
        if (r7 != null) goto L28;
        return TriggerSendLoading.NO_LOADING;
    L28:
        return r7;
    L32:
        return TriggerSendLoading.NO_LOADING;
    L31:
        return TriggerSendLoading.NO_LOADING;
    L30:
        return TriggerSendLoading.NO_LOADING;
    L18:
        r5 = null;
    L6:
        r1 = false;
        goto L8
    }

    private final void setCreationPrivacy(boolean r37) {
        if (r37 == false) goto L5;
        int r4 = 3;
    L6:
        if (r37 == false) goto L8;
        int r2 = 2;
    L9:
        if (r37 == false) goto L11;
        int r3 = 2;
    L12:
        p(r3);
        if (r37 == true) goto L19;
        Message r8 = this.i;
        if (r8 == null) goto L17;
        String r9 = r8.getMessageId();
    L18:
        MusicCreationHelperKt.a(r9, "chat_list", "chat");
        goto L19
    L17:
        r9 = null;
    L19:
        tx9.m0.c(getItemName(), getCurrentStatus(), "chat", "chat_list");
        Map<String, Pair<String, Integer>> r5 = this.E;
        if (r5 == null) goto L28;
        MusicCreationContent r10 = this.j;
        if (r10 == null) goto L24;
        String r11 = zc9.i0.a(r10);
    L25:
        Pair r6 = (Pair) ((LinkedHashMap) r5).get(r11);
        if (r6 == null) goto L28;
        String r13 = (String) r6.getFirst();
    L29:
        Message r7 = this.i;
        if (r7 == null) goto L36;
        List<AICreationTaskDurationInfo> r12 = ap8.a.a(r7);
        if (r12 == null) goto L36;
        AICreationTaskDurationInfo r14 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r12);
        if (r14 == null) goto L36;
        String r15 = r14.taskId;
    L37:
        Message r16 = this.i;
        if (r16 == null) goto L40;
        String r17 = r16.getMessageId();
    L42:
        if (com.larus.utils.o0.d(r17) == false) goto L47;
        Message r18 = this.i;
        if (r18 == null) goto L46;
        String r19 = r18.getMessageId();
    L49:
        if (r37 == false) goto L51;
        String r110 = "1";
    L52:
        if (r37 == false) goto L54;
        String r111 = TriggerSendLoading.NO_LOADING;
    L55:
        Message r20 = this.i;
        if (r20 == null) goto L60;
        Map r21 = r20.getExt();
        if (r21 == null) goto L60;
        String r23 = (String) r21.get("gen_music_create_way");
    L61:
        tx9.e2.a.b(new tx9.o0("chat", "chat_list", r13, r15, r19, "music", r110, r111, null, null, null, null, r23, null, null, null, null, null, 515585), null, 3);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, r2, r3, r4, null), 3, null);
        return;
    L60:
        r23 = null;
        goto L61
    L54:
        r111 = "1";
        goto L55
    L51:
        r110 = TriggerSendLoading.NO_LOADING;
        goto L52
    L46:
        r19 = null;
        goto L49
    L47:
        r19 = TriggerSendLoading.NO_LOADING;
        goto L49
    L40:
        r17 = null;
    L36:
        r15 = null;
        goto L37
    L24:
        r11 = null;
    L28:
        r13 = null;
        goto L29
    L11:
        r3 = 3;
        goto L12
    L8:
        r2 = 1;
        goto L9
    L5:
        r4 = 2;
        goto L6
    }

    private final void setShapeCornerColorTint(String r8) {
    L10:
        e = move-exception;
        FLogger.a.e("LyricsToSong", "error parsing tint color ", e);
        return;
    L3:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        if (r8 != null) goto L6;
        int r9 = Color.argb(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L10
    L8:
        int r6 = r9;
        int r10 = CircleProgressBarView.k;     // Catch: IllegalArgumentException -> L10
        float r5 = CircleProgressBarView.a.a(getContext(), 8.0f);     // Catch: IllegalArgumentException -> L10
        h(this, this.s, r5, r5, r5, r5, r6);     // Catch: IllegalArgumentException -> L10
        return;
    L6:
        r9 = Color.parseColor("#B6BACD");     // Catch: IllegalArgumentException -> L10
        goto L8
    L7:
        r9 = Color.parseColor(r8);     // Catch: IllegalArgumentException -> L10
        goto L8
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void GP(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.d(r1);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Ij(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.c(r1);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void eb(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.a(r1);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [android.widget.TextView, com.larus.bmhome.music.widget.AuthorView] */
    public final void o(String r4) {
        String r1 = null;
        if (AppHost.a.isOversea() == false) goto L7;
        Context r0 = getContext();
        if (r0 == null) goto L11;
        r1 = j5.b(r0, r4);
    L11:
        ?? r5 = this.d;
        if (r5 != 0) goto L14;
        return;
    L14:
        if (r1 != null) goto L16;
        String r2 = "";
    L17:
        if (r1 != null) goto L19;
        r1 = "";
    L19:
        Intrinsics.checkNotNullParameter(r2, "fullContent");
        Intrinsics.checkNotNullParameter(r1, "tail");
        if (Intrinsics.areEqual(r2, r5.a) == true) goto L22;
    L24:
        r5.setText(r2);
        r5.a = r2;
        r5.b = r1;
        r5.invalidate();
        return;
    L22:
        if (Intrinsics.areEqual(r5.b, r1) == false) goto L24;
        return;
    L16:
        r2 = r1;
        goto L17
    L7:
        StringBuilder r3 = new StringBuilder();
        r3.append(r4);
        r3.append(" / ");
        Context r6 = getContext();
        if (r6 == null) goto L10;
        r1 = r6.getString(2131908040);
    L10:
        r3.append(r1);
        r1 = r3.toString();
        goto L11
    }

    public final void p(int r4) {
        this.H = r4;
        if (com.larus.bmhome.utils.u.h() == true) goto L5;
    L50:
        ViewGroup r5 = this.F;
        if (r5 == null) goto L53;
        r5.setVisibility(8);
    L53:
        RoundConstraintLayout r6 = this.G;
        if (r6 == null) goto L58;
        r6.setVisibility(8);
        return;
    L58:
        return;
    L5:
        if (AccountService.a.isLogin().booleanValue() == false) goto L50;
        if (r4 != 1) goto L10;
    L37:
        ViewGroup r7 = this.F;
        if (r7 == null) goto L40;
        r7.setVisibility(8);
    L40:
        RoundConstraintLayout r8 = this.G;
        if (r8 == null) goto L43;
        com.larus.utils.e1.x(r8);
    L43:
        RoundConstraintLayout r9 = this.G;
        if (r9 == null) goto L46;
        com.larus.utils.e1.d(r9, new v(this));
    L46:
        IFlowChatThemeConfigProvider r10 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r10 == null) goto L57;
        r10.b(this.G, AdaptThemeFeatureKey.CHAT_CARD_SONG_PUBLISH);
        return;
    L57:
        return;
    L10:
        if (r4 == 2) goto L37;
        if (r4 == 3) goto L19;
        ViewGroup r11 = this.F;
        if (r11 == null) goto L16;
        r11.setVisibility(8);
    L16:
        RoundConstraintLayout r12 = this.G;
        if (r12 == null) goto L46;
        r12.setVisibility(8);
        goto L46
    L19:
        ViewGroup r13 = this.F;
        if (r13 == null) goto L22;
        com.larus.utils.e1.x(r13);
    L22:
        TextView r14 = this.I;
        if (r14 == null) goto L33;
        Context r0 = getContext();
        if (r0 == null) goto L31;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L31;
        String r2 = r1.getString(2131900630);
        if (r2 == null) goto L31;
    L32:
        r14.setText(r2);
    L31:
        r2 = "";
    L33:
        RoundConstraintLayout r15 = this.G;
        if (r15 == null) goto L36;
        r15.setVisibility(8);
    L36:
        com.larus.utils.e1.d(this.F, new w(this));
        goto L46
    }

    public final void setRebindListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.M = r2;
    }

    public final void t(com.larus.bmhome.music.player.j r43) {
        z2 r0 = z2.a;
        if (r0.musicCreateSupportDetail() == true) goto L5;
        return;
    L5:
        com.larus.bmhome.music.player.a r3 = this.h;
        if (r3 == null) goto L8;
        boolean r4 = r3.a();
    L9:
        MusicCreationContent r15 = this.j;
        if (r15 != null) goto L13;
        return;
    L13:
        if (com.larus.bmhome.music.protocol.a.a(r15) == true) goto L15;
        return;
    L15:
        String r16 = "";
        FragmentActivity r17 = null;
        if (r0.V3() == true) goto L18;
        boolean r2 = false;
        boolean r5 = true;
    L44:
        if (r2 == false) goto L46;
        return;
    L46:
        int r1 = r0.x1();
        MusicDetailPagerFragment r6 = new MusicDetailPagerFragment();
        r6.n = this.i;
        r6.p = com.larus.bmhome.music.player.j.a(r43, null, null, false, false, null, 0, null, "music_detail", true, null, null, null, false, false, null, 67059711);
        r6.o = r15;
        Message r7 = this.i;
        if (r7 == null) goto L49;
        boolean r14 = com.larus.bmhome.chat.bean.d.j0(r7);
    L50:
        r6.q = r14;
        Function0<Unit> r8 = new p(this);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r6.r = r8;
        r6.s = this.x;
        com.larus.bmhome.chat.api.q0.a r9 = this.k;
        if (r9 == null) goto L57;
        com.larus.bmhome.chat.component.collection.o r10 = r9.i2();
        if (r10 == null) goto L57;
        if (r10.i0() != r5) goto L57;
        boolean r18 = true;
    L58:
        if (r18 == false) goto L60;
        r16 = "click_collection";
    L60:
        r6.y = r16;
        if (r4 == false) goto L63;
        int r11 = this.C;
    L64:
        r6.z = r11;
        r6.A = r1;
        this.K = r6;
        Context r12 = getContext();
        if ((r12 instanceof FragmentActivity) == false) goto L67;
        r17 = (FragmentActivity) r12;
    L67:
        if (r17 == null) goto L89;
        FragmentManager r13 = r17.getSupportFragmentManager();     // Catch: Exception -> L78
        LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L78
        String r20 = "LyricsToSong";
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r20, r19);     // Catch: Exception -> L76
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r6, r19) == true) goto L90;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L74:
        r6.show(r13, r20);     // Catch: Exception -> L76
        return;
    L90:
        return;
    L76:
        e = e;
    L80:
        FLogger.a.e(r20, "There have something wrong when show e=" + e.getMessage());
        return;
    L78:
        e = e;
        r20 = r2;
        goto L80
    L89:
        return;
    L63:
        r11 = 0;
    L57:
        r18 = false;
        goto L58
    L49:
        r14 = true;
        goto L50
    L18:
        com.larus.bmhome.music.player.j r21 = com.larus.bmhome.music.player.j.a(r43, null, null, false, false, null, 0, null, "music_detail", true, null, null, null, false, false, null, 67059711);
        Bundle r110 = new Bundle();
        ConcurrentHashMap<String, Object> r22 = ir8.a.a;
        MusicAppletPage r111 = MusicAppletPage.CHAT_MUSIC_DETAIL;
        String r112 = ir8.a.a(r111.getValue());
        com.larus.bmhome.music.player.a r23 = this.h;
        if (r23 != null) goto L21;
    L23:
        boolean r24 = false;
    L24:
        if (r24 == false) goto L26;
        int r25 = this.C;
    L27:
        Message r26 = this.i;
        if (r26 == null) goto L30;
        boolean r27 = com.larus.bmhome.chat.bean.d.j0(r26);
    L31:
        r5 = true;
        ir8.b r113 = new ir8.b(r21, r15, r25, r27, this.i, this.x, new r(this), new s(this), new t(this));
        Intrinsics.checkNotNullParameter(r112, "key");
        Intrinsics.checkNotNullParameter(r113, "data");
        ir8.a.a.put(r112, r113);
        r110.putString(MusicAppletPage.KEY_DATA_KEY, r112);
        Message r28 = this.i;
        if (r28 == null) goto L34;
        String r29 = r28.getMessageId();
    L35:
        if (r29 != null) goto L37;
        r29 = "";
    L37:
        r110.putString(MusicAppletPage.KEY_MESSAGE_ID, r29);
        Message r30 = this.i;
        if (r30 == null) goto L40;
        String r31 = r30.getConversationId();
    L41:
        if (r31 != null) goto L43;
        r31 = "";
    L43:
        r110.putString(MusicAppletPage.KEY_CONVERSATION_ID, r31);
        r110.putString(MusicAppletPage.KEY_SOURCE, "chat_card");
        r2 = IAIChatUgcAIGCService.a.N(r110, r111.getValue());
        goto L44
    L40:
        r31 = null;
        goto L41
    L34:
        r29 = null;
        goto L35
    L30:
        r27 = true;
        goto L31
    L26:
        r25 = 0;
        goto L27
    L21:
        if (r23.a() != true) goto L23;
        r24 = true;
        goto L24
    L8:
        r4 = false;
        goto L9
    }

    public static Unit a(LyricsToSongCardView r86, ImageView r87) {
        Intrinsics.checkNotNullParameter(r87, "it");
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L5;
        r1.D0();
        com.larus.home.impl.sdk.b1.a.c("chat_music_share_video");
    L5:
        FrameLayout r3 = r86.x;
        if (r3 == null) goto L40;
        MusicCreationContent r10 = r86.j;
        if (r10 == null) goto L41;
        com.larus.bmhome.chat.api.q0.a r2 = r86.k;
        if (r2 == null) goto L39;
        LifecycleCoroutineScope r4 = r2.F9();
        if (r4 == null) goto L39;
        LruCache<String, wc9.e> r5 = ko8.a.a;
        long r6 = ko8.a.e;
        String r14 = ko8.a.h(r6);
        String r16 = ko8.a.e(r6);
        com.larus.bmhome.chat.api.q0.a r7 = r86.k;
        if (r7 == null) goto L21;
        com.larus.bmhome.chat.component.cvs.y r8 = r7.u0();
        if (r8 == null) goto L21;
        String r17 = r8.getBotId();
    L22:
        Message r9 = r86.i;
        if (r9 == null) goto L25;
        String r18 = r9.getMessageId();
    L26:
        com.larus.bmhome.share.panel.h r11 = new com.larus.bmhome.share.panel.h(null, null, r14, "chat", r16, r17, r18, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r86.i, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -249, -257, 1023);
        MusicShareApi r12 = MusicShareApi.a;
        com.larus.common_ui.dialog.l0 r13 = r86.getLoadingDialog();
        Message r15 = r86.i;
        if (r15 == null) goto L30;
        String r19 = r15.getMessageId();
        if (r19 == null) goto L30;
    L31:
        Message r20 = r86.i;
        com.larus.bmhome.chat.api.q0.a r0 = r86.k;
        if (r0 == null) goto L36;
        com.larus.bmhome.chat.component.cvs.y r21 = r0.u0();
        if (r21 == null) goto L36;
        String r110 = r21.getBotId();
    L37:
        MusicShareApi.d(r3, r4, r13, "chat", "click_music_card", r19, r20, r10, null, r11, r110, null, 5376);
        return Unit.INSTANCE;
    L36:
        r110 = null;
    L30:
        r19 = "";
        goto L31
    L25:
        r18 = null;
    L21:
        r17 = null;
    L39:
        return Unit.INSTANCE;
    L41:
        return Unit.INSTANCE;
    L40:
        return Unit.INSTANCE;
    }

    public static Unit b(LyricsToSongCardView r11, RoundConstraintLayout r12) {
        Intrinsics.checkNotNullParameter(r12, "it");
        int r13 = r11.H;
        if (r13 != 1) goto L5;
        Context r3 = r11.getContext();
        r11.p(3);
        tx9.m0.c(r11.getItemName(), r11.getCurrentStatus(), "chat", "chat_list");
        Message r14 = r11.i;
        if (r14 == null) goto L11;
        String r15 = r14.getMessageId();
    L12:
        MusicCreationHelperKt.a(r15, "chat_list", "chat");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new LyricsToSongCardView$addCreation$1(r11, 1, r3, 3, null), 3, null);
    L14:
        return Unit.INSTANCE;
    L11:
        r15 = null;
        goto L12
    L5:
        if (r13 != 2) goto L14;
        r11.setCreationPrivacy(false);
        goto L14
    }

    public static final /* synthetic */ void f(LyricsToSongCardView r0, String r1) {
        r0.setShapeCornerColorTint(r1);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Pe(float r13, boolean r14) {
        com.larus.bmhome.music.player.a r15 = this.h;
        if (r15 == null) goto L75;
        MusicBoxLyricView r0 = this.w;
        if (r0 == null) goto L76;
        int r16 = (int) ((r13 * r15.j(null, null)) * 10);
        List<LyricsUtterances> r17 = r0.V5();
        if (r17 == null) goto L79;
        int r1 = r0.e;
        if ((r1 - 300) <= r16) goto L12;
    L13:
        FLogger.a.i("MusicLyricView", "[setProgress] curProgress=" + r0.e + " new " + r16 + " trigger seek");
        List<LyricsUtterances> r2 = r0.V5();
        if (r2 != null) goto L17;
    L30:
        if (r0.e != 0) goto L32;
        FLogger.a.i("MusicLyricView", "[setProgress] curProgress= got zero ");
    L32:
        int r3 = r0.e;
        r0.e = r16;
        int r4 = r0.d;
        if (r4 >= 0) goto L35;
    L41:
        FLogger r18 = FLogger.a;
        r18.i("MusicLyricView", "[setProgress] curProgress=" + r3 + " new " + r16 + " try next");
        List<LyricsUtterances> r19 = r0.V5();
        if (r19 != null) goto L45;
    L47:
        boolean r110 = false;
    L48:
        if (r110 == true) goto L50;
        r0.S5();
        return;
    L50:
        List<LyricsUtterances> r111 = r0.V5();
        if (r111 != null) goto L54;
    L64:
        boolean r112 = false;
    L66:
        if (r112 == true) goto L68;
        r18.d("MusicLyricView", "[resetStatus]");
        r0.d = -1;
        r0.e = 0;
        return;
    L68:
        r0.d++;
        r0.S5();
        return;
    L54:
        if ((r0.d + 2) > r111.size()) goto L64;
        int r5 = ((LyricsUtterances) ListProtector.get(r111, r0.d + 1)).getStartTime();
        int r6 = r0.d;
        if (r6 < 0) goto L59;
        int r113 = ((LyricsUtterances) ListProtector.get(r111, r6)).getEndTime();
    L60:
        int r7 = r0.e;
        if (r7 >= r5) goto L65;
        if (r7 < r113) goto L64;
    L65:
        r112 = true;
        goto L66
    L59:
        r113 = 0;
        goto L60
    L45:
        if (RangesKt.coerceAtMost(r0.e + 1, CollectionsKt.getLastIndex(r19)) == r0.d) goto L47;
        r110 = true;
        goto L48
    L35:
        if (r16 > ((LyricsUtterances) ListProtector.get(r17, r4)).getEndTime()) goto L41;
        int r8 = r17.size();
        int r9 = r0.d + 1;
        if (r8 <= r9) goto L41;
        if (r0.e > ((LyricsUtterances) ListProtector.get(r17, r9)).getStartTime()) goto L41;
        return;
    L17:
        if (r2.isEmpty() == true) goto L30;
        r0.e = r16;
        r0.d = -1;
        Iterator r10 = CollectionsKt.minus(CollectionsKt.getIndices(r2), 1).iterator();
    L21:
        if (r10.hasNext() == false) goto L26;
        int r11 = ((Number) r10.next()).intValue();
        if (r16 < ((LyricsUtterances) ListProtector.get(r2, r11)).getEndTime()) goto L21;
        r0.d = r11;
        goto L21
    L26:
        if (r0.d <= (-1)) goto L28;
        FLogger.a.d("MusicLyricView", "[seek to] index " + r0.d + " text " + ((LyricsUtterances) ListProtector.get(r2, r0.d)).getText());
        goto L30
    L28:
        FLogger.a.d("MusicLyricView", "[seek to] index " + r0.d + " text " + ((LyricsUtterances) ListProtector.get(r2, 0)).getText());
        goto L30
    L12:
        if ((r1 + 500) >= r16) goto L30;
    L79:
        return;
    L76:
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void mP(int r1, boolean r2) {
        if (r1 <= 3) goto L5;
        int r3 = r1;
    L6:
        this.C = r3;
        CircleProgressBar r4 = this.o;
        if (r4 == null) goto L10;
        r4.setProgress(r1);
        return;
    L10:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void r30(String r1, Map<String, String> r2) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.e(r1, r2);
    }

    public static Unit c(LyricsToSongCardView r1, ViewGroup r2, int r3) {
        if (r3 != 2131899193) goto L6;
        r1.setCreationPrivacy(false);
    L8:
        com.larus.bmhome.view.screenmenu.d r4 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r2);
        return Unit.INSTANCE;
    L6:
        if (r3 != 2131899197) goto L8;
        r1.setCreationPrivacy(true);
        goto L8
    }

    public final void g(final MusicCreationContent r19, Message r20, final com.larus.bmhome.music.player.j r21, Function0<Unit> r22) {
        String r5 = null;
        if (r19 == null) goto L5;
        String r6 = r19.getLyricsSeekContent();
    L6:
        boolean r7 = true;
    L11:
        e = move-exception;
        FLogger.a.e("LyricsToSong", "error json addLyricsView", e);
    L15:
        LyricsSeekContent r0 = this.D;
        if (r0 == null) goto L27;
        if (r0 == null) goto L23;
        List r1 = r0.getUtterances();
        if (r1 == null) goto L23;
        if (r1.isEmpty() != true) goto L23;
        boolean r2 = true;
    L24:
        if (r2 == true) goto L27;
        boolean r3 = false;
    L29:
        if (r3 == false) goto L44;
        if (r19 == null) goto L32;
        String r4 = r19.getLyrics();
    L34:
        if (TextUtils.isEmpty(r4) == false) goto L43;
        if (r20 != null) goto L37;
    L39:
        boolean r8 = false;
    L40:
        if (r8 == false) goto L42;
        int r9 = 1;
    L45:
        if (r9 == 2) goto L48;
        if (r9 == 3) goto L48;
    L56:
        int r12 = r9;
    L58:
        if (r12 == 2) goto L62;
        if (r12 == 3) goto L62;
    L77:
        FLogger.a.i("LyricsToSong", "[addLyricsView] state:" + r12);
        if (r19 != null) goto L80;
    L82:
        r7 = false;
    L83:
        if (r7 == true) goto L85;
    L87:
        String r13 = "";
    L88:
        MusicBoxLyricView r11 = this.w;
        if (r11 == null) goto L101;
        LyricsSeekContent r14 = this.D;
        if (r19 == null) goto L96;
        String r10 = r19.getLyrics();
        if (r10 == null) goto L96;
        String r15 = r10;
    L97:
        r11.R5(r12, r13, r14, r15, r22, new d(r21, r19, this));
        return;
    L96:
        r15 = "";
        goto L97
    L101:
        return;
    L85:
        if (TextUtils.isEmpty(r19.getUseTemplateId()) == false) goto L87;
        r13 = getContext().getString(2131907946) + "" + AccountService.a.getNickname();
        goto L88
    L80:
        if (r19.getMusicGenType() != 2) goto L82;
    L62:
        if (TextUtils.equals(this.N, r6) == false) goto L69;
        String r16 = this.O;
        if (r19 == null) goto L67;
        r5 = r19.getLyrics();
    L67:
        if (TextUtils.equals(r16, r5) == false) goto L69;
        return;
    L69:
        if (r6 != null) goto L71;
        r6 = "";
    L71:
        this.N = r6;
        if (r19 == null) goto L75;
        String r17 = r19.getLyrics();
        if (r17 == null) goto L75;
    L76:
        this.O = r17;
    L75:
        r17 = "";
    L48:
        if (com.larus.bmhome.music.protocol.a.a(r19) == true) goto L56;
        if (r20 != null) goto L51;
    L53:
        boolean r18 = false;
    L54:
        if (r18 == false) goto L56;
        r12 = 0;
        goto L58
    L51:
        if (com.larus.bmhome.chat.bean.d.j0(r20) == true) goto L53;
        r18 = true;
        goto L54
    L42:
        r9 = 0;
        goto L45
    L37:
        if (com.larus.bmhome.chat.bean.d.j0(r20) != true) goto L39;
        r8 = true;
        goto L40
    L43:
        r9 = 2;
        goto L45
    L32:
        r4 = null;
        goto L34
    L44:
        r9 = 3;
    L23:
        r2 = false;
    L27:
        r3 = true;
    L13:
        e = move-exception;
        FLogger.a.e("LyricsToSong", "error json addLyricsView", e);
        goto L15
    L8:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        JsonReader r23 = new JsonReader(new StringReader(r6));     // Catch: JsonSyntaxException -> L11 JSONException -> L13
        r23.setLenient(true);     // Catch: JsonSyntaxException -> L11 JSONException -> L13
        this.D = (LyricsSeekContent) GsonProtectorUtils.fromJson(HttpExtKt.f, r23, LyricsSeekContent.class);     // Catch: JsonSyntaxException -> L11 JSONException -> L13
    L5:
        r6 = null;
        goto L6
    }

    public static void h(LyricsToSongCardView r5, View r6, float r7, float r8, float r9, float r10, int r11) {
        r5.getClass();
        if (r6 == null) goto L7;
        GradientDrawable r12 = new GradientDrawable();
        r12.setColors(new int[]{r11, r11, r11});
        r12.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r12.setShape(0);
        r12.setCornerRadii(new float[]{r7, r7, r8, r8, r9, r9, r10, r10});
        r6.setBackground(r12);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v3 */
    public final void i(Message r50, com.larus.bmhome.chat.api.q0.a r51, final MusicCreationContent r52, int r53, String r54, Fragment r55, Function0<Unit> r56) {
        Intrinsics.checkNotNullParameter(r56, "longClickBinder");
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("binding holder task ");
        r2.append(r53);
        r2.append(" in task ");
        if (r52 == null) goto L7;
        ad9.b r3 = r52.getPlayList();
        if (r3 == null) goto L7;
        String r4 = r3.getItemId();
    L8:
        r2.append(r4);
        r2.append(" chunking ");
        if (r52 == null) goto L11;
        String r5 = r52.getChunkUrl();
    L12:
        r2.append(r5);
        r0.i("LyricsToSong", r2.toString());
        this.m = r53;
        this.n = r54;
        this.l = r55;
        this.i = r50;
        if (r50 == null) goto L37;
        String r6 = r50.getMessageId();
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        if (r6.length() != 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L37;
        if (com.larus.im.bean.message.a.V(r50) == true) goto L29;
        if (com.larus.bmhome.chat.bean.d.j0(r50) == true) goto L29;
    L32:
        boolean r8 = true;
    L34:
        if (r8 == true) goto L36;
        kr8.q.a(r50);
        goto L37
    L36:
        if (r8 == true) goto L37;
        throw new NoWhenBranchMatchedException();
    L29:
        if (com.larus.im.bean.message.a.V(r50) == true) goto L31;
    L33:
        r8 = false;
        goto L34
    L31:
        if (com.larus.im.bean.message.a.I0(r50) == true) goto L33;
    L21:
        r7 = false;
    L37:
        if (r50 == null) goto L57;
        if (r52 == null) goto L57;
        String r9 = zc9.i0.a(r52);
        nq9.f r10 = m3.a.o();
        if (r10 == null) goto L57;
        r10.b();
        i1a.a r11 = i1a.a.a;
        String r12 = r52.getChunkUrl();
        if (r12 != null) goto L45;
        String r13 = "";
    L46:
        String r14 = r52.getVid();
        if (r14 != null) goto L49;
        String r15 = "";
    L50:
        Image r16 = r52.getCover();
        if (r16 == null) goto L55;
        ImageObj r17 = r16.imageThumb;
        if (r17 == null) goto L55;
        String r18 = r17.url;
    L56:
        ?? r19 = 1;
        r11.e(r50, r9, r13, r15, !TextUtils.isEmpty(r18), !TextUtils.isEmpty(r52.getLyricsSeekContent()), r52.getMusicGenFailed());
    L58:
        if (r52 != null) goto L60;
    L62:
        boolean r20 = false;
    L63:
        if (r20 == false) goto L81;
        String r21 = "LyricsToSong";
        r0.i(r21, "music gen failed due to server reply");
        TextView r22 = this.v;
        if (r22 == null) goto L67;
        com.larus.utils.e1.x(r22);
    L67:
        View r23 = this.u;
        if (r23 == null) goto L71;
        com.larus.utils.e1.o(r23);
    L71:
        if (TextUtils.isEmpty(r52.getMusicGenFailedMsg()) == true) goto L75;
        TextView r24 = this.v;
        if (r24 == null) goto L78;
        r24.setText(r52.getMusicGenFailedMsg());
    L78:
        TextView r25 = this.v;
        if (r25 == null) goto L87;
        r25.setClickable(false);
    L87:
        this.k = r51;
        StringBuilder r26 = new StringBuilder("bind lyrics to song box ! messageId ");
        if (r50 == null) goto L90;
        String r27 = r50.getMessageId();
    L91:
        r26.append(r27);
        r26.append(" status ");
        if (r50 == null) goto L94;
        Object r28 = r50.getMessageStatus();
    L95:
        r26.append(r28);
        r0.i(r21, r26.toString());
        this.j = r52;
        Message r1 = this.i;
        if (r1 == null) goto L101;
        Map r29 = r1.getExt();
        if (r29 == null) goto L101;
        String r30 = (String) r29.get("user_creation");
        if (r30 == null) goto L101;
    L102:
        LinkedHashMap r31 = new LinkedHashMap();
        JSONObject r32 = new JSONObject(r30);     // Catch: Exception -> L115
        ArrayList r33 = new ArrayList();     // Catch: Exception -> L115
        Iterator<String> r34 = r32.keys();     // Catch: Exception -> L115
    L105:
        if (r34.hasNext() == false) goto L108;
        r33.add(r34.next());     // Catch: Exception -> L115
        goto L105
    L108:
        if (r33.size() <= r19) goto L110;
        CollectionsKt.sortWith(r33, new d0());     // Catch: Exception -> L115
    L110:
        Iterator r35 = r33.iterator();     // Catch: Exception -> L115
    L111:
        if (r35.hasNext() == false) goto L117;
        String r36 = (String) r35.next();     // Catch: Exception -> L115
        JSONObject r37 = new JSONObject(r32.optString(r36));     // Catch: Exception -> L115
        r31.put(r36, new Pair(r37.optString("creation_id"), Integer.valueOf(r37.optInt("private_status"))));     // Catch: Exception -> L115
    L117:
        this.E = r31;
        MusicCreationContent r38 = this.j;
        Message r39 = this.i;
        if (r39 == null) goto L120;
        String r40 = r39.getMessageId();
    L121:
        if (r40 == null) goto L133;
        Map<String, Pair<String, Integer>> r41 = this.E;
        if (r41 == null) goto L126;
        Pair r42 = (Pair) ((LinkedHashMap) r41).get(n(r38));
    L127:
        if (r42 != null) goto L129;
        int r43 = 1;
    L136:
        p(r43);
        if (r51 == null) goto L152;
        com.larus.bmhome.chat.component.cvs.y r44 = r51.u0();
        if (r44 == null) goto L152;
        String r45 = r44.getBotId();
        if (r45 == null) goto L152;
        if (r45.length() != 0) goto L145;
        boolean r46 = true;
    L146:
        if (r46 == false) goto L153;
        com.larus.bmhome.chat.api.e0 r47 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r47 == null) goto L152;
        LaunchInfo r48 = r47.a;
        if (r48 == null) goto L152;
        r45 = r48.W();
    L153:
        if (r45 != null) goto L155;
        String r210 = "";
    L156:
        if (r50 == null) goto L161;
        String r49 = com.larus.bmhome.chat.bean.d.x(r50).getShowFrom();
        if (r49 == null) goto L161;
        String r211 = r49;
    L163:
        if (r52 == null) goto L400;
        if (r50 == null) goto L400;
        if (r52.getMusicGenFailed() == true) goto L400;
        if (r51 == null) goto L184;
        u7 r57 = r51.u3();
        if (r57 == null) goto L184;
        List r58 = r57.zj();
        if (r58 == null) goto L184;
        Iterator r59 = r58.iterator();
    L175:
        if (r59.hasNext() == false) goto L182;
        Object r60 = r59.next();
        if (((Message) r60).getContentType() == 0) goto L179;
        boolean r61 = true;
    L180:
        if (r61 == false) goto L175;
    L183:
        Message r62 = (Message) r60;
    L185:
        String r63 = r50.getMessageId();
        if (r63 != null) goto L188;
        String r212 = "";
    L189:
        String r64 = r50.getConversationId();
        if (r64 != null) goto L192;
        String r213 = "";
    L193:
        if (r51 == null) goto L195;
        CoroutineScope r310 = r51.F9();
    L196:
        Lazy r65 = com.larus.bmhome.music.player.i.a;
        Context r66 = this.a;
        Intrinsics.checkNotNullParameter(r66, "context");
        String r311 = r66.toString();
        String r214 = r52.getVid();
        String r67 = r52.getVideoModel();
        if (r67 != null) goto L199;
        String r215 = "";
    L200:
        FLogger r68 = FLogger.a;
        r68.i(r21, "[needAutoPlay], async is: " + Boolean.valueOf(com.larus.im.bean.message.a.V(r50)) + ", played is: " + Boolean.valueOf(com.larus.im.bean.message.a.I0(r50)));
        if (com.larus.im.bean.message.a.V(r50) != r19) goto L203;
        boolean r69 = true;
    L204:
        if (r69 == false) goto L206;
        boolean r216 = (com.larus.im.bean.message.a.I0(r50) ? 1 : 0) ^ r19;
    L232:
        LruCache<String, wc9.e> r70 = ko8.a.a;
        String r312 = ko8.a.e(ko8.a.e);
        String r71 = r52.getTitle();
        if (r71 != null) goto L235;
        String r313 = "";
    L236:
        String r72 = r52.getChunkUrl();
        if (r72 != null) goto L239;
        String r410 = "";
    L240:
        final com.larus.bmhome.music.player.j r73 = new com.larus.bmhome.music.player.j(r212, r213, r210, r211, "", -1, r215, r214, r216, false, r310, 0, r311, null, "chat", false, r312, r313, r410, false, false, r52.getPlayList(), false, false, this.i, "music_gen", 14166528);
        r68.d(r21, "[inquireIsMessageFinished] update:" + com.larus.bmhome.chat.bean.d.j0(r50));
        r68.d(r21, "Message id " + r50.getMessageId() + "  Music singer self => [addContentView]");
        o(AccountService.a.getNickname());
        Image r74 = r52.getCover();
        if (r74 == null) goto L243;
        String r75 = r74.key;
    L245:
        if (TextUtils.isEmpty(r75) == true) goto L247;
        Image r76 = r52.getCover();
        if (r76 == null) goto L269;
        ImageObj r77 = r76.imageThumb;
        if (r77 == null) goto L267;
        String r78 = r77.url;
    L268:
        int r79 = 0;
        Uri r80 = com.larus.image.loader.b0.a(r78, "chat.music", false, false, 6);
    L270:
        SimpleDraweeView r81 = this.g;
        if (r81 == null) goto L273;
        r81.setBackgroundResource(r79);
    L273:
        setShapeCornerColorTint(null);
        String.valueOf(r80);
        r68.i(r21, "cover image start loading started " + r80);
        SimpleDraweeView r82 = this.e;
        if (r82 == null) goto L276;
        ImageLoaderKt.x(r82, r80, "lyrics_to_song_box", null, new j(this, r52), 4);
    L276:
        SimpleDraweeView r83 = this.g;
        if (r83 == null) goto L279;
        ImageLoaderKt.x(r83, r80, "lyrics_to_song_box", null, new k(this), 4);
    L279:
        BuildersKt.launch$default(getScope(), Dispatchers.getIO(), null, new LyricsToSongCardView$loadCoverImage$3(r52, this, null), 2, null);
    L281:
        if (TextUtils.isEmpty(r52.getTitle()) == false) goto L283;
        s();
        if (com.larus.bmhome.chat.bean.d.j0(r50) == false) goto L313;
        View r84 = this.t;
        if (r84 == null) goto L310;
        com.larus.utils.e1.x(r84);
    L310:
        TextView r85 = this.c;
        if (r85 == null) goto L320;
        r85.setText(getContext().getString(2131908033));
    L320:
        if (com.larus.bmhome.music.protocol.a.a(r52) == false) goto L333;
        ImageView r86 = this.y;
        if (r86 == null) goto L324;
        r86.setImageDrawable(ContextCompat.getDrawable(getContext(), 2131242075));
    L324:
        ImageView r87 = this.z;
        if (r87 == null) goto L327;
        r87.setImageDrawable(ContextCompat.getDrawable(getContext(), 2131241237));
    L327:
        ImageView r88 = this.y;
        if (r88 == null) goto L330;
        com.larus.utils.e1.d(r88, new a0(this));
    L330:
        ImageView r89 = this.z;
        if (r89 == null) goto L334;
        com.larus.utils.e1.d(r89, new b0(this));
    L334:
        View r90 = this.t;
        if (r90 == null) goto L337;
        com.larus.utils.e1.d(r90, new e(this));
    L337:
        TextView r91 = this.c;
        if (r91 == null) goto L340;
        com.larus.utils.e1.d(r91, new f(this));
    L340:
        SimpleDraweeView r92 = this.g;
        if (r92 == null) goto L344;
        com.larus.utils.e1.d(r92, new g(this));
    L344:
        if (com.larus.bmhome.chat.bean.d.j0(r50) == false) goto L354;
        if (TextUtils.isEmpty(r52.getVideoModel()) == false) goto L354;
        View r93 = this.t;
        if (r93 == null) goto L350;
        com.larus.utils.e1.d(r93, new h(this));
    L350:
        TextView r94 = this.c;
        if (r94 == null) goto L354;
        com.larus.utils.e1.d(r94, new i(this));
    L354:
        if (com.larus.bmhome.music.protocol.a.a(r52) == false) goto L356;
        hideLoadingView();
        FrameLayout r95 = this.b;
        if (r95 == null) goto L367;
        com.larus.utils.e1.d(r95, new com.larus.bmhome.music.widget.c(this));
    L367:
        g(r52, r50, r73, r56);
        if (com.larus.bmhome.music.protocol.a.a(r52) == false) goto L370;
        com.larus.utils.e1.d(this, new x(this, r73));
    L371:
        com.larus.bmhome.music.player.a r96 = this.h;
        if (r96 == null) goto L378;
        com.larus.bmhome.music.player.b.a r97 = com.larus.bmhome.music.player.b.a;
        String r98 = r73.o();
        if (r98 != null) goto L376;
        r98 = "";
    L376:
        r97.getClass();
        Intrinsics.checkNotNullParameter(r98, "vid");
        Intrinsics.checkNotNullParameter(r96, "player");
        com.larus.bmhome.music.player.b.a.c.put(r98, new WeakReference(r96));
        r96.d(r73);
    L378:
        if (com.larus.bmhome.chat.bean.d.j0(r50) != r19) goto L380;
        boolean r99 = true;
    L381:
        if (r99 == true) goto L383;
    L390:
        RoundConstraintLayout r100 = this.G;
        if (r100 == null) goto L393;
        r100.setEnabled(false);
    L393:
        RoundConstraintLayout r101 = this.G;
        if (r101 == null) goto L396;
        r101.setAlpha(0.4f);
    L396:
        b r102 = this.K;
        if (r102 == null) goto L428;
        r102.mK(r50);
        return;
    L428:
        return;
    L383:
        if (TextUtils.isEmpty(r52.getVideoModel()) == true) goto L390;
        RoundConstraintLayout r103 = this.G;
        if (r103 == 0) goto L387;
        r103.setEnabled(r19);
    L387:
        RoundConstraintLayout r104 = this.G;
        if (r104 == null) goto L396;
        r104.setAlpha(1.0f);
        goto L396
    L380:
        r99 = false;
        goto L381
    L370:
        com.larus.utils.e1.d(this, new y());
        goto L371
    L356:
        if (com.larus.bmhome.chat.bean.d.j0(r50) == true) goto L358;
        showLoadingView();
    L358:
        FrameLayout r105 = this.b;
        if (r105 == null) goto L361;
        com.larus.utils.e1.d(r105, new c0(this));
    L361:
        ImageView r106 = this.r;
        if (r106 == null) goto L367;
        r106.setBackgroundResource(0);
        goto L367
    L333:
        k();
        goto L334
    L313:
        View r107 = this.t;
        if (r107 == null) goto L316;
        com.larus.utils.e1.q(r107);
    L316:
        TextView r108 = this.c;
        if (r108 == null) goto L320;
        r108.setText(getContext().getString(2131907953));
        goto L320
    L283:
        if (com.larus.bmhome.music.protocol.a.a(r52) == false) goto L285;
        View r109 = this.t;
        if (r109 == null) goto L302;
        com.larus.utils.e1.x(r109);
    L302:
        TextView r110 = this.c;
        if (r110 == null) goto L320;
        r110.setText(r52.getTitle());
        goto L320
    L285:
        if (com.larus.bmhome.chat.bean.d.j0(r50) == false) goto L292;
        View r111 = this.t;
        if (r111 == null) goto L289;
        com.larus.utils.e1.x(r111);
    L289:
        TextView r112 = this.c;
        if (r112 == null) goto L298;
        r112.setText(getContext().getString(2131908033));
    L298:
        s();
        goto L320
    L292:
        View r113 = this.t;
        if (r113 == null) goto L295;
        com.larus.utils.e1.q(r113);
    L295:
        TextView r114 = this.c;
        if (r114 == null) goto L298;
        r114.setText(getContext().getString(2131907953));
        goto L298
    L267:
        r78 = null;
        goto L268
    L269:
        r79 = 0;
        r80 = null;
        goto L270
    L247:
        if (com.larus.bmhome.chat.bean.d.j0(r50) == false) goto L261;
        r68.i(r21, "loading view hide");
        this.B = false;
        LottieAdapterView r115 = this.p;
        if (r115 == null) goto L251;
        r115.setAlpha(0.0f);
    L251:
        this.L = false;
        ImageWebpLoadingBgView r116 = this.f;
        if (r116 == null) goto L254;
        com.larus.utils.e1.o(r116);
    L254:
        SimpleDraweeView r117 = this.e;
        if (r117 == null) goto L257;
        r117.setImageDrawable(ContextCompat.getDrawable(this.a, 2131239857));
    L257:
        SimpleDraweeView r118 = this.g;
        if (r118 == null) goto L260;
        r118.setBackgroundResource(2131239336);
    L260:
        setShapeCornerColorTint(null);
        goto L281
    L261:
        q();
        goto L281
    L243:
        r75 = null;
        goto L245
    L239:
        r410 = r72;
        goto L240
    L235:
        r313 = r71;
        goto L236
    L206:
        StringBuilder r119 = new StringBuilder("[needAutoPlay], index is: ");
        r119.append(r53);
        r119.append(", lastMessageId is: ");
        if (r62 == null) goto L209;
        String r120 = r62.getMessageId();
    L210:
        r119.append(r120);
        r119.append(", dataMessageId: ");
        r119.append(r50.getMessageId());
        r119.append(", playList?.itemId is: ");
        ad9.b r121 = r52.getPlayList();
        if (r121 == null) goto L213;
        String r122 = r121.getItemId();
    L214:
        r119.append(r122);
        r119.append(", mFirstCardItemId is: ");
        r119.append(this.n);
        r68.i(r21, r119.toString());
        if (r53 != 0) goto L230;
        if (r62 == null) goto L218;
        String r123 = r62.getMessageId();
    L220:
        if (TextUtils.equals(r123, r50.getMessageId()) == false) goto L230;
        ad9.b r124 = r52.getPlayList();
        if (r124 == null) goto L224;
        String r125 = r124.getItemId();
    L226:
        if (Intrinsics.areEqual(r125, this.n) == false) goto L230;
        if (com.larus.utils.o0.d(this.n) == false) goto L230;
        boolean r126 = true;
    L231:
        r216 = r126;
        goto L232
    L224:
        r125 = null;
        goto L226
    L218:
        r123 = null;
    L230:
        r126 = false;
        goto L231
    L213:
        r122 = null;
        goto L214
    L209:
        r120 = null;
        goto L210
    L203:
        r69 = false;
        goto L204
    L199:
        r215 = r67;
        goto L200
    L195:
        r310 = null;
        goto L196
    L192:
        r213 = r64;
        goto L193
    L188:
        r212 = r63;
        goto L189
    L179:
        r61 = false;
        goto L180
    L182:
        r60 = null;
    L184:
        r62 = null;
    L400:
        com.larus.utils.e1.d(this, new l());
        TextView r127 = this.c;
        if (r127 == null) goto L403;
        r127.setText(getContext().getString(2131907953));
    L403:
        o(AccountService.a.getNickname());
        q();
        View r128 = this.t;
        if (r128 == null) goto L406;
        com.larus.utils.e1.d(r128, new h(this));
    L406:
        TextView r129 = this.c;
        if (r129 == null) goto L409;
        com.larus.utils.e1.d(r129, new i(this));
    L409:
        k();
        RoundConstraintLayout r130 = this.G;
        if (r130 == null) goto L412;
        r130.setEnabled(false);
    L412:
        RoundConstraintLayout r131 = this.G;
        if (r131 == null) goto L415;
        r131.setAlpha(0.4f);
    L415:
        s();
        l();
        g(null, null, null, new u());
        FLogger.a.d(r21, "empty state ");
        return;
    L161:
        r211 = "";
        goto L163
    L155:
        r210 = r45;
        goto L156
    L145:
        r46 = false;
    L152:
        r45 = null;
        goto L153
    L129:
        int r132 = ((Number) r42.getSecond()).intValue();
        if (r132 == r19) goto L135;
        r43 = 2;
        if (r132 != 2) goto L133;
        this.J = 2;
        goto L136
    L135:
        r43 = 3;
        this.J = 3;
        goto L136
    L126:
        r42 = null;
    L133:
        r43 = 0;
        goto L136
    L120:
        r40 = null;
    L115:
        e = move-exception;
        FLogger.a.e("MusicPlayerDetailFragment", "There have something wrong when parse!!!e=" + e.getMessage());
    L101:
        r30 = "";
        goto L102
    L94:
        r28 = null;
        goto L95
    L90:
        r27 = null;
        goto L91
    L75:
        TextView r133 = this.v;
        if (r133 == null) goto L78;
        r133.setText(getContext().getText(2131907944));
        goto L78
    L81:
        r21 = r9;
        TextView r134 = this.v;
        if (r134 == null) goto L84;
        com.larus.utils.e1.o(r134);
    L84:
        View r135 = this.u;
        if (r135 == null) goto L87;
        com.larus.utils.e1.x(r135);
        goto L87
    L60:
        if (r52.getMusicGenFailed() != r19) goto L62;
        r20 = true;
    L55:
        r18 = null;
        goto L56
    L49:
        r15 = r14;
        goto L50
    L45:
        r13 = r12;
    L57:
        r19 = 1;
        goto L58
    L11:
        r5 = null;
    L7:
        r4 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(LyricsToSongCardView r9, Message r10, com.larus.bmhome.chat.api.q0.a r11, MusicCreationContent r12, int r13, String r14, Fragment r15, Function0 r16, int r17) {
        if ((r17 & 16) == 0) goto L5;
        String r6 = "";
    L7:
        if ((r17 & 32) == 0) goto L9;
        Fragment r7 = null;
    L11:
        if ((r17 & 64) == 0) goto L13;
        Function0 r8 = new com.larus.bmhome.music.widget.b();
    L14:
        r9.i(r10, r11, r12, r13, r6, r7, r8);
        return;
    L13:
        r8 = r16;
        goto L14
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }
}
