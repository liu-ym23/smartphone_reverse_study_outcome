package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 V2\u00020\u0001:\u0001WB\u0007¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR!\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010*R!\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010/R!\u00104\u001a\b\u0012\u0004\u0012\u0002010+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010/R!\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001b\u001a\u0004\b6\u0010\u001dR!\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010\u001dR!\u0010>\u001a\b\u0012\u0004\u0012\u00020;0+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010/R!\u0010B\u001a\b\u0012\u0004\u0012\u00020?0+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u001b\u001a\u0004\bA\u0010/R!\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bD\u0010\u001dR!\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u001b\u001a\u0004\bF\u0010\u001dR\"\u0010G\u001a\u00020\u000e8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006X"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/kmp/live/livelink/api/model/VideoShowMode;", "currentVideoShowMode", "", "setCurrentVideoShowMode", "saveDigitAvatar", "readDigitAvatar", "checkEnsureSingMode", "checkEnsureVideoShowMode", "showMode", "Lcom/bytedance/android/live/liveinteract/digitavatar/videoavatar/b;", "callBack", "setVideoShowMode", "", "isLoading", "setIsDigitAvatarLoading", "getIsDigitAvatarLoading", "lastShowMode", "setLastVideoShowMode", "getIsDigitAvatarLoaded", "isLoaded", "setIsDigitAvatarLoaded", "getLastVideoShowMode", "getCurrentVideoShowMode", "Lcom/bytedance/live/datacontext/m;", "restoreDigitAvatar$delegate", "Lcom/bytedance/live/datacontext/p;", "getRestoreDigitAvatar", "()Lcom/bytedance/live/datacontext/m;", "restoreDigitAvatar", "isDigitAvatarLoading$delegate", "isDigitAvatarLoading", "isDigitAvatarLoaded$delegate", "isDigitAvatarLoaded", "lastViewShowMode$delegate", "getLastViewShowMode", "lastViewShowMode", "Lcom/bytedance/android/live/liveinteract/digitavatar/n;", "digitAvatar$delegate", "getDigitAvatar", "digitAvatar", "Lcom/bytedance/kmp/live/livelink/api/model/VideoShowMode;", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/liveinteract/digitavatar/videoavatar/c;", "setVideoShowModeEvent$delegate", "getSetVideoShowModeEvent", "()Lcom/bytedance/live/datacontext/k;", "setVideoShowModeEvent", "Lcom/bytedance/android/live/liveinteract/digitavatar/videoavatar/d;", "setVideoShowModeResult$delegate", "getSetVideoShowModeResult", "setVideoShowModeResult", "usedAvatarThisLinkRound$delegate", "getUsedAvatarThisLinkRound", "usedAvatarThisLinkRound", "currentUsingDigitAvatarInVideoTalkRoom$delegate", "getCurrentUsingDigitAvatarInVideoTalkRoom", "currentUsingDigitAvatarInVideoTalkRoom", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/j;", "sendAvatarEmoji$delegate", "getSendAvatarEmoji", "sendAvatarEmoji", "Lcom/bytedance/android/live/liveinteract/digitavatar/h0;", "requestUpdateAvatar$delegate", "getRequestUpdateAvatar", "requestUpdateAvatar", "isPickImageWithGallery$delegate", "isPickImageWithGallery", "isPickImageWidthCamera$delegate", "isPickImageWidthCamera", "skipFrequencyCheck", "Z", "getSkipFrequencyCheck", "()Z", "setSkipFrequencyCheck", "(Z)V", "", "updateShowModeSource", "Ljava/lang/String;", "getUpdateShowModeSource", "()Ljava/lang/String;", "setUpdateShowModeSource", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DigitAvatarContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "DigitAvatarContext";
    private final com.bytedance.live.datacontext.p currentUsingDigitAvatarInVideoTalkRoom$delegate;
    private VideoShowMode currentVideoShowMode;
    private final com.bytedance.live.datacontext.p digitAvatar$delegate;
    private final com.bytedance.live.datacontext.p isDigitAvatarLoaded$delegate;
    private final com.bytedance.live.datacontext.p isDigitAvatarLoading$delegate;
    private final com.bytedance.live.datacontext.p isPickImageWidthCamera$delegate;
    private final com.bytedance.live.datacontext.p isPickImageWithGallery$delegate;
    private final com.bytedance.live.datacontext.p lastViewShowMode$delegate;
    private final com.bytedance.live.datacontext.p requestUpdateAvatar$delegate;
    private final com.bytedance.live.datacontext.p restoreDigitAvatar$delegate;
    private final com.bytedance.live.datacontext.p sendAvatarEmoji$delegate;
    private final com.bytedance.live.datacontext.p setVideoShowModeEvent$delegate;
    private final com.bytedance.live.datacontext.p setVideoShowModeResult$delegate;
    private boolean skipFrequencyCheck;
    private String updateShowModeSource;
    private final com.bytedance.live.datacontext.p usedAvatarThisLinkRound$delegate;

    public static final class a {
        public final DigitAvatarContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(DigitAvatarContext.class);
            if ((r0 instanceof DigitAvatarContext) == true) goto L6;
            r0 = null;
        L6:
            return (DigitAvatarContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "restoreDigitAvatar", "getRestoreDigitAvatar()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "isDigitAvatarLoading", "isDigitAvatarLoading()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "isDigitAvatarLoaded", "isDigitAvatarLoaded()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "lastViewShowMode", "getLastViewShowMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "digitAvatar", "getDigitAvatar()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "setVideoShowModeEvent", "getSetVideoShowModeEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "setVideoShowModeResult", "getSetVideoShowModeResult()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "usedAvatarThisLinkRound", "getUsedAvatarThisLinkRound()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "currentUsingDigitAvatarInVideoTalkRoom", "getCurrentUsingDigitAvatarInVideoTalkRoom()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "sendAvatarEmoji", "getSendAvatarEmoji()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "requestUpdateAvatar", "getRequestUpdateAvatar()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "isPickImageWithGallery", "isPickImageWithGallery()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DigitAvatarContext.class, "isPickImageWidthCamera", "isPickImageWidthCamera()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    private final com.bytedance.live.datacontext.m<VideoShowMode> getLastViewShowMode() {
        return (com.bytedance.live.datacontext.m) this.lastViewShowMode$delegate.a(this, $$delegatedProperties[3]);
    }

    private final com.bytedance.live.datacontext.m<Boolean> isDigitAvatarLoaded() {
        return (com.bytedance.live.datacontext.m) this.isDigitAvatarLoaded$delegate.a(this, $$delegatedProperties[2]);
    }

    private final com.bytedance.live.datacontext.m<Boolean> isDigitAvatarLoading() {
        return (com.bytedance.live.datacontext.m) this.isDigitAvatarLoading$delegate.a(this, $$delegatedProperties[1]);
    }

    public final void checkEnsureSingMode() {
    }

    public final com.bytedance.live.datacontext.m<Boolean> getCurrentUsingDigitAvatarInVideoTalkRoom() {
        return (com.bytedance.live.datacontext.m) this.currentUsingDigitAvatarInVideoTalkRoom$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.m<n> getDigitAvatar() {
        return (com.bytedance.live.datacontext.m) this.digitAvatar$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.k<h0> getRequestUpdateAvatar() {
        return (com.bytedance.live.datacontext.k) this.requestUpdateAvatar$delegate.a(this, $$delegatedProperties[10]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getRestoreDigitAvatar() {
        return (com.bytedance.live.datacontext.m) this.restoreDigitAvatar$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> getSendAvatarEmoji() {
        return (com.bytedance.live.datacontext.k) this.sendAvatarEmoji$delegate.a(this, $$delegatedProperties[9]);
    }

    public final com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.digitavatar.videoavatar.c> getSetVideoShowModeEvent() {
        return (com.bytedance.live.datacontext.k) this.setVideoShowModeEvent$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.digitavatar.videoavatar.d> getSetVideoShowModeResult() {
        return (com.bytedance.live.datacontext.k) this.setVideoShowModeResult$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getUsedAvatarThisLinkRound() {
        return (com.bytedance.live.datacontext.m) this.usedAvatarThisLinkRound$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isPickImageWidthCamera() {
        return (com.bytedance.live.datacontext.m) this.isPickImageWidthCamera$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isPickImageWithGallery() {
        return (com.bytedance.live.datacontext.m) this.isPickImageWithGallery$delegate.a(this, $$delegatedProperties[11]);
    }

    public final boolean getSkipFrequencyCheck() {
        boolean r0 = this.skipFrequencyCheck;
        this.skipFrequencyCheck = false;
        return r0;
    }

    public final String getUpdateShowModeSource() {
        String r0 = this.updateShowModeSource;
        this.updateShowModeSource = null;
        return r0;
    }

    public final void readDigitAvatar() {
        n r2 = (n) getDigitAvatar().getValue();
        String r3 = "";
        String r0 = (String) ((Map) b6.v.getValue()).get(je0.d.b0().toString());     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = "{}";
    L6:
        r3 = r0;
        n r1 = (n) GsonHelper.get().fromJson(r3, n.class);     // Catch: Throwable -> L10
        if (r1 == null) goto L13;
        r2.a(r1);     // Catch: Throwable -> L10
    L13:
        if (r2.a == false) goto L26;
        String r4 = r2.d;
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L27;
        ALogger.i("KtvDigitAvatar", "初始化avatar性别为用户性别：gender=" + c0.b());
        AvatarGender r6 = c0.b();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.b = r6;
        return;
    L27:
        return;
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
        goto L21
    L26:
        return;
    L10:
        th = move-exception;
        ALogger.e("KtvDigitAvatar", "从sp中读取avatar数据出错. avatarData=".concat(r3), th);
        int r7 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(th, "e");
        Intrinsics.checkNotNullParameter(r3, "avatarInfo");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("exception", th.toString());
        r8.put("avatar_data", r3);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("avatar_deserialize_from_sp_exception", r8);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(th, "e");
        Intrinsics.checkNotNullParameter(r3, "avatarInfo");
        JSONObject r11 = new JSONObject();
        r11.put("exception", th.toString());
        r11.put("avatar_data", r3);
        nd0.c.o(nd0.c.a, LinkMonitorData.AvatarDeserializeFromSpExceptionMonitorData, r11, 0, null, false, 28);
        goto L13
    }

    public DigitAvatarContext() {
        Boolean r0 = Boolean.FALSE;
        this.restoreDigitAvatar$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isDigitAvatarLoading$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isDigitAvatarLoaded$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        VideoShowMode r1 = VideoShowMode.AUDIO;
        this.lastViewShowMode$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.digitAvatar$delegate = com.bytedance.live.datacontext.q.d(this, new n(false, null, null, 63));
        this.currentVideoShowMode = r1;
        this.setVideoShowModeEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.setVideoShowModeResult$delegate = com.bytedance.live.datacontext.e.b(this);
        this.usedAvatarThisLinkRound$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.currentUsingDigitAvatarInVideoTalkRoom$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.sendAvatarEmoji$delegate = com.bytedance.live.datacontext.e.b(this);
        this.requestUpdateAvatar$delegate = com.bytedance.live.datacontext.e.b(this);
        this.isPickImageWithGallery$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isPickImageWidthCamera$delegate = com.bytedance.live.datacontext.q.d(this, r0);
    }

    public final void checkEnsureVideoShowMode() {
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
    L11:
        if (((ArrayList) c0.a(r1, r3, false)).contains(getCurrentVideoShowMode()) == true) goto L14;
        ALogger.i("KtvDigitAvatar", "checkEnsureVideoShowMode: 当前showMode为" + getCurrentVideoShowMode() + "，但是房间/用户不支持该showMode，so校正为AUDIO");
        setVideoShowMode$default(this, VideoShowMode.AUDIO, null, 2, null);
        return;
    L14:
        return;
    L9:
        r3 = null;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public final boolean getIsDigitAvatarLoaded() {
        return ((Boolean) isDigitAvatarLoaded().getValue()).booleanValue();
    }

    public final boolean getIsDigitAvatarLoading() {
        return ((Boolean) isDigitAvatarLoading().getValue()).booleanValue();
    }

    public final VideoShowMode getLastVideoShowMode() {
        return (VideoShowMode) getLastViewShowMode().getValue();
    }

    public final void saveDigitAvatar() {
        String r0 = GsonProtectorUtils.toJson(GsonHelper.get(), getDigitAvatar().getValue());
        com.bytedance.android.livesdk.sharedpref.e r1 = b6.v;
        Map r2 = (Map) r1.getValue();
        r2.put(je0.d.b0().toString(), r0);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
    }

    public final VideoShowMode getCurrentVideoShowMode() {
        return this.currentVideoShowMode;
    }

    private final void setCurrentVideoShowMode(VideoShowMode r4) {
        ALogger.w(TAG, "setCurrentVideoShowMode ;; newVideoShowMode == " + r4 + " ;; oldVideoShowMode == " + getCurrentVideoShowMode());
        LocalTestManager.a(new Class[]{wy.a.class});
        this.currentVideoShowMode = r4;
    }

    public final void setIsDigitAvatarLoaded(boolean r2) {
        isDigitAvatarLoaded().setValue(Boolean.valueOf(r2));
    }

    public final void setIsDigitAvatarLoading(boolean r2) {
        isDigitAvatarLoading().setValue(Boolean.valueOf(r2));
    }

    public final void setLastVideoShowMode(VideoShowMode r2) {
        Intrinsics.checkNotNullParameter(r2, "lastShowMode");
        getLastViewShowMode().setValue(r2);
    }

    public final void setSkipFrequencyCheck(boolean r1) {
        this.skipFrequencyCheck = r1;
    }

    public final void setUpdateShowModeSource(String r1) {
        this.updateShowModeSource = r1;
    }

    public final void setVideoShowMode(VideoShowMode r4, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r5) {
        Intrinsics.checkNotNullParameter(r4, "showMode");
        ALogger.w(TAG, "setVideoShowMode ;; newVideoShowMode == " + r4 + " ;; oldVideoShowMode == " + getCurrentVideoShowMode());
        LocalTestManager.a(new Class[]{wy.a.class});
        setCurrentVideoShowMode(r4);
        getSetVideoShowModeEvent().post(new com.bytedance.android.live.liveinteract.digitavatar.videoavatar.c(r4, r5));
    }

    public static /* synthetic */ void setVideoShowMode$default(DigitAvatarContext r0, VideoShowMode r1, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setVideoShowMode(r1, r2);
    }
}
