package com.bytedance.android.livesdk.interactivity.comment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.privilege.model.danmu.PrivilegeBarrageResponse;
import com.bytedance.android.live.profit.privilege.model.danmu.SendPrivilegeBarrageException;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.live.status.api.IAggregateService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.m91;
import com.bytedance.android.livesdk.config.p7;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputDraftType;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputPanelComponentSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.comment.datacontext.CommentContext;
import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.comment.event.QuickCommentTypeEnum;
import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentEntry;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentScene;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputConstantNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PanelPopupFailed;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.comment.mylive.MyLiveEntranceManager;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LiveLandscapeInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LivePortraitInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.OGCFixedInputDialog;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.utils.CommentUtils;
import com.bytedance.android.livesdk.interactivity.comment.view.CommentWidgetAnimator;
import com.bytedance.android.livesdk.interactivity.model.INPUT_PARAM_KEY;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.n4;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.u4;
import com.bytedance.android.livesdk.user.LiveInteractFunction;
import com.bytedance.android.livesdk.utils.b3;
import com.bytedance.android.livesdk.utils.k6;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.v4;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.InputDefaultConfig;
import com.bytedance.android.livesdkapi.depend.model.live.LowPcuGuideData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomInteractData;
import com.bytedance.android.livesdkapi.depend.model.live.UserWorldChatInfo;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.service.ICurrentInteractionUiAction;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.jato.views.JatoOptDrawableCache;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r52.i4;
import zg1.e3;
import zg1.x2;
import zg1.y2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeDanmakuSend, needDynamicControl = true, type = PlayerViewControl.Type.BOTTOM)
public class CommentWidget extends MiddlewareRoomRecyclableWidget implements CommentPresenter.IView, View.OnClickListener, Observer<KVData>, t22.b, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, y22.d, s22.c.a {
    public static final int V1 = 0;
    public static final int b2 = 0;
    public static final int g2 = 0;
    public int A;
    public x22.b B;
    public final x22.c C;
    public String D;
    public String E;
    public String F;
    public String G;
    public final e G1;
    public Boolean H;
    public WeakReference<ViewTreeObserver> H0;
    public final j H1;
    public u22.m.a I;
    public final CompositeDisposable J;
    public boolean K;
    public CommentWidgetAnimator L;
    public final boolean L0;
    public final k L1;
    public m0 M;
    public b M1;
    public f0 N;
    public final HashMap<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> O;
    public String P;
    public s62.a P0;
    public final m P1;
    public String Q;
    public final o Q1;
    public x22.a R;
    public x22.a S;
    public final q S1;
    public String T;
    public u22.m T1;
    public boolean U;
    public Long V;
    public final boolean V0;
    public String W;
    public s22.c X;
    public g0 Y;
    public boolean Z;
    public TextView a;
    public View b;
    public final boolean b1;
    public View c;
    public View d;
    public RedDotView e;
    public RelativeLayout f;
    public View g;
    public final boolean g1;
    public HSImageView h;
    public final Set<y22.e> h1;
    public HSImageView i;
    public FrameLayout j;
    public ViewGroup k;
    public boolean k0;
    public final Set<t22.a> k1;
    public Boolean l;
    public Boolean m;
    public TextView n;
    public LottieAnimationView o;
    public View p;
    public MyLiveEntranceManager p0;
    public final x22.d p1;
    public boolean q;
    public IRoom r;
    public Activity s;
    public String t;
    public String u;
    public boolean v;
    public com.bytedance.android.livesdk.interactivity.comment.t v1;
    public boolean w;
    public boolean x;
    public boolean x1;
    public CommentPresenter y;
    public boolean y1;
    public int z;

    public class a implements Runnable {
        public final /* synthetic */ CommentWidget a;

        @Override // java.lang.Runnable
        public final void run() {
            CommentWidget.xq(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(CommentWidget r1) {
            this.a = r1;
        }
    }

    public class b extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ CommentWidget c;

        public final void run() {
            CommentWidget.yq(this.c);
            b(true);
        }

        public b(CommentWidget r1) {
            this.c = r1;
            super("comment_widget_load");
        }
    }

    public class c extends AccessibilityDelegateCompat {
        public final /* synthetic */ CommentWidget a;

        public c(CommentWidget r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityNodeInfo(View r3, AccessibilityNodeInfoCompat r4) {
            super.onInitializeAccessibilityNodeInfo(r3, r4);
            DataCenter r5 = ((Widget) this.a).dataCenter;
            if (r5 != null) goto L5;
        L7:
            r4.setContentDescription(this.a.P);
            r4.setClassName(EditText.class.getName());
            return;
        L5:
            if (((Boolean) r5.get("data_is_scroll", Boolean.FALSE)).booleanValue() == false) goto L7;
            r4.setContentDescription(null);
        }

        public final boolean performAccessibilityAction(View r4, int r5, Bundle r6) {
            if (r5 != 64) goto L11;
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L11;
            if (((Boolean) r0.get("data_is_scroll", Boolean.FALSE)).booleanValue() == false) goto L11;
            return true;
        L11:
            return super.performAccessibilityAction(r4, r5, r6);
        }
    }

    public class d implements com.bytedance.android.livesdk.chatroom.utils.a1.b {
        public final /* synthetic */ CommentWidget a;

        public d(CommentWidget r1) {
            this.a = r1;
        }

        public final void a(Bitmap r9) {
            Matrix r5 = new Matrix();
            if (s1.getResources() == null) goto L5;
            Resources r0 = s1.getResources();
            float r7 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density / 3.0f;
        L6:
            r5.postScale(r7, r7);
            Bitmap r1 = Bitmap.createBitmap(r9, 0, 0, r9.getWidth(), r9.getHeight(), r5, true);
            if (r9.getNinePatchChunk() != null) goto L9;
            return;
        L9:
            if (this.a.L == null) goto L13;
            byte[] r10 = com.bytedance.android.livesdk.chatroom.utils.a1.f(r9.getNinePatchChunk(), r7, false, false);
            Rect r2 = com.bytedance.android.livesdk.chatroom.utils.a1.i(r10);
            CommentWidgetAnimator r3 = this.a.L;
            r3.d = 1;
            com.bytedance.android.livesdk.interactivity.comment.view.b r4 = new com.bytedance.android.livesdk.interactivity.comment.view.b(r1, r10, r2);
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r3.c = r4;
            ALogger.d("CommentWidget", "room set CommentWidgetAnimator ninePatch drawable Success");
            return;
        L13:
            return;
        L5:
            r7 = 1.0f;
            goto L6
        }

        public final void onFail(Exception r3) {
            ALogger.e("CommentWidget", "room set CommentWidgetAnimator ninePatch drawable failed", r3);
        }
    }

    public class e implements x22.e {
        public final /* synthetic */ CommentWidget a;

        public e(CommentWidget r1) {
            this.a = r1;
        }

        public final void a(String r15, boolean r16, int r17, boolean r18, Map<String, Object> r19, com.bytedance.android.livesdk.event.m r20, com.bytedance.android.livesdk.event.q r21) {
            g92.b r13 = new g92.b();
            long r3 = -1;
            boolean r1 = false;
            if (r19 == null) goto L45;
            Object r5 = r19.get("danmu_money");
            if ((r5 instanceof Long) == false) goto L7;
            r3 = ((Long) r5).longValue();
        L7:
            Object r6 = r19.get("is_from_comment_operate_copy");
            if ((r6 instanceof Boolean) == false) goto L10;
            r1 = ((Boolean) r6).booleanValue();
        L10:
            Object r7 = r19.get("start_send_time");
            if ((r7 instanceof Long) == false) goto L13;
            r13.e = ((Long) r7).longValue();
        L13:
            Object r8 = r19.get("user_send_duration");
            if ((r8 instanceof Long) == false) goto L16;
            r13.a = ((Long) r8).longValue();
        L16:
            Object r9 = r19.get("associate_show_send_duration");
            if ((r9 instanceof Long) == false) goto L19;
            r13.c = ((Long) r9).longValue();
        L19:
            Object r10 = r19.get("is_from_click_event");
            if ((r10 instanceof Boolean) == false) goto L22;
            r13.d = ((Boolean) r10).booleanValue();
        L22:
            Object r11 = r19.get("interest_kp_id");
            if ((r11 instanceof String) == false) goto L25;
            r13.i = (String) r11;
        L25:
            Object r14 = r19.get("interest_kp_text");
            if ((r14 instanceof String) == false) goto L28;
            r13.h = (String) r14;
        L28:
            Object r23 = r19.get("truth_question_id");
            Object r24 = r19.get("truth_question_text");
            if ((r23 instanceof Long) == false) goto L36;
            if ((r24 instanceof String) == false) goto L36;
            String r25 = (String) r24;
            if (r25.isEmpty() == true) goto L36;
            r13.g = ((Long) r23).longValue();
            Intrinsics.checkNotNullParameter(r25, "<set-?>");
            r13.f = r25;
        L36:
            if ("lottery".equals(this.a.F) == false) goto L42;
            if (r15 == null) goto L42;
            if (r15.equals(this.a.G) == false) goto L42;
            r13.b = this.a.F;
        L42:
            if ("lottery".equals(this.a.F) == true) goto L44;
            r13.b = this.a.F;
        L44:
            CommentWidget r26 = this.a;
            r26.F = null;
            r26.G = null;
            boolean r110 = r1;
            long r27 = r3;
        L46:
            CommentWidget r2 = this.a;
            QuickCommentTypeEnum r28 = QuickCommentTypeEnum.DEFAULT;
            int r4 = CommentWidget.V1;
            r2.fr(r15, r16, r17, r18, r28, r27, r20, r21, r110, r13, r19);
            return;
        L45:
            r27 = -1;
            r110 = false;
            goto L46
        }
    }

    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ CommentWidget b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r0 = ((Widget) this.b).contentView.getWidth();
            CommentWidget r1 = this.b;
            if (r1.x == false) goto L8;
            int r2 = CommentWidget.b2;
            if (r0 <= r2) goto L21;
            this.a.width = r2;
        L21:
            ((Widget) this.b).contentView.setLayoutParams(this.a);
            ((Widget) this.b).contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L8:
            if (r1.A <= 0) goto L15;
            ViewGroup r3 = ((Widget) r1).containerView;
            if (r3 == null) goto L15;
            if (r3.getVisibility() == 0) goto L15;
            ViewGroup.LayoutParams r4 = this.a;
            r4.width = this.b.A;
        L17:
            ViewGroup.LayoutParams r5 = this.a;
            if (r5.width > 0) goto L20;
            r5.width = this.b.Kq();
        L20:
            CommentWidget r6 = this.b;
            r6.A = this.a.width;
        L15:
            if (r0 <= this.b.Kq()) goto L17;
            ViewGroup.LayoutParams r7 = this.a;
            r7.width = this.b.Kq();
            goto L17
        }

