package com.larus.bmhome.view.actionbar.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.tips.GuideTipsDelegate;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.gaokao.network.PreloadGaokaoProvinceConfHelper;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.trace.RealtimeCallEntry;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import tx9.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0002ijBS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J!\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0010\u0010@\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001cH\u0002J\b\u0010A\u001a\u00020:H\u0002J\u0010\u0010B\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0010\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020:H\u0002J\u0010\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020IH\u0002J\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020=0K2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020I0KH\u0002J\u0010\u0010M\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0010\u0010N\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0012\u0010O\u001a\u0004\u0018\u00010I2\u0006\u0010;\u001a\u00020\u001cH\u0002J\u001a\u0010P\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001c2\b\b\u0002\u0010Q\u001a\u00020\nH\u0002J\u0018\u0010R\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\nH\u0002J\b\u0010T\u001a\u00020UH\u0002J\f\u0010V\u001a\u00020I*\u00020=H\u0002J\b\u0010W\u001a\u00020:H\u0002J\u001c\u0010X\u001a\u00020:2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\b\u0002\u0010[\u001a\u00020\nH\u0002J&\u0010\\\u001a\u00020=2\b\u0010]\u001a\u0004\u0018\u00010I2\b\u0010^\u001a\u0004\u0018\u00010I2\b\b\u0001\u0010_\u001a\u00020=H\u0002J\u0012\u0010`\u001a\u00020:2\b\u0010a\u001a\u0004\u0018\u00010IH\u0002J\u0012\u0010b\u001a\u00020\n2\b\u0010a\u001a\u0004\u0018\u00010IH\u0002J\u0016\u0010c\u001a\u00020:2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020:0\u000fH\u0016J\b\u0010e\u001a\u00020:H\u0016J\b\u0010f\u001a\u00020:H\u0016J\u0010\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0018R\u0016\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarNormalHolder;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "Lcom/larus/bmhome/view/actionbar/custom/ICustomActionAnimation;", "itemView", "Landroid/view/View;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "", "isActionBarPanel", "actionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/ActionBarShowTipCache;", "hostViewProvider", "Lkotlin/Function0;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/chat/ChatParam;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;ZZLcom/larus/bmhome/view/actionbar/custom/ActionBarShowTipCache;Lkotlin/jvm/functions/Function0;)V", "getItemView", "()Landroid/view/View;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "getCallback", "()Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "()Z", "setActionBarPanel", "(Z)V", "currentItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "icon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "loading", "Landroid/widget/ProgressBar;", "name", "Landroid/widget/TextView;", "redDotIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "blueUpdateIcon", "actionBarRedDotVisibleHelper", "Lcom/larus/bmhome/view/actionbar/custom/ActionBarRedDotVisibleHelper;", "barrier", "Landroidx/constraintlayout/widget/Barrier;", "ivLeftBold", "Landroid/widget/ImageView;", "lottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "lottieStatusJob", "Lkotlinx/coroutines/Job;", "recordStatusJob", "loadingStatusJob", "isNightMode", "roundViewDelegate", "Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "getRoundViewDelegate", "()Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "springDrawable", "Landroid/graphics/drawable/Drawable;", "bindData", "", "data", "customWidth", "", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Integer;)V", "initMinutesSdkAndObserveStatus", "handleLottieJob", "clearLottieStatusJobs", "isCurrentActionBarItem", "renderGradientStyle", "config", "Lcom/larus/platform/model/actionbar/ActionBarGradientStyle;", "clearGradientStyle", "safe2Color", "colorStr", "", "safe2ColorList", "", "colorStrList", "handleLoading", "handleGaokaoData", "getTalkBackName", "updateUiStyle", "forceDisplayExtraStyle", "updateIconAndName", "needShowLottie", "unavailablePcDisplayExtra", "Lcom/larus/bmhome/actionbar/model/ActionBarUIDisplayExtra;", "toHexColor", "setIconVisible", "setDefaultStyle", "displayExtra", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarNormalHolder$ActionBarUIConfig;", "tintIcon", "getFinalColorInt", "normalColorString", "darkColorString", "defaultColorRes", "setIconUrl", ShareType.URL, "setLocalResourceIcon", "startRedAnimation", "animationEnd", "tryShowGuideTips", "onViewRecycle", "isViewFullyVisible", "view", "Companion", "ActionBarUIConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomActionBarNormalHolder extends BaseActionBarHolder {
    public static final /* synthetic */ int v = 0;
    public final View a;
    public final ChatParam b;
    public final t1 c;
    public final boolean d;
    public final boolean e;
    public final n f;
    public final Function0<View> g;
    public com.larus.bmhome.actionbar.model.z0 h;
    public final SimpleDraweeView i;
    public final ProgressBar j;
    public final TextView k;
    public final AppCompatImageView l;
    public final TextView m;
    public final j n;
    public final Barrier o;
    public final ImageView p;
    public final LottieAdapterView q;
    public Job r;
    public Job s;
    public Job t;
    public Drawable u;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;

        public a() {
            this(null, null, null, null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActionBarUIConfig(titleColor=" + this.a + ", backgroundColor=" + this.b + ", borderColor=" + this.c + ", darkModeTitleColor=" + this.d + ", darkModeBackgroundColor=" + this.e + ", darkModeBorderColor=" + this.f + ')';
        }

        public a(String r1, String r2, String r3, String r4, String r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class b {
    }

    static {
    }

    public CustomActionBarNormalHolder() {
        throw null;
    }

    @Override // com.larus.bmhome.view.actionbar.BaseActionBarHolder
    public final void T3() {
        Job r0 = this.r;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.r = null;
        Job r1 = this.s;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.s = null;
        this.h = null;
    }

    public final c29.a X3() {
        RoundConstraintLayout r0 = this.a;
        if ((r0 instanceof RoundConstraintLayout) == false) goto L5;
        RoundConstraintLayout r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getDelegate();
    L5:
        r1 = null;
        goto L6
    }

    public final void a4() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("tryShowGuideTips currentItem?.displayExtra?.tipInfo ");
        com.larus.bmhome.actionbar.model.z0 r2 = this.h;
        String r3 = null;
        if (r2 == null) goto L9;
        com.larus.bmhome.actionbar.model.m0 r4 = r2.u;
        if (r4 == null) goto L9;
        com.larus.bmhome.actionbar.model.d2 r5 = r4.u;
        if (r5 == null) goto L9;
        String r6 = r5.c;
    L10:
        r1.append(r6);
        r1.append(" state = ");
        r1.append(this.c.f());
        r0.d("CustomActionBarNormalHolder", r1.toString());
        com.larus.bmhome.actionbar.model.z0 r7 = this.h;
        if (r7 != null) goto L13;
        return;
    L13:
        if (ws8.a.a(r7) == true) goto L15;
        return;
    L15:
        if (this.c.f() != 0) goto L74;
        com.larus.bmhome.actionbar.model.z0 r8 = this.h;
        if (r8 == null) goto L24;
        com.larus.bmhome.actionbar.model.m0 r9 = r8.u;
        if (r9 == null) goto L24;
        com.larus.bmhome.actionbar.model.d2 r10 = r9.u;
        if (r10 == null) goto L24;
        r3 = r10.a;
    L24:
        if (r3 != null) goto L26;
        r3 = "";
    L26:
        String r11 = r3;
        if (r8 == null) goto L34;
        com.larus.bmhome.actionbar.model.m0 r12 = r8.u;
        if (r12 == null) goto L34;
        com.larus.bmhome.actionbar.model.d2 r13 = r12.u;
        if (r13 == null) goto L34;
        String r14 = r13.c;
        if (r14 == null) goto L34;
    L35:
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        boolean r16 = false;
        String r17 = String.format(r14, Arrays.copyOf(new Object[]{this.c.a()}, 1));
        com.larus.bmhome.actionbar.model.z0 r18 = this.h;
        if (r18 == null) goto L45;
        com.larus.bmhome.actionbar.model.p0 r19 = r18.o;
        if (r19 == null) goto L45;
        Integer r20 = r19.a;
        int r21 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r20 == null) goto L45;
        if (r20.intValue() != r21) goto L45;
        boolean r22 = true;
    L46:
        if (r22 == false) goto L48;
        final com.larus.bmhome.chat.tips.a r23 = new com.larus.bmhome.chat.tips.a(0, r11, r17);
    L64:
        if (GuideTipsDelegate.b.c(r23.a) == true) goto L66;
    L68:
        r0.d("CustomActionBarNormalHolder", "can not show guide tip~");
        return;
    L66:
        if (com.larus.network.http.d.e == true) goto L68;
        this.a.postDelayed(new z1(this, r23), 100);
        return;
    L48:
        com.larus.bmhome.actionbar.model.z0 r24 = this.h;
        if (r24 == null) goto L58;
        com.larus.bmhome.actionbar.model.r r25 = r24.q;
        if (r25 == null) goto L58;
        Integer r26 = r25.a;
        if (r26 == null) goto L58;
        if (r26.intValue() != 21) goto L58;
        r16 = true;
    L58:
        if (r16 == false) goto L61;
        r23 = new com.larus.bmhome.chat.tips.a(1, r11, r17);
        goto L64
    L61:
        if (wa8.k1.c(this.h) == false) goto L72;
        r23 = new com.larus.bmhome.chat.tips.a(8, r11, r17, 30000);
        goto L64
    L72:
        return;
    L45:
        r22 = false;
    L34:
        r14 = this.a.getContext().getResources().getString(2131901494);
        goto L35
    L74:
        return;
    L9:
        r6 = null;
        goto L10
    }

    public static String Y3(com.larus.bmhome.actionbar.model.z0 r3) {
        if (r3.y == false) goto L18;
        wa8.u1 r0 = r3.z;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.a;
    L9:
        if (com.larus.utils.o0.d(r2) == false) goto L18;
        StringBuilder r4 = new StringBuilder();
        r4.append(r3.e);
        wa8.u1 r5 = r3.z;
        if (r5 == null) goto L13;
        r1 = r5.a;
    L13:
        if (r1 != null) goto L15;
        r1 = "";
    L15:
        r4.append(r1);
        return r4.toString();
    L7:
        r2 = null;
    L18:
        return r3.e;
    }

    public static List Z3(List r4) {
        List r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r1 = (String) r6.next();
        int r2 = com.larus.utils.l0.a;
        r0.add(Integer.valueOf(((Number) com.larus.utils.l0.a(0, new x1(r1))).intValue()));
        goto L4
    L6:
        return r0;
    }

    public static final boolean U3(CustomActionBarNormalHolder r3, com.larus.bmhome.actionbar.model.z0 r4) {
        com.larus.bmhome.actionbar.model.z0 r5 = r3.h;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r5.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r5.a, r4.a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.larus.bmhome.view.actionbar.custom.d2] */
    public final void V3(final com.larus.bmhome.actionbar.model.z0 r37, Integer r38) {
        this.h = r37;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("bindData, key=");
        jq9.j r5 = null;
        if (r37 == null) goto L5;
        String r6 = r37.b;
    L6:
        r4.append(r6);
        r4.append(", instructionType:");
        if (r37 == null) goto L11;
        com.larus.bmhome.actionbar.model.r r7 = r37.q;
        if (r7 == null) goto L11;
        Integer r8 = r7.a;
    L12:
        r4.append(r8);
        r4.append(", switch=");
        if (r37 == null) goto L17;
        com.larus.bmhome.actionbar.model.h0 r9 = r37.n;
        if (r9 == null) goto L17;
        Boolean r10 = r9.a;
    L18:
        r4.append(r10);
        r4.append(" customWidth is ");
        r4.append(r38);
        r3.d("CustomActionBarNormalHolder", r4.toString());
        a4();
        j r11 = this.n;
        ChatParam r12 = this.b;
        if (r12 == null) goto L21;
        String r13 = r12.b;
    L22:
        r11.a(r37, r13);
        if (r37 == null) goto L124;
        this.j.setVisibility(8);
        this.i.setVisibility(0);
        if (Intrinsics.areEqual(r37.b, "coco_spring_festival_2025") == false) goto L34;
        Job r14 = this.t;
        if (r14 == null) goto L29;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L29:
        r3.d("CustomActionBarNormalHolder", "loadingStatus:observer new");
        LifecycleCoroutineScope r15 = this.c.e();
        if (r15 == null) goto L32;
        Job r16 = BuildersKt.launch$default(r15, Dispatchers.getMain().getImmediate(), null, new CustomActionBarNormalHolder$handleLoading$1(this, r37, null), 2, null);
    L33:
        this.t = r16;
    L38:
        com.larus.bmhome.actionbar.model.r r17 = r37.q;
        if (r17 == null) goto L46;
        Integer r18 = r17.a;
        if (r18 == null) goto L46;
        if (r18.intValue() != 23) goto L46;
        boolean r19 = true;
    L47:
        if (r19 == false) goto L56;
        PreloadGaokaoProvinceConfHelper r20 = PreloadGaokaoProvinceConfHelper.a;
        if (PreloadGaokaoProvinceConfHelper.b == null) goto L51;
        boolean r21 = true;
    L52:
        if (r21 == true) goto L56;
        LifecycleCoroutineScope r22 = this.c.e();
        if (r22 == null) goto L56;
        PreloadGaokaoProvinceConfHelper.a(r22);
        goto L56
    L51:
        r21 = false;
    L56:
        c29.a r23 = X3();
        if (r23 == null) goto L59;
        r23.t = false;
        r23.u = 0;
    L59:
        this.k.getPaint().setShader(null);
        if (AudioServiceDelegate.a.P().g() == false) goto L67;
        Integer r24 = r37.g;
        int r25 = ActionBarExecutionType.RECORD.getValue();
        if (r24 == null) goto L67;
        if (r24.intValue() != r25) goto L67;
    L77:
        boolean r26 = true;
    L79:
        boolean r27 = b4(r37, r26);
        c4(r37, false);
        Job r28 = this.r;
        if (r28 == null) goto L82;
        Job.DefaultImpls.cancel$default(r28, null, 1, null);
    L82:
        this.r = null;
        Job r29 = this.s;
        if (r29 == null) goto L85;
        Job.DefaultImpls.cancel$default(r29, null, 1, null);
    L85:
        this.s = null;
        if (Intrinsics.areEqual(r37.b, "coco_record") == false) goto L88;
    L93:
        boolean r30 = true;
    L94:
        if (r30 == false) goto L122;
        AppCompatActivity r31 = AppHost.a.a().getCurrentActivity();
        if ((r31 instanceof AppCompatActivity) == false) goto L98;
        AppCompatActivity r32 = r31;
    L99:
        if (r32 == null) goto L122;
        String r110 = r37.b;
        if (r110 == null) goto L119;
        int r111 = r110.hashCode();
        if (r111 == (-1794846868)) goto L117;
        if (r111 == 841475061) goto L113;
        if (r111 != 1259927704) goto L119;
        if (r110.equals("coco_record") == false) goto L119;
    L118:
        this.s = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r32), null, null, new CustomActionBarNormalHolder$handleLottieJob$1$1(this, r37, null), 3, null);
        Job r33 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r32), null, null, new CustomActionBarNormalHolder$handleLottieJob$1$2(this, r37, null), 3, null);
    L120:
        this.r = r33;
        goto L122
    L113:
        if (r110.equals("doc_oral") == false) goto L119;
        r33 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r32), null, null, new CustomActionBarNormalHolder$handleLottieJob$1$3(this, r37, null), 3, null);
        goto L120
    L117:
        if (r110.equals("coco_ai_simul_interpret") == true) goto L118;
    L119:
        r33 = null;
        goto L120
    L98:
        r32 = null;
    L122:
        if (Intrinsics.areEqual(r37.b, "coco_call") == false) goto L125;
        c3.c(RealtimeCallEntry.MAIN_ACTION_BAR);
    L125:
        if (r38 != null) goto L127;
    L129:
        if (r37 == null) goto L131;
        r5 = r37.B;
    L131:
        if (r5 == null) goto L165;
        boolean r2 = v19.h.a;
        if (v19.h.b(this.a.getContext()) == false) goto L135;
    L138:
        boolean r34 = true;
    L139:
        if (r34 == false) goto L141;
        final List r35 = r5.c;
    L142:
        if (r34 == false) goto L144;
        String r36 = r5.i;
    L145:
        if (r34 == false) goto L147;
        List r39 = r5.f;
    L148:
        if (r35 == null) goto L165;
        if (r36 == null) goto L165;
        if (r39 == null) goto L165;
        final ?? r40 = new d2(this, r35);
        if (this.k.getWidth() != 0) goto L155;
    L158:
        this.k.post(new e2(r40));
    L159:
        c29.a r41 = X3();
        if (r41 == null) goto L162;
        int r42 = com.larus.utils.l0.a;
        int r43 = ((Number) com.larus.utils.l0.a(0, new x1(r36))).intValue();
        r41.t = true;
        r41.u = r43;
    L162:
        c29.a r44 = X3();
        if (r44 == null) goto L165;
        List r45 = Z3(CollectionsKt.filterNotNull(r39));
        Intrinsics.checkNotNullParameter(r45, "backgroundColorList");
        r44.f = r45;
        r44.c();
        goto L165
    L155:
        if (this.k.getHeight() == 0) goto L158;
        r40.invoke();
        goto L159
    L147:
        r39 = r5.g;
        goto L148
    L144:
        r36 = r5.h;
        goto L145
    L141:
        r35 = r5.b;
        goto L142
    L135:
        if (this.d == true) goto L138;
        r34 = false;
    L165:
        AppCompatImageView r46 = this.l;
        if (r46 != null) goto L168;
    L170:
        boolean r47 = false;
    L171:
        if (r47 == false) goto L180;
        TextView r48 = this.m;
        if (r48 != null) goto L175;
    L177:
        boolean r49 = false;
    L178:
        if (r49 == false) goto L180;
        this.o.setReferencedIds(new int[]{2131390830});
    L181:
        if (r37 == null) goto L189;
        com.larus.bmhome.actionbar.model.p0 r50 = r37.o;
        if (r50 == null) goto L189;
        com.larus.bmhome.actionbar.model.a2 r51 = r50.d();
        if (r51 == null) goto L189;
        ArrayList r52 = r51.a;
        if (r52 == null) goto L189;
        int r53 = r52.size();
    L190:
        if (r53 <= 1) goto L192;
        com.larus.utils.e1.x(this.p);
    L193:
        com.larus.utils.e1.d(this.a, new a2(r37, this));
        this.c.d(this.a, this.i, this.k, r37);
        if (r37 == null) goto L198;
        if (r27 == false) goto L199;
        int r112 = v19.c.a(2130972081, this.a.getContext(), 2131103143);
        int r113 = v19.c.a(2130972087, this.a.getContext(), 2131103162);
        int r114 = v19.c.a(2130972080, this.a.getContext(), 2131103140);
        StringCompanionObject r115 = StringCompanionObject.INSTANCE;
        String r210 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r112)}, 1));
        String r310 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r113)}, 1));
        String r311 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r114)}, 1));
        String r211 = String.format("#%08X", Arrays.copyOf(new Object[]{0}, 1));
        c4(com.larus.bmhome.actionbar.model.z0.a(r37, null, null, null, null, null, null, null, null, null, null, new com.larus.bmhome.actionbar.model.m0(null, null, null, null, null, null, r210, r211, r310, r210, r211, r310, r311, r311, r311, r311, 4128831), null, false, -1048577), true);
        return;
    L199:
        return;
    L198:
        return;
    L192:
        com.larus.utils.e1.o(this.p);
    L189:
        r53 = 0;
        goto L190
    L175:
        if (r48.getVisibility() != 8) goto L177;
        r49 = true;
    L180:
        this.o.setReferencedIds(new int[]{2131390830, 2131376335, 2131390835});
        goto L181
    L168:
        if (r46.getVisibility() != 8) goto L170;
        r47 = true;
        goto L171
    L127:
        if (r38.intValue() <= 0) goto L129;
        ViewGroup.LayoutParams r54 = this.a.getLayoutParams();
        r54.width = r38.intValue();
        this.a.setLayoutParams(r54);
        goto L129
    L88:
        if (Intrinsics.areEqual(r37.b, "coco_ai_simul_interpret") == true) goto L93;
        if (Intrinsics.areEqual(r37.b, "doc_oral") == true) goto L93;
        r30 = false;
    L67:
        if (Intrinsics.areEqual(r37.b, "doc_oral") == false) goto L78;
        IFlowSdkDepend r55 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r55 == null) goto L75;
        r55.N();
        kotlinx.coroutines.flow.i1 r56 = com.larus.home.impl.sdk.n1.a.u();
        if (r56 == null) goto L75;
        if (((Boolean) r56.getValue()).booleanValue() != true) goto L75;
        boolean r57 = true;
    L76:
        if (r57 == false) goto L78;
    L75:
        r57 = false;
    L78:
        r26 = false;
    L46:
        r19 = false;
        goto L47
    L32:
        r16 = null;
        goto L33
    L34:
        Job r58 = this.t;
        if (r58 == null) goto L37;
        Job.DefaultImpls.cancel$default(r58, null, 1, null);
    L37:
        this.u = null;
        goto L38
    L124:
        r27 = false;
        goto L125
    L21:
        r13 = null;
    L17:
        r10 = null;
    L11:
        r8 = null;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.StringBuilder] */
    public final boolean b4(com.larus.bmhome.actionbar.model.z0 r20, boolean r21) {
        String r2 = r20.b;
        Object r7 = null;
        if (Intrinsics.areEqual(r2, "coco_ai_simul_interpret") == false) goto L22;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L7;
        r3.y();
        com.larus.home.impl.sdk.t1 r4 = com.larus.home.impl.sdk.t1.a;
    L8:
        if (r4 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L44;
        if (r4 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L44;
    L43:
        final boolean r8 = true;
    L47:
        boolean r9 = v19.h.a;
        final boolean r10 = v19.h.b(this.a.getContext());
        FLogger r11 = FLogger.a;
        r11.g("CustomActionBarNormalHolder", new v1(r10, r8));
        Object r12 = r20.e;
        if (r10 == false) goto L50;
    L55:
        com.larus.bmhome.actionbar.model.g1 r13 = r20.d;
        if (r13 == null) goto L58;
    L57:
        ?? r14 = r13.b;
    L59:
        r11.i("CustomActionBarNormalHolder", "updateIconAndName iconUrl = " + r14);
        ReplyOption r15 = this.c.g(r20);
        ModelItemIdentity r16 = r15.getModel();
        if (Intrinsics.areEqual(r16, wa8.t0.a) == true) goto L115;
        com.larus.bmhome.actionbar.model.p0 r17 = r20.o;
        if (r17 == null) goto L69;
        Integer r18 = r17.a;
        int r19 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r18 == null) goto L69;
        if (r18.intValue() != r19) goto L69;
        boolean r110 = true;
    L70:
        if (r110 == false) goto L107;
        com.larus.bmhome.actionbar.model.p0 r111 = r20.o;
        if (r111 == null) goto L105;
        com.larus.bmhome.actionbar.model.a2 r112 = r111.d();
        if (r112 == null) goto L105;
        ArrayList r113 = r112.a;
        if (r113 == null) goto L105;
        Iterator r114 = r113.iterator();
    L79:
        if (r114.hasNext() == false) goto L83;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.b2) r115).b(), r16) == false) goto L79;
    L84:
        com.larus.bmhome.actionbar.model.b2 r116 = (com.larus.bmhome.actionbar.model.b2) r115;
        if (r116 == null) goto L105;
        if (r10 == false) goto L90;
        com.larus.bmhome.actionbar.model.g1 r22 = r116.f;
        if (r22 != null) goto L92;
    L93:
        String r23 = null;
    L94:
        String r117 = r20.e + ": " + r116.b;
        if (Intrinsics.areEqual(r116.b(), wa8.t0.c) == false) goto L104;
        if (r10 == false) goto L100;
        com.larus.bmhome.actionbar.model.g1 r24 = r116.d;
        if (r24 != null) goto L102;
    L103:
        r23 = null;
    L102:
        r23 = r24.b;
        goto L104
    L100:
        r24 = r116.c;
        if (r24 == null) goto L103;
    L104:
        r14 = r23;
        r12 = r117;
    L106:
        if (r116 != null) goto L115;
    L92:
        r23 = r22.b;
        goto L94
    L90:
        r22 = r116.e;
        if (r22 == null) goto L93;
    L83:
        r115 = null;
    L105:
        r116 = null;
        r14 = r14;
    L107:
        if (r10 == false) goto L111;
        com.larus.bmhome.actionbar.model.m0 r118 = r20.u;
        if (r118 == null) goto L114;
        r14 = r118.r;
    L114:
        r14 = 0;
        goto L115
    L111:
        com.larus.bmhome.actionbar.model.m0 r119 = r20.u;
        if (r119 == null) goto L114;
        r14 = r119.q;
    L69:
        r110 = false;
    L115:
        com.larus.bmhome.actionbar.model.p0 r120 = r20.o;
        if (r120 == null) goto L123;
        Integer r121 = r120.a;
        int r122 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r121 == null) goto L123;
        if (r121.intValue() != r122) goto L123;
        boolean r123 = true;
    L124:
        if (r123 == false) goto L273;
        com.larus.bmhome.actionbar.model.p0 r124 = r20.o;
        if (r124 == null) goto L128;
        boolean r125 = Intrinsics.areEqual(r124.k, Boolean.TRUE);
    L129:
        if (r125 == false) goto L221;
        Function0<View> r126 = this.g;
        if (r126 == null) goto L135;
        View r127 = (View) r126.invoke();
        if (r127 == null) goto L135;
        LinkedHashMap r128 = IMainBotNestedMenuService.a.R8(NestedMenuScene.ACTION_BAR, r20, r15, r127);
    L136:
        List r129 = (List) r128.get("mode");
        if (r129 != null) goto L139;
        r129 = CollectionsKt.emptyList();
    L139:
        List r130 = r129;
        Iterator r131 = r130.iterator();
    L141:
        if (r131.hasNext() == false) goto L146;
        Object r132 = r131.next();
        if (((di8.d0) r132).getRight().a == false) goto L141;
    L147:
        di8.d0 r133 = (di8.d0) r132;
        if (r133 != null) goto L150;
        r133 = (di8.d0) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r130), new y1()));
    L150:
        if (r133 == null) goto L152;
        di8.f0 r25 = r133.c();
    L154:
        if ((r25 instanceof di8.p0) == false) goto L156;
        di8.p0 r26 = (di8.p0) r25;
    L157:
        if (r26 == null) goto L159;
        PcDevice r27 = r26.c;
    L160:
        if (r27 != null) goto L162;
    L164:
        boolean r28 = false;
    L165:
        if (r133 != null) goto L167;
        r133 = (di8.d0) CollectionsKt.firstOrNull(r129);
    L167:
        if (r133 == null) goto L204;
        di8.a0 r29 = r133.c();
        if ((r29 instanceof di8.a0) == false) goto L176;
        di8.a0 r30 = r29;
        String r134 = r30.b();
        ?? r135 = r14;
        if (r134 == null) goto L173;
        r135 = r134;
    L173:
        Object r31 = r30.a();
        ?? r136 = r135;
        ?? r137 = r135;
        if (r31 == null) goto L274;
    L175:
        r12 = r31;
        r137 = r136;
    L274:
        if (r8 == false) goto L296;
        Integer r32 = r20.g;
        int r33 = ActionBarExecutionType.RECORD.getValue();
        if (r32 == null) goto L281;
        if (r32.intValue() != r33) goto L281;
    L286:
        LottieAdapterView r34 = this.q;
        if (r10 == false) goto L289;
        int r35 = 2131820625;
    L290:
        r34.setAnimation(r35);
        TextView r36 = this.k;
        if (Intrinsics.areEqual(r20.b, "coco_ai_simul_interpret") == false) goto L293;
        String r0 = this.a.getContext().getString(2131898379);
    L294:
        r36.setText(r0);
    L295:
        this.q.setVisibility(0);
        this.i.setVisibility(4);
    L352:
        return r28;
    L293:
        r0 = this.a.getContext().getString(2131907301);
        goto L294
    L289:
        r35 = 2131820624;
    L281:
        if (Intrinsics.areEqual(r20.b, "coco_ai_simul_interpret") == true) goto L286;
        if (Intrinsics.areEqual(r20.b, "doc_oral") == false) goto L295;
        this.q.setAnimation("lottie/text_msg_voice_playing.json");
        this.k.setText((CharSequence) r12);
        goto L295
    L296:
        this.q.setVisibility(8);
        com.larus.utils.e1.x(this.i);
        final String r138 = (String) r137;
        if (r138 != null) goto L299;
    L302:
        boolean r1 = true;
    L303:
        if (r1 == false) goto L355;
    L347:
        boolean r139 = false;
    L348:
        if (r139 == true) goto L351;
        final long r37 = System.currentTimeMillis();
        ImageLoaderKt.v(this.i, r138, "custom_actionbar_icon", com.larus.image.loader.b0.d("custom_actionbar_icon", com.larus.platform.exp.a.i), new f2(r37, r138));
    L351:
        this.k.setText((CharSequence) r12);
        goto L352
    L355:
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L307
        Object r39 = Result.constructor-impl(UriProtector.parse(r138));     // Catch: Throwable -> L307
    L310:
        if (Result.isFailure-impl(r39) == false) goto L312;
        r39 = null;
    L312:
        Uri r40 = (Uri) r39;
        if (r40 == null) goto L347;
        if (Intrinsics.areEqual(r40.getScheme(), "res") == false) goto L347;
        if (r40.getHost() != null) goto L320;
    L322:
        String r41 = r40.getLastPathSegment();
        if (r41 == null) goto L347;
        Integer r42 = StringsKt.toIntOrNull(r41);
        if (r42 == null) goto L347;
        if (r42.intValue() == 0) goto L329;
        boolean r43 = true;
    L330:
        if (r43 == true) goto L333;
        r42 = null;
    L333:
        if (r42 == null) goto L347;
        Object r44 = Result.constructor-impl(ContextCompat.getDrawable(this.a.getContext(), r42.intValue()));     // Catch: Throwable -> L337
    L340:
        if (Result.isFailure-impl(r44) == true) goto L343;
        r7 = r44;
    L343:
        Drawable r45 = (Drawable) r7;
        if (r45 == null) goto L347;
        ImageLoaderKt.b(this.i);
        this.i.setImageDrawable(r45);
        r139 = true;
    L337:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L340
    L329:
        r43 = false;
        goto L330
    L320:
        if (Intrinsics.areEqual(r40.getHost(), this.a.getContext().getPackageName()) == true) goto L322;
    L307:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L310
    L299:
        if (r138.length() == 0) goto L302;
        r1 = false;
        goto L303
    L176:
        r137 = r14;
        if ((r29 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L274;
        com.larus.bmhome.chat.nestedmenu.b.a r48 = ((com.larus.bmhome.chat.nestedmenu.b) r29).c;
        r137 = r14;
        if (r48 == null) goto L274;
        com.larus.bmhome.actionbar.model.t0 r49 = r48.a;
        r137 = r14;
        if (r49 == null) goto L274;
        if (r10 == false) goto L190;
        com.larus.bmhome.actionbar.model.g1 r50 = r49.f;
        if (r50 == null) goto L187;
        Object r51 = r50.b;
        if (r51 == null) goto L187;
    L194:
        String r140 = r49.k;
        if (r140 != null) goto L197;
    L200:
        boolean r141 = true;
    L201:
        if (r141 == false) goto L203;
        r31 = r49.b;
    L220:
        r136 = r51;
        goto L175
    L203:
        r31 = r49.k;
        goto L220
    L197:
        if (r140.length() == 0) goto L200;
        r141 = false;
    L187:
        com.larus.bmhome.actionbar.model.g1 r52 = r49.e;
        if (r52 == null) goto L193;
        r51 = r52.b;
    L193:
        r51 = null;
        goto L194
    L190:
        com.larus.bmhome.actionbar.model.g1 r53 = r49.e;
        if (r53 == null) goto L193;
        r51 = r53.b;
        goto L194
    L204:
        ?? r142 = r14;
        if (Intrinsics.areEqual(r16, wa8.t0.a) == true) goto L215;
        if (r10 == false) goto L210;
        com.larus.bmhome.actionbar.model.m0 r143 = r20.u;
        if (r143 == null) goto L214;
        String r144 = r143.r;
    L213:
        r142 = r144;
    L214:
        r142 = 0;
        goto L215
    L210:
        com.larus.bmhome.actionbar.model.m0 r145 = r20.u;
        if (r145 == null) goto L214;
        r144 = r145.q;
    L215:
        ObricActionBarSendServiceDelegate r146 = ObricActionBarSendServiceDelegate.b;
        r137 = r142;
        if (r146.u(r15) == false) goto L274;
        Pair r54 = r146.f();
        r137 = r142;
        if (r54 == null) goto L274;
        r51 = r54.getSecond();
        r31 = r54.getFirst();
        goto L220
    L162:
        if (Intrinsics.areEqual(r27.r(), Boolean.TRUE) == true) goto L164;
        r28 = true;
        goto L165
    L159:
        r27 = null;
        goto L160
    L156:
        r26 = null;
        goto L157
    L152:
        r25 = null;
        goto L154
    L146:
        r132 = null;
    L135:
        r128 = IMainBotNestedMenuService.a.P8(NestedMenuScene.ACTION_BAR, r20, r15);
        goto L136
    L221:
        com.larus.bmhome.actionbar.model.p0 r55 = r20.o;
        if (r55 == null) goto L268;
        com.larus.bmhome.actionbar.model.a2 r56 = r55.d();
        if (r56 == null) goto L268;
        ArrayList r57 = r56.a;
        if (r57 == null) goto L268;
        Iterator r58 = r57.iterator();
    L229:
        if (r58.hasNext() == false) goto L233;
        Object r147 = r58.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.b2) r147).b(), r16) == false) goto L229;
    L234:
        com.larus.bmhome.actionbar.model.b2 r148 = (com.larus.bmhome.actionbar.model.b2) r147;
        if (r148 == null) goto L268;
        if (Intrinsics.areEqual(r16, wa8.t0.a) == false) goto L239;
    L248:
        if (r10 == false) goto L252;
        com.larus.bmhome.actionbar.model.g1 r59 = r148.d;
        if (r59 != null) goto L254;
    L256:
        r14 = 0;
    L257:
        String r60 = r148.k;
        if (r60 != null) goto L260;
    L263:
        boolean r61 = true;
    L264:
        if (r61 == false) goto L266;
        String r62 = String.valueOf(r148.b);
    L267:
        r12 = r62;
        goto L273
    L266:
        r62 = String.valueOf(r148.k);
        goto L267
    L260:
        if (r60.length() == 0) goto L263;
        r61 = false;
    L254:
        String r63 = r59.b;
    L255:
        r14 = r63;
        goto L257
    L252:
        r59 = r148.c;
        if (r59 == null) goto L256;
    L239:
        if (Intrinsics.areEqual(r16, wa8.t0.c) == true) goto L248;
        if (r10 == false) goto L245;
        com.larus.bmhome.actionbar.model.g1 r64 = r148.f;
        if (r64 == null) goto L256;
    L247:
        r63 = r64.b;
        goto L255
    L245:
        r64 = r148.e;
        if (r64 == null) goto L256;
    L233:
        r147 = null;
    L268:
        ObricActionBarSendServiceDelegate r65 = ObricActionBarSendServiceDelegate.b;
        if (r65.u(r15) == false) goto L273;
        Pair r66 = r65.f();
        if (r66 == null) goto L273;
        r14 = r66.getSecond();
        r12 = r66.getFirst();
        goto L273
    L128:
        r125 = false;
    L273:
        r28 = false;
        r137 = r14;
    L123:
        r123 = false;
    L58:
        r14 = 0;
        goto L59
    L50:
        if (this.d == true) goto L55;
        r13 = r20.c;
        if (r13 == null) goto L58;
    L16:
        if (r4.j() != true) goto L18;
        r6 = true;
    L44:
        r8 = false;
        goto L47
    L10:
        if (r4.y0() != true) goto L12;
        r5 = true;
        goto L13
    L7:
        r4 = null;
        goto L8
    L22:
        if (Intrinsics.areEqual(r2, "coco_record") == false) goto L46;
        IFlowSdkDepend r67 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r67 == null) goto L26;
        r67.y();
        com.larus.home.impl.sdk.t1 r68 = com.larus.home.impl.sdk.t1.a;
    L27:
        if (r68 != null) goto L29;
    L31:
        boolean r69 = false;
    L32:
        if (r69 == false) goto L40;
        if (r68 != null) goto L35;
    L37:
        boolean r70 = false;
    L38:
        if (r70 == false) goto L40;
        boolean r71 = true;
    L41:
        if (r69 == false) goto L45;
        if (r71 == true) goto L44;
    L45:
        r8 = AudioServiceDelegate.a.P().g();
        goto L47
    L35:
        if (r68.j() != true) goto L37;
        r70 = true;
    L40:
        r71 = false;
        goto L41
    L29:
        if (r68.y0() != true) goto L31;
        r69 = true;
        goto L32
    L26:
        r68 = null;
        goto L27
    L46:
        r8 = r21;
        goto L47
    }

    public final void c4(com.larus.bmhome.actionbar.model.z0 r13, boolean r14) {
        RoundConstraintLayout r1 = null;
        if (this.d == false) goto L13;
        if (r14 == true) goto L13;
        RoundConstraintLayout r15 = this.a;
        if ((r15 instanceof RoundConstraintLayout) == false) goto L8;
        r1 = r15;
    L8:
        if (r1 == null) goto L12;
        c29.a r16 = r1.getDelegate();
        if (r16 == null) goto L12;
        int r17 = ContextCompat.getColor(this.a.getContext(), 2131106535);
        r16.a(r17);
        r16.b(r17);
        r16.g(ContextCompat.getColor(this.a.getContext(), 2131106536));
    L12:
        this.k.setTextColor(ContextCompat.getColor(this.a.getContext(), 2131103298));
        this.i.clearColorFilter();
        return;
    L13:
        com.larus.bmhome.actionbar.model.p0 r18 = r13.o;
        if (r18 == null) goto L16;
        boolean r19 = Intrinsics.areEqual(r18.k, Boolean.TRUE);
    L17:
        boolean r2 = true;
        if (r19 == false) goto L38;
        com.larus.bmhome.actionbar.model.p0 r110 = r13.o;
        if (r110 == null) goto L24;
        com.larus.bmhome.actionbar.model.s0 r111 = r110.j;
        if (r111 == null) goto L24;
        boolean r112 = Intrinsics.areEqual(r111.d, Boolean.TRUE);
    L25:
        if (r112 == false) goto L38;
        String r113 = this.c.g(r13).getModeId();
        if (r113 != null) goto L29;
    L32:
        boolean r3 = true;
    L33:
        if (r3 == false) goto L35;
    L40:
        boolean r114 = false;
    L41:
        Integer r4 = r13.g;
        ActionBarExecutionType r5 = ActionBarExecutionType.SWITCH_STATUS;
        int r6 = r5.getValue();
        if (r4 != null) goto L45;
    L101:
        View r115 = this.a;
        Integer r7 = r13.g;
        int r8 = r5.getValue();
        if (r7 != null) goto L105;
    L107:
        String r9 = Y3(r13);
    L108:
        r115.setContentDescription(r9);
        RoundConstraintLayout r116 = this.a;
        if ((r116 instanceof RoundConstraintLayout) == false) goto L111;
        RoundConstraintLayout r117 = r116;
    L112:
        if (r117 == null) goto L120;
        c29.a r118 = r117.getDelegate();
        if (r118 == null) goto L120;
        Context r10 = this.a.getContext();
        TextView r11 = this.m;
        if (r11 == null) goto L118;
        Context r12 = r11.getContext();
    L119:
        r118.b(ContextCompat.getColor(r10, v19.c.b(2130972118, r12, 2131103188)));
        goto L120
    L118:
        r12 = null;
    L120:
        com.larus.bmhome.actionbar.model.m0 r119 = r13.u;
        if (r119 == null) goto L123;
        String r20 = r119.m;
    L124:
        if (r119 == null) goto L126;
        String r120 = r119.n;
    L127:
        TextView r21 = this.m;
        if (r21 == null) goto L130;
        Context r22 = r21.getContext();
    L131:
        int r121 = W3(r20, r120, v19.c.b(2130972080, r22, 2131103140));
        ImageView r23 = this.p;
        int r24 = com.larus.utils.j0.a;
        r23.setImageDrawable(com.larus.utils.j0.f(2131240784, r121));
        com.larus.bmhome.actionbar.model.m0 r25 = r13.u;
        if (r25 == null) goto L134;
        String r26 = r25.a;
    L135:
        if (r25 == null) goto L137;
        String r27 = r25.b;
    L138:
        if (r25 == null) goto L140;
        String r28 = r25.c;
    L141:
        if (r25 == null) goto L143;
        String r29 = r25.d;
    L144:
        if (r25 == null) goto L146;
        String r122 = r25.e;
    L147:
        if (r25 == null) goto L149;
        String r123 = r25.f;
    L150:
        a r124 = new a(r26, r27, r28, r29, r122, r123);
    L151:
        Integer r125 = r13.g;
        int r30 = r5.getValue();
        if (r125 != null) goto L155;
    L157:
        r2 = false;
    L158:
        c29.a r126 = X3();
        if (r126 == null) goto L161;
        r126.a(0);
    L161:
        String r127 = r124.c;
        String r0 = r124.f;
        TextView r31 = this.m;
        if (r31 == null) goto L164;
        Context r32 = r31.getContext();
    L165:
        int r128 = W3(r127, r0, v19.c.b(2130972087, r32, 2131103162));
        c29.a r33 = X3();
        if (r33 == null) goto L168;
        r33.g(r128);
    L168:
        String r129 = r124.a;
        String r130 = r124.d;
        TextView r34 = this.m;
        if (r34 == null) goto L171;
        r1 = r34.getContext();
    L171:
        int r131 = W3(r129, r130, v19.c.b(2130972079, r1, 2131103136));
        this.k.setTextColor(r131);
        if (r2 == false) goto L174;
        this.i.setColorFilter(r131);
        return;
    L174:
        this.i.clearColorFilter();
        return;
    L164:
        r32 = null;
        goto L165
    L155:
        if (r125.intValue() != r30) goto L157;
    L149:
        r123 = null;
        goto L150
    L146:
        r122 = null;
        goto L147
    L143:
        r29 = null;
        goto L144
    L140:
        r28 = null;
        goto L141
    L137:
        r27 = null;
        goto L138
    L134:
        r26 = null;
        goto L135
    L130:
        r22 = null;
        goto L131
    L126:
        r120 = null;
        goto L127
    L123:
        r20 = null;
        goto L124
    L111:
        r117 = null;
        goto L112
    L105:
        if (r7.intValue() != r8) goto L107;
        StringCompanionObject r35 = StringCompanionObject.INSTANCE;
        int r36 = com.larus.utils.j0.a;
        r9 = String.format(com.larus.utils.j0.d(2131898746), Arrays.copyOf(new Object[]{Y3(r13)}, 1));
        goto L108
    L45:
        if (r4.intValue() != r6) goto L101;
        if (r114 == false) goto L101;
        View r132 = this.a;
        Integer r37 = r13.g;
        int r38 = r5.getValue();
        if (r37 != null) goto L51;
    L53:
        String r39 = Y3(r13);
    L54:
        r132.setContentDescription(r39);
        IFlowChatThemeConfigProvider r133 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r133 == null) goto L57;
        r133.d(new b2(this), new c2(this), AdaptThemeFeatureKey.CHAT_ACTIONBAR_DEEP_THINK_PRESS_COLOR);
    L57:
        if (r133 != null) goto L70;
        RoundConstraintLayout r134 = this.a;
        if ((r134 instanceof RoundConstraintLayout) == false) goto L61;
        RoundConstraintLayout r135 = r134;
    L62:
        if (r135 == null) goto L70;
        c29.a r136 = r135.getDelegate();
        if (r136 == null) goto L70;
        Context r40 = this.a.getContext();
        TextView r41 = this.m;
        if (r41 == null) goto L68;
        Context r42 = r41.getContext();
    L69:
        r136.b(ContextCompat.getColor(r40, v19.c.b(2130973611, r42, 2131105590)));
        goto L70
    L68:
        r42 = null;
        goto L69
    L61:
        r135 = null;
    L70:
        com.larus.bmhome.actionbar.model.m0 r137 = r13.u;
        if (r137 == null) goto L73;
        String r43 = r137.o;
    L74:
        if (r137 == null) goto L76;
        String r138 = r137.p;
    L77:
        TextView r44 = this.m;
        if (r44 == null) goto L80;
        Context r45 = r44.getContext();
    L81:
        int r139 = W3(r43, r138, v19.c.b(2130973613, r45, 2131105594));
        ImageView r46 = this.p;
        int r47 = com.larus.utils.j0.a;
        r46.setImageDrawable(com.larus.utils.j0.f(2131240784, r139));
        com.larus.bmhome.actionbar.model.m0 r48 = r13.u;
        if (r48 == null) goto L84;
        String r49 = r48.g;
    L85:
        if (r48 == null) goto L87;
        String r50 = r48.h;
    L88:
        if (r48 == null) goto L90;
        String r51 = r48.i;
    L91:
        if (r48 == null) goto L93;
        String r52 = r48.j;
    L94:
        if (r48 == null) goto L96;
        String r140 = r48.k;
    L97:
        if (r48 == null) goto L99;
        String r141 = r48.l;
    L100:
        r124 = new a(r49, r50, r51, r52, r140, r141);
        goto L151
    L99:
        r141 = null;
        goto L100
    L96:
        r140 = null;
        goto L97
    L93:
        r52 = null;
        goto L94
    L90:
        r51 = null;
        goto L91
    L87:
        r50 = null;
        goto L88
    L84:
        r49 = null;
        goto L85
    L80:
        r45 = null;
        goto L81
    L76:
        r138 = null;
        goto L77
    L73:
        r43 = null;
        goto L74
    L51:
        if (r37.intValue() != r38) goto L53;
        StringCompanionObject r53 = StringCompanionObject.INSTANCE;
        int r54 = com.larus.utils.j0.a;
        r39 = String.format(com.larus.utils.j0.d(2131898747), Arrays.copyOf(new Object[]{Y3(r13)}, 1));
        goto L54
    L35:
        if (Intrinsics.areEqual(r113, "1") == true) goto L40;
    L39:
        r114 = true;
        goto L41
    L29:
        if (r113.length() == 0) goto L32;
        r3 = false;
    L24:
        r112 = false;
    L38:
        if (Intrinsics.areEqual(this.c.g(r13).getModel(), wa8.t0.a) == true) goto L40;
    L16:
        r19 = false;
        goto L17
    }

    public final int W3(String r2, String r3, int r4) {
        boolean r0 = v19.h.a;
        if (v19.h.b(this.a.getContext()) == false) goto L11;
        if (r3 == null) goto L10;
        Integer r5 = u1.a(r3);
        if (r5 == null) goto L10;
        return r5.intValue();
    L10:
        return ContextCompat.getColor(this.a.getContext(), r4);
    L11:
        if (r2 == null) goto L17;
        Integer r6 = u1.a(r2);
        if (r6 == null) goto L17;
        return r6.intValue();
    L17:
        return ContextCompat.getColor(this.a.getContext(), r4);
    }

    public CustomActionBarNormalHolder(RoundConstraintLayout r3, ChatParam r4, t1 r5, boolean r6, boolean r7, n r8, Function0 r9, int r10) {
        if ((r10 & 8) == 0) goto L6;
        r6 = false;
    L6:
        if ((r10 & 16) == 0) goto L9;
        r7 = false;
    L9:
        if ((r10 & 64) == 0) goto L11;
        r9 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r5, "callback");
        super(r3);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.i = r3.findViewById(2131374692);
        this.j = (ProgressBar) r3.findViewById(2131378977);
        this.k = (TextView) r3.findViewById(2131390830);
        AppCompatImageView r11 = r3.findViewById(2131376335);
        this.l = r11;
        TextView r12 = (TextView) r3.findViewById(2131390835);
        this.m = r12;
        this.n = new j(r11, r12);
        this.o = r3.findViewById(2131363974);
        this.p = (ImageView) r3.findViewById(2131376349);
        this.q = r3.findViewById(2131374695);
    }
}
