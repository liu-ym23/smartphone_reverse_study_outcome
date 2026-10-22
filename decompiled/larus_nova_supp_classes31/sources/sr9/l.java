package sr9;

import android.content.Context;
import android.view.View;
import com.larus.platform.api.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l implements g0 {
    public final View a;
    public boolean b;
    public boolean c;
    public lq9.q d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    public final void E6() {
    }

    public final boolean Ea() {
        return false;
    }

    public final void Fa(String r1, boolean r2, int r3, View.OnClickListener r4) {
    }

    public final void Ia(String r1, com.larus.platform.api.j r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "title");
    }

    public final void Na(Integer r1, CharSequence r2) {
    }

    public final void Qa() {
    }

    public final void Sa(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "iconUri");
        Intrinsics.checkNotNullParameter(r2, "iconUrl");
    }

    public final void Ua() {
    }

    public final void Wa() {
    }

    public final View getBackIcon() {
        return null;
    }

    public final View getMoreView() {
        return null;
    }

    public final View getMultitaskManagementIcon() {
        return null;
    }

    public final View getRedDot() {
        return null;
    }

    public final View getTitleText() {
        return null;
    }

    public final View getTtsView() {
        return null;
    }

    public final void refresh() {
    }

    public final void setBackBtnEnabled(boolean r1) {
    }

    public final void setBackIconRes(int r1) {
    }

    public final void setBackIconVisible(boolean r1) {
    }

    public final void setHasMore(boolean r1) {
    }

    public final void setImmerse(boolean r1) {
    }

    public final void setIsLocalSubConvChange(boolean r1) {
    }

    public final void setMoreBtnEnabled(boolean r1) {
    }

    public final void setOnAddBotClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnBackClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnMainClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnMoreClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnTtsCheckedListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnTtsContinuousTalkCheckedListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnTtsContinuousTalkLongClickListener(Function1<? super View, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "longClickAction");
    }

    public final void setRealTimeCallVisible(boolean r1) {
    }

    public final void setRealtimeCallVisibleHookShow(boolean r1) {
    }

    public final void setRedDotBGType(int r1) {
    }

    public final void setRedDotUnreadCount(int r1) {
    }

    public final void setRedDotViewClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setRedDotViewVisible(boolean r1) {
    }

    public final void setStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
    }

    public final void setTitleIcon(boolean r1) {
    }

    public final void setTtsContinuousTalkVisible(boolean r1) {
    }

    public final void setTtsGrey(boolean r1) {
    }

    public final void setTtsVisible(boolean r1) {
    }

    public final void va() {
    }

    public final boolean Da() {
        return this.g;
    }

    public final boolean Ja() {
        return this.h;
    }

    public final boolean getAudioBtnEnabled() {
        return this.f;
    }

    public final lq9.q getEarphoneState() {
        return this.d;
    }

    public final boolean getHasAddBot() {
        return this.b;
    }

    public final View getTitle() {
        return this.a;
    }

    public final View getTitleView() {
        return this.a;
    }

    public final boolean getTtsBanned() {
        return this.e;
    }

    public final boolean getTtsChecked() {
        return this.c;
    }

    public final boolean getTtsContinuousTalkChecked() {
        return this.k;
    }

    public final boolean getTtsContinuousTalkEnabled() {
        return this.j;
    }

    public final boolean i() {
        return this.i;
    }

    public l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new View(r2);
        this.d = new lq9.q(false, false);
        this.e = true;
    }

    public final void setAudioBtnEnabled(boolean r1) {
        this.f = r1;
    }

    public final void setCreateNewCvsClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setDotEnable(boolean r1) {
        this.h = r1;
    }

    public final void setEarphoneState(lq9.q r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setHasAddBot(boolean r1) {
        this.b = r1;
    }

    public final void setMainBot(boolean r1) {
        this.g = r1;
    }

    public final void setOnChatHistoryCheckedListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnMultitaskClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnSearchClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnSideNavClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnTtsLongPressAction(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "longClickAction");
    }

    public final void setRealtimeCallBtnClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setRedDotVisible(boolean r1) {
        this.i = r1;
    }

    public final void setTtsBanned(boolean r1) {
        this.e = r1;
    }

    public final void setTtsChecked(boolean r1) {
        this.c = r1;
    }

    public final void setTtsContinuousTalkChecked(boolean r1) {
        this.k = r1;
    }

    public final void setTtsContinuousTalkEnabled(boolean r1) {
        this.j = r1;
    }
}