        public f(CommentWidget r1, ViewGroup.LayoutParams r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ u22.m a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ CommentEntry c;
        public final /* synthetic */ CommentWidget d;

        public final void a() {
            if (this.d.isViewValid() == true) goto L5;
            return;
        L5:
            String r0 = this.a.b;
            boolean r1 = false;
            if (r0 != null) goto L8;
        L25:
            String r3 = r1.b("@%s ", new Object[]{r0});
            CommentWidget r4 = this.d;
            x22.b r5 = r4.B;
            if (r5 == null) goto L36;
            LiveInputDialogV3 r6 = (LiveInputDialogV3) r5;
            if (r3 == null) goto L34;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = r6.g;
            if (r2 == null) goto L34;
            EditText r7 = r2.a;
            if (r7 == null) goto L34;
            r7.setText(r3);
        L34:
            CommentWidget.zq(this.d, this.a.e);
            return;
        L36:
            if (this.b == false) goto L38;
            boolean r8 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.d;
        L39:
            long r9 = 0;
            if (r8 == false) goto L57;
            IRoomAuthStatus r10 = r4.r.getRoomAuthStatus();
            if (r10 == null) goto L50;
            com.bytedance.android.livesdk.interactivity.service.model.c r11 = (com.bytedance.android.livesdk.interactivity.service.model.c) r10.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
            if (r11 == null) goto L50;
            long r13 = r11.getEnableChatMention();
            if (r13 != 1) goto L48;
        L49:
            boolean r14 = true;
        L51:
            if (r14 == false) goto L57;
            IBaseUser r15 = this.a.e.j;
            if (r15 == null) goto L57;
            if (r15.isMysteryMan() == true) goto L57;
            r1 = true;
            goto L57
        L48:
            if (r13 == 0) goto L49;
        L50:
            r14 = false;
        L57:
            if (r1 == false) goto L59;
            this.d.p1.a(this.a.n).a = BuildConfig.FLAVOR;
        L60:
            u22.m r16 = this.a;
            u22.m.a r17 = r16.e;
            String r18 = null;
            if (r17 == null) goto L67;
            r17.e = r0;
            CommentWidget r19 = this.d;
            r19.D = r17.a;
            if (this.b == false) goto L65;
            r9 = r16.n;
        L65:
            r19.p1.a(r9).b = r17;
            CommentWidget r20 = this.d;
            r20.I = this.a.e;
            r20.E = null;
        L67:
            if (this.a.d == false) goto L69;
            r18 = DefaultLandingPanel.Emoji.getPanel();
        L69:
            HashMap r21 = new HashMap();
            r21.put(INPUT_PARAM_KEY.TargetUser, this.a.j);
            u22.m r23 = this.a;
            if (this.d.hr(this.c, new g92.f(r23.l, r23.i, r18, r21)).booleanValue() == false) goto L74;
            CommentWidget.zq(this.d, this.a.e);
            return;
        L74:
            return;
        L59:
            this.d.p1.a(this.a.n).a = r3;
            goto L60
        L38:
            r8 = true;
            goto L39
        L8:
            if (r0.length() <= 1) goto L25;
            u22.m.a r24 = this.a.e;
            if (r24 != null) goto L12;
        L14:
            boolean r25 = false;
        L15:
            if (r25 == true) goto L25;
            CommentWidget r26 = this.d;
            IRoom r27 = r26.r;
            if (r27 != null) goto L19;
        L22:
            boolean r28 = true;
        L23:
            if (r28 == true) goto L25;
            r0 = r0.charAt(0) + s1.B(2131923020);
            goto L25
        L19:
            if (r27.getRoomAuthStatus() == null) goto L22;
            r28 = r26.r.getRoomAuthStatus().getEnableUserCard();
            goto L23
        L12:
            if (r24.c == false) goto L14;
            r25 = true;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(CommentWidget r1, u22.m r2, boolean r3, CommentEntry r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ u22.m a;
        public final /* synthetic */ CommentEntry b;
        public final /* synthetic */ CommentWidget c;

        public final void a() {
            if (this.c.isViewValid() == true) goto L5;
            return;
        L5:
            CommentWidget r0 = this.c;
            x22.b r1 = r0.B;
            if (r1 == null) goto L8;
            boolean r2 = this.a.c;
            r1.getClass();
            return;
        L8:
            x22.c r3 = r0.C;
            boolean r4 = this.a.c;
            r3.getClass();
            if (this.a.d == false) goto L11;
            String r5 = DefaultLandingPanel.Emoji.getPanel();
        L12:
            String r6 = r5;
            HashMap r7 = new HashMap();
            r7.put(INPUT_PARAM_KEY.TargetUser, this.a.j);
            u22.m r8 = this.a;
            g92.f r9 = new g92.f(r8.l, r8.i, r6, r7);
            this.c.hr(this.b, r9);
            return;
        L11:
            r5 = null;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(CommentWidget r1, u22.m r2, CommentEntry r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static /* synthetic */ class i {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[QuickCommentTypeEnum.values().length];
            a = r0;
            r0[QuickCommentTypeEnum.QUICK_COMMENT_MATCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[QuickCommentTypeEnum.QUICK_COMMENT_OGC_FIXED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ CommentWidget a;

        public final void a() {
            if (this.a.isViewValid() == false) goto L15;
            TextView r0 = this.a.a;
            if (r0 == null) goto L16;
            float r1 = r0.getMeasuredWidth();
            TextPaint r2 = this.a.a.getPaint();
            if (r1 <= 0.0f) goto L12;
            if (r2 == null) goto L12;
            if (r2.measureText(this.a.P) <= r1) goto L12;
            boolean r3 = true;
        L13:
            this.a.P1.e(cc2.h.f.c, r3);
            return;
        L12:
            r3 = false;
            goto L13
        L16:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(CommentWidget r1) {
            this.a = r1;
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ CommentWidget a;

        public final void a() {
            CommentWidget r0 = this.a;
            if (((Widget) r0).context != null) goto L5;
            return;
        L5:
            if (r0.r != null) goto L7;
            return;
        L7:
            if (r0.j == null) goto L34;
            CommentWidget r2 = this.a;
            r0.p0 = new MyLiveEntranceManager(((Widget) r2).context, r2.r, r2.j, CommentWidget.wq(r2), ((Widget) this.a).dataCenter);
            MyLiveEntranceManager r1 = this.a.p0;
            r1.getClass();
            ALogger.i("MyLive", "load my live container,timestamp = " + System.currentTimeMillis());
            r1.a = r1.h.findViewById(2131380565);
            r1.b = r1.h.findViewById(2131380566);
            r1.c = new CompositeDisposable();
            DataCenter r3 = r1.j;
            if (r3 == null) goto L11;
            r3.observe("data_user_in_room", r1);
        L11:
            IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
            if (r4 == null) goto L14;
            boolean r5 = r4.user().isLogin();
        L15:
            if (r5 == true) goto L17;
            r1.h.setOnClickListener(new y62.d(r1));
        L26:
            TextView r6 = this.a.a;
            if (r6 == null) goto L35;
            com.bytedance.android.live.core.utils.a1.m(r6, s1.f(5.0f));
            com.bytedance.android.live.core.utils.a1.n(this.a.a, s1.f(4.0f));
            if (this.a.ur() == false) goto L36;
            MainThreadPostUtils.d(this.a.H1);
            MainThreadPostUtils.b(this.a.H1);
            return;
        L36:
            return;
        L35:
            return;
        L17:
            ALogger.i("MyLive", "bind fake user avatar");
            if (r1.a == null) goto L26;
            if (r1.b == null) goto L26;
            UIUtils.setViewVisibility(r1.h, 0);
            IBaseUser r7 = r1.b();
            if (r7 != null) goto L24;
            r7 = jc1.k.n(IMiddlewareUserService.class).user().y();
            ALogger.i("MyLive", "use IUserService User data");
        L24:
            if (r7 == null) goto L26;
            HSImageView r8 = r1.a;
            py.k r9 = r7.getAvatarThumbKt();
            int r10 = r1.d;
            ImageLoader.bindAvatar(r8, r9, r10, r10);
            ALogger.i("MyLive", "bind IUserService User data");
            r1.h.setOnClickListener(new y62.b(r7, r1));
            goto L26
        L14:
            r5 = false;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public k(CommentWidget r1) {
            this.a = r1;
        }
    }

    public class l implements cc2.n<cc2.h> {
        public final /* synthetic */ CommentWidget a;

        public l(CommentWidget r1) {
            this.a = r1;
        }

        @Override // cc2.n
        public final void a(cc2.h r1, Boolean r2) {
            CommentWidget r3 = this.a;
            int r4 = CommentWidget.V1;
            if (r3.ur() == false) goto L6;
            UIUtils.setViewVisibility(this.a.h, 0);
            return;
        }

        @Override // cc2.n
        public final void b(cc2.h r1, Boolean r2) {
            UIUtils.setViewVisibility(this.a.h, 8);
        }
    }

    public class m extends cc2.p<cc2.h> {
        @Override // cc2.p
        public final Set<cc2.h> b() {
            HashSet r0 = new HashSet();
            r0.add(cc2.h.b.c);
            r0.add(cc2.h.f.c);
            r0.add(cc2.h.a.c);
            r0.add(cc2.h.d.c);
            r0.add(cc2.h.c.c);
            r0.add(cc2.h.e.c);
            return r0;
        }

        @Override // cc2.p
        public final Set<cc2.h> c() {
            return new HashSet();
        }

        public m(l r2) {
            super(true, r2);
        }
    }

    public class n implements cc2.n<cc2.a> {
        public final /* synthetic */ CommentWidget a;

        public n(CommentWidget r1) {
            this.a = r1;
        }

        @Override // cc2.n
        public final void a(cc2.a r2, Boolean r3) {
            UIUtils.setViewVisibility(this.a.i, 0);
            this.a.P1.e(cc2.h.a.c, true);
            s62.a r4 = this.a.P0;
            if (r4 == null) goto L6;
            r4.b = true;
            return;
        }

        @Override // cc2.n
        public final void b(cc2.a r2, Boolean r3) {
            UIUtils.setViewVisibility(this.a.i, 8);
            this.a.P1.e(cc2.h.a.c, false);
            s62.a r4 = this.a.P0;
            if (r4 == null) goto L8;
            r4.b = false;
            yo2.e r5 = r4.d;
            if (r5 == null) goto L9;
            r5.d();
            return;
        L9:
            return;
        }
    }

    public class o extends cc2.p<cc2.a> {
        @Override // cc2.p
        public final Set<cc2.a> b() {
            HashSet r0 = new HashSet();
            r0.add(cc2.a.C0009a.c);
            r0.add(cc2.a.b.c);
            return r0;
        }

        @Override // cc2.p
        public final Set<cc2.a> c() {
            HashSet r0 = new HashSet();
            r0.add(cc2.a.c.c);
            return r0;
        }

        public o(n r2) {
            super(false, r2);
        }
    }

    public class p implements cc2.n<cc2.j> {
        public final /* synthetic */ CommentWidget a;

        public p(CommentWidget r1) {
            this.a = r1;
        }

        @Override // cc2.n
        public final void a(cc2.j r2, Boolean r3) {
            UIUtils.setViewVisibility(this.a.k, 0);
            this.a.P1.e(cc2.h.b.c, true);
        }

        @Override // cc2.n
        public final void b(cc2.j r2, Boolean r3) {
            UIUtils.setViewVisibility(this.a.k, 8);
            this.a.P1.e(cc2.h.b.c, false);
        }
    }

    public class q extends cc2.p<cc2.j> {
        @Override // cc2.p
        public final Set<cc2.j> b() {
            HashSet r0 = new HashSet();
            r0.add(cc2.j.a.c);
            return r0;
        }

        @Override // cc2.p
        public final Set<cc2.j> c() {
            HashSet r0 = new HashSet();
            r0.add(cc2.j.b.c);
            return r0;
        }

        public q(p r2) {
            super(false, r2);
        }
    }

    public static class r {
        public r() {
        }

        public r(int r1) {
        }
    }

    public class s implements t {
        public final com.bytedance.android.live.base.model.message.v0 a;

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final o1 getLandscapeAreaCommon() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final long getChatId() {
            com.bytedance.android.live.base.model.message.v0 r0 = this.a;
            if (r0 == null) goto L5;
            Long r1 = Long.valueOf(r0.getPinBaseMessageId());
        L7:
            return r1.longValue();
        L5:
            r1 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final String getContent() {
            com.bytedance.android.live.base.model.message.v0 r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getChatContent();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final Boolean a() {
            return Boolean.FALSE;
        }

        public s(com.bytedance.android.live.base.model.message.v0 r1) {
            this.a = r1;
        }
    }

    public interface t {
        Boolean a();

        long getChatId();

        String getContent();

        o1 getLandscapeAreaCommon();
    }

    public class u implements t {
        public final com.bytedance.android.live.base.model.message.k0 a;

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final long getChatId() {
            com.bytedance.android.live.base.model.message.k0 r0 = this.a;
            if (r0 == null) goto L5;
            Long r1 = Long.valueOf(r0.getChatId());
        L7:
            return r1.longValue();
        L5:
            r1 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final String getContent() {
            com.bytedance.android.live.base.model.message.k0 r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getContent();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final o1 getLandscapeAreaCommon() {
            com.bytedance.android.live.base.model.message.k0 r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getLandscapeAreaCommon();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final Boolean a() {
            return Boolean.FALSE;
        }

        public u(com.bytedance.android.live.base.model.message.k0 r1) {
            this.a = r1;
        }
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public String getSpm() {
        return "a100.a100.a166";
    }

    public final void nr() {
        this.D = null;
        this.I = null;
        this.E = null;
    }

    public final int supportClearScene() {
        return 54;
    }

    static {
        V1 = s1.f(200.0f);
        b2 = s1.f(128.0f);
        g2 = s1.f(100.0f);
    }

    public static boolean Yq() {
        return ((Boolean) ev1.q.d.getValue()).booleanValue();
    }

    public Boolean Cq() {
        com.bytedance.android.livesdk.sharedpref.e<l42.b> r0 = l42.a.r;
        l42.b r1 = (l42.b) r0.getValue();
        if (r1 != null) goto L7;
        return Boolean.FALSE;
    L7:
        if (r1.a == true) goto L9;
        long r2 = System.currentTimeMillis();
        long r4 = r1.b;
        if (r4 <= 0) goto L17;
        if ((r2 - r4) >= 2592000000L) goto L17;
        r1.b = r2;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        return Boolean.FALSE;
    L17:
        return Boolean.TRUE;
    L9:
        return Boolean.FALSE;
    }

    public final void Dr() {
        CommentWidgetAnimator r0 = this.L;
        if (r0 != null) goto L5;
    L10:
        this.h.setImageResource(2131250247);
        this.P1.e(cc2.h.c.c, false);
        return;
    L5:
        if (r0.e == false) goto L10;
        if (Tq() == false) goto L9;
        this.P1.e(cc2.h.c.c, false);
        this.h.setImageResource(2131250248);
        return;
    L9:
        this.P1.e(cc2.h.c.c, true);
    }

    public int Kq() {
        int r0 = V1;
        View r1 = this.d;
        if (r1 != null) goto L5;
        return r0;
    L5:
        if (r1.getVisibility() != 0) goto L11;
        int r2 = s1.f(250.0f);
        if (((d51) j40.a1.a.getValue()).d() == true) goto L9;
        return r2;
    L9:
        return s1.f(268.0f);
    L11:
        return r0;
    }

    public final com.bytedance.android.livesdk.interactivity.api.quickcomment.f Lq() {
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter) != null) goto L6;
        return null;
    L6:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).getQuickCommentManager() != null) goto L9;
        return null;
    L9:
        return (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).getQuickCommentManager().getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void M3() {
        IRoom r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getRoomAuthStatus() != null) goto L7;
        return;
    L7:
        if (isScreenPortrait() == true) goto L9;
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("comment can not show due to room auth");
        int r1 = 8;
        if (isScreenPortrait() == true) goto L20;
        ((Widget) this).contentView.setAlpha(1.0f);
        xr();
        View r2 = ((Widget) this).contentView;
        if (this.r.getRoomAuthStatus().getEnableChat() == true) goto L17;
    L19:
        UIUtils.setViewVisibility(r2, r1);
    L24:
        ((Widget) this).dataCenter.put("data_room_comment_status", Boolean.valueOf(this.r.getRoomAuthStatus().getEnableChat()));
        return;
    L17:
        if (this.r.getRoomAuthStatus().isEnableLandscapeChat() == false) goto L19;
        r1 = 0;
        goto L19
    L20:
        View r3 = ((Widget) this).contentView;
        if (this.r.getRoomAuthStatus().getEnableChat() == false) goto L23;
        r1 = 0;
    L23:
        UIUtils.setViewVisibility(r3, r1);
        goto L24
    L9:
        if (this.r.getRoomAuthStatus().getEnableChat() == false) goto L11;
        sr();
        goto L24
    L11:
        rr();
        goto L24
    }

    public final void Nq() {
        if (TextUtils.isEmpty(this.P) == false) goto L7;
        TextView r0 = this.a;
        if (r0 == null) goto L7;
        this.P = Jq(r0.getMeasuredWidth(), this.a.getPaint(), true).a;
    L7:
        r3.e(this.a, new c(this));
    }

    public final void Rq() {
        ALogger.i("CommentWidget", "start initCommentEditView");
        IRoom r1 = this.r;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.r, true) == true) goto L12;
        Eq(Boolean.FALSE);
        ALogger.i("CommentWidget", "skip handle onOGCFixedChatSyncDataChange cuz Chat disable");
        return;
    L12:
        IRoom r3 = this.r;
        if (r3 == null) goto L17;
        IRoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L17;
        r2 = com.bytedance.android.livesdk.interactivity.service.model.b.b(r4);
    L17:
        if (r2 == true) goto L20;
        Eq(Boolean.FALSE);
        ALogger.i("CommentWidget", "skip handle onOGCFixedChatSyncDataChange cuz FixedChat disable");
        return;
    L20:
        IRoom r0 = this.r;
        if (r0 == null) goto L25;
        IRoomAuthStatus r5 = r0.getRoomAuthStatus();
        if (r5 == null) goto L25;
        boolean r6 = com.bytedance.android.livesdk.interactivity.service.model.b.b(r5);
    L26:
        if (r6 == false) goto L32;
        Eq(Boolean.TRUE);
        TextView r7 = this.n;
        if (r7 == null) goto L30;
        r7.setText(s1.B(2131916659));
    L30:
        dr();
        return;
    L32:
        return;
    L25:
        r6 = false;
        goto L26
    L5:
        if (r1.isMergeVSRoom() == true) goto L8;
        Eq(Boolean.FALSE);
    }

    public void Sq() {
        this.a = (TextView) ((Widget) this).contentView.findViewById(2131371393);
        this.b = ((Widget) this).contentView.findViewById(2131371394);
        this.g = ((Widget) this).contentView.findViewById(2131371395);
        this.n = (TextView) ((Widget) this).contentView.findViewById(2131381418);
        this.c = ((Widget) this).contentView.findViewById(2131367373);
        this.j = (FrameLayout) ((Widget) this).contentView.findViewById(2131380567);
        ImageView r0 = (ImageView) findViewById(2131376162);
        this.d = findViewById(2131385977);
        this.e = findViewById(2131384096);
        int r1 = g2.a;
        if (g2.b(Boolean.valueOf(this.q)) == false) goto L17;
        View r2 = this.b;
        if (r2 == null) goto L8;
        UIUtils.setLayoutParams(r2, Integer.MIN_VALUE, s1.f(38.0f));
    L8:
        if (this.a != null) goto L10;
    L12:
        View r3 = ((Widget) this).contentView.findViewById(2131392712);
        if (r3 == null) goto L17;
        if (isScreenPortrait() == false) goto L17;
        com.bytedance.android.live.core.utils.a1.o(r3, s1.f(2.0f));
        com.bytedance.android.live.core.utils.a1.k(r3, s1.f(36.0f));
        goto L17
    L10:
        if (isScreenPortrait() == false) goto L12;
        UIUtils.setLayoutParams(this.a, Integer.MIN_VALUE, s1.f(38.0f));
    L17:
        this.h = ((Widget) this).contentView.findViewById(2131371530);
        this.i = ((Widget) this).contentView.findViewById(2131362394);
        this.k = (ViewGroup) ((Widget) this).contentView.findViewById(2131375113);
        if (this.x == false) goto L20;
    L58:
        LottieAnimationView r4 = this.o;
        if (r4 != null) goto L61;
    L67:
        TextView r5 = this.a;
        if (r5 == null) goto L70;
        r5.setOnClickListener(this);
    L70:
        TextView r6 = this.n;
        if (r6 == null) goto L73;
        r6.setOnClickListener(this);
    L73:
        this.C.getClass();
        if (this.s.getSharedPreferences("feed_live_span", 0).getInt("span_count", 0) <= 1) goto L76;
        String r7 = "live_small_picture";
    L77:
        this.t = r7;
        kr();
        if (PadConfigUtils.c() == false) goto L81;
        int r8 = s1.j(2131168967);
        UIUtils.updateLayoutMargin(((Widget) this).contentView, r8, -3, -3, r8);
        return;
    L81:
        return;
    L76:
        r7 = "live_big_picture";
        goto L77
    L61:
        if (r4.getVisibility() != 0) goto L67;
        if (this.d == null) goto L67;
        if (Wq() == false) goto L67;
        this.d.setVisibility(0);
        goto L67
    L20:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L58;
        this.p = ((Widget) this).contentView.findViewById(2131369197);
        LottieAnimationView r9 = ((Widget) this).contentView.findViewById(2131376163);
        this.o = r9;
        DataContext r10 = null;
        if (r9 != null) goto L24;
        SafetyGuard.a(null, null, "mIvDanmakuSwitch error");
        ALogger.e("CommentWidget", "mIvDanmakuSwitch is null, mOrientationPortrait is " + this.x + ", room is " + this.r.getId() + " newLandscape is " + com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter));
    L29:
        this.L = Iq();
        if (((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).canShowCastDanmakuBtn(((Widget) this).dataCenter) == false) goto L39;
        LottieAnimationView r11 = this.o;
        if (r11 == null) goto L39;
        if (((Boolean) ((Widget) this).dataCenter.get("byte_cast_danmaku_mode", Boolean.FALSE)).booleanValue() == false) goto L36;
        int r13 = 8;
    L37:
        r11.setVisibility(r13);
        goto L39
    L36:
        r13 = 0;
    L39:
        if (jc1.k.f(IRoomContextService.class) == null) goto L58;
        if (jc1.k.f(IRoomContextService.class).getRoomDataContext(((MiddlewareRoomRecyclableWidget) this).dataContext) == null) goto L58;
        if (jc1.k.f(IRoomContextService.class).getRoomDataContext(((MiddlewareRoomRecyclableWidget) this).dataContext).H2() == false) goto L58;
        DataCenter r14 = ((Widget) this).dataCenter;
        int r15 = CommentUtils.a;
        IInteractivityInjectService r16 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r16 == null) goto L47;
        DataContext r17 = r16.getLiveVisibilityControlContext(r14);
    L49:
        if ((r17 instanceof LiveVisibilityControlContext) == false) goto L52;
        r10 = r17;
    L52:
        LiveVisibilityControlContext r18 = (LiveVisibilityControlContext) r10;
        if (r18 == null) goto L58;
        if (r18.enablePlayBackAbility() == true) goto L57;
        UIUtils.updateLayoutMargin(((Widget) this).contentView, s1.f(0.0f), -3, -3, -3);
    L57:
        ((ObservableSubscribeProxy) r18.getPlayBackAbilityInMsgMutable().a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new com.bytedance.android.livesdk.interactivity.comment.u(this));
        goto L58
    L47:
        r17 = null;
        goto L49
    L24:
        if (Wq() == false) goto L26;
        String r19 = "vs_danmaku/images_landscape_opt";
    L27:
        r9.setImageAssetsFolder(r19);
        this.o.setOnClickListener(this);
        goto L29
    L26:
        r19 = "comment/images";
        goto L27
    }

    public final boolean Tq() {
        if (((d51) j40.a1.a.getValue()).b() == false) goto L11;
        IRoom r0 = this.r;
        if (r0 == null) goto L11;
        if (r0.isMergeVSRoom() == true) goto L11;
        if (this.r.isMediaRoom() == true) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // s22.c.a
    public final int U9() {
        View r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getWidth() - g2;
    }

    public boolean Wq() {
        j40.a1 r0 = j40.a1.a;
        if (((d51) r0.getValue()).c() == false) goto L5;
    L8:
        return true;
    L5:
        if (((d51) r0.getValue()).d() == true) goto L8;
        return false;
    }

    @Override // t22.b
    public final void dismissInputDialog() {
        if (this.B != null) goto L5;
        return;
    L5:
        if (isViewValid() == false) goto L9;
        ((LiveInputDialogV3) this.B).dismissInputDialog();
        ((Widget) this).dataCenter.put("data_pre_show_keyboard", Boolean.FALSE);
        return;
    }

    public int getLayoutId() {
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L8;
        this.x = gb2.a.c(((Widget) this).dataCenter, true);
        ALogger.i("Comment_preload", "getLayoutId::::  isPortrait " + this.x + "   dataCenter" + ((Widget) this).dataCenter.hashCode() + " widget : " + hashCode());
        if (this.x == true) goto L8;
        return 2131567637;
    L8:
        return 2131567636;
    }

    public final boolean isRecyclableOnRotation() {
        return !com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter);
    }

    public final void jr() {
        CommentWidgetAnimator r0 = this.L;
        q4.b r1 = r0.a;
        boolean r2 = true;
        boolean r3 = false;
        if (r1 != null) goto L5;
    L6:
        q4.b r4 = r0.b;
        if (r4 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == true) goto L16;
        boolean r6 = !r0.e;
        r0.e = r6;
        r0.c(r6, true);
        xs2.b.a().post(new e3(r0.e, 0, "comment_animator"));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r7 = l42.a.g;
        Boolean r8 = Boolean.valueOf(r0.e);
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r8);
        r0.b(r0.e);
    L16:
        if (ur() == false) goto L19;
        Dr();
    L19:
        if (Wq() == true) goto L21;
    L25:
        r2 = false;
    L26:
        View r9 = this.d;
        if (r9 == null) goto L32;
        if (r2 == false) goto L30;
        int r10 = 0;
    L31:
        r9.setVisibility(r10);
        goto L32
    L30:
        r10 = 8;
    L32:
        CommentWidgetAnimator r11 = this.L;
        if (r11 == null) goto L35;
        r3 = r11.e;
    L35:
        yr(r3);
        if (Tq() == false) goto L39;
        xr();
        return;
    L39:
        return;
    L21:
        if (this.L.e == false) goto L26;
        if (Tq() == false) goto L25;
    L9:
        if (r4.b() != true) goto L11;
    L10:
        r5 = true;
        goto L12
    L5:
        if (r1.b() == true) goto L10;
        goto L6
    }

    public void kr() {
        ViewGroup.LayoutParams r0 = ((Widget) this).contentView.getLayoutParams();
        if (this.x == true) goto L5;
        r0.width = Kq();
        ((Widget) this).contentView.setLayoutParams(r0);
        ((Widget) this).contentView.getViewTreeObserver().addOnGlobalLayoutListener(new f(this, r0));
        return;
    L5:
        r0.width = -1;
        ((Widget) this).contentView.setLayoutParams(r0);
    }

    public final void onClear() {
        FileUtils.removeDir(new PolarisFileWrapper(jc1.a.b().getFilesDir().getAbsolutePath() + "/audio/"));
    }

    public final void rr() {
        ((Widget) this).contentView.setAlpha(0.34f);
        xr();
        String r0 = this.s.getString(2131915461);
        IRoom r1 = this.r;
        if (r1 != null) goto L5;
    L7:
        y3.f(((Widget) this).dataCenter).a(ToolbarButton.COMMENT, r0);
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L11;
        r2.put("data_room_comment_disable", new r());
        return;
    L11:
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.a(r1) == true) goto L7;
        r0 = com.bytedance.android.livesdk.interactivity.comment.utils.f.c(this.r);
        goto L7
    }

    public final void sr() {
        ((Widget) this).contentView.setAlpha(1.0f);
        xr();
        y3.f(((Widget) this).dataCenter).o(ToolbarButton.COMMENT);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("data_room_comment_disable", new r(0));
        return;
    }

    public void tr() {
        int r1 = 2131249082;
        if (this.x == false) goto L12;
        View r0 = this.b;
        if (r0 != null) goto L7;
    L11:
        Cr();
    L21:
        if (this.x == true) goto L55;
        IRoom r2 = this.r;
        if (r2 != null) goto L25;
    L27:
        boolean r3 = false;
    L28:
        View r4 = this.b;
        if (r4 == null) goto L35;
        if (this.r == null) goto L33;
        r4.setBackground(new e1());
        goto L35
    L33:
        r4.setBackgroundResource(2131249085);
    L35:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L39;
        CommentWidgetAnimator r5 = this.L;
        if (r5 == null) goto L39;
        yr(r5.e);
    L39:
        if (r3 == false) goto L52;
        CommentWidgetAnimator r6 = this.L;
        if (r6 == null) goto L52;
        r6.a();
        if (this.L.e == true) goto L46;
        this.b.setBackgroundResource(2131249084);
    L46:
        if (ht2.g.e(this.r, 10) == false) goto L52;
        ALogger.d("CommentWidget", "room start set landNinePatch bg");
        if (this.L.e == true) goto L50;
        ht2.g.b(10, this.r, this.b, false);
    L50:
        com.bytedance.android.livesdk.chatroom.utils.a1.u(ht2.g.a(this.r, 10, false), new d(this));
    L52:
        if ((this.a instanceof LiveTextView) == false) goto L55;
        Cr();
        goto L55
    L25:
        if (r2.isMergeVSRoom() == false) goto L27;
        r3 = true;
    L55:
        if (ht2.g.f(this.r, 10, true) == true) goto L57;
        return;
    L57:
        if (this.r.isMergeVSRoom() == true) goto L59;
        ht2.g.c(10, this.r, this.b);
        return;
    L59:
        if (this.x == false) goto L64;
        ht2.g.b(10, this.r, this.b, true);
        return;
    L64:
        return;
    L7:
        if (Yq() == true) goto L10;
        r1 = 2131249087;
    L10:
        r0.setBackground(s1.m(r1));
        goto L11
    L12:
        View r7 = this.b;
        if (r7 != null) goto L15;
    L19:
        this.a.setTextColor(s1.h(2131108569));
        Cr();
        goto L21
    L15:
        if (Yq() == true) goto L18;
        r1 = 2131249083;
    L18:
        r7.setBackground(s1.m(r1));
        goto L19
    }

    public final void xr() {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.C == null) goto L13;
        x22.a r1 = Jq(r0.getMeasuredWidth(), this.a.getPaint(), true);
        this.R = r1;
        String r2 = r1.a;
        this.P = r2;
        if (this.Q.equals(r2) == true) goto L10;
        this.Q = this.P;
        com.bytedance.android.livesdk.interactivity.comment.utils.e.a(this.R);
    L10:
        this.a.setText(this.P);
        Cr();
        Nq();
        return;
    }

    public final void zr() {
        IRoom r0 = this.r;
        if (r0 == null) goto L9;
        if (r0.getRoomAuthStatus() == null) goto L9;
        if (this.r.getRoomAuthStatus().getEnableChat() == true) goto L9;
    L16:
        boolean r1 = true;
    L18:
        if (r1 == false) goto L21;
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("comment can not show due to room auth");
        IRoom r2 = this.r;
        InteractivityMonitor.Event r3 = com.bytedance.android.livesdk.interactivity.api.monitor.a.a;
        Intrinsics.checkNotNullParameter("room auth disable", "reason");
        InteractivityMonitor.c(InteractivityMonitor.Event.CommentDisable, r2, 0, "room auth disable", 16);
    L21:
        if (isScreenPortrait() == true) goto L23;
        if (r1 == false) goto L31;
        UIUtils.setViewVisibility(((Widget) this).contentView, 8);
        return;
    L31:
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
        return;
    L23:
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(isScreenPortrait(), this.r) == true) goto L25;
    L27:
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
        return;
    L25:
        if (this.y1 == true) goto L27;
        UIUtils.setViewVisibility(((Widget) this).contentView, 4);
        ALogger.i("CommentWidget", "ToolbarAndCommentShowCtrlSetting set contentView INVISIBLE");
        return;
    L9:
        if (isScreenPortrait() == true) goto L17;
        IRoom r4 = this.r;
        if (r4 == null) goto L17;
        if (r4.getRoomAuthStatus() == null) goto L17;
        if (this.r.getRoomAuthStatus().isEnableLandscapeChat() == false) goto L16;
    L17:
        r1 = false;
        goto L18
    }

    public CommentWidget() {
        Boolean r0 = Boolean.FALSE;
        this.l = r0;
        this.m = r0;
        this.w = true;
        this.z = 0;
        this.A = 0;
        this.B = null;
        this.C = new x22.c();
        this.G = null;
        this.H = r0;
        this.J = new CompositeDisposable();
        this.K = false;
        this.M = null;
        this.N = null;
        this.O = new HashMap();
        this.P = BuildConfig.FLAVOR;
        this.Q = BuildConfig.FLAVOR;
        this.T = null;
        this.U = false;
        this.V = 0L;
        this.W = null;
        this.L0 = com.bytedance.android.livesdk.interactivity.api.monitor.b.a.monitorKeyboard;
        this.V0 = ((Boolean) n4.a.getValue()).booleanValue();
        this.b1 = ((Boolean) v4.a.getValue()).booleanValue();
        this.g1 = ((Boolean) u4.a.getValue()).booleanValue();
        this.h1 = new HashSet();
        this.k1 = new HashSet();
        this.p1 = new x22.d();
        this.x1 = false;
        this.y1 = false;
        this.G1 = new e(this);
        this.H1 = new j(this);
        this.L1 = new k(this);
        this.P1 = new m(new l(this));
        this.Q1 = new o(new n(this));
        this.S1 = new q(new p(this));
        this.T1 = null;
    }

    public final void Cr() {
        s1.h(2131107087);
        if (this.x == false) goto L5;
        int r0 = s1.h(2131107087);
    L12:
        this.a.setTextColor(r0);
        return;
    L5:
        r0 = ColorProtector.parseColor("#CCFFFFFF");
        CommentWidgetAnimator r1 = this.L;
        if (r1 == null) goto L12;
        if (r1.e == false) goto L12;
        if (Tq() == false) goto L12;
        r0 = s1.h(2131107084);
        goto L12
    }

    public CommentWidgetAnimator Iq() {
        if (Wq() == false) goto L9;
        if (this.d == null) goto L9;
        CommentWidgetAnimator r0 = new CommentWidgetAnimator(this.b, this.d, this.a, this.o, ColorProtector.parseColor("#00000000"), Tq());
        Intrinsics.checkNotNullParameter("vs_danmaku/vs_danmaku_close.json", "<set-?>");
        r0.f = "vs_danmaku/vs_danmaku_close.json";
        Intrinsics.checkNotNullParameter("vs_danmaku/vs_danmaku_open.json", "<set-?>");
        r0.g = "vs_danmaku/vs_danmaku_open.json";
        return r0;
    L9:
        return new CommentWidgetAnimator(this.b, this.p, this.a, this.o, ColorProtector.parseColor("#4D000000"), false);
    }

    public final void dr() {
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r0 = Lq();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), ((Widget) this).dataCenter);
        com.bytedance.android.livesdk.interactivity.api.base.d r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r3 = r1.getState();
    L6:
        if (r3 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.api.base.d r4 = (com.bytedance.android.livesdk.interactivity.api.base.d) r3.getValue();
    L10:
        if (r4 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r5 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r5 == null) goto L14;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r6 = r5.getState();
    L15:
        if (r6 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.base.d r7 = (com.bytedance.android.livesdk.interactivity.api.base.d) r6.getValue();
    L19:
        if (r7.a == PublicScreenAreaPageType.PublicScreen) goto L27;
        StringBuilder r8 = new StringBuilder("onOGCFixedChatSyncDataChange, current pageType = ");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r9 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r9 == null) goto L23;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r10 = r9.getState();
    L24:
        if (r10 == null) goto L26;
        r2 = (com.bytedance.android.livesdk.interactivity.api.base.d) r10.getValue();
    L26:
        r8.append(r2.a);
        ALogger.i("CommentWidget", r8.toString());
        Eq(Boolean.FALSE);
        boolean r11 = false;
    L28:
        if (r0 != null) goto L30;
        return;
    L30:
        if (r0.isOGCFixedComment() == false) goto L49;
        int r13 = ((Integer) r0.getQuickCommentType().getValue()).intValue();
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        if (r13 != 3) goto L50;
        if (r11 == true) goto L35;
        return;
    L35:
        if (this.n == null) goto L52;
        ArrayList r14 = new ArrayList();
        int r15 = 22;
    L38:
        if (r15 > 25) goto L43;
        py.k r16 = ht2.g.a(this.r, r15, true);
        if (r16 == null) goto L42;
        r14.add(r16);
    L42:
        r15 = r15 + 1;
        goto L38
    L43:
        ht2.k.c(r14);
        Eq(Boolean.TRUE);
        this.n.setText((CharSequence) r0.mo904getFixedCommentTips().getValue());
        return;
    L52:
        return;
    L50:
        return;
    L49:
        return;
    L23:
        r10 = null;
        goto L24
    L17:
        r7 = null;
        goto L19
    L14:
        r6 = null;
    L27:
        r11 = true;
        goto L28
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onPause");
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onResume");
    }

    public void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        Iterator r0 = ((HashSet) this.h1).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((y22.e) r0.next()).destroy();
        goto L4
    L6:
        ((HashSet) this.h1).clear();
        Iterator r1 = ((HashSet) this.k1).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((t22.a) r1.next()).onUnload();
        goto L8
    L10:
        ((HashSet) this.k1).clear();
        ((Widget) this).contentView.setAlpha(1.0f);
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L13;
        r2.removeObserver(this);
    L13:
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this.M);
        this.a.removeOnLayoutChangeListener(this.N);
        this.y.detachView();
        this.J.clear();
        this.v = false;
        this.K = false;
        this.w = true;
        x22.b r3 = this.B;
        if (r3 == null) goto L16;
        r3.dismissAllowingStateLoss();
        this.B = null;
    L16:
        x22.c r4 = this.C;
        if (r4 == null) goto L19;
        r4.e = null;
        r4.h.clear();
    L19:
        com.bytedance.android.livesdk.interactivity.comment.utils.e.c = false;
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onUnload");
        wr(BuildConfig.FLAVOR);
        s22.c r5 = this.X;
        if (r5 == null) goto L34;
        r5.b(ContainerType.PublicScreen);
        this.X = null;
        if (this.Y == null) goto L34;
        WeakReference<ViewTreeObserver> r6 = this.H0;
        if (r6 == null) goto L32;
        ViewTreeObserver r7 = r6.get();
        if (r7 != null) goto L28;
    L31:
        this.H0.clear();
        this.H0 = null;
    L33:
        this.Y = null;
        goto L34
    L28:
        if (r7.isAlive() == false) goto L30;
        r7.removeOnGlobalLayoutListener(this.Y);
        goto L31
    L30:
        ((Widget) this).contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.Y);
        goto L31
    L32:
        ((Widget) this).contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.Y);
    L34:
        this.P1.d();
        this.S1.d();
        this.Q1.d();
        this.y1 = false;
        MyLiveEntranceManager r8 = this.p0;
        if (r8 == null) goto L43;
        CompositeDisposable r9 = r8.c;
        if (r9 == null) goto L39;
        r9.clear();
    L39:
        r8.c = null;
        DataCenter r10 = r8.j;
        if (r10 == null) goto L42;
        r10.removeObserver(r8);
    L42:
        this.p0 = null;
        MainThreadPostUtils.d(this.H1);
    L43:
        s62.a r11 = this.P0;
        if (r11 == null) goto L46;
        r11.c();
        this.P0 = null;
    L46:
        MainThreadPostUtils.d(this.L1);
    }

