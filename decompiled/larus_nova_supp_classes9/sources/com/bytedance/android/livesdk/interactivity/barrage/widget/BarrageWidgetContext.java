package com.bytedance.android.livesdk.interactivity.barrage.widget;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.ChatCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import p22.i;
import p22.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001nB\u0007¢\u0006\u0004\bk\u0010lJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\nR!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\nR!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001e\u0010\nR!\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b#\u0010$R!\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\b\u001a\u0004\b(\u0010\nR!\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\b\u001a\u0004\b,\u0010\nR!\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b0\u0010\nR!\u00107\u001a\b\u0012\u0004\u0012\u000203028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\b\u001a\u0004\b5\u00106R!\u0010;\u001a\b\u0012\u0004\u0012\u000208028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\b\u001a\u0004\b:\u00106R!\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0003028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\b\u001a\u0004\b=\u00106R!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0003028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\b\u001a\u0004\b?\u00106R!\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0003028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\b\u001a\u0004\bA\u00106R!\u0010C\u001a\b\u0012\u0004\u0012\u00020\u0003028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\b\u001a\u0004\bC\u00106R!\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0003028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\b\u001a\u0004\bE\u00106R!\u0010G\u001a\b\u0012\u0004\u0012\u00020\u0003028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\b\u001a\u0004\bG\u00106R!\u0010K\u001a\b\u0012\u0004\u0012\u00020H0\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\b\u001a\u0004\bJ\u0010\nR!\u0010O\u001a\b\u0012\u0004\u0012\u00020L0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\b\u001a\u0004\bN\u0010$R!\u0010S\u001a\b\u0012\u0004\u0012\u00020P0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\b\u001a\u0004\bR\u0010$R!\u0010W\u001a\b\u0012\u0004\u0012\u00020T028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\b\u001a\u0004\bV\u00106R!\u0010[\u001a\b\u0012\u0004\u0012\u00020X028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\b\u001a\u0004\bZ\u00106R!\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\b\u001a\u0004\b^\u0010\nR!\u0010c\u001a\b\u0012\u0004\u0012\u00020`0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\b\u001a\u0004\bb\u0010$R!\u0010f\u001a\b\u0012\u0004\u0012\u00020\u0003028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\b\u001a\u0004\be\u00106R\u0011\u0010g\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0011\u0010i\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010hR\u0011\u0010j\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bj\u0010h¨\u0006o"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/widget/BarrageWidgetContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/b;", BuildConfig.FLAVOR, "hasCleared", "Lcom/bytedance/live/datacontext/n;", "Lp22/p;", "textDanmakuSettingConfig$delegate", "Lcom/bytedance/live/datacontext/p;", "getTextDanmakuSettingConfig", "()Lcom/bytedance/live/datacontext/n;", "textDanmakuSettingConfig", "Lp22/a;", "adminDanmakuSettingConfig$delegate", "getAdminDanmakuSettingConfig", "adminDanmakuSettingConfig", "Lp22/g;", "giftDanmakuSettingConfig$delegate", "getGiftDanmakuSettingConfig", "giftDanmakuSettingConfig", "Lp22/c;", "businessDanmakuConfig$delegate", "getBusinessDanmakuConfig", "businessDanmakuConfig", "Lp22/k;", "privilegeDanmakuSettingConfig$delegate", "getPrivilegeDanmakuSettingConfig", "privilegeDanmakuSettingConfig", "Lp22/i;", "normalDanmakuSettingConfig$delegate", "getNormalDanmakuSettingConfig", "normalDanmakuSettingConfig", "Lcom/bytedance/live/datacontext/j;", "Lpk6/a;", "danmakuAlpha$delegate", "getDanmakuAlpha", "()Lcom/bytedance/live/datacontext/j;", "danmakuAlpha", "Lcom/bytedance/android/livesdk/interactivity/barrage/widget/a;", "env$delegate", "getEnv", "env", "Landroid/view/View;", "scrollBarrageView$delegate", "getScrollBarrageView", "scrollBarrageView", "Lcom/bytedance/android/livesdk/interactivity/utils/f;", "chatCarnivalStylePicker$delegate", "getChatCarnivalStylePicker", "chatCarnivalStylePicker", "Lcom/bytedance/live/datacontext/m;", BuildConfig.FLAVOR, "scaleRate$delegate", "getScaleRate", "()Lcom/bytedance/live/datacontext/m;", "scaleRate", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/g;", "contour$delegate", "getContour", "contour", "isCarnivalStarted$delegate", "isCarnivalStarted", "isWarmingUp$delegate", "isWarmingUp", "isInCarnival$delegate", "isInCarnival", "isDanmakuVisible$delegate", "isDanmakuVisible", "isLandscapeDanmakuVisible$delegate", "isLandscapeDanmakuVisible", "isLandscapeCarnivalDisabled$delegate", "isLandscapeCarnivalDisabled", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/d;", "chatCarnivalMessage$delegate", "getChatCarnivalMessage", "chatCarnivalMessage", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/ChatCarnivalDataSyncModel;", "chatCarnivalSyncModel$delegate", "getChatCarnivalSyncModel", "chatCarnivalSyncModel", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/GeneralCarnivalDataSyncModel;", "generalCarnivalSyncModel$delegate", "getGeneralCarnivalSyncModel", "generalCarnivalSyncModel", BuildConfig.FLAVOR, "waitDanmakuCountEnum$delegate", "getWaitDanmakuCountEnum", "waitDanmakuCountEnum", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/a;", "waitMessageState$delegate", "getWaitMessageState", "waitMessageState", BuildConfig.FLAVOR, "appData$delegate", "getAppData", "appData", "Lo22/d;", "danmakuCarnivalManager$delegate", "getDanmakuCarnivalManager", "danmakuCarnivalManager", "defaultVisibleAlpha$delegate", "getDefaultVisibleAlpha", "defaultVisibleAlpha", "isPortrait", "()Z", "isVSVerticalStream", "isAnchor", "<init>", "()V", "Companion", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageWidgetContext extends DataContext implements com.bytedance.android.livesdk.interactivity.api.publicscreen.b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final float SCALE_RATE_NORMAL = 1.0f;
    public static final float SCALE_RATE_SMALL = 0.85f;
    public static final String TAG = "BarrageWidgetContext";
    private final p adminDanmakuSettingConfig$delegate;
    private final p appData$delegate;
    private final p businessDanmakuConfig$delegate;
    private final p chatCarnivalMessage$delegate;
    private final p chatCarnivalStylePicker$delegate;
    private final p chatCarnivalSyncModel$delegate;
    private final p contour$delegate;
    private final p danmakuAlpha$delegate;
    private final p danmakuCarnivalManager$delegate;
    private final p defaultVisibleAlpha$delegate;
    private final p env$delegate;
    private final p generalCarnivalSyncModel$delegate;
    private final p giftDanmakuSettingConfig$delegate;
    private final p isCarnivalStarted$delegate;
    private final p isDanmakuVisible$delegate;
    private final p isInCarnival$delegate;
    private final p isLandscapeCarnivalDisabled$delegate;
    private final p isLandscapeDanmakuVisible$delegate;
    private final p isWarmingUp$delegate;
    private final p normalDanmakuSettingConfig$delegate;
    private final p privilegeDanmakuSettingConfig$delegate;
    private final p scaleRate$delegate;
    private final p scrollBarrageView$delegate;
    private final p textDanmakuSettingConfig$delegate;
    private final p waitDanmakuCountEnum$delegate;
    private final p waitMessageState$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "textDanmakuSettingConfig", "getTextDanmakuSettingConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "adminDanmakuSettingConfig", "getAdminDanmakuSettingConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "giftDanmakuSettingConfig", "getGiftDanmakuSettingConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "businessDanmakuConfig", "getBusinessDanmakuConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "privilegeDanmakuSettingConfig", "getPrivilegeDanmakuSettingConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "normalDanmakuSettingConfig", "getNormalDanmakuSettingConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "danmakuAlpha", "getDanmakuAlpha()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "env", "getEnv()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "scrollBarrageView", "getScrollBarrageView()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "chatCarnivalStylePicker", "getChatCarnivalStylePicker()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "scaleRate", "getScaleRate()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "contour", "getContour()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "isCarnivalStarted", "isCarnivalStarted()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "isWarmingUp", "isWarmingUp()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "isInCarnival", "isInCarnival()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "isDanmakuVisible", "isDanmakuVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "isLandscapeDanmakuVisible", "isLandscapeDanmakuVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "isLandscapeCarnivalDisabled", "isLandscapeCarnivalDisabled()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "chatCarnivalMessage", "getChatCarnivalMessage()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "chatCarnivalSyncModel", "getChatCarnivalSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "generalCarnivalSyncModel", "getGeneralCarnivalSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "waitDanmakuCountEnum", "getWaitDanmakuCountEnum()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "waitMessageState", "getWaitMessageState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "appData", "getAppData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "danmakuCarnivalManager", "getDanmakuCarnivalManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(BarrageWidgetContext.class, "defaultVisibleAlpha", "getDefaultVisibleAlpha()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final n<p22.a> getAdminDanmakuSettingConfig() {
        return (n) this.adminDanmakuSettingConfig$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public n<String> getAppData() {
        return (n) this.appData$delegate.a(this, $$delegatedProperties[23]);
    }

    public final n<p22.c> getBusinessDanmakuConfig() {
        return (n) this.businessDanmakuConfig$delegate.a(this, $$delegatedProperties[3]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> getChatCarnivalMessage() {
        return (n) this.chatCarnivalMessage$delegate.a(this, $$delegatedProperties[18]);
    }

    public final n<com.bytedance.android.livesdk.interactivity.utils.f> getChatCarnivalStylePicker() {
        return (n) this.chatCarnivalStylePicker$delegate.a(this, $$delegatedProperties[9]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public j<ChatCarnivalDataSyncModel> getChatCarnivalSyncModel() {
        return (j) this.chatCarnivalSyncModel$delegate.a(this, $$delegatedProperties[19]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public m<com.bytedance.android.livesdk.interactivity.api.barrage.data.g> getContour() {
        return (m) this.contour$delegate.a(this, $$delegatedProperties[11]);
    }

    public final j<pk6.a> getDanmakuAlpha() {
        return (j) this.danmakuAlpha$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public j<o22.d> getDanmakuCarnivalManager() {
        return (j) this.danmakuCarnivalManager$delegate.a(this, $$delegatedProperties[24]);
    }

    public m<Boolean> getDefaultVisibleAlpha() {
        return (m) this.defaultVisibleAlpha$delegate.a(this, $$delegatedProperties[25]);
    }

    public final n<com.bytedance.android.livesdk.interactivity.barrage.widget.a> getEnv() {
        return (n) this.env$delegate.a(this, $$delegatedProperties[7]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public j<GeneralCarnivalDataSyncModel> getGeneralCarnivalSyncModel() {
        return (j) this.generalCarnivalSyncModel$delegate.a(this, $$delegatedProperties[20]);
    }

    public final n<p22.g> getGiftDanmakuSettingConfig() {
        return (n) this.giftDanmakuSettingConfig$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<i> getNormalDanmakuSettingConfig() {
        return (n) this.normalDanmakuSettingConfig$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<k> getPrivilegeDanmakuSettingConfig() {
        return (n) this.privilegeDanmakuSettingConfig$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Float> getScaleRate() {
        return (m) this.scaleRate$delegate.a(this, $$delegatedProperties[10]);
    }

    public final n<View> getScrollBarrageView() {
        return (n) this.scrollBarrageView$delegate.a(this, $$delegatedProperties[8]);
    }

    public final n<p22.p> getTextDanmakuSettingConfig() {
        return (n) this.textDanmakuSettingConfig$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public m<Integer> getWaitDanmakuCountEnum() {
        return (m) this.waitDanmakuCountEnum$delegate.a(this, $$delegatedProperties[21]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public m<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a> getWaitMessageState() {
        return (m) this.waitMessageState$delegate.a(this, $$delegatedProperties[22]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public m<Boolean> isCarnivalStarted() {
        return (m) this.isCarnivalStarted$delegate.a(this, $$delegatedProperties[12]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public m<Boolean> isDanmakuVisible() {
        return (m) this.isDanmakuVisible$delegate.a(this, $$delegatedProperties[15]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public m<Boolean> isInCarnival() {
        return (m) this.isInCarnival$delegate.a(this, $$delegatedProperties[14]);
    }

    public m<Boolean> isLandscapeCarnivalDisabled() {
        return (m) this.isLandscapeCarnivalDisabled$delegate.a(this, $$delegatedProperties[17]);
    }

    public m<Boolean> isLandscapeDanmakuVisible() {
        return (m) this.isLandscapeDanmakuVisible$delegate.a(this, $$delegatedProperties[16]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public m<Boolean> isWarmingUp() {
        return (m) this.isWarmingUp$delegate.a(this, $$delegatedProperties[13]);
    }

    public final boolean isAnchor() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        Boolean r1 = null;
        if (r0 == null) goto L8;
        o r2 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r2 == null) goto L8;
        r1 = r2.isAnchor();
    L8:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    }

    public final boolean isPortrait() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        Boolean r1 = null;
        if (r0 == null) goto L8;
        o r2 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r2 == null) goto L8;
        r1 = r2.isPortraitInteraction();
    L8:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    }

    public final boolean isVSVerticalStream() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        Boolean r1 = null;
        if (r0 == null) goto L8;
        o r2 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r2 == null) goto L8;
        r1 = r2.isVSVerticalStream();
    L8:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    }

    public BarrageWidgetContext() {
        this.textDanmakuSettingConfig$delegate = q.c(this);
        this.adminDanmakuSettingConfig$delegate = q.c(this);
        this.giftDanmakuSettingConfig$delegate = q.c(this);
        this.businessDanmakuConfig$delegate = q.c(this);
        this.privilegeDanmakuSettingConfig$delegate = q.c(this);
        this.normalDanmakuSettingConfig$delegate = q.c(this);
        this.danmakuAlpha$delegate = ConstantKt.c(this);
        this.env$delegate = q.c(this);
        this.scrollBarrageView$delegate = q.c(this);
        this.chatCarnivalStylePicker$delegate = q.c(this);
        this.scaleRate$delegate = q.d(this, Float.valueOf(1.0f));
        this.contour$delegate = q.a(this, new com.bytedance.android.livesdk.interactivity.api.barrage.data.g(), BarrageWidgetContext$contour$2.INSTANCE);
        Boolean r0 = Boolean.FALSE;
        this.isCarnivalStarted$delegate = q.d(this, r0);
        this.isWarmingUp$delegate = q.d(this, r0);
        this.isInCarnival$delegate = q.d(this, r0);
        this.isDanmakuVisible$delegate = q.d(this, Boolean.TRUE);
        int r1 = a1.a;
        boolean r2 = true;
        if (a1.a.a().d() == false) goto L10;
        BarrageSetting r3 = (BarrageSetting) l42.a.d.getValue();
        if (r3 == null) goto L10;
        if (r3.isCarnivalBarrageOpen() == true) goto L10;
        boolean r4 = false;
    L11:
        this.isLandscapeDanmakuVisible$delegate = q.d(this, Boolean.valueOf(r4));
        if (a1.a.a().d() == false) goto L18;
        BarrageSetting r5 = (BarrageSetting) l42.a.d.getValue();
        if (r5 == null) goto L18;
        if (r5.isCarnivalBarrageOpen() == true) goto L18;
    L19:
        this.isLandscapeCarnivalDisabled$delegate = q.d(this, Boolean.valueOf(r2));
        this.chatCarnivalMessage$delegate = q.c(this);
        this.chatCarnivalSyncModel$delegate = ConstantKt.c(this);
        this.generalCarnivalSyncModel$delegate = ConstantKt.c(this);
        this.waitDanmakuCountEnum$delegate = q.d(this, 0);
        this.waitMessageState$delegate = q.d(this, new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a(0));
        this.appData$delegate = q.c(this);
        this.danmakuCarnivalManager$delegate = ConstantKt.b(this, BarrageWidgetContext$danmakuCarnivalManager$2.INSTANCE);
        this.defaultVisibleAlpha$delegate = q.d(this, r0);
        getDanmakuAlpha().d(new pk6.a(255));
        return;
    L18:
        r2 = false;
    L10:
        r4 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.b
    public boolean hasCleared() {
        return isCleared();
    }
}
