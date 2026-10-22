package com.bytedance.android.livesdk.followtool;

import am2.x;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.HostInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.customize.IInternalFollowTool;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.p8;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.m;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lm3.c;
import lm3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J8\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0013H\u0016J \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u001c\u0010\u001d\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0016J*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010\u001f\u001a\u00020\bH\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/InternalFollowTool;", "Lcom/bytedance/android/live/customize/IInternalFollowTool;", "Landroid/content/Context;", "context", "Lio/reactivex/subjects/PublishSubject;", "", "ob", "", "", "logExtra", "", "Llm3/c;", "getActionList", "key", "params", "", "sendLog", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/user/b;", "paramBuilder", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/depend/model/follow/FollowPair;", "makeFollowByRoom", "Lcom/bytedance/android/livesdk/user/m;", "makeUnFollowByRoom", "followPair", "showToastWithFollowStateSyncCheck", "shouldTreatAsFollowed", "showFollowSyncDialog", "openUserId", "getUnFollowDialogText", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class InternalFollowTool implements IInternalFollowTool {

    public static final class a implements c.a {
        public final /* synthetic */ InternalFollowTool b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ PublishSubject d;

        public final void onAction(d r4) {
            Intrinsics.checkNotNullParameter(r4, "dialog");
            Handler r0 = DialogLancet.resolveDialogHandler(r4);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r4);
            r4.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r4);
        L17:
            HashMap r5 = new HashMap(this.c);
            r5.put("click_button", "cancel");
            InternalFollowTool.access$sendLog(this.b, "livesdk_relationships_authorization_popup_click", r5);
            this.d.onNext(Boolean.FALSE);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r4);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r4));
            goto L17
        }

        public a(InternalFollowTool r1, Map r2, PublishSubject r3) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class b implements c.a {
        public final /* synthetic */ InternalFollowTool b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ PublishSubject d;

        public final void onAction(d r4) {
            Intrinsics.checkNotNullParameter(r4, "dialog");
            Handler r0 = DialogLancet.resolveDialogHandler(r4);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r4);
            r4.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r4);
        L17:
            HashMap r5 = new HashMap(this.c);
            r5.put("click_button", "confirm");
            InternalFollowTool.access$sendLog(this.b, "livesdk_relationships_authorization_popup_click", r5);
            this.d.onNext(Boolean.TRUE);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r4);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r4));
            goto L17
        }

        public b(InternalFollowTool r1, Map r2, PublishSubject r3) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public InternalFollowTool() {
        k.l(IInternalFollowTool.class, this);
    }

    public Observable<String> getUnFollowDialogText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "openUserId");
        return Observable.just(LiveResUtil.getString(2131919781));
    }

    private final void sendLog(String r5, Map<String, String> r6) {
        u.l().sendLog(r5, r6, new Object[]{Room.class, x.class, com.bytedance.android.livesdk.user.k.class});
    }

    public boolean shouldTreatAsFollowed(Room r8, FollowPair r9) {
        int r0 = com.bytedance.android.livesdk.followtool.utils.a.a;
        if (r8 == null) goto L26;
        RoomAuthStatus r2 = r8.getRoomAuthStatus();
        if (r2 == null) goto L26;
        if (r2.useHostInfo != 1) goto L26;
        if (r9 == null) goto L26;
        if (r9.isSyncFollow() == true) goto L26;
        User r10 = r8.getOwner();
        if (r10 == null) goto L18;
        HostInfo r11 = r10.getHostInfo();
        if (r11 == null) goto L18;
        if (r11.isFollowing() != true) goto L18;
        boolean r12 = true;
    L20:
        if (r9.followStatus == 0) goto L22;
        boolean r13 = true;
    L23:
        if (r12 == false) goto L31;
        if (r13 == false) goto L32;
    L29:
        return true;
    L32:
        return false;
    L31:
        return false;
    L22:
        r13 = false;
    L18:
        r12 = false;
    L26:
        if (r9 == null) goto L29;
        if (r9.followStatus != 0) goto L29;
        return false;
    }

    public Observable<Boolean> showFollowSyncDialog(Context r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "logExtra");
        View r0 = LayoutInflater.from(r12).inflate(2131566169, null, false);
        TextView r1 = (TextView) r0.findViewById(2131367794);
        p8 r2 = (p8) LiveConfigSettingKeys.INTERNAL_FOLLOW_SYNC_CONTENT_CONFIG_SETTING_KEY.getValue();
        IHostContext r4 = k.f(IHostContext.class);
        if (r4 == null) goto L6;
        String r5 = r4.appName();
        if (r5 == null) goto L6;
    L7:
        String r6 = r2.a();
        r1.setText(StringsKt.replace$default(r6, "{host}", r5, false, 4, null));
        PublishSubject<Boolean> r3 = PublishSubject.create();
        d.a r7 = new d.a(r12);
        r7.d = r0;
        r7.e = getActionList(r12, r3, r13);
        r7.j = false;
        r7.l = false;
        r7.a();
        sendLog("livesdk_relationships_authorization_popup_show", r13);
        return r3;
    L6:
        r5 = "";
        goto L7
    }

    public static final /* synthetic */ void access$sendLog(InternalFollowTool r0, String r1, Map r2) {
        r0.sendLog(r1, r2);
    }

    private final List<c> getActionList(Context r4, PublishSubject<Boolean> r5, Map<String, String> r6) {
        c r0 = new c();
        r0.b = r4.getString(2131915919);
        r0.c = new a(this, r6, r5);
        c r1 = new c();
        r1.b = r4.getString(2131915915);
        r1.c = new b(this, r6, r5);
        ArrayList r7 = new ArrayList(2);
        r7.add(r0);
        r7.add(r1);
        return r7;
    }

    public Observable<FollowPair> makeFollowByRoom(Context r7, Room r8, Function1<? super Boolean, ? extends com.bytedance.android.livesdk.user.b> r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "paramBuilder");
        int r2 = com.bytedance.android.livesdk.followtool.utils.a.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "paramBuilder");
        com.bytedance.android.livesdk.user.b r0 = (com.bytedance.android.livesdk.user.b) r9.invoke(Boolean.FALSE);
        if (r8 == null) goto L7;
        User r1 = r8.getOwner();
        if (r1 == null) goto L7;
        String r3 = r1.getUserId();
    L9:
        if (mz.c.a(r3, ((com.bytedance.android.livesdk.user.a) r0).a) == false) goto L19;
        if (r8 == null) goto L18;
        RoomAuthStatus r4 = r8.getRoomAuthStatus();
        if (r4 == null) goto L18;
        if (r4.useHostInfo != 1) goto L18;
        return com.bytedance.android.livesdk.followtool.utils.a.a(r7, MapsKt.mapOf(TuplesKt.to("relationships_authorization_type", com.bytedance.android.livesdk.followtool.utils.a.b(r8)))).observeOn(AndroidSchedulers.mainThread()).flatMap(new com.bytedance.android.livesdk.followtool.utils.b(r9));
    L18:
        return com.bytedance.android.livesdk.followtool.utils.a.d().h(r0);
    L19:
        return com.bytedance.android.livesdk.followtool.utils.a.d().h(r0);
    L7:
        r3 = null;
        goto L9
    }

    public Observable<FollowPair> makeUnFollowByRoom(Context r7, Room r8, Function1<? super Boolean, ? extends m> r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "paramBuilder");
        int r2 = com.bytedance.android.livesdk.followtool.utils.a.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "paramBuilder");
        m r0 = (m) r9.invoke(Boolean.FALSE);
        if (r8 == null) goto L7;
        User r1 = r8.getOwner();
        if (r1 == null) goto L7;
        String r3 = r1.getUserId();
    L9:
        if (mz.c.a(r3, ((com.bytedance.android.livesdk.user.a) r0).a) == false) goto L19;
        if (r8 == null) goto L18;
        RoomAuthStatus r4 = r8.getRoomAuthStatus();
        if (r4 == null) goto L18;
        if (r4.useHostInfo != 1) goto L18;
        return com.bytedance.android.livesdk.followtool.utils.a.a(r7, MapsKt.mapOf(TuplesKt.to("relationships_authorization_type", com.bytedance.android.livesdk.followtool.utils.a.b(r8)))).observeOn(AndroidSchedulers.mainThread()).flatMap(new com.bytedance.android.livesdk.followtool.utils.c(r9));
    L18:
        return com.bytedance.android.livesdk.followtool.utils.a.d().i(r0);
    L19:
        return com.bytedance.android.livesdk.followtool.utils.a.d().i(r0);
    L7:
        r3 = null;
        goto L9
    }

    public void showToastWithFollowStateSyncCheck(Context r7, Room r8, FollowPair r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "room");
        Intrinsics.checkNotNullParameter(r9, "followPair");
        int r3 = com.bytedance.android.livesdk.followtool.utils.a.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "room");
        Intrinsics.checkNotNullParameter(r9, "followPair");
        User r10 = r8.getOwner();
        if (r10 == null) goto L5;
        String r11 = r10.getUserId();
    L7:
        if ((!Intrinsics.areEqual(r11, r9.getUserIdString())) == true) goto L42;
        RoomAuthStatus r12 = r8.getRoomAuthStatus();
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.useHostInfo == 1) goto L14;
        return;
    L14:
        if (r9.followStatus == 0) goto L37;
        User r13 = r8.getOwner();
        if (r13 == null) goto L38;
        FollowInfo r14 = r13.getFollowInfo();
        if (r14 != null) goto L21;
        return;
    L21:
        if (r9.isSyncFollow() == false) goto L26;
        if (r14.isFollowing() == true) goto L39;
        f2.c(StringsKt.replace$default(((p8) LiveConfigSettingKeys.INTERNAL_FOLLOW_SYNC_CONTENT_CONFIG_SETTING_KEY.getValue()).b(), "{userName}", com.bytedance.android.livesdk.followtool.utils.a.c(), false, 4, null), 0);
        return;
    L39:
        return;
    L26:
        if (r14.isFollowing() == true) goto L28;
        f2.c(StringsKt.replace$default(((p8) LiveConfigSettingKeys.INTERNAL_FOLLOW_SYNC_CONTENT_CONFIG_SETTING_KEY.getValue()).b(), "{userName}", com.bytedance.android.livesdk.followtool.utils.a.c(), false, 4, null), 0);
        return;
    L28:
        String r0 = ((p8) LiveConfigSettingKeys.INTERNAL_FOLLOW_SYNC_CONTENT_CONFIG_SETTING_KEY.getValue()).c();
        IHostContext r15 = k.f(IHostContext.class);
        if (r15 == null) goto L32;
        String r16 = r15.appName();
        if (r16 == null) goto L32;
    L33:
        f2.c(StringsKt.replace$default(r0, "{host}", r16, false, 4, null), 0);
        return;
    L32:
        r16 = "";
        goto L33
    L38:
        return;
    L37:
        return;
    L42:
        return;
    L5:
        r11 = null;
        goto L7
    }
}