    public final boolean ur() {
        if (isScreenPortrait() == true) goto L10;
        IRoom r0 = this.r;
        if (r0 == null) goto L10;
        if (r0.isMergeVSRoom() == false) goto L10;
        return false;
    L10:
        if (this.q == false) goto L12;
    L14:
        boolean r1 = y62.a.a;
        if (y62.a.a(this.r, this.x) == true) goto L17;
    L21:
        boolean r2 = false;
    L22:
        IRoom r3 = this.r;
        if (r3 == null) goto L42;
        IRoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L29;
        com.bytedance.android.livesdk.interactivity.service.model.c r5 = (com.bytedance.android.livesdk.interactivity.service.model.c) r4.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r5 == null) goto L29;
        long r6 = r5.getEnableEmojiExpose();
    L31:
        if (r6 == 2) goto L33;
        boolean r7 = true;
    L34:
        if (r7 == true) goto L36;
        return false;
    L36:
        if (((Boolean) ec2.f.a.getValue()).booleanValue() == true) goto L38;
        return false;
    L38:
        if (this.q == true) goto L45;
        if (r2 == true) goto L46;
        return true;
    L46:
        return false;
    L45:
        return false;
    L33:
        r7 = false;
    L29:
        r6 = 2;
        goto L31
    L42:
        return false;
    L17:
        if (y62.a.c.c() == false) goto L21;
        if (y62.a.e > y62.a.d) goto L21;
        r2 = true;
        goto L22
    L12:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L14;
        return false;
    }

    public static void Gq(Map r3) {
        if (r3.isEmpty() == true) goto L17;
        int r0 = CastIntegerProtector.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        Iterator r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L28;
        g92.c r1 = (g92.c) JsonUtil.parse((String) ((Map.Entry) r4.next()).getValue(), g92.c.class);     // Catch: Exception -> L15
        if (r1 == null) goto L7;
        if (r0 < (CastIntegerProtector.parseInt(r1.c) + 3)) goto L7;
        r4.remove();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L7
    L28:
        return;
    }

