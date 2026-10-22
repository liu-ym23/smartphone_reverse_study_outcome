package com.larus.bmhome.chat.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.auth.LaunchBiz;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.a;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010(2\b\u0010/\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020-2\u0006\u00101\u001a\u0002022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0016J(\u00103\u001a\u00020-2\u0006\u00101\u001a\u0002022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000208H\u0016J \u00109\u001a\u00020-2\u0006\u00101\u001a\u0002022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0016J&\u0010:\u001a\u00020-2\u0006\u00101\u001a\u0002022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u00104\u001a\u000205H\u0016J\u001e\u0010>\u001a\u00020-2\u0006\u00101\u001a\u0002022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010@\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010A\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010B\u001a\u0004\u0018\u00010\u001aH\u0016J\u001e\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u0002022\u0006\u0010E\u001a\u00020(H\u0096@¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u00020-2\b\u0010H\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010I\u001a\u00020-H\u0016J\b\u0010J\u001a\u000205H\u0016J\b\u0010K\u001a\u000205H\u0016J\b\u0010L\u001a\u000205H\u0016J\b\u0010M\u001a\u000205H\u0016J\b\u0010N\u001a\u000205H\u0016J\u0012\u0010O\u001a\u00020-2\b\u0010P\u001a\u0004\u0018\u00010(H\u0016J\u001c\u0010Q\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u0001022\b\u0010S\u001a\u0004\u0018\u000102H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\bR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00100\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001c\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\b¨\u0006T"}, d2 = {"Lcom/larus/bmhome/chat/api/AuthModelServiceNoop;", "Lcom/larus/bmhome/chat/api/IAuthModelService;", "<init>", "()V", "appLaunchInfoWithStatusLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/larus/bmhome/chat/api/AppLaunchInfoWithStatus;", "getAppLaunchInfoWithStatusLiveData", "()Landroidx/lifecycle/LiveData;", "mainBotConversationInfo", "Lcom/larus/im/bean/conversation/Conversation;", "getMainBotConversationInfo", "launchInfoWithStatusLiveData", "Lcom/larus/bmhome/chat/api/LaunchInfoWithStatus;", "getLaunchInfoWithStatusLiveData", "coreLaunchWithStatusLiveData", "Lcom/larus/bmhome/auth/LaunchResult;", "Lcom/larus/bmhome/auth/CoreLaunchInfo;", "getCoreLaunchWithStatusLiveData", "basicLaunchWithStatusLiveData", "Lcom/larus/bmhome/auth/BasicLaunchInfo;", "getBasicLaunchWithStatusLiveData", "imLaunchWithStatusLiveData", "Lcom/larus/bmhome/auth/IMLaunchInfo;", "getImLaunchWithStatusLiveData", "audioLaunchWithStatusLiveData", "Lcom/larus/bmhome/auth/AudioLaunchInfo;", "getAudioLaunchWithStatusLiveData", "coreLaunchForConsumerLiveData", "getCoreLaunchForConsumerLiveData", "basicLaunchForConsumerLiveData", "getBasicLaunchForConsumerLiveData", "imLaunchForConsumerLiveData", "getImLaunchForConsumerLiveData", "audioLaunchForConsumerLiveData", "getAudioLaunchForConsumerLiveData", "appLaunchInfoDataWithCache", "Lcom/larus/bmhome/auth/AppLaunchInfo;", "getAppLaunchInfoDataWithCache", "launchInfoDataWithCache", "Lcom/larus/bmhome/auth/LaunchInfo;", "getLaunchInfoDataWithCache", "mainBotConversationInfoWithCache", "getMainBotConversationInfoWithCache", "saveCache", "", "launchInfo", "conversationInfo", "requestAppLaunch", "from", "", "requestLaunchInfo", "isForce", "", "forceRequestIgnoreStatus", "scene", "Lcom/larus/bmhome/chat/api/LaunchRequestScene;", "requestLaunchCore", "requestLaunch", "bizSet", "", "Lcom/larus/bmhome/auth/LaunchBiz;", "requestColdStartLaunchAfterFirstFeed", "getCoreLaunchForConsumer", "getBasicLaunchForConsumer", "getIMLaunchForConsumer", "getAudioLaunchForConsumer", "socialDefaultConversationRequest", "metricType", "launchData", "(Ljava/lang/String;Lcom/larus/bmhome/auth/LaunchInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMainBotConversationInfo", "cvsInfo", "resetInfo", "appIconEditEnable", "advancedWhiteEnabled", "isAdvancedWhiteUserOrDebugEntranceEnable", "isEnablePromptDetail", "advancedWhiteEnabledInCici", "updateLaunchInfoCache", "newData", "updateConversationModeDefaultKeys", "defaultNewChatModeKey", "defaultNewOfficeModeKey", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AuthModelServiceNoop implements IAuthModelService {
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    public final MutableLiveData i;
    public final MutableLiveData j;
    public final MutableLiveData k;
    public final MutableLiveData l;
    public final MutableLiveData m;
    public final MutableLiveData n;

    public final com.larus.bmhome.auth.j0 C() {
        return null;
    }

    public final e0 D() {
        return null;
    }

    public final void F(String r2, Set<? extends LaunchBiz> r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "bizSet");
    }

    public final boolean b() {
        return false;
    }

    public final boolean d() {
        return false;
    }

    public final void f(wc9.e r1) {
    }

    public final boolean g() {
        return false;
    }

    public final void h(String r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "from");
    }

    public final void k(String r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "from");
    }

    public final void n() {
    }

    public final com.larus.bmhome.auth.b o() {
        return null;
    }

    public final void p(String r1, String r2) {
    }

    public final void q(String r1, boolean r2, LaunchRequestScene r3) {
        Intrinsics.checkNotNullParameter(r1, "from");
        Intrinsics.checkNotNullParameter(r3, "scene");
    }

    public final void r(LaunchInfo r1, wc9.e r2) {
    }

    public final boolean s() {
        return false;
    }

    public final void t(String r1, Set<? extends LaunchBiz> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "from");
        Intrinsics.checkNotNullParameter(r2, "bizSet");
    }

    public final com.larus.bmhome.auth.h0 v() {
        return null;
    }

    public final void w(String r2) {
        Intrinsics.checkNotNullParameter("Main_setupLaunchInfo", "from");
    }

    public final boolean z() {
        return false;
    }

    public AuthModelServiceNoop() {
        this.a = new MutableLiveData(new a(null, 0, null));
        this.b = new MutableLiveData(null);
        this.c = new MutableLiveData(new e0(null, 0, null, null));
        LaunchBiz r11 = LaunchBiz.CORE;
        this.d = new MutableLiveData(new c1(r11, 0, "", null, false, 56));
        LaunchBiz r16 = LaunchBiz.BASIC;
        this.e = new MutableLiveData(new c1(r16, 0, "", null, false, 56));
        LaunchBiz r17 = LaunchBiz.IM;
        this.f = new MutableLiveData(new c1(r17, 0, "", null, false, 56));
        LaunchBiz r18 = LaunchBiz.AUDIO;
        this.g = new MutableLiveData(new c1(r18, 0, "", null, false, 56));
        this.h = new MutableLiveData(new c1(r11, 0, "", null, false, 56));
        this.i = new MutableLiveData(new c1(r16, 0, "", null, false, 56));
        this.j = new MutableLiveData(new c1(r17, 0, "", null, false, 56));
        this.k = new MutableLiveData(new c1(r18, 0, "", null, false, 56));
        this.l = new MutableLiveData(null);
        this.m = new MutableLiveData(null);
        this.n = new MutableLiveData(null);
    }

    public final LiveData<a> A() {
        return this.l;
    }

    public final LiveData<c1<com.larus.bmhome.auth.j0>> B() {
        return this.j;
    }

    public final LiveData<c1<com.larus.bmhome.auth.b>> E() {
        return this.g;
    }

    public final LiveData<c1<com.larus.bmhome.auth.h0>> H() {
        return this.d;
    }

    public final LiveData<c1<com.larus.bmhome.auth.h0>> a() {
        return this.h;
    }

    public final LiveData<c1<e0>> c() {
        return this.i;
    }

    public final LiveData<e0> e() {
        return this.c;
    }

    public final LiveData<c1<com.larus.bmhome.auth.j0>> i() {
        return this.f;
    }

    public final LiveData<c1<com.larus.bmhome.auth.b>> j() {
        return this.k;
    }

    public final LiveData<c1<e0>> l() {
        return this.e;
    }

    public final LiveData<a> m() {
        return this.a;
    }

    public final LiveData<wc9.e> u() {
        return this.n;
    }

    public final LiveData<LaunchInfo> x() {
        return this.m;
    }

    public final LiveData<wc9.e> y() {
        return this.b;
    }

    public final Object G(LaunchInfo r1, Continuation r2) {
        return Unit.INSTANCE;
    }
}