    public static void Mq(com.bytedance.android.livesdk.event.y r8) {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.event.m r9 = r8.e;
        if (r9 == null) goto L39;
        List r10 = r9.a;
        if (r10 == null) goto L40;
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        ImageSpan r1 = ((com.bytedance.android.livesdk.event.n) r11.next()).f;
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.comment.input.d) == false) goto L8;
        com.bytedance.android.livesdk.interactivity.comment.input.d r2 = (com.bytedance.android.livesdk.interactivity.comment.input.d) r1;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L41;
        r0.put("content_type", "quick_interaction");
        if (r2 != null) goto L17;
    L20:
        MiddlewareRoomContext r14 = MiddlewareRoomContext.getShared();
        String r3 = "0";
        if (r14 != null) goto L23;
    L27:
        r0.put("is_anchor", "0");
    L28:
        if (r14 != null) goto L30;
    L34:
        r0.put("audience_count", r3);
        com.bytedance.android.livesdk.log.j0 r15 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r4 = new am2.x();
        r4.a = "live_interact";
        r15.sendLog("audience_live_message", r0, new Object[]{am2.u.class, r4, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        return;
    L30:
        if (r14.getCurStatMessage() == null) goto L34;
        if (r14.getCurStatMessage().getValue() == null) goto L34;
        r3 = String.valueOf(((mk) r14.getCurStatMessage().getValue()).getTotal());
        goto L34
    L23:
        if (r14.isAnchor() == null) goto L27;
        if (((Boolean) r14.isAnchor().getValue()).booleanValue() == false) goto L27;
        r0.put("is_anchor", "1");
        goto L28
    L17:
        if (r2.h.getType() != 1) goto L19;
        r0.put("quick_interaction_type", "say_hi");
        goto L20
    L19:
        r0.put("quick_interaction_type", "location");
        goto L20
    L41:
        return;
    L12:
        r2 = null;
        r13 = false;
        goto L13
    L40:
        return;
    }

    public static /* synthetic */ DataContext wq(CommentWidget r0) {
        return ((MiddlewareRoomRecyclableWidget) r0).dataContext;
    }

    public static void xq(final CommentWidget r11) {
        r11.J.add(xs2.b.a().b(u22.m.class).compose(r11.getAutoUnbindTransformer()).subscribe(new a1(r11)));
        r11.J.add(xs2.b.a().b(za2.a.class).compose(r11.getAutoUnbindTransformer()).subscribe(new b1(r11)));
        r11.J.add(xs2.b.a().b(u22.c.class).compose(r11.getAutoUnbindTransformer()).subscribe(new c1(r11)));
        r11.J.add(xs2.b.a().b(u22.g.class).compose(r11.getAutoUnbindTransformer()).subscribe(new t0(r11)));
        r11.J.add(xs2.b.a().b(e3.class).compose(r11.getAutoUnbindTransformer()).subscribe(new v(r11)));
        r11.J.add(xs2.b.a().b(b30.i.class).subscribe(new w(r11)));
        r11.J.add(xs2.b.a().b(b30.k.class).subscribe(new x(r11)));
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(r11.isScreenPortrait(), r11.r) == true) goto L5;
    L9:
        DataCenter r0 = ((Widget) r11).dataCenter;
        if (r0 == null) goto L24;
        String r4 = (String) r0.get("pre_entry_chat_string", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r4) == true) goto L14;
        r11.G1.a(r4, false, 0, false, null, null, null);
        ((Widget) r11).dataCenter.put("pre_entry_chat_string", BuildConfig.FLAVOR);
    L14:
        DataCenter r1 = ((Widget) r11).dataCenter;
        Boolean r2 = Boolean.FALSE;
        if (((Boolean) r1.get("pre_entry_open_chat", r2)).booleanValue() == false) goto L17;
        r11.hr(CommentEntry.Click, new g92.f(OpenInputSource.PreviewEntryChat, System.currentTimeMillis(), null, null));
        ((Widget) r11).dataCenter.put("pre_entry_open_chat", r2);
    L17:
        ((Widget) r11).dataCenter.observe("byte_cast_danmaku_mode", r11).observe("cmd_do_send_message", r11).observe("data_screen_record_is_open", r11).observe("cmd_wanna_send_message", r11).observe("data_room_audio_comment_enable", r11).observe("data_link_state", r11).observe("data_media_introduction_showing", r11).observe("cmd_start_edit", r11).observe("cmd_widget_loaded", r11).observe("data_room_video_comment_share_enable", r11).observe("cmd_change_interactivity_component_visibility", r11).observeForever("data_keyboard_status", r11).observeForever("cmd_hide_other_toolbar", r11).observeForever("cmd_hide_in_douyin_commerce", r11).observeForever("cmd_special_dialog_show", r11).observeForever("fixed_comment_emoji_data_loaded", r11);
        final Long r3 = (Long) ((Widget) r11).dataCenter.get("pre_entry_fast_emoji_id", -1L);
        if (r3.longValue() <= 0) goto L25;
        r11.or(r3);
        if (CollectionUtils.isEmpty(((com.bytedance.android.live.profit.vip.h) yt0.c.l().getSubscribeInfo().getValue()).a) == false) goto L22;
        yt0.c.l().getSubscribeInfo().a().subscribe(new a0(r11, r3));
        return;
    L22:
        r11.pr(r3, ((com.bytedance.android.live.profit.vip.h) yt0.c.l().getSubscribeInfo().getValue()).a);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) r11).dataContext, ((Widget) r11).dataCenter) == null) goto L9;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) r11).dataContext, ((Widget) r11).dataCenter).getToolbarAndCommentShowCtrlManager().getValue() == null) goto L9;
        ALogger.i("CommentWidget", "subscribe ToolbarAndCommentShowCtrlManager onTotalWidgetReady");
        Disposable r5 = ((a32.a) com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) r11).dataContext, ((Widget) r11).dataCenter).getToolbarAndCommentShowCtrlManager().getValue()).a().timeout(((Long) i4.a.getValue()).longValue(), TimeUnit.MILLISECONDS).doOnError(new y()).onErrorReturnItem(new u22.k()).observeOn(AndroidSchedulers.mainThread()).subscribe(new z(r11));
        r11.J.add(r5);
        goto L9
    }

    public static void yq(final CommentWidget r9) {
        r9.getClass();
        long r0 = System.currentTimeMillis();
        UIUtils.setViewVisibility(r9.b, 0);
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) r9).dataCenter) == false) goto L8;
        CommentWidgetAnimator r2 = r9.L;
        if (r2 == null) goto L8;
        r2.a();
    L8:
        if (r9.ur() == false) goto L26;
        m r3 = r9.P1;
        cc2.h.b r6 = cc2.h.b.c;
        if (r9.Z == false) goto L16;
        s22.c r7 = r9.X;
        if (r7 == null) goto L16;
        if (r7.isShowing() == false) goto L16;
        boolean r8 = true;
    L17:
        r3.e(r6, r8);
        r3.a(r9.h, s1.B(2131914439));
        r9.h.setOnClickListener(r9);
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L21;
        r9.runWithRoomEntered(new v0(r9));
    L24:
        if (ht2.g.f(r9.r, 15, true) == false) goto L27;
        ht2.g.d(15, r9.r, r9.h, new w0());
    L27:
        r9.kr();
        r9.xr();
        r9.tr();
        r9.runWithRoomVisible(new z0(r9));
        int r4 = r9.z + 1;
        r9.z = r4;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r5 = l42.a.s;
        Integer r10 = Integer.valueOf(r4);
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r10);
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onLoad");
        CommentContext.a r11 = CommentContext.Companion;
        DataCenter r13 = ((Widget) r9).dataCenter;
        r11.getClass();
        if (CommentContext.a.a(r13) == null) goto L30;
        CommentContext.a.a(((Widget) r9).dataCenter).getCommentService().d(r9);
    L30:
        UIUtils.setViewVisibility(((Widget) r9).contentView, 0);
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) r9).dataCenter) == true) goto L33;
    L37:
        r9.runWithRoomEntered(new j0(r9));
        z32.c.c(InputConstantNode.InputPrepareViewTime, String.valueOf(System.currentTimeMillis() - r0));
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(r9.isScreenPortrait(), r9.r) == true) goto L40;
    L44:
        DataCenter r1 = ((Widget) r9).dataCenter;
        if (r1 == null) goto L50;
        b30.i r14 = (b30.i) r1.get("cmd_show_comment_input_dialog_from_preview", null);
        ((Widget) r9).dataCenter.put("cmd_show_comment_input_dialog_from_preview", null);
        if (r14 == null) goto L51;
        ALogger.i("CommentWidget", "OpenCommentPanelEvent from preview");
        r9.cr(r14);
        return;
    L51:
        return;
    L50:
        return;
    L40:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) r9).dataContext, ((Widget) r9).dataCenter) == null) goto L44;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) r9).dataContext, ((Widget) r9).dataCenter).getToolbarAndCommentShowCtrlManager().getValue() == null) goto L44;
        ALogger.i("CommentWidget", "call ToolbarAndCommentShowCtrlManager notifyCommentReady");
        ((a32.a) com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) r9).dataContext, ((Widget) r9).dataCenter).getToolbarAndCommentShowCtrlManager().getValue()).c();
        goto L44
    L33:
        if (r9.L == null) goto L37;
        if (r9.ur() == false) goto L37;
        r9.Dr();
        goto L37
    L21:
        if (r9.K == true) goto L24;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_emoji_show", null, new Object[]{am2.x.class, Room.class});
        r9.K = true;
    L16:
        r8 = false;
        goto L17
    L26:
        r9.P1.e(cc2.h.d.c, true);
        goto L27
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Ae(com.bytedance.android.live.base.model.message.v0 r9) {
        r9.setLocalInsertMsg(true);
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter) == null) goto L5;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter).B(r9);
    L5:
        HashMap r4 = new HashMap();
        r4.put("is_settled", "1");
        r4.put("quickCommentType", QuickCommentTypeEnum.QUICK_COMMENT_OGC_FIXED);
        mr(new com.bytedance.android.livesdk.event.d0(BuildConfig.FLAVOR, ISendCommentEvent.Sender.CommentWidget, r4, null, null, false), new s(r9));
    }

    public final void Aq(HashMap<String, String> r6) {
        if (((Boolean) ec2.v0.a.getValue()).booleanValue() == false) goto L15;
        IService r0 = jc1.k.f(IInteractService.class);
        String r1 = BuildConfig.FLAVOR;
        if (r0 == null) goto L7;
        r6.put("ui_layout", jc1.k.f(IInteractService.class).getCurrentUiLayout() + BuildConfig.FLAVOR);
    L7:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.get("data_online_changed_list", new ArrayList()) == null) goto L13;
        r1 = ((ArrayList) ((Widget) this).dataCenter.get("data_online_changed_list", new ArrayList())).size() + BuildConfig.FLAVOR;
    L13:
        r6.put("online_size", r1);
        return;
    }

    public final void Bq(HashMap<String, String> r5) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L12;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r0.get("data_click_preview_comment_enter_room", r1)).booleanValue() != true) goto L12;
        r5.put("click_method", "interact_area");
        String r2 = this.W;
        if (r2 != null) goto L9;
    L11:
        ((Widget) this).dataCenter.put("data_click_preview_comment_enter_room", r1);
        goto L12
    L9:
        if (r2.isEmpty() == true) goto L11;
        r5.put("guide_text", this.W);
        r5.put("request_source", "preview_guide");
    L12:
        this.W = null;
    }

    public final void Eq(Boolean r6) {
        if (r6.booleanValue() == false) goto L15;
        View r7 = this.g;
        if (r7 == null) goto L7;
        r7.setVisibility(8);
    L7:
        TextView r8 = this.n;
        if (r8 != null) goto L10;
    L14:
        ALogger.i("CommentWidget", "changeOGCFixedUIStyle to true");
        return;
    L10:
        if (r8.getVisibility() != 8) goto L12;
    L13:
        this.n.setVisibility(0);
        HashMap r9 = new HashMap();
        r9.put("operate_type", "show");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_shortcut_message_icon", r9, new Object[]{new am2.x(), IRoom.class});
        goto L14
    L12:
        if (this.n.getVisibility() != 4) goto L14;
    L15:
        View r10 = this.g;
        if (r10 == null) goto L18;
        r10.setVisibility(0);
    L18:
        TextView r11 = this.n;
        if (r11 == null) goto L21;
        r11.setVisibility(8);
    L21:
        ALogger.i("CommentWidget", "changeOGCFixedUIStyle to false");
    }

    public final void Er(u22.m r11) {
        if (br(r11, Boolean.FALSE).booleanValue() == false) goto L6;
        return;
    L6:
        if (this.T1 != r11) goto L8;
        return;
    L8:
        this.T1 = r11;
        CommentEntry r0 = CommentEntry.WannaSendEvent;
        int r1 = r11.m;
        if (r1 != 1) goto L18;
        r0 = CommentEntry.ChatChannelWannaEvent;
        if (r11.n > 0) goto L17;
        int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a;
        IInteractivityInjectService r3 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r3 == null) goto L15;
        long r6 = r3.getCurrentChatChannelId();
    L16:
        r11.n = r6;
        goto L17
    L15:
        r6 = -1;
    L17:
        boolean r7 = true;
    L31:
        nr();
        if (r11.getType() != 1) goto L34;
        this.C.j = r11.g;
    L35:
        this.E = r11.f;
        if (r11.getType() != 1) goto L39;
        new g(this, r11, r7, r0).run();
        return;
    L39:
        if (r11.getType() != 2) goto L42;
        ((Widget) this).contentView.postDelayed(new h(this, r11, r0), 500);
        return;
    L42:
        if (r11.d == false) goto L44;
        String r4 = DefaultLandingPanel.Emoji.getPanel();
    L45:
        HashMap r8 = new HashMap();
        r8.put(INPUT_PARAM_KEY.TargetUser, r11.j);
        r8.put(INPUT_PARAM_KEY.ReplyMsgId, Long.valueOf(r11.k));
        r8.put(INPUT_PARAM_KEY.SecretClickFrom, Integer.valueOf(r11.h));
        hr(r0, new g92.f(r11.l, r11.i, r4, r8));
        return;
    L44:
        r4 = null;
        goto L45
    L34:
        this.C.j = -1;
        goto L35
    L18:
        r7 = false;
        if (r1 != 2) goto L22;
        r0 = CommentEntry.SquareChatEvent;
        goto L31
    L22:
        if (r11.getType() != 1) goto L24;
        r0 = CommentEntry.WannaSendAtEvent;
        goto L31
    L24:
        OpenInputSource r5 = r11.l;
        if (r5 != OpenInputSource.SecretChat) goto L27;
    L30:
        r0 = CommentEntry.SecretChat;
        goto L31
    L27:
        if (r5 == OpenInputSource.ReplySecretChat) goto L30;
        if (r5 != OpenInputSource.ReplyHeartSecretChat) goto L31;
        goto L30
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Oy(boolean r2) {
        this.C.b = r2;
    }

    public void Pq(KVData r5) {
        if (((Boolean) r5.getData(Boolean.FALSE)).booleanValue() == false) goto L8;
        LottieAnimationView r6 = this.o;
        if (r6 == null) goto L7;
        r6.setVisibility(8);
    L7:
        xs2.b.a().post(new e3(true, 2, "cast"));
        return;
    L8:
        LottieAnimationView r7 = this.o;
        if (r7 == null) goto L11;
        r7.setVisibility(0);
    L11:
        xs2.b.a().post(new e3(((Boolean) l42.a.g.getValue()).booleanValue(), 2, "cast"));
    }

    public final void Qq(ApiServerException r4) {
        if (ExceptionUtils.shouldShowBindPhone(r4) == true) goto L5;
        return;
    L5:
        if (((Boolean) r52.a.a.getValue()).booleanValue() == true) goto L7;
        return;
    L7:
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L12;
        jc1.k.f(IMiddlewareHostApp.class).startBindPhoneDialogFragment(this.s, "live_detail", "live_detail", new h0(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void R00(com.bytedance.android.live.base.model.message.r r2) {
        CommentUtils.a(r2, ((Widget) this).dataCenter);
    }

    @Override // t22.b
    public final void Xp(boolean r3) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (this.q == true) goto L19;
        x22.b r0 = this.B;
        if (r0 == null) goto L10;
        r0.getClass();
    L13:
        this.C.a = r3;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter) == null) goto L18;
        com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).isUserBannedTalk().setValue(Boolean.valueOf(r3));
        return;
    L18:
        return;
    L10:
        this.C.a = r3;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter) == null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).isUserBannedTalk().setValue(Boolean.valueOf(r3));
        goto L13
    }

    public final void Zq(int r5) {
        HashMap r0 = new HashMap();
        IBaseUser r1 = jc1.k.f(IMiddlewareUserService.class).user().b();
        r0.put("user_id", r1.getIdString());
        py.d r2 = r1.getUserHonor();
        if (r2 == null) goto L5;
        r0.put("privilege_level", String.valueOf(r2.getLevel()));
    L5:
        r0.put("danmu_level", String.valueOf(r5));
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L8;
        String r6 = "portrait";
    L9:
        r0.put("screen_layout", r6);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_send_barrage_fail", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L8:
        r6 = "landscape";
        goto L9
    }

    public final boolean canControlByPlayer(PlayerViewControl.KEY r3) {
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r4.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L7;
        return true;
    }

    public final void cr(b30.i r9) {
        ALogger.i("CommentWidget", "receive an OpenCommentPanelEvent");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L10:
        String r0 = r9.b;
        if (r0 == null) goto L13;
        this.p1.a(0).a = r0;
        this.G = r9.b;
    L13:
        this.D = r9.c;
        this.E = r9.d;
        this.F = r9.g;
        String r1 = r9.n;
        if (r1 == null) goto L26;
        if (r1.isEmpty() == true) goto L26;
        String r2 = r9.n;
        String r3 = this.F;
        int r4 = CommentUtils.a;
        Intrinsics.checkNotNullParameter(r2, "hint");
        if (Intrinsics.areEqual("anchor_custom_topic_btn", r3) == false) goto L21;
        x22.a r5 = new x22.a(r2, HintType.ANCHOR_CUSTOM_TOPIC);
    L24:
        this.S = r5;
        goto L26
    L21:
        if (Intrinsics.areEqual("comment_topic_btn", r3) == false) goto L23;
        r5 = new x22.a(r2, HintType.COMMENT_TOPIC);
        goto L24
    L23:
        r5 = new x22.a(r2, HintType.NORMAL);
    L26:
        if ("lottery".equals(this.F) == false) goto L28;
        this.C.i = 9;
    L28:
        OpenInputSource r6 = OpenInputSource.OpenPanelEvent;
        if (r9.a == false) goto L31;
        r6 = OpenInputSource.Preview;
        this.W = r9.l;
    L31:
        g92.f r7 = new g92.f(r6, r9.i, r9.h, null);
        r7.a = r9.k;
        hr(CommentEntry.OpenPanelEvent, r7);
        r9.e.onCommentSuccess(BuildConfig.FLAVOR, null, null);
        this.C.f = null;
        return;
    L5:
        if (r9.j == false) goto L10;
        if (com.bytedance.android.livesdk.interactivity.comment.utils.b.a(r9.g) == false) goto L10;
        com.bytedance.android.livesdk.interactivity.comment.utils.b.b("openCommentPanel", this.s);
    }

    public final void er(com.bytedance.android.livesdk.interactivity.api.base.d r4) {
        PublicScreenAreaPageType r5 = r4.a;
        boolean r1 = false;
        if (r5 != PublicScreenAreaPageType.ChatChannel) goto L5;
        boolean r0 = true;
    L6:
        this.Z = r0;
        if (r5 != PublicScreenAreaPageType.Square) goto L9;
        r1 = true;
    L9:
        this.k0 = r1;
        xr();
        dr();
        this.Q1.e(cc2.a.C0009a.c, this.Z);
        this.P1.e(cc2.h.e.c, this.k0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void gr(String r6) {
        if (this.q == false) goto L5;
    L30:
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_1");
        return;
    L5:
        if (isScreenPortrait() == false) goto L30;
        if (this.r.isMediaRoom() == true) goto L30;
        if (this.r.isScreenshot() == true) goto L30;
        if (gd0.v.a(((Integer) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue(), 8) == false) goto L16;
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_2");
        return;
    L16:
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.r, true) == true) goto L19;
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_3");
        return;
    L19:
        IRoom r0 = this.r;
        if (r0 == null) goto L26;
        if (com.bytedance.android.livesdk.interactivity.service.model.b.a(r0.getRoomAuthStatus()) == false) goto L26;
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_4");
        return;
    L26:
        if (TextUtils.isEmpty(r6) == true) goto L28;
        f2.c(r6, 0);
    L28:
        this.m = Boolean.TRUE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void h8(Exception r7) {
        if ((r7 instanceof ApiServerException) == false) goto L23;
        ApiServerException r0 = (ApiServerException) r7;
        int r1 = r0.getErrorCode();
        if (50001 != r1) goto L8;
        Xp(true);
        IESUIUtils.displayToast(this.s, r0.getPrompt());
    L22:
        Qq(r0);
        int r2 = r1;
    L24:
        HashMap r3 = new HashMap();
        r3.put("error_code", String.valueOf(r1));
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.d(EventName.ChatApiTrigger, r3);
        com.bytedance.android.livesdk.interactivity.api.monitor.a.b(r7, r2);     // Catch: Exception -> L27
        return;
    L30:
        return;
    L8:
        if (50004 != r1) goto L19;
        x22.b r4 = this.B;
        if (r4 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = ((LiveInputDialogV3) r4).g;
        if (r5 == null) goto L17;
        EditText r6 = r5.a;
        if (r6 == null) goto L17;
        r6.setText(BuildConfig.FLAVOR);
    L17:
        dismissInputDialog();
        IESUIUtils.displayToast(this.s, r0.getPrompt());
        goto L22
    L16:
        this.p1.a(0).a = BuildConfig.FLAVOR;
        goto L17
    L19:
        if (r1 != 50019) goto L21;
        dismissInputDialog();
        b32.a.a(this.s, "send_message", new d0(this), new e0(this));
        goto L22
    L21:
        IESUIUtils.displayToast(this.s, r0.getPrompt());
        goto L22
    L23:
        f2.b(2131918930, 0);
        Logger.e("CommentWidget", "unknown exception " + r7.toString());
        r2 = -1;
        r1 = 12345;
        goto L24
    }

    public final void onChanged(Object r14) {
        KVData r15 = (KVData) r14;
        if (isViewValid() == false) goto L196;
        if (r15 != null) goto L6;
        return;
    L6:
        if (r15.getKey() != null) goto L8;
        return;
    L8:
        if (r15.getData() == null) goto L230;
        String r0 = r15.getKey();
        r0.getClass();
        boolean r3 = true;
        int r4 = 4;
        switch(r0.hashCode()) {
            case -1836833765: goto L82;
            case -1755796428: goto L78;
            case -1679741667: goto L74;
            case -1598618410: goto L70;
            case -1548871708: goto L66;
            case -888767508: goto L62;
            case -826138222: goto L58;
            case -657921921: goto L54;
            case -526943249: goto L50;
            case 309908432: goto L46;
            case 741568604: goto L42;
            case 872172481: goto L38;
            case 912007817: goto L34;
            case 1060055221: goto L30;
            case 1723690875: goto L26;
            case 1887208196: goto L22;
            case 1939188655: goto L18;
            case 2143275606: goto L14;
            default: goto L85;
        };
    L85:
        byte r1 = -1;
    L87:
        switch(r1) {
            case 0: goto L193;
            case 1: goto L184;
            case 2: goto L182;
            case 3: goto L178;
            case 4: goto L170;
            case 5: goto L168;
            case 6: goto L159;
            case 7: goto L155;
            case 8: goto L149;
            case 9: goto L142;
            case 10: goto L141;
            case 11: goto L135;
            case 12: goto L131;
            case 13: goto L122;
            case 14: goto L115;
            case 15: goto L112;
            case 16: goto L101;
            case 17: goto L90;
            default: goto L231;
        };
    L141:
        Pq(r15);
        return;
    L142:
        boolean r16 = ((Boolean) r15.getData()).booleanValue();
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.r, false) == false) goto L214;
        View r2 = ((Widget) this).contentView;
        if (r16 == true) goto L148;
        r4 = 0;
    L148:
        UIUtils.setViewVisibility(r2, r4);
        return;
    L214:
        return;
    L149:
        String r5 = (String) r15.getData();
        if (TextUtils.isEmpty(r5) == true) goto L235;
        e r6 = this.G1;
        if (r6 == null) goto L216;
        r6.a(r5, false, 0, false, null, null, null);
        return;
    L216:
        return;
    L235:
        return;
    L155:
        o42.f r17 = (o42.f) r15.getData();
        if (r17 == null) goto L218;
        HashMap r13 = new HashMap();
        fr(r17.a, false, 0, false, r17.b, -1, null, null, false, new g92.b(), r13);
        return;
    L218:
        return;
    L168:
        this.D = "live";
        this.E = null;
        hr(CommentEntry.GuideEvent, new g92.f(OpenInputSource.GuideEvent, System.currentTimeMillis(), null, null));
        return;
    L178:
        Long r18 = (Long) ((Widget) this).dataCenter.get("pre_entry_fast_emoji_id", -1L);
        if (r18.longValue() <= 0) goto L236;
        or(r18);
        return;
    L236:
        return;
    L182:
        Er((u22.m) r15.getData());
        return;
    L231:
        return;
    L90:
        if (this.q == true) goto L232;
        IInteractService r7 = jc1.k.f(IInteractService.class);
        if (r7 != null) goto L95;
        return;
    L95:
        if (r7.canShowCommentShareVideoOpenCloseToast() == true) goto L97;
        return;
    L97:
        if (((Boolean) r15.getData(Boolean.TRUE)).booleanValue() == false) goto L99;
        f2.c(((Widget) this).context.getString(2131923080), 0);
        return;
    L99:
        f2.c(((Widget) this).context.getString(2131923078), 0);
        return;
    L232:
        return;
    L101:
        if (((Boolean) r15.getData()).booleanValue() == false) goto L103;
    L106:
        ((Widget) this).contentView.setVisibility(r4);
        com.bytedance.android.livesdk.log.b0 r19 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r8 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (((Widget) this).contentView.getVisibility() == 0) goto L110;
        r3 = false;
    L110:
        r8.append(r3);
        r8.append(", reason: DATA_SCREEN_RECORD_IS_OPEN");
        String r9 = r8.toString();
        r19.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r9);
        return;
    L103:
        if (this.v == true) goto L106;
        r4 = 0;
        goto L106
    L112:
        if (((Boolean) r15.getData()).booleanValue() == false) goto L204;
        hr(CommentEntry.Click, new g92.f(OpenInputSource.PreviewEntryChat, System.currentTimeMillis(), null, null));
        return;
    L204:
        return;
    L115:
        if (this.q == false) goto L118;
        return;
    L118:
        if (((Boolean) r15.getData(Boolean.TRUE)).booleanValue() == false) goto L120;
        gr(((Widget) this).context.getString(2131915100));
        return;
    L120:
        wr(((Widget) this).context.getString(2131915098));
        return;
    L122:
        if (((Boolean) r15.getData()).booleanValue() == false) goto L124;
        ((Widget) this).contentView.setVisibility(4);
    L125:
        com.bytedance.android.livesdk.log.b0 r110 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r10 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (((Widget) this).contentView.getVisibility() == 0) goto L129;
        r3 = false;
    L129:
        r10.append(r3);
        r10.append(", reason: DATA_KEYBOARD_STATUS");
        String r11 = r10.toString();
        r110.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r11);
        return;
    L124:
        ((Widget) this).contentView.setVisibility(0);
        this.v = false;
        goto L125
    L131:
        if (((Boolean) r15.getData()).booleanValue() == false) goto L133;
        ((Widget) this).contentView.setAlpha(0.5f);
        return;
    L133:
        ((Widget) this).contentView.setAlpha(1.0f);
        return;
    L135:
        if (this.r.isLiveTypeAudio() == true) goto L138;
        return;
    L138:
        if (gd0.v.a(((Integer) r15.getData(0)).intValue(), 8) == false) goto L140;
        wr(BuildConfig.FLAVOR);
        return;
    L140:
        gr(BuildConfig.FLAVOR);
        return;
    L159:
        if (r15.getData() != null) goto L161;
        return;
    L161:
        if ((r15.getData() instanceof cc2.e) == false) goto L221;
        cc2.f r20 = ((cc2.e) r15.getData()).b(cc2.a.class);
        if (r20 == null) goto L165;
        this.Q1.e((cc2.a) r20.a, r20.b);
    L165:
        cc2.f r111 = ((cc2.e) r15.getData()).b(cc2.h.class);
        if (r111 == null) goto L222;
        this.P1.e((cc2.h) r111.a, r111.b);
        return;
    L222:
        return;
    L221:
        return;
    L170:
        if (((Boolean) r15.getData()).booleanValue() == false) goto L172;
        ((Widget) this).contentView.setVisibility(4);
    L173:
        com.bytedance.android.livesdk.log.b0 r112 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r21 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (((Widget) this).contentView.getVisibility() == 0) goto L177;
        r3 = false;
    L177:
        r21.append(r3);
        r21.append(", reason: CMD_VISIBILITY_IN_DOUYIN_COMMERCE");
        String r23 = r21.toString();
        r112.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r23);
        return;
    L172:
        ((Widget) this).contentView.setVisibility(0);
        goto L173
    L184:
        if (((Boolean) r15.getData(Boolean.FALSE)).booleanValue() == false) goto L186;
        ((Widget) this).contentView.setVisibility(4);
    L187:
        com.bytedance.android.livesdk.log.b0 r113 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r24 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (((Widget) this).contentView.getVisibility() == 0) goto L191;
        r3 = false;
    L191:
        r24.append(r3);
        r24.append(", reason: CMD_HIDE_OTHER_TOOLBARBUTTON");
        String r25 = r24.toString();
        r113.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r25);
        return;
    L186:
        ((Widget) this).contentView.setVisibility(0);
        goto L187
    L193:
        if (this.V0 == true) goto L229;
        gr(BuildConfig.FLAVOR);
        return;
    L229:
        return;
    L14:
        if (r0.equals("data_room_video_comment_share_enable") == false) goto L85;
        r1 = 17;
        goto L87
    L18:
        if (r0.equals("data_screen_record_is_open") == false) goto L85;
        r1 = 16;
        goto L87
    L22:
        if (r0.equals("pre_entry_open_chat") == false) goto L85;
        r1 = 15;
        goto L87
    L26:
        if (r0.equals("data_room_audio_comment_enable") == false) goto L85;
        r1 = 14;
        goto L87
    L30:
        if (r0.equals("data_keyboard_status") == false) goto L85;
        r1 = 13;
        goto L87
    L34:
        if (r0.equals("cmd_special_dialog_show") == false) goto L85;
        r1 = 12;
        goto L87
    L38:
        if (r0.equals("data_link_state") == false) goto L85;
        r1 = 11;
        goto L87
    L42:
        if (r0.equals("byte_cast_danmaku_mode") == false) goto L85;
        r1 = 10;
        goto L87
    L46:
        if (r0.equals("data_media_introduction_showing") == false) goto L85;
        r1 = 9;
        goto L87
    L50:
        if (r0.equals("pre_entry_chat_string") == false) goto L85;
        r1 = 8;
        goto L87
    L54:
        if (r0.equals("cmd_do_send_message") == false) goto L85;
        r1 = 7;
        goto L87
    L58:
        if (r0.equals("cmd_change_interactivity_component_visibility") == false) goto L85;
        r1 = 6;
        goto L87
    L62:
        if (r0.equals("cmd_start_edit") == false) goto L85;
        r1 = 5;
        goto L87
    L66:
        if (r0.equals("cmd_hide_in_douyin_commerce") == false) goto L85;
        r1 = 4;
        goto L87
    L70:
        if (r0.equals("fixed_comment_emoji_data_loaded") == false) goto L85;
        r1 = 3;
        goto L87
    L74:
        if (r0.equals("cmd_wanna_send_message") == false) goto L85;
        r1 = 2;
        goto L87
    L78:
        if (r0.equals("cmd_hide_other_toolbar") == false) goto L85;
        r1 = 1;
        goto L87
    L82:
        if (r0.equals("cmd_widget_loaded") == false) goto L85;
        r1 = 0;
        goto L87
    L230:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        long r2 = System.currentTimeMillis();
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.r, true) == true) goto L26;
        IRoom r0 = this.r;
        if (r0 == null) goto L22;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L22;
        IRoomAuthStatus.IRoomAuthSpecialStyle r3 = r1.getRoomAuthSpecialStyle();
        if (r3 == null) goto L22;
        IRoomAuthStatusStyle r4 = r3.getChatStyle();
        if (r4 == null) goto L22;
        if (r4.getUnableStyle() != 1) goto L22;
        String r5 = r4.getContent();
        if (r5 == null) goto L22;
        if (r5.length() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 != true) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L26;
        f2.c(com.bytedance.android.livesdk.interactivity.comment.utils.f.c(this.r), 0);
        return;
    L19:
        r6 = false;
    L22:
        r7 = false;
    L26:
        int r13 = r11.getId();
        if (r13 == 2131371393) goto L36;
        if (r13 == 2131381418) goto L36;
        if (r13 != 2131376163) goto L34;
        jr();
        return;
    L34:
        if (r13 != 2131371530) goto L41;
        this.V = Long.valueOf(System.currentTimeMillis());
        nr();
        hr(CommentEntry.Click, new g92.f(OpenInputSource.EmojiExpose, r2, DefaultLandingPanel.Emoji.getPanel(), null));
        return;
    L41:
        return;
    L36:
        this.V = Long.valueOf(System.currentTimeMillis());
        nr();
        this.D = "live";
        hr(CommentEntry.Click, new g92.f(OpenInputSource.ClickCommentBox, r2, null, null));
        if (r13 != 2131381418) goto L43;
        HashMap r14 = new HashMap();
        r14.put("operate_type", "click");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_shortcut_message_icon", r14, new Object[]{new am2.x(), IRoom.class});
        return;
    }

    public final void onEnterClear(int r3) {
        if (r3 != 4) goto L5;
    L8:
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L11;
        r0.setVisibility(8);
    L11:
        p7 r1 = com.bytedance.android.livesdk.performance.p.a;
        if (r1.enable == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == true) goto L20;
        return;
    L20:
        if (r3 != 2) goto L27;
        View r4 = ((Widget) this).contentView;
        if (r4 != null) goto L24;
        return;
    L24:
        if (2 == r4.getLayerType()) goto L29;
        ((Widget) this).contentView.setLayerType(2, null);
        ALogger.i("ttlive_widget", "CommentWidget Set LAYER_TYPE_HARDWARE");
        return;
    L29:
        return;
    L27:
        return;
    L14:
        if (r1.commentWidgetEnable == false) goto L16;
        r2 = true;
        goto L17
    L5:
        if (r3 == 16) goto L8;
        if (r3 != 32) goto L11;
        goto L8
    }

    public void onEvent(u22.g r14) {
        if (r14.a != 0) goto L62;
        IBaseUser r0 = jc1.k.f(IMiddlewareUserService.class).user().y();
        IRoom r1 = this.r;
        if (r1 == null) goto L8;
        long r2 = r1.getId();
    L9:
        Intrinsics.checkNotNullParameter(r14, "event");
        com.bytedance.android.live.base.model.message.k0 r3 = (com.bytedance.android.live.base.model.message.k0) vh7.f.c(com.bytedance.android.live.base.model.message.k0.class);
        long r4 = new Random().nextInt(10000000);
        com.bytedance.android.live.base.model.message.m0 r6 = vh7.f.c(com.bytedance.android.live.base.model.message.m0.class);
        r6.setRoomId(r2);
        r6.setShowMsg(true);
        r6.setMessageId(r4);
        r6.setMethod("WebcastChatMessage");
        Unit r7 = Unit.INSTANCE;
        r3.setBaseMessage(r6);
        r3.setGiftImage(r14.d);
        a5 r8 = r14.c;
        IBaseUser r9 = null;
        if (r8 == null) goto L47;
        List r10 = r8.getPieces();
        if (r10 == null) goto L47;
        if ((!r10.isEmpty()) == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L47;
        Iterator r11 = r10.iterator();
    L20:
        if (r11.hasNext() == false) goto L41;
        Object r13 = r11.next();
        i5 r15 = ((c5) r13).getUserValue();
        if (r15 == null) goto L24;
        IBaseUser r16 = r15.getUser();
    L25:
        IMiddlewareUserService r17 = jc1.k.f(IMiddlewareUserService.class);
        if (r17 == null) goto L30;
        com.bytedance.android.livesdk.user.e r18 = r17.user();
        if (r18 == null) goto L30;
        String r19 = r18.n();
    L31:
        if (r16 == null) goto L38;
        if (r19 == null) goto L38;
        if ((!Intrinsics.areEqual(r19, "0")) == false) goto L38;
        if (TextUtils.equals(r16.getIdString(), r19) == false) goto L38;
        boolean r20 = true;
    L39:
        if (r20 == false) goto L20;
    L42:
        c5 r21 = (c5) r13;
        if (r21 == null) goto L47;
        i5 r5 = r21.getUserValue();
        if (r5 == null) goto L47;
        r9 = r5.getUser();
    L38:
        r20 = false;
    L30:
        r19 = null;
        goto L31
    L24:
        r16 = null;
        goto L25
    L41:
        r13 = null;
    L47:
        r3.setContent(r14.b);
        if (r9 == null) goto L51;
        r0 = r9;
    L51:
        r3.setUserInfo(r0);
        r3.setMessageMethod("WebcastChatMessage");
        r3.setChatId(r4);
        HashMap r23 = new HashMap();
        r23.put("live.intent.extra.ENTER_LIVE_SOURCE", this.u);
        String r110 = r14.b;
        if (r110 != null) goto L55;
        r110 = BuildConfig.FLAVOR;
    L55:
        A20(new com.bytedance.android.livesdk.event.d0(r110, ISendCommentEvent.Sender.CommentWidget, r23, null, null, false), r3);
        return;
    L8:
        r2 = 0;
        goto L9
    }

    public final void onExitClear(int r4) {
        if (r4 != 4) goto L5;
    L8:
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L11;
        r0.setVisibility(0);
    L11:
        p7 r1 = com.bytedance.android.livesdk.performance.p.a;
        if (r1.enable == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == true) goto L20;
        return;
    L20:
        if (r4 != 2) goto L27;
        View r5 = ((Widget) this).contentView;
        if (r5 != null) goto L24;
        return;
    L24:
        if (2 != r5.getLayerType()) goto L29;
        ((Widget) this).contentView.setLayerType(0, null);
        ALogger.i("ttlive_widget", "CommentWidget Set LAYER_TYPE_NONE");
        return;
    L29:
        return;
    L27:
        return;
    L14:
        if (r1.commentWidgetEnable == false) goto L16;
        r2 = true;
        goto L17
    L5:
        if (r4 == 16) goto L8;
        if (r4 != 32) goto L11;
        goto L8
    }

    public void onInit(Object... r3) {
        this.q = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.r = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        this.x = gb2.a.c(((Widget) this).dataCenter, true);
        this.u = (String) ((Widget) this).dataCenter.get("log_enter_live_source");
        this.s = (Activity) ((Widget) this).context;
        this.y = new CommentPresenter();
        com.bytedance.android.livesdk.sharedpref.e<Integer> r4 = l42.a.s;
        Integer r1 = Integer.valueOf(this.z);
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r1);
        Sq();
        Rq();
        if (((m91) LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue()).a() == true) goto L9;
    L6:
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onInit");
        return;
    L9:
        JatoOptDrawableCache.preloadDrawableCache(((Widget) this).context.getResources(), new int[]{2131250247});     // Catch: Exception -> L8
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v49, types: [com.bytedance.android.livesdk.interactivity.comment.m0] */
    /* JADX WARN: Type inference failed for: r3v51, types: [android.view.View$OnLayoutChangeListener, com.bytedance.android.livesdk.interactivity.comment.f0] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.android.livesdk.interactivity.comment.i0] */
    public void onLoad(Object... r10) {
        if (this.r != null) goto L5;
        return;
    L5:
        if (((Widget) this).contentView == null) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.x = gb2.a.c(((Widget) this).dataCenter, true);
        long r1 = System.currentTimeMillis();
        ((Widget) this).contentView.setAlpha(1.0f);
        String r11 = s1.B(2131922326);
        this.a.setText(r11);
        x22.c r3 = this.C;
        r3.getClass();
        r3.c = new x22.a(r11, HintType.NORMAL);
        Room r13 = (IRoom) ((Widget) this).dataCenter.get("data_room");
        this.r = r13;
        if (this.g1 == false) goto L21;
        Room r14 = r13;
        if (r14 == null) goto L21;
        if (r14.getRoomInteractData() == null) goto L21;
        if (r14.getRoomInteractData().getLowPcuGuideData() == null) goto L21;
        LowPcuGuideData r15 = r14.getRoomInteractData().getLowPcuGuideData();
        int r4 = r15.status;
        if (r4 != 1) goto L19;
        this.T = r15.guideText;
        this.U = true;
        goto L21
    L19:
        if (r4 != 2) goto L21;
        this.U = false;
    L21:
        Rq();
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).changeDrawCleanScreen(((Widget) this).dataCenter, ((Widget) this).containerView, this.r);
        CommentUtils.c(this.r, ((Widget) this).dataCenter);
        ((HashSet) this.k1).add(this.p1);
        com.bytedance.android.livesdk.interactivity.comment.t r16 = new com.bytedance.android.livesdk.interactivity.comment.t(new i0(this), ((Widget) this).dataCenter);
        this.v1 = r16;
        ((HashSet) this.k1).add(r16);
        Iterator r17 = ((HashSet) this.k1).iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        ((t22.a) r17.next()).onLoad();
        goto L23
    L25:
        this.q = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor")).booleanValue();
        this.u = (String) ((Widget) this).dataCenter.get("log_enter_live_source");
        this.s = (Activity) ((Widget) this).context;
        this.y.g0(this);
        TextView r18 = this.a;
        if (r18 != 0) goto L28;
    L31:
        runWithRoomVisible(new a(this));
        this.M1 = new b(this);
        if (getRoomContextService() == null) goto L37;
        if (getRoomContextService().getRoomDataContext(((Widget) this).dataCenter, 0).B2() == null) goto L37;
        getRoomContextService().getRoomDataContext(((Widget) this).dataCenter, 0).B2().c(new n0(this));
    L37:
        if (this.k != null) goto L39;
    L52:
        this.Z = false;
        this.k0 = false;
    L53:
        xr();
        if (this.x == true) goto L63;
        if (this.L == null) goto L63;
        if (ur() == false) goto L63;
        if (this.L.e == ((Boolean) l42.a.g.getValue()).booleanValue()) goto L63;
        this.L.a();
        Dr();
    L63:
        if (Lq() == null) goto L65;
        xr();
        dr();
        this.J.add(Lq().mo904getFixedCommentTips().subscribe(new q0(this)));
        this.J.add(Lq().getQuickComment().subscribe(new r0(this)));
    L65:
        Nq();
        this.f = (RelativeLayout) findViewById(2131372714);
        ALogger.i("Comment_preload", "loadDanmukuSetting::::  isPortrait " + this.x + "   dataCenter" + ((Widget) this).dataCenter.hashCode() + this.f + " widget : " + hashCode());
        if (this.x == false) goto L72;
        RelativeLayout r19 = this.f;
        if (r19 == null) goto L72;
        r19.setVisibility(8);
        View r110 = this.p;
        if (r110 == null) goto L72;
        r110.setVisibility(8);
    L72:
        View r111 = this.d;
        if (r111 == null) goto L80;
        r3.c(r111, s1.B(2131914415), true);
        this.d.setOnClickListener(new d1(this));
        if (Cq().booleanValue() == false) goto L79;
        RedDotView r112 = this.e;
        if (r112 == null) goto L79;
        r112.setVisibility(0);
    L79:
        this.e.setVisibility(8);
    L80:
        long r7 = System.currentTimeMillis();
        z32.c.c(InputConstantNode.InputLoadTime, String.valueOf(r7 - r1));
        long r0 = ((Long) ((Widget) this).dataCenter.get("user_enter_room_start_time", -1L)).longValue();
        if (r0 <= 0) goto L83;
        z32.c.c(InputConstantNode.InputShowCostTime, String.valueOf(r7 - r0));
    L83:
        IRoom r113 = this.r;
        if (r113 != null) goto L86;
    L93:
        TextView r114 = this.a;
        if (r114 == null) goto L96;
        com.bytedance.android.live.core.utils.a1.m(r114, s1.f(12.0f));
        com.bytedance.android.live.core.utils.a1.n(this.a, s1.f(10.0f));
    L96:
        UIUtils.setViewVisibility(this.j, 8);
    L97:
        Boolean r115 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a;
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a(this.r) == false) goto L105;
        if (this.x == false) goto L105;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter) == null) goto L105;
        ALogger.i("AICloneTag", "wait for manager init");
        com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).getAiCloneManager().c(new s0(this));
    L105:
        if (this.V0 == false) goto L110;
        gr(BuildConfig.FLAVOR);
        return;
    L110:
        return;
    L86:
        if (this.j == null) goto L93;
        boolean r2 = y62.a.a;
        if (y62.a.a(r113, this.x) == false) goto L93;
        UIUtils.setViewVisibility(this.j, 0);
        if (y62.a.c.b() == false) goto L92;
        MainThreadPostUtils.c(this.L1, y62.a.f);
        goto L97
    L92:
        this.L1.run();
        goto L97
    L39:
        if (((MiddlewareRoomRecyclableWidget) this).dataContext == null) goto L52;
        if (isScreenPortrait() == false) goto L52;
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L45;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getChannelGreetingManager(((MiddlewareRoomRecyclableWidget) this).dataContext, new o0(this));
    L45:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r116 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r116 == null) goto L48;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r117 = r116.getState();
    L49:
        if (r117 == null) goto L51;
        this.Z = ((com.bytedance.android.livesdk.interactivity.api.base.d) r117.getValue()).a.equals(PublicScreenAreaPageType.ChatChannel);
        this.k0 = ((com.bytedance.android.livesdk.interactivity.api.base.d) r117.getValue()).a.equals(PublicScreenAreaPageType.Square);
        this.J.add(r117.a().subscribe(new p0(this)));
        er((com.bytedance.android.livesdk.interactivity.api.base.d) r117.getValue());
        goto L53
    L51:
        this.Z = false;
        this.k0 = false;
        goto L53
    L48:
        r117 = null;
        goto L49
    L28:
        if (this.b1 == false) goto L30;
        ?? r5 = new f0(this);
        this.N = r5;
        r18.addOnLayoutChangeListener(r5);
        goto L31
    L30:
        this.M = new m0(this);
        r18.getViewTreeObserver().addOnGlobalLayoutListener(this.M);
        goto L31
    }

    public final void onRoomVisible(boolean r1) {
        super.onRoomVisible(r1);
    }

    public final void or(Long r18) {
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.r, false) == true) goto L12;
        String r1 = ((o72.a) ec2.n.a.getValue()).e();
        if (r1 != null) goto L7;
    L8:
        r1 = s1.B(2131915461);
    L9:
        f2.c(r1, 0);
        ((Widget) this).dataCenter.put("pre_entry_fast_emoji_id", -1L);
        return;
    L7:
        if (r1.isEmpty() == false) goto L9;
    L12:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter) != null) goto L14;
        return;
    L14:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).getQuickCommentManager() != null) goto L16;
        return;
    L16:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).getQuickCommentManager().getValue() == null) goto L61;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r2 = ((com.bytedance.android.livesdk.interactivity.api.quickcomment.f) com.bytedance.android.livesdk.interactivity.api.i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter).getQuickCommentManager().getValue()).getOGCFixedChatInfo();
        if (r2 != null) goto L20;
        return;
    L20:
        if (CollectionUtils.isEmpty(r2.fixedEmojiList) == true) goto L63;
        Iterator<com.bytedance.android.livesdk.interactivity.api.quickcomment.a> r3 = r2.fixedEmojiList.iterator();
    L23:
        if (r3.hasNext() == false) goto L64;
        if (r3.next().id != r18.longValue()) goto L23;
        ((Widget) this).dataCenter.put("pre_entry_fast_emoji_id", -1L);
        Iterator r5 = ((HashSet) this.h1).iterator();
        CommentFlowContext r7 = null;
    L28:
        if (r5.hasNext() == false) goto L32;
        r7 = ((y22.e) r5.next()).b(CommentEntry.GuideEvent, null);
        if (r7 == null) goto L28;
    L32:
        if (this.C.a == false) goto L40;
        if (r7 == null) goto L37;
        CommentInputConfig r6 = r7.d;
        if (r6 == null) goto L37;
        boolean r8 = r6.m;
    L38:
        if (r8 == true) goto L40;
        return;
    L37:
        r8 = false;
    L40:
        long r9 = r18.longValue();
        ISendCommentEvent.Sender r10 = ISendCommentEvent.Sender.CommentWidget;
        if (y22.b.b(new com.bytedance.android.livesdk.event.c0(r9, 0, false, r10, new HashMap(), r7, null)) == true) goto L42;
        CommentPresenter r11 = this.y;
        if (r11 == null) goto L23;
        r11.o0(new com.bytedance.android.livesdk.event.b0(r18.longValue(), r10, new HashMap(), r7));
        return;
    L42:
        ALogger.i("CommentWidget", "sendEmojiMessage true by flowContext:" + r7.toString());
        return;
    L64:
        return;
    L63:
        return;
    }

    @Override // s22.c.a
    public final void q7(boolean r3) {
        if (r3 == false) goto L4;
        this.S1.e(cc2.j.b.c, true);
    L5:
        xr();
        return;
    L4:
        this.S1.e(cc2.j.b.c, false);
        goto L5
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void rI(Exception r4) {
        if ((r4 instanceof ApiServerException) == false) goto L12;
        ApiServerException r5 = (ApiServerException) r4;
        int r0 = r5.getErrorCode();
        if (50001 != r0) goto L8;
        Xp(true);
        IESUIUtils.displayToast(this.s, r5.getPrompt());
    L11:
        Qq(r5);
        return;
    L8:
        if (50005 != r0) goto L10;
        f2.c(r5.getPrompt(), 0);
        goto L11
    L10:
        IESUIUtils.displayToast(this.s, r5.getPrompt());
        goto L11
    L12:
        f2.b(2131918930, 0);
        Logger.e("CommentWidget", "unknown exception " + r4.toString());
    }

    public final void vr(g92.f r2) {
        if (r2.b != OpenInputSource.Preview) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L15;
        IMiddlewareLiveService r4 = jc1.k.f(IMiddlewareLiveService.class);
        if (r4 == null) goto L16;
        ICurrentInteractionUiAction r5 = r4.getCurrentInteractionUiAction();
        if (r5 == null) goto L17;
        IRoom r0 = this.r;
        if (r0 == null) goto L18;
        r5.showInteractionAndEnterRoom(r0.getIdStr());
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void wr(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        f2.c(r2, 0);
    L5:
        Boolean r3 = Boolean.FALSE;
        this.l = r3;
        this.m = r3;
        x22.c r4 = this.C;
        if (r4 == null) goto L9;
        r4.getClass();
        return;
    }

    public void yr(boolean r9) {
        if (this.b == null) goto L70;
        boolean r0 = Tq();
        j40.a1 r1 = j40.a1.a;
        int r3 = 2131249085;
        int r4 = 8;
        Drawable r7 = null;
        if (((d51) r1.getValue()).c() == false) goto L27;
        if (this.x == true) goto L27;
        View r2 = this.b;
        if (r9 == false) goto L13;
        if (r0 == true) goto L13;
        Drawable r5 = null;
    L16:
        r2.setBackground(r5);
        View r6 = this.p;
        if (r6 == null) goto L23;
        if (r9 == false) goto L21;
        if (r0 == true) goto L21;
    L22:
        r6.setVisibility(r4);
    L21:
        r4 = 0;
    L23:
        View r10 = this.c;
        if (r10 == null) goto L71;
        r10.setBackground(null);
        return;
    L71:
        return;
    L13:
        if (Yq() == false) goto L15;
        r3 = 2131249082;
    L15:
        r5 = s1.m(r3);
    L27:
        if (((d51) r1.getValue()).d() == true) goto L29;
    L50:
        View r8 = this.d;
        if (r8 == null) goto L53;
        r8.setVisibility(8);
    L53:
        View r11 = this.b;
        if (r9 == false) goto L57;
        Drawable r13 = null;
    L60:
        r11.setBackground(r13);
        View r14 = this.p;
        if (r14 == null) goto L66;
        if (r9 == true) goto L65;
        r4 = 0;
    L65:
        r14.setVisibility(r4);
    L66:
        View r15 = this.c;
        if (r15 == null) goto L75;
        r15.setBackground(null);
        return;
    L75:
        return;
    L57:
        if (Yq() == false) goto L59;
        r3 = 2131249082;
    L59:
        r13 = s1.m(r3);
        goto L60
    L29:
        if (this.x == true) goto L50;
        this.b.setBackground(null);
        View r16 = this.d;
        if (r16 != null) goto L33;
    L37:
        View r17 = this.c;
        if (r17 == null) goto L47;
        if (r9 == false) goto L43;
        if (r0 == true) goto L43;
    L46:
        r17.setBackground(r7);
    L43:
        if (Yq() == false) goto L45;
        r3 = 2131249082;
    L45:
        r7 = s1.m(r3);
    L47:
        View r18 = this.p;
        if (r18 == null) goto L73;
        r18.setVisibility(8);
        return;
    L73:
        return;
    L33:
        if ((r16.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L37;
        RelativeLayout.LayoutParams r19 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (r19 == null) goto L37;
        r19.leftMargin = s1.f(10.0f);
        goto L37
    }

    public void onEvent(e3 r3) {
        CommentWidgetAnimator r0 = this.L;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3.c != 2) goto L7;
        return;
    L7:
        if (r0.e != ((Boolean) l42.a.g.getValue()).booleanValue()) goto L9;
        return;
    L9:
        jr();
    }

    public void onEvent(u22.m r1) {
        Er(r1);
    }

    public static void ar(g92.f r6, String r7) {
        com.bytedance.android.livesdk.interactivity.api.monitor.b.c(r6.b.getSource(), false, r7, null, null, null);
    }

    public static void zq(CommentWidget r13, u22.m.a r14) {
        r13.getClass();
        if (r14 == null) goto L34;
        int r0 = r14.b;
        String r6 = "1";
        if (r0 != 2) goto L17;
        HashMap r15 = new HashMap(1);
        r15.put("user_id", jc1.k.f(IMiddlewareUserService.class).user().n());
        r15.put("to_user_id", String.valueOf(r14.d));
        if (r14.c == false) goto L10;
        Object r1 = "1";
    L11:
        r15.put("is_anchor", r1);
        if (r14.l == true) goto L15;
        r6 = "0";
    L15:
        r15.put("vs_is_official_comment", r6);
        r15.putAll(r14.h);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_long_press_message", r15, new Object[]{IRoom.class, am2.x.class});
        r15.put("trigger_type", "long_press");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_at_reply", r15, new Object[]{IRoom.class, am2.x.class});
        return;
    L10:
        r1 = "0";
        goto L11
    L17:
        if (r0 == 3) goto L19;
        return;
    L19:
        if ("0".equals(com.bytedance.android.live.core.utils.a0.n(((Widget) r13).dataCenter).getOwnerUserIdString()) == false) goto L21;
        String r16 = BuildConfig.FLAVOR;
    L22:
        boolean r17 = TextUtils.equals(r16, r14.d);
        HashMap r2 = new HashMap(1);
        r2.put("user_id", jc1.k.f(IMiddlewareUserService.class).user().n());
        r2.put("to_user_id", String.valueOf(r14.d));
        if (r17 == false) goto L25;
        String r18 = "anchor";
    L26:
        r2.put("user_type", r18);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_card_click_at", r2, new Object[]{IRoom.class, am2.x.class});
        r2.put("trigger_type", "profile_at");
        if (r17 == true) goto L30;
        r6 = "0";
    L30:
        r2.put("is_anchor", r6);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_at_reply", r2, new Object[]{IRoom.class, am2.x.class});
        return;
    L25:
        r18 = "audience";
        goto L26
    L21:
        r16 = com.bytedance.android.live.core.utils.a0.n(((Widget) r13).dataCenter).getOwnerUserIdString();
        goto L22
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void A20(com.bytedance.android.livesdk.event.d0 r5, com.bytedance.android.live.base.model.message.k0 r6) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.U == false) goto L8;
        this.U = false;
        xr();
    L8:
        x22.b r0 = this.B;
        if (r0 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = ((LiveInputDialogV3) r0).g;
        if (r1 == null) goto L17;
        EditText r2 = r1.a;
        if (r2 == null) goto L17;
        r2.setText(BuildConfig.FLAVOR);
    L17:
        if ((this.s instanceof FragmentActivity) == false) goto L22;
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L22;
        jc1.k.f(IMiddlewareHostApp.class).checkBindHelpShow(this.s, "live_comment");
    L22:
        if (r6.getContentSelfSeeStatus() != 0) goto L24;
        CommentUtils.a(r6, ((Widget) this).dataCenter);
    L24:
        xs2.b.a().post(new u22.i(r6));
        mr(r5, new u(r6));
        IInteractivityInjectService r7 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r7 == null) goto L28;
        r7.onMessageSendSuccess((Room) ((Widget) this).dataCenter.get("data_room", null));
        return;
    L28:
        return;
    L15:
        this.p1.a(0).a = BuildConfig.FLAVOR;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void EH(String r2, int r3) {
        if (r3 != 1) goto L6;
        this.T = r2;
        this.U = true;
    L8:
        xr();
        return;
    L6:
        if (r3 != 2) goto L8;
        this.U = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void R10(com.bytedance.android.livesdk.event.c0 r7, com.bytedance.android.live.base.model.message.v0 r8) {
        r8.setLocalInsertMsg(true);
        if (this.U == false) goto L6;
        this.U = false;
        xr();
    L6:
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter) == null) goto L8;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter).B(r8);
    L8:
        HashMap<String, String> r1 = new HashMap();
        if (r8.getEmojiId() == null) goto L24;
        r1.put("emoji_id", r8.getEmojiId().toString());
        if (r7.c != 0) goto L13;
        String r9 = "4:3";
    L14:
        r1.put("emoji_scale", r9);
        String r3 = "1";
        if (r7.d == false) goto L17;
        String r10 = "1";
    L18:
        r1.put("is_new", r10);
        if (this.q == true) goto L22;
        r3 = "0";
    L22:
        r1.put("is_anchor", r3);
        goto L24
    L17:
        r10 = "0";
        goto L18
    L13:
        r9 = "3:1";
    L24:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L26;
        String r11 = "horizontal";
    L27:
        r1.put("room_orientation", r11);
        if (((Boolean) l42.a.u.getValue()).booleanValue() == false) goto L30;
        String r13 = "vip_page";
    L31:
        r1.put("request_page", r13);
        Map<? extends String, ? extends String> r14 = r7.h;
        if (r14 == null) goto L34;
        r1.putAll(r14);
    L34:
        r1.put("livevip_status", k6.a());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_livevip_emoji_send", r1, new Object[]{IRoom.class, am2.x.class});
        HashMap<String, String> r15 = new HashMap();
        Map<? extends String, ? extends String> r16 = r7.h;
        if (r16 == null) goto L38;
        r15.putAll(r16);
    L38:
        if (this.r == null) goto L40;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(((Widget) this).dataCenter, r1);
    L40:
        x22.a r17 = this.C.c;
        if (r17 == null) goto L43;
        r15.put("default_text", r17.a);
        r15.put("default_text_type", this.C.c.getType().getTypeName());
    L43:
        Aq(r15);
        r15.put("content_type", "member_emoji");
        Bq(r1);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_live_message", r15, new Object[]{IRoom.class, am2.x.class});
        return;
    L30:
        r13 = "comment";
        goto L31
    L26:
        r11 = "vertical";
        goto L27
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Vh(Exception r13, com.bytedance.android.livesdk.event.y r14) {
        int r0 = r14.b;
        if ((r13 instanceof ApiServerException) == false) goto L40;
        ApiServerException r15 = (ApiServerException) r13;
        int r1 = r15.getErrorCode();
        if (50001 != r1) goto L8;
        Xp(true);
        IESUIUtils.displayToast(this.s, r15.getPrompt());
    L38:
        Qq(r15);
    L45:
        Zq(r0);
        return;
    L8:
        if (50004 != r1) goto L10;
    L29:
        x22.b r16 = this.B;
        if (r16 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r17 = ((LiveInputDialogV3) r16).g;
        if (r17 == null) goto L37;
        EditText r18 = r17.a;
        if (r18 == null) goto L37;
        r18.setText(BuildConfig.FLAVOR);
    L37:
        dismissInputDialog();
        IESUIUtils.displayToast(this.s, r15.getPrompt());
        goto L38
    L36:
        this.p1.a(0).a = BuildConfig.FLAVOR;
        goto L37
    L10:
        if (50014 == r1) goto L29;
        if (80074 == r1) goto L29;
        if (40001 != r1) goto L26;
        String r2 = r15.getPrompt();
        Object r19 = r14.d.get("money");     // Catch: Throwable -> L21
        Objects.requireNonNull(r19);     // Catch: Throwable -> L21
        long r8 = ((Long) r19).longValue();     // Catch: Throwable -> L21
        boolean r110 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: Throwable -> L21
        long r9 = r8 - com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class).rechargeCenter().getAvailableDiamonds();
        if (r9 > 0) goto L24;
    L23:
        r9 = 1;
    L24:
        f2.c(r2, 0);
        x2.a r111 = new x2.a();
        ((y2) r111).a = 1;
        Intrinsics.checkNotNullParameter("live_detail", "<set-?>");
        ((y2) r111).b = "live_detail";
        ((y2) r111).e = r9;
        Intrinsics.checkNotNullParameter("danmu", "<set-?>");
        ((y2) r111).c = "danmu";
        xs2.b.a().post(r111.a());
    L21:
        th = move-exception;
        ALogger.e("CommentWidget", "failed to calculate lackDiamond in handleMoneyNotEnough", th);
        goto L23
    L26:
        if (r1 != 50019) goto L28;
        dismissInputDialog();
        b32.a.a(this.s, "send_barrage", new b0(this), new c0(this));
        goto L38
    L28:
        ExceptionUtils.handleException(getContext(), r15);
        goto L38
    L40:
        if ((r13 instanceof SendPrivilegeBarrageException) == true) goto L42;
        f2.h(((Widget) this).context, 2131918956, 0);
        Logger.d("CommentWidget", "unknown exception " + r13.toString());
        goto L45
    L42:
        if (((SendPrivilegeBarrageException) r13).getReason() != 1) goto L45;
        xs2.b.a().post(new u22.m());
        goto L45
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Y30(CommentFlowContext r5, tlc.d r6) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        long r0 = r5.l;
        x22.b r2 = this.B;
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = ((LiveInputDialogV3) r2).g;
        if (r1 == null) goto L13;
        EditText r3 = r1.a;
        if (r3 == null) goto L13;
        r3.setText(BuildConfig.FLAVOR);
    L13:
        Intrinsics.checkNotNullParameter(r6, "result");
        r5.a = CommentFlowContext.State.Success;
        r5.i = r6;
        y22.e r7 = r5.b;
        if (r7 == null) goto L16;
        r7.c(r5);
    L16:
        int r8 = y22.c.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        StringBuilder r9 = new StringBuilder("[");
        r9.append(r5.hashCode());
        r9.append("] success, type is ");
        Object r10 = r5.i;
        String r4 = null;
        if ((r10 instanceof tlc.d) == true) goto L19;
        r10 = null;
    L19:
        tlc.d r11 = (tlc.d) r10;
        if (r11 == null) goto L22;
        r4 = r11.getMessageMethod();
    L22:
        r9.append(r4);
        ALogger.i("CommentFlowContext", r9.toString());
        return;
    L12:
        this.p1.a(r0).a = BuildConfig.FLAVOR;
        goto L13
    }

    public final Boolean br(u22.m r2, Boolean r3) {
        if (isScreenPortrait() == true) goto L14;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L14;
        if (r2.m != 0) goto L14;
        if (r3.booleanValue() == false) goto L12;
        f2.b(2131915052, 0);
    L12:
        return Boolean.TRUE;
    L14:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void cI(CommentFlowContext r3, Exception r4) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        r3.getClass();
        r3.a = CommentFlowContext.State.Failed;
        r3.j = r4;
        y22.e r0 = r3.b;
        if (r0 == null) goto L8;
        r0.d(r3);
    L8:
        int r1 = y22.c.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        ALogger.i("CommentFlowContext", "[" + r3.hashCode() + "] failed ");
        if ((r4 instanceof ApiServerException) == false) goto L11;
        String r5 = ((ApiServerException) r4).getPrompt();
    L12:
        if (r5 != null) goto L15;
        r5 = s1.B(2131918930);
    L15:
        f2.c(r5, 0);
        if ((r4 instanceof ApiServerException) == false) goto L19;
        int r6 = ((ApiServerException) r4).getErrorCode();     // Catch: Exception -> L22
    L20:
        com.bytedance.android.livesdk.interactivity.api.monitor.a.b(r4, r6);     // Catch: Exception -> L22
        return;
    L19:
        r6 = -1;
    L25:
        return;
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void cT(com.bytedance.android.livesdk.event.x r8, kc2.a r9) {
        CommentUtils.a(r9, ((Widget) this).dataCenter);
        if (this.U == false) goto L5;
        this.U = false;
        xr();
    L5:
        HashMap<String, String> r0 = new HashMap();
        String r3 = "1";
        if (this.q == false) goto L8;
        String r2 = "1";
    L9:
        r0.put("is_anchor", r2);
        r0.put("is_voice", String.valueOf(1));
        if (r9.isResend == false) goto L12;
        String r5 = "resend";
    L13:
        r0.put("send_type", r5);
        r0.put("duration", String.valueOf(r9.audioDuration));
        r0.put("prompt", r9.content);
        r0.put("comment_id", r9.msgId);
        if (((Boolean) b6.X.getValue()).booleanValue() == false) goto L16;
        String r10 = "1";
    L17:
        r0.put("is_screen_clear", r10);
        r0.put("connection_type", jc1.k.f(IInteractService.class).getLinkConnectionType());
        boolean r11 = com.bytedance.android.live.revenue.core.util.h.a;
        r0.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getLinkAnchorCount());
        if (com.bytedance.android.livesdk.utils.landscape.e.b(this.q, this.r) == true) goto L20;
        String r13 = "1";
    L21:
        r0.put("if_danmu", r13);
        if (com.bytedance.android.livesdk.interactivity.api.p.a() == true) goto L25;
        r3 = "0";
    L25:
        r0.put("is_comment_inter_flow", r3);
        IInteractivityInjectService r14 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r14 == null) goto L28;
        r0.put("is_vr_machine", r14.getVrMachineLogStr(((Widget) this).dataCenter));
        r14.appendCastSDKLogCommonParams(r0);
    L28:
        r3.m(r0, ((Widget) this).context);
        r0.put("content_length", "0");
        r0.put("at_user_id", "null");
        if (this.r == null) goto L32;
        if (r14 == null) goto L32;
        r14.buildVsRoomLog(((Widget) this).dataCenter, r0);
    L32:
        Aq(r0);
        Bq(r0);
        x22.a r4 = this.C.c;
        if (r4 == null) goto L35;
        r0.put("default_text", r4.a);
        r0.put("default_text_type", this.C.c.getType().getTypeName());
    L35:
        com.bytedance.android.livesdk.log.j0 r6 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r1 = new am2.x();
        r1.a = "live_interact";
        r6.sendLog("audience_live_message", r0, new Object[]{am2.u.class, r1, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        Boolean r7 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r8, "is_from_click_event", r7)).booleanValue() == false) goto L38;
        z32.c.b(InputValueNode.SendAudioSuccess);
    L38:
        if (r14 == null) goto L41;
        r14.onMessageSendSuccess((Room) ((Widget) this).dataCenter.get("data_room", null));
        return;
    L41:
        return;
    L20:
        r13 = "0";
        goto L21
    L16:
        r10 = "0";
        goto L17
    L12:
        r5 = "success";
        goto L13
    L8:
        r2 = "0";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void f30(Exception r8, kc2.a r9) {
        if ((r8 instanceof ApiServerException) == false) goto L13;
        ApiServerException r10 = (ApiServerException) r8;
        int r0 = r10.getErrorCode();
        if (r0 != 50005) goto L10;
        if (TextUtils.isEmpty(r10.getPrompt()) == true) goto L10;
        f2.c(r10.getPrompt(), 0);
    L10:
        if (50001 != r0) goto L12;
        Xp(true);
        IESUIUtils.displayToast(this.s, r10.getPrompt());
        goto L13
    L12:
        IESUIUtils.displayToast(this.s, r10.getPrompt());
    L13:
        CommentUtils.a(r9, ((Widget) this).dataCenter);
        HashMap<String, String> r11 = new HashMap();
        String r3 = "1";
        if (this.q == false) goto L16;
        String r1 = "1";
    L17:
        r11.put("is_anchor", r1);
        r11.put("is_voice", String.valueOf(1));
        if (r9.isResend == false) goto L20;
        String r2 = "resend";
    L21:
        r11.put("send_type", r2);
        r11.put("duration", String.valueOf(r9.audioDuration));
        if (((Boolean) b6.X.getValue()).booleanValue() == false) goto L24;
        String r13 = "1";
    L25:
        r11.put("is_screen_clear", r13);
        r11.put("connection_type", jc1.k.f(IInteractService.class).getLinkConnectionType());
        boolean r14 = com.bytedance.android.live.revenue.core.util.h.a;
        r11.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getLinkAnchorCount());
        if (com.bytedance.android.livesdk.utils.landscape.e.b(this.q, this.r) == false) goto L29;
        r3 = "0";
    L29:
        r11.put("if_danmu", r3);
        r11.put("is_vr_machine", ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getVrMachineLogStr(((Widget) this).dataCenter));
        r11.put("content_length", "0");
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L32;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r11);
    L32:
        r3.m(r11, ((Widget) this).context);
        r11.put("at_user_id", "null");
        if (this.r == null) goto L35;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(((Widget) this).dataCenter, r11);
    L35:
        Aq(r11);
        Bq(r11);
        com.bytedance.android.livesdk.log.j0 r15 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r4 = new am2.x();
        r4.a = "live_interact";
        r15.sendLog("audience_live_message", r11, new Object[]{am2.u.class, r4, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        return;
    L24:
        r13 = "0";
        goto L25
    L20:
        r2 = "fail";
        goto L21
    L16:
        r1 = "0";
        goto L17
    }

    public final Boolean hr(CommentEntry r14, g92.f r15) {
        OpenInputSource r0 = r15.b;
        if (r0 == null) goto L8;
        String r1 = r0.getSource();
        com.bytedance.android.livesdk.interactivity.api.settings.config.n r2 = com.bytedance.android.livesdk.interactivity.api.monitor.b.a;
        Intrinsics.checkNotNullParameter(r1, "source");
        if (com.bytedance.android.livesdk.interactivity.api.monitor.b.a.monitorTryShow == false) goto L8;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("source", r1);
        Unit r3 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r4 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, r8, 7);
        r4.a(InteractivityMonitor.Event.InputPanelRequestShow);
        r4.b(InteractivityTraceMonitor.Event.InputPanelRequestShow);
    L8:
        Iterator r5 = ((HashSet) this.h1).iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        CommentFlowContext r6 = ((y22.e) r5.next()).b(r14, r15.e);
        if (r6 == null) goto L10;
    L15:
        if (r6 == null) goto L32;
        Iterator r7 = ((HashSet) this.h1).iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        if (((y22.e) r7.next()).e(r6) == false) goto L18;
        return Boolean.FALSE;
    L23:
        r6.a = CommentFlowContext.State.Input;
        y22.e r9 = r6.b;
        if (r9 == null) goto L26;
        CommentInputConfig r10 = r9.a(r6);
    L27:
        r6.d = r10;
        int r11 = y22.c.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        StringBuilder r13 = new StringBuilder("[");
        r13.append(r6.hashCode());
        r13.append("] input, config is ");
        CommentInputConfig r16 = r6.d;
        if (r16 == null) goto L30;
        String r17 = r16.toString();
    L31:
        r13.append(r17);
        ALogger.i("CommentFlowContext", r13.toString());
        goto L32
    L30:
        r17 = null;
        goto L31
    L26:
        r10 = null;
    L32:
        OpenInputSource r18 = r15.b;
        OpenInputSource r19 = OpenInputSource.EmojiExpose;
        boolean r20 = true;
        boolean r21 = false;
        if (r18 != r19) goto L35;
        boolean r23 = true;
    L36:
        this.x1 = r23;
        if (CommentEntry.Click != r14) goto L39;
        boolean r110 = true;
    L40:
        Boolean r111 = Boolean.valueOf(r110);
        this.H = r111;
        if (r111.booleanValue() == false) goto L43;
        z32.c.b(InputValueNode.ClickComment);
    L43:
        boolean r112 = this.H.booleanValue();
        if (this.B == null) goto L46;
    L307:
        vr(r15);
        ar(r15, "view invalid");
    L308:
        r20 = false;
    L310:
        return Boolean.valueOf(r20);
    L46:
        if (((Widget) this).isViewValid == false) goto L307;
        if (this.r.isMergeVSRoom() == true) goto L51;
    L57:
        IRoom r24 = this.r;
        if (r24 != null) goto L60;
    L69:
        IMiddlewareUserService r25 = jc1.k.f(IMiddlewareUserService.class);
        if (r25 == null) goto L78;
        if (r25.user().isLogin() == true) goto L75;
        Bundle r113 = new Bundle();
        com.bytedance.android.livesdk.user.e r26 = r25.user();
        Context r27 = ((Widget) this).context;
        com.bytedance.android.livesdk.user.l.a r28 = new com.bytedance.android.livesdk.user.l.a();
        r28.a = s1.B(2131915990);
        r28.d = "comment_live";
        r28.c = -1;
        r28.h = r113;
        r28.e = BuildConfig.FLAVOR;
        r26.login(r27, new com.bytedance.android.livesdk.user.l(r28)).compose(getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.NotLogin.getReason());
        vr(r15);
        ar(r15, "not login");
        goto L308
    L75:
        if (r25.user().g(LiveInteractFunction.COMMENT) == false) goto L78;
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.UserCenterIntercept.getReason());
        vr(r15);
        ar(r15, "user center intercept");
    L78:
        if (this.q == true) goto L153;
        IRoom r29 = this.r;
        if (r29 == null) goto L86;
        IRoomAuthStatus r30 = r29.getRoomAuthStatus();
        if (r30 == null) goto L86;
        IRoomAuthStatus.IRoomAuthSpecialStyle r31 = r30.getRoomAuthSpecialStyle();
        if (r31 == null) goto L86;
        IRoomAuthStatusStyle r33 = r31.getChatStyle();
    L87:
        if (r33 == null) goto L89;
        boolean r34 = true;
    L90:
        if (r34 == false) goto L153;
        IRoomAuthStatusStyle r35 = this.r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle();
        IRoom r36 = this.r;
        if (r36 != null) goto L94;
    L98:
        long r37 = -1;
    L99:
        com.bytedance.android.livesdk.log.b0 r38 = com.bytedance.android.livesdk.log.b0.o();
        String r39 = "Check Anchor Comment Switch Disable, FollowStatus:" + r37 + " AnchorSwitch:" + r35.getAnchorSwitch();
        r38.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r39);
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.a(this.r) == true) goto L125;
        IBaseUser r40 = (IBaseUser) ((Widget) this).dataCenter.get("data_user_in_room", null);
        if (r40 != null) goto L106;
        r40 = jc1.k.f(IMiddlewareUserService.class).user().b();
    L106:
        if (r40.getIdString().equals(this.r.getAnchorId()) == true) goto L125;
        if (r35.getAnchorSwitch() != 1) goto L112;
    L124:
        boolean r41 = true;
    L126:
        if (r41 == false) goto L135;
        if (r6 == null) goto L131;
        CommentInputConfig r43 = r6.d;
        if (r43 == null) goto L131;
        boolean r44 = r43.n;
    L132:
        if (r44 == true) goto L135;
        IESUIUtils.displayToast(this.s, com.bytedance.android.livesdk.interactivity.comment.utils.f.c(this.r));
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.SpecialStyle.getReason());
        vr(r15);
        ar(r15, "special style intercept");
    L131:
        r44 = false;
    L135:
        if (this.r.isMergeVSRoom() == false) goto L137;
    L139:
        boolean r45 = false;
    L141:
        if (this.r.isMergeVSRoom() == true) goto L143;
    L145:
        if (r45 == false) goto L153;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r46 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter);
        PaidSceneEnum r47 = PaidSceneEnum.PAID_ROOM;
        if (r46.e1(r47) == true) goto L153;
        String r114 = this.r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().getContentForPaidLive();
        if (TextUtils.isEmpty(r114) == false) goto L151;
        r114 = s1.B(2131921175);
    L151:
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).k2(r47, new HashMap(), true, null);
        f2.c(r114, 0);
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.NotPaid.getReason());
        vr(r15);
        ar(r15, "vs paid live intercept");
        goto L308
    L143:
        if (this.r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().getAnchorSwitchForPaidLive() != 2) goto L145;
        r45 = true;
        goto L145
    L137:
        if (this.r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().getAnchorSwitchForPaidLive() == 1) goto L139;
        r45 = true;
        goto L141
    L112:
        if (r35.getAnchorSwitch() != 3) goto L119;
        if (r37 == 2) goto L119;
        if (r37 != 3) goto L124;
    L119:
        if (r35.getAnchorSwitch() != 5) goto L125;
        if (r37 == 2) goto L125;
        if (r37 != 1) goto L124;
    L125:
        r41 = false;
        goto L126
    L94:
        if (r36.getOwner() == null) goto L98;
        if (this.r.getOwner().getFollowInfo() == null) goto L98;
        r37 = this.r.getOwner().getFollowInfo().getFollowStatus();
        goto L99
    L89:
        r34 = false;
    L86:
        r33 = null;
    L153:
        if (this.C.a == false) goto L161;
        if (r6 == null) goto L158;
        CommentInputConfig r48 = r6.d;
        if (r48 == null) goto L158;
        boolean r49 = r48.m;
    L159:
        if (r49 == true) goto L161;
        IESUIUtils.displayToast(this.s, 2131920062);
        ALogger.i("CommentWidget", "user ban");
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.UserBan.getReason());
        vr(r15);
        ar(r15, "user banned");
    L158:
        r49 = false;
    L161:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r50 = Lq();
        if (r50 == null) goto L199;
        IRoom r51 = this.r;
        if (r51 == null) goto L199;
        if (r51.isMergeVSRoom() == false) goto L168;
    L170:
        boolean r53 = false;
    L172:
        if (this.r.isMergeVSRoom() == false) goto L179;
        if (r50.isFixedComment() == false) goto L179;
        if (r50.isOGCFixedComment() == true) goto L179;
        r53 = true;
    L179:
        if (this.r.isMergeVSRoom() == true) goto L181;
    L185:
        boolean r54 = false;
    L187:
        if (this.r.isMergeVSRoom() == true) goto L189;
    L193:
        boolean r55 = false;
    L195:
        if (this.r.isMergeVSRoom() == true) goto L197;
    L201:
        boolean r56 = this.x;
        if (r56 == false) goto L205;
        if (r54 == false) goto L205;
        IESUIUtils.displayToast(this.s, s1.B(2131916658));
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.VS.getReason());
        vr(r15);
        ar(r15, "fix comment empty");
    L205:
        if (r56 == false) goto L211;
        if (r53 == false) goto L211;
        if (y22.b.a(r6) == true) goto L211;
        IESUIUtils.displayToast(this.s, r50.getFixCommentToast());
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.VS.getReason());
        vr(r15);
        ar(r15, "fix comment intercept");
    L211:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).F0(PaidInteractEntry.CONTROL_ENTRY_COMMENT) == true) goto L214;
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.NotPaid.getReason());
        vr(r15);
        ar(r15, "not paid");
        goto L308
    L214:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == true) goto L216;
    L226:
        this.v = true;
        ((Widget) this).dataCenter.put("data_pre_show_keyboard", Boolean.TRUE);
        IRoom r57 = this.r;
        if (r57 != null) goto L229;
    L231:
        IRoom r58 = this.r;
        if (r58 != null) goto L234;
    L241:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r59 = Lq();
        this.C.e = null;
        if (r59 == null) goto L257;
        List<IQuickCommentShowWord> r60 = r59.getCurrentQuickComment(this.x);
        if (CollectionUtils.isEmpty(r60) == true) goto L257;
        if (r6 == null) goto L249;
        CommentInputConfig r61 = r6.d;
        if (r61 == null) goto L249;
        CommentInputConfig.State r63 = r61.q;
    L251:
        if (r63 == CommentInputConfig.State.ForeClose) goto L253;
        boolean r64 = true;
    L254:
        if (r64 == false) goto L257;
        this.C.e = new LinkedList();
        this.C.e.addAll(r60);
        goto L257
    L253:
        r64 = false;
    L249:
        r63 = null;
    L257:
        if (this.C == null) goto L266;
        this.l.booleanValue();
        x22.c r65 = this.C;
        r65.f = r15.d;
        DataContext r66 = getRoomContext();
        int r67 = CommentUtils.a;
        if (r66 == null) goto L264;
        IInteractService r68 = jc1.k.f(IInteractService.class);
        if (r68 == null) goto L264;
        boolean r69 = r68.canShowCommentShareVideoButton();
    L265:
        r65.g = r69;
    L264:
        r69 = false;
    L266:
        x22.a r70 = this.S;
        if (r70 == null) goto L269;
        this.C.c = r70;
    L270:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r71 = Fq(this.C, r6, r15);
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r73 = r71.g;
        if (r15.b != r19) goto L273;
        boolean r74 = true;
    L274:
        r73.q = r74;
        if (r112 == false) goto L277;
        r73.m = this.V;
    L277:
        r73.s = r112;
        if (isScreenPortrait() == false) goto L280;
        int r75 = LivePortraitInputDialogV3.L;
        Intrinsics.checkNotNullParameter(r71, "attrs");
        LivePortraitInputDialogV3 r76 = new LivePortraitInputDialogV3();
        r76.d = r71;
        r76.h = r6;
        this.B = r76;
    L281:
        ((LiveInputDialogV3) this.B).j = ((Widget) this).dataCenter;
        if (r55 == false) goto L284;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r77 = Fq(this.C, r6, r15);
        int r78 = OGCFixedInputDialog.D;
        Intrinsics.checkNotNullParameter(r77, "attrs");
        OGCFixedInputDialog r79 = new OGCFixedInputDialog();
        r79.d = r77;
        r79.h = r6;
        this.B = r79;
        r79.j = ((Widget) this).dataCenter;
    L284:
        x22.b r80 = this.B;
        ((LiveInputDialogV3) r80).e = this.G1;
        FragmentActivity r81 = this.s;     // Catch: IllegalStateException -> L306
        LiveInputDialogV3 r83 = (LiveInputDialogV3) r80;     // Catch: IllegalStateException -> L306
        r83.getClass();     // Catch: IllegalStateException -> L306
        if (r81 == null) goto L305;
        FragmentManager r84 = r81.getSupportFragmentManager();     // Catch: IllegalStateException -> L306
        LandscapeRestrictionOperation r85 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: IllegalStateException -> L306
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r83, "INPUT", r85);     // Catch: IllegalStateException -> L306
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r84, r83, r85) == false) goto L312;
    L292:
        if (r112 == false) goto L294;
        z32.c.b(InputValueNode.DialogPopup);     // Catch: IllegalStateException -> L306
    L294:
        IVSPlayerService r115 = jc1.k.f(IVSPlayerService.class);     // Catch: IllegalStateException -> L306
        if (r115 == null) goto L299;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r116 = r115.provideVSPlayerViewControlService(((Widget) this).dataCenter);     // Catch: IllegalStateException -> L306
        if (r116 == null) goto L299;
        r116.setVisibilityStatus(false);     // Catch: IllegalStateException -> L306
    L299:
        lr(r15, r6);     // Catch: IllegalStateException -> L306
        if (r15.b != OpenInputSource.Preview) goto L302;
        r21 = true;
    L302:
        if (r21 == false) goto L310;
        jc1.k.f(IMiddlewareLiveService.class).getCurrentInteractionUiAction().showInteractionMask(this.r.getIdStr());     // Catch: IllegalStateException -> L306
        goto L310
    L312:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L311
    L291:
        r83.show(r84, "INPUT");     // Catch: IllegalStateException -> L306
        goto L292
    L305:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");     // Catch: IllegalStateException -> L306
    L306:
        this.B = null;
        ar(r15, "state loss exception");
        goto L310
    L280:
        int r86 = LiveLandscapeInputDialogV3.A;
        Intrinsics.checkNotNullParameter(r71, "attrs");
        LiveLandscapeInputDialogV3 r87 = new LiveLandscapeInputDialogV3();
        r87.d = r71;
        r87.h = r6;
        this.B = r87;
        goto L281
    L273:
        r74 = false;
        goto L274
    L269:
        x22.a r88 = Jq(this.a.getMeasuredWidth(), this.a.getPaint(), false);
        this.S = r88;
        this.C.c = r88;
        goto L270
    L234:
        if (r58.allowGift() == true) goto L241;
        String r89 = s1.B(2131915338);
        if (this.r.getRoomAuthStatus().getOffReason() != null) goto L238;
    L240:
        this.C.d = r89;
        goto L241
    L238:
        if (TextUtils.isEmpty(this.r.getRoomAuthStatus().getOffReason().getGift()) == true) goto L240;
        r89 = this.r.getRoomAuthStatus().getOffReason().getGift();
        goto L240
    L229:
        if (r57.getRoomAuthStatus() == null) goto L231;
        this.C.b = this.r.getRoomAuthStatus().getEnableDanmaku();
        goto L231
    L216:
        if (this.x == true) goto L226;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L226;
        if (r6 == null) goto L223;
        CommentInputConfig r90 = r6.d;
        if (r90 == null) goto L223;
        boolean r91 = r90.p;
    L224:
        if (r91 == true) goto L226;
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.LandscapeBlock.getReason());
        vr(r15);
        ar(r15, "landscape block");
    L223:
        r91 = false;
        goto L224
    L197:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(this.r.getRoomAuthStatus()) == true) goto L201;
    L200:
        r55 = false;
        goto L201
    L189:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(this.r.getRoomAuthStatus()) == false) goto L193;
        if (y22.b.a(r6) == true) goto L193;
        r55 = true;
        goto L195
    L181:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(this.r.getRoomAuthStatus()) == false) goto L185;
        if (r50.isOGCFixedCommentEmpty() == false) goto L185;
        r54 = true;
        goto L187
    L168:
        if (r50.isFixedComment() == false) goto L170;
        r53 = true;
    L199:
        r53 = false;
        r54 = false;
        goto L200
    L60:
        if (r24.getRoomAuthStatus() == null) goto L69;
        if (this.r.getRoomAuthStatus().getEnableChat() == true) goto L69;
        String r117 = ((o72.a) ec2.n.a.getValue()).e();
        if (r117 != null) goto L66;
    L67:
        r117 = s1.B(2131915461);
    L68:
        f2.c(r117, 0);
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.CommentClose.getReason());
        vr(r15);
        ar(r15, "room auth close");
        goto L308
    L66:
        if (r117.isEmpty() == false) goto L68;
    L51:
        if (isScreenPortrait() == false) goto L57;
        IVSPlayerService r93 = jc1.k.f(IVSPlayerService.class);
        if (r93 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r94 = r93.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r94 == null) goto L57;
        r94.setVisibilityStatus(false);
        goto L57
    L39:
        r110 = false;
        goto L40
    L35:
        r23 = false;
        goto L36
    L14:
        r6 = null;
        goto L15
    }

    public final void lr(g92.f r10, CommentFlowContext r11) {
        HashMap r0 = new HashMap();
        r0.put("request_page", this.D);
        u22.m.a r1 = this.I;
        if (r1 != null) goto L5;
    L14:
        String r2 = this.E;
        if (r2 == null) goto L20;
        if (r2.equals("barrage") == false) goto L20;
        r0.put("comment_carnival_trigger_type", this.D);
    L20:
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L23;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r0);
    L23:
        if (this.q == false) goto L25;
        r0.put("user_type", "anchor");
        r0.put("is_anchor", "1");
    L33:
        IRoom r3 = this.r;
        if (r3 == null) goto L36;
        r0.put("audience_type", r3.getAudienceType());
    L36:
        x22.a r4 = this.C.c;
        if (r4 == null) goto L40;
        r0.put("default_text", r4.a);
        r0.put("default_text_type", this.C.c.getType().getTypeName());
    L40:
        if (r10.b != OpenInputSource.Preview) goto L42;
        boolean r13 = true;
    L43:
        if (r13 == false) goto L50;
        String r14 = this.W;
        if (r14 == null) goto L50;
        if (r14.isEmpty() == true) goto L50;
        r0.put("guide_text", this.W);
        r0.put("request_source", "preview_guide");
    L50:
        if (r11 != null) goto L53;
        r0.put("panel_type", "default");
    L55:
        com.bytedance.android.livesdk.log.j0.l().sendLog("comment_pannel_show", r0, new Object[]{new am2.x(), IRoom.class});
        return;
    L53:
        if (r11.c != CommentScene.SquareChat) goto L55;
        r0.put("panel_type", "square");
        goto L55
    L42:
        r13 = false;
        goto L43
    L25:
        r0.put("is_anchor", "0");
        if (jc1.k.f(IMiddlewareUserService.class) == null) goto L33;
        if (jc1.k.f(IMiddlewareUserService.class).user().q() == null) goto L33;
        if (jc1.k.f(IMiddlewareUserService.class).user().q().isAdmin() == false) goto L32;
        r0.put("user_type", "admin");
        goto L33
    L32:
        r0.put("user_type", "user");
        goto L33
    L5:
        if (r1.c == false) goto L7;
        Object r5 = "1";
    L8:
        r0.put("is_anchor", r5);
        r0.put("to_user_id", String.valueOf(this.I.d));
        long r6 = this.I.f;
        if (r6 <= 0) goto L12;
        r0.put("from_comment_id", String.valueOf(r6));
    L12:
        if (((HashMap) this.I.g).isEmpty() == true) goto L14;
        r0.putAll(this.I.g);
        goto L14
    L7:
        r5 = "0";
        goto L8
    }

    public final void mr(com.bytedance.android.livesdk.event.d0 r29, t r30) {
        HashMap<String, String> r4 = new HashMap();
        String r6 = "0";
        if (this.q == false) goto L5;
        String r0 = "1";
    L6:
        r4.put("is_anchor", r0);
        com.bytedance.android.live.profit.lottery.i r1 = yt0.c.f();
        if (r1 == null) goto L13;
        com.bytedance.android.live.profit.lottery.g r2 = (com.bytedance.android.live.profit.lottery.g) r1.getCurrentLottery().getValue();
        if (r2 == null) goto L13;
        if ((r2.getState() instanceof LotteryState.g) == false) goto L13;
        r4.put("lottery_id", String.valueOf(r2.getState().a.a));
    L13:
        String r3 = this.E;
        if (r3 == null) goto L19;
        if (r3.equals("barrage") == false) goto L19;
        r4.put("comment_carnival_trigger_type", this.D);
    L19:
        if (TextUtils.isEmpty(this.E) == true) goto L21;
        r4.put("message_source", this.E);
        this.E = null;
    L21:
        IRoom r5 = this.r;
        if (r5 == null) goto L413;
        int r9 = com.bytedance.android.live.core.utils.h1.a;
        r4.put("live_type", i1.a(r5.getStreamType()));
        r4.putAll(com.bytedance.android.live.core.utils.h1.a(this.r));
    L413:
        r4.put("comment_id", String.valueOf(r30.getChatId()));     // Catch: Exception -> L28
        r4.put("live_source", this.t);     // Catch: Exception -> L28
        if (TextUtils.isEmpty(this.r.getSourceType()) == true) goto L30;
        r4.put("moment_room_source", this.r.getSourceType());     // Catch: Exception -> L28
    L30:
        boolean r7 = !Lists.isEmpty(ab2.a.d(r30.getContent()));
        if (r7 == false) goto L33;
        String r10 = "1";
    L34:
        r4.put("with_emoji", r10);
        if (r7 == false) goto L41;
        if (this.x1 == false) goto L39;
        r4.put("emoji_send_entrance_pattern", "live_emoji");
        goto L41
    L39:
        r4.put("emoji_send_entrance_pattern", "comment_keyboard_emoji");
    L41:
        if (r29.b.equals(ISendCommentEvent.Sender.Lottery) == false) goto L43;
        String r8 = "lottery";
    L44:
        r4.put("request_page", r8);
        Iterator r11 = r29.c.entrySet().iterator();
    L46:
        if (r11.hasNext() == false) goto L51;
        Map.Entry r13 = (Map.Entry) r11.next();
        if ((r13.getValue() instanceof String) == false) goto L46;
        r4.put((String) r13.getKey(), (String) r13.getValue());
        goto L46
    L51:
        if (r4.containsKey("is_shortcut_message") == true) goto L53;
        r4.put("is_shortcut_message", "0");
    L53:
        String r14 = this.D;
        if (r14 == null) goto L75;
        if (this.I == null) goto L75;
        r4.put("request_page", r14);
        r4.put("to_user_id", String.valueOf(this.I.d));
        if (TextUtils.isEmpty(this.I.i) == true) goto L60;
        r4.put("webcast_to_user_id", this.I.i);
    L60:
        String r15 = r29.a;
        String r16 = this.I.e;
        if (TextUtils.isEmpty(r15) == false) goto L63;
    L67:
        boolean r17 = false;
    L68:
        if (r17 == false) goto L70;
        String r18 = "0";
    L71:
        r4.put("is_modify", r18);
        long r19 = this.I.f;
        if (r19 <= 0) goto L75;
        r4.put("from_comment_id", String.valueOf(r19));
        goto L75
    L70:
        r18 = "1";
        goto L71
    L63:
        if (TextUtils.isEmpty(r16) == true) goto L67;
        if (r15.contains(r16) == false) goto L67;
        r17 = true;
    L75:
        if (InteractGameContext.isAnchorPlayingGame() == false) goto L77;
        String r110 = "1";
    L78:
        r4.put("is_gaming", r110);
        if (((Boolean) b6.X.getValue()).booleanValue() == false) goto L81;
        String r111 = "1";
    L82:
        r4.put("is_screen_clear", r111);
        Long r112 = com.bytedance.android.livesdk.interactivity.comment.utils.e.a;
        Intrinsics.checkNotNullParameter(r29, "event");
        Intrinsics.checkNotNullParameter(r4, "map");
        com.bytedance.android.livesdk.event.m r113 = r29.d;
        if (r113 == null) goto L96;
        List r114 = r113.a;
        if (r114 == null) goto L96;
        ArrayList r115 = new ArrayList();
        Iterator r116 = r114.iterator();
    L88:
        if (r116.hasNext() == false) goto L97;
        ImageSpan r117 = ((com.bytedance.android.livesdk.event.n) r116.next()).f;
        if ((r117 instanceof com.bytedance.android.livesdk.interactivity.comment.input.a) == true) goto L92;
        r117 = null;
    L92:
        com.bytedance.android.livesdk.interactivity.comment.input.a r118 = (com.bytedance.android.livesdk.interactivity.comment.input.a) r117;
        if (r118 == null) goto L88;
        r115.add(r118);
    L97:
        if (r115 != null) goto L99;
    L102:
        boolean r20 = true;
    L103:
        if (r20 == true) goto L105;
        String r21 = "activity_emoji";
    L106:
        com.bytedance.android.livesdk.event.m r119 = r29.d;
        if (r119 == null) goto L124;
        List r120 = r119.a;
        if (r120 == null) goto L124;
        List r121 = r120;
        if ((r121 instanceof Collection) == true) goto L113;
    L115:
        Iterator r122 = r121.iterator();
    L117:
        if (r122.hasNext() == false) goto L121;
        if ((((com.bytedance.android.livesdk.event.n) r122.next()).f instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == false) goto L117;
        boolean r123 = true;
    L122:
        if (r123 != true) goto L124;
        r21 = r21.concat("|fusion");
    L121:
        r123 = false;
        goto L122
    L113:
        if (r121.isEmpty() == false) goto L115;
    L124:
        com.bytedance.android.livesdk.event.m r124 = r29.d;
        if (r124 == null) goto L142;
        List r125 = r124.a;
        if (r125 == null) goto L142;
        List r126 = r125;
        if ((r126 instanceof Collection) == true) goto L131;
    L133:
        Iterator r127 = r126.iterator();
    L135:
        if (r127.hasNext() == false) goto L139;
        if ((((com.bytedance.android.livesdk.event.n) r127.next()).f instanceof com.bytedance.android.livesdk.interactivity.comment.input.d) == false) goto L135;
        boolean r128 = true;
    L140:
        if (r128 != true) goto L142;
        r21 = r21 + "|quick_interaction";
    L139:
        r128 = false;
        goto L140
    L131:
        if (r126.isEmpty() == false) goto L133;
    L142:
        if (r115 == null) goto L146;
        com.bytedance.android.livesdk.interactivity.comment.input.a r129 = (com.bytedance.android.livesdk.interactivity.comment.input.a) CollectionsKt.firstOrNull(r115);
        if (r129 == null) goto L146;
        r4.put("emoji_group_id", String.valueOf(r129.f.getActivityEmojiGroupId()));
    L146:
        r4.put("content_type", r21);
        MiddlewareRoomContext r23 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r23 == null) goto L153;
        com.bytedance.live.datacontext.i r24 = r23.isAnchor();
        if (r24 == null) goto L153;
        if (((Boolean) r24.getValue()).booleanValue() != true) goto L153;
        String r25 = "1";
    L154:
        r4.put("is_anchor", r25);
        com.bytedance.android.livesdk.event.m r26 = r29.d;
        if (r26 == null) goto L168;
        List r27 = r26.a;
        if (r27 == null) goto L168;
        ArrayList r28 = new ArrayList();
        Iterator r31 = r27.iterator();
    L160:
        if (r31.hasNext() == false) goto L167;
        ImageSpan r130 = ((com.bytedance.android.livesdk.event.n) r31.next()).f;
        if ((r130 instanceof com.bytedance.android.livesdk.interactivity.comment.input.d) == true) goto L164;
        r130 = null;
    L164:
        com.bytedance.android.livesdk.interactivity.comment.input.d r131 = (com.bytedance.android.livesdk.interactivity.comment.input.d) r130;
        if (r131 == null) goto L160;
        r28.add(r131);
        goto L160
    L167:
        com.bytedance.android.livesdk.interactivity.comment.input.d r132 = (com.bytedance.android.livesdk.interactivity.comment.input.d) CollectionsKt.firstOrNull(r28);
    L170:
        if (r132 != null) goto L172;
    L176:
        MiddlewareRoomContext r133 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r133 == null) goto L183;
        com.bytedance.live.datacontext.n r134 = r133.getCurStatMessage();
        if (r134 == null) goto L183;
        mk r135 = (mk) r134.getValue();
        if (r135 == null) goto L183;
        Long r136 = Long.valueOf(r135.getTotal());
    L184:
        r4.put("audience_count", String.valueOf(r136));
        ArrayList r137 = new ArrayList();
        ArrayList r138 = new ArrayList();
        com.bytedance.android.livesdk.event.m r139 = r29.d;
        if (r139 == null) goto L212;
        List r140 = r139.a;
        if (r140 == null) goto L212;
        ArrayList r33 = new ArrayList();
        Iterator r34 = r140.iterator();
    L190:
        if (r34.hasNext() == false) goto L195;
        Object r141 = r34.next();
        if ((((com.bytedance.android.livesdk.event.n) r141).f instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == false) goto L190;
        r33.add(r141);
        goto L190
    L195:
        Iterator r35 = r33.iterator();
    L197:
        if (r35.hasNext() == false) goto L212;
        ImageSpan r36 = ((com.bytedance.android.livesdk.event.n) r35.next()).f;
        if ((r36 instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == true) goto L201;
        r36 = null;
    L201:
        com.bytedance.android.livesdk.interactivity.comment.input.c r37 = (com.bytedance.android.livesdk.interactivity.comment.input.c) r36;
        if (r37 == null) goto L197;
        com.bytedance.android.livesdk.interactivity.api.emoji.a r38 = r37.g;
        if (r38 == null) goto L197;
        String r142 = r38.c();
        if (r142 != null) goto L208;
        r142 = BuildConfig.FLAVOR;
    L208:
        r137.add(r142);
        List<String> r39 = r38.e();
        if (r39 == null) goto L197;
        r138.addAll(r39);
    L212:
        if ((!r137.isEmpty()) == false) goto L215;
        r4.put("fusion", CollectionsKt.joinToString$default(r137, "|", null, null, 0, null, null, 62, null));
        r4.put("original_emoji_list", CollectionsKt.joinToString$default(r138, "|", null, null, 0, null, null, 62, null));
    L215:
        if (this.r.getAutoCover() != 0) goto L217;
    L221:
        int[] r40 = i.a;
        HashMap<String, List<String>> r41 = u22.f.a;
        Intrinsics.checkNotNullParameter(r29, "event");
        Object r43 = r29.c.get("quickCommentType");
        if ((r43 instanceof QuickCommentTypeEnum) == true) goto L224;
        r43 = null;
    L224:
        QuickCommentTypeEnum r44 = (QuickCommentTypeEnum) r43;
        if (r44 != null) goto L227;
        r44 = QuickCommentTypeEnum.DEFAULT;
    L227:
        int r45 = r40[r44.ordinal()];
        if (r45 == 1) goto L232;
        if (r45 == 2) goto L231;
        r4.put("prompt", r29.a);
    L233:
        int r46 = x22.f.a;
        Map r47 = r29.c;
        if (r47 == null) goto L239;
        Object r48 = r47.get("paste_edit_method");
        if (r48 == null) goto L239;
        String r49 = r48.toString();
        if (r49 == null) goto L239;
    L240:
        r4.put("paste_edit_method", r49);
        r4.put("is_voice", "0");
        if (u22.f.f(r29) == false) goto L243;
        String r50 = "1";
    L244:
        r4.put("is_from_voice_pannel", r50);
        r4.put("connection_type", jc1.k.f(IInteractService.class).getLinkConnectionType());
        boolean r51 = com.bytedance.android.live.revenue.core.util.h.a;
        r4.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getLinkAnchorCount());
        String r53 = r30.getContent();
        int r54 = CommentUtils.a;
        if (r53 != null) goto L411;
    L265:
        boolean r55 = false;
    L266:
        if (r55 == false) goto L268;
        String r56 = "1";
    L269:
        r4.put("is_only_emoji", r56);
        if (r30.getLandscapeAreaCommon() != null) goto L272;
    L274:
        IRoom r57 = this.r;
        if (r57 != null) goto L277;
    L279:
        com.bytedance.android.livesdk.event.m r58 = r29.d;
        if (r58 == null) goto L282;
        r4.put("related_emoji_type", r58.b);
    L282:
        Object r59 = r29.c.get("comment_send_params");
        if ((r59 instanceof g92.b) == false) goto L305;
        g92.b r60 = (g92.b) r59;
        long r61 = r60.a;
        if (r61 <= 0) goto L287;
        r4.put("send_duration", String.valueOf(r61));
    L287:
        long r63 = r60.c;
        if (r63 <= 0) goto L291;
        r4.put("association_show_send_duration", String.valueOf(r63));
    L291:
        if (r60.d == false) goto L293;
        z32.c.b(InputValueNode.SendChatSuccess);
    L293:
        String r64 = r60.i;
        if (r64 == null) goto L296;
        r4.put("tag_id", r64);
    L296:
        String r65 = r60.h;
        if (r65 == null) goto L300;
        r4.put("tag_text", r65);
    L300:
        if (r60.g <= 0) goto L305;
        if (TextUtils.isEmpty(r60.f) == true) goto L305;
        r4.put("question_id", String.valueOf(r60.g));
        r4.put("question_text", r60.f);
    L305:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(this.q, this.r) == true) goto L307;
        String r66 = "1";
    L308:
        r4.put("if_danmu", r66);
        if (com.bytedance.android.livesdk.interactivity.api.p.a() == false) goto L311;
        String r67 = "1";
    L312:
        r4.put("is_comment_inter_flow", r67);
        if (r30.a().booleanValue() == false) goto L315;
        String r68 = "1";
    L316:
        r4.put("is_chat_channel", r68);
        String r69 = r29.a;
        if (r69 == null) goto L319;
        r4.put("content_length", String.valueOf(r69.length()));
    L319:
        r4.put("is_vr_machine", ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getVrMachineLogStr(((Widget) this).dataCenter));
        if (u22.f.c(r29) == false) goto L322;
        r4.put("is_comment_feedback_copy", "1");
    L322:
        IAggregateService r70 = jc1.k.f(IAggregateService.class);
        if (r70 == null) goto L327;
        JSONObject r71 = r70.getPlayerStatsLog();
        if (r71 == null) goto L327;
        r4.put("stream_cdn_ip", r71.optString("cdn_ip:"));
        r4.put("stream_cdn_play_url", r71.optString("url:"));
    L327:
        JSONObject r73 = new JSONObject();
        JSONObject r74 = new JSONObject();     // Catch: JSONException -> L330
        String r143 = com.bytedance.android.live.core.utils.a0.n(((Widget) this).dataCenter).getOwnerUserIdString();     // Catch: JSONException -> L330
        int r144 = com.bytedance.android.live.base.model.user.n0.a;     // Catch: JSONException -> L330
        com.bytedance.android.live.base.model.user.o0.a.getClass();     // Catch: JSONException -> L330
        r73.put("int64_features", r74.put("event_author_id", com.bytedance.android.live.base.model.user.o0.a.f(r143)));     // Catch: JSONException -> L330
    L332:
        r4.put("__need_pass_other_fields__", r73.toString());
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L336;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r4);
    L336:
        if (r29.c.containsKey("at_user_id") == false) goto L339;
        r4.put("at_user_id", String.valueOf(r29.c.get("at_user_id")));
    L339:
        if (r29.c.containsKey("message_type") == false) goto L342;
        r4.put("message_type", String.valueOf(r29.c.get("message_type")));
    L342:
        if (u22.f.b(r29) == false) goto L344;
        r4.put("is_common_comment", "1");
    L345:
        com.bytedance.android.livesdk.event.q r75 = r29.e;
        if (r75 != null) goto L348;
    L360:
        r4.put("at_user_id", "null");
    L362:
        if (this.r == null) goto L364;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(((Widget) this).dataCenter, r4);
    L364:
        Aq(r4);
        r3.m(r4, ((Widget) this).context);
        Bq(r4);
        x22.a r76 = this.C.c;
        if (r76 == null) goto L367;
        r4.put("default_text", r76.a);
        r4.put("default_text_type", this.C.c.getType().getTypeName());
    L367:
        com.bytedance.android.livesdk.log.j0 r77 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r78 = new am2.x();
        r78.a = "live_interact";
        r77.sendLog("audience_live_message", r4, new Object[]{am2.u.class, r78, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        DataCenter r79 = ((Widget) this).dataCenter;
        if (r79 != null) goto L371;
        return;
    L371:
        if (com.bytedance.android.livesdk.utils.c1.b(r79) == false) goto L389;
        IRoom r80 = this.r;
        if (r80 == null) goto L389;
        if (r80.getOwner() == null) goto L389;
        JSONObject r81 = new JSONObject();
        r81.put("anchor_id", this.r.getOwner().getIdString());     // Catch: JSONException -> L379
        r81.put("room_id", String.valueOf(this.r.getId()));     // Catch: JSONException -> L379
    L381:
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).handleLiveAdExtraData(r81);
        ILiveDouPlusService r83 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r84 = new HashMap();
        r84.put("ad_extra_data", r81.toString());
        Map r85 = com.bytedance.android.livesdk.utils.c1.e(((Widget) this).dataCenter);
        if (r85 != null) goto L384;
    L387:
        r83.logEvent(true, "live_ad", "live_comment", r84);
        goto L389
    L384:
        if (r85.isEmpty() == true) goto L387;
        r84.putAll(r85);
    L379:
        e = move-exception;
        ALogger.e("CommentWidget", e);
    L389:
        if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this).dataCenter) == false) goto L454;
        IRoom r86 = this.r;
        if (r86 != null) goto L393;
        return;
    L393:
        if (r86.getOwner() == null) goto L456;
        JSONObject r87 = new JSONObject();
        r87.put("anchor_id", this.r.getOwner().getIdString());     // Catch: JSONException -> L397
        r87.put("room_id", String.valueOf(this.r.getId()));     // Catch: JSONException -> L397
    L399:
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).handleLiveAdExtraData(r87);
        ILiveDouPlusService r88 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r89 = new HashMap();
        r89.put("ad_extra_data", r87.toString());
        Map r90 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this).dataCenter);
        if (r90.isEmpty() == true) goto L403;
        r89.putAll(r90);
    L403:
        r88.logEvent(true, "live_ad", "live_comment", r89);
        b3.a(((Widget) this).dataCenter, r87);
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).reportAdEvent(((Widget) this).dataCenter, "draw_ad", "click", this.r.getOwnerUserIdString(), this.r.getId());
        return;
    L397:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L399
    L456:
        return;
    L454:
        return;
    L348:
        if (CollectionUtils.isEmpty(r75.a) == true) goto L360;
        StringBuilder r91 = new StringBuilder();
        Iterator r93 = r29.e.a.iterator();
    L351:
        if (r93.hasNext() == false) goto L359;
        com.bytedance.android.livesdk.event.r r94 = (com.bytedance.android.livesdk.event.r) r93.next();
        IBaseUser r145 = r94.e;
        if (r145 == null) goto L351;
        if (r94.f == false) goto L358;
        r6 = "1";
    L358:
        r91.append(r145.getIdString());
        r91.append("|");
        goto L351
    L359:
        r91.deleteCharAt(r91.length() - 1);
        r4.put("at_user_id", r91.toString());
        r4.put("is_mention_list", r6);
        goto L362
    L344:
        r4.put("is_common_comment", "0");
    L330:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L332
    L315:
        r68 = "0";
        goto L316
    L311:
        r67 = "0";
        goto L312
    L307:
        r66 = "0";
        goto L308
    L277:
        if (r57.isMergeVSRoom() == false) goto L279;
        r4.put("vs_is_star_comment", "0");
        goto L279
    L272:
        if (r30.getLandscapeAreaCommon().isStarMessage() == false) goto L274;
        r4.put("vs_is_star_comment", "1");
        goto L279
    L268:
        r56 = "0";
        goto L269
    L411:
    L263:
        e = move-exception;
        i40.h.a("recommend_emoji matcher error-" + e.toString());
        goto L265
    L247:
        if (r53.length() <= 0) goto L249;
        boolean r95 = true;
    L251:
        if (r95 != true) goto L265;
        Matcher r96 = PatternProtector.compile("\\[.+?\\]").matcher(r53);     // Catch: Exception -> L263
        int r97 = 0;
    L254:
        if (r96.find() == false) goto L260;
        String r146 = r96.group();     // Catch: Exception -> L263
        if (r146 == null) goto L258;
        int r147 = r146.length();     // Catch: Exception -> L263
    L259:
        r97 = r97 + r147;     // Catch: Exception -> L263
        goto L254
    L258:
        r147 = 0;
        goto L259
    L260:
        if (r97 != r53.length()) goto L265;
        r55 = true;
        goto L266
    L249:
        r95 = false;
        goto L251
    L243:
        r50 = "0";
    L239:
        r49 = CardLockInfo.sUNKNOWN;
        goto L240
    L231:
        r4.put("is_settled", "0");
        r4.put("is_shortcut_message", "1");
        r4.put("prompt", r29.a);
        goto L233
    L232:
        r4.put("is_hot_sample_message", "1");
        r4.put("prompt", r29.a);
        goto L233
    L217:
        if (this.r.getAutoCover() != 1) goto L219;
        String r98 = "autocover";
    L220:
        r4.put("cover_type", r98);
        goto L221
    L219:
        r98 = "other";
    L183:
        r136 = null;
        goto L184
    L172:
        if (r132.h.getType() != 1) goto L174;
        String r148 = "say_hi";
    L175:
        r4.put("quick_interaction_type", r148);
        goto L176
    L174:
        r148 = "location";
    L168:
        r132 = null;
    L153:
        r25 = "0";
        goto L154
    L105:
        r21 = "comment";
        goto L106
    L99:
        if (r115.isEmpty() == true) goto L102;
        r20 = false;
    L96:
        r115 = null;
        goto L97
    L81:
        r111 = "0";
        goto L82
    L77:
        r110 = "0";
        goto L78
    L43:
        r8 = "normal";
        goto L44
    L33:
        r10 = "0";
    L28:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L30
    L5:
        r0 = "0";
        goto L6
    }

    public final void pr(final Long r14, List r15) {
        boolean r1 = false;
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.r, false) == true) goto L11;
        String r16 = ((o72.a) ec2.n.a.getValue()).e();
        if (r16 != null) goto L7;
    L8:
        r16 = s1.B(2131915461);
    L9:
        f2.c(r16, 0);
        ((Widget) this).dataCenter.put("pre_entry_fast_emoji_id", -1L);
        return;
    L7:
        if (r16.isEmpty() == false) goto L9;
    L11:
        Iterator r17 = r15.iterator();
    L13:
        if (r17.hasNext() == false) goto L45;
        final com.bytedance.android.live.profit.vip.l r0 = (com.bytedance.android.live.profit.vip.l) r17.next();
        if (Long.valueOf(r0.a).equals(r14) == false) goto L13;
        ((Widget) this).dataCenter.put("pre_entry_fast_emoji_id", -1L);
        Iterator r18 = ((HashSet) this.h1).iterator();
        CommentFlowContext r3 = null;
    L18:
        if (r18.hasNext() == false) goto L21;
        r3 = ((y22.e) r18.next()).b(CommentEntry.GuideEvent, null);
        if (r3 == null) goto L18;
    L21:
        final CommentFlowContext r11 = r3;
        if (this.C.a == false) goto L30;
        if (r11 == null) goto L27;
        CommentInputConfig r19 = r11.d;
        if (r19 == null) goto L27;
        r1 = r19.m;
    L27:
        if (r1 == true) goto L30;
        return;
    L30:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(null, ((Widget) this).dataCenter) != null) goto L32;
        qr(r14.longValue(), (int) r0.c, r0.f, ISendCommentEvent.Sender.CommentWidget, new HashMap(), r11, new HashMap());
        return;
    L32:
        if (((Boolean) com.bytedance.android.livesdk.interactivity.api.i.a(null, ((Widget) this).dataCenter).isFirstMessageConsumed().getValue()).booleanValue() != true) goto L34;
        qr(r14.longValue(), (int) r0.c, r0.f, ISendCommentEvent.Sender.CommentWidget, new HashMap(), r11, new HashMap());
        return;
    L34:
        com.bytedance.android.livesdk.interactivity.api.i.a(null, ((Widget) this).dataCenter).isFirstMessageConsumed().a().subscribe(new k0(this, r14, r0, r11), new l0());
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Ej(long r11, com.bytedance.android.livesdk.event.y r13, com.bytedance.android.livesdk.interactivity.api.comment.data.c r14) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        x22.b r0 = this.B;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = ((LiveInputDialogV3) r0).g;
        if (r1 == null) goto L14;
        EditText r2 = r1.a;
        if (r2 == null) goto L14;
        r2.setText(BuildConfig.FLAVOR);
    L14:
        if (TextUtils.isEmpty(r14.c()) == false) goto L17;
        f2.b(2131918956, 0);
        Zq(r13.b);
        return;
    L17:
        boolean r3 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class).rechargeCenter().setAvailableDiamonds(r14.b());
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter) != null) goto L20;
    L48:
        boolean r15 = false;
    L49:
        Mq(r13);
        HashMap r16 = new HashMap();
        if (r15 == false) goto L52;
        String r17 = "1";
    L53:
        r16.put("with_emoji", r17);
        r16.put("live_source", this.t);     // Catch: Exception -> L58
        if (TextUtils.isEmpty(this.r.getSourceType()) == true) goto L61;
        r16.put("moment_room_source", this.r.getSourceType());     // Catch: Exception -> L58
    L61:
        if (r13.c.equals(ISendCommentEvent.Sender.Lottery) == false) goto L63;
        String r18 = "lottery";
    L64:
        r16.put("request_page", r18);
        Iterator r19 = r13.d.entrySet().iterator();
    L66:
        if (r19.hasNext() == false) goto L70;
        Map.Entry r4 = (Map.Entry) r19.next();
        if ((r4.getValue() instanceof String) == false) goto L66;
        r16.put((String) r4.getKey(), (String) r4.getValue());
        goto L66
    L70:
        r16.put("danmu_level", "0");
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L73;
        String r110 = "portrait";
    L74:
        r16.put("screen_layout", r110);
        if (this.q == false) goto L77;
        String r111 = "anchor";
    L78:
        r16.put("user_type", r111);
        if (this.r == null) goto L81;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(((Widget) this).dataCenter, r16);
    L81:
        com.bytedance.android.livesdk.log.j0 r112 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r5 = new am2.x();
        r5.a = "live_interact";
        r112.sendLog("send_barrage", r16, new Object[]{r5, am2.u.class, IRoom.class, am2.n.f()});
        Boolean r113 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r13, "is_from_click_event", r113)).booleanValue() == false) goto L94;
        z32.c.b(InputValueNode.SendAdminDanmakuSuccess);
        return;
    L94:
        return;
    L77:
        r111 = "user";
        goto L78
    L73:
        r110 = "landscape";
        goto L74
    L63:
        r18 = "normal";
    L58:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L61
    L52:
        r17 = "0";
        goto L53
    L20:
        if (isViewValid() == false) goto L48;
        if (r14.f() == false) goto L24;
        f2.b(2131915274, 0);
        goto L48
    L24:
        Intrinsics.checkNotNullParameter(r14, "barrage");
        Object r6 = null;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L36
        IMiddlewareNetworkService r8 = jc1.k.f(IMiddlewareNetworkService.class);     // Catch: Throwable -> L36
        if (r8 == null) goto L33;
        am3.c r9 = r8.getProtoDecoder(h4.class);     // Catch: Throwable -> L36
        if (r9 == null) goto L33;
        byte[] r10 = Base64.decode(r14.d(), 0);     // Catch: Throwable -> L36
        am3.g r20 = new am3.g();     // Catch: Throwable -> L36
        r20.k(new am3.b(r10));     // Catch: Throwable -> L36
        h4 r21 = (h4) r9.decode(r20);     // Catch: Throwable -> L36
        if (r21 == null) goto L33;
        r21.setHttpSendTime(r11);     // Catch: Throwable -> L36
        r21.setSelfAndMock(true);     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter("start_send_time", "key");     // Catch: Throwable -> L36
        r21.setStartSendTime(((Number) ISendCommentEvent.a.a(r13, "start_send_time", 0L)).longValue());     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter("api_success_time", "key");     // Catch: Throwable -> L36
        r21.setApiSuccessTime(((Number) ISendCommentEvent.a.a(r13, "api_success_time", 0L)).longValue());     // Catch: Throwable -> L36
    L34:
        Object r23 = Result.constructor-impl(r21);     // Catch: Throwable -> L36
    L38:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L42;
        ALogger.e("ttlive_msg", r24.toString());
    L42:
        if (Result.isFailure-impl(r23) == true) goto L45;
        r6 = r23;
    L45:
        h4 r25 = (h4) r6;
        if (r25 == null) goto L48;
        r25.setLocalInsertMsg(true);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.d(r25, PSMessageAction.SYSTEM);
        r25.setHttpSendTime(r11);
        MessageIdentity r114 = new MessageIdentity();
        r114.setShowIdentity(r14.e());
        r114.setIdentityLabel(r14.a());
        r25.setMessageIdentity(r114);
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter).B(r25);
        r15 = Lists.notEmpty(ab2.a.d(r25.getChatContent()));
    L33:
        r21 = null;
    L36:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L12:
        this.p1.a(0).a = BuildConfig.FLAVOR;
        goto L14
    }

    public final com.bytedance.android.livesdk.interactivity.comment.newinput.c Fq(x22.c r17, CommentFlowContext r18, g92.f r19) {
        fc2.e r4 = (fc2.e) ec2.f0.a.getValue();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r5 = new com.bytedance.android.livesdk.interactivity.comment.newinput.c();
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r6 = new com.bytedance.android.livesdk.interactivity.comment.newinput.a();
        boolean r7 = r17.b;
        IRoom r8 = this.r;
        boolean r9 = true;
        if (r8 != null) goto L5;
    L11:
        r5.c = r7;
        if (this.m.booleanValue() == true) goto L14;
    L16:
        boolean r10 = false;
    L17:
        r5.a = r10;
        IRoom r11 = this.r;
        if (r11 == null) goto L33;
        IRoomAuthStatus r13 = r11.getRoomAuthStatus();
        if (r13 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.service.model.c r14 = (com.bytedance.android.livesdk.interactivity.service.model.c) r13.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r14 == null) goto L24;
        long r15 = r14.getAudioChatToText();
    L26:
        if (r15 == 2) goto L28;
        boolean r16 = true;
    L29:
        if (r16 == false) goto L33;
        if (r4.b() == false) goto L33;
        r5.b = true;
        goto L33
    L28:
        r16 = false;
    L24:
        r15 = 2;
    L33:
        r5.e = r17.g;
        s62.a r20 = this.P0;
        if (r20 == null) goto L36;
        r5.f = r20.d();
    L36:
        r6.e = r17.c;
        r6.f = r17.d;
        r6.i = this.C.i;
        r6.n = Long.valueOf(r17.j);
        OpenInputSource r21 = r19.b;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r6.t = r21;
        r6.u = r19.c;
        if (r19.b != OpenInputSource.Preview) goto L39;
        boolean r23 = true;
    L40:
        r6.w = r23;
        r6.x = r19.a;
        r17.j = -1;
        x22.d r3 = this.p1;
        if (r18 == null) goto L43;
        r3.getClass();
        long r110 = r18.l;
    L44:
        u22.m.a r24 = r3.a(r110).b;
        if (r24 == null) goto L51;
        IBaseUser r25 = r24.j;
        if (r25 == null) goto L51;
        if (r25.isMysteryMan() != true) goto L51;
        boolean r26 = true;
    L52:
        r6.v = r26;
        com.bytedance.android.livesdk.interactivity.api.q r27 = com.bytedance.android.livesdk.interactivity.api.q.a;
        List<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r28 = null;
        com.bytedance.android.livesdk.interactivity.api.h r29 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r29 == null) goto L57;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> r30 = r29.getActivityEmojiManager();
        if (r30 == null) goto L57;
        com.bytedance.android.livesdk.interactivity.api.emoji.d r31 = (com.bytedance.android.livesdk.interactivity.api.emoji.d) r30.getValue();
    L58:
        if (r31 == null) goto L60;
        r6.k = r31.b();
    L60:
        com.bytedance.android.livesdk.interactivity.api.emoji.e r33 = com.bytedance.android.livesdk.interactivity.api.q.d();
        if (r33 == null) goto L63;
        r6.l = r33.d();
    L63:
        r6.r = this.E;
        long r111 = InputDraftType.getSceneId(r18);
        if (r18 != null) goto L66;
    L68:
        boolean r34 = false;
    L69:
        CharSequence r112 = this.p1.a(r111).a;
        if (r18 == null) goto L74;
        if (r34 == true) goto L74;
        boolean r2 = false;
    L75:
        if (r2 == false) goto L78;
        r6.j = this.p1.a(r111).b;
    L84:
        r6.g = r112;
        r6.h = false;
        r6.o = r17.e;
        r6.p = r17.f;
        if (this.q == false) goto L87;
        r5.b = false;
        r5.a = false;
    L87:
        String r35 = BuildConfig.FLAVOR + jc1.k.f(IMiddlewareUserService.class).user().b().getIdString() + this.r.getId();
        if (r17.b == true) goto L90;
    L129:
        r6.b = !isScreenPortrait();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.g = r6;
        IRoom r0 = this.r;
        Lazy r36 = PublicScreenABHelper.a;
        if (r0 == null) goto L135;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L135;
        if (r1.isPanelECServiceEnable() != true) goto L135;
    L136:
        if (r9 == true) goto L138;
    L160:
        return r5;
    L138:
        if (isScreenPortrait() == false) goto L160;
        com.bytedance.android.livesdk.interactivity.api.q r37 = com.bytedance.android.livesdk.interactivity.api.q.a;
        com.bytedance.android.livesdk.interactivity.api.h r38 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r38 == null) goto L144;
        com.bytedance.live.datacontext.j<InputPanelComponentSyncDataModel> r39 = r38.getInputPanelComponentSyncDataModelModel();
        if (r39 == null) goto L144;
        InputPanelComponentSyncDataModel r40 = (InputPanelComponentSyncDataModel) r39.getValue();
    L145:
        if (r40 != null) goto L148;
    L151:
        if (r28 == null) goto L160;
        Iterator<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r41 = r28.iterator();
    L154:
        if (r41.hasNext() == false) goto L159;
        com.bytedance.android.livesdk.interactivity.api.comment.data.f r43 = r41.next();
        if (r43 == null) goto L154;
        this.O.put(Integer.valueOf(r43.type), r43);
        goto L154
    L159:
        HashMap<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> r44 = this.O;
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r5.d = r44;
        goto L160
    L148:
        if (r40.getInputPanelComponentSyncData().c() == null) goto L151;
        r28 = r40.getInputPanelComponentSyncData().c().data;
    L144:
        r40 = null;
    L135:
        r9 = false;
        goto L136
    L90:
        if (TextUtils.isEmpty(r35) == true) goto L129;
        com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r45 = l42.a.i;
        Map r46 = (Map) r45.getValue();
        if (r46 == null) goto L129;
        if (r46.get(r35) == null) goto L129;
        g92.c r47 = (g92.c) JsonUtil.parse((String) r46.get(r35), g92.c.class);     // Catch: Exception -> L127
        if (r47 == null) goto L129;
        com.bytedance.android.live.profit.privilege.model.danmu.b r113 = r47.a;     // Catch: Exception -> L127
        if (r113 == null) goto L129;
        if (r113.getStyle() == 21) goto L129;
        boolean r114 = this.q;     // Catch: Exception -> L127
        IRoom r115 = this.r;     // Catch: Exception -> L127
        if (r115 != null) goto L104;
    L106:
        UserAttr r116 = jc1.k.f(IMiddlewareUserService.class).user().q();     // Catch: Exception -> L127
        if (r114 == true) goto L111;
        if (r116 == null) goto L111;
        r114 = r116.isAdmin();     // Catch: Exception -> L127
    L111:
        if (r47.a.getStyle() != 0) goto L114;
        if (r114 == false) goto L114;
    L115:
        r6.d = r47.a;     // Catch: Exception -> L127
        if (TextUtils.isEmpty(r17.d) == true) goto L122;
        if (this.p1.a(r111).b != null) goto L120;
    L125:
        Gq(r46);     // Catch: Exception -> L127
        goto L129
    L120:
        if (this.p1.a(r111).b.k == true) goto L125;
    L122:
        if (gb2.a.c(((Widget) this).dataCenter, true) == true) goto L125;
        r6.e = new x22.a(r47.a.getCommentToast(), HintType.NORMAL);     // Catch: Exception -> L127
    L114:
        if (r47.a.getStyle() > 0) goto L115;
        com.bytedance.android.livesdk.sharedpref.f.d(r45, null);     // Catch: Exception -> L127
        goto L125
    L104:
        if (r115.getOwner() == null) goto L106;
        r114 = Objects.equals(jc1.k.f(IMiddlewareUserService.class).user().n(), this.r.getOwner().getIdString());     // Catch: Exception -> L127
    L127:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L129
    L78:
        if ((r112 instanceof Editable) == false) goto L84;
        Object[] r48 = ((Editable) r112).getSpans(0, r112.length(), MentionSpan.class);
        if (r48 == null) goto L84;
        int r49 = r48.length;
        int r117 = 0;
    L82:
        if (r117 >= r49) goto L84;
        ((Editable) r112).removeSpan(r48[r117]);
        r117 = r117 + 1;
    L74:
        r2 = true;
        goto L75
    L66:
        if (r18.c != CommentScene.ChatChannel) goto L68;
        r34 = true;
    L57:
        r31 = null;
    L51:
        r26 = false;
        goto L52
    L43:
        r110 = 0;
        goto L44
    L39:
        r23 = false;
        goto L40
    L14:
        if (r4.c() == false) goto L16;
        r10 = true;
        goto L17
    L5:
        if (r8.getRoomAuthStatus() == null) goto L11;
        if (r7 == true) goto L8;
    L10:
        r7 = false;
        goto L11
    L8:
        if (this.r.getRoomAuthStatus().isEnableLandscapeChat() == false) goto L10;
        r7 = true;
        goto L11
    }

    public final x22.a Jq(float r9, TextPaint r10, boolean r11) {
        IRoom r0 = this.r;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r3 = Lq();
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        IRoom r5 = this.r;
        if (r5 != null) goto L17;
    L23:
        boolean r6 = false;
    L25:
        if (this.x == false) goto L27;
    L29:
        boolean r7 = false;
    L31:
        if (this.x == true) goto L37;
        CommentWidgetAnimator r8 = this.L;
        if (r8 == null) goto L37;
        if (r8.e == false) goto L37;
        boolean r13 = true;
    L38:
        if (r2 == true) goto L40;
        if (r13 == false) goto L47;
        if (Tq() == false) goto L47;
        return new x22.a(s1.B(2131920039), HintType.NORMAL);
    L47:
        if (this.Z == false) goto L56;
        s22.c r14 = this.X;
        if (r14 == null) goto L55;
        if (r14.isShowing() == false) goto L55;
        return new x22.a(s1.B(2131917198), HintType.NORMAL);
    L55:
        return new x22.a(s1.B(2131922327), HintType.NORMAL);
    L56:
        String r15 = null;
        if (this.k0 == false) goto L76;
        IRoom r16 = this.r;
        int r17 = CommentUtils.a;
        if (r16 == null) goto L73;
        RoomInteractData r18 = r16.getRoomInteractData();
        if (r18 == null) goto L73;
        UserWorldChatInfo r19 = r18.getSquareInfo();
        if (r19 == null) goto L73;
        String r110 = r19.getInputTip();
        if (r110 == null) goto L73;
        if (r110.length() > 0) goto L70;
        r1 = false;
    L70:
        if (r1 == false) goto L72;
        r15 = r110;
    L72:
        if (r15 == null) goto L73;
    L75:
        return new x22.a(r15, HintType.NORMAL);
    L73:
        r15 = s1.B(2131922328);
        goto L75
    L76:
        if (r4 == false) goto L85;
        boolean r20 = y62.a.a;
        if (y62.a.a(this.r, this.x) == false) goto L83;
        if (ur() == false) goto L83;
        MainThreadPostUtils.d(this.H1);
        MainThreadPostUtils.b(this.H1);
    L83:
        return new x22.a((String) r3.mo904getFixedCommentTips().getValue(), HintType.NORMAL);
    L85:
        if (r6 == true) goto L87;
        if (r7 == true) goto L90;
        com.bytedance.android.livesdk.interactivity.i.Companion.getClass();
        com.bytedance.android.livesdk.interactivity.i r21 = com.bytedance.android.livesdk.interactivity.i.access$getImpl$cp();
        if (r21 != null) goto L98;
        r21 = (com.bytedance.android.livesdk.interactivity.i) jc1.k.f(com.bytedance.android.livesdk.interactivity.i.class);
        if (r21 != null) goto L97;
        r21 = new com.bytedance.android.livesdk.interactivity.i();
    L97:
        com.bytedance.android.livesdk.interactivity.i.access$setImpl$cp(r21);
    L98:
        String r23 = r21.getCommentTip(((Widget) this).dataCenter);
        if (r23 != null) goto L101;
        com.bytedance.android.livesdk.interactivity.comment.t r24 = this.v1;
        if (r24 == null) goto L109;
        if (r24.a() == null) goto L109;
        return this.v1.a();
    L109:
        if (this.r.isMergeVSRoom() == false) goto L111;
    L116:
        IRoom r25 = this.r;
        if (r25 == null) goto L130;
        if (r25.getRoomInteractData() == null) goto L130;
        if (this.r.getRoomInteractData().getInputDefaultConfig() == null) goto L130;
        InputDefaultConfig r26 = this.r.getRoomInteractData().getInputDefaultConfig();
        if (r26 == null) goto L130;
        if (r11 == false) goto L127;
        String r27 = r26.getEntryHint();
    L128:
        r15 = r27;
        goto L130
    L127:
        r27 = r26.getDialogHint();
    L130:
        if (TextUtils.isEmpty(r15) == false) goto L132;
        r15 = s1.B(2131922325);
    L132:
        String r28 = s1.B(2131922326);
        if (r9 <= 0.0f) goto L138;
        if (r10 == null) goto L138;
        if (r10.measureText(r15) <= r9) goto L138;
    L139:
        if (r1 == false) goto L144;
        if (r11 == false) goto L144;
        return new x22.a(r28, HintType.NORMAL);
    L144:
        return new x22.a(r15, HintType.NORMAL);
    L138:
        r1 = false;
        goto L139
    L111:
        if (this.r.isMediaRoom() == true) goto L116;
        if (this.U == false) goto L116;
        return new x22.a(this.T, HintType.NORMAL);
    L101:
        return new x22.a(r23, HintType.NORMAL);
    L90:
        return new x22.a(s1.B(2131915877), HintType.NORMAL);
    L87:
        return new x22.a(s1.B(2131915877), HintType.NORMAL);
    L40:
        return new x22.a(s1.B(2131919963), HintType.NORMAL);
    L37:
        r13 = false;
        goto L38
    L27:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L29;
        r7 = true;
        goto L31
    L17:
        if (r5.isMergeVSRoom() == false) goto L23;
        DataCenter r29 = ((Widget) this).dataCenter;
        if (r29 == null) goto L23;
        if (com.bytedance.android.live.core.utils.a0.l(r29, true) == true) goto L23;
        r6 = true;
        goto L25
    L11:
        if (r3.isFixedComment() == false) goto L13;
        r4 = true;
        goto L14
    L5:
        if (r0.isEnableChat(false) == true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void vN(long r13, com.bytedance.android.livesdk.event.y r14, PrivilegeBarrageResponse r15) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        x22.b r0 = this.B;
        long r1 = 0;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = ((LiveInputDialogV3) r0).g;
        if (r2 == null) goto L14;
        EditText r3 = r2.a;
        if (r3 == null) goto L14;
        r3.setText(BuildConfig.FLAVOR);
    L14:
        if (TextUtils.isEmpty(r15.getOrderId()) == false) goto L17;
        f2.b(2131918956, 0);
        Zq(r14.b);
        return;
    L17:
        boolean r4 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class).rechargeCenter().setAvailableDiamonds(r15.getLeftDiamond());
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter) != null) goto L20;
    L37:
        boolean r16 = false;
    L38:
        f2.i(((Widget) this).context, r15.getToast(), 0);
        HashMap r17 = new HashMap();
        if (r16 == false) goto L41;
        String r18 = "1";
    L42:
        r17.put("with_emoji", r18);
        r17.put("live_source", this.t);     // Catch: Exception -> L47
        if (TextUtils.isEmpty(this.r.getSourceType()) == true) goto L50;
        r17.put("moment_room_source", this.r.getSourceType());     // Catch: Exception -> L47
    L50:
        if (r14.c.equals(ISendCommentEvent.Sender.Lottery) == false) goto L52;
        String r19 = "lottery";
    L53:
        r17.put("request_page", r19);
        Iterator r110 = r14.d.entrySet().iterator();
    L55:
        if (r110.hasNext() == false) goto L59;
        Map.Entry r111 = (Map.Entry) r110.next();
        if ((r111.getValue() instanceof String) == false) goto L55;
        r17.put((String) r111.getKey(), (String) r111.getValue());
        goto L55
    L59:
        r17.put("danmu_level", String.valueOf(r14.b));
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L62;
        String r112 = "portrait";
    L63:
        r17.put("screen_layout", r112);
        if (this.q == false) goto L66;
        String r113 = "anchor";
    L67:
        r17.put("user_type", r113);
        if (this.r == null) goto L70;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(((Widget) this).dataCenter, r17);
    L70:
        com.bytedance.android.livesdk.log.j0 r114 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r5 = new am2.x();
        r5.a = "live_interact";
        r114.sendLog("send_barrage", r17, new Object[]{r5, am2.u.class, IRoom.class, am2.n.f()});
        Boolean r115 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r14, "is_from_click_event", r115)).booleanValue() == false) goto L73;
        z32.c.b(InputValueNode.SendPrivilegeDanmakuSuccess);
    L73:
        Mq(r14);
        return;
    L66:
        r113 = "user";
        goto L67
    L62:
        r112 = "landscape";
        goto L63
    L52:
        r19 = "normal";
    L47:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L50
    L41:
        r18 = "0";
        goto L42
    L20:
        if (isViewValid() == false) goto L37;
        IBaseUser r6 = (IBaseUser) ((Widget) this).dataCenter.get("data_user_in_room", null);
        if (r6 != null) goto L24;
        r6 = jc1.k.f(IMiddlewareUserService.class).user().b();
    L24:
        IRoom r7 = this.r;
        Intrinsics.checkNotNullParameter(r14, "ev");
        Intrinsics.checkNotNullParameter(r15, "response");
        s3 r8 = vh7.f.c(s3.class);
        r8.setMessageMethod("WebcastPrivilegeScreenChatMessage");
        IBaseUser r9 = r15.getUser();
        if (r9 == null) goto L28;
        r6 = r9;
    L28:
        r8.setUser2(r6);
        r8.setContent(r14.a);
        r8.setStyle(r14.b);
        r8.setSkin(r15.getSkin());
        r8.setLocalInsertMsgOld(true);
        Intrinsics.checkNotNullParameter("start_send_time", "key");
        r8.setStartSendTime(((Number) ISendCommentEvent.a.a(r14, "start_send_time", 0L)).longValue());
        Intrinsics.checkNotNullParameter("api_success_time", "key");
        r8.setApiSuccessTime(((Number) ISendCommentEvent.a.a(r14, "api_success_time", 0L)).longValue());
        r8.setHttpSendTime(r13);
        r8.setSelfAndMock(true);
        com.bytedance.android.live.base.model.message.m0 r116 = vh7.f.c(com.bytedance.android.live.base.model.message.m0.class);
        if (r7 == null) goto L31;
        r1 = r7.getId();
    L31:
        r116.setRoomId(r1);
        r116.setMessageId(r15.getMsgId());
        r116.setMethod("WebcastPrivilegeScreenChatMessage");
        r116.setShowMsg(true);
        Unit r117 = Unit.INSTANCE;
        r8.setBaseMessage(r116);
        MessageIdentity r118 = new MessageIdentity();
        r118.setShowIdentity(r15.getShowIdentity());
        r118.setIdentityLabel(r15.getIdentityLabel());
        r8.setMessageIdentity(r118);
        if (r14.e == null) goto L34;
    L35:
        com.bytedance.android.livesdk.interactivity.api.entity.o.a(r14, r8, r14.a);
    L36:
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(((Widget) this).dataCenter).j(r8, true);
        r16 = Lists.notEmpty(ab2.a.d(r8.getContent()));
        goto L38
    L34:
        if (r14.f == null) goto L36;
    L12:
        this.p1.a(0).a = BuildConfig.FLAVOR;
        goto L14
    }

    public final void qr(long r13, int r15, boolean r16, ISendCommentEvent.Sender r17, HashMap r18, CommentFlowContext r19, Map r20) {
        CommentPresenter r1 = this.y;
        if (r1 == null) goto L6;
        r1.p0(new com.bytedance.android.livesdk.event.c0(r13, r15, r16, r17, r18, r19, r20));
        return;
    }

    public final void fr(String r20, boolean r21, int r23, boolean r24, QuickCommentTypeEnum r25, long r26, com.bytedance.android.livesdk.event.m r27, com.bytedance.android.livesdk.event.q r28, boolean r29, g92.b r30, Map<String, Object> r31) {
        com.bytedance.android.livesdk.user.e r3 = jc1.k.f(IMiddlewareUserService.class).user();
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.isLogin() == true) goto L10;
        Context r0 = ((Widget) this).context;
        com.bytedance.android.livesdk.user.l.a r2 = new com.bytedance.android.livesdk.user.l.a();
        r2.a = s1.B(2131915990);
        r2.d = "comment_live";
        r2.c = -1;
        r3.login(r0, new com.bytedance.android.livesdk.user.l(r2)).compose(getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "not login", null);
        return;
    L10:
        if (r3.g(LiveInteractFunction.COMMENT) == false) goto L14;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "UserCenter intercept", null);
        return;
    L14:
        if (this.w == false) goto L16;
        xs2.b.a().post(new u22.j(true, 0));
        this.w = false;
    L16:
        CommentPresenter r4 = this.y;
        if (r4 != null) goto L21;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "comment presenter is null", null);
        return;
    L21:
        if (r21 == false) goto L23;
        ISendCommentEvent.Sender r10 = ISendCommentEvent.Sender.CommentWidget;
        String r1 = this.u;
        HashMap r11 = new HashMap();
        r11.put("live.intent.extra.ENTER_LIVE_SOURCE", r1);
        r11.put("money", Long.valueOf(r26));
        r11.put("is_from_click_event", Boolean.valueOf(r30.d));
        r11.put("start_send_time", Long.valueOf(r30.e));
        r4.k0(new com.bytedance.android.livesdk.event.y(r20, r23, r10, r11, r27, r28));
        return;
    L23:
        ISendCommentEvent.Sender r14 = ISendCommentEvent.Sender.CommentWidget;
        String r7 = this.u;
        HashMap r15 = new HashMap();
        r15.put("live.intent.extra.ENTER_LIVE_SOURCE", r7);
        r15.put("from_voice_panel", Boolean.valueOf(r24));
        r15.put("quickCommentType", r25);
        r15.put("is_from_comment_operate_copy", Boolean.valueOf(r29));
        r15.put("comment_send_params", r30);
        r15.put("request_source", r30.b);
        r15.put("start_send_time", Long.valueOf(r30.e));
        if (r31 != null) goto L26;
    L28:
        if (r31 != null) goto L30;
    L32:
        if (r31 != null) goto L34;
    L36:
        if (r31 != null) goto L38;
    L40:
        if (r31 != null) goto L42;
    L44:
        if (r31 != null) goto L46;
    L48:
        if (r31 != null) goto L50;
    L52:
        if (r31 != null) goto L54;
    L56:
        if (r31 != null) goto L58;
    L60:
        if (r31 != null) goto L62;
    L74:
        IMiddlewareRoomService r5 = jc1.k.f(IMiddlewareRoomService.class);
        if (r5 == null) goto L80;
        String r6 = r5.getIntentRecognition();
        if (r6 == null) goto L80;
        r15.put("intent_recognition", r6);
    L80:
        if (r30.g > 0) goto L82;
    L84:
        r4.l0(new com.bytedance.android.livesdk.event.d0(r20, r14, r15, r27, r28, false));
        return;
    L82:
        if (TextUtils.isEmpty(r30.f) == true) goto L84;
        r15.put("truth_question_id", Long.valueOf(r30.g));
        r15.put("truth_question_text", r30.f);
        goto L84
    L62:
        if (r31.containsKey("jsb_track_params") == false) goto L74;
        Object r8 = r31.get("jsb_track_params");
        if ((r8 instanceof JsonObject) == false) goto L74;
        JsonObject r9 = (JsonObject) r8;
        Iterator r13 = r9.keySet().iterator();
    L67:
        if (r13.hasNext() == false) goto L74;
        String r16 = (String) r13.next();
        JsonElement r17 = r9.get(r16);
        if (r17 == null) goto L67;
        r15.put(r16, r17.getAsString());     // Catch: Exception -> L72
    L72:
        e = move-exception;
        SafetyGuard.a("CommentPresenter", e, "parse jsb track params failed");
        goto L67
    L58:
        if (r31.containsKey("default_text_type") == false) goto L60;
        r15.put("default_text_type", r31.get("default_text_type"));
        goto L60
    L54:
        if (r31.containsKey("paste_edit_method") == false) goto L56;
        r15.put("paste_edit_method", r31.get("paste_edit_method"));
        goto L56
    L50:
        if (r31.containsKey("is_self_click_send") == false) goto L52;
        r15.put("is_self_click_send", r31.get("is_self_click_send"));
        goto L52
    L46:
        if (r31.containsKey("is_from_click_event") == false) goto L48;
        r15.put("is_from_click_event", r31.get("is_from_click_event"));
        goto L48
    L42:
        if (r31.containsKey("input_comment_type") == false) goto L44;
        r15.put("input_comment_type", r31.get("input_comment_type"));
        goto L44
    L38:
        if (r31.containsKey("is_shortcut_message") == false) goto L40;
        r15.put("is_shortcut_message", r31.get("is_shortcut_message"));
        goto L40
    L34:
        if (r31.containsKey("is_settled") == false) goto L36;
        r15.put("is_settled", r31.get("is_settled"));
        goto L36
    L30:
        if (r31.containsKey("message_type") == false) goto L32;
        r15.put("message_type", r31.get("message_type"));
        goto L32
    L26:
        if (r31.containsKey("at_user_id") == false) goto L28;
        r15.put("at_user_id", r31.get("at_user_id"));
        goto L28
    }
}
